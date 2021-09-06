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
		float exp = hD.findExpectancy();
		//the sd of all hurricanes in "life time of stock"
		float sd = hD.findStandarddeviation();
		//list of changes in stock per hurricane "life time of stock"
		float[] avgPStorm = hD.avgPerStorm();
		//add change to reader file
		HashMap<String,ArrayList<hurricaneData>> stateToHurricane = new HashMap<>();
		//changeData holds hurricanes name data and affect on stock
		HashMap<String,ArrayList<changeData>> stateToPercentage = new HashMap<>();
		for (String str : states){
			stateToCercentage.put(str, hD.AvgPerState(stateName,level));
		}

		String state = findClosestStateToStorm();

		//stock SYMBOL


		//		DataAnalayzer dA = new DataAnalayzer(hD,dD);
//		dA.findChangePerStorm();
		System.out.println("sssssssssssssssssssssss");

	}
}
