package practica9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverHelper_Test {
	
	 //Que retorne una lista de elementos que recibe por parámetro, que contengan ids 
	
	 public static List<WebElement> getElementsWithIds(WebDriver driver, String tag) {
		 List<WebElement> elements = driver.findElements(By.tagName(tag));
		 List<WebElement> WitchIds = new ArrayList<>();
		 for (WebElement e : elements) {
			if (e.getAttribute("id").isEmpty() == false) {
				WitchIds.add(e);
				
			}
		}
		
		 return WitchIds;
	 }
	 //Que retorne una lista de elementos que recibe por parámetro, que contengan el atributo name con valor
	 public static List<WebElement> getElementsWithNames(WebDriver driver, String tag) {
		 List<WebElement> elements = driver.findElements(By.tagName(tag));
		 List<WebElement> WitchName = new ArrayList<>();
		 for (WebElement e : elements) {
			if (e.getAttribute("name").isEmpty() == false) {
				WitchName.add(e);
				System.out.println("name "+ WitchName);
				
			}
		}
		
		 return WitchName;
	 }
	 
	 public static WebElement getElementByName(String name, WebDriver driver) {
	        return driver.findElement(By.name(name));
	    }

	    public static WebElement getElementByXPath(String attr, String value, WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@" + attr + "='" + value + "']"));
	    }
	
}
