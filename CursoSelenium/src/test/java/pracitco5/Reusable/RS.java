package pracitco5.Reusable;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pracitco5.PO.Authentication;
import pracitco5.PO.CreateAccount;
import pracitco5.PO.MyAccount;
import pracitco5.PO.SingIn_entrada;
import pracitco5.POCompra.Dresses;
import pracitco5.POCompra.Principal;
import util.SeleniumDriver;

public class RS {
	public static  WebDriver driver;
	
	 
	
	public static MyAccount registroUsuario(WebDriver remoteDriver ,String email, String firstName, String lastName, String information) {
		
		SingIn_entrada signIn = new SingIn_entrada(remoteDriver);
		Assert.assertEquals("My personal info", signIn.getSingIn());
		
		Authentication authentication = signIn.clickSingIn();
		authentication.getAuthentication();
		authentication.getLogin();
		//SeleniumDriver.sleepSeconds(3);
		CreateAccount createPerfil = authentication.crearEmail(email);
		SeleniumDriver.sleepSeconds(5);
		Assert.assertEquals(email, createPerfil.getRegistreEmail());
		//String registroEmail = createPerfil.getRegistreEmail();
		//System.out.println("email"+registroEmail);
		return	createPerfil.crearPerfil(email, firstName, lastName, information);
		
	}
	
	public static void menu(String name) {
		
		
		switch (name) {
		case "DRESSES":
			
			  Principal.menuWoman();
			
			
			break;
		case "WOMEN":
			 
			break;
		default:
			break;
		}

	}

	public static String menu2(String name) {
		// TODO Auto-generated method stub
		return name;
		
	}

//	public static void menus(String dresses) {
//		menu(dresses);
//		
//	}
	
}
