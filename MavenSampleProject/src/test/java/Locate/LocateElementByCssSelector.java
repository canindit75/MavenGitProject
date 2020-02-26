package Locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByCssSelector {

		static WebDriver driver;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.calculator.net/calorie-calculator.html");
			//Identifying element by class - webtable
			//This is also an example of identifying elements by tagname
			// also extract cell values from WebTable
			
			WebElement table = driver.findElement(By.cssSelector(".cinfoT"));
			//for the above table , you have get all the rowa -
			List <WebElement> rows = table.findElements(By.tagName("tr"));
			for(WebElement row :rows){
				///get the columns or cells for each row - current row 
				List<WebElement> cols = row.findElements(By.tagName("td"));
				for(WebElement col : cols){
					//when you are trying to get the plaintext between opening tag and closing tag
					System.out.print(col.getText() + "\t");
				}
				System.out.println("");
				
				
			}
			
			System.out.println("Pattern match on attribute value of id with starts-with using xpath");
			List<WebElement> startswithcheight = driver.findElements(By.xpath("//*[starts-with(@id,'cheight')]"));
			for(WebElement e : startswithcheight){
				System.out.println(e.getAttribute("id"));
			}
			
			System.out.println("Pattern match on attribute value of name with contains using xpath");
			List<WebElement> containssex = driver.findElements(By.xpath("//*[contains(@name,'sex')]"));
			for(WebElement e : containssex){
				System.out.println(e.getAttribute("id"));
			}
			
			System.out.println("Pattern match on attribute value of id with starts with using css");
			List<WebElement> startswithccss = driver.findElements(By.cssSelector("[id^='c']"));
			for(WebElement e : startswithccss){
				System.out.println(e.getAttribute("id"));
			}
			
			System.out.println("Pattern match on attribute value of name with contains using css");
			List<WebElement> containsheightcss = driver.findElements(By.cssSelector("[name*='height']"));
			for(WebElement e : containsheightcss){
				System.out.println(e.getAttribute("id"));
			}
			

	}

}
