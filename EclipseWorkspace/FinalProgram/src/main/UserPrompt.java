package main;

import java.security.AllPermission;
import java.util.Scanner;

import games.Game;
import games.GuessTheNumber;
import games.RockPaperScissors;

public class UserPrompt {
	static Game[] allGames = new Game[] {new GuessTheNumber(), new RockPaperScissors()};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String choice;
		do {
			System.out.println("Play what?\n0 - Quit\n1 - Guess the Number\n2 - Rock Paper Scissors");
			choice = scanner.nextLine();		//Freakin nextInt was being a bitch so I went with the ghetto version
			
			if (!choice.equals("0"))	allGames[Integer.parseInt(choice) - 1].playGame();
			
		} while (!choice.equals("0"));
	}
	
}
