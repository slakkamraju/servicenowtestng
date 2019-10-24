package com.servicenow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.qa.base.TestBase;
import com.servicenow.qa.utilities.TestUtilities;

public class NeedItCreatePage extends TestBase {

	TestUtilities testUtil = null;
	
	@FindBy(xpath="//button[@id='x_407521_needit_needit.u_when_needed.ui_policy_sensitive' and @class='btn btn-default btn-ref date_time_trigger']")
	WebElement dataTimeButton;
	
	@FindBy(xpath="//td[text()='Go to Today']")
	WebElement todaysDate;
	
	@FindBy(xpath="//button[@id='GwtDateTimePicker_ok']")
	WebElement clickSelectedDate;
	
	public NeedItCreatePage () {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtilities();
	}
	public void selectDate() {
		testUtil.switchToFrame();
		System.out.println("In selectDate method");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataTimeButton.click();
		todaysDate.click();
		clickSelectedDate.click();;
	}
	public String getPageTitle() {
		return driver.getTitle();//"NeedIt|Raju Browser tab title"
	}
	
}
