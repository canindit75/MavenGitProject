package com.caloriecalc.testcases;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.caloriecalc.pageobjects.InquiryFormPOM;
import com.caloriecalc.utils.DataReaders;
import com.caloriecalc.utils.Drivers;

public class InquiryForm {
	WebDriver driver;
	
	//Data provider
	//gets data from ./src/testData/data.csv file
	@DataProvider
	public Iterator<String[]> testData(){
		return  DataReaders.CSVReader("./src/test/java/com/caloriecalc/testData/data.csv");
	}
	
	//testcase to validate formfields
	@Test(dataProvider = "testData")
	public void testCase001(Object fName,Object lName, Object email, Object mob) throws Exception{
		driver = Drivers.getChrome();
		driver.get(DataReaders.projectProperty("baseURL"));
		InquiryFormPOM obj = new InquiryFormPOM(driver);
		obj.testCase001(fName, lName, email, mob);
		driver.close();
	}
}
