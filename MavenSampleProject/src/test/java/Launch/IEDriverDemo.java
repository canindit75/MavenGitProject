package Launch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//Tested - Working - Had change the Zoom Level from 150 to 100 Manually to make it work
public class IEDriverDemo {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		String baseURL = "http://www.google.com";		
		driver.get(baseURL);


	}

}
