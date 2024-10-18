package webapplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import webapplication.pageobjects.Confirmationpage;
import webapplication.pageobjects.Landingpage;
import webapplication.pageobjects.addresspage;
import webapplication.pageobjects.cartpage;
import webapplication.pageobjects.productpage;

public class optimisedcode  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		String productName= "ZARA COAT 3";
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\nikhi\\Downloads\\chromedriver-win64.exe");	
			WebDriver driver =new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			Landingpage landingpage=new Landingpage (driver);
			landingpage.site();
			landingpage.loginapplication("Deekshav11@gmail.com","Deeksha11@");
			productpage productcatalogue=new productpage(driver);
			List<WebElement>products=productcatalogue.getproductlist();
			productcatalogue.addtocart(productName);
			productcatalogue.cart();
			cartpage cpage=new cartpage(driver);
			Boolean match=cpage.verifyingproducts(productName);
			Assert.assertTrue(match);
			cpage.gotocheckout();
			addresspage adrspage=new addresspage(driver);
			adrspage.selectingcountry("India");
			Confirmationpage lastpage=new Confirmationpage(driver);
			lastpage.getmessage();
	
	
	
		//Assert.assertTrue(Confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
