package symco_System;

import java.io.*;
import java.util.*;

public class Symco_System {
	public static void main(String[] args) {
		//심코시스템 인스턴스 생성
		Symco_System symco_System = new Symco_System();
		
		/*직원정보 받아오기*/
		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee = Employee.init();
	
		/*로그인 시스템 호출*/
		new Login_System(employee);	
	}

}
