import java.util.*;

public class Teeball {
	public static void main(String[] args){
		/*Starting a new game of Teeball*/
		Ball ball = new Ball();
		Batter batter = new Batter();
		Fielder fielder = new Fielder();

		batter.swingAtBall(ball);
		fielder.fieldBall(ball);
	}
}

class Ball {
	int distanceHit;

	public Ball() {
		distanceHit = 0;
	}
}

class Batter {
	public void swingAtBall(Ball tBall) {
		/*Prompting and getting user input*/
		System.out.println("What strength should I hit the ball at?");
		int strength = (new Scanner(System.in)).nextInt();

		/*Figuring out percent chance that I only hit it 5 feet*/
		int onlyFiveFeet = strength * 15; 

		/*Calculating whether I only hit it 5 feet*/
		Random r = new Random();
		if (r.nextInt(100) < onlyFiveFeet) 		tBall.distanceHit = 5;
		else									tBall.distanceHit = r.nextInt(150) * strength;

		/*Showing how far I hit it*/
		System.out.println("Hit the ball " + tBall.distanceHit + " feet.");
	}
}

class Fielder {
	public void fieldBall(Ball tBall) {
		if (tBall.distanceHit <= 100)		System.out.println("Out");
		else								System.out.println("Hit");
	}
}