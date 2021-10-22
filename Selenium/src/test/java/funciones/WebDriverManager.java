package funciones;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {

	public static void setWindowSize(WebDriver driver, String size) {
		if (size.toLowerCase() == "maximized") {
			driver.manage().window().maximize();
		}
		if (size.toLowerCase() == "fullscreen") {
			driver.manage().window().fullscreen();
		}

	}

	// para llamar con coordenadas la pantalla
	public static void setWindowSizePosition(int x, int y, WebDriver driver) {
		driver.manage().window().setSize(new Dimension(x, y));
	}
}
