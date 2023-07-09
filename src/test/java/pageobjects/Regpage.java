package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Regpage extends Basepage {
	
	
	
	public Regpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='Surname']")
	WebElement surname;
	
	@FindBy(xpath="//input[@id='E_post']")
	WebElement epost;
	
	@FindBy(xpath="//input[@id='Mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@id='submit']")
	WebElement submit;
	
	@FindBy(xpath="//label[@class='label-success']")
	
	WebElement checkmsg;
	
	public void setfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setsurname(String sname)
	{
		surname.sendKeys(sname);
	}
	
	public void setepost(String post)
	{
		epost.sendKeys(post);
	}
	
	public void setmobile(String mob)
	{
		mobile.sendKeys(mob);
	}
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String conpwd)
	{
		confirmpassword.sendKeys(conpwd);
	}
	
	public void clicksubmit()
	{
		submit.click();
	}
	
	
	public String checkessage()
	{
		try
		{
		return (checkmsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	

}
