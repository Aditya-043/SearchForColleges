package DemoProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelSetup {
	public static List<String> getData(File file) {
		List<String> data = new ArrayList<String>();
 
		//try block to get Exceptions
		try { 
			FileInputStream is = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			int cells = sheet.getRow(0).getLastCellNum();
			for(int r=0;r<=rows;r++) 
			{
					XSSFRow currentRow = sheet.getRow(r);
					for(int c=0;c<cells;c++) 
					{
						data.add(currentRow.getCell(c).toString());
					}
			}
			wb.close();
		} 
		
		//multiple catch for specific Exceptions
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//return the retrieved data
		return data;
	}
 
}