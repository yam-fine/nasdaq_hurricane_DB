import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class hurricaneData {
	private final String name;
	private final String state;
	private final int category;
	private final int date;
	private final int year;
	private final int month;
	private final int day;
	private final float avgPriceOfWeek;
	private final float avgPrice3MLATER;



	public hurricaneData(String name, int category, int y, int m, int d,String state,float apow,float ap3ml){
		this.name = name;
		this.category = category;
		this.year = y;
		this.month = m;
		this.day = d;
		this.state = state;
		this.avgPriceOfWeek = apow;
		this.avgPrice3MLATER = ap3ml;
		this.date = year*10000+month*100+day;
	}
	public String getName(){return name;}
	public String getState(){return state;}
	public int getCategory(){return category;}
	public int getDate(){return date;}
	public int getYear(){return year;}
	public int getMonth(){return month;}
	public int getDay(){return day;}
	public float avgPriceOfWeek(){return day;}
	public float avgPrice3MLATER(){return day;}
	public float getChange(){
		if(avgPriceOfWeek == 0 || avgPrice3MLATER == 0){
			return 0;
		}
		else {
			return ((this.avgPrice3MLATER / this.avgPriceOfWeek)-1)*100;
		}
	}

}
