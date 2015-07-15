import java.util.*;

public class Baseball {

	public static void main(String[] args){
		/*Starting up a baseball game*/	
		Ball ball = new Ball();
		Pitcher pitcher = new Pitcher();
		Batter batter = new Batter();
		int maxBalls = 4;
		int maxStrikes = 3;
		int maxHits = 1;

		/*Beginning the game... Should last one at-bat*/
		while(maxBalls > 0 && maxStrikes > 0 && maxHits > 0) {
			pitcher.throwBall(ball);
			batter.swingAtBall(ball);

			if (ball.hit) {
				maxHits -= 1;		System.out.println("Hit!");
			}
			if (ball.strike) {
				maxStrikes -= 1;	System.out.println("Strike!");
			}
			if (ball.ball) {
				maxBalls -= 1;		System.out.println("Ball!");
			}
		}
	}
}

class Ball {
	int height = 0;
	boolean hit, strike, ball = false;

	public void reset() {
		height = 0;
		hit = false;
		strike = false;
		ball = false;
	}
}

class Pitcher{
	public void throwBall(Ball baseball) {
		Random r = new Random();
		baseball.reset();
		baseball.height = r.nextInt();
	}
}

class Batter {
	public void swingAtBall(Ball baseball) {
		/*Prompting and getting user input*/
		System.out.println("What height should I swing at? (1, 2, or 0 to not swing)");
		int swingHeight = (new Scanner(System.in)).nextInt();

		if (swingHeight == baseball.height && swingHeight != 0) 	baseball.hit = true;
		else if (swingHeight == baseball.height)					baseball.ball = true;
		else														baseball.strike = true;
	}
}