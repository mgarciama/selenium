package page.locations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	@FindBy(how = How.LINK_TEXT, using = "buy + sell")
	public WebElement MenuBullSell;
	@FindBy(how = How.LINK_TEXT, using = "Search Cars")
	public WebElement MenuSearchCars;
	@FindBy(how = How.LINK_TEXT, using = "Sell my car")
	public WebElement MenuSellCar;
	@FindBy(how = How.LINK_TEXT, using = "Used")
	public WebElement MenuUsed;
	@FindBy(how = How.XPATH, using ="//h1")
	public WebElement titlePrincipal;
	//New & Used Car Search - carsguide
}
