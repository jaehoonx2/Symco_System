package symco_System;

import java.util.ArrayList;

public class screenFactory implements Factory{
	
	public void create(ArrayList<Employee> employee, String type){
		switch(type){
		case "blue" : Mainscreen_blue.exec(employee);
		break;
		case "summer" : Mainscreen_summer.exec(employee);
		break;
		}
	}
}
