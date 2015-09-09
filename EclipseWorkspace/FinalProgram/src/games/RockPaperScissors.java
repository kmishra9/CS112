package games;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends Game {
	
	static HashMap<Integer, String> rps = new HashMap<Integer, String>();
	static int wins = 0;
	static int losses = 0;
	static boolean tied = false;

	/*Standard initializer for single game of Rock/Paper/Scissors*/
	public RockPaperScissors() {
		/*Defining number -> choice relationship*/
		rps.put(0, "rock");
		rps.put(1, "paper");
		rps.put(2, "scissors");
	}

	/**
	 * The AI then chooses randomly from Rock/Paper/Scissors and displays its choice, as well
	 * as the result
	 * @Param opponentNum - the user's choice, converted from RPS to a number (relationship in hashmap)
	 */
	private static void determineWinner(int opponentNum) {
		Random tRNG = new Random();
		int myNum = tRNG.nextInt(3);		//Making a random number between 0 and 3 

		/*Print what I picked*/
		System.out.println("I picked " + rps.get(myNum) + ".");

		/*We chose the same thing*/
		if (myNum == opponentNum) {
			System.out.println("It was a tie!");
			RockPaperScissors.tied = true;

		/*Losing situations: (myNum, opponentNum) -> (0,2), (1,0), (2,1)*/
		} else if (myNum - opponentNum == 1 || myNum - opponentNum == -2) {
			System.out.println("You lose!");
			RockPaperScissors.tied = false;
			losses += 1;
		
		/*If you did not tie and did not lose, you won*/
		} else {
			System.out.println("You win!");
			RockPaperScissors.tied = false;
			wins += 1;
		}
	}

	@Override
	public void playGame() {
		
		String answer = "";
		Scanner sc = new Scanner(System.in);
		
		/*Game loop will only end when user selects choice not to play another game*/
		while (!answer.equals("N")) {
			
			/*Start a new game by asking for a user choice*/
			System.out.println("\nPlease enter “S” for scissors, “R” for rock, or “P” for paper.");
			String usrmsg = sc.nextLine().toUpperCase();

			int selection;
			/*Converting answer to numerical equivalent*/
			if (usrmsg.equals("R")) 		selection = 0;
			else if (usrmsg.equals("P"))	selection = 1;
			else 							selection = 2;
			
			determineWinner(selection);

			/*Prompt user to see if they'd like to play another game, skip replay prompt altogether if tied*/
			boolean t = RockPaperScissors.tied;
			if (t) {
				System.out.println("Tie! Try again!");

			} else {
				System.out.println("Would you like to play again? (y/n)");
				answer = sc.nextLine().toUpperCase();
			}
		}

		/*Ending message*/
		int w = RockPaperScissors.wins;
		int l = RockPaperScissors.losses;
		System.out.println("You won " + w + " game(s) and lost " + l + " game(s).");
	}

}
