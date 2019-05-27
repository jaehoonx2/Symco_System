package symco_System;

public class GroupFactory {
	
	public Group getGroup(String groupType){
		if(groupType == null){
			return null;
		}
		
		if(groupType.equalsIgnoreCase("���")){
			return new HobbyGroup();
		}
		else if(groupType.equalsIgnoreCase("������Ʈ")){
			return new ProjectGroup();
		}
		
		return null;
	}
}
