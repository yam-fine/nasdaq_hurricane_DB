import java.util.Date;

//public static final int Date = 0;
//public static final int Close = 1;
//public static final int Volume = 2;
//public static final int Open = 3;
//public static final int High = 4;
//public static final int Low = 5;
public class dateData {
	private final float Close ;
	private final int Volume ;
	private final float Open ;
	private final float High ;
	private final float Low ;
	//indicator to the state of the data true means the data is kosher otherwise there is a problem
	boolean Valid = false;
	dateData(float close, int volume, float open, float high, float low){
		this.Close = close;
		this.Volume = volume;
		this.Open = open;
		this.High = high;
		this.Low = low;
		if(Close!=0&&Volume!=0&&Open!=0&&High!=0&&Low!=0){
			Valid = true;
		}
	}


	float getClose(){ return Close;	}
	int getVolume(){ return Volume; }
	float getOpen(){ return Open; }
	float getHigh(){ return High; }
	float getLow(){	return Low;	}
}
