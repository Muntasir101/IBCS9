package com.Demo;

import com.Basic.BaseClass;

public class HomePage extends BaseClass {

	public static void main(String[] args) {
		launchChrome();

	}
	
	public static void openHomepage()
	{
		driver.get("https://demo.opencart.com/");
	}

}
