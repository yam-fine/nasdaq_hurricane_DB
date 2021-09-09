import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
	final static String totalExp = "total expectancy is :";
	final static String Exp3plus = "for hurricanes level 3 or higher the expectancy is :";
	final static String Exp4plus = "for hurricanes level 4 or higher the expectancy is :";
	final static String totalSd = "total standard deviation is :";
	final static String Sd3plus = "for hurricanes level 3 or higher the standard deviation is :";
	final static String Sd4plus = "for hurricanes level 4 or higher standard deviation is :";

	public static void main(String[] args) throws ParseException {
		ExcelFileReader Fr = new ExcelFileReader();
		String stocksName = "FLR STOCK";
		HashMap<Integer, dateData> dD = Fr.readStockDataFile("nasdaq_db/fulldata.xlsx");
		HashMap<String, ArrayList<hurricaneData>> hD = Fr.readHurricanekDataFile("nasdaq_db/hurricaneDB" +
																				 ".xlsx",2005, dD);
		DataAnalayzer datAnal = new DataAnalayzer(hD, dD,2002);
//		datAnal.findChangePerStorm(7);

		//the exp of all hurricanes in "life time of stock"
		float exp = datAnal.ExpectedVal(0);
		//the exp of all hurricanes in "life time of stock"
		float exp3plus = datAnal.ExpectedVal(3);
		//the sd of all hurricanes in "life time of stock"
		float exp4plus = datAnal.ExpectedVal(4);
		//the sd of all hurricanes in "life time of stock"
		float sd = datAnal.SD(0);
		//list of changes in stock per hurricane "life time of stock"
		float sd3plus = datAnal.SD(3);
		float sd4plus = datAnal.SD(4);
		//list of changes in stock per hurricane "life time of stock"
//		float[] avgPStorm = hD.avgPerStorm();
		//add change to reader file
		System.out.println(stocksName +"\n" + totalExp + exp +"\n"+ Exp3plus + exp3plus +"\n"+ Exp4plus + exp4plus +"\n");
		System.out.println(stocksName +"\n"+ totalSd + sd +"\n"+ Sd3plus + sd3plus +"\n"+ Sd4plus + sd4plus +"\n");

	}
}
