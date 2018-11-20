package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;
import static com.torenzo.qa.util.StaticVariable.date;
import static com.torenzo.qa.util.StaticVariable.invoice_no1;
import static com.torenzo.qa.util.StaticVariable.ordernofromreceipt;
import static com.torenzo.qa.util.StaticVariable.payment_value;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.util.Reusemethod;
import static com.torenzo.qa.util.StaticVariable.table_No;

public class OrderCreateAndPayThroughSeated extends Loginapp{
	
	Reusemethod call = new Reusemethod();

	public OrderCreateAndPayThroughSeated() throws IOException {
	super();

	}
	@Test(priority=22)
	public void orderWithTable() throws IOException, InterruptedException
	{

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try{
	if(driver.findElement(By.id(obj.getProperty("TableStructureIcon"))).isDisplayed())
	{
	System.out.println("Reloading table structure");

	call.SwapAdmin();
	driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
	/*boolean tableViewPageTitle = adminSettingPage.verifyTableViewDisplay();
	Assert.assertTrue(tableViewPageTitle, "Table view not found inside Admin Settings after swapping");*/
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

	@Test(priority=23)
	public void tableStrucuterVerify(){

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	call.specifyTableFromTableStructure();

	}


	@Test(priority=24)
	public void addguestandItem() throws IOException, InterruptedException
	{

	System.out.println("selecting guest and adding item to them");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));	
	System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());	
	call.selectGuestandAddItem();
	call.seatedPay();

	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
	// Assert.assertTrue(splitReceiptPage.verifySplitReceiptPage(), "Split Receipt Options window not found upon clicking on it");
	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
	Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed(), "single recepit splited but the receipt not splited (FAILED)");
	List<WebElement> puff = driver.findElements(By.id("name"));
	System.out.println("Receipt count is==> " +puff.size());
	ordernofromreceipt = driver.findElement(By.id("order_id")).getText().substring(7);
	System.out.println("Order number is==> " +ordernofromreceipt);
	invoice_no1 = driver.findElement(By.id("invoice_no")).getText().substring(8);
	System.out.println("Invoice numeber is==> " +invoice_no1);
	date = driver.findElement(By.id("date")).getText();
	System.out.println("Date of receipt paid is==> " +date);

	for(WebElement we:puff)
	{
	driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
	// Assert.assertTrue(payingPaymentPage.verifyPayingPaymentWindow(), "Payment window not found upon clicking on PayBill");	
	driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
	payment_value = driver.findElement(By.id("payment_value")).getText().substring(1); 
	driver.findElement(By.id("done_guest")).click();
	driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
	// Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found after paying order(upon clicking on Close Table Without Receipt FAILED) ");
	System.out.println("Order is succefully created and paid");
	Thread.sleep(2000);
	System.out.println("Now navigate bact to home page");
	driver.findElement(By.id("com.torenzo.torenzocafe:id/cancel_table_structure_btn")).click();
	driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
	}

	}

}
