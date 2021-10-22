package funciones;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRowAndColumCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(projectPath + "/src/main/resources/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet hoja = workbook.getSheet("prueba");
		XSSFRow row = hoja.getRow(0);
		int colCount = row.getLastCellNum();
		
		System.out.println("total de numeros de columnas " + colCount);
		
		int rowCount = hoja.getLastRowNum() + 1;
		System.out.println("total de numeros de filas " + rowCount);
		
		
	}

}
