package symco_System;
import java.util.Random;

public class WomanDress extends DressCode {
	Random random = new Random();

	public String Top() {
		int i = random.nextInt();
		String top = "";
		
		if(i%6 == 0){
			top = "블라우스";
		}
		else if(i%6 == 1){
			top = "티셔츠";
		}
		else if(i%6 == 2){
			top = "크롭티";
		}
		else if(i%6 == 3){
			top = "후드티";
		}
		else if(i%6 == 4){
			top = "씨스루";
		}
		else{
			top = "니트";
		}
		
		return top;
	}

	public String Bottom() {
		int i = random.nextInt();
		String bottom = "";
		
		if(i%6 == 0){
			bottom = "A라인 스커트";
		}
		else if(i%6 == 1){
			bottom = "H라인 스커트";
		}
		else if(i%6 == 2){
			bottom = "트레이닝 바지";
		}
		else if(i%6 == 3){
			bottom = "레깅스";
		}
		else if(i%6 == 4){
			bottom = "반바지";
		}
		else{
			bottom = "스키니진";
		}
		
		return bottom;
	}

}
