package funciones;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshooter {

	// asi sacamos todas las fotos, tanta buenas como malas, con la condicional sin negar (en el testone.java)

	public static void takeScreenshot(String screenName, WebDriver driver) {

		File myScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(myScreenshot, new File(screenName + "_" + System.currentTimeMillis() + " .png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
