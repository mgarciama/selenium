package practico13;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.opencsv.CSVReader;

import practico13.Personas;

public class EjemploOne_Csv {
	/**
	 * TENER EN CUENTA DE LEER UN ARCHIVO
	 * 1º EL OBJETO READER, UN WHILE Y UN FOR.
	 * PARA PONERLO BONITO
	 * 1.CREACIÓN DE STRING PARA IDENTIFICAR LOS PARAMETROS
	 * 2.CREAMOS UN PATRÓN DEL CONTENIDO, LLAMANDO DESDE UN OBJETO
	 * 3. AGREGAMOS UNA LISTA PARA AÑADIR MÁS ELEMENTOS
	 * */
	
	public static List<Personas>LISTA_PERSONAS = new ArrayList<>();

	public static void loadPersona() throws IOException {
		// llamamos al objeto CSV, indincado la ruta
		CSVReader reader = new CSVReader(new FileReader("dataloader/email.csv"));
		//le indicamos en una matriz
		String[] fila;
		//nos sacara todo la fila
		//si la siguiente fila es distinta a null, seguira avanzando
		int contador = 0;
		while((fila = reader.readNext()) !=null) {
			//System.out.print("*** "+contador + "***");
			//así quitamos la primera fila de los titulos
			if (contador !=0) {
				//sacara todas las filas de la tabla
				for (int i = 0; i < fila.length; i++) {
					String infoPersona = fila[i];
					//System.out.println("datos  "+infoPersona);
					//pasamos el datos al string
					procesarDatos(infoPersona);
				}
			}
			
			
			contador++;
		}
		
	}
	public static void procesarDatos(String datosPersonales) {
		String[] datos = datosPersonales.split(";");
		//identificamos por parametros
		String email = datos[0];
		String identifiacador = datos[1];
		String  firsName = datos[2];
		String lastName = datos[3];
		
		String fullName = firsName.concat(" ").concat(lastName);
		//guardamos los datos para lanzarlo
		Personas pers = new Personas(fullName, "", Integer.parseInt(identifiacador), email);
		
		//agramos una lista, todo el listado o contenido 
		//list.add(objeto)
		LISTA_PERSONAS.add(pers);
		System.out.println(""+ pers);
		
	}
	public static List<String> getDataFromSCV(String fileName) throws IOException {
		Assert.assertTrue(fileName.endsWith(".csv"));// para encuentre solo de tipo csv
		
		// llamamos al objeto CSV, indincado la ruta  "dataloader/email.csv"
		CSVReader reader = new CSVReader(new FileReader(fileName));
		//le indicamos en una matriz
		String[] fila;
		List<String> csvData = new ArrayList<>();
		//nos sacara todo la fila
		//si la siguiente fila es distinta a null, seguira avanzando
		int contador = 0;
		while((fila = reader.readNext()) !=null) {
			//System.out.print("*** "+contador + "***");
			//así quitamos la primera fila de los titulos
			if (contador !=0) {
				//sacara todas las filas de la tabla
				for (int i = 0; i < fila.length; i++) {
					String infoPersona = fila[i];
					//System.out.println("datos  "+infoPersona);
					//pasamos el datos al string
					csvData.add(infoPersona);
				}
			}
			
			
			contador++;
		}
		return csvData;
	}
}
