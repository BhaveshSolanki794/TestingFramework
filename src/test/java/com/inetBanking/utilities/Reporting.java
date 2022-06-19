package com.inetBanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports Reports;
	ExtentTest test;
	
	public void configurereports() {
		
		htmlReporter = new ExtentSparkReporter("Test-Report.html");
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReporter);
		
		Reports.setSystemInfo("Machine: ", "Windows 10");
		Reports.setSystemInfo("Author: ", "Bhavesh");
		Reports.setSystemInfo("Environment: ", "QA");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Automation Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test=Reports.createTest(result.getName()); // create new entry in th report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=Reports.createTest(result.getName()); // create new entry in th report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=Reports.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		configurereports();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reports.flush();
	}
	
	
	
	

}
