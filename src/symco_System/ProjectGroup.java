package symco_System;

public class ProjectGroup implements Group {

	public String groupType() {
		String state = "프로젝트";
		
		return state;
	}
	
	public String groupActivity(String n){
		String state = "";
		if(n == "1"){
			state = "사내 소속 부서";
		}
		else if(n == "2"){
			state = "사내 소속외 부서";
		}
		else if(n== "3"){
			state = "타사(외주) 협업";
		}
		else{
			state = "기타";
		}
		
		return state;
	}
	
	

}