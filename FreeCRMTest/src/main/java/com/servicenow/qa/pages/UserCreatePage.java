package com.servicenow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.utilities.TestUtilities;

public class UserCreatePage extends TestBase{

	TestUtilities testUtil = null;

	@FindBy(xpath="//button[@id='sysverb_new']")
	WebElement newButton;

	@FindBy(id="sys_user.user_name")
	WebElement userID;

	@FindBy(id="sys_user.first_name")
	WebElement firstName;

	@FindBy(id="sys_user.last_name")
	WebElement lastName;

	@FindBy(id="sys_user.title")
	WebElement userTitle;

	@FindBy(id="sys_display.sys_user.department")
	WebElement userDepartment;

	@FindBy(id="sys_display.sys_user.manager")
	WebElement userManager;

	@FindBy(id="sys_user.user_password")
	WebElement userPassword;

	@FindBy(id="sys_user.email")
	WebElement userEmail;

	@FindBy(id="sysverb_insert")
	WebElement submitButton;

	public UserCreatePage () {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtilities();
		testUtil.switchToFrame();
	}
	public void clickNewButton() {


		//System.out.println("In selectDate method");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void createUser(String uID,String fn,String ln, String ut,String ud,String um,String up,String ue) {		
		clickNewButton();
		userID.sendKeys(uID);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		userTitle.sendKeys(ut);
		userDepartment.sendKeys(ud);
		userManager.sendKeys(um);
		userPassword.sendKeys(up);
		userEmail.sendKeys(ue);
		submitButton.click();
	}
	public void clickSubmitButton() {

	
		submitButton.click();

	}
}
