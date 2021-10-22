package carsGuide.utils;



import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;



public class DataFactory {
public WebDriver driver;

public static Faker faker = new Faker();
 


	public static String getFakeFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}
	public static  String getFakeLastName() {
		String lastName= faker.name().lastName();
		return lastName;
	}
	public static String getEmail() {
		String email = "prueba" + Math.random() +"test"+ "@gmail.com";
		return email;
	}
	
}
