package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	public WebDriver driver;
	
	public Loginpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(xpath="//input[@value='Log In']")
	WebElement submitbutton;
	
	
	public WebElement Email()
	{
		return email;
	}
	public WebElement Password()
	{
		return password;
	}
	public WebElement Submitbutton()
	{
		return submitbutton;
	}
	
	

}
