package com.qa.salesforce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.salesforce.utility.TestUtil;

public class TestBase 
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	//
	public TestBase()
	{
		
	try{
		prop=new Properties();
		FileInputStream ip=new FileInputStream(
				"C:\\Users\\suresh\\workspace\\salesforce_P1"
				+"\\src\\main\\java\\com\\qa\\salesforce\\config\\config.properties");
	} catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
		
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		/*if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Suresh\\SeleniumCore\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}*/
		
		if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",new File("C:\\Suresh\\SeleniumCore\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe").getAbsolutePath());
			driver=new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}



	
	
	
	
	
	
	
	


