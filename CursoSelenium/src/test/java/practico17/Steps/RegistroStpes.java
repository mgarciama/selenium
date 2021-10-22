package practico17.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistroStpes extends BaseSteps{
	@When("ingreso a la seccion de registrarse")
    public void ingreso_a_la_seccion_de_registrarse() {
        //driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        registrationPage = landingPage.goToRegistrationPage();
    }

    @Then("puedo completar todos los campos del registro")
    public void puedo_completar_todos_los_campos_del_registro() {
        registrationPage.fillRegistrationFields();
        registrationPage.closeDriver();
    }
}
