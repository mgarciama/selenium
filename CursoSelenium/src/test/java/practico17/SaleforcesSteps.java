package practico17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommercseSite.PageObject.LandingPage;
import practico17.PageObject.CRMPage;
import util.SeleniumDriver;

public class SaleforcesSteps {
	public WebDriver driver;
	private LandingPage landingPage;
	private CRMPage CrmPage; 
	
	@Given("^estoy en la pagina de Salesforce$")
	public void estoy_en_la_pagina_de_Salesforce() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 //landingPage = new LandingPage(driver);
	}

	@When("^hago click en CRM$")
	public void hago_click_en_CRM() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement aceptarCoock = driver.findElement(By.id("onetrust-accept-btn-handler"));
	    SeleniumDriver.sleepSeconds(2);
	    if (aceptarCoock.isEnabled()) {
			aceptarCoock.click();
			//SeleniumDriver.sleepSeconds(5);////a[@href='mx/crm/']
			WebElement CRM = driver.findElement(By.xpath("//a[@href='/es/learning-centre/crm/what-is-crm/']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", CRM);
			//CRM.click();
			SeleniumDriver.sleepSeconds(5);
			//SeleniumDriver.newVentana(driver);
			
		}
	}

	@Then("^ingreso a la pagina de CRM$")
	public void ingreso_a_la_pagina_de_CRM() throws Throwable {
	    // buscamos el titulo y la url
		System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.salesforce.com/es/learning-centre/crm/what-is-crm/");
		//Assert.assertTrue(false, driver.getCurrentUrl().concat("crm"));
	   
	}

	@And("^encuentro informacion sonre los CRM$")
	public void encuentro_informacion_sonre_los_CRM() throws Throwable {
	    //encontramos mensajes o textos sobre los CRM
		WebElement infoCRM = driver.findElement(By.id("que-es-la-crm"));
		System.out.println("teto CRM:  "+infoCRM.getText());
		Assert.assertEquals(infoCRM.getText(), "¿Qué es la CRM?");
	 
	}

	@When("^ingreso a la session de registrase$")
	public void ingreso_a_la_session_de_registrase() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
	  driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");	
	  WebElement aceptarCoock = driver.findElement(By.id("onetrust-accept-btn-handler"));
	    SeleniumDriver.sleepSeconds(2);
	    if (aceptarCoock.isEnabled()) {
	    	aceptarCoock.click();
	    }
	  
	  }

	@Then("^puedo completar todos los campos del registro$")
	public void puedo_completar_todos_los_campos_del_registro() throws Throwable {
		Faker faker = new Faker();
		driver.findElement(By.name("UserFirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("UserLastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("UserTitle")).sendKeys(faker.job().title());
        driver.findElement(By.name("UserEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("UserPhone")).sendKeys("666666666");
        driver.findElement(By.name("CompanyName")).sendKeys("Salesforce");

        WebElement industryElement = driver.findElement(By.name("Lead.Industry"));
        Select industrySelect = new Select(industryElement);
        industrySelect.selectByVisibleText("Otro");
	}



	@When("^obtengo los H(\\d+)s$")
	public void obtengo_los_H_s(int arg1) throws Throwable {
		 List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
		 Assert.assertEquals(listaH1s.size(), "se encuentro un unico h1");
	   
	}

	@Then("^encuentro un solo h(\\d+)$")
	public void encuentro_un_solo_h(int arg1) throws Throwable {
	   
	 
	}
}
