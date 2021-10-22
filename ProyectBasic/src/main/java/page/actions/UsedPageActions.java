package page.actions;

import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.locations.UsedPage;
import util.SeleniumDriver;

public class UsedPageActions {
	
public static UsedPage used = null;

public UsedPageActions() {
	this.used = new UsedPage();
	PageFactory.initElements(SeleniumDriver.getDriver(), used);
	
}
 public void selector(String value) {
	 SeleniumDriver.SelectText(used.SelectModelDr, value);
 }
 public void selectMake(String value) {
		SeleniumDriver.selectValue(used.SelectMake, value);
	}
public void selectLocations(String value) {
	SeleniumDriver.selectValue(used.SelectLocations, value);
}
public void selectPrice(String value) {
	SeleniumDriver.SelectText(used.SelectPrice, value);
}
public void clickFindCars() {
	used.ClickFindMyCars.click();
}
 public void title(String actual) {
	 
	 Assert.assertEquals(actual, used.titleUsed.getText());
 }
 
 public void titleFinal(String title) {
	 String actualtitle =
		SeleniumDriver.getDriver().getTitle();
			Assert.assertEquals(actualtitle, title);
	    System.out.println("titulo " + title +"actual" + actualtitle);
 }
 
}
