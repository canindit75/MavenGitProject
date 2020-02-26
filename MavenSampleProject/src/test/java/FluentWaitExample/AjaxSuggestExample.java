package FluentWaitExample;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class AjaxSuggestExample {
	WebDriver driver;
	@Test
	public void AjaxExample(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("s");
        driver.manage().window().maximize();
        
       FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        		.withTimeout(40, TimeUnit.SECONDS)
        		.pollingEvery(5, TimeUnit.SECONDS)
        		.ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver,WebElement>(){
        	public WebElement apply(WebDriver driver){
        		
        		WebElement element = driver.findElement(By.xpath("//*[@id='sbse2']/div[2]/b"));
        		if(element.isDisplayed())
        		{
        			System.out.println("Ajax");
        			return element;
        		}
        		else
        		{
        			System.out.println("No Ajax");
        			return null;
        		}
        		}});
        	}
        }
	


