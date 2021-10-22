package practrica6.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import practrica6.pageObject.Dresses;
import practrica6.pageObject.Principal;
import practrica6.pageObject.ShoppingCart;
import practrica6.utils.Constants;
import util.SeleniumDriver;

public class TestVestido extends BaseT{
	//public WebDriver driver;
	
	@Test(description = "vestidoGenerico", enabled = true, priority = 1)
	public void compraVestido() {
		compra();
	}
	
	private void compra() {
		Principal pr = new Principal(driver); 
		
		Dresses dress = pr.pulsarMenuWoman();
		Assert.assertFalse(dress.getDresses());
		dress.anadirVestido();
		
		ShoppingCart shopping = dress.validarMensaje();
//		String h1Shopping = "SHOPPING-CART SUMMARY\r\n"
//				+ "Your shopping cart contains: 1 Product";
		//Assert.assertEquals(h1Shopping, shopping.getShoppingCart());
		Assert.assertFalse(shopping.getOrder());	
		shopping.pulsarProceed();
		Assert.assertFalse(shopping.getLogin());
		shopping.comprobarRegistro(Constants.USER, Constants.PASSWORD);
		Assert.assertEquals("ADDRESSES", shopping.getAddres());
		shopping.pulsarProcess();
		Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", shopping.getAddres());
		
	}
}
