package testngPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseOps {
	
	@Test
	public void MouseOpsTest(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.opencart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//implicit wait - once from that point till the driver closes 
		WebElement component=driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/a"));
		component.click();
		//driver.findElement(By.id("cage")).sendKeys(Keys.ENTER);
		//explicit - property check + timeout
		WebDriverWait wait = new WebDriverWait(driver,30);
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a")));
		WebElement printerElement = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a"));
		//MOuse Operations Actions
		Actions action = new Actions(driver);
		action.moveToElement(printerElement).click(printerElement).build().perform();
		}catch(Exception e){
			System.out.println("Exception Occurred");
		}
	}

}
