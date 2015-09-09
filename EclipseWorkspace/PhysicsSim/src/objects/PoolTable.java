package objects;

import java.awt.Point;
import java.util.Random;

public class PoolTable {
	private Ball ball;
	private final int WIDTH;
	private final int HEIGHT;
	private final int LOOPTIME;
	
	public PoolTable(int w, int h, int bRadius, int LOOPTIME) {
		//Storing the width + height + looptime of the PoolTable
		this.WIDTH = w;
		this.HEIGHT = h;
		this.LOOPTIME = LOOPTIME;
		
		//Getting random coordinates for the ball's starting position
		Random r = new Random();
		int randomX = r.nextInt(WIDTH);
		int randomY = r.nextInt(HEIGHT);
		
		//Creating a new ball with the given radius and a random starting point
		this.ball = new Ball(bRadius, randomX, randomY, LOOPTIME);
	}
	
	public void applyForce(int force, int xPos, int yPos) {
		//Finding difference between vector origin and ball
		double deltaX = ball.x - xPos;
		double deltaY = ball.y - yPos;
		
		//Finding theta
		double theta = Math.atan(deltaY / deltaX) * 180 / Math.PI;
		
		//Finding force components
		double yForce = force * Math.sin(theta);
		double xForce = force * Math.cos(theta);
		
		//Updating ball (yay for hella abstraction which is actually the most important thing ever for projects like this)
		ball.update(xForce, yForce);
		bounce();
		
		//UNCOMMENT ME FOR USEFUL OUTPUT
		//System.out.println(ball.x + ", " + ball.y);
	}
	
	//Method that checks if the ball should bounce and computes new 
	private void bounce() {
		/*
		 * 0,0 			WIDTH, 0
		 * 
		 * 0, HEIGHT	WIDTH, HEIGHT
		 */
		
		//Right side check (invert horizontal speed and make sure ball doesn't pass the sidesß
		if (ball.x + ball.RADIUS >= WIDTH) {
			ball.horizontalBounce();
			ball.x = WIDTH - ball.RADIUS;
		} else if (ball.x - ball.RADIUS <= 0) {
			ball.horizontalBounce();
			ball.x = 0 + ball.RADIUS;
		}
		
		//Test case for justifying separation of ifs: corner cases, literally. Bouncing off of (0,0)
		if (ball.y + ball.RADIUS >= HEIGHT) {
			ball.verticalBounce();
			ball.y = HEIGHT - ball.RADIUS;
		} else if (ball.y - ball.RADIUS <= 0) {
			ball.verticalBounce();
			ball.y = 0 + ball.RADIUS;
		}	
	}
	
	//The approximate position of the ball
	public Point ballPosition() {
		return new Point((int) ball.x, (int)ball.y);
	}
	
	//The radius of the ball
	public int ballRadius() {
		return (int) ball.RADIUS;
	}
}
