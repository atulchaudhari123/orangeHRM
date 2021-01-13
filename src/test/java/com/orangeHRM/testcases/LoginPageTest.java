package com.orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.testbase.TestBase;
import com.orangeHRM.util.TestUtil;


public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;

	
	public LoginPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void applicationSetup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		
	}
		
	@Test
	public void verifyLogo()
	{
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		System.out.println("verify logo");
	
	}
	@Test(dataProvider = "getData")
	public void loginOrangeHRM(String usrname, String pasword)
	{
		loginpage.login(usrname, pasword);
		String actualTitle=driver.getTitle();
		String expTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expTitle);
		TestUtil.takeScreenShot("DashboardPage");
		
	}
	
	@Test
	public void verifyforgotPWDlink() {
		loginpage.forgotPwd();
	
		String actualURL= driver.getCurrentUrl();
		String expURL="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
		Assert.assertEquals(actualURL, expURL);
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public static Object[][] getData(){
		
	Object [][] TestData = TestUtil.getData("LoginPageTest");
		
//		Object [][] TestData = new Object[2][2];
//		TestData[0][0] = "admin";
//   	    TestData[0][1] = "admin123";
//   	    
//   	    TestData[1][0] = "admin";
//	    TestData[1][1] = "admin1";
		    
		    return TestData;
	}
		
	}

