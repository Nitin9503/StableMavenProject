package com.torenzo.qa.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TransactionOrderPage;

import static com.torenzo.qa.util.StaticVariable.Amount;
import static com.torenzo.qa.util.StaticVariable.Discount;
import static com.torenzo.qa.util.StaticVariable.OrderNo;
import static com.torenzo.qa.util.StaticVariable.invoice_no;
import static com.torenzo.qa.util.StaticVariable.invoice_noNckot;
import static com.torenzo.qa.util.StaticVariable.invoice_tillCash;
import static com.torenzo.qa.util.StaticVariable.invoice_tillNCKOT;
import static com.torenzo.qa.util.StaticVariable.table_No;
import static com.torenzo.qa.util.StaticVariable.invoice_no1;
import static com.torenzo.qa.util.StaticVariable.order_total;
import static com.torenzo.qa.util.StaticVariable.order_no1;
import static com.torenzo.qa.util.StaticVariable.Amount;
import static com.torenzo.qa.util.StaticVariable.Discount;
import static com.torenzo.qa.util.StaticVariable.DiscountR;
import static com.torenzo.qa.util.StaticVariable.OrderNo;
import static com.torenzo.qa.util.StaticVariable.Order_No;
import static com.torenzo.qa.util.StaticVariable.invoice_no;
import static com.torenzo.qa.util.StaticVariable.invoice_tillCash;
import static com.torenzo.qa.util.StaticVariable.total_amount;
import static com.torenzo.qa.util.StaticVariable.DiscountR;
import static com.torenzo.qa.util.StaticVariable.OrderID;
import static com.torenzo.qa.util.StaticVariable.Order_No;
import static com.torenzo.qa.util.StaticVariable.Order_To;
import static com.torenzo.qa.util.StaticVariable.table_name;
import static com.torenzo.qa.util.StaticVariable.total_amount;
import static com.torenzo.qa.util.StaticVariable.ReserTime;
import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;
import static com.torenzo.qa.util.StaticVariable.b;
import static com.torenzo.qa.util.StaticVariable.customername1;
import static com.torenzo.qa.util.StaticVariable.date;
import static com.torenzo.qa.util.StaticVariable.homePageTitle;
import static com.torenzo.qa.util.StaticVariable.payment;
import static com.torenzo.qa.util.StaticVariable.ordernofromreceipt;
import static com.torenzo.qa.util.StaticVariable.partysize;
import static com.torenzo.qa.util.StaticVariable.payment_value;

public class Reusemethod extends Loginapp {
	/*
	 * PaymentPage paymentPage = new PaymentPage(driver); SplitReceiptPage
	 * splitReceiptPage =new SplitReceiptPage(); PayingPaymentPage
	 * payingPaymentPage = new PayingPaymentPage(); HomePage homePage = new
	 * HomePage(driver); GuestPage guestPage = new GuestPage(driver); OrderPage
	 * orderPage = new OrderPage(driver); TransactionOrderPage
	 * transactionOrderPage = new TransactionOrderPage(driver);
	 */

	public Reusemethod() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void checkForEmptyTable() {
		System.out.println("Searching for empty Table");

		for (int t = 1; t <= 41; t++) {
			System.out.println("value of t is" + t);
			System.out.println("increment ");
			driver.findElement(By.xpath("//android.widget.Button[@index=" + t + "]")).click();
			try {
				if (driver.findElement(By.xpath(obj.getProperty("TableOptions"))).isDisplayed()) {
					System.out.println(" Busy ");

					// ((AndroidDriver)
					// driver).pressKeyCode(AndroidKeyCode.BACK);
					driver.pressKeyCode(AndroidKeyCode.BACK);

				}
			} catch (Exception e)

			{
				/*
				 * Boolean partySizeWindowTitle =
				 * guestPage.verifytitleOfPartySizeInTable();
				 * Assert.assertTrue(partySizeWindowTitle,
				 * "Party Size window not found in table structure");
				 */
				System.out.println("table is free and adding guest");
				addedGuestToOrder = driver.findElement(By.id("add_guest_three")).getText();
				driver.findElement(By.id("add_guest_three")).click();
				driver.findElement(By.id(obj.getProperty("DoneEmployeeList"))).click();
				break;

			}
			t++;
		}

	}

	public void transactionTypeWindow() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Order creation process is started with takeout");

		driver.findElement(By.id(obj.getProperty("CreateNewOrder"))).click();

		try {
			if (driver.findElement(By.id("com.torenzo.torenzocafe:id/cancel_new_order_select")).isDisplayed()) {

				driver.findElement(By.xpath(obj.getProperty("TakeOutOrder"))).click();
			}

		} catch (Exception e) {
			System.out.println("TakeOut order is created");
		}

	}

	public void addGuestToOrder() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String guestNameOrder = driver.findElement(By.xpath("//android.widget.TextView[@text='Guest 1']")).getText();
		System.out.println("guestNameOrder==" + guestNameOrder);
		Assert.assertEquals(guestNameOrder, "Guest 1",
				"Order not created after creating order (Guest is not added to order)");
		System.out.println("Order created succefully");
		order_no1 = driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("Order number is =>" + order_no1);
		driver.findElement(By.id(obj.getProperty("AddGuest"))).click();
		String editGuestWindow = driver.findElement(By.xpath("//android.widget.TextView[@text='Edit Guest']"))
				.getText();
		Assert.assertEquals(editGuestWindow, "Edit Guest", "Edit Guest window not found");
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
		driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
	}

	public void selectGuestandAddItem() throws IOException, InterruptedException {
		Thread.sleep(5000);
		List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
		System.out.println("guestCountFromOrder = " + guestCountFromOrder.size());
		try {
			if (driver.findElement(By.id("com.torenzo.torenzocafe:id/table_name")).isDisplayed()) {
				table_No = driver.findElement(By.id("com.torenzo.torenzocafe:id/table_name")).getText();
			}
		} catch (Exception e) {
			System.out.println("Order is not created by table structure");

		}

		try {
			if (driver.findElement(By.xpath(obj.getProperty("AllItems"))).isDisplayed()) {
				driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
			}

		} catch (Exception e) {
			System.out.println("All category button is not displayed");
		}

		for (WebElement we : guestCountFromOrder) {
			we.click();

			for (int i = 1; i < 3; i++) {
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="
								+ i + "]"))
						.click();
				try {
					System.out.println("searching for modifier ");
					if (driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed()) {
						System.out.println("Modifier displayed ");
						try {
							if (driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']"))
									.isDisplayed()) {
								System.out.println("clicking on modifier ");
								driver.findElement(By
										.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']"))
										.click();
								driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();

							}
						} catch (Exception e) {
							System.out.println(
									"Modifier is not present on modifier window hence entering custom modifier");
							WebElement custom = driver.findElement(By.id(obj.getProperty("CustomModifierAdd")));
							custom.sendKeys("Spicy");
							WebElement count = driver.findElement(By.id(obj.getProperty("CustomModifierCount")));
							count.sendKeys("2");
							driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
							custom.sendKeys("Extra Spicy");
							count.sendKeys("3");
							driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
							driver.findElement(By.id(obj.getProperty("DoneItemModifie"))).click();

						}
					}

				} catch (Exception e) {
					System.out.println("Modifier not available for the item");

				}

			}

			/*
			 * List<WebElement>totalItemAddedToOrder =
			 * driver.findElements(By.id(
			 * "com.torenzo.torenzocafe:id/guest_orderd_item_recycler_view"));
			 * System.out.println("total item added tp item="
			 * +totalItemAddedToOrder.size()); List<WebElement>swiplayput=
			 * driver.findElements(By.id(
			 * "com.torenzo.torenzocafe:id/swipe_layout"));
			 * System.out.println("swiplayput=" +swiplayput.size());
			 * List<WebElement>transaction_type_img= driver.findElements(By.id(
			 * "com.torenzo.torenzocafe:id/transaction_type_img"));
			 * System.out.println("transaction_type_img="
			 * +transaction_type_img.size());
			 */

		}
		order_total = driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).getText().substring(1);
		System.out.println("Order total on order page " + order_total);

	}

	public void Allitemwithoutmodifier() throws InterruptedException, IOException {

		// String guestNameOrder =
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Guest
		// 1']")).getText();
		// System.out.println("guestNameOrder==" +guestNameOrder);
		// Assert.assertEquals(guestNameOrder, "Guest 1", "Order not created");
		System.out.println("Order created succefully");
		order_no1 = driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("order_no1 in ordercreation is =>" + order_no1);
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
		Thread.sleep(5000);

		for (int i = 2; i < 7; i++) {
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index=" + i + "]"))
					.click();

			try {
				System.out.println("searching for modifier ");
				if (driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed()) {
					System.out.println("Modifier displayed ");

					driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();

				}
			} catch (Exception e) {
				System.out.println("Catch exception");

			}

		}
	}

	public void Payment() throws IOException, InterruptedException {

		List<WebElement> guest = driver.findElements(By.id("guest_name"));
		System.out.println("Guest count is ==>" + guest.size());

		driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).click();
		invoice_no = driver.findElement(By.id("com.torenzo.torenzocafe:id/invoice_no")).getText().substring(8);
		System.out.println(invoice_no);
		// Assert.assertEquals(paymentPage.verifyPaymentPagetitle(), "PayBill",
		// "Payment Page not found created order and went for order");
		driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();
		if (guest.size() <= 1) {
			System.out.println("Spliting receipt for single guest only");
			driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
		} else {
			System.out.println("Spliting receipt for split per guest");
			driver.findElement(By.id(obj.getProperty("SplitPerGuest"))).click();
		}
		List<WebElement> puff = driver.findElements(By.id("name"));
		System.out.println("Receipt count is==> " + puff.size());
		Assert.assertEquals(puff.size(), guest.size(),
				"Splited receipt as per guest and receipts are not splited as per guest (Failed)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		for (WebElement we : puff) {
			Thread.sleep(4000);

			we.click();
			driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
			driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
			driver.findElement(By.id(obj.getProperty("DoneGuest"))).click();
			driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
			System.out.println("Click on Close table without receipt and entring into try");
			try {
				driver.findElement(By.id(obj.getProperty("ContinueWithoutClosingTable"))).click();
			} catch (Exception e) {

				System.out.println("Order is Paid");

			}
		}
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']"))
				.click();

	}

	public void paymentByCombine() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> totalGroupCount = driver.findElements(By.id(obj.getProperty("GuestLayout")));
		System.out.println("totalGroupCount is==> " + totalGroupCount.size());
		driver.findElement(By.xpath(obj.getProperty("PaybillXpath"))).click();
		List<WebElement> puff = driver.findElements(By.id("name"));
		System.out.println("Receipt count is==> " + puff.size());
		Assert.assertEquals(totalGroupCount.size(), puff.size(),
				"Receipt are not splited as per grop from combin order");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);

		for (WebElement we : puff) {
			Thread.sleep(4000);
			we.click();
			driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
			driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
			driver.findElement(By.id(obj.getProperty("DoneGuest"))).click();
			driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
			System.out.println("Click on Close table without receipt and entring into try");
			try {
				driver.findElement(By.id(obj.getProperty("ContinueWithoutClosingTable"))).click();
			} catch (Exception e) {

				System.out.println("Combine Order is Paid");

			}

		}
		Thread.sleep(4000);
		driver.findElement(By.id(obj.getProperty("Homecombine"))).click();
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']"))
				.click();

	}

	public void payWithCash() throws InterruptedException {

		driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).click();
		invoice_no = driver.findElement(By.id("com.torenzo.torenzocafe:id/invoice_no")).getText().substring(8);
		System.out.println("invoice_no==>" + invoice_no);
		// driver.findElement(By.id("com.torenzo.torenzocafe:id/discount_popUp")).click();
		// driver.findElement(By.xpath("//android.widget.TextView[@text='10%(Amount)']")).click();
		// DiscountR=driver.findElement(By.id("com.torenzo.torenzocafe:id/discount_value")).getText();
		// System.out.println("DiscountR" +DiscountR);
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"))
				.click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/paybill")).click();
		total_amount = driver.findElement(By.id("com.torenzo.torenzocafe:id/total_amount")).getText();
		System.out.println("total_amount==>" + total_amount);
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_payment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Close table without receipt']")).click();
		Thread.sleep(5000);
	}

	public void Payment1() throws IOException, InterruptedException {
		// System.out.println("Used for Edit order");

		List<WebElement> guest = driver.findElements(By.id(obj.getProperty("GuestName")));

		System.out.println("Guest count is ==>" + guest.size());
		driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).click();
		// Assert.assertEquals(paymentPage.verifyPaymentPagetitle(), "PayBill",
		// "Payment Page not found created order and went for order");
		driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();
		// Assert.assertTrue(splitReceiptPage.verifySplitReceiptPage(), "Split
		// Receipt Options window not found upon clicking on it");
		driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
		Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed(),
				"single recepit splited but the receipt not splited (FAILED)");
		List<WebElement> puff = driver.findElements(By.id("name"));
		System.out.println("Receipt count is==> " + puff.size());
		ordernofromreceipt = driver.findElement(By.id("order_id")).getText().substring(7);
		System.out.println("Order number is==> " + ordernofromreceipt);
		invoice_no1 = driver.findElement(By.id("invoice_no")).getText().substring(8);
		System.out.println("Invoice numeber is==> " + invoice_no1);
		date = driver.findElement(By.id("date")).getText();
		System.out.println("Date of receipt paid is==> " + date);
		Thread.sleep(4000);
		for (WebElement we : puff) {
			Thread.sleep(4000);
			we.click();
			driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
			// Assert.assertTrue(payingPaymentPage.verifyPayingPaymentWindow(),
			// "Payment window not found upon clicking on PayBill");
			driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
			payment_value = driver.findElement(By.id("payment_value")).getText().substring(1);
			driver.findElement(By.id("done_guest")).click();
			driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
			// Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home
			// page is not found after paying order(upon clicking on Close Table
			// Without Receipt FAILED) ");
			System.out.println("Order is succefully created and paid");
			driver.findElement(
					By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']"))
					.click();

		}
	}

	public void seatedPay() throws InterruptedException {
		driver.findElement(By.id("com.torenzo.torenzocafe:id/table_structure_img")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/table_guest_list")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/seated_btn")).click();
		for (int d = 1; d < 18; d++) {
			System.out.println("the value of D is = " + d);// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]
			try { // android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
				if (driver
						.findElement(By
								.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
										+ d + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
						.isDisplayed()) {
					System.out.println(" D first is = " + d);
					// if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[â€œ+d+â€�]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed()){

					table_name = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ d + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.getText().substring(8);
					System.out.println(" D second is = " + d);
					try {
						System.out.println("compare tables are:  " + table_No + " " + table_name);
						// if(table_name.equalsIgnoreCase(table_No)){
						if (table_name.equalsIgnoreCase(table_No)) {
							System.out.println("Table name and table no. are matched");
							driver.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ d
											+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
									.click();

							break;
						}
					} catch (Exception e) {
						System.out.println("Table name and table no are not matched");
					}
				}
			}

			catch (Exception e) {
				d = d - 6;
				ScrollUpOnSeatedList();

			}
		}

	}

	public void addTagsAndAllergies() {
		driver.findElement(By.id("com.torenzo.torenzocafe:id/tag_btn_name")).click();

		System.out.println("Tags are adding started");
		for (int k = 1; k < 4; k++) {

			driver.findElement(By
					.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
							+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"))
					.click();

		}
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click();
		System.out.println("Tags got added successfully");
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='+ Add Allergy']")).click();
		 * System.out.println("adding allergies started"); for(int j=1;j<4;j++)
		 * {
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
		 * +j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")
		 * ).click();
		 * 
		 * } driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).
		 * click(); System.out.println("Allergies got added successfully");
		 * 
		 * //Giving visits note here
		 * driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_visit_notes"
		 * )).sendKeys(
		 * "I am very happy with your service and food taste is also good");
		 */
	}

	public void selectDateAndTime() {
		// selecting date here
		driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_date")).click();

		// driver.findElement(By.id("android:id/next")).click();
		WebElement st = driver.findElement(By.id("android:id/date_picker_header_date"));
		System.out.println(st.getText());
		String date = st.getText().substring(9);
		int d = Integer.parseInt(date);
		// d=d+3;
		System.out.println(d);

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.ViewAnimator[1]/android.view.ViewGroup[1]/com.android.internal.widget.ViewPager[1]/android.view.View[1]/android.view.View["
						+ d + "]"))
				.click();
		driver.findElement(By.id("android:id/button1")).click();

		// selecting time here
		driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_time")).click();
		WebElement time = driver.findElement(By.id("android:id/hours"));
		String hours = time.getText();
		System.out.println(hours);
		String hour = time.getText().substring(0, 1);
		System.out.println(hour);
		int t = Integer.parseInt(hour);
		System.out.println(t);
		t = t + 2;
		System.out.println(t);
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.RadialTimePickerView.RadialPickerTouchHelper["
						+ t + "]"))
				.click();

		driver.findElement(By.id("android:id/button1")).click();
		ReserTime = driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_time")).getText();
		System.out.println(ReserTime);

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date1 = new Date();
		System.out.println(dateFormat.format(date1));

	}

	public void specifyTableFromTableStructure() {

		for (int t = 1; t <= 42; t++) {
			System.out.println("veriying for loop");
			try {
				System.out.println("enter into try block");
				driver.findElement(By.xpath("//android.widget.Button[@index=" + t + "]")).click();
				System.out.println("select table with index id = " + t);
			} catch (Exception e) {
				t = t - t + 1;
				driver.findElement(By.id("com.torenzo.torenzocafe:id/floor_select_btn")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Floor2']")).click();
				driver.findElement(By.xpath("//android.widget.Button[@index=" + t + "]")).click();
			}
			try {
				System.out.println("it enter into try block");
				if (driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed()) {
					driver.navigate().back();
				}
			} catch (Exception e) {
				try {

					if (driver.findElement(By.id(obj.getProperty("CancelGuestbyPhoneNumber"))).isDisplayed()) {
						addedGuestToOrder = driver.findElement(By.id("add_guest_three")).getText();
						driver.findElement(By.id("add_guest_three")).click();
						driver.findElement(By.id(obj.getProperty("DoneEmployeeList"))).click();
						break;
					}
				} catch (Exception a) {
					System.out.println("table select for reservation section");
					break;
				}
			}
			t = t + 1;
		}

	}

	public void serachForReservationAndWaitingFromList() throws Exception {
		// driver.findElement(By.id("com.torenzo.torenzocafe:id/search_reservation")).sendKeys(customername1);
		Thread.sleep(2000);
		for (b = 1; b < 13; b++) {
			try {
				System.out.println(b);
				if (driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["
								+ b + "]"))
						.isDisplayed())// android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
				{
					String gsize = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["
											+ b + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
							.getText();
					System.out.println(gsize);
					String gname = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["
											+ b + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.getText();
					System.out.println(gname);
					System.out.println(customername1 + " " + gname + "  " + partysize + " " + gsize);
					try {
						System.out.println("check and compare customername and partysize");
						if (customername1.equalsIgnoreCase(gname) && (partysize.equalsIgnoreCase(gsize))) {
							System.out.println("Current guest name and party size are equals ");
							b--;
							Dimension size = driver.findElement(By
									.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"
											+ b + "']"))
									.getSize();
							System.out.println("size of element" + size);
							int x1 = (int) (size.width * 0.10);
							int x2 = (int) (size.width * 0.80);
							TouchAction action = new TouchAction(driver);
							System.out.println("swipe2");
							WebElement ele2 = (WebElement) driver.findElements(By
									.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"
											+ b + "']")))
									.get(0);
							System.out.println("value" + ele2);
							b = b + 1;
							switch (b) {
							case 1:
								if (b == 1) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 360).release().perform();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								}
								break;
							case 2:
								if (b == 2) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 520).release().perform();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								}
								break;
							case 3:
								if (b == 3) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 680).release().perform();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								}
								break;
							case 4:
								if (b == 4) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 840).release().perform();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								}
								break;
							case 5:
								if (b == 5) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1000).release().perform();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								}
								break;
							case 6:
								if (b == 6) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1160).release().perform();
								}
								break;
							case 7:
								if (b == 7) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1320).release().perform();
								}
								break;
							case 8:
								if (b == 8) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1480).release().perform();
								}
								break;
							case 9:
								if (b == 9) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1640).release().perform();
								}
								break;
							case 10:
								if (b == 1) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1800).release().perform();
								}
								break;
							case 11:
								if (b == 11) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 1960).release().perform();
								}
								break;
							case 12:
								if (b == 12) {
									System.out.println("the vue of b is getting=" + b);
									action.longPress(ele2).moveTo(x1, 2120).release().perform();
								}
								break;
							default:
								System.out.println("the value of b not exist");
							}
							// action.longPress(ele2).moveTo(x1,360).release().perform();
							System.out.println("swipe4");
							break;
						}
					} catch (Exception e) {
						System.out.println("party size and customername not match");
					}
				}
			} catch (Exception e) {
				System.out.println("searched cell not found so scrollup on reservation list");
				b = b - 3;
				if (b > 0) {
					b--;
				} else {
					System.out.println("value of b= 0");
				}
				System.out.println("reduced value of " + b);
				scrollUpOnResevationList();
			}
			System.out.println("party size and customername not match");
		}
	}

	public void swipadmin() {
		{

			double startPercentage = 0.01;
			double finalPercentage = 0.9;
			double anchorPercentage = 0.5;
			int duration = 200;
			Dimension size = driver.manage().window().getSize();
			System.out.println("size of element" + size);
			int anchor = (int) (size.height * anchorPercentage);
			int startPoint = (int) (size.width * startPercentage);
			int endPoint = (int) (size.width * finalPercentage);
			new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration))
					.moveTo(endPoint, anchor).release().perform();
			System.out.println("Swipe admin setting done");

		}
	}

	public void ScrollUpOnSeatedList() throws InterruptedException {
		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']"))
				.getSize();

		System.out.println(size);
		// Find swipe start and end point from screenâ€™s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		// driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
	}

	public void scrollcashtab() {
		Dimension size = driver.findElement(By.id("cash_details_tab_recycler_view")).getSize();
		System.out.println("edit view size==>" + size);
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		WebElement ele = (WebElement) driver.findElements(By.id("cash_details_tab_recycler_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(starty, endy).release().perform();

	}

	public void editorderscroll() {
		System.out.println("Scrolling edit view");
		Dimension size = driver.findElement(By.id("edit_order_recycleview")).getSize();
		System.out.println("edit view size==>" + size);
		int starty = (int) (size.height * 0.20);
		int endy = (int) (size.height * 0.80);
		int startx = size.width / 2;
		WebElement ele = (WebElement) driver.findElements(By.id("edit_order_recycleview")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		System.out.println("Scrolling edit view done");

	}

	public void combineOrderList() {
		System.out.println("Scrolling ciombine view");
		Dimension size = driver.findElement(By.id("CombineOrdersListRecyclerView")).getSize();
		System.out.println("edit view size==>" + size);
		int starty = (int) (size.height * 0.20);
		int endy = (int) (size.height * 0.80);
		int startx = size.width / 2;
		WebElement ele = (WebElement) driver.findElements(By.id("CombineOrdersListRecyclerView")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		System.out.println("Scrolling edit view done");

	}

	public void scrollCombineOrderList() {
		System.out.println("Scroll Combine Order List");
		Dimension size = driver.findElement(By.id(obj.getProperty("CombineTaskListRv"))).getSize();
		System.out.println("edit view size==>" + size);
		int starty = (int) (size.height * 0.20);
		int endy = (int) (size.height * 0.80);
		int startx = size.width / 2;
		WebElement ele = (WebElement) driver.findElements(By.id(obj.getProperty("CombineTaskListRv"))).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		System.out.println("Scrolling edit view done");

	}

	public void scrollreport() {
		System.out.println("Scrolling reprot section for matching");
		Dimension size = driver.findElement(By.id("all_report_view")).getSize();
		int statry = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		WebElement ele = (WebElement) driver.findElements(By.id("all_report_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();

	}

	public void SwapAdmin() {
		double startPercentage = 0.01;
		double finalPercentage = 0.9;
		double anchorPercentage = 0.5;
		int duration = 200;
		Dimension size = driver.manage().window().getSize();
		System.out.println("size of element" + size);
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * finalPercentage);
		new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration))
				.moveTo(endPoint, anchor).release().perform();
	}

	public void reportswap() {
		double startPercenatge = 0.01;
		double finalPercentage = 0.9;
		double anchorPercentage = 0.5;
		int duration = 200;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercenatge);
		int endPoint = (int) (size.width * finalPercentage);
		TouchAction action = new TouchAction(driver);
		action.press(endPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(startPoint, anchor).release()
				.perform();
	}

	public void scrollUpOnWaitingList() throws Exception {

		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']"))
				.getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.
		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		Thread.sleep(2000);
	}

	public void scrollUpOnResevationList() throws Exception {

		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']"))
				.getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		Thread.sleep(2000);

	}

	public void DbconnbeforePay() {
		try {
			Order_To = Order_To.substring(1);
			System.out.println("fetching data from database like Order table Before payment");
			System.out.println("ID" + "       " + "LastUpdated" + "              " + "Total" + "       " + "Tax"
					+ "         " + "Discount" + "    " + "status" + "          " + "UniqueId" + "       " + "StoreID"
					+ "     " + "EmployeeName");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.32:3306/finaldbnew",
					"root", "root");
			// Connection con=(Connection)
			// DriverManager.getConnection("//127.0.0.1:3306/28_May_pnrdb?autoReconnect=true&useSSL=false","root","root");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from finaldbnew.order  where UniqueId='" + Order_No + "' and Total=" + Order_To + ";");
			while (rs.next()) {
				System.out.println(rs.getString("ID") + "    " + rs.getString("LastUpdated") + "      "
						+ rs.getString("Total") + "      " + rs.getString("Tax") + "     " + rs.getString("Discount")
						+ "       " + rs.getString("status") + "       " + rs.getString("UniqueId") + "             "
						+ rs.getString("StoreID") + "         " + rs.getString("EmployeeName"));
				System.out.println("OrderID" + "     " + "FullPrice" + "     " + "Price" + "         "
						+ "QuantityOnOrder" + "      " + "SalesTax" + "    " + "Description" + "       "
						+ "CategoryName" + "       " + "DepartmentName" + "     " + "Taxable");
				OrderID = (rs.getString("ID"));
			}
			ResultSet rk = stmt.executeQuery("select * from finaldbnew.orderentry where OrderId='" + OrderID + "';");
			while (rk.next())
				System.out.println(rk.getString("OrderID") + "     " + rk.getString("FullPrice") + "       "
						+ rk.getString("Price") + "           " + rk.getString("QuantityOnOrder") + "                "
						+ rk.getString("SalesTax") + "         " + rk.getString("Description") + "          "
						+ rk.getString("CategoryName") + "             " + rk.getString("DepartmentName") + "         "
						+ rk.getString("Taxable"));
			System.out.println("");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void DbconnAfterPay() {
		try {

			System.out.println("fetching data from database like Order table After payment");
			System.out.println("ID" + "       " + "LastUpdated" + "              " + "Total" + "       " + "Tax"
					+ "         " + "Discount" + "    " + "status" + "          " + "UniqueId" + "       " + "StoreID"
					+ "     " + "EmployeeName");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.32:3306/finaldbnew",
					"root", "root");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from finaldbnew.order  where UniqueId='" + Order_No + "' and Total=" + Order_To + ";");
			while (rs.next())
				System.out.println(rs.getString("ID") + "    " + rs.getString("LastUpdated") + "      "
						+ rs.getString("Total") + "      " + rs.getString("Tax") + "     " + rs.getString("Discount")
						+ "       " + rs.getString("status") + "       " + rs.getString("UniqueId") + "             "
						+ rs.getString("StoreID") + "         " + rs.getString("EmployeeName"));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void DbconnReceiptdata() {

		try {
			Order_To = Order_To.substring(1);
			System.out.println("ID" + "     " + "ReceiptTotal" + "     " + "isPaid" + "    " + "Tax" + "        "
					+ "Discount" + "     " + "InvoiceNumber" + "             " + "ReceiptDateTime" + "      "
					+ "StoreID" + "       " + "ReceiptTime");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.32:3306/finaldbnew",
					"root", "root");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rt = stmt
					.executeQuery("select * from finaldbnew.receiptdata where InvoiceNumber='" + invoice_no + "';");
			while (rt.next()) {
				System.out.println(rt.getString("ID") + "    " + rt.getString("ReceiptTotal") + "            "
						+ rt.getString("isPaid") + "       " + rt.getString("Tax") + "    " + rt.getString("Discount")
						+ "       " + rt.getString("InvoiceNumber") + "     " + rt.getString("ReceiptDateTime") + "    "
						+ rt.getString("StoreID") + "         " + rt.getString("ReceiptTime"));
			}
			System.out.println("");
			System.out.println("ID" + "     " + "StartDate" + "     " + "OrderAmount" + "    " + "ReceiptTotal"
					+ "        " + "InvoiceNumber" + "     " + "TransactionType" + "             " + "uniqueOrderNO"
					+ "      " + "StoreID" + "       " + "drawerID");
			ResultSet rd = stmt.executeQuery(
					"select * from finaldbnew.drawertransaction where InvoiceNumber='" + invoice_no + "';");
			while (rd.next())
				System.out.println(rd.getString("ID") + "    " + rd.getString("StartDate") + "      "
						+ rd.getString("OrderAmount") + "      " + rd.getString("ReceiptTotal") + "     "
						+ rd.getString("InvoiceNumber") + "       " + rd.getString("TransactionType") + "       "
						+ rd.getString("uniqueOrderNO") + "             " + rd.getString("StoreID") + "         "
						+ rd.getString("drawerID"));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("");
	}

	public void tillManagment() throws InterruptedException {

		driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_cash_details")).click();

		// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]

		for (int k = 1; k < 25; k++) {
			System.out.println("verifying loop for cell of j is =" + k);
			try {
				System.out.println("j is =" + k);
				if (driver
						.findElement(By
								.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
										+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
						.isDisplayed()) {
					invoice_tillCash = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.getText();
					System.out.println("invoice no form till is = " + invoice_tillCash);
					System.out.println("Receipt invoice no is =" + invoice_no);
					OrderNo = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
							.getText();
					System.out.println("order no from till is =" + OrderNo);
					System.out.println("orderno before paid =" + order_no1);

					Amount = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[1]"))
							.getText().substring(1);
					System.out.println("Amount from till is =" + Amount);

					System.out.println("Amount before paid =" + order_total);

					try {
						if (invoice_no.equalsIgnoreCase(invoice_tillCash) && (order_no1.equalsIgnoreCase(OrderNo))
								&& (order_total.equalsIgnoreCase(Amount))) {
							OrderNo = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
									.getText();
							Discount = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"))
									.getText();
							// invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
							// Amount=
							// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText().substring(1);
							System.out.println();
							System.out.println("Order details taken from order creation and receipt :");
							System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount" + "   "
									+ "Amount");
							System.out.println(order_no1 + "           " + invoice_no + "      " + DiscountR + "   "
									+ order_total);
							System.out.println();
							System.out.println("Order details taken from Till in Cash Detail section :");
							System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount" + "   "
									+ "Amount");
							System.out.println(OrderNo + "           " + invoice_tillCash + "       " + Discount
									+ "    " + Amount);
							System.out.println();
							// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
							break;
						}
					} catch (Exception e) {
						System.out.println("invoice numbers not match");
					}
				}
			} catch (Exception e) {
				k = k - 2;
				if (k > 0) {
					k--;
				}
				System.out.println("scroll up on Nckot list started");
				scrollOncashDetailIntill();
			}
		}
		driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click();
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']"))
				.click();

		Thread.sleep(1000);
	}

	public void tillManagment1() throws InterruptedException {

		driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_cash_details")).click();
		try {
			if (driver.findElement(By.xpath("//android.widget.TextView[@text='Table']")).isDisplayed())
				;
			{
				String st = driver.findElement(By.xpath("//android.widget.TextView[@text='Table']")).getText();
				System.out.println(st);
				for (int k = 1; k < 25; k++) {
					System.out.println("verifying loop for cell of j is =" + k);
					try {
						System.out.println("j is =" + k);
						if (driver
								.findElement(By
										.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
												+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
								.isDisplayed()) {
							invoice_tillCash = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
									.getText();
							System.out.println("invoice no form till is = " + invoice_tillCash);
							System.out.println("Receipt invoice no is =" + invoice_no);
							OrderNo = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
									.getText();
							System.out.println("order no from till is =" + OrderNo);
							System.out.println("orderno before paid =" + order_no1);

							Amount = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[1]"))
									.getText().substring(1);
							System.out.println("Amount from till is =" + Amount);

							System.out.println("Amount before paid =" + order_total);

							try {
								if (invoice_no.equalsIgnoreCase(invoice_tillCash)
										&& (order_no1.equalsIgnoreCase(OrderNo))
										&& (order_total.equalsIgnoreCase(Amount))) {
									OrderNo = driver
											.findElement(By
													.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
															+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
											.getText();
									Discount = driver
											.findElement(By
													.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
															+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"))
											.getText();
									// invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
									// Amount=
									// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText().substring(1);
									System.out.println();
									System.out.println("Order details taken from order creation and receipt :");
									System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount"
											+ "   " + "Amount");
									System.out.println(order_no1 + "           " + invoice_no + "      " + DiscountR
											+ "   " + order_total);
									System.out.println();
									System.out.println("Order details taken from Till in Cash Detail section :");
									System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount"
											+ "   " + "Amount");
									System.out.println(OrderNo + "           " + invoice_tillCash + "       " + Discount
											+ "    " + Amount);
									System.out.println();
									// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
									break;
								}
							} catch (Exception e) {
								System.out.println("invoice numbers not match");
							}
						}
					} catch (Exception e) {
						k = k - 2;
						if (k > 0) {
							k--;
						}
						System.out.println("scroll up on Nckot list started");
						scrollOncashDetailIntill();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("it enters into catch block");
			for (int k = 1; k < 25; k++) {
				System.out.println("verifying loop for cell of j is =" + k);
				try {
					System.out.println("j is =" + k);
					if (driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.isDisplayed()) {
						invoice_tillCash = driver
								.findElement(By
										.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
												+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
								.getText();
						System.out.println("invoice no form till is = " + invoice_tillCash);
						System.out.println("Receipt invoice no is =" + invoice_no);
						OrderNo = driver
								.findElement(By
										.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
												+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
								.getText();
						System.out.println("order no from till is =" + OrderNo);
						System.out.println("orderno before paid =" + order_no1);

						Amount = driver
								.findElement(By
										.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
												+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]"))
								.getText().substring(1);
						System.out.println("Amount from till is =" + Amount);

						System.out.println("Amount before paid =" + order_total);

						try {
							if (invoice_no.equalsIgnoreCase(invoice_tillCash) && (order_no1.equalsIgnoreCase(OrderNo))
									&& (order_total.equalsIgnoreCase(Amount))) {
								OrderNo = driver
										.findElement(By
												.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
														+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
										.getText();
								Discount = driver
										.findElement(By
												.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
														+ k + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"))
										.getText();
								// invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
								// Amount=
								// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText().substring(1);
								System.out.println();
								System.out.println("Order details taken from order creation and receipt :");
								System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount"
										+ "   " + "Amount");
								System.out.println(order_no1 + "           " + invoice_no + "      " + DiscountR + "   "
										+ order_total);
								System.out.println();
								System.out.println("Order details taken from Till in Cash Detail section :");
								System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount"
										+ "   " + "Amount");
								System.out.println(OrderNo + "           " + invoice_tillCash + "       " + Discount
										+ "    " + Amount);
								System.out.println();
								// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
								break;
							}
						} catch (Exception a) {
							System.out.println("invoice numbers not match");
						}
					}
				} catch (Exception c) {
					k = k - 2;
					if (k > 0) {
						k--;
					}
					System.out.println("scroll up on Nckot list started");
					scrollOncashDetailIntill();
				}

			}

		}

		// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]

		driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click();
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']"))
				.click();

		Thread.sleep(1000);
	}

	public void scrollOncashDetailIntill() throws InterruptedException {
		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']"))
				.getSize();

		System.out.println(size);
		// Find swipe start and end point from screenâ€™s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		// driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
	}

	public void loadOrder(String Type) throws Exception {
		// android.widget.TextView
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy"); Date
		 * date1 = new Date();
		 * 
		 * //Date date = new Date(); //String startDate= new
		 * SimpleDateFormat("dd-MMM-yyyy").format(date);
		 * 
		 * System.out.println(date1);
		 */
		Order_No = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).getText();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		driver.findElement(By.id("com.torenzo.torenzocafe:id/order_list_layout")).click();
		try {
			if (driver.findElement(By.id("com.torenzo.torenzocafe:id/transaction_typetext_two")).isDisplayed()) {
				driver.findElement(By.id("com.torenzo.torenzocafe:id/transaction_typetext_" + Type + "")).click();
			}
		} catch (Exception e) {
			System.out.println("it shown only Takeout type order");
		}

		driver.findElement(By.id("com.torenzo.torenzocafe:id/search_order_byid")).sendKeys(Order_No);
		Thread.sleep(2000);
		// scrollUp();
		// driver.findElement(By.xpath("//android.widget.TextView
		// [@text='23-Jun-2018 03:40:24']")).click();
		for (int a = 1; a < 10; a++) {
			try {
				System.out.println(a);
				if (driver
						.findElement(By
								.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["
										+ a + "]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]"))
						.isDisplayed()) {
					String CurDate = driver
							.findElement(By
									.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["
											+ a + "]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]"))
							.getText().substring(0, 11);
					System.out.println(CurDate);
					// System.out.println(CurDate.substring(0, 11));
					String Amount = driver
							.findElement(By
									.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["
											+ a + "]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.getText().substring(1);
					System.out.println(Amount);
					System.out.println(order_total);
					System.out.println(order_total.replaceFirst(".$", ""));
					try {
						if ((order_total.replaceFirst(".$", "")).equalsIgnoreCase(Amount)
								&& (CurDate.equals(dateFormat.format(date))))
						// if((CurDate.equals(date1))&(Order_To).equalsIgnoreCase(Amount))
						// android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
						{
							System.out.println("Current date is equal ");
							// android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
							driver.findElement(By
									.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["
											+ a
											+ "]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
									.click();

							if (driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).isDisplayed()) {
								System.out.println("order get load successfully");

								break;
							}

						}
					} catch (Exception e) {

						// if(driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).isDisplayed()){`
						// break;
						// }
					}

				}
			} catch (Exception e) {
				System.out.println("Date and time not match");
				a = a - 3;
				if (a > 1) {
					a--;
				} else {
					System.out.println("value of a=1");
				}
				System.out.println("reduced value of " + a);
				scrollUpOnOrderList();
			}
		}
	}

	public void scrollUpOnOrderList() throws Exception {

		Dimension size = driver
				.findElement(By
						.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]"))
				.getSize();
		System.out.println(size);
		// Find swipe start and end point from screenâ€™s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.

		// WebElement ele2 = (WebElement)
		// driver.findElements(By.xpath(("android.support.v7.widget.RecyclerView[contains(@resource-id,'orders_list_recycler_view')
		// and @index='0']"))).get(0);
		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]")))
				.get(0);

		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, starty).release().perform();
		// driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
	}

	public void OrderPayWithNckot() throws InterruptedException {
		driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).click();
		invoice_no = driver.findElement(By.id("com.torenzo.torenzocafe:id/invoice_no")).getText().substring(8);
		System.out.println(invoice_no);
		Thread.sleep(2000);
		// total_amount=
		// driver.findElement(By.id("com.torenzo.torenzocafe:id/total_amount")).getText();
		// System.out.println("total_amount==>" +total_amount);
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"))
				.click();

		driver.findElement(By.id("com.torenzo.torenzocafe:id/paybill")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Non Chargeable KOT']")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_payment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Close table without receipt']")).click();
		Thread.sleep(5000);
	}

	public void verifyNckotsection() throws InterruptedException {
		System.out.println("navigate to Nckot section");
		double startPercentage = 0.01;
		double finalPercentage = 0.9;
		double anchorPercentage = 0.5;
		int duration = 200;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * finalPercentage);
		new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/nonkot_order")).click();
		// driver.findElement(By.id("admin_settings")).click();
		System.out.println("verifying nckot");
		driver.findElement(By.id("com.torenzo.torenzocafe:id/search")).click();

		Thread.sleep(2000);

		for (int j = 1; j < 13; j++) {
			System.out.println("verifying loop for cell of j is =" + j);
			try {
				System.out.println("j is =" + j);

				// if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())

				if (driver
						.findElement(By
								.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
										+ j + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
						.isDisplayed()) {
					invoice_noNckot = driver
							.findElement(By
									.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ j + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
							.getText();
					System.out.println(" invoice no from receipt before payment is" + invoice_noNckot);
					try {
						if (invoice_noNckot.equalsIgnoreCase(invoice_no)) {
							driver.findElement(By
									.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ j
											+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
									.click();
							driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
							break;
						}
					} catch (Exception e) {
						System.out.println("invoice numbers not match");
					}
				}
			} catch (Exception e) {
				j = j - 7;
				if (j > 0) {
					j--;
				}
				System.out.println("scroll up on Nckot list started");
				scrollOnNckotlist();
			}
		}

	}

	public void rejctNckot() {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String print = driver.findElement(By.xpath("//android.widget.Button[@text='Reject Order']")).getText();
		WebElement ele = driver.findElement(By.xpath("//android.widget.Button[@text='Reject Order']"));
		TouchAction action = new TouchAction(driver);
		action.longPress(ele);
		action.perform();
		driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
	}

	public void accepttNckot() {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String print = driver.findElement(By.xpath("//android.widget.Button[@text='Accept Order']")).getText();
		WebElement ele = driver.findElement(By.xpath("//android.widget.Button[@text='Accept Order']"));
		TouchAction action = new TouchAction(driver);
		action.longPress(ele);
		action.perform();
		// driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'transaction')
		// and @index='0']")).click();
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[1]")).click();
		// driver.findElement(By.id("com.torenzo.torenzocafe:id/Accept
		// Order")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
	}

	// tap on nckot tab in till management
	public void NckotInTill() throws InterruptedException {

		driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_gift_card_details_tab")).click();

		for (int l = 1; l < 13; l++) {
			System.out.println("verifying loop for cell of j is =" + l);
			try {
				System.out.println("j is =" + l);

				// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
				// if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
				if (driver
						.findElement(By
								.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
										+ l + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
						.isDisplayed()) {
					System.out.println("cell is present");
					// invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();

					invoice_tillNCKOT = driver
							.findElement(By
									.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
											+ l + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
							.getText();
					System.out.println("invoice no from receipt before payment is" + invoice_noNckot);
					System.out.println("invoice no search in nckot list after payment " + invoice_tillNCKOT);
					try {
						if (invoice_noNckot.equalsIgnoreCase(invoice_tillNCKOT)) {
							OrderNo = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ l + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
									.getText();
							Discount = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ l + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"))
									.getText();
							Amount = driver
									.findElement(By
											.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["
													+ l + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]"))
									.getText();
							System.out.println("Order detaill showing in nckot secton below :");
							System.out.println("Order No" + "           " + "Invoice No" + "      " + "Discount" + "   "
									+ "Amount");
							System.out.println(
									OrderNo + "           " + invoice_tillNCKOT + "      " + Discount + "   " + Amount);
							// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
							break;
						}
					} catch (Exception e) {
						System.out.println("invoice numbers not match");
					}
				}
			} catch (Exception e) {
				l = l - 18;
				if (l > 0) {
					l--;
				}
				System.out.println("scroll up on Nckot list started");
				scrollOnNCKOTIntill();
			}
		}

	}

	public void scrollOnNckotlist() throws InterruptedException {
		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'edit_order_recycleview') and @index='0']"))
				.getSize();

		System.out.println(size);
		// Find swipe start and end point from screen’s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'edit_order_recycleview') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		// driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
	}

	public void scrollOnNCKOTIntill() throws InterruptedException {
		Dimension size = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'gift_card_details_tab_recycler_view') and @index='0']"))
				.getSize();

		System.out.println(size);
		// Find swipe start and end point from screen’s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
		// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver
				.findElements(By
						.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'gift_card_details_tab_recycler_view') and @index='0']")))
				.get(0);
		System.out.println("value" + ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx, endy).release().perform();
		// driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
	}
}
