package symco_System;
import java.util.Random;

public class ManDress extends DressCode {
	
	public String Top() {
		Random random = new Random();
		int i = random.nextInt();
		String top = "";
		
		if(i%3 == 0){
			top = "üũ ����";
		}
		else if(i%3 == 1){
			top = "���� ����";
		}
		else{
			top = "Ƽ����";
		}
		
		return top;
	}

	
	public String Bottom() {
		Random random = new Random();
		int i = random.nextInt();
		String bottom = "";
		
		if(i%3 == 0){
			bottom = "û����";
		}
		else if(i%3 == 1){
			bottom = "��Ű����";
		}
		else{
			bottom = "Ʈ���̴� ����";
		}
		
		return bottom;
	}
	
	
}
