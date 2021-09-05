public class HurricaneStateIndicator {
	String stateName;
	float change;
	HurricaneStateIndicator(String name , float num){
		stateName = name;
		change = num;
	}
	String getStateName(){return stateName;}
	float getChange(){return change;}
}
