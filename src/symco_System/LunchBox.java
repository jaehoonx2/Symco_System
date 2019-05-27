package symco_System;

public abstract class LunchBox implements Food {


	public Packing packing() {
		return new Meal();
	}

	public abstract String telNum();
}