package ecommercseSite.test;




import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import practica3.Constants;
import practica3.Utilities;
import util.SeleniumDriver;




public class LoginTest extends BaseTest {
	

		
		

		@Test(description = "registro", enabled = false, priority = 1)
		public void registrarTest() throws InterruptedException {
			 String email = "manu" + Math.random() +"test"+ "@gmail.com";
			 Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName= faker.name().lastName();
			String information = faker.lorem().characters();
			
			//Utilities utilities = new Utilities(driver);
			registerAnUser(email, firstName, lastName,information);
			   SeleniumDriver.sleepSeconds(3);
//			//WebElement informationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));
//			informationBtn.click();
			   SeleniumDriver.sleepSeconds(3);
			//List <WebElement> input = driver.findElements(By.tagName("input"));
			//input.get(6);
//			System.out.println("input "+input.get(6).getAttribute("value"));
//			Assert.assertEquals(firstName, input.get(6).getAttribute("value"));
//			Assert.assertEquals(lastName, input.get(7).getAttribute("value"));
//			Assert.assertEquals(email, input.get(8).getAttribute("value"));
			 
		}
		
		@Test(description = "login", enabled = false, priority = 2)
		public void loginTest() throws InterruptedException {
			 String email = "manu" + Math.random() +"test"+ "@gmail.com";
			 Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName= faker.name().lastName();
			String information = faker.lorem().characters();
			
			Utilities utilities = new Utilities(driver);
			utilities.registerAnUser(email, firstName, lastName,information);
			 //log out....
	       // WebElement logoutBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?mylogout=']"));
	        logoutBtn.click();
	        
	        SeleniumDriver.sleepSeconds(3);
	        System.out.println("pantalla regresión");
	        //login        
	        //WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
	        //WebElement inputPassword = driver.findElement(By.id("passwd"));
	        inputEmail.sendKeys(email);
	        inputPassword.sendKeys(Constants.PASSWORD);
	        System.out.println("before login: "+ driver.getTitle());
	        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
	        loginBtn.click();
	        System.out.println("after login... " + driver.getTitle());
	        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));

	       // WebElement userNameBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']"));
	        System.out.println(userNameBtn.getText());
	        Assert.assertTrue(userNameBtn.getText().contains(firstName));

	       //WebElement myAccountH1 = driver.findElement(By.tagName("h1"));
	        Assert.assertEquals("MY ACCOUNT", myAccountH1.getText());
		}
		@Test(description = "registro de validation", enabled = true, priority = 3)
		public void registroValidation() throws InterruptedException {
			 String email = "manu" + Math.random() +"test"+ "@gmail.com";
			 Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName= faker.name().lastName();
			String information = faker.lorem().characters();
			
			//Utilities utilities = new Utilities(driver);
			registerAnUser(email, firstName, lastName,information);
			SeleniumDriver.sleepSeconds(3);
			 //log out....
	        //WebElement logoutBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?mylogout=']"));
	      //  logoutBtn.click();
	        
	        SeleniumDriver.sleepSeconds(3);
	        System.out.println("pantalla regresión");
			
			//email
			driver.findElement(By.id("email_create")).sendKeys(email);
			driver.findElement(By.name("SubmitCreate")).click();
			SeleniumDriver.sleepSeconds(5);
			//WebElement mensajeError = driver.findElement(By.id("create_account_error"));
			System.out.println(mensajeError.getText());
			
			Assert.assertEquals(mensaje, mensajeError.getText());
			
		}

		private void registerAnUser(String email, String firstName, String lastName, String information) {
			// TODO Auto-generated method stub
			
		}
	
	

}


