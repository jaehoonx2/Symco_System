package symco_System;

public abstract class Chicken implements Food {

	public String name() {
		return "ġŲ��";
	}
	
	public Packing packing(){
		return new Snack();
	}
	
	public abstract String telNum();
	
	public abstract String kcal();

}
