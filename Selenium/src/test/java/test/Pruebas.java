package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import funciones.Screenshooter;
import funciones.SoutTest;
import pagesLogin.PO_Pruebas;


public class Pruebas {
	protected WebDriver driver;
	@BeforeMethod
	public void setUpTest() throws Exception {
		// cargamos el directorio para poder navegar
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		// ejecuta sin interface grafica
		//ChromeOptions chromeOptions = new ChromeOptions();
	//	chromeOptions.addArguments("--headless");
	//	driver = new ChromeDriver(chromeOptions);
		//Ejecutar con interfaz grafica
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://the-internet.herokuapp.com/";
		// navegamos a google
		driver.get(url);
	
	}

	@Test(description = "Alertas", enabled = false, priority = 1)
	public void AlertsJS () {
		PO_Pruebas pruebas = new PO_Pruebas(driver);
		pruebas.pulsarAlerts();
	}
	@Test(description = "Confirmar Alertas", enabled = true, priority = 2)
	public void AlertsConfirmar() {
		PO_Pruebas pruebas = new PO_Pruebas(driver);
		pruebas.pulsarAlerts2();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		SoutTest.SouTest(result);
		if (!result.isSuccess()) {
			Screenshooter.takeScreenshot("CapturasError\\Pruebas\\Error", driver);

		}
		driver.close();
		
	}
}
