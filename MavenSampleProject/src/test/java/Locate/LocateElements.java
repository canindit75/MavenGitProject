package Locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocateElements {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//Locate elements by id
		WebElement ageElement = driver.findElement(By.id("cage"));
		ageElement.clear();
		ageElement.sendKeys("45");
		//Locate Eleements by name
		List<WebElement> sexList = driver.findElements(By.name("csex"));
		for(WebElement element : sexList){
			if(element.getAttribute("value").equals("f")){
				if(!element.isSelected())
				{
					element.click();
					break;
				}
			}
		}
		//Locate Elements by name
		WebElement weightElement = driver.findElement(By.name("cpound"));
		weightElement.clear();
		weightElement.sendKeys("200");
		//Locate Elements by tagname,classname
		WebElement table = driver.findElement(By.className("cinfoT"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row : rows){
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col : cols){
				System.out.print(col.getText() + "\t");
			}
			System.out.println("");
		}
		
		//Accessing dropdown 
		WebElement ActivityddElement = driver.findElement(By.id("cactivity"));
		Select dd = new Select(ActivityddElement);
		System.out.println("Default dropdown value : " +dd.getFirstSelectedOption().getText());
		dd.selectByIndex(1);
		Thread.sleep(2000);
		System.out.println("dropdown value by index 1 - Sedentry : " +dd.getFirstSelectedOption().getText());
		dd.selectByValue("1.375");
		Thread.sleep(2000);		
		System.out.println("dropdown value by value 1.375 - Light Exercise : " +dd.getFirstSelectedOption().getText());
		dd.selectByVisibleText("Very Active: intense exercise 6-7 times/week");
		Thread.sleep(2000);		
		System.out.println("dropdown value by value 1.725 - Very Active : " +dd.getFirstSelectedOption().getText());
		
		//Locate elements by xpath
		//Find Age Label 
		WebElement ageLabel = driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println(ageLabel.getText());
		
		WebElement ageLabel1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println(ageLabel1.getText());
		
		
	}
}
