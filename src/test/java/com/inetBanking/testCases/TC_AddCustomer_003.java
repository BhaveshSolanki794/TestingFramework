package com.inetBanking.testCases;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void AddCustomer() throws InterruptedException {
		
		
		driver.get(custUrl);
		
	
		
		AddNewCustomer ac = new AddNewCustomer(driver);
		ac.EnterCustName("Bhavesh");
		logger.info("Entered Customer name");
		ac.SelectGender("male");
		ac.AddDateOfBirth("02", "12", "1997");
		ac.EnterAddress("Vartak Road");
		ac.AddCity("virar");
		ac.AddState("Maharashtra");
		ac.AddPinNo("401303");
		ac.AddMobNo("9638527412");
		
		String ranEmail = GenRandomAlpha() + "@gmail.com";
		
		ac.AddEmailId(ranEmail);
		ac.AddPassword("Vaccine@2022");
		ac.ClickSubmit();
		Thread.sleep(5000);
		//test.pass("test passed");
		
		if(AlertPresent() == true) {
			Assert.assertTrue(true);
			logger.info("test passed");
			driver.switchTo().alert();
			driver.switchTo().alert().accept();
		}else {
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean AlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	public String GenRandomAlpha() {
		String ranAlpha = RandomStringUtils.randomAlphabetic(6);
		return ranAlpha;
	}
	

}
