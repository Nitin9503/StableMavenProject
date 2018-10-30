package com.torenzo.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.torenzo.qa.base.TestBase;

import io.appium.java_client.TouchAction;

public class ScrollMethod extends TestBase{

	
	   public void swipAdmin()
	       {
		     
		      double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
		      Dimension size = driver.manage().window().getSize();
		      System.out.println("size of element" +size);
		      int anchor = (int) (size.height * anchorPercentage);
			  int startPoint = (int) (size.width * startPercentage);
			  int endPoint = (int) (size.width * finalPercentage);
			  new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
			  System.out.println("Swipe admin setting done");
	}
	
		
	public void scrollUpOnSeatedList() throws InterruptedException{
		
	     	Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']")).getSize();		
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);	    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
			System.out.println(starty);
			System.out.println(endy);
			System.out.println(startx);
				// Swipe from Bottom to Top.
		
			WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']"))).get(0);
			System.out.println("value" +ele2);
			TouchAction action = new TouchAction(driver);
			action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
	 }
	
	
	public void scrollCashTab()
	{
		Dimension size = driver.findElement(By.id("cash_details_tab_recycler_view")).getSize();
		System.out.println("edit view size==>"+size);
		int starty = (int) (size.height*0.80);
		int endy = (int) (size.height*0.20);
		int startx = size.width/2;
		WebElement ele=(WebElement)driver.findElements(By.id("cash_details_tab_recycler_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(starty, endy).release().perform();
		
		
	}
	
	
	public void editOrderScroll()
	{
		System.out.println("Scrolling edit view");
		Dimension size = driver.findElement(By.id("edit_order_recycleview")).getSize();
		System.out.println("edit view size==>"+size);
		int starty = (int) (size.height*0.20);
		int endy = (int) (size.height*0.80);
		int startx = size.width/2;
		WebElement ele = (WebElement) driver.findElements(By.id("edit_order_recycleview")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		System.out.println("Scrolling edit view done");
		

	}
	
	
	public void scrollReport()
	{
		System.out.println("Scrolling reprot section for matching");
		Dimension size= driver.findElement(By.id("all_report_view")).getSize();
		int statry =  (int) (size.height*0.80);
		int endy = (int) (size.height*0.20);              
		int startx = size.width/2;
		WebElement ele=(WebElement) driver.findElements(By.id("all_report_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();	
		
	}
	
	
	public void reportSwap()
	{
		double startPercenatge =0.01; double finalPercentage =0.9; double anchorPercentage = 0.5; int duration = 200;
		Dimension size=driver.manage().window().getSize();
		int anchor = (int) (size.height*anchorPercentage);
		int startPoint = (int) (size.width*startPercenatge);
		int endPoint = (int) (size.width * finalPercentage);	
		TouchAction action = new TouchAction(driver);
		action.press(endPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(startPoint, anchor).release().perform();
	}
			
	public void scrollUpOnWaitingList() throws Exception {

		Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']")).getSize();	
		System.out.println(size);
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
			// Swipe from Bottom to Top.
		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']"))).get(0);
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();	   
			Thread.sleep(2000);
		}
	
		public void scrollUpOnResevationList() throws Exception {
		Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']")).getSize();
		System.out.println(size);		
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']"))).get(0);
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();	   
			Thread.sleep(2000);
		}
 
        public void scrollOncashDetailIntill() throws InterruptedException{
		Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']")).getSize();
					
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
					    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
			System.out.println(starty);
			System.out.println(endy);
			System.out.println(startx);
						// Swipe from Bottom to Top.
			WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']"))).get(0);
			System.out.println("value" +ele2);
			TouchAction action = new TouchAction(driver);
			action.longPress(ele2).moveTo(startx,endy).release().perform();	   
						//driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(2000);
			 }
 
        public void scrollUpOnOrderList() throws Exception {
		
		Dimension size = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]")).getSize();
		System.out.println(size);
		// Find swipe start and end point from screen’s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
	 
		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
			int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
			// Swipe from Bottom to Top.

		//WebElement ele2 = (WebElement) driver.findElements(By.xpath(("android.support.v7.widget.RecyclerView[contains(@resource-id,'orders_list_recycler_view') and @index='0']"))).get(0);
		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]"))).get(0);
		
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,starty).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
 
 
}
