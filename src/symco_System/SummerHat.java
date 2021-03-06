package symco_System;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class SummerHat extends Decorator{
	Moomin moomin;
		
	public SummerHat(Moomin moomin){
		this.moomin = moomin;
		location = "/hat_summer.jpg";
	}
	
	//override
	public ImageIcon MyGetImage(){
		//get two images
		Image image1 = moomin.MyGetImage().getImage();
		Image image2 = new ImageIcon(this.getClass().getResource(this.getLocation())).getImage();
		
		//set a size for merged image
		int w = 250;
		int h = 200;
		
		//merge
		Image image = new BufferedImage(w,h,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.drawImage(image1,0,0,null);
		g.drawImage(image2,45,-25,null);
		
		ImageIcon newImg = new ImageIcon(image);
		
		return newImg;
	}

}
