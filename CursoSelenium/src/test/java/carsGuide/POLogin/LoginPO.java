package carsGuide.POLogin;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.SeleniumDriver;

public class LoginPO {
	public WebDriver driver;

	@FindBy(tagName = "li")
	public List<WebElement> listados;
	@FindBy(xpath = "(//ul/li)[3]")
	public WebElement singUpIn;
	@FindBy(tagName = "input")
	public List<WebElement> input;
	
	
	
	
	public LoginPO(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSingUpIn() {
		return listados.get(2).getText();
	}
	public boolean getTitle(String name) {
		return driver.getCurrentUrl().contains(name);
	}
	public void signUpIn() {
		SeleniumDriver.hoverClick(driver, singUpIn,singUpIn);
		System.out.println(driver.getTitle());
	
	}

	public void registrarte(String email, String password, String name, String lastName) {
		input.get(1).sendKeys(email);
		input.get(2).sendKeys(password);
		input.get(2).sendKeys(name);
		input.get(3).sendKeys(lastName);
	}
}
