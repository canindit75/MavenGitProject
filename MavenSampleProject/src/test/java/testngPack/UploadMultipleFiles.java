package testngPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadMultipleFiles {

	public static void main(String args[]) throws IOException, InterruptedException{
		System.getProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/Selenium_Training/Selenium_Projects_Workspace/MavenSampleProject/autoit/fileupload.html");
		driver.findElement(By.name("myfile")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Selenium_Training\\Selenium_Projects_Workspace\\MavenSampleProject\\autoit\\multiplefileupload.exe"+" "+"E:\\Selenium_Training\\Selenium_Projects_Workspace\\MavenSampleProject\\autoit\\names.txt");
		Thread.sleep(5000);
		driver.findElement(By.name("myfile")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Selenium_Training\\Selenium_Projects_Workspace\\MavenSampleProject\\autoit\\multiplefileupload.exe"+" "+"E:\\Selenium_Training\\Selenium_Projects_Workspace\\MavenSampleProject\\autoit\\fileupload1.html");
		Thread.sleep(5000);
		//driver.quit();

	}
}
