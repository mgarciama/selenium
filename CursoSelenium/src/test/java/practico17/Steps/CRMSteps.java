package practico17.Steps;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import practico17.PageObject.LandingPage;


public class CRMSteps extends BaseSteps {
	@When("hago click en CRM")
    public void hago_click_en_crm() {
        landingPage = new LandingPage(driver);
        crmPage = landingPage.goToCrmPage();
    }

    @Then("ingreso a la pagina de CRM")
    public void ingreso_a_la_pagina_de_crm() {
        Assert.assertEquals(crmPage.getPageUrl(), "https://www.salesforce.com/mx/crm/", "Se esperaba otra URL");
        Assert.assertTrue(crmPage.getPageUrl().contains("crm"));
    }

    @Then("encuentro informacion sobre los CRM")
    public void encuentro_informacion_sobre_los_crm() {
        Assert.assertEquals(crmPage.getTextById("que-es-crm"), "¿Qué es CRM?", "Se esperaba otro elemento");
        crmPage.closeDriver();
    }
}
