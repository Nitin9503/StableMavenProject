package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.invoice_no;
import static com.torenzo.qa.util.StaticVariable.order_no1;
import static com.torenzo.qa.util.StaticVariable.Order_No;
import static com.torenzo.qa.util.StaticVariable.invoice_noNckot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.util.Reusemethod;

public class VerifyOrederWithNckot extends Loginapp{

	public VerifyOrederWithNckot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	Reusemethod call = new Reusemethod();
	@Test(priority=34)
	public void orderCreationWithNckot1() throws IOException, InterruptedException{
		//call.swipadmin();
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
	}
	@Test(priority=35)
	public void orderPaidwithNckot() throws InterruptedException{
		call.OrderPayWithNckot();
		call.verifyNckotsection();
		call.accepttNckot();
		call.NckotInTill();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/menu_img_grid")).click();
	}
	@Test(priority=36)
	public void OrderCreateWithNckot2() throws InterruptedException, IOException{
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
	}
	@Test(priority=37)
	public void verifyOrderByRecjectNckot() throws InterruptedException{
		call.OrderPayWithNckot();
		call.verifyNckotsection();
	    call.rejctNckot();
		call.swipadmin();
		driver.findElement(By.id(obj.getProperty("EditOrder"))).click();
	    String present= driver.findElement(By.id(obj.getProperty("CancelOrderList"))).getText();
		Assert.assertEquals(present, "Cancel", "Edit Order Window not Found");	
				System.out.println("Edit order window is displayed");
				driver.findElement(By.id("textView")).click();
       			driver.findElement(By.id("decrement")).click();
				driver.findElement(By.id("increment")).click();
				driver.findElement(By.id("btn_done")).click();
				driver.findElement(By.id("search")).click();
				
				 for(int j=1; j<15; j++)
				   {
					 System.out.println("verifying loop for cell of j is ="+j);	 
					    try
					     {
					     System.out.println("j is ="+j);	
					    	 
					    	                         //android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]
					 if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed()){
						 System.out.println("here cell is present");
					 invoice_noNckot=driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
					 System.out.println(invoice_no);
					 System.out.println(" invoice no from receipt before payment is"+invoice_noNckot);	 
				   try{
					 if(invoice_noNckot.equalsIgnoreCase(invoice_no)){
						 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
							driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
							System.out.println("After reject order from nckot section is removed and stored into Edit order successfully");
						 break;
					                               }
				   }catch(Exception e){
						System.out.println("invoice numbers not match");
					    }
				      }
				    }
				   catch(Exception e){
					 j=j-7;
					   if(j>0)
					   {
						   j--;
					   }
					   System.out.println("scroll up on Nckot list started");
					   call.scrollOnNckotlist();
				      }
				    }
				  }
	@Test(priority=38)
	public void verifyOrderByRecjectNckotIntoTill() throws InterruptedException{
		call.tillManagment1();
		
	}
	
}
