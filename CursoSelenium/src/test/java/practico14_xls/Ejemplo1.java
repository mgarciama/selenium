package practico14_xls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ejemplo1 {
	public static List<Personas> LISTA_PERSONAS = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		//ruta del excel
		XSSFWorkbook samplexlsx = new XSSFWorkbook("dataloader/sample.xlsx");
		//nombremos la hoja
        XSSFSheet sheet1 = samplexlsx.getSheet("Hoja1");
        //creamos una lista
        List<String> listaDatos = new ArrayList<>();
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

            System.out.println();
		}
		

        listaDatos.remove(0);
        for (String data : listaDatos){
            //System.out.println("*****  " + data);

            String [] datosPersonales = data.split(";");
            String firstName =  datosPersonales[0];
            String lastName = datosPersonales[1];
            String country = datosPersonales[3];
            String id = datosPersonales[6];
            String edad = datosPersonales[4];
            String nacimiento = datosPersonales[5];
            String genero = datosPersonales[2];
            
           // String fullName = firstName.concat(" ").concat(lastName);

            //Personas p = new Personas(firstName, genero, Integer.parseInt(id) ,edad, nacimiento,country,lastName);
           Personas p = new Personas(firstName, lastName ,Integer.parseInt(id), edad, nacimiento, genero, country);
            System.out.println(p);

            LISTA_PERSONAS.add(p);
            System.out.println("solo una persona" + LISTA_PERSONAS.get(0).getNombre());
        }
	}	
	

}
