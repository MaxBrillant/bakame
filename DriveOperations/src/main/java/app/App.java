package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import static javax.swing.ScrollPaneConstants.*;

import javax.mail.MessagingException;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.TestBox;
import Class.OptionsMenu.StudentMenu;
import CloudOperations.aws;
import CloudOperations.mysql;
import Class.CustomVerticalScrollBarUI;
import Class.NewStudent;
import app.NewTest;
import Class.Student;
import Publishing.Mail;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import sideInformation.StudentInfo;

import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class App {

	public static JFrame frame;
	public static int count = 0;
	public static JPanel panel;
	public static JPanel panel_5;
	public static JButton delete;
	public static JPanel panel_1;
	public static boolean saveTests = false;
	public static JButton btnAjouter;
	public static JButton edit;
	
	public static int n;
	public static List<String> students = new ArrayList();
	public static JScrollPane scrollPane;
	public static Component course;
	private static JLabel title;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
	
		
		  
		  
		  
		  
		  
		  File file = new File("C:/Users/User/Desktop/db_script.sql");
		  aws.downloadContent(file.getPath()); FileReader fr; fr = new
		  FileReader(file);
		  
		  
		  BufferedReader br = new BufferedReader(fr); Object[] lines =
		  br.lines().toArray();
		  
		  List<String> l = new ArrayList(); int j = 0; for(int i = 0; i< lines.length;
		  i++) { if(lines[i].toString().contains("CONSTRAINT")) { j++; String s =
		  lines[i].toString().substring(0, lines[i].toString().lastIndexOf("`"))+j+"`";
		  l.add(s); }else{ l.add(lines[i].toString()); }}
		  
		  
		  if(file.exists()) { file.delete(); }
		  
		  file.createNewFile(); for(int i = 0; i< l.toArray().length; i++) {
		  
		  PrintWriter pw = new PrintWriter(file); for(int k = 0;
		  k<l.toArray().length;k++) { pw.println(l.get(k)); }
		  
		  pw.close();}
		 }

	/**
	 * Create the application.
	 */
	public App(String classroom_in_ay_id) {
		initialize(classroom_in_ay_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String classroom_in_ay_id) {

		loadStudents(classroom_in_ay_id);
		
		
		frame = new JFrame();/*
								 * frame.addComponentListener(new ComponentAdapter() {
								 * 
								 * @Override public void componentResized(ComponentEvent e) { Dimension
								 * screensize = Toolkit.getDefaultToolkit().getScreenSize();
								 * 
								 * for(int i = 0; i<panel_5.getComponentCount();i++) {
								 * if(frame.getWidth()<=1191) { panel_5.setLayout(new
								 * WrapLayout(WrapLayout.CENTER, 15*frame.getWidth()/2/screensize.width,
								 * 15*frame.getWidth()/2/screensize.width)); }else { panel_5.setLayout(new
								 * WrapLayout(WrapLayout.CENTER, 10, 10)); } }} });
								 */
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setMinimumSize(new Dimension(480, 0));
		
		
		
		btnAjouter = new JButton("");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAjouter.setBackground(new Color(0, 180, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouter.setBackground(new Color(0, 150, 150));
			}
		});
		btnAjouter.setBorder(null);
		btnAjouter.setFocusPainted(false);
		btnAjouter.setBackground(new Color(0, 150, 150));
		btnAjouter.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		btnAjouter.setFont(new Font("Arial", Font.PLAIN, 27));
		btnAjouter.setBounds(235, 11, 118, 116);
		
		delete = new JButton("");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 180, 180));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 150, 150));
			}}
		});
		delete.setBorder(null);
		delete.setFocusPainted(false);
		delete.setBackground(new Color(0, 150, 150));
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setBounds(385, 11, 118, 116);
	//	panel.add(delete);
		
		edit = new JButton("");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 180, 180));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 150, 150));
			}}
		});
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(0, 150, 150));
		edit.setBounds(535, 11, 118, 116);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 25));
		panel_1.setPreferredSize(new Dimension(350, 10));
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		

		
		
		//General g = new General(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
		//JPanel lp = new JPanel();
		//panel_1.add(lp, BorderLayout.CENTER);
		
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 128));
		panel.setBackground(new Color(40, 40, 40));
		panel.setLayout(new BorderLayout(0, 0));
		frame.add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		panel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect(classroom_in_ay_id);
			}
		});
		panel1.setBackground(Home.getClassColors(classroom_in_ay_id).get(0));
		panel1.setPreferredSize(new Dimension(10, 45));
		panel.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		title = new JLabel(Home.getClassName(classroom_in_ay_id)+" - "+Home.getStudentName(App.students.get(App.n)));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Home.getClassColors(classroom_in_ay_id).get(1));
		title.setFont(new Font("Roboto", Font.BOLD, 16));
		panel1.add(title, BorderLayout.CENTER);
		
		JButton btnAs = new JButton("Eleves");
		btnAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Application app = new Application(classroom_in_ay_id);
				app.frame.setVisible(true);
				App.frame.setVisible(false);
			}
		});
		btnAs.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		//button_2.setPreferredSize(new Dimension(150, 14));
		btnAs.setForeground(Home.getClassColors(classroom_in_ay_id).get(1));
		btnAs.setFont(new Font("Roboto", Font.BOLD, 16));
		btnAs.setFocusPainted(false);
		btnAs.setBorderPainted(false);
		btnAs.setBackground(panel1.getBackground());
		panel1.add(btnAs, BorderLayout.WEST);
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(40, 40, 40));
		panel_3.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		

		JButton logo = new JButton("");
		logo.setMultiClickThreshhold(1000L);
		logo.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		logo.setPreferredSize(new Dimension(70, 50));
		logo.setFont(new Font("Arial", Font.PLAIN, 27));
		logo.setFocusPainted(false);
		logo.setBorder(null);
		logo.setBackground(new Color(40, 40, 40));
		panel_10.add(logo, BorderLayout.WEST);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		//scrollPane_1.setPreferredSize(new Dimension(2, 40));
		panel_10.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setBackground(scrollPane_1.getParent().getBackground());
		
		
		JPanel panel_11 = new JPanel();
		scrollPane_1.setViewportView(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 10));
		panel_11.setBackground(new Color(40, 40, 40).darker());
		
		
		
		
		
		JPanel panel_41 = new JPanel();
		panel_41.setPreferredSize(new Dimension(190, 30));
		panel_41.setBackground(new Color(60, 60, 60));
		panel_41.setBounds(39, 77, 195, 30);
		panel_11.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JLabel lblerTrimestre = new JLabel("2eme Trimestre");
		lblerTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblerTrimestre.setForeground(Color.WHITE);
		lblerTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_41.add(lblerTrimestre, BorderLayout.CENTER);

		if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
			lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
			}else {
				lblerTrimestre.setText("Toute l'annee");
				}
		
		JButton button_21 = new JButton("");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component selectedCourse = null;
				if(Cours.selectedCourses.toArray().length>0) {
				selectedCourse = Cours.selectedCourses.get(0);
				selectedCourse.setName(Cours.selectedCourses.get(0).getName());
				}if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}

				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
					lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
					}else {
						lblerTrimestre.setText("Toute l'annee");
						}
				loadCourses(classroom_in_ay_id, students.get(n));
				
				if(selectedCourse!= null) {
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}
			}else{
				//General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
			}}
		});
		button_21.setFocusPainted(false);
		button_21.setBorderPainted(false);
		button_21.setBackground(panel_41.getBackground());
		button_21.setBorder(null);
		button_21.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_21.setPreferredSize(new Dimension(30, 30));
		panel_41.add(button_21, BorderLayout.WEST);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
				}
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}

				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
					lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
					}else {
						lblerTrimestre.setText("Toute l'annee");
						}loadCourses(classroom_in_ay_id, students.get(n));
				

				
				if(selectedCourse != null) {
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}}else{
					//	General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
				
			}
		});
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(panel_41.getBackground());
		button_3.setBorder(null);
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		panel_41.add(button_3, BorderLayout.EAST);
		
		
		
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(40, 40, 40));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect(classroom_in_ay_id);
			}
		});
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(null);
		
		panel_5.setLayout(new WrapLayout(WrapLayout.LEFT, 12, 12));
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(350, 80));
		frame.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel logo_panel = new JPanel();
		logo_panel.setPreferredSize(new Dimension(350, 80));
		logo_panel.setBackground(new Color(40, 40, 40));
		panel_4.add(logo_panel, BorderLayout.NORTH);
		logo_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
		
		JButton logo1 = new JButton("");
		logo1.setFocusPainted(false);
		logo1.setBackground(new Color(40, 40, 40));
		logo1.setBorder(null);
		logo_panel.add(logo1);
		logo1.setHorizontalAlignment(SwingConstants.CENTER);
		logo1.setHorizontalTextPosition(SwingConstants.CENTER);
		logo1.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\Open-ed.png"));
		logo1.setPreferredSize(new Dimension(220, 70));
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(350, 2));
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		StudentInfo panel_2 = new StudentInfo(classroom_in_ay_id);
		scrollPane_2.setViewportView(panel_2);
		

		/*
		 * frame.addComponentListener(new ComponentAdapter() {
		 * 
		 * @Override public void componentResized(ComponentEvent e) { Dimension
		 * screensize = Toolkit.getDefaultToolkit().getScreenSize();
		 * 
		 * for(int i = 0; i<panel_5.getComponentCount();i++) {
		 * if(frame.getWidth()<=1191) { panel_5.setLayout(new
		 * WrapLayout(WrapLayout.CENTER, 15*frame.getWidth()/2/screensize.width,
		 * 15*frame.getWidth()/2/screensize.width)); }else { panel_5.setLayout(new
		 * WrapLayout(WrapLayout.CENTER, 10, 10)); } }} });
		 */
		
		deselect(classroom_in_ay_id);

		
		loadCourses(classroom_in_ay_id, students.get(n));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deselect(classroom_in_ay_id);
				createBox();
				NewCourse.create.setVisible(true);
				NewCourse.actualiser.setVisible(false);
				
		        SwingUtilities.invokeLater(() -> {
		            JScrollBar bar = scrollPane.getVerticalScrollBar();
		            bar.setValue(bar.getMaximum());
		    });
		        
			}
		});
	
		
		

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	

		//Exam.loadExams();
	}
	
	public static void loadStudents(String classroom_in_ay_id) { //number selected
		students.clear();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
		
		for(int i = 0;i<lines.length;i++) {
		students.add(lines[i].toString());
		}
	}
	

	
	
	public static void createBox() {
		
		NewCourse nc = new NewCourse();
		nc.setVisible(true);
        
	}
	public static void deselect(String classroom_in_ay_id) {
		
		Cours.isSelected = false;
		
		//General g = new General(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
		//panel_1.remove(0);
		//panel_1.add(g);
		panel_1.setVisible(false);
		Cours.selectedCourses.clear();
		for(int i = 0; i<panel_5.getComponentCount(); i++) {
			((Container) panel_5.getComponent(i)).getComponent(1).setBackground(new Color(60, 60, 60));
			((JComponent) panel_5.getComponent(i)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
			((Container) ((Container) panel_5.getComponent(i)).getComponent(0)).getComponent(0).setForeground(Color.black);
			
			if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(161, 0, 0))) {
				App.panel_5.getComponent(i).setBackground(new Color(255,221,221));
			((Container) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(255,221,221));
			}
			else if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(31, 154, 97))) {
			App.panel_5.getComponent(i).setBackground(new Color(201,255,226));
			((Container) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(201,255,226));
}else if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(120, 120, 120))) {
	App.panel_5.getComponent(i).setBackground(new Color(200, 200, 200));
	((JComponent) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(200, 200, 200));
}
		}
		
		panel_1.revalidate();
		panel_1.repaint();
		panel_5.revalidate();
		panel_5.repaint();
		
		

}
	
	public static void loadName(String classroom_in_ay_id, String student_in_classroom_id, Container c) {
		
		((JLabel) c.getParent().getParent().getParent().getComponent(0)).setText(Home.getStudentName(student_in_classroom_id));
		((JLabel) ((Container) c.getParent().getParent().getParent().getComponent(2)).getComponent(0)).setText(App.getStudentNumber(student_in_classroom_id));
		
		title.setText(Home.getClassName(classroom_in_ay_id)+" - "+Home.getStudentName(student_in_classroom_id));/*
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		if(c.getComponentCount()>0) {
			for(int j = 0; j<c.getComponentCount(); j++) {
				c.getComponent(j).setBackground(new Color(80, 80, 80));
				((Container) c.getComponent(j)).getComponent(0).setForeground(Color.white);
			}
		c.getComponent(App.n).setBackground(new Color(20, 148, 198));
		((Container) c.getComponent(App.n)).getComponent(0).setForeground(Color.white);
	}}
	
	public static String getStudentNumber(String student_in_classroom_id) {
		 String number = null;
		 
		 try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * FROM students_in_classrooms "
						+ "WHERE sic_id = '"+student_in_classroom_id+"'");
				while(rs.next())
				{
					number = rs.getString("number");
		
		}} catch (SQLException e) {
			e.printStackTrace();
			
			}
		
	return number;
	}
	
	public static void loadCourses(String classroom_in_ay_id, String student_id) {

		App.panel_5.removeAll();

				Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
				
				for(int i = 0; i<lines.length;i++) {
				Cours c = new Cours(lines[i].toString(), classroom_in_ay_id, student_id);
				c.setName(lines[i].toString());
				App.panel_5.add(c);
				//number.setText(String.valueOf(panel_5.getComponentCount()));
				Cours.loaddata(c, lines[i].toString(), classroom_in_ay_id, student_id);
				
				App.panel_5.revalidate();
				App.panel_5.repaint();
				}
		}
}
