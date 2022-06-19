package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement AddCustomerLink;
	
	@FindBy(id = "dismiss-button")
	WebElement CloseButton;
	
	@FindBy(name = "name")
	WebElement Customername;
	
	@FindBy(name = "rad1")
	WebElement Gender;
	
	@FindBy(name = "dob")
	WebElement DateOfBirth;
	
	@FindBy(name = "addr")
	WebElement Address;
	
	@FindBy(name = "city")
	WebElement City;
	
	@FindBy(name = "state")
	WebElement State;
	
	@FindBy(name = "pinno")
	WebElement PinNo;
	
	@FindBy(name = "telephoneno")
	WebElement MobNo;
	
	@FindBy(name = "emailid")
	WebElement EmailId;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement Submitbtn;
	
	@FindBy(xpath = "//input[@type = 'reset']")
	WebElement Resetbtn;
	
	public void ClickAddCustomer () {
		AddCustomerLink.click();
	}
	
	public void ClickClosebtn() {
		CloseButton.click();
	}
	
	public void EnterCustName (String name) {
		Customername.sendKeys(name);
	}
	
	public void SelectGender (String gender) {
		Gender.click();
	}
	
	public void AddDateOfBirth (String dd, String mm, String yy) {
		DateOfBirth.sendKeys(dd);
		DateOfBirth.sendKeys(mm);
		DateOfBirth.sendKeys(yy);
	}
	
	public void EnterAddress (String addr) {
		Address.sendKeys(addr);
	}
	
	public void AddCity (String city) {
		City.sendKeys(city);
	}
	
	public void AddState (String state) {
		State.sendKeys(state);
	}
	
	public void AddPinNo (String pinno) {
		PinNo.sendKeys(pinno);
	}
	
	public void AddMobNo (String number) {
		MobNo.sendKeys(number);
	}
	
	public void AddEmailId (String id) {
		EmailId.sendKeys(id);
	}
	
	public void AddPassword (String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void ClickSubmit () {
		Submitbtn.click();
	}
	
	public void ClickReset () {
		Resetbtn.click();
		
	}
	

}
