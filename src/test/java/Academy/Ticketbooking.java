package Academy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Flightbooking;

public class Ticketbooking extends Base {
	Flightbooking fb;
	WebDriver driver;

	@BeforeTest
	public void initialtest() throws IOException {
		driver = initializeDriver();
		String urlname1 = prop.getProperty("url1");
		driver.get(urlname1);
	}

	@Test
	public void onewaytrip() throws IOException, InterruptedException {

		fb = new Flightbooking(driver);
		fb.Country().sendKeys("ind");
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		// WebElement option
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}

		fb.Oneway().click();
		fb.Departurecity().click();
		fb.Depcityname().click();
		Thread.sleep(2000);
		fb.Arrivalcity().click();
		fb.Arrivalcityname().click();
		Thread.sleep(2000);
		fb.Departuredate().click();
		fb.Passengers().click();
		int i = 1;
		for (i = 1; i < 5; i++) {
			fb.Passengerno().click();
		}
		fb.Passengersbutton().click();
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");
		//fb.Search().click();

	}
	@Test
	public void twowayTrip()
	{
		fb.Roundtrip().click();
		fb.Date().click();
		while(!fb.Monthbox().getText().contains("May"))
		 {
			fb.Next().click();
		 }
		int date= driver.findElements(By.cssSelector("td[data-handler='selectDay']")).size();
		 for(int i=0;i<date;i++)
		 {
			String txt= driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if(txt.equalsIgnoreCase("20"))
			{
				
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();	
				break;
			}
		
	}
	
	}

}
