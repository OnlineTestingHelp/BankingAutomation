package com.banking.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.config.gblConstants;

public class LoginPage {
	
	Logger log = LogManager.getLogger(this);
	WebDriver driver;
	
	//Locators
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginBtn;
	
	
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(gblConstants.implicit_wait_time, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	//Enter UserName
	public void enterUN(String UserName) {
		log.info("Entering the data in UserName");
		userName.sendKeys(UserName);
	}
	
	//Enter Password
	public void enterPwd(String Password) {
		password.sendKeys(Password);
	}
	
	//Click on Loginbtn
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
}
