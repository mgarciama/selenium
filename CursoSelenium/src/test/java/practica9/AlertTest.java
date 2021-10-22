package practica9;

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

public class AlertTest {
	String URL = "http://www.seleniumacademy.net/alertas";
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
			
			driver.get(URL);
		
		
		}


		@Test(description = "ejemplos de alert - simple", enabled = true, priority = 1)
	    public void simpleAlert(){
	       
			WebElement alert1 = driver.findElement(By.id("alert1"));
			alert1.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("alertGetText "+ alert.getText());
			alert.accept();


	    }
		@Test(description = "ejemplos de alert - simple", enabled = true, priority = 2)
	    public void confirmationAlert(){
	       
			WebElement alert1 = driver.findElement(By.id("alert2"));
			alert1.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("alertGetText "+ alert.getText());
			alert.accept();
			
			WebElement msgAlert = driver.findElement(By.id("demo"));
			System.out.println(msgAlert.getText());
			Assert.assertEquals("Alert accepted!",msgAlert.getText());


	    }
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			 Thread.sleep(3000);
			//driver.close();
			
		}
}
