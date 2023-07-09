package testcases;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Dashboardpage;
import pageobjects.Homepage;
import pageobjects.Loginpagepb;
import testbase.Baseclass;

public class Loginpage extends Baseclass {
	
	public ResourceBundle rb;
	
	
	@Test(groups= {"master", "sanity"})
	void test_loginpage() throws InterruptedException
	{
		
		ResourceBundle.getBundle("config");
		logger.info("login test started");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clicklogin();
		System.out.println("hi");
	    Loginpagepb lp=new Loginpagepb(driver);
	    lp.setusername("maheshgoud");
	    lp.setpassword("123456");
	   
	    lp.clickloginpb();
	    logger.info("clicked on login");
	    Thread.sleep(2000);
	    Dashboardpage dp=new Dashboardpage(driver);
	    System.out.println(dp.checktext());
	     Assert.assertEquals(dp.checktext(), true);
	     
	    
	     logger.info("login test finished");
	    
		}catch(Exception e)
		{
			Assert.fail();
			System.out.println("enter catched loop");
		}
		
		
	}
	

}
