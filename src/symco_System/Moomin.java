package symco_System;

import javax.swing.ImageIcon;

public abstract class Moomin {
	String location = "����";
	
	public String getLocation(){
		return location;
	}
	
	//�ڽ� class���� ����
	public abstract ImageIcon MyGetImage();
}
