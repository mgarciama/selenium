package Spotify.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PlanPremium {
	public WebDriver driver;
	@FindBy(tagName  = "h3")
	public WebElement listados;
	//
	@FindBy(xpath  = "//div/a/div/span[contains(text(),'comenzar')]")
	public WebElement btnComenzar;
	public PlanPremium(WebDriver remoteDriver){
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
    }
	
	public boolean getPremium() {
		
		//System.out.println(""+driver.getTitle());
		
		return  driver.getCurrentUrl().contains("Spotify Premium - Spotify (UY)");
		
	}
	public void listaPlan() {
		System.out.println(listados.getText());
	}
	public void btnComenzar() {
		btnComenzar.click();
	}
}
