package ejercicios;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ejercicio3 {
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
		String url = "https://www.apple.com/";
		// navegamos a google
		driver.get(url);
	
	
	}

	@Test(description = "obtener todos los DIV y contar los id que tenga los DIV", enabled = false, priority = 1)
	public void primerTest() throws InterruptedException {
		List<WebElement> todosDiv = driver.findElements(By.tagName("div"));
		System.out.println("div" + todosDiv.size());
		int contador = 1;
		for (WebElement element : todosDiv) {//div
			String allId = element.getAttribute("id");
			if (!allId.isEmpty()) {
				System.out.println("todos los datos: "+ contador  + " id: "+ allId);
				contador++;
			}
		}
	
	}
	
	@Test(description = "buscar WebElements dentro de un WebElement", enabled = true, priority = 1)
	public void segundoTest() throws InterruptedException {
		List<WebElement> todosDiv = driver.findElements(By.className("ac-gn-content"));
		//WebElement titulos = driver.findElement(By.tagName("li"));
		
		for (WebElement e : todosDiv) {//div
			System.out.println("titulos "+ e.getText());
			
		}
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		 Thread.sleep(3000);
		driver.close();
		
	}
}
