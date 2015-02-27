package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

import javax.swing.ImageIcon;

/**
 * 
 * Thanks Sanity! Guess we aren't using this though.
 *
 */

public class Sprite {
	
	public Sprite(String imagename) {
		try {
			Image image = Toolkit.getDefaultToolkit().getImage("./sprites/"+imagename+".png");
			ImageIcon sprite = new ImageIcon(image);
			int width = sprite.getIconWidth();
			int height = sprite.getIconHeight();
			int[] pixels = new int[width * height];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(pixels, 255, 0, 255);
		} catch (Exception i) {
			i.printStackTrace();
		}
	}
	
	public void setTransparency(int[] pixels, int transRed, int transGreen, int transBlue) {
		for(int index = 0; index < pixels.length; index++)
			if(((pixels[index] >> 16) & 255) == transRed && ((pixels[index] >> 8) & 255) == transGreen && (pixels[index] & 255) == transBlue)
				pixels[index] = 0;
	}
	
}
