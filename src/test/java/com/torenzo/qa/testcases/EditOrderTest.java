package com.torenzo.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import static com.torenzo.qa.util.StaticVariable.order_total;
import static com.torenzo.qa.util.StaticVariable.order_no1; 
import static com.torenzo.qa.util.StaticVariable.invoice_no1;
import static com.torenzo.qa.util.StaticVariable.date;
import static com.torenzo.qa.util.StaticVariable.invoice_tillCash;
import static com.torenzo.qa.util.StaticVariable.OrderNo;
import static com.torenzo.qa.util.StaticVariable.Amount;
import static com.torenzo.qa.util.StaticVariable.edit_order_invoice;
@Listeners(com.torenzo.qa.listener.Listener.class)
public class EditOrderTest extends Loginapp {
	
	public EditOrderTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public static String invoice_tillCash;
	public static String OrderNo;
	public static String Amount; 
	//public static String order_no1;
	//public static String edit_order_invoice;*/
	@Test(priority=18)
	public void editorder() throws InterruptedException, IOException
	{
			
		Reusemethod call = new Reusemethod();
		System.out.println("For order and item");
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		System.out.println("For payment");
	    call.Payment1();
	    System.out.println("Swipe admin panel");
		call.swipadmin();
		
		driver.findElement(By.id(obj.getProperty("EditOrder"))).click();
		
		System.out.println("invoice no.for verify=>"+invoice_no1);
		System.out.println("Order no.for verify=>"+order_no1);
		System.out.println("Order amount for verify=>"+order_total);

		try {
			if(driver.findElement(By.id(obj.getProperty("CancelOrderList"))).isDisplayed())
			{
				System.out.println("Edit order window is displayed");
				driver.findElement(By.id("textView")).click();
       			driver.findElement(By.id("decrement")).click();
				driver.findElement(By.id("increment")).click();
				driver.findElement(By.id("btn_done")).click();
				driver.findElement(By.id("search")).click();
				
				for (int i=1;i<50;i++)
				{
				try{
					
					System.out.println("Value of is==>"+i);
					if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())
					{
					String cell = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
					String cell1 = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
					System.out.println("value of cell=>"+cell);
					System.out.println("value of cell=>"+cell1);
					System.out.println("invoice number after paid order"+invoice_no1);
					if (cell.equalsIgnoreCase(invoice_no1))
					{
					System.out.println("Receipt number is matched");
					driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
					driver.findElement(By.id("done")).click();
					break;
				}
				else
				{
					System.out.println("Receipt number is not matched");
			
				
			    }
			    }
			}catch(Exception e)
			{
				System.out.println("Cell not found hence scrolling");
				call.editorderscroll();
				i=i-7;
			}
				
		 }	
				
			}
			}catch(Exception e)
		    {
				System.out.println("Edit order window is not displayed");
			}
		  
		    System.out.println("Verifing same order is opened as comparing order number");
		    String orderid = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).getText();
			System.out.println("Order number is (comparing both value)=>" + order_no1   +orderid);
		    if(order_no1.equalsIgnoreCase(orderid))
		      {
		        	System.out.println("Order no. is matched after paying and now in Edit order");
		      }
		   	else
		  	{
		       	System.out.println("Order no. is not matched after paying and now in Edit order");	
		    }
		    		    
		 System.out.println("Going to till management to check order");	   
	     driver.findElement(By.id(obj.getProperty("UserDetails"))).click();
		 driver.findElement(By.id(obj.getProperty("TillMgmt"))).click();	 
		 String tillPage =  driver.findElement(By.xpath("//android.widget.TextView[@text='Drawer Name :']")).getText();
		 System.out.println("tillPage =>" +tillPage );
	       Assert.assertEquals(tillPage , "Drawer Name :", "Till page not found");
		 driver.findElement(By.id(obj.getProperty("TxtCashDetails"))).click();

		for(int k=1; k<100; k++)
		   {
		 
	       try
			   {
	    	   Thread.sleep(500);
			  	 
			    if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
			    {
			     System.out.println("value of k is==>"+k);
				 invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
				 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
				 Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[1]")).getText().substring(1);
				 System.out.println("Invoice number in till "+invoice_tillCash);
				 System.out.println("Order number in till "+OrderNo);
				 System.out.println("Order amount. number in till "+ Amount);
		  
			 if(invoice_no1.equalsIgnoreCase(invoice_tillCash) && order_total.equalsIgnoreCase(Amount) && order_no1.equalsIgnoreCase(OrderNo))
			 {
					System.out.println("Paid order is checked in Till and check for invoice no. Order no. and Amount all matched ");
				   break;
		     }
			 else
		    {
				System.out.println("Some value is not matched hence the test case failed");
			}
		      }
			    
		   
			   } catch(Exception e){
	
			   System.out.println("Scroll cash view ");
			  call.scrollcashtab();
		      }
		   }
		
		 System.out.println("EditOrder class ends here");
		    System.out.println("All classe are executed with this one");
		}


	}
		

























	/*driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[1]")).click();
	
	 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.Button[1]")).click();
	 System.out.println("reason window");
	 String print = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).getText();
	 System.out.println("Reason=>"+print);
	driver.findElement(By.id("textView ")).sendKeys("Bad food");*/
				
				/*for (int i=1;i<50;i++)
				{
				try{
					
					System.out.println("Value of is==>"+i);
					if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())
					{
				String cell = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
				System.out.println("value of cell"+cell);
				System.out.println("invoice number after paid order"+invoice_no1);
				if (cell.equalsIgnoreCase(invoice_no1))
				{
					System.out.println("Receipt number is matched");
					driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
					driver.findElement(By.id("done")).click();
					break;
				}
				else
				{
					System.out.println("Receipt number is not matched");
			
				
			    }
			    }
			}catch(Exception e)
			{
				System.out.println("Cell not found hence scrolling");
				call.editorderscroll();
				i=i-7;
			}
				
					}	
				
			}
			}catch(Exception e)
		    {
				System.out.println("Edit order window is not displayed");
			}
		String order = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).getText();
		String total=driver.findElement(By.id("order_total_upside")).getText();
		       if (order.equalsIgnoreCase(order_no1)&&total.equalsIgnoreCase(order_total))
		       {
		    	
		    	   System.out.println("Order no. and order amount is matched");
		    	   
		    	  driver.findElement(By.xpath("//android.widget.TextView[@text='Void Order']")).click();
		    	  try {
		    		  if( driver.findElement(By.xpath("//android.widget.TextView[@text='Reasons for void']")).isDisplayed())
		    		  {
		    			  
		    			  System.out.println("User adding reason for void order");
		    			  driver.findElement(By.id("Cancle")).click();
		    		  driver.findElement(By.xpath("//android.widget.TextView[@text='Void Order']")).click();
		    		 String reasonvoid = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).getText(); 
		    		 System.out.println("reason for void" +reasonvoid);
		    		  
		    	  }
		    	  }catch(Exception e)
		    	  {
		    	   
		       }
		       System.out.println("Order no. and order amount is not matched");
		
				}
		}
}	
		
*/
		/*driver.findElement(By.xpath("//android.widget.TextView[@text='PNR9/2018-2019/999']")).click();
		driver.findElement(By.id("done")).click();
		for(int e=0; e<30;e++)
		{
			
			String cell = driver.findElement(By.xpath("//android.widget.LinearLayout[@index="+e+"]")).getText();
		
			System.out.println("Receipt no. on Edit order=>"+cell);
			try{
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[@index="+e+"]")).isDisplayed())
				{
					driver.findElement(By.xpath("//android.widget.TextView[@text='invoice_no1']")).click();
					
					
					
					driver.findElement(By.xpath("//android.widget.LinearLayout[@index="+e+"]")).click();
					String receipt_no = driver.findElement(By.id("invoice_no")).getText();
					System.out.println(" Edit order=>"+cell);
			driver.findElement(By.id("done")).click();
				if(receipt_no == invoice_no1)
				{
					
				}
					
					
					
				}
			}catch (Exception e1)
			{
				call.editorderscroll();
			}
			}
		}
		
}

*/