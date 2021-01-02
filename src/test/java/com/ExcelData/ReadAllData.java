package com.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Set test data path
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ReadData.xlsx");

		//workbook
		Workbook wb=WorkbookFactory.create(fis);

		//Excel sheet
		Sheet sht=wb.getSheet("MyData");
		
		//Iterator through each Row one by one
		Iterator<Row> rowIterator=sht.iterator();
		while(rowIterator.hasNext())
		{
			Row row=rowIterator.next();
			//for each roe iterator through all columns
			Iterator<Cell> cellIterator=row.cellIterator();
			while(cellIterator.hasNext())
			{
				Cell cel=cellIterator.next();
	
				System.out.println(cel.getStringCellValue());
			}
		}
				
		fis.close();
		
	}

}
