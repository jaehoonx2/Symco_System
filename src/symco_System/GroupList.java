package symco_System;

import java.util.ArrayList;

public class GroupList {
	static Employee groupLeader;
	static ArrayList<Employee> groupMember;
	static String groupName;
	 
     static ArrayList<GroupList> GgroupList = new ArrayList<GroupList>();
	   

	   public GroupList(String GroupName, Employee GroupLeader, ArrayList<Employee> GroupMember){
	      this.groupLeader = GroupLeader;
	      this.groupMember = GroupMember;
	      this.groupName = GroupName;
	      //this.myProjectList = new ArrayList<Project>();
	   }
	   
	   public static void addGroup(String GroupName, Employee GroupLeader, ArrayList<Employee> GroupMember){
	      ArrayList<GroupList> groupList = new ArrayList<GroupList>();
	      
	      /*�׷����� ����: �׷츮��ID, PW, �̸�, ����, �μ�*/
	      groupList.add(new GroupList(GroupName, GroupLeader, GroupMember));
	      GgroupList = groupList;
	   }
	   
	   public Employee getGroupLeader(){
	      return groupLeader;
	   }
	   
	   public ArrayList<Employee> getGroupMember(){
		   return groupMember;
	   }
	   
	   public String getGroupName(){
		   return groupName;
	   }

}
