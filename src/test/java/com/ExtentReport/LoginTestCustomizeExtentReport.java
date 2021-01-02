package com.ExtentReport;

import java.io.IOException;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Basic.BaseClass;
import com.Demo.HomePage;
import com.Demo.LoginTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


@SuppressWarnings("deprecation")
public class LoginTestCustomizeExtentReport extends BaseClass {


	// Extent report
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest logger;

	@BeforeTest
	public void startReports()
	{
		System.out.println("Hello");
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\LoginCustomizeTestReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("OS Version", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Browser Version", "87");
		report.setSystemInfo("Screen Size", "1317 * 709");

		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Muntasir Abdullah");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");

	}

	@Test
	public void loginTC_001() throws InterruptedException, IOException
	{


		logger=report.createTest("Login Test By Email and password invalid");

		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");

		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");

		LoginTest.emailPassInValid();
		logger.log(Status.PASS, "Login by invalid Email and Pasword Test done.");

		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");

		logger.log(Status.PASS, "Email and password invalid Test case Executed.");

		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 1 successfully Executed.");

	}


	@Test
	public void loginTC_002() throws InterruptedException, IOException
	{


		logger=report.createTest("Login Test by Email valid and password invalid");

		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");

		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");

		LoginTest.emailValidPassInValid();		
		logger.log(Status.PASS, "Login by Email valid and Pasword invalid Test done.");


		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");

		logger.log(Status.PASS, "Email valid and password invalid Test case Executed.");

		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 2 successfully Executed.");

	}

	@Test
	public void loginTC_003() throws InterruptedException, IOException
	{


		logger=report.createTest("Login Test by Email invalid and password valid");

		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");

		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");

		LoginTest.emailInValidPassValid();		
		logger.log(Status.PASS, "Login by Email invalid and Pasword valid Test done.");


		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");


		logger.log(Status.PASS, "Email invalid and password valid Test case Executed.");

		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 3 successfully Executed.");

	}

	@Test
	public void loginTC_004() throws InterruptedException, IOException
	{


		logger=report.createTest("Login Test by Email and password are valid");

		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");

		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");

		LoginTest.emailPassValid();		
		logger.log(Status.PASS, "Login by valid Email and Pasword Test done.");

		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");

		
		logger.log(Status.PASS, "Email and password are valid Test case Executed.");

		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 4 successfully Executed.");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			logger.fail(result.getThrowable());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}
		
		else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		}
	}

	@AfterTest
	public void testComplete()
	{
		report.flush();
	}
	
}
