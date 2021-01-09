package com.ScreenshotPdf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;
import com.Demo.HomePage;

public class BugReportImage extends BaseClass {

	public static void main(String[] args) throws IOException {
		launchChrome();
		HomePage.openHomepage();

		//Search Box 
		WebElement searchbox=driver.findElement(By.name("search"));
		
		//Highlight Element with red border 3px width
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'",searchbox);

		byte[] img_byte=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

		BufferedImage img=ImageIO.read(new ByteArrayInputStream(img_byte));

		//Get Location of the element
		Point point=searchbox.getLocation();
		int Xcoordinate=point.getX();
		int Ycoordinate=point.getY();

		//Get Image width and Height 
	//	int imageWidth=searchbox.getSize().getWidth();
	//	int imageHeight=searchbox.getSize().getHeight();

		//Add some text and draw a rectangle
		Graphics g=img.getGraphics();
		g.setColor(Color.red);
		g.setFont(new Font("SansSerif", Font.BOLD, 14));
		g.drawString("This is Bug", Xcoordinate, Ycoordinate);// Xcoordinate and Ycoordinate
		
		//If we want to draw , we need Xcoordinate,Ycoordinate, imageWidth, imageHeight
		//g.drawRect(Xcoordinate,Ycoordinate, imageWidth, imageHeight);

		g.dispose();

		ImageIO.write(img, "PNG",new File(System.getProperty("user.dir")+"\\Screenshots\\BugReportImage.png"));

		tearDownChrome();

	}

}
