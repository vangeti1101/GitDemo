package webapplication.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstctcomp;

public class Landingpage extends abstctcomp {

	

     WebDriver driver ;
   public Landingpage(WebDriver driver)
   {
   super(driver);
	   this.driver=driver;
PageFactory.initElements(driver, this);
   }

  @FindBy(id="userEmail")
  WebElement Email;
   
  @FindBy(id="userPassword")
  WebElement password;
  
   @FindBy(id="login")
  WebElement button;
   
   @FindBy(css="[class*='flyInOut']")
   WebElement errormessage;
   
    public productpage loginapplication(String email,String pw)
    {
    	Email.sendKeys(email);
    	password.sendKeys(pw);
    	button.click();
    	productpage productcatalogue=new productpage(driver);
    	return productcatalogue;
    }
    public String geterrormessage()
    {
    	waitforWebElementvisibility(errormessage);
    	return errormessage.getText();
    }

    public void site()
    {
    	driver.get("https://rahulshettyacademy.com/client/");
    }







}
