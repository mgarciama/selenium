package practico15_bdd.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.SeleniumDriver;


public class Spotify_Steps {
	public WebDriver driver;
	

	@Given("^me encuentro en el sitio de spotify$")
	public void me_encuentro_en_el_sitio_de_spotify() throws Throwable {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spotify.com/es");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	}
	@Given("^hago click en registrarme$")
	public void hago_click_en_registrarme() throws Throwable {
		SeleniumDriver.sleepSeconds(3);
	   driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	   SeleniumDriver.sleepSeconds(3);
	   driver.findElement(By.xpath("(//li/a)[4]")).click();
	   
	}
	String title;
	@When("^consulto por el titulo de la pagina$")
	public void consulto_por_el_titulo_de_la_pagina() throws Throwable {
		title = driver.getTitle();
		System.out.println("Se consulta por el titulo : " + title);
	}

	@Then("^me muestra el titulo \"([^\"]*)\"$")
	public void me_muestra_el_titulo(String arg1) throws Throwable {
		 Assert.assertEquals(title, arg1);
	        System.out.println("Son iguales!!");
	}

	

	@And("^compoleto el campo email con \"([^\"]*)\"$")
	public void compoleto_el_campo_email_con(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement input = driver.findElement(By.id("email"));
		WebElement input2 = driver.findElement(By.id("confirm"));
		input.sendKeys(arg1);
		input2.sendKeys(arg1);
	}

	@When("^completo el campo password con \"([^\"]*)\"$")
	public void completo_el_campo_password_con(String arg1) throws Throwable {
		WebElement input3 = driver.findElement(By.id("password"));
		
		input3.sendKeys(arg1);
	    
	}

	@And("^completo el alias con \"([^\"]*)\"$")
	public void completo_el_alias_con(String arg1) throws Throwable {
		WebElement input4 = driver.findElement(By.id("displayname"));
		
		input4.sendKeys(arg1);
		
	}

	@And("^hago click en el boton de registrarme$")
	public void hago_click_en_el_boton_de_registrarme() throws Throwable {
		WebElement input5 = driver.findElement(By.xpath("//div/button[@type=\"submit\"]"));
		
		input5.click();
		
	}

	@And("^se crea la cuenta$")
	public void se_crea_la_cuenta() throws Throwable {
	    System.out.println("cuenta creada");
	    
	}

	@And("^se muestra un mensaje de exito$")
	public void se_muestra_un_mensaje_de_exito() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("cuenta creada");
	}


}
