package app;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

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
import Class.TestBox;
import Class.TestInfo;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.StudentStats;
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

	/**
	 * Create the panel.
	 */
	public LPane(String course_id, String student_id, String classroom_id) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int) screensize.getWidth()*33/100,(int) (screensize.getHeight()*82/100)));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test.deselect(course_id, student_id, classroom_id);
			}
		});
		panel.setBackground(new Color(25, 25, 25));
		panel.setPreferredSize(new Dimension(10, (int) (screensize.getHeight()*82/100*20/100) ));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		echec = new JLabel("Echec:");
		echec.setForeground(new Color(245, 255, 250));
		echec.setFont(new Font("Roboto", Font.PLAIN, 18));
		echec.setBounds(10, 98, 218, 23);
		panel.add(echec);
		
		Name = new JLabel(TestBox.getFullName(course_id));
		Name.setForeground(Color.WHITE);
		Name.setFont(new Font("Futura Hv BT", Font.BOLD, 25));
		Name.setBounds(10, 1, 440, 32);
		panel.add(Name);
		
		no = new JLabel("0 interrogations effectuees");
		no.setForeground(new Color(245, 255, 250));
		no.setFont(new Font("Arial", Font.BOLD, 20));
		no.setBounds(10, 33, 308, 23);
		panel.add(no);
		
		
		pourcent = new JLabel("Pourcentage: " );
		pourcent.setForeground(new Color(255, 255, 255));
		pourcent.setFont(new Font("Arial", Font.BOLD, 20));
		pourcent.setBounds(10, 54, 218, 23);
		panel.add(pourcent);
		
		prog = new JLabel("Progression: 0%");
		prog.setForeground(new Color(245, 255, 250));
		prog.setFont(new Font("Roboto", Font.PLAIN, 18));
		prog.setBounds(10, 76, 177, 23);
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
		points.setFont(new Font("Futura Bk BT", Font.PLAIN, 35));
		points.setBounds(252, 30, 177, 44);
		panel.add(points);
		
		
		average = new JLabel("Moyenne:");
		average.setHorizontalAlignment(SwingConstants.TRAILING);
		average.setVisible(false);
		average.setForeground(new Color(245, 255, 250));
		average.setFont(new Font("Arial", Font.PLAIN, 18));
		average.setBounds(238, 98, 145, 23);
		panel.add(average);
		
		mention = new JLabel("Tres bien");
		mention.setHorizontalAlignment(SwingConstants.TRAILING);
		mention.setForeground(new Color(255, 33, 94));
		mention.setFont(new Font("Arial", Font.PLAIN, 20));
		mention.setBounds(297, 70, 132, 23);
		panel.add(mention);
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		comboBox.setVisible(false);
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
		comboBox.setFont(new Font("Arial", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "40", "80"}));
		comboBox.setBounds(385, 98, 53, 22);
		panel.add(comboBox);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 18));
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
				Test.deselect(course_id, student_id, classroom_id);
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
				Test.deselect(course_id, student_id, classroom_id);
			}
		});
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(25, 25, 25));
		scrollPane2.setViewportView(panel_2);
		panel_2.setLayout(new WrapLayout(1, 10, 3));
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Test.deselect(course_id, student_id, classroom_id);
			}
		});
		loadAllTests(course_id, student_id, classroom_id);
	}
	
	public static void loadAllTests(String course_id, String student_id, String classroom_id) {
		LPane.panel_3.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadTests(course_id, student_id, classroom_id, Home.terms.get(i));
		}
		LPane.panel_3.revalidate();
		LPane.panel_3.repaint();
	}
	
	public static void loadTests(String course_id, String student_id, String classroom_id, String term_id) {
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(term_id);
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNdashimyeMaxBrillant.setBounds(92, 0, 391, 40);
		LPane.panel_3.add(lblNdashimyeMaxBrillant);
		
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
				JLabel lblNdashimyeMaxBrillant1 = new JLabel("            Aucune interrogation effectuee.               ");
				lblNdashimyeMaxBrillant1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNdashimyeMaxBrillant1.setForeground(new Color(255, 255, 255).darker());
				lblNdashimyeMaxBrillant1.setFont(new Font("Roboto", Font.PLAIN, 18));
				lblNdashimyeMaxBrillant1.setBounds(92, 0, 391, 40);
				LPane.panel_3.add(lblNdashimyeMaxBrillant1);
		}
		Test.deselect(course_id, student_id, classroom_id);
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
					+ "WHERE ti.test_id = '"+test_id+" AND ti.test_id = sgt.test_id AND ti.is_active = 1");
		
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
	
	
public static String loadStudentSerieNote(String serie_id, String student_id) {
		
		String note = "0/0";
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from series AS s "
					+ "JOIN exam_information AS ei "
					+ "JOIN students_grades_exams AS sge "
					+ "WHERE ei.exam_id = s.exam_id AND s.serie_id = '"+serie_id+" AND s.serie_id = sge.serie_id AND ei.is_active = 1");
		
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
