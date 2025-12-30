package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.SearchProductsPage;

public class ProductAvailabilityPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	SearchProductsPage searchProductPage;
	
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
	
	@Test(groups = {"smoke","sanity"})
	public void verifyProductAvailability() throws Throwable
	{
		indexPage = new IndexPage();
		searchProductPage = indexPage.clickOnProducts();
		boolean result = searchProductPage.validateProductPage();
		Assert.assertTrue(result);
	}
	

}
