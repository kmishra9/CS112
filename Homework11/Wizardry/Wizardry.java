import java.util.*;

public class Wizardry {

	static final int DAMAGE = 10;
	

	public static void main(String[] args) {
		ArrayList<Student> myCharacters = new ArrayList<Student>();

		Scanner sc = new Scanner(System.in);
		int input;
		boolean inputIsGood = false;

		do {
			/*Displaying menu and getting choice*/
			System.out.println("What class would you like?");
			System.out.println("0) Done\n1) Hacker\n2) Gunslinger\n3) Inventor\n4) Boss");
			input = sc.nextInt();

			inputIsGood = input >= 0 && input <= 4;
			/*Adding the user's input to the arraylist*/
			addTo(input, myCharacters);

		} while (myCharacters.size() < 1 || ((!inputIsGood || myCharacters.size() < 6) && input != 0));		//Ew


		/*Damaging random characters*/
		System.out.println("Boom goes the dynamite");

		/*Displaying starting health*/
		System.out.println("Starting health");

		/*Randomly generating numbers (similar to hashing)*/
		int count = 0;
		int index = 0;
		int i = 30;				//Just a random number I chose

		while (count < 6) {
			printHealths(myCharacters);

			/*The index of the random student I'm choosing*/
			index = i % myCharacters.size();

			/*Inflicting damage and screaming*/
			Student s = myCharacters.get(index);
			s.setHealth(s.getHealth() - DAMAGE);
			s.scream(DAMAGE);


			/*Cleanup for next iteration*/
			i = (int) ((i + index) * 1.6);		//Just a random way to create a random next i lol too lazy to import the standard way
			count += 1;
		}

		System.out.println("Final health");
		printHealths(myCharacters);
	}

	public static void printHealths(List<Student> l) {
		String msg = "";
		for (Student s : l) {
			msg += s.getHealth();
			msg += "/";
		}
		System.out.println(msg);
	}

	/*Converts an int choice into its corresponding student class and puts into the list*/
	public static void addTo(int choice, List l) {
		Student toPut = null;

		switch (choice) {
			case 0:
				if (l.size() < 1)
					System.out.println("You must have at least one character");
				break;
			case 1:
				toPut = new Hacker();
				break;
			case 2:
				toPut = new Gunslinger();
				break;
			case 3:
				toPut = new Inventor();
				break;
			case 4:
				toPut = new Boss();
				break;
			default:
				System.out.println("That is not a choice");
				break;
		}

		if (toPut != null) {
			System.out.println("Added " + toPut);
			l.add(toPut);
		}
	}
}