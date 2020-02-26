package com.caloriecalc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
	static WebDriver driver;
	
	public static WebDriver getChrome() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static String propertyReader(String filePath, String fileName, String propName) {
		Properties obj = new Properties();
		FileInputStream inStream;
		try{
			inStream = new FileInputStream(new File(filePath + "/" + fileName));
			obj.load(inStream);
		}catch(IOException e) {
			
		}
		return obj.getProperty(propName);
	}
}
