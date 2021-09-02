import java.util.Date;

public class hurricaneData {
	private String name;
	private int category;
	private Date date;
	private int year;
	private int month;
	private int day;

	public void init(String name, int category, Date date, int y, int m, int d){
		this.name = name;
		this.category = category;
		this.date = date;
		this.year = y;
		this.month = m;
		this.day = d;
	}

	public String getName(){return name;}
	public int getCategory(){return category;}
	public Date getDate(){return date;}
	public int getYear(){return year;}
	public int getMonth(){return month;}
	public int getDay(){return day;}
}
