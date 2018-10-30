package com.torenzo.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;

public class VerifyOrderInSuspendedList extends Loginapp{

	public VerifyOrderInSuspendedList() throws IOException {
		super();
	}
   Reusemethod call = new Reusemethod();
   @Test(priority=19)
   public void OrderCreateAndLoadTest() throws IOException, InterruptedException{
	    call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();  
   }
   @Test(priority=20)
   public void loadOrderFromSuspendedListTest() throws Exception{
	   call.loadOrder("Two");
   }
   
   
}
