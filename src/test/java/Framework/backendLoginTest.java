package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.backendLoginPage;
import resources.Base;
import resources.ExtentReporterNG;

public class backendLoginTest extends Base {
	public WebDriver driver;
	//public static Logger Log=LogManager.getLogger(Base.class.getName());
	
	
	@BeforeMethod
	public void InIt() throws IOException {
		driver=initializeDriver();
		//test.info("driver initialized");
		//Log.info("Driver initialized");
		driver.get(prop.getProperty("backendUrl"));
		//test.info("Launched "+prop.getProperty("backendUrl"));
	}
	
	@Test(dataProvider="LoginData")
	public void backendLogin(String userName, String Password) throws IOException {		
		
		backendLoginPage backendLogin=new backendLoginPage(driver);	
		backendLogin.getUserName().sendKeys(userName);
		test.pass("Entered user name : "+userName);
		backendLogin.getPassword().sendKeys(Password);	
		test.pass("Entered password : "+Password);
		//Assert.assertFalse(backendLogin.getLogin().isDisplayed());
		backendLogin.getLogin().click();	
		test.pass("Clicked on Backend login button ");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] LoginData() {
		Object[][] data=new Object[1][2];
		data[0][0]="admin";
		data[0][1]="i95devteam";
		
		//Test to run second time
		//data[1][0]="admin";
		//data[1][1]="i95devteam";
		return data;
	}

}
