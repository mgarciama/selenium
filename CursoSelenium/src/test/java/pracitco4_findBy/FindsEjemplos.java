package pracitco4_findBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindsEjemplos extends BaseTest{
	
		
		
		
		
		@Test(description = "netlfix", enabled = true, priority = 1)
		public void Busquedatest() {
			
//			mostrar todos las cantidades de parrafos : Assert.assertNotEquals(listaParrafos.size(), 0);
			System.out.println("cantidad de parrafos es: "+ listaParrafos.size());
//			mostrar todos las cantidades de links : Assert.assertNotEquals(listaLinks.size(), 0);
			System.out.println("cantidad de links es: "+ listaLinks.size());
//			Assert.assertNotEquals(ListaBtns.size(), 0);
			System.out.println("cantidad de bototnes : "+ listaLinks.size());
			
			//imprimimos los links de los textos
			for (WebElement link : listaLinks) {
				
				if (!link.getText().isEmpty()) {
					System.out.println("los textos que tiene los links-->"+ link.getText());
				}
				
			}
			//mostrar los textos de los botones
			for (WebElement btn : ListaBtns) {
				System.out.println("mostramos todos los botones que tiene los textos: "+ btn.getText());
				
			}
			
			//obtener una lista con todos los H1, H2 Y H3
			System.out.println("todos los Hs "+ getAllHs.size());
			for (WebElement h : getAllHs) {
				//System.out.println("h"+ h.getTagName());
				String hs = h.getTagName();
				//queremos que muestre h1
				if (hs.equals("h1")) {
					System.out.println("hs "+ h.getTagName());
				}
				
			}
			
			
		}
//			@Test
//			public void searchLoginBtn(){
//				//Olvide mi contraseña
//				//Login
//				for (WebElement btn : ListaBtns) {
//					
//					if (btn.getText().equals("Login")) {
//						btn.click();
//					}
//					if (btn.getText().equals("contraseña")) {
//						btn.click();
//					}
//					
//				}
//			}
	
		
}
