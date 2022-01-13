package Academy;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\MG\\eclipse-workspace\\E2Eproject\\src\\main\\java\\Academy\\data.properties");
		 
		//We dont hardcode the path instead we should generate dynamically
		 //System.getProperty("user.dir")
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
	//if we mention url name here for all test cases in different classes it will be same
	//so we mention url in test cases of respective classes whatever url it needs
		//String urlname=prop.getProperty("url");
		
	//if we are getting the value of a property we use .equals instead of ==
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MG\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		 //we dont mention url here. 
		// driver.get(urlname);
	}
	else if(browsername.equals("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\MG\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		// driver=new FirefoxDriver();
	}
	else if(browsername.equals("ie"))
	{
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
	}
	
	public String screenshotmethod(String TestCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destfile));
		return destfile;
	}

}
