package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.OSname;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestECC {

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("newCommandTimeout", "150");

			caps.setCapability("udid", "192.168.208.101:5555");
			System.out.println("Windows Emulator device id");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		//caps.setCapability("appPackage", "com.torenzo.torenzocafe");
		//caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
		
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);	
			System.out.println("After thread" );
			//Login
			driver.findElement(By.id("txtUserName")).sendKeys("testbil");
			System.out.println("After User name" );
			driver.findElement(By.id("txtPassword")).sendKeys("enexion4test");
			
			System.out.println("After password" );

			driver.findElement(By.id("btnLogIn")).click();
			System.out.println("After login" );
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			//driver.findElement(By.xpath("text()='16 NEWS'")).click();
		

				
	}

}
