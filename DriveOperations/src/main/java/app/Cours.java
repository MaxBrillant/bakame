package app;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComponent;

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
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Class.Animations;
import Class.Application;
import Class.ExamInfo;
import Class.NewExam;
import Class.TestBox;
import Class.OptionsMenu.TestMenu;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;

public class Cours extends JPanel {
	public static JLabel percent;
	public static JLabel Cours;
	public static JPanel stats;
	public static JPanel courseBox;
	public static JPanel Box1;
	public static JLabel lblPoints;
	public static JLabel lblAverage;
	public static JLabel lblImprovements;
	public static JLabel num;
	public static boolean isSelected;
	public static List<Component> selectedCourses = new ArrayList();
	

	/**
	 * Create the panel.
	 */
	public Cours(String ay_id, String course_id, String classroom_id, String student_id) {
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(Color.BLACK);
	setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
	setPreferredSize(new Dimension(400, 150));
	setLayout(new BorderLayout(0, 0));
	
	
	
	courseBox = new JPanel();
	courseBox.setBorder(null);
	courseBox.setBackground(new Color(201,255,226));
	courseBox.setPreferredSize(new Dimension(180, 10));
	add(courseBox, BorderLayout.WEST);
	courseBox.setLayout(null);
	
	Cours = new JLabel(TestBox.getFullName(course_id));
	Cours.setBorder(null);
	Cours.setForeground(new Color(0, 0, 0));
	Cours.setBackground(Color.GREEN);
	Cours.setFont(new Font("Futura Bk BT", Font.BOLD, 25));
	Cours.setHorizontalAlignment(SwingConstants.CENTER);
	Cours.setBounds(0, 0, 180, 150);
	courseBox.add(Cours);
	
	num = new JLabel("0");
	num.setHorizontalAlignment(SwingConstants.CENTER);
	num.setForeground(new Color(0, 0, 0));
	num.setFont(new Font("Arial", Font.PLAIN, 17));
	num.setBounds(0, 116, 37, 34);
	courseBox.add(num);
	
	stats = new JPanel();
	stats.setBackground(new Color(60, 60, 60));
	add(stats, BorderLayout.CENTER);

	GridBagLayout gbl_stats = new GridBagLayout();
	gbl_stats.columnWidths = new int[]{18, 132, 0};
	gbl_stats.rowHeights = new int[]{24, 35, 35, 35, 35, 17, 0};
	gbl_stats.columnWeights = new double[]{0.0, 10.0, Double.MIN_VALUE};
	gbl_stats.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	stats.setLayout(gbl_stats);
	
	percent = new JLabel("Pourcentage: 0%");
	percent.setForeground(Color.WHITE);
	percent.setFont(new Font("Roboto", Font.BOLD, 18));
	percent.setBounds(10, 21, 230, 24);
	stats.add(percent);

	GridBagConstraints gbc_percent = new GridBagConstraints();
	gbc_percent.fill = GridBagConstraints.VERTICAL;
	gbc_percent.anchor = GridBagConstraints.WEST;
	gbc_percent.insets = new Insets(0, 0, 5, 0);
	gbc_percent.gridx = 1;
	gbc_percent.gridy = 1;
	stats.add(percent, gbc_percent);
	
	
	lblPoints = new JLabel("Points:");
	lblPoints.setForeground(Color.WHITE);
	lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
	lblPoints.setBounds(10, 47, 230, 24);
	stats.add(lblPoints);

	GridBagConstraints gbc_lblPoints = new GridBagConstraints();
	gbc_lblPoints.anchor = GridBagConstraints.WEST;
	gbc_lblPoints.insets = new Insets(0, 0, 5, 0);
	gbc_lblPoints.gridx = 1;
	gbc_lblPoints.gridy = 2;
	stats.add(lblPoints, gbc_lblPoints);
	
	lblAverage = new JLabel("Moyenne:");
	lblAverage.setForeground(Color.WHITE);
	lblAverage.setFont(new Font("Roboto", Font.BOLD, 18));
	lblAverage.setBounds(10, 73, 230, 24);
	stats.add(lblAverage);

	GridBagConstraints gbc_lblAverage = new GridBagConstraints();
	gbc_lblAverage.fill = GridBagConstraints.VERTICAL;
	gbc_lblAverage.anchor = GridBagConstraints.WEST;
	gbc_lblAverage.insets = new Insets(0, 0, 5, 0);
	gbc_lblAverage.gridx = 1;
	gbc_lblAverage.gridy = 3;
	stats.add(lblAverage, gbc_lblAverage);
	
	lblImprovements = new JLabel("Echec:");
	lblImprovements.setForeground(Color.WHITE);
	lblImprovements.setFont(new Font("Roboto", Font.BOLD, 18));
	lblImprovements.setBounds(10, 101, 230, 24);
	stats.add(lblImprovements);

	GridBagConstraints gbc_lblImprovements = new GridBagConstraints();
	gbc_lblImprovements.fill = GridBagConstraints.VERTICAL;
	gbc_lblImprovements.anchor = GridBagConstraints.WEST;
	gbc_lblImprovements.insets = new Insets(0, 0, 5, 0);
	gbc_lblImprovements.gridx = 1;
	gbc_lblImprovements.gridy = 4;
	stats.add(lblImprovements, gbc_lblImprovements);
	
	
	setPreferredSize(new Dimension(new Dimension(400, 150)));
	
	
	
    addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Animations.animateComponent(getComponent(0).getParent(), 20, 20 , 40);
					boolean alreadyExists = false;

						if(selectedCourses.contains(getComponent(0).getParent())) {
						alreadyExists = true;
						}
						App.deselect();
						selectedCourses.clear();
					selectedCourses.add(getComponent(0).getParent());
					
					
						for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
							if(App.panel_5.getComponent(j).equals(selectedCourses.get(0))) {
								setSelected(App.panel_5.getComponent(j));
							}}
						showStudentTests(course_id, student_id, classroom_id);
				//
			}
			public void mouseEntered(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					getComponent(1).setBackground(new Color(40, 40, 40));
					setBorder(new LineBorder(new Color(20, 148, 198),4));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedCourses.contains(getComponent(0).getParent())) {
					getComponent(1).setBackground(new Color(60, 60, 60));
					setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
				}
				
			}
		});
		
	}

	
public static void setSelected(Component c) {
	
	if(((JComponent) c).getComponent(0).getBackground().equals(new Color(255,221,221))) {
		c.setBackground(new Color(161, 0, 0));
	((Container) c).getComponent(0).setBackground(new Color(161, 0, 0));
	((Container) c).getComponent(1).setBackground(new Color(118, 12, 12));
	}
	else if(((JComponent) c).getComponent(0).getBackground().equals(new Color(201,255,226))) {
	c.setBackground(new Color(31, 154, 97));
	((Container) c).getComponent(0).setBackground(new Color(31, 154, 97));
	((Container) c).getComponent(1).setBackground(new Color(0, 98, 59));
}else {
c.setBackground(new Color(120, 120, 120));
((JComponent) c).getComponent(0).setBackground(new Color(120, 120, 120));
((JComponent) c).getComponent(1).setBackground(new Color(80, 80, 80));
}
	((JComponent) c).setBorder(new MatteBorder(3, 2, 6, 5, c.getBackground()));
	((Container) ((Container) c).getComponent(0)).getComponent(0).setForeground(Color.white);
	((Container) ((Container) c).getComponent(0)).getComponent(1).setForeground(Color.white);
	
}


public static void showStudentTests(String course_id, String student_id, String classroom_id) {
	LPane tp = new LPane(course_id, student_id, classroom_id);
	App.panel_1.remove(1);
	App.panel_1.add(tp);
	App.panel_1.revalidate();
	App.panel_1.repaint();
	}
	
	  public static void loadAverage(String course_id, String classroom_id, String ay_id) {
	  
	  if(App.panel_5.getComponentCount()>0) {
		  try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * FROM courses_in_classroom "
						+ "WHERE course_id = '"+course_id+"' AND classroom_id = '"+classroom_id+"' AND ay_id = '"+ay_id+"' LIMIT 1");
				while(rs.next())
				{
			  LPane.comboBox.setSelectedItem(Integer.parseInt(rs.getString("maxima")));
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			} }
	  
	  }
	 

	public static void loaddata(Container c, String course_id, String classroom_id, String student_id, String ay_id) {
		
		Double sum = (double) 0;
		Double sum1 = (double) 0;
		Double tot = (double) 0;
		Double tot1 = (double) 0;
			
			
			List l = CourseStats.getStudentTestsStats(App.getStudentName(App.n), Home.className, courseName, Home.termsText.get(Home.selectedTermIndex), "All", "All");
			List l1 = CourseStats.getStudentExamStats(App.getStudentName(App.n), Home.className, courseName, Home.termsText.get(Home.selectedTermIndex), "All", "All");
			
			List<String> note = Arrays.asList(l.get(1).toString().split("/"));
			List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
			
			String courseMaxima;
			courseMaxima = ExamInfo.loadCourseMaxima(course_id, classroom_id, ay_id);
			
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima1 = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			Double percentage;
			if(points1 == 0 && maxima1 == 0) {
				percentage = (double) 0;
			}else {

				percentage = points1*100/maxima1;
			}
			
			
			((JLabel) ((Container) c.getComponent(1)).getComponent(1)).setText("Points"+": "+new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima1));
			((JLabel) ((Container) c.getComponent(1)).getComponent(0)).setText("Pourcentage: "+new DecimalFormat("##.##").format(percentage)+"%");
			
			((JLabel) ((Container) c.getComponent(1)).getComponent(2)).setText("Moyenne: "+new DecimalFormat("##.##").format(points1/maxima1*Integer.parseInt(courseMaxima))+"/"+courseMaxima);
			
			if(percentage>=50) {
				((JLabel) ((Container) c.getComponent(1)).getComponent(3)).setText("Augm. : "+new DecimalFormat("##.##").format(points1-(maxima1/2))+" points");
			}else {
				((JLabel) ((Container) c.getComponent(1)).getComponent(3)).setText("Echec. : "+new DecimalFormat("##.##").format((maxima1/2)-points1)+" points");
				}
		
			if(percentage>=50) {
				c.getComponent(0).setBackground(new Color(201,255,226));
			}else {
				c.getComponent(0).setBackground(new Color(255,221,221));
			}
			if(points1 == 0 && maxima1 == 0) {
				c.getComponent(0).setBackground(new Color(200, 200, 200));
				}
	}
	
}
