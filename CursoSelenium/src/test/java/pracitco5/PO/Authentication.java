package pracitco5.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authentication {
	public WebDriver driver;
	@FindBy(tagName = "h1")
	public WebElement h1Auth;
	@FindBy(id = "email_create")
	public WebElement cuentaEmail;
	@FindBy(id = "SubmitCreate")
	public WebElement submitEmail;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement inputEmail;
	@FindBy(id = "passwd")
	public WebElement inputPassword;
	@FindBy(id = "SubmitLogin")
	public WebElement SubmitLogin;
	@FindBy(id = "create_account_error")
	public WebElement mensajeError;
	public Authentication(WebDriver remoteDriver) {
		this.driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAuthentication() {
		//validamos la pagina
		return h1Auth.getText();
	}
	public String getLogin() {
		return driver.getTitle().concat("Login");
	}
	
	public CreateAccount crearEmail(String email) {
		cuentaEmail.sendKeys(email);
		submitEmail.click();
		
		CreateAccount createPerfil = new CreateAccount(driver);
		return createPerfil;
	}
	
	public void registro(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		SubmitLogin.click();
		
		
	}
	public String validateRegistro() {
		return mensajeError.getText();
	}
	
}
