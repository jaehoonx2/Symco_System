package symco_System;

import java.io.*;
import java.util.ArrayList;

public class Employee {
	private String id;
	private String password;
	private String name;
	private String rank;
	private String department;
	public static ArrayList<Employee> temployee = null;
	
	public Employee(String ID, String Password, String Name, String Rank, String Department){
		this.id = ID;
		this.password = Password;
		this.name = Name;
		this.rank = Rank;
		this.department = Department;
	}
	
	public static void addEmployee(String ID, String Password, String Name, String Rank, String Department){
	      ArrayList<Employee> employee = new ArrayList<Employee>();
	      
	      employee.add(new Employee(ID, Password, Name, Rank, Department));
	      temployee = employee;
	   }
	
	public static ArrayList<Employee> init(){
		ArrayList<Employee> employee = new ArrayList<Employee>();
		
		/*�������� �ӽ�����: ID, PW, �̸�, ����, �μ�*/
		employee.add(new Employee("leader","leader","������","����","�λ�"));
		employee.add(new Employee("employee","employee","�����","���","������"));
		
		return employee;
	}
	
	public String getID(){
		return id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public String getRank(){
		return rank;
	}
	
	public String getDepartment(){
		return department;
	}
	
}
