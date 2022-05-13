package com.banking.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.banking.common.Base;
import com.banking.pages.HomePage;
import com.banking.pages.LoginPage;
import com.banking.util.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends Base {
	
	@Test
	public void loginTestCase() throws IOException {
		
		//Load URL
		String URL = Utilities.readProperty("AdminURL"); 
		launchApplication(URL);
		
		//Enter UN
		LoginPage lp = new LoginPage(driver);
		lp.enterUN(Utilities.readProperty("UserName") );
		lp.enterPwd(Utilities.readProperty("Password"));
		lp.clickLoginBtn();
		
		
		//Enter Password
		//Click on login button
		HomePage hp = new HomePage(driver);
		hp.verifyHomePage();
		test.log(LogStatus.PASS, "User is logged in successfully");
	}

}
