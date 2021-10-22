package practico15_bdd.steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Calculadora {
	private int suma;
	private int resta;
	@Given("^tengo una calculadora$")
	public void tengo_una_calculadora() throws Throwable {
	   
	   suma = 0;
	   System.out.println("inicializando . . .");
	}

	@When("^suma (\\d+) y (\\d+)$")
	public void suma_y(int arg1, int arg2) throws Throwable {
		suma = arg1+arg2;
	   System.out.println("suma de"+arg1+"+"+arg2+ " "+suma);
	   
	}

	@Then("^se muestra suma (\\d+)$")
	public void se_muestra_suma(int arg1) throws Throwable {
	    System.out.println("resultado = "+suma);
	    System.out.println("es "+arg1);
	    Assert.assertEquals(arg1,suma);
	   
	}

	@When("^resta (\\d+) y (\\d+)$")
	public void resta_y(int arg1, int arg2) throws Throwable {
		resta = arg1-arg2;
		System.out.println("suma de"+arg1+"+"+arg2+ " "+resta);
	    
	}
	@Then("^se muestra resta (\\d+)$")
	public void se_muestra_resta(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("resultado"+ resta);
		  System.out.println("es "+arg1);
		    Assert.assertEquals(arg1,resta);
	}
}
