package symco_System;
import java.util.Random;

public class DoOrNot {
	
	public String Decision(){
		Random random = new Random();
		int number;
		String dicision ="";
		
		number = random.nextInt();
		
		if(number%3 == 0){
			dicision = "���� ������.";
		}
		else if(number%3 == 1){
			dicision = "��¥ �ؾߵǸ� �ϴµ�, �����ϸ� ������.";
		}
		else{
			dicision = "�� ����� �ض�.";
		}
		
		
		return dicision;
	}
	
	
}
