package Class;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.OptionsMenu.CourseMenu;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.CourseMenu;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;

public class Course extends JPanel {
	public static JPanel Box1;
	public static JLabel lblNdashimyeMaxBrillant;
	public static JLabel label_5;
	public static List<Component> selectedCourses = new ArrayList();

	/**
	 * Create the panel.
	 */
	public Course() {
		setBackground(new Color(60, 60, 60));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				CourseMenu.deselect();
					boolean alreadyExists = false;
					if((MouseEvent.CTRL_MASK & e.getModifiers())!=0) {
						if(!selectedCourses.contains(getComponent(0).getParent())) {
							selectedCourses.add(getComponent(0).getParent());
						}else {
							selectedCourses.remove(getComponent(0).getParent());
						}
					}else {

						if(selectedCourses.contains(getComponent(0).getParent())) {
						alreadyExists = true;
						}
					deselectAll();
					CourseMenu.deselect();
					selectedCourses.add(getComponent(0).getParent());
					}

					
					for(int i = 0; i<selectedCourses.toArray().length; i++) {
						for(int j = 0; j< Application.panel2.getComponentCount(); j++) {
							if(Application.panel2.getComponent(j).equals(selectedCourses.get(i))) {
								Application.panel2.getComponent(j).setBackground(new Color(20, 148, 198));
								
								for(int k = 0;k<((Container) Application.panel2.getComponent(j)).getComponentCount();k++) {
									((Container) Application.panel2.getComponent(j)).getComponent(k).setForeground(Color.white);
								}
					}}}
					
				//
					CourseMenu.edit.setVisible(true);
					CourseMenu.delete.setVisible(true);
					CourseMenu.goBackward.setVisible(true);
					CourseMenu.goForward.setVisible(true);
					CourseMenu.publish.setVisible(true);
					CourseMenu.stats.setVisible(true);
					if(selectedCourses.toArray().length>1) {
						CourseMenu.edit.setVisible(false);
						CourseMenu.stats.setVisible(false);
						CourseMenu.goForward.setVisible(false);
						CourseMenu.goBackward.setVisible(false);
					}
					
					if(selectedCourses.toArray().length==1) {
						Component comp = null;

					for(int i = 0; i< Application.panel2.getComponentCount(); i++) {
							if(Application.panel2.getComponent(i).equals(selectedCourses.get(0))) {
								comp = Application.panel2.getComponent(i);
							}
						}
					
							if(!comp.equals(null)) {
								if(Application.panel2.getComponent(Application.panel2.getComponentCount()-1).equals(comp)) {
									CourseMenu.goBackward.setVisible(false);
								}if(Application.panel2.getComponent(0).equals(comp)) {
									CourseMenu.goForward.setVisible(false);
								}
					}}
					
				if(selectedCourses.toArray().length==0) {
					deselectAll();
				}
				Application.no.setText(getName());
				
			}
			public void mouseEntered(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					setBackground(new Color(60, 60, 60).brighter());
					setBorder(new LineBorder(new Color(20, 148, 198)));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					setBackground(new Color(60, 60, 60));
					setBorder(null);
				}
				
			}
		});
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(screensize.width*97/100, 40));
		setLayout(null);
		
		lblNdashimyeMaxBrillant = new JLabel("");
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		lblNdashimyeMaxBrillant.setBounds(20, 0, 380, 40);
		add(lblNdashimyeMaxBrillant);
		
		JLabel label = new JLabel("0%");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label.setBounds(407, 0, 94, 40);
		add(label);
		
		JLabel label_1 = new JLabel("0/0");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_1.setBounds(558, 0, 134, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_2.setBounds(730, 0, 94, 40);
		add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_3.setBounds(871, 0, 94, 40);
		add(label_3);
		
		JLabel label_4 = new JLabel("+0%");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_4.setBounds(1040, 0, 94, 40);
		add(label_4);
		
		label_5 = new JLabel("0%");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_5.setBounds(1190, 0, 147, 40);
		add(label_5);
	}
	
	public static void deselectAll() {
		for(int i = 0; i< ((Container) Application.panel2).getComponentCount(); i++) {
			if(selectedCourses.contains(((Container) Application.panel2).getComponent(i))) {
				((JComponent) ((Container) Application.panel2).getComponent(i)).setBackground(new Color(60, 60, 60));
				((JComponent) ((Container) Application.panel2).getComponent(i)).setBorder(null);
			}
				Application.panel2.revalidate();

				Application.panel2.repaint();
		
		}

		selectedCourses.clear();
		
		CourseMenu.deselect();
	}
}
