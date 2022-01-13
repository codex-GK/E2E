package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage 
{
	public WebDriver driver;

	
	public Landingpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@href='https://rahulshettyacademy.com/sign_in/']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	WebElement title;
	
	@FindBy(css="div[class*='video-banner'] h3")
	WebElement pagetitle;

	public WebElement Login()
	{
		return login;
	}

	public WebElement Title()
	{
		return title;
	}
	public WebElement Pagetitle()
	{
		return pagetitle;
	}

}
