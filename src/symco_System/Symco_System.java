package symco_System;

import java.io.*;
import java.util.*;

public class Symco_System {
	public static void main(String[] args) {
		//���ڽý��� �ν��Ͻ� ����
		Symco_System symco_System = new Symco_System();
		
		/*�������� �޾ƿ���*/
		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee = Employee.init();
	
		/*�α��� �ý��� ȣ��*/
		new Login_System(employee);	
	}

}
