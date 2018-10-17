package testCases.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DataProvider.ExtentManager;
import com.Factory.BrowserFactory;
import com.Factory.DataProviderFactory;
import com.PageObject.Yahoo_HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class VerifyHomePage_Yahoo extends BrowserFactory{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	public static String sheetName;

	@BeforeMethod
	public void setUp() throws Exception {
		extent = ExtentManager.GetExtent();
		driver = BrowserFactory.getBrowser("chrome");
		Thread.sleep(2000);
		String urlPath = DataProviderFactory.getConfig().getApplicationUrl();
		driver.get(urlPath);
		Thread.sleep(2000);

	}

	@Test
	public void verifyHomepagetitle() throws Exception {
		if(BrowserFactory.executeDriverSetup()==true){
		sheetName = "SignUp";
		int rowCount = DataProviderFactory.getExcel().getRowCount(sheetName);
		System.out.println(rowCount);
		for (int row =1;row<rowCount;row++){
		String titleFromExcel= DataProviderFactory.getExcel().getCellData(sheetName, row, 1);
		System.out.println("Title from excel = " + titleFromExcel);
		test= extent.createTest(this.getClass().getSimpleName());

		Yahoo_HomePage homepage = PageFactory.initElements(driver, Yahoo_HomePage.class);

		String title = homepage.getHomePageTitle();
		System.out.println("My Application title is= " + title);
		DataProviderFactory.getExcel().getCellData("SignUp", row, 1);
		Assert.assertEquals(title, titleFromExcel);
		test.log(Status.INFO, "Assert Passed and title matched");
		Reporter.log("Assert Passed and title matched");
		BrowserFactory.ScreenShot().takeScreenshot();
		}
	}
	}

	//@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test failed" + result.getThrowable());
			Reporter.log("Fail Test Case");
			BrowserFactory.ScreenShot().takeScreenshot();
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(this.getClass().getSimpleName() + "-test skiped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test passed");
			Reporter.log("Pass");
			BrowserFactory.ScreenShot().takeScreenshot();
		}

	}

	@AfterTest
	public void testEnd() {
		extent.flush();
		BrowserFactory.closeBrowser(driver);

	}

}
