package page.locations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UsedPage {
	
	@FindBy(how=How.XPATH,using = "//select[@id='models']")
	public WebElement SelectModelDr;
	@FindBy(how=How.XPATH,using = "//select[@id='makes']")
	public WebElement SelectMake;
	@FindBy(how=How.XPATH,using = "//select[@id='locations']")
	public WebElement SelectLocations;
	@FindBy(how=How.XPATH,using = "//select[@id='priceTo']")
	public WebElement SelectPrice;
	@FindBy(how=How.XPATH,using = "//input[@id='search-submit']")
	public WebElement ClickFindMyCars;
	@FindBy(how=How.XPATH,using = "//h1")
	public WebElement titleUsed;
}
