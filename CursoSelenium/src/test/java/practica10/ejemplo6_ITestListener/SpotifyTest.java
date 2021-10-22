package practica10.ejemplo6_ITestListener;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import practica10.ejemplo4_Listener.InvokedMethodListener;
import util.SeleniumDriver;


@Listeners(value = TestListeners.class)
public class SpotifyTest {
	protected WebDriver driver;
//	@BeforeMethod
//	public void setup() {
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",
//				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
//		// ejecuta sin interface grafica
//		//ChromeOptions chromeOptions = new ChromeOptions();
//	//	chromeOptions.addArguments("--headless");
//	//	driver = new ChromeDriver(chromeOptions);
//		//Ejecutar con interfaz grafica
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		//String url = "http://automationpractice.com/index.php";
//		String url = "https://www.spotify.com/es/";
//		//context.setAttribute("WebDriver",driver);
//
//		driver.get(url);
//	}
	
	@BeforeMethod
	public void sertDriverContext(ITestContext context) {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.spotify.com/es/";
		context.setAttribute("WebDriver",driver);
		
		//	ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("--headless");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		   
		  driver.get(url);
	}
	
	@Test
	public void tesSpotify() {
		System.out.println("title"+ driver.getTitle());
		Assert.assertEquals("Escuchar lo es todo - Spotify", driver.getTitle());
		SeleniumDriver.sleepSeconds(3);
		//click cooke
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.xpath("//*[@href='https://www.spotify.com/es/signup/']")).click();
		SeleniumDriver.newVentana(driver);
		SeleniumDriver.sleepSeconds(3);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		List<WebElement> errorList = driver.findElements(By.tagName("span"));
		
		for (WebElement e : errorList) {
			System.out.println("error: "+ e.getText());
			
			if (e.getText().equals("Es necesario que indiques tu correo electrónico")) {
				Assert.assertTrue(false);
			}
			
			Assert.assertEquals("Es necesario que indiques tu correo electrónico", e.getText());
		}
	}
	//ejecutamos 5 veces
//		private int i = 0;
//		@Test(successPercentage = 60 ,invocationCount = 5)
//		
//		//el successPercentage = 100 representa a que no se toleran fallas, tiene que pasar los 5 test
//		//el successPercentage = 80  representa a que debe pasar el 80% de las ejecuciones, tiene que pasar los 4 de 5 ejecuciones
//		//el successPercentage = 60  representa a que debe pasar el 60% de las ejecuciones, tiene que pasar los 3 de 5 ejecuciones
//		//el successPercentage es 0, es decir, aunque falle todos los test, el resultado será exitoso
//		public void porcentageTestSuccessRate() {
//			i++;
//			System.out.println("i vale + "+ i);
//			
//			if (i == 1 || i == 2) {
//				Assert.assertTrue(false);
//			}
//		}
	
	
	@AfterMethod
	public void closeMethod() {
		
		driver.close();
	}
}
