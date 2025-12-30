package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.base.BaseClass;

public class ViewCartPage extends BaseClass {
	
	@FindBy(xpath = "//td[@class='cart_price']/p")
	WebElement cartPrice;
	
	@FindBy(xpath = "//td[@class='cart_total']/p")
	WebElement cartTotal;
	
	@FindBy(linkText = "Proceed To Checkout")
	WebElement checkoutBtn;
	
	public ViewCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCartPriceEqualsTotal() throws Throwable {

	    String priceText = cartPrice.getText();
	    String totalText = cartTotal.getText();

	    // Remove currency and spaces (Rs. 1500 -> 1500)
	    int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
	    int total = Integer.parseInt(totalText.replaceAll("[^0-9]", ""));

	    return price == total;
	}
	
	public OrderPage clickonCheckOut() throws Throwable
	{
		action.click(getDriver(), checkoutBtn);
		return new OrderPage();
	}
}
