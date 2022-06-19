package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver , this);
				
	}
	
	@FindBy(name = "uid")
	WebElement txtuserid;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(name = "btnLogin")
	WebElement loginbtn;
	
	@FindBy(name = "btnReset")
	WebElement resetbtn;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
	
	public void EnterUsername (String uname) {
		txtuserid.sendKeys(uname);
	}
	
	public void EnterPassword (String pwd ) {
		txtpassword.sendKeys(pwd);
	}
	
	public void LoginButton()  {
		loginbtn.click();
	}
	
	public void ResetButton() {
		resetbtn.click();
	}
	
	public void Logout() {
		logout.click();
	}
	
	
	
	
	
}
