package practico7;

import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class SoftAsserts {

	@Test
	public void TestAsserts() {
		SoftAssert softAssert = new SoftAssert();
		Assert.assertFalse(1>5, "Error 1 es mayor que 5, assert con testNg"); // si pongo añado 1 <5, solo me muestra este assert no lo demás
		softAssert.assertFalse(1<5, "Error: 1 es menor que 5"); //1 es menor que 5
		softAssert.assertTrue(10>12, "Error: 10 no es mayor que 12"); //10 mayor que 12
		softAssert.assertEquals("Hola", "Mundo", "Error: No se obtuvo Mundo");
		softAssert.assertNotEquals("Hola", "Hola", "Error: No se esperaba Hola pero obtuvo Hola");
		softAssert.assertTrue("hola".contains("x"), "Error: No e encuentro la letra x dentro de la palabra Hola");
		
		System.out.println("fin del mentodo del test");
		softAssert.assertAll();
	}
	
}
