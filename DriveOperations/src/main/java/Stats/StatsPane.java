package Stats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Application.Home;
import Application.ResizeImages;
import Class.Animations;
import Class.CustomVerticalScrollBarUI;
import Class.TestBox;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.LPane;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Point;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.MouseWheelEvent;
import javax.swing.JSeparator;

public class StatsPane extends JFrame {

	private JPanel contentPane;
	private JPanel panel_4;
	private JPanel panel_6;
	public static JLabel name;
	public static JLabel course;
	public static JLabel className;
	public static JLabel Term;
	public static List<String> terms = new ArrayList();
	public static List<String> classes = new ArrayList();
	public static List<String> courses = new ArrayList();
	public static List<String> students = new ArrayList();
	public static int selectedTerm;
	public static int selectedClass;
	public static int selectedCourse;
	public static int selectedStudent;
	public static JScrollPane scrollPane;
	public static JLabel number;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					mysql.connectToDB();
					StatsPane frame = new StatsPane("1", "1", "All", "Toute l'annee");
					frame.setVisible(true);
					System.gc();
					Thread.currentThread().setPriority((int) (Thread.MAX_PRIORITY*0.8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StatsPane(String student_in_classroom_id, String course_in_classroom_id, String classroom_in_ay_id, String term_id) {
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(400, 600));
		setBounds(100, 100, 450, screensize.height*90/100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Login.setAsPopup(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setPreferredSize(new Dimension(10, 200));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorderPainted(false);
		popupMenu.setBackground(new Color(0, 0, 0,120));
		popupMenu.setPreferredSize(new Dimension(335, 100));
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setBounds(49, 44, 335, 30);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton left1 = new JButton("");
		left1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		left1.setPreferredSize(new Dimension(30, 30));
		left1.setFocusPainted(false);
		left1.setBorderPainted(false);
		left1.setBorder(null);
		left1.setBackground(new Color(60, 60, 60));
		panel_4.add(left1, BorderLayout.WEST);
		
		JButton right1 = new JButton("");
		right1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		right1.setPreferredSize(new Dimension(30, 30));
		right1.setFocusPainted(false);
		right1.setBorderPainted(false);
		right1.setBorder(null);
		right1.setBackground(new Color(60, 60, 60));
		panel_4.add(right1, BorderLayout.EAST);
		
		Term = new JLabel();
		Term.setHorizontalAlignment(SwingConstants.CENTER);
		Term.setForeground(Color.WHITE);
		Term.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_4.add(Term, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(60, 60, 60));
		panel_7.setBounds(49, 76, 335, 30);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton left2 = new JButton("");
		left2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		left2.setPreferredSize(new Dimension(30, 30));
		left2.setFocusPainted(false);
		left2.setBorderPainted(false);
		left2.setBorder(null);
		left2.setBackground(new Color(60, 60, 60));
		panel_7.add(left2, BorderLayout.WEST);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		popupMenu_1.setPreferredSize(new Dimension(335, 100));
		popupMenu_1.setBorderPainted(false);
		popupMenu_1.setBackground(new Color(0, 0, 0, 120));
		addPopup(left2, popupMenu_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(0, 0, 0, 125));
		scrollPane_1.setAutoscrolls(true);
		popupMenu_1.add(scrollPane_1);
		JPanel panel_8 = new JPanel();
		panel_8.setMaximumSize(new Dimension(0, 300));
		panel_8.setBackground(new Color(0, 0, 0, 125));
		scrollPane_1.setViewportView(panel_8);
		panel_8.setLayout(new WrapLayout(1, 3, 3));
		
		JButton right2 = new JButton("");
		right2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		right2.setPreferredSize(new Dimension(30, 30));
		right2.setFocusPainted(false);
		right2.setBorderPainted(false);
		right2.setBorder(null);
		right2.setBackground(new Color(60, 60, 60));
		panel_7.add(right2, BorderLayout.EAST);
		
		className = new JLabel();
		className.setHorizontalAlignment(SwingConstants.CENTER);
		className.setForeground(Color.WHITE);
		className.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_7.add(className, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(60, 60, 60));
		panel_9.setBounds(49, 108, 335, 30);
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JButton left3 = new JButton("");
		left3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		left3.setPreferredSize(new Dimension(30, 30));
		left3.setFocusPainted(false);
		left3.setBorderPainted(false);
		left3.setBorder(null);
		left3.setBackground(new Color(60, 60, 60));
		panel_9.add(left3, BorderLayout.WEST);
		
		JPopupMenu popupMenu1 = new JPopupMenu();
		addPopup(left3, popupMenu1);
		popupMenu1.setPreferredSize(new Dimension(335, 100));
		popupMenu1.setBorderPainted(false);
		popupMenu1.setBackground(new Color(0, 0, 0, 120));
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBackground(new Color(0, 0, 0, 125));
		scrollPane2.setAutoscrolls(true);
		popupMenu1.add(scrollPane2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(0, 300));
		panel_5.setBackground(new Color(0, 0, 0, 125));
		scrollPane2.setViewportView(panel_5);
		panel_5.setLayout(new WrapLayout(1, 3, 3));
		
		JButton right3 = new JButton("");
		right3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		right3.setPreferredSize(new Dimension(30, 30));
		right3.setFocusPainted(false);
		right3.setBorderPainted(false);
		right3.setBorder(null);
		right3.setBackground(new Color(60, 60, 60));
		panel_9.add(right3, BorderLayout.EAST);
		
		course = new JLabel("Mathematiques Statistiques");
		course.setHorizontalAlignment(SwingConstants.CENTER);
		course.setForeground(Color.WHITE);
		course.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_9.add(course, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(60, 60, 60));
		panel_10.setBounds(49, 140, 335, 30);
		panel_1.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JButton left4 = new JButton("");
		left4.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		left4.setPreferredSize(new Dimension(30, 30));
		left4.setFocusPainted(false);
		left4.setBorderPainted(false);
		left4.setBorder(null);
		left4.setBackground(new Color(60, 60, 60));
		panel_10.add(left4, BorderLayout.WEST);
		
		JButton right4 = new JButton("");
		right4.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		right4.setPreferredSize(new Dimension(30, 30));
		right4.setFocusPainted(false);
		right4.setBorderPainted(false);
		right4.setBorder(null);
		right4.setBackground(new Color(60, 60, 60));
		panel_10.add(right4, BorderLayout.EAST);
		
		name = new JLabel("DUSHIME Sylvio");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_10.add(name, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				revalidate();
				repaint();
			}
		});
		panel.add(scrollPane, BorderLayout.CENTER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		
		JPanel panel_2 = new JPanel();
		//StudentStats s = new StudentStats(student_id, classroom_id, course_id, term_id, "All", "All");
		//scrollPane.setViewportView(s);
		panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		setLocationRelativeTo(null);
		

		addPopup(panel_10, popupMenu);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBackground(new Color(0, 0, 0,125));
		popupMenu.add(scrollPane1);
		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(0, 300));
		panel_3.setBackground(new Color(0, 0, 0,125));
		scrollPane1.setViewportView(panel_3);
		panel_3.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		
		JLabel lblNewLabel = new JLabel("Statistiques");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel.setBounds(49, 3, 335, 30);
		panel_1.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 35, 434, 2);
		panel_1.add(separator);
		
		number = new JLabel("12");
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setForeground(Color.WHITE);
		number.setFont(new Font("Roboto", Font.BOLD, 17));
		number.setBounds(150, 170, 134, 30);
		panel_1.add(number);


		displayStats(student_in_classroom_id, course_in_classroom_id, classroom_in_ay_id, term_id);
		
/*
		new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{*/
		if(selectedStudent == 0) {
			CourseStats cs = new CourseStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
			scrollPane.setViewportView(cs);
			CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
			number.setVisible(false);
		}else {
			StudentStats cs = new StudentStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
			scrollPane.setViewportView(cs);
			StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
			number.setVisible(false);
		} /*
			 * return null; } }.execute();
			 */

		right1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedTerm == terms.toArray().length-1) {
					selectedTerm = 0;
				}else {
					selectedTerm++;
				}

				if(selectedTerm == terms.toArray().length-1) {
					Term.setText(terms.get(selectedTerm));
				}else {
					Term.setText(Home.getTermName(terms.get(selectedTerm)));
					}

				if(selectedStudent == 0) {
					number.setVisible(false);
					CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}else {
					number.setVisible(true);
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}
				revalidate();
				repaint();
			}
		});right2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedClass == classes.toArray().length-1) {
					selectedClass = 0;
				}else {
					selectedClass++;
				}
				
				selectedStudent = 1;
				selectedCourse = 1;
				
					StudentStats cs = new StudentStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					scrollPane.setViewportView(cs);
					number.setVisible(true);
					
				displayStats(students.get(selectedStudent), courses.get(selectedCourse), classes.get(selectedClass), terms.get(selectedTerm));

				StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				revalidate();
				repaint();
			}
		});right3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCourse == courses.toArray().length-1) {
					selectedCourse = 0;
				}else {
					selectedCourse++;
				}
				if(selectedCourse > 0) {
					course.setText(TestBox.getFullName(courses.get(selectedCourse)));
				}else {
					course.setText(courses.get(selectedCourse));
					}
				if(selectedStudent == 0) {
					CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}else {
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}
				revalidate();
				repaint();
			}
		});right4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(selectedStudent == students.toArray().length-1) {
					selectedStudent = 0;
					name.setText("All");
					CourseStats cs = new CourseStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					scrollPane.setViewportView(cs);
					CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					number.setVisible(false);
				}else {
					if(selectedStudent == 0) {
					StudentStats cs = new StudentStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					scrollPane.setViewportView(cs);
					number.setVisible(true);
					}
					selectedStudent++;
					name.setText(Home.getStudentName(students.get(selectedStudent)));
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}

				revalidate();
				repaint();
			}
		});

		
		left1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedTerm == 0) {
					selectedTerm = terms.toArray().length-1;
				}else {
					selectedTerm--;
				}

				if(selectedTerm == terms.toArray().length-1) {
					Term.setText(terms.get(selectedTerm));
				}else {
					Term.setText(Home.getTermName(terms.get(selectedTerm)));
					}

				if(selectedStudent == 0) {
					number.setVisible(false);
					CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}else {
					number.setVisible(true);
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}
				revalidate();
				repaint();
			}
		});left2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedClass == 0) {
					selectedClass = classes.toArray().length-1;
				}else {
					selectedClass--;
				}
				selectedStudent = 1;
				selectedCourse = 1;
				
					StudentStats cs = new StudentStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					scrollPane.setViewportView(cs);
					number.setVisible(true);
					
				displayStats(students.get(selectedStudent), courses.get(selectedCourse), classes.get(selectedClass), terms.get(selectedTerm));

				StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				revalidate();
				repaint();
			
			}
		});left3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCourse == 0) {
					selectedCourse = courses.toArray().length-1;
				}else {
					selectedCourse--;
				}
				if(selectedCourse > 0) {
					course.setText(TestBox.getFullName(courses.get(selectedCourse)));
				}else {
					course.setText(courses.get(selectedCourse));
					}
				if(selectedStudent == 0) {
					CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}else {
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
				}
				revalidate();
				repaint();
			}
		});left4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(selectedStudent == 0) {
					selectedStudent = students.toArray().length-1;
					name.setText(Home.getStudentName(students.get(selectedStudent)));
					StudentStats cs = new StudentStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					scrollPane.setViewportView(cs);
					StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
					number.setVisible(true);

				}else {
					selectedStudent--;
					name.setText(Home.getStudentName(students.get(selectedStudent)));
					if(selectedStudent == 0) {
						name.setText("All");
						CourseStats cs = new CourseStats(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
						scrollPane.setViewportView(cs);
						CourseStats.loadCourseData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
						number.setVisible(false);
						}else {
							StudentStats.loadStudentData(students.get(selectedStudent), classes.get(selectedClass), courses.get(selectedCourse), terms.get(selectedTerm), "All", "All");
						}
				}

				revalidate();
				repaint();
			}
		});
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getComponent() == component && e.getClickCount() == 2) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(component, 0, component.getHeight());
			}
		});
	}
	
	
	
	
	public static void displayStats(String student_in_classroom_id, String course_in_classroom_id, String classroom_in_ay_id, String term_id) {
		
		populateTermsList(Login.selectedAcademicYearID);
		populateClassList(Login.selectedAcademicYearID);
		populateCourseList(classroom_in_ay_id);
		populateStudentList(classroom_in_ay_id);
		

		for(int i = 0; i< students.toArray().length; i++) {
			if(students.get(i).equals(student_in_classroom_id)) {
		selectedStudent = i;
		break;
		}}
		for(int i = 0; i< courses.toArray().length; i++) {
			if(courses.get(i).equals(course_in_classroom_id)) {
				selectedCourse = i;
		break;
		}}
		for(int i = 0; i< classes.toArray().length; i++) {
			if(classes.get(i).equals(classroom_in_ay_id)) {
				selectedClass = i;
		break;
		}}
		for(int i = 0; i< terms.toArray().length; i++) {
			if(terms.get(i).equals(term_id)) {
				selectedTerm = i;
		break;
		}}
		
		className.setText(Home.getClassName(classes.get(selectedClass)));

		if(selectedTerm == terms.toArray().length-1) {
			Term.setText(terms.get(selectedTerm));
		}else {
			Term.setText(Home.getTermName(terms.get(selectedTerm)));
			}
		
		if(selectedStudent>0) {
		name.setText(Home.getStudentName(students.get(selectedStudent)));
		}else {
			name.setText("All");
		}
		if(selectedCourse>0) {
		course.setText(TestBox.getFullName(courses.get(selectedCourse)));
		}else {
			course.setText("All");	
		}
	}
	
	public static void populateTermsList(String ay_id) {
		terms.clear();
		Object[] l = Home.loadActiveTerms(ay_id);
		for(int i = 0; i< l.length; i++) {
		terms.add(l[i].toString());
		}
		terms.add("Toute l'annee");
	}
	
	public static void populateClassList(String ay_id) {
		classes.clear();
		Object[] l = Home.loadActiveClasses(ay_id);
		for(int i = 0; i< l.length; i++) {
		classes.add(l[i].toString());
		}
		}

		/*
		 * public static int getClassIndex(String className) {
		 * 
		 * int index = 0; File file1 = new
		 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
		 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		 * 
		 * aws.downloadContent(file1.getPath()); FileReader fr1; try { fr1 = new
		 * FileReader(file1);
		 * 
		 * 
		 * BufferedReader br1 = new BufferedReader(fr1); Object[] lines1 =
		 * Home.loadActiveClasses(file1.getPath());
		 * 
		 * for(int i = 0; i< lines1.length; i++) { List name =
		 * Arrays.asList(lines1[i].toString().split("//"));
		 * 
		 * if(hasCourses(name.get(0).toString()) && hasStudents(name.get(0).toString()))
		 * { index = index+1; if(name.get(0).toString().equals(className)) { index =
		 * index-1; break; }} } } catch (FileNotFoundException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } return index; }
		 */
	public static void populateCourseList(String classroom_id) {
		courses.clear();
		courses.add("All");
		Object[] lines1 = Home.loadActiveCourses(classroom_id);
		
		for(int i = 0; i< lines1.length; i++) {
			courses.add(lines1[i].toString());
		}
	}
	
	/*
	 * public static int getCourseIndex(String shortName, String className) {
	 * 
	 * int index = 0; File file1 = new
	 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
	 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+
	 * "/Courses.txt");
	 * 
	 * aws.downloadContent(file1.getPath()); FileReader fr1; try { fr1 = new
	 * FileReader(file1);
	 * 
	 * 
	 * BufferedReader br1 = new BufferedReader(fr1); Object[] lines1 =
	 * Home.loadActiveCourses(file1.getPath());
	 * 
	 * for(int i = 0; i< lines1.length; i++) { List name =
	 * Arrays.asList(lines1[i].toString().split("//"));
	 * 
	 * if(name.get(0).toString().equals(shortName)) { index = i+1; break; } } }
	 * catch (FileNotFoundException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } return index; }
	 */
	
	public static void populateStudentList(String classroom_id) {
		students.clear();
		students.add("All");
		Object[] lines1 = Home.loadActiveStudents(classroom_id);
		
		for(int i = 0; i< lines1.length; i++) {
			students.add(lines1[i].toString());
		}
	}/*
		 * 
		 * public static int getStudentIndex(String studentName, String className) {
		 * 
		 * int index = 0; File file1 = new
		 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
		 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+
		 * "/Students.txt");
		 * 
		 * aws.downloadContent(file1.getPath()); FileReader fr1; try { fr1 = new
		 * FileReader(file1);
		 * 
		 * 
		 * BufferedReader br1 = new BufferedReader(fr1); Object[] lines1 =
		 * Home.loadActiveStudents(file1.getPath());
		 * 
		 * for(int i = 0; i< lines1.length; i++) { List name =
		 * Arrays.asList(lines1[i].toString().split("//"));
		 * 
		 * if(name.get(0).toString().replaceAll("::", " ").equals(studentName)) { index
		 * = i+1; break; } } } catch (FileNotFoundException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); } return index; }
		 */
	
	
	public static boolean hasCourses(String classroom_id) {
		boolean hasc = false ;
		Object[] lines1 = Home.loadActiveCourses(classroom_id);

		if(lines1.length>0) {
			hasc = true;
		}else {
			hasc = false;
		}
		return hasc;
	}
	public static boolean hasStudents(String classroom_id) {
		boolean hasc = false ;
		Object[] lines1 = Home.loadActiveStudents(classroom_id);

		if(lines1.length>0) {
			hasc = true;
		}else {
			hasc = false;
		}
		return hasc;
	}
}
