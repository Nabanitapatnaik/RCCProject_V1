package com.RCC.TestData;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RCC.pageobjects.AlertPage;

public class TC_AlertTest_100  extends BaseClass{
	@Test
	public void checkingAlert() {
		driver.get(BaseUrl);
		logger.info("Base URL is opened");
		
		//creating object for alertpage
		AlertPage ap=new AlertPage(driver);
		ap.setEmail(Emailid);
		logger.info("Username entered");
		ap.countMeIn();
		
		if(driver.getTitle().equalsIgnoreCase("Preparing Students for the Best Colleges - Ramana Coaching Center")) {
			Assert.assertTrue(true);
			logger.info("Test passed");
		}else {
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
	}
}
