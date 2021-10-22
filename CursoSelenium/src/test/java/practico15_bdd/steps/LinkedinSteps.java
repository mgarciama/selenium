package practico15_bdd.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkedinSteps {
	@Given("^estoy en la pagina de linkedin$")
	public void estoy_en_la_pagina_de_linkedin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("entro en el linkedin");
	}

	@When("^ingreso mi email correctamente$")
	public void ingreso_mi_email_correctamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("ingreso el email correctamente");
	}

	@And("^ingreso mi contrasena correctamente$")
	public void ingreso_mi_contrasena_correctamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("ingreso la contraseña correctamente");
	}

	@Then("^entro a la cuenta$")
	public void entro_a_la_cuenta() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("entro en mi cuenta");
	}

	@When("^ingreso mi email incorrectamente$")
	public void ingreso_mi_email_incorrectamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("ingreso el email mal");
	}

	@Then("^se despliega un error de login$")
	public void se_despliega_un_error_de_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("KO login");
	}

	@And("^ingreso mi contrasena incorrectamente$")
	public void ingreso_mi_contrasena_incorrectamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("contraseña mal");
	}
	@Then("^se despliega un error de login \"([^\"]*)\"$")
	public void se_despliega_un_error_de_login(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("mostrar "+ arg1);
		
	}

}