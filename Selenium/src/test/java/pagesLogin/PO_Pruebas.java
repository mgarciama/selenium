package pagesLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import funciones.Screenshooter;
import funciones.Squery;

public class PO_Pruebas {

	private WebDriver driver;
	
	@FindBy(xpath = "(//li/a)[29]")
	private WebElement PulsarAlerts;
	@FindBy(xpath = "//h3")//h3[contains( text(), 'JavaScript Alerts')]
	private WebElement title;
	@FindBy(xpath ="(//ul/li/button)[1]")
	private WebElement buttonOne;
	@FindBy(xpath ="(//ul/li/button)[2]")
	private WebElement buttonTwo;
	@FindBy(xpath ="(//ul/li/button)[3]")
	private WebElement buttonThree;
	//contructor
	public PO_Pruebas(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void assertPage() {
		
		Squery.AssertText("JavaScript Alerts", title);
	}
	public void pulsarAlerts() {
		PulsarAlerts.click();
		Squery.sleepSeconds(3);
		//System.out.println("text" + title.getText());
		assertPage();
		Screenshooter.takeScreenshot("Capturas\\pruebas\\pruebas", driver);
		buttonOne.click();
		Squery.alertAccept(driver);
		Squery.sleepSeconds(3);
	}
	public void pulsarAlerts2() {
		PulsarAlerts.click();
		Squery.sleepSeconds(3);
		//System.out.println("text" + title.getText());
		assertPage();
		Screenshooter.takeScreenshot("Capturas\\pruebas\\pruebas", driver);
		buttonTwo.click();
		Squery.alertAccept(driver);
		buttonTwo.click();
		Squery.sleepSeconds(5);
		Squery.alertCancel(driver);
		Squery.sleepSeconds(5);
		buttonThree.click();
		Squery.sleepSeconds(5);
		Squery.alertString(driver, "prueba alerta");
		Squery.sleepSeconds(5);
	}
}
