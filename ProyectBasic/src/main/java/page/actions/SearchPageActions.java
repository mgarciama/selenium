package page.actions;

import org.openqa.selenium.support.PageFactory;

import page.locations.SearchPage;
import util.SeleniumDriver;

public class SearchPageActions {

	SearchPage search = null;
	
	public SearchPageActions() {
		this.search = new SearchPage();
		PageFactory.initElements(SeleniumDriver.getDriver(), search);
	}
	public void title() {
		String name = "New & Used Car Search - carsguide";
		SeleniumDriver.AssertText(name, search.titlePrincipal);
	
	}
	public void selectMake(String value) {
		SeleniumDriver.selectValue(search.SelectMake, value);
	}
	public void selectModels(String value) {
		SeleniumDriver.selectValue(search.SelectModels, value);
	}
	public void selectLocations(String value) {
		SeleniumDriver.selectValue(search.SelectLocations, value);
	}
	public void selectPrice(String value) {
		SeleniumDriver.SelectText(search.SelectPrice, value);
	}
	public void clickFindCars() {
		search.ClickFindMyCars.click();
	}
	
}
