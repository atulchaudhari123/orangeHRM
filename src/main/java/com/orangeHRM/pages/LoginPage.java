package com.orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testbase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Repository - OR Properties
	
	@FindBy(id="txtUsername")
	WebElement UserName;
	
	@FindBy(name ="txtPassword")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//*[@id=\"divLogo\"]/img")
	WebElement logo;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPassword;
	
	
	//initialize the page object
	
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	
	}

	
	// Actions needs to be performed
	
	public boolean validateLogo() {
		
		return logo.isDisplayed();
		
	}
	
	public void login(String UName, String Pword) {
		UserName.sendKeys(UName);
		Password.sendKeys(Pword);
		LoginBtn.click();
	}
	
	public void forgotPwd() {
		forgotPassword.click();
	}
	
}
	
