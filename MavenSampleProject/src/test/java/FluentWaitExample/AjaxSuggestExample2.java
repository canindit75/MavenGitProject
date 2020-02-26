package FluentWaitExample;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import com.google.common.base.Function;

public class AjaxSuggestExample2 {
	WebDriver driver;
	@Test
	public void AjaxExample(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("s");
        driver.manage().window().maximize();
        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul/li[1]")));
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
         
         List <WebElement> Listelement = wait.until(new Function<WebDriver, List<WebElement>>() {
         public List<WebElement> apply(WebDriver driver) {
         List <WebElement> Listelement = driver.findElements(By.xpath("//*[@role='listbox']/li"));
         if(Listelement.size() >0)
         {
            System.out.println("Ajax Suggestion List box is displayed");
            return Listelement;
         }
         else
         {
            System.out.println("Ajax Suggestion List box is not displayed");
        	return null;
          }
         }});
      //  List <WebElement> lst = driver.findElements(By.xpath("//*[@role='listbox']/li"));
      //  for(WebElement e : lst){
         for(WebElement e : Listelement){
        	System.out.println(e.getText());
        	
        	if(e.getText().equals("spark")){
        		System.out.println("spark found in the Ajax Suggestion List");
        		e.click();
        		break;
        	}else
        	{
        	//	System.out.println("spark not found in the Ajax Suggestion List");
        	}        		
        }
	}
}
