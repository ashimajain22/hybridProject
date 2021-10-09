package com.testCases;

import java.io.File;
import java.io.IOException;

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
import org.testng.annotations.*;

import com.utilities.readConfig;

public class baseClass {

	
	readConfig rc = new readConfig();
	public String baseURL= rc.getApplicationURL();
	public String username= rc.getUserEmail();
	public String password= rc.getPassword();
	public static WebDriver driver;
	
public  static Logger logger;

@BeforeClass	
public void setup()
	{
		
		logger = logger.getLogger("Log4jDemo"); // provide test case name or class name
		
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());
		driver= new ChromeDriver();
	
		
	}


public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}


	@AfterClass
	public void tearDown()
	{
		driver.quit();

}}