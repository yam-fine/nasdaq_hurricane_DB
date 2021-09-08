import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
	public static void main(String[] args) throws ParseException {
//		System.out.println("Hello world!");
		ExcelFileReader Fr = new ExcelFileReader();
		HashMap<Integer, dateData> dD = Fr.readStockDataFile("nasdaq_db/seconedchance.xlsx");
		HashMap<String, ArrayList<hurricaneData>> hD = Fr.readHurricanekDataFile("nasdaq_db/hurricaneDB.xlsx",2005);
		String[] states = hD.getStates;
		//the exp of all hurricanes in "life time of stock"
		float exp = hD.findExpectancy(0);
		//the exp of all hurricanes in "life time of stock"
		float exp3plus = hD.findExpectancy(3);
		//the sd of all hurricanes in "life time of stock"
		float exp4plus = hD.findExpectancy(4);
		//the sd of all hurricanes in "life time of stock"
		float sd = hD.findStandarddeviation(0);
		//list of changes in stock per hurricane "life time of stock"
		float sd3plus = hD.findStandarddeviation(3);
		float sd4plus = hD.findStandarddeviation(4);
		//list of changes in stock per hurricane "life time of stock"
		float[] avgPStorm = hD.avgPerStorm();
		//add change to reader file
		System.out.println("sssssssssssssssssssssss");

	}
}
