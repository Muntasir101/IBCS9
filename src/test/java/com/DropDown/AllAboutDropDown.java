package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Basic.BaseClass;

public class AllAboutDropDown extends BaseClass {
	
	public static void main(String[] args) throws InterruptedException {

		launchChrome();
		openDropDownTestURL();
		dropDownAllOptions();
		//selectDropDownByIndex();
		//selectDropDownByValue();
		//selectDropDownByVisibleText();
		tearDownChrome();
	}
	
	public static void openDropDownTestURL()
	{
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}
	
	public static void dropDownAllOptions()
	{
		WebElement DropDown=driver.findElement(By.id("dropdown"));			
		String allOptions=DropDown.getText();		
		System.out.println(allOptions);
		
	}
	
	public static void selectDropDownByIndex() throws InterruptedException
	{
		WebElement DropDown=driver.findElement(By.id("dropdown"));		
		Select obj=new Select(DropDown);	
		obj.selectByIndex(1);
		Thread.sleep(5000);
	}
	
	public static void selectDropDownByValue() throws InterruptedException
	{
		WebElement DropDown=driver.findElement(By.id("dropdown"));		
		Select obj=new Select(DropDown);	
		obj.selectByValue("2");
		Thread.sleep(5000);
	}
	
	public static void selectDropDownByVisibleText() throws InterruptedException
	{
		WebElement DropDown=driver.findElement(By.id("dropdown"));		
		Select obj=new Select(DropDown);	
		obj.selectByVisibleText("Option 1");
		Thread.sleep(5000);
	} 
}
