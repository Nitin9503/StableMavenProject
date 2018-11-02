package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.add_guest_done;
import static com.torenzo.qa.util.StaticVariable.ReserTime;
import static com.torenzo.qa.util.StaticVariable.b;
import static com.torenzo.qa.util.StaticVariable.customername1;
import static com.torenzo.qa.util.StaticVariable.partysize;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

import io.appium.java_client.TouchAction;

public class ReservationTest extends Loginapp{


	public ReservationTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Reusemethod call = new Reusemethod();
	@Test(priority = 22)
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
	
	@Test(priority = 23)
	 public void verifyReservation()throws InterruptedException{		 
   	 	driver.findElement(By.id("table_guest_list")).click(); 
   	 	System.out.println("verify add new reservation tab with blank data showing error message or not");
   	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_reservation_btn")).click();    	 
   	 	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
   	 	System.out.println("It shown error message so verified add new reservation tab successfully");	
   	 	//typing customer name here
   	 	Thread.sleep(3000);
   	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_party_name")).sendKeys(customername1);
   	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_customer")).click(); 	 
   	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/new_tbl_party_size")).click(); 
   	 	System.out.println("entering party size");
   	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_three")).click(); 
   	 	driver.findElement(By.id(add_guest_done)).click(); 
   	 	partysize =driver.findElement(By.id("com.torenzo.torenzocafe:id/new_tbl_party_size")).getText();
   	 	System.out.println(partysize);
   	 	//selecting table below code
   	    System.out.println("specify Table");
  	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/specify_tbl")).click(); 
  		System.out.println("selecting table");
   
  		call.specifyTableFromTableStructure();
        call.selectDateAndTime();
   	
        //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[2]")).click();
 	    //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys("9564648258");
	    //entering contact no here
        driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_contact_no")).sendKeys("9876584341");
	    //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
	   
        //entering Email address here
        driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_email")).sendKeys("David@gmail.com");
 
        //selecting tags
        call.addTagsAndAllergies();
	
	    //Tap onAdd reservation tab
	    driver.findElement(By.id("com.torenzo.torenzocafe:id/add_reservation_btn")).click();  
     }
	@Test(priority=24)
	public void reservationTransfer() throws Exception{
	         driver.findElement(By.id("com.torenzo.torenzocafe:id/reservation_btn")).click();
		     System.out.println("click on Reservation button");
		     call.serachForReservationAndWaitingFromList();
		     //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
			 //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
			 String st= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
			 // String st= driver.findElement(By.id("com.torenzo.torenzocafe:id/table_name")).getText();
		     System.out.println(st);
		   if(st.equalsIgnoreCase("Specify Table"))
		             {
		                System.out.println("specify table verifying");
		            	//driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
		                driver.findElement(By.id("com.torenzo.torenzocafe:id/transfer_tbl")).click();
		                System.out.println("click on transfer table button1");
		            	System.out.println("specify table verifying");
		                //driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
		            	// System.out.println("click on transfer table button1");
	                    call.specifyTableFromTableStructure();
		          }    
		    else
	                 {
	                    System.out.println("tap on transfer table2");
	        	      //  driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	                    driver.findElement(By.id("com.torenzo.torenzocafe:id/transfer_tbl")).click();
	        	       
	        	        System.out.println("click on transfer table successfully");
	                     } 
		   call.selectGuestandAddItem();

	}
	
	
	}


