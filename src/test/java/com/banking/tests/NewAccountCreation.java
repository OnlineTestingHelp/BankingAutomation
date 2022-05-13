package com.banking.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.common.Base;
import com.banking.pages.HomePage;
import com.banking.pages.LoginPage;
import com.banking.pages.UserHomePage;
import com.banking.pages.UserLoginPage;
import com.banking.util.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class NewAccountCreation extends Base {
	
	Logger log = (Logger) LogManager.getLogger(this);
	
	String FName = "Venkat";
	String MiddleName = "Venkata";
	String LName = "Krishna";
	String email_Pwd = "Venkat@123";
	String balance = "100000";
	String accNo = Utilities.AccountNumber();
	String email = "onlinetestinghelp" + accNo + "@gmail.com";
	
	@Test(priority = 0)
	public void verify_User_Addition() throws IOException {
		try {
		//Load URL
		String URL = Utilities.readProperty("AdminURL"); 
		launchApplication(URL);
		test.log(LogStatus.PASS, "Application is launched successfully");
		
		//Enter UN
		LoginPage lp = new LoginPage(driver);
		lp.enterUN(Utilities.readProperty("UserName") );
		lp.enterPwd(Utilities.readProperty("Password"));
		lp.clickLoginBtn();
		test.log(LogStatus.PASS, "Login button is clicked successfully");
		
		//Enter Password
		//Click on login button
		HomePage hp = new HomePage(driver);
		hp.verifyHomePage();
		hp.clickOnAccMgmt();
		hp.clickOnNewAccount();

		hp.createNewAccount(accNo, FName,MiddleName,LName,email,email_Pwd,balance);
		hp.verifyUserAdded(accNo);
		log.info("New User is created successfully");
		test.log(LogStatus.PASS, "New User is created successfully");
		}catch(Exception e) {
			e.printStackTrace();
			log.info("User is not created");
			test.log(LogStatus.FAIL, "New User is NOT created");
		}

	}
	
	@Test(priority = 1)
	public void verifyCreateUserLogin() throws IOException, InterruptedException {
		try {
		//Load URL
		String URL = Utilities.readProperty("UserLoginURL"); 
		launchApplication(URL);
		
		UserLoginPage ULP = new UserLoginPage(driver);
		ULP.userLogin(email, email_Pwd);
		
		UserHomePage UHP = new UserHomePage(driver);
		UHP.verifyAccountNo(accNo);
		UHP.verifyBalance(balance);
		log.info("Verify AccountNo and Balance are done");
		test.log(LogStatus.FAIL, "Verify AccountNo and Balance are done");
		Assert.assertFalse(true);
		}catch(Exception e) {
			e.printStackTrace();
			log.info("Verify AccountNo and Balance are not matched");
			test.log(LogStatus.FAIL, "Verify AccountNo and Balance are not matched");
		}

	}

}
