package eulen.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import funciones.Screenshooter;


public class LoginEulenPO {
	private WebDriver driver;
	@FindBy(id = "iniciarSesion")
	private WebElement iniciarSesion;
	@FindBy(xpath = "//img[@alt='Logo de EULEN']")
	private WebElement icono;
	
	
	public LoginEulenPO(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public void assertPage() {
		
		Assert.assertEquals("Logo de EULEN", icono.getAttribute("alt"));
		//System.out.println("verficar" + icono.getAttribute("alt"));
	}
	
	public void inicio() {
		
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		iniciarSesion.click();
		
		
	}
	
	
	
	
	
}
