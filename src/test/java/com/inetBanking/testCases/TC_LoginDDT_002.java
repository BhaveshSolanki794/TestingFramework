package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void LoginDataTest (String user, String pwd) throws IOException {
		
		//extentreport("Login data TestCase", "Bhavesh", "Data Driven Test", "Windows");
		
		LoginPage lp = new LoginPage(driver);
		lp.EnterUsername(user);
		logger.info("username provided");
		lp.EnterPassword(pwd);
		logger.info("password provided");
		lp.LoginButton();
		
		if(isAlertPresent() == true) {
//			test.fail("Login Failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			screenshot(driver, "Login Failed");
		}else {
			Assert.assertTrue(true);
			lp.Logout();
//			test.pass("Login Successful");
			logger.info("logout Successfull");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException {
		String Path  = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum = XUtils.getRowCount(Path, "Sheet1");
		int colnum = XUtils.getCellCount(Path, "Sheet1", 1);
		
		String LoginData [][] = new String [rownum] [colnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0; j<colnum;j++) {
				
				LoginData [i-1][j] = XUtils.getCellData(Path, "Sheet1", i, j);
			}
		}
		
		return LoginData;
	}
	
	
	

}
