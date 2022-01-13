package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flightbooking
{
	public WebDriver driver;
	
	@FindBy(id="autosuggest")
	WebElement country;
	
	@FindBy(id="ctl00_mainContent_rbtnl_Trip_0")
	WebElement oneway;
	
	@FindBy(id="ctl00_mainContent_rbtnl_Trip_1")
	WebElement roundtrip;
	
	@FindBy(id="ctl00_mainContent_view_date2")
	WebElement date;
	
	@FindBy(css="div[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right'] span[class='ui-icon ui-icon-circle-triangle-e']")
	WebElement next;
		
	@FindBy(css="div[class='ui-datepicker-group ui-datepicker-group-last'] div[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']")
	WebElement monthbox;
	
	@FindBy(css="td[data-handler='selectDay']")
	WebElement returnday;
		
	@FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement departurecity;
	
	@FindBy(linkText="Bengaluru (BLR)")
	WebElement depcityname;
	
	@FindBy(id="ctl00_mainContent_ddl_destinationStation1_CTXT")
	WebElement arrivalcity;
	
	@FindBy(linkText="Vijayawada (VGA)")
	WebElement arrivalcityname;
	
	@FindBy(css=".ui-state-default.ui-state-highlight")
	WebElement departuredate;
	
	@FindBy(id="divpaxinfo")
	WebElement passengers;
	
	@FindBy(id="hrefIncAdt")
	WebElement passengerno;
	
	@FindBy(id="btnclosepaxoption")
	WebElement passengersbutton;
	
	
	
	
	
	@FindBy(id="ctl00_mainContent_btn_FindFlights")
	WebElement search;
	
	public Flightbooking(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement Country()
	{
		return country;
	}
	public WebElement Oneway()
	{
		return oneway;
	}
	public WebElement Roundtrip()
	{
		return roundtrip;
	}
	public WebElement Date()
	{
		return date;
	}
	public WebElement Next()
	{
		return next;
	}
	public WebElement Monthbox()
	{
		return monthbox;
	}
	public WebElement Returnday()
	{
		return returnday;
	}
	
	public WebElement Departurecity()
	{
		return departurecity;
	}
	public WebElement Depcityname()
	{
		return depcityname;
	}
	public WebElement Arrivalcity()
	{
		return arrivalcity;
	}
	public WebElement Arrivalcityname()
	{
		return arrivalcityname;
	}
	
	public WebElement Departuredate()
	{
		return departuredate;
	}
	public WebElement Passengers()
	{
		return passengers;
	}
	public WebElement Passengerno()
	{
		return passengerno;
	}
	public WebElement Passengersbutton()
	{
		return passengersbutton;
	}
	
	public WebElement Search()
	{
		return search;
	}
	
	
	

}
