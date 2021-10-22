package carsGuide.Reusable;

import org.openqa.selenium.WebDriver;

import carsGuide.POLogin.LoginPO;
import carsGuide.POLogin.PaginaInicioPO;

public class RS {
	public static  WebDriver driver;
	
	public static LoginPO menuLogin(WebDriver driver, String name) {
		LoginPO lgPO = new LoginPO(driver);
		switch (name) {
		case "Sign up / Sign in":
			lgPO.signUpIn();
			break;

		case "buy + sell":
			
			break;
		default:
			break;
		}
		return lgPO;
	}
	public static PaginaInicioPO menuPrincipal(WebDriver driver, String name) {
		PaginaInicioPO pg = new PaginaInicioPO(driver);
		switch (name) {
	
		case "buy + sell":
			pg.menuHoverBuySell();
			break;
		default:
			break;
		}
		return pg;
	}
	
}
