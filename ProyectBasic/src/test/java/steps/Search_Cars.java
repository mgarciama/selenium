package steps;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.actions.HomePageActions;
import page.actions.ListCarsPageActions;
import page.actions.SearchPageActions;
import util.SeleniumDriver;

public class Search_Cars {
	
	HomePageActions home = new HomePageActions();
	SearchPageActions search = new SearchPageActions();
	ListCarsPageActions list = new ListCarsPageActions();
	
	@Given("^Estamos en la pagina \"([^\"]*)\" del sitio web CARSGUIDE$")
	public void estamos_en_la_pagina_del_sitio_web_CARSGUIDE(String url) throws Throwable {
	    SeleniumDriver.openPage(url);
	}

	@When("^Nos movemos por el menu$")
	public void nos_movemos_por_el_menu(List<String>list) throws Throwable {
	    String menu = list.get(1);
	    System.out.println(menu);
	    home.moveToBull(menu);
	    
	}

	@And("^hacemos click a \"([^\"]*)\"$")
	public void hacemos_click_a(String search) throws Throwable {
		System.out.println(search);
	   home.clickSearch();
	}

	@Then("^verificamos que estemos en la pagina SerchCars$")
	public void verificamos_que_estemos_en_la_pagina_SerchCars() throws Throwable {
	    search.title();
	}

	@And("^Y seleccionamos Any Make por \"([^\"]*)\"$")
	public void y_seleccionamos_Any_Make_por(String value) throws Throwable {
	    search.selectMake(value);
	}

	@And("^Volvemos a selecionar Select Model por \"([^\"]*)\"$")
	public void volvemos_a_selecionar_Select_Model_por(String value) throws Throwable {
	    search.selectModels(value);
	}

	@And("^Seleccionamos Any Location as \"([^\"]*)\"$")
	public void seleccionamos_Any_Location_as(String value) throws Throwable {
	    search.selectLocations(value);
	}

	@And("^Selecionamos Price por \"([^\"]*)\"$")
	public void selecionamos_Price_por(String value) throws Throwable {
	    search.selectPrice(value);
	}

	@And("^Hacemos click a Find_My_Next_Cars$")
	public void hacemos_click_a_Find_My_Next_Cars() throws Throwable {
	    search.clickFindCars();
	}

	@Then("^Deberia ver la lista de los coches buscados$")
	public void deberia_ver_la_lista_de_los_coches_buscados() throws Throwable {
		list.listado();
	}

	@And("^la pagina deberia aparecer \"([^\"]*)\"$")
	public void la_pagina_deberia_aparecer(String title) throws Throwable {
	   list.Asserttitle(title);
	}


}
