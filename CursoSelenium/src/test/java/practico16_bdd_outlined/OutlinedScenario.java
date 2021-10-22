package practico16_bdd_outlined;



import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OutlinedScenario {
	
	Integer monto;
	
	@Given("^tengo (\\d+) dolares$")
	public void tengo_dolares(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    monto = arg1;
	}
	@When("^gasto (\\d+) dolares$")
	public void gasto_dolares(int arg1) throws Throwable {
		monto = monto - arg1;
	}
	

	@Then("^me sobran (\\d+) dolares$")
	public void me_sobran_dolares(int arg1) throws Throwable {
		//ssert.assertEquals(monto, arg1, "se esperaba tener un saldo de "+ arg1);
	}
	
}
