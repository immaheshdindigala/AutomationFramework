package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	
	public static ExtentReports extent=ExtentReporterNG.getReportObject();
	public static ExtentTest test;
	public ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		    driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			//initialize driver here
			
		}else if(browserName.equals("IE")) {
			
			//initialize driver here
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	 FileUtils.copyFile(source, new File(destinationFile));
	 return destinationFile;
	}
	

}
