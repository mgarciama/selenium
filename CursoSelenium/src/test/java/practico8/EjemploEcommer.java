package practico8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.SeleniumDriver;

public class EjemploEcommer {

	String URL = "http://automationpractice.com/index.php";
	protected WebDriver driver;


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
		//Ejecutar con interfaz grafica
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get(URL);
	
	
	}


	@Test(description = "ejemplos con Actions", enabled = true, priority = 1)
    public void registrationTest(){
        WebElement loginBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']"));
        SeleniumDriver.hoverClick(driver, loginBtn, loginBtn);
       

        String email = "selenium" + Math.random() + "@gmail.com";
        WebElement emailInputField = driver.findElement(By.id("email_create"));

        
        SeleniumDriver.HoverWrite(driver, emailInputField,email);


        WebElement submitBtn = driver.findElement(By.id("SubmitCreate"));

        SeleniumDriver.hoverClick(driver, submitBtn, submitBtn);
//
        WebElement firstNameElement = driver.findElement(By.id("customer_firstname"));
        WebElement lastNameElement = driver.findElement(By.id("customer_lastname"));
        WebElement passElement = driver.findElement(By.id("passwd"));
        SeleniumDriver.KeyDownUp(driver, firstNameElement, "manu","el");
        SeleniumDriver.HoverWrite(driver, lastNameElement, "apellidos");
        SeleniumDriver.HoverWrite(driver, passElement, "holaaaa mundoooooooooooo");



    }
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		 Thread.sleep(3000);
		//driver.close();
		
	}
}
