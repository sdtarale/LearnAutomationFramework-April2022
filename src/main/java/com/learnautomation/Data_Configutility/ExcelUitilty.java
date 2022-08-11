package com.learnautomation.Data_Configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUitilty {
	
	static XSSFWorkbook wb;
	
	public static Object[][] readDataFromExcel(String sheetname) throws IOException
	{ 
		Object obj[][]=null;
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ConfigUtility.getConfigData("TestData_File_Name"))));
			XSSFSheet sh1=wb.getSheet(sheetname);
			int row=sh1.getPhysicalNumberOfRows();
			int column=sh1.getRow(0).getPhysicalNumberOfCells();
			obj=new Object[row][column];
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					obj[i][j]=getData(sheetname, i, j);
				}
			}
				
			
		} catch (FileNotFoundException e) {
			
		System.out.println("Could not find the excel sheet "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not load the excel sheet "+e.getMessage());
		}
		wb.close();		
		return obj;
		
	}
	
	public static String getData(String sheet, int row, int column) throws IOException
	{	String data="";
		XSSFSheet sh=wb.getSheet(sheet);
		XSSFCell cell=sh.getRow(row).getCell(column);
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if (cell.getCellType()==CellType.NUMERIC)
		{
			double doubleData=cell.getNumericCellValue();
			data=String.valueOf(doubleData);
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		wb.close();
		return data;
	}
	

}
