package symco_System;

public class HobbyGroup implements Group {

	public String groupType() {
		String state = "���";
		
		return state;
	}
	
	public String groupActivity(String n){
		String state = "";
		
		if(n== "1"){
			state = "����";
		}
		else if(n=="2"){
			state = "����";
		}
		else if(n=="3"){
			state = "��ȸ";
		}
		else{
			state = "��Ÿ";
		}
		
		return state;
	}
	
	

}
