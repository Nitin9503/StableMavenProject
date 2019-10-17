
package com.torenzo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static com.torenzo.qa.util.StaticVariable.OSname;
import com.torenzo.qa.util.TestUtil;

import static com.torenzo.qa.util.TestUtil.IMPLICIT_WAIT_TIME;

import com.qa.ExtentReportsListener.StartAppiumServer;
import com.torenzo.qa.pages.LoginPage;

@Listeners(com.torenzo.qa.listener.Listener.class)
public class Loginapp extends StartAppiumServer {
	// LoginPage loginPage = new LoginPage();
	public static AndroidDriver driver;
	public static Properties obj;
	org.apache.log4j.Logger log = LogManager.getLogger(Loginapp.class);

	public Loginapp() throws IOException {
		OSname = System.getProperty("os.name");
		System.out.println("We are on ==>" + OSname);

		if (OSname.equalsIgnoreCase("Mac OS X")) {
			obj = new Properties();
			// FileInputStream objfile = new
			// FileInputStream("E:\\Appium1\\AppiumMavenProject\\applications.properties");
			FileInputStream objfile = new FileInputStream(
					"/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/src/main/java/com/torenzo/qa/config/application.properties");
			obj.load(objfile);
		} else if (OSname.equalsIgnoreCase("Windows 7")) {
			obj = new Properties();
			// FileInputStream objfile = new
			// FileInputStream("E:\\Appium1\\AppiumMavenProject\\applications.properties");
			FileInputStream objfile = new FileInputStream(
					"E:\\Appium1\\StableMavenProject\\src\\main\\java\\com\\torenzo\\qa\\config\\application.properties");
			obj.load(objfile);
		}

	}

	@BeforeSuite(alwaysRun = true)
	public void launch() throws IOException, InterruptedException

	{
		String driverPath = System.getProperty("user.dir");
		System.out.println("path==>" + driverPath);
		if (OSname.equalsIgnoreCase("Mac OS X")) {
			startServerOnMac();
			Thread.sleep(3000);
		} else if (OSname.equalsIgnoreCase("Windows 7") || OSname.equalsIgnoreCase("Windows 7")) {
			/*Runtime rt = Runtime.getRuntime();
			// String new_dir = "C:\\Users\\nikhil.sonawane\\Desktop";
			String new_dir = "E:\\Appium1\\StableMavenProject\\AppiumBatFile";

			rt.exec("cmd.exe /c cd \"" + new_dir + "\" & start cmd.exe /k \"startappium.bat\"");
			Thread.sleep(10000);*/
		}

		log.info(
				"************************************ Permission popup **********************************************");
		// for mac machine bellow is the command for launch termninal
		// Process p1 = Runtime.getRuntime().exec("/usr/bin/open -a Terminal");
		// navigate to folder and save text file == cd
		// Library/Android/sdk/platform-tools ; adb logcat > Sachin.txt

		// for window machine bellow is the command for launch termninal
		// Process p1 = Runtime.getRuntime().exec("cmd.exe /c start cd
		// \"E:\\AppiumFile\\android-sdk-windows\\platform-tools\" && dir");
		// System.out.println("Launched CMD window");

		log.info("************************************ Launching App**********************************************");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("newCommandTimeout", "30");

		if (OSname.equalsIgnoreCase("Mac OS X")) {
			caps.setCapability("udid", "192.168.56.101:5555");
			System.out.println("Mac Emulator device id");
		} else if (OSname.equalsIgnoreCase("Windows 7")) {
			caps.setCapability("udid", "192.168.208.101:5555");
			System.out.println("Windows Emulator device id");
		}
		
		caps.setCapability("app", "E:\\Appium1\\StableMavenProject\\src\\App\\torenzo39a.apk");
		/*caps.setCapability("appPackage", "com.torenzo.torenzocafe");
		caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");*/
		// caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release
		// 75.apk");
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (Exception e) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void login() throws IOException {
		System.out.println("Hello1");

		try {

			if (driver.findElement(By.xpath(obj.getProperty("TitleLogin"))).isDisplayed()) {
				// driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe");
				// driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
				driver.findElement(By.id(obj.getProperty("Submit"))).click();
				driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
				driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
				System.out.println("on home page");

			}

		} catch (Exception e) {

			driver.findElement(By.xpath(obj.getProperty("Live-User"))).click();
			/*
			 * driver.findElement(By.xpath("Demo-User")).click();
			 * driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys(
			 * "torenzocafe");
			 * driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys(
			 * "1234");
			 */
			driver.findElement(By.id(obj.getProperty("Submit"))).click();
			driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
			driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
			System.out.println("on home page");
		}

	}

	@BeforeClass
	public void permission() throws IOException, InterruptedException {

		try {

			if (driver.findElement(By.xpath(obj.getProperty("PermissionPopup"))).isDisplayed()) {
				System.out.println("Permission popup is displayed");
				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
				String titleHomePage = driver.findElement(By.xpath("//android.widget.TextView[@text='Order']"))
						.getText();
				Assert.assertEquals("Order", titleHomePage, "HomePage not found");

			}
		} catch (Exception e) {

			System.out.println("Permission popup is not displayed");
			// String titleHomePage =
			// driver.findElement(By.xpath("//android.widget.TextView[@text='Order']")).getText();
			// Assert.assertEquals("Order", titleHomePage, "HomePage not
			// found");
		}

	}
	@AfterTest
	public void tearDown(){
		
		stopServerOnMac();
		
	}

}
