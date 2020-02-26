package testngPack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsDemo {
	
	@Test
	public void testGoogleSearch()
	{ 
		System.getProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
		driver.get("http://google.in");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println("Before Assertion : " + expectedTitle + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("After Assertion " + expectedTitle + actualTitle + " Title Watched");		
	}	
}
