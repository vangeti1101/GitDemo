package webapplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class framework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("WebDriver.chrome.driver", "C:\\Users\\nikhi\\Downloads\\chromedriver-win64.exe");	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client/");
	driver.findElement(By.id("userEmail")).sendKeys("Deekshav11@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Deeksha11@");
	driver.findElement(By.id("login")).click();
	List<WebElement> products=driver.findElements(By.cssSelector( ".mb-3"));
	for(int i=0;i<products.size();i++)
		{
			String product=products.get(i).getText();
		    if(product.contains("ZARA COAT 3"))
		    {
		    driver.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
		    }

		}
	
	

	}}








