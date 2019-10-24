package com.servicenow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.qa.base.TestBase;


public class LoginPage extends TestBase{

	//Page Factory or Object Repository(OR)
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(id="sysverb_login")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot Password ?")
	WebElement forgotPassword;
	
	//@FindBy(xpath="//img[@id='mainBannerImage16']")
	@FindBy(xpath="//a[@data-original-title = 'ServiceNow Home Page']")
	WebElement servicenowLogo;

	//Initializing the page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateServicenowImage() {
		return servicenowLogo.isDisplayed();
		
	}
	public HomePage login(String un, String pwd) {
		//driver.switchTo().frame("gsft_main");
		driver.switchTo().frame(0);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();

		//driver.switchTo().defaultContent();
		return new HomePage();
	}

}
