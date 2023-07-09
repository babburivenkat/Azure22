package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpagepb extends Basepage {
	
	public Loginpagepb(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginpb;
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickloginpb()
	{
		loginpb.click();;
	}
	

}
