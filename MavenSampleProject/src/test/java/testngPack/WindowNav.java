package testngPack;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowNav {
	WebDriver driver;
	@Test
	public void Handl_WindowNa() throws InterruptedException{		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//window id of the Parent Window
		String ParentWindowID = driver.getWindowHandle();
		System.out.println("ParentWindowID : " + ParentWindowID);
		
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of Open Windows : " + winids.size()); //1
		//Identify Login Now and Click on Login NOw
		WebElement LoginButton = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
	
		LoginButton.click();
		System.out.println("Number of Open Windows after clicking on Loginbutton but before getting the windowHandles : " + winids.size()); //1
		//at this point of time - i have 2 windows open
		//Now I need to get the windowHandles at this point of time to get the 
		//current number of opened windows		
		
		winids = driver.getWindowHandles();
		System.out.println("Number of Open Windows : " + winids.size());//2
		Iterator<String> itr = winids.iterator();
		String mainwindowId = itr.next().toString();
		String subwindowId = itr.next().toString();

		System.out.println("mainWindowId - " + mainwindowId);
		System.out.println("subWindowId - " + subwindowId);
		//switch the control to the subwindow 
		driver.switchTo().window(subwindowId);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
		WebElement UserId = driver.findElement(By.id("User_Id"));
		UserId.sendKeys("Selenium");
		Thread.sleep(3000);
		driver.close(); //this is going to close the subwindow 
		//switch the control to the main window
		driver.switchTo().window(mainwindowId);
		driver.findElement(By.id("topMnuinsurance")).click();
		
		
	}

}
