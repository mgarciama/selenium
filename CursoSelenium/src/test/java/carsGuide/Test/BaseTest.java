package carsGuide.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import carsGuide.Auto.Automovil;
import carsGuide.utils.Constants;
import cucumber.api.java.it.Dato;
import practico12.Personas;
import util.SeleniumDriver;

public class BaseTest {
	String url = "https://www.carsguide.com.au/buy-a-car/new-and-used-car-search";
	public static List<Automovil> LIST_AUTOMOVIL= new ArrayList<>();
	public WebDriver driver;
@BeforeMethod
public void setUpTest(ITestContext context) throws Exception {
	
	// cargamos el directorio para poder navegar
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",
			projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	
	String xpathChrome = "C:\\Users\\manue\\AppData\\Local\\Google\\Chrome\\User Data";
	// ejecuta sin interface grafica
	ChromeOptions chromeOptions = new ChromeOptions();
	//chromeOptions.addArguments("--headless");
	//chromeOptions.addArguments("--user-data-dir="+xpathChrome);
	//chromeOptions.addArguments("--profile-directory= Profile 1");
	driver = new ChromeDriver(chromeOptions);
	//driver = new ChromeDriver();

	// navegamos a google
	driver.get(url);
	//Ejecutar con interfaz grafica
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     PageFactory.initElements(driver, this);
     context.setAttribute("WebDriver",driver);

}
	@BeforeTest
	public void loadData() {
		//separamos la cadena
		Constants.AUTOMOVIL = Constants.AUTOMOVIL.replace("; ", ";");
		Constants.AUTOMOVIL = Constants.AUTOMOVIL.replace(", ", ",");
		String[] dataCoches = Constants.AUTOMOVIL.split(";");
		//llamamos la cadena por niveles
		System.out.println("datos Audi"+ dataCoches[0]);
		System.out.println("datos BMW"+ dataCoches[1]);
		//sacamos de toda de la cadena en llamada individuales
		//Para meterlo en el objeto
		for (int i = 0; i < dataCoches.length; i++) {
			 String [] datos = dataCoches[i].split(",");
			 //System.out.println("datos "+ datos[0]); 
			 String marca = datos[0];
			 String modelo = datos[1];
			 String localizacion = datos[2];
			 String precio = datos[3];
			 Automovil auto = new Automovil(marca, modelo, localizacion, precio);
			 LIST_AUTOMOVIL.add(auto);
		}
		
	}




@AfterMethod
public void tearDown(ITestResult result) throws InterruptedException {
	SeleniumDriver.sleepSeconds(3);
	driver.close();
	
}
}
