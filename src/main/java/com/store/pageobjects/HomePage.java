package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement signInBtn;
	
	
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cartBtn;
	
	
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productsBtn;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement deleteAccountBtn;
	
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public SearchProductsPage clickOnProduct() throws Throwable
	{
		action.click(getDriver(), productsBtn);
		return new SearchProductsPage();
	}
	
	public ViewCartPage clickonCart() throws Throwable
	{
		action.click(getDriver(), cartBtn);
		return new ViewCartPage();
	}
	
	public LoginPage clickonLogOut() throws Throwable
	{
		action.click(getDriver(), logoutBtn);
		return new LoginPage();
	}
	
	public String getCurrURL()
	{
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
	
	public boolean validateSuccessfulLogin()
	{
		return action.isDisplayed(getDriver(), logoutBtn);
	}
}
