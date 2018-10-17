package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Yahoo_HomePage {
	WebDriver driver;
	
	public Yahoo_HomePage(WebDriver IDriver){
		
		this.driver = IDriver;
	}
   @FindBy(xpath="//*[@id='uh-signin']")WebElement signInlink;
   @FindBy(xpath="//*[@id='yui_3_18_0_3_1533332727265_790']")WebElement mailLink;
   @FindBy(xpath="//*[@id='yui_3_18_0_3_1533332727265_787']")WebElement newsLink;
   
   
   public void clickOnSignInLink(){
	   signInlink.click();
   }
   public void clickOnMailLink(){
	   mailLink.click();
   }
   public void clickOnNewsLink(){
	   newsLink.click();
   }
   public String getHomePageTitle(){
	   
	return driver.getTitle();
	   
   }
}
