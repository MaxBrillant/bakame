package Stats;

import javax.swing.JPanel;

import app.Test;
import app.WrapLayout;
import Application.Home;
import Application.ResizeImages;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Class.Application;
import Class.Student;
import Class.TestBox;
import Class.TestInfo;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class StudentStats extends JPanel {
	public static JLabel percent;
	public static JLabel points;
	public static JLabel place;
	public static JLabel echecs;
	public static JLabel missedTests;
	public static JLabel tests;
	public static JLabel p2;
	public static JLabel p1;
	public static JLabel points1;
	public static JLabel points2;
	public static JPanel panel_11;
	public static JPanel panel_13;
	public static JPanel panel11;
	public static JPanel panel1;
	public static JPanel panelEchecs;
	public static JPanel panelPoints;
	public static JPanel panelPercent;
	public static JPanel panel_8;

	/**
	 * Create the panel.
	 */
	public StudentStats() {
		setBackground(new Color(40, 40, 40));
		setLayout(new WrapLayout(WrapLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 80, 80));
		panel.setPreferredSize(new Dimension(200, 70));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Pourcentage");
		lblNewLabel.setPreferredSize(new Dimension(61, 25));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		percent = new JLabel("75,28%");
		percent.setForeground(Color.WHITE);
		percent.setFont(new Font("Roboto", Font.BOLD, 30));
		percent.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(percent, BorderLayout.CENTER);
		
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(label_7, BorderLayout.EAST);
		
		panelPercent = new JPanel();
		panelPercent.setBackground(new Color(80, 80, 80));
		panelPercent.setPreferredSize(new Dimension(70, 0));
		panelPercent.setMaximumSize(new Dimension(70, 54));
		panel.add(panelPercent, BorderLayout.SOUTH);
		panelPercent.setLayout(new WrapLayout(1, 1, 1));
		
		
		panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 70+panelPercent.getPreferredSize().height));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 70));
		panel_1.setBackground(new Color(80, 80, 80));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		points = new JLabel("692/700");
		points.setHorizontalAlignment(SwingConstants.CENTER);
		points.setForeground(Color.WHITE);
		points.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_1.add(points, BorderLayout.CENTER);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setPreferredSize(new Dimension(61, 25));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_1.add(lblPoints, BorderLayout.NORTH);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Arial", Font.BOLD, 30));
		panel_1.add(label_12, BorderLayout.EAST);
		
		panelPoints = new JPanel();
		panelPoints.setBackground(new Color(80, 80, 80));
		panelPoints.setPreferredSize(new Dimension(70, 0));
		panelPoints.setMaximumSize(new Dimension(70, 54));
		panel_1.add(panelPoints, BorderLayout.SOUTH);
		panelPoints.setLayout(new WrapLayout(1, 1, 1));
		
		
		panel_1.setPreferredSize(new Dimension(panel_1.getPreferredSize().width, 70+panelPoints.getPreferredSize().height));
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(200, 70));
		panel_7.setBackground(new Color(80, 80, 80));
		add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setPreferredSize(new Dimension(61, 25));
		lblPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlace.setForeground(Color.WHITE);
		lblPlace.setFont(new Font("Roboto", Font.BOLD, 18));
		
		place = new JLabel("-");
		place.setHorizontalAlignment(SwingConstants.CENTER);
		place.setForeground(Color.WHITE);
		place.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_7.add(place, BorderLayout.CENTER);

		panel_7.add(lblPlace, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(80, 80, 80));
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		echecs = new JLabel("10");
		echecs.setHorizontalAlignment(SwingConstants.CENTER);
		echecs.setForeground(Color.WHITE);
		echecs.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_3.add(echecs, BorderLayout.CENTER);
		
		JLabel lblEchecs = new JLabel("Echecs");
		lblEchecs.setPreferredSize(new Dimension(61, 25));
		lblEchecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecs.setForeground(Color.WHITE);
		lblEchecs.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_3.add(lblEchecs, BorderLayout.NORTH);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 30));
		panel_3.add(label_5, BorderLayout.EAST);
		
		panelEchecs = new JPanel();
		panelEchecs.setPreferredSize(new Dimension(70, 0));
		panel_3.add(panelEchecs, BorderLayout.SOUTH);
		panelEchecs.setMaximumSize(new Dimension(70, 130));
		

		panel_3.setPreferredSize(new Dimension(200, 70));
		
		panelEchecs.setLayout(new WrapLayout(WrapLayout.CENTER, 1, 1));
		
		JPanel panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(200, 70));
		panel_10.setBackground(new Color(80, 80, 80));
		add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		missedTests = new JLabel("3");
		missedTests.setHorizontalAlignment(SwingConstants.CENTER);
		missedTests.setForeground(Color.WHITE);
		missedTests.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_10.add(missedTests, BorderLayout.CENTER);
		
		JLabel lblInterrogationsNonFaites = new JLabel("Interrogations ratees");
		lblInterrogationsNonFaites.setPreferredSize(new Dimension(61, 25));
		lblInterrogationsNonFaites.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterrogationsNonFaites.setForeground(Color.WHITE);
		lblInterrogationsNonFaites.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_10.add(lblInterrogationsNonFaites, BorderLayout.NORTH);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial", Font.BOLD, 30));
		panel_10.add(label_8, BorderLayout.EAST);
		
		panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(70, 0));
		panel_11.setMaximumSize(new Dimension(70, 130));
		panel_10.add(panel_11, BorderLayout.SOUTH);

		panel_11.setLayout(new WrapLayout(1, 1, 1));
		

		panel_10.setPreferredSize(new Dimension(panel_10.getPreferredSize().width, 70+panel_11.getPreferredSize().height));
		
		

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(200, 70));
		panel_4.setBackground(new Color(80, 80, 80));
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		tests = new JLabel("24");
		tests.setHorizontalAlignment(SwingConstants.CENTER);
		tests.setForeground(Color.WHITE);
		tests.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_4.add(tests, BorderLayout.CENTER);
		
		JLabel interros = new JLabel("Interrogations faites");
		interros.setPreferredSize(new Dimension(61, 25));
		interros.setHorizontalAlignment(SwingConstants.CENTER);
		interros.setForeground(Color.WHITE);
		interros.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_4.add(interros, BorderLayout.NORTH);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Arial", Font.BOLD, 30));
		panel_4.add(label_9, BorderLayout.EAST);
		
		panel_13 = new JPanel();
		panel_13.setPreferredSize(new Dimension(70, 0));
		panel_13.setMaximumSize(new Dimension(70, 130));
		panel_4.add(panel_13, BorderLayout.SOUTH);
		panel_13.setLayout(new WrapLayout(1, 1, 1));
		

		panel_4.setPreferredSize(new Dimension(panel_4.getPreferredSize().width, 70+panel_13.getPreferredSize().height));
		
		
		panel_8 = new JPanel();
		panel_8.setPreferredSize(new Dimension(405, 250));
		panel_8.setBackground(new Color(80, 80, 80));
		add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
        
        JLabel label_3 = new JLabel("Interrogations non faites");
        label_3.setPreferredSize(new Dimension(61, 0));
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setForeground(Color.WHITE);
        label_3.setFont(new Font("Roboto", Font.PLAIN, 18));
        panel_8.add(label_3, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 70));
		panel_2.setBackground(new Color(80, 80, 80));
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCoursLePlus = new JLabel("Cours le plus reussie");
		lblCoursLePlus.setPreferredSize(new Dimension(61, 25));
		lblCoursLePlus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoursLePlus.setForeground(Color.WHITE);
		lblCoursLePlus.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblCoge = new JLabel("Interro no1");
		lblCoge.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoge.setForeground(Color.WHITE);
		lblCoge.setFont(new Font("Roboto", Font.BOLD, 25));
		panel_2.add(lblCoge, BorderLayout.CENTER);
		

		panel_2.add(lblCoursLePlus, BorderLayout.NORTH);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Arial", Font.BOLD, 30));
		panel_2.add(label_10, BorderLayout.EAST);
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(70, 0));
		panel1.setMaximumSize(new Dimension(70, 130));
		panel_2.add(panel1, BorderLayout.SOUTH);
		

		panel1.setLayout(new WrapLayout(1, 1, 1));
		

		panel_2.setPreferredSize(new Dimension(panel_2.getPreferredSize().width, 70+panel1.getPreferredSize().height));
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(200, 70));
		panel_5.setBackground(new Color(80, 80, 80));
		add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLinterroLaMoins = new JLabel("Cours le moins reussie");
		lblLinterroLaMoins.setPreferredSize(new Dimension(61, 25));
		lblLinterroLaMoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinterroLaMoins.setForeground(Color.WHITE);
		lblLinterroLaMoins.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblInterroNo = new JLabel("Interro no3");
		lblInterroNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterroNo.setForeground(Color.WHITE);
		lblInterroNo.setFont(new Font("Roboto", Font.BOLD, 25));
		panel_5.add(lblInterroNo, BorderLayout.CENTER);
		

		panel_5.add(lblLinterroLaMoins, BorderLayout.NORTH);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Arial", Font.BOLD, 30));
		panel_5.add(label_11, BorderLayout.EAST);
		
		panel11 = new JPanel();
		panel11.setPreferredSize(new Dimension(70, 0));
		panel11.setMaximumSize(new Dimension(70, 130));
		panel_5.add(panel11, BorderLayout.SOUTH);

		panel11.setLayout(new WrapLayout(1, 1, 1));
		

		panel_5.setPreferredSize(new Dimension(panel_5.getPreferredSize().width, 70+panel11.getPreferredSize().height));
		
		
		

		for(int i = 0; i<getComponentCount(); i++) {
			int k =i;
			
			if(((Container) getComponent(k)).getComponentCount() >3) {
				((Container) getComponent(k)).getComponent(3).setMaximumSize(new Dimension(200,
						((Container) ((Container) getComponent(k)).getComponent(3)).getComponentCount()*(26)+2));
				}
			
			((Container) getComponent(i)).getComponent(0).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if((((Container) getComponent(k)).getComponent(3)).getPreferredSize().height==0){
						((Container) getComponent(k)).getComponent(3).setPreferredSize(
								new Dimension(0, ((Container) getComponent(k)).getComponent(3).getMaximumSize().height));
						getComponent(k).setPreferredSize( new Dimension(405, 70+((Container) getComponent(k)).getComponent(3).getPreferredSize().height));
						
						getComponent(k).revalidate();
						getComponent(k).repaint();
						revalidate();
						repaint();
						}
					else {
						if(((Container) getComponent(k)).getComponentCount() >3) {
						((Container) getComponent(k)).getComponent(3).setPreferredSize(new Dimension(0, 0));
						getComponent(k).setPreferredSize(new Dimension(200, 70));
						
						revalidate();
						repaint();
						}
					}
				}
			});
		}
        		//loadStudentData();
	}
	
	
	public static void loadStudentData() {
		
		

		new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
            	
				//CourseStats.loadCourseData();
		for(int i = 0; i<((Container) StatsPane.scrollPane.getComponent(0)).getComponentCount(); i++) {
			if(!((Container) ((Container) StatsPane.scrollPane.getComponent(0)).getComponent(i)).equals(panel_8)) {
			for(int j = 0; j<((Container) ((Container) StatsPane.scrollPane.getComponent(0)).getComponent(i)).getComponentCount(); j++) {
			if(((Container) ((Container) ((Container) StatsPane.scrollPane.getComponent(0)).getComponent(i)).getComponent(j)).getComponentCount()>3) {
				((Container) ((Container) ((Container) ((Container) StatsPane.scrollPane.getComponent(0)).getComponent(i)).getComponent(j)).getComponent(3)).removeAll();
			}
		
			}}
		}
		loadStuff();
		
		List l = getStudentTestsStats(StatsPane.name.getText().toString(), StatsPane.className.getText()
				, StatsPane.course.getText(), StatsPane.Term.getText().toString(), "All", "All");
		List l1 = getStudentExamStats(StatsPane.name.getText().toString(), StatsPane.className.getText()
				, StatsPane.course.getText(), StatsPane.Term.getText().toString(), "All", "All");
		
		List<String> note = Arrays.asList(l.get(1).toString().split("/"));
		List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
		
		if(Double.parseDouble(note.get(0).replaceAll(",", ".")) != 0 && Double.parseDouble(note.get(1).replaceAll(",", ".")) !=0) {

			p1.setText(new DecimalFormat("##.##").format(Double.parseDouble(note.get(0).replaceAll(",", "."))*100/Double.parseDouble(note.get(1).replaceAll(",", ".")))+"%");
			points1.setText(new DecimalFormat("##.##").format(Double.parseDouble(note.get(0).replaceAll(",", ".")))+"/"+
					new DecimalFormat("##.##").format(Double.parseDouble(note.get(1).replaceAll(",", "."))));
			}else {
				p1.setText("0%");
				points1.setText("0/0");
			}
			if(Double.parseDouble(note1.get(0).replaceAll(",", ".")) != 0 && Double.parseDouble(note1.get(1).replaceAll(",", ".")) !=0) {
				p2.setText(new DecimalFormat("##.##").format(Double.parseDouble(note1.get(0).replaceAll(",", "."))*100/Double.parseDouble(note1.get(1).replaceAll(",", ".")))+"%");
				points2.setText(new DecimalFormat("##.##").format(Double.parseDouble(note1.get(0).replaceAll(",", ".")))+"/"+
					new DecimalFormat("##.##").format(Double.parseDouble(note1.get(1).replaceAll(",", "."))));
			}else {
				p2.setText("0%");
				points2.setText("0/0");
			}
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			Double percentage;
			if(points1 == 0 && maxima == 0) {
				percentage = (double) 0;
			}else {

				percentage = points1*100/maxima;
			}
			
			percent.setText(new DecimalFormat("##.##").format(percentage)+"%");

			if(points1 == 0 && maxima == 0) {
				points.setText("0/0");
			}else {

				points.setText(new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
			}
		
		
		
		percent.setText(new DecimalFormat("##.##").format(percentage)+"%");
		points.setText(new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
		tests.setText(l.get(2).toString());
		missedTests.setText(l.get(4).toString());
		

		StatsPane.number.setText(loadStudentNumber(StatsPane.name.getText(), StatsPane.className.getText()));
		

		loadAllTests();
		echecs();
		rankStudentPerformances(StatsPane.className.getText());
		
		
		
		for(int i = 0; i<panelEchecs.getParent().getParent().getComponentCount(); i++) {
			int k =i;
			
			if(!((Container) panelEchecs.getParent().getParent().getComponent(i)).equals(panel_8)) {
			if(((Container) panelEchecs.getParent().getParent().getComponent(i)).getComponentCount()>3) {
				((Container) panelEchecs.getParent().getParent().getComponent(i)).getComponent(3).setBackground(new Color(80, 80, 80));
			}
			
			if(((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponentCount() >3) {
				((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3).setMaximumSize(new Dimension(200,
						((Container) ((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3)).getComponentCount()*(26)+2));
				}
			
			if(((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponentCount() >3){

				if(((Container) panelEchecs.getParent().getParent().getComponent(k)).getPreferredSize().height==70) {
				((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3).setPreferredSize(new Dimension(0, 0));
				panelEchecs.getParent().getParent().getComponent(k).setPreferredSize(new Dimension(200, 70));
				
				panelEchecs.getParent().getParent().revalidate();
				panelEchecs.getParent().getParent().repaint();
				}
			else {
				
				((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3).setPreferredSize(
						new Dimension(0, ((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3).getMaximumSize().height));
				panelEchecs.getParent().getParent().getComponent(k).setPreferredSize( new Dimension(405, 70+((Container) panelEchecs.getParent().getParent().getComponent(k)).getComponent(3).getPreferredSize().height));
				
				panelEchecs.getParent().getParent().getComponent(k).revalidate();
				panelEchecs.getParent().getParent().getComponent(k).repaint();
				panelEchecs.getParent().getParent().revalidate();
				panelEchecs.getParent().getParent().repaint();
				
				}}
		}
		}

		 return null;
    }
}.execute();


        panel_8.removeAll();
		new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
            	
		XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chart.setBackgroundPaint(new Color(80, 80, 80));
        panel_8.add(chartPanel);
        StatsPane.scrollPane.revalidate();
        StatsPane.scrollPane.repaint();

   	 return null;
   }
}.execute();
	}
	
	public static String loadStudentNumber(String s ,String c) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");
		aws.downloadContent(file.getPath());
		String number = "";
			
			FileReader fr;
			try {
				fr = new FileReader(file);
			
			
			BufferedReader br = new BufferedReader(fr);
			Object lines [] = Home.loadActiveStudents(file.getPath());
			
			for(int i = 0;i<lines.length; i++) {
				List note = Arrays.asList(lines[i].toString().trim().split("//"));
				
				if(note.get(0).equals(s)) {
					number = note.get(1).toString();
				}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return number;
			
	}
	
	public static void loadStuff() {
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(40, 40, 40));
		panel_6.setPreferredSize(new Dimension(400, 25));
		panelPercent.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Travaux journaliers");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 0, 208, 25);
		panel_6.add(lblNewLabel_1);
		
		p1 = new JLabel("78,5%");
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setForeground(Color.WHITE);
		p1.setFont(new Font("Roboto", Font.PLAIN, 17));
		p1.setBounds(233, 0, 143, 25);
		panel_6.add(p1);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setPreferredSize(new Dimension(400, 25));
		panel_15.setBackground(new Color(40, 40, 40));
		panelPercent.add(panel_15);
		
		p2 = new JLabel("84%");
		p2.setHorizontalAlignment(SwingConstants.CENTER);
		p2.setForeground(Color.WHITE);
		p2.setFont(new Font("Roboto", Font.PLAIN, 17));
		p2.setBounds(233, 0, 143, 25);
		panel_15.add(p2);
		
		JLabel lblExamens = new JLabel("Examens");
		lblExamens.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamens.setForeground(Color.WHITE);
		lblExamens.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblExamens.setBounds(10, 0, 208, 25);
		panel_15.add(lblExamens);
		
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setPreferredSize(new Dimension(400, 25));
		panel_16.setBackground(new Color(40, 40, 40));
		panelPoints.add(panel_16);
		
		JLabel label = new JLabel("Travaux journaliers");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.PLAIN, 17));
		label.setBounds(10, 0, 208, 25);
		panel_16.add(label);
		
		points1 = new JLabel("78,5%");
		points1.setHorizontalAlignment(SwingConstants.CENTER);
		points1.setForeground(Color.WHITE);
		points1.setFont(new Font("Roboto", Font.PLAIN, 17));
		points1.setBounds(233, 0, 143, 25);
		panel_16.add(points1);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setPreferredSize(new Dimension(400, 25));
		panel_17.setBackground(new Color(40, 40, 40));
		panelPoints.add(panel_17);
		
		points2 = new JLabel("84%");
		points2.setHorizontalAlignment(SwingConstants.CENTER);
		points2.setForeground(Color.WHITE);
		points2.setFont(new Font("Roboto", Font.PLAIN, 17));
		points2.setBounds(233, 0, 143, 25);
		panel_17.add(points2);
		
		JLabel label_4 = new JLabel("Examens");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Roboto", Font.PLAIN, 17));
		label_4.setBounds(10, 0, 208, 25);
		panel_17.add(label_4);
		

	}
	
	
	public static List<String> getStudentTestsStats(String n, String c, String cn, String t, String firstDate, String lastDate) {
		
		String percentage = "0%";
		String points = "0/0";
		String Tests = "0";
		String Echecs = "0";
		String missed = "0";
		Double progress = (double) 0;
		List <String>stats = new ArrayList();
			
			Double sum = (double) 0;
			Double sum1 = (double) 0;
			Double tot = (double) 0;
			Double tot1 = (double) 0;
			int test = 0;
			int tests = 0;
			int missedTests = 0;
			boolean echec = false;
			int echecs = 0;
			Object[] lines1 = null;
			List <String>classes = new ArrayList();
			List <String>students = new ArrayList();
			List <String>terms = new ArrayList();
			
			

			File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Courses.txt");
			aws.downloadContent(file1.getPath());
				
				FileReader fr1;
				try {
					fr1 = new FileReader(file1);
				
				
				BufferedReader br1 = new BufferedReader(fr1);
				lines1 = Home.loadActiveCourses(file1.getPath());
			
				if(lines1.length>0) {
				if(cn == "All") {
					classes.clear();
					for(int j = 0; j<lines1.length;j++) {
					List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
					classes.add(note1.get(0).toString());
					}
					}
				else {
					classes.clear();
					classes.add(TestBox.getShortName(cn, c));
				}
				}else {
					classes.clear();
				}
				
				
File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");

aws.downloadContent(file11.getPath());
				FileReader fr11;
				try {
					fr11 = new FileReader(file11);
				
				
				BufferedReader br11 = new BufferedReader(fr11);
				Object[] lines11 = Home.loadActiveStudents(file11.getPath());

				if(lines11.length>0) {
				if(n == "All") {
					students.clear();
				
				for(int j = 0; j<lines11.length;j++) {
				List note1 = Arrays.asList(lines11[j].toString().trim().split("//"));
				students.add(note1.get(0).toString());
				}}
			else {
				students.clear();
				students.add(n);
			}}else {
				students.clear();
			}
				
				if(t == "Toute l'annee") {
					terms.clear();
				
				
				terms.add("1er Trimestre");
				terms.add("2eme Trimestre");
				terms.add("3eme Trimestre");
				}
			else {
				terms.clear();
				terms.add(t);
			}
				
				String firstTerm = "";
				String lastTerm = "";
				
				if(terms.toArray().length>1) {
					for(int i = 0; i<terms.toArray().length; i++) {
						if(termHasTests(c, terms.get(i).toString())) {
							firstTerm = terms.get(i).toString();
							break;
				}
						}
					for(int i = terms.toArray().length-1; i>=0; i--) {
						if(termHasTests(c, terms.get(i).toString())) {
							lastTerm = terms.get(i).toString();
							break;
				}
				}
				}else {
					firstTerm = t;
					lastTerm = t;
				}

				if(!firstTerm.equals("")&& !lastTerm.equals("")) {
					if(classes.toArray().length>1) {
						String firstTestInTerm = "0";
						String lastTestInTerm = "0";
						for(int i = 0; i< classes.toArray().length; i++) {
							
							if(CourseStats.courseHasTests(classes.get(i).toString(), c, lastTerm) || CourseStats.courseHasTests(classes.get(i).toString(), c, firstTerm)) {
							String coursefirstDate = getTestDate(c, classes.get(i).toString(), "1", lastTerm);
							
							String courselastDate = getTestDate(c, classes.get(i).toString(), getLastTestNumber(c, classes.get(i).toString(), firstTerm), firstTerm);
							
							 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							 Date d1 = null;
							 Date d2 = null;
							 Date d3 = null;
							 Date d4 = null;
							try {
								System.out.println(coursefirstDate);
								d1 = df.parse(coursefirstDate);
								d2 = df.parse(courselastDate);
								if(!firstTestInTerm.equals("0")&&!lastTestInTerm.equals("0")) {
								d3 = df.parse(firstTestInTerm);
								d4 = df.parse(lastTestInTerm);
								}else {
									d3 = df.parse(coursefirstDate);
									d4 = df.parse(courselastDate);
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							
							Calendar c1 = Calendar.getInstance();
							Calendar c2 = Calendar.getInstance();
							Calendar c3 = Calendar.getInstance();
							Calendar c4 = Calendar.getInstance();
							c1.setTime(d1);
							c2.setTime(d2);
							c3.setTime(d3);
							c4.setTime(d4);
							
							if(!firstTestInTerm.equals("0")){
							if(c1.before(c3)) {
								firstTestInTerm = coursefirstDate;
							}
							}else {
								firstTestInTerm = coursefirstDate;
							}

							if(!lastTestInTerm.equals("0")){
							if(c2.after(c4)) {
								lastTestInTerm = courselastDate;
							}}else {
								lastTestInTerm = courselastDate;
							}
						}
						}
						if(firstDate.equals("All")) {
						firstDate = firstTestInTerm;
						}if(lastDate.equals("All")) {
						lastDate = lastTestInTerm;
					}}
					
					if(!students.isEmpty()) {
					for(int l = 0; l<terms.toArray().length;l++) {
						for(int j = 0; j<classes.toArray().length;j++) {
							for(int k = 0; k<students.toArray().length;k++) {

					
					File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/"+students.get(k).toString()+"/"+terms.get(l).toString()+"/"+classes.get(j).toString()+".txt");

					aws.downloadContent(file.getPath());
						try {

							FileReader fr = new FileReader(file);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines = br.lines().toArray();
						
							if(lines.length>1) {
								if(classes.toArray().length==1) {
								if(firstDate.equals("All")) {
									firstDate = getTestDate(c, classes.get(j).toString(), "1", lastTerm);
								}
								if(lastDate.equals("All")) {
									lastDate = getTestDate(c, classes.get(j).toString(), getLastTestNumber(c, classes.get(j).toString(), firstTerm), firstTerm);
								}}
								//System.out.println(firstDate+"--"+lastDate);
								 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								 Date d1 = null;
								 Date d2 = null;
								try {
									d1 = df.parse(firstDate);
									d2 = df.parse(lastDate);
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								
								Calendar c1 = Calendar.getInstance();
								Calendar c2 = Calendar.getInstance();
								c1.setTime(d1);
								c2.setTime(d2);
							
								
								tot = (double) 0;
								tot1 = (double) 0;
								test = 0;
							for(int i = 1; i<lines.length; i++) {
							

								
								 SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
								 Date d3 = null;
								try {
									d3 = df1.parse(getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString()));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								
								Calendar c3 = Calendar.getInstance();
								c3.setTime(d3);
								

								if(c3.after(c1) && c3.before(c2) || c3.equals(c1) && c3.before(c2) || c3.after(c1) && c3.equals(c2) || c3.equals(c1)&& c3.equals(c2)) {
									System.out.println("Starting at "+c1.getTime().getDate()+"/"+(c1.getTime().getMonth()+1)+"/"+(c1.getTime().getYear()+1900)+"---"+c3.getTime().getDate()+"/"+(c3.getTime().getMonth()+1)+"/"+(c3.getTime().getYear()+1900));
									System.out.println("ending at "+c3.getTime().getDate()+"/"+(c3.getTime().getMonth()+1)+"/"+(c3.getTime().getYear()+1900)+"---"+c2.getTime().getDate()+"/"+(c2.getTime().getMonth()+1)+"/"+(c2.getTime().getYear()+1900));
									
									List l1 = Arrays.asList(lines[i].toString().trim().split("//"));
									List note = Arrays.asList(l1.get(1).toString().split("/"));
						
							Double d = Double.parseDouble((String) note.get(0));
							Double e = Double.parseDouble((String) note.get(1));
							
								progress = progress+ Double.parseDouble(Test.getTestProgression(l1.get(0).toString(), students.get(k)));

							tot = tot+ d;
							tot1 = tot1+e;
							if(e==0 && d==0) {
								test = test+0;
								missedTests = missedTests+1;
							}else {
								test++;
								missedTests = missedTests+0;
							}
							
							
							if(i>=2) {
								
								if(lines[i-1].toString().equals("0/0") || lines[i].toString().equals("0/0")) {
								}else {
								String str1 = lines[i-1].toString().replaceAll("[^0.00-9.00]+", " ");
								List note11 = Arrays.asList(str1.trim().split(" "));
								
							}
							}
							}}
							sum = sum+tot;
							sum1 = sum1+tot1;
							
							}else {
								test = 0;
							}

							
							
							
								if(tot<(tot1/2) && lines.length>6) {
								echec = true;
							}else {
								echec = false;
							}
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
						tests = tests+test;
						if(echec) {
						echecs = echecs+1;
						}else {
							echecs = echecs+0;
						}	
						if(sum==0 && sum1==0) {
							points = "0/0";
						}else {
							points =new DecimalFormat("##.##").format(sum)+"/"+new DecimalFormat("##.##").format(sum1);
						}
						Tests=String.valueOf(tests);
						
						Double percent = sum/sum1*100;
						if(sum==0 && sum1==0) {
							percentage ="0%";
						}else {
							percentage = new DecimalFormat("##.##").format(percent)+"%";
						}
						Echecs = String.valueOf(echecs);
						missed = String.valueOf(missedTests);
				}
						}
					}}}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		stats.add(percentage);
		stats.add(points.replaceAll(",", "."));
		stats.add(Tests);
		stats.add(Echecs);
		stats.add(missed);
		stats.add(new DecimalFormat("##.##").format(progress).replaceAll(",", "."));
		
		return stats;
		
	}
	
public static List<String> getStudentTests(String n, String c, String cn, String t) {
		
	List <String>classes = new ArrayList();
	List <String>students = new ArrayList();
	List <String>terms = new ArrayList();
	
	List <String>studentTests = new ArrayList();
	

	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Courses.txt");

	aws.downloadContent(file1.getPath());
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object [] lines1 = Home.loadActiveCourses(file1.getPath());
			
		if(lines1.length>0) {
	if(cn == "All") {
		classes.clear();
		for(int j = 0; j<lines1.length;j++) {
		List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
		classes.add(note1.get(0).toString());
		}}
	else {
		classes.clear();
		classes.add(TestBox.getShortName(cn, c));
	}
		}else {
			classes.clear();
		}
	

		File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");

		aws.downloadContent(file11.getPath());
		FileReader fr11;
		try {
			fr11 = new FileReader(file11);
		
		
		BufferedReader br11 = new BufferedReader(fr11);
		Object[] lines11 = Home.loadActiveStudents(file11.getPath());
		
		if(lines11.length>0) {
	if(n == "All") {
		students.clear();
	
	
	
	for(int j = 0; j<lines11.length;j++) {
	List note1 = Arrays.asList(lines11[j].toString().trim().split("//"));
	students.add(note1.get(0).toString());
	}
	}
else {
	students.clear();
	students.add(n);
}}else {
	students.clear();
}
	
	
	if(t == "Toute l'annee") {
		terms.clear();
	
	terms.add("1er Trimestre");
	terms.add("2eme Trimestre");
	terms.add("3eme Trimestre");
	}
else {
	terms.clear();
	terms.add(t);
}

	if(!students.isEmpty()) {
		for(int l = 0; l<terms.toArray().length;l++) {
			for(int j = 0; j<classes.toArray().length;j++) {
				for(int k = 0; k<students.toArray().length;k++) {
		

		int tests = 0;
		int missedTests = 0;
				File file111 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/"+students.get(k).toString()+"/"+terms.get(l).toString()+"/"+classes.get(j).toString()+".txt");

				aws.downloadContent(file111.getPath());
					FileReader fr111;
					try {
						fr111 = new FileReader(file111);
					
					
					BufferedReader br111 = new BufferedReader(fr111);
					Object []lines = br111.lines().toArray();
					
					for(int k1 = 1; k1<lines.length; k1++) {
						List l1 = Arrays.asList(lines[k1].toString().trim().split("//"));
						if(l1.get(1).toString().equals("0/0")) {
							missedTests++;
						}else {
							tests++;
						}
					}
					
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					studentTests.add(classes.get(j).toString()+"//"+String.valueOf(tests)+"//"+missedTests);
					
	}}}}
	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return studentTests;
	}

public static void loadAllTests() {
	
	List t = getStudentTests(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
			, StatsPane.course.getText(), StatsPane.Term.getText().toString());
	
	List t1 = getMissedTests(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
			, StatsPane.course.getText(), StatsPane.Term.getText().toString());
	
	for(int i = 0; i< t1.toArray().length;i++) {
		List tests = Arrays.asList(t1.get(i).toString().split("//"));
		
		if(!t1.isEmpty()) {
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(40, 40, 40));
		panel_6.setPreferredSize(new Dimension(400, 25));
		panel_11.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(tests.get(0).toString());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEADING);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 0, 200, 25);
		panel_6.add(lblNewLabel_1);
		
		JLabel p1 = new JLabel(tests.get(1).toString());
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setForeground(Color.WHITE);
		p1.setFont(new Font("Roboto", Font.PLAIN, 15));
		p1.setBounds(90, 0, 250, 25);
		panel_6.add(p1);
		
		JLabel p11 = new JLabel("Interro no "+tests.get(2).toString());
		p11.setHorizontalAlignment(SwingConstants.CENTER);
		p11.setForeground(Color.WHITE);
		p11.setFont(new Font("Roboto", Font.PLAIN, 15));
		p11.setBounds(270, 0, 143, 25);
		panel_6.add(p11);
		}}
		
	for(int i = 0; i< t.toArray().length;i++) {
		List tests = Arrays.asList(t.get(i).toString().split("//"));
		
		if(!tests.get(1).toString().equals("0")) {
		JPanel panel_61 = new JPanel();
		panel_61.setBackground(new Color(40, 40, 40));
		panel_61.setPreferredSize(new Dimension(400, 25));
		panel_13.add(panel_61);
		panel_61.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel(TestBox.getFullName(tests.get(0).toString(), StatsPane.className.getText().toString()));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEADING);
		lblNewLabel_11.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(10, 0, 270, 25);
		panel_61.add(lblNewLabel_11);
		
		JLabel p1 = new JLabel(tests.get(1).toString());
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setForeground(Color.WHITE);
		p1.setFont(new Font("Roboto", Font.PLAIN, 17));
		p1.setBounds(270, 0, 143, 25);
		panel_61.add(p1);
		}
		
	}
	
}


	
public static List<String> getStudentExamStats(String n, String c, String cn, String t, String firstDate, String lastDate) {
		
		String percentage = "0";
		String points = "0/0";
		String Tests = "0";
		String Echecs = "0";
		String missed = "0";
		List <String>stats = new ArrayList();
			
			Double sum = (double) 0;
			Double sum1 = (double) 0;
			Double tot = (double) 0;
			Double tot1 = (double) 0;
			int test = 0;
			int tests = 0;
			int missedTests = 0;
			boolean echec = false;
			int echecs = 0;
			Object[] lines1 = null;
			List <String>classes = new ArrayList();
			List <String>students = new ArrayList();
			List <String>terms = new ArrayList();
			
				if(cn.equals("All")) {
					classes.clear();
				File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Courses.txt");

				aws.downloadContent(file1.getPath());
					FileReader fr1;
					try {
						fr1 = new FileReader(file1);
					
					
					BufferedReader br1 = new BufferedReader(fr1);
					lines1 = Home.loadActiveCourses(file1.getPath());
					for(int j = 0; j<lines1.length;j++) {
					List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
					classes.add(note1.get(0).toString());
					}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				else {
					classes.clear();
					classes.add(TestBox.getShortName(cn, c));
				}
				
				if(n.equals("All")) {
					students.clear();
					
					File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");

					aws.downloadContent(file11.getPath());
					FileReader fr11;
					try {
						fr11 = new FileReader(file11);
					
					
					BufferedReader br11 = new BufferedReader(fr11);
					Object[] lines11 = Home.loadActiveStudents(file11.getPath());
					for(int j = 0; j<lines11.length;j++) {
					List note1 = Arrays.asList(lines11[j].toString().trim().split("//"));
					students.add(note1.get(0).toString());
					}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				else {
					students.clear();
					students.add(n);
				}
					if(t == "Toute l'annee") {
						terms.clear();
					
					terms.add("1er Trimestre");
					terms.add("2eme Trimestre");
					terms.add("3eme Trimestre");
					}
				else {
					terms.clear();
					terms.add(t);
				}
					

					String firstTerm = "";
					String lastTerm = "";
					
					if(terms.toArray().length>1) {
						for(int i = 0; i<terms.toArray().length; i++) {
							if(termHasTests(c, terms.get(i).toString())) {
								firstTerm = terms.get(i).toString();
								break;
					}
							}
						for(int i = terms.toArray().length-1; i>=0; i--) {
							if(termHasTests(c, terms.get(i).toString())) {
								lastTerm = terms.get(i).toString();
								break;
					}
					}
					}else {
						firstTerm = t;
						lastTerm = t;
					}
					
					if(!firstTerm.equals("")&& !lastTerm.equals("")) {
						if(classes.toArray().length>1) {
							String firstTestInTerm = "0";
							String lastTestInTerm = "0";
							for(int i = 0; i< classes.toArray().length; i++) {
								
								if(CourseStats.courseHasExams(classes.get(i).toString(), c, lastTerm) || CourseStats.courseHasExams(classes.get(i).toString(), c, firstTerm)) {
								String coursefirstDate = getExamDate(c, classes.get(i).toString(), lastTerm);
								String courselastDate = getExamDate(c, classes.get(i).toString(), firstTerm);
								
								 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								 Date d1 = null;
								 Date d2 = null;
								 Date d3 = null;
								 Date d4 = null;
								try {
									System.out.println(coursefirstDate);
									d1 = df.parse(coursefirstDate);
									d2 = df.parse(courselastDate);
									if(!firstTestInTerm.equals("0")&&!lastTestInTerm.equals("0")) {
									d3 = df.parse(firstTestInTerm);
									d4 = df.parse(lastTestInTerm);
									}else {
										d3 = df.parse(coursefirstDate);
										d4 = df.parse(courselastDate);
									}
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								
								Calendar c1 = Calendar.getInstance();
								Calendar c2 = Calendar.getInstance();
								Calendar c3 = Calendar.getInstance();
								Calendar c4 = Calendar.getInstance();
								c1.setTime(d1);
								c2.setTime(d2);
								c3.setTime(d3);
								c4.setTime(d4);
								
								if(!firstTestInTerm.equals("0")){
								if(c1.before(c3)) {
									firstTestInTerm = coursefirstDate;
								}
								}else {
									firstTestInTerm = coursefirstDate;
								}

								if(!lastTestInTerm.equals("0")){
								if(c2.after(c4)) {
									lastTestInTerm = courselastDate;
								}}else {
									lastTestInTerm = courselastDate;
								}
							}
							}
							if(firstDate.equals("All")) {
							firstDate = firstTestInTerm;
							}if(lastDate.equals("All")) {
							lastDate = lastTestInTerm;
						}}
						

					if(!terms.isEmpty()&& !classes.isEmpty() && !students.isEmpty()) {
						for(int l = 0; l<terms.toArray().length;l++) {
							for(int j = 0; j<classes.toArray().length;j++) {
								for(int k = 0; k<students.toArray().length;k++) {
						

					
					File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/"+students.get(k).toString()+"/"+terms.get(l).toString()+"/"+classes.get(j).toString()+".txt");

					aws.downloadContent(file.getPath());
						try {

							FileReader fr = new FileReader(file);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines = br.lines().toArray();
						
							if(!lines[0].equals("0")) {
								
								
								if(classes.toArray().length==1) {
									if(firstDate.equals("All")) {
										firstDate = getExamDate(c, classes.get(j).toString(), lastTerm);
									}
									if(lastDate.equals("All")) {
										lastDate = getExamDate(c, classes.get(j).toString(), firstTerm);
									}}
									//System.out.println(firstDate+"--"+lastDate);
									 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
									 Date d1 = null;
									 Date d2 = null;
									try {
										d1 = df.parse(firstDate);
										d2 = df.parse(lastDate);
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} 
									
									Calendar c1 = Calendar.getInstance();
									Calendar c2 = Calendar.getInstance();
									c1.setTime(d1);
									c2.setTime(d2);
									
									
									
								tot = (double) 0;
								tot1 = (double) 0;
								test = 0;
							
								List <String>note1 = new ArrayList();
								if(lines[0].toString().contains("//")) {
							note1 = Arrays.asList(lines[0].toString().trim().split("//"));
								}else {
									note1 = Arrays.asList(lines[0].toString());
								}
								
							for(int i = 0; i<note1.toArray().length; i++) {

								

								
								 SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
								 Date d3 = null;
								try {
									d3 = df1.parse(getExamDate(c, classes.get(j).toString(), terms.get(l).toString()));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								
								Calendar c3 = Calendar.getInstance();
								c3.setTime(d3);
								

								if(c3.after(c1) && c3.before(c2) || c3.equals(c1) && c3.before(c2) || c3.after(c1) && c3.equals(c2) || c3.equals(c1)&& c3.equals(c2)) {
									
							List note = Arrays.asList(note1.get(i).toString().trim().split("/"));
							Double d = Double.parseDouble((String) note.get(0));
							Double e = Double.parseDouble((String) note.get(1));
							

							tot = tot+ d;
							tot1 = tot1+e;
							if(e==0 && d==0) {
								test = test+0;
								missedTests = missedTests+1;
							}else {
								test++;
								missedTests = missedTests+0;
							}
								
							}}
							sum = sum+tot;
							sum1 = sum1+tot1;
							
							}else {
								test = 0;
							}

							
							
							
								if(tot<(tot1/2)) {
								echec = true;
							}else {
								echec = false;
							}
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
						tests = tests+test;
						if(echec) {
						echecs = echecs+1;
						}else {
							echecs = echecs+0;
						}	
						if(sum==0 && sum1==0) {
							points = "0/0";
						}else {
							points =new DecimalFormat("##.##").format(sum)+"/"+new DecimalFormat("##.##").format(sum1);
						}
						Tests=String.valueOf(tests);
						
						Double percent = sum/sum1*100;
						if(sum==0 && sum1==0) {
							percentage ="0%";
						}else {
							percentage = new DecimalFormat("##.##").format(percent)+"%";
						}
						Echecs = String.valueOf(echecs);
						missed = String.valueOf(missedTests);
				}
							}}}
					}
		stats.add(percentage);
		stats.add(points);
		stats.add(Tests);
		stats.add(Echecs);
		stats.add(missed);
		
		return stats;
		
	}
	
	
	
	
	 private static XYDataset createDataset() {

		 List progress = getStudentProgression(StatsPane.name.getText().toString(), StatsPane.className.getText()
					, StatsPane.course.getText(), StatsPane.Term.getText().toString(), "All", "All");

		 System.out.println(StatsPane.name.getText().toString()+": "+progress);
	        TimeSeries series = new TimeSeries("2019");

		 for(int i = 0; i<progress.toArray().length; i++) {
			 List l = Arrays.asList(progress.get(i).toString().split("//"));
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d1 = null;
		try {
			d1 = df.parse(l.get(0).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	        series.addOrUpdate(new Day(d1), Double.parseDouble(l.get(1).toString()));
	    }
	        TimeSeriesCollection dataset = new TimeSeriesCollection();
	        dataset.addSeries(series);
	        return dataset;
	        }

	    private static JFreeChart createChart(XYDataset dataset) {

	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Progression",
	                "Date",
	                "Performances(en %)",
	                dataset,
	                PlotOrientation.VERTICAL,
	                false,
	                true,
	                false
	        );
	        
			  XYPlot plot = chart.getXYPlot();
			  DateAxis axis = new DateAxis();
			  axis.setAxisLinePaint(Color.white);
			  plot.setOutlinePaint(Color.white);
			  plot.setDomainGridlinePaint(Color.white);
			  plot.getRangeAxis().setAxisLinePaint(Color.white);
			  plot.setDomainAxis(axis);
			  axis.setDateFormatOverride(new SimpleDateFormat("dd/MM/yyyy"));

			  plot.getDomainAxis().setLabel("Duree");

			  plot.getDomainAxis().setTickLabelPaint(Color.LIGHT_GRAY);
			  plot.getDomainAxis().setTickLabelFont(new Font("Roboto", Font.PLAIN, 15));
			  plot.getDomainAxis().setLabelPaint(Color.white);
			  plot.getDomainAxis().setLabelFont(new Font("Roboto", Font.PLAIN, 18));
			  plot.getRangeAxis().setTickLabelPaint(Color.LIGHT_GRAY);
			  plot.getRangeAxis().setTickLabelFont(new Font("Roboto", Font.PLAIN, 15));
			  plot.getRangeAxis().setLabelPaint(Color.white);
			  plot.getRangeAxis().setLabelFont(new Font("Roboto", Font.PLAIN, 18));
			  
			  var renderer = new XYLineAndShapeRenderer(); 
			  renderer.setSeriesPaint(0, Color.WHITE);
			  renderer.setSeriesStroke(0, new BasicStroke(2.0f));
			  
			  plot.setRenderer(renderer);
			  plot.setBackgroundPaint(Color.DARK_GRAY);
			  
			  plot.setRangeGridlinesVisible(true); plot.setRangeGridlinePaint(Color.WHITE);
			  
			  plot.setDomainGridlinesVisible(true);
			  plot.setDomainGridlinePaint(Color.WHITE);
			 

	       // chart.getLegend().setFrame(BlockBorder.NONE);

			  
	        chart.setTitle(new TextTitle("Progression",
	        		new Font("Roboto", Font.BOLD, 18)
	                )
	        );
			  chart.getTitle().setPaint(Color.white);

	        return chart;
	    }
	    
	    public static int getNumberOfechecs(String studentName, String className, String term, String start, String end) {

	    	int echec = 0;
	    	
	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Courses.txt");

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = Home.loadActiveCourses(file1.getPath());
			
	    	
			for(int i = 0; i<lines1.length;i++) {
	    	List course = Arrays.asList(lines1[i].toString().split("//"));
				
	    	

			List<String> l = new ArrayList();
			l.add("0");
			l.add("0/0");
			List<String> l1 = new ArrayList();
			l1.add("0");
			l1.add("0/0");
			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
		    	l = getStudentTestsStats(studentName, className
						, course.get(1).toString(), term, start, end);}

			if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			 l1 = getStudentExamStats(studentName, className
						, course.get(1).toString(), term, start, end);
				}
			
			List<String> note = Arrays.asList(l.get(1).toString().split("/"));
			List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
			
			
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			
			if(Double.parseDouble(new DecimalFormat("##.##").format(points1).replaceAll(",", "."))<(Double.parseDouble(new DecimalFormat("##.##").format(maxima).replaceAll(",", "."))/2)) {
			echec++;
			}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    	return echec;
	    }
	    
	    public static void echecs() {
	    	
	    	
	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+StatsPane.className.getText().toString()+"/Courses.txt");

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = Home.loadActiveCourses(file1.getPath());
			
	    	
			for(int i = 0; i<lines1.length;i++) {
	    	List course = Arrays.asList(lines1[i].toString().split("//"));
				
	    	List l = getStudentTestsStats(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
					, course.get(1).toString(), StatsPane.Term.getText().toString(), "All", "All");
	    	
			List l1 = getStudentExamStats(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
					, course.get(1).toString(), StatsPane.Term.getText().toString(), "All", "All");
			
			List<String> note = Arrays.asList(l.get(1).toString().split("/"));
			List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
			
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			
			if(Double.parseDouble(new DecimalFormat("##.##").format(points1).replaceAll(",", "."))<(Double.parseDouble(new DecimalFormat("##.##").format(maxima).replaceAll(",", "."))/2)) {
				
				JPanel panel_6 = new JPanel();
				panel_6.setBackground(new Color(40, 40, 40));
				panel_6.setPreferredSize(new Dimension(400, 25));
				panel_6.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel(course.get(1).toString());
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEADING);
				lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setBounds(10, 0, 250, 25);
				panel_6.add(lblNewLabel_1);
				
				if(course.get(1).toString().equals(StatsPane.course.getText())) {
					panel_6.setBackground(new Color(20, 148, 198));
				}
				
				String echec = new DecimalFormat("##.##").format(maxima/2-points1).replaceAll(",", ".");
				JLabel p1 = new JLabel(new DecimalFormat("##.##").format(points1).replaceAll(",", ".")+"/"+new DecimalFormat("##.##").format(maxima)+" ("+echec+"pts)");
				p1.setHorizontalAlignment(SwingConstants.CENTER);
				p1.setForeground(Color.WHITE);
				p1.setFont(new Font("Roboto", Font.PLAIN, 17));
				p1.setBounds(250, 0, 143, 25);
				panel_6.add(p1);
				

				panelEchecs.add(panel_6);
			}
			}
			((JLabel) panelEchecs.getParent().getComponent(0)).setText(String.valueOf(panelEchecs.getComponentCount()));
			
			for(int i = 0; i< panelEchecs.getComponentCount(); i++) {
				if(((JLabel) ((Container) panelEchecs.getComponent(i)).getComponent(1)).getText().equals(StatsPane.course.getText())) {
				panelEchecs.getComponent(i).setBackground(new Color(20, 148, 198));
			}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
	    
	    
	    public static String getEchecsInPoints(String name, String className, String courseName,  String term, String start, String end) {

	    	
				
	    	List l = getStudentTestsStats(name, className
					, courseName, term, start, end);
	    	
			List l1 = getStudentExamStats(name, className
					, courseName, term, start, end);
			
			List<String> note = Arrays.asList(l.get(1).toString().split("/"));
			List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
			
			
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			
			String echec = "0";
			if(Double.parseDouble(new DecimalFormat("##.##").format(points1).replaceAll(",", "."))<(Double.parseDouble(new DecimalFormat("##.##").format(maxima).replaceAll(",", "."))/2)) {
				
				echec = new DecimalFormat("##.##").format(maxima/2-points1).replaceAll(",", ".");
			}

			return echec;
	    }
	    
	    
	    public static void rankStudentPerformances(String s) {
	    	
	    	panel1.removeAll();
	    	panel11.removeAll();
	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+s+"/Courses.txt");
	    	int number = 0;
			

			List<Double> percent = new ArrayList<Double>();
			List<Double> percent1 = new ArrayList<Double>();

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = Home.loadActiveCourses(file1.getPath());
			number = lines1.length;
			
			if(lines1.length>0) {
			
			for(int i = 0; i<lines1.length;i++) {
				List c = Arrays.asList(lines1[i].toString().split("//"));
				
			List l = getStudentTestsStats(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
					, c.get(1).toString(), StatsPane.Term.getText().toString(), "All", "All");
			List l1 = getStudentExamStats(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
					, c.get(1).toString(), StatsPane.Term.getText().toString(), "All", "All");
			
			List<String> note = Arrays.asList(l.get(1).toString().split("/"));
			List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
			
			Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
			Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
			
			Double percentage;
			if(points1 != 0 && maxima != 0) {
			percentage = points1*100/maxima;
			}else {
				percentage = (double) 0;
			}
			percent.add((percentage));
			percent1.add(Double.parseDouble(percent.get(i).toString())+(Double.parseDouble(String.valueOf(i))*1/100));
			
			}}
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Collections.sort(percent, Collections.reverseOrder());
			Collections.sort(percent1, Collections.reverseOrder());
		

			List t1 = getStudentTests(StatsPane.name.getText().toString(), StatsPane.className.getText().toString()
					, "All", StatsPane.Term.getText().toString());
			
			for(int i = 0; i<percent.toArray().length;i++) {

				JPanel panel_6 = new JPanel();
				panel_6.setBackground(new Color(40, 40, 40));
				panel_6.setPreferredSize(new Dimension(400, 25));
				panel1.add(panel_6);
				panel_6.setLayout(null);
				

				JLabel lblNewLabel_1 = new JLabel();
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setBounds(0, 0, 40, 25);
				panel_6.add(lblNewLabel_1);
				
				JLabel lblNewLabel_11 = new JLabel();
				lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEADING);
				lblNewLabel_11.setFont(new Font("Roboto", Font.PLAIN, 17));
				lblNewLabel_11.setForeground(new Color(255, 255, 255));
				lblNewLabel_11.setBounds(50, 0, 270, 25);
				panel_6.add(lblNewLabel_11);
				
				p1 = new JLabel();
				p1.setHorizontalAlignment(SwingConstants.CENTER);
				p1.setForeground(Color.WHITE);
				p1.setFont(new Font("Roboto", Font.PLAIN, 17));
				p1.setBounds(290, 0, 143, 25);
				panel_6.add(p1);
				
				panel1.add(panel_6);
				panel1.revalidate();
				panel1.repaint();
				
				
				
				JPanel panel_61 = new JPanel();
				panel_61.setBackground(new Color(40, 40, 40));
				panel_61.setPreferredSize(new Dimension(400, 25));
				panel_61.setLayout(null);
				

				JLabel lblNewLabel_111 = new JLabel();
				lblNewLabel_111.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_111.setFont(new Font("Roboto", Font.PLAIN, 17));
				lblNewLabel_111.setForeground(new Color(255, 255, 255));
				lblNewLabel_111.setBounds(0, 0, 40, 25);
				panel_61.add(lblNewLabel_111);
				
				JLabel lblNewLabel_1111 = new JLabel();
				lblNewLabel_1111.setHorizontalAlignment(SwingConstants.LEADING);
				lblNewLabel_1111.setFont(new Font("Roboto", Font.PLAIN, 17));
				lblNewLabel_1111.setForeground(new Color(255, 255, 255));
				lblNewLabel_1111.setBounds(50, 0, 270, 25);
				panel_61.add(lblNewLabel_1111);
				
				p1 = new JLabel();
				p1.setHorizontalAlignment(SwingConstants.CENTER);
				p1.setForeground(Color.WHITE);
				p1.setFont(new Font("Roboto", Font.PLAIN, 17));
				p1.setBounds(290, 0, 143, 25);
				panel_61.add(p1);
				
				panel11.add(panel_61);
				panel11.revalidate();
				panel11.repaint();

				System.out.println(Math.round((percent1.get(i)-percent.get(i))*100));
				System.out.println((percent));
				System.out.println((percent1));
			}
				
			
			for(int i = 0; i<panel1.getComponentCount(); i++) {
				List tests = Arrays.asList(t1.get((int) Math.round((percent1.get(i)-percent.get(i))*100)).toString().split("//"));
				((JLabel) ((Container) panel1.getComponent(i)).getComponent(2)).setText(new DecimalFormat("##.##").format(percent.get(i)).toString()+"%");
				((JLabel) ((Container) panel1.getComponent(i)).getComponent(0)).setText(String.valueOf(i+1));
				((JLabel) ((Container) panel1.getComponent(i)).getComponent(1)).setText(TestBox.getFullName(tests.get(0).toString(), s));
				
				if(((JLabel) ((Container) panel1.getComponent(i)).getComponent(1)).getText().equals(StatsPane.course.getText())) {
					panel1.getComponent(i).setBackground(new Color(20, 148, 198));
				}
			}
			
			for(int i = number-1; i>9; i--) {
				panel1.remove(i);
			}
			
			for(int i = panel11.getComponentCount()-1; i>-1; i--) {

				List tests = Arrays.asList(t1.get((int) Math.round((percent1.get(i)-percent.get(i))*100)).toString().split("//"));
				((JLabel) ((Container) panel11.getComponent(panel11.getComponentCount()-1-i)).getComponent(2)).setText(new DecimalFormat("##.##").format(percent.get(i)).toString()+"%");
				((JLabel) ((Container) panel11.getComponent(i)).getComponent(0)).setText(String.valueOf(i+1));
				((JLabel) ((Container) panel11.getComponent(panel11.getComponentCount()-1-i)).getComponent(1)).setText(TestBox.getFullName(tests.get(0).toString(), s));

				if(((JLabel) ((Container) panel11.getComponent(panel11.getComponentCount()-1-i)).getComponent(1)).getText().equals(StatsPane.course.getText())) {
					panel11.getComponent(panel11.getComponentCount()-1-i).setBackground(new Color(20, 148, 198));
					
				}
			}
			((JLabel) panel1.getParent().getComponent(0)).setText(TestBox.getShortName(((JLabel) ((JComponent) panel1.getComponent(0)).getComponent(1)).getText(), s));
			((JLabel) panel11.getParent().getComponent(0)).setText(TestBox.getShortName(((JLabel) ((JComponent) panel11.getComponent(0)).getComponent(1)).getText(), s));
			
	    
			for(int i = number-1; i>9; i--) {
				panel11.remove(i);
			}
	    }
	
	    
	    
	    public static List<String> getFirstAndLastTestDate(String className, String term1, String term2) {

	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Test List/"+term1+"/TestList.txt");

			List <String>l = new ArrayList();
	    	String date1 = null;
	    	String date2 = null;
			List <String>comp = new ArrayList();
			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i< lines1.length; i++) {
			List note1 = Arrays.asList(lines1[i].toString().trim().split("//"));
			List note2 = Arrays.asList(note1.get(4).toString().trim().split("/"));
			comp.add(note2.get(2).toString()+"/"+note2.get(1).toString()+"/"+note2.get(0).toString());
			}
					Collections.sort(comp);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			date1 = comp.get(0);
			l.add(date1);
			
			
			List <String>comp1 = new ArrayList();
			File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Test List/"+term2+"/TestList.txt");

			aws.downloadContent(file11.getPath());
			FileReader fr11;
			try {
				fr11 = new FileReader(file11);
			
			
			BufferedReader br11 = new BufferedReader(fr11);
			Object[] lines11 = br11.lines().toArray();
			for(int i = 0; i< lines11.length; i++) {
			List note1 = Arrays.asList(lines11[i].toString().trim().split("//"));
			List note2 = Arrays.asList(note1.get(4).toString().trim().split("/"));
			comp1.add(note2.get(2).toString()+"/"+note2.get(1).toString()+"/"+note2.get(0).toString());
			}
					Collections.sort(comp1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			date2 = comp1.get(comp1.toArray().length-1);
			
			l.add(date2);

			return l;
	    }
	    
	    
	    public static boolean termHasTests(String className, String term) {
	    	
	    	boolean hasIt = false;
	    	List terms = new ArrayList();
	    	if(term.equals("Toute l'annee")) {
	    		terms.add("1er Trimestre");
	    		terms.add("2eme Trimestre");
	    		terms.add("3eme Trimestre");
	    	}else {
	    		terms.add(term);
	    	}
	    	for(int i = 0; i< terms.toArray().length; i++) {
	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Test List/"+terms.get(i)+"/TestList.txt");

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			
			if(lines1.length>0) {
				hasIt = true;
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
	    	return hasIt;
	    	
	    }
	    
	    public static List<String> getFirstAndLastExamDate(String className, String term1, String term2) {

	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Exam List/"+term1+"/ExamList.txt");

			List <String>l = new ArrayList();
	    	String date1 = null;
	    	String date2 = null;
			List <String>comp = new ArrayList();

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i< lines1.length; i++) {
			List note1 = Arrays.asList(lines1[i].toString().trim().split("//"));
			List note2 = Arrays.asList(note1.get(3).toString().trim().split("/"));
			comp.add(note2.get(2).toString()+"/"+note2.get(1).toString()+"/"+note2.get(0).toString());
			}
					Collections.sort(comp);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			date1 = comp.get(0);
			
			
			List <String>comp1 = new ArrayList();
			File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Exam List/"+term1+"/ExamList.txt");

			aws.downloadContent(file11.getPath());
			FileReader fr11;
			try {
				fr11 = new FileReader(file11);
			
			
			BufferedReader br11 = new BufferedReader(fr11);
			Object[] lines11 = br11.lines().toArray();
			for(int i = 0; i< lines11.length; i++) {
			List note1 = Arrays.asList(lines11[i].toString().trim().split("//"));
			List note2 = Arrays.asList(note1.get(3).toString().trim().split("/"));
			comp1.add(note2.get(2).toString()+"/"+note2.get(1).toString()+"/"+note2.get(0).toString());
			}
					Collections.sort(comp1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			date2 = comp1.get(comp1.toArray().length-1);
			
			l.add(date2);

			return l;
	    }
	    
	    
	    public static String getTestDate(String className, String courseName, String number, String term) {

	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Test List/"+term+"/TestList.txt");
			
	    	String date = null;

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int j = 0; j<lines1.length;j++) {
			List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
			
			if(note1.get(1).toString().equals(courseName)) {
				if(note1.get(3).equals(number)) {
					date = note1.get(4).toString();
					break;
				}
			}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	

			return date;
	    }
	    
	    
	    public static String getExamDate(String className, String courseName, String term) {

	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Exam List/"+term+"/ExamList.txt");

			aws.downloadContent(file1.getPath());
	    	String date = null;
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int j = 0; j<lines1.length;j++) {
			List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
			
			if(note1.get(0).toString().equals(courseName)) {
					date = note1.get(3).toString();
			}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return date;
	    }
	    
	    public static String getLastTestNumber(String className, String courseName, String term) {


	    	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Test List/"+term+"/TestList.txt");
			int number = 0;

			aws.downloadContent(file1.getPath());
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int j = 0; j<lines1.length;j++) {
			List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
			
			if(note1.get(1).toString().equals(courseName)) {
					number++;
			}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	

			return String.valueOf(number);
	    
	    }
	    

		
public static List<String> getMissedTests(String n, String c, String cn, String t) {
		
		List <String>missedTests = new ArrayList();
		
			
			Object[] lines1 = null;
			List <String>Courses = new ArrayList();
			List <String>students = new ArrayList();
			List <String>terms = new ArrayList();
			
				if(cn == "All") {
					Courses.clear();
				File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Courses.txt");

				aws.downloadContent(file1.getPath());
					FileReader fr1;
					try {
						fr1 = new FileReader(file1);
					
					
					BufferedReader br1 = new BufferedReader(fr1);
					lines1 = Home.loadActiveCourses(file1.getPath());
					for(int j = 0; j<lines1.length;j++) {
					List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
					Courses.add(note1.get(0).toString());
					}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				else {
					Courses.clear();
					Courses.add(TestBox.getShortName(cn, c));
				}if(n == "All") {
					students.clear();
					
					File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");

					aws.downloadContent(file11.getPath());
					FileReader fr11;
					try {
						fr11 = new FileReader(file11);
					
					
					BufferedReader br11 = new BufferedReader(fr11);
					Object[] lines11 = Home.loadActiveStudents(file11.getPath());
					for(int j = 0; j<lines11.length;j++) {
					List note1 = Arrays.asList(lines11[j].toString().trim().split("//"));
					students.add(note1.get(0).toString());
					}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				else {
					students.clear();
					students.add(StatsPane.name.getText());
				}
					if(t == "Toute l'annee") {
						terms.clear();
					
					terms.add("1er Trimestre");
					terms.add("2eme Trimestre");
					terms.add("3eme Trimestre");
					}
				else {
					terms.clear();
					terms.add(StatsPane.Term.getText());
				}

					if(!terms.isEmpty()&& !Courses.isEmpty() && !students.isEmpty()) {
						for(int l = 0; l<terms.toArray().length;l++) {
							for(int j = 0; j<Courses.toArray().length;j++) {
								for(int k = 0; k<students.toArray().length;k++) {

									String missed ;

					
					File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/"+students.get(k).toString()+"/"+terms.get(l).toString()+"/"+Courses.get(j).toString()+".txt");

					aws.downloadContent(file.getPath());
						try {

							FileReader fr = new FileReader(file);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines = br.lines().toArray();
						
								
								
							for(int i = 1; i<lines.length; i++) {
								List l1 = Arrays.asList(lines[i].toString().trim().split("//"));
								if(l1.get(1).toString().equals("0/0")) {

									missed = terms.get(l).toString()+"//"+Courses.get(j).toString()+"//"+ String.valueOf(i);
									missedTests.add(missed);
								}
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
							}}
					}
		
		return missedTests;
		
	}
	    

public static int getNumberOfStudents(String s) {
	
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+s+"/Students.txt");
	int no = 0;

	aws.downloadContent(file1.getPath());
	FileReader fr1;
	try {
		fr1 = new FileReader(file1);
	
	BufferedReader br1 = new BufferedReader(fr1);
	Object[] lines1 = Home.loadActiveStudents(file1.getPath());
	no = lines1.length;
	
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return no;
}
public static List<String> getStudentsFromClass(String className) {
	
	List<String> l = new ArrayList();
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
	int no = 0;

	aws.downloadContent(file1.getPath());
	FileReader fr1;
	try {
		fr1 = new FileReader(file1);
	
	BufferedReader br1 = new BufferedReader(fr1);
	Object[] lines1 = Home.loadActiveStudents(file1.getPath());
	
	for(int i = 0 ; i< lines1.length; i++) {
		List l1 = Arrays.asList(lines1[i].toString().split("//"));
		l.add(l1.get(0).toString());
	}
	
	
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return l;
}











public static List <String> getStudentProgression(String n, String c, String cn, String t, String firstDate, String lastDate) {
		Object[] lines1 = null;
		List <String>classes = new ArrayList();
		List <String>students = new ArrayList();
		List <String>terms = new ArrayList();
		
		List <String> progression = new ArrayList();
		
		

		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Courses.txt");
		aws.downloadContent(file1.getPath());
			
			FileReader fr1;
			try {
				fr1 = new FileReader(file1);
			
			
			BufferedReader br1 = new BufferedReader(fr1);
			lines1 = Home.loadActiveCourses(file1.getPath());
		
			if(lines1.length>0) {
			if(cn == "All") {
				classes.clear();
				for(int j = 0; j<lines1.length;j++) {
				List note1 = Arrays.asList(lines1[j].toString().trim().split("//"));
				classes.add(note1.get(0).toString());
				}
				}
			else {
				classes.clear();
				classes.add(TestBox.getShortName(cn, c));
			}
			}else {
				classes.clear();
			}
			
			
File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/Students.txt");

aws.downloadContent(file11.getPath());
			FileReader fr11;
			try {
				fr11 = new FileReader(file11);
			
			
			BufferedReader br11 = new BufferedReader(fr11);
			Object[] lines11 = Home.loadActiveStudents(file11.getPath());

			if(lines11.length>0) {
			if(n == "All") {
				students.clear();
			
			for(int j = 0; j<lines11.length;j++) {
			List note1 = Arrays.asList(lines11[j].toString().trim().split("//"));
			students.add(note1.get(0).toString());
			}}
		else {
			students.clear();
			students.add(n);
		}}else {
			students.clear();
		}
			
			if(t == "Toute l'annee") {
				terms.clear();
			
			
			terms.add("1er Trimestre");
			terms.add("2eme Trimestre");
			terms.add("3eme Trimestre");
			}
		else {
			terms.clear();
			terms.add(t);
		}
			
			String firstTerm = "";
			String lastTerm = "";
			
			if(terms.toArray().length>1) {
				for(int i = 0; i<terms.toArray().length; i++) {
					if(termHasTests(c, terms.get(i).toString())) {
						firstTerm = terms.get(i).toString();
						break;
			}
					}
				for(int i = terms.toArray().length-1; i>=0; i--) {
					if(termHasTests(c, terms.get(i).toString())) {
						lastTerm = terms.get(i).toString();
						break;
			}
			}
			}else {
				firstTerm = t;
				lastTerm = t;
			}
				if(classes.toArray().length>1) {
					String firstTestInTerm = "0";
					String lastTestInTerm = "0";
					for(int i = 0; i< classes.toArray().length; i++) {
						
						if(CourseStats.courseHasTests(classes.get(i).toString(), c, lastTerm) || CourseStats.courseHasTests(classes.get(i).toString(), c, firstTerm)) {
						String coursefirstDate = getTestDate(c, classes.get(i).toString(), "1", lastTerm);
						
						String courselastDate = getTestDate(c, classes.get(i).toString(), getLastTestNumber(c, classes.get(i).toString(), firstTerm), firstTerm);
						
						 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						 Date d1 = null;
						 Date d2 = null;
						 Date d3 = null;
						 Date d4 = null;
						try {
							d1 = df.parse(coursefirstDate);
							d2 = df.parse(courselastDate);
							if(!firstTestInTerm.equals("0")&&!lastTestInTerm.equals("0")) {
							d3 = df.parse(firstTestInTerm);
							d4 = df.parse(lastTestInTerm);
							}else {
								d3 = df.parse(coursefirstDate);
								d4 = df.parse(courselastDate);
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						
						Calendar c1 = Calendar.getInstance();
						Calendar c2 = Calendar.getInstance();
						Calendar c3 = Calendar.getInstance();
						Calendar c4 = Calendar.getInstance();
						c1.setTime(d1);
						c2.setTime(d2);
						c3.setTime(d3);
						c4.setTime(d4);
						
						if(!firstTestInTerm.equals("0")){
						if(c1.before(c3)) {
							firstTestInTerm = coursefirstDate;
						}
						}else {
							firstTestInTerm = coursefirstDate;
						}

						if(!lastTestInTerm.equals("0")){
						if(c2.after(c4)) {
							lastTestInTerm = courselastDate;
						}}else {
							lastTestInTerm = courselastDate;
						}
					}
					}
					if(firstDate.equals("All")) {
					firstDate = firstTestInTerm;
					}if(lastDate.equals("All")) {
					lastDate = lastTestInTerm;
				}}
				
				if(!students.isEmpty()) {
				for(int l = 0; l<terms.toArray().length;l++) {
					for(int j = 0; j<classes.toArray().length;j++) {
						for(int k = 0; k<students.toArray().length;k++) {
							

				
				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+c+"/"+students.get(k).toString()+"/"+terms.get(l).toString()+"/"+classes.get(j).toString()+".txt");

				aws.downloadContent(file.getPath());
					try {

						FileReader fr = new FileReader(file);
						
						BufferedReader br = new BufferedReader(fr);
						Object[] lines = br.lines().toArray();
					
						if(lines.length>1) {
							if(classes.toArray().length==1) {
							if(firstDate.equals("All")) {
								firstDate = getTestDate(c, classes.get(j).toString(), "1", lastTerm);
							}
							if(lastDate.equals("All")) {
								lastDate = getTestDate(c, classes.get(j).toString(), getLastTestNumber(c, classes.get(j).toString(), firstTerm), firstTerm);
							}}
							//System.out.println(firstDate+"--"+lastDate);
							 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							 Date d1 = null;
							 Date d2 = null;
							try {
								d1 = df.parse(firstDate);
								d2 = df.parse(lastDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							
							Calendar c1 = Calendar.getInstance();
							Calendar c2 = Calendar.getInstance();
							c1.setTime(d1);
							c2.setTime(d2);
						
							
						for(int i = 1; i<lines.length; i++) {
						
							 SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
							 Date d3 = null;
							try {
								d3 = df1.parse(getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString()));
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							
							Calendar c3 = Calendar.getInstance();
							c3.setTime(d3);
							
							System.out.println(getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString()));
							System.out.println("Progression starting at "+c1.getTime().getDate()+"/"+(c1.getTime().getMonth()+1)+"/"+(c1.getTime().getYear()+1900)+"---"+c3.getTime().getDate()+"/"+(c3.getTime().getMonth()+1)+"/"+(c3.getTime().getYear()+1900));
							System.out.println("Progression ending at "+c3.getTime().getDate()+"/"+(c3.getTime().getMonth()+1)+"/"+(c3.getTime().getYear()+1900)+"---"+c2.getTime().getDate()+"/"+(c2.getTime().getMonth()+1)+"/"+(c2.getTime().getYear()+1900));
							
							if(c3.after(c1) && c3.before(c2) || c3.equals(c1) && c3.before(c2) || c3.after(c1) && c3.equals(c2) || c3.equals(c1)&& c3.equals(c2)) {
								System.out.println("true");
								List list1 = StudentStats.getStudentTestsStats(students.get(k), c
										,classes.get(j).toString(), "Toute l'annee"
										,getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString()), getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString()));
								List<String> note = Arrays.asList(list1.get(1).toString().split("/"));
								
								Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."));
								Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."));
								
								Double percentage;
								if(points1==0 && maxima==0 ) {
									percentage = 0.00;
								}else {
									percentage = points1*100/maxima;
									progression.add(getTestDate(c, classes.get(j).toString(), String.valueOf(i), terms.get(l).toString())+"//"+percentage);
								}
								
							}}}
						
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
					}
				}}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
return progression;
}


}
