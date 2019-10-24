package com.servicenow.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.servicenow.qa.base.TestBase;

public class HomePage extends TestBase {

	//
	@FindBy(xpath="//span[@class='user-name hidden-xs hidden-sm hidden-md']")
	WebElement userNameLabel;

	//Select
	@FindBy(id="application_picker_select")
	WebElement applicationPicker;

	//button
	@FindBy(id="nav-settings-button")
	WebElement settings;

	//Select
	@FindBy(id="update_set_picker_select")
	WebElement updateSetPicker;

	//button
	// //button[@data-original-title='Toggle Help Sidebar' or @aria-label='Toggle Help Sidebar']
	@FindBy(xpath="//button[@data-original-title='Toggle Help Sidebar' or @aria-label='Toggle Help Sidebar']")
	WebElement toggleHelpSidebar;

	//button
	@FindBy(xpath="//button[@aria-label='Add Help Article']")
	WebElement addHelpArticle;

	//aside
	@FindBy(xpath="//aside[@class='navpage-right']")
	WebElement help;

	//button
	@FindBy(id="connect_toggle_sidebar_header_button")
	WebElement toggleConnectSidebar;

	//Input
	@FindBy(id="sysparm_search")
	WebElement globalSearch;
	
	@FindBy(xpath="//span[contains(text(),'Needit - Create New')]")
	WebElement createNeedIT;
	
	@FindBy(xpath="//span[contains(text(),'User Administration - Users')]")
	WebElement createUser;

	//Initializing the page objects
	public HomePage(){

		PageFactory.initElements(driver, this);
	}
	//Actions
	public String getUserLabel() {
		return userNameLabel.getText();
	}
	public void setApplicationScope(String scope){

		Select select = new Select(applicationPicker);
		select.selectByVisibleText(scope);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getApplicationScope() {

		Select select = new Select(applicationPicker);
		return select.getFirstSelectedOption().getText();
	}
	public String getUpdateSetPickerValue() {

		Select select = new Select(updateSetPicker);
		return select.getFirstSelectedOption().getText();
	}
	public void clickOnToggleHelpSidebar(){	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(help.isDisplayed())
			toggleHelpSidebar.click();
		//		clickOn(driver,toggleHelpSidebar,10);

	}
	public boolean visibilityOfAddHelpArticleText() {	

		return addHelpArticle.isDisplayed();

	}
	public boolean verifyVisibilityOfAddHelpArticle() {
		clickOnToggleHelpSidebar();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addHelpArticle.isDisplayed();
	}
	public NeedItCreatePage createNeeit() {
		createNeedIT.click();
		return new NeedItCreatePage();
	}
	public UserCreatePage selectUsersCreateLink() {
		createUser.click();
		return new UserCreatePage();
	}
	//It can click on any element
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
