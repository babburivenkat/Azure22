package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboardpage extends Basepage {
	
	public Dashboardpage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='Customer Details']")
	WebElement welcometxt;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logout;
	
	public boolean checktext()
	{
		try
		{
		return (welcometxt.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	public void dpclicklogout()
	{
		logout.click();
	}

}
