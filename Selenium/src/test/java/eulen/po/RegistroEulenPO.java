package eulen.po;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import funciones.Screenshooter;
import funciones.Squery;

public class RegistroEulenPO {

	private WebDriver driver;
	@FindBy(id = "identifierId")
	private WebElement inputRegistro;
	@FindBy(className = "LXVVDe")
	private WebElement icono;
	@FindBy(id = "identifierNext")
	private WebElement btnRegistro;
	@FindBy(name = "password")
	private WebElement inputPassword;
	@FindBy(id = "passwordNext")
	private WebElement btnRegistro2;
	@FindBy(id = "captchaimg")
	private WebElement captcha;
	
	@FindBy(id = "ca")
	private WebElement newCaptcha;
	public RegistroEulenPO(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public void assertPage() {
		
		Assert.assertEquals("LXVVDe", icono.getAttribute("class"));
		//System.out.println("verificar " + icono.getAttribute("class"));
	}
	
	public void inicio(String name, String number)   {
		Squery.newVentana(driver);
		assertPage();
		Screenshooter.takeScreenshot("Capturas\\loginNew\\LOGIN", driver);
		inputRegistro.click();
		inputRegistro.sendKeys(name);
		btnRegistro.click();
		Squery.sleepSeconds(3);
		String iconoCaptcha = "captchaimg";

		String nuevocaptcha = captcha.getAttribute("id");
		//iconoCaptcha.equals(captcha);
	if (nuevocaptcha.equals(iconoCaptcha)) {
		 String imageUrl=captcha.getAttribute("src");
		 System.out.println("imagen1 " + imageUrl.toString());
		 newCaptcha.sendKeys(imageUrl.toString());
		 Squery.sleepSeconds(3);
		 btnRegistro.click();
		 Squery.sleepSeconds(5);
	}
	else {	
		Squery.sleepSeconds(5);
		inputPassword.click();
		inputPassword.clear();
		inputPassword.sendKeys(number);
		btnRegistro2.click();
		Squery.sleepSeconds(3);
		 String imageUrl=newCaptcha.getAttribute("src");
		 
		 System.out.println("imagen " + imageUrl);
	//	Client cliente = (Client)new SocketClient("", "");

	  //  System.out.println("cliente" + cliente);
	    byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

	   // byte[] arrScreen = (OutputType.BYTES);
	    BufferedImage imageScreen = null;
		try {
			imageScreen = ImageIO.read(new ByteArrayInputStream(src));
			System.out.println("imagen23" + imageScreen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   // WebElement cap = driver.findElementById("captcha");
	    Dimension capDimension = captcha.getSize();
	    System.out.println("dime"+ capDimension);
	    Point capLocation = captcha.getLocation();
	    BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
	    System.out.println("dim2e"+ imgCap);
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    try {
			ImageIO.write(imgCap, "png", os);
			System.out.println(ImageIO.write(imgCap, "png", os));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 
	}
		
	
		
	}
	
}
