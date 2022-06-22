package Application;

import java.awt.Image;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class ResizeImages {
	
	public static void main(String [] args) {
		ImageIcon c = resize(100, 100, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\Bakame_logo.jpg");
	}
	
	public static ImageIcon resize(int width, int height, String location) {
		ImageIcon imageIcon = new ImageIcon(location);
		Image image = imageIcon.getImage();
		Double w = ((double)imageIcon.getIconWidth())/((double)imageIcon.getIconHeight());
		Image img = image.getScaledInstance(Integer.parseInt(new DecimalFormat("##").format(w*height)), height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
}
