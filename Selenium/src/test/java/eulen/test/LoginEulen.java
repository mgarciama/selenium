package eulen.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eulen.po.LoginEulenPO;
import eulen.po.RegistroEulenPO;
import funciones.Screenshooter;
import funciones.SoutTest;



public class LoginEulen {
	
	
	
	
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
		String url = "https://node-dot-eulen-efqm.appspot.com/#/login";
		// navegamos a google
		driver.get(url);
	
	}

	@Test(description = "prueba registro", enabled = true, priority = 1)
	public void registro () {
		LoginEulenPO eulenLogin = new LoginEulenPO(driver);
		eulenLogin.inicio();
		RegistroEulenPO registro = new RegistroEulenPO(driver);
		registro.inicio("francisco.murillo","123456");
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) {
		SoutTest.SouTest(result);
		if (!result.isSuccess()) {
			Screenshooter.takeScreenshot("CapturasError\\loginNew\\Error", driver);

		}
		
		driver.close();
		driver.quit();
		
	
	}
}
