package Launch;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//Tested Working OK - Tested on Firefox 37 - Selenium Java 2.53 + JDK 1.7 
//Tested Does not Work with Firefox 53.0.3 64 bit + Selenium Java 3.14.0 + JDK 1.8
public class FirefoxDriver37Demo {	
	
	public static void main(String[] args) {
		WebDriver driver;		
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		driver = new FirefoxDriver(cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
}