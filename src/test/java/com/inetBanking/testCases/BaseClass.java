package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getBaseUrl() ;
	public String custUrl = readconfig.getaddcustUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
		
	@Parameters("browser") 
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties.txt");
				
		if (br.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(br.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(baseUrl);
		
		
	}
	
//	public void extentreport(String title,String author, String category,String device) {
		
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String repname = "Test-Report-" + timestamp + ".html";
//		
//		ExtentReports extent = new ExtentReports();
//		ExtentSparkReporter spark = new ExtentSparkReporter(repname);
//		ExtentTest test;
//		
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("MyReport");
//		extent.attachReporter(spark);
//
//		
//		test = extent.createTest(title).assignAuthor(author).assignCategory(category).assignDevice(device);
//	}
	
	public void screenshot(WebDriver driver, String name) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		 File destinationpath = new File("Screenshots/" + System.currentTimeMillis() + ".png");

		FileUtils.copyFile(srcfile, destinationpath);
		System.out.println("Screenshot taken");

	}

	
	@AfterClass
	public void TearDown() {
		//extent.flush();
		driver.quit();
	}
	
	
}
