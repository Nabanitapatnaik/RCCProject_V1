package com.RCC.TestData;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RCC.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	
	//create object for readconfig class
	ReadConfig readconfig=new ReadConfig();
	public String BaseUrl=readconfig.getUrl();
	public String Emailid=readconfig.getemailid();
	
	
	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 logger=logger.getLogger("RCCProject_V1");
		 PropertyConfigurator.configure("log4j.properties");
	}


	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
