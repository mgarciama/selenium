package practico17.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public CRMPage goToCrmPage(){
        driver.findElement(By.xpath("//a[@href='/mx/crm/']")).click();
        CRMPage nextPage = new CRMPage(driver);
        return nextPage;
    }


    public RegistrationPage goToRegistrationPage(){
        driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        RegistrationPage nextPage = new RegistrationPage(driver);
        return nextPage;
    }
}
