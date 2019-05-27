package symco_System;
import java.util.Random;

public class EitherOr implements DecisionMaker {
	public String Decision(){
		Random random = new Random();
		int number;
		String dicision ="";
		
		number = random.nextInt();
		
		if(number%2 == 0){
			dicision = "전자가 더 나은 것 같다.";
		}
		else{
			dicision = "후자를 택하는게 더 나을 걸?";
		}
		
		
		return dicision;
	}

}
