import java.util.Date;

public class hurricaneData {
	private final String name;
	private final String state;
	private final int category;
	private final int date;
	private final int year;
	private final int month;
	private final int day;


	public hurricaneData(String name, int category, int date, int y, int m, int d,String state){
		this.name = name;
		this.category = category;
		this.date = date;
		this.year = y;
		this.month = m;
		this.day = d;
		this.state = state;
	}

	public String getName(){return name;}
	public int getCategory(){return category;}
	public int getDate(){return date;}
	public int getYear(){return year;}
	public int getMonth(){return month;}
	public int getDay(){return day;}
}
