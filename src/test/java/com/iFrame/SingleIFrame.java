package com.iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;

public class SingleIFrame extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		launchChrome();
		openIframeTestURL();
		testIFrame();
		tearDownChrome();
	}
	
	public static void openIframeTestURL()
	{
		driver.get("https://the-internet.herokuapp.com/iframe");
	}
	
	public static void testIFrame() throws InterruptedException
	{
		driver.switchTo().frame("mce_0_ifr");		
		WebElement iFrame=driver.findElement(By.id("tinymce"));
		iFrame.clear();
		iFrame.sendKeys("Test Automation.");
		Thread.sleep(4000);
	}

}
