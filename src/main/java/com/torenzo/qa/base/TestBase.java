package com.torenzo.qa.base;

import static com.torenzo.qa.util.StaticVariable.OSname;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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
			FileInputStream ip = new FileInputStream("E:\\Appium1\\StableMavenProject\\src\\main\\java\\com\\torenzo\\qa\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
	

	
    public static void initilization() throws MalformedURLException, InterruptedException
    {
    	 /* String deviceName = prop.getProperty("device");
        if(deviceName.equalsIgnoreCase("andriod"))*/
    	 DesiredCapabilities caps = new DesiredCapabilities();
 		caps.setCapability("deviceName", "Honor");
 		caps.setCapability("platformName", "Android");
 		caps.setCapability("platformVersion", "6.0");
 		caps.setCapability("newCommandTimeout","150");
 		
 		 if(OSname.equalsIgnoreCase("Mac OS X")){	
 		caps.setCapability("udid", "192.168.56.101:5555");
 		 System.out.println("Mac Emulator device id");
 		 }
 		 else if(OSname.equalsIgnoreCase("Windows 7")){
 		 caps.setCapability("udid", "192.168.208.101:5555");
 		 System.out.println("Windows Emulator device id");
 		 }		
 	    caps.setCapability("appPackage", "com.torenzo.torenzocafe");
 		caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
 	//	caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");
 		try{
 			 Thread.sleep(7000);
 		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
 		}catch(Exception e)
 		{
 			 Thread.sleep(7000);
 			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
 		}
 		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }
    	@BeforeTest
    	public void startServer() throws MalformedURLException {
    		System.out.println("start server1");
		    CommandLine cmd = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
		    cmd.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\Appium.js");
		    cmd.addArgument("--address");
		    cmd.addArgument("0.0.0.0");
		    cmd.addArgument("--port");
		    cmd.addArgument("4723");

		    DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		    DefaultExecutor executor = new DefaultExecutor();
		    executor.setExitValue(1);
		    try {
		        executor.execute(cmd, handler);
		        Thread.sleep(10000);
		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
    	}
    	@AfterTest
    	public void stopServer() throws InterruptedException {
    		System.out.println("stop server1");
    	    Runtime runtime = Runtime.getRuntime();
    	    try {
    	        runtime.exec("taskkill /F /IM node.exe");
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	    System.out.println("stop server2");
    	    Thread.sleep(7000);
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
	

	

