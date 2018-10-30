package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.invoice_no1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.TouchAction;

public class VoidRefundTest extends Loginapp{

	public VoidRefundTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
       
	Reusemethod call = new Reusemethod();
	@Test(priority=0)
	public void voidOrder(){
		call.swipadmin();
		driver.findElement(By.id(obj.getProperty("EditOrder"))).click();
	
		String present= driver.findElement(By.id(obj.getProperty("CancelOrderList"))).getText();
		
		Assert.assertEquals(present, "Cancel", "Edit Order Window not Found");	
				System.out.println("Edit order window is displayed");
				driver.findElement(By.id("textView")).click();
       			driver.findElement(By.id("decrement")).click();
				driver.findElement(By.id("increment")).click();
				driver.findElement(By.id("btn_done")).click();
				driver.findElement(By.id("search")).click();
		try{	
					if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())
					{
						driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
						driver.findElement(By.id("done")).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					}
		}catch(Exception e)
		{
				System.out.println("Cell not found hence scrolling");
			
			}
				
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String print=driver.findElement(By.xpath("//android.widget.Button[@text='Void Order']")).getText();
WebElement	ele=driver.findElement(By.xpath("//android.widget.Button[@text='Void Order']"));
TouchAction action = new TouchAction(driver);
action.longPress(ele);
action.perform();
	System.out.println("print" +print);
	String print1 =driver.findElement(By.xpath("//android.widget.Button[@text='Refund Order']")).getText();
	System.out.println("print1" +print1);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.Button[@text='Void Order']")).click();
	String print2=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[1]")).getText();
	System.out.println("print2" +print2);
	String print3 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.Button[1]")).getText();
	System.out.println("print3" +print3);
	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[1]")).click();
	System.out.println("passed");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("com.torenzo.torenzocafe:id/transaction")).click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]")).click();
		System.out.println("passed1");
	}
	
}
