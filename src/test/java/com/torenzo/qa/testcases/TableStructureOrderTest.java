

package com.torenzo.qa.testcases;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;

import io.appium.java_client.TouchAction;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;
import static com.torenzo.qa.util.StaticVariable.homePageTitle ;

@Listeners(com.torenzo.qa.listener.Listener.class)

public class  TableStructureOrderTest extends Loginapp{


	 Reusemethod call = new Reusemethod();
	
	 	 
	public TableStructureOrderTest() throws IOException {
		super();
	
	}

	@Test(priority=0)
		public void orderWithTable() throws IOException, InterruptedException
		{


		
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
    	try{
	    	 if(driver.findElement(By.id(obj.getProperty("TableStructureIcon"))).isDisplayed())
			 {
			  System.out.println("Reloading table structure");
		
			  call.SwapAdmin();
			/* boolean adminPanelTitile = adminSettingPage.verifyAdminSettingPanel();
			 Assert.assertTrue(adminPanelTitile, "Admin Panel not found");*/
			 driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
			 /*boolean tableViewPageTitle = adminSettingPage.verifyTableViewDisplay();
             Assert.assertTrue(tableViewPageTitle, "Table view not found inside Admin Settings after swapping");*/
		     driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
	         }
				 
	      }catch (Exception e)
		  {
			    System.out.println("verifying table strucuture");
			    call.SwapAdmin();
				/*boolean adminPanelTitile = adminSettingPage.verifyAdminSettingPanel();
				Assert.assertTrue(adminPanelTitile, "Admin Panel not found");*/
			    driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
			    /*boolean tableViewPageTitle = adminSettingPage.verifyTableViewDisplay();
                Assert.assertTrue(tableViewPageTitle, "Table view not found inside Admin Settings after swapping ");*/
		        driver.findElement(By.id(obj.getProperty("TableviewDisplay"))).click();
		      driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
	      }
		}
	
	@Test(priority=1)
	public void tableStrucuterVerify(){
	
		/*  boolean titleofTablestructure = tableStructurePage.verifyTableStructurePage();
		  Assert.assertTrue(titleofTablestructure, "Table structure page is not found after relaoding table from Admin setting");*/
		 System.out.println("PASS");
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    call.checkForEmptyTable();
	          
		       }

		
	@Test(priority=2)
	 public void addguestandItem() throws IOException, InterruptedException
	 {
         
		System.out.println("selecting guest and adding item to them");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));		
		System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
		System.out.println("addedGuestToOrder = " +addedGuestToOrder);
		String change = Integer.toString(guestCountFromOrder.size());
		System.out.println("change = " +change);
		Assert.assertEquals(addedGuestToOrder, change, "Guest are not matched to each other after adding from party size to order page");
		call.selectGuestandAddItem();
		 Thread.sleep(3000);
		String	str=driver.findElement(By.xpath("//android.widget.Button[@text='Cash']")).getText();
		System.out.println("str==>" +str);
		 Thread.sleep(3000);
			driver.findElement(MobileBy.id("com.torenzo.torenzocafe:id/cash")).click();
		 Thread.sleep(3000);
	
	 }
      	
			@Test(priority=3)
			 public void paymentorder() throws IOException, InterruptedException
			 {
			
/*			 call.Payment();
		System.out.println("Table structure class end here");		
*/	
				}
			
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
