package dogpile;


import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;






public class DogpileTest {
	
	String url = "https://www.dogpile.com/";
	 public WebDriver driver;
		
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
			driver = new ChromeDriver();
		
			// navegamos a google
			driver.get(url);
			//Ejecutar con interfaz grafica
			driver.manage().window().maximize();
			
		
		
		}
		
		@Test(description = "busqueda", enabled = true, priority = 1)
		public void Busquedatest() {
			//a/span[contains(text(),'¡Listo!')]
			WebElement spanCookies = driver.findElement(By.xpath("//a/span[contains(text(),'¡Listo!')]"));
			WebElement nameInput = driver.findElement(By.id("q"));
			System.out.println("que es : "+ spanCookies.isEnabled());
			String cookies = "¡Listo!";
			System.out.println("nuevo : "+ cookies.isEmpty());
			if (!cookies.isEmpty()) {
				spanCookies.click();
			} 
		
			
		
			
			System.out.println("name " + nameInput.getAttribute("title"));
			Assert.assertEquals("Search", nameInput.getAttribute("title"));
			
			nameInput.sendKeys("tesla");
			//div[@class='txt']
			driver.findElement(By.className("txt")).click();
			List<WebElement> enlances1 = driver.findElements(By.xpath("//div/a"));
			List<WebElement> enlances2 = driver.findElements(By.xpath("//div[@class='web-bing__result']"));
			System.out.println("enlace 2" + enlances2.size());
			//int contador = 1;
			for (WebElement e : enlances2) {
				//List<WebElement> enlace3 = driver.findElements(By.className("lc_ si27 "));
				if (!enlances1.isEmpty()) {
					
					Assert.assertNotNull(e);
				}
				//contador ++;
			}
		}

	
	
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
			
		}

}
