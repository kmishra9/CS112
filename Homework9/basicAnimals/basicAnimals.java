package basicAnimals;


public class basicAnimals {
	//Ugh, did we really need to make TWO of each class?
	public static void main(String[] args){
		//Making animals
		Pigeon pg1 = new Pigeon();
		Pigeon pg2 = new Pigeon();
		Dove d1 = new Dove();
		Dove d2 = new Dove();
		Rabbit r1 = new Rabbit();
		Rabbit r2 = new Rabbit();
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Gecko g1 = new Gecko();
		Gecko g2 = new Gecko();
		Snake s1 = new Snake();
		Snake s2 = new Snake();

		//Doing stuff
		d1.move();
		c2.move();
		g1.move();
		d1.eat("bug");
		r2.breathe();
	}
}

class Pigeon {
	final String whatIEat = "bread";
	final String howImove = "flies";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "pigeon";
	}
}

class Dove {
	final String whatIEat = "rice";
	final String howImove = "flies";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "dove";
	}
}

class Rabbit {
	final String whatIEat = "grass";
	final String howImove = "hops";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "rabbit";
	}
}

class Cat {
	final String whatIEat = "children and dreams";
	final String howImove = "runs";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "cat";
	}
}

class Gecko {
	final String whatIEat = "bugs";
	final String howImove = "crawls";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "gecko";
	}
}

class Snake {
	final String whatIEat = "mice";
	final String howImove = "slithers";

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void move() {
		System.out.println("A " + this + " " + howImove);
	}

	public void breathe() {
		System.out.println("A " + this + " can breathe.");
	}

	@Override
	public String toString() {
		return "snake";
	}
}





