package testngPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Handle_drap_drop_frame {
	WebDriver driver;
	@Test
	public void FrameTest(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement); //switched control to the frame
		//Lets identify the drag and drop elements 
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		//I should drag the draggable element and drop on the droppable element
		//for this we will use mouse operations
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragElement, dropElement);
		actions.build();
		actions.perform();
		String verifydroppedMsg = dropElement.getText();
		if(verifydroppedMsg.equals("Dropped!")){
			System.out.println("Dropped Successfully");
		}
		else
		{
			System.out.println("Dropped was not Successfull");
		}
		
		
	}

}
