package symco_System;
import java.util.Random;

public class NextdayFortune implements Fortune {
	Random random = new Random();
	public String popFortune(){
		int number;
		String message;
		
		number = random.nextInt();
		
		if(number%10 == 0){
			message = "���� ������ �����ϼ���.";
		}
		else if(number%10 == 1){
			message = "��縦 �����ϼ���!";
		}
		else if(number%10 == 2){
			message = "���� �ֹ�����.";
		}
		else if(number%10 == 3){
			message = "���� �����ϼ���. ���� ���� �˴ϴ�!";
		}
		else if(number%10 == 4){
			message = "����� ���� �Ͼ ���� �ְڳ׿�..";
		}
		else if(number%10 == 5){
			message = "�θ�Բ� ����Ѵٰ� �����帮����. �� �е��� �׻� �Բ� ��ô°� �ƴմϴ�.";
		}
		else if(number%10 == 6){
			message = "�۾��ϴ� ������ ���ڱ� ���ư� ���� ������, �߰� ����� ����� �ϼ���! ��!!!";
		}
		else if(number%10 == 7){
			message = "�����ٰ� �̷�� ���� �� �ٺ����ϴ�.";
		}
		else if(number%10 == 8){
			message = "�ְ��� ���̳׿�!";
		}
		else{
			message = "�׻� �ϳ��Բ��� �Բ��Ͻʴϴ� :)";
		}
		
		return message;
	}
}
