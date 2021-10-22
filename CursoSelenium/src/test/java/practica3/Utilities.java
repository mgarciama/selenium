package practica3;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.SeleniumDriver;



public class Utilities {
		WebDriver driver;

    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
    	}
    
    public void registerAnUser(String email,String firstName, String lastName, String information) throws InterruptedException {
    	
    	signIn();
    	//creamos una cuenta
    	WebElement cuentaEmail = driver.findElement(By.id("email_create"));
    	cuentaEmail.sendKeys(email);
    	driver.findElement(By.id("SubmitCreate")).click();
    	Thread.sleep(3000);
      	Assert.assertTrue(driver.getTitle().contains("Login"));
    	
    
    		//rellenamos formulario
        	List <WebElement> input = driver.findElements(By.tagName("input"));
    		List <WebElement> select = driver.findElements(By.tagName("select"));
    		input.get(4).click();
    		input.get(6).sendKeys(firstName);
    		input.get(7).sendKeys(lastName);
    		
    		//validamos el correo que hemos puesto
    		System.out.println("email del formulario: "+ input.get(8).getAttribute("value"));
    		Assert.assertEquals(email, input.get(8).getAttribute("value"));
			
    		//contraseña
    		WebElement password = driver.findElement(By.id("passwd"));
    		password.sendKeys(Constants.PASSWORD);
    		//seleccionamos fecha de nacimiento
    		SeleniumDriver.SelectByIndex(select.get(0), Constants.BIRTH_DAY);
			SeleniumDriver.SelectByIndex(select.get(1), Constants.BIRTH_MONTH);
			SeleniumDriver.selectValue(select.get(2), Constants.BIRTH_YEAR);
			
			//tu dirección
			input.get(12).sendKeys(Constants.NAME);
			input.get(13).sendKeys(Constants.SURNAME);
			input.get(14).sendKeys(Constants.COMPANY);
			input.get(15).sendKeys(Constants.ADDRESS);
			input.get(17).sendKeys(Constants.CITY);
			SeleniumDriver.selectValue(select.get(3), Constants.STATE);
			input.get(18).sendKeys(Constants.ZIP_CODE);
			WebElement textOpcional = driver.findElement(By.id("other"));
			textOpcional.sendKeys(information);
			input.get(20).sendKeys(Constants.PHONE);
			input.get(21).clear();
			input.get(21).sendKeys(Constants.ALIAS);
			driver.findElement(By.id("submitAccount")).click();
    	
    	
    	
    }
    
		public void signIn() {
			//System.out.println("titulo "+ driver.getTitle());
	    	Assert.assertTrue(driver.getTitle().contains("My Store"));
	    	//click - sing in
			WebElement login = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
			login.click();
	    	//validamos el h1 de la pagina posterior
	    	WebElement h1Auth = driver.findElement(By.tagName("h1"));
	    	//System.out.println(h1Auth.getText());
	    	Assert.assertEquals("AUTHENTICATION",h1Auth.getText());
	    	//validamos si estamos en login:
	     	System.out.println("titulo "+ driver.getTitle());
	    	Assert.assertTrue(driver.getTitle().contains("Login"));
		}
    
}
