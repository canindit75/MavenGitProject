package testngPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
//Solution to the Timeout issues in the new chromedriver v80
//https://stackoverflow.com/questions/60114639/timed-out-receiving-message-from-renderer-0-100-log-messages-using-chromedriver
public class CalorieCalcTest {
	
	@Test
	public void EnterCalorieDetails() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//findElement - id,name,class, getAttribute,getCSSValue
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear(); //clear the textbox
		ageTextbox.sendKeys("56"); //enter 56 in the ageTextbox

		List<WebElement> sexList =driver.findElements(By.name("csex"));
		//looping through the list of elements
		for(WebElement sexElement : sexList){
			System.out.println(sexElement.getAttribute("id") + "  " + sexElement.getAttribute("value"));
			//perform click on female and thats alos only if it is unselected
			if(sexElement.getAttribute("value").equals("f")){
				if(!sexElement.isSelected()){
					sexElement.click();
					break;
				}
			}
		}
	
		WebElement weightTextbox = driver.findElement(By.id("ckg"));
		weightTextbox.clear(); //clear the textbox
		weightTextbox.sendKeys("200"); //enter 56 in the ageTextbox
		Thread.sleep(3000);
		driver.close();
	}

}
