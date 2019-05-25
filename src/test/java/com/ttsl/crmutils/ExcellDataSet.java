package com.ttsl.crmutils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ttsl.crmapppages.Initializer;

public class ExcellDataSet extends Initializer{
	
	
	public static boolean checkTestMethodName(String MethodName) throws Exception, IOException
	{
		
		
		XSSFWorkbook book = new XSSFWorkbook(new File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\src\\test\\resources\\ExcellFile\\ExcelDataSet.xlsx"));
		 
		XSSFSheet sheet=book.getSheet("HOME");
		
		int rowno=sheet.getLastRowNum();
		
		for(int i =1;i<=rowno;i++)
		{
			Cell cell=sheet.getRow(i).getCell(0);
			
			sheet.getRow(i).getCell(0).setCellType(cell.CELL_TYPE_STRING);
			
			String TestName=sheet.getRow(i).getCell(0).getStringCellValue();
			
			if(TestName==MethodName)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static Object[][] getMultipleData() throws Exception, Exception
	{
		
		

		XSSFWorkbook book = new XSSFWorkbook(new File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\src\\test\\resources\\ExcellFile\\ExcelDataSet.xlsx"));
		 
		XSSFSheet sheet=book.getSheet("MULTI DATA");
		
		int rowno=sheet.getLastRowNum();
		
		int cellno=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[cellno][rowno+1];
		
		for(int i=0;i<=rowno;i++)
		{
			for(int j=0;j<cellno;j++)
			{
				Cell cell=sheet.getRow(i).getCell(j);
				
				sheet.getRow(i).getCell(j).setCellType(cell.CELL_TYPE_STRING);
				
				 data[j][i]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	 
	}

}
