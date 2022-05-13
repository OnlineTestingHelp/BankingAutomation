package com.banking.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.config.gblConstants;

public class UserLoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement userLoginUN;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement userLoginPwd;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement userLoginBtn;
	
	
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(gblConstants.implicit_wait_time, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String UserName,String Password) throws InterruptedException {
		userLoginUN.sendKeys(UserName);
		userLoginPwd.sendKeys(Password);
		Thread.sleep(1000);
		userLoginBtn.click();
	}
	
}
