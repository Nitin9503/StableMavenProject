package com.torenzo.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.order_total;
import static com.torenzo.qa.util.StaticVariable.paymentValue;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CashPaymentFromHomeTest extends Loginapp{

	Reusemethod call = new Reusemethod();
	
	public CashPaymentFromHomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=0)
	public void orderCreation() throws IOException, InterruptedException{
		Thread.sleep(3000);
		String str =driver.findElement(By.xpath(obj.getProperty("Combine"))).getText();
		System.out.println("str" +str);
		driver.findElement(By.xpath(obj.getProperty("Combine"))).click();
		System.out.println("str" +str);
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(obj.getProperty("Cash"))).click();
	
	}
	@Test(priority=1)
	public void cashPaymentFromHome() throws IOException, InterruptedException{
		//order_total
		 driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
		 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();

		 
	}
	
	@Test(priority=3)
	public void orderCreationNegative() throws IOException, InterruptedException{
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//android.widget.Button[@text='Cash']")).click();
		driver.findElement(By.xpath(obj.getProperty("Cash"))).click();
	
	}
	
	@Test(priority=4)
	public void cashPaymentFromHomeNegative() throws IOException, InterruptedException{
		//order_total
		order_total =order_total.substring(0, order_total.length()-1);
		System.out.println("order_total is =>" +order_total);
		 driver.findElement(By.xpath(obj.getProperty("clickOnCancel"))).click();
		 String title = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment']")).getText();
		 Assert.assertEquals(title, "Payment", "Payment Window title is not displayed upon clicking on cancel button from close table window");
	 
		 String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
			System.out.println("paymentamonut is =>" +paymentamonut);
			Assert.assertEquals(order_total, paymentamonut, "Both value is not matched with each other from Payment Window");
			 driver.findElement(By.id(obj.getProperty("DoneGuest"))).click();
	        driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
		 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
		
		 
	}
	
	

}
