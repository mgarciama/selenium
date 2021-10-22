package practico14_xls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import practico14_xls.Personas;

public class Ejemplo2 {
	public static  List<String> listaDatos = new ArrayList<>();
	public static List<Personas> LISTA_PERSONA= new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		//ruta del excel
				XSSFWorkbook samplexlsx = new XSSFWorkbook("dataloader/sample.xlsx");
				//nombremos la hoja
		        XSSFSheet sheet1 = samplexlsx.getSheet("Hoja1");
		        //creamos una lista
		       // List<String> listaDatos = new ArrayList<>();
		        for (int fila = 0; fila < 5; fila++){
		           String dato = " ";

		            for (int columna = 0; columna < 7; columna++){
		                try {
		                   dato += sheet1.getRow(fila).getCell(columna).getNumericCellValue() + ";";
		                  //  System.out.print(sheet1.getRow(fila).getCell(columna).getNumericCellValue()+ ";");
		                } catch (IllegalStateException ex) {
		                    dato += sheet1.getRow(fila).getCell(columna).getStringCellValue() + ";";
		                  //  System.out.print(sheet1.getRow(fila).getCell(columna).getStringCellValue()+ ";");
		                }
		            }

		            listaDatos.add(dato);

		            //System.out.println("nueva lista "+dato);
				}
		        listaDatos.remove(0);
		        HashMap<String, String>mapaPaisesConCapitales = new HashMap<String, String>();
		  
		        for ( String data : listaDatos){
		          // System.out.print("*****  " + data);

		            String [] datosPersonales = data.split(";");
		          
		            String firstName =  datosPersonales[0];
		            String lastName = datosPersonales[1];
		            String country = datosPersonales[3];
		            String id = datosPersonales[6];
		            String edad = datosPersonales[4];
		            String nacimiento = datosPersonales[5];
		            String genero = datosPersonales[2];
		           // datosPersonales = DATA;
		          
		            Personas p = new Personas(firstName, lastName ,Integer.parseInt(id), edad, nacimiento, genero, country);
					
		            LISTA_PERSONA.add(p);
		        }
		        Personas p = LISTA_PERSONA.get(1);
		       System.out.print(p.getNombre());
	}
}
