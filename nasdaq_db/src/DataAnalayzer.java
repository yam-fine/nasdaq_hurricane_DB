import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//אני רוצה למצוא התאמה באמצעות דאטה יעני גש להוריקן ואחכ לך למניה בתאריכים שלנו תמצא ממוצע שבועי של הQ
public class DataAnalayzer {
	HashMap<String, ArrayList<hurricaneData>>  hD ;
	HashMap<Integer, dateData> dD;
	HashMap<String, Date> quarters;

	DataAnalayzer(HashMap<String, ArrayList<hurricaneData>> hd,HashMap<Integer, dateData> dd) throws ParseException {
		hD =hd;
		dD =dd;
		quarters = new HashMap<>() ;
		quarters.put("Q1",new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2021"));
		quarters.put("Q2",new SimpleDateFormat("dd/MM/yyyy").parse("7/4/2021"));
		quarters.put("Q3",new SimpleDateFormat("dd/MM/yyyy").parse("10/07/2021"));
		quarters.put("Q4",new SimpleDateFormat("dd/MM/yyyy").parse("14/11//2021"));
	}
	
	HashMap<String, ArrayList<HurricaneStateIndicator>> findChangePerStorm(){
		if( hD == null || dD == null){
			return null;
		}
		HashMap<String, ArrayList<HurricaneStateIndicator>> data = new HashMap<String, ArrayList<HurricaneStateIndicator>>();
		for (String str: hD.keySet()){
			for(hurricaneData dHrcn: hD.get(str)){
				if(dHrcn.getDate()/1000 >= 2005){
					int qNum = getQ(dHrcn.getDate());
					int earningsWeekAvg = getAvgOfWeek((qNum%4)+1,dHrcn.getYear());
					int intDate = dHrcn.getDate();
					float percent = earningsWeekAvg/ ((dD.get(intDate).getOpen()+dD.get(intDate).getClose())/2);
					float change = (percent - 1)*100;
					if (data.get(str) != null){
						data.put(str,new ArrayList<HurricaneStateIndicator>());
					}
					data.get(str).add(new HurricaneStateIndicator(dHrcn.getState(),change));
				}

			}
		}
		float expectancy  = findExpectancy(int level);
		float sD  = findStandarddeviation(int level);

		return data;
	}

	private int getAvgOfWeek(int i,int year) {
			Date firstDay = quarters.get(i);
			Calendar cal = new GregorianCalendar();
			cal.setTime(firstDay);
			cal.get(Calendar.YEAR);
			int first = year * 1000 + cal.get(Calendar.MONTH) * 10 + cal.get(Calendar.DAY_OF_MONTH);
			int dayCounter = 0; int totalVal = 0;
			for (int day = first; day < first + 8; day++){
				if(dD.get(day) != null){
					dayCounter++;
					totalVal += (dD.get(day).getClose() + dD.get(day).getOpen())/2;
				}
			}
			if(totalVal ==0){return 0;}
			return totalVal/dayCounter;
	}

	private int getQ(int date) {
		int month  = (date % 1000) / 10;
		if(month == 11 || month == 12 || month == 1){
			return 1;
		}
		if( 2<= month && month <=4){
			return 2;
		}
		if(5<= month && month <=7){
			return 3;
		}
		return 4;
	}
	
}
