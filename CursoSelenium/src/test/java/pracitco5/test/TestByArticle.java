package pracitco5.test;

import org.junit.Assert;
import org.testng.annotations.Test;


import pracitco5.POCompra.Dresses;
import pracitco5.POCompra.Principal;
import pracitco5.POCompra.ShoppingCart;
import pracitco5.Reusable.RS;
import pracitco5.utils.DataFactory;


public class TestByArticle extends BaseTest{
	@Test(description = "vestidoGenerico", enabled = true, priority = 4)
	public void compraVestido() {
		compra();
	}
	
	private void compra() {
		String email = DataFactory.getEmail();
		String firstName =  DataFactory.getFakeFirstName();
		String lastName=  DataFactory.getFakeLastName();
		String information = DataFactory.getFakeInformation();
		Principal pr = new Principal(driver); 
		
		RS.menu(pr.getDresses());
		//pr.getWoman();
		//pr.getDresses();
		
		Dresses dress = new Dresses(driver);//pr.pulsarMenuWoman();
		Assert.assertFalse(dress.getDresses());
		dress.anadirVestido();
		
		ShoppingCart shopping = dress.validarMensaje();
//		String h1Shopping = "SHOPPING-CART SUMMARY\r\n"
//				+ "Your shopping cart contains: 1 Product";
		//Assert.assertEquals(h1Shopping, shopping.getShoppingCart());
		Assert.assertFalse(shopping.getOrder());	
		shopping.pulsarProceed();
		Assert.assertFalse(shopping.getLogin());
		RS.registroUsuario(driver, email, firstName, lastName, information);
		shopping.pulsarProceed();
		//shopping.comprobarRegistro(Constants.USER, Constants.PASSWORD);
		Assert.assertEquals("ADDRESSES", shopping.getAddres());
		shopping.pulsarProcess();
		Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", shopping.getAddres());
		
	}
}
