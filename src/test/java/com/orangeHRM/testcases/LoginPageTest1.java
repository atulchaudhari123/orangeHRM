
package com.orangeHRM.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.testbase.TestBase;

public class LoginPageTest1 extends TestBase {

	LoginPage loginpage;

	public LoginPageTest1() throws Exception {
		super();
	}

	@BeforeClass(groups = {"Sanity"})
	public void applicationSetup() throws Exception {
		initialization();
		loginpage = new LoginPage();

	}

	@Test(groups = {"Sanity"})
	public void verifyLogo() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		System.out.println("verify logo");

	}
    @Parameters({"username","password"})
	@Test(groups = {"Sanity"})
	public void loginOrangeHRM(String uname, String pwd) {
		loginpage.login(uname,pwd);
		String actualTitle = driver.getTitle();
		String expTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expTitle);

	}

	@Test(groups = {"Regression"})
	public void logout() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		Thread.sleep(4000);

	}

	@AfterClass(groups = {"Sanity"})
	public void tearDown() {
		driver.quit();
	}
}
