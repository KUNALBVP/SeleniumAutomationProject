package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement userEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement userPassword;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement signInBtn;
	
	
	@FindBy(xpath = "//input[@data-qa= 'signup-name']")
	WebElement newUserName;
	
	@FindBy(xpath = "//input[@data-qa= 'signup-email']")
	WebElement newUserEmail;
	
	@FindBy(xpath = "//button[text()='Signup']")
	WebElement userCreateButton;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	
	public HomePage login(String usermail, String password) throws Throwable
	{
		action.type(userEmail, usermail);
		action.type(userPassword, password);
		action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AccountCreationPage accountCreation(String newEmail, String newName) throws Throwable
	{
		action.type(newUserEmail, newEmail);
		action.type(newUserName, newName);
		action.click(getDriver(), userCreateButton);
		return new AccountCreationPage();
	}
}
