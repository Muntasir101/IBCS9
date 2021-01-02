package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;

public class SwitchMultipleWindow extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		launchChrome();
		WindowGUID.openHomeURL();
		SwitchWindow();
		tearDownChrome();

	}

	public static void SwitchWindow() throws InterruptedException
	{
		String parentGUID=driver.getWindowHandle();
		WebElement NewWindowBtn=driver.findElement(By.cssSelector("#content > div > a"));
		NewWindowBtn.click();
		Thread.sleep(3000);

		Set<String> allGUID=driver.getWindowHandles();

		int TotalWindow=allGUID.size();
		System.out.println("Total Number of Window= "+TotalWindow);
		
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(parentGUID))
			{
				driver.switchTo().window(parentGUID);
				Thread.sleep(3000);
				System.out.println("Parent window Title: "+driver.getTitle());
				
				break;
			}
		}
		
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(parentGUID))
			{
				driver.switchTo().window(ChildGUID);
				Thread.sleep(3000);
				System.out.println("Child window Title: "+driver.getTitle());
				
				break;
			}
		}
		
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(parentGUID))
			{
				driver.switchTo().window(parentGUID);
				Thread.sleep(3000);
				System.out.println("Switch from Child window, parent window Title: "+driver.getTitle());
				
				break;
			}
		}

	}

}
