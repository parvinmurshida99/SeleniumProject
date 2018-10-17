package com.Factory;

import com.DataProvider.ConfigDataProvider;
import com.DataProvider.ExcelDataProvider;
import com.DataProvider.ReportLog;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig(){
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
		
	}
	
	public static ExcelDataProvider getExcel(){
		ExcelDataProvider getdata = new ExcelDataProvider("./ApplicationTestData/DataSheet.xlsx");
		System.out.println(getdata);
		return getdata;
		
	}
	
	
	
	/*public static ReportLog getReportLog(){
		ReportLog getReport = new ReportLog();
		return getReport;
	}*/

	
	}
	
	


