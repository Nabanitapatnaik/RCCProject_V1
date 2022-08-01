package projectex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class logintestpageclass1 {
	
	WebDriver driver;
	
	public logintestpageclass1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "j_username")
	WebElement userEmail; // Email id

	@FindBy(id = "j_password")
	WebElement userpwd; // password

	@FindBy(id = "loginbtn")
	WebElement login; // Log in
	
	public void getEmail(String email) {
		userEmail.sendKeys(email);
	}

	// Set password in password text box
	public void getpassword(String pwd) {
		userpwd.sendKeys(pwd);
	}

	// Click on login button
	public void getLogin() {
		login.click();
	}
	

}
