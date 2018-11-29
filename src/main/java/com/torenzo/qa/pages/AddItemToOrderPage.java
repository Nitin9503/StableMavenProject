package com.torenzo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.torenzo.qa.base.TestBase;


import java.util.List;
public class AddItemToOrderPage extends TestBase{
	
	public void addItem() throws InterruptedException{
		
		driver.findElement(By.xpath(prop.getProperty("AllItems"))).click();
		List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
		
		System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
		if(guestCountFromOrder.size()<=100)
		{
			
			for(WebElement we:guestCountFromOrder)
			{
				we.click();
				
				for (int i=1; i<3; i++)
				{	Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
					try{
						System.out.println("searching for modifier ");
						if(driver.findElement(By.xpath(prop.getProperty("ModifierOnItem"))).isDisplayed())
						{
							System.out.println("Modifier displayed ");
							try{
								if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
								{
									System.out.println("clicking on modifier ");
									driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
									driver.findElement(By.id(prop.getProperty("DoneItemModifier"))).click();
									
								}
							     }catch(Exception e)
								{
							    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
							    	 WebElement custom = driver.findElement(By.id(prop.getProperty("CustomModifierAdd")));
									custom.sendKeys("Spicy");
									WebElement count = driver.findElement(By.id(prop.getProperty("CustomModifierCount")));
									count.sendKeys("2");
									driver.findElement(By.id(prop.getProperty("AddCustomModifierBtn"))).click();
									custom.sendKeys("Extra Spicy");
									count.sendKeys("3");
									driver.findElement(By.id(prop.getProperty("AddCustomModifierBtn"))).click();
									driver.findElement(By.id(prop.getProperty("DoneItemModifie"))).click();
									
								}
						}
						
					}catch(Exception e)
					{
						System.out.println("Modifier not available for the item");
						
						}
							
						}
				
				List<WebElement>totalItemAddedToOrder = driver.findElements(By.id("com.torenzo.torenzocafe:id/guest_orderd_item_recycler_view"));
				System.out.println("total item added tp item=" +totalItemAddedToOrder.size());
				List<WebElement>swiplayput= driver.findElements(By.id("com.torenzo.torenzocafe:id/swipe_layout"));
				System.out.println("swiplayput=" +swiplayput.size());
				List<WebElement>transaction_type_img= driver.findElements(By.id("com.torenzo.torenzocafe:id/transaction_type_img"));
				System.out.println("transaction_type_img=" +transaction_type_img.size());
				
				Assert.assertEquals(transaction_type_img.size(), 2, "Item count not matched");
				
			
				
			}
			
			
		}
		else{
			
			System.out.println("Guest not Found");
		}

	
		
	}

}
