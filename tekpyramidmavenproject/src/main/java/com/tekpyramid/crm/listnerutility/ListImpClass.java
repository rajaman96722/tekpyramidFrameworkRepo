package com.tekpyramid.crm.listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener , ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		// TODO Auto-generated method stub
		System.out.println("==== ======>"+result.getMethod().getMethodName()+">====START======");
		  test =	report.createTest(result.getMethod().getMethodName());
		  UtilityClassObject.setTest(test);
		  test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started <===");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		//spark report config
		 spark = new ExtentSparkReporter("./AdvancePeport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSWE", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
	System.out.println("Report backup");
	report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==== ======>"+result.getMethod().getMethodName()+">====END======");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> Completed <====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	   String testName=	result.getMethod().getMethodName();
	
	   TakesScreenshot eDriver = (TakesScreenshot)BaseClass.sDriver;
		String filePath =eDriver.getScreenshotAs(OutputType.BASE64);
		
	 	   String time=new Date().toString().replace(" ", "_").replace(":"," ");
	 	  test.addScreenCaptureFromBase64String(filePath,testName+""+time);
	 	 test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <====");
	 	    
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
