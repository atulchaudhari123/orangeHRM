package com.orangeHRM.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangeHRM.excelreader.ExcelDataReader;
import com.orangeHRM.testbase.TestBase;




public class TestUtil extends TestBase{


	public TestUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public static boolean ReadExcelData(String testcaseName)
	{
    for(int rowNum=2 ; rowNum<=datatable.getRowCount("Test Cases");rowNum++){
	// System.out.println(datatable.getCellData("Test Cases", "TestScriptName", rowNum));
	if(testcaseName.equals(datatable.getCellData("Test Cases", "TestScriptName", rowNum))){

	if(datatable.getCellData("Test Cases", "RunMode", rowNum).equals("Y"))

	return false;

	else
	return true;

	}
	}
	return false;
	}
	//Get data from Excel file
	public static Object [][] getData(String testName)
	{
		// Return test data
		// Read the data from Excel
		
		if (datatable==null)
		{
			datatable = new ExcelDataReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\orangeHRM\\config\\Suite.xlsx");
		}
		
		int row = datatable.getRowCount(testName)-1;
		if (row<=0)
		{
			 Object [][] TestData = new Object[1][0];
		return TestData;
		}	
		 row = datatable.getRowCount(testName);
		 int cols = datatable.getColumnCount(testName);
		 
		 System.out.println("Test Name --" +testName);
		 System.out.println("Test row --" +row);
		 System.out.println("Test cols --" +cols);
		 
		 Object data[][]= new Object[row-1][cols];
		 
		 for(int rowNum = 2; rowNum<=row; rowNum++)
		 {
			 for(int colNum = 0; colNum<cols; colNum++)
			 {
				 data[rowNum-2][colNum] = datatable.getCellData(testName, colNum, rowNum);
				 
			 }
		 }
		 
		return data;
	}

	
	public static void takeScreenShot(String filename)
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile , new File(System.getProperty("user.dir")+ "\\Screenshot\\"+ filename+ ".jpg" ));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
