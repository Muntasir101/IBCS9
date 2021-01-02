package com.ExtentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Basic.BaseClass;
import com.Demo.HomePage;
import com.Demo.LoginTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginTestNormalExtentReport extends BaseClass {

	// Extent report
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest logger;
	
	WebDriver driver;
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\LoginTestReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		logger=report.createTest("Login Test");
		
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");
		
		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");
		
		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");
		
		LoginTest.emailPassInValid();
		logger.log(Status.PASS, "Login by invalid Email and Pasword Test done.");
		
		LoginTest.emailValidPassInValid();		
		logger.log(Status.PASS, "Login by Email valid and Pasword invalid Test done.");
		
		LoginTest.emailInValidPassValid();		
		logger.log(Status.PASS, "Login by Email invalid and Pasword valid Test done.");
		
		LoginTest.emailPassValid();		
		logger.log(Status.PASS, "Login by valid Email and Pasword Test done.");
		
		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");
		
		logger.log(Status.PASS, "Successfully Test case Executed.");
		
		report.flush();		
	}
	
	
}
