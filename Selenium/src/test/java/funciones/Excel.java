package funciones;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private String filePath, excelSheet;
	
	public Excel(String filePath, String excelSheet) throws IOException {
		this.filePath = filePath;
		fis = new FileInputStream(this.filePath);
		wb = new XSSFWorkbook(fis);
		this.excelSheet = excelSheet;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getExcelSheet() {
		return excelSheet;
	}
	
	public void setExcelSheet(String excelSheet) {
		this.excelSheet = excelSheet;
	}
	
	public List<List<Object>> readExcel() {
		sheet = wb.getSheet(this.excelSheet);
		List<List<Object>> data = new ArrayList<List<Object>>();
		
		Iterator<Row> itRows = sheet.rowIterator();
		int heads = 0;
		
		while (itRows.hasNext()) {
			Row row = (Row) itRows.next();
			if (heads>0) {
				Iterator<Cell> itCells = row.cellIterator();
				List<Object> cellData = new ArrayList<Object>();

				while (itCells.hasNext()) {
					Cell cell = itCells.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						cellData.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							cellData.add(cell.getDateCellValue());
						} else {
							cellData.add(cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						cellData.add(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_ERROR:
						cellData.add(cell.getErrorCellValue());
						break;
					}
				}

				if (!cellData.isEmpty()) {
					data.add(cellData);
				}

				cellData = null;
			} else {
				heads++;
			}
		}
		
		return data;
	}
}