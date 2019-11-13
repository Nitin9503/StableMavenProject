package com.torenzo.qa.pages;


import static com.torenzo.qa.util.StaticVariable.order_total;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.*;
public class OrderPage extends TestBase{
    
	public static double value;
	public double singleModiferValue;

	 public OrderPage(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='All Items']")
		public WebElement allCategoryItemButton;
	 
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Guest 1']")
		public WebElement guestFirstClick;
	 
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Guest 2']")
		public WebElement guestSecondClick;
	 
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Guest 3']")
		public WebElement guestThirdClick;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/guest_name")
		public List<WebElement> guestName;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/order_no")
		public WebElement orderNumberFromOrderPage;
	 
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_btn")
		public WebElement addGuestBtn;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/order_total_upside")
		public WebElement orderTotal;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/ordered_item_price")
		public List<WebElement> totalItemAddedAmount;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/ordered_item_name")
		public List<WebElement> orderedItemName;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/qty_grid")
		public List<WebElement> itemQuantity;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/menu_price_grid")
		public List<WebElement> menuItemPrice;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/ordered_item_qty")
		public List<WebElement> orderedItemQuantity;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/ordered_item_modifier_name")
		public List<WebElement> orderedItemModifierName;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/value")
		public List<WebElement> orderedModifierPrice;
		
		
	 public String getTextorderNumberFromOrderPage() throws InterruptedException{
		 
				return orderNumberFromOrderPage.getText();
			}
	 
	 public void clickAllCategoryItemButton() throws InterruptedException{
		    allCategoryItemButton.click();
		
		}
	 public GuestPage clickOnAddGuestBtn() throws InterruptedException, IOException{
			
		 addGuestBtn.click();
		 return new GuestPage(driver);
		}
	 
	 public boolean getTextFromFirstGuest() throws InterruptedException{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return guestFirstClick.isDisplayed();
		}
	 
			public void clickOnFirstGuest() throws InterruptedException{
		
				guestFirstClick.click();
			}
			
			public void clickOnSecondGuest() throws InterruptedException{
			
				guestSecondClick.click();
			}
			public void clickOnThirdGuest() throws InterruptedException{
	
				guestThirdClick.click();
			}
			
			public int totolGuestCount() throws InterruptedException{
				
				Thread.sleep(3000);
				System.out.println("count==" +guestName.size());
				return guestName.size();
		
			}
       public WebElement guestClick(){   	   
    	   return guestName.get(0);    	   
    	 /*  TouchAction action = new TouchAction(driver);
   		action.longPress(longPressOptions().withElement(element(guestName.get(1))).withDuration(ofSeconds(2))).release().perform();
		*/
       }
       
       
       public String orderedItemModifierName(int i){   	
    	   return orderedItemModifierName.get(i).getText().trim();   
       }
       
       public boolean orderedItemModifierNameForContinueRegular(String str){       
    	   for (WebElement element :orderedItemModifierName){
    		  
    		   if (element.getText().equals(str)){
    			  System.out.println("element.getText()==>" +element.getText()); 
    			  return false ;
    		   }
    		   else{
    			   System.out.println("Selected modifier and click continue the with without modifier modifier is not present on order(PASS)");    			      		   }	   
    	   }
    	  return true; 
       }
       
       
       public int totalModifier(){
    	 return  orderedItemModifierName.size();
       }
       
       public String orderedModifierPrice(int i , String s){   	  
	    		String str = orderedModifierPrice.get(i).getText().substring(1).trim();  
	    		return str.replace(str, s);
       }
       
       public String orderedCustomModifierPrice(int i){   	  
   		return orderedModifierPrice.get(i).getText().substring(1).trim();  
   		
       }
       
       public String orderedDefaultModifierPrice(int i){   	  
      		return orderedModifierPrice.get(i).getText().substring(1).trim();  
      		
          }
       
       public double orderedDefaultModifierPrice1(int i){   
    	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     		return Double.valueOf(orderedModifierPrice.get(i).getText().substring(2).trim());  
         }
       
       
       
       public double itemQuantity(){   	
    	 //  System.out.println("Item Quantity==>" +Double.valueOf(itemQuantity.get(0).getText().substring(4)));
    	   return Double.valueOf(itemQuantity.get(0).getText().substring(4));    	   
       }
      
		
       public String menuItemPrice(){  	   
    	   DecimalFormat df = new DecimalFormat("#0.00");
    	  String value = df.format(Double.valueOf(menuItemPrice.get(0).getText().substring(7)));
    	  System.out.println("value==>" +value);
    	// double value1 = Double.valueOf(value);
    	  // System.out.println("value1==>" +value1); 
    	 //  System.out.println("Menu item price==>" +Double.valueOf(menuItemPrice.get(0).getText().substring(7)));    	  
    	   return  value;   
       }
	public double totalItemValue(){			
				double totalPrice = 0;				
				for (WebElement element : totalItemAddedAmount){				
					System.out.println("Item wise price" +Double.valueOf(element.getText().substring(1)));
					totalPrice = totalPrice + Double.valueOf(element.getText().substring(1)) + singleModiferValue;
				}
				
				System.out.println("totalPrice " +totalPrice);
				return totalPrice;
			}
			
			public double singleItemValueFromOrder(int i){				
				double totalPrice = 0;
				System.out.println("Item wise price" +Double.valueOf(totalItemAddedAmount.get(i).getText().substring(1)));
				totalPrice = totalPrice + Double.valueOf(totalItemAddedAmount.get(i).getText().substring(1));					
				System.out.println("totalPrice " +totalPrice);
				return totalPrice;
			}
			
			public String singleItemPriceFromOrder(int i){						
				System.out.println("Item wise price in String" +(totalItemAddedAmount.get(i).getText().substring(1)));
				return totalItemAddedAmount.get(i).getText().substring(1);		 				
			
			}
			
			public String orderTotal(){
		
					System.out.println("Item wise price" +orderTotal.getText());
					return orderTotal.getText();
			}
	
			public void clickOnOrderedItem(int i){			
				orderedItemName.get(i).click();
			}
			
			public double orderedItemQuantity(int i){			
				return Double.valueOf(orderedItemQuantity.get(i).getText());
			}
	
			public void selectGuestandAddItem() throws IOException, InterruptedException
			{			
				Thread.sleep(3000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		      	List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
				System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
			    this.clickAllCategoryItemButton();
			    value = this.itemQuantity();
				for(WebElement we:guestCountFromOrder)
					{
						we.click();
					 	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
						for (int i=1; i<3; i++)
						{	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
							try{
								System.out.println("searching for modifier ");
								if(driver.findElement(By.xpath("//android.widget.TextView[@text='Apply Modifiers']")).isDisplayed())
								{
									System.out.println("Modifier displayed ");
									try{
										if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
										{
											System.out.println("clicking on modifier ");
										 singleModiferValue = Double.valueOf(ItemOperationPage.modifierPrice.get(0).getText().substring(1));
										System.out.println("singleModiferValue==>" +singleModiferValue );	
										 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
											
											driver.findElement(By.id("done_item_modifier")).click();
											
										}
									     }catch(Exception e)
										{
									    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
									    	 WebElement custom = driver.findElement(By.id("custom_modifier_add"));
											custom.sendKeys("Spicy");
											WebElement count = driver.findElement(By.id("custom_modifier_count "));
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
								System.out.println("Modifier not available for the item");
								
								}
									
								}	
						
					}
			
	}
	 
}
	
