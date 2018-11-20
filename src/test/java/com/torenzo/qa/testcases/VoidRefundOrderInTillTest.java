package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.Amount;
import static com.torenzo.qa.util.StaticVariable.Discount;
import static com.torenzo.qa.util.StaticVariable.OrderNo;
import static com.torenzo.qa.util.StaticVariable.order_no1;
import static com.torenzo.qa.util.StaticVariable.invoice_no;
import static com.torenzo.qa.util.StaticVariable.invoice_noNckot;
import static com.torenzo.qa.util.StaticVariable.invoice_tillNCKOT;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

public class VoidRefundOrderInTillTest extends Loginapp {
	public VoidRefundOrderInTillTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
       
	Reusemethod call = new Reusemethod();
	@Test(priority=28)
	public void orderCreateAndPay() throws IOException, InterruptedException{
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		call.payWithCash();
	}
	@Test(priority=29)
	public void orderVerifyInEditOrder() throws IOException, InterruptedException{
		
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
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					System.out.println("it comes insside 37");
					String print=driver.findElement(By.xpath("//android.widget.Button[@text='Void Order']")).getText();
					System.out.println("it comes insside 38");
				WebElement	ele=driver.findElement(By.xpath("//android.widget.Button[@text='Void Order']"));
				System.out.println("it comes insside 39");
				TouchAction action = new TouchAction(driver);
				System.out.println("it comes insside 40");
				action.longPress(ele);
				System.out.println("it comes insside 41");
				action.perform();
				System.out.println("it comes insside 42");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
				//driver.findElement(By.xpath("//aandroid.widget.TextView[@text='Bad Test']")).click();
				driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				  }
				
				
				 @Test(priority=30)
					public void VerifyVoidinTill() throws IOException, InterruptedException{
					
						 //tap on nckot tab in till management
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();		
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();	
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_void_details_tab")).click();
						 for(int l=1; l<13; l++)
						    {
							 System.out.println("verifying loop for cell of j is ="+l);	 
							    try
							     {
							    	 System.out.println("j is ="+l);

							 //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
						     //if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
							 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
						 {                              
								 System.out.println("cell is present");   
							// invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
							
							 invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
							 System.out.println("invoice no from receipt before payment is"+invoice_noNckot);	
							 System.out.println("invoice no search in nckot list after payment "+invoice_tillNCKOT);
						   try{
							 if(invoice_noNckot.equalsIgnoreCase(invoice_tillNCKOT)){
								 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
								//Discount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
					            Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
								 System.out.println("Order detaill showing in Void secton below :");
								 System.out.println("Order No"+"           "+"Invoice No"+"       "+"Amount");
								 System.out.println(OrderNo+"           "+invoice_tillNCKOT+"      "+Amount);
								// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
								 break;
							                               }
						   }catch(Exception e){
								System.out.println("invoice numbers not match");
							    }
						      }
						    }
						   catch(Exception e){
							 l=l-18;
							   if(l>0)
							   {
								   l--;
							   }
							   System.out.println("scroll up on Nckot list started");
							   call.scrollOnNCKOTIntill();
						      }
						   }
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click();
						driver.findElement(By.id("com.torenzo.torenzocafe:id/menu_img_grid")).click();
			          }
				 @Test(priority=31)
				 public void RefundTest() throws InterruptedException{
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
											driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								System.out.println("it comes insside 37");
								String print=driver.findElement(By.xpath("//android.widget.Button[@text='Refund Order']")).getText();
								System.out.println("it comes insside 38");
								WebElement	ele=driver.findElement(By.xpath("//android.widget.Button[@text='Refund Order']"));
								System.out.println("it comes insside 39");
								TouchAction action = new TouchAction(driver);
								System.out.println("it comes insside 40");
								action.longPress(ele);
								System.out.println("it comes insside 41");
								action.perform();
								System.out.println("it comes insside 42");
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
								//driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
								//driver.findElement(By.xpath("//aandroid.widget.TextView[@text='Bad Test']")).click();
								driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					 }
				 @Test(priority=32)
				 public void RefundTillTest() throws InterruptedException{
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();		
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();	
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_refund_details_tab")).click();
					 for(int l=1; l<13; l++)
					    {
						 System.out.println("verifying loop for cell of j is ="+l);	 
						    try
						     {
						    	 System.out.println("j is ="+l);

						 //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
					     //if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
						 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
					 {                              
							 System.out.println("cell is present");   
						// invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
						
						 invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
						 System.out.println("invoice no from receipt before payment is"+invoice_noNckot);	
						 System.out.println("invoice no search in nckot list after payment "+invoice_tillNCKOT);
					   try{
						 if(invoice_noNckot.equalsIgnoreCase(invoice_tillNCKOT)){
							 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
							//Discount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
				            Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
							 System.out.println("Order detaill showing in Refund secton below :");
							 System.out.println("Order No"+"           "+"Invoice No"+"       "+"Amount");
							 System.out.println(OrderNo+"           "+invoice_tillNCKOT+"      "+Amount);
							// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
							 break;
						                               }
					   }catch(Exception e){
							System.out.println("invoice numbers not match");
						    }
					      }
					    }
					   catch(Exception e){
						 l=l-18;
						   if(l>0)
						   {
							   l--;
						   }
						   System.out.println("scroll up on Nckot list started");
						   call.scrollOnNCKOTIntill();
					      }
					   }
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click();
					//driver.findElement(By.id("com.torenzo.torenzocafe:id/menu_img_grid")).click();
          }
}