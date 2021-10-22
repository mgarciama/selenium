package test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import funciones.Screenshooter;
import funciones.SoutTest;

public class CondicionesComunes {
	// https://gitlab.com/explore/projects/starred?utf8=%E2%9C%93&name=selenium
	protected WebDriver driver;
	ArrayList<String> tabs;
	// private String browserName;

	// public static String browserName = null;
	@BeforeMethod
	public void setUpTest() throws Exception {
		// cargamos el directorio para poder navegar
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		// ejecuta sin interface grafica
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");

		driver = new ChromeDriver(chromeOptions);

		String url = "http://www.newtours.demoaut.com";
		// navegamos a google
		driver.get(url);
		// abre una ventana con js
		// JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		// String google = "window.open('https://www.google.es/')";
		// jsExecutor.executeScript(google);
		// tabs = new ArrayList<String> (driver.getWindowHandles());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		SoutTest.SouTest(result);
		if (!result.isSuccess()) {
			Screenshooter.takeScreenshot("CapturasError\\login\\Error", driver);

		}
		// https://www.youtube.com/watch?v=dgjkS_cUljg&list=PLjM3-neCG6qwYzuAGvZrRnhJ2tt-4WiG4&index=28

		driver.close();
		// cerrar los tabs
		// driver.switchTo().window(tabs.get(1)).close();
		// driver.switchTo().window(tabs.get(0)).close();
	}

}
