package webapplication;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import Testcomponents.BaseTest;
import Testcomponents.Retry;
import webapplication.pageobjects.cartpage;
import webapplication.pageobjects.productpage;


public class ErrorValidations extends BaseTest {

	@Test(groups= {"Errorhandling"},retryAnalyzer=Retry.class)
	public void errors() throws IOException
	{
		landingpage.loginapplication("Deeks11@gmail.com","Dee");
	Assert.assertEquals("Incorrect email or password.", landingpage.geterrormessage());
		}

	
	@Test
	public void productvalidation() throws IOException
	{
		String productName= "ZARA COAT 3";
		 productpage productcatalogue=landingpage.loginapplication("Deekshav121@gmail.com","Deeksha121@");
			List<WebElement>products=productcatalogue.getproductlist();
			productcatalogue.addtocart(productName);
			cartpage cpage=productcatalogue.cart();
			Boolean match=cpage.verifyingproducts("ZARA COAT 33");
			Assert.assertFalse(match);
			

			
	}





















}
