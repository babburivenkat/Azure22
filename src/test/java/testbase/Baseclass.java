package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass(groups= {"master", "regression", "sanity"})
	@Parameters("browser")
	
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());
		
		//driver=new EdgeDriver();
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://itera-qa.azurewebsites.net/home");
		driver.get(rb.getString("Appurl"));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups= {"master", "regression", "sanity"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomstring()
	{
		String randstring=RandomStringUtils.randomAlphabetic(5);
		
		return (randstring);
	}
	
	public String randomnumber()
	{
		String randnum=RandomStringUtils.randomNumeric(5);
		return (randnum);
	}
	
	public String alphanumeric()
	{
		String num=RandomStringUtils.randomNumeric(5);
		String str=RandomStringUtils.randomAlphabetic(5);
		return (num+str);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
