package ejemploAssert;

public class Personas {

	private String nombre;
	private String apellido;

	public Personas(String name, String subname) {
		name = nombre;
		subname = apellido;
	}

	public void saludar() {
		System.out.println("Hola" + this.nombre + "" + this.apellido);
	}
}
