package practica11;

public class ManejoDeStrings {

	
	public static String info = "Manuel, García, 30, QA; Yoana, Ponsoda, 28, Profesora";
	public static void main (String args[]) {
		//buscamos si es está en el string
		boolean presente = info.contains("Manuel");
		System.out.println("está presente ? "+ presente);
		//cambiamos las letras
		String replaceString = info.replace('a','A');
		System.out.println("cambiar todas las letas a minusculas en A mayusculas"+ replaceString);
		
		String [] personas =info.split(";");
		System.out.println("-- > cuantas personas tenemos: "+ personas.length);
		
		String persona1 = personas[0];
		String persona2 = personas[1];
		
		System.out.println("persona 1 "+ persona1);
		System.out.println("persona 2 "+ persona2);
		//lo simplificaoms más 
		System.out.println("lo simplificaos por casillas");
		String[] datosPersonales1 = persona1.split(",");
		System.out.println("Nombre : "+obtenerNombre(datosPersonales1));
		System.out.println("Apellido : "+obtenerApellido(datosPersonales1));
		System.out.println("Edad:  : "+obtenerAños(datosPersonales1));
		System.out.println("Profesion : "+obtenerProfesion(datosPersonales1));
	}
	
	public static String obtenerNombre(String[] datosPersonas) {
		
		return datosPersonas[0];
	}
	public static String obtenerApellido(String[] datosPersonas) {
			
			return datosPersonas[1];
		}
	public static String obtenerAños(String[] datosPersonas) {
		
		return datosPersonas[2];
	}
public static String obtenerProfesion(String[] datosPersonas) {
		
		return datosPersonas[3];
	}
	


}
