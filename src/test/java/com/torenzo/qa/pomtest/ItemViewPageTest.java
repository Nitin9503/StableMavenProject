package com.torenzo.qa.pomtest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.util.TestUtil;

public class ItemViewPageTest extends TestBase {

	public  HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;	
    public TestUtil testUtil;

	public ItemViewPageTest() throws IOException {
		super();
	
	}

	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();	
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		 testUtil = new TestUtil(driver);
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
	    homePage = loginPage.clickOnPermissionPupup();				
	 
	}

	@Test(priority=2)
	public void verifyItemFirstViewTest() throws IOException, InterruptedException{		
		homePage.allItemFirstView.click();
		String itemName =homePage.searchItemInFirstView(4);
		homePage.searchItemOrCategory(itemName.toLowerCase());
		Assert.assertEquals(itemName, homePage.searchItemInFirstView(0), "Item name is not matched after searching in first view");
		homePage.itemNames.get(0).click();
		Assert.assertTrue(orderPage.orderNumberFromOrderPage(), "Order is not created after searching and clicking on item");
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");	
		homePage.cancelSearch.click();		
	}
	
	@Test(priority=2)
	public void verifyItemSecondViewTest() throws IOException, InterruptedException{		
		homePage.allItemSecondViewInList.click();
		String itemName =homePage.searchItemInSecondView(4);
		homePage.searchItemOrCategory(itemName.toLowerCase());
		Assert.assertEquals(itemName, homePage.searchItemInSecondView(0), "Item name is not matched after searching in second view");
		homePage.itemNamesVertical.get(0).click();
		Assert.assertTrue(orderPage.orderNumberFromOrderPage(), "Order is not created after searching and clicking on item");
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");	
		homePage.cancelSearch.click();
	
	}
	
	@Test(priority=3)
	public void verifyItemLastViewTest() throws IOException, InterruptedException{		
		homePage.categoryViseList.click();
		String itemName =homePage.searchICategoryInLastView(4);
		homePage.searchItemOrCategory(itemName.toLowerCase());
		Assert.assertEquals(itemName, homePage.searchICategoryInLastView(0), "Category name is not matched after searching in last view");
		homePage.categoryNames.get(0).click();
		Assert.assertTrue(orderPage.orderNumberFromOrderPage(), "Order is not created after searching and clicking on item");
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");	
		homePage.cancelSearch.click();
	
	}
	
	
	/*
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {	
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
	
	}*/

}
