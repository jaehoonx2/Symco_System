package symco_System;

public class HobbyGroup implements Group {

	public String groupType() {
		String state = "취미";
		
		return state;
	}
	
	public String groupActivity(String n){
		String state = "";
		
		if(n== "1"){
			state = "여가";
		}
		else if(n=="2"){
			state = "예술";
		}
		else if(n=="3"){
			state = "학회";
		}
		else{
			state = "기타";
		}
		
		return state;
	}
	
	

}
