package com.torenzo.qa.pages;


import static com.torenzo.qa.util.StaticVariable.order_total;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
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
    	   
    	   return guestName.get(1);
    	   
    	 /*  TouchAction action = new TouchAction(driver);
   		action.longPress(longPressOptions().withElement(element(guestName.get(1))).withDuration(ofSeconds(2))).release().perform();
		*/
       }
				
			public double totalItemValue(){
				
				double totalPrice = 0;
				
				for (WebElement element : totalItemAddedAmount){
					
					System.out.println("Item wise price" +Double.valueOf(element.getText().substring(1)));
					totalPrice = totalPrice + Double.valueOf(element.getText().substring(1));
				}
				
				System.out.println("totalPrice " +totalPrice);
				return totalPrice;
			}
			
			public String orderTotal(){
		
					System.out.println("Item wise price" +orderTotal.getText());
					return orderTotal.getText();
			}
	
			
			public void selectGuestandAddItem() throws IOException, InterruptedException
			{			
				Thread.sleep(3000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		      	List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
				System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
			    this.clickAllCategoryItemButton();
			
				for(WebElement we:guestCountFromOrder)
					{
						we.click();
					 	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
						for (int i=1; i<2; i++)
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
	















	/*@Test(priority = 0)
	public void Allitemwithoutmodifier() throws InterruptedException, IOException
	{
	
	   
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Order creation process is started with takeout");
	 
	   	 driver.findElement(By.id(obj.getProperty("CreateNewOrder"))).click();
	      	
         try{
    	        if(driver.findElement(By.id(obj.getProperty("CancelNewOrder"))).isDisplayed())
    	         {
    	        	
    	        	 driver.findElement(By.xpath(obj.getProperty("TakeOutOrder"))).click();
    	         }
    	        
         }catch (Exception e)
         {
 		       System.out.println("Catching transaction type exception");
         }
	    	        
	   order_no1=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("order_no1 in ordercreation is =>" + order_no1);
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
		Thread.sleep(5000);
		
			for (int i=2; i<9; i++)
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
				try{
					System.out.println("searching for modifier ");
					if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
					{
						System.out.println("Modifier displayed ");
						
						driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
								
							}
					
					
				}catch(Exception e)
				{
					System.out.println("Catch exception");
					
					}
						
					}
          }

}
*/