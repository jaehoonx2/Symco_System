package symco_System;
import java.util.Random;

public class WomanDress extends DressCode {
	Random random = new Random();

	public String Top() {
		int i = random.nextInt();
		String top = "";
		
		if(i%6 == 0){
			top = "���콺";
		}
		else if(i%6 == 1){
			top = "Ƽ����";
		}
		else if(i%6 == 2){
			top = "ũ��Ƽ";
		}
		else if(i%6 == 3){
			top = "�ĵ�Ƽ";
		}
		else if(i%6 == 4){
			top = "������";
		}
		else{
			top = "��Ʈ";
		}
		
		return top;
	}

	public String Bottom() {
		int i = random.nextInt();
		String bottom = "";
		
		if(i%6 == 0){
			bottom = "A���� ��ĿƮ";
		}
		else if(i%6 == 1){
			bottom = "H���� ��ĿƮ";
		}
		else if(i%6 == 2){
			bottom = "Ʈ���̴� ����";
		}
		else if(i%6 == 3){
			bottom = "���뽺";
		}
		else if(i%6 == 4){
			bottom = "�ݹ���";
		}
		else{
			bottom = "��Ű����";
		}
		
		return bottom;
	}

}
