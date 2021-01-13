package com.orangeHRM.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.orangeHRM.excelreader.ExcelDataReader;



public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static ExcelDataReader datatable;
	
	public TestBase() throws Exception {
		prop = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\orangeHRM\\config\\config.properties");
		prop.load(fn);
	}
	
	public void initialization() {
		String BrowserName = prop.getProperty("browserType");
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Atul\\Silenium\\Selenium Webdriver Download\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox")) {
			System.setProperty("webdriver,gecko.driver", "C:\\Atul\\Silenium\\Selenium Webdriver Download\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Atul\\Silenium\\Selenium Webdriver Download\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("ApplicationURL"));
		
		}

}
