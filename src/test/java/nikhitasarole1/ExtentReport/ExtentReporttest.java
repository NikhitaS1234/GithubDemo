package nikhitasarole1.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;


public class ExtentReporttest {
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhita");
	}

	@Test
	public void initialDemo()
	{
		extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver","C:/Users/Dell/Java/Chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
        extent.flush();		

		
		
	}

}
