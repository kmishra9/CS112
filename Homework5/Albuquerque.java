import java.util.*;


public class Albuquerque {
	Character[][] board;
	final int BOARD_SIZE = 12;
	final int periodAscii = 46;
	final int spaceAscii = 32;
	final int xAscii = 88;
	final int oAscii = 111;

	/*Monitors the state of my two "animals"*/
	Point x;
	Point o;

	public static void main(String[] args) {
		new Albuquerque();
	}

	public Albuquerque() {
		/*Create the board and fill it with defaults and initial start*/
		board = new Character[BOARD_SIZE][BOARD_SIZE];
		fillWithDots();

		/*Start the GUI loop*/
		Scanner sc = new Scanner(System.in);
		while (true) {
			/*Draw the board as it currently is*/
			drawBoard();
			
			/*Get the user's input and move o or quit*/
			String input = sc.nextLine();
			if (input.toUpperCase().equals("X")) {
				System.out.println("I knew I should have taken that left turn at Albuquerque.");
				return;
			}
			move(input);

			/*End the game if o is on top of x*/
			if (o.amOnTop(x)) {
				drawBoard();
				System.out.println("You win!");
				return;
			}
			/*Seperation between maps*/
			System.out.println("\n\n");
		}
		
	}

	/*Fills the entire board with dots and randomly selects two positions to put the x and o*/
	private void fillWithDots() {
		Random rand = new Random();

		/*Finding random points to put x and y*/
		x = new Point(rand.nextInt(BOARD_SIZE), rand.nextInt(BOARD_SIZE));
		o = new Point(rand.nextInt(BOARD_SIZE), rand.nextInt(BOARD_SIZE));

		/*Filling the board with dots*/
		for (int i = 0; i < BOARD_SIZE; i += 1) {
			for (int j = 0; j < BOARD_SIZE; j += 1) {

				/*Place the x here*/
				if (i == x.i && j == x.j)		board[i][j] = (char) xAscii;
				/*Place the o here*/
				else if (i == o.i && j == o.j)	board[i][j] = (char) oAscii;
				/*Default, just dots*/
				else 							board[i][j] = (char) periodAscii;
			}
		}
	}

	/*Seperates the GUI from board logic... Simply draws the state of the board*/
	private void drawBoard() {
		for (int i = 0; i < BOARD_SIZE; i += 1) {
			for (int j = 0; j < BOARD_SIZE; j += 1) System.out.print(board[i][j] + "   ");
			System.out.println("\n");
		}

	}

	/*Abstraction for moving using the w, a, s, and d keys*/
	private void move(String input) {
		switch (input.toLowerCase()) {
			case "w":
				/*Out of bounds*/
				if (o.i == 0) {
					System.out.println("Invalid move");
					return;
				}
				/*Moving it up*/
				replaceWithSpace(o.i, o.j);
				o.i -= 1;					
				replaceWithO(o.i, o.j);
				break;

			case "a":
				/*Out of bounds*/
				if (o.j == 0) {
					System.out.println("Invalid move");
					return;
				}
				/*Moving it left*/
				replaceWithSpace(o.i, o.j);
				o.j -= 1;					
				replaceWithO(o.i, o.j);
				break;

			case "s":
				/*Out of bounds*/
				if (o.i == BOARD_SIZE - 1) {
					System.out.println("Invalid move");
					return;
				}
				/*Moving it down*/
				replaceWithSpace(o.i, o.j);
				o.i += 1;					
				replaceWithO(o.i, o.j);
				break;

			case "d":
				/*Out of bounds*/
				if (o.j == BOARD_SIZE - 1) {
					System.out.println("Invalid move");
					return;
				}
				/*Moving it rightt*/
				replaceWithSpace(o.i, o.j);
				o.j += 1;					
				replaceWithO(o.i, o.j);
				break;
			
			default:
				System.out.println("Unsupported move");
				break;
		}
	}

	/*Abstraction for replacing a dot or previous Point with a space*/
	private void replaceWithSpace(int i, int j) {
		board[i][j] = (char) spaceAscii;
		return;
	}

	/*Abstraction for replacing a dot with the new position of O*/
	private void replaceWithO(int i, int j) {
		board[i][j] = (char) oAscii;
		return;
	}	
}

class Point {
	int i,j;
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public boolean amOnTop(Point other) {
		return other.i > this.i && other.j == this.j;
	}
}