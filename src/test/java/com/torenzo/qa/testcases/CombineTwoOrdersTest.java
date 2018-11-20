package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.order_no1;
import static com.torenzo.qa.util.StaticVariable.taskNo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.TouchAction;
import junit.framework.Assert;

public class CombineTwoOrdersTest extends Loginapp {

	TouchAction action;
	Reusemethod call = new Reusemethod();
	
	public CombineTwoOrdersTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test(priority=0)
	public void createOrderAndtabOnCombine() throws InterruptedException, IOException{
	
		/*Thread.sleep(3000);
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();*/
		
		Thread.sleep(3000);
		String str=driver.findElement(By.xpath(obj.getProperty("ClickOnCombine"))).getText();
		System.out.println("str==>" +str);
		driver.findElement(By.xpath(obj.getProperty("ClickOnCombine"))).click();
		Thread.sleep(3000);
		boolean PaybillXpath =driver.findElement(By.xpath(obj.getProperty("PaybillXpath"))).isDisplayed();
		Assert.assertTrue(PaybillXpath);
		System.out.println("tabOnCombine done");
		
		for (int t=1; t<40; t++){
			WebElement	ele=driver.findElement(By.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+t+"]"));		
			WebElement	element2 =  driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+t+"]"));
           action = new TouchAction(driver);
           action.longPress(ele).moveTo(element2).release().perform();
           
           if(t==2){            
        	   
        	   break;
           }
           else{
        		System.out.println("T value is not two"); 
           }
			
		}
		
		for (int g=1; g<40; g++){
			try{
			if (driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout["+g+"]/android.widget.ImageView[1]")).isDisplayed())
			{
			WebElement	guestFromOrder = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout["+g+"]/android.widget.ImageView[1]"));
			WebElement	orderView = driver.findElement(By.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]"));
			action = new TouchAction(driver);
	        action.longPress(guestFromOrder).moveTo(orderView).release().perform();
	           
	         try{
	           
	           if(driver.findElement(By.id("com.torenzo.torenzocafe:id/alertTitle")).isDisplayed())
	           {
	        	String  orderMoveFrom = driver.findElement(By.id("android:id/message")).getText();
	        	
	        	System.out.println("orderMoveFrom==>" +orderMoveFrom); 
	        	
	        	  driver.findElement(By.id(obj.getProperty("Button2"))).click(); 
	        	   break;
	           }
	         }catch(Exception e){
	        	  
	        		System.out.println("Confirmation popup is not diplayed (Guest yet to be move)"); 
	           }
	           
			
			}
			}catch(Exception e){
				System.out.println("All guest are moved "); 
			}
		}
		
		
		}
	
	/*@Test(priority=1)
	public void searchOrder(){		
		System.out.println("order_no1=>"+order_no1);	
		driver.findElement(By.id(obj.getProperty("SearchOrderCombine"))).sendKeys(order_no1);
		 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		System.out.println("dateFromSystem=>" +dateFormat.format(date));	
		for(int t=1; t<40; t++){
		try{
		if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+t+"]")).isDisplayed())
		{	
	    System.out.println("cell found");
		String currentDate = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+t+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText().substring(0, 11);
		System.out.println("currentDate=>"+currentDate);			
		String orderNoFromOrdertab  = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+t+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]")).getText();
		System.out.println("orderNoFromOrdertab=>"+orderNoFromOrdertab);
		System.out.println("currentDate=>"+currentDate);
		System.out.println("order_no1=>"+order_no1);
		System.out.println("dateFromSystem=>" +dateFormat.format(date));	
		 
		if(order_no1.equalsIgnoreCase(orderNoFromOrdertab) && dateFormat.format(date).equalsIgnoreCase(currentDate))
		{
	    System.out.println("order no. and date are matched ");
		WebElement	ele=driver.findElement(By.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+t+"]"));
		WebElement	element2 =  driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]"));
		action = new TouchAction((driver));	
		action.longPress(ele).waitAction(3000).moveTo(element2).release().perform();  	 
		 System.out.println("Hello1");
		 break;
		}
		else{
			 System.out.println("order no. and date are not matched, Looking for next cell");
		}
		}
	}catch(Exception e){
		
		System.out.println("cell not found hence scrolling");
		call.combineOrderList();
		t=t-5;
	}
	
		
	}
	}
	
	@Test(priority=2)
	public void createGroup() throws InterruptedException{
    
			Thread.sleep(3000);
			driver.findElement(By.id(obj.getProperty("GuestGroupsTabCombine"))).click();
			driver.findElement(By.id(obj.getProperty("GroupAddButton"))).click();
			driver.findElement(By.id(obj.getProperty("GroupAddButton"))).click();
	}
			
		@Test(priority=3)		
		public void moveGuestToGroup() throws InterruptedException{	
		       
			 System.out.println("moveGuestToGroup method");
		       Thread.sleep(2000);
		 //      WebElement element1 = driver.findElement(By.id("com.torenzo.torenzocafe:id/guest_layout"));
				List<WebElement>ele1 = driver.findElements(By.id("com.torenzo.torenzocafe:id/guest_layout"));
     			WebElement group1 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"));
				WebElement group2 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"));

		for(int t=1; t<20; t++){

				try{
				if (driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout["+t+"]/android.widget.ImageView[1]")).isDisplayed())
					
				{
			 System.out.println("PASS");	
			 WebElement	element = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout["+t+"]/android.widget.ImageView[1]"));
					
		    if(t<2){
		    		 System.out.println("PASS2");
		 			 action = new TouchAction((driver));
		 			 action.longPress(element).waitAction(3000).moveTo(group1).release().perform();
	 		
		    		  }
		    else{
		    	 System.out.println("PASS3");
		    	  	action = new TouchAction((driver));
	 				action.longPress(element).waitAction(3000).moveTo(group2).release().perform();
	 				 System.out.println("PASS3");  
		    }
   	
				}
		       	
			}catch(Exception e){
		
				 System.out.println("All guest are moved from order to group");
				 break;
			}
			
		}						
		}
		

		@Test(priority=4)
		public void createTask() throws InterruptedException{
			Thread.sleep(3000);
			driver.findElement(By.id(obj.getProperty("CombineTaskSaveIcon"))).click();
			boolean cancelButton=driver.findElement(By.id(obj.getProperty("CancelOrderList"))).isDisplayed();
			System.out.println("cancelButton==>" +cancelButton);
			Assert.assertTrue("Task window not opened upon clicking on Save Combine task", cancelButton);
 			taskNo =driver.findElement(By.id(obj.getProperty("SearchOrderCombine"))).getText();
			System.out.println("taskNo==>" +taskNo);
			driver.findElement(By.id(obj.getProperty("SaveTask"))).click();
		
		}

		@Test(priority=5)
		public void selectTaskFromList() throws InterruptedException{
  
		 Thread.sleep(3000);			
		  driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.ImageView[1]")).click();
		  boolean taskListWindowTitle = driver.findElement(By.xpath(obj.getProperty("CombineOrderTasks"))).isDisplayed();
		  Assert.assertTrue("TaskList window not opened upon clicking on TaskList button", taskListWindowTitle);					
		 
		  for(int t=1; t<30; t++){
				
			  try{
				if (driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+t+"]/android.widget.LinearLayout[1]")).isDisplayed())
						{
					
					String taskNoInList = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+t+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
					System.out.println("taskNoInList==>" +taskNoInList);
					try{
						
						if (taskNoInList.equalsIgnoreCase(taskNo))
						{
							System.out.println("Task Are matched");
							driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+t+"]/android.widget.LinearLayout[1]")).click();				           
							break;
						}

					}catch(Exception e){
						
						System.out.println("here in catch");
						
					}
		
				}
				}catch(Exception e){
					System.out.println("cell not found");
					call.scrollCombineOrderList();
					t=t-5;
					
				}

			}
		}
		
		@Test(priority=6)
		public void payment() throws InterruptedException{
			
			call.paymentByCombine();
			System.out.println("Done");
		}*/
	

}
       