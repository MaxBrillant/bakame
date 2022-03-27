package app;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.metal.MetalProgressBarUI;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class EducationBox extends JPanel {
	public static JProgressBar progress;

	/**
	 * Create the panel.
	 */
	public EducationBox() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(new Dimension((int) screensize.getWidth()*20/100,(int) (screensize.getHeight()*82/100*15/100))));
		setLayout(null);
		
		progress = new JProgressBar();
		progress.setBounds(10, 28, 251, 30);
		progress.setBackground(new Color(240, 248, 255));
		UIManager.put("progress.selectionBackground", Color.black);
		progress.setStringPainted(true);
		progress.setForeground(new Color(46, 139, 87));
		progress.setValue(90);
		progress.setFont(new Font("Roboto", Font.PLAIN, 23));
		progress.setString("54/60");
		
		
		Color color ;
		//NewTest nt = new NewTest();
		//if(nt.isVisible()) {
		//if(100*Double.parseDouble(NewTest.PO.getText().replace(",", "."))/Double.parseDouble(NewTest.TP.getSelectedItem().toString().replace(",", "."))>=50) {
			//color = new Color(0, 168, 96);
		//}else {
			//color = new Color(204, 0, 0);
		//}
		
		//progress.setUI(new BasicProgressBarUI() {
			//protected Color getSelectionBackground() { return color;}
			//protected Color getSelectionForeground() { return Color.white;}
		//});
		//}
		
		add(progress);
		
		JLabel lblNewLabel = new JLabel("Education");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(55, 4, 163, 24);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retirer");
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 17));
		btnNewButton.setBounds(20, 63, 103, 30);
		add(btnNewButton);
		
		JButton btnPunitions = new JButton("Historique");
		btnPunitions.setFont(new Font("Roboto", Font.PLAIN, 17));
		btnPunitions.setBounds(133, 63, 118, 30);
		add(btnPunitions);
				
	}
	
	
	public static void color() {

		for (int k = 0; k< LPane.panel_3.getComponentCount();k++) {
			if(LPane.panel_3.getComponent(k) instanceof Test) {
			String str = ((JProgressBar) ((Container) LPane.panel_3.getComponent(k)).getComponent(0)).getString();
			List note = Arrays.asList(str.trim().split("/"));
			
			Color color;
			if(Double.parseDouble((String)note.get(0))/Double.parseDouble((String)note.get(1))*100 >=50) {
				color = new Color(0, 168, 96);
			}else {
				color = new Color(204, 0, 0);
			}
			
			EducationBox.progress.setUI(new BasicProgressBarUI() {
				protected Color getSelectionBackground() { return color;}
				protected Color getSelectionForeground() { return Color.white;
				}
			});
			}
			
		}
		
	}
}
