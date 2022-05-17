package sideInformation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Schedule;
import Class.Course;
import Class.TestBox;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.ScholarYears;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ClassInfo extends JPanel {
	public static JLabel numberOfCourses;
	public static JLabel numberOfStudents;
	public static JLabel percent;
	public static JLabel success;

	/**
	 * Create the panel.
	 */
	public ClassInfo(String className) {
		setBorder(new LineBorder(Color.WHITE, 1, true));
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(400, 614));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(className);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 21, 380, 28);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 70));
		panel.setBackground(new Color(80, 80, 80));
		panel.setBounds(18, 119, 178, 70);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMoyenne = new JLabel("Moyenne %");
		lblMoyenne.setPreferredSize(new Dimension(61, 25));
		lblMoyenne.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyenne.setForeground(Color.WHITE);
		lblMoyenne.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(lblMoyenne, BorderLayout.NORTH);
		
		percent = new JLabel("...");
		percent.setHorizontalAlignment(SwingConstants.CENTER);
		percent.setForeground(Color.WHITE);
		percent.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(percent, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Informations rapides");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(78, 93, 227, 19);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 70));
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setBounds(204, 119, 178, 70);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPoints = new JLabel("Taux de reussite");
		lblPoints.setPreferredSize(new Dimension(61, 25));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_1.add(lblPoints, BorderLayout.NORTH);
		
		success = new JLabel("...");
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setForeground(Color.WHITE);
		success.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_1.add(success, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 70));
		panel_2.setBackground(new Color(80, 80, 80));
		panel_2.setBounds(18, 197, 178, 70);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEchecs = new JLabel("Nombre d'eleves");
		lblEchecs.setPreferredSize(new Dimension(61, 25));
		lblEchecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecs.setForeground(Color.WHITE);
		lblEchecs.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_2.add(lblEchecs, BorderLayout.NORTH);
		
		numberOfStudents = new JLabel("...");
		numberOfStudents.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfStudents.setForeground(Color.WHITE);
		numberOfStudents.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_2.add(numberOfStudents, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(200, 70));
		panel_3.setBackground(new Color(80, 80, 80));
		panel_3.setBounds(204, 197, 178, 70);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEducation = new JLabel("Nombres de cours");
		lblEducation.setPreferredSize(new Dimension(61, 25));
		lblEducation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEducation.setForeground(Color.WHITE);
		lblEducation.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_3.add(lblEducation, BorderLayout.NORTH);
		
		numberOfCourses = new JLabel("...");
		numberOfCourses.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfCourses.setForeground(Color.WHITE);
		numberOfCourses.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_3.add(numberOfCourses, BorderLayout.CENTER);
		
		JLabel lblemePfEconomique = new JLabel("Annee scholaire "+ScholarYears.selectedScholarYear);
		lblemePfEconomique.setHorizontalAlignment(SwingConstants.CENTER);
		lblemePfEconomique.setForeground(new Color(192, 192, 192));
		lblemePfEconomique.setFont(new Font("Futura Hv BT", Font.PLAIN, 18));
		lblemePfEconomique.setBounds(53, 50, 294, 28);
		add(lblemePfEconomique);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setPreferredSize(new Dimension(0, 1));
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 85, 400, 10);
		add(separator);
		
		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommandes.setForeground(Color.LIGHT_GRAY);
		lblCommandes.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCommandes.setBounds(78, 300, 227, 19);
		add(lblCommandes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setPreferredSize(new Dimension(0, 1));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 292, 400, 10);
		add(separator_1);
		
		JButton btnvoirLeleve = new JButton("<html><div style='text-align: center;'>Structure de l'horaire</div></html>");
		btnvoirLeleve.setIconTextGap(0);
		btnvoirLeleve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnvoirLeleve.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnvoirLeleve.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Schedule.png"));
		btnvoirLeleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Schedule sc = new Schedule(className);
				sc.setVisible(true);
			}
		});
		btnvoirLeleve.setForeground(Color.WHITE);
		btnvoirLeleve.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnvoirLeleve.setFocusPainted(false);
		btnvoirLeleve.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnvoirLeleve.setBackground(new Color(40, 40, 40));
		btnvoirLeleve.setBounds(31, 445, 165, 100);
		add(btnvoirLeleve);
		
		btnvoirLeleve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnvoirLeleve.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnvoirLeleve.setBackground(btnvoirLeleve.getParent().getBackground());
			}
		});
		
		JButton btnstatistiquesAvances = new JButton("<html><div style='text-align: center;'>Horaire de la classe </div></html>");
		btnstatistiquesAvances.setIconTextGap(0);
		btnstatistiquesAvances.setHorizontalTextPosition(SwingConstants.CENTER);
		btnstatistiquesAvances.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnstatistiquesAvances.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\calendar_1.png"));
		btnstatistiquesAvances.setForeground(Color.WHITE);
		btnstatistiquesAvances.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnstatistiquesAvances.setFocusPainted(false);
		btnstatistiquesAvances.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnstatistiquesAvances.setBackground(new Color(40, 40, 40));
		btnstatistiquesAvances.setBounds(210, 330, 165, 100);
		//add(btnstatistiquesAvances);
		
		JButton btnstatistiquesAvancees = new JButton("<html><div style='text-align: center;'>Statistiques avancees</div></html>");
		btnstatistiquesAvancees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StatsPane frame = new StatsPane(3, StatsPane.getClassIndex(className), 0, 0);
				frame.setVisible(true);
			
			
			}
		});
		btnstatistiquesAvancees.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnstatistiquesAvancees.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Stats.png"));
		btnstatistiquesAvancees.setIconTextGap(0);
		btnstatistiquesAvancees.setHorizontalTextPosition(SwingConstants.CENTER);
		btnstatistiquesAvancees.setForeground(Color.WHITE);
		btnstatistiquesAvancees.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnstatistiquesAvancees.setFocusPainted(false);
		btnstatistiquesAvancees.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnstatistiquesAvancees.setBackground(new Color(40, 40, 40));
		btnstatistiquesAvancees.setBounds(31, 330, 165, 100);
		add(btnstatistiquesAvancees);
		
	if(StatsPane.hasCourses(className) && StatsPane.hasStudents(className)) {
		btnstatistiquesAvancees.setEnabled(true);
		btnstatistiquesAvancees.setBackground(btnstatistiquesAvancees.getParent().getBackground());
	}else {
		btnstatistiquesAvancees.setEnabled(false);
		btnstatistiquesAvancees.setBackground(Color.gray);
	}
		
		btnstatistiquesAvances.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnstatistiquesAvances.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnstatistiquesAvances.setBackground(btnstatistiquesAvances.getParent().getBackground());
			}
		});
		
		btnstatistiquesAvancees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnstatistiquesAvancees.isEnabled()) {
				btnstatistiquesAvancees.setBackground(new Color(20, 148, 198));
				}
			}public void mouseExited(MouseEvent e) {
				if(btnstatistiquesAvancees.isEnabled()) {
				btnstatistiquesAvancees.setBackground(btnstatistiquesAvancees.getParent().getBackground());
			}}
		});

		
		
		loadStudentInfo(className);
	}
	

	public static void loadStudentInfo(String className) {

		percent.setText("...");
		numberOfStudents.setText("...");
		numberOfCourses.setText("...");
		success.setText("...");
		new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
            	List<String> l = new ArrayList();
    			l.add("0");
    			l.add("0/0");
    			List<String> l1 = new ArrayList();
    			l1.add("0");
    			l1.add("0/0");
    			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
		l = StudentStats.getStudentTestsStats("All", className, "All", Home.termsText.get(Home.selectedTermIndex), "All", "All");
    			}
    			if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
		l1 = StudentStats.getStudentExamStats("All", className, "All", Home.termsText.get(Home.selectedTermIndex), "All", "All");
    			}
		
		List<String> note = Arrays.asList(l.get(1).toString().split("/"));
		List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
		
		Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
		Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
		
		Double percentage;
		if(points1 == Double.parseDouble("0") && maxima == Double.parseDouble("0")) {
			percentage = (double) 0;
		}else {	
			percentage = points1*100/maxima;
		}
		
		percent.setText(new DecimalFormat("##.##").format(percentage)+"%");
		int students = StudentStats.getNumberOfStudents(className);
		int courses = CourseStats.getNumberOfCourses(className);
		numberOfStudents.setText(students+"");	
		numberOfCourses.setText(courses+"");	
		return null;
            }
            }.execute();

		success.setText("...");
		new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
		List<String> listOfStudents = StudentStats.getStudentsFromClass(className);
		
		int echecs = 0;
		for(int i = 0; i< listOfStudents.toArray().length; i++) {
        	List<String> list = new ArrayList();
        	list.add("0");
        	list.add("0/0");
			List<String> list1 = new ArrayList();
			list1.add("0");
			list1.add("0/0");
			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
				list  = StudentStats.getStudentTestsStats(listOfStudents.get(i), className
						, "All", "Toute l'annee", "All", "All");
			}
			if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
				list1 = StudentStats.getStudentExamStats(listOfStudents.get(i), className
						, "All", "Toute l'annee", "All", "All");
			}
			
			List<String> note2 = Arrays.asList(list.get(1).toString().split("/"));
			List<String> note3 = Arrays.asList(list1.get(1).toString().split("/"));
			
			Double points11 = Double.parseDouble(note2.get(0).replaceAll(",", "."))+Double.parseDouble(note3.get(0).replaceAll(",", "."));
			Double maxima1 = Double.parseDouble(note2.get(1).replaceAll(",", "."))+Double.parseDouble(note3.get(1).replaceAll(",", "."));
			
			if(points11 == 0 && maxima1== 0) {
				echecs = echecs;
			}else {
			Double percentage1 = points11*100/maxima1;
			if(percentage1<50) {
				echecs++;
			}
			}
		}
		if(StudentStats.getNumberOfStudents(className)>0) {
			if(StudentStats.termHasTests(className, Home.termsText.get(Home.selectedTermIndex))) {
		success.setText(100-(echecs*100/StudentStats.getNumberOfStudents(className))+"%");
			}}else{
			success.setText("-");
		}
		 return null;
            }
            }.execute();
	 
}
}
