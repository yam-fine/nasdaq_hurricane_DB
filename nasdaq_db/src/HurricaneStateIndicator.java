/**
 * class holds final data we will use to calculate different kinds of indicators
 */
public class HurricaneStateIndicator {
	/**
	 * state that the hurricane passed through
	 */
	String stateName;
	/**
	 * the change in the following quarter
	 */
	float change;
	HurricaneStateIndicator(String name , float num){
		stateName = name;
		change = num;
	}
	String getStateName(){return stateName;}
	float getChange(){return change;}
}
