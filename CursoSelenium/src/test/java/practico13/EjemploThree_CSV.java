package practico13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjemploThree_CSV {

	public static List<Personas>LISTA_PERSONAS = new ArrayList<>();	
	public static void main(String args[]) throws IOException {
		List<String> datosCSV = EjemploOne_Csv.getDataFromSCV("dataloader/email.csv");
		
		for (String dato : datosCSV) {
			System.out.println("dato"+ dato);
			String[] datos = dato.split(";");
			String email = datos[0];
			String identifiacador = datos[1];
			String  firsName = datos[2];
			String lastName = datos[3];
			
			String fullName = firsName.concat(" ").concat(lastName);
			//guardamos los datos para lanzarlo
			Personas pers = new Personas(fullName, "", Integer.parseInt(identifiacador), email);
			LISTA_PERSONAS.add(pers);
			System.out.println("sacamos la lista por orden");
			System.out.println(LISTA_PERSONAS.get(0).getEmail());
		}
	}
}
