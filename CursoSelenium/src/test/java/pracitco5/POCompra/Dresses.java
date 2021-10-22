package pracitco5.POCompra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class Dresses {
	public WebDriver driver;
	@FindBy(xpath = "(//ul)[21]")
	public WebElement listadoImagen;
	@FindBy(tagName = "img")
	public List<WebElement> hoverImagen;
	@FindBy(tagName = "a")
	public List<WebElement> clickEnlace;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement checkOut;
	@FindBy(id = "layer_cart")
	public WebElement idCuadro;
	@FindBy(xpath = "(//img[@title='Printed Dress'])[1]")
	public WebElement anadirVestido;
	@FindBy(xpath = "(//a[@title='Add to cart'])[1]")
	public WebElement hoverCompra;
	
	
	public Dresses(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDresses() {
		//System.out.println("dr"+driver.getTitle());
		return driver.getCurrentUrl().contains("Dresses - My Store");
	}
	
	public void seleccionarVestido() {
		
		for (WebElement webElement : hoverImagen) {
				String title = webElement.getAttribute("title");
				//System.out.println("img" + title);
				//(//img[@title='Printed Dress'])[1]
				if (listadoImagen.isDisplayed()) {
				
						System.out.println("img: "+ title);
					
					
					
					}
//					if (title.isEmpty() == false) {
//						System.out.println("img2 " + title);
//					}
				
				}
	}
	public void anadirVestido() {
		SeleniumDriver.hoverClick(driver, anadirVestido, hoverCompra);
	}
	
	public ShoppingCart validarMensaje() {
			SeleniumDriver.sleepSeconds(3);
			
			WebElement ele = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			ShoppingCart shopping = new ShoppingCart(driver);
			return shopping;
	}
	
	
}
