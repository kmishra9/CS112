package games;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber extends Game {
	
	int randomNumber;
	
	public GuessTheNumber() {
		/*Making random number*/
		Random r = new Random();
		randomNumber = r.nextInt(100) + 1;
	}

	public boolean guessNumber(int x) {
		if (x == randomNumber) {
			System.out.println("You are the smartest person alive!");
		} else if (x < randomNumber) {
			System.out.println("Higher");
		} else {
			System.out.println("Lower");
		}

		return x == randomNumber;
	}
	
	@Override
	public void playGame() {
		/*Prompting user*/
		System.out.println("Pick a number between 1 and 100");
		Scanner sc = new Scanner(System.in);

		/*Giving them chances to guess*/
		int chances = 0;
		int newGuess;
		while (chances < 5) {
			newGuess = sc.nextInt();
			
			if (guessNumber(newGuess))	
				break;
				
			int absoluteDifference = Math.abs(randomNumber - newGuess);
			
			if (chances == 3) {
				System.out.println("This is your last chance. Your last guess was off by " 
					+ absoluteDifference + "...");
			}	

			chances += 1;
		}
	}

}
