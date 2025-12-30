package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.dataproviders.DataProviders;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.OrderConfirmationPage;
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.PaymentPage;
import com.store.pageobjects.SearchProductsPage;
import com.store.pageobjects.ViewCartPage;
import com.store.utlity.Log;

public class EndToEndTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchProductsPage searchProductPage;
	ViewCartPage viewCartPage;
	OrderPage orderPage;
	PaymentPage paymentPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke", "sanity", "regression"})
	public void setup(@Optional("Chrome") String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"smoke", "sanity", "regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(dataProvider = "cardCredentials", dataProviderClass = DataProviders.class, groups = "regression")
	public void verifyOrderPlacement(String cardName, String cardNumber, String cvv, String monthExpiry, String yearExpiry) throws Throwable
	{
		Log.startTestCase("End to End" );
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		Log.info("Sign in button clicked");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User logged in successfully");
		searchProductPage = homePage.clickOnProduct();
		viewCartPage = searchProductPage.addRandomProductsToCart();
		orderPage = viewCartPage.clickonCheckOut();
		boolean calc = orderPage.validateOrderTotal();
		if(calc==true)
		{
			Log.info("Order details verified");
		}
		else
		{
			Log.info("Order details NOT verified");
		}
		paymentPage = orderPage.clickOnPlaceOrder();
		//orderConfirmationPage =  paymentPage.fillCardDetailsAndPay("test", "12345678", "123", "05", "2040");
		orderConfirmationPage =  paymentPage.fillCardDetailsAndPay(cardName, cardNumber, cvv, monthExpiry, yearExpiry);
		Log.info("Payment Made");
		boolean result = orderConfirmationPage.validateOrderPlaced();
		Assert.assertTrue(result,"Order placed");
		homePage = orderConfirmationPage.clickOnContinue();
		loginPage = homePage.clickonLogOut();
		Log.info("User logged out successfully");
		Log.endTestCase("End to End");
		
	}

}
