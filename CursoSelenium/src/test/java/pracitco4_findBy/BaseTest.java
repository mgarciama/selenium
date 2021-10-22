package pracitco4_findBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	String url = "https://www.netflix.com/es/login?nextpage=https%3A%2F%2Fwww.netflix.com%2Fbrowse";
	 public WebDriver driver;
	 	@FindBy(tagName = "p")
	 	public List<WebElement> listaParrafos;
		@FindBy(tagName = "a")
		public List<WebElement> listaLinks;
		@FindBy(tagName = "button")
		public List<WebElement> ListaBtns;
		@FindAll({
			@FindBy(how = How.TAG_NAME, using = "h1"),
			@FindBy(how = How.TAG_NAME, using = "h2"),
			@FindBy(how = How.TAG_NAME, using = "h3")
		})
		public List<WebElement> getAllHs;
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
