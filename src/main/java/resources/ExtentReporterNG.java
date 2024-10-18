package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
  public static ExtentReports getReportObject()
{
	//ExtentReports, ExtentSparkReporter
			//first we should create the class
	String path =System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
reporter.config(). setReportName("Web Automation Results" );
reporter.config().setDocumentTitle("Test Results");
//now create Extent Reportsobject

         ExtentReports extent=new ExtentReports();
         extent.attachReporter(reporter);
         extent.setSystemInfo("Tester", "Deeksha");
           return extent;

	
}
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

