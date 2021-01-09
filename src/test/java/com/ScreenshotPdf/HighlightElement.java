package com.ScreenshotPdf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;
import com.Demo.HomePage;

public class HighlightElement extends BaseClass{

	public static void main(String[] args) throws InterruptedException, IOException {
		launchChrome();
		HomePage.openHomepage();

		//Search Box 
		WebElement searchbox=driver.findElement(By.name("search"));
		
		//Highlight Element with red border 3px width
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'",searchbox);
		
		
		Thread.sleep(4000);
		
		//Take screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Save final image
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\HighlightScreenshot.png"),true);	

		tearDownChrome();
	}

}
