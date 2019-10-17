package ParrellelPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestClass extends TestBase {

	public TestClass(String portNumber, String udid) {
		super(portNumber, udid);
	
	}

	@Test
	public void login(){

		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Open Existing Restaurant/Store (Live Users)']")).click();
		 driver.findElement(By.id("access_name")).sendKeys("torenzocafe");
		  driver.findElement(By.id("access_code")).sendKeys("1234");
		  driver.findElement(By.id("submit_login")).click();
	}

}
