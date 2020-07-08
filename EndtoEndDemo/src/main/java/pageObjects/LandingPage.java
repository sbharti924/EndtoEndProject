package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	
	//for page object model best practice is to have objects first and followed by methods
	
	public WebDriver driver;
	By signin= By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navigation= By.linkText("CONTACT");
	
	
	public LandingPage(WebDriver driver) {   // this driver has life got from homepage driver
	 this.driver = driver;    //rhs driver gave life to lhs driver
	}

	public WebElement getLogin(){
		
		return driver.findElement(signin);
	}
	
   public WebElement gettitle(){
		
		return driver.findElement(title);
	}
   public WebElement getnavigation(){
		
		return driver.findElement(navigation);
	}
	
}
