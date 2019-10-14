package com.torenzo.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.TransactionOrderPage;

public class GuestPageTest extends TestBase {

	public GuestPageTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	OrderPage orderPage;
	GuestPage guestPage;
	TransactionOrderPage transactionOrderPage;
	HomePageTest homePageTest;
/*
	@BeforeClass()
	public void setUp() throws IOException, InterruptedException {
		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		homePageTest = new HomePageTest();
	}*/

	@Test(priority = 0)
	public void loginApp() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePageTest.loginApp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * orderPageTest = new TransactionOrderPageTest();
		 * orderPageTest.orderTypewindowTitleTest(driver);
		 * orderPageTest.verifyCreatedOrderTest(driver);
		 * orderPageTest.AddGuestButtonTest(driver);
		 * guestPage.ClickOnAddGuest(driver);
		 */

	}

	@Test(priority = 1)
	public void clickOnCreateNewOrder() throws InterruptedException, IOException {
		transactionOrderPage = homePage.clickNewOrderCreateBtn();
		try {
			if (transactionOrderPage.getTextCancelButtonFromTransaction()) {
				transactionOrderPage.clickOnbarTabButton();
			}
		} catch (Exception e) {
			System.out.println("Normal order is created");
		}
		Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
		System.out.println("Normal order is created = " + orderPage.getTextorderNumberFromOrderPage());
	}

	@Test(priority = 2)
	public void clickOnGuestButtonVerifyWindow() throws InterruptedException, IOException {

		Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
		System.out.println("Normal order is created = " + orderPage.getTextorderNumberFromOrderPage());
		orderPage.clickOnAddGuestBtn();

		Assert.assertTrue(guestPage.verifytitleOfGuestWindow(),
				"Guest window is not displayed upon clicking on guest button");
		guestPage.clickAddGuestTwo();
		System.out.println("Normal order is created = " + guestPage.getTextGuestCountAddedFromGuestWindow());
		guestPage.clickAddGuestDoneClick();
	}

	@Test(priority = 3)
	public void verifyGuestAddedTest() throws InterruptedException {
		int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
		int guestCountFromWindow = 1 + str;
		System.out.println("guestCountFromWindow=>" + guestCountFromWindow);
		int comapre = orderPage.totolGuestCount();
		String totalguest = guestPage.getTextGuestCountAddedFromGuestWindow();
		Assert.assertEquals(guestCountFromWindow, comapre, "Guest count not matched from order page with guest window");	
		}

	

}
