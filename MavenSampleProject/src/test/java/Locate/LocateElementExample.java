package Locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementExample {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.calculator.net/calorie-calculator.html");
		//Identifying element age textbox by id locator strategy
		//findElement will return one WebElement
		WebElement ageTextBox = driver.findElement(By.xpath("//*[@id='cage']"));
		System.out.println("Value of ID attribute before clear: " + ageTextBox.getAttribute("value"));
		//clear the ageTextBox
		ageTextBox.clear();
		System.out.println("Value of ID attribute after clearing : " + ageTextBox.getAttribute("value"));
		//If i dont clear it will append so I need to clear
		ageTextBox.sendKeys("45"); //Input 45 as age into age TextboX
		//retrieve the values of ageTextBox --- id, name, value, class
		System.out.println("Value of ID attribute : " + ageTextBox.getAttribute("id"));
		System.out.println("Value of name attribute : " + ageTextBox.getAttribute("name"));
		System.out.println("Value of value attribute after entering data as 45 : " + ageTextBox.getAttribute("value"));
		
		//Identifying element  by name locator - for sex - if you use findElement
		//it only returns one webelment - it will always point to the first element
		//now in case, I point to the second element - i have to use the method findElements which returns a list of elements
		WebElement GenderElement = driver.findElement(By.xpath("//*[@name='csex']"));
		System.out.println("Gender Value : " + GenderElement.getAttribute("value"));
		List <WebElement> GenderList = driver.findElements(By.name("csex"));
		System.out.println(GenderList.size()); //The number of WebElements with name='csex'
		for(WebElement Gender : GenderList){
			if(Gender.getAttribute("value").equals("f"))
				if(!Gender.isSelected()){
				    Gender.click();
				    System.out.println("Female will be selected");
				    break;
				}
			
		}
		
		/*male -- first webelement of type name = csex
				female -- second webelement of type name=csex

				findElements method returns a list of WebElement
				List<WebElement>sexList=driver.findElements(By.name("csex"));

				for(WebElement SexElement : sexList){

				if(!SexElement.IsSelected) //Performing a check -- is the element already selected or not --> if it is not selected then I will perform a click operation

				! --> Not Selected ---> 
				    SexElement.click();
*/
		
		
		
		
		
		
	}

}
