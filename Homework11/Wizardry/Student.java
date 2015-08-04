public abstract class Student {
	private int health;

	public int getHealth() {
		return health;
	}

	public void setHealth(int newHealth) {
		this.health = newHealth;
	}

	public void scream(int damage) {
		System.out.println(this + " hit for " + damage);
	}
}

abstract class Thinker extends Student {
}

abstract class Coder extends Student {
}

class Gunslinger extends Coder {
	public Gunslinger() {
		setHealth(20);
	}

	@Override
	public String toString() {
		return "Gunslinger";
	}
}

class Hacker extends Coder {
	public Hacker() {
		setHealth(30);
	}

	@Override
	public String toString() {
		return "Hacker";
	}
}


class Inventor extends Thinker {
	public Inventor() {
		setHealth(10);
	}

	@Override
	public String toString() {
		return "Inventor";
	}
}

class Boss extends Thinker {
	public Boss() {
		setHealth(35);
	}

	@Override
	public String toString() {
		return "Boss";
	}
}