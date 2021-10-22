package practico17;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "E:/manue/Eclipse/SeleniumAcademy/CursoSelenium/src/test/java/practico17",
        glue = "practico17/Steps",
        
        plugin = {"pretty"},//va a mostrar todos en cada metodo en sus steps
        tags = "@CRM" // solo se ejecutara los escenarios que tenga esta anotacion

)
public class Runner {

}
