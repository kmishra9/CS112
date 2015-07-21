package acidicAnimals;

public class acidicAnimals {
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
		s1.eat("bug");
		s1.eat("mouse");
	}
}

/* Made the design decision to make Animal, Bird, Mammal, and Reptile all abstract because they're
 * objects that shouldn't be able to stand alone. Ie. They make enough modification to the base abstract 
 * animal class (almost used an interface, but as a class it means less repeated code) to merit their own 
 * subclass branches, but shouldn't be able to be instantiated on their own, since they'll have subclasses
 * that are more specfic and are "actual" things.
 */

abstract class Animal {

	String whatIEat;
	String howImove;

	public boolean eat(String food) {
		if (whatIEat.equals(food)) {
			System.out.println("The " + food + " was eaten.");
			return true;
		}
		System.out.println("A " + this + " will not eat a " + food);

		return false;
	}

	public void breathe() {
		System.out.println("A " + this + " takes a breath");
	}

	public void move() {
		System.out.println("A " + this + " can" + " " + howImove);
	}

	@Override
	public String toString() {
		return "animal";
	}

	public abstract boolean playScrabble(Animal opponent);
}

abstract class Bird extends Animal {

	public Bird() {
		howImove = "fly";
	}

	@Override 
	public String toString() {
		return "bird";
	}
}

abstract class Mammal extends Animal {

	public Mammal() {
		howImove = "run";
	}

	@Override 
	public String toString() {
		return "mammal";
	}
}

abstract class Reptile extends Animal {

	public Reptile() {
		howImove = "crawl";
	}

	@Override 
	public String toString() {
		return "reptile";
	}
}

class Pigeon extends Bird {

	public Pigeon() {
		super();
		whatIEat = "bread";
	}

	@Override
	public String toString() {
		return "pigeon";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Pigeon && other != this;
	}
}

class Dove extends Bird {

	public Dove() {
		super();
		whatIEat = "rice";
	}

	@Override
	public String toString() {
		return "dove";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Dove && other != this;
	}
}

class Rabbit extends Mammal {

	public Rabbit() {
		super();
		whatIEat = "grass";
	}

	@Override
	public String toString() {
		return "rabbit";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Rabbit && other != this;
	}
}

class Cat extends Mammal {

	public Cat() {
		super();
		whatIEat = "children and dreams";
	}

	@Override
	public String toString() {
		return "cat";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Cat && other != this;
	}
}

class Gecko extends Reptile {

	public Gecko() {
		super();
		whatIEat = "bug";
	}

	@Override
	public String toString() {
		return "gecko";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Gecko && other != this;
	}
}

class Snake extends Reptile {

	String[] whatIEat;

	public Snake() {
		super();
		whatIEat = new String[]{"mouse", "bug"};
	}

	@Override
	public boolean eat(String food) {
		//Look for it in what I eat
		for (String someFood : whatIEat) {
			if (someFood.equals(food)) {
				System.out.println("The " + food + " was eaten.");
				return true;
			}
		}
		
		System.out.println("A " + this + " will not eat a " + food);
		return false;
	}

	@Override
	public String toString() {
		return "snake";
	}

	@Override
	public boolean playScrabble(Animal other) {
		return other instanceof Snake && other != this;
	}
}

