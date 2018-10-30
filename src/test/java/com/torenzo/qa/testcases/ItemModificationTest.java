package com.torenzo.qa.testcases;

import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.text.DecimalFormat;

import okhttp3.Call;

import org.apache.tools.ant.property.GetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import static com.torenzo.qa.util.StaticVariable.customdiscount;
import static com.torenzo.qa.util.StaticVariable.customreason;
import static com.torenzo.qa.util.StaticVariable.order_total;

@Listeners(com.torenzo.qa.listener.Listener.class)
public class ItemModificationTest extends Loginapp {
		
	public ItemModificationTest() throws IOException {
			super();
			// TODO Auto-generated constructor stub
		}
	
	Reusemethod call = new  Reusemethod();
	public static String price1;
	public static Double value;
	public static String quantity1;
	public static String perdiscountprice;
	public static String perdiscount;
	
		@Test(priority=12)
		public void modifyorder() throws InterruptedException, IOException
		{
		    call.transactionTypeWindow();
		    call.addGuestToOrder();
			call.Allitemwithoutmodifier();
			
		}
	
		@Test(priority=13)
		public void reOrder() throws IOException
		{
			
		//driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
		System.out.println("order total before reorder item = "+order_total);
		price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
		System.out.println("price 1 = "+price1);
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		driver.findElement(By.id(obj.getProperty("Reorder"))).click();
	    Double addition = Double.parseDouble(order_total) + Double.parseDouble(price1);
		    DecimalFormat format = new DecimalFormat("0.00");
	        String ordertotalplusreorder = format.format(addition);
	        System.out.println("reorder = addition of order total and item price = "+ordertotalplusreorder);
			order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
			System.out.println("order total after reorder item = "+order_total);
			
    	if (ordertotalplusreorder.equalsIgnoreCase(order_total))
    	{
    		System.out.println("Item price added succefully to order toatl after reording the item");
    	}
    	else
    	{
    		System.out.println("Item price not added to order toatl after reording the item");
    	}
    	
    	System.out.println("Reorder method ends here");
	  }
	
	
		@Test(priority=14)
		public void modifier()
		{
			
		order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
		System.out.println("order total before applying modifier = "+order_total);
	    price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
		System.out.println("price 1 = "+price1);
		 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		 driver.findElement(By.id(obj.getProperty("Modifier"))).click();
			try{
				System.out.println("searching for modifier ");
				if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
				{
				System.out.println("Modifier displayed ");
				driver.findElement(By.id(obj.getProperty("CancelModifierDialog"))).click();
				System.out.println("cancel modifier window ");
				 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
				 driver.findElement(By.id(obj.getProperty("Modifier"))).click();
					try{
						if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
						{
							System.out.println("clicking on modifier ");
							driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
			          		String modifiercharges = driver.findElement(By.id("modifier_charges")).getText();
						    System.out.println("modifiercharges= "+modifiercharges);
							driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
							Double addition = Double.parseDouble(order_total) + Double.parseDouble(modifiercharges);
							 System.out.println("addition= "+addition);
							 DecimalFormat df = new DecimalFormat("0.00");
							 String modifierplusordertotal = df.format(addition);
							  System.out.println("modifierplusordertotal= "+modifierplusordertotal);
							  order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
								System.out.println("order total before applying modifier = "+order_total);
								if (order_total.equalsIgnoreCase(modifierplusordertotal))
								{
									 System.out.println("modifier added succefully and chnages in the total order amount");
								}
								else
								{
									System.out.println("modifier not added and not chnages in the total order amount");
								}
													
						}
					     }catch(Exception e)
						{
					    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
							 driver.findElement(By.id(obj.getProperty("CustomModifierAdd"))).sendKeys("Spicy");
							driver.findElement(By.id(obj.getProperty("CustomModifierCount"))).sendKeys("2");
		   			        String custommodprice = driver.findElement(By.id("custom_modifier_count")).getText();
                  			 System.out.println("custom modifier prize" +custommodprice);
							driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();	
							driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
							Double addition = Double.parseDouble(order_total) + Double.parseDouble(custommodprice);
							DecimalFormat df = new DecimalFormat("0.00");
							String orderplusmodifier = df.format(addition);
							System.out.println("orderplusmodifier" +orderplusmodifier);
							 order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
							System.out.println("order total before applying modifier = "+order_total);
							if (order_total.equalsIgnoreCase(orderplusmodifier))
							{
								 System.out.println("modifier added succefully and chnages in the total order amount");
							}
							else
							{
								 System.out.println("modifier not added succefully and not chnages in the total order amount");
							}
							
						}
				}
				
			}catch(Exception e)
			{
				System.out.println("Catch exception");
			}			
		 
		}
		
		
		@Test(priority=15)
		public void Discount()
		{
		
		order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
		System.out.println("order total before discount to item = "+order_total);
	    price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
		System.out.println("price 1 = "+price1);
		 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		 driver.findElement(By.id(obj.getProperty("Discount"))).click();
	
	 try{
		 if (driver.findElement(By.xpath(obj.getProperty("ItemDiscount"))).isDisplayed())
		 {
			 System.out.println("For Custom Discount");
			 System.out.println("Discount window is displayed");
			 driver.findElement(By.id(obj.getProperty("CancelModifierDialog"))).click();
			 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			 driver.findElement(By.id(obj.getProperty("Discount"))).click();
			 driver.findElement(By.id("reason")).sendKeys("Festival");
	     	 driver.findElement(By.id("amount")).sendKeys("10");
		      customreason = driver.findElement(By.id("reason")).getText();  
			  customdiscount = driver.findElement(By.id("amount")).getText();
			 System.out.println("customreason==>" +customreason);
			 System.out.println("customdiscount==>" +customdiscount);
			 driver.findElement(By.id("apply")).click();
     		 System.out.println("Check whether discount is added in Current Discount window(Custom Discount)");
			 String incurrenwindow = driver.findElement(By.id("name")).getText();
			 System.out.println("incurrenwindow ==>" +incurrenwindow);
			
				 if (incurrenwindow.equalsIgnoreCase(customreason))
				 {
					 System.out.println("Reason is added for the Discount succefully"); 
				 }
				 else{
					 System.out.println("Reason is not added for the Discount");  
				 }
			 driver.findElement(By.id("done_discount")).click();
			 System.out.println("Check whether item and order total dedected after applying discount to item");
		     
			 Double substraction = Double.parseDouble(order_total) - Double.parseDouble(customdiscount);
			 System.out.println("discountonitem==>"+substraction);
			 DecimalFormat df = new DecimalFormat("0.00");
			 String discountonitem = df.format(substraction); 
         	 order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
				System.out.println("order total after applying discount on item = "+order_total);
				if(order_total.equalsIgnoreCase(discountonitem))
				{
					System.out.println("Discount is succefully applied on item and verified with total order amount");
				}
				else
				{
					System.out.println("Discount is not applied on item and verified with total order amount");
				}
				 
		 }
		 }catch(Exception e)
		 {
			 
			 System.out.println("Discount window is not displayed");
			 
		 }
	 
         	 System.out.println("For Preset Discount");
         	order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
    		System.out.println("order total before preset disocunt item = "+order_total);
         	 price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
     		System.out.println("price 1 = "+price1);
     		
			 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			 driver.findElement(By.id(obj.getProperty("Discount"))).click();
	     	 driver.findElement(By.id(obj.getProperty("PresetDiscount1"))).click();
			 driver.findElement(By.id(obj.getProperty("PerDiscountRegPrice"))).click();
     		 driver.findElement(By.id("amount_on_reset")).sendKeys("5");
			 perdiscount =  driver.findElement(By.id("amount_on_reset")).getText();
			 System.out.println("perdiscount==>" +perdiscount);
			 driver.findElement(By.id("apply_on_preset")).click();
			 String incurrenwindow = driver.findElement(By.id("name")).getText();
			 System.out.println("incurrenwindow ==>" +incurrenwindow);
			 driver.findElement(By.id("done_discount")).click();
			 System.out.println("Check whether discount is added in Current Discount window(Preset Discount)");
      	/*
      		 Double discountcount = Double.parseDouble(price1) * Double.parseDouble(perdiscount) / 100;
      		 System.out.println("perdiscountonitem = ==>" +discountcount);
			 DecimalFormat df = new DecimalFormat("0.00");
			 String perdiscountonitem = df.format(discountcount); 
			 System.out.println("perdiscountonitem = ==>" +perdiscountonitem);*/
      		order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
    		System.out.println("order total after preset disocunt item = "+order_total);
      	/*	 if (order_total.equalsIgnoreCase(perdiscountonitem))
      		 {
      			System.out.println("Preset Discount is succefully added and changes in total amount"); 
      		 }
      		 else
      		 {
      			System.out.println("Preset Discount is not added and not changes in total amount");
      		 }*/
		
	    }
		@Test(priority=16)
		public void Quantity(){
		
		//String item = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
	     	 quantity1 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).getText();		
			System.out.println("quantity= "+quantity1);
			price1 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
			System.out.println("price 1 = "+price1);
	      	order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
			System.out.println(" quantiy method = order_total first time ="+order_total);
			
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		    try{
				 if(driver.findElement(By.xpath(obj.getProperty("OptionsForItem"))).isDisplayed())
		     	{
				 System.out.println("Option for item window is opened");
				 driver.findElement(By.id(obj.getProperty("Quantity"))).click();	
				 
				 try{
					 if (driver.findElement(By.xpath(obj.getProperty("QuantityWindow"))).isDisplayed())
					 {
						    System.out.println("Quantity window is opened");
						    driver.findElement(By.id("cancel_add_item")).click();
							driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
							 driver.findElement(By.id(obj.getProperty("Quantity"))).click();
							driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
					        quantity1 =driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).getText();
	                        System.out.println("quantity1=" +quantity1);
	                        driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();	 
						 
					 }
				 }catch (Exception e)
				 {
					 System.out.println("Quantity window is not opened");
				 }
		     	}
		   }catch(Exception e)
		      {
			 System.out.println("Option for item window is not opened");
		      }
	 
		     Double multiply = Double.parseDouble(price1) * Double.parseDouble(quantity1);
	    	 DecimalFormat format1 = new DecimalFormat("0.00");
	    	 String pricequanmulti = format1.format(multiply);
	    	 value = multiply - Double.parseDouble(price1);
	    	 System.out.println(" again price 1 ="+value);	
	    	 System.out.println(" pricequanmulti ="+pricequanmulti);
	    	 price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
	    	 
	    	 System.out.println(" again price 1 ="+price1);	
	    	 
	    	 if (pricequanmulti.equalsIgnoreCase(price1))
			 {
			     System.out.println("price of item is matched after adding quantiy succefully");
		     }
		    	else
			 {
		    	 System.out.println("price of item is not matched after adding quantiy");
			 }
     	    Double addition = Double.parseDouble(order_total) + (value);
		    DecimalFormat format = new DecimalFormat("0.00");
	        String ordertotalplusprice = format.format(addition);
            System.out.println("decimal format=" +ordertotalplusprice);
	    	order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
			System.out.println(" order_total second time="+order_total);
     	    System.out.println("Check whether amount correctly added or not");
    
     	   if (ordertotalplusprice.equalsIgnoreCase(order_total))
		   {
			 System.out.println("total amount is matched as expected after adding  to it succefully");
	       }
	    	else
		   {
			System.out.println("total amount is not matched as expected after adding to it");
		   }
    	 System.out.println("Quantity method ends here");
    	}
	
		
		@Test(priority=18)
		public void delete() throws IOException, InterruptedException
		{
		
		order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
		System.out.println("order total before delete item = "+order_total);
	    price1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
		System.out.println("price 1 = "+price1);
	    driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		driver.findElement(By.id(obj.getProperty("Delete"))).click();	
	    String print = driver.findElement(By.id("alertTitle")).getText();
	    System.out.println("Title =>" +print);
	    driver.findElement(By.id(obj.getProperty("Button1"))).click();
	   	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		driver.findElement(By.id(obj.getProperty("Delete"))).click();
	    driver.findElement(By.id(obj.getProperty("Button2"))).click(); 
	     
 		    Double substraction = Double.parseDouble(order_total) - Double.parseDouble(price1);
	        DecimalFormat format = new DecimalFormat("0.00");
	 	    String ordertotalsubdelet = format.format(substraction);
	 	    System.out.println("order total after substraction from total = "+ordertotalsubdelet);
	 	    order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
			System.out.println("order total after delete item = "+order_total);
	         if (ordertotalsubdelet.equalsIgnoreCase(order_total))
	         {
	               System.out.println("Item is deleted succefully and also toatl amonut of order deducted");
	         }
	         else
	         {
	        	    System.out.println("Item is not deleted and also toatl amonut of order not deducted"); 
	         }
	         System.out.println("Delete method ends here");
	        
	       call.Payment1();  
		} 
	
	   }




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


		    /*Float price2 = price1*quantity1;
    		 System.out.println("price2=" +price2);
					String pr2 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1);
					Float price3 = Float.parseFloat(pr2);
					Float order_total2 = price2+order_tota1;
					order_total = driver.findElement(By.id("order_total_upside")).getText().substring(1);
					Float order_tota2 = Float.parseFloat(order_total);
					if (order_tota2==order_total2)
					{
						 System.out.println("Item amount is matched as expected");
					}
					else
					{
						System.out.println("Item amount is not matched as expected");
					}
					
					 System.out.println("HERE");
					
					 System.out.println("price3=" +price3);
					if (price2==price3)
					{
						 System.out.println("Item amount is matched as expected");
					}
					else
					{
						System.out.println("Item amount is not matched as expected");
					}
				 */
				/* 
				 System.out.println("item qauntity get added ");
				 Float b=2f;
					Float abc = price*b;
					 
					 System.out.println("abc value=" +abc);
					String st=Float.toString(abc);
					 System.out.println("st value=" +st);*/
	
		
		/*if(st.equalsIgnoreCase((driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(1)))){
			
			 System.out.println("compare ");
		}
		else{
			 System.out.println("not compare");
		}*/
	
			
				
			
	//;
			
		//driver.findElement(By.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			
			//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[""""]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]
			
			/*try 
			{
				
				{
					System.out.println("Option window is opened");
				}
			}catch(Exception e){
				
				System.out.println("Option window is opened");
			}
			}
		}*/
	

	
