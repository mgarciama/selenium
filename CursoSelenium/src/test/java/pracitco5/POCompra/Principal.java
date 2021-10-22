package pracitco5.POCompra;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class Principal {
public static WebDriver driver;
	
	@FindBy(xpath  = "(//li/a[@title='Dresses'])[2]")
	public static WebElement Vestido;
	@FindBy(xpath  = "(//li/a[@title='Dresses'])[1]")
	public WebElement hoverVestidoClick;
	@FindBy(xpath  = "(//li/a[@title='Women'])[1]")
	public WebElement hoverWomen;
	
	
	public Principal(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	public String getWoman() {
		System.out.println(hoverWomen.getText());
		return hoverWomen.getText();
	}
	public String getDresses() {
		System.out.println(Vestido.getText());
		return Vestido.getText();
	}
	public Dresses pulsarMenuWoman() {
		SeleniumDriver.hoverClick(driver, Vestido, Vestido);
		Dresses dresses = new Dresses(driver);
		return dresses;
	}
	public Dresses pulsarMenuDresses() {
		hoverWomen.click();
		Dresses dresses = new Dresses(driver);
		return dresses;
	}
	public static void menuWoman() {
		SeleniumDriver.hoverClick(driver, Vestido, Vestido);
	}
	public void menuDresses() {
		hoverWomen.click();
	}
}
