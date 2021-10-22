package Spotify.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;





public class Principal {
	public WebDriver driver;
	@FindBy(id = "onetrust-accept-btn-handler")
	public WebElement coocke;
	@FindBy(linkText  = "Premium")
	public WebElement urlPremium;
	public Principal(WebDriver remoteDriver){
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
    }
	
	public PlanPremium pulsarbtnPremium() {
		
		Assert.assertEquals("ACEPTAR COOKIES", coocke.getText());
		if (coocke.isDisplayed()) {
			coocke.click();
		
			urlPremium.click();
		}
		
		
		
		PlanPremium planPremium = new PlanPremium(driver);
	        return planPremium;
	}
}
