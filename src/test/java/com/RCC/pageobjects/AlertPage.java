package com.RCC.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AlertPage {
	
	WebDriver driver;
	
	//  driver.findElement(By.id("newsletters")).sendKeys("xyz");

	public AlertPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="newsletters")
	WebElement txtEmail;

	@FindBy(xpath="//button[@class='form-control rcc-btn']")
	WebElement clickSubmit;

    
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void countMeIn() {
		txtEmail.click();
	}
	
	
}
