package symco_System;


import java.awt.Button;

public class ColleagueButton extends Button implements Login_Colleague {
	private Login_Mediator mediator;
	public ColleagueButton(String caption) {
		super(caption);
	}
	public void setMediator (Login_Mediator mediator) {	// Mediator�� ����
		this.mediator = mediator;
	}
	
	public void setColleagueEnabled(boolean enabled){
										// Mediator���� ��ȿ/��ȿ�� ����
		setEnabled(enabled);
		
	}
}
