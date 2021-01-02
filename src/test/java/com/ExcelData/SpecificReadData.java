package com.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class SpecificReadData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Set test data path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");


		//workbook
		Workbook wb=WorkbookFactory.create(fis);

		//Excel sheet
		Sheet sht=wb.getSheet("MyData");

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
		String UserPassword1=cel2.getStringCellValue();
		System.out.println("User password 1: " +UserPassword1);

		fis.close();

	}

}
