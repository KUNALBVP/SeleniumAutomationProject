package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(css = "a.btn.btn-primary")
	WebElement continueBtn;
	
	@FindBy(css = "a.btn.btn-default.btn.btn-default.check_out")
	WebElement downloadInvoiceBtn;
	
	@FindBy(xpath = "//b[normalize-space()='Order Placed!']")
	WebElement orderPlacedMessage;
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations!')]")
	WebElement congratulationsMessage;
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderPlaced() throws Throwable
	{
		return action.isDisplayed(getDriver(), orderPlacedMessage);
	}
	
	public boolean validateCongratsMessage() throws Throwable
	{
		return action.isDisplayed(getDriver(), congratulationsMessage);
	}
	
	public HomePage clickOnContinue() throws Throwable
	{
		action.click(getDriver(), continueBtn);
		return new HomePage();
	}

}
