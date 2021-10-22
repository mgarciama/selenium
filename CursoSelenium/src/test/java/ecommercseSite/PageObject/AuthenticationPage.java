package ecommercseSite.PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AuthenticationPage {
	public WebDriver driver;
	
	public AuthenticationPage(WebDriver remoteDriver) {
		this.driver = remoteDriver;
	}
	
	public void validateAuthPage(String firstName,String lastName, String email) {
		List <WebElement> input = driver.findElements(By.tagName("input"));
		System.out.println("input "+input.get(6).getAttribute("value"));
		Assert.assertEquals(firstName, input.get(6).getAttribute("value"));
		Assert.assertEquals(lastName, input.get(7).getAttribute("value"));
		Assert.assertEquals(email, input.get(8).getAttribute("value"));
	}
	
	public void createEnailTheAccount() {
		
		
	}
}
