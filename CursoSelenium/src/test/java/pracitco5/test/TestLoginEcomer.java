package pracitco5.test;



import org.junit.Assert;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pracitco5.PO.Authentication;
import pracitco5.PO.CreateAccount;
import pracitco5.PO.MyAccount;
import pracitco5.PO.MyPersonalInformation;
import pracitco5.PO.SingIn_entrada;
import pracitco5.Reusable.RS;
import pracitco5.utils.Constants;
import pracitco5.utils.DataFactory;
import util.SeleniumDriver;


public class TestLoginEcomer extends BaseTest {
	

	
	
	@Test(description = "login", enabled = false, priority = 2)
	public void comprobarLogin() {
		String email = DataFactory.getEmail();
		String firstName =  DataFactory.getFakeFirstName();
		String lastName=  DataFactory.getFakeLastName();
		String information = DataFactory.getFakeInformation();
		
		
		MyAccount myAccount = RS.registroUsuario(driver, email, firstName, lastName, information);
		Authentication authentication = myAccount.pulsarLogout();
		
		authentication.registro(email,Constants.PASSWORD );
		System.out.println("after login... " + driver.getTitle());
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.MyAccountTitle));
        
        System.out.println();
        Assert.assertTrue(myAccount.menuUserValidate().contains(firstName));
	}
	
//	private MyAccount registroUsuario(String email, String firstName, String lastName, String information) {
//		
//		SingIn_entrada signIn = new SingIn_entrada(driver);
//		Assert.assertEquals("My personal info", signIn.getSingIn());
//		
//		Authentication authentication = signIn.clickSingIn();
//		authentication.getAuthentication();
//		authentication.getLogin();
//		//SeleniumDriver.sleepSeconds(3);
//		CreateAccount createPerfil = authentication.crearEmail(email);
//		SeleniumDriver.sleepSeconds(5);
//		Assert.assertEquals(email, createPerfil.getRegistreEmail());
//		//String registroEmail = createPerfil.getRegistreEmail();
//		//System.out.println("email"+registroEmail);
//		return	createPerfil.crearPerfil(email, firstName, lastName, information);
//		
//	}
}
