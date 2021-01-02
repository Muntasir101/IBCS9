package com.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;


public class AllAboutAlert extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		launchFirefox();
		openAlertTestURL();
		promptAlertTest();
		tearDownFirefox();
	}

	public static void openAlertTestURL()
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	
	public static void normalAlertTest() throws InterruptedException
	{
		WebElement JSAlert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
		JSAlert.click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept(); // Click on ok 
		Thread.sleep(3000);  //Explicit Wait
	}

	public static void confirmAlertTest() throws InterruptedException
	{
		WebElement JSConfirm=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		JSConfirm.click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept(); // Click on ok 
		driver.switchTo().alert().dismiss(); //Click on cancel 
		Thread.sleep(3000);  //Explicit Wait
	}
	
	public static void promptAlertTest() throws InterruptedException
	{
		WebElement JSPrompt=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		JSPrompt.click();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("Test Automation");
		driver.switchTo().alert().accept(); 
		Thread.sleep(3000); 
	}
	

}
