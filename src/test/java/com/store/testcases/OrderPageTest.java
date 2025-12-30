package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.SearchProductsPage;
import com.store.pageobjects.ViewCartPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchProductsPage searchProductPage;
	ViewCartPage viewCartPage;
	OrderPage orderPage;
	
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
	
	@Test(groups = "sanity")
	public void verifyTotalOnOrderPage() throws Throwable
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProductPage = homePage.clickOnProduct();
		viewCartPage = searchProductPage.addRandomProductsToCart();
		orderPage = viewCartPage.clickonCheckOut();
		boolean result = orderPage.validateOrderTotal();
		Assert.assertTrue(result);
	}

}
