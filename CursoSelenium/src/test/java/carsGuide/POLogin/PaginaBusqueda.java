package carsGuide.POLogin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumDriver;

public class PaginaBusqueda {
	public WebDriver driver;

	@FindBy(id = "makes")
	public WebElement selectMarcas;
	@FindBy(id = "models")
	public WebElement selectModelos;
	@FindBy(id = "locations")
	public WebElement selectLocalizacion;
	@FindBy(id = "priceTo")
	public WebElement selectPrecio;
	@FindBy(id = "search-submit")
	public WebElement buttonBuscar;  
	@FindBy(className  = "listing-cars")
	public WebElement encontrar; 
	@FindBy(className  = "carListing--content ")
	public List <WebElement> listaCoches; 
	public PaginaBusqueda(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void buscarCars(String marca, String modelo, String locatiom, String precio) {
		SeleniumDriver.selectValue(selectMarcas, marca);//"Audi"
		SeleniumDriver.selectValue(selectModelos, modelo);//A4
		SeleniumDriver.selectValue(selectLocalizacion, locatiom);//ACT - All
		SeleniumDriver.selectValue(selectPrecio, precio);//15000
		
		buttonBuscar.click();
		
	}
	
	public void resultadoBusquedaCars() {
		//System.out.println("encontramos "+ encontrar.getText());
		System.out.println("cuanto:  "+ encontrar.getSize());
		//System.out.println("listado: "+ listaCoches.size());
	}
}
