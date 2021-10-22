package pagesLogin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import funciones.Screenshooter;
import funciones.Squery;


public class PO_Login {
//http://automationpractice.com/index.php
	private WebDriver driver;
	@FindBy(className = "login")
	private WebElement registrarteClick;
	@FindBy(id = "email_create")
	private WebElement emailFind;
	@FindBy(id = "SubmitCreate")
	private WebElement entrarCuenta;
	@FindBy(xpath = "//h1[@class='page-heading']")
	private WebElement title;
	@FindBy(xpath = "(//img[@itemprop='image'])[1]")
	private WebElement img;
	
	@FindBy(xpath = "(//div//a/span[contains(text(), 'Add to cart')])[1]")
	private WebElement span;
	//contructor
	public PO_Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void assertPage() {
		
		Assert.assertEquals("AUTHENTICATION", title.getText());
	}
	//manu.iecisa@hotmail.com
	public void registrar(String name) {
		registrarteClick.click();
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		assertPage();
		emailFind.click();
		emailFind.sendKeys(name);
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		entrarCuenta.click();
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
	
	}
	//con hover
	public void inicioHover() {
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		Squery.move(driver, img);
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		span.click();
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
	}
	//hoverClick
	public void pruebaHover() {
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		Squery.hoverClick(driver, img, span);
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
	}
	
}
