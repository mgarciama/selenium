package practico15_bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "E:/manue/Eclipse/SeleniumAcademy/CursoSelenium/src/test/java/practico15_bdd",
        glue = "practico15_bdd/steps",
        
        plugin = {"pretty"},//va a mostrar todos en cada metodo en sus steps
        tags = "@Calculadora" // solo se ejecutara los escenarios que tenga esta anotacion

)
public class Runner {

}
