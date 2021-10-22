package ecommercseSite.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
String mensaje = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
String url = "http://automationpractice.com/index.php";
public WebDriver driver;

@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
public WebElement informationBtn;

@FindBy(tagName = "input")
public List<WebElement> input;

@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
public WebElement logoutBtn;

@FindBy(xpath = "//input[@id='email']")
public WebElement inputEmail;

@FindBy(id = "passwd")
public WebElement inputPassword;

@FindBy(id = "SubmitLogin")
public WebElement loginBtn;

@FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
public WebElement userNameBtn;

@FindBy(id = "create_account_error")
public WebElement mensajeError;

@FindBy(tagName  = "h1")
public WebElement myAccountH1;


@BeforeMethod
public void setUpTest() throws Exception {
	
	// cargamos el directorio para poder navegar
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",
			projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	// ejecuta sin interface grafica
	//ChromeOptions chromeOptions = new ChromeOptions();
//	chromeOptions.addArguments("--headless");
//	driver = new ChromeDriver(chromeOptions);
	driver = new ChromeDriver();

	// navegamos a google
	driver.get(url);
	//Ejecutar con interfaz grafica
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     PageFactory.initElements(driver, this);


}

@AfterMethod
public void tearDown(ITestResult result) throws InterruptedException {
	Thread.sleep(3000);
	driver.close();
	
}
}
