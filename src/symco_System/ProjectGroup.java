package symco_System;

public class ProjectGroup implements Group {

	public String groupType() {
		String state = "������Ʈ";
		
		return state;
	}
	
	public String groupActivity(String n){
		String state = "";
		if(n == "1"){
			state = "�系 �Ҽ� �μ�";
		}
		else if(n == "2"){
			state = "�系 �Ҽӿ� �μ�";
		}
		else if(n== "3"){
			state = "Ÿ��(����) ����";
		}
		else{
			state = "��Ÿ";
		}
		
		return state;
	}
	
	

}