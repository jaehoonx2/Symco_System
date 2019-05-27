package symco_System;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ConcreteMoomin extends Moomin{
	
	public ConcreteMoomin(){
		location = "/Moomin_Base.jpg";
	}
	
	//override
	public ImageIcon MyGetImage(){
		Image img = new ImageIcon(this.getClass().getResource(location)).getImage();
		
		//set a size for merged image
		int w = 250;
		int h = 250;
				
		//merge
		Image image = new BufferedImage(w,h,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.drawImage(img,0,30,null);
		
		ImageIcon newImg = new ImageIcon(img);
		
		return newImg;
	}
}
