package com.servicenow.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.pages.HomePage;
import com.servicenow.qa.pages.LoginPage;
import com.servicenow.qa.pages.NeedItCreatePage;

public class NeedItCreatePageTest extends TestBase {

	LoginPage loginPage = null;
	HomePage homePage = null;
	NeedItCreatePage needitCreatePage = null;

	
	public NeedItCreatePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		needitCreatePage = new NeedItCreatePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		needitCreatePage = homePage.createNeeit();

	}
	@Test
	public void setDate() {
		needitCreatePage.selectDate();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
