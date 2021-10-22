package practico13;

public class Personas {

	private String nombre;
	private String apellidos;
	private int dni;
	private String email;
	
	
	
	public Personas(String apellidos, String Nombre, int Dni, String Email) {
		this.dni = Dni;
		this.nombre = Nombre;
		this.apellidos = apellidos;
		this.email = Email;
	}

	public int getDString() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPais() {
		return this.apellidos;
	}
	public String getEmail() {
		return this.email;
	}
	
	public String toString() {
		return "Nombre y apellidos: "+this.apellidos + " |"+ " DNI: "+this.dni +  " | Email: " + this.email;
	}
}
