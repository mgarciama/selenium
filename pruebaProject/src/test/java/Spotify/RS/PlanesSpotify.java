package Spotify.RS;

import org.openqa.selenium.WebDriver;

import Spotify.po.PlanPremium;

public class PlanesSpotify {
	public static  WebDriver driver;
	
	public static void pulsarPlaneSpotify(WebDriver driver, String name) {
		PlanPremium plPremium = new PlanPremium (driver);
		switch (name) {
		case "Individual":
			plPremium.btnComenzar();
			break;
		}
	}
}
