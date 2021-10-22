package pracitco5.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pracitco5.PO.Authentication;
import pracitco5.PO.MyAccount;
import pracitco5.PO.MyPersonalInformation;
import pracitco5.Reusable.RS;
import pracitco5.utils.Constants;
import pracitco5.utils.DataFactory;
import util.SeleniumDriver;

public class TestRegistro extends BaseTest {
	
	@Test(description = "registro", enabled = true, priority = 1)
	public void registrarTest() throws InterruptedException {
		String email = DataFactory.getEmail();
		String firstName =  DataFactory.getFakeFirstName();
		String lastName=  DataFactory.getFakeLastName();
		String information = DataFactory.getFakeInformation();
		
		
		MyAccount myAccount = RS.registroUsuario(driver, email, firstName, lastName, information);
		MyPersonalInformation myPersonal = myAccount.pulsarInformacion();
		
		Assert.assertEquals(firstName, myPersonal.getRegistreNameValue());
		Assert.assertEquals(lastName, myPersonal.getRegistreLastNameValue());
		Assert.assertEquals(email, myPersonal.getRegistreEmailValue());
	}
	@Test(description = "registro de validation", enabled = true, priority = 3)
	public void registroValidation() throws InterruptedException {
		String email = DataFactory.getEmail();
		String firstName =  DataFactory.getFakeFirstName();
		String lastName=  DataFactory.getFakeLastName();
		String information = DataFactory.getFakeInformation();
		
		
		MyAccount myAccount = RS.registroUsuario(driver,email, firstName, lastName, information);
		Authentication authentication = myAccount.pulsarLogout();
		authentication.crearEmail(email);
		SeleniumDriver.sleepSeconds(3);
		System.out.println(authentication.validateRegistro());
		Assert.assertEquals(Constants.mensaje,authentication.validateRegistro());
		
	}
}
