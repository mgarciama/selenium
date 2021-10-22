package practica10.ejemplo4_Listener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(value = InvokedMethodListener.class)
public class AppleTest {

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMehod");
	}
	@Test
	public void testOne() {
		System.out.println("@Test test 1");
	}
	@Test
	public void testTwo() {
		System.out.println("@Test test 2");
	}
	@AfterMethod
	public void closeMethod() {
		System.out.println("@AfterMethod");
	}
}
