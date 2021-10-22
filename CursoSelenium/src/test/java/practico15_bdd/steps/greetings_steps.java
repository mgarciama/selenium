package practico15_bdd.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class greetings_steps {
	 @Given("entro a un bar")
	    public void entro_a_un_bar() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("He entrado al bar!!");
	    }

	    @When("encuentro personas")
	    public void encuentro_personas() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Me encuentro con personas!!");
	    }

	    @Then("las saludo")
	    public void las_saludo() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Las voy a saludar!!");
	    }

	    @When("encuentro mesa libre")
	    public void encuentro_mesa_libre() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Encuentro mesa libre!!");
	    }

	    @Then("tomo asiento")
	    public void tomo_asiento() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Tomo asiento!!");
	    }

	    @When("tengo sed")
	    public void tengo_sed() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Tengo sed");
	    }

	    @Then("pido una bebida")
	    public void pido_una_bebida() {
	        // Write code here that turns the phrase above into concrete actions
	        System.out.println("Pido una bebida");
	    }
	
}
