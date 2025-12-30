package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement signInBtn;
	
	
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cartBtn;
	
	
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productsBtn;
	
	@FindBy(xpath = "//a[text()=' Home']")
	WebElement homeBtn;
	
	@FindBy(xpath = "//div[@class='logo pull-left']/a/img")
	WebElement myStoreLogo;
	
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable
	{
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean ValidateLogo() throws Throwable
	{
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getStoreTitle()
	{
		String storeTitle = getDriver().getTitle();
		return storeTitle;
	}
	
	public ViewCartPage clickOnCart() throws Throwable
	{
		action.click(getDriver(), cartBtn);
		return new ViewCartPage();
	}
	
	public SearchProductsPage clickOnProducts() throws Throwable
	{
		action.click(getDriver(), productsBtn);
		return new SearchProductsPage();
	}
	
	public HomePage clickOnHome() throws Throwable
	{
		action.click(getDriver(), homeBtn);
		return new HomePage();
	}
}
