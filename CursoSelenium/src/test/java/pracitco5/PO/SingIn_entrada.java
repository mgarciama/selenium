package pracitco5.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingIn_entrada {
	public WebDriver driver;
	@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
	public WebElement informationBtn;
	
	public SingIn_entrada(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		  PageFactory.initElements(remoteDriver, this);
	}

	public Authentication clickSingIn() {
		
		informationBtn.click();
		
		Authentication authentication = new Authentication(driver);
		return authentication;
	}
	public String getSingIn() {
		System.out.println("inf: "+informationBtn.getText());
		return informationBtn.getText();
	}
}
