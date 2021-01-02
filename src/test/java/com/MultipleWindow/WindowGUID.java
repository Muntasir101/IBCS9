package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;

public class WindowGUID extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		launchChrome();
		openHomeURL();
		getGUID();
		tearDownChrome();

	}
	
	public static void openHomeURL()
	{
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	public static void getGUID() throws InterruptedException
	{
	   String parentGUID=driver.getWindowHandle();
	   System.out.println("parent GUID: "+parentGUID);
	   
	   WebElement NewWindowBtn=driver.findElement(By.cssSelector("#content > div > a"));
	   NewWindowBtn.click();
	   Thread.sleep(3000);
	   
	   Set<String> allGUID=driver.getWindowHandles();
	   System.out.println("All GUID: "+allGUID);
	   
	   int TotalWindow=allGUID.size();
	   System.out.println("Total Number of Window= "+TotalWindow);
	   
	   
	}

}
