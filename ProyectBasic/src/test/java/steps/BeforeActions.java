package steps;

import cucumber.api.java.Before;
import util.SeleniumDriver;

public class BeforeActions {

	@Before
	public static void setUp() {
		//llamamos al chromeDriver
		SeleniumDriver.setUpDriver();
		
	}
	
}
