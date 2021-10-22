package test;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import funciones.Excel;
import funciones.Screenshooter;
import funciones.SoutTest;
import pagesLogin.PO_Formulario;
import pagesLogin.PO_Login;

public class Test_Login {
	
	
	protected WebDriver driver;
	@BeforeMethod
	public void setUpTest() throws Exception {
		Excel data = new Excel(null, null);
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
		String url = "http://automationpractice.com/index.php";
		// navegamos a google
		driver.get(url);
	
	}

	@Test(description = "prueba registro", enabled = true, priority = 1)
	public void registro () {
		PO_Login poLogin = new PO_Login(driver);
		poLogin.registrar("manu.iecisa@hotmail.com");
		PO_Formulario formulario = new PO_Formulario(driver);
		formulario.formulario("Manuel","Gacía", "mgarcia@iecisa.com","123456","1");
	}
	@Test(description = "prueba hoverMove", enabled = false, priority = 1)
	public void prueba () {
		PO_Login poLogin = new PO_Login(driver);
		poLogin.inicioHover();
		
	}
	@Test(description = "prueba hoverClick", enabled = false, priority = 2)
	public void prueba2 () {
		PO_Login poLogin = new PO_Login(driver);
		poLogin.inicioHover();
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		SoutTest.SouTest(result);
		if (!result.isSuccess()) {
			Screenshooter.takeScreenshot("CapturasError\\loginNew\\Error", driver);

		}
		driver.close();
		
	}
	
}
