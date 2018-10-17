package com.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public String  filepath ;
	
	
	
	public ExcelDataProvider(String excelpath){ //constractor
	
		
		try {
			filepath=excelpath;
			File src = new File(this.filepath);
			FileInputStream fis =new FileInputStream(src);
			wb =new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	// function to get string cell data from excel
	public String getCellData(String sheetName, int row , int col){
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	// function to get cell data as format.
	public String getFromatCellData(String sheetName, int row, int col){
		DataFormatter df = new DataFormatter();
		sheet = wb.getSheet(sheetName);
		Cell cell = sheet.getRow(row).getCell(col);
		String data = df.formatCellValue(cell);
		
		return data;
		
	}
	//function to count the row from excel
	public int getRowCount( String sheetName){
		int row = wb.getSheet(sheetName).getLastRowNum();
		row= row+1;
		return row;
		
	}
	// function for getting numeric cell value from excel.
	public int getNumaricCellData(String sheetName, int row, int col){
		sheet = wb.getSheet(sheetName);
		int data = (int) sheet.getRow(row).getCell(col).getNumericCellValue();
		return data;
	}
	//Function to get cell data as date formate
	public Date getDateCellData(String sheetName, int row, int col){
		sheet = wb.getSheet(sheetName);
		Date data =  sheet.getRow(row).getCell(col).getDateCellValue();
		return data;
	}
	//function to get money type of data
	public Double getDoubleCellData(String sheetName, int row, int col){
		sheet = wb.getSheet(sheetName);
	    Double data =  sheet.getRow(row).getCell(col).getNumericCellValue();
		return data;
	}
	
	// function for writing in excel
	public void writingIntoExcel() throws Exception{
		
		FileOutputStream fileout = new FileOutputStream(filepath);
		wb.write(fileout);
		fileout.flush();
		fileout.close();
	}
	// function for creating sheet in excel
	public void createSheet(String sheetName){
		sheet = wb.getSheet(sheetName);
	}
	// function for creating row in excel
	public Row createRow(String sheetName, int rowIndex){
		sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow((int)rowIndex);
		
		return row;
		
	}
	// function for deleting sheet from excel
	
	public void deleteSheetFromExcel(String sheetName) throws Exception{
		for(int i=wb.getNumberOfSheets()-1; i>0;i--){
			XSSFSheet tempSheet=wb.getSheetAt(i);
			if(tempSheet.getSheetName().equalsIgnoreCase(sheetName)){
				wb.removeSheetAt(i);
				break;
			}
		}
		writingIntoExcel();
	}
	
	
	
	

}
