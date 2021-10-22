package Spotify.Steps;


import org.testng.Assert;
import org.testng.annotations.Test;

import Spotify.RS.PlanesSpotify;
import Spotify.po.PlanPremium;
import Spotify.po.Principal;


public class PlanIndividualSteps extends BaseTest {

	@Test
	public void comprobarIndividual() {
		Principal pr = new Principal(driver);
		
		PlanPremium plnPremium = pr.pulsarbtnPremium();
		
		Assert.assertFalse(plnPremium.getPremium());
		
		PlanesSpotify.pulsarPlaneSpotify(driver, "Individual");
		
	}
	
	
}
