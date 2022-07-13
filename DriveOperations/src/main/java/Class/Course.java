package Class;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
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

import Application.ResizeImages;
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
	public Course(String classroom_in_ay_id) {
		
		
		setBorder(null);
		setBackground(new Color(40, 40, 40));
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentMenu.deselect();
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


					if(selectedCourses.toArray().length==1) {
						Component comp = null;

					for(int i = 0; i< Application.panelCourses.getComponentCount(); i++) {
							if(Application.panelCourses.getComponent(i).equals(selectedCourses.get(0))) {
								comp = Application.panelCourses.getComponent(i);
							}
						}
					
						}
					
					for(int i = 0; i<selectedCourses.toArray().length; i++) {
						for(int j = 0; j< Application.panelCourses.getComponentCount(); j++) {
							if(Application.panelCourses.getComponent(j).equals(selectedCourses.get(i))) {
								((Container) Application.panelCourses.getComponent(j)).getComponent(0).setBackground(new Color(20, 148, 198, 50));
								((Container) Application.panelCourses.getComponent(j)).getComponent(1).setBackground(new Color(20, 148, 198, 50));
								((JComponent) Application.panelCourses.getComponent(j)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
								((Container) ((Container) Application.panelCourses.getComponent(j)).getComponent(0)).getComponent(0).setVisible(true);
								
								for(int k = 0;k<((Container) Application.panelCourses.getComponent(j)).getComponentCount();k++) {
									((Container) Application.panelCourses.getComponent(j)).getComponent(k).setForeground(Color.white);
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

					for(int i = 0; i< Application.panelCourses.getComponentCount(); i++) {
							if(Application.panelCourses.getComponent(i).equals(selectedCourses.get(0))) {
								comp = Application.panelCourses.getComponent(i);
							}
						}
					
							if(!comp.equals(null)) {
								if(Application.panelCourses.getComponent(Application.panelCourses.getComponentCount()-1).equals(comp)) {
									CourseMenu.goBackward.setVisible(false);
								}if(Application.panelCourses.getComponent(0).equals(comp)) {
									CourseMenu.goForward.setVisible(false);
								}
					}}
					
				if(selectedCourses.toArray().length==0) {
					deselectAll();
				}
				
			}
			public void mouseEntered(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(new Color(60, 60, 60));
					getComponent(1).setBackground(new Color(60, 60, 60));
					}
			}public void mouseExited(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(getBackground());
					getComponent(1).setBackground(getBackground());
					setBorder(null);
				}
				
			}
		});
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 67));
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(35, 30));
		panel.setBackground(new Color(40, 40, 40));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(35, 40));
		panel1.setBackground(new Color(20, 148, 198));
		panel.add(panel1, BorderLayout.WEST);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\check.png"));
		panel1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblUmuhozaChrisKoen = new JLabel();
		lblUmuhozaChrisKoen.setAlignmentX(1.0f);
		lblUmuhozaChrisKoen.setText("Mathematiques Statistiques");
		lblUmuhozaChrisKoen.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.BOLD, 16));
		panel.add(lblUmuhozaChrisKoen, BorderLayout.CENTER);
		
		JButton stats = new JButton();
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		stats.setBackground(new Color(40, 40, 40));
		panel.add(stats, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setPreferredSize(new Dimension(10, 37));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		panel_1.setBackground(new Color(40, 40, 40));
		
		
		JLabel lblProgres = new JLabel(" pas cot\u00E9 ");
		lblProgres.setHorizontalAlignment(SwingConstants.CENTER);
		//lblProgres.setPreferredSize(new Dimension(70, 18));
		lblProgres.setOpaque(true);
		lblProgres.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProgres.setForeground(Color.BLACK);
		lblProgres.setFont(new Font("Roboto", Font.BOLD, 14));
		lblProgres.setBackground(new Color(233, 150, 122));
		panel_1.add(lblProgres);
		
		
		JLabel lblNewLabel = new JLabel("Moyenne: 58.5/105");
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("-");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		label.setBackground(new Color(250, 128, 114));
		panel_1.add(label);
		
		JLabel lblPoints = new JLabel("65.74%");
		lblPoints.setVerticalAlignment(SwingConstants.TOP);
		lblPoints.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 14));
		lblPoints.setBackground(new Color(250, 128, 114));
		panel_1.add(lblPoints);
		
		JLabel label_1 = new JLabel("-");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Roboto", Font.BOLD, 14));
		label_1.setBackground(new Color(250, 128, 114));
		panel_1.add(label_1);
		
		JLabel lblEchecs = new JLabel("12 echecs");
		lblEchecs.setVerticalAlignment(SwingConstants.TOP);
		lblEchecs.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEchecs.setForeground(new Color(211, 211, 211));
		lblEchecs.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEchecs.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEchecs);
		
		JLabel label_2 = new JLabel("-");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalTextPosition(SwingConstants.LEADING);
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setFont(new Font("Roboto", Font.BOLD, 14));
		label_2.setBackground(new Color(250, 128, 114));
		panel_1.add(label_2);
		
		JLabel lblInterros = new JLabel("53 interros");
		lblInterros.setVerticalAlignment(SwingConstants.TOP);
		lblInterros.setHorizontalTextPosition(SwingConstants.LEADING);
		lblInterros.setForeground(new Color(211, 211, 211));
		lblInterros.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblInterros.setBackground(new Color(250, 128, 114));
		panel_1.add(lblInterros);
		
		JLabel label_4 = new JLabel("-");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setForeground(new Color(211, 211, 211));
		label_4.setFont(new Font("Roboto", Font.BOLD, 14));
		label_4.setBackground(new Color(250, 128, 114));
		panel_1.add(label_4);
		
		JLabel lblProgres1 = new JLabel("Progres: 120.75%");
		lblProgres1.setVerticalAlignment(SwingConstants.TOP);
		lblProgres1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblProgres1.setForeground(new Color(211, 211, 211));
		lblProgres1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProgres1.setBackground(new Color(250, 128, 114));
		panel_1.add(lblProgres1);
		
		JLabel label_3 = new JLabel("-");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Roboto", Font.BOLD, 14));
		label_3.setBackground(new Color(250, 128, 114));
		panel_1.add(label_3);
		
		JLabel lblEducation = new JLabel("Reussite: 83%");
		lblEducation.setVerticalAlignment(SwingConstants.TOP);
		lblEducation.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEducation.setForeground(new Color(211, 211, 211));
		lblEducation.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEducation.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEducation);
	
		
	}
	
	public static void deselectAll() {
		for(int i = 0; i< ((Container) Application.panelCourses).getComponentCount(); i++) {
			if(((Container) Application.panelCourses).getComponent(i) instanceof Course) {
			if(selectedCourses.contains(((Container) Application.panelCourses).getComponent(i))) {
				((JComponent) ((Container) Application.panelCourses).getComponent(i)).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) Application.panelCourses).getComponent(i)).getComponent(0).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) Application.panelCourses).getComponent(i)).getComponent(1).setBackground(new Color(40, 40, 40));
				((Container) ((Container) Application.panelCourses.getComponent(i)).getComponent(0)).getComponent(0).setVisible(false);
				((JComponent) ((Container) Application.panelCourses).getComponent(i)).setBorder(null);
			}
			((Container) ((Container) Application.panelCourses.getComponent(i)).getComponent(0)).getComponent(0).setVisible(false);
			
				Application.panelCourses.revalidate();

				Application.panelCourses.repaint();
			}
		}

		selectedCourses.clear();
		
		CourseMenu.deselect();
}
}
