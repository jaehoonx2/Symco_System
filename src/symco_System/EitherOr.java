package symco_System;
import java.util.Random;

public class EitherOr implements DecisionMaker {
	public String Decision(){
		Random random = new Random();
		int number;
		String dicision ="";
		
		number = random.nextInt();
		
		if(number%2 == 0){
			dicision = "���ڰ� �� ���� �� ����.";
		}
		else{
			dicision = "���ڸ� ���ϴ°� �� ���� ��?";
		}
		
		
		return dicision;
	}

}
