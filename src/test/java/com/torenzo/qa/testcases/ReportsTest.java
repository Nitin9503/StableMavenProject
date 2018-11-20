package com.torenzo.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.torenzo.qa.util.StaticVariable.payment;
import static com.torenzo.qa.util.StaticVariable.customdiscount;
import static com.torenzo.qa.util.StaticVariable.customreason;
import static com.torenzo.qa.util.StaticVariable.OrderTotalfromreport;
import static com.torenzo.qa.util.StaticVariable.Headername;
import static com.torenzo.qa.util.StaticVariable.order_no1;
import static com.torenzo.qa.util.StaticVariable.order_total;
import static com.torenzo.qa.util.StaticVariable.PaymentTotal;
import static com.torenzo.qa.util.StaticVariable.OrderNoInReport;
import static com.torenzo.qa.util.StaticVariable.ordstatusinreport;
import static com.torenzo.qa.util.StaticVariable.processing;
import static com.torenzo.qa.util.StaticVariable.paid;
import static com.torenzo.qa.util.StaticVariable.ordernofromreceipt;
import static com.torenzo.qa.util.StaticVariable.payment_value;




import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.mysql.jdbc.Driver;
import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;
@Listeners(com.torenzo.qa.listener.Listener.class)
public class ReportsTest extends Loginapp{

	
		Reusemethod call = new Reusemethod();
		ItemModificationTest call1 = new ItemModificationTest();
	

	public ReportsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*@Test(priority = 22)
	public void discountverify() throws IOException, InterruptedException{
		
		Reports call1 = new Reports();
		call.Allitem();
		call1.reprotsection();
		 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
		
	}*/
	@Test(priority = 39)
	public void ordercreate() throws IOException, InterruptedException{
		ReportsTest call2 = new ReportsTest();
		call.transactionTypeWindow();
		call.addGuestToOrder();
		call.selectGuestandAddItem();
		call.Payment1();
		call2.reprotsection();
		// driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
		
	}
		@Test(priority=40)
	public void orderpaid() throws IOException, InterruptedException
		{
			ReportsTest call2 = new ReportsTest();
			call.transactionTypeWindow();
			call.addGuestToOrder();
			call.selectGuestandAddItem();
		    call2.reprotsection();
			 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
			
		}
		

       String order[] = {"paid", "order_no1","order_total" };	
	
	
		
		public void reprotsection() throws IOException, InterruptedException{
		
		driver.findElement(By.id(obj.getProperty("UserDetails"))).click();
		String title  = driver.findElement(By.xpath("//android.widget.TextView[@text='User Details']")).getText();
		System.out.println("Hello==>" +title);		
		Assert.assertEquals(title, "User Details", "User details window not opened");
		driver.findElement(By.id(obj.getProperty("Report"))).click();		
		System.out.println("Main array of Report");
		 String customerReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Customer Report']")).getText();
		 String inventoryReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Inventory Report']")).getText();
		 String orderReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Order Report']")).getText();
		 String salesReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Sales Report']")).getText();
		 String discountReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Discount Report']")).getText();
		 String miscellaneousReport=driver.findElement(By.xpath("//android.widget.TextView[@text='Miscellaneous Report']")).getText();
		// String mSwipeReport=driver.findElement(By.xpath("//android.widget.TextView[@text='MSwipe Report']")).getText();
		 
		 String report [] = {"customerReport", "inventoryReport", "orderReport", "salesReport", "discountReport", "miscellaneousReport" ,"mSwipeReport"};	
         //String mSwipesubreport [] = {"paymentDetailed", "salesDetailed", "tillsReport"};
		 	
		
		
		 for(int i=0; i<report.length; i++)
		 {			 
			 if(report[i].equalsIgnoreCase("customerReport"))
			 {
			
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Customer Report']")).click();
				 String customerList = driver.findElement(By.xpath("//android.widget.TextView[@text='Customer List']")).getText();
				 String customerListsubreport [] = {"customerList"};
				 for (int c=0; c<customerListsubreport.length; c++)
				 {
					 if(customerListsubreport[c].equalsIgnoreCase("customerList"))
					 {
				
				 	 try{
					 driver.findElement(By.xpath("//android.widget.TextView[@text='Customer List']")).click();
					 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
						if(present)
						{
						driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
						Headername = driver.findElement(By.id("header_category_name")).getText();
						System.out.println("Headername==>" +Headername);
					 }
					
					 }catch(Exception e)
					 {

							System.out.println("Here 3");
							break;
						 
					 }
					 }
				 }
		    }
			 
					 
			 else if(report[i].equalsIgnoreCase("inventoryReport"))
			 {
			
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Inventory Report']")).click();

				 String inventoryDetails = driver.findElement(By.xpath("//android.widget.TextView[@text='Inventory Details']")).getText();
				 String rawMaterialDetails = driver.findElement(By.xpath("//android.widget.TextView[@text='Raw Material Details']")).getText();
				 String inventorysubreport [] = {"inventoryDetails", "rawMaterialDetails"};
				 System.out.println("Here 33");
				 
				 for (int d=0; d<inventorysubreport.length; d++)
				 {
					 
					 if(inventorysubreport[d].equalsIgnoreCase("inventoryDetails"))
					 {
				
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Inventory Details']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
					
						 if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
							System.out.println("Here 6");	
							
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Inventory Stock"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
						}
					}
							else
							{
								System.out.println("No canccel window");
							
							}						 
					 }
					 else if(inventorysubreport[d].equalsIgnoreCase("rawMaterialDetails")){
				
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Raw Material Details']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
						 System.out.println("Here 34");
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Raw Material Stock"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }		
				 }	
				 System.out.println("Inventory report end here"); 
				 }
	 
			 
			 
		 
			 
			 else if(report[i].equalsIgnoreCase("orderReport"))
			 {
				
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Order Report']")).click();
				 String orderDetails = driver.findElement(By.xpath("//android.widget.TextView[@text='Order Details']")).getText();
				 String ordersubreport [] = {"orderDetails"};
				 for (int e=0; e<ordersubreport.length; e++)
				 {
					 
					 if(ordersubreport[e].equalsIgnoreCase("orderDetails"))
					 {
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Order Details']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
						 
							if(present)
							{
							 driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
							
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Order Details"))
							{
				
								for (int k=1; k<30; k++)
								{
									try{
								boolean present1 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]")).isDisplayed();		
								if(present)
								{

								
									OrderNoInReport = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
									ordstatusinreport = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.TextView[1]")).getText();
									PaymentTotal =	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[10]/android.widget.TextView[1]")).getText();
								OrderTotalfromreport =	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.TextView[1]")).getText();
							
								
								System.out.println("OrderNoInReport=>"+OrderNoInReport);
								System.out.println("PaymentTotal=>"+PaymentTotal);
								System.out.println("ordstatusinreport=>"+ordstatusinreport);
								System.out.println("OrderTotalfromreport=>"+OrderTotalfromreport);
								
								
							    Double chng= Double.parseDouble(OrderTotalfromreport);
								System.out.println("chng===" +chng);
								DecimalFormat formate = new DecimalFormat("0.00");
								String value = formate.format(chng);
								System.out.println("chng===" +value);
								  Double chng1 = Double.parseDouble(PaymentTotal);
								
								if(ordstatusinreport.equalsIgnoreCase("paid") )
								{
									
									System.out.println("ordernofromreceipt comparing =>"+ordernofromreceipt);
									System.out.println("payment_value comparing =>"+payment_value);
									System.out.println("OrderNoInReport=>"+OrderNoInReport);
									System.out.println("PaymentTotal=>"+PaymentTotal);
									System.out.println("order has some amount then entered here= PAID");
								if(ordernofromreceipt.equalsIgnoreCase(OrderNoInReport) && payment_value.equalsIgnoreCase(PaymentTotal))
								{
									
									System.out.println("order is matched");
									System.out.println("order is " +ordstatusinreport);
									break;
									
								}
								else{
									System.out.println("order is not matched");
									
								}
								}
								else{
									
									System.out.println("order has no amount then entered here - IN PROCESSING");
									System.out.println("order_total comparing =>"+order_total);
									System.out.println("order_no1 cpmaparing=>"+order_no1);
									System.out.println("OrderNoInReport=>"+OrderNoInReport);
									System.out.println("comparinf value ===" +value);
									
									if(OrderNoInReport.equalsIgnoreCase(order_no1) && value.equalsIgnoreCase(order_total))
									{
										
										System.out.println("order is matched");
										System.out.println("order is " +ordstatusinreport);
										break;
										
									}
									else{
										System.out.println("order is not matched");
										
									}

								}
								
								
	
									}
							
									}catch(Exception e1)
								{

									call.scrollreport();
									k = k - 10;	
								}
								
		      		}	
							driver.findElement(By.id("layout_arrow")).click();
							System.out.println("break for title");
							break;
							
							}	
							else{
								
								System.out.println("Title is not matched");
								call.reportswap();
							}
						
							}
							
							}
							else
							{
								System.out.println("no canccel window");
							
							}						 			 
				 }
					
			 }
				 System.out.println("Order report end here");
		 }
		
			
			 
	 
			 
     	 else if(report[i].equalsIgnoreCase("salesReport"))
			 {

				 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales Report']")).click();

				 String salesByCategory = driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Category']")).getText();
				 String salesByDepartment = driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Department']")).getText();
				 String dailySalesByCashier = driver.findElement(By.xpath("//android.widget.TextView[@text='Daily Sales By Cashier']")).getText();
				 String performanceByCategory = driver.findElement(By.xpath("//android.widget.TextView[@text='Performance By Category']")).getText();
				 String voidRefundReport = driver.findElement(By.xpath("//android.widget.TextView[@text='Void Refund Report']")).getText();
				 String salesByWaiter = driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Waiter']")).getText();
				 String discountSummary = driver.findElement(By.xpath("//android.widget.TextView[@text='Discount Summary']")).getText();
				 String salesByItem = driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Item']")).getText();
				 String endDayReport = driver.findElement(By.xpath("//android.widget.TextView[@text='End Day Report']")).getText();
				 String summeryandDetailedSales = driver.findElement(By.xpath("//android.widget.TextView[@text='Summary and Detailed Sales']")).getText();
				 String productWiseSalesReport = driver.findElement(By.xpath("//android.widget.TextView[@text='Product Wise Sales Report']")).getText();
				 System.out.println("in after Sales Report");	
				 String salesByCategorysubreport [] = {"salesByCategory", "salesByDepartment" ,"dailySalesByCashier" ,"performanceByCategory", "voidRefundReport","salesByWaiter" ,"discountSummary" ,"salesByItem", "endDayReport", "summeryandDetailedSales", "productWiseSalesReport" };
				Thread.sleep(500);
				 for (int z=0; z<salesByCategorysubreport.length; z++)
				 {
					 if(salesByCategorysubreport[z].equalsIgnoreCase("salesByCategory"))
					 {

						 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Category']")).click();
						
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
						 System.out.println("Here 34");
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();								
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								
								System.out.println("Headername==>" +Headername);
								
							if(Headername.equalsIgnoreCase("Sales By Category"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
			 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("salesByDepartment")){
			
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Department']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();

							Thread.sleep(500);
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Sales By Department"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("dailySalesByCashier")){
			
						 try{
		
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Daily Sales By Cashier']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();	
							Thread.sleep(500);
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Daily Sales By Cashier"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
						 }catch(Exception e)
							{
								System.out.println("no canccel window");
							
							
							}						 
					 }
		 			 
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("performanceByCategory")){
						 try{

						 driver.findElement(By.xpath("//android.widget.TextView[@text='Performance By Category']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();

							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();

							Thread.sleep(500);
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Performance By Category"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
						 }catch(Exception e)
							{
								System.out.println("No canccel window");
							
							}						 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("voidRefundReport")){
		
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Void Refund Report']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();

							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();						
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Void/Refund Report"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("salesByWaiter")){

						 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Waiter']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
					
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
					
							Thread.sleep(500);
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Sales By Waiter"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("discountSummary")){
	
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Discount Summary']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
				
							Thread.sleep(500);
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Discount Summary"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("salesByItem")){
				
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales By Item']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Sales By Item"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("endDayReport")){
		
						 driver.findElement(By.xpath("//android.widget.TextView[@text='End Day Report']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();					
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("End Day Report"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("summeryandDetailedSales")){
	
						try{
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Summary and Detailed Sales']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
		
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();

							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Summary and Detailed Sales"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
						}catch(Exception e)
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 
					 else if(salesByCategorysubreport[z].equalsIgnoreCase("productWiseSalesReport")){
					
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Product Wise Sales Report']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
                 		for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Productwise Sales"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						 
					 }
					 
				
					
					 }	
				 System.out.println("Sales report end here");
				 }
				 	
			 
			 
			 else if(report[i].equalsIgnoreCase("discountReport"))
			 {
			 
			driver.findElement(By.xpath("//android.widget.TextView[@text='Discount Report']")).click();
			String itemDiscount = driver.findElement(By.xpath("//android.widget.TextView[@text='Item Discount']")).getText();
				 String orderDiscount = driver.findElement(By.xpath("//android.widget.TextView[@text='Order Discount']")).getText();
				 String discountsubreport [] = {"itemDiscount", "orderDiscount"};
				 for (int d=0; d<discountsubreport.length; d++)
				 {
					 
					 if(discountsubreport[d].equalsIgnoreCase("itemDiscount"))
					 {
		
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Item Discount']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();

							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();							
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Item Discount"))
							{
								System.out.println("TITLE IS MATCHED");
								
								System.out.println("order_total=>"+customreason );
								System.out.println("order_no1=>"+order_no1);
								System.out.println("ordernofromreceipt=>"+ordernofromreceipt);
								System.out.println("payment_value=>"+customdiscount);
							
						
							driver.findElement(By.id("layout_arrow")).click();
							System.out.println("break for title");
							break;
							
							}	
	
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
						
					 }
		
					 
					 else if(discountsubreport[d].equalsIgnoreCase("orderDiscount")){
						
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Order Discount']")).click();
						 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
						 System.out.println("Here 34");
							if(present)
							{
							driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
							System.out.println("Here 6");	
						
							for (int t =1; t<30; t++)
							{
								Headername = driver.findElement(By.id("header_category_name")).getText();
								System.out.println("Headername==>" +Headername);
							if(Headername.equalsIgnoreCase("Order Discount"))
							{
								System.out.println("TITLE IS MATCHED");
								driver.findElement(By.id("layout_arrow")).click();
								break;
						 
					          }
							else{
								System.out.println("TITLE IS NOT MATCHED");
								call.reportswap();
								
							}
							}
							}
							else
							{
								System.out.println("No canccel window");
							
							}
					 
					 }
						System.out.println("Order discount end here");	
				 }
			 }
			 
			 
			 else if(report[i].equalsIgnoreCase("miscellaneousReport"))
			 {
		
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Miscellaneous Report']")).click();
		     	 String paymentDetailed = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment Detailed']")).getText();
				 String salesDetailed = driver.findElement(By.xpath("//android.widget.TextView[@text='Sales Detailed']")).getText();
				 String tillsReport = driver.findElement(By.xpath("//android.widget.TextView[@text='Tills Report']")).getText();

				 	String miscellaneoussubreport [] = {"paymentDetailed", "salesDetailed","tillsReport"};
				 	 for (int d=0; d<miscellaneoussubreport.length; d++)
					 {
						 
						 if(miscellaneoussubreport[d].equalsIgnoreCase("paymentDetailed"))
						 {
						
							 driver.findElement(By.xpath("//android.widget.TextView[@text='Payment Detailed']")).click();
							 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
					
								if(present)
								{
								driver.findElement(By.id(obj.getProperty("DoneReport"))).click();								
								for (int t =1; t<30; t++)
								{
									Headername = driver.findElement(By.id("header_category_name")).getText();
									System.out.println("Headername==>" +Headername);
								if(Headername.equalsIgnoreCase("Payment Details"))
								{
									System.out.println("TITLE IS MATCHED");
									driver.findElement(By.id("layout_arrow")).click();
									break;
							 
						          }
								else{
									System.out.println("TITLE IS NOT MATCHED");
									call.reportswap();
									
								}
								}
								}
								else
								{
									System.out.println("No canccel window");
								
								}
							 						 
						 }
						 
						 else if(miscellaneoussubreport[d].equalsIgnoreCase("salesDetailed")){
					
							 try{
							 driver.findElement(By.xpath("//android.widget.TextView[@text='Sales Detailed']")).click();
							 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
								if(present)
								{
								driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
			
								for (int t =1; t<30; t++)
								{
									Headername = driver.findElement(By.id("header_category_name")).getText();
									System.out.println("Headername==>" +Headername);
								if(Headername.equalsIgnoreCase("Sales Detailed"))
								{
									System.out.println("TITLE IS MATCHED");
									driver.findElement(By.id("layout_arrow")).click();
									break;
							 
						          }
								else{
									System.out.println("TITLE IS NOT MATCHED");
									call.reportswap();
									
								}
								}
								}
							 }catch(Exception e)
								{
									System.out.println("no canccel window");
								
								}
							 
						 }
						 else if(miscellaneoussubreport[d].equalsIgnoreCase("tillsReport")){
						
							 try{
							 driver.findElement(By.xpath("//android.widget.TextView[@text='Tills Report']")).click();
							 boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
	
								if(present)
								{
								driver.findElement(By.id(obj.getProperty("DoneReport"))).click();	
								for (int t =1; t<30; t++)
								{
									Headername = driver.findElement(By.id("header_category_name")).getText();
									System.out.println("Headername==>" +Headername);
								if(Headername.equalsIgnoreCase("Tills Report"))
								{
									System.out.println("TITLE IS MATCHED");
									driver.findElement(By.id("layout_arrow")).click();
									break;
							 
						          }
								else{
									System.out.println("TITLE IS NOT MATCHED");
									call.reportswap();
									
								}
								}
								}
							 }catch(Exception e)
								{
									System.out.println("No canccel window");
								
								}
							 
						 }
					 
					 
					 }
					 	
					 System.out.println("Missceleneousreport end here");	
			 }
			 
			 /*else if(report[i].equalsIgnoreCase("mSwipeReport"))
			 {
				 log.info("************************************MSwipe Report**********************************************"); 
				 driver.findElement(By.xpath("//android.widget.TextView[@text='MSwipe Report']")).click();
				 System.out.println("This module yet to be implement");	 
			 }*/
							 
			 else
			 {
				 System.out.println("all are fails");	 
			 }		 
			 
			 System.out.println("main for loop");	 
			 
		 }
		 System.out.println("doneeeeee");	
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Back']")).click();
		 
	}
	
}
		
		 
		 
		 
	



		 
		/*driver.findElement(By.id(obj.getProperty("UserDetails"))).click();
		String ttitle  = driver.findElement(By.xpath("//android.widget.TextView[@text='User Details']")).getText();
		System.out.println("Hello==>" +title);		
		Assert.assertEquals(title, "User Details", "User details window not opened");
		
		driver.findElement(By.id(obj.getProperty("Report"))).click();
		//String tab = driver.findElement(By.xpath("//android.widget.TextView[@text='Customer Report']")).getText();
	//	System.out.println(tab);
	//	Assert.assertEquals(tab, "Customer Report", "Reprot section is not opened");
		
		System.out.println("Here 4");
		for (int r = 1; r<=7; r++)
		{
			System.out.println("first");
			String optionreport = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+r+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
			System.out.println("Reprot of option===>" +optionreport);
			System.out.println("Here 5");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+r+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		for(int k =1; k <=15; k++)
	    {
			System.out.println("Here 55");
			try{
		boolean present1 =driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView["+k+"]")).isDisplayed();
		if(present1)
		{
			System.out.println("value of opetion==>" +driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView["+k+"]")).getText());
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView["+k+"]")).click();
			
			boolean present = driver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).isDisplayed();
			if(present)
			{
			driver.findElement(By.id(obj.getProperty("DoneReport"))).click();
			System.out.println("Here 6");	
			Headername = driver.findElement(By.id("header_category_name")).getText();
			System.out.println("Headername==>" +Headername);
			for (int l=1; l<=20; l++)
			if (Headername.equalsIgnoreCase(driver.findElement(By.id("header_category_name")).getText()))
			{
				System.out.println("Title is matched ");
				driver.findElement(By.id("layout_arrow")).click();
				break;
			}
			else
			{
				System.out.println("Title is not matched ");
				call.reportswap();
			}	
				    	
		
			
		}
			else{
				System.out.println("Here 77");
				Assert.assertTrue(present, "Cancle window is not displayed");
			}

		System.out.println("Here 7");
		}
		}catch(Exception e)
		{
	System.out.println("looking for next report");
		}
	     break;
       }
		
		}
		}    
	}*/
		
		
		
	
		
		//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]

		
		
		


