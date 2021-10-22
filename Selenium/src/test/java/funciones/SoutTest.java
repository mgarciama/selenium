package funciones;

import org.testng.ITestResult;

public class SoutTest {
	//mostrar el resultado : pass / fall /bloqued
	public static void SouTest(ITestResult result) {
		System.out.println("El test" + result.getMethod().getDescription() + " resulto: " + result.getStatus());
	}
}
