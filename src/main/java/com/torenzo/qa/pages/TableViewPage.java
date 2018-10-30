package com.torenzo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TableViewPage extends TestBase {

	 public TableViewPage(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Element inside Admin Settings Page
	
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/table_structure_text")
		public WebElement tableStructureText;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/kitchen_display_system_text")
		public WebElement kitchenKisplaySystemText;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/reload_items")
		public WebElement reloadItems;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/drawer_settings")
		public WebElement drawerSettings;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/credit_card")
		public WebElement creditCard;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/item_images")
		public WebElement itemImages;

		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/reload_tables")
		public WebElement reloadTables;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/tableview_display")
		public WebElement tableviewDisplay;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/back_arrow_layout")
		public WebElement backArrowButton;

		
		public void clickOnTableviewDisplay(){
			tableviewDisplay.click();
		}
		
		public HomePage clickOnbackArrowButton(){
			backArrowButton.click();
			return new HomePage(driver);
		}
		
		public TableStructurePage clickOnreloadTables() throws IOException{
			reloadTables.click();
			return new TableStructurePage(driver);
		}
		
		
		
		
}
