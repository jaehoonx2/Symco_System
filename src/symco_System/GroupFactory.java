package symco_System;

public class GroupFactory {
	
	public Group getGroup(String groupType){
		if(groupType == null){
			return null;
		}
		
		if(groupType.equalsIgnoreCase("취미")){
			return new HobbyGroup();
		}
		else if(groupType.equalsIgnoreCase("프로젝트")){
			return new ProjectGroup();
		}
		
		return null;
	}
}
