package webapplication.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstctcomp;

public class Confirmationpage extends abstctcomp{


//String Confirmationmessage =driver.findElement(By.cssSelector(".hero-primary")).getText();

	 WebDriver driver ;
	   public Confirmationpage (WebDriver driver)
	   {
	   super(driver);
		   this.driver=driver;
	PageFactory.initElements(driver, this);
	   }


	   @FindBy(css=".hero-primary") 
	    WebElement cnfmsg;
	   
	   public String getmessage()
	   {
		   return cnfmsg.getText();
	   }



















}
