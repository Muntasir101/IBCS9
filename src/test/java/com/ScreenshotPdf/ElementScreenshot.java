package com.ScreenshotPdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Basic.BaseClass;
import com.Demo.HomePage;

public class ElementScreenshot extends BaseClass{

	public static void main(String[] args) throws IOException {
		launchChrome();
		HomePage.openHomepage();

		//Search Box 
		WebElement searchbox=driver.findElement(By.name("search"));

		//Capture Full page Screenshot 
		//Take screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Get Location of the element
		Point point=searchbox.getLocation();
		int Xcoordinate=point.getX();
		int Ycoordinate=point.getY();
		
		//Get Image width and Height 
		int imageWidth=searchbox.getSize().getWidth();
		int imageHeight=searchbox.getSize().getHeight();
			
		//Reading Full image screenshot
		BufferedImage img=ImageIO.read(srcFile);
		
		// Cutting image using coordinate , width and height
		BufferedImage FinalImage=img.getSubimage(Xcoordinate, Ycoordinate, imageWidth, imageHeight);
		ImageIO.write(FinalImage, "PNG", srcFile);
		
		//Save final image
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\ElementScreenshot.png"),true);	
	
		tearDownChrome();
		
	}

}
