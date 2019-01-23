package com.poc.qa.util;

import java.util.ArrayList;

public class TestUtil {
	
static Xls_Reader reader;


public static ArrayList<String> getDataFromExcel()
{
	ArrayList<String> exceldata= new ArrayList<String>();
	
	try
	{
     reader =new Xls_Reader("C://Users//vishal.kashid//ExcelDriven.xlsx");
	}
	catch (Exception e) { 
		e.printStackTrace(); 
	}
	
	for(int rownum=2;rownum<=reader.getRowCount("GETStatus"); rownum++)
	{
		 
		exceldata.add(reader.getCellData("GETStatus", "Source", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "Name", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "Sourcename", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "FCount", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "Scount", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "Status", rownum));
		 
		exceldata.add(reader.getCellData("GETStatus", "Text", rownum));
		 
		
		 
	}
	
	
return exceldata;	

}	

public static ArrayList<String> postDataFromExcel()
{
	ArrayList<String> exceldata= new ArrayList<String>();
	
	try
	{
     reader =new Xls_Reader("C://Users//vishal.kashid//ExcelDriven.xlsx");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	for(int rownum=2;rownum<=reader.getRowCount("POSTStatus"); rownum++)
	{
		 
		exceldata.add(reader.getCellData("POSTStatus", "Source", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "Name", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "Sourcename", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "FCount", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "Scount", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "Status", rownum));
		 
		exceldata.add(reader.getCellData("POSTStatus", "Text", rownum));
		 
		
		 
	}
	
	
return exceldata;	

}	

}