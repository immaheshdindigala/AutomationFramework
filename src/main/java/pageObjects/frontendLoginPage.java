package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class frontendLoginPage {
	public WebDriver driver;
	public frontendLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signIn=By.xpath("//div[@class='panel header']//a[contains(@href,'login')]");
	By userName=By.id("email");
	By password=By.id("pass");
	By signInButton=By.id("send2");
	
	public WebElement getSignIn() {
		return driver.findElement(signIn);
				
	}
	public WebElement getUserName() {
		return driver.findElement(userName);
				
	}
	public WebElement getPassword() {
		return driver.findElement(password);
				
	}
	public WebElement getSignInButton() {
		return driver.findElement(signInButton);		
	}

}
