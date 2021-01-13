package com.orangeHRM.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.testbase.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(xpath = "//tr//td[@class=\"legendLabel\"]")
	List<WebElement> Legend;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement AdminTab;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
	WebElement UseManagement;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement Users;
	
	public DashboardPage() throws Exception{
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLegends() {
		
		for(WebElement ele:Legend) {
			
			String legend = ele.getText();
			
			if(legend.equals("Not assigned to Subunits")) {
				
				return ele.isDisplayed();
			}
		}
		return false;
	}
	
	public void clickAdminUser() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(AdminTab).build().perform();;
		Thread.sleep(2000);
		UseManagement.click();
		Thread.sleep(2000);
		Users.click();
		Thread.sleep(2000);
}
}			