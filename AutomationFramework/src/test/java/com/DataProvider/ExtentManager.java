package com.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	public static String filepath ="./extentreport.html";
	
	public static ExtentReports GetExtent(){
		if(extent !=null)
			return extent;//avoid creating new instance of html file
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			return extent;
			
		
	}
	
	public static ExtentHtmlReporter getHtmlReporter(){
		
		htmlReporter = new ExtentHtmlReporter(filepath);
		htmlReporter.loadXMLConfig("./ReportsConfig.xml");
				return htmlReporter;
		
	}
	
	public static ExtentTest createTest(String name, String description){
		test=extent.createTest(name, description);
				return test;
	}

}
