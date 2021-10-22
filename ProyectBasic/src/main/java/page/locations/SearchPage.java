package page.locations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {
	@FindBy(how=How.XPATH,using = "//h1")
	public WebElement titlePrincipal;
	@FindBy(how=How.XPATH,using = "//select[@id='makes']")
	public WebElement SelectMake;
	@FindBy(how=How.XPATH,using = "//select[@id='models']")
	public WebElement SelectModels;
	@FindBy(how=How.XPATH,using = "//select[@id='locations']")
	public WebElement SelectLocations;
	@FindBy(how=How.XPATH,using = "//select[@id='priceTo']")
	public WebElement SelectPrice;
	@FindBy(how=How.XPATH,using = "//input[@id='search-submit']")
	public WebElement ClickFindMyCars;
	
	
}
