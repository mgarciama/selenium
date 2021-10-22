package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import util.SeleniumDriver;

public class AfterActions {

	@After
	public static void tearDown(Scenario scenario) {
		WebDriver driver = SeleniumDriver.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }
		//llamamos para cerrar navegador
		SeleniumDriver.tearDown();
	}
}
