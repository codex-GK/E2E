package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;

public class Validatetitle extends Base {
	public WebDriver driver;
	Landingpage lp;

	@BeforeTest
	public void firstexecution() throws IOException {
		// initializeDriver();
		// or
		driver = initializeDriver();
		String urlname = prop.getProperty("url");
		driver.get(urlname);
	}

	@Test()
	public void titlevalidation() throws IOException {

		lp = new Landingpage(driver);

		Assert.assertEquals(lp.Title().getText(), "FEATUREDCOURSES");

	}

	@Test
	public void pageTitleValidation() throws IOException {

		lp = new Landingpage(driver);

		Assert.assertEquals(lp.Pagetitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

	}

	@AfterTest
	public void closewindow() {
		driver.close();
	}

}
