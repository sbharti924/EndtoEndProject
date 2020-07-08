package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver; // so that it can be accessed by other classes
	public Properties prop;
	public WebDriver intializeDriver() throws IOException{
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\JavaProjects\\EndtoEndDemo\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName =prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver",
					"D:\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("firefox")){

			
			System.setProperty("webdriver.gecko.driver",
					"D:\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}

		else if(browserName.equalsIgnoreCase("InternetExplorer")){

			//System.setProperty("webdriver.gecko.driver",
					//"D:\\FirefoxDriver\\geckoriver.exe");
			driver = new InternetExplorerDriver(); 
		}
  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
  
  return driver;// so that this driver can be passed to test classes
		
	}
	
	public void getScreenshot(String testCaseName, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;   //this driver got life after driver information passed from listener to screenshot argument
		File source =ts.getScreenshotAs(OutputType.FILE);  //source is virtual location
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"; //user.dir gives current path to this project,reports creates a folder and testCaseName will let us know which method got failed
		FileUtils.copyFile(source, new File(destinationFile));        //to use FileUtils we have to add common io dependency
	}
	
}
