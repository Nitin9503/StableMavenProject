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

public class ReloadPageTest extends TestBase {
	
	public TableStructurePage tableStructurePage;  
	public AdminSettingPage adminSettingPage;
	public TableViewPage  tableViewPage;	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public ItemOperationPage itemOperationPage; 
	public TestUtil testUtil;	
	
	public ReloadPageTest() throws IOException{
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
	public void reloadItemsTest() throws IOException, InterruptedException{	
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		adminSettingPage.clickOnadminSettings();		
		tableViewPage.reloadItems.click();
		Assert.assertTrue(orderPage.allCategoryText(), "Home page is not found after reloading the item from the Admin settings");		
		testUtil.writeStringValue(9, 1, 2);
	
	}
	
	@Test(priority=3)
	public void itemImagesTest() throws IOException, InterruptedException{	
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		adminSettingPage.clickOnadminSettings();
		tableViewPage.itemImages.click();	
		tableViewPage.radioButtonForItemImages();
		tableViewPage.clickOnbackArrowButton();
		orderPage.clickAllCategoryItemButton();		
		Assert.assertTrue(orderPage.itemImages(), "Item image is not found after checking radio buttom from Admin setting ");		
		testUtil.writeStringValue(9, 2, 2);
	}
		
	@Test(priority=4)
	public void realodTableTest() throws IOException, InterruptedException{	
		testUtil.swapRightToLeft(homePage.adminPanel(), homePage.trackOrder());
		adminSettingPage.clickOnadminSettings();
		tableViewPage.reloadTables.click();
		Assert.assertEquals(tableStructurePage.titleOfTableStructure(), testUtil.readDataFromExcellString(6,2,0), "Table Structure page is not found upon reloading table from Admin Settings");
		testUtil.writeStringValue(9, 3, 2);
	}

	}
	
	
	




