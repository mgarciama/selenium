package practico17.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	   public WebDriver driver;

	    public String getPageTitle(){
	        return driver.getTitle();
	    }

	    public String getPageUrl(){
	        return driver.getCurrentUrl();
	    }

	    public void closeDriver(){
	        driver.close();
	    }

	    public int getAmountOfH1(){
	        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
	        return listaH1s.size();
	    }
}
