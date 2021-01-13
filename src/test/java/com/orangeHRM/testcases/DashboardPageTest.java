package com.orangeHRM.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.pages.DashboardPage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.testbase.TestBase;

public class DashboardPageTest extends TestBase {
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	public DashboardPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void appSetup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		loginpage.login("admin", "admin123");
		
	}
	
	@Test
	public void verifyLegendTest() {
		
		boolean leg = dashboardpage.verifyLegends();
		System.out.println(leg);
		Assert.assertTrue(leg);
		
	}
	
	@Test
	public void adminClick() throws Exception {
		
		dashboardpage.clickAdminUser();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
