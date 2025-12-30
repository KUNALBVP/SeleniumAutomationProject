package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
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
	public void verifyLogo() throws Throwable
	{
		indexPage = new IndexPage();
		boolean result = indexPage.ValidateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "smoke")
	public void verifyTitle()
	{
		String actualTitle = indexPage.getStoreTitle();
		Assert.assertEquals(actualTitle, "Automation Exercise");
	}
	

}
