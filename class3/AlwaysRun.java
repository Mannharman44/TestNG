package com.class3;

import org.testng.annotations.*;

public class AlwaysRun {
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		System.out.println("I am before Suite");
	}

	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		System.out.println("I am before class");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		System.out.println("I am After Suite");
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		System.out.println("I am After class");
	}
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		System.out.println("I am After method");
	}
	
	
	
	@Test
	public void test() {
		System.out.println("I am Test method");
	}
	@Test
	public void test1() {
		System.out.println("I am before method");
	}
	
}
