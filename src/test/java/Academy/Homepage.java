package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;

public class Homepage extends Base
{  
	public WebDriver driver;
	@BeforeTest
	public void firstexecution() throws IOException
	{
		//initializeDriver();
				//or
				driver=initializeDriver();
				//we are not supposed to hardcode the website this should be global value
				//driver.get("http://www.qaclickacademy.com");
				
				//driver.get(prop.getProperty("url"));
	}
	
	
	
	@Test(dataProvider="getdata")
	public void basePageNavigation(String username, String password) throws IOException
	{
		 
		//driver=initializeDriver();
		
	String urlname=prop.getProperty("url");
		driver.get(urlname);
		
		
		
		
		Landingpage lp=new Landingpage(driver);
		lp.Login().click();
		Loginpage lp1=new Loginpage(driver);
		
	//we are not supposed to hardcode the values so we parameterize the data
	//we use data provider annoation, we provide both parameterization and data providing using testng dataprovider annotation
	//Dataprovider annotation is used when we have multiple data sets to run for a test case ie lot of usernames, pswds etc
		
		
		
		
		lp1.Email().sendKeys(username);
		lp1.Password().sendKeys(password);
		lp1.Submitbutton().click();
		
		
	
	
	}
	@AfterTest
	public void closewindow()
	{
		driver.close();
	}

	
		@DataProvider 
		public Object[][] getdata()
		{
			//Array[][] ar=new Array[][];
			Object[][] ob=new Object[2][2];
			ob[0][0]="ram@gmail.com";
			ob[0][1]="ram1";
			ob[1][0]="arjun@gmail.com";
			ob[1][1]="arjun1";
			return ob;
			
			
					
		}
		
		
		
	}
	


