package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;
	
	
	public static void launchFirefox()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();  // WebDriver changed to driver 
	}

	@BeforeTest
	public static void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void tearDownFirefox()
	{
		if(driver!=null)
		{
			driver.close();
		}
		else {
			System.out.println("No driver found.");
		}
	}
	
	@AfterTest
	public static void tearDownChrome()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
		else {
			System.out.println("No driver found.");
		}
	}
}
