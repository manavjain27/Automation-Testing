package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {

	/*
	 * @Test public void readcredentials() throws IOException { FileInputStream
	 * fis=new FileInputStream("C:\\Users\\Waheguru\\Desktop\\List.xlsx");
	 * XSSFWorkbook workbook=new XSSFWorkbook(fis); XSSFSheet
	 * sheet=workbook.getSheet("Credentials");
	 * 
	 * 
	 * XSSFRow row =sheet.getRow(0); String firstCell =
	 * row.getCell(0).getStringCellValue(); System.out.println(firstCell);
	 * 
	 * }
	 */
	
	@Test
	public static String readCredentials_Second() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Waheguru\\Desktop\\List.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Credentials");
		
		
		 XSSFRow row =sheet.getRow(0);
			
			String s=row.getCell(0).getStringCellValue();
			return s;
		
	}
	
	@Test
	public static String readCredentials_Second1() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Waheguru\\Desktop\\List.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Credentials");
		
		 XSSFRow row =sheet.getRow(0);
	
			String s=row.getCell(1).getStringCellValue();
		
			
		
	
		return s;
	}
	
}
