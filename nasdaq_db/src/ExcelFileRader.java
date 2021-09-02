import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
	public static final int stockDate = 0;
	public static final int stockClose = 1;
	public static final int stockVolume = 2;
	public static final int stockOpen = 3;
	public static final int stockHigh = 4;
	public static final int stockLow = 5;
	public static final int hurricaneName = 0;
	public static final int hurricaneSS = 1;
	public static final int hurricaneDate = 2;
	public static final int hurricaneYear = 3;
	public static final int hurricanState = 4;

	//	ExcelFileRader(String usersPath){}

	public Map<Integer, dateData> readStockDataFile(String usersPath) throws ParseException {
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
			if(rowCount>=1) {
				for (Cell cell : row) {
					//				System.out.println(dateToInt(cell.toString()));
					relativeLoc += 1;
					switch (relativeLoc) {
					case stockDate:
						System.out.println(dateToInt(cell.toString()));
						date = dateToInt(cell.toString());
						break;
					case stockClose:
						//					System.out.println(dollarToInt(cell.toString()));
						dD.initClose(dollarToInt(cell.toString()));
						break;

					case stockVolume:
						//					System.out.println(volToInt(cell.toString()));
						dD.initVolume(volToInt(cell.toString()));
						break;

					case stockOpen:
						//					System.out.println(dollarToInt(cell.toString()));
						dD.initOpen(dollarToInt(cell.toString()));
						break;

					case stockHigh:
						//					System.out.println(dollarToInt(cell.toString()));
						dD.initHigh(dollarToInt(cell.toString()));
						break;

					case stockLow:
						//					System.out.println(dollarToInt(cell.toString()));
						dD.initLow(dollarToInt(cell.toString()));

					}

				}
				data.put(date, dD);
				relativeLoc = -1;
				//System.out.println(rowCount);
				//			return data;
			}
			rowCount++;

		}
		return data;
	}
	public int dateToInt(String cellString) throws ParseException {
		String[] values;
		boolean os_changes_values = false;
		Map<String, Integer> dic = new HashMap<>();
		dic.put("Jan", 1);
		dic.put("Feb", 2);
		dic.put("Mar", 3);
		dic.put("Apr", 4);
		dic.put("May", 5);
		dic.put("Jun", 6);
		dic.put("Jul", 7);
		dic.put("Aug", 8);
		dic.put("Sep", 9);
		dic.put("Oct", 10);
		dic.put("Nov", 11);
		dic.put("Dec", 12);

		if (cellString.contains("/"))
			values = cellString.split("/");
		else {
			values = cellString.split("-");
			os_changes_values = true;
		}
		if (values.length == 3 && !os_changes_values) {
			int day = Integer.parseInt(values[1]);
			int month = Integer.parseInt(values[0]);
			int year = Integer.parseInt(values[2]);
			int num = year * 10000 + month * 100 + day;
			return num;
		}
		else if(values.length == 3 && os_changes_values){
//			Calendar cal = Calendar.getInstance();
//			java.util.Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(values[1]);
//			cal.setTime(date);
//			System.out.println(cellString);
			int day = Integer.parseInt(values[0]);
			int month = dic.get(values[1]);
			int year = Integer.parseInt(values[2]);
			int num = year * 10000 + month * 100 + day;
			return num;
		}
		return 00000000;
	}

	public float dollarToInt(String cellString) {
		System.out.println(cellString.substring(1));
		return Float.parseFloat(cellString.substring(1));
	}

	public int volToInt(String cellString) {
		System.out.println((int)Float.parseFloat(cellString));
		return (int)Float.parseFloat(cellString);
	}

	public Map<String, hurricaneData> readHurricanekDataFile(String usersPath, int years) throws ParseException {
		try {
			//obtaining input bytes from a file
			fis = new FileInputStream(new File("nasdaq_db/hurricaneDB.xlsx"));

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
		Map<String, hurricaneData> data = new HashMap<>();
		int rowCount = 0;
		int relativeLoc = -1;
		int yearnum = 2012;
		for (Row row : sheet) {
			String name;int date;int category;int year;int month;int day;
			hurricaneData hD = new hurricaneData();
			for (Cell cell : row) {
				if(rowCount>=1) {
					//				System.out.println(dateToInt(cell.toString()));
					relativeLoc += 1;
					switch (relativeLoc) {
					case hurricaneName:
						break;
					case hurricaneSS:
//											System.out.println(dollarToInt(cell.toString()));
						break;

					case hurricaneDate:
						//					System.out.println(volToInt(cell.toString()));
						break;

					case hurricaneYear:
						//					System.out.println(dollarToInt(cell.toString()));
						break;

					case hurricanState:
						//					System.out.println(dollarToInt(cell.toString()));
						break;

					}

				}
				relativeLoc = -1;

			}
			rowCount++;
			return null;

		}
		return data;
		}
	}




