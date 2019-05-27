package symco_System;

public abstract class Burger implements Food {

	public String name() {
		// TODO Auto-generated method stub
		return "¹ö°ÅÁı";
	}

	public Packing packing() {
		return new Meal();
	}

	public abstract String telNum();

}
