package com.caloriecalc.pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InquiryFormPOM {
	WebDriver driver;
	//Page object constructor to instantiate WebElements with pageFactory
	public InquiryFormPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
	}
	
	@FindBy(css = "body > form > table > tbody > tr:nth-child(1) > td > h3:nth-child(2) > i > span > span")
	WebElement textTitle;
	
	@FindBy(id = "fname")
	WebElement textboxFName;
	
	@FindBy(id = "lname")
	WebElement textboxLName;
	
	@FindBy(id = "emails")
	WebElement textboxEmail;
	
	@FindBy(id = "mobile")
	WebElement textboxMobile;
	
	@FindBy(name = "D6")
	WebElement dropdownTutionType;
	
	@FindBy(name = "D5")
	WebElement dropdownCity;
	
	@FindBy(name = "D4")
	WebElement dropdownLearningMode;
	
	@FindBy(css = "body > h3")
	WebElement textSuccessfulSubmit;
	
	@FindBy(id = "enqdetails")
	WebElement textBoxEnquiry;
	
	@FindBy(id = "Submit1")
	WebElement btnSubmit;
	
	
	//Test case 001 
	public void testCase001(Object fName,Object lName, Object email, Object mob) throws Exception {
		
		textboxFName.sendKeys(fName.toString());
		textboxLName.sendKeys(lName.toString());
		textboxEmail.sendKeys(email.toString());
		textboxMobile.sendKeys(mob.toString());
		Select selectTutionType = new Select(dropdownTutionType);
		selectTutionType.selectByValue("senglish");
		Select selectCity = new Select(dropdownCity);
		selectCity.selectByValue("pune");
		Select selectLearningMode = new Select(dropdownLearningMode);
		selectLearningMode.selectByValue("mercedes");
		textBoxEnquiry.sendKeys("abc");
		
		try {
			Thread.sleep(15000);
		}catch(InterruptedException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		if(!driver.getTitle().equals("Online Coaching Class Enquiry Form")) {
			throw new Exception("Invalid title");
		}
		
		if(!textTitle.getText().equals("Tuition Enquiry Details Form")) {
			throw new Exception("Invalid header text");
		}
		
		
		String sEnglish = selectTutionType.getFirstSelectedOption().getAttribute("value");
		Assert.assertEquals(sEnglish, "senglish");
		
		
		String cityPune = selectCity.getFirstSelectedOption().getAttribute("value");
		Assert.assertEquals(cityPune, "pune");
		
		
		String learningModeClassRoom = selectLearningMode.getFirstSelectedOption().getAttribute("value");
		Assert.assertEquals(learningModeClassRoom, "mercedes");
		
		btnSubmit.click();
		
		Alert submitAlert = driver.switchTo().alert();
		Assert.assertEquals(submitAlert.getText(),"Thank you for submitting the online coaching Class Enquiry");
		submitAlert.accept();
		
		String SuccessText = textSuccessfulSubmit.getText();
		Assert.assertEquals(SuccessText, "Our Counselor will contact you soon.");
	}
}
