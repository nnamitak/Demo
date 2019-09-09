package com.booktopia.generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class UtilitiyLib {
		
	
	
		public static String now(){
			SimpleDateFormat s= new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
			return s.format(new Date());
		}
		
		public static void captureScreenShot(String path)
		{
			try {
				
					Robot robo = new Robot();
					Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
					BufferedImage img= robo.createScreenCapture(new Rectangle(d));
					ImageIO.write(img, "png", new File(path));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
		}
	
}
