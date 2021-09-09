import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataAnalayzer {
	HashMap<String, ArrayList<hurricaneData>>  hD ;
	HashMap<Integer, dateData> dD;
	HashMap<String, Date> quarters;
	int mY;


	DataAnalayzer(HashMap<String, ArrayList<hurricaneData>> hd,HashMap<Integer, dateData> dd,int minimalYear) throws ParseException {
		hD =hd;
		dD =dd;
		quarters = new HashMap<>() ;
		mY = minimalYear;
	}
	

//מבחינתי הוריקן בכל מדיה הוא הוריקן שונה יע ני אם יש הוריקן ב3 מדינות זה 3 הוריקנים
	public float ExpectedVal(int level){
		float exp = 0;
		int count = 0;
		//iterate over all hurricanes
		for (String name : hD.keySet()){
			for(hurricaneData hsi : hD.get(name)){
			if(name != null && hsi != null && !name.equals("Unnamed")&& hsi.getYear()>= mY && hsi.getCategory() >= level && hsi.getChange()!= 0) {
				exp += hsi.getChange();
				count++;
			}
		}
		}
		return exp / count;
	}

	public float SD(int level){
		double exp = 0;
		int count = 0;
		double eVSqr = ExpectedVal(level);
		for (String name : hD.keySet()){
			for(hurricaneData hsi : hD.get(name)) {
				if (name != null && hsi != null && !name.equals("Unnamed") && hsi.getYear()>= mY && hsi.getCategory() >= level && hsi.getChange()!= 0) {
					exp += Math.pow((eVSqr-hsi.getChange()), 2);
					count++;
				}
			}

		}
		return (float) Math.sqrt(Math.abs(exp/count));
	}

	
}
