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
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(420, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(12, 10));
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
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
		stats.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		stats.setPreferredSize(new Dimension(50, 50));
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setIconTextGap(-4);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 18));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(panel.getBackground());
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
		publish.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.setIconTextGap(-4);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(50, 50));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(panel.getBackground());
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
		goForward.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_up.png"));
		goForward.setVerticalTextPosition(SwingConstants.BOTTOM);
		goForward.setPreferredSize(new Dimension(50, 50));
		goForward.setIconTextGap(0);
		goForward.setHorizontalTextPosition(SwingConstants.CENTER);
		goForward.setForeground(Color.WHITE);
		goForward.setFont(new Font("Roboto", Font.PLAIN, 18));
		goForward.setFocusPainted(false);
		goForward.setBorder(null);
		goForward.setBackground(panel.getBackground());
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
		goBackward.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_down.png"));
		goBackward.setVerticalTextPosition(SwingConstants.BOTTOM);
		goBackward.setPreferredSize(new Dimension(50, 50));
		goBackward.setIconTextGap(0);
		goBackward.setHorizontalTextPosition(SwingConstants.CENTER);
		goBackward.setForeground(Color.WHITE);
		goBackward.setFont(new Font("Roboto", Font.PLAIN, 18));
		goBackward.setFocusPainted(false);
		goBackward.setBorder(null);
		goBackward.setBackground(panel.getBackground());
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
		edit.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
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
		delete.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"A-Z", "merite", "Progres", "Echecs"}));
		comboBox_2.setFont(new Font("Roboto", Font.BOLD, 17));
		comboBox_2.setBounds(50, 77, 96, 30);
		
		Application.deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(panel.getBackground());
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
		for(int k = 0;k<Application.panelCourses.getComponentCount(); k++) {
		for(int i =0;i<((Container) Application.panelCourses.getComponent(k)).getComponentCount();i++) {
			for(int j = 0;j<Application.panelCourses.getComponentCount();j++) {
				//((Container) Application.panelCourses.getComponent(j)).getComponent(i).setForeground(Color.white);
			Application.panelCourses.getComponent(j).setBackground(new Color(60, 60, 60));
		}
		}
}
		Application.no.setText(String.valueOf(Application.panelCourses.getComponentCount()));
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
