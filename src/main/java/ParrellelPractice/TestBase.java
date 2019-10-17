package ParrellelPractice;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase implements Runnable {
	AppiumDriver<WebElement> driver;

	String port;
    String udid;
   
    public TestBase(String portNumber, String udid) {
        port = portNumber;
        udid = udid;
    }
	
	public void launch() throws InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		   
		//Set the capabilities
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", "E:\\VisaProject\\test142.apk");
		capabilities.setCapability("appPackage", "com.torenzo.torenzocafe");
		capabilities.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
		   
		//Launch the app using the appium port number that you provided in the Appium server
		 try {
	            driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
	            Thread.sleep(10000);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	

	}

	public static void main(String args[]){
		Runnable r1 = new TestBase("5000", "52007374ea85154f"); //device id of first mobile device
        Runnable r2 = new TestBase("4723", "ZY3227V4V6"); //device id of second mobile device
        new Thread(r1).start();
        new Thread(r2).start();

	}
	
	public void run() {
		try {
			launch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
