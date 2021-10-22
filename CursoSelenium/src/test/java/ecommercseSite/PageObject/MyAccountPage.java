package ecommercseSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
public WebDriver driver;

@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
public WebElement logoutBtn;
	
	public MyAccountPage(WebDriver remoteDriver) {
		this.driver = remoteDriver;
	}
	
	public void clickLogoutBtn() {
		  logoutBtn.click();
	}
}
