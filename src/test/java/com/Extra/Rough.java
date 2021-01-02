package com.Extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://google.com");

		
	//	System.out.println(System.getProperty("user.dir"));
		
	}

}
