package Spotify.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	String url = "https://www.spotify.com/uy/";
	public WebDriver driver;
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
	//driver.close();
	
}
}
