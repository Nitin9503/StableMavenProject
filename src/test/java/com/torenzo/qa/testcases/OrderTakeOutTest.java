
package com.torenzo.qa.testcases;

import java.io.FileInputStream;

import static com.torenzo.qa.util.StaticVariable.homePageTitle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.android.AndroidDriver;


@Listeners(com.torenzo.qa.listener.Listener.class)
public class OrderTakeOutTest extends Loginapp{
	
	Reusemethod call = new Reusemethod();
	// HomePage homePage = new HomePage(driver);	
	 
	 public OrderTakeOutTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=4)
	public void Allitem() throws IOException, InterruptedException{		
	/*	String str =homePage.titleOfhomePage();		
	    System.out.println("str==>" +str);*/		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		call.transactionTypeWindow();    	        
		String order_no=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("Order number is =>" + order_no);
		driver.findElement(By.id(obj.getProperty("AddGuest"))).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
     	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();		
		call.selectGuestandAddItem();
		}
			
		@Test(priority=5)
		public void Payment() throws IOException, InterruptedException
		{

			 call.Payment();
			/* homePageTitle =homePage.titleOfhomePage();		
		      System.out.println("homePageTitle==>" +homePageTitle);*/
		      //Assert.assertEquals(homePageTitle, "Order", "Home page is not found after paying payment");
			System.out.println("Ordercreate class end here");
			
		}
	
		
   	}
	


	