package pagesLogin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import funciones.Screenshooter;
import funciones.Squery;

public class PO_Formulario {

	private WebDriver driver;
	@FindBy(xpath = "//h1[@class='page-heading']")
	private WebElement title;
	@FindBy(xpath = "//form//div//input")
	private List<WebElement> formulario;
	@FindBy (id = "days")
	private WebElement selectDay;
	
	
	public PO_Formulario(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void assertPage() {

		Assert.assertEquals("CREATE AN ACCOUNT", title.getText());
	}
	public void formulario(String name, String surname, String email, String password, String value) {
		Squery.newVentana(driver);
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		Squery.sleepSeconds(3);
		assertPage();
		
		//formulario
	
		String[] form = new String[formulario.size()];
		int i = 0;
		for(WebElement e : formulario) {
			Squery.sleepSeconds(2);
			form[i] = e.getText();
			if(i <=1) {
				e.click();
			} else if(i <=2) {
				e.sendKeys(name);
			} else if(i <=3) {
				e.sendKeys(surname);
			} else if(i <= 4) {
				e.sendKeys(email);
			} else if (i <= 5) {
				e.sendKeys(password);
			} else if (i <= 6) {
				Squery.selectValue(selectDay, value);
			}
			i ++;
			Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		}
		
	}
}
