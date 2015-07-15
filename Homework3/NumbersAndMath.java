import java.util.*;

public class NumbersAndMath {
	
	/*Diverts control to secondary class*/
	public static void main(String[] args) {
		System.out.println("Please enter a number of seconds:");
		Scanner sc = new Scanner(System.in);
		
		String usrmsg = sc.nextLine();
		SecondToDateConverter stdc = new SecondToDateConverter(Integer.parseInt(usrmsg));
		System.out.println(stdc);
	}
}



class SecondToDateConverter {
	/*Globally accepted constants*/
	final int SECONDS_IN_MINUTE = 60;
	final int MINUTES_IN_HOUR = 60;
	final int HOURS_IN_DAY = 24;
	final int DAYS_IN_FORTNIGHT = 14;
	final int DAYS_IN_YEAR = 365;

	/*Declares variables and puts them into an "answer" array*/
	int years, fortnights, days, hours, minutes, seconds;
	int[] holdAnswers = {years, fortnights, days, hours, minutes, seconds};

	/*Standard initialzer for class, converts a given number of seconds to an easier to understand format*/
	public SecondToDateConverter(int seconds) {
		
		/*Minor calculations, for getting each unit, converted to seconds*/
		int[] holdDivisors = new int[5];
		holdDivisors[4] = SECONDS_IN_MINUTE;
		holdDivisors[3] = holdDivisors[4] * MINUTES_IN_HOUR;
		holdDivisors[2] = holdDivisors[3] * HOURS_IN_DAY;
		holdDivisors[1] = holdDivisors[2] * DAYS_IN_FORTNIGHT;
		holdDivisors[0] = holdDivisors[2] * DAYS_IN_YEAR;

		/*Converting seconds to each answer*/
		for (int i = 0; i < holdDivisors.length; i += 1) {
			holdAnswers[i] = seconds / holdDivisors[i];
			seconds %= holdDivisors[i];
		}

		/*Seconds left over*/
		holdAnswers[5] = seconds;
	}

	@Override
	public String toString() {
		String msg = "That is ";
		String y = holdAnswers[0] + " years, ";
		String f = holdAnswers[1] + " fortnights, ";
		String d = holdAnswers[2] + " days, ";
		String h = holdAnswers[3] + " hours, ";
		String m = holdAnswers[4] + " minutes, ";
		String s = "and " + holdAnswers[5] + " seconds. ";

		return msg + y + f + d + h + m + s; 
	}
}
