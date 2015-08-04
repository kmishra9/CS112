
public abstract class Appliance {
	private Recipe foodInMe;

	public Appliance() {
		foodInMe = null;
	}

	public boolean canTakeFood() {
		return foodInMe == null;
	}

	public void takeFood(Recipe food) {
		foodInMe = food;
	}

	/*Abstraction, so I can just call addTime from main*/
	public void addTime(int time) {
		if (foodInMe != null)					
			cook(time);
	}

	/*Cooks if there's something to cook*/
	public void cook(int time) {
		foodInMe.cookFor(time);
		
		/*If the thing finished cooking, the appliance is free now*/
		if (foodInMe.doneCooking()) {
			System.out.println(this + " done cooking " + foodInMe);
			foodInMe = null;
		}
	}
}

class Oven extends Appliance {
	@Override
	public String toString() {
		return "Oven";
	}
}

class Fryer extends Appliance {
	@Override
	public String toString() {
		return "Fryer";
	}
}

class Grill extends Appliance {
	@Override
	public String toString() {
		return "Grill";
	}
}