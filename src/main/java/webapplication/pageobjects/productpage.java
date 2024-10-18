package webapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractcomponents.abstctcomp;

public class productpage extends abstctcomp {
	WebDriver driver ;
public productpage(WebDriver driver)
{
	 super(driver);
	   this.driver=driver;
	PageFactory.initElements(driver, this);
	   }
 @FindBy(css=".mb-3") 
    List<WebElement> products;
//List<WebElement> products = driver.findElements(By.cssSelector( ".mb-3"));
    By productsBy= By.cssSelector(".mb-3");
   By addcart=By.cssSelector("div.card-body button:last-of-type");
 By toastmessage=  By.cssSelector("#toast-container");
By spinner= By.cssSelector(".ng-animating");
 public List<WebElement> getproductlist()
 {
	  waitforvisibility(productsBy);
	 return products;
	 }
    public WebElement originalproduct(String productName)
{
      WebElement prod=products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
     return prod;
     }
public void addtocart(String productName)
{
     WebElement prod= originalproduct(productName);
	prod.findElement(addcart).click();
     waitforvisibility(toastmessage);
     waitforinvisibility(spinner) ;    
}
















}
