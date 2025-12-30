package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class AccountCreationSuccessPage extends BaseClass {
	
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement accountCreatedText;
	
	@FindBy(css = "a.btn.btn-primary")
	WebElement continueBtn;
	
	public AccountCreationSuccessPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateSuccessMessage() throws Throwable
	{
		return action.isDisplayed(getDriver(), accountCreatedText);
	}
	
	public HomePage clickOnContinue() throws Throwable
	{
		action.click(getDriver(), continueBtn);
		return new HomePage();
	}

}
