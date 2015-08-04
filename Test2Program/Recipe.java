
public abstract class Recipe {
	private int totalCookTime;					//However long it needs to cook
	private int beenCookingFor = 0;				//However long it has already cooked
	
	public Recipe(int totalCookTime) {
		this.totalCookTime = totalCookTime;
	}

	/*Returns true only if the recipe has cooked for as long as it needs to*/
	public boolean doneCooking() {
		return totalCookTime == beenCookingFor;
	}

	/*Checks to see if the appliance coming is the correct type to cook the recipe*/
	public abstract boolean canCookIn(Appliance a);

	/*Responsible for cooking the rat over a given time interval... Glorified setter method*/
	public void cookFor(int time) {
		beenCookingFor += time;
	}
}

class BakedRat extends Recipe {
	public BakedRat() {
		super(25);
	}

	@Override
	public boolean canCookIn(Appliance a) {
		return a.canTakeFood() && a instanceof Oven;			//Not optimal but I was blanking on how to do this slightly more efficiently. Maybe a .equals? 
	}

	@Override
	public String toString() {
		return "baked rat";
	}
}

class FriedRat extends Recipe {
	public FriedRat() {
		super(10);
	}

	public boolean canCookIn(Appliance a) {
		return a.canTakeFood() && a instanceof Fryer;
	}

	@Override
	public String toString() {
		return "fried rat";
	}
}