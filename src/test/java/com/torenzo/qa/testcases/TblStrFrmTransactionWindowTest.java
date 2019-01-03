package com.torenzo.qa.testcases;

import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;
import static com.torenzo.qa.util.StaticVariable.comapre;
import static com.torenzo.qa.util.StaticVariable.guestCountFromParty;
import static com.torenzo.qa.util.StaticVariable.homePageTitle;
import static com.torenzo.qa.util.StaticVariable.paymentValue;
import static com.torenzo.qa.util.StaticVariable.totalOfOrder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.pages.TableViewPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.Reusemethod;
import com.torenzo.qa.util.ScrollMethod;

public class TblStrFrmTransactionWindowTest extends TestBase {

	public TblStrFrmTransactionWindowTest() throws IOException {
		super();
	}
	//run and gets passed
	TransactionOrderPage transactionOrderPage;
	HomePage homePage;
	LoginPage loginPage;
	OrderPage orderPage;
	GuestPage guestPage;
	PaymentPage paymentPage; 
	SplitReceiptPage splitReceiptPage;
	PayingPaymentPage payingPaymentPage;
	TableStructurePage tableStructurePage;  
	ScrollMethod scrollMethod;
	AdminSettingPage adminSettingPage;
	TableViewPage  tableViewPage;
	
		@BeforeTest
	    public void setUp() throws IOException, InterruptedException
	    {
			initilization();
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			orderPage = new OrderPage(driver);
			guestPage = new GuestPage(driver);
			paymentPage = new PaymentPage(driver);
			transactionOrderPage = new TransactionOrderPage(driver); 
		    splitReceiptPage = new SplitReceiptPage(driver);
		    payingPaymentPage = new PayingPaymentPage(driver);
		    tableStructurePage = new TableStructurePage(driver);
		    scrollMethod = new ScrollMethod();
		    adminSettingPage = new AdminSettingPage(driver);
		    tableViewPage = new TableViewPage(driver);
				
	    }
		
		@Test(priority = 0)
		public void loginApp() throws IOException, InterruptedException{
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
				loginPage.validatelaunchLink();		 
				Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
				loginPage.clickOnOpenExistStoreButton();	  
				boolean titleOfLoginWindow = loginPage.titleOfLoginPage();
				Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
				loginPage.clickOnSubmitLoginButton();
				boolean clockInButton = loginPage.validateClockInButton();
				Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
				loginPage.clickOnClockInButton();
		     	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
				loginPage.clickOnroleNameButton();
		
		}
		
		   @Test(priority = 1)
		  public void clickOnCreateNewOrder() throws InterruptedException{
			Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
		    homePage = loginPage.clickOnPermissionPupup();				
			homePage.titleOfhomePage();					
			System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			scrollMethod.swipAdmin();
			Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after scrolling it");
			tableViewPage = adminSettingPage.clickOnadminSettings();
			tableViewPage.clickOnTableviewDisplay();
			homePage =tableViewPage.clickOnbackArrowButton();
			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (after coming back from admin settings)");	
			transactionOrderPage = homePage.clickNewOrderCreateBtn();
			Assert.assertTrue(transactionOrderPage.getTextCancelButtonFromTransaction(), "Transaction type window not found upon clicking on Create new Order button");
					try{	
				
						tableStructurePage	=transactionOrderPage.clickOndineInButton();
				
				}catch(Exception e){
					
					System.out.println("DineIn Order Type is not found");
					transactionOrderPage.clickOnCancelButtonFromTransaction();
				}
				
					Assert.assertTrue(tableStructurePage.titleOfTableStructure(), "Table Structure page is not found upon DINE-IN Type from Transaction type window");
						
		}
		@Test(priority = 2)
		public void selectEmptyTable() throws InterruptedException, IOException{
			tableStructurePage.checkForEmptyTable();
		    Assert.assertTrue(guestPage.verifytitleOfPartySizeInTable(), "Party size window not found upon clicking on empty table");
		    guestPage.clickAddGuestThree();
		   guestCountFromParty = guestPage.gteTextCountAddedFromPartyWindow();
		   orderPage = guestPage.clickOnDoneEmployeeList();
		   
			String count = Integer.toString(orderPage.totolGuestCount());
	        Assert.assertEquals(guestCountFromParty, count, "Guest count is not matched when it to each other from order page to party size window");	   
	        orderPage.selectGuestandAddItem();      
	        totalOfOrder =homePage.getTextFromOrderTotal();
	        System.out.println("totalOfOrder=>" +totalOfOrder);
	    	comapre = orderPage.totolGuestCount();
			System.out.println("comapre=>" +comapre);		
	        paymentPage = homePage.clickOnOrderTotalUpsideButton();
	        Assert.assertEquals( paymentPage.verifyPaymentPagetitle(), "PayBill", "Payment Page is not found upon clicking on TotalUpsideButton from Order");
		 }

	
		@Test(priority = 3)
		public void getPaymentDone() throws IOException, InterruptedException{
			splitReceiptPage = paymentPage.ClickOnSplitReceiptClick();		
			Assert.assertTrue(splitReceiptPage.verifySplitReceiptPage(), "Receipt page is not found upon clicking on Split receipt button");
			System.out.println("Spliting receipt for single guest");
			splitReceiptPage.clickOnsplitEquallyForAll();	
			System.out.println("receipt count is =>" +paymentPage.totolReceiptCount());
			System.out.println("paymentPage.totalReceipt is =>" +paymentPage.totalReceipt.size());
			Assert.assertEquals(comapre, paymentPage.totolReceiptCount(), "Receipts are not splited as per Split Equally For All from Split option");
			float value = Float.parseFloat(totalOfOrder) / Float.parseFloat(guestCountFromParty);
			String str = Float.toString(value);
			System.out.println("value is =>" +value);
		for( WebElement  we : paymentPage.totalReceipt){
			
				we.click();
				payingPaymentPage  = paymentPage.clickOnPayBill();
				Assert.assertTrue(payingPaymentPage.titleOfPaymentWindow(), "Payment window is not opened upon clicking on Paybill button");
				EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
				EditTotalAmt =EditTotalAmt.substring(0, EditTotalAmt.length()-1);				
				Assert.assertEquals(str, EditTotalAmt, "Amount not correctly splited as per Split Equally For All from Split option");			
				payingPaymentPage.ClickOnaddPayment();
				paymentValue = payingPaymentPage.getTextpaymentValue();
				System.out.println("EditTotalAmt is =>" +EditTotalAmt);
				System.out.println("paymentValue =>" +paymentValue);
				Assert.assertEquals(EditTotalAmt, paymentValue, "Both value is not matched with each other from Payment Window");
				payingPaymentPage.clickOnDoneFromPaymentWindow();
				payingPaymentPage.closeTableWithoutReceiptButton();
				
				try{
					payingPaymentPage.continueWithoutClosingtableButton();
				}catch(Exception e){
					 System.out.println("Order is Paid");
				}
			
		}

			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (after paying order");
		

		}
	
	
 }
