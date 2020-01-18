package com.class1;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.util.CommonMethods;
import com.util.Constants;

public class Hw extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(priority=2, dependsOnMethods= {"negativeLogin"},enabled=false)
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();

		boolean logo = driver.findElement(By.xpath("//div[@id='branding']//a//img")).isDisplayed();
		if (logo) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

	}

	@Test(priority=1)
	public void negativeLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();

		String text = driver.findElement(By.id("spanMessage")).getText();

		if (text.equals("Password cannot be empty")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
