package com.torenzo.qa.pomtest;

import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.paymentValue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.EditOrderPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderDiscountPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.TestUtil;

public class EditOrderPageTest extends TestBase {

	String invoice="";
	double totalFromHome;
	String orderNumber ="";
	public EditOrderPageTest() throws IOException {
		super();
	}

	public TransactionOrderPage transactionOrderPage;
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public GuestPage guestPage;
	public PaymentPage paymentPage;
	public SplitReceiptPage splitReceiptPage;
	public PayingPaymentPage payingPaymentPage;
	public OrderDiscountPage orderDiscountPage;
	public TestUtil testUtil;
	public AdminSettingPage adminSettingPage;
	public EditOrderPage editOrderPage;


	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		splitReceiptPage = new SplitReceiptPage(driver);
		payingPaymentPage = new PayingPaymentPage(driver);
		 orderDiscountPage = new OrderDiscountPage(driver);
		 testUtil = new TestUtil(driver);
		 adminSettingPage = new AdminSettingPage(driver);
		  editOrderPage = new EditOrderPage(driver);
	}
	
	@Test(priority=1)
	public void verfiyHomePageTest() throws IOException, InterruptedException{		 
		 loginPage.validatelaunchLink();		 
		loginPage.clickOnOpenExistStoreButton();
		Thread.sleep(3000);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));		
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();
		Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	    homePage = loginPage.clickOnPermissionPupup();				
			
	}

	@Test(priority = 2)
	   public void paymentPageTest() throws InterruptedException, IOException{	
	   // this are in flow previous
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		orderNumber =orderPage.getTextorderNumberFromOrderPage();
		orderPage.selectGuestandAddItem();	
		 totalFromHome = Double.valueOf(homePage.getTextFromOrderTotal());
		homePage.clickOnOrderTotalUpsideButton();	
		invoice = paymentPage.getTextInvoiceNoFromReceipt();
		payingPaymentPage  = paymentPage.clickOnPayBill();		
		EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
		String str = String.format("%1.2f", EditTotalAmt);
		EditTotalAmt = Double.valueOf(str);
		System.out.println("EditTotalAmt=======>" +EditTotalAmt);	
		payingPaymentPage.ClickOnaddPayment();
		paymentValue = payingPaymentPage.getTextpaymentValue();		
		payingPaymentPage.clickOnDoneFromPaymentWindow();	
		payingPaymentPage.closeTableWithoutReceiptButton();
	}

	@Test(priority = 3)
	   public void editPageTest() throws InterruptedException, IOException{			
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		adminSettingPage.editOrder.click();
		Assert.assertEquals(editOrderPage.getTextCancel(), testUtil.readDataFromExcellString(10,1,0)  , "Edit order window is not opened upon clicking Edit order from admin settings.");	
		testUtil.writeStringValue(10, 1, 2);
		System.out.println("testUtil.currentDate==>" +testUtil.currentDate("dd-MMM-YY"));
		Assert.assertEquals(editOrderPage.getTextDate(), testUtil.currentDate("dd-MMM-YY")  , "System date and edit order date isn not matched");	
		testUtil.writeStringValue(10, 2, 2);
		if(editOrderPage.getTextFromInvoice().equalsIgnoreCase("invoice")){
			editOrderPage.doneEditWindow.click();
			
		}else{
			testUtil.scrollTillContainsText(invoice);
			editOrderPage.getTextFromInvoice();
			
			editOrderPage.doneEditWindow.click();
		}		
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after clicking on Edit order");		
		testUtil.writeStringValue(10, 3, 2);
		Assert.assertEquals(totalFromHome, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after reloading order from edit order");		
		testUtil.writeStringValue(10, 5, 2);
		Assert.assertEquals(orderNumber, orderPage.getTextorderNumberFromOrderPage(), "Order Number is not matched after reloading order from edit order");		
		testUtil.writeStringValue(10, 4, 2);
		
	}


	@Test(priority = 4)
	   public void editPageTestNegative() throws InterruptedException, IOException{		
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		adminSettingPage.editOrder.click();
		editOrderPage.cancelEditWindow.click();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after clicking on Edit order and cancelling edit window");		
		
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
	}
	
}
