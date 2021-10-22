package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		        features = "src/test/resources/features",
				plugin= {"pretty","html:target/RunCuke/cucumber.html", "com.cucumber.listener.ExtentCucumberFormatter",
						 "json:target/RunCuke/cucumber.json"}, 
				glue = "steps",
				monochrome = true 
				//tags = {"@usando-Busqueda-cars"}
		        )
public class RunCucke extends AbstractTestNGCucumberTests{
	@BeforeClass
	public static void setup() {
		
	//Inicia el informe de extensión y genera el resultado en el archivo de salida / Ejecutar (marca de tiempo única)
		
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");	
	Date curDate = new Date();
	String strDate = sdf.format(curDate);
	//generamos el html en la carpeta target
	String fileName = System.getProperty("user.dir")+ "\\target\\Extent_Reports\\" + strDate + ".html";
	File newFile = new File(fileName);
	//llamamos a la dependecia vimalselvam
	ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);
	//creamos el fihcero xml
	ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
	//nombre y version del driver y de selenium
	ExtentCucumberFormatter.addSystemInfo("Browser Name", "ChromeDriver");
	ExtentCucumberFormatter.addSystemInfo("Browser Version", "v2.40.565498");
	ExtentCucumberFormatter.addSystemInfo("Selenium Version", "v3.141.59");
	
	//agregar información del sistema utilizando HashMap()
	Map systemInfo = new HashMap();
	systemInfo.put("Cucumber version", "v1.2.5");
	systemInfo.put("Extent Cucumber Report version", "v1.1.1");
	ExtentCucumberFormatter.addSystemInfo(systemInfo);
	
	
}
}
