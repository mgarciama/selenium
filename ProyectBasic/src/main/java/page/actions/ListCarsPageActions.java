package page.actions;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.locations.ListCarsPage;
import util.SeleniumDriver;


public class ListCarsPageActions {

	ListCarsPage lista = null;

	public ListCarsPageActions() {
		this.lista = new ListCarsPage();
		PageFactory.initElements(SeleniumDriver.getDriver(), lista );
	}
	
	public void Asserttitle(String title) {
		 String actual_title =
					SeleniumDriver.getDriver().getTitle();
		 			Assert.assertEquals(actual_title, title);
				    System.out.println("titulo " + title +"actual" + actual_title);
	}

	public void listado() {
		List<WebElement> listado = lista.listaCars.findElements(By.xpath("//div[@class='no-results-filters-row row']"));;
		System.out.println("listado" + listado);
		for (int i = 0; i < listado.size(); i++) {
			System.out.println("listado: " + listado.get(i).getText());
			Assert.assertTrue(listado.get(i).getText(), true);
			//Assert.assertTrue(listado.get(i).getText(), true);
		}
	}
}
