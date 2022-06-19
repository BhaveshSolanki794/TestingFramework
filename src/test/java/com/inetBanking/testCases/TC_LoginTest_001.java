package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException 
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.EnterUsername(username);
		logger.info("Entered username");
		
		lp.EnterPassword(password);
		logger.info("Entered password");
		
		lp.LoginButton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			screenshot(driver, "Login page");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
}
