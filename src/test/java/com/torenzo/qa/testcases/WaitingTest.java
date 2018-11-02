package com.torenzo.qa.testcases;

//import static  com.torenzo.qa.util.Constants.add_guest_done;
import static  com.torenzo.qa.util.StaticVariable.b;
import static  com.torenzo.qa.util.StaticVariable.guestname;
import static  com.torenzo.qa.util.StaticVariable.partysize;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;
import static com.torenzo.qa.util.StaticVariable.customername1;

public class WaitingTest extends Loginapp{

	public WaitingTest() throws IOException {
		super();
	}

	Reusemethod call = new Reusemethod();
	@Test(priority = 27)
	public void verifyTableViewIcon(){
		
		         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		    	try{
			    	 if(driver.findElement(By.id(obj.getProperty("TableStructureIcon"))).isDisplayed())
					 {
					  System.out.println("Reloading table structure");
					  call.SwapAdmin();
					 driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
					 
				     driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
			         }
						 
			      }catch (Exception e)
				  {
					    System.out.println("verifying table strucuture");
					    call.SwapAdmin();
					    driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
					    
				        driver.findElement(By.id(obj.getProperty("TableviewDisplay"))).click();
				        driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
			      }
				}
   
	@Test(priority=28)
	public void verifyWaiting() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("table_guest_list")).click(); 
		System.out.println("tapping on waiting section tab");
	    driver.findElement(By.id("com.torenzo.torenzocafe:id/waiting_btn")).click(); 
		
		//verify add new reservation tab with blank data showing error message or not
       	// driver.findElement(By.id("com.torenzo.torenzocafe:id/add_waiting_btn")).click(); 
       	// driver.findElement(By.id("android:id/button1")).click(); 
		 //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
	
		
	  //typing customer name here
		 Thread.sleep(3000);
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name")).sendKeys(customername1);
		 
		 guestname = driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name")).getText();
		 System.out.println(guestname);
    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_wait_customer")).click(); 
		 
		 //entering party size here
    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/new_wait_party_size")).click(); 
   		 System.out.println("entering party size");
   		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click(); 
		 driver.findElement(By.id("add_guest_done")).click(); 
		 Thread.sleep(2000);
         partysize =driver.findElement(By.id("com.torenzo.torenzocafe:id/new_wait_party_size")).getText();
         System.out.println(partysize);
         driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_contact_no")).sendKeys("8876584341");
     	// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
     		
        //entering Email address here
        driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_email")).sendKeys("Navin@gmail.com");
        call.addTagsAndAllergies();
        driver.findElement(By.id("com.torenzo.torenzocafe:id/add_waiting_btn")).click(); 
    }
	@Test(priority=29)
	public void waitingTranasfer() throws Exception{
		   System.out.println("opening waiting list");
	       driver.findElement(By.id("com.torenzo.torenzocafe:id/waiting_btn")).click();
	   //driver.findElement(By.id("com.torenzo.torenzocafe:id/search_waiting")).sendKeys(customername1);
	       call.serachForReservationAndWaitingFromList();
	       Thread.sleep(3000);
	       String st= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
		   System.out.println(st);
	       System.out.println("The value st as shown as  "+st);
	       if(st.equalsIgnoreCase("Transfer To Table"))
	             {
	       	   System.out.println(b);
			   // driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			   driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
               System.out.println("specify table verifying");
	           //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
	           System.out.println("click on transfer table button1");
	           System.out.println("specify table verifying");
	           //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
	           //driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	           // System.out.println("click on transfer table button1");
	           call.specifyTableFromTableStructure();
	             }    
           else
            {
           System.out.println("tap on transfer table2");
	       driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	       System.out.println("click on transfer table successfully");
           }
            
	      
	       call.selectGuestandAddItem();
	       call.Payment();
		
		
	       //driver.findElement(By.id("com.torenzo.torenzocafe:id/cancel_table_structure_btn")).click();
	}
	
}
