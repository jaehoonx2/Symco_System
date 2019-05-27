package symco_System;


import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Login_Colleague {
	private Login_Mediator mediator;
	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state){	//������
		super(caption, group, state);
	}
	public void setMediator(Login_Mediator mediator) {	// Mediator�� ����
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {	// Mediator���� ��ȿ/��ȿ�� ����
		setEnabled(enabled);
	}
	public void itemStateChanged(ItemEvent e){	//���°� �ٲ�� Mediator���� ����
		mediator.colleagueChanged();
	}
}
