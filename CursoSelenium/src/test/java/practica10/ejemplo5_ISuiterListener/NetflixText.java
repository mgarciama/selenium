package practica10.ejemplo5_ISuiterListener;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NetflixText {

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	}
	
	@Test
	public void testOne() {
		System.out.println("Un text de netflix");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE");
	}
}
