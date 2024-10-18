package webapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstctcomp;

public class addresspage extends abstctcomp {


	 WebDriver driver ;
	   public addresspage (WebDriver driver)
	   {
	   super(driver);
		   this.driver=driver;
	PageFactory.initElements(driver, this);
	   }
	   @FindBy(css="input[placeholder='Select Country']") 
	    WebElement selectedcountry;
	   @FindBy(css="section[class*='ta-results'] button:last-of-type") 
	    WebElement country;
	    @FindBy(css="a[class*='btnn']") 
	    WebElement countryname;

	  // driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("indi");



public Confirmationpage selectingcountry(String cntry) {
	
	selectedcountry.sendKeys("indi");
	country.click();
	countryname.click();
	Confirmationpage lastpage=new Confirmationpage(driver);
	return lastpage;
	


}



//driver.findElement(By.cssSelector("a[class*='btnn']")).click();



//driver.findElement(By.cssSelector("section[class*='ta-results'] button:last-of-type")).click();
//driver.findElement(By.cssSelector("a[class*='btnn']")).click();














}
