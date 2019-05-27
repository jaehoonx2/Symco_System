package symco_System;
import java.util.Random;

public abstract class DressCode {
	public String Shoes(){
		Random random = new Random();
		int i;
		
		i = random.nextInt();
		String shoes = "";
		
		if(i%4 == 0){
			shoes = "운동화";
		}
		else if(i%4 == 1){
			shoes = "구두";
		}
		else if(i%4 == 2){
			shoes = "슬리퍼";
		}
		else{
			shoes = "샌들";
		}
		
		
		return shoes;
	}
	
	public abstract String Top();
	public abstract String Bottom();
	

}
