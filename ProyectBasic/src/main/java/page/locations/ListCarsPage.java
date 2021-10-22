package page.locations;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ListCarsPage {
	@FindBy(xpath = "//div[@class='no-results-filters-row row']")
	public WebElement listaCars;
	
	
}
