package symco_System;

import javax.swing.ImageIcon;

public abstract class Moomin {
	String location = "없음";
	
	public String getLocation(){
		return location;
	}
	
	//자식 class에서 구현
	public abstract ImageIcon MyGetImage();
}
