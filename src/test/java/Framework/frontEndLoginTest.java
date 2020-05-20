package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.frontendLoginPage;
import resources.Base;

public class frontEndLoginTest extends Base {
public WebDriver driver;

@BeforeMethod
public void InIt() throws IOException {
	driver=initializeDriver();
	driver.get(prop.getProperty("frontendUrl"));
}
	
@Test(dataProvider="FrontLoginData")
	public void frontEndLogin(String userName, String Password) throws IOException {		
		
		frontendLoginPage frontendLogin=new frontendLoginPage(driver);
		frontendLogin.getSignIn().click();
		frontendLogin.getUserName().sendKeys(userName);
		test.pass("Entered Frontend username: "+userName);
		frontendLogin.getPassword().sendKeys(Password);		
		test.pass("Entered Frontend password: "+Password);
		frontendLogin.getSignInButton().click();
		test.pass("Clicked on Fronend SignIn button");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] FrontLoginData() {
		Object[][] data=new Object[1][2];
		data[0][0]="mahesh.dindigala@jivainfotech.com";
		data[0][1]="I95devteam";
		return data;
	}


}
