package pracitco5.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	public WebDriver driver;
	@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
	public WebElement logoutBtn;
	@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
	public WebElement informacitiontBtn;
	@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
	public WebElement userNameBtn;

	public MyAccount(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public Authentication pulsarLogout() {
		logoutBtn.click();
		Authentication autothentication = new Authentication(driver);
		return autothentication;
	}
	public MyPersonalInformation pulsarInformacion() {
		informacitiontBtn.click();
		MyPersonalInformation myPersonal = new MyPersonalInformation(driver);
		return myPersonal;
	}
	
	public String menuUserValidate() {
		return userNameBtn.getText();
		
	}
}
