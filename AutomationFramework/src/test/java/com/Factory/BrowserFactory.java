package com.Factory;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.DataProvider.ReportLog;



public class BrowserFactory {

	public static WebDriver driver;
	public static ReportLog Screenshot;
	public static boolean continueTestClass = false;
	public static String MyTestClassName;
	public static String sheetName;
	//public static DataProviderFactory ed;
	
	
	

	// function for invoking browser
	public static WebDriver getBrowser(String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("firefox")) 
		{
			//System.setProperty("webdriver.firefox.marionette", DataProviderFactory.getConfig().getChromePath());
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			
	
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			
			//we created object of configDataProvider class inside
			//DataproviderFactory class. from this class we are calling DataproviderFactory class and getting all
			//other properties that class and ConfigDataProvider class
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("useAutomationExtentions", false);
	options.addArguments("test-type");
	options.addArguments("start-maximized");
	options.addArguments("--js-flags=--expose-gc");
	 options.addArguments("--start-maximized");
     options.addArguments("--ignore-certificate-errors");
     options.addArguments("--disable-popup-blocking");
     options.addArguments("--incognito");
     options.addArguments("--no-sandbox");
     options.addArguments("--dns-prefetch-disable");
     options.addArguments("--disable-default-apps");
     options.addArguments("--enable-precise-memory-info");
     options.addArguments("--enable-automation");
     options.addArguments("test-type=browser");
     options.addArguments("disable-infobars");
     options.addArguments("disable-extentions");
    // driver = new ChromeDriver(options);
   
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCapabilities.setCapability("ensureCleanSession", true);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("ignore-certificate-error", true);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlartBehaviour", "accept");
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			
			driver = new InternetExplorerDriver(ieCapabilities);
			//driver = new InternetExplorerDriver();
		}else{
			throw new Exception("Browser is not found");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;

	}
	
	public static boolean executeDriverSetup(){
		sheetName = "SignUp";
		int rowCount = DataProviderFactory.getExcel().getRowCount(sheetName);
		System.out.println(rowCount);
		for (int row =1;row<rowCount;row++){
			String excelTestClassName =(DataProviderFactory.getExcel().getCellData(sheetName, row, 0));
			System.out.println(excelTestClassName);
		if(MyTestClassName.equals(excelTestClassName)){
			System.out.println();
			System.out.println(MyTestClassName);
			continueTestClass=true;
		
		}
		}
		return continueTestClass==true;
	}
	
	public static ReportLog ScreenShot(){
	return Screenshot = new ReportLog();
	}
// function for closing driver
	public static void closeBrowser(WebDriver IDriver) {
		IDriver.close();
	}
}