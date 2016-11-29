package testProject;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Keywords extends ObjectRepository  {
	WebDriver driver = new FirefoxDriver();
	
	
	public  void launchBrowser(String url){
		driver.get(url);
		driver.manage().window().maximize();
	}
	public String getTitle(){
		return driver.getTitle();
	}
	public void click(String xpath){

		waitforElement(xpath).click();
	}
	public void quitDriver(){
		driver.quit();
		
	}
	public void filltextbox(String xpath,String value) {
		waitforElement(xpath).sendKeys(value);
		
	}
	public String  getText(String xpath) {
		
		return waitforElement(xpath).getText();
		
	}

	public String generateEmailID(){
		
		String emailId;
		emailId = randomString(8)+"@"+randomString(5)+"."+RandomStringUtils.randomAlphabetic(3).toLowerCase();
			
		return emailId;
			
		
	}
	public String randomString(int x){
		String random;
		random = UUID.randomUUID().toString().replaceAll("-", "").subSequence(0, x).toString();
		return random;
	}
	public  WebElement waitforElement(String xpath){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;
	}
}
