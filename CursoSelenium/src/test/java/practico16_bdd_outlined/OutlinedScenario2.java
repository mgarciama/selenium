package practico16_bdd_outlined;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OutlinedScenario2 {
	
	@Given("^estoy en un sitio web$")
	public void estoy_en_un_sitio_web() throws Throwable {
		System.out.println("entro en la web");
	}

	@Given("^me encontre en la pagina principal$")
	public void me_encontre_en_la_pagina_principal() throws Throwable {
		System.out.println("entro la pagina");
	}

	@When("^busco el nombre del usuario MTPE(\\d+)$")
	public void busco_el_nombre_del_usuario_MTPE(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("usuario de MTPE "+ arg1);
	}

	@Then("^recibo un mensaje no se encuentra en el sistema$")
	public void recibo_un_mensaje_no_se_encuentra_en_el_sistema() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("MTP no está en el sistema");
	}

	@When("^busco el nombre del usuario ROX(\\d+)$")
	public void busco_el_nombre_del_usuario_ROX(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("usuario ROX"+ arg1);
	}

	@Then("^recibo un mensaje nombre de usuario invalido$")
	public void recibo_un_mensaje_nombre_de_usuario_invalido() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("ROX es invalido");
	}

	@When("^busco el nombre del usuario MGDL$")
	public void busco_el_nombre_del_usuario_MGDL() throws Throwable {
	  
	}

	@Then("^recibo un mensaje nombre de usuario valido$")
	public void recibo_un_mensaje_nombre_de_usuario_valido() throws Throwable {
	  
	}


}
