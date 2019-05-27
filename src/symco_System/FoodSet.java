package symco_System;

import java.util.ArrayList;
import java.util.List;


public class FoodSet {
	static String foodList = "";
	static String foodPack = "";
	static String foodTel = "";
 
	static List<Food> foods = new ArrayList<Food>();
	
	public void addFood(Food food){
		foods.add(food);
	}
	
	public String getNum(){
		String num = "";
		
		for(Food food : foods){
			num = num + food.telNum() + ", ";
		}
		
		return num;
	}
	
	
	public void setFoods(){
		for(Food food : foods){
			foodList = foodList + ", " + food.name();
			foodPack = foodPack + "  분류: " + food.packing().pack();
			foodTel = foodTel + "  전화번호: " + food.telNum();
		}
	}
	
	public static void init_setFoods(){
		foods.clear();
		foodList = "";
		foodPack = "";
		foodTel = "";
	}
	
}

