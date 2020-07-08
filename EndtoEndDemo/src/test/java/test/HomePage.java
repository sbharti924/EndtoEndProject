package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogIn;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver; //when to made changes in pom by segregating every test in parallel then all test will take driver from base class simultaneously which will overwrite other tests driver so we have to create local driver so that overriding wont happen.now driver in line 20 is that local driver
    @BeforeTest
    public void intialize() throws IOException{
    	driver=intializeDriver();    //this driver gets life as intializeDriver has returned driver and that driver we are using here
		
    }
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException{
		
		driver.get(prop.getProperty("url"));// we have to keep this inside test bcoz if we we will keep in before test,url opens only once but we need to invoke url two times as we have to pass two user name and passwords
		// two methods to call inheritance and other is create object of class
		LandingPage l = new LandingPage(driver);// to give driver here we have to add constructor in landing page 
		l.getLogin().click();
		LogIn lp = new LogIn(driver);
		lp.getemail().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		lp.getlogin().click();
		}
		
	
	@AfterTest
	public void teardown(){
	driver.close();
	}
		
		@DataProvider
		public Object[][] getData(){
			// Row stands for how many different data types test should run
			//coloumn stands for how many values per each test
			
			// Array size is 2
			// 0,1
			Object[][] data=new Object[2][2];   //first 2 represents two users and second 2 represents how many times data needs to be entered for first user
			//0th row
			data[0][0]="nonrestricteduser@qw.com";
			data[0][1]="123456";
			
			//1st row
			data[1][0]="restricteduser@qw.com";
			data[1][1]="456788";
			
			
			return data;
			
			
			
			
			
			
		}
		
		
	

	
	
	
	
}
