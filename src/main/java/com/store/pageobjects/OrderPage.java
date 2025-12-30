package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class OrderPage extends BaseClass {
	
	
	@FindBy(css = "a.check_out")
	WebElement placeOrderBtn;
	
	
	@FindBy(xpath = "//td[@class='cart_total']/p")
	WebElement priceTotal;
	
	@FindBy(xpath = "//tr[2]/td[4]/p[1]")
	WebElement amountTotal;
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	
	public boolean validateOrderTotal() throws Throwable
	{
		String priceText = priceTotal.getText();
	    String amountText = amountTotal.getText();

	    // Remove currency and spaces (Rs. 1500 -> 1500)
	    int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
	    int amount = Integer.parseInt(amountText.replaceAll("[^0-9]", ""));

	    return price == amount;
	}
	
	public PaymentPage clickOnPlaceOrder() throws Throwable
	{
		action.scrollByVisibilityOfElement(getDriver(), placeOrderBtn);
		action.click(getDriver(), placeOrderBtn);
		return new PaymentPage();
	}
}
