package com.torenzo.qa.testcases;


import static com.torenzo.qa.util.StaticVariable.Order_No;
import static com.torenzo.qa.util.StaticVariable.Order_To;
import static com.torenzo.qa.util.StaticVariable.order_summary_qty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

public class VerifyOrderInTillTest extends Loginapp{

		public VerifyOrderInTillTest() throws IOException {
			super();
			
		}
		Reusemethod call = new  Reusemethod();
	@Test(priority=19)
	public void orderCreateAndDBtest() throws IOException, InterruptedException{
		
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		order_summary_qty = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_summary_qty")).getText().substring(1);
		 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
		 Order_To=OrderTo.getText();
		 System.out.println(Order_To);
		 WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
	     Order_No=OrderNo.getText();
		 System.out.println(Order_No);
		
			
		System.out.println("order_summary_qty ===>" +order_summary_qty);
		call.DbconnbeforePay();
	}
		@Test(priority=20)
		public void paymentAndDBtest() throws InterruptedException{
			call.payWithCash();
			call.DbconnAfterPay();
		}
		
		@Test(priority=21)
		public void VerfyTillAndDBtest() throws InterruptedException{
		call.DbconnReceiptdata();
		call.tillManagment();
		}
	}
	
