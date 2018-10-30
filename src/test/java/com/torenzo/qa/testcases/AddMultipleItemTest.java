package com.torenzo.qa.testcases;

import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

@Listeners(com.torenzo.qa.listener.Listener.class)
public class AddMultipleItemTest extends Loginapp
{
	Reusemethod call = new Reusemethod();
	
	public AddMultipleItemTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void scrollupitem() throws IOException
	  {
        
			Dimension size = driver.findElement(By.id(obj.getProperty("MenusGridRecyclerView"))).getSize();
			System.out.print("item view size" +size);
			int starty = (int) (size.height * 0.80);
		    int endy = (int) (size.height * 0.20);
    		int startx = size.width / 2;
			System.out.println(starty);
			System.out.println(endy);
			System.out.println(startx);
			 WebElement ele1=(WebElement) driver.findElements(By.id(obj.getProperty("MenusGridRecyclerView"))).get(0);
			System.out.println("value" +ele1);
			TouchAction action = new TouchAction(driver);
			action.longPress(ele1).moveTo(startx,endy).release().perform();	   
	    
	}

	 public void scrollguestview() throws IOException
	   {
	
		 System.out.println("scrolling guest view");
		Dimension sizeguestview = driver.findElement(By.id(obj.getProperty("GuestVerticalRecyclerView"))).getSize();
		System.out.println("guest view size is ==>" +sizeguestview);
		int starty = (int) (sizeguestview.height*0.80);
		int endy = (int) (sizeguestview.height*0.20);
		int startx = sizeguestview.width/2;
		WebElement ele2 = (WebElement) driver.findElements(By.id(obj.getProperty("GuestVerticalRecyclerView"))).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();
	 }


		@Test(priority=10)
		public void TakeoutOrder() throws InterruptedException, IOException
		{
			
			 System.out.println("Order creation process is started for multiple item");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 call.transactionTypeWindow();
    	        
		String order_no=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("Order number is =>" + order_no);
		driver.findElement(By.id(obj.getProperty("AddGuest"))).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_one")).click();
	 	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
		System.out.println("Selecting guest one and adding item to it");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 1']")).click();
		
			for (int i=1; i<11; i++)
			{
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				try{
					 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).isDisplayed())
				{
				driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
				System.out.println("Selecting item and value of i==> " +i);     
		
				}
				try{
			       	if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
						{
							System.out.println("Modifier window is displayed");
						
							try{
								if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
								{
									System.out.println("clicking on modifier ");
									driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
									driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
								
								}
								
							     }catch(Exception e)
								{
							    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
							    	 WebElement custom = driver.findElement(By.id(obj.getProperty("CustomModifierAdd")));
									custom.sendKeys("Spicy");
									WebElement count = driver.findElement(By.id(obj.getProperty("CustomModifierCount")));
									count.sendKeys("2");
									driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
									custom.sendKeys("Extra Spicy");
									count.sendKeys("3");
									driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
									driver.findElement(By.id(obj.getProperty("DoneItemModifie"))).click();
									
								}
						}	
						
					}catch(Exception e)
					  {
						System.out.println("Modifier is not present for the item");
				
						
					  }
		
		  }catch(Exception e)    
				{
					
					System.out.println("scrolling item view");
					scrollupitem();
					i=i-3;
					System.out.println("scrolling for item done");
					
				}
		
			}
	
			
			for (int g=1;g<10;g++)
			{
				try{
					System.out.println("selecting guest 2");
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					if (driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 2']")).isDisplayed())
					{
						System.out.println("Guest two found");
						driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 2']")).click();
						break;
					}
				}catch(Exception e)
				{
					System.out.println("Guest two not found");
					scrollguestview();
				}
			}
			
			
			for (int j=1; j<10; j++)
			{
				try{
				
				if (driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+j+"]")).isDisplayed())
				{
				driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+j+"]")).click();
				System.out.println("Selecting item and value of i==> " +j);     
		
				}
				try{
				 	if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
						{
							System.out.println("Modifier window is displayed");
						
							try{
								if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
								{
									System.out.println("clicking on modifier ");
									driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
									driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
								
								}
								
							     }catch(Exception e)
								{
							    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
							    	 WebElement custom = driver.findElement(By.id(obj.getProperty("CustomModifierAdd")));
									custom.sendKeys("Spicy");
									WebElement count = driver.findElement(By.id(obj.getProperty("CustomModifierCount")));
									count.sendKeys("2");
									driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
									custom.sendKeys("Extra Spicy");
									count.sendKeys("3");
									driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
									driver.findElement(By.id(obj.getProperty("DoneItemModifie"))).click();
									
								}
						}	
						
					}catch(Exception e)
					  {
						System.out.println("Modifier is not present for the item");
				
						
					  }
		
		  }catch(Exception e)    
				{
					
					System.out.println("scrolling item view");
					scrollupitem();
					j=j-3;
					System.out.println("scrolling for item done");
					
				}
		
			}
			
	
			call.Payment();
		
		}		
		
		
		
    }




















        /*public void TakeoutOrder() throws InterruptedException
	   {
		System.out.println("Order creation process is started on swipe logic for guestview and itemview");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       	driver.findElement(By.id("com.torenzo.torenzocafe:id/new_order_create_btn_layout")).click();
        try{
	        if(driver.findElement(By.id("cancel_new_order_select")).isDisplayed())
	         {
	        	
	        	 driver.findElement(By.xpath("//android.widget.TextView[@text='Take-Out']")).click();
	         }
	        
     }catch (Exception e)
     {
		       System.out.println("Transaction type winodw is not displayed");
     }
		String order_no=driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).getText();
		System.out.println("Order number is =>" + order_no);       
	  	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_btn")).click();
	  	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_four")).click();
    	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_done")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='All Items']")).click();	
			
	
		for (int g=0; g<3; g++)
		{
			
			try{
				
				System.out.println("Selecting guest and value of g=>" +g);
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).isDisplayed())
				{
					driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();	
				}
		
				for (int i=3; i<12; i++)
				{
					try{
					
					if (driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).isDisplayed())
					{
					driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
					System.out.println("Selecting item and value of i==> " +i);     
			
					}
					try{
				       	if(driver.findElement(By.xpath("//android.widget.TextView[@text='Apply Modifiers']")).isDisplayed())
							{
								System.out.println("Modifier window is displayed");
							
								try{
									if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
									{
										System.out.println("clicking on modifier ");
										driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
										driver.findElement(By.id("done_item_modifier")).click();
									
									}
									
								     }catch(Exception e)
									{
								    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
								    	 WebElement custom = driver.findElement(By.id("custom_modifier_add"));
										custom.sendKeys("Spicy");
										WebElement count = driver.findElement(By.id("custom_modifier_count"));
										count.sendKeys("2");
										driver.findElement(By.id("add_custom_modifier_btn")).click();
										custom.sendKeys("Extra Spicy");
										count.sendKeys("3");
										driver.findElement(By.id("add_custom_modifier_btn")).click();
										driver.findElement(By.id("done_item_modifier")).click();
										
									}
							}	
							
						}catch(Exception e)
						  {
							System.out.println("Modifier is not present for the item");
					
							
						  }
			
			  }catch(Exception e)    
					{
						
						System.out.println("scrolling item view");
						scrollupitem();
						i=i-3;
						System.out.println("scrolling for item done");
						
					}
			
				}
			}catch (Exception e)
			{
			
				scrollguestview();
				g=g-1;
				System.out.println("SCROLLING GUEST VIEW DONE");
				
			}
		 }
	   }	
*/
		

