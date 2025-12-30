package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement pageHeading;
	
	@FindBy(id = "id_gender1")
	WebElement maleRadioBtn;
	
	@FindBy(id = "id_gender2")
	WebElement femaleRadioBtn;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement daysDropdown;
	
	@FindBy(id = "months")
	WebElement monthsDropdown;
	
	@FindBy(id = "years")
	WebElement yearsDropdown;
	
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id = "company")
	WebElement companyName;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "address2")
	WebElement address2;
	
	@FindBy(id = "country")
	WebElement countryDropdown;
	
	@FindBy(id = "state")
	WebElement state;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "zipcode")
	WebElement zipCode;
	
	@FindBy(id = "mobile_number")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccountBtn;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validatepageHeading() throws Throwable
	{
		return action.isDisplayed(getDriver(), pageHeading);
	}
	
	public String getDisplayedName() throws Throwable
	{
		return name.getAttribute("value");
	}
	
	public String getDisplayedEmail() throws Throwable
	{
		return email.getAttribute("value");
	}
	
	public void fillNewUserGeneralDetails(String gender, String pwd, String birthDay, String birthMonthNumber, String birthYear, String fName, String lName, String compName) throws Throwable
	{
		if(gender == "male")
		{
			action.click(getDriver(), maleRadioBtn);	
		}
		else
		{
			action.click(getDriver(), femaleRadioBtn);
		}
		
		action.type(password, pwd);
		action.selectByValue(daysDropdown, birthDay);
		action.selectByValue(monthsDropdown, birthMonthNumber);
		action.selectByValue(yearsDropdown, birthYear);
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(companyName, compName);
	}
	
	public void fillNewUserAddressDetails(String add1, String add2, String cityName, String stateName, String countryName, String zip, String mobile) throws Throwable
	{
		action.type(address1, add1);
		action.type(address2, add2);
		action.selectByValue(countryDropdown, countryName);
		action.type(state, stateName);
		action.type(city, cityName);
		action.type(zipCode, zip);
		action.type(mobileNumber, mobile);
	}
	
	public AccountCreationSuccessPage clickOnCreateAccount() throws Throwable
	{
		action.click(getDriver(), createAccountBtn);
		return new AccountCreationSuccessPage();
	}

}
