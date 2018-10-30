/*package com.torenzo.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.TouchAction;

public class CashPaymentFromHomeTest extends Loginapp{

	Reusemethod call = new Reusemethod();
	
	public CashPaymentFromHomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=0)
	public void cashPaymentFromHome() throws IOException, InterruptedException{
		call.Allitem();
		
		//driver.findElement(By.id("com.torenzo.torenzocafe:id/cash")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.Button[@text='Quick-Receipt")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Cash']")).click();
		String str=driver.findElement(By.xpath("//android.widget.Button[@text='Cash']")).getText();
		System.out.println("str=>"+str);
		 driver.findElement(By.xpath("//android.widget.Button[@text='Cash']")).click();
		TouchAction action = new TouchAction(driver);
		
	}
	
	
	
	
	

}*/
