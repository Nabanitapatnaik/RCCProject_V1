package projectex;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class logintestcase1 extends baseclass {
	@Test(priority=1)
	public void myPortal() throws IOException, InterruptedException {
		logger.info("Checking credentials for Student Login");
		logger.info("URL entered");

		// creating object of my portal page
		logintestpageclass1 mpp = new logintestpageclass1(driver);

		// Fill user name
		mpp.getEmail(Email);
		logger.info("Email entered");

		// Fill password
		mpp.getpassword(pwd);
		logger.info("password entered");

		// Click Login button
		mpp.getLogin();
		logger.info("Click Login Button");

		// Get the title of Login Page
		logger.info("Checking the Title of the Page");

		if (driver.getTitle().equalsIgnoreCase("Ramana Coaching Center")) {
			Assert.assertTrue(true);
			logger.info("Test passed");
		} else {
			captureScreen(driver, "logintestcase1");
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}

		logger.info("Login Successfull!");

	}
   

}
