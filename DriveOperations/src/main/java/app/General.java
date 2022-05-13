package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

import Application.Home;
import Class.CustomVerticalScrollBarUI;
import Class.TestBox;
import CloudOperations.aws;
import Stats.CourseStats;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class General extends JPanel {

	public static JPanel panel = new JPanel();
	public static JLabel percentage;
	public static JLabel lblPoints;
	public static JLabel lblTests;
	public static JLabel lblEchecs;
	public static JLabel lblProgress;
	public static JPanel panelPercent;
	public static JPanel panelPoints;
	public static JPanel panelTests;
	public static JPanel panelEchec;
	public static JPanel panelProgress;
	public static boolean hasNext;
	public static boolean hasPrevious;

	/**
	 * Create the panel.
	 */
	public General(String student_in_classroom_id, String classroom_in_ay_id, String term_id) {
		setBackground(new Color(235, 255, 244));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(300, 629));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setBorder(null);
		scrollPane_4.setPreferredSize(new Dimension((int) screensize.getWidth()*33/100,(int) (screensize.getHeight()*82/100*80/100)));
		add(scrollPane_4);
		scrollPane_4.getVerticalScrollBar().setUnitIncrement(10);

		scrollPane_4.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_4.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(300, 10));
		panel_2.setBackground(new Color(25, 25, 25));
		scrollPane_4.setViewportView(panel_2);
		panel_2.setLayout(new WrapLayout(1, 10, 10));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(80, 80, 80));
		
		JLabel lblNewLabel = new JLabel("Total General");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Cliquez sur les barres en dessous pour voir les details de chaque cours</html>");
		lblNewLabel_1.setPreferredSize(new Dimension(300, 30));
		//lblNewLabel_1.setPreferredSize(new Dimension(10, 38));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_1);
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(280, 33));
		panel_2.add(panel_3);
		
		percentage = new JLabel("Pourcentage: 0%");
		percentage.setForeground(Color.WHITE);
		percentage.setHorizontalAlignment(SwingConstants.CENTER);
		percentage.setFont(new Font("Roboto", Font.PLAIN, 16));
		percentage.setBounds(8, 3, 263, 26);
		panel_3.add(percentage);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(7, 33, 265, 80);
		panel_3.add(scrollPane1);
		

		scrollPane1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane1.getVerticalScrollBar().setUnitIncrement(5);
		
		panelPercent = new JPanel();
		panelPercent.setForeground(new Color(255, 255, 255));
		panelPercent.setBackground(panel_2.getBackground());
		scrollPane1.setViewportView(panelPercent);
		panelPercent.setLayout(new WrapLayout(WrapLayout.CENTER,10,6));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(80, 80, 80));
		panel_5.setLayout(null);
		panel_5.setPreferredSize(new Dimension(280, 33));
		panel_2.add(panel_5);
		
		lblPoints = new JLabel("Points: 0/0");
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblPoints.setBounds(8, 3, 263, 26);
		panel_5.add(lblPoints);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(7, 33, 265, 80);
		panel_5.add(scrollPane);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getVerticalScrollBar().setUnitIncrement(5);
		
		panelPoints = new JPanel();
		panelPoints.setForeground(new Color(255, 255, 255));
		panelPoints.setBackground(panel_2.getBackground());
		scrollPane.setViewportView(panelPoints);
		panelPoints.setLayout(new WrapLayout(WrapLayout.LEFT,10,6));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(80, 80, 80));
		panel_6.setLayout(null);
		panel_6.setPreferredSize(new Dimension(280, 33));
		panel_2.add(panel_6);
		
		
		lblTests = new JLabel("Interrogations faites: 0");
		lblTests.setForeground(Color.WHITE);
		lblTests.setHorizontalAlignment(SwingConstants.CENTER);
		lblTests.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblTests.setBounds(8, 3, 263, 26);
		panel_6.add(lblTests);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(7, 33, 265, 80);
		panel_6.add(scrollPane_1);
		

		scrollPane_1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(5);
		
		panelTests = new JPanel();
		panelTests.setForeground(new Color(255, 255, 255));
		panelTests.setBackground(panel_2.getBackground());
		scrollPane_1.setViewportView(panelTests);
		panelTests.setLayout(new WrapLayout(WrapLayout.CENTER,10,6));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(80, 80, 80));
		panel_7.setLayout(null);
		panel_7.setPreferredSize(new Dimension(280, 33));
		panel_2.add(panel_7);
		
		
		lblEchecs = new JLabel("Echecs: 0");
		lblEchecs.setForeground(Color.WHITE);
		lblEchecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecs.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblEchecs.setBounds(8, 3, 263, 26);
		panel_7.add(lblEchecs);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(7, 33, 265, 60);
		panel_7.add(scrollPane_2);
		

		scrollPane_2.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_2.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(5);
		
		panelEchec = new JPanel();
		panelEchec.setForeground(new Color(255, 255, 255));
		panelEchec.setBackground(panel_2.getBackground());
		scrollPane_2.setViewportView(panelEchec);
		panelEchec.setLayout(new WrapLayout(WrapLayout.CENTER,10,6));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(80, 80, 80));
		panel_8.setLayout(null);
		panel_8.setPreferredSize(new Dimension(280, 33));
		panel_2.add(panel_8);
		
		lblProgress = new JLabel("Progression: 0%");
		lblProgress.setForeground(Color.WHITE);
		lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgress.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblProgress.setBounds(8, 3, 263, 26);
		panel_8.add(lblProgress);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(7, 33, 265, 80);
		panel_8.add(scrollPane_3);
		
		

		scrollPane_3.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getVerticalScrollBar().setUnitIncrement(5);
		
		
		panelProgress = new JPanel();
		panelProgress.setForeground(new Color(255, 255, 255));
		panelProgress.setBackground(panel_2.getBackground());
		scrollPane_3.setViewportView(panelProgress);
		panelPoints.setLayout(new WrapLayout(WrapLayout.CENTER,10,6));
		panelProgress.setLayout(new WrapLayout(WrapLayout.CENTER,10,6));
		loadName(student_in_classroom_id);
		totalScore(student_in_classroom_id, classroom_in_ay_id, term_id);
		

		for(int i = 0;i<panel_2.getComponentCount(); i++) {
			int j = i;
			panel_2.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_2.getComponent(j).setBackground(new Color(120, 120, 120));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel_2.getComponent(j).setBackground(new Color(80, 80, 80));
				}
				
			});
		}
		

		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_3.getPreferredSize().equals(new Dimension(280, 33))) {
				panel_3.setPreferredSize(new Dimension(280, 120));
				
				panel_5.setPreferredSize(new Dimension(280, 33));
				panel_6.setPreferredSize(new Dimension(280, 33));
				panel_7.setPreferredSize(new Dimension(280, 33));
				panel_8.setPreferredSize(new Dimension(280, 33));
				
				panel_3.revalidate();
				panel_3.repaint();
				}
				else{
					panel_3.setPreferredSize(new Dimension(280, 33));
					panel_3.revalidate();
					panel_3.repaint();
				}
			}
		});
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_5.getPreferredSize().equals(new Dimension(280, 33))) {
					panel_5.setPreferredSize(new Dimension(280, 120));
					
					panel_3.setPreferredSize(new Dimension(280, 33));
					panel_6.setPreferredSize(new Dimension(280, 33));
					panel_7.setPreferredSize(new Dimension(280, 33));
					panel_8.setPreferredSize(new Dimension(280, 33));
					
					panel_5.revalidate();
					panel_5.repaint();
				}
				else{
					panel_5.setPreferredSize(new Dimension(280, 33));
					panel_5.revalidate();
					panel_5.repaint();
				}
			}
		});
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_6.getPreferredSize().equals(new Dimension(280, 33))) {
					panel_6.setPreferredSize(new Dimension(280, 120));
					
					panel_3.setPreferredSize(new Dimension(280, 33));
					panel_5.setPreferredSize(new Dimension(280, 33));
					panel_7.setPreferredSize(new Dimension(280, 33));
					panel_8.setPreferredSize(new Dimension(280, 33));
					
					panel_6.revalidate();
					panel_6.repaint();
				}
				else{
					panel_6.setPreferredSize(new Dimension(280, 33));
					panel_6.revalidate();
					panel_6.repaint();
				}
			}
		});
		
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_7.getPreferredSize().equals(new Dimension(280, 33))) {
					panel_7.setPreferredSize(new Dimension(280, 100));
					
					panel_3.setPreferredSize(new Dimension(280, 33));
					panel_5.setPreferredSize(new Dimension(280, 33));
					panel_6.setPreferredSize(new Dimension(280, 33));
					panel_8.setPreferredSize(new Dimension(280, 33));
					
					panel_7.revalidate();
					panel_7.repaint();
				}
				else{
					panel_7.setPreferredSize(new Dimension(280, 33));
					panel_7.revalidate();
					panel_7.repaint();
				}
			}
		});
		
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel_8.getPreferredSize().equals(new Dimension(280, 33))) {
					panel_8.setPreferredSize(new Dimension(280, 120));
					
					panel_3.setPreferredSize(new Dimension(280, 33));
					panel_5.setPreferredSize(new Dimension(280, 33));
					panel_6.setPreferredSize(new Dimension(280, 33));
					panel_7.setPreferredSize(new Dimension(280, 33));
					
				panel_8.revalidate();
				panel_8.repaint();
				}
				else{
					panel_8.setPreferredSize(new Dimension(280, 33));
					panel_8.revalidate();
					panel_8.repaint();
				}
			}
		});
		
	}
	
	
	
	public static void loadName(String student_id) {
		/*
		 * File file = new
		 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
		 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+
		 * "/Students.txt"); aws.downloadContent(file.getPath()); FileReader fr; try {
		 * fr = new FileReader(file);
		 * 
		 * 
		 * BufferedReader br = new BufferedReader(fr); Object[] lines =
		 * Home.loadActiveStudents(file.getPath()); List note1;
		 * 
		 * if(App.n<lines.length) { note1 =
		 * Arrays.asList(lines[i].toString().trim().split("//")); }else{ note1 =
		 * Arrays.asList(lines[0].toString().trim().split("//")); }
		 */
		App.name.setText(Home.getStudentName(student_id));
		App.num.setText(App.getStudentNumber(student_id));
		/*
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		if(App.numbers.getComponentCount()>0) {
			for(int j = 0; j<App.numbers.getComponentCount(); j++) {
				App.numbers.getComponent(j).setBackground(new Color(80, 80, 80));
				((Container) App.numbers.getComponent(j)).getComponent(0).setForeground(Color.white);
			}
		App.numbers.getComponent(App.n).setBackground(new Color(20, 148, 198));
		((Container) App.numbers.getComponent(App.n)).getComponent(0).setForeground(Color.white);
	}}
	
	

	
	public static void totalScore(String student_in_classroom_id, String classroom_in_ay_id, String term_id) {
	panelPoints.removeAll();
	panelPercent.removeAll();
	panelTests.removeAll();
	panelEchec.removeAll();
	panelProgress.removeAll();;

	Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
		for(int i = 0; i<lines.length;i++) {
			List l = new ArrayList();
			l.add("0");
			l.add("0/0");
			List<String> l1 = new ArrayList();
			l1.add("0");
			l1.add("0/0");
			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
				l = StudentStats.getStudentTestsStats(student_in_classroom_id, classroom_in_ay_id
						,lines[i].toString(), term_id,"All", "All");
				}

			if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
				l1 = StudentStats.getStudentExamStats(student_in_classroom_id, classroom_in_ay_id
						,lines[i].toString(), term_id,"All", "All");
				}
	List<String> note = Arrays.asList(l.get(1).toString().split("/"));
	List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));

	Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
	Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));

	Double percentage;
	if(points1==0 && maxima==0 ) {
		percentage = 0.00;
	}else {
		percentage = points1*100/maxima;
	}
	if(points1==0 && maxima==0 ) {}
	else {
			JLabel label1 = new JLabel("- "+TestBox.getShortName(lines[i].toString())
					.toUpperCase()+": "+new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima)+"	   ");
					label1.setFont(new Font("Roboto", Font.BOLD, 12));
					label1.setForeground(Color.white);
					panelPoints.add(label1);
					
					
					JLabel label11 = new JLabel("- "+TestBox.getShortName(lines[i].toString())
							.toUpperCase()+": "+new DecimalFormat("##.##").format(percentage)+"%	   ");
							label11.setFont(new Font("Roboto", Font.BOLD, 12));
							label11.setForeground(Color.white);
							panelPercent.add(label11);
							
							
							if(l.toArray().length>2) {
					JLabel label111 = new JLabel("- "+TestBox.getShortName(lines[i].toString())
							.toUpperCase()+": "+((List)l.get(6)).toArray().length+"	   ");
							label111.setFont(new Font("Roboto", Font.BOLD, 12));
							label111.setForeground(Color.white);
							panelTests.add(label111);

							JLabel label = new JLabel("- "+TestBox.getShortName(lines[i].toString())
									.toUpperCase()+": "+l.get(5)+"%	   ");
									label.setFont(new Font("Roboto", Font.BOLD, 12));
									label.setForeground(Color.white);
									panelProgress.add(label);
							}
							
							
							if(percentage<50) {
						JLabel label1111 = new JLabel("- "+TestBox.getShortName(lines[i].toString())
								.toUpperCase()+": "+new DecimalFormat("##.##").format(maxima/2-points1)+"pts    ");
								label1111.setFont(new Font("Roboto", Font.BOLD, 12));
								label1111.setForeground(Color.white);
								panelEchec.add(label1111);
					}}}


		
		List l = new ArrayList();
		l.add("0");
		l.add("0/0");
		List<String> l1 = new ArrayList();
		l1.add("0");
		l1.add("0/0");
		if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
			l = StudentStats.getStudentTestsStats(student_in_classroom_id, classroom_in_ay_id
					,"All", term_id,"All", "All");
			}

		if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			l1 = StudentStats.getStudentExamStats(student_in_classroom_id, classroom_in_ay_id
					,"All", term_id,"All", "All");
			}
List<String> note = Arrays.asList(l.get(1).toString().split("/"));
List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));

Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));

Double percentage;
if(points1==0 && maxima==0 ) {
	percentage = 0.00;
}else {
	percentage = points1*100/maxima;
}
		lblPoints.setText("Points: "+new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
		
		General.percentage.setText("Pourcentage: "+new DecimalFormat("##.##").format(percentage)+"%");
		lblEchecs.setText(String.valueOf("Echecs: "+StudentStats.getNumberOfechecs(student_in_classroom_id, "All",
				classroom_in_ay_id, term_id, "All", "All")));
		if(panelEchec.getComponentCount() == 0) {
			JLabel label = new JLabel("Pas d'echecs");
					label.setFont(new Font("Roboto", Font.BOLD, 12));
					label.setForeground(Color.white);
					panelEchec.add(label);

		}
		if(l.toArray().length>2) {
		lblTests.setText("Interrogations effectuees: "+((List)l.get(6)).toArray().length);
		lblProgress.setText(String.valueOf("Progression: "+new DecimalFormat("##.##").format(Double.parseDouble((String) l.get(5))))+"%");
		}
		}
}
