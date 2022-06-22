package com.RCC.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter {

	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark;
	public ExtentTest test;

	public void onStart(ITestContext tr) {

		Date date = new Date();
		String strDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		String reportName = "Test-Report-" + strDate + ".html";
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);

		try {
			spark.loadXMLConfig(System.getProperty("user.dir") + "/Extent-confg.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "padma");

		spark.config().setDocumentTitle("RCC Test Report"); // Tile of report
		spark.config().setReportName("Automation Testing"); // Name of the report
		spark.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {

		test = extent.createTest(tr.getName()); // create new entry in the report
		// passed inf highlighted green
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {

		test = extent.createTest(tr.getName()); // create new entry in the report
		// passed inf highlighted green
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + tr.getName() + ".png";

		File file = new File(screenShotPath);
		if (file.exists()) {
			try {
				test.fail("ScreenShot is Below: " + test.addScreenCaptureFromPath(screenShotPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult tr) {

		test = extent.createTest(tr.getName()); // create new entry in the report
		// passed inf highlighted green
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext tr) {
		extent.flush();
	}

}
