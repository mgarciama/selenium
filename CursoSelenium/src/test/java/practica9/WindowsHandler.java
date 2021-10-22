package practica9;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.SeleniumDriver;

public class WindowsHandler {
	String URL = "https://www.naukri.com/";
	String URL2 = "https://www.salesforce.com/";
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
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
		
		
		}


		@Test(description = "multiplex ventanas", enabled = false, priority = 1)
	    public void multipleVentana(){
			driver.get(URL);
			
		
			
			 SeleniumDriver.sleepSeconds(3);
				//cerramos todas las ventanas
		       driver.close();
		}
		
		@Test(description = "mapeos", enabled = true, priority = 2)
	    public void salesforceTest() throws InterruptedException{
			HashMap<String,String> mapaTab = new HashMap<String, String>();
			driver.get(URL2);
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			 String ventanaPrincipal = driver.getWindowHandle();
		       System.out.println("ventana Principal "+ ventanaPrincipal);
			
			//driver.findElement(By.xpath("//*[@href='/es/form/signup/freetrial-sales-pe/?d=70130000000EqoP']")).click();
			WebDriverHelper_Test.getElementByXPath("href", "/es/form/signup/freetrial-sales-pe/?d=70130000000EqoP", driver).click();;
			System.out.println("se abre una ventana ");
			
			
//			 Set<String> todasLasVentanas = driver.getWindowHandles();
//			 mapaTab.put("main",ventanaPrincipal);
//			 
//			 
//			 for (String unaVentana : todasLasVentanas) {
//				if (!ventanaPrincipal.equals(unaVentana)) {
//					mapaTab.put("registro", unaVentana);
//				
//				}
//			}
			cargarValoresEnMapa(mapaTab, "main","registro",ventanaPrincipal);
				driver.switchTo().window(mapaTab.get("registro"));
				driver.findElement(By.name("UserFirstName")).sendKeys("Manu");
				Thread.sleep(3000);
				driver.switchTo().window(mapaTab.get("main"));
				Thread.sleep(3000);
				driver.switchTo().window(mapaTab.get("registro"));
				Thread.sleep(3000);
				driver.switchTo().window(mapaTab.get("main"));
				driver.close();
			
		}
		 @Test(description = "getElementsWithIds", enabled = false, priority = 3)
		public void Test_getElementsWithIds() {
			 driver.get(URL2);
			 driver.findElement(By.id("onetrust-accept-btn-handler")).click();
				WebDriverHelper_Test.getElementsWithIds(driver, "products_menu_item");
				WebDriverHelper_Test.getElementsWithNames(driver, "products_menu_item");
		 }
		//localizar todas las ventanas y cerrarlas
	    private void keepFirstWindowOpen() {
	    	
	    	//indicamos la ventana principal
		       String ventanaPrincipal = driver.getWindowHandle();
		       System.out.println("ventana Principal "+ ventanaPrincipal);
		       //muestra todas las ventanas
		       Set<String> todasLasVentanas = driver.getWindowHandles();
		       System.out.println("**********************************");
		       //sacamos todas las ventanas, para identificarlas
		       for (String unaVentana : todasLasVentanas) {
				System.out.println("una ventana "+ unaVentana);
				//!unaVentana.equals(ventanaPrincipal) 
				if (unaVentana.equals(ventanaPrincipal) == false) {
					driver.switchTo().window(unaVentana);
					System.out.println("cerrando la ventana de una ventana"+ unaVentana);
					 SeleniumDriver.sleepSeconds(3);
					driver.close();
				}
				
			}
		      

		    }
	    	//mapeo de ventanas, es más facil para cambiar de ellas
	    public HashMap<String, String> cargarValoresEnMapa(HashMap<String, String> mapa,String main, String registro, String mainWindow){
	    	 Set<String> todasLasVentanas = driver.getWindowHandles();
			 mapa.put(main,mainWindow);
			 
			 
			 for (String unaVentana : todasLasVentanas) {
				if (!mainWindow.equals(unaVentana)) {
					mapa.put(registro, unaVentana);
				
				}
			}
				
				
	    
			return mapa;
	    	  
	    }
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			 Thread.sleep(5000);
			driver.quit();
			
		}
}
