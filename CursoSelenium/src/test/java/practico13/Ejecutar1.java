package practico13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejecutar1 {
	public static List<String>lista_persona = new ArrayList<>();	
	public static void main(String[] args) throws IOException {
		
		List<String> datosCSV = EjemploOne_Csv.getDataFromSCV("dataloader/email.csv");
		for (String dato : datosCSV) {
			System.out.println("dato"+ dato);
			String[] datos = dato.split(";");
			
			
			
		
			lista_persona.add(dato);
			System.out.println("sacamos la lista por orden");
			System.out.println(lista_persona.get(0));
			System.out.println(datos[1]);
		}
	}

}
