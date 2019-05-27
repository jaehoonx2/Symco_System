package symco_System;
import java.util.Random;

public class ManDress extends DressCode {
	
	public String Top() {
		Random random = new Random();
		int i = random.nextInt();
		String top = "";
		
		if(i%3 == 0){
			top = "체크 난방";
		}
		else if(i%3 == 1){
			top = "와이 셔츠";
		}
		else{
			top = "티셔츠";
		}
		
		return top;
	}

	
	public String Bottom() {
		Random random = new Random();
		int i = random.nextInt();
		String bottom = "";
		
		if(i%3 == 0){
			bottom = "청바지";
		}
		else if(i%3 == 1){
			bottom = "스키니진";
		}
		else{
			bottom = "트레이닝 바지";
		}
		
		return bottom;
	}
	
	
}
