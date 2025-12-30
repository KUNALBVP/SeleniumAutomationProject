package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class PaymentPage extends BaseClass {

	
	@FindBy(xpath = "//input[@name='name_on_card']")
	WebElement nameCardBox;
	
	
	@FindBy(xpath = "//input[@name='card_number']")
	WebElement cardNumberBox;
	
	
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement cvcBox;
	
	
	@FindBy(xpath = "//input[@name='expiry_month']")
	WebElement monthExpiryBox;
	
	@FindBy(xpath = "//input[@name='expiry_year']")
	WebElement yearExpiryBox;
	
	
	@FindBy(id = "submit")
	WebElement payBtn;
	
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public OrderConfirmationPage fillCardDetailsAndPay(String name, String cardNumber, String cvc, String month, String year) throws Throwable
	{
		action.type(nameCardBox, name);
		action.type(cardNumberBox, cardNumber);
		action.type(cvcBox, cvc);
		action.type(monthExpiryBox, month);
		action.type(yearExpiryBox, year);
		action.scrollByVisibilityOfElement(getDriver(), payBtn);
		action.click(getDriver(), payBtn);
		return new OrderConfirmationPage();
	}
	
}
