package com.qa.salesforce.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.salesforce.base.TestBase;

public class LoginPage extends TestBase {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 username']") WebElement Username;
	
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 password']") WebElement Password;
	
	@FindBy(id="Login") WebElement Login;
	
	@FindBy(xpath="//img[@id='logo' and @class='standard_logo']") WebElement sfLogo;
	
	//initiating the page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public boolean validatesfLogo(){
		
		return sfLogo.isDisplayed();
				
	}
	
	public String getTitleofLaunchPage(){
		return driver.getTitle();
	}
	
	
	public LaunchPage validateLoginPage( String usn, String pswd){
		
		Username.sendKeys(usn);
		Password.sendKeys(pswd);
		return new LaunchPage();
				
	}
	
	
	
}
