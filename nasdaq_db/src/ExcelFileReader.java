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
public class ExcelFileReader {

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

	public HashMap<Integer, dateData> readStockDataFile(String usersPath) throws ParseException {
		try {
			//obtaining input bytes from a file
			fis = new FileInputStream(new File(usersPath));

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
		HashMap<Integer, dateData> data = new HashMap<>();
		int rowCount = 0;
		int relativeLoc = -1;
		int date = 0;float close = 0,open = 0 ,high = 0,low = 0;int volume = 0;
		for (Row row : sheet) {
			if(rowCount>=1) {
				for (Cell cell : row) {
					//System.out.println(dateToInt(cell.toString()));
					relativeLoc += 1;
					switch (relativeLoc) {
					case stockDate:
//						System.out.println(dateToInt(cell.toString()));
						date = dateToInt(cell.toString());
						break;
					case stockClose:
//						System.out.println(dollarToInt(cell.toString()));
						close = dollarToInt(cell.toString());
						break;
					case stockVolume:
//						System.out.println(volToInt(cell.toString()));
						volume = volToInt(cell.toString());
						break;
					case stockOpen:
//						System.out.println(dollarToInt(cell.toString()));
						open = dollarToInt(cell.toString());
						break;
					case stockHigh:
						//System.out.println(dollarToInt(cell.toString()));
						high = dollarToInt(cell.toString());
						break;
					case stockLow:
						//System.out.println(dollarToInt(cell.toString()));
						low = dollarToInt(cell.toString());
					}
				}
//				System.out.println(close+" "+open+" "+high+" "+low+" "+volume+" "+date);
				dateData dD = new dateData(close,volume,open,high,low);
				data.put(date, dD);
				//System.out.println(rowCount);
				//return null;
			}
			rowCount++;
			relativeLoc = -1;
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
//			System.out.println(cellString);
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
//		System.out.println(cellString);
		return Float.parseFloat(cellString);
	}

	public int volToInt(String cellString) {
//		System.out.println((int)Float.parseFloat(cellString));
		return (int)Float.parseFloat(cellString);
	}

	/*
		function Purpose is to get hurricanes data file and put the data into hash table
	 */
	public HashMap<String, ArrayList<hurricaneData>> readHurricanekDataFile(String usersPath, int years,
																			HashMap<Integer, dateData> stockData) throws ParseException {
		try {
			//obtaining input bytes from a file
			fis = new FileInputStream(new File(usersPath));

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
		HashMap<String, ArrayList<hurricaneData>> data = new HashMap<>();
		int rowCount = 0;
		int relativeLoc = -1;
		for (Row row : sheet) {
			String name = null; String state = null; int category = 0;
			int year = 0;int month = 0;int day = 0;
			for (Cell cell : row) {
				if(rowCount>=1) {
					relativeLoc += 1;
					switch (relativeLoc) {
					case hurricaneName:
						name = cell.toString();
						break;
					case hurricaneSS:
						category = Integer.parseInt(cell.toString().substring(9,10));
						break;
					case hurricaneDate:
						Date arr = new SimpleDateFormat("dd-MMM-yyyy").parse(cell.toString());
						Calendar cal = new GregorianCalendar();
						cal.setTime(arr);
						cal.get(Calendar.YEAR);
//						System.out.println(cal.get(Calendar.MONTH)+"  "+cal.get(Calendar.DAY_OF_MONTH));
						month = cal.get(Calendar.MONTH)+1;
						day = cal.get(Calendar.DAY_OF_MONTH);
						break;

					case hurricaneYear:
						year = (int)Float.parseFloat(cell.toString());
						//System.out.println(dollarToInt(cell.toString()));
						break;

					case hurricanState:
						state = cell.toString();
						//System.out.println(dollarToInt(cell.toString()));
						break;
					}
//					System.out.println(name+" "+category+" "+" "+year+" "+month+" "+day+" "+state);


				}


			}
//			System.out.println(name+" + "+category+" + "+date+" + "+year+" + "+month+" + "+day+" + "+state);

			int date = year * 10000 + month * 100 + day;

			float avgPriceOfWeek = getAvgOfDate(date,10,stockData);

			int dateXMLater = calculateXMonthLater(3,year,month,day);

			float avgPrice3MLATER = getAvgOfDate(dateXMLater,10,stockData);

			hurricaneData hD = new hurricaneData(name,category,year,month,day,state,avgPriceOfWeek,avgPrice3MLATER);
			if (data.get(name) == null){
				data.put(name,new ArrayList<>());
			}
			data.get(name).add(hD);
			relativeLoc = -1;
			rowCount++;
		}
		return data;
	}

	private int getAvgOfDate(int date,int numofdays,HashMap<Integer, dateData> dD) {

		int dayCounter = 0; int totalVal = 0;
		for (int day = date; day < date+numofdays + numofdays; day++){
			if(dD.get(day) != null){
				dayCounter++;
				totalVal += (dD.get(day).getClose() + dD.get(day).getOpen())/2;
			}
		}
		if(totalVal ==0){return 0;}
		return totalVal/dayCounter;
	}

	private int calculateXMonthLater(int x,int year, int month, int day) {
		if(month+x <= 12){
			return year*10000 + (month+x)*100 + day;
		}
		else {
			return (year+1)*10000 + (month+x-12)*100+ day;
		}


	}
}




