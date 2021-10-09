package com.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.loginPage;

public class TC_Logintest_001 extends baseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);

		logger.info("---URL is opened----");
		loginPage lp = new loginPage(driver);
//	lp.setUsername(username);
		// lp.setPassword(password);
		lp.clickLogin();

		logger.info("login done----");
		Thread.sleep(5000);
		if (driver.getTitle().equalsIgnoreCase("Dashboard / nopCommerce administration")) {

			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login passed");
		}
		
		else
		{
			Assert.assertTrue(false);
logger.info("login failed");
captureScreen(driver,"loginTest");
		}

	}

}
