package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class backendLoginPage extends Base {
	public WebDriver driver;
	public backendLoginPage(WebDriver driver ) {
		 this.driver=driver;
	}
	
	By userName=By.id("username");
	By password=By.id("login");
	By signIn=By.xpath("//*[@id='login-form']//button[@class='action-login action-primary']");
	
	public WebElement getUserName() {
		return driver.findElement(userName);
				
	}
	public WebElement getPassword() {
		return driver.findElement(password);
				
	}
	public WebElement getLogin() {
		return driver.findElement(signIn);
				
	}

}
