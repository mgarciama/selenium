package pracitco5.PO;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInformation {
	public WebDriver driver;
	@FindBy(tagName = "input")
	public List<WebElement> input;
	public MyPersonalInformation(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	public String getRegistreNameValue() {
		return input.get(6).getAttribute("value");
	}
	public String getRegistreLastNameValue() {
		return input.get(7).getAttribute("value");
	}
	public String getRegistreEmailValue() {
		System.out.println("email_get"+input.get(8).getAttribute("value"));
		return input.get(8).getAttribute("value");
	}
	
}
