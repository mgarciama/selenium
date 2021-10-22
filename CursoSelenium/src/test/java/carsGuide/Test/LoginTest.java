package carsGuide.Test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import carsGuide.Auto.Automovil;
import carsGuide.Listener.ListenersTest;
import carsGuide.POLogin.LoginPO;
import carsGuide.POLogin.PaginaBusqueda;
import carsGuide.POLogin.PaginaInicioPO;
import carsGuide.Reusable.RS;
import carsGuide.utils.Constants;
import pracitco5.utils.DataFactory;
import util.SeleniumDriver;

@Listeners(value = ListenersTest.class)
public class LoginTest extends BaseTest{
	@Test(description = "IniciarSession", enabled = true, priority = 1)
	public void IniciarSession() {
		Automovil  auto = LIST_AUTOMOVIL.get(0);//llamamos al Auid
		//login();
		PaginaInicioPO pag = new PaginaInicioPO(driver);
		RS.menuPrincipal(driver, pag.getBuy());
		Assert.assertFalse(pag.getListado());
		PaginaBusqueda paB = new PaginaBusqueda(driver);
		//paB.buscarCars("Audi", "A4", "ACT - All", "15000");//metemos los arreglos
		paB.buscarCars(auto.getMarca(), auto.getModelo(), auto.getLocalizacion(), auto.getPrecio());
		paB.resultadoBusquedaCars();
	}
	
	private void login() {
		LoginPO lg = new LoginPO(driver);
		
		RS.menuLogin(driver,lg.getSingUpIn());
		Assert.assertFalse(lg.getTitle(Constants.SingInTitle));
		SeleniumDriver.newVentana(driver);
		String email = DataFactory.getEmail();
		String name =  DataFactory.getFakeFirstName();
		String lastName=  DataFactory.getFakeLastName();
		lg.registrarte(email, Constants.PASSWORD, name, lastName);
		
	}
	
}
