package app;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.metal.MetalProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.ExamInfo;
import Class.TestBox;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import accounts.Users;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Test extends JPanel {
	public static JLabel number;
	public static JProgressBar progress;
	public static JLabel progression;
	public static JLabel percent;

	public static int selected = 0;
	public static boolean isSelected;
	public static List<Component> selectedTests = new ArrayList();

	/**
	 * Create the panel.
	 */
	public Test(String course_id, String student_id, String classroom_id, String term_id) {
		setBackground(new Color(80, 80, 80));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(280, 35));
		setLayout(null);
		
		progress = new JProgressBar();
		progress.setBorder(new LineBorder(new Color(255, 255, 255)));
		progress.setBounds(42, 5, 148, 25);
		progress.setBackground(LPane.panel_3.getBackground());
		UIManager.put("progress.selectionBackground", Color.black);
		progress.setStringPainted(true);
		progress.setForeground(new Color(46, 139, 87));
		progress.setValue(58);
		progress.setFont(new Font("Roboto", Font.PLAIN, 14));
		progress.setString("58/100");
		
		
		//Color color ;
		//NewTest nt = new NewTest();
		//if(nt.isVisible()) {
		//if(100*Double.parseDouble(NewTest.PO.getText().replace(",", "."))/Double.parseDouble(NewTest.TP.getSelectedItem().toString().replace(",", "."))>=50) {
			//color = new Color(0, 168, 96);
		//}else {
			//color = new Color(255, 33, 94);
		//}
		
		//progress.setUI(new BasicProgressBarUI() {
			//protected Color getSelectionBackground() { return color;}
			//protected Color getSelectionForeground() { return Color.white;}
		//});
		//}
		
		add(progress);
		
		
		
		
		number = new JLabel();
		number.setForeground(Color.WHITE);
		number.setText("22");
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setFont(new Font("Roboto", Font.PLAIN, 12));
		number.setBounds(0, 2, 37, 30);
		add(number);
		
		percent = new JLabel("100%");
		percent.setHorizontalAlignment(SwingConstants.CENTER);
		percent.setForeground(Color.WHITE);
		percent.setFont(new Font("Roboto", Font.PLAIN, 12));
		percent.setBounds(190, 2, 48, 30);
		add(percent);
		
		progression = new JLabel("-100%");
		progression.setForeground(Color.WHITE);
		progression.setHorizontalAlignment(SwingConstants.CENTER);
		progression.setFont(new Font("Roboto", Font.PLAIN, 12));
		progression.setBounds(232, 2, 48, 30);
		add(progression);
		
		JLabel pasfait = new JLabel("N'as pas fait l'interrogation");
		pasfait.setIconTextGap(15);
		pasfait.setIcon(ResizeImages.resize(46, 26, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\missing.png"));
		pasfait.setHorizontalTextPosition(SwingConstants.RIGHT);
		pasfait.setForeground(Color.WHITE);
		pasfait.setHorizontalAlignment(SwingConstants.CENTER);
		pasfait.setFont(new Font("Roboto", Font.BOLD, 14));
		pasfait.setBounds(10, 2, 270, 33);
		add(pasfait);
		

		
		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				
				

				
				boolean alreadyExists = false;

					if(selectedTests.contains(getComponent(0).getParent())) {
					alreadyExists = true;
					}
					Test.deselect(course_id, student_id, classroom_id);
					selectedTests.clear();
				selectedTests.add(getComponent(0).getParent());
				
				
					for(int j = 0; j< LPane.panel_3.getComponentCount(); j++) {
						if(LPane.panel_3.getComponent(j).equals(selectedTests.get(0))) {
							LPane.panel_3.getComponent(j).setBackground(new Color(20, 148, 198));
							((Container) LPane.panel_3.getComponent(j)).getComponent(1).setForeground(Color.WHITE);
							((Container) LPane.panel_3.getComponent(j)).getComponent(2).setForeground(Color.WHITE);
							((Container) LPane.panel_3.getComponent(j)).getComponent(3).setForeground(Color.WHITE);
							}}
					showTestData(getName(), student_id);
			//
		
				

				//setBorder(new LineBorder(Color.white, 2));

				isSelected = true;
				
				if(e.getClickCount()==2){
					
					List note1 = Arrays.asList(LPane.loadStudentNote(getName(), student_id).trim().split("/"));
					
					NewTest c = new NewTest(getName());
					c.setVisible(true);
					NewTest.update.setVisible(true);
					NewTest.create.setVisible(false);
					NewTest.PO.setText((String) note1.get(0));
					NewTest.interro.setText(getTestName(getName()));
					
					NewTest.TP.setText(getTestMaxima(getName()));
				}

		}
			public void mouseEntered(MouseEvent e) {

				if(!selectedTests.contains(getComponent(0).getParent())) {
					setBorder(null);
					setBackground(new Color(120, 120, 120));
					setForeground(Color.white);
					if(!getComponent(0).isVisible()) {
						getComponent(1).setForeground(new Color(255, 102, 102).brighter());
						getComponent(4).setForeground(new Color(255, 102, 102).brighter());
						
					}
				}
			}public void mouseExited(MouseEvent e) {
				

				if(!selectedTests.contains(getComponent(0).getParent())) {if(!getComponent(0).isVisible()) {
					setBackground(LPane.panel_3.getBackground());
					setBorder(new LineBorder(Color.white, 2));
					getComponent(1).setForeground(Color.white);
					getComponent(4).setForeground(Color.white);
				}else {
			setBackground(new Color(80, 80, 80));
			setBorder(null);
				}}
			}
		});

	}
	
	public static void showTestData(String test_id, String student_id) {

		String note = LPane.loadStudentNote(test_id, student_id);
		String percent = Test.getTestPercent(test_id, student_id);
		LPane.points.setText(note);
		LPane.prog.setText("Progression: "+Test.getTestProgression(test_id, student_id)+"%");
		LPane.pourcent.setText("Pourcentage: "+percent+"%");
		List l = Arrays.asList(note.split("/"));
		if(Double.parseDouble(percent)>=50) {
		LPane.echec.setText("Augmentation: "+new DecimalFormat("##.##").format((Double.parseDouble(l.get(0).toString())-(Double.parseDouble(l.get(1).toString())/2)))+" points");
		}else {
			LPane.echec.setText("Echec: "+new DecimalFormat("##.##").format((Double.parseDouble(l.get(1).toString())/2)-Double.parseDouble(l.get(0).toString()))+" points");
		}
		
		LPane.points.setForeground(new Color(255, 33, 94));
		LPane.mention.setForeground(new Color(255, 33, 94));
		LPane.mention();
		
		LPane.average.setVisible(false);
		LPane.comboBox.setVisible(false);
		LPane.no.setText(getTestName(test_id));
		
		
		LPane.panel_3.revalidate();
		LPane.panel_3.repaint();
	}

	public static String getTestProgression(String test_id, String student_id) {
		String progress;
		if(hasPreviousTests(test_id, getTestCourse(test_id), getTestClassroom(test_id), getTestTerm(test_id))) {
			String previousNote = LPane.loadStudentNote(getPreviousTest(test_id, getTestCourse(test_id), getTestClassroom(test_id), getTestTerm(test_id)), student_id);
			String note = LPane.loadStudentNote(test_id, student_id);
			if(!previousNote.equals("0/0") || !note.equals("0/0")) {
			
			List l = Arrays.asList(previousNote.split("/"));
			List l1 = Arrays.asList(note.split("/"));
			
			Double percent1 = (100*Double.parseDouble(l1.get(0).toString()))/Double.parseDouble(l1.get(1).toString());
			Double percent2 = (100*Double.parseDouble(l.get(0).toString()))/Double.parseDouble(l.get(1).toString());
			
			progress = new DecimalFormat("##.##").format((percent1-percent2));
			}else {
				progress = "0";
			}
		}else {
			progress = "0";
		}
		return progress.replaceAll(",", ".");
	}
	
	
	public static String getTestCourseProgression(String test_id, String ay_id) {
		double progress = 0;
		String classroom_id = Test.getTestClassroom(test_id);
		Object[] lines = Home.loadActiveStudents(classroom_id, ay_id);
		for(int i = 0; i< lines.length; i++) {
			double studentProgress = Double.parseDouble(Test.getTestProgression(test_id, lines[i].toString()));
			progress = progress+ studentProgress;
		}
		return new DecimalFormat("##.##").format(progress);
	}
	
	
	public static String getPreviousTest(String test_id, String course_id, String classroom_id, String term_id) {
	 
		String previousTestId = null;
		List<String> listOfTests = new ArrayList();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN course_tests AS ct "
					+ "WHERE ti.test_id = ct.test_id AND ti.is_active = 1 AND ti.classroom_id = '"+classroom_id+"' AND ti.term_id = '"+term_id+"' AND ct.course_id = '"+course_id+"' "
							+ "ORDER BY ti.date ASC");
			
		
		while(rs.next())
		{
			listOfTests.add(rs.getString("ti.test_id"));
		}
		for(int i = 0; i< listOfTests.toArray().length; i++) {
			if(i > 0 && listOfTests.get(i).equals(test_id)) {
				previousTestId = listOfTests.get(i-1).toString();
				break;
			}
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return previousTestId;
	}

	public static boolean hasPreviousTests(String test_id, String course_id, String classroom_id, String term_id) {
		boolean hasPreviousTests = false;
		List<String> listOfTests = new ArrayList();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN course_tests AS ct "
					+ "WHERE ti.test_id = ct.test_id AND ti.is_active = 1 AND ti.classroom_id = '"+classroom_id+"' AND ti.term_id = '"+term_id+"' AND ct.course_id = '"+course_id+"' "
							+ "ORDER BY ti.date ASC");
			
		
		while(rs.next())
		{
			listOfTests.add(rs.getString("ti.test_id"));
		}
		for(int i = 0; i< listOfTests.toArray().length; i++) {
			if(i > 0 && listOfTests.get(i).equals(test_id)) {
				hasPreviousTests = true;
				break;
			}
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return hasPreviousTests;
	}

	public static String getTestPercent(String test_id, String student_id) {
		String percent;
		String note = LPane.loadStudentNote(test_id, student_id);
		if(!note.equals("0/0")) {
		
		List l1 = Arrays.asList(note.split("/"));
		
		Double percent1 = (100*Double.parseDouble(l1.get(0).toString()))/Double.parseDouble(l1.get(1).toString());
		
		percent = new DecimalFormat("##.##").format((percent1));
		}else {
			percent = "0";
		}
	return percent.replaceAll(",", ".");
}
	

	public static String getTestMaxima(String test_id) {
		 
			String maxima = null;
			
			try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * from test_information "
						+ "WHERE is_active = 1 AND test_id = '"+test_id+"' LIMIT 1");
			
			while(rs.next())
			{
				maxima = rs.getString("maxima");
			}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return maxima;
		}
	
public static String getTestDate(String test_id) {
	 
		String date = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT DAY(date), MONTH(date), YEAR(date) from test_information "
					+ "WHERE is_active = 1 AND test_id = '"+test_id+"' LIMIT 1");
		
		while(rs.next())
		{
			date = rs.getString("DAY(date)")+"/"+rs.getString("MONTH(date)")+"/"+rs.getString("YEAR(date)");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return date;
	}
	
public static String getTestName(String test_id) {
	 
		String name = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information "
					+ "WHERE is_active = 1 AND test_id = '"+test_id+"' LIMIT 1");
		
		while(rs.next())
		{
			name = rs.getString("test_name");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}

public static String getTestCourse(String test_id) {
	 
		String course = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information AS ti "
					+ "JOIN course_tests AS ct "
					+ "WHERE ti.test_id = ct.test_id AND ti.is_active = 1 AND ti.test_id = '"+test_id+"' LIMIT 1");
		
		while(rs.next())
		{
			course = rs.getString("ct.course_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return course;
	}

public static String getTestClassroom(String test_id) {
	 
		String classroom = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information "
					+ "WHERE is_active = 1 AND test_id = '"+test_id+"' LIMIT 1");
		
		while(rs.next())
		{
			classroom = rs.getString("classroom_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return classroom;
	}

public static String getTestTerm(String test_id) {
	 
		String term = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from test_information "
					+ "WHERE is_active = 1 AND test_id = '"+test_id+"' LIMIT 1");
		
		while(rs.next())
		{
			term = rs.getString("term_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return term;
	}
	
	
	public static void color(Container test) {
			String str = ((JProgressBar) ((Container) (test)).getComponent(0)).getString();
			List note = Arrays.asList(str.trim().split("/"));
			
			Color color;
			if(Double.parseDouble((String)note.get(0))/Double.parseDouble((String)note.get(1))*100 >=50) {
				color = new Color(0, 168, 96);
			}else {
				color = new Color(255, 33, 94);
			}
			
			Test.progress.setUI(new BasicProgressBarUI() {
				protected Color getSelectionBackground() { return color;}
				protected Color getSelectionForeground() { return Color.white;
				}
			});
			
		
	}
	public static void deselect(String course_id, String student_id, String classroom_id) {
		for(int i = 0; i < LPane.panel_3.getComponents().length;i++) {
			
			if(((JComponent) LPane.panel_3.getComponent(i)) instanceof Test) {
			if(!((JComponent) LPane.panel_3.getComponent(i)).getComponent(0).isVisible()) {
				((JComponent) LPane.panel_3.getComponent(i)).setBackground(LPane.panel_3.getBackground());
				((Container) LPane.panel_3.getComponent(i)).getComponent(1).setForeground(Color.white);
				((JComponent) LPane.panel_3.getComponent(i)).setBorder(new LineBorder(Color.white, 2));
			}else {
		((JComponent) LPane.panel_3.getComponent(i)).setBackground(new Color(80, 80, 80));
		((Container) LPane.panel_3.getComponent(i)).getComponent(1).setForeground(Color.white);
		((Container) LPane.panel_3.getComponent(i)).getComponent(2).setForeground(Color.white);
			}
	}}
		
		List l = StudentStats.getStudentTestsStats(student_id, classroom_id, course_id, Home.termsText.get(Home.selectedTermIndex), "All", "All");
		
		List<String> note = Arrays.asList(l.get(1).toString().split("/"));
		
		Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."));
		Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."));
		
		Double percentage;
		if(points1 == Double.parseDouble("0") && maxima == Double.parseDouble("0")) {
			percentage = (double) 0;
		}else {
			percentage = points1*100/maxima;
		}

		LPane.average.setVisible(true);
		LPane.comboBox.setVisible(true);
		LPane.supprimer.setVisible(false);
		LPane.modifier.setVisible(false);
		
		
		LPane.no.setText(l.get(2).toString()+" Interrogations effectuees");
		
		
		

		LPane.prog.setText("Progression: "+ l.get(5).toString()+"%");
		LPane.pourcent.setText("Pourcentage: "+new DecimalFormat("##.##").format(percentage)+"%");
		LPane.points.setText(l.get(1).toString());
		if(percentage>=50) {
		LPane.echec.setText("Augmentation: "+new DecimalFormat("##.##").format((Double.parseDouble(note.get(0).toString())-(Double.parseDouble(note.get(1).toString())/2)))+" points");
		}else {
			LPane.echec.setText("Echec: "+new DecimalFormat("##.##").format((Double.parseDouble(note.get(1).toString())/2)-Double.parseDouble(note.get(0).toString()))+" points");
		}
		
		LPane.points.setForeground(new Color(255, 33, 94));
		LPane.mention.setForeground(new Color(255, 33, 94));
		LPane.mention();
		
		LPane.average.setVisible(true);
		LPane.comboBox.setVisible(true);
		selectedTests.clear();
		LPane.comboBox.setSelectedItem(ExamInfo.loadCourseMaxima(course_id, classroom_id, Login.selectedAcademicYearID));
		
			LPane.mention();
			LPane.average();
	}
}