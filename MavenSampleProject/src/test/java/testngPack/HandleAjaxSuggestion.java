package testngPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAjaxSuggestion {
	WebDriver driver;
	@Test
	public void AjaxTest(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("s");
	    WebDriverWait wait = new WebDriverWait(driver, 10); //wait defined 
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbo']/li[1]")));
		List<WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']/li"));
		System.out.println(list.size());
		
		for(WebElement element : list)
		{				
			if(element.getText().equals("snapdeal"))
			{
				element.click();
				break; //the list will disappear
			}
		}
		}
		catch(InvalidSelectorException e){
			System.out.println("Invalid Selector Exception");
		}
		catch(NoSuchElementException e){
			System.out.println("No Such Element Found");
		}
		catch(TimeoutException e){
			System.out.println("Timeput Exception");
		}

		driver.close();
	}

}
