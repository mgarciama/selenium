package practico16_bdd_outlined.Orange;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.SeleniumDriver;

public class StepsHelper {

	public static void validateQuickActions(String quicActions, WebDriver driver) {
		List<WebElement> quicActionLists = driver.findElements(By.className("quick-access-item-container"));
		Assert.assertNotEquals(quicActionLists.size(),0);
		SeleniumDriver.sleepSeconds(3);
		boolean quickActionsBoolean = false;
		for (WebElement e : quicActionLists) {
			System.out.println("e "+ e.getText());
			
			if (e.getText().equals("Assign Leave")) {
				quickActionsBoolean = true;
			}
		}
			Assert.assertTrue(quickActionsBoolean);
			driver.close();
	}
	
}
