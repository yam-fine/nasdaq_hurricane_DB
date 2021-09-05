import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
	public static void main(String[] args) throws ParseException {
//		System.out.println("Hello world!");
		ExcelFileReader Fr = new ExcelFileReader();
		HashMap<Integer, dateData> dD = Fr.readStockDataFile("nasdaq_db/seconedchance.xlsx");
		HashMap<String, ArrayList<hurricaneData>> hD = Fr.readHurricanekDataFile("nasdaq_db/hurricaneDB" + ".xlsx");
		DataAnalayzer dA = new DataAnalayzer(hD,dD);
	}
}
