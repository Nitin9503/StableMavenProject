package com.torenzo.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;


public class LoginPage extends TestBase{

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/open_exist_store")
	public WebElement openExistStoreButton;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/view_sample_store")
	public WebElement viewSampleStoreButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Torenzo Cafe']")
	public WebElement titleOfLoginPage;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/access_name")
	public WebElement editTextAccessName;
	

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/access_code")
	public WebElement editTextAccessCode;

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/submit_login")
	public WebElement submitLoginButton;
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Clock-In']")
	public WebElement titileClockIn;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/clock_in")
	public WebElement clockInButton;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/role_name")
	public WebElement roleNameButton;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/cancel_clockin_popup")
	public WebElement cancelClockinFromClockingWindow;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Allow']")
	public WebElement allowButtonText;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement permissionAllowButton;
	
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	
	public boolean validatelaunchLink() throws InterruptedException{
     Thread.sleep(9000);		
	return openExistStoreButton.isDisplayed();

				
	}
	public void clickOnOpenExistStoreButton(){
	
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);	
	openExistStoreButton.click();
				
	}
	
	public boolean titleOfLoginPage(){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return titleOfLoginPage.isDisplayed();
	}
	
	public void passCreadentilas(String un, String pwd){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		editTextAccessName.sendKeys(un);
		editTextAccessCode.sendKeys(un);
		
	}
	public void clickOnSubmitLoginButton(){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		submitLoginButton.click();
				
	}
	
	public boolean validateClockInButton()
	{
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return clockInButton.isDisplayed();
	
	}
	
	public void clickOnClockInButton(){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		clockInButton.click();
				
	}
	
	public boolean validateTitileClockIn()
	{
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return titileClockIn.isDisplayed();
	
	}
	
	
	
	public void clickOnroleNameButton(){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		roleNameButton.click();
		
	}
	
    public boolean validatePermissionPopup(){
    	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return allowButtonText.isDisplayed();
	}
	
	
	public HomePage clickOnPermissionPupup(){
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		permissionAllowButton.click();
		permissionAllowButton.click();
		return new HomePage(driver);
	}
	
	
	

	
	
	
	
}
	





















	
	/*public String validateLoginPageTitle()
	{

		return driver.findElement(By.xpath("//android.widget.TextView[@text='Open Existing Restaurant/Store (Live Users)']")).getText();
	
	}
	public boolean validateTorenzologo()
	{
		 System.out.println("Hello1");
		return driver.findElement(By.xpath("//imp[contains(@class,'android.widget.ImageView')]")).isDisplayed();
	
	}
	
	public void login (String un, String pwd)
	{
		driver.findElement(By.xpath(obj.getProperty("Live-User"))).click();
		driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys(un);
		driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys(pwd);
		driver.findElement(By.id(obj.getProperty("Submit"))).click();	
		
	}
	
	public void ClickOnly()
	{
		driver.findElement(By.xpath(obj.getProperty("Live-User"))).click();
		driver.findElement(By.id(obj.getProperty("Submit"))).click();
		driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
		 driver.findElement(By.id("role_name")).click();
		
	}
	public String clockinButton()
	{
		
		return driver.findElement(By.id(obj.getProperty("Clock-In"))).getText();
	}
	
	public String clockinTypeWindowTitle()
	{
		driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
	
		return driver.findElement(By.xpath(obj.getProperty("Clockintypewindow"))).getText();
	}
	
	
	
	public String permissionPopup() 
	{
		 driver.findElement(By.id("role_name")).click();
		 
		 
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Allow Torenzo to access photos, media, and files on your device?']")).getText();
		
	
	}
	public HomePage Navigation()
	{
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	    driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		return new HomePage();
	}
	
	
}



*/














	/*//@Test(alwaysRun=true)
	public void login() throws IOException
	{
 

		System.out.println("Value of Live user" +obj.getProperty("Live-User"));
    try{

	
	    if(driver.findElement(By.xpath(obj.getProperty("TitleLogin"))).isDisplayed())
		{
	    	driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys(obj.getProperty("username"));
            driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys(obj.getProperty("password"));
			driver.findElement(By.id(obj.getProperty("Submit"))).click();
		   driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
		 
		   driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
		    System.out.println("on home page");
		    driver.unlockDevice();
		}
		
		
	}catch(Exception e)
	{
	    
		driver.findElement(By.xpath(obj.getProperty("Live-User"))).click();
		//driver.findElement(By.xpath("Demo-User")).click();
		driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys(obj.getProperty("username"));
        driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys(obj.getProperty("password"));
     	driver.findElement(By.id(obj.getProperty("Submit"))).click();
	    driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
	    driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
	    System.out.println("on home page");
	}
	

}
	
	
	

}
*/