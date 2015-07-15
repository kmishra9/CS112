package MyBag;

import java.util.*;

public class Input {
	
	public static int getGoodInt(int low, int high) {
		Scanner sc = new Scanner(System.in);

		int userInput = 0;
		boolean haveGoodInt = false;

		while (!haveGoodInt) {
			userInput = sc.nextInt();
			haveGoodInt = userInput >= low && userInput <= high; 
		}
		return userInput;
	}

}
	