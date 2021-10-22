package pracitco5.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pracitco5.utils.Constants;
import util.SeleniumDriver;

import java.util.List;

public class CreateAccount {
	public WebDriver driver;
	@FindBy(tagName = "input")
	public List<WebElement> input;
	@FindBy(tagName = "select")
	public List<WebElement> select;
	@FindBy(id = "passwd")
	public WebElement password;
	@FindBy(id = "submitAccount")
	public WebElement submitAccount;
	@FindBy(id = "other")
	public WebElement textOpcional;
	@FindBy(id = "email")
	public WebElement emailInput;
	@FindBy(tagName = "h3")
	public WebElement h3;
	
	public CreateAccount(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getRegistreEmail() {
		System.out.println("email_get"+input.get(8).getAttribute("value"));
		return input.get(8).getAttribute("value");
	}
	
	public MyAccount crearPerfil(String email, String firstName, String lastName, String information) {
		SeleniumDriver.sleepSeconds(5);
		//String dato = "YOUR PERSONAL INFORMATION";
	//	System.out.println(h3.getText());
		//if (h3.equals(dato)) {
			//List <WebElement> input = driver.findElements(By.tagName("input"));
			//List <WebElement> select = driver.findElements(By.tagName("select"));
			//if (h3.getText().contains(dato)) {
				input.get(4).click();
				input.get(6).sendKeys(firstName);
				input.get(7).sendKeys(lastName);
				
				//validamos el correo que hemos puesto
				//System.out.println("email del formulario: "+ input.get(8).getAttribute("value"));
				//Assert.assertEquals(email, input.get(8).getAttribute("value"));
				
				
				//contraseña
			
				password.sendKeys(Constants.PASSWORD);
				//seleccionamos fecha de nacimiento
				SeleniumDriver.SelectByIndex(select.get(0), Constants.BIRTH_DAY);
				SeleniumDriver.SelectByIndex(select.get(1), Constants.BIRTH_MONTH);
				SeleniumDriver.selectValue(select.get(2), Constants.BIRTH_YEAR);
				
				//tu dirección
				input.get(12).sendKeys(Constants.NAME);
				input.get(13).sendKeys(Constants.SURNAME);
				input.get(14).sendKeys(Constants.COMPANY);
				input.get(15).sendKeys(Constants.ADDRESS);
				input.get(17).sendKeys(Constants.CITY);
				SeleniumDriver.selectValue(select.get(3), Constants.STATE);
				input.get(18).sendKeys(Constants.ZIP_CODE);
			
				textOpcional.sendKeys(information);
				input.get(20).sendKeys(Constants.PHONE);
				input.get(21).clear();
				input.get(21).sendKeys(Constants.ALIAS);
				submitAccount.click();
				MyAccount myAccount = new MyAccount(driver);
				return myAccount;
				
				
			//}
			
			
		//}
		
		
	}
}
