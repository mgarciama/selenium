package ejemploAssert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

	public int numeroUno = 5;
	public int numeroDos = 3;

	// compara si existe si coinciden con boolean
	// assertTrue/False
	@Test
	public void testNumeroVerdadero() {
		Assert.assertTrue(numeroUno == numeroDos + 1, "No es verdadero" + String.valueOf(numeroUno));
	}

	@Test
	public void testNumeroFalse() {
		Assert.assertFalse(numeroUno == numeroDos, "Ambos no son iguales");
	}

	// comprueba con dos acciones si un usar un boolean
	// NotEquals / Equals
	@Test
	public void testNumeroIguales() {
		Assert.assertEquals(numeroUno + 10, numeroDos + 12);
	}

	@Test
	public void testNumeroNoIguales() {
		Assert.assertNotEquals(numeroUno - 1, numeroDos * 20);
	}

	// notNull / Null
	@Test
	public void testDeNoNulo() {
		Personas persona = new Personas("manuel", "garcia");
		Assert.assertNotNull(persona); // dara pk

	}

	@Test
	public void testDeNulo() {
		Personas persona = null;
		Assert.assertNull(persona); // dara ok
	}

	// NotSame/Same
	@Test
	public void testnoMismoObjet() {
		Personas persona = new Personas("manuel", "garcia");
		Personas persona2 = new Personas("manuel", "garcia");

		Assert.assertNotSame(persona, persona2);
	}

	@Test
	public void testMismoObjet() {
		Personas persona = new Personas("manuel", "garcia");
		Personas persona2 = persona;

		Assert.assertSame(persona, persona2);
	}
}
