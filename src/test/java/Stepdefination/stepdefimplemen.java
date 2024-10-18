package Stepdefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webapplication.pageobjects.Confirmationpage;
import webapplication.pageobjects.Landingpage;
import webapplication.pageobjects.addresspage;
import webapplication.pageobjects.cartpage;
import webapplication.pageobjects.productpage;

public class stepdefimplemen  extends BaseTest{
public Landingpage landingpage;

public productpage productcatalogue;
public Confirmationpage lastpage;
public cartpage cpage;
 @Given("I landed on Ecommerce page")
 public void I_landed_on_Ecommerce_page() throws IOException
 {
	landingpage= launchapplication();
 }
   
   
@Given("^logged in with username (.+) and password (.+)$")
public void logged_in_username_and_password(String username, String password)
  {
	productcatalogue=landingpage.loginapplication(username,password);
  }


@When("^I add product (.+) to cart$")
public void i_add_product_to_cart(String productName) throws InterruptedException
{
	List<WebElement>products=productcatalogue.getproductlist();
	productcatalogue.addtocart(productName);
}

@When("^Checkout the (.+) and submit the order$")
public void Checkout_submit_the_order(String productName)
{
	cartpage cpage=productcatalogue.cart();
	Boolean match=cpage.verifyingproducts(productName);
	Assert.assertTrue(match);
	addresspage adrspage=cpage.gotocheckout();
        lastpage=adrspage.selectingcountry("India");
}


@Then("{string} message is displayed on confirmation page")
public void message_displayed_confirmation_page(String string)

{
	String Confirmationmessage =lastpage.getmessage();
	Assert.assertTrue(Confirmationmessage.equalsIgnoreCase(string));
       driver.close();
}
@Then("{string} message is displayed")
public void message_is_displayed(String string)
 {
	Assert.assertEquals((string), landingpage.geterrormessage());
	 driver.close();
	 }


}






























