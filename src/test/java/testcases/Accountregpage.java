package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Regpage;
import testbase.Baseclass;

public class Accountregpage extends Baseclass {
	
	 
     
      
      @Test(groups= {"master", "regression"})
	public void test_account() throws InterruptedException
	{
    	  
    	  logger.debug("application logs");
    	  logger.info("**** Accountregpage started ***");
    	  try
    	  {
		Homepage hp=new Homepage(driver);
		hp.clicksignup();
		
		Regpage rp=new Regpage(driver);
		  logger.info("**** providing customer details***");
		rp.setfirstname(randomstring());
		rp.setsurname(randomstring());
		rp.setepost("1234");
		rp.setmobile("123456789");
		rp.setsurname(randomstring());
		rp.setusername(randomstring());
		String password=randomnumber();
		rp.setpassword(password);
		rp.setconfirmpassword(password);
		Thread.sleep(3000);
		rp.clicksubmit();
		  logger.info("**** clicked on submit ***");
		  logger.info("validating message");
		Assert.assertEquals(rp.checkessage(),"Registration Successful");
		
		System.out.println(rp.checkessage());
		
    	  }catch(Exception e)
    	  {
    		  logger.error("validation failed");
    		  Assert.fail();
    	  }
		
    	  logger.info("completed test");
		
	}
	
	

}
