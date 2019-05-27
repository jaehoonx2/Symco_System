package symco_System;

public class FoodBuilder {
	
	public FoodSet FeelgoodFood(){
		FoodSet foodset = new FoodSet();
		foodset.addFood(new Gonssi());
		foodset.addFood(new BBQ());
		
		return foodset;
	}
	
	public FoodSet FeelbadFood(){
		FoodSet foodset = new FoodSet();
		foodset.addFood(new Burgerking());
		foodset.addFood(new Ddangddang());
		
		return foodset;
	}
	
	public FoodSet FeelsosoFood(){
		FoodSet foodset = new FoodSet();
		foodset.addFood(new Hansot());
		foodset.addFood(new Buar());
		
		return foodset;
	}
	
	public FoodSet FeelbusyFood(){
		FoodSet foodset = new FoodSet();
		foodset.addFood(new Lottelia());
		foodset.addFood(new SSaltongdak());
		
		return foodset;
	}
	
	public FoodSet FeelVbusyFood(){
		FoodSet foodset = new FoodSet();
		foodset.addFood(new Mcdonald());
		foodset.addFood(new Buar());
		
		return foodset;
	}
	
}
