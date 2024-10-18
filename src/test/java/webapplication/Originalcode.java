package webapplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Originalcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName= "ZARA COAT 3";
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\nikhi\\Downloads\\chromedriver-win64.exe");	
			WebDriver driver =new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/client/");
			
			driver.findElement(By.id("userEmail")).sendKeys("Deekshav11@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Deeksha11@");
			driver.findElement(By.id("login")).click();
			WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			List<WebElement> products = driver.findElements(By.cssSelector( ".mb-3"));
			WebElement prod=products.stream().filter(product->
			
		        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cartproducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(match);
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();

		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("indi");
		driver.findElement(By.cssSelector("section[class*='ta-results'] button:last-of-type")).click();
		driver.findElement(By.cssSelector("a[class*='btnn']")).click();

		String Confirmationmessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();



			



	}

}
