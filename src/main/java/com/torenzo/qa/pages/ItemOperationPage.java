package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

public class ItemOperationPage extends TestBase{

	 public ItemOperationPage(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Options for Item']")
		public WebElement optionsForItem;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/quantity")
		public WebElement quantity;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/modifier")
		public WebElement modifier;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/discount")
		public WebElement discount;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/reorder")
		public WebElement reorder;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/delete")
		public WebElement delete;
	 
	 @AndroidFindBy(id="android:id/alertTitle")
		public WebElement confirmationDeletGuest ;
	 
	 @AndroidFindBy(id="android:id/button2")
		public WebElement oKConfirmation ;
	 
	 @AndroidFindBy(id="android:id/button1")
		public WebElement cancelConfirmation ;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/modifier_type_price")
		public static  List<WebElement> modifierPrice ;
	 //Quantity window
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Quantity']")
		public WebElement quntityTitle ;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/cancel_add_item")
		public WebElement cancel ;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/add_guest_done")
		public WebElement doneQuantity ;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/edit_number_item")
		public WebElement editNumber ;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/add_guest_delete")
		public WebElement deleteQuantity;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_one")
		public WebElement addOneGuestClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_two")
		public WebElement addTwoGuestClick;

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_zero")
		public WebElement addZeroGuestClick;
	 
	 @AndroidFindBy(id ="android:id/message")
		public WebElement alertMessage;
	 //Modifir=er window
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_modifier_dialog")
		public WebElement cancelModifierDialog;
	 
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Apply Modifiers']")
		public WebElement applyModifiers;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/continue_reguler_modifier_btn")
		public WebElement continueRegulerModifierBtn;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_item_modifier")
		public WebElement doneItemModifier;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/custom_modifier_add")
		public WebElement customModifierAdd;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/custom_modifier_count")
		public WebElement customModifierCount;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_custom_modifier_btn")
		public WebElement addCustomModifierBtn;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/modifier_charges")
		public List<WebElement> modifierCharges;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/modifier_type")
		public List<WebElement> modifierType;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/delete_modifier")
		public WebElement deleteModifier;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/edit_modifier")
		public WebElement editModifier;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/save_modifier")
		public WebElement saveModifier;
	
	 //discout window
	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Item Discount']")
		public WebElement itemDiscount;

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_discount")
		public WebElement doneDiscount;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/reason")
		public WebElement reason;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/amount")
		public WebElement amount;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/amount_flag")
		public WebElement amountFlag;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/percent_flag")
		public WebElement percentFlag;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/apply")
		public WebElement apply;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/name")
		public List<WebElement> name;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/value")
		public List<WebElement> value;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/edit_discount")
		public WebElement editDiscount;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/delete_discount")
		public WebElement deleteDiscount;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/save_discount")
		public WebElement saveDiscount;
	 
	 public String getTextModifierPrices(int i){
		 return modifierPrice.get(i).getText().substring(1).trim();
	
		 }	 
	 
	 public String getTextModifierCharges(int i, String s){
			String str = modifierCharges.get(i).getText().trim();
			return str.replaceAll(str, s);
		 }
	 
	 public String getTextModifierCharges(int i){
		System.out.println("modifierCharges==>" +modifierCharges.size());
			return modifierCharges.get(i).getText().trim();
		
		 }
	  
	 public String getTextModifierType(int i){
			return  modifierType.get(i).getText().trim();
		 }
	
	 
	 public void passkModifierCharges(int i , String str){
		 modifierCharges.get(i).clear();
			modifierCharges.get(i).sendKeys(str);		
		 }
	 
	 public void passModifierType(int i , String str){
		   modifierType.get(i).clear();
			  modifierType.get(i).sendKeys(str);
		 }
	 
	 public WebElement ModifierCharges(int i){
		 System.out.println("modifierCharges==>" +modifierCharges.size());
			return  modifierCharges.get(i);
		 }
	 
	 public WebElement ModifierType(int i){
		 System.out.println("modifierType==>" +modifierType.size());
			return modifierType.get(i);
		 }
	 
	 public String getTextApplyModifiers(){
			return  applyModifiers.getText();
		 }
	 
	 public String getTextOptionForItem(){
		return  optionsForItem.getText();
	 }
	 
	 public String getAlertMessage(){
			return  alertMessage.getText();
		 }
	 
	 
	 public String confirmationDeletGuest(){		
		 return confirmationDeletGuest.getText();  
	}
	 
	 public String quntityTitle(){		
		 return quntityTitle.getText();  
	}
	 
	 public String editNumberText(){		
		 return editNumber.getText();  
	}
	 
	 
	 public void quntityAdd(double d){
		 double qua = d + 1;
		 String quantity = String.valueOf(qua);
		 editNumber.sendKeys(quantity);	 
	 }
	//discount.
	 
	 public WebElement reasonFromBelow(int i){
		 return name.get(i);
	 }
	
	 public WebElement discountFromBelow(int i){
		return value.get(i);
		 }
 
	 public String getTextReasonFromBelow(int i){
		 return name.get(i).getText();
	 }
	 
	 public void discountFromBelow(int i, String str){
		 value.get(i).clear();	
		  value.get(i).sendKeys(str);;
			 }
	 
		 public void reasonFromBelow(int i , String str){
			 name.get(i).clear();	
			 name.get(i).sendKeys(str);;
		 }
		 
	
	 public String getTextDiscountFromBelow(int i , String s){
		String str = value.get(i).getText().trim();
		return str.replaceAll(str, s);
		 }
	 
	 public String getTextDiscountFromBelow(int i){
	//	 System.out.println("value.get(i).getText().trim();=>" +value.get(i).getText().trim());
			return value.get(i).getText().trim();
		
			 }
 
	 public void passReason(String str){
		 reason.sendKeys(str);
	 }
	 
	 public void passAmount(String str){
		 amount.sendKeys(str);
	 }
	 
	 public WebElement elementName(int i){
		 return name.get(i);
	 }
	 
	 public WebElement elementValue(int i){
		 return value.get(i);
	 }
	 
	public String getTextItemDiscount(){
		return itemDiscount.getText();
	}
	 
	 
 
	 
	 
}
