//public static final int Date = 0;
//public static final int Close = 1;
//public static final int Volume = 2;
//public static final int Open = 3;
//public static final int High = 4;
//public static final int Low = 5;
public class dateData {
	public int Close ;
	public int Volume ;
	public int Open ;
	public int High ;
	public int Low ;
	//counts the amount of data that was inserted, helps to validate the data
	public int Counter = 0 ;
	//indicator to the state of the data true means the data is kosher otherwise there is a problem
	boolean Valid = false;
	void initClose(int close){
		Close = close;
		Counter++;
	}
	void initVolume(int volume){
		Volume = volume;
		Counter++;
	}
	void initOpen(int open){
		Open = open;
		Counter++;
	}
	void initHigh(int high){
		High = high;
		Counter++;
	}
	void initLow(int low){
		Low = low;
		Counter++;
		if(Close != 0 && Volume != 0 && Open != 0 && High != 0 && Low != 0 && Counter ==5){
			Valid = true
		}
	}
	int getClose(){
		return Close;
	}
	int getVolume(int volume){
		return Volume ;
	}
	int getOpen(int open){
		return Open ;
	}
	int getHigh(int high){
		return High ;
	}
	int getLow(int low){
		return Low ;
	}

}
