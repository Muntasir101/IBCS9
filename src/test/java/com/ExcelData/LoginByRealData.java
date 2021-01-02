package com.ExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.Basic.BaseClass;
import com.Demo.HomePage;
import com.Demo.LoginTest;

public class LoginByRealData extends BaseClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {		

		//Set test data path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");
		//workbook
		Workbook wb=WorkbookFactory.create(fis);
		//Excel sheet
		Sheet sht=wb.getSheet("MyData");

		//Getting email and password from Excel
		//Excel Row
		Row rw=sht.getRow(0);

		//Excel cell
		Cell cel=rw.getCell(0);	

		String UserMail1=cel.getStringCellValue();
		System.out.println("User Mail 1: " +UserMail1);

		//for password
		//Excel Row
		Row rw2=sht.getRow(0);
		Cell cel2=rw2.getCell(1);

		//if password String
		//String StringUserPassword1=cel2.getStringCellValue();
		//System.out.println("User password 1: " +StringUserPassword1);

		//if password numeric
		DataFormatter formatter=new DataFormatter();
		String Numericpassword1=formatter.formatCellValue(cel2);

		fis.close();

		//Real Implement in Demo.opencart.com
		launchChrome();
		HomePage.openHomepage();
		LoginTest.openLoginURL();	

		WebElement Email=driver.findElement(By.name("email"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		Email.sendKeys(UserMail1);
		Password.sendKeys(Numericpassword1);
		LoginBtn.click();

		Thread.sleep(5000);



		/*
		 * Message to be written in Excel
		 * if login with valid data output as Pass otherwise Fail
		 */

		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");

		String valiLogin="My Orders";		
		String acutalLogin=driver.findElement(By.cssSelector("#content > h2:nth-child(3)")).getText();		
		if(acutalLogin.contains(valiLogin))
		{
			String Result="Pass";
			sht.getRow(0).createCell(2).setCellValue(Result);
		}

		else {
			String Result="Fail";
			sht.getRow(0).createCell(2).setCellValue(Result);
		}
		
		//Logout
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1400)");
		
		WebElement Logout=driver.findElement(By.cssSelector("#column-right > div > a:nth-child(13)"));
		Logout.click();

		wb.write(fout);
		
		tearDownChrome();

	}

}
