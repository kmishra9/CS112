import java.util.*;

public class ExcelAtArrays {
	/*Default current state of league*/
	String[] teams = new String[0];
	int[] wins = new int[0];
	int[] losses = new int[0];
	int numberOfTeams = 0;

	public static void main(String[] args) {
		new ExcelAtArrays();
	}
	

	public ExcelAtArrays() {
		System.out.println("Howdy sports fan!");
		Integer answer = -1;
		do {
			/*Display the menu, get the user's choice*/
			answer = menu();

			/*Use the choice to determine control of the program*/
			takeChoice(answer);

		} while (answer != 5);		//Exit when asked to quit

		System.out.println("Order Dreadball today!");
	}

	/*Abstraction for displaying menu and getting the user's choice*/
	private static int menu() {
		/*Print the menu*/
		System.out.println("Please pick an option from the list below:");
		System.out.println("1) Create league");
		System.out.println("2) List all teams");
		System.out.println("3) Record a win");
		System.out.println("4) Record a loss");
		System.out.println("5) Quit");

		/*Initialize a scanner that will get the user's choice*/
		Scanner sc = new Scanner(System.in);
		/*Get the choice*/
		try {
			Integer userChoice = sc.nextInt();

			/*If the choice was valid, return it*/
			if (userChoice <= 5 && userChoice >= 1)	return userChoice;

		} catch (Exception e) {
			/*There was some problem... Just let it return -1*/
		}

		/*Every non valid choice*/
		return -1;
	}

	/*Abstraction for control flow after choice is selected*/
	private void takeChoice(int userChoice) {
		/* Switches can't use null... which is stupid... Probably because they use .equals, not == 
		 * or it tries to unbox Integer to int, which is also not great
		 */
		String added;

		switch (userChoice) {
			/*Replace the "current" league*/
			case 1:
				createLeague();
				break;

			/*List out all the teams of the league*/
			case 2:
				if (numberOfTeams == 0) {
					System.out.println("There are no teams\n");
					return;
				}

				listAllTeams();
				System.out.println("\n");
				break;
			
			/*Add wins to a team*/
			case 3:
				/*Check to make sure there are teams*/
				if (numberOfTeams == 0) {
					System.out.println("There are no teams\n");
					return;
				}
				/*Make proper additions to the right team*/
				System.out.println("Which team won a game?");
				added = addToTeam(wins);
				
				if (added != null)
					System.out.println(added + "win(s)\n");
				else
					takeChoice(userChoice);

				break;

			/*Add losses to a team*/
			case 4:
				/*Check to make sure there are teams*/
				if (numberOfTeams == 0) {
					System.out.println("There are no teams\n");
					return;
				}
				/*Make proper additions to the right team*/
				System.out.println("Which team lost a game?");
				added = addToTeam(losses);

				if (added != null) 
					System.out.println(added + "loss(es)\n");
				else 
					takeChoice(userChoice);

				break;
			
			/*Do nothing, user is quitting*/
			case 5:
				break;
			
			/*I picked an invalid choice*/
			default:
				System.out.println("That is not a choice.\n");
				break;
		}
	}

	/*Abstraction for creating a league*/
	private void createLeague() {
		/*Prompting user*/
		System.out.println("How many teams should I make?");
		/*Getting answer*/
		Scanner sc = new Scanner(System.in);
		Integer numberOfTeams;
		try {
			numberOfTeams = sc.nextInt();
		
		} catch (Exception e) {
			System.out.println("Invalid choice. Please enter a positive integer.\n");
			createLeague();
			return;
		}

		/*Creating a new league using the three arrays*/
		teams = new String[numberOfTeams];
		wins = new int[numberOfTeams];
		losses = new int[numberOfTeams];
		this.numberOfTeams = numberOfTeams;

		/*Resetting the pointer*/
		sc.nextLine();

		/*Filling the league up*/
		for (int i = 0; i < numberOfTeams; i += 1) {
			System.out.println("Team " + (i + 1) + "'s name?");
			teams[i] = sc.nextLine();
		}
	}

	/*Abstraction for showing the league*/
	private void listAllTeams() {
		System.out.println("\t\tW\tL");
		for (int i = 0; i < numberOfTeams; i += 1) {
			System.out.println(teams[i]  + "\t\t" + wins[i] + "\t" + losses[i]);
		}
	}

	/*Abstraction for adding "something" to a team*/
	private String addToTeam(int[] teamWL) {
		/*Ask the user for a team*/
		Scanner sc = new Scanner(System.in);
		String lookForThisTeam = sc.nextLine();

		/*Look for it in teams*/
		for (int i = 0; i < numberOfTeams; i += 1) {
			if (lookForThisTeam.equals(teams[i])) {
				teamWL[i] += 1;
				return lookForThisTeam + " now has " + teamWL[i];
			}
		}

		System.out.println("That is not a team");
		return null;
	}
}
	