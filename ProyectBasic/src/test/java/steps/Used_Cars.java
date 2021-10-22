package steps;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import page.actions.HomePageActions;
import page.actions.SearchPageActions;
import page.actions.UsedPageActions;

public class Used_Cars {
	
	UsedPageActions used = new UsedPageActions();
	HomePageActions home = new HomePageActions();
	
	@And("^hacemos click a \"([^\"]*)\" para el menu used$")
	public void hacemos_click_a(String used) throws Throwable {
		System.out.println(used);
		home.clickUsed();
	}
	
	@Then("^verificamos que estemos en la pagina \"([^\"]*)\" used$")
	public void verificamos_que_estemos_en_la_pagina(String title) throws Throwable {
	    used.title(title);
	}

	@And("^Y seleccionamos Any Make por \"([^\"]*)\" used$")
	public void y_seleccionamos_Any_Make_por(String value) throws Throwable {
	    used.selectMake(value);
	}
	
	@And("^select car model used$")
	public void select_car_model(List<String> list) throws Throwable {
	   String menu = list.get(1);
	   used.selector(menu);
	   
	}
	
	@And("^Seleccionamos Any Location as \"([^\"]*)\" used$")
	public void seleccionamos_Any_Location_as(String value) throws Throwable {
	    used.selectLocations(value);
	}
	@And("^Selecionamos Price por \"([^\"]*)\" used$")
	public void selecionamos_Price_por(String value) throws Throwable {
	    used.selectPrice(value);
	}
	
	@And("^Hacemos click a Find_My_Next_Cars used$")
	public void hacemos_click_a_Find_My_Next_Cars() throws Throwable {
	    used.clickFindCars();
	}
	@And("^pagina deberia aparecer \"([^\"]*)\" used$")
	public void pagina_deberia_aparecer(String title)throws Throwable {
		used.titleFinal(title);
		}
	
}
