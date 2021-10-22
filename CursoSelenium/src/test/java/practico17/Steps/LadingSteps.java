package practico17.Steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Then;

public class LadingSteps extends BaseSteps {
	 @Then("encuentro un solo h1")
	    public void encuentro_un_solo_h1() {
	        //List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
	        Assert.assertEquals(landingPage.getAmountOfH1(), 1, "Se esperaba un unico h1");
	        landingPage.closeDriver();
	    }

}
