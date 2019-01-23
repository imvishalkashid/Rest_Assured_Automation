package com.poc.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
    int a;
    int b;
	
public Xls_Reader(String path) { 
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
		// returns the row count in a sheet

		public int getRowCount(String sheetName){
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return 0;
			else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
			}
			
		}
		// returns the data from a cell
		
		
		public String getCellData(String sheetName,String colName,int rowNum){
				try{
					
				
				int index = workbook.getSheetIndex(sheetName);
				int col_Num=-1;
				
				
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num=i;
				}
				
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum-1);
				
				cell = row.getCell(col_Num);
				
				
				//System.out.println(cell.getCellType());
				if(cell.getCellType()==CellType.STRING)
					  return cell.getStringCellValue();
				else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA){
					
					  
					 String cellText  = String.valueOf((int)cell.getNumericCellValue());
					  
				    return cellText;
					 
				  }else if(cell.getCellType()==CellType.BLANK)
				      return ""; 
				  else
					  return String.valueOf(cell.getBooleanCellValue());

					  
				}
				catch(Exception e){
					
					e.printStackTrace();
					return "row "+rowNum+" or column "+colName +" does not exist in xls";
				}
			}
		
				
		// to run this on stand alone
		public static void main(String arg[]) throws IOException{
			
			//System.out.println(filename);
			Xls_Reader datatable = null;
		}
}

