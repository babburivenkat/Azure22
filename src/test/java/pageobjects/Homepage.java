package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	
	public void clicksignup()
	{
		signup.click();
	}
	
	public void clicklogin()
	{
		login.click();
	}
	
	

}
