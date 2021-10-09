package com.pageObjects;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		
		this.ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutLink;
	
	
	public void setUsername(String uname)
	{
		
		txtEmail.sendKeys(uname);
	}

	public void clickLogin()
	{
		
		loginBtn.click();
	}

	public void setPassword(String pass)
	{
		
		txtPassword.sendKeys(pass);
	}

	public void clickLogout()
	{
		
		logoutLink.click();
	}
}
