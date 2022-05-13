package com.banking.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.banking.config.gblConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public ExtentReports report;
	public static ExtentTest test;
	
	@BeforeMethod
	@Parameters(value={"Browser"})
	public void invokingApplication(String  Browser,Method method) {
		
		test = report.startTest(method.getName());
		
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		report.endTest(test);
	}
	
	public void launchApplication(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(gblConstants.implicit_wait_time, TimeUnit.SECONDS);
	}
	
	@BeforeSuite
	public void initializeReport() {
		report = new ExtentReports("ExtentReports.html");
	}
	
	@AfterSuite
	public void closeReport() {
		report.flush();
	}
	
	public String screenCapture(String methodName) throws IOException {
		
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		

			String fileName = System.getProperty("user.dir")+ "/Screenshots/"+methodName+dateName+".png";
			FileUtils.copyFile(srcFile, new File(fileName));
		return fileName;
		
	}
}
