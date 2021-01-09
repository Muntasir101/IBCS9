package com.ScreenshotPdf;

import java.io.IOException;

import com.Basic.BaseClass;
import com.Demo.HomePage;

public class PageScreenshot extends BaseClass{

	public static void main(String[] args) throws IOException {
		launchChrome();
		HomePage.openHomepage();
		windowSizeScreenshot();
		fullPageScreenshot();
		tearDownChrome();
	}

}
