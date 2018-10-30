package com.torenzo.qa.testcases;

import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;
@Listeners(com.torenzo.qa.listener.Listener.class)
public class SwappingItemTest extends Loginapp{

	Reusemethod call= new Reusemethod();

	public SwappingItemTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=11)
	public void swapitem() throws InterruptedException, IOException
    {
	
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
        List<WebElement> allitem = driver.findElements(By.id("transaction_type_img"));
       	System.out.println("Total item for order is=> " +allitem.size());
 
    	List<WebElement> totalguest = driver.findElements(By.id("quest_name"));
    	System.out.println("Total guest for order is=> " +totalguest.size());
    	int itemperguest = allitem.size()/totalguest.size();
    	System.out.println("Item per guest is=> " +itemperguest);
    	System.out.println("SWAPPING, MOVING AND DELETE GUEST");
    	
    	TouchAction press = new TouchAction (driver);
    
     	WebElement guest1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 1']"));
    	WebElement guest2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 2']"));
    	WebElement guest3 = driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 3']"));
    	
    	System.out.println("Pressing on guest1");
    	Thread.sleep(5000);
    	press.press(guest1).perform();
    	try{
    		if(driver.findElement(By.xpath(obj.getProperty("GuestProperties"))).isDisplayed())
    		{
    			System.out.println("Swapping items from guest1 to guest2");
    			driver.findElement(By.id(obj.getProperty("SwapAllItemsWithGuest"))).click();
	    		driver.findElement(By.xpath("//android.widget.TextView[@text='Back']")).click();
	    		driver.findElement(By.id(obj.getProperty("SwapAllItemsWithGuest"))).click();
    			try{
    				if(driver.findElement(By.xpath(obj.getProperty("SelectGuest"))).isDisplayed())
    				{
    					driver.findElement(By.xpath("//android.widget.TextView[@text='Guest  2']")).click();
    	    			driver.findElement(By.id("button1")).click();
    	    			driver.findElement(By.xpath("//android.widget.TextView[@text='Guest  2']")).click();
    	    			driver.findElement(By.id("button2")).click();
    					
    				}
    			  }catch(Exception e)
    			  {
    				System.out.println("Guest window is not displayed");
    				e.printStackTrace();
    			  }
    			
    	    
    		}
    		
    	 }catch(Exception e)
    	  {
    	  	System.out.println("WINDOW IS NOT DISPLAYED TO SWAP");
    		e.printStackTrace();
    	
    	 }
    	
    	
    	try{
    		System.out.println("Pressing on guest3");
    		press.press(guest3).perform();
    		if(driver.findElement(By.xpath(obj.getProperty("GuestProperties"))).isDisplayed())
    		{
    			System.out.println("Moving items from guest2 to guest3");
    			driver.findElement(By.id(obj.getProperty("MoveAllItemsToGuest"))).click();
    			try{
    				if(driver.findElement(By.xpath(obj.getProperty("SelectGuest"))).isDisplayed())
    				{
    					driver.findElement(By.xpath("//android.widget.TextView[@text='Guest  2']")).click();
    	    			driver.findElement(By.id("button1")).click();
    	    			driver.findElement(By.xpath("//android.widget.TextView[@text='Guest  2']")).click();
    	    			driver.findElement(By.id("button2")).click();
    					
    				}
    			}catch(Exception e)
    			{
    				System.out.println("Guest window is not displayed");
    				e.printStackTrace();
    			}
    			
    	    	
    		}
    		
    	}catch(Exception e)
    	{
      		System.out.println("WINDOW IS NOT DISPLAYED TO MOVE");
    		e.printStackTrace();
    	}
    	
      System.out.println("Pressing on guest2");
    	press.press(guest2).perform();
    	try{
    		
    		if(driver.findElement(By.xpath(obj.getProperty("GuestProperties"))).isDisplayed())
    		{
    			System.out.println("Moving items from guest3 to guest2");	    			
    			driver.findElement(By.id(obj.getProperty("DeleteGuestText"))).click();
    			driver.findElement(By.id("button1")).click();
    			driver.findElement(By.id(obj.getProperty("DeleteGuestText"))).click();
	     		driver.findElement(By.id("button2")).click();
    			driver.findElement(By.xpath("//android.widget.TextView[@text='Guest  1']")).click();
    			List<WebElement> totalguest1 = driver.findElements(By.id("quest_name"));
    			System.out.println("Total guest for order is=>" +totalguest1.size());
    			if(totalguest.size()==totalguest1.size())
    			{
    				System.out.println("Guest is not deleted");
    			}
    			else{
    				System.out.println("Guest is successfully deleted");
    			}
    			
   
    		}
    		
    	}catch(Exception e)
    	{
      		System.out.println("WINDOW IS NOT DISPLAYED TO DELETE");
    		e.printStackTrace();
    	}
    	  	
		    System.out.println("Pressing on guest1");
		    press.press(driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 1']"))).perform();
			System.out.println("Adding guest info to order");
			driver.findElement(By.id(obj.getProperty("AddGuestIdentification"))).click();
			try{
			if(driver.findElement(By.xpath(obj.getProperty("AddGuestIdentificationWindow"))).isDisplayed())
			{
			driver.findElement(By.id("select_from_existing_text")).click();
			
				System.out.println("Searching existance customer with number");	
				driver.findElement(By.id("number_search")).sendKeys("123456789");
					 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
					 driver.findElement(By.id("done_guest")).click();
			
	try{
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='Akash']")).isDisplayed())
		{
			System.out.println("Guest successfully added to order");	
			
	}
	}catch(Exception e)
	{
		System.out.println("Guest is not added to order");	
	}
	}
	}catch(Exception e)
	{
		System.out.println("Guest window is not displayed");
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 3']")).click();
	driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='1']")).click();
    

	call.Payment();

	
    
}

}
