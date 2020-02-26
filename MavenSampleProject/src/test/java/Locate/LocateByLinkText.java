package Locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByLinkText {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.calculator.net/calorie-calculator.html");
        driver.findElement(By.linkText("BMI")).click();
        driver.findElement(By.partialLinkText("Weight")).click();
	}

}
