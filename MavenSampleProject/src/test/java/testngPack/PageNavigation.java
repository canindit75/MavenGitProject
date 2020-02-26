package testngPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageNavigation {
	
	@Test
	public void PageNav() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.calculator.net/calorie-calculator.html");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("title : " + title);
		String CurrentURL= driver.getCurrentUrl();
		System.out.println("CurrentURL : " + CurrentURL);
		String pageSource =driver.getPageSource();
		System.out.println("pageSource : " + pageSource);

		//navigating to another page by clicking on BMI link
		driver.findElement(By.linkText("BMI")).click();
		Thread.sleep(2000);
		driver.navigate().back(); //use the back button
		Thread.sleep(2000);
		driver.navigate().forward(); //forward button
		Thread.sleep(2000);
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		driver.navigate().refresh(); //refreshing the loaded page
		driver.get("http://www.google.com");
		
		
	}

}
