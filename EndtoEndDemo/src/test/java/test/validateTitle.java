package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogIn;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	@BeforeTest
    public void intialize() throws IOException{
    	driver=intializeDriver();    //this driver gets life as intializeDriver has returned driver and that driver we are using here
		driver.get(prop.getProperty("url"));
		// two methods to call inheritance and other is create object of class
    }
	
    @Test
	public void validateTitlee() throws IOException{
		
		LandingPage l = new LandingPage(driver);// to give driver here we have to add constructor in landing page 
		//compare the values by using assert
		//l.gettitle().getText();
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES123");}
		
		@AfterTest
		public void teardown(){
		driver.close();
		}
	

	
	
	
	
}
