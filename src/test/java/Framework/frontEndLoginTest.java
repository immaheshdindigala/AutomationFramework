package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	
	@Test
	public void frontEndLogin() throws IOException {		
		
		frontendLoginPage frontendLogin=new frontendLoginPage(driver);
		frontendLogin.getSignIn().click();
		frontendLogin.getUserName().sendKeys("mahesh.dindigala@jivainfotech.com");
		frontendLogin.getPassword().sendKeys("I95devteam");		
		frontendLogin.getSignInButton().click();		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
