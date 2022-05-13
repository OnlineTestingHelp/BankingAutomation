package com.banking.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.config.gblConstants;

public class UserHomePage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//h1[@class='text-dark']")
	WebElement userLoginText;
	
	@FindBy(xpath = "//h3[contains(text(),'Account Number:')]")
	WebElement verifyAccountNo;
	
	@FindBy(xpath="//h3[contains(text(),'Current Balance:')]")
	WebElement verifyAccBalance;
	
	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(gblConstants.implicit_wait_time, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginText() {
		userLoginText.isDisplayed();
	}
	
	public void verifyAccountNo(String AccountNo) {
		String accNo = verifyAccountNo.getText();
		if(accNo.contains(AccountNo)) {
			System.out.println("Account No is displayed successfully");
		}
	}
	
	public void verifyBalance(String Balance) {
		String accNo = verifyAccBalance.getText();
		if(accNo.replace(",", "").contains(Balance)){
			System.out.println("Balance displayed successfully");
		}
	}

}
