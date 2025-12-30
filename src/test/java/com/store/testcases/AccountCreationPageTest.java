package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.AccountCreationPage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class AccountCreationPageTest  extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
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
	public void verifyAccountCreationPage() throws Throwable
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.accountCreation("davvja@abcgf.com", "VDAHBZSH");
		boolean result = accountCreationPage.validatepageHeading();
		Assert.assertTrue(result);
	}
	
	
}
