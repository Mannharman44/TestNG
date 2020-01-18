package com.util;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
	    System.out.println("Test started"+result.getName());
	   
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test Passed"+result.getName());
	    CommonMethods.screenShot("passed/"+result.getName());
	  }
	
	public  void onTestFailure(ITestResult result) {
	    System.out.println("Test failed"+result.getName());
	    CommonMethods.screenShot("failed/"+result.getName()); 
	  }
	
	
	
	
}
