package symco_System;


import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Login_Colleague {
	private Login_Mediator mediator;
	public ColleagueTextField(String text, int columns) {	// ������
		super(text, columns);
	}
	public void setMediator(Login_Mediator mediator) {	// Mediator�� ����
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {	// Mediator���� ��ȿ/��ȿ�� ����
		setEnabled(enabled);
		setBackground(enabled ? Color.white : Color.darkGray);
	}
	public void textValueChanged(TextEvent e) {	// ���ڿ��� ���ϸ� Mediator���� ����
		mediator.colleagueChanged();
	}
}