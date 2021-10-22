package practico14_xls;

import java.util.Date;

public class Personas {

	private String nombre;
	private String apellidos;
	private String genero;
	private String pais;
	private int dni;
	private String date;
	private String edad;
	
	
	
	public Personas(String apellidos, String Nombre, int Dni, String date, String genero, String pais, String edad) {
		this.dni = Dni;
		this.nombre = Nombre;
		this.apellidos = apellidos;
		this.date = date;
		this.genero = genero;
		this.pais = pais;
		this.edad = edad;
	}

	
	public int getDString() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellidos;
	}
	public String getDate() {
		return this.date;
	}
	public String getPais() {
		return this.pais;
	}
	public String getGenero() {
		return this.genero;
	}
	public String getEdad() {
		return this.edad;
	}
	public String toString() {
		return "Nombre y apellidos: "+this.nombre+this.apellidos + " |"+ " DNI: "+this.dni +  " | Edad: " + this.edad +" | fecha de nacimiento " + this.date+" | Genero " + this.genero + " | Pais" + this.pais;
	}
}
