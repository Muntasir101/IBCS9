package com.Basic;

import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



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
	
	public static void windowSizeScreenshot() throws IOException
	{
		//Take screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Save
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\WindowSizeScreenshot.png"),true);	
	}
	
	public static void fullPageScreenshot() throws IOException
	{
		//Take screenshot
		Screenshot Fullscreen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1200)).takeScreenshot(driver);
		ImageIO.write(Fullscreen.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\Screenshots\\FullPageScreenshot.png"));
	}
}
