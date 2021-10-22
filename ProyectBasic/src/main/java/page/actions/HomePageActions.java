package page.actions;

import org.openqa.selenium.support.PageFactory;
import page.locations.HomePage;
import util.SeleniumDriver;

public class HomePageActions {

	HomePage home = null;
	
	public HomePageActions() {
		this.home = new HomePage();
		PageFactory.initElements(SeleniumDriver.getDriver(), home );
	}
	
	
	public void title() {
		String name = "New & Used Car Search - carsguide";
		SeleniumDriver.AssertText(name, home.titlePrincipal);
	}
	
	public void moveToBull(String element) {
		SeleniumDriver.move(SeleniumDriver.getDriver(), home.MenuBullSell);
	}
	
	public void clickSearch() {
		home.MenuSearchCars.click();
	}
	public void clickSell() {
		home.MenuSellCar.click();
	}
	public void clickUsed() {
		home.MenuUsed.click();
	}
	
	
	
}
