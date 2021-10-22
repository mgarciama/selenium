package util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class SeleniumDriver {
	private static SeleniumDriver SeleniumDriver;
	private static WebDriver driver;
	@SuppressWarnings("unused")
	private static WebDriverWait waitDriver;
	
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	
	private SeleniumDriver() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver,TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	//abrimos navegador
	public static void openPage(String url) {
		driver.get(url);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	//Iniciamos driver
	public static void setUpDriver() {
		if(SeleniumDriver == null) {
			SeleniumDriver = new SeleniumDriver();
		}
	}
	//cerramos driver
	public static void tearDown() {
		if(driver !=null) {
			driver.close();
			driver.quit();
		}
		SeleniumDriver = null;
	}
	
	// marcamos una clase 5 segundos para reutilizarlos
	public static void sleepSeconds(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//hover
		public static void hoverMove(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			Action mouseOverHome = actions.moveToElement(element).build();
			mouseOverHome.perform();
			
		}
		//hoverClick con webElement
		public static void hoverClick(WebDriver driver, WebElement move, WebElement click) {
			Actions actions = new Actions(driver);
			Action mouseOverHome = actions.moveToElement(move).doubleClick(click).build();
			mouseOverHome.perform();
			
		}
		
		//dobleClick
		public static void doubleClick(WebDriver driver, WebElement element) {
			
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}
		
		//arrastrar y soltar
		public static void DragDrop(WebDriver driver,WebElement arrastrar,WebElement soltar) {
			Actions actionProvider = new Actions(driver);
			actionProvider.dragAndDrop(arrastrar, soltar).build().perform();
		}
		
		public static void HoverWrite(WebDriver driver, WebElement element, String string) {
			Actions actions = new Actions(driver);
			Action fillEmailInputField = actions.moveToElement(element)
	                .click()
	                .sendKeys(string)
	                .build();

	        fillEmailInputField.perform();
		}
		
		public static void KeyDownUp(WebDriver driver,WebElement element, String string1, String string2) {
			Actions actions = new Actions(driver);
			 Action firstNameActionPart1 = actions.moveToElement(element)
                     .click()
                     .sendKeys(string1)
                     .keyDown(Keys.SHIFT)
                     .sendKeys(string2)
                     .keyUp(Keys.SHIFT)
                     .build();
			 firstNameActionPart1.perform();
		}
		
			

		//ventana nueva 
		public static void newVentana(WebDriver driver) {
			
			String ventana = driver.getWindowHandle();
			Set<String> ventana2 = driver.getWindowHandles();
			Iterator <String> i2 = ventana2.iterator();
			
			while(i2.hasNext()) {
				String p2 = i2.next();
				ventana.equals(p2);
				driver.switchTo().window(p2);
			}
		}
		//Select - value
		public static void selectValue(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
		//Select - visibleText
		public static void SelectText(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
		//Select - ByIndex
		public static void SelectByIndex(WebElement element, int value) {
			Select select = new Select(element);
			select.selectByIndex(value);
		}
		
		
		
		/***
		 * continuar 
		 * */
		//Verficar titulo
		public static void AssertText(String name, WebElement title) {
			
			Assert.assertEquals(name, title.getText());
		}
	
		//alerta simple - acpetar
		@SuppressWarnings("unlikely-arg-type")
		public static void alertAccept(WebDriver driver) {
			Alert alerta = driver.switchTo().alert();
			String alertMessge = driver.switchTo().alert().getText();
			// mostramos el alert
			System.out.println("alerta: " + alertMessge);
			alertMessge.equals(alerta);
			//aceptamos alert
			alerta.accept();
		}
		//alerta-simple - cancelar
		@SuppressWarnings("unlikely-arg-type")
		public static void alertCancel(WebDriver driver) {
			Alert alerta = driver.switchTo().alert();
			String alertMessge = driver.switchTo().alert().getText();
			// mostramos el alert
			System.out.println("alerta: " + alertMessge);
			alertMessge.equals(alerta);
			//aceptamos alert
			alerta.dismiss();
		}
		@SuppressWarnings("unlikely-arg-type")
		public static void alertString(WebDriver driver, String string) {
			Alert alerta = driver.switchTo().alert();
			String alertMessge = driver.switchTo().alert().getText();
			// mostramos el alert
			System.out.println("alerta: " + alertMessge);
			alertMessge.equals(alerta);
			alerta.sendKeys(string);
			alerta.accept();
		}
		
}
