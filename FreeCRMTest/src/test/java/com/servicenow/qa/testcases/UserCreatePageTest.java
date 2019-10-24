package com.servicenow.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.pages.HomePage;
import com.servicenow.qa.pages.LoginPage;
import com.servicenow.qa.pages.UserCreatePage;
import com.servicenow.qa.utilities.TestUtilities;

public class UserCreatePageTest extends TestBase {

	LoginPage loginPage = null;
	HomePage homePage = null;
	UserCreatePage userCreatePage = null;
	String sheetName = "Sheet1";

	
	public UserCreatePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		//usercreatePage = new UserCreatePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		userCreatePage = homePage.selectUsersCreateLink();

	}
//	@Test(priority=1, dataProvider="getSNData")
//	public void createUser(String uid,String fname,String lname,String utitle,String uDepartment,String uManager, String uPassword,String uEmail) {
//		userCreatePage.createUser(uid, fname, lname, utitle, uDepartment, uManager, uPassword, uEmail);
//	}
	@DataProvider
	public Object[][] getSNData() {
		Object data[][] = TestUtilities.getTestData(sheetName);
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
