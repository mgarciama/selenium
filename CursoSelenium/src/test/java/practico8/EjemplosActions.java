package practico8;

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

import util.SeleniumDriver;

public class EjemplosActions {
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
		//String url = "https://www.google.com/";// para los test 1 y 2
		
		// navegamos a google
		//driver.get(url);
	
	
	}


	
	
	@Test(description = "mover un elemento, un hover en un elemento", enabled = false, priority = 1)
	public void moveToElement() {
		
	driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();	
	WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
	SeleniumDriver.hoverMove(driver, gmailLink);
	}
	@Test(description = "doble click en un elemento", enabled = false, priority = 2)
	public void dobleClikc() {
		
	driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();	
	WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
	SeleniumDriver.hoverClick(driver, gmailLink,gmailLink);
	}
	@Test(description = "arrastar y soltar", enabled = false, priority = 3)
	public void drapDpog() {
		String url = "https://crossbrowsertesting.github.io/drag-and-drop";
		driver.get(url);
		WebElement arrastrar = driver.findElement(By.id("draggable"));
		WebElement soltar = driver.findElement(By.id("droppable"));
		
		SeleniumDriver.DragDrop(driver, arrastrar, soltar);
			
	}
	@Test(description = "encontrarElemento: Iframe", enabled = true, priority = 4)
	public void jquery() {
		String url = "https://api.jquery.com/dblclick/";
		driver.get(url);
		//se posiciona el punto 0
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.cssSelector("html>body>div"));
		SeleniumDriver.hoverClick(driver, element1, element1);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		 Thread.sleep(3000);
		//driver.close();
		
	}
}
