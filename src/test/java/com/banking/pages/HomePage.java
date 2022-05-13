package com.banking.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.config.gblConstants;
import com.banking.util.Utilities;

public class HomePage {
	WebDriver driver;
	String text;
	String AccountNumber;
	
	@FindBy(xpath = "//h1[text()='Welcome to  Online Banking System']")
	WebElement HomePageText;
	
	@FindBy(xpath = "//p[contains(text(),'Account Management')]/..")
	WebElement AccountMgmt;
	
	@FindBy(xpath = "//p[contains(text(),'New Account')]/..")
	WebElement NewAccount;
	
	@FindBy(xpath = "//input[@name='account_number']")
	WebElement Account_Number;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@placeholder='(optional)']")
	WebElement MiddleName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='generated_password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@name='pin']")
	WebElement PIN;
	
	@FindBy(xpath = "//input[@name='balance']")
	WebElement balance;
	
	@FindBy(xpath = "//input[@name='account_number']")
	WebElement AccNo;
	
	@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
	WebElement Save;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath = "//table[@id='indi-list']/tbody/tr[1]/td[2]")
	WebElement tableAccNo;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(gblConstants.implicit_wait_time, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePage() {
		if(HomePageText.isDisplayed()) {
			System.out.println("Home page is displayed successfully");
		}else {
			System.out.println("Home page is not displayed");
		}
	}
	
	//Click on Account management
	public void clickOnAccMgmt() {
		AccountMgmt.click();
	}
	
	//Click on New Account
	public void clickOnNewAccount() {
		NewAccount.click();
	}
	
	
	
	
	
	//Create New Account
	public void createNewAccount(String AccNo1,String fName,String MidName,String LastNam, String emailVal,String pwd,String bal) {
		AccNo.sendKeys(AccNo1);
		FirstName.sendKeys(fName);
		MiddleName.sendKeys(MidName);
		LastName.sendKeys(LastNam);
		Email.sendKeys(emailVal);
		Password.sendKeys(pwd);
		PIN.sendKeys("1234");
		balance.sendKeys(bal);
		Save.click();
		
		search.sendKeys(AccNo1);
		search.sendKeys(Keys.ENTER);
		
		
	}
		
	//Verify User added
	public void verifyUserAdded(String AccountNumber) {
		String text = tableAccNo.getText();
		if(text.equalsIgnoreCase(AccountNumber)) {
			System.out.println("Account is added successfully");
		}
	}
	

}
