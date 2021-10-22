package practrica6.pageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class Principal {
public WebDriver driver;
	
	@FindBy(xpath  = "(//li/a[@title='Dresses'])[2]")
	public WebElement hoverVestido;
	@FindBy(xpath  = "(//li/a[@title='Dresses'])[1]")
	public WebElement hoverVestidoClick;
	@FindBy(xpath  = "(//li/a[@title='Women'])[1]")
	public WebElement hoverWomen;
	public Principal(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public Dresses pulsarMenuWoman() {
		SeleniumDriver.hoverClick(driver, hoverVestido, hoverVestido);
		Dresses dresses = new Dresses(driver);
		return dresses;
	}
}
