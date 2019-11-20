package com.torenzo.qa.pomtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.ItemOperationPage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.pages.TableViewPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.ScrollMethod;
import com.torenzo.qa.util.TestUtil;

import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.comapre;
import static com.torenzo.qa.util.StaticVariable.guestCountFromParty;
import static com.torenzo.qa.util.StaticVariable.paymentValue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TableStructurePageTest extends TestBase {
	
	public TableStructurePage tableStructurePage;  
	public AdminSettingPage adminSettingPage;
	public TableViewPage  tableViewPage;	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public ItemOperationPage itemOperationPage; 
	public TestUtil testUtil;	
	
	public TableStructurePageTest() throws IOException{
		   super();
	   }

	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		 itemOperationPage = new ItemOperationPage(driver);
		 testUtil = new TestUtil(driver);
		 tableStructurePage = new TableStructurePage(driver);
		 adminSettingPage = new AdminSettingPage(driver);
		 tableViewPage=new TableViewPage(driver);
	}
	
	@Test(priority=1)
	public void verfiyHomePageTest() throws IOException, InterruptedException{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		loginPage.validatelaunchLink();		 
		loginPage.clickOnOpenExistStoreButton();
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));		
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();			
	    homePage = loginPage.clickOnPermissionPupup();							
	}
	
	@Test(priority=2)
	public void verfiyTableIconTest() throws IOException, InterruptedException{	
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after swapping it from HomePage");
		adminSettingPage.clickOnadminSettings();
		tableViewPage.clickOnTableviewDisplay();
		tableViewPage.clickOnbackArrowButton();
		Assert.assertTrue(homePage.validatetableStructureButton(), "Table Structure page is not found upon reloading table from Admin Settings");
		testUtil.writeStringValue(6, 1, 2);
		homePage.clickOnTableStructureButton();
		Assert.assertEquals(tableStructurePage.titleOfTableStructure(), testUtil.readDataFromExcellString(6,2,0), "Table Structure page is not found upon reloading table from Admin Settings");
		testUtil.writeStringValue(6, 2, 2);
	}
	
	@Test(priority=3)
	public void searchFormEmptyTableTest1() throws IOException, InterruptedException{	
		tableStructurePage.searchFromEmptyTable();
		System.out.println("before party size");
		tableStructurePage.addGuest();
		//tableStructurePage.passGuest(0);
		System.out.println("tableStructurePage.getGuest()=>" +tableStructurePage.getGuest());
		int guest = Integer.valueOf(tableStructurePage.getGuest());
		tableStructurePage.doneGuest.click();	
	//	Assert.assertEquals(tableStructurePage.name, orderPage.getTextTableName(), "Table name is not matched which selected from table page in order page");			
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after selecting table from table structure");		
		Assert.assertEquals(guest, orderPage.totolGuestCount(), "Guest are not matched after adding guest from window at order ");	
		testUtil.writeStringValue(6, 5, 2);
		/*orderPage.selectGuestandAddItem();		
		Assert.assertEquals(Double.valueOf(homePage.getTextFromOrderTotal()), orderPage.totalItemValue(), "Guest are not matched after adding guest from window at order ");	
		testUtil.writeStringValue(6, 6, 2);*/

	}
		
	@Test(priority=4)
	public void searchFormEmptyTableNegativeTest() throws IOException, InterruptedException{		
		homePage.clickOnTableStructureButton();
		tableStructurePage.searchFromEmptyTable();
		tableStructurePage.passGuestInEditBox("21");
	//	tableStructurePage.passGuest(2);
	//	tableStructurePage.passGuest(1);
		tableStructurePage.doneGuest.click();	
		Assert.assertEquals(tableStructurePage.getTextAlertTitle(), testUtil.readDataFromExcellString(6,7,0), "Alert popup is not displayed when entered more guest to order");	
		testUtil.writeStringValue(6, 7, 2);
		tableStructurePage.getTextMessage();
		tableStructurePage.alertOk.click();		
		Assert.assertEquals(tableStructurePage.titleOfGuestWindow(), testUtil.readDataFromExcellString(6,3,0), "we are not navigate to party size window after clicking from OK button from alert");	
		tableStructurePage.passGuestInEditBox("0");
		tableStructurePage.doneGuest.click();		
		tableStructurePage.getTextMessage();
		Assert.assertEquals(tableStructurePage.getTextAlertTitle(), testUtil.readDataFromExcellString(6,7,0), "Alert popup is not displayed when entered more guest to order");	
		testUtil.writeStringValue(6, 8, 2);
		tableStructurePage.alertOk.click();
		tableStructurePage.cancelGuest.click();
		Assert.assertEquals(tableStructurePage.titleOfTableStructure(), testUtil.readDataFromExcellString(6,2,0), "Table Structure page is not found upon canceling from guest page");
		testUtil.writeStringValue(6, 9, 2);
		

	}

	}
	
	
	



























/*	@BeforeClass
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
		    homePageTest = new HomePageTest();
		    
	    }
		
		@Test(priority = 1)
		public void loginApp() throws IOException, InterruptedException
		{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		homePageTest.loginApp();
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
		 Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	     homePage = loginPage.clickOnPermissionPupup();				
		 homePage.titleOfhomePage();					
		System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
		Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
		
		}
		
		@Test(priority = 1)
		public void validateTableStrucutre() throws IOException, InterruptedException{
		
		try{
			if (homePage.validatetableStructureButton()){
				scrollMethod.swipAdmin();
				Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after scrolling it");
				tableViewPage = adminSettingPage.clickOnadminSettings();
			
			}
		}catch(Exception e)
		{
			scrollMethod.swipAdmin();
			Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after scrolling it");
			tableViewPage = adminSettingPage.clickOnadminSettings();
			tableViewPage.clickOnTableviewDisplay();

	    }
		
		tableStructurePage = tableViewPage.clickOnreloadTables();
		
		Assert.assertTrue(tableStructurePage.titleOfTableStructure(), "Table Structure page is not found upon reloading table from Admin Settings");
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
        System.out.println("getTextFromOrderTotal=>" +homePage.getTextFromOrderTotal());
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
		splitReceiptPage.clickOnSingleRecipt();	
		System.out.println("receipt count is =>" +paymentPage.totolReceiptCount());
		System.out.println("paymentPage.totalReceipt is =>" +paymentPage.totalReceipt.size());
	
	for( WebElement  we : paymentPage.totalReceipt){
		
		we.click();
		payingPaymentPage  = paymentPage.clickOnPayBill();
			Assert.assertTrue(payingPaymentPage.titleOfPaymentWindow(), "Payment window is not opened upon clicking on Paybill button");
			EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
			EditTotalAmt =EditTotalAmt.substring(0, EditTotalAmt.length()-1);
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
	

	}*/
        
