package com.torenzo.qa.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.torenzo.qa.base.TestBase;

public class PermissionPage{

static AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Allow']")
	public WebElement openExistStoreButton;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement permissionAllowButton;
	
	

	
	
	
	
	
	
	
	
	
	
	
}