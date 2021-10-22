package practico12;

import java.util.HashMap;

public class ManejoDeString {
										//PAIS - CAPITAL - MONEDA
	public static String PAISES_LATAM = "Chile, Santiago, Peso Chileno, Argentina, Buenos Aires, Peso Argentino, España, Madrid, Euro, Uruguay, Montevideo, Peso Uruguayo";
			
	public static void main (String args[]) {
		PAISES_LATAM = PAISES_LATAM.replace(", ", ",");
		
		//metemos en una matriz y lo separamos por comas
		String [] arregloPaises = PAISES_LATAM.split(",");
		for (int i = 0; i < arregloPaises.length; i++) {
			
			System.out.println("POSICION "+i +" "+ arregloPaises[i]);
		}
		//SACAMOS LOS CAPITALES
		for (int i = 1; i < arregloPaises.length; i = i +3) {
		
			System.out.println("CAPITAL--> " + arregloPaises[i]);
		}
		
		//Sacamos los PAISES
		for (int i = 0; i < arregloPaises.length; i = i+3){
			System.out.println("PAISE: " + arregloPaises[i]);
		}
		//Sacamos las Monedas
		for (int i = 2; i < arregloPaises.length; i = i +3) {
			System.out.println("Monedas: " + arregloPaises[i]);
		}
		
		//ESPAÑA --> MADRID
		//URUGUAY --> MONTEVIDEO
		//ARGENTINA --> BUENOS AIRES
		//CHILE --> SANTIAGO
		
		HashMap<String, String>mapaPaisesConCapitales = new HashMap<String, String>();
		for (int i = 0; i < arregloPaises.length; i = i+3) {
			mapaPaisesConCapitales.put(arregloPaises[i], arregloPaises[i+1]);
		}
		// <Chile , Santiago>
		// <Argentina, Buenos Aires>
		// <España , Madrid>
		System.out.println("La capital de Chile es: " + mapaPaisesConCapitales.get("Chile"));
		System.out.println("La capital de España es: " + mapaPaisesConCapitales.get("España"));
		System.out.println("La capital de Argentia es: " + mapaPaisesConCapitales.get("Argentina"));
		System.out.println("La capital de Uruguay es: " + mapaPaisesConCapitales.get("Uruguay"));
	}
	

}
