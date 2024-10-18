package webapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstctcomp;

public class ordersdisplay extends abstctcomp {
     WebDriver driver ;
	   public ordersdisplay(WebDriver driver)
	   {
	   super(driver);
		   this.driver=driver;
	PageFactory.initElements(driver, this);
	   }
	   @FindBy(css="tr[class*='ng'] td:nth-child(3)") 
	    List<WebElement> productnames;

	   @FindBy(css="li[class='totalRow'] button") 
	    WebElement checkpage;

	   public Boolean verifyingorderproducts(String productName)
	   {
	   	 Boolean match=productnames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
	     return match;
	   }





}
