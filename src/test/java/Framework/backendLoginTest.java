package Framework;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.backendLoginPage;
import resources.Base;

public class backendLoginTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void InIt() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("backendUrl"));
	}
	
	@Test(dataProvider="LoginData")
	public void backendLogin(String userName, String Password) throws IOException {		
		
		backendLoginPage backendLogin=new backendLoginPage(driver);	
		Assert.assertTrue(backendLogin.getUserName().isDisplayed());
//		Assert.assertFalse(backendLogin.getUserName().isDisplayed());
		
		backendLogin.getUserName().sendKeys(userName);
		backendLogin.getPassword().sendKeys(Password);		
		backendLogin.getLogin().click();	
		
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
