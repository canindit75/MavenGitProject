package testngPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class HandlePopups {
	WebDriver driver;
	@Test
	public void AlertHandling() throws InterruptedException{
		Alert alert = null;
		JavascriptExecutor js =null;
		String alertMsg=null;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.calculator.net/calorie-calculator.html");
	//	driver.get(PropertyReader.getProperty("appurl"));
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();

		//first invoke an information Alert information
		//we have an interface named JavaScriptExecutor which exposes the method executeScript
		//which is used for executing javascript - you pass the script as an argument
		try{
		js = (JavascriptExecutor)driver;
		//js.executeScript("alert('This is an information alert message');");
		//How to handle the alert
		
		alert = driver.switchTo().alert(); ///control switched to alert
		alertMsg = alert.getText(); //alert Message
		Thread.sleep(3000);
		alert.accept(); //Click on OK
		if(alertMsg.equals("This is an information alert message"))
			System.out.println("Alert Message Match found");
		else 
			System.out.println("Alert Message does not match");
		
		}catch(NoAlertPresentException e){
			System.out.println("No Alert Present ");
		}
		js.executeScript("confirm('Do you want to continue(y/n)?');");
		alert = driver.switchTo().alert();
		alertMsg = alert.getText(); //alert Message
		Thread.sleep(3000);
		alert.dismiss();; //Click on Cancel
		if(alertMsg.equals("This is an information alert message"))
			System.out.println("Alert Message Match found");
		else 
			System.out.println("Alert Message does not match");
		
	}

}
