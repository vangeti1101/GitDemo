package abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webapplication.pageobjects.cartpage;
import webapplication.pageobjects.ordersdisplay;

public class abstctcomp {
  WebDriver driver;
	public abstctcomp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css ="button[routerlink*='cart']")
	WebElement cartbutton;

	@FindBy (css ="button[routerlink*='myorders']")
	WebElement orders;
	
	
	
	
	
	
	
	public void waitforvisibility(By FindBy)
{
	  WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
} 
public void waitforinvisibility(By FindBy)
{
	
	WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

public void waitforWebElementvisibility(WebElement FindBy)
{
	  WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(FindBy));
} 




public cartpage cart()
{
         cartbutton.click();
			cartpage cpage=new cartpage(driver);
return cpage;
  }
public ordersdisplay orderbutton()
{
         orders.click();
			ordersdisplay odr=new ordersdisplay(driver);
return odr;
  }
    
//driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();




}
