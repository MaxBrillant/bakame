package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.Course;
import Class.NewCourse;
import Class.NewPane;
import Class.NewStudent;
import Class.Student;
import Class.TestBox;
import CloudOperations.aws;
import Publishing.NewPublication;
import Stats.StatsPane;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

public class CourseMenu extends JPanel {
	public static JTextField textField;
	public static JButton add;
	public static JButton stats;
	public static JButton publish;
	public static JButton edit;
	public static JButton delete;
	public static JButton goForward;
	public static JButton goBackward;

	/**
	 * Create the panel.
	 */
	public CourseMenu(String classroom_in_ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int) screensize.getWidth(), (int) screensize.getHeight()*20/100*70/100));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension((int) screensize.getWidth()*0/100, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(12, 10));
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(100, 100));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(new Color(60, 60, 60));
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		
		stats = new JButton("");
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Course.selectedCourses.toArray().length>0) {
				StatsPane frame = new StatsPane("All", Course.selectedCourses.get(0).getName(), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
			}else{
				StatsPane frame = new StatsPane("All", "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
			
			}
			}
		});
		stats.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		stats.setPreferredSize(new Dimension(100, 100));
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setIconTextGap(-4);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 18));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(new Color(60, 60, 60));
		panel.add(stats);
		
		publish = new JButton("");
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewPublication np = new NewPublication();
				np.setVisible(true);
			
			}
		});
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.setIconTextGap(-4);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(100, 100));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(new Color(60, 60, 60));
		panel.add(publish);
		
		goForward = new JButton("");
		goForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				goUp(TestBox.getShortName(((JLabel) ((Container) Course.selectedCourses.get(0)).getComponent(0)).getText(), Home.className), Home.className);
				
				
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		    			NewCourse.load(classroom_in_ay_id);
		            	 return null;
		            }
		        }.execute();
			
			
			}
		});
		goForward.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_up.png"));
		goForward.setVerticalTextPosition(SwingConstants.BOTTOM);
		goForward.setPreferredSize(new Dimension(100, 100));
		goForward.setIconTextGap(0);
		goForward.setHorizontalTextPosition(SwingConstants.CENTER);
		goForward.setForeground(Color.WHITE);
		goForward.setFont(new Font("Roboto", Font.PLAIN, 18));
		goForward.setFocusPainted(false);
		goForward.setBorder(null);
		goForward.setBackground(new Color(60, 60, 60));
		panel.add(goForward);
		
		goBackward = new JButton("");
		goBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				goDown(TestBox.getShortName(((JLabel) ((Container) Course.selectedCourses.get(0)).getComponent(0)).getText(), Home.className), Home.className);
				
				
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		    			NewCourse.load(classroom_in_ay_id);
		            	 return null;
		            }
		        }.execute();
			
			
			
			}
		});
		goBackward.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_down.png"));
		goBackward.setVerticalTextPosition(SwingConstants.BOTTOM);
		goBackward.setPreferredSize(new Dimension(100, 100));
		goBackward.setIconTextGap(0);
		goBackward.setHorizontalTextPosition(SwingConstants.CENTER);
		goBackward.setForeground(Color.WHITE);
		goBackward.setFont(new Font("Roboto", Font.PLAIN, 18));
		goBackward.setFocusPainted(false);
		goBackward.setBorder(null);
		goBackward.setBackground(new Color(60, 60, 60));
		panel.add(goBackward);
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCourse nt = new NewCourse();
				nt.setVisible(true);
				nt.actualiser.setVisible(true);
				nt.create.setVisible(false);
				String s = courseData(((JLabel) ((Container) Course.selectedCourses.get(0)).getComponent(0)).getText());
				List l = Arrays.asList(s.split("//"));
				nt.courseName.setText(l.get(1).toString());
				nt.name.setText(l.get(0).toString());
				nt.TP.setSelectedItem(l.get(2).toString());
			}
		});
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(100, 100));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(60, 60, 60));
		panel.add(edit);
		
		delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< Course.selectedCourses.toArray().length; i++) {
				deleteStudent(TestBox.getShortName(((JLabel) ((Container) Course.selectedCourses.get(i)).getComponent(0)).getText(), Home.className), Home.className);
				}
				
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		    			NewCourse.load(classroom_in_ay_id);
		            	 return null;
		            }
		        }.execute();
			
			}
		});
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(100, 100));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(new Color(60, 60, 60));
		panel.add(delete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(panel.getBackground());
		panel_1.setPreferredSize(new Dimension(350, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(88, 0, 281, 30);
		panel_1.add(textField);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"A-Z", "merite", "Progres", "Echecs"}));
		comboBox_2.setFont(new Font("Roboto", Font.BOLD, 17));
		comboBox_2.setBounds(50, 77, 96, 30);
		//panel_1.add(comboBox_2);
		
		JButton btnElevesSupprimes = new JButton("Cours supprimes");
		btnElevesSupprimes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(60, 60, 60));
			}
			
		});
		btnElevesSupprimes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnElevesSupprimes.setPreferredSize(new Dimension(100, 100));
		btnElevesSupprimes.setIconTextGap(0);
		btnElevesSupprimes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnElevesSupprimes.setForeground(Color.WHITE);
		btnElevesSupprimes.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnElevesSupprimes.setFocusPainted(false);
		btnElevesSupprimes.setBorder(null);
		btnElevesSupprimes.setBackground(new Color(60, 60, 60));
		btnElevesSupprimes.setBounds(206, 46, 134, 24);
		panel_1.add(btnElevesSupprimes);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 60, 60));
		panel_3.setBounds(10, 40, 177, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		

		
		JLabel label = new JLabel("Travaux");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_3.add(label, BorderLayout.CENTER);
		label.setText(Home.periodText.get(Home.selectedPeriod));
		

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod>0) {
					Home.selectedPeriod--;
				}else {
					Home.selectedPeriod = Home.periodText.toArray().length-1;
				}
				label.setText(Home.periodText.get(Home.selectedPeriod));
				for(int i = 0; i< Application.panel2.getComponentCount(); i++) {
					if(Application.panel2.getComponent(i) instanceof Course) {
						String course_id = (String) Application.panel2.getComponent(i).getName();
					NewCourse.loadCoursedata((Container) Application.panel2.getComponent(i), course_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
				}
		});
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(60, 60, 60));
		panel_3.add(button_3, BorderLayout.WEST);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod<Home.periodText.toArray().length-1) {
					Home.selectedPeriod++;
				}else {
					Home.selectedPeriod = 0;
				}
				label.setText(Home.periodText.get(Home.selectedPeriod));

				for(int i = 0; i< Application.panel2.getComponentCount(); i++) {
					if(Application.panel2.getComponent(i) instanceof Course) {
						String course_id = (String) Application.panel2.getComponent(i).getName();
					NewCourse.loadCoursedata((Container) Application.panel2.getComponent(i), course_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
			}
		});
		button_4.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_4.setPreferredSize(new Dimension(30, 30));
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setBorder(null);
		button_4.setBackground(new Color(60, 60, 60));
		panel_3.add(button_4, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setBounds(10, 77, 195, 30);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		
		JLabel label_1 = new JLabel("2eme Trimestre");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_4.add(label_1, BorderLayout.CENTER);
		
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				label_1.setText(Home.termsText.get(Home.selectedTermIndex));

				for(int i = 0; i< Application.panel2.getComponentCount(); i++) {
					if(Application.panel2.getComponent(i) instanceof Course) {
						String course_id = (String) Application.panel2.getComponent(i).getName();
					NewCourse.loadCoursedata((Container) Application.panel2.getComponent(i), course_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
				}
		});
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(60, 60, 60));
		panel_4.add(button_1, BorderLayout.WEST);
		label_1.setText(Home.termsText.get(Home.selectedTermIndex));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				label_1.setText(Home.termsText.get(Home.selectedTermIndex));

				for(int i = 0; i< Application.panel2.getComponentCount(); i++) {
					if(Application.panel2.getComponent(i) instanceof Course) {
						String course_id = (String) Application.panel2.getComponent(i).getName();
					NewCourse.loadCoursedata((Container) Application.panel2.getComponent(i), course_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
			}
		});
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(60, 60, 60));
		panel_4.add(button_2, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(panel.getBackground());
		panel_2.setPreferredSize(new Dimension(130, 200));
		add(panel_2, BorderLayout.WEST);
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button.setPreferredSize(new Dimension(100, 100));
		button.setFont(new Font("Arial", Font.PLAIN, 27));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(panel_2.getBackground());
		panel_2.add(button);
		
		Application.deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			String[] s = {"Ajouter","Statistiques","Publier","Monter","Descendre","Modifier","Supprimer"};
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(120, 120, 120));
					((AbstractButton) panel.getComponent(j)).setText(s[j]);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
					((AbstractButton) panel.getComponent(j)).setText(null);
				}
			});
		}
	}
	
	
	public static void deselect() {

		edit.setVisible(false);
		delete.setVisible(false);
		goForward.setVisible(false);
		goBackward.setVisible(false);
		
		if(!NewCourse.isEmpty) {
		for(int k = 0;k<Application.panel2.getComponentCount(); k++) {
		for(int i =0;i<((Container) Application.panel2.getComponent(k)).getComponentCount();i++) {
			for(int j = 0;j<Application.panel2.getComponentCount();j++) {
				//((Container) Application.panel2.getComponent(j)).getComponent(i).setForeground(Color.white);
			Application.panel2.getComponent(j).setBackground(new Color(60, 60, 60));
		}
		}
}
		Application.no.setText(String.valueOf(Application.panel2.getComponentCount()));
		}else {

	Application.no.setText("0");
}
		CourseMenu.stats.setVisible(true);
		}
	
	
	public static void deleteStudent(String shortName, String className) {
		

		List<String> StudentList = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Courses.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				StudentList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<StudentList.toArray().length; i++) {
			List l = Arrays.asList(StudentList.get(i).split("//"));
			if(l.get(0).toString().equals(shortName)) {
				StudentList.add(i, StudentList.get(i).replaceAll("//active", "//deleted"));
				StudentList.remove(i+1);
			}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Courses.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<StudentList.toArray().length;j++) {
			pw.println((String)StudentList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
	}
	
	
	
	
	
	
	public static void goUp (String shortName, String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Courses.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		for(int i = 0; i< comp.toArray().length; i++) {

			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(shortName)) {
				comp.add(i-1, comp.get(i));
				comp.remove(i+1);
			}
		
		}
		
		if(file.exists()) {
			file.delete();
		}

	try {
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	aws.upload(file.getPath());
	}
	public static void goDown (String shortName, String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Courses.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		for(int i = 0; i< comp.toArray().length; i++) {
			if(i+1 < comp.toArray().length) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(shortName)) {
				comp.add(i+2, comp.get(i));
				comp.remove(i);
				break;
			}
			}
		}
		if(file.exists()) {
			file.delete();
		}

	try {
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	aws.upload(file.getPath());
	}
}
