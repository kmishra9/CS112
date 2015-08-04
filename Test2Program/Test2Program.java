/*Test 2 Program*/

import java.util.*;

public class Test2Program {

	static final int timeInterval = 5;

	public static void main(String[] args){
		/*Opening my restaurant*/
		Appliance[] myRestaurant = new Appliance[4];
		myRestaurant[0] = new Fryer();
		myRestaurant[1] = new Fryer();
		myRestaurant[2] = new Grill();
		myRestaurant[3] = new Oven();

		/*Setting up some variables*/
		Scanner sc = new Scanner(System.in);
		int input;

		do {
			/*Displaying the menu*/
			System.out.println("Welcome to the Smallwood Cafe, please place your order (1, 2, 3, or 4):");
			System.out.println("\t1) Fried Rat\n\t2) Baked Rat\n\t3) Nothing\n\t4) Quit");

			/*Asking the user what they want*/
			input = sc.nextInt();

			/*Check if there's space for what they want... if there isn't tell em to wait*/
			switch (input) {
				case 1:
					checkRestaurantForPosition(new FriedRat(), myRestaurant);
					break;
				case 2:
					checkRestaurantForPosition(new BakedRat(), myRestaurant);
					break;
				case 3:
					System.out.println("Waiting 5 minutes...");
					break;
				case 4:
					System.out.println("Thanks for coming. I vote I get 100%");
					break;
				default:
					System.out.println("Not a valid command. Please enter 1, 2, 3, or 4");
					break;
			}

			if (input != 4) {
				addTime(myRestaurant, timeInterval);
			}
			
		} while (input != 4);
	}

	private static void checkRestaurantForPosition(Recipe food, Appliance[] restaurant) {
		for (Appliance a : restaurant) {
			if (food.canCookIn(a)) {
				a.takeFood(food);
				return;
			}
		}
		System.out.println("Please wait while we finish up some orders");
	}

	private static void addTime(Appliance[] restaurant, int timeInterval) {
		/*Abstraction for having time pass*/
		for (Appliance a : restaurant) 		a.addTime(timeInterval);
	}
}





