package symco_System;
import java.util.Random;

public class NextdayFortune implements Fortune {
	Random random = new Random();
	public String popFortune(){
		int number;
		String message;
		
		number = random.nextInt();
		
		if(number%10 == 0){
			message = "부하 직원을 조심하세요.";
		}
		else if(number%10 == 1){
			message = "상사를 조심하세요!";
		}
		else if(number%10 == 2){
			message = "일찍 주무세요.";
		}
		else if(number%10 == 3){
			message = "말을 조심하세요. 말이 씨가 됩니다!";
		}
		else if(number%10 == 4){
			message = "뜻밖의 일이 일어날 수도 있겠네요..";
		}
		else if(number%10 == 5){
			message = "부모님께 사랑한다고 말씁드리세요. 그 분들이 항상 함께 계시는게 아닙니다.";
		}
		else if(number%10 == 6){
			message = "작업하던 파일이 갑자기 날아갈 수도 있으니, 중간 저장과 백업을 하세요! 꼭!!!";
		}
		else if(number%10 == 7){
			message = "귀찮다고 미루면 내일 더 바빠집니다.";
		}
		else if(number%10 == 8){
			message = "최고의 날이네요!";
		}
		else{
			message = "항상 하나님께서 함께하십니다 :)";
		}
		
		return message;
	}
}
