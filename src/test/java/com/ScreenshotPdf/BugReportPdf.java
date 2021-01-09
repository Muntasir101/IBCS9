package com.ScreenshotPdf;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Basic.BaseClass;
import com.Demo.HomePage;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BugReportPdf extends BaseClass {
	
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		launchChrome();
		HomePage.openHomepage();
		
		byte[] input=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		//Pdf
		Document doc=new Document();
		
		String output=System.getProperty("user.dir")+"\\Screenshots\\BugReportpdf.pdf";
		
		FileOutputStream fos=new FileOutputStream(output);
		
		PdfWriter writer=PdfWriter.getInstance(doc, fos);
		
		writer.open();
		doc.open();
		
		Image img=Image.getInstance(input);
		
		img.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);
		
		doc.add(img);
		doc.add(new Paragraph("Bug Report"));
		doc.add(new Paragraph("Priority: HIGH"));
		doc.add(new Paragraph("Severity: MEDIUM"));
		doc.add(new Paragraph("Steps to Reproduce: "));
		
		doc.close();
		writer.close();
		
		tearDownChrome();
		
	}

}
