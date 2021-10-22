package funciones;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Squery {
	
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReport;
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
	public static void move(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		Action mouseOverHome = actions.moveToElement(element).build();
		mouseOverHome.perform();
		
	}
	//hoverClick
	public static void hoverClick(WebDriver driver, WebElement move, WebElement click) {
		Actions actions = new Actions(driver);
		Action mouseOverHome = actions.moveToElement(move).moveToElement(click).build();
		mouseOverHome.perform();
		
	}
	//dobleClick
	public static void doubleClick(WebDriver driver, WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
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
		//Verficar
		public static void AssertText(String name, WebElement title) {
			
			Assert.assertEquals(name, title.getText());
		}
		//alerta simples
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
		//buscar más información
		public static void report(String nombreHtml) {
			
			//decimos lo que creamos
			 htmlReport = new ExtentHtmlReporter(nombreHtml);
			//creamos el archivo
			 extent = new ExtentReports();
			extent.attachReporter(htmlReport);
		}
		public static void log (String titulo, String description, String información) {
			
			  ExtentTest testReport =
						extent.createTest(titulo, description);
			  testReport.log(Status.INFO, información);
		}
		public static void info (String titulo, String description) {
			  ExtentTest testReport =
						extent.createTest(titulo, description);
			  testReport.info("test passed/ test completo");
			
		}
}
