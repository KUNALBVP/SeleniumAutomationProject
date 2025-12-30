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

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	
	@Test(groups = "smoke")
	public void validateHomeTest() throws Throwable
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String expectedHomePageURL = "https://automationexercise.com/";
		String actualHomePageURL = homePage.getCurrURL();
		Assert.assertEquals(actualHomePageURL, expectedHomePageURL);
	}
	
}
