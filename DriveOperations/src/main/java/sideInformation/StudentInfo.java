package sideInformation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.Student;
import Class.TestBox;
import CloudOperations.aws;
import Publishing.PersonalMessage;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfo extends JPanel {
	public static JLabel percent;
	public static JLabel points;
	public static JLabel echec;
	public static JLabel education;
	public static JLabel className;
	public static JLabel number;
	public static JLabel name;

	/**
	 * Create the panel.
	 */
	public StudentInfo(String studentName, String ClassName, String start, String end) {
		setBorder(new LineBorder(Color.WHITE, 1, true));
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(400, 500));
		setLayout(null);
		
		name = new JLabel("Umuhoza Chris Koen Michael");
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		name.setBounds(10, 21, 294, 28);
		add(name);
		
		number = new JLabel("No 129");
		number.setForeground(Color.WHITE);
		number.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		number.setBounds(314, 21, 76, 28);
		add(number);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 70));
		panel.setBackground(new Color(80, 80, 80));
		panel.setBounds(18, 119, 178, 70);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("Pourcentage");
		label.setPreferredSize(new Dimension(61, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(label, BorderLayout.NORTH);
		
		percent = new JLabel("75,28%");
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
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setPreferredSize(new Dimension(61, 25));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_1.add(lblPoints, BorderLayout.NORTH);
		
		points = new JLabel("1250,5/1600");
		points.setHorizontalAlignment(SwingConstants.CENTER);
		points.setForeground(Color.WHITE);
		points.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_1.add(points, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 70));
		panel_2.setBackground(new Color(80, 80, 80));
		panel_2.setBounds(18, 197, 178, 70);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEchecs = new JLabel("Echecs");
		lblEchecs.setPreferredSize(new Dimension(61, 25));
		lblEchecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecs.setForeground(Color.WHITE);
		lblEchecs.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_2.add(lblEchecs, BorderLayout.NORTH);
		
		echec = new JLabel("2");
		echec.setHorizontalAlignment(SwingConstants.CENTER);
		echec.setForeground(Color.WHITE);
		echec.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_2.add(echec, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(200, 70));
		panel_3.setBackground(new Color(80, 80, 80));
		panel_3.setBounds(204, 197, 178, 70);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEducation = new JLabel("Education");
		lblEducation.setPreferredSize(new Dimension(61, 25));
		lblEducation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEducation.setForeground(Color.WHITE);
		lblEducation.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_3.add(lblEducation, BorderLayout.NORTH);
		
		education = new JLabel("54/60");
		education.setHorizontalAlignment(SwingConstants.CENTER);
		education.setForeground(Color.WHITE);
		education.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_3.add(education, BorderLayout.CENTER);
		
		className = new JLabel(ClassName);
		className.setHorizontalAlignment(SwingConstants.CENTER);
		className.setForeground(new Color(192, 192, 192));
		className.setFont(new Font("Futura Hv BT", Font.PLAIN, 18));
		className.setBounds(53, 50, 294, 28);
		add(className);
		
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
		
		JButton btnvoirLeleve = new JButton("<html><div style='text-align: left;'>Voir l'eleve</div></html>");
		btnvoirLeleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.className = ClassName;
				Student.openStudent(studentName);
				Home.frame.setVisible(false);
			}
		});
		btnvoirLeleve.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\open.png"));
		btnvoirLeleve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnvoirLeleve.setIconTextGap(0);
		btnvoirLeleve.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnvoirLeleve.setForeground(Color.WHITE);
		btnvoirLeleve.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnvoirLeleve.setFocusPainted(false);
		btnvoirLeleve.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnvoirLeleve.setBackground(new Color(40, 40, 40));
		btnvoirLeleve.setBounds(25, 330, 165, 155);
		add(btnvoirLeleve);
		
		btnvoirLeleve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnvoirLeleve.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnvoirLeleve.setBackground(btnvoirLeleve.getParent().getBackground());
			}
		});
		
		JButton btnstatistiquesAvances = new JButton("<html><div style='text-align: center;'>Statistiques avanc\u00E9es</div></html>");
		btnstatistiquesAvances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StatsPane frame = new StatsPane(3, StatsPane.getClassIndex(ClassName), 0, StatsPane.getStudentIndex(studentName, ClassName));
				frame.setVisible(true);
			
				
			}
		});
		btnstatistiquesAvances.setHorizontalTextPosition(SwingConstants.CENTER);
		btnstatistiquesAvances.setIconTextGap(0);
		btnstatistiquesAvances.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnstatistiquesAvances.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		btnstatistiquesAvances.setForeground(Color.WHITE);
		btnstatistiquesAvances.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnstatistiquesAvances.setFocusPainted(false);
		btnstatistiquesAvances.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnstatistiquesAvances.setBackground(new Color(40, 40, 40));
		btnstatistiquesAvances.setBounds(210, 330, 165, 155);
		add(btnstatistiquesAvances);
		

		btnstatistiquesAvances.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnstatistiquesAvances.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnstatistiquesAvances.setBackground(btnstatistiquesAvances.getParent().getBackground());
			}
		});
		
		
		loadStudentInfo(studentName, ClassName, start, end);
	}
	
	public static void loadStudentInfo(String studentName, String className, String start, String end) {
		name.setText(studentName);
		number.setText("No "+StudentStats.loadStudentNumber(studentName, className));
		
		List<String> l = new ArrayList();
		l.add("0");
		l.add("0/0");
		List<String> l1 = new ArrayList();
		l1.add("0");
		l1.add("0/0");
		if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
			l  = StudentStats.getStudentTestsStats(studentName, className
				, "All", "Toute l'annee", start, end);}

		if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			l1 = StudentStats.getStudentExamStats(studentName, className
					, "All", "Toute l'annee", start, end);
			}
		List<String> note = Arrays.asList(l.get(1).toString().split("/"));
		List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
		
		Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
		Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
		
		Double percentage;
		if(points1 == 0 && maxima== 0) {
			percentage = (double) 0;
		}else {
		percentage = points1*100/maxima;
		}
		percent.setText(new DecimalFormat("##.##").format(percentage)+"%");
		points.setText(new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
		echec.setText(StudentStats.getNumberOfechecs(studentName, className, "Toute l'annee", start, end)+"");
		
	}
}
