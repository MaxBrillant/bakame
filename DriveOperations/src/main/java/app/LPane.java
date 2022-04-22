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

public class LPane extends JPanel {
	public static JLabel Name;
	public static JButton add;
	public static JScrollPane scrollPane;
	public static JScrollPane scrollPane2;
	public static JPanel panel_3;
	public static JButton supprimer;
	public static JLabel no;
	public static JButton modifier;
	public static JLabel points;
	public static List note;
	public static JPanel panel;
	public static JLabel pourcent;
	public static JLabel prog;
	public static JLabel average;
	public static JLabel mention;
	public static JLabel echec;
	public static JComboBox comboBox;
	private JPanel panel_1;
	public static JPanel panel_2;
	public static JTabbedPane tabbedPane;
	private JPanel panel_4;

	/**
	 * Create the panel.
	 */
	public LPane(String course_id, String student_id, String classroom_id) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(300, 629));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_id, App.students.get(App.n), classroom_id);
			}
		});
		panel.setBackground(new Color(25, 25, 25));
		panel.setPreferredSize(new Dimension(10, (int) (screensize.getHeight()*82/100*20/100) ));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		echec = new JLabel("Echec:");
		echec.setForeground(new Color(211, 211, 211));
		echec.setFont(new Font("Roboto", Font.PLAIN, 14));
		echec.setBounds(10, 70, 177, 23);
		panel.add(echec);
		
		Name = new JLabel(TestBox.getFullName(course_id));
		Name.setForeground(Color.WHITE);
		Name.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Name.setBounds(10, 1, 280, 28);
		panel.add(Name);
		
		no = new JLabel("0 interros effectuees");
		no.setForeground(new Color(211, 211, 211));
		no.setFont(new Font("Roboto", Font.PLAIN, 14));
		no.setBounds(10, 25, 145, 23);
		panel.add(no);
		
		
		pourcent = new JLabel("Pourcentage: " );
		pourcent.setForeground(new Color(211, 211, 211));
		pourcent.setFont(new Font("Roboto", Font.PLAIN, 14));
		pourcent.setBounds(10, 40, 145, 23);
		panel.add(pourcent);
		
		prog = new JLabel("Progression: 0%");
		prog.setForeground(new Color(211, 211, 211));
		prog.setFont(new Font("Roboto", Font.PLAIN, 14));
		prog.setBounds(10, 55, 145, 23);
		panel.add(prog);
		
		add = new JButton("Ajouter");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				add.setBackground(new Color(64, 201, 135));
			}public void mouseExited(MouseEvent e) {
				add.setBackground(new Color(0, 171, 89));
			}
		});
		add.setBorder(null);
		add.setFocusPainted(false);
		add.setBackground(new Color(0, 171, 89));
		add.setForeground(new Color(255, 255, 255));
		add.setBounds(130, 3, 89, 30);
		//panel_1.add(add);
		add.setFont(new Font("Arial", Font.BOLD, 17));
		
		supprimer = new JButton("Supprimer");
		supprimer.setVisible(false);
		supprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				supprimer.setBackground(new Color(201, 64, 64));
			}public void mouseExited(MouseEvent e) {
				supprimer.setBackground(new Color(171, 0, 0));
			}
		});
		supprimer.setBorder(null);
		supprimer.setFocusPainted(false);
		supprimer.setBackground(new Color(171, 0, 0));
		supprimer.setForeground(new Color(255, 255, 255));
		supprimer.setBounds(229, 3, 108, 30);
		//panel_1.add(supprimer);
		supprimer.setFont(new Font("Arial", Font.BOLD, 17));
		
		modifier = new JButton("Modifier");
		modifier.setVisible(false);
		modifier.setBorder(null);
		modifier.setFocusPainted(false);
		modifier.setBackground(new Color(171, 145, 0));
		modifier.setForeground(new Color(255, 255, 255));
		modifier.setFont(new Font("Arial", Font.BOLD, 17));
		modifier.setBounds(347, 3, 100, 30);
		//panel_1.add(modifier);
		
		points = new JLabel("0/10");
		points.setForeground(new Color(255, 33, 94));
		points.setHorizontalAlignment(SwingConstants.TRAILING);
		points.setFont(new Font("Segoe UI", Font.BOLD, 18));
		points.setBounds(132, 49, 105, 28);
		panel.add(points);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 95, 158, 23);
		panel.add(panel_4);
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
		comboBox.setSelectedItem(Integer.valueOf((int) Double.parseDouble(ExamInfo.loadCourseMaxima(course_id, classroom_id, Login.selectedAcademicYearID))));
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
		
		mention = new JLabel("Tres bien");
		mention.setHorizontalAlignment(SwingConstants.TRAILING);
		mention.setForeground(new Color(255, 33, 94));
		mention.setFont(new Font("Roboto", Font.PLAIN, 14));
		mention.setBounds(132, 70, 105, 23);
		panel.add(mention);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		add(tabbedPane, BorderLayout.CENTER);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tabbedPane.addTab("Interrogations", null, scrollPane, null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_id, App.students.get(App.n), classroom_id);
			}
		});
		panel_3.setBackground(new Color(25, 25, 25));
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new WrapLayout(WrapLayout.CENTER,10,3));
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(null);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Examens", null, scrollPane2, null);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_id, App.students.get(App.n), classroom_id);
			}
		});
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(25, 25, 25));
		scrollPane2.setViewportView(panel_2);
		panel_2.setLayout(new WrapLayout(1, 10, 3));
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Test.deselect(course_id, App.students.get(App.n), classroom_id);
			}
		});
		loadAllTests(course_id, student_id, classroom_id);
		loadAllExams(course_id, student_id, classroom_id);
	}
	
	public static void loadAllTests(String course_id, String student_id, String classroom_id) {
		LPane.panel_3.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadTests(course_id, student_id, classroom_id, Home.terms.get(i));
		}
		LPane.panel_3.revalidate();
		LPane.panel_3.repaint();
	}
	
	public static void loadAllExams(String course_id, String student_id, String classroom_id) {
		LPane.panel_2.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadExams(course_id, student_id, classroom_id, Home.terms.get(i));
		}
		LPane.panel_2.revalidate();
		LPane.panel_2.repaint();
	}
	
	public static void loadTests(String course_id, String student_id, String classroom_id, String term_id) {
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 18));
		LPane.panel_3.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(300, 30));
		
	boolean hasTests = false;
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN course_tests AS ct "
					+ "WHERE ti.test_id = ct.test_id AND ti.is_active = 1 AND ti.classroom_id = '"+classroom_id+"' AND ti.term_id = '"+term_id+"' AND ct.course_id = '"+course_id+"'");
			
		
		while(rs.next())
		{
			hasTests = true;
				String n = loadStudentNote(rs.getString("ti.test_id"), student_id);
			List note = Arrays.asList(n.split("/"));
			String s = (String) note.get(1);
			String g = (String) note.get(0);
			
			Test t = new Test(course_id, student_id, classroom_id, term_id);
			t.setName(rs.getString("ti.test_id"));
			t.progress.setString(g+"/"+ s);
			LPane.panel_3.add(t);

			t.getComponent(t.getComponentCount()-1).setVisible(false);
			t.progression.setText(Math.round(Double.parseDouble(Test.getTestProgression(rs.getString("ti.test_id"), student_id)))+"%");
			t.percent.setText(Math.round(Double.parseDouble(Test.getTestPercent(rs.getString("ti.test_id"), student_id)))+"%");
			t.number.setText(rs.getString("ti.test_name"));
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
				lblNdashimyeMaxBrillant1.setFont(new Font("Roboto", Font.PLAIN, 18));
				LPane.panel_3.add(lblNdashimyeMaxBrillant1);
				lblNdashimyeMaxBrillant1.setPreferredSize(new Dimension(300, 30));
		}
		Test.deselect(course_id, App.students.get(App.n), classroom_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}
	public static String loadStudentNote(String test_id, String student_id) {
		
		String note = "0/0";
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN students_grades_tests AS sgt "
					+ "WHERE ti.test_id = '"+test_id+"' AND sgt.student_id = '"+student_id+"' AND ti.test_id = sgt.test_id AND ti.is_active = 1");
		
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
	
	
	
	
public static void loadExams(String course_id, String student_id, String classroom_id, String term_id) {
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 18));
		LPane.panel_2.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(300, 30));
		
		boolean hasTests = false;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information AS ei "
					+ "JOIN course_exams AS ce "
					+ "JOIN series AS s "
					+ "WHERE ei.exam_id = ce.exam_id AND ei.is_active = 1 AND ei.classroom_id = '"+classroom_id+"' AND ei.term_id = '"+term_id+"' AND ce.course_id = '"+course_id+"' "
							+ "AND ei.exam_id = s.exam_id");
			
		
		while(rs.next())
		{

			String n = loadStudentSerieNote(rs.getString("s.serie_id"), student_id);
		List note = Arrays.asList(n.split("/"));
		String s = (String) note.get(1);
		String g = (String) note.get(0);
		
						Exam t = new Exam(course_id, student_id, classroom_id, term_id);
						t.setName(rs.getString("s.serie_id"));
						
						t.progress.setString(g+"/"+ s);
						
						//t.getComponent(4).setVisible(false);
						int i = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""));
						LPane.panel_2.add(t, i);
						
						if(t.progress.getString().equals("0/0")) {
							t.setBackground(LPane.panel_3.getBackground());
							t.setBorder(new LineBorder(Color.white, 2));
							for(int j = 0;j<3;j++) {
								t.getComponent(j).setVisible(false);
							}
							//t.getComponent(4).setVisible(true);
							t.number.setVisible(true);
						}
						else {
						t.progress.setValue((int) (100*Double.parseDouble(g)/Double.parseDouble(s)));
						if(100*Double.parseDouble(g)/Double.parseDouble(s)<50) {
							t.progress.setForeground(new Color(255, 33, 94));
							Exam.color();
						}else {
							t.progress.setForeground(new Color(0, 168, 96));
							Exam.color();
						}
						}
						

						//LPane.percent();
					
						//LPane.ranking();
						//LPane.progression();

						LPane.scrollPane2.revalidate();
						LPane.scrollPane2.repaint();
						LPane.panel_2.revalidate();
						LPane.panel_2.repaint();
						
						//Exam.deselect();
						
						
						 SwingUtilities.invokeLater(() -> {
					            JScrollBar bar = LPane.scrollPane2.getVerticalScrollBar();
					            bar.setValue(bar.getMaximum());
					    });

						LPane.panel_2.revalidate();
						LPane.panel_2.repaint();
					}

		if(!hasTests) {
				JLabel lblNdashimyeMaxBrillant1 = new JLabel("Aucune serie effectuee.");
				lblNdashimyeMaxBrillant1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNdashimyeMaxBrillant1.setForeground(new Color(255, 255, 255).darker());
				lblNdashimyeMaxBrillant1.setFont(new Font("Roboto", Font.PLAIN, 18));
				LPane.panel_2.add(lblNdashimyeMaxBrillant1);
				lblNdashimyeMaxBrillant1.setPreferredSize(new Dimension(300, 30));
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//ExamBox.loadExams();
	}
	
public static String loadStudentSerieNote(String serie_id, String student_id) {
		
		String note = "0/0";
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from series AS s "
					+ "JOIN exam_information AS ei "
					+ "JOIN students_grades_exams AS sge "
					+ "WHERE ei.exam_id = s.exam_id AND s.serie_id = '"+serie_id+"' AND sgt.student_id = '"+student_id+" AND s.serie_id = sge.serie_id AND ei.is_active = 1");
		
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
