package practica3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import util.SeleniumDriver;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerTest {
	
	 WebDriver driver;
		
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
			//String url = "http://automationpractice.com/index.php";
			String url = "http://automationpractice.com/index.php";
			// navegamos a google
			driver.get(url);
		
		
		}

		@Test(description = "registro", enabled = false, priority = 1)
		public void primerTest() throws InterruptedException {
			Faker fake = new Faker();
			String firstName = fake.name().firstName();
			registroToSite(firstName );
			Thread.sleep(3000);
			
			WebElement informationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));

			informationBtn.click();
			

			WebElement nameInput = driver.findElement(By.id("firstname"));
			System.out.println("name: " + firstName + " = listInput "+nameInput.getAttribute("value"));
	
			 
		}
		
		@Test(description = "login", enabled = false, priority = 2)
		public void login() {
			String email = "mPrueba@gmail.com";
			String password = "147258369";
		
			
			//entramos el login de entrada
			WebElement login = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
			login.click();
			//href="http://automationpractice.com/index.php?
//			WebElement loginOut = driver.findElement(By.xpath("//*[@href=\'http://automationpractice.com/index.php?']"));
//			loginOut.click();
			
			//registro usuer
			
			WebElement emailInput = driver.findElement(By.id("email"));
			emailInput.sendKeys(email);
			WebElement passwordinput = driver.findElement(By.id("passwd"));
			passwordinput.sendKeys(password);
			
		}
		
		@Test
		public void registroValidation() {
			String email = "mPrueba@gmail.com";
			//entramos el login de entrada
			WebElement login = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
			login.click();
			
			//email
			driver.findElement(By.id("email_create")).sendKeys(email);
			driver.findElement(By.name("SubmitCreate")).click();
			SeleniumDriver.sleepSeconds(5);
			WebElement mensajeError = driver.findElement(By.xpath("(//ol/li)[2]"));
			System.out.println(mensajeError.getText());
			
			
		}
		
		private void registroToSite(String firstName ) {
			Faker fake = new Faker();
			 firstName = fake.name().firstName();
			String lastName = fake.name().lastName();
			//Fake es una libreria para obtener datos para formularios
			
			
			//entramos el login de entrada
		WebElement login = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		login.click();
		//validamos la pagina del login
		WebElement authentication = driver.findElement(By.tagName("h1"));
		Assert.assertEquals("AUTHENTICATION",authentication.getText());
		System.out.println("titulo "+ driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Login"));
		
		String email = "Manu" + Math.random() + "@gmail.com";
		//String email = "mPrueba@gmail.com";
		
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.name("SubmitCreate")).click();
	//vamos a la siguiente pantalla
		
//		WebElement tituloValidation = driver.findElement(By.tagName("h1"));
//		System.out.println("va "+ tituloValidation.getText());
//		Assert.assertEquals("AUTHENTICATION",tituloValidation.getText());
		SeleniumDriver.sleepSeconds(3);
		
		List <WebElement> input = driver.findElements(By.tagName("input"));
		List <WebElement> select = driver.findElements(By.tagName("select"));
	
			input.get(4).click();
			input.get(6).sendKeys(firstName);
			input.get(7).sendKeys(lastName);
			System.out.println("email: " + email + " = listInput "+input.get(8).getAttribute("value"));
			Assert.assertEquals(email,input.get(8).getAttribute("value"));
			input.get(9).sendKeys("147258369");
			//form.get(10).click();
			
			SeleniumDriver.SelectByIndex(select.get(0), 23);
			SeleniumDriver.SelectByIndex(select.get(1), 12);
			SeleniumDriver.selectValue(select.get(2), "1990");
			
			input.get(12).sendKeys(fake.name().firstName());
			input.get(13).sendKeys(fake.name().lastName());
			input.get(14).sendKeys(fake.company().bs());
			input.get(15).sendKeys(fake.address().streetAddress() + fake.address().streetAddressNumber());
			input.get(17).sendKeys(fake.address().city());
			
			SeleniumDriver.selectValue(select.get(3), "1");
			input.get(18).sendKeys("13170");
			
			WebElement textOpcional = driver.findElement(By.id("other"));
			
			textOpcional.sendKeys(fake.lorem().characters());
			input.get(20).sendKeys("661260572");
			input.get(21).clear();
			input.get(21).sendKeys("mgarciam");
			
			WebElement btn = driver.findElement(By.id("submitAccount"));
			btn.click();
		
			SeleniumDriver.sleepSeconds(3);
			WebElement informationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));

			informationBtn.click();
			SeleniumDriver.sleepSeconds(3);
			//SeleniumDriver.newVentana(driver);
			
//			input.get(6).sendKeys(fake.name().firstName());
//			input.get(7).sendKeys(fake.name().lastName());
//			System.out.println("email: " + email + " = listInput "+input.get(8).getAttribute("value"));
		
			
			WebElement nameInput = driver.findElement(By.id("firstname"));
			System.out.println("name: " + firstName + " = listInput "+nameInput.getAttribute("value"));
		}
	
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
			
		}

}
