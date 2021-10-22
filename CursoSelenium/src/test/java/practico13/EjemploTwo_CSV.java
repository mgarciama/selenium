package practico13;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections.map.HashedMap;
import org.yaml.snakeyaml.tokens.Token.ID;

public class EjemploTwo_CSV {
	
	/**
	 * MAPEO:
	 * CLAVE, VALOR
	 * identificador, objetoPersona
	 * */
	
	public static HashMap<Integer, Personas>ID_PERSON_MAP = new HashMap<>();
	public static void main (String args[]) throws IOException {
		
		//llamamos al punto anterior
		EjemploOne_Csv.loadPersona();
		List<Personas> listaPersonas = EjemploOne_Csv.LISTA_PERSONAS;
		System.out.println("La cantidad de persona es: "+ listaPersonas.size());
		//cargamos la lista
		for (Personas personas : listaPersonas) {
			ID_PERSON_MAP.put(personas.getDString(), personas);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("ingrese el DNI");
		int dni = input.nextInt();
		System.out.println("los datos son: ");
		System.out.println(ID_PERSON_MAP.get(dni));
	}
}
