package com.orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testbase.TestBase;

public class ResetPasswordPage extends TestBase{
	
	//Page Repository - OR Properties
	
	@FindBy(xpath ="//*[@id='securityAuthentication_userName']")
	WebElement RUsername;
	
	@FindBy(xpath = "//*[@id=\"btnSearchValues\"]")
	WebElement ResetButton;
	
	@FindBy(xpath = "//*[@id=\"btnCancel\"]" )
	WebElement CancelBtn;
	
	//initialize the page object
	
	public ResetPasswordPage() throws Exception {
		
		PageFactory.initElements(driver, this);
	}
	
	// Actions needs to be performed
	
	
	public void resetPassword(String Runame) throws Exception {
		
		RUsername.sendKeys(Runame);
		Thread.sleep(2000);
		ResetButton.click();
		
	}
  public void cancelResetPwd() {
	  CancelBtn.click();
  }
	
	
}
