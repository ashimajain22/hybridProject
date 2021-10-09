package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.loginPage;
import com.utilities.XLUtils;

public class TC_Logintest_002 extends baseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user , String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();

		logger.info("---URL is opened----");
		loginPage lp = new loginPage(driver);
	lp.setUsername(user);
		 lp.setPassword(pwd);
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
/* @DataProvider(name="loginData")
public String[][] getData() throws IOException
{
	String path = "D:/workspace/HybridProjectFramework/src/test/java/com/testData/loginData.xlsx";
int rowNum= XLUtils.getRowCount(path, "data");
int colNum= XLUtils.getCellCount(path, "data", rowNum);
String loginData[][]= new String [rowNum][colNum];
for(int i=1 ; i<=rowNum; i++)
{
for (int j=0;j<colNum;j++)
{
loginData[i-1][j]= XLUtils.getCellData(path, "data", i,j);	
}
}
return loginData;
}*/
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="D:\\workspace\\HybridProjectFramework\\src\\test\\java\\com\\testData\\loginData.xlsx";
		System.out.println("fddsfdfds");
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rownum);
		System.out.println("fdd");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
}
