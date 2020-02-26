package testngPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JSInvoke_HandlingAlerts {
	String browser = "chrome";
	WebDriver driver;
	@Test
	public void HandlingAlertPopups() throws InterruptedException{
		try{
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//create an instance of chromeDriver - we are able to access the
		//methods and properties of the parent class and as well as the child class
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")){
		//pointing my class instance to interface
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		//Actually when do we go for WebDriver - Cross Browser - i have multiple browsers

		//but I want to only driver instance - i point to the interface because all theclasses implement the same interface
		driver.get("http://www.google.com");
		
		//i want to invoke javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('This is an information box');");
		//now to handle alert- first verify the alert message is correct, click on Ok button
		//Create an instance to alert and switch control alert
		//this is needed to perform any operation on the alert - retrieving alert msg , click on ok button
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Thread.sleep(2000);
		alert.accept(); //click on ok button
		//verify the alert message
		if(alertMsg.equals("This is an information box"))
			System.out.println("Alert Message Match found");
		else
			System.out.println("Alert Message Match Not found");
		
		js = (JavascriptExecutor)driver;
		String title = (String)js.executeScript("document.title");
		System.out.println("title : " + title);
		WebElement ageTextbox = (WebElement)js.executeScript("document.getElementById('cage');");
		js.executeScript("confirm('Do you want to continue(y/n)?');");
		alert = driver.switchTo().alert();
		alertMsg = alert.getText();
		Thread.sleep(2000);
		alert.dismiss(); //click on ok button
		//verify the alert message
		if(alertMsg.equals("This is an information box"))
			System.out.println("Alert Message Match found");
		else
			System.out.println("Alert Message Match Not found");
	}
	
	 catch(NoAlertPresentException e){
		 System.out.println("alert not present");
		 System.out.println(e.getLocalizedMessage());
		 e.printStackTrace();
	}

 }
}
