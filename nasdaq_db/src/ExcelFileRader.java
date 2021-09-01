import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * the purpose of this class is to read excel file that has
 * poi link "https://www.youtube.com/watch?v=Teoh7fbpuKY"
 */
public class ExcelFileRader {

	//file input object relative to users path
	private FileInputStream fis;
	//sheet that holds excel file
	private XSSFSheet sheet;
	//object we use in order o iterate file rows
	private XSSFWorkbook wb;
	// file's Properties in order of reading a row
	public static final int Date = 0;
	public static final int Close = 1;
	public static final int Volume = 2;
	public static final int Open = 3;
	public static final int High = 4;
	public static final int Low = 5;


	//	ExcelFileRader(String usersPath){}

	public Map<Integer, dateData> readFile(String usersPath) {
		try {
			//obtaining input bytes from a file
			fis = new FileInputStream(new File("nasdaq_db/seconedchance.xlsx"));

		} catch (Exception e) {
			System.out.println("Problem with file reading in excel file read class ");
			return null;

		}
		try {
			//creating workbook instance that refers to .xls file
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Problem with workbook instance in excel file read class ");
			return null;

		}

		sheet = wb.getSheetAt(0);
		Map<Integer, dateData> data = new HashMap<>();
		int rowCount = 0;
		int relativeLoc = -1;
		int date = 0;
		for (Row row : sheet) {
			dateData dD = new dateData();
			for (Cell cell : row) {
//				System.out.println(dateToInt(cell.toString()));
				relativeLoc+=1;
				switch (relativeLoc) {
				case Date:
					System.out.println(dateToInt(cell.toString()));
					date = dateToInt(cell.toString());

				case Close:
					System.out.println(dollarToInt(cell.toString()));
					dD.initClose(dollarToInt(cell.toString()));



				case Volume:
					System.out.println(volToInt(cell.toString()));
					dD.initVolume(volToInt(cell.toString()));


				case Open:
					System.out.println(dollarToInt(cell.toString()));
					dD.initClose(dollarToInt(cell.toString()));



				case High:
					System.out.println(dollarToInt(cell.toString()));
					dD.initClose(dollarToInt(cell.toString()));



				case Low:
					System.out.println(dollarToInt(cell.toString()));
					dD.initClose(dollarToInt(cell.toString()));

				}
//				relativeLoc = 0;

				//return data;
			}
			data.put(date, dD);
			rowCount++;
			relativeLoc = 0;
			//System.out.println(rowCount);
//			return data;
		}
		return data;
	}
	public int dateToInt(String cellString) {
		String[] values = cellString.split("/");
		int day = Integer.parseInt(values[1]);
		int month = Integer.parseInt(values[0]);
		int year = Integer.parseInt(values[2]);
//		System.out.println(day+" "+month+" "+year);
		int num = year*10000+month*100+day;
		return num;
	}
	public int dollarToInt(String cellString) {
		String[] values = cellString.split("$");
		System.out.println(values[0]);
		return Integer.parseInt(values[0]);

	}
	public int volToInt(String cellString) {
		return Integer.parseInt(cellString);

	}




}

