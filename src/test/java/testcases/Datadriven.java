package testcases;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Dashboardpage;
import pageobjects.Homepage;
import pageobjects.Loginpagepb;
import testbase.Baseclass;
import utilities.DataProviders;

public class Datadriven extends Baseclass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	
	void test_Datadriver(String email, String pwd, String exp) throws InterruptedException
	{
		ResourceBundle.getBundle("config");
		logger.info("login test started");
	
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clicklogin();
		System.out.println("hi");
	    Loginpagepb lp=new Loginpagepb(driver);
	    lp.setusername(email);
	    lp.setpassword(pwd);
	   
	    lp.clickloginpb();
	    logger.info("clicked on login");
	    Thread.sleep(2000);
	    Dashboardpage dp=new Dashboardpage(driver);
	  boolean target= dp.checktext();
	    System.out.println(dp.checktext());
	     Assert.assertEquals(dp.checktext(), true);
		
		
		if(exp.equals("Valid"))
		{
			if(target==true)
			{
				dp.dpclicklogout();
				Assert.assertTrue(true);
			}
		}
		else
		{
			Assert.assertTrue(false);
		}
		

		if(exp.equals("Invalid"))
		{
			if(target==true)
			{
				dp.dpclicklogout();
				Assert.assertTrue(false);
			}
		}
		else
		{
			Assert.assertTrue(true);
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
			
	}

}
