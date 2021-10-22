package practico16_bdd_outlined.Orange;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.SeleniumDriver;

public class OrangeStpes {
public WebDriver driver;
String cantidadElementos = "";

@Given("^estoy en Orange$")
public void estoy_en_Orange() throws Throwable {
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",
			projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    
}

@When("^me logeo$")
public void me_logeo() throws Throwable {
//  WebElement user = driver.findElement(By.id("txtUsername"));
//  user.sendKeys("admin");
//  WebElement pass = driver.findElement(By.id("txtPassword"));
//  pass.sendKeys("admin");
  
  driver.findElement(By.id("btnLogin")).click();
  
}

@When("^estoy en el lading page$")
public void estoy_en_el_lading_page() throws Throwable {
	SeleniumDriver.sleepSeconds(5);
  System.out.println(driver.getTitle());
 // Assert.assertTrue(driver.getCurrentUrl().contains("Dashboard"));
	SeleniumDriver.sleepSeconds(5);
}

@Then("^veo la Assign leave en quick actions$")
public void veo_la_Assign_leave_en_quick_actions() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	StepsHelper.validateQuickActions(Constants.ASSIGN_LEAVE_QUICK_ACTION, driver);
}

@Then("^veo la Leave List en quick actions$")
public void veo_la_Leave_List_en_quick_actions() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	StepsHelper.validateQuickActions(Constants.LEAVE_CALENDAR_QUICK_ACTION, driver);
}


@Then("^veo la Leave Calendar en quick actions$")
public void veo_la_Leave_Calendar_en_quick_actions() throws Throwable {
	StepsHelper.validateQuickActions(Constants.LEAVE_LIST_QUICK_ACTION, driver);
}


@When("obtengo la cantidad de leave request to approve")
public void obtengo_la_cantidad_de_leave_request_to_approve() {
    WebElement cantidadLeaveRequestElement = driver.findElement(By.className("record-count"));
    System.out.println(cantidadLeaveRequestElement.getText());

     cantidadElementos = cantidadLeaveRequestElement.getText().replace("(", "");
    cantidadElementos = cantidadElementos.replace(")", "");

}

@When("ingreso a la seccion de leave requests")
public void ingreso_a_la_seccion_de_leave_requests() {
    driver.findElement(By.className("link-title")).click();
    Assert.assertTrue(driver.getCurrentUrl().contains("view_leave_list"));
}

@Then("la cantidad de elementos a desplegarse debe coincidir")
public void la_cantidad_de_elementos_a_desplegarse_debe_coincidir() {

    WebElement cantidadElementosTotal = driver.findElement(By.className("summary"));
    System.out.println("===> " + cantidadElementosTotal.getText());

    Assert.assertTrue(cantidadElementosTotal.getText().endsWith("of " + cantidadElementos));

}
}
