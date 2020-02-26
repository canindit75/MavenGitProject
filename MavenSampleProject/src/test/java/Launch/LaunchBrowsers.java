package Launch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Tested Working OK
public class LaunchBrowsers {
	static WebDriver driver;
public static void main(String args[]) throws InterruptedException{	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	
	//driver = new ChromeDriver();
	driver = new ChromeDriver(options);
	driver.get("https://seltraining-dev-ed.my.salesforce.com");
	WebElement userNameTextbox = driver.findElement(By.id("username"));
	WebElement pwdTextbox = driver.findElement(By.id("password")); 
	WebElement loginBtn = driver.findElement(By.id("Login"));
	userNameTextbox.sendKeys("selenium@training.com");
	pwdTextbox.sendKeys("salesforce123");
	loginBtn.click();
	WebDriverWait wait = new WebDriverWait(driver,60);
	//Click on the Link	after logging in	 
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uiImage")));	
	driver.findElement(By.className("uiImage")).click();
	//Thread.sleep(2000);
	//Click on Log Out link
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out")));
	driver.findElement(By.linkText("Log Out")).click();
}
}
