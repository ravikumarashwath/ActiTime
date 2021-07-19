package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel { // to fetch inpu from excel file

	public static String getData(String path, String sheet, int r, int c) {
		String val="";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			val = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return val;

	}

	public static int getRowCount(String path, String sheet) {

		int rowcount=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowcount = wb.getSheet(sheet).getLastRowNum(); //to get last row number used
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		return rowcount;
	}

}
