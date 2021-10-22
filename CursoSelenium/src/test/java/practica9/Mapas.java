package practica9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.checkerframework.checker.units.qual.m;

public class Mapas {

	public static void main(String args[]) {
		//los mapas, tiene clave y valor, siempre se llama con clave para identificar el valor
		
		//sirve para llamar, añadir, eliminar los valores, normalmente en una bbdd
	
		HashMap<Integer,String> mapaPersonas = new HashMap<Integer, String>();
		mapaPersonas.put(111, "manuel garcia");
		mapaPersonas.put(222, "Yoana Ponsoda");
		mapaPersonas.put(333, "Lia");
		mapaPersonas.put(444, "Dana");
		mapaPersonas.put(555, "New");
		System.out.println("es : " + mapaPersonas.get(222));
		System.out.println("mapa "+ mapaPersonas);
		mapaPersonas.remove(555);
		System.out.println("mapapersonas "+ mapaPersonas);
		
		List<String> listaNombres = new ArrayList<>();
		listaNombres.add("Manu");
		listaNombres.add("Yoana");
		listaNombres.add("Lia");
		listaNombres.add("Dana");
		
		//Ordenes = Tiempo que se demora en encontrar a un elemento
		//Lista el peor tiempo es N, siendo N la cantidad de elementos
		//HASHMAP el peor tiempo es 1, siempre que debo saber la clave
		for (String nombres : listaNombres) {
			if (nombres.equals("Manu")) {
				System.out.println("se encuentra en el Sistema");
			}
		}
		
	}
	
	
}
