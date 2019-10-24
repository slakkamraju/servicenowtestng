package com.servicenow.qa.testcases;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.pages.HomePage;
import com.servicenow.qa.pages.LoginPage;
import com.servicenow.qa.pages.NeedItCreatePage;
import com.servicenow.qa.pages.UserCreatePage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	NeedItCreatePage needitCreatePage = null;
	UserCreatePage userCreatePage = null;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		needitCreatePage = new NeedItCreatePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
//	@Test(priority=1)
//	public void validateUserName() {
//		String un = homePage.getUserLabel();
//		System.out.println("User Name: " + un);
//		Assert.assertEquals(un, "System Administrator", "User Name not matched");
//	}
//	@Test(priority=2)
//	public void validateApplicationPicker() {
//		homePage.setApplicationScope("Needit");
//		String applicationScope = homePage.getApplicationScope();
//		System.out.println("Application Scope: " + applicationScope);
//		Assert.assertEquals(applicationScope, "Needit", "Application Scope not matched");
//	}
//	@Test(priority=3)
//	public void validateUpdateSetPicker() {
//		String updateSetPickerValue = homePage.getApplicationScope();
//		System.out.println("Update Set Value: " + updateSetPickerValue);
//		Assert.assertEquals(updateSetPickerValue, "Needit", "Update Set Picker Value not matched");
//	}
//	@Test(priority=4)
//	public void verifyToggleHelpSidebar() throws InterruptedException {
//		boolean bStatus = homePage.verifyVisibilityOfAddHelpArticle();
//		System.out.println("Visibility of Add Help Article Button: " + bStatus);
//		Assert.assertTrue(bStatus);
//	}
//	@Test(priority=5)
//	public void verifyNeeditLinkTest(){
//		needitCreatePage = homePage.createNeeit();
//	}
	@Test(priority=6)
	public void verifyCreateUserLink(){
		userCreatePage = homePage.selectUsersCreateLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout)
			.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
