package com.Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Basic.BaseClass;

public class Registration extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {

		launchChrome();
		HomePage.openHomepage();
		openRegistrationURL();
		RegisterInsertData();
		tearDownChrome();

	}

	public static void openRegistrationURL() throws InterruptedException
	{
		WebElement MyAccountMenu=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		MyAccountMenu.click();
		Thread.sleep(1000);
		
		WebElement RegisterSubmenu=driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a"));
		RegisterSubmenu.click();
		Thread.sleep(1000);		
	}

	public static void RegisterInsertData() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\propertiesFile\\OR.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		driver.findElement(By.name("firstname")).sendKeys("fahim1");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Siddiqui");		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.name("telephone")).sendKeys("11234789");
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[1]")).click();	
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();


		String validRegistartion="Your Account Has Been Created!";		
		String acutalRegistration=driver.findElement(By.cssSelector("#content > h1")).getText();		
		Assert.assertEquals(acutalRegistration, validRegistartion);
		System.out.println("Account Created");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1400)");
		
		WebElement Logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
		Logout.click();

	}

}
