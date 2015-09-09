package objects;

public class Ball {
	//	M
	double x;
	double y;
	//	M/s
	double xVelocity;
	double yVelocity;
	//	M/S^2
	double xAccel;
	double yAccel;
	//	Newtons
	double xForce;
	double yForce;
	
	final int RADIUS;			//Meters
	final double FRICTION = -5;		//Newtons
	final double MASS = 1;			//Kilograms
	final int secondsPerLoop;
	
	/*Constructor takes in a radius and random starting coordinates and seconds per loop*/
	public Ball(int r, int randomX, int randomY, int secondsPerLoop) {
		this.RADIUS = r;
		this.x = randomX;
		this.y = randomY;
		this.secondsPerLoop = secondsPerLoop;
		
		update(0, 0);
	}
	
	private void updateForce(double xForce, double yForce) {
		this.xForce += xForce;
		this.yForce += yForce;
	}
	
	private void updateAcceleration(double xAccel, double yAccel) {
		this.xAccel += xAccel;
		this.yAccel += yAccel;
	}
	
	private void updateVelocity(double xVelocity, double yVelocity) {
		this.xVelocity += xVelocity;
		this.yVelocity += yVelocity;
	}
	
	private void updatePosition(double xCoord, double yCoord) {
		this.x += xCoord;
		this.y += yCoord;
	}
	
	private void resetForceAndAccel() {
		xForce = 0;
		yForce = 0;
		xAccel = 0;
		yAccel = 0;
	}
	
	private void applyFriction() {
		updateForce(FRICTION * secondsPerLoop, FRICTION * secondsPerLoop);
	}
	
	//Takes in force components and trrigers update of ball attributes (only PoolTable should be able to access this, not GUI)
	void update(double xForce, double yForce) {
		
		//Specify net force/time here so you only have to do it once (only reference secondsPerLoop at the top level)
		updateForce(xForce * secondsPerLoop, yForce * secondsPerLoop);
		
		//Apply friction
		applyFriction();
		
		updateAcceleration(this.xForce/MASS, this.yForce/MASS);
		
		updateVelocity(xAccel, yAccel);
		
		updatePosition(xVelocity, yVelocity);
		
		//Assume force is instantaneous not continuous
		resetForceAndAccel();
		
		
	}
	
	//Handling a bounce (simply the component's velocity inverse)
	public void horizontalBounce() {
		xVelocity *= -1;
	}
	
	public void verticalBounce() {
		yVelocity *= -1;
	}
}
