package ejercicios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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

public class Ejercicio1 {
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
			String url = "https://www.facebook.com/";
			// navegamos a google
			driver.get(url);
		
		
		}

		@Test(description = "Encontrar un elementos", enabled = false, priority = 1)
		public void primerTest() throws InterruptedException {
//			String url = "https://www.facebook.com/";
//			driver.get(url);
			
			WebElement element1 = driver.findElement(By.className("qqqqqq"));
			//no encuentra elemento de la clase name
			element1.click();
		}
		
		
		@Test(description = "Encontrar una lista", enabled = false, priority = 2)
		public void sengudoTest() {
			List<WebElement> listaTagClass = driver.findElements(By.className("qqqq"));
			Assert.assertNotEquals(listaTagClass.size(), 0);
		}
		
		
		@Test(description = "obtener todos los elementos", enabled = false, priority = 3)
		public void tercerTest() {
			List<WebElement> listaTagName = driver.findElements(By.tagName("h112"));
			// con estos assert, nos dá un passed porque queremos la lista vacía.
			Assert.assertTrue(listaTagName.isEmpty());
			Assert.assertFalse(listaTagName.isEmpty() == false);
			Assert.assertEquals(0, listaTagName.size());
			
			//con este assert, nos dice realmente su valor, la lista no debe estar vacía:
			//Assert.assertNotEquals(listaTagName.size(), 0);
//			String text = "";
//											//text
//											//true
//			Assert.assertEquals(listaTagName, false);

		}
		@Test(description = "obtener todos los elementos", enabled = true, priority = 4)
		public void cuartoTest() {
			List<WebElement> listaH = driver.findElements(By.tagName("h1"));
			//con este assert, nos dice realmente su valor, la lista no debe estar vacía:
			//Assert.assertNotEquals(listaTagName.size(), 0);
			
											//text
											//true
			//Assert.assertTrue(listaH.isEmpty() == false);
			//Assert.assertFalse(listaH.isEmpty());
			Assert.assertNotEquals(0, listaH.size());

		}
		
		
		
		
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			 Thread.sleep(3000);
			driver.close();
			
		}
}
