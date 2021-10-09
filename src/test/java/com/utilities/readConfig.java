package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	
	public readConfig()
	{
		File src = new File("./configuration/config.properties");
try
{
FileInputStream fis = new FileInputStream(src)	;
pro= new Properties();
pro.load(fis);

} catch(Exception e)
{
System.out.println("exceptoon is" +e.getMessage());	
}
}
	
	public String getApplicationURL()
	{
		
	String url=	pro.getProperty("baseURL");
	return url;
	}
	public String getUserEmail()
	{
		
	String username=	pro.getProperty("username");
	return username;
	}
	public String getPassword()
	{
		
	String password=	pro.getProperty("password");
	return password;
	}
	public String getChromePath()
	{
		
	String chroPath=	pro.getProperty("chromepath");
	return chroPath;
	}
	public String getFirefoxPath()
	{
		
	String FirefoxPath=	pro.getProperty("chromepath");
	return FirefoxPath;
	}
}