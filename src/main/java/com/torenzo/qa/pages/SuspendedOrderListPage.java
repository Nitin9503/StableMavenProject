package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.torenzo.qa.base.TestBase;
import  static com.torenzo.qa.pomtest.SuspendedOrderListTest.*;

public class SuspendedOrderListPage extends TestBase {

	public ArrayList<String> arr;
	public ArrayList<String> arr1;
    public boolean flags;
    public static String id;

	public SuspendedOrderListPage(AndroidDriver<AndroidElement> driver)
			throws IOException {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/order_list_layout")
	public WebElement orderlistClick;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/cancel_order_list")
	public WebElement orderlistCancelButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Orders']")
	public WebElement orderlistTextTitle;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/search_order_byid")
	public WebElement searchBox;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/cancel_search")
	public WebElement orderlistSearchCancel;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/sort_id_suspended_order")
	WebElement sort_Id_Click;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_no")
	public WebElement order_list;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_no")
	public List<WebElement> order_List;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/sort_cost_suspended_order")
	public WebElement sort_cost_Click;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_total")
	public WebElement cost_list;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_total")
	public List<WebElement> cost_List;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_date")
	public List<WebElement> Date_List;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/ordered_item_name")
	public List<WebElement> Item_List;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/suspended_order_date")
	public List<WebElement> Item_Price_List;

	public void supendedlistClick() {
		orderlistClick.click();

	}

	public String OrderListTitle() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return orderlistTextTitle.getText();

	}

	public void supendedlistCancel() {
		orderlistCancelButton.click();

	}

	public void supendedlistSearch(String orderNo) {
		searchBox.sendKeys(orderNo);

	}

	public void supendedSearchCancel() {
		orderlistSearchCancel.click();

	}

	public void orderlistsortByDeceCost() {
		sort_cost_Click.click();
		int cost_count_Before = cost_List.size();
		System.out.println(cost_count_Before);
		int flag = 0;
		for (WebElement costAfter : cost_List) {
			String cost1 = costAfter.getText().substring(1);
			System.out.println("cost1====>"
					+ cost_List.get(0).getText().substring(1));
			if (Float.parseFloat(cost_List.get(0).getText().substring(1)) < Float
					.parseFloat(cost1)) {
				flag = 1;
				break;
			}

		}

		if (flag == 1) {
			flags = false;
			System.out.println("cost1====>" + false);
		} else {
			flags = true;
			System.out.println("cost1====>" + true);
		}

	}

	public void orderlistsortByAsceCost() {
		sort_cost_Click.click();
		int cost_count_Before = cost_List.size();
		System.out.println(cost_count_Before);
		int flag = 0;
		for (WebElement costAfter : cost_List) {
			String cost1 = costAfter.getText().substring(1);
			System.out.println("cost1====>"
					+ cost_List.get(0).getText().substring(1));
			arr = new ArrayList<String>();
			arr.add(cost1);

			if (Float.parseFloat(cost_List.get(0).getText().substring(1)) > Float
					.parseFloat(cost1)) {
				flag = 1;
				break;
			}

		}

		if (flag == 1) {
			flags = false;
			System.out.println("cost1====>" + false);
		} else {
			flags = true;
			System.out.println("cost1====>" + true);
		}

	}

	public void orderlistsortByDecOrderNo() {
		int flag = 0;
		sort_Id_Click.click();
		int Order_count = order_List.size();
		System.out.println(Order_count);
		int OrderNolist = order_List.size();
		System.out.println(OrderNolist);
		for (WebElement OrderId : order_List) {
			System.out.println(OrderId.getText());
			if (Integer.parseInt(order_List.get(0).getText().substring(2)) < Integer
					.parseInt(OrderId.getText().substring(2))) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			flags = false;
			System.out.println(flags);

		} else {
			flags = true;
			System.out.println(flags);
		}

	}

	public void orderlistsortByAsceOrderNo() {
		int flag = 0;
		sort_Id_Click.click();
		int Order_count = order_List.size();
		System.out.println(Order_count);
		int OrderNolist = order_List.size();
		System.out.println(OrderNolist);
		for (WebElement OrderId : order_List) {
			System.out.println(OrderId.getText());
			if (Integer.parseInt(order_List.get(0).getText().substring(2)) > Integer
					.parseInt(OrderId.getText().substring(2))) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			flags = false;
			System.out.println(flags);

		} else {
			flags = true;
			System.out.println(flags);
		}

	}

	public static String currentDate(String dateFormate) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormate);
		Date date = new Date();
		// System.out.println(dateFormat.format(date));
		return dateFormat.format(date);

	}

	public void getDateNo() throws InterruptedException {

		for (WebElement date_List : Date_List) {

			System.out.println("  " + date_List.getText().substring(0, 11));
			if (SuspendedOrderListPage.currentDate("dd-MMM-yyyy").equalsIgnoreCase(
					date_List.getText().substring(0, 11))) {

				Thread.sleep(2000);
				System.out.println("compare date matched");
				date_List.click();
				break;
			}
		}
	}
	public ArrayList<String> getItemDataFromDB(String OrderNo, String Currentdate){
		ArrayList<String> str = new ArrayList<String>();
		try{
			System.out.println("fetching data from database like -- Order -- table After payment");
			/*System.out.println("ID" + "       " + "LastUpdated" + "              " + "Total" + "       " + "Tax"
					+ "         " + "Discount" + "    " + "status" + "          " + "UniqueId" + "       " + "StoreID"
					+ "     " + "EmployeeName");*/
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/finaldb2",
					"root", "root");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM finaldb2.`order` where UniqueId='"+OrderNo+"' and  LastUpdated='"+Currentdate+"'");
			//"select * from finaldb2.order  where UniqueID ='"+OrderNo+"' and  LastUpdated='"+Currentdate+"'");
			while (rs.next()){
				id = rs.getString("ID");
				System.out.println("id inside loop "+id);
		/*		System.out.println(rs.getString("ID") + "    " + rs.getString("LastUpdated") + "      "
						+ rs.getString("Total") + "      " + rs.getString("Tax") + "     " + rs.getString("Discount")
						+ "       " + rs.getString("status") + "       " + rs.getString("UniqueId") + "             "
						+ rs.getString("StoreID") + "         " + rs.getString("EmployeeName"));*/
			
			
			System.out.println("----------------------------------------------------------------------------->");
			System.out.println("fetching data from database like -- OrderEntry -- table After payment");
		/*	System.out.println("OrderID" + "     " + "FullPrice" + "     " + "Price" + "         "
					+ "QuantityOnOrder" + "      " + "SalesTax" + "    " + "Description" + "       "
					+ "CategoryName" + "       " + "DepartmentName" + "     " + "Taxable");*/
			
		System.out.println("order id "+id);
		ResultSet rk = stmt.executeQuery("select * from finaldb2.orderentry where OrderId='"+id+"'");
		while (rk.next()){
			/*System.out.println(rk.getString("OrderID") + "     " + rk.getString("FullPrice") + "       "
					+ rk.getString("Price") + "           " + rk.getString("QuantityOnOrder") + "                "
					+ rk.getString("SalesTax") + "         " + rk.getString("Description") + "          "
					+ rk.getString("CategoryName") + "             " + rk.getString("DepartmentName") + "         "
					+ rk.getString("Taxable"));*/
		str.add(rk.getString("Description"));
		System.out.println(str);
			}con.close();
		}
		System.out.println("Data from dorder entry "+str);	
		}catch (Exception e) {
				System.out.println(e);
			}
			//System.out.println(st);
		return str;
	}

	public ArrayList<String> getItemNameDataFromOrder(){
		System.out.println("No. of Item List -->"+Item_List.size());
		ArrayList<String> st = new ArrayList<String>();
		for(WebElement we :Item_List){
		
			we.getText();
			st.add(we.getText());
		}
	System.out.println(st);
	return st;
	}
	public void getItemPriceFromOrder(){
		System.out.println("No. of Item List -->"+Item_Price_List.size());
		ArrayList<String> stp = new ArrayList<String>();
		for(WebElement we :Item_Price_List){
		
			we.getText();
			stp.add(we.getText());
		}
	System.out.println(stp);
	}
	
	public  boolean compareList(List ls1,List ls2){
        return ls1.toString().contentEquals(ls2.toString())?true:false;
    }
public  void arraycomparision() {

    ArrayList<String> one  = new ArrayList<String>();
    ArrayList<String> two  = new ArrayList<String>();

    one.add("one");
    one.add("two");
    one.add("six");

    two.add("one");
    two.add("six");
    two.add("two");
 /*  System.out.println(two);
   System.out.println(one);*/
  
    System.out.println("items name from order --->"+st1);
    System.out.println("items name from order --->"+this.getItemNameDataFromOrder());
    System.out.println(" item names from order entr--->"+this.getItemDataFromDB(orderNumber, this.currentDate("yyyy-MM-dd")));
   
    
    System.out.println("Output1 of execution before order load  :: "+compareList(st1, this.getItemDataFromDB(orderNumber, this.currentDate("yyyy-MM-dd"))));
     //System.out.println("Output1 of execution after order load :: "+compareList(this.getItemNameDataFromOrder(), this.getItemDataFromDB(orderNumber, this.currentDate("yyyy-MM-dd"))));
}
	
	}
	

