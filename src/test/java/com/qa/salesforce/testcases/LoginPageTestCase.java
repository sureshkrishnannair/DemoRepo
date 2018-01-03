package com.qa.salesforce.testcases;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.salesforce.base.TestBase;
import com.qa.salesforce.pages.LaunchPage;
import com.qa.salesforce.pages.LoginPage;

public class LoginPageTestCase extends TestBase{
	LoginPage loginpage;
	WebDriver driver;
	Properties prop;
	LaunchPage launchpage;
	
	
	public LoginPageTestCase(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void ValidateLogoTest(){
		boolean flag=loginpage.validatesfLogo();
		Assert.assertTrue(flag);		
	}
	
	/*@Test
	public void ValidateTitle(){
		
		String Title=loginpage.getTitleofLaunchPage();
		Assert.assertEquals(Title, "Login | Salesforce");
	}*/
	
	
	@Test(priority=2)
	public void validateLoginTest(){
		launchpage=loginpage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
		public void TearDown(){
		
		driver.close();
			
		}
	}


