package com.torenzo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.myjeeva.poi.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.util.TestUtil;

import freemarker.template.utility.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestBase {
	//Use .bat file to run project 
	public static AndroidDriver driver;
	//static IOSDriver driver;
	public static Properties prop;

	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/src/main/java/com/torenzo/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
	

	
    public static void initilization() throws MalformedURLException
    {
       /* String deviceName = prop.getProperty("device");
        if(deviceName.equalsIgnoreCase("andriod"))*/
    	try
        {
        	DesiredCapabilities caps = new DesiredCapabilities();
    		caps.setCapability("deviceName", "Honor");
    		caps.setCapability("platformName", "Android");
    		caps.setCapability("platformVersion", "6.0");
    		caps.setCapability("newCommandTimeout","150");
            caps.setCapability("udid", "192.168.56.101:5555");
            caps.setCapability("appPackage", "com.torenzo.torenzocafe");
    		caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
    	//	caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");
    		try{
    		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    		}catch(Exception e)
    		{
    			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    		}
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		
    
    		
    	}catch(Exception e){
    		
    	
    	}
    	
    	
    	
    	
    }
    
    
    
    
    
    
     /* else if (deviceName.equalsIgnoreCase("iOS"))
        {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
			
		        capabilities.setCapability("deviceName", "iPad 2");
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("platformVersion", "9.3");	       
				capabilities.setCapability("udid", "95bb78de2a63886aaa9542d51740dbda53ffc7ca");
     			capabilities.setCapability("app", "/Users/rahul.kardel/Desktop/Torenzo.app");
     			driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
			capabilities.setCapability("app", "/Users/rahul.kardel/Desktop/Torenzo.app");
			   Driver= new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
           }
        
    	//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);*/
    	
    

	
    
    
    
    
    
    
    
    
   /* 

    
	@BeforeTest(alwaysRun=true)
	public void login() throws IOException
	{
	

		System.out.println("Value of Live user" +prop.getProperty("Live-User"));
    try{

	
	    if(driver.findElement(By.xpath(prop.getProperty("TitleLogin"))).isDisplayed())
		{
	    	//driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe");
           // driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
			driver.findElement(By.id(prop.getProperty("Submit"))).click();
		   driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
		 
		   driver.findElement(By.id(prop.getProperty("RoleName"))).click();
		    System.out.println("on home page");
		    driver.unlockDevice();
		}
		
		
	}catch(Exception e)
	{
	    
		driver.findElement(By.xpath(prop.getProperty("Live-User"))).click();
		//driver.findElement(By.xpath("Demo-User")).click();
	//	driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe");
	//	driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
     	driver.findElement(By.id(prop.getProperty("Submit"))).click();
	    driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
	    driver.findElement(By.id(prop.getProperty("RoleName"))).click();
	    System.out.println("on home page");
	}
	
	}


	
	@BeforeClass
	   public void permission() throws IOException
		{
										
		try{
		
			if (driver.findElement(By.xpath(prop.getProperty("PermissionPopup"))).isDisplayed())
			{
				 System.out.println("Permission popup is displayed");
				 driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			    driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			
			}
		}catch (Exception e)
	      	{
			
				System.out.println("Permission popup is not displayed");
			}
		}	*/
	
}	
	

