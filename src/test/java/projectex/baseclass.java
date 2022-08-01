package projectex;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseclass {

	public static WebDriver driver;
	public static Logger logger;

	// Creating Object For ReadConfig1 Class
	readconfig1 readconfig1 = new readconfig1();

	public String BaseUrl = readconfig1.getBaseUrl();
	public String Email = readconfig1.getEmail();
	public String pwd = readconfig1.getPwd();

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(BaseUrl);

		// Log4j to get the Logs of Entire Project
		logger = logger.getLogger("RCCProject_V1");
		PropertyConfigurator.configure("log4j.properties");

	}
	
	
	// Screen shot Method - To CaptureSSreenShot in case of Failure
		public void captureScreen(WebDriver driver, String tname) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			String strDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
			File target = new File( "./ScreenShots/" + tname + strDate + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");

		}
		// Sleep Method
		public void getSleep() throws InterruptedException {
			Thread.sleep(3000);
		}

		// Close the Tabs
		@AfterClass
		public void tearDown() {

			driver.close();
		}
		
}
