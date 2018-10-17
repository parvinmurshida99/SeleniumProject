package com.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.Factory.BrowserFactory;

public class ReportLog extends BrowserFactory{
	
	public void takeScreenshot() throws Exception{
	
	String timeStamp;
	File ScreenShotName;
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	ScreenShotName = new File("C:/AutomationFramwork/Screenshot" + timeStamp+ ".png");
	FileUtils.copyFile(srcFile, ScreenShotName);
	
	String filePath = ScreenShotName.toString();
	String path = "<img src = \"file://" + filePath + "\" alt =\"\"/>";
	Reporter.log(path);
	}
}
