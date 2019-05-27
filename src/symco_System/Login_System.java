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
	private static Employee curEmployee;   //�ν��Ͻ� ���� ���̵� ȣ�Ⱑ��

	   public boolean IsValidUser(String id, String password, ArrayList<Employee> employee){
	      int i=0;
	      
	      for(i=0; i<employee.size(); i++){
	         if(id.equals(employee.get(i).getID()) && password.equals(employee.get(i).getPassword())){
	            setCurEmployee(employee.get(i));      //�α����� ����� ������ ����  !! curEmployee�� �������? setCurEmployee���� �غ�����.
	            return true;
	         }
	      }
	      
	      return false;
	   }
	   
	   //setCurEmployee�� �߰��� �κ��̿���!!
	   private void setCurEmployee(Employee login_Employee){
	      this.curEmployee = login_Employee;
	   }
	   
	   public static Employee getCurEmployee(){   //�ν��Ͻ� ���� ���̵� ȣ�Ⱑ��
	      return curEmployee;
	   }
	   
	// ������
	// Colleague���� �����ϰ�, ��ġ�� �Ŀ� ǥ�ø� �����Ѵ�.
	public Login_System(ArrayList<Employee> employee) {
		setBounds(700, 300, 0, 0);
		setBackground(Color.lightGray);
		//���̾ƿ� �Ŵ����� ����ؼ� 4X2�� �׸��带 �����.
		setLayout(new GridLayout(4,2));
		//Colleague���� ����
		createColleagues(employee);
		//��ġ
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username: "));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// ��ȿ/��ȿ�� �ʱ� ����
		colleagueChanged();
		// ǥ��
		pack();
		show();
	}
	
	//Colleague���� �����Ѵ�.
	public void createColleagues(ArrayList<Employee> employee) {
		// ����
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		//Mediator�� ��Ʈ
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		//Listener�� ��Ʈ
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 String password = textPass.getText();
		         String username = textUser.getText();
		            
		         if(IsValidUser(username, password, employee)){ //�α��� ���� �� ����.
		        	 textPass.setText(null);
		             textUser.setText(null);
		               
		               //Mainscreen�� exec�� ȣ��, employee�� ArrayList<Employee> Ÿ���Դϴ�.
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
	
	
	//Colleague���� ������ Colleague�� ��ȿ/��ȿ�� �����Ѵ�.
	public void colleagueChanged() {
		if (checkGuest.getState()) {				//Guest ���
		textUser.setColleagueEnabled(false);
		textPass.setColleagueEnabled(false);
		buttonOk.setColleagueEnabled(true);
		} else {									//Login ���
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}
	
	//textUser �Ǵ� textPass�� ������ �־���.
	//�� Colleague�� ��ȿ/��ȿ�� �����Ѵ�.
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