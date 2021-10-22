package pracitco5.POCompra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class ShoppingCart {
	public WebDriver driver;
	@FindBy(xpath = "//h1[contains(text(),'Shopping-cart summary')]")
	public WebElement h1Shopping;
	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
	public WebElement btnProceed;
	@FindBy(id = "email")
	public WebElement inputEmail;
	@FindBy(id = "passwd")
	public WebElement inputPassword;
	@FindBy(id = "SubmitLogin")
	public WebElement buttonLogin;
	@FindBy(tagName  = "h1")
	public WebElement h1;
	@FindBy(xpath  = "//button[@name='processAddress']")
	public WebElement btnProcess;
	@FindBy(xpath  = "//button[@name='processCarrier']")
	public WebElement btnProcessCarrier;
	@FindBy(id = "cgv")
	public WebElement checkList;
	
	
	public ShoppingCart(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String getShoppingCart() {
		System.out.println(driver.getTitle());
		System.out.println(h1Shopping.getText());
		return h1Shopping.getText();
	}
	public boolean getOrder() {
		System.out.println(driver.getTitle());
		return driver.getCurrentUrl().contains("Order - My Store");
	}
	public void pulsarProceed() {
		btnProceed.click();
	}
	public boolean getLogin() {
		System.out.println(driver.getTitle());
		return driver.getCurrentUrl().contains("Login - My Store");
		
	}
	public void comprobarRegistro(String user, String pass) {
		inputEmail.sendKeys(user);
		inputPassword.sendKeys(pass);
		buttonLogin.click();
		
	}
	public String getAddres() {
		System.out.println("text: "+ h1.getText());
		return h1.getText();
	}
	public void pulsarProcess() {
		btnProcess.click();
		SeleniumDriver.sleepSeconds(3);
		checkList.click();
		btnProcessCarrier.click();
	}
	
}
