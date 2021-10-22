package practico;




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

public class Clase1 {

	
		
		 WebDriver driver;
		
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
			String url = "www.facebook.com";
			// navegamos a google
			//driver.get(url);
		
		
		}

		@Test(description = "Alertas", enabled = false, priority = 1)
		public void primerTest() {
			//driver.get(url);
		//list<WebElement> listaTagName = driver.findElements(By.tagName("qqqq"));
		
			//String estilo = driver.findElement(By.id("")).
		
		
		}
		
		@Test(description = "atributos alt", enabled = true, priority = 1)
		public void getAttribute() {
			driver.get("https://mundomac.com");
			//lista de imagenes
			List<WebElement> listaImagenes= driver.findElements(By.tagName("img"));
			Assert.assertNotEquals(listaImagenes.size(), 0);
			int contador = 1;
			for (WebElement img: listaImagenes) {
				String altAttr = img.getAttribute("alt");
				//System.out.println("listas: " + altAttr);
				
				//los atributos alt están vacios		
				//si está vacio o no tiene el atributo alt
				if (altAttr.isEmpty() || altAttr.equals("")) {
					String imgSrc = img.getAttribute("src");
					System.out.println("imagenes src: "+ imgSrc);
					System.out.println("********* "+ altAttr + "resultados: "+ contador);
					contador++;
				}
			}
			
		}
		@Test(description = "encontrar los hijos", enabled = false, priority = 1)
		public void bbc() {
			driver.get("https://www.bbc.com");
			List<WebElement>  idElement = driver.findElements(By.id("orb-modules"));
			//List<WebElement>  divElement = driver.findElement(By.tagName("div"));
			//List<WebElement> parrafos = divElement.findElements(By.tagName("p"));
			
			for(WebElement div : idElement) {
				List<WebElement> parrafos = div.findElements(By.tagName("p"));
				System.out.println("parrafos: "+ parrafos.size());
			}
			
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			
			driver.close();
			
		}

	}



