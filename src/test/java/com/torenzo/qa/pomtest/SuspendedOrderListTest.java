package com.torenzo.qa.pomtest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.SuspendedOrderListPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.TestUtil;

public class SuspendedOrderListTest extends TestBase {

	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	public SuspendedOrderListPage suspendedOrderListPage;
	public TestUtil testUtil;
	String orderNumber;

	public SuspendedOrderListTest() throws IOException {
		super();

	}

	@BeforeClass
	public void launchApp() throws InterruptedException, IOException {

		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		suspendedOrderListPage = new SuspendedOrderListPage(driver);
		testUtil = new TestUtil(driver);
	}

	@Test(priority = 1)
	public void verfiyHomePageTest() throws IOException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage.validatelaunchLink();
		loginPage.clickOnOpenExistStoreButton();
		Thread.sleep(3000);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0, 3, 0),
				testUtil.readDataFromExcellString(0, 4, 0));
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
		loginPage.clickOnroleNameButton();
		Assert.assertTrue(loginPage.validatePermissionPopup(),
				"Permission popup is not found");
		homePage = loginPage.clickOnPermissionPupup();

	}
    @Test(priority = 2)
	public void OrderListPageTest() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();
		System.out.println(orderPage.getTextorderNumberFromOrderPage() + "-"
				+ "Number order is created");
		orderPage.selectGuestandAddItem();
		orderPage.totalItemValue();
		System.out.println("Order Total from hub =>"
				+ Double.valueOf(homePage.getTextFromOrderTotal()));
		double totalFromHome = Double.valueOf(homePage.getTextFromOrderTotal());
		suspendedOrderListPage.supendedlistClick();
		Assert.assertEquals(suspendedOrderListPage.OrderListTitle(),
				testUtil.readDataFromExcellString(6, 1, 0),
				"suspended order list Title not matched");
		testUtil.writeStringValue(6, 1, 2);
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void SearchBoxInSuspendedListTest() throws InterruptedException,
			IOException {
		suspendedOrderListPage.supendedlistCancel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		orderNumber = orderPage.getTextorderNumberFromOrderPage();
		suspendedOrderListPage.supendedlistClick();
		suspendedOrderListPage.supendedlistSearch(orderNumber);
		suspendedOrderListPage.supendedSearchCancel();
		testUtil.writeStringValue(6, 2, 2);

	}

	@Test(priority = 4)
	public void orderListSortByCostTest() throws IOException {
		// suspendedOrderListPage.supendedlistClick();
		suspendedOrderListPage.orderlistsortByDeceCost();
		Assert.assertEquals(suspendedOrderListPage.flags, true,
				"Order not sorted by clicking on cost_Sort click");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		suspendedOrderListPage.orderlistsortByAsceCost();
		Assert.assertEquals(suspendedOrderListPage.flags, true,
				"Order not sorted by clicking on cost_Sort click");
		testUtil.writeStringValue(6, 3, 2);
	}

	@Test(priority = 5)
	public void orderListSortByOrderNoTest() throws IOException {

		suspendedOrderListPage.orderlistsortByDecOrderNo();
		Assert.assertEquals(suspendedOrderListPage.flags, true,
				"Order not sorted by clicking on orderNo_Sort click");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		suspendedOrderListPage.orderlistsortByAsceOrderNo();
		Assert.assertEquals(suspendedOrderListPage.flags, true,
				"Order not sorted by clicking on orderNo_Sort click");
		testUtil.writeStringValue(6, 4, 2);

	}

	@Test(priority = 6)
	public void VerifyOrderInOrderListTest() throws InterruptedException,
			IOException {
		suspendedOrderListPage.supendedlistSearch(orderNumber);
		testUtil.scrollTillContainsText(suspendedOrderListPage.currentDate("dd-MMM-yyyy"));
		// System.out.println(suspendedOrderListPage.currentDate());
		suspendedOrderListPage.getDateNo();
		Assert.assertEquals(homePage.titleOfhomePage(),
				testUtil.readDataFromExcellString(6, 5, 0),
				"Order not serach and selected successfully");
		testUtil.writeStringValue(6, 5, 2);
	}

	@Test(priority = 7)
	public void gettheItemDetails(){
		
		suspendedOrderListPage.getItemDataFromDB(orderNumber, suspendedOrderListPage.currentDate("yyyy-MM-dd"));
		System.out.println(orderNumber +" -----  "+suspendedOrderListPage.currentDate("yyyy-M-dd"));
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {

		driver.quit();
		Thread.sleep(5000); 
		Runtime.getRuntime().exec(
				".\\src\\main\\java\\com\\TestData\\command.bat");
		Thread.sleep(6000);
   }
}
