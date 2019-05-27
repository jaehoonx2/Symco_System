package symco_System;
import java.util.Random;

public class DoOrNot {
	
	public String Decision(){
		Random random = new Random();
		int number;
		String dicision ="";
		
		number = random.nextInt();
		
		if(number%3 == 0){
			dicision = "절대 하지마.";
		}
		else if(number%3 == 1){
			dicision = "진짜 해야되면 하는데, 웬만하면 하지마.";
		}
		else{
			dicision = "니 맘대로 해라.";
		}
		
		
		return dicision;
	}
	
	
}
