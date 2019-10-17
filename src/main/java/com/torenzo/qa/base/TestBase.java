package com.torenzo.qa.base;
import static com.torenzo.qa.util.StaticVariable.OSname;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
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

public class TestBase {
	// Use .bat file to run project
	public static AndroidDriver driver;
	// static IOSDriver driver;
	
	public static Properties obj;
	public static String OSname;

	public TransactionOrderPage transactionOrderPage;
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public GuestPage guestPage;
	public PaymentPage paymentPage;
	public SplitReceiptPage splitReceiptPage;
	public PayingPaymentPage payingPaymentPage;
	public TableStructurePage tableStructurePage;
	public ScrollMethod scrollMethod;
	public AdminSettingPage adminSettingPage;
	public TableViewPage tableViewPage;
	public HomePageTest homePageTest;

	public TestBase() throws IOException {
		OSname = System.getProperty("os.name").substring(0,3);
		System.out.println("We are on ==>" + OSname);

		if (OSname.equalsIgnoreCase("Mac")) {
			obj = new Properties();
			FileInputStream objfile = new FileInputStream(
					"/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/src/main/java/com/torenzo/qa/config/config.properties");
			obj.load(objfile);
		} else if (OSname.equalsIgnoreCase("Win")) {
			obj = new Properties();
			FileInputStream objfile = new FileInputStream(
					"E:\\Appium1\\StableMavenProject\\src\\main\\java\\com\\torenzo\\qa\\config\\config.properties");
			obj.load(objfile);
		}

	}

	@BeforeSuite
	public void startServer() throws InterruptedException, IOException {
		String driverPath = System.getProperty("user.dir");
		System.out.println("path==>" + driverPath);
		if (OSname.equalsIgnoreCase("Mac")) {
			System.out.println("We are on Mac OS,, Please start Appium server manually");
			Thread.sleep(1000);
		} else if (OSname.equalsIgnoreCase("Win")) {
			Runtime rt = Runtime.getRuntime();
			// String new_dir = "C:\\Users\\nikhil.sonawane\\Desktop";
			String new_dir = "E:\\Appium1\\StableMavenProject\\AppiumBatFile";
			rt.exec("cmd.exe /c cd \"" + new_dir + "\" & start cmd.exe /k \"startappium.bat\"");
			Thread.sleep(10000);
		}

	}

	public static void initilization() throws MalformedURLException, InterruptedException {
		/*
		 * String deviceName = prop.getProperty("device");
		 * if(deviceName.equalsIgnoreCase("andriod"))
		 */

		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Honor");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.0");
			caps.setCapability("fullReset", true);
			caps.setCapability("newCommandTimeout", "60");
			if (OSname.equalsIgnoreCase("Mac OS X")) {
				caps.setCapability("udid", "192.168.56.101:5555");
				System.out.println("Mac Emulator device id");
			} else if (OSname.equalsIgnoreCase("Win")) {
				caps.setCapability("udid", "192.168.208.101:5555");
				System.out.println("Windows Emulator device id");
			}
			if (OSname.equalsIgnoreCase("Mac")) {
				caps.setCapability("app", "/Users/rahul.kardel/Downloads/142torenzo.apk");
				System.out.println("Mac Emulator device id");
			} else if (OSname.equalsIgnoreCase("Win")) {

				System.out.println("Windows Emulator device id");
			}

			caps.setCapability("appPackage", "com.torenzo.torenzocafe");
			caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
			// caps.setCapability("app",
			// "/Users/rahul.kardel/Downloads/app-release 75.apk");
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			} catch (Exception e) {
				driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("Exception");

		}
		System.out.println("App about to launch");

	}
	
	@BeforeClass
    public void setUp() throws IOException, InterruptedException
    {
		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		splitReceiptPage = new SplitReceiptPage(driver);
		payingPaymentPage = new PayingPaymentPage(driver);
		tableStructurePage = new TableStructurePage(driver);
		scrollMethod = new ScrollMethod();
		adminSettingPage = new AdminSettingPage(driver);
		tableViewPage = new TableViewPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		homePageTest = new HomePageTest();
		
    }
	
	@AfterClass
	public void tearDown(){
		
		driver.quit();
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
