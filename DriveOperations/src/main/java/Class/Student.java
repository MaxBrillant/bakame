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
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Class;
import Application.Group;
import Application.Home;
import Class.OptionsMenu.HomeMenu1;
import Class.OptionsMenu.StudentMenu;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.App;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import sideInformation.ClassInfo;
import sideInformation.MainInfo;

public class Student extends JPanel {
	public static JPanel Box1;
	public static List<Component> selectedStudents = new ArrayList();

	/**
	 * Create the panel.
	 */
	public Student(String classroom_in_ay_id) {
		setBackground(new Color(60, 60, 60));
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				

				StudentMenu.deselect();
					boolean alreadyExists = false;
					if((MouseEvent.CTRL_MASK & e.getModifiers())!=0) {
						if(!selectedStudents.contains(getComponent(0).getParent())) {
							selectedStudents.add(getComponent(0).getParent());
						}else {
							selectedStudents.remove(getComponent(0).getParent());
						}
					}else {

						if(selectedStudents.contains(getComponent(0).getParent())) {
						alreadyExists = true;
						}
					deselectAll();
					StudentMenu.deselect();
					selectedStudents.add(getComponent(0).getParent());
					}


					if(selectedStudents.toArray().length==1) {
						Component comp = null;

					for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
							if(Application.panel1.getComponent(i).equals(selectedStudents.get(0))) {
								comp = Application.panel1.getComponent(i);
							}
						}
					
							if(!comp.equals(null)) {
					}}
					
					for(int i = 0; i<selectedStudents.toArray().length; i++) {
						for(int j = 0; j< Application.panel1.getComponentCount(); j++) {
							if(Application.panel1.getComponent(j).equals(selectedStudents.get(i))) {
								Application.panel1.getComponent(j).setBackground(new Color(20, 148, 198));
								
								for(int k = 0;k<((Container) Application.panel1.getComponent(j)).getComponentCount();k++) {
									((Container) Application.panel1.getComponent(j)).getComponent(k).setForeground(Color.white);
								}
					}}}
					
				//

					StudentMenu.open.setVisible(true);
					StudentMenu.edit.setVisible(true);
					StudentMenu.settings2.setVisible(true);
					StudentMenu.delete.setVisible(true);
					StudentMenu.retirer.setVisible(true);
					StudentMenu.publish.setVisible(true);
					StudentMenu.stats.setVisible(true);
					if(selectedStudents.toArray().length>1) {
						StudentMenu.open.setVisible(false);
						StudentMenu.edit.setVisible(false);
						StudentMenu.settings2.setVisible(false);
						StudentMenu.stats.setVisible(false);
					}
				if(selectedStudents.toArray().length==0) {
					deselectAll();
				}
				
				
				if(e.getClickCount()==2) {
					if(selectedStudents.toArray().length==1) {
					openStudent(getName(), classroom_in_ay_id);
					Application.frame.setVisible(false);
				}}
			}
			public void mouseEntered(MouseEvent e) {
				if(!selectedStudents.contains(getComponent(0).getParent())) {
					setBackground(new Color(60, 60, 60).brighter());
					setBorder(new LineBorder(new Color(20, 148, 198)));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedStudents.contains(getComponent(0).getParent())) {
					setBackground(new Color(60, 60, 60));
					setBorder(null);
				}
				
			}
		});
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 59));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(35, 40));
		panel.setBackground(new Color(51, 255, 204));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("203");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(30, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblUmuhozaChrisKoen = new JLabel();
		lblUmuhozaChrisKoen.setAlignmentX(1.0f);
		lblUmuhozaChrisKoen.setText("Umuhoza Chris Koen Michael");
		lblUmuhozaChrisKoen.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.BOLD, 16));
		add(lblUmuhozaChrisKoen, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(10, 30));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		panel_1.setBackground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("49.75%");
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("-");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		label.setBackground(new Color(250, 128, 114));
		panel_1.add(label);
		
		JLabel lblPoints = new JLabel("Points: 1902.39/2888");
		lblPoints.setVerticalAlignment(SwingConstants.TOP);
		lblPoints.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPoints.setForeground(new Color(211, 211, 211));
		lblPoints.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPoints.setBackground(new Color(250, 128, 114));
		panel_1.add(lblPoints);
		
		JLabel label_1 = new JLabel("-");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		label_1.setBackground(new Color(250, 128, 114));
		panel_1.add(label_1);
		
		JLabel lblPlace = new JLabel("234 eme");
		lblPlace.setVerticalAlignment(SwingConstants.TOP);
		lblPlace.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPlace.setForeground(new Color(211, 211, 211));
		lblPlace.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPlace.setBackground(new Color(250, 128, 114));
		panel_1.add(lblPlace);
		
		JLabel label_5 = new JLabel("-");
		label_5.setVerticalAlignment(SwingConstants.TOP);
		label_5.setHorizontalTextPosition(SwingConstants.LEADING);
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setFont(new Font("Roboto", Font.PLAIN, 14));
		label_5.setBackground(new Color(250, 128, 114));
		panel_1.add(label_5);
		
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
		label_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		label_2.setBackground(new Color(250, 128, 114));
		panel_1.add(label_2);
		
		JLabel lblInterros = new JLabel("53 interros");
		lblInterros.setVerticalAlignment(SwingConstants.TOP);
		lblInterros.setHorizontalTextPosition(SwingConstants.LEADING);
		lblInterros.setForeground(new Color(211, 211, 211));
		lblInterros.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblInterros.setBackground(new Color(250, 128, 114));
		panel_1.add(lblInterros);
		
		JLabel label_3 = new JLabel("-");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Roboto", Font.PLAIN, 14));
		label_3.setBackground(new Color(250, 128, 114));
		panel_1.add(label_3);
		
		JLabel lblEducation = new JLabel("Education: 82/180");
		lblEducation.setVerticalAlignment(SwingConstants.TOP);
		lblEducation.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEducation.setForeground(new Color(211, 211, 211));
		lblEducation.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEducation.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEducation);
		
		JLabel label_4 = new JLabel("-");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setForeground(new Color(211, 211, 211));
		label_4.setFont(new Font("Roboto", Font.PLAIN, 14));
		label_4.setBackground(new Color(250, 128, 114));
		panel_1.add(label_4);
		
		JLabel lblProgres = new JLabel("Progres: 120.75%");
		lblProgres.setVerticalAlignment(SwingConstants.TOP);
		lblProgres.setHorizontalTextPosition(SwingConstants.LEADING);
		lblProgres.setForeground(new Color(211, 211, 211));
		lblProgres.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProgres.setBackground(new Color(250, 128, 114));
		panel_1.add(lblProgres);
	
		
	}
	
	public static void openStudent(String student_id, String classroom_in_ay_id) {
		
		int index = 0;
		Object [] lines = Home.loadActiveStudents(classroom_in_ay_id);
		for(int i = 0; i<lines.length;i++) {
			List note = Arrays.asList(lines[i].toString().trim().split("//"));
			if(note.get(0).toString().equals(student_id)) {
				index = i;
				break;
			}
		}
		App.n= index;
		App app = new App(classroom_in_ay_id);
		app.frame.setVisible(true);
	}
	
	

public static void deselectAll() {
	for(int i = 0; i< ((Container) Application.panel1).getComponentCount(); i++) {
		if(selectedStudents.contains(((Container) Application.panel1).getComponent(i))) {
			((JComponent) ((Container) Application.panel1).getComponent(i)).setBackground(new Color(60, 60, 60));
			((JComponent) ((Container) Application.panel1).getComponent(i)).setBorder(null);
		}
			Application.panel1.revalidate();

			Application.panel1.repaint();
	
	}

	selectedStudents.clear();
	
	StudentMenu.deselect();
}
}
