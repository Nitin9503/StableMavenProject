package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.diff_amount;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;

@Listeners(com.torenzo.qa.listener.Listener.class)
public class TillSubmit extends Loginapp
{

	public TillSubmit() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test(priority =27)
   public void tillSubmite()
   {
	   
		driver.findElement(By.id(obj.getProperty("UserDetails"))).click();
		 driver.findElement(By.id(obj.getProperty("TillMgmt"))).click();
		
		 
		 String SubmitCashDrawer =  driver.findElement(By.xpath("//android.widget.TextView[@text='Submit Cash Drawer']")).getText();

		 System.out.println("SubmitCashDrawer =>" +SubmitCashDrawer );
	
		
	       Assert.assertEquals(SubmitCashDrawer, "Submit Cash Drawer", "Till page not found");
		
	   String saleamountfromdatabase =driver.findElement(By.id("sale_amount_from_database")).getText();
	   System.out.println("sale_amount_from_database=>" +saleamountfromdatabase);
	   String  accountedsale=driver.findElement(By.id("accounted_sale")).getText().substring(1);
	   System.out.println("accounted_sale=>" +accountedsale);   
	   String  diff_amount = driver.findElement(By.id("diff_amount")).getText().substring(1);
	   System.out.println(diff_amount);
	   diff_amount =diff_amount.substring(0, diff_amount.length()-3);
	   System.out.println(diff_amount);
	   driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_cent_amount")).click();
	    String[] a = diff_amount.split("");
	    int len=diff_amount.length();
		for(int s=0;s<len; s++)
		{
	    System.out.println(a[s]);
	    driver.findElement(By.xpath("//android.widget.Button[@text='"+a[s]+"']")).click();
       }
   	//driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_cent_amount")).sendKeys(diff_amount);	
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/submit")).click();	
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_till")).click();
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/back_search_list")).click();
		 if(driver.findElement(By.xpath("//android.widget.TextView[@text='AceCafe 1']")).isDisplayed()){
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='AceCafe 1']")).click();
		 int[] i = {1,2,3,4};
		   // System.out.println(i);
		    for(int j=0; j < i.length; j++) {
		    System.out.println("Value at index " + j + ": " + i[j]);
		    driver.findElement(By.xpath("//android.widget.Button[@text='"+i[j]+"']")).click(); //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout[3]/android.widget.ImageView[1]
		                                     }
		    }
	   /*driver.findElement(By.id("edt_cent_amount")).click();
	   driver.findElement(By.id("add_guest_seven")).getText();
	   
	   driver.findElement(By.id("add_guest_one")).getText();
	   driver.findElement(By.id("add_guest_two")).getText();
	   driver.findElement(By.id("add_guest_three")).getText();
	   driver.findElement(By.id("add_guest_four")).getText();
	   driver.findElement(By.id("add_guest_five")).getText();
	   driver.findElement(By.id("add_guest_six")).getText();*/
	   
	   
	   
	   
	
	   
   }
	
	
	
}
