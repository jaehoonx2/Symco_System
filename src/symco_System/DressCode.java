package symco_System;
import java.util.Random;

public abstract class DressCode {
	public String Shoes(){
		Random random = new Random();
		int i;
		
		i = random.nextInt();
		String shoes = "";
		
		if(i%4 == 0){
			shoes = "�ȭ";
		}
		else if(i%4 == 1){
			shoes = "����";
		}
		else if(i%4 == 2){
			shoes = "������";
		}
		else{
			shoes = "����";
		}
		
		
		return shoes;
	}
	
	public abstract String Top();
	public abstract String Bottom();
	

}
