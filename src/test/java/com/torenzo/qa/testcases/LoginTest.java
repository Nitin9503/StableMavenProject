package com.torenzo.qa.testcases;

import static com.ghana.app.qa.util.TestUtil.prop;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ghana.app.qa.util.TestUtil;

public class LoginTest {

	public static WebDriver driver;
@BeforeMethod
public void setup(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/gmail/"); 
}
@Test(priority=1)
public void ValidDataTest(){
	
}

@Test(priority=1)
public void InvalidDataTest(){
	
}
@AfterMethod
public void TearDown(){
	
}
	
	
}
