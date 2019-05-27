package symco_System;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class Login_System extends Frame implements ActionListener, Login_Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	private static Employee curEmployee;   //인스턴스 생성 없이도 호출가능

	   public boolean IsValidUser(String id, String password, ArrayList<Employee> employee){
	      int i=0;
	      
	      for(i=0; i<employee.size(); i++){
	         if(id.equals(employee.get(i).getID()) && password.equals(employee.get(i).getPassword())){
	            setCurEmployee(employee.get(i));      //로그인한 사람의 정보를 저장  !! curEmployee가 사라진다? setCurEmployee만들어서 해봐야지.
	            return true;
	         }
	      }
	      
	      return false;
	   }
	   
	   //setCurEmployee가 추가된 부분이에요!!
	   private void setCurEmployee(Employee login_Employee){
	      this.curEmployee = login_Employee;
	   }
	   
	   public static Employee getCurEmployee(){   //인스턴스 생성 없이도 호출가능
	      return curEmployee;
	   }
	   
	// 생성자
	// Colleague들을 생성하고, 배치한 후에 표시를 실행한다.
	public Login_System(ArrayList<Employee> employee) {
		setBounds(700, 300, 0, 0);
		setBackground(Color.lightGray);
		//레이아웃 매니저를 사용해서 4X2의 그리드를 만든다.
		setLayout(new GridLayout(4,2));
		//Colleague들의 생성
		createColleagues(employee);
		//배치
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username: "));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 유효/무효의 초기 지정
		colleagueChanged();
		// 표시
		pack();
		show();
	}
	
	//Colleague들을 생성한다.
	public void createColleagues(ArrayList<Employee> employee) {
		// 생성
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		//Mediator의 세트
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		//Listener의 세트
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 String password = textPass.getText();
		         String username = textUser.getText();
		            
		         if(IsValidUser(username, password, employee)){ //로그인 성공 시 실행.
		        	 textPass.setText(null);
		             textUser.setText(null);
		               
		               //Mainscreen의 exec을 호출, employee는 ArrayList<Employee> 타입입니다.
		               Mainscreen_blue.exec(employee);
		               dispose();
		            }
		            else{
		               JOptionPane.showMessageDialog(null, "Why can't access?\n"
		               		+ "1.Guests have no permission to access\n"
		               		+ "2.The username or the password is incorrect",
		               		"Login Error",JOptionPane.ERROR_MESSAGE);
		               textPass.setText(null);
		               textUser.setText(null);
		            }
	        }
		});
		buttonCancel.addActionListener(this);
		}
	
	
	//Colleague에서 통지로 Colleague의 유효/무효를 판정한다.
	public void colleagueChanged() {
		if (checkGuest.getState()) {				//Guest 모드
		textUser.setColleagueEnabled(false);
		textPass.setColleagueEnabled(false);
		buttonOk.setColleagueEnabled(true);
		} else {									//Login 모드
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}
	
	//textUser 또는 textPass의 변경이 있었다.
	//각 Colleague의 유효/무효를 판정한다.
	private void userpassChanged() {
		if (textUser.getText().length() > 0){
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 0) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
		}	
}