package Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import webapplication.pageobjects.Landingpage;

public class BaseTest {
public WebDriver driver;
public Landingpage landingpage;
 public WebDriver initializeDriver() throws IOException
 {
	Properties prop=new Properties();
	//FileInputStream fis=new FileInputStream("C:\\Users\\nikhi\\eclipse-workspace\\webapplication\\src\\main\\java\\resources\\Globaldata.properties");
	
	//convert the long path as same  belowone just cut it and write
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Globaldata.properties");
	 prop.load(fis);
String browsername=	System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
	// String browsername= prop.getProperty("browser");
	 
	// if (browsername.equalsIgnoreCase("chrome"))
        if (browsername.contains("chrome"))
	 {
	 	ChromeOptions options=new ChromeOptions();
		 System.setProperty("WebDriver.chrome.driver", "C:\\Users\\nikhi\\Downloads\\chromedriver-win64.exe");	
		if(browsername.contains("headless"))
		{
			options.addArguments("headless");
		}
		 driver =new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,900));//fullscreen
		
		 }
	 else if(browsername.equalsIgnoreCase("firefox"))
	 {
		 System.setProperty("WebDriver.gecko.driver", "C:\\Users\\nikhi\\Downloads\\geckodriver-v0.35.0-win64.exe");	
		  driver =new FirefoxDriver();
	 }
	 else if(browsername.equalsIgnoreCase("Edgedriver"))
	 {
		 System.setProperty("WebDriver.chrome.driver", "give EdgeDriverpath.exe");	
		  driver =new EdgeDriver();
		 }
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	 return driver;
 }
 
 public List<HashMap<String, String>> getjsondatatomap(String filepath) throws IOException 
 {
//convert json to string
	String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\purchaseorder.json"),
			StandardCharsets.UTF_8);
 
 //convert string to hashmap dependency-Jackson Databind
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){
	});
 
         return data;
 
 }

 
 
	@BeforeMethod (alwaysRun =true)
	public Landingpage launchapplication() throws IOException
	{
		driver=initializeDriver();
		landingpage=new Landingpage (driver);
		landingpage.site();
		return landingpage;
	}
	
 
 @AfterMethod
 public void teardown()
 {
		driver.close();

 }
 
 
 
 public String getscreenshot(String testcaseName,WebDriver driver) throws IOException
 {
	  TakesScreenshot ts = (TakesScreenshot)driver;
 File source= ts.getScreenshotAs(OutputType.FILE);
 File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+"png");
 FileUtils.copyFile(source, file);
 return System.getProperty("user.dir")+"//reports//"+testcaseName+"png";
 
 
  }





 
 
 
 
 
 
 
 
 
 }
























