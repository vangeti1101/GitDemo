package webapplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testcomponents.BaseTest;
import webapplication.pageobjects.Confirmationpage;
import webapplication.pageobjects.addresspage;
import webapplication.pageobjects.cartpage;
import webapplication.pageobjects.ordersdisplay;
import webapplication.pageobjects.productpage;

public class moreoptimisedway extends BaseTest {
	String productName= "ZARA COAT 3";
	@Test(dataProvider="getdata",groups= {"purchase"})
	//we use if there are 2 parameters
	//public void optimiseway(String email,String password,String productName) throws IOException
	public void optimiseway(HashMap<String,String>input) throws IOException
	{
	
		 productpage productcatalogue=landingpage.loginapplication(input.get("email"),input.get("password"));
			List<WebElement>products=productcatalogue.getproductlist();
			//productcatalogue.addtocart(productName);
			productcatalogue.addtocart(input.get("product"));
			cartpage cpage=productcatalogue.cart();
			Boolean match=cpage.verifyingproducts(input.get("product"));
			Assert.assertTrue(match);
			addresspage adrspage=cpage.gotocheckout();
			Confirmationpage lastpage=adrspage.selectingcountry("India");
			String Confirmationmessage =lastpage.getmessage();
			Assert.assertTrue(Confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
			
			}
	
@Test(dependsOnMethods= {"optimiseway"})
		public void orderhistory()
		{
			 productpage productcatalogue=landingpage.loginapplication("Deekshav11@gmail.com","Deeksha11@");
		
			 ordersdisplay odr= productcatalogue.orderbutton();
			Assert.assertTrue(odr.verifyingorderproducts(productName));
		}


  




		@DataProvider
		public  Object[][] getdata() throws IOException
			{
		
			List<HashMap<String,String>>data= getjsondatatomap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\purchaseorder.json");
			return new Object[][]	{  {data.get(0)}, {data.get(1)} };        	
			}
			
		
		
		
		
		
		
		
		
		
		
		//	if there are 2 parameters we use likethis 
		//return new Object[][]	{  {"Deekshav11@gmail.com","Deeksha11@","ZARA COAT 3"}, {"Deekshav121@gmail.com","Deeksha121@","ADIDAS ORIGINAL"}   };
		
			
//		HashMap<String,String> map=new HashMap<String,String> ();
			//	map.put("email", "Deekshav11@gmail.com");
			//	map.put("password", "Deeksha11@");
				//map.put("product", "ZARA COAT 3");
				
				//HashMap<String,String> map1=new HashMap<String,String> ();
				//map1.put("email", "Deekshav121@gmail.com");
			//	map1.put("password","Deeksha121@");
				//map1.put("product", "ADIDAS ORIGINAL");
				//if there are more parameters we use like this 













}




























			
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


