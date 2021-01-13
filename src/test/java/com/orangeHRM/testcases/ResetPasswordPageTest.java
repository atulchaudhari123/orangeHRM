package com.orangeHRM.testcases;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.ResetPasswordPage;
import com.orangeHRM.testbase.TestBase;

public class ResetPasswordPageTest extends TestBase{
	
	ResetPasswordPage resetPWDPage;
	LoginPage loginpage;

	
	public ResetPasswordPageTest() throws Exception{
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		resetPWDPage = new ResetPasswordPage();
		loginpage =  new LoginPage();
		loginpage.forgotPwd();
	;
	}
	
	@Test
	public void verifyResetPWD() throws Exception {
		resetPWDPage.resetPassword("abcd");
		Assert.assertTrue(true);
		
	}
	@Test
	public void cancelRPWD() {
		resetPWDPage.cancelResetPwd();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}