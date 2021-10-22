package carsGuide.POLogin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class PaginaInicioPO {
	public WebDriver driver;
	@FindBy(tagName = "li")
	public List<WebElement> mostrarLi;
	@FindBy(tagName = "ul")
	public List<WebElement> mostrarUl;
	@FindBy(xpath = "//ul/li/a[contains(text(),'Search Cars')]")
	public WebElement menuBuscar;
	@FindBy(xpath = "//ul/li/a[contains(text(),'buy + sell')]")
	public WebElement menuBuy;

	public PaginaInicioPO(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getListado() {
	//	int contador = 1;
		//String li = "";
		boolean cierto = false;
		for (WebElement e : mostrarUl) {
			String ul = e.getText();
			if (!ul.isEmpty()) {
			e.isDisplayed();
			}
//				for (WebElement i : mostrarLi) {
//					String li = i.getText();
//					String liSin = i.getTagName();
//					//si aparece dentro de ul li con texto
//					if (!li.isEmpty()) {
//						//System.out.println(" li"+ i.getText());
//						i.isDisplayed();
//						
//						//si muestra dentro de ul - li sin texto con el string li
//						// si muestra dentro de ul, no aparece li con el string liSin
//					} if (liSin.isEmpty()) {
//						//System.out.println("li vacio"+i.getSize());
//						//System.out.println(" li"+ i.getSize());
//						//contador++;
//						//System.out.println("no UL"+ e.getSize());
//					}
//					
//				}
//			} 
		}
		return cierto;
	}
	
	public String getBuy() {
		return menuBuscar.getText();
	}
	public void menuHoverBuySell() {
		//SeleniumDriver.hoverMove(driver, menuBuySell);////ul/li/a[contains(text(),'Search Cars')]
	
				SeleniumDriver.hoverMove(driver, menuBuy);
				
				SeleniumDriver.hoverClick(driver, menuBuscar, menuBuscar);

	}
	
}
