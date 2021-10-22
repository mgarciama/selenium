package practico12;

import java.util.ArrayList;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.java.it.Dato;
import util.SeleniumDriver;



public class TestConString {

	
	public static String DATA = "112111, Manuel, Ciudad Real, España, testing@test.com; 112112, Yoana, Ciudad Real, España, profesora@profe.com"; 
	//metemos en una lista la clase Personas
	public static List<Personas> LISTA_PERSONA= new ArrayList<>();
	

		
		@BeforeTest
		public void loadData() {
		DATA = DATA.replace("; ", ";");
		DATA = DATA.replace(", ", ",");
		String [] datosPersonas = DATA.split(";");
		System.out.println(datosPersonas[0]);
		System.out.println(datosPersonas[1]);
		
		for (int i = 0; i < datosPersonas.length; i++) {
			String[] datos = datosPersonas[i].split(",");
			System.out.println("datos de las personas: ");
			System.out.println(datos[0]);
			System.out.println(datos[1]);
			System.out.println(datos[2]);
			System.out.println(datos[3]);
			
			String dni = datos[0];
			String nombre = datos[1];
			String pais = datos[3];
			String email = datos[4];
												
			Personas p = new Personas(pais, nombre, Integer.parseInt(dni),email);
			
			LISTA_PERSONA.add(p);
		}
		System.out.println("********Lista de Personas******");
		System.out.println(LISTA_PERSONA.get(0));
		System.out.println(LISTA_PERSONA.get(1));

	}
		public WebDriver driver;
		@BeforeMethod
		public void setUpTest() throws Exception {
			
			// cargamos el directorio para poder navegar
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			
		
		
			driver = new ChromeDriver();
			//driver = new ChromeDriver();
			String url = "https://www.spotify.com";
			// navegamos a google
			driver.get(url);
		}
		private int i = 0;
		@Test (invocationCount = 2)
		public void registroTest() {
			System.out.println("********Lista de Personas******");
			System.out.println(LISTA_PERSONA.get(0));
			System.out.println(LISTA_PERSONA.get(1));
			Assert.assertNotEquals("Deben salir la lista", LISTA_PERSONA.size());
			
			Personas p = LISTA_PERSONA.get(i); // para llamar a todos el listado ejecuanto dos veces
			
			//web del spotify
			System.out.println("title"+ driver.getTitle());
			Assert.assertEquals("Escuchar lo es todo - Spotify", driver.getTitle());
			SeleniumDriver.sleepSeconds(3);
			//click cooke
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			driver.findElement(By.xpath("//*[@href='https://www.spotify.com/es/signup/']")).click();
			SeleniumDriver.newVentana(driver);
			
			//formulario
			WebElement  inputEmail= driver.findElement(By.id("email"));
			//inputEmail.sendKeys(LISTA_PERSONA.get(0).getEmail());
			inputEmail.sendKeys(p.getEmail());
			WebElement  inputNombre = driver.findElement(By.id("displayname"));
			//inputNombre.sendKeys(LISTA_PERSONA.get(1).getNombre()); una opccion para llamar la otra persona
			inputNombre.sendKeys(p.getNombre());
			
			i++; // añadimos ++ para intentar ejecutar dos veces y llamando al listado sin poner get(1)
		}
		@AfterMethod
		public void closeDriver() {
		
			driver.close();
		}

}
