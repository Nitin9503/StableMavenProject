package com.torenzo.qa.pomtest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;








import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.ResetPinPage;
import com.torenzo.qa.pages.SuspendedOrderListPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.TestUtil;

public class ResetPinPageTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;
	public OrderPage orderPage;
	public ResetPinPage resetPinPage;
	public TestUtil testUtil;
	
	
	public ResetPinPageTest() throws IOException {
		super();
		
	}
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException {

		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		resetPinPage= new ResetPinPage(driver);
		testUtil = new TestUtil(driver);
	
	
	
	}

	@Test(priority=1)
	public void LoginIntoAppTest() throws IOException, InterruptedException{		 
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
	public void verifyResetPinWindowtest() throws IOException, InterruptedException{
    	Thread.sleep(2000);
    	System.out.println("enter into rest pin Test");
    	//homePage.clickUserDetailsButton(); 
    	resetPinPage.userDetailClick();
    	System.out.println("user detail text ---->"+testUtil.readDataFromExcellString(3, 1, 0));
    	assertEquals(resetPinPage.getUserDetailsTitle(), testUtil.readDataFromExcellString(3, 1, 0), "Required User Details Title not showing" );
        testUtil.writeStringValue(3, 1, 2);
    	resetPinPage.resetClickOption();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Assert.assertEquals(resetPinPage.getResetPinTorenzoTitle(), testUtil.readDataFromExcellString(3, 3, 0), "User is not navigated on Reset Window after clicking on Reset Pin Option.");
    	 }
	
	@Test(priority=3)
	public void VerifyResetPinWithInvalidNumberTest() throws IOException, InterruptedException{
		resetPinPage.enterCurrentPin(testUtil.readDataFromExcellString(3, 4, 0));
		resetPinPage.enterNewPin(testUtil.readDataFromExcellString(3, 5, 0));
		resetPinPage.enterConfirmedNewPin(testUtil.readDataFromExcellString(3, 6, 0));
		testUtil.writeStringValue(3, 4, 2);
		resetPinPage.clickOnRestButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().alert().getText();
		
   		
    // Switching to Alert        
    Alert alert = driver.switchTo().alert();		
    		
    // Capturing alert message.    
    String alertMessage= driver.switchTo().alert().getText().substring(6);		
    		
    // Displaying alert message		
    System.out.println(alertMessage);	
    Thread.sleep(5000);
    		
    // Accepting alert		
    alert.accept();	
     
    Assert.assertEquals(alertMessage, testUtil.readDataFromExcellString(3, 7, 0), "Alert message not displyed and not match");
    testUtil.writeStringValue(3, 7, 2);
	}
	@Test(priority=4)
	public void verifyResetPinWithValidpinTest() throws IOException, InterruptedException{
		resetPinPage.enterCurrentPin(testUtil.readDataFromExcellString(3, 8, 0));
		resetPinPage.enterNewPin(testUtil.readDataFromExcellString(3, 9, 0));
		resetPinPage.enterConfirmedNewPin(testUtil.readDataFromExcellString(3, 10, 0));
		testUtil.writeStringValue(3, 8, 2);
		resetPinPage.clickOnRestButton();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Alert alert = driver.switchTo().alert();		
		
	    // Capturing alert message.    
	    String alertMessage= driver.switchTo().alert().getText().substring(6);		
	    		
	    // Displaying alert message		
	    System.out.println(alertMessage);	
	    Thread.sleep(5000);
	    		
	    //Accepting alert		
	    alert.accept();	
		
	}
	@Test(priority=5)
	public void verifyClickOnBack() throws IOException, InterruptedException{
		resetPinPage.backButtonClick();
		Assert.assertEquals(resetPinPage.getUserDetailsTitle(), testUtil.readDataFromExcellString(3, 1, 0), "User is not Navigated to User detail Popup after click on Back button ");
	    testUtil.scrollTillText("Lock");
	}
	@Test(priority=6)
	public void verifyLockScreenWithNewPin(){
		resetPinPage.lockOption.click();
		
		
		
	} 
	
	/*@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
	
	}
	*/
	
	
	
}
