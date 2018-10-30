/*package com.torenzo.qa.testcases;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.PermissionPage;


public class PermissionTest extends TestBase{

	PermissionPage permission;
	
	LoginPage loginPage;
	
	public PermissionTest()
	{
		super();
	}
	
	@BeforeTest()
	public void setUp() throws MalformedURLException{
		initilization();
		loginPage = new LoginPage();
		//  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("Live-User"))).click();
		driver.findElement(By.id(prop.getProperty("Submit"))).click();
		driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
		 driver.findElement(By.id("role_name")).click();
				 
	}
	
	@Test(priority = 0)
	public void PermissionPopupTest()
	{
		 loginPage = new LoginPage();
		 loginPage.ClickOnRole();
		  System.out.println("in");
		permission.permissionPopup();
		  System.out.println("title==" +title);
		  Assert.assertEquals(title, "Allow Torenzo to access photos, media, and files on your device?");
		  System.out.println("Permission popup is displayed");
		  System.out.println("in1");
			 driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			    driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			    System.out.println("in2");
	}
	
	
}*/
