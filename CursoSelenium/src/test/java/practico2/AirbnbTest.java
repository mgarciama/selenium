package practico2;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AirbnbTest {
	
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
			String url = "https://www.airbnb.es/";
			// navegamos a google
			driver.get(url);
			//5 segundos de espera
			int segundosAEsperar = 5;
			driver.manage().timeouts().implicitlyWait(segundosAEsperar , TimeUnit.SECONDS);
		
		
		}

		
		private static String fechas(String fecha, int dia) {
			
			String[] f = fecha.split("-");
		    Calendar calendar = Calendar.getInstance();
		    calendar.set(Integer.parseInt(f[0]), Integer.parseInt(f[1])-1, Integer.parseInt(f[2]));

		    calendar.add(Calendar.DAY_OF_MONTH, dia);
		    
		    SimpleDateFormat fe = new SimpleDateFormat("YYYY-MM-dd");
		    return fe.format(calendar.getTime());
			
		}
		@Test(description = "busqueda de alojamientos", enabled = true, priority = 1)
		public void primerTest() throws InterruptedException {
		
		    
			
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='_1qnlffd6']")).click();
			driver.findElement(By.xpath("//*[@placeholder='¿A dónde viajas?']")).sendKeys("Budapest");
			//calendario:
			//calendario:
			WebElement llegada = driver.findElement(By.xpath("//div[@role='button']/div/div[2]"));
		
			String formato = "yyyy-MM-dd";

			
			DateFormat date = new SimpleDateFormat(formato);

			
			Date today = Calendar.getInstance().getTime();        
			
			String todayAsString = date.format(today);

			System.out.println("día de hoy: " + todayAsString);
			System.out.println("suma de la fecha "+ fechas(todayAsString,7));

			llegada.click();
		
			//fehca de hoy
			WebElement fechaInicio = driver.findElement(By.xpath("//div[@data-testid = 'datepicker-day-"+todayAsString+"']"));

			fechaInicio.click();
			Thread.sleep(2000);
			WebElement salida = driver.findElement(By.xpath("(//div[@role='button'])[2]/div/div[2]"));
			
			salida.click();
			salida.click();
			Thread.sleep(2000);
			// fecha de hoy + 7 días 
			
			WebElement fechaFIn = driver.findElement(By.xpath("//div[@data-testid = 'datepicker-day-"+fechas(todayAsString,7)+"']"));
			System.out.println(fechaFIn.getText());
			fechaFIn.click();
			
			//huespedes
			WebElement huespedes = driver.findElement(By.xpath("//div[@class='_uh2dzp']"));
			huespedes.click();
			//cantidades de huespedes:
			driver.findElement(By.xpath("(//button[@class='_7hhhl3'])[2]")).click();
			driver.findElement(By.xpath("(//button[@class='_7hhhl3'])[2]")).click();
			driver.findElement(By.xpath("(//button[@class='_7hhhl3'])[2]")).click();
			//buscar
			driver.findElement(By.xpath("//button[@class='_1mzhry13']")).click();
		
			//nueva ventana de busqueda
			WebElement encontramos = driver.findElement(By.className("_1snxcqc"));
			System.out.println("assert: "+ encontramos.isDisplayed());
			String texto = encontramos.getText();
			System.out.println("texto "+ texto);
			Assert.assertTrue(encontramos.isDisplayed());
			//Assert.assertEquals(texto,encontramos.getText());
			
			
		}
		
		
		
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
			
		}


}
