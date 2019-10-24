package com.servicenow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.pages.HomePage;
import com.servicenow.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
		//System.out.println("LoginPageTest Constructor");
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Raju Browser tab title");
	}
	@Test(priority=2)
	public void servicenowLogoImageTest() {
		
		boolean imgFlag = loginPage.validateServicenowImage();
		Assert.assertTrue(imgFlag);
	}
	@Test(priority=3)
	public void loginTest() {

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
