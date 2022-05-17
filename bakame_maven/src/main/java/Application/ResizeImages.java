package Application;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResizeImages {
	
	public static ImageIcon resize(int width, int height, String location) {
		

		ImageIcon imageIcon = new ImageIcon(location);
		Image image = imageIcon.getImage();
		Image img = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		
		ImageIcon i = new ImageIcon(img);
		
		return new ImageIcon(img);
	}
}
