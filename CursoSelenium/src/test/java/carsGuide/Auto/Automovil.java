package carsGuide.Auto;

public class Automovil {
//String marca, String modelo, String locatiom, String precio
	private String marca;
	private String modelo;
	private String localizacion;
	private String precio;
	
	public Automovil(String ma, String mo, String lo, String pr) {
		this.marca = ma;
		this.modelo = mo;
		this.localizacion = lo;
		this.precio = pr;
	}
	
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}public String getLocalizacion() {
		return this.localizacion;
	}public String getPrecio() {
		return this.precio;
	}
	
	
}
