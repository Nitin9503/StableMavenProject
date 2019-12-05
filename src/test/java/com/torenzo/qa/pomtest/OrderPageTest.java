package com.torenzo.qa.pomtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.torenzo.qa.pages.OrderPage.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.ItemOperationPage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.TestUtil;

public class OrderPageTest extends TestBase {
	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	public ItemOperationPage itemOperationPage; 
	public TestUtil testUtil;	
	public OrderPageTest() throws IOException{		
		super();
	}
	
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		 itemOperationPage = new ItemOperationPage(driver);
		 testUtil = new TestUtil(driver);
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
	
	@Test(priority = 2)
	public void addItemToOrder() throws InterruptedException, IOException{	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		int guestCount =orderPage.totolGuestCount();		
		System.out.println("Total guest for the order==>" +guestCount);		
		orderPage.selectGuestandAddItem();
		String menuItemPriceBefore = orderPage.menuItemPrice();
		System.out.println("value" +value);
		double itemQuantityAfter = value - 1;
		Assert.assertEquals(itemQuantityAfter, orderPage.itemQuantity(),  "Item quntity is not reduced after adding item to order");
		testUtil.writeStringValue(2, 10, 2);
		Assert.assertEquals(menuItemPriceBefore, orderPage.singleItemPriceFromOrder(0),  "Menu item price and same order price is not matched in order list");	
		testUtil.writeStringValue(2, 11, 2);
		orderPage.totalItemValue();
		System.out.println("Order Total from hub =>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		Assert.assertEquals(orderPage.totalItemValue(), Double.valueOf(homePage.getTextFromOrderTotal()),  "Item total and Total of order is not matched");
		testUtil.writeStringValue(2, 2, 2);
	}
	
	
	
	@Test(priority = 3)
	public void deleteItemFromOrderTest() throws InterruptedException, IOException{			
		orderPage.clickOnOrderedItem(0);
		Assert.assertEquals(itemOperationPage.getTextOptionForItem(), testUtil.readDataFromExcellString(5,1,0),  "Item option window is not displayed upon clicking on Item");		
		testUtil.writeStringValue(5, 1, 2);	
		itemOperationPage.delete.click();		
		Assert.assertEquals(itemOperationPage.confirmationDeletGuest(), testUtil.readDataFromExcellString(5,2,0),  "Item option window is not displayed upon clicking on Item");		
		testUtil.writeStringValue(5, 2, 2);	
		itemOperationPage.cancelConfirmation.click();
		testUtil.writeStringValue(5, 3, 2);	
		double orderTotal = Double.valueOf(homePage.getTextFromOrderTotal());
		double singleItem = orderPage.singleItemValueFromOrder(0);
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found aftre deleting on item");
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.delete.click();
		itemOperationPage.oKConfirmation.click();
		double orderTotalDelete = orderTotal - singleItem;
		Assert.assertEquals(orderTotalDelete, Double.valueOf(homePage.getTextFromOrderTotal()),  "Order total is not matched after deleting item from order");
		testUtil.writeStringValue(5, 4, 2);	
		homePage.categoryViseList.click();
	}
	
	@Test(priority = 4)
	public void reorderItemFromOrderTest() throws InterruptedException, IOException{	
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		int guestCount =orderPage.totolGuestCount();		
		System.out.println("Total guest for the order==>" +guestCount);		
		orderPage.selectGuestandAddItem();
		double orderTotal = Double.valueOf(homePage.getTextFromOrderTotal());
		System.out.println("orderTotal====>"  +orderTotal);
		double singleItem = orderPage.singleItemValueFromOrder(0);
		System.out.println("singleItem====>"  +singleItem);
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.reorder.click();
		double orderTotalReorder = orderTotal + singleItem;
		System.out.println("orderTotalReorder====>"  +orderTotalReorder);
		System.out.println("Double.valueOf(homePage.getTextFromOrderTotal()====>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Assert.assertEquals(orderTotalReorder, Double.valueOf(homePage.getTextFromOrderTotal()),  "Order total is not matched after reording item to order");
		testUtil.writeStringValue(5, 5, 2);		
	}
	
	@Test(priority = 5)
	public void quantityItemFromOrderTest1() throws InterruptedException, IOException{	
		double singleItemBefore = orderPage.singleItemValueFromOrder(1);
		double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());
		double quantityBefore  = orderPage.orderedItemQuantity(1);
		double itemQuantityAfter = value - 1;
		orderPage.clickOnOrderedItem(1);
		itemOperationPage.quantity.click();
		Assert.assertEquals(itemOperationPage.quntityTitle(), testUtil.readDataFromExcellString(5,6,0),  "Item option window is not displayed upon clicking on Item");		
		testUtil.writeStringValue(5, 6, 2);	
		itemOperationPage.addTwoGuestClick.click();
		double qunatityEnter = Double.valueOf(itemOperationPage.editNumberText());
		itemOperationPage.doneQuantity.click();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after adding quantity to item");		
		System.out.println("itemQuantityAfter" +itemQuantityAfter);
		System.out.println("orderPage.itemQuantity()" +orderPage.itemQuantity());
		Assert.assertEquals(itemQuantityAfter, orderPage.itemQuantity(),  "Item quntity is not reduced after adding item to order from qunatity window");
		Assert.assertEquals(qunatityEnter, orderPage.orderedItemQuantity(1), "Quantiy of the item is not matched after adding from window to order");		
		testUtil.writeStringValue(5, 7, 2);
		double singleItemAfter =  singleItemBefore * qunatityEnter;	
		Assert.assertEquals(singleItemAfter, orderPage.singleItemValueFromOrder(1), "Single item price is not increased after adding quantiy to order");		
		testUtil.writeStringValue(5, 8, 2);		
		double orderTotalAfter =  orderTotalBefore + singleItemBefore;	
		Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total value is not increased after adding quantity to order");		
		testUtil.writeStringValue(5, 9, 2);
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.quantity.click();
		itemOperationPage.cancel.click();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after canceling quantity window");		
	}
	@Test(priority = 6)
	public void quantityItemFromOrderTest2() throws InterruptedException, IOException{	
		orderPage.clickOnOrderedItem(1);
		itemOperationPage.quantity.click();
		itemOperationPage.addTwoGuestClick.click();
		itemOperationPage.deleteQuantity.click();
		Assert.assertTrue(itemOperationPage.editNumberText().isEmpty(), "Guest value is not removed from guest edit box after pressing on Arrow");
		itemOperationPage.cancel.click();;
		testUtil.writeStringValue(5, 10, 2);
		double qunatity = orderPage.itemQuantity();
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.quantity.click();
		itemOperationPage.quntityAdd(qunatity);
		itemOperationPage.doneQuantity.click();
		Assert.assertEquals(itemOperationPage.confirmationDeletGuest(), testUtil.readDataFromExcellString(5,12,0),  "Quantity window is displayed upon clickin on OK from alert popup");	
		testUtil.writeStringValue(5, 11, 2);
		testUtil.writeStringValue(5, 12, 2);
		System.out.println("Helooooo==>"+itemOperationPage.getAlertMessage());	
		itemOperationPage.cancelConfirmation.click();
		Assert.assertEquals(itemOperationPage.quntityTitle(), testUtil.readDataFromExcellString(5,6,0),  "Quantity window is displayed upon clickin on OK from alert popup");		
		itemOperationPage.cancel.click();
		homePage.categoryViseList.click();
		
	}
	
	@Test(priority = 7)
	public void customModifierAddWindowTest1() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");	
		orderPage.selectGuestandAddItem();
		double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.modifier.click();
		Assert.assertEquals(itemOperationPage.getTextApplyModifiers(), testUtil.readDataFromExcellString(5,13,0),  "Item option window is not displayed upon clicking on Item");		
		testUtil.writeStringValue(5, 13, 2);	
		itemOperationPage.customModifierAdd.sendKeys(testUtil.readDataFromExcellString(5,14,0));
		itemOperationPage.customModifierCount.sendKeys(testUtil.readDataFromExcellString(5,15,0));	
		itemOperationPage.addCustomModifierBtn.click();	
		Assert.assertEquals(itemOperationPage.getTextModifierType(0), testUtil.readDataFromExcellString(5,14,0), "Added custom modifier(Modifier name) to item is not displayed below to modifier window");		
		Assert.assertEquals(itemOperationPage.getTextModifierCharges(0 , testUtil.readDataFromExcellString(5,15,0)), testUtil.readDataFromExcellString(5,15,0), "Added custom modifier(Charges name) to item is not displayed below to modifier window");		
		testUtil.writeStringValue(5, 16, 2);
		itemOperationPage.doneItemModifier.click();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after adding custom modifier to item");		
		Assert.assertEquals(orderPage.orderedItemModifierName(0), testUtil.readDataFromExcellString(5,14,0), "Home page is not found after adding custom modifier to item");		
		testUtil.writeStringValue(5, 17, 2);
		Assert.assertEquals(orderPage.orderedModifierPrice(0 , testUtil.readDataFromExcellString(5,15,0)),testUtil.readDataFromExcellString(5,15,0), "Home page is not found after adding custom modifier to item");		
		testUtil.writeStringValue(5, 18, 2);		
		double orderTotalAfter = orderTotalBefore + Double.valueOf(testUtil.readDataFromExcellString(5,15,0));
		Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not increased after adding modifier price to item");		
		testUtil.writeStringValue(5, 19, 2);

	}
	
	@Test(priority = 8)
	public void custommodifierDelAndEditWindowTest2() throws InterruptedException, IOException{			
		double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());
		double modifierPriceBefore = Double.valueOf(orderPage.orderedModifierPrice(0 , testUtil.readDataFromExcellString(5,15,0)));
		int totalModifierBefore = orderPage.totalModifier();
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.modifier.click();				
		testUtil.swapRightToLeft(itemOperationPage.ModifierCharges(0),itemOperationPage.ModifierType(0));
		itemOperationPage.deleteModifier.click();
		double orderTotalAfter = orderTotalBefore - modifierPriceBefore ;
		itemOperationPage.doneItemModifier.click();		
		int totalModifierAfter = totalModifierBefore - 1;
		Assert.assertEquals(totalModifierAfter , orderPage.totalModifier(), "Modifier is not deleted from order after deleting modifier modifier window");		
		testUtil.writeStringValue(5, 20, 2);
		Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not decrased after deleting modifier from modifier window");		
		testUtil.writeStringValue(5, 21, 2);	
				
		//continue without modifier.
		orderPage.clickOnOrderedItem(1);
		itemOperationPage.modifier.click();
		itemOperationPage.ModifierType(1).click();	
		boolean modiferCheck = orderPage.orderedItemModifierNameForContinueRegular(itemOperationPage.getTextModifierType(3));
		itemOperationPage.continueRegulerModifierBtn.click();
		Assert.assertTrue(modiferCheck,"Selected modifier and click continue the with without modifier modifier is  present on order(FAIL) " );
		testUtil.writeStringValue(5, 35, 2);	
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after clicking on continue regular");		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.modifier.click();	
		itemOperationPage.customModifierAdd.sendKeys(testUtil.readDataFromExcellString(5,14,0));
		itemOperationPage.customModifierCount.sendKeys(testUtil.readDataFromExcellString(5,15,0));	
		itemOperationPage.addCustomModifierBtn.click();
		itemOperationPage.doneItemModifier.click();		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.modifier.click();
		testUtil.swapRightToLeft(itemOperationPage.ModifierCharges(0),itemOperationPage.ModifierType(0));
		itemOperationPage.editModifier.click();
		itemOperationPage.passkModifierCharges(0, testUtil.readDataFromExcellString(5,22,0));	
		itemOperationPage.passModifierType(0, testUtil.readDataFromExcellString(5,23,0));
		itemOperationPage.saveModifier.click();
		String editedModifierCharges = itemOperationPage.getTextModifierCharges(0 ,testUtil.readDataFromExcellString(5,22,0));	
		String editedModifierName = itemOperationPage.getTextModifierType(0);
		itemOperationPage.doneItemModifier.click();
		Assert.assertEquals(orderPage.orderedItemModifierName(0), editedModifierName, "Modifier name is not mathced with order item in order after edting from modifier window");		
		testUtil.writeStringValue(5, 24, 2);
		Assert.assertEquals(orderPage.orderedModifierPrice(0 ,testUtil.readDataFromExcellString(5,22,0) ),editedModifierCharges, "Modifier price is not mathced with order item in order after edting from modifier window");		
		testUtil.writeStringValue(5, 25, 2);
		double orderTotalAfter1 =  orderTotalBefore + Double.valueOf(testUtil.readDataFromExcellString(5,22,0)) -1;		
		Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not increased after editing modifier value from modifier window");		
		testUtil.writeStringValue(5, 26, 2);
		
	}

	@Test(priority = 9)
	public void defaultmodifierDelAndEditWindowTest3() throws InterruptedException, IOException{			
		double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());
		double modifierPriceBefore = Double.valueOf(orderPage.orderedModifierPrice(1 , orderPage.orderedCustomModifierPrice(1)));
		int totalModifierBefore = orderPage.totalModifier();
		orderPage.clickOnOrderedItem(1);
		itemOperationPage.modifier.click();	
		Thread.sleep(5000);
		testUtil.swapRightToLeft(itemOperationPage.ModifierCharges(0),itemOperationPage.ModifierType(3));

		itemOperationPage.deleteModifier.click();
		double orderTotalAfter = orderTotalBefore - modifierPriceBefore ;
		itemOperationPage.doneItemModifier.click();		
		int totalModifierAfter = totalModifierBefore - 1;
		Assert.assertEquals(totalModifierAfter , orderPage.totalModifier(), "Modifier is not deleted from order after deleting modifier modifier window");		
		testUtil.writeStringValue(5, 27, 2);
		Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not decrased after deleting modifier from modifier window");		
		testUtil.writeStringValue(5, 28, 2);	

		orderPage.clickOnOrderedItem(1);
		itemOperationPage.modifier.click();
		Thread.sleep(4000);
		itemOperationPage.ModifierType(1).click();	///not able to click heres
		String modifierNameFromWindow = itemOperationPage.getTextModifierType(3);
		String modifierChargesFromWindow = itemOperationPage.getTextModifierCharges(0);
		Assert.assertEquals(itemOperationPage.getTextModifierPrices(0), itemOperationPage.getTextModifierCharges(0), "Default modifier amount is not matched with below modifier name when added from modifier window");		
		testUtil.writeStringValue(5, 29, 2);
		itemOperationPage.doneItemModifier.click();	
		Assert.assertEquals(orderPage.orderedItemModifierName(1) ,modifierNameFromWindow, "Default modifier name is not matched with modifier added to order");		
		testUtil.writeStringValue(5, 30, 2);
	
		Assert.assertEquals(modifierChargesFromWindow, orderPage.orderedDefaultModifierPrice(1), "Default modifier price is not matched with modifier added to order ");		
		testUtil.writeStringValue(5, 31, 2);		
		double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());
		orderPage.clickOnOrderedItem(1);
		itemOperationPage.modifier.click();
		testUtil.swapRightToLeft(itemOperationPage.ModifierCharges(0),itemOperationPage.ModifierType(3));
		itemOperationPage.editModifier.click();
		itemOperationPage.passkModifierCharges(0, testUtil.readDataFromExcellString(5,22,0));	
		itemOperationPage.passModifierType(3, testUtil.readDataFromExcellString(5,23,0));
		itemOperationPage.saveModifier.click();
		String editedModifierCharges = itemOperationPage.getTextModifierCharges(0 ,testUtil.readDataFromExcellString(5,22,0));	
		String editedModifierName = itemOperationPage.getTextModifierType(3);
		itemOperationPage.doneItemModifier.click();
		Assert.assertEquals(orderPage.orderedItemModifierName(1), editedModifierName, "Default Modifier name is not mathced with order item in order after edting from modifier window");		
		testUtil.writeStringValue(5, 32, 2);	
		Assert.assertEquals(orderPage.orderedModifierPrice(0 ,testUtil.readDataFromExcellString(5,22,0) ),editedModifierCharges, " Default Modifier price is not mathced with order item in order after edting from modifier window");		
		testUtil.writeStringValue(5, 33, 2);	
		double orderTotalAfter1 =  orderTotalBefore1 + Double.valueOf(testUtil.readDataFromExcellString(5,22,0));
		System.out.println("orderTotalAfter1==>" +orderTotalAfter1);
		System.out.println("Double.valueOf(homePage.getTextFromOrderTotal())==>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not increased after editing default modifier value from modifier window");		
		testUtil.writeStringValue(5, 34, 2);	
	}
	
	
	@Test(priority = 10)
	public void orderDiscount() throws InterruptedException, IOException{	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		homePage.categoryViseList.click();
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");		      
		orderPage.selectGuestandAddItem();
		double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	//read from excell title
		Assert.assertEquals(itemOperationPage.getTextItemDiscount(), testUtil.readDataFromExcellString(5,37,0), "Discount window is not opened upon clicking on discount from ordered item");		
		testUtil.writeStringValue(5, 37, 2);
		itemOperationPage.passReason(testUtil.readDataFromExcellString(5,38,0));
		itemOperationPage.passAmount(testUtil.readDataFromExcellString(5,39,0));
		itemOperationPage.apply.click();		
		Assert.assertEquals(itemOperationPage.getTextReasonFromBelow(0), testUtil.readDataFromExcellString(5,38,0), "Added reason is not matched with the added reason at below");		
		testUtil.writeStringValue(5, 40, 2);
		Assert.assertEquals(itemOperationPage.getTextDiscountFromBelow(0), testUtil.decimalFormate(testUtil.readDataFromExcellString(5,39,0)), "Added discount is not matched with the added discount at below");		
		testUtil.writeStringValue(5, 41, 2);
		String reasonDiscountWindow = itemOperationPage.getTextReasonFromBelow(0);		
		String discoutDiscount  = itemOperationPage.getTextDiscountFromBelow(0);
		double discoutDiscountWindow =Double.valueOf(discoutDiscount);
		double orderTotalAfter = orderTotalBefore -discoutDiscountWindow;	
		itemOperationPage.doneDiscount.click();	
		Assert.assertEquals(reasonDiscountWindow, orderPage.orderedDefaultModifierPrice1(0), "Added reason for discount is not matched with the order item on order page");		
		testUtil.writeStringValue(5, 42, 2);
		Assert.assertEquals(discoutDiscountWindow, orderPage.orderedItemModifierName(0), "Added discount is not matched with the order item on order page");		
		testUtil.writeStringValue(5, 43, 2);
		Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after adding discount amount to order");		
		testUtil.writeStringValue(5, 44, 2);
		
		double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());	
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		testUtil.swapRightToLeft(itemOperationPage.discountFromBelow(0),itemOperationPage.reasonFromBelow(0));
		itemOperationPage.editDiscount.click();		
		itemOperationPage.reasonFromBelow(0, testUtil.readDataFromExcellString(5,38,0));
		itemOperationPage.discountFromBelow(0, testUtil.readDataFromExcellString(5,39,0));
		itemOperationPage.saveDiscount.click();
		
		String reasonDiscountWindow1 = itemOperationPage.getTextReasonFromBelow(0);		
		String discoutDiscount1  = itemOperationPage.getTextDiscountFromBelow(0);
		double discoutDiscountWindow1 =Double.valueOf(discoutDiscount1);
		double orderTotalAfter1 = orderTotalAfter -discoutDiscountWindow1;
		itemOperationPage.doneDiscount.click();
		Assert.assertEquals(reasonDiscountWindow1, orderPage.orderedItemModifierName(0), "Added discount is not matched with the order item on order page");		
		testUtil.writeStringValue(5, 47, 2);
		Assert.assertEquals(discoutDiscountWindow1, orderPage.orderedDefaultModifierPrice1(0), "Added reason for discount is not matched with the order item on order page");		
		testUtil.writeStringValue(5, 48, 2);
		Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after adding discount amount to order");		
		testUtil.writeStringValue(5, 49, 2);
		
	}
	
	

/*	@Test(priority = 11)
	public void orderDiscountDeletTest() throws InterruptedException, IOException{	
	//proper for delete discount but there is added in the mantis
		double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());	
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		testUtil.swapRightToLeft(itemOperationPage.discountFromBelow(0),itemOperationPage.reasonFromBelow(0));
		itemOperationPage.deleteDiscount.click();		
		double orderTotalAfter1 = orderTotalBefore1  + Double.valueOf(testUtil.readDataFromExcellString(5,46,0));
		itemOperationPage.cancelModifierDialog.click();
		Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after deleting discount amount to order");		
		testUtil.writeStringValue(5, 50, 2);
		
	}*/
	
	@Test(priority = 12)
	public void orderDiscountExtraAmountTest() throws InterruptedException, IOException{	
		double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());
		double singleItem = Double.valueOf(orderPage.singleItemPriceFromOrder(0) +1);
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		itemOperationPage.passReason(testUtil.readDataFromExcellString(5,45,0));
		itemOperationPage.passAmount(String.valueOf(singleItem));
		itemOperationPage.apply.click();
		Assert.assertEquals(itemOperationPage.confirmationDeletGuest(), testUtil.readDataFromExcellString(5,51,0), "Discount is accepted more than price of item ");			
		testUtil.writeStringValue(5, 52, 2);
		itemOperationPage.cancelConfirmation.click();
		itemOperationPage.cancelModifierDialog.click();		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		testUtil.swapRightToLeft(itemOperationPage.discountFromBelow(0),itemOperationPage.reasonFromBelow(0));
		itemOperationPage.editDiscount.click();
		itemOperationPage.reasonFromBelow(0, testUtil.readDataFromExcellString(5,45,0));
		itemOperationPage.discountFromBelow(0, String.valueOf(singleItem));		
		itemOperationPage.saveDiscount.click();
		Assert.assertEquals(itemOperationPage.confirmationDeletGuest(), testUtil.readDataFromExcellString(5,51,0), "Discount is accepted more than price of item ");				
		testUtil.writeStringValue(5, 53, 2);
		itemOperationPage.cancelConfirmation.click();
		itemOperationPage.cancelModifierDialog.click();

	}

	
	//Test script for percentage discount is not done need some improvement
	@Test(priority = 13)
	public void orderDiscountPercentTest() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		homePage.categoryViseList.click();
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");		      
		orderPage.selectGuestandAddItem();
		double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());
		
		/*//discoutn as arjun said.
		double singleItem = Double.valueOf(orderPage.singleItemPriceFromOrder(0));
		double singleItemPriceAfterDiscount = (singleItem) / (Double.valueOf(testUtil.readDataFromExcellString(5,54,0))*100);
		System.out.println("singleItemPriceAfterDiscount==>" +singleItemPriceAfterDiscount);*/
		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		itemOperationPage.passReason(testUtil.readDataFromExcellString(5,38,0));
		itemOperationPage.passAmount(testUtil.readDataFromExcellString(5,54,0));
		itemOperationPage.percentFlag.click();
		itemOperationPage.apply.click();
		double discoutDiscount1  = Double.valueOf(itemOperationPage.getTextDiscountFromBelow(0));
		
		//Assert.assertEquals(discoutDiscount1, singleItemPriceAfterDiscount, "Percentage calculation is not matched after calculated from item and compare to below window");				
		
		double orderTotalAfter = orderTotalBefore1 -discoutDiscount1;	
		itemOperationPage.doneDiscount.click();
		System.out.println("discoutDiscount1=." +discoutDiscount1);
		System.out.println("orderPage.orderedDefaultModifierPrice1(1)=." +orderPage.orderedDefaultModifierPrice1(0));
		Assert.assertEquals(discoutDiscount1, orderPage.orderedDefaultModifierPrice1(0) ,  "Percentage calculation is not matched after calculated from item and compare to below window");				
		testUtil.writeStringValue(5, 55, 2);
		//percentage discount
	//	Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()) -discoutDiscount1, "Order total is not matched after adding percenatage discount to order");		
		testUtil.writeStringValue(5, 56, 2);
		
		orderPage.clickOnOrderedItem(0);
		itemOperationPage.discount.click();	
		testUtil.swapRightToLeft(itemOperationPage.discountFromBelow(0),itemOperationPage.reasonFromBelow(0));
		itemOperationPage.editDiscount.click();		
		itemOperationPage.reasonFromBelow(0, testUtil.readDataFromExcellString(5,45,0));
		itemOperationPage.discountFromBelow(0, testUtil.readDataFromExcellString(5,57,0));
		itemOperationPage.saveDiscount.click();		
		
		double discoutDiscountWindow1  = Double.valueOf(itemOperationPage.getTextDiscountFromBelow(0));
		System.out.println("discoutDiscount1==." +discoutDiscountWindow1);

		itemOperationPage.doneDiscount.click();
		double orderTotalAfter1 = orderTotalAfter - discoutDiscountWindow1;
		Assert.assertEquals(discoutDiscountWindow1, orderPage.orderedDefaultModifierPrice1(0), "Added for discount item is not matched aftre edting with the ordered item on order page");		
		testUtil.writeStringValue(5, 58, 2);
		System.out.println("orderTotalAfter1==." +orderTotalAfter1);
		System.out.println("Double.valueOf(homePage.getTextFromOrderTotal()==." +Double.valueOf(homePage.getTextFromOrderTotal()));
	//	Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after editing discount amount to order");		
		testUtil.writeStringValue(5, 59, 2);
	
	
	}
	
	
		@AfterClass
		public void tearDown() throws InterruptedException, IOException {
			
			driver.quit();
	        Thread.sleep(5000);
	    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
			Thread.sleep(6000);
		
		}

}











/*@Test(priority = 10)
public void orderDiscount() throws InterruptedException, IOException{	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	homePage.categoryViseList.click();
	transactionOrderPage = homePage.clickNewOrderCreateBtn();	
	System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");		      
	orderPage.selectGuestandAddItem();	
	double orderTotalBefore = Double.valueOf(homePage.getTextFromOrderTotal());	
	orderPage.clickOnOrderedItem(0);
	itemOperationPage.discount.click();	//read from excell title
	Assert.assertEquals(itemOperationPage.getTextItemDiscount(), testUtil.readDataFromExcellString(5,37,0), "Discount window is not opened upon clicking on discount from ordered item");		
	testUtil.writeStringValue(5, 37, 2);
	itemOperationPage.passReason(testUtil.readDataFromExcellString(5,38,0));
	itemOperationPage.passAmount(testUtil.readDataFromExcellString(5,39,0));
	itemOperationPage.apply.click();		
	Assert.assertEquals(itemOperationPage.getTextReasonFromBelow(0), testUtil.readDataFromExcellString(5,38,0), "Added reason is not matched with the added reason at below");		
	testUtil.writeStringValue(5, 40, 2);		

	
	Assert.assertEquals(itemOperationPage.getTextDiscountFromBelow(0, testUtil.readDataFromExcellString(5,39,0)), testUtil.readDataFromExcellString(5,39,0), "Added discount is not matched with the added discount at below");		
	testUtil.writeStringValue(5, 41, 2);
	
	String reasonDiscountWindow = itemOperationPage.getTextReasonFromBelow(0);		
	String discoutDiscount  = itemOperationPage.getTextDiscountFromBelow(0);
	double discoutDiscountWindow =Double.valueOf(discoutDiscount);
	double orderTotalAfter = orderTotalBefore -discoutDiscountWindow;	
	itemOperationPage.doneDiscount.click();	
	Assert.assertEquals(reasonDiscountWindow, orderPage.orderedItemModifierName(0), "Added reason for discount is not matched with the order item on order page");		
	testUtil.writeStringValue(5, 42, 2);
	Assert.assertEquals(discoutDiscountWindow, orderPage.orderedDefaultModifierPrice1(0), "Added discount is not matched with the order item on order page");		
	testUtil.writeStringValue(5, 43, 2);
	Assert.assertEquals(orderTotalAfter, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after adding discount amount to order");		
	testUtil.writeStringValue(5, 44, 2);
	
	double orderTotalBefore1 = Double.valueOf(homePage.getTextFromOrderTotal());	
	orderPage.clickOnOrderedItem(0);
	itemOperationPage.discount.click();	
	testUtil.swapRightToLeft(itemOperationPage.discountFromBelow(0),itemOperationPage.reasonFromBelow(0));
	itemOperationPage.editDiscount.click();		
	itemOperationPage.reasonFromBelow(0, testUtil.readDataFromExcellString(5,45,0));
	itemOperationPage.discountFromBelow(0, testUtil.readDataFromExcellString(5,46,0));
	itemOperationPage.saveDiscount.click();
	
	String reasonDiscountWindow1 = itemOperationPage.getTextReasonFromBelow(0);		
	String discoutDiscount1  = itemOperationPage.getTextDiscountFromBelow(0);
	System.out.println("discoutDiscount1==." +discoutDiscount1);
	double discoutDiscountWindow1 =Double.valueOf(discoutDiscount1);
	System.out.println("discoutDiscountWindow1==>" +discoutDiscountWindow1);
	itemOperationPage.doneDiscount.click();
	double orderTotalAfter1 = orderTotalBefore1 - 1;
	Assert.assertEquals(reasonDiscountWindow1, orderPage.orderedItemModifierName(0), "Added discount is not matched with the order item on order page");		
	testUtil.writeStringValue(5, 47, 2);
	Assert.assertEquals(discoutDiscountWindow1, orderPage.orderedDefaultModifierPrice1(0), "Added reason for discount is not matched with the order item on order page");		
	testUtil.writeStringValue(5, 48, 2);
	Thread.sleep(4000);
	System.out.println("orderTotalAfter1==." +orderTotalAfter1);
	System.out.println("Double.valueOf(homePage.getTextFromOrderTotal()==." +Double.valueOf(homePage.getTextFromOrderTotal()));
	Assert.assertEquals(orderTotalAfter1, Double.valueOf(homePage.getTextFromOrderTotal()), "Order total is not matched after adding discount amount to order");		
	testUtil.writeStringValue(5, 49, 2);

}*/


	
	
