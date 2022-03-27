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
	public static JLabel place;
	public static JLabel number;
	public static JLabel lblNdashimyeMaxBrillant;
	public static JLabel label_5;
	public static List<Component> selectedStudents = new ArrayList();

	/**
	 * Create the panel.
	 */
	public Student() {
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
					openStudent(((JLabel) ((Container) selectedStudents.get(selectedStudents.toArray().length-1)).getComponent(2)).getText());
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
		setPreferredSize(new Dimension(screensize.width*97/100, 40));
		setLayout(null);
		
		number = new JLabel();
		number.setForeground(Color.BLACK);
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setBounds(5, 0, 39, 40);
		number.setFont(new Font("Roboto", Font.PLAIN, 23));
		add(number);
		
		place = new JLabel();
		place.setForeground(Color.WHITE);
		place.setHorizontalAlignment(SwingConstants.CENTER);
		place.setBounds(50, 0, 94, 40);
		place.setFont(new Font("Roboto", Font.PLAIN, 23));
		add(place);
		
		lblNdashimyeMaxBrillant = new JLabel();
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblNdashimyeMaxBrillant.setBounds(141, 0, 380, 40);
		add(lblNdashimyeMaxBrillant);
		
		JLabel label = new JLabel("0%");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.PLAIN, 23));
		label.setBounds(520, 0, 94, 40);
		add(label);
		
		JLabel label_1 = new JLabel("0/0");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_1.setBounds(653, 0, 134, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_2.setBounds(807, 0, 94, 40);
		add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_3.setBounds(932, 0, 94, 40);
		add(label_3);
		
		JLabel label_4 = new JLabel("+0%");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_4.setBounds(1077, 0, 94, 40);
		add(label_4);
		
		label_5 = new JLabel();
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_5.setBounds(1181, 0, 147, 40);
		add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 204));
		panel.setBounds(0, 0, 53, 40);
		add(panel);
	
		
	}
	
	public static void openStudent(String studentName) {
		
		int index = 0;
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		aws.downloadContent(file.getPath());
		FileReader fr;
		try {
			fr = new FileReader(file);
		
		
		BufferedReader br = new BufferedReader(fr);
		Object [] lines = Home.loadActiveStudents(file.getPath());
		for(int i = 0; i<lines.length;i++) {
			List note = Arrays.asList(lines[i].toString().trim().split("//"));
			if(note.get(0).toString().equals(studentName)) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		App.n= index;
		App app = new App();
		app.frame.setVisible(true);
		Application.frame.setVisible(false);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
