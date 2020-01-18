package com.class3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import com.util.CommonMethods;
import com.util.Constants;

public class Hw extends CommonMethods {

	@BeforeMethod
	public void login() throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");

		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}

	@Test(dataProvider = "getData")
	public void addEmployee(String fn, String ln, String un, String pw) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys(fn);
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys(ln);
		Thread.sleep(2000);
		driver.findElement(By.id("chkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("user_name")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.id("user_password")).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(By.id("re_password")).sendKeys(pw);

		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {

		FileUtils.copyFile(screen, new File("Screenshots/HMRS/AddEmployee"+fn+ln+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "James", "Johnson", "James0", "James!123" }, { "Jon", "Jones", "Jones0", "Jones!123" },
				{ "Jeff", "Brown", "Brown0", "Brown!123" }, { "Jim", "Crow", "Crow0", "Crow!123" },
				{ "Tom", "Benson", "Benson0", "Benson!123" } };
		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();

	}

}
