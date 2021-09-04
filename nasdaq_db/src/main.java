import java.text.ParseException;

public class main {
	public static void main(String[] args) throws ParseException {
//		System.out.println("Hello world!");
		ExcelFileReader Fr = new ExcelFileReader();
//		Fr.readStockDataFile("path");
		Fr.readHurricanekDataFile("path",34);
	}
}
