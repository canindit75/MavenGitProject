package testngPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowNavigation {
	WebDriver driver;
	@Test
	public void WindowNav() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		//let me first get the window id of the parent window 
		String ParentWindow = driver.getWindowHandle();
		System.out.println("ParentWindow  : " +ParentWindow);
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of Open WIndows  : " + winids.size());

		//Click on the link Login BUtton
		driver.findElement(By.xpath("//*[@title='LOGIN NOW']")).click();
		//now at this point to i have get the number of open windows 
		winids = driver.getWindowHandles();
		System.out.println("Number of Open WIndows  : " + winids.size());
		
		Iterator<String> itr= winids.iterator();
		//while(itr.hasNext())
		
		String mainwindowId  = itr.next();
		String subwindowId  = itr.next();
		System.out.println("ParentWindow  : " +mainwindowId);
		System.out.println("SubWindow  : " +subwindowId);
		//switch control to the subwindow
		driver.switchTo().window(subwindowId);
		
		Thread.sleep(3000);
		driver.findElement(By.name("User_Id")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.close(); //subwindows
		driver.switchTo().window(mainwindowId);
		driver.findElement(By.id("topMnuinsurance")).click();
		int isElementPresent = driver.findElements(By.id("topMnuinsurance")).size();
		
		for(String winid : winids){
			if(driver.getTitle().equals("")){
				driver.switchTo().window(winid);
				
					
				}
			}
			
		}
		
	}


