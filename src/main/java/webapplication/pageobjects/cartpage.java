package webapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstctcomp;

public class cartpage extends abstctcomp {
   WebDriver driver ;
	   public cartpage (WebDriver driver)
	   {
	   super(driver);
		   this.driver=driver;
	PageFactory.initElements(driver, this);
	   }

	   @FindBy(css="div[class='cartSection'] h3") 
	    List<WebElement> cartproducts;

	   @FindBy(css="li[class='totalRow'] button") 
	    WebElement checkpage;

	  // List<WebElement> cartproducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));

public Boolean verifyingproducts(String productName)
{
	 Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
  return match;
}

public addresspage gotocheckout()
{
	 checkpage.click();
	 addresspage adrspage=new addresspage(driver);
	 return adrspage;
}

//driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();












}
