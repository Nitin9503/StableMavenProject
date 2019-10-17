package com.torenzo.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CCTest {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Galaxy J7 Duo");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.1.0");
		caps.setCapability("newCommandTimeout", "150");
		caps.setCapability("udid", "ZY3227V4V6");
		System.out.println("Mac Emulator device id");
		
		caps.setCapability("appPackage", "enexion.energy.cockpitTest");
		//capabilities.setCapability("udid", "emulator-5554");
		caps.setCapability("appActivity", "enexion.energy.cockpitTest.MainActivity");
		
		
	/*	caps.setCapability("appPackage", "com.torenzo.torenzocafe");
		caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");*/
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
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
		driver.findElement(By.xpath("//android.widget.TextView[@text='News']")).click();
	//	driver.findElement(By.xpath("contains(text(), 'NEWS')")).click();
		//driver.findElement(By.("#!PRICES")).click();
		
		

	}

}
