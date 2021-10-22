package practico12;

public class Personas {

	private String nombre;
	private String pais;
	private int dni;
	private String email;
	
	
	
	public Personas(String Pais, String Nombre, int Dni, String Email) {
		this.dni = Dni;
		this.nombre = Nombre;
		this.pais = Pais;
		this.email = Email;
	}

	public int getDString() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPais() {
		return this.pais;
	}
	public String getEmail() {
		return this.email;
	}
	
	public String toString() {
		return "Pais: "+this.pais + " ,Nombre: "+ this.nombre + " ,DNI: "+this.dni +  " Email: " + this.email;
	}
}
