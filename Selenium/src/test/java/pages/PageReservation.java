package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {

	private WebDriver driver;
	private By titleText;

	private By PassangerDrop;
	private By FromDrop;
	private By ArrivingDrop;

	public PageReservation(WebDriver driver) {

		this.driver = driver;
		titleText = By.xpath(
				"(/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr/td/font/font/b/font/font)[1]");
		PassangerDrop = By.name("passCount");
		FromDrop = By.name("fromPort");
		ArrivingDrop = By.name("toPort");
	}

	public void assertPage() {

		Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Details"));
	}

	// marcamos un select
	public void selectePassenger(int cant) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(PassangerDrop));

		Select selectPassenger = new Select(cantidadPasajeros);
		// Select selectPassenger = new Select(driver.findElement(PassangerDrop));
		// pasamos la cantidad de pasageros
		selectPassenger.selectByVisibleText(Integer.toString(cant));

	}

	public void selectFromPort(int i) {
		Select selectFrom = new Select(driver.findElement(FromDrop));
		// pasamos la cantidad de pasageros
		selectFrom.selectByIndex(i);
	}

	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(ArrivingDrop));
		selectTo.selectByValue(city);
	}

}
