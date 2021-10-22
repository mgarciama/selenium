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

public class Ejercicio2 {
	
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
		//String url = "http://automationpractice.com/index.php";
		String url = "https://www.booking.com/";
		// navegamos a google
		driver.get(url);
	
	
	}

	@Test(description = "validar booking", enabled = true, priority = 1)
	public void primerTest() throws InterruptedException {
		WebElement conectaConGente = driver.findElement(By.xpath("(//div/h2)[6]"));
		System.out.println("valido: "+ conectaConGente.getText());
		Assert.assertNotEquals(0, conectaConGente);
	}
	
	@Test(description = "validar con un tagName", enabled = false, priority = 2)
	public void segundoTest() throws InterruptedException {
		List<WebElement> tagName = driver.findElements(By.tagName("h2"));
		for (WebElement webElement : tagName) {
			System.out.println("tagname: "+webElement.getAttribute("h2"));
			//al encontrar h2 null, este assert, nos dice que no nul
			Assert.assertNotNull(webElement);

		}
		
		
	}
	

	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		 Thread.sleep(3000);
		driver.close();
		
	}

}
