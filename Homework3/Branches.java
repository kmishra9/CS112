/**
 * Implements an RPS AI that will play forever if need be
 * @author Kunal Mishra
 */

import java.util.*;

public class Branches {
	
	/*Replay logic is abstracted from RPS class to main's game loop*/
	public static void main(String[] args){
		String answer = "";
		
		/*Game loop will only end when user selects choice not to play another game*/
		while (!answer.equals("N")) {
			
			/*Start a new game by asking for a user choice*/
			System.out.println("\nPlease enter “S” for scissors, “R” for rock, or “P” for paper.");
			Scanner sc = new Scanner(System.in);
			String usrmsg = sc.nextLine().toUpperCase();


			/*Converting answer to numerical equivalent*/
			if (usrmsg.equals("R")) {
				new RockPaperScissors(0);
			} else if (usrmsg.equals("P")) {
				new RockPaperScissors(1);
			} else {
				new RockPaperScissors(2);
			}


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


class RockPaperScissors {
	static HashMap<Integer, String> rps = new HashMap<Integer, String>();
	/* Yeah I know using static here is kind of hacky but I was lazy and it was 
	 * easier this way on top of what I had already
	 */
	static int wins = 0;
	static int losses = 0;
	static boolean tied = false;

	/*Standard initializer for single game of Rock/Paper/Scissors*/
	public RockPaperScissors(int selection) {
		/*Defining number -> choice relationship*/
		rps.put(0, "rock");
		rps.put(1, "paper");
		rps.put(2, "scissors");

		determineWinner(selection);
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
}