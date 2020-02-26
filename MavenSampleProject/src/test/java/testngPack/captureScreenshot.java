package testngPack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class captureScreenshot {
	
/*	@Test
	public void captureScreenshot() throws IOException{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.calculator.net/calorie-calculator.html");
		//we will use TakesScreenshot interface and access the method getScreenshotAs
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		//reference common-io jars - i need FileUtils.copyFile(source,dest)
		FileUtils.copyFile(file,new File("./screenshots/CalorieCalcError.png"));
	}*/
	
	@Test
	public void method1() throws IOException, InterruptedException{
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		WebElement ele = driver.findElement(By.id("lga"));

		Thread.sleep(2000);

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();


		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		driver.quit();
		 
	}

	
	
/*//	@Test
//	public void method1() throws IOException, InterruptedException{
//		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("http://www.google.com");
//		Thread.sleep(2000);
//		WebElement ele = driver.findElement(By.id("lga"));
//
//		// Get entire page screenshot
//		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		BufferedImage  fullImg = ImageIO.read(screenshot);
//
//		// Get the location of element on the page
//		Point point = ele.getLocation();
//
//		// Get width and height of the element
//		int eleWidth = ele.getSize().getWidth();
//		int eleHeight = ele.getSize().getHeight();
//
//		// Crop the entire page screenshot to get only element screenshot
//		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
//		    eleWidth, eleHeight);
//		ImageIO.write(eleScreenshot, "png", screenshot);
//
//		// Copy the element screenshot to disk
//		File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
//		FileUtils.copyFile(screenshot, screenshotLocation);
//		 
//	}
*/}
