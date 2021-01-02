package com.Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Basic.BaseClass;

public class LoginTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		launchChrome();
		HomePage.openHomepage();
		openLoginURL();	
		emailPassInValid();
		emailValidPassInValid();
		emailInValidPassValid();
		emailPassValid();
		tearDownChrome();
	}

	public static void openLoginURL() throws InterruptedException
	{
		WebElement MyAccountMenu=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		MyAccountMenu.click();
		Thread.sleep(1000);

		WebElement LoginSubmenu=driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a"));
		LoginSubmenu.click();
		Thread.sleep(1000);		
	}

	public static void emailPassValid() throws InterruptedException, IOException
	{		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\propertiesFile\\OR.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Thread.sleep(1000);
		Email.clear();
		Email.sendKeys(prop.getProperty("email"));
		Thread.sleep(1000);
		Password.clear();
		Password.sendKeys(prop.getProperty("password"));
		LoginBtn.click();

		String valiLogin="My Orders";		
		String acutalLogin=driver.findElement(By.cssSelector("#content > h2:nth-child(3)")).getText();		
		Assert.assertEquals(acutalLogin, valiLogin);
		System.out.println("Login Successful for valid Credentails");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1400)");
		
		WebElement Logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
		Logout.click();
	}

	public static void emailPassInValid()
	{
			
		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Email.clear();
		Email.sendKeys("mail22223@mail.com");
		Password.clear();
		Password.sendKeys("123456323");
		LoginBtn.click();
	}

	public static void emailValidPassInValid() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\propertiesFile\\OR.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Email.clear();
		Email.sendKeys(prop.getProperty("email"));
		Password.clear();
		Password.sendKeys(" ");
		LoginBtn.click();
	}

	public static void emailInValidPassValid() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\propertiesFile\\OR.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Email.clear();
		Email.sendKeys("mail22dd@mail.com");
		Password.clear();
		Password.sendKeys(prop.getProperty("password"));
		LoginBtn.click();
	}

}
