package Spotify.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Registrar {
	public WebDriver driver;
	public Registrar(WebDriver remoteDriver){
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
    }
}
