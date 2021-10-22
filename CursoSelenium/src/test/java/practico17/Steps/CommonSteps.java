package practico17.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

public class CommonSteps extends BaseSteps{
	 @Given("estoy en la pagina de Salesforce")
	    public void estoy_en_la_pagina_de_salesforce() {
		 String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.salesforce.com");
			driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    }
}
