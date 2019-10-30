package com.torenzo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.myjeeva.poi.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.pages.TableViewPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.testcases.HomePageTest;
import com.torenzo.qa.util.ScrollMethod;
import com.torenzo.qa.util.TestUtil;

import freemarker.template.utility.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	// Use .bat file to run project
	// static IOSDriver driver;
	public  AndroidDriver driver;
	DesiredCapabilities caps;
	
	public  AppiumDriverLocalService server;
	public  XSSFWorkbook workbook;
	
	public   File src;	
	public  Properties obj;
	public String OSname;

	public TestBase() throws IOException {
		OSname = System.getProperty("os.name").substring(0,3);
		System.out.println("We are on ==>" + OSname);
		
		if (OSname.equalsIgnoreCase("Win")) {
			 src = new File(
					".\\src\\main\\java\\com\\TestData\\TorenzoTestData.xlsx");
			 
		} else if (OSname.equalsIgnoreCase("Mac")) {
			 src = new File(
					"./src/main/java/com/TestData/TorenzoTestData.xlsx");		
		}
		
		FileInputStream fis1 = new FileInputStream(src);
		 workbook = new XSSFWorkbook(fis1);
	

		if (OSname.equalsIgnoreCase("Mac")) {
			obj = new Properties();
			FileInputStream objfile = new FileInputStream(
					"./src/main/java/com/torenzo/qa/config/config.properties");
			obj.load(objfile);
			src = new File("./src/App/"+obj.getProperty("appName")+".apk");
		} else if (OSname.equalsIgnoreCase("Win")) {
			obj = new Properties();
			FileInputStream objfile = new FileInputStream(
					".\\src\\main\\java\\com\\torenzo\\qa\\config\\config.properties");
			obj.load(objfile);
			src = new File(".\\src\\App\\"+obj.getProperty("appName")+".apk");
		}

	}
	
	public  AppiumDriverLocalService startAppiumServer() {
		boolean flag = checkIfServerIsRunnning(4723);
		if(flag){
			System.out.println("Port is alerdy runnning");
		}
		else{
			server = AppiumDriverLocalService.buildDefaultService();
			server.start();		
		}
		return server;
		}
	
	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{

		Process proc = Runtime.getRuntime().exec("E:\\VisaProject\\StableMavenProject\\src\\main\\java\\resources\\startEmulator.bat");
		proc.waitFor();
		Thread.sleep(6000);

	}
	
	public void initilization() throws MalformedURLException, InterruptedException {
			
		 server= startAppiumServer();
		 
		try {
			 caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Honor");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.0");
		//	caps.setCapability("fullReset", true);
			caps.setCapability("newCommandTimeout", "80");
			if (OSname.equalsIgnoreCase("Mac OS X")) {
				caps.setCapability("udid", obj.getProperty("device"));
				System.out.println("Mac Emulator device id");
			} else if (OSname.equalsIgnoreCase("Win")) {
				caps.setCapability("udid", obj.getProperty("device"));
				System.out.println("Windows Emulator device id");
			}
			caps.setCapability("app", src.getAbsolutePath());
			System.out.println("Path");
		/*	caps.setCapability("appPackage", "com.torenzo.torenzocafe");
			caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
		   caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");*/
	        System.out.println(driver);
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		        System.out.println("try    "+driver);
			} catch (Exception e) {
				driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				   System.out.println("catch    "+driver);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

			System.out.println("Exception");
		
		}
		System.out.println("App about to launch");
	}
	

}





















/*
 * else if (deviceName.equalsIgnoreCase("iOS")) { DesiredCapabilities
 * capabilities = new DesiredCapabilities();
 * 
 * capabilities.setCapability("deviceName", "iPad 2");
 * capabilities.setCapability("platformName", "iOS");
 * capabilities.setCapability("platformVersion", "9.3");
 * capabilities.setCapability("udid",
 * "95bb78de2a63886aaa9542d51740dbda53ffc7ca");
 * capabilities.setCapability("app", "/Users/rahul.kardel/Desktop/Torenzo.app");
 * driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
 * capabilities);
 * 
 * capabilities.setCapability("app", "/Users/rahul.kardel/Desktop/Torenzo.app");
 * Driver= new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
 * capabilities); Driver.manage().timeouts().implicitlyWait(60,
 * TimeUnit.SECONDS); }
 * 
 * //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
 * TimeUnit.SECONDS);
 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME,
 * TimeUnit.SECONDS);
 */

/*
 * 
 * 
 * @BeforeTest(alwaysRun=true) public void login() throws IOException {
 * 
 * 
 * System.out.println("Value of Live user" +prop.getProperty("Live-User")); try{
 * 
 * 
 * if(driver.findElement(By.xpath(prop.getProperty("TitleLogin"))).isDisplayed()
 * ) { //driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys(
 * "torenzocafe"); //
 * driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
 * driver.findElement(By.id(prop.getProperty("Submit"))).click();
 * driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
 * 
 * driver.findElement(By.id(prop.getProperty("RoleName"))).click();
 * System.out.println("on home page"); driver.unlockDevice(); }
 * 
 * 
 * }catch(Exception e) {
 * 
 * driver.findElement(By.xpath(prop.getProperty("Live-User"))).click();
 * //driver.findElement(By.xpath("Demo-User")).click(); //
 * driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe"
 * ); //
 * driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
 * driver.findElement(By.id(prop.getProperty("Submit"))).click();
 * driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
 * driver.findElement(By.id(prop.getProperty("RoleName"))).click();
 * System.out.println("on home page"); }
 * 
 * }
 * 
 * 
 * 
 * @BeforeClass public void permission() throws IOException {
 * 
 * try{
 * 
 * if (driver.findElement(By.xpath(prop.getProperty("PermissionPopup"))).
 * isDisplayed()) { System.out.println("Permission popup is displayed");
 * driver.findElement(By.id(
 * "com.android.packageinstaller:id/permission_allow_button")).click();
 * driver.findElement(By.id(
 * "com.android.packageinstaller:id/permission_allow_button")).click();
 * 
 * } }catch (Exception e) {
 * 
 * System.out.println("Permission popup is not displayed"); } }
 */
