package app;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Container;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.CustomVerticalScrollBarUI;
import Class.ExamBox;
import Class.ExamInfo;
import Class.TestBox;
import Class.TestInfo;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.sql.*; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.awt.Cursor;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.FlowLayout;

public class LPane extends JPanel {
	public static JLabel Name;
	public static JPanel panel_3;
	public static JLabel no;
	public static JLabel points;
	public static List note;
	public static JLabel pourcent;
	public static JLabel prog;
	public static JLabel average;
	public static JLabel mention;
	public static JLabel echec;
	public static JComboBox comboBox;
	public static JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	public static int selectedTab;
	private static JScrollPane scrollPane;
	private static JScrollPane scrollPane2;
	private static JPanel panel_1;
	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public LPane(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id) {
		setPreferredSize(new Dimension(350, 629));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		//panel.setPreferredSize(new Dimension(10, (int) (screensize.getHeight()*82/100*20/100) ));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2;
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(10, 130));
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
			}
		});
		panel2.setBackground(panel.getBackground());
		panel.add(panel2, BorderLayout.NORTH);
		panel2.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel2.add(panel_6);
		panel_6.setBackground(panel_6.getParent().getBackground());
		panel_6.setLayout(null);
		
		echec = new JLabel("Echec:");
		echec.setBounds(10, 2, 210, 17);
		panel_6.add(echec);
		echec.setForeground(new Color(211, 211, 211));
		echec.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		no = new JLabel("0 interros effectuees");
		no.setBounds(10, 22, 210, 17);
		panel_6.add(no);
		no.setForeground(new Color(211, 211, 211));
		no.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		
		pourcent = new JLabel("Pourcentage: " );
		pourcent.setBounds(10, 42, 210, 17);
		panel_6.add(pourcent);
		pourcent.setForeground(new Color(211, 211, 211));
		pourcent.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		prog = new JLabel("Progression: 0%");
		prog.setBounds(10, 62, 210, 17);
		panel_6.add(prog);
		prog.setForeground(new Color(211, 211, 211));
		prog.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 82, 170, 20);
		panel_4.setPreferredSize(new Dimension(170, 20));
		panel_6.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBackground(panel_4.getParent().getBackground());
		
		
		average = new JLabel("Moyenne:");
		panel_4.add(average, BorderLayout.WEST);
		average.setHorizontalAlignment(SwingConstants.TRAILING);
		average.setVisible(false);
		average.setForeground(new Color(245, 255, 250));
		average.setFont(new Font("Roboto", Font.BOLD, 14));
		comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(10, 22));
		comboBox.setMaximumSize(new Dimension(40, 32767));
		panel_4.add(comboBox, BorderLayout.CENTER);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		comboBox.setVisible(false);
		comboBox.setSelectedItem(Integer.valueOf((int) Double.parseDouble(ExamInfo.loadCourseMaxima(course_in_classroom_id))));
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				average();
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!comboBox.getSelectedItem().toString().isBlank()) {
				average();
			}}
		});
		comboBox.setEditable(true);
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "40", "80"}));
		
		Name = new JLabel("   "+TestBox.getFullName(course_in_classroom_id));
		Name.setPreferredSize(new Dimension(55, 20));
		Name.setForeground(Color.WHITE);
		Name.setFont(new Font("Roboto", Font.BOLD, 16));
		panel2.add(Name, BorderLayout.NORTH);
		
		
		panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(170, 10));
		panel2.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		//panel_1.add(modifier);
		panel_5.setBackground(panel_5.getParent().getBackground());
		
		points = new JLabel("1200.39/3000");
		panel_5.add(points);
		points.setForeground(new Color(255, 33, 94));
		points.setHorizontalAlignment(SwingConstants.TRAILING);
		points.setFont(new Font("Roboto", Font.BOLD, 25));
		
		mention = new JLabel("Tres bien");
		panel_5.add(mention);
		mention.setHorizontalAlignment(SwingConstants.TRAILING);
		mention.setForeground(new Color(255, 33, 94));
		mention.setFont(new Font("Roboto", Font.PLAIN, 14));

		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		panel.add(scrollPane, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
			}
		});
		panel_3.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new WrapLayout(WrapLayout.CENTER,3,3));
		
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(null);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Exam.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
			}
		});
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(40, 40, 40));
		scrollPane2.setViewportView(panel_2);
		panel_2.setLayout(new WrapLayout(1, 10, 3));
		
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 37));
		panel_1.setBackground(new Color(40, 40, 40));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		
		JButton btnNewButton1 = new JButton("Interrogations");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToTestView(Cours.selectedCourses.get(0).getName(), classroom_in_ay_id);
			}
		});
		btnNewButton1.setMultiClickThreshhold(1000L);
		btnNewButton1.setFocusPainted(false);
		btnNewButton1.setPreferredSize(new Dimension(130, 37));
		btnNewButton1.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(20, 148, 198)));
		btnNewButton1.setIconTextGap(10);
		btnNewButton1.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewButton1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton1.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton1.setBackground(new Color(60, 60, 60));
		btnNewButton1.setForeground(new Color(255, 255, 255));
		panel_1.add(btnNewButton1);

		
		JButton btnExamens = new JButton("Examens");
		btnExamens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setToExamView(Cours.selectedCourses.get(0).getName(), classroom_in_ay_id);
			}
		});
		btnExamens.setMultiClickThreshhold(1000L);
		btnExamens.setPreferredSize(new Dimension(130, 37));
		btnExamens.setBorder(null);
		//button.setBorderPainted(true);
		btnExamens.setIconTextGap(10);
		btnExamens.setVerticalTextPosition(SwingConstants.CENTER);
		btnExamens.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnExamens.setForeground(Color.LIGHT_GRAY);
		btnExamens.setFont(new Font("Roboto", Font.BOLD, 14));
		btnExamens.setFocusPainted(false);
		btnExamens.setBackground(new Color(40, 40, 40));
		panel_1.add(btnExamens);
		
		for(int i = 0; i< (panel_1).getComponentCount();i++) {
			int k = i;
			Color c = (panel_1).getComponent(k).getBackground();
			(panel_1).getComponent(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(k != selectedTab) {
					(panel_1).getComponent(k).setBackground(new Color(60, 60, 60));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(k != selectedTab) {
					(panel_1).getComponent(k).setBackground((panel_1).getComponent(k).getParent().getBackground());
			}}
			});
		}
		
		
		
		for(int i = 0; i< panel_1.getComponentCount(); i++) {
			//panel_1.getComponent(i).setPreferredSize(new Dimension(100, 50));
			panel_1.getComponent(i).setBackground(new Color(40, 40, 40));
			panel_1.getComponent(i).setForeground(Color.LIGHT_GRAY);
			((JComponent) panel_1.getComponent(i)).setBorder(null);
			((AbstractButton) panel_1.getComponent(i)).setIcon(null);
		}
		//btnNewButton1.setPreferredSize(new Dimension(150, 50));
		btnNewButton1.setForeground(Color.white);
		btnNewButton1.setBackground(new Color(60, 60, 60));
		btnNewButton1.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(20, 148, 198)));
		
		loadAllTests(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id);
		loadAllExams(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id);
		

		if(LPane.selectedTab==0) {
			LPane.setToTestView(course_in_classroom_id, classroom_in_ay_id);
		}else {
			LPane.setToExamView(course_in_classroom_id, classroom_in_ay_id);
			}
	}
	
	public static void setToTestView(String course_in_classroom_id, String classroom_in_ay_id) {
	
	selectedTab = 0;
	panel.remove(1);
	panel.add(scrollPane, BorderLayout.CENTER);
	for(int i = 0; i< panel_1.getComponentCount(); i++) {
		//panel_1.getComponent(i).setPreferredSize(new Dimension(100, 50));
		panel_1.getComponent(i).setBackground(new Color(40, 40, 40));
		panel_1.getComponent(i).setForeground(Color.LIGHT_GRAY);
		((JComponent) panel_1.getComponent(i)).setBorder(null);
		((AbstractButton) panel_1.getComponent(i)).setIcon(null);
	}
//	btnNewButton1.setPreferredSize(new Dimension(150, 50));
	panel_1.getComponent(0).setForeground(Color.white);
	panel_1.getComponent(0).setBackground(new Color(60, 60, 60));
	((JComponent) panel_1.getComponent(0)).setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(20, 148, 198)));
	Test.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
	panel.revalidate();
	panel.repaint();
	
	}
	
	public static void setToExamView(String course_in_classroom_id, String classroom_in_ay_id) {
		
		selectedTab = 1;
		panel.remove(1);
		panel.add(scrollPane2, BorderLayout.CENTER);
		for(int i = 0; i< panel_1.getComponentCount(); i++) {
			//panel_1.getComponent(i).setPreferredSize(new Dimension(100, 50));
			panel_1.getComponent(i).setBackground(new Color(40, 40, 40));
			panel_1.getComponent(i).setForeground(Color.LIGHT_GRAY);
			((JComponent) panel_1.getComponent(i)).setBorder(null);
			((AbstractButton) panel_1.getComponent(i)).setIcon(null);
		}
//		btnNewButton1.setPreferredSize(new Dimension(150, 50));
		panel_1.getComponent(1).setForeground(Color.white);
		panel_1.getComponent(1).setBackground(new Color(60, 60, 60));
		((JComponent) panel_1.getComponent(1)).setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(20, 148, 198)));
		Exam.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
		panel.revalidate();
		panel.repaint();
		
		}

	public static void loadAllTests(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id) {
		LPane.panel_3.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadTests(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id, Home.terms.get(i));
		}
		LPane.panel_3.revalidate();
		LPane.panel_3.repaint();
	}
	
	public static void loadAllExams(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id) {
		LPane.panel_2.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadExams(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id, Home.terms.get(i));
		}
		LPane.panel_2.revalidate();
		LPane.panel_2.repaint();
	}
	
	public static void loadTests(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id, String term_id) {
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 14));
		LPane.panel_3.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(280, 30));
		
	boolean hasTests = false;
	int i = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN course_tests AS ct "
					+ "WHERE ti.test_id = ct.test_id AND ti.is_active = 1 AND ti.cia_id = '"+classroom_in_ay_id+"' AND ti.term_id = '"+term_id+"' AND ct.courses_in_classroom_id = '"+course_in_classroom_id+"'");
			
		
		while(rs.next())
		{
			i++;
			hasTests = true;
				String n = loadStudentNote(rs.getString("ti.test_id"), student_in_classroom_id);
			List note = Arrays.asList(n.split("/"));
			String s = (String) note.get(1);
			String g = (String) note.get(0);
			
			Test t = new Test(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id, term_id);
			t.setName(rs.getString("ti.test_id"));
			t.progress.setString(g+"/"+ s);
			LPane.panel_3.add(t);

			t.getComponent(t.getComponentCount()-1).setVisible(false);
			t.percent.setText(Math.round(Double.parseDouble(Test.getTestPercent(n)))+"%");
			t.number.setText(i+"");
			
			String prog = Test.getTestProgression(rs.getString("ti.test_id"), student_in_classroom_id);
			if(prog.contains("-")) {
			t.progression.setText(Math.round(Double.parseDouble(prog))+"%");
			t.progression.setForeground(new Color(255,221,221));
			}else {
				t.progression.setText("+"+Math.round(Double.parseDouble(prog))+"%");
				t.progression.setForeground(new Color(201,255,226));
				}
			
			LPane.panel_3.revalidate();
			LPane.panel_3.repaint();

			if(!n.equals("0/0")) {
			t.progress.setValue((int) (100*Double.parseDouble(g)/Double.parseDouble(s)));
			if(100*Double.parseDouble(g)/Double.parseDouble(s)<50) {
				t.progress.setForeground(new Color(247, 101, 141));
				Test.color(t);
			}else {
				t.progress.setForeground(new Color(0, 168, 96));
				Test.color(t);
			}
				}else {
					t.progress.setVisible(false);
					t.percent.setVisible(false);
					t.progress.setVisible(false);
					t.progression.setVisible(false);
					t.getComponent(t.getComponentCount()-1).setVisible(true);

					t.setBackground(LPane.panel_3.getBackground());
					t.setBorder(new LineBorder(Color.white, 2));
					t.getComponent(1).setForeground(Color.white);
					t.getComponent(4).setForeground(Color.white);
				}
		}
		if(!hasTests) {
				JLabel lblNdashimyeMaxBrillant1 = new JLabel("Aucune interrogation effectuee.");
				lblNdashimyeMaxBrillant1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNdashimyeMaxBrillant1.setForeground(new Color(255, 255, 255).darker());
				lblNdashimyeMaxBrillant1.setFont(new Font("Roboto", Font.PLAIN, 14));
				LPane.panel_3.add(lblNdashimyeMaxBrillant1);
				lblNdashimyeMaxBrillant1.setPreferredSize(new Dimension(280, 30));
		}
		Test.deselect(course_in_classroom_id, App.students.get(App.n), classroom_in_ay_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}
	public static String loadStudentNote(String test_id, String student_in_classroom_id) {
		
		String note = "0/0";
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN students_grades_tests AS sgt "
					+ "WHERE ti.test_id = '"+test_id+"' AND sgt.sic_id = '"+student_in_classroom_id+"' AND ti.test_id = sgt.test_id AND ti.is_active = 1");
		
		while(rs.next())
		{
			if(rs.getString("sgt.points").equals(null)) {
				note = "0/0";
			}else {
			note = rs.getString("sgt.points")+"/"+rs.getString("ti.maxima");
		}}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
				return note;
	}
	
	
	
	
public static void loadExams(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id, String term_id) {
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 14));
		LPane.panel_2.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(280, 30));
		
		boolean hasTests = false;
		int i = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information AS ei "
					+ "JOIN course_exams AS ce "
					+ "JOIN series AS s "
					+ "WHERE ei.exam_id = ce.exam_id AND ei.is_active = 1 AND ei.cia_id = '"+classroom_in_ay_id+"' AND ei.term_id = '"+term_id+"' AND ce.courses_in_classroom_id = '"+course_in_classroom_id+"' "
							+ "AND ei.exam_id = s.exam_id");
			
		
		while(rs.next())
		{
			hasTests = true;
			i++;
			String n = loadStudentSerieNote(rs.getString("s.serie_id"), student_in_classroom_id);
		List note = Arrays.asList(n.split("/"));
		String s = (String) note.get(1);
		String g = (String) note.get(0);
		
		Exam e = new Exam(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id, term_id);
		e.setName(rs.getString("s.serie_id"));
		e.progress.setString(g+"/"+ s);
		LPane.panel_2.add(e);

		e.getComponent(e.getComponentCount()-1).setVisible(false);
		e.number.setText(i+"");
		LPane.panel_2.revalidate();
		LPane.panel_2.repaint();

		if(!n.equals("0/0")) {
		e.progress.setValue((int) (100*Double.parseDouble(g)/Double.parseDouble(s)));
		if(100*Double.parseDouble(g)/Double.parseDouble(s)<50) {
			e.progress.setForeground(new Color(247, 101, 141));
			Test.color(e);
		}else {
			e.progress.setForeground(new Color(0, 168, 96));
			Test.color(e);
		}
			}else {
				e.progress.setVisible(false);
				//t.percent.setVisible(false);
				e.progress.setVisible(false);
				//t.progression.setVisible(false);
				e.getComponent(e.getComponentCount()-1).setVisible(true);

				e.setBackground(LPane.panel_2.getBackground());
				e.setBorder(new LineBorder(Color.white, 2));
				e.getComponent(1).setForeground(Color.white);
				e.getComponent(2).setForeground(Color.white);
			}
					}

		if(!hasTests) {
				JLabel lblNdashimyeMaxBrillant1 = new JLabel("Aucune serie effectuee.");
				lblNdashimyeMaxBrillant1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNdashimyeMaxBrillant1.setForeground(new Color(255, 255, 255).darker());
				lblNdashimyeMaxBrillant1.setFont(new Font("Roboto", Font.PLAIN, 14));
				LPane.panel_2.add(lblNdashimyeMaxBrillant1);
				lblNdashimyeMaxBrillant1.setPreferredSize(new Dimension(280, 30));
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//ExamBox.loadExams();
	}
	
public static String loadStudentSerieNote(String serie_id, String student_in_classroom_id) {
		
		String note = "0/0";
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * FROM series AS s "
					+ "JOIN exam_information AS ei "
					+ "JOIN students_grades_exams AS sge "
					+ "WHERE ei.exam_id = s.exam_id AND s.serie_id = '"+serie_id+"' AND sge.sic_id = '"+student_in_classroom_id+"' AND s.serie_id = sge.serie_id AND ei.is_active = 1");
		
		while(rs.next())
		{
			if(rs.getString("sge.points").equals(null)) {
				note = "0/0";
			}else {
			note = rs.getString("sge.points")+"/"+rs.getString("s.maxima");
		}}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
				return note;
	}

	public static void average() {
		
			String str = points.getText().replaceAll("[^0.00-9.00]+", " ");
			note = Arrays.asList(str.trim().split(" "));
			Double i =   Double.parseDouble((String) note.get(0))/Double.parseDouble((String) note.get(1))*Double.parseDouble(comboBox.getSelectedItem().toString());
			
			average.setText("Moyenne: "+new DecimalFormat("##.##").format(i)+"/");
	}
	
	
public static void mention() {

		
		String str = points.getText().replaceAll("[^0.00-9.00]+", " ");
		note = Arrays.asList(str.trim().split(" "));
		Double i =   Double.parseDouble((String) note.get(0))/Double.parseDouble((String) note.get(1))*100;
		//This is to get the grade and the maximum independently

		if(i < 50) {
			mention.setText("A ameliorer!");
		}else if(i >= 50 && i < 70) {
			mention.setText("Acceptable!");
		}else if(i >= 70 && i < 90) {
			mention.setText("Bien!");
		}else if(i >= 90 && i < 100) {
			mention.setText("Tres Bien!");
		}else if(i == 100) {
			mention.setText("Excellent!");
		}
		
		
		
	}
}
