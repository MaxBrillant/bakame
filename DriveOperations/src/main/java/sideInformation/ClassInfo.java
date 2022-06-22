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
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import elements.CustomButton;
import elements.RoundLabel;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class ClassInfo extends JPanel {
	public static JLabel name;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public ClassInfo(String classroom_in_ay_id) {
		setBorder(null);
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(350, 750));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		RoundLabel btnNewButton = new RoundLabel(100, 100, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\Bakame_logo.jpg");
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setPreferredSize(new Dimension(100, 100));
		btnNewButton.setBackground(new Color(40, 40, 40));
		add(btnNewButton);
		
		name = new JLabel(Home.getClassName(classroom_in_ay_id));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setPreferredSize(new Dimension(360, 20));
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Roboto", Font.BOLD, 16));
		add(name);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(320, 25));
		add(panel);
		panel.setBackground(getBackground());
		
		lblNewLabel = new JLabel(Home.loadActiveStudents(classroom_in_ay_id).length+" eleves");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		label = new JLabel("-");
		panel.add(label);
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel(Home.loadActiveCourses(classroom_in_ay_id).length+" cours");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		

		CustomButton changePhoto = new CustomButton("<html><div style='text-align: leading;'>Changer la photo</div></html>");
		changePhoto.setRadius(15);
		changePhoto.setAlignmentX(Component.CENTER_ALIGNMENT);
		changePhoto.setMultiClickThreshhold(2000L);
		changePhoto.setMargin(new Insets(2, 10, 2, 14));
		changePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		changePhoto.setPreferredSize(new Dimension(170, 25));
		changePhoto.setIconTextGap(10);
		changePhoto.setForeground(Color.WHITE);
		changePhoto.setFont(new Font("Roboto", Font.BOLD, 14));
		changePhoto.setFocusPainted(false);
		changePhoto.setBorderColor(new Color(255, 255, 255));
		changePhoto.setBackground(new Color(40, 40, 40));
		changePhoto.setIcon(ResizeImages.resize(15, 15, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		add(changePhoto);
		
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setPreferredSize(new Dimension(320, 1));
		add(separator);
		
		CustomButton btnstructuresDeLhoraire = new CustomButton("<html><div style='text-align: leading;'>Structure de l'horaire</div></html>");
		btnstructuresDeLhoraire.setRadius(15);
		btnstructuresDeLhoraire.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnstructuresDeLhoraire.setMargin(new Insets(2, 10, 2, 14));
		btnstructuresDeLhoraire.setHorizontalAlignment(SwingConstants.LEADING);
		btnstructuresDeLhoraire.setPreferredSize(new Dimension(320, 40));
		btnstructuresDeLhoraire.setIconTextGap(10);
		btnstructuresDeLhoraire.setForeground(Color.WHITE);
		btnstructuresDeLhoraire.setFont(new Font("Roboto", Font.BOLD, 14));
		btnstructuresDeLhoraire.setFocusPainted(false);
		btnstructuresDeLhoraire.setBorderColor(new Color(255, 255, 255));
		btnstructuresDeLhoraire.setBackground(new Color(40, 40, 40));
		btnstructuresDeLhoraire.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnstructuresDeLhoraire);
		
		CustomButton btnhoraireDeClasse = new CustomButton("<html><div style='text-align: leading;'>Horaire de classe</div></html>");
		btnhoraireDeClasse.setRadius(15);
		btnhoraireDeClasse.setMargin(new Insets(2, 10, 2, 14));
		btnhoraireDeClasse.setHorizontalAlignment(SwingConstants.LEADING);
		btnhoraireDeClasse.setPreferredSize(new Dimension(320, 40));
		btnhoraireDeClasse.setIconTextGap(10);
		btnhoraireDeClasse.setForeground(Color.WHITE);
		btnhoraireDeClasse.setFont(new Font("Roboto", Font.BOLD, 14));
		btnhoraireDeClasse.setFocusPainted(false);
		btnhoraireDeClasse.setBorderColor(new Color(255, 255, 255));
		btnhoraireDeClasse.setBackground(new Color(40, 40, 40));
		btnhoraireDeClasse.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnhoraireDeClasse);
		

		CustomButton btnstatistiquesAvances = new CustomButton("<html><div style='text-align: leading;'>Statistiques avanc\u00E9es</div></html>");
		btnstatistiquesAvances.setRadius(15);
		btnstatistiquesAvances.setMargin(new Insets(0, 10, 0, 0));
		btnstatistiquesAvances.setHorizontalAlignment(SwingConstants.LEADING);
		btnstatistiquesAvances.setPreferredSize(new Dimension(320, 40));
		btnstatistiquesAvances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsPane frame = new StatsPane("All", "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
				}
		});
		btnstatistiquesAvances.setIconTextGap(10);
		btnstatistiquesAvances.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		btnstatistiquesAvances.setForeground(Color.WHITE);
		btnstatistiquesAvances.setFont(new Font("Roboto", Font.BOLD, 14));
		btnstatistiquesAvances.setFocusPainted(false);
		btnstatistiquesAvances.setBorderColor(new Color(255, 255, 255));
		btnstatistiquesAvances.setBackground(new Color(40, 40, 40));
		add(btnstatistiquesAvances);
		
		CustomButton btnlisteDesPresences = new CustomButton("<html><div style='text-align: leading;'>Liste des presences</div></html>");
		btnlisteDesPresences.setRadius(15);
		btnlisteDesPresences.setMargin(new Insets(2, 10, 2, 14));
		btnlisteDesPresences.setHorizontalAlignment(SwingConstants.LEADING);
		btnlisteDesPresences.setPreferredSize(new Dimension(320, 40));
		btnlisteDesPresences.setIconTextGap(10);
		btnlisteDesPresences.setForeground(Color.WHITE);
		btnlisteDesPresences.setFont(new Font("Roboto", Font.BOLD, 14));
		btnlisteDesPresences.setFocusPainted(false);
		btnlisteDesPresences.setBorderColor(new Color(255, 255, 255));
		btnlisteDesPresences.setBackground(new Color(40, 40, 40));
		btnlisteDesPresences.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnlisteDesPresences);
		
		
		CustomButton classDiary = new CustomButton("<html><div style='text-align: leading;'>Journal de classe</div></html>");
		classDiary.setRadius(15);
		classDiary.setMargin(new Insets(2, 10, 2, 14));
		classDiary.setHorizontalAlignment(SwingConstants.LEADING);
		classDiary.setPreferredSize(new Dimension(320, 40));
		classDiary.setIconTextGap(10);
		classDiary.setForeground(Color.WHITE);
		classDiary.setFont(new Font("Roboto", Font.BOLD, 14));
		classDiary.setFocusPainted(false);
		classDiary.setBorderColor(new Color(255, 255, 255));
		classDiary.setBackground(new Color(40, 40, 40));
		classDiary.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(classDiary);
		
		CustomButton btnpaiementDuMinerval = new CustomButton("<html><div style='text-align: leading;'>Paiement du minerval</div></html>");
		btnpaiementDuMinerval.setRadius(15);
		btnpaiementDuMinerval.setMargin(new Insets(2, 10, 2, 14));
		btnpaiementDuMinerval.setHorizontalAlignment(SwingConstants.LEADING);
		btnpaiementDuMinerval.setPreferredSize(new Dimension(320, 40));
		btnpaiementDuMinerval.setIconTextGap(10);
		btnpaiementDuMinerval.setForeground(Color.WHITE);
		btnpaiementDuMinerval.setFont(new Font("Roboto", Font.BOLD, 14));
		btnpaiementDuMinerval.setFocusPainted(false);
		btnpaiementDuMinerval.setBorderColor(new Color(255, 255, 255));
		btnpaiementDuMinerval.setBackground(new Color(40, 40, 40));
		btnpaiementDuMinerval.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnpaiementDuMinerval);
		
		CustomButton btnhistoriqueDeConduite = new CustomButton("<html><div style='text-align: leading;'>Historique de conduite</div></html>");
		btnhistoriqueDeConduite.setRadius(15);
		btnhistoriqueDeConduite.setMargin(new Insets(2, 10, 2, 14));
		btnhistoriqueDeConduite.setHorizontalAlignment(SwingConstants.LEADING);
		btnhistoriqueDeConduite.setPreferredSize(new Dimension(320, 40));
		btnhistoriqueDeConduite.setIconTextGap(10);
		btnhistoriqueDeConduite.setForeground(Color.WHITE);
		btnhistoriqueDeConduite.setFont(new Font("Roboto", Font.BOLD, 14));
		btnhistoriqueDeConduite.setFocusPainted(false);
		btnhistoriqueDeConduite.setBorderColor(new Color(255, 255, 255));
		btnhistoriqueDeConduite.setBackground(new Color(40, 40, 40));
		btnhistoriqueDeConduite.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnhistoriqueDeConduite);
		
		CustomButton btnbulletinScolaire = new CustomButton("<html><div style='text-align: leading;'>Bulletin scolaire</div></html>");
		btnbulletinScolaire.setRadius(15);
		btnbulletinScolaire.setMargin(new Insets(2, 10, 2, 14));
		btnbulletinScolaire.setHorizontalAlignment(SwingConstants.LEADING);
		btnbulletinScolaire.setPreferredSize(new Dimension(320, 40));
		btnbulletinScolaire.setIconTextGap(10);
		btnbulletinScolaire.setForeground(Color.WHITE);
		btnbulletinScolaire.setFont(new Font("Roboto", Font.BOLD, 14));
		btnbulletinScolaire.setFocusPainted(false);
		btnbulletinScolaire.setBorderColor(new Color(255, 255, 255));
		btnbulletinScolaire.setBackground(new Color(40, 40, 40));
		btnbulletinScolaire.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnbulletinScolaire);
		
		CustomButton btnconditionsDeReussite = new CustomButton("<html><div style='text-align: leading;'>Conditions de reussite</div></html>");
		btnconditionsDeReussite.setRadius(15);
		btnconditionsDeReussite.setMargin(new Insets(2, 10, 2, 14));
		btnconditionsDeReussite.setHorizontalAlignment(SwingConstants.LEADING);
		btnconditionsDeReussite.setPreferredSize(new Dimension(320, 40));
		btnconditionsDeReussite.setIconTextGap(10);
		btnconditionsDeReussite.setForeground(Color.WHITE);
		btnconditionsDeReussite.setFont(new Font("Roboto", Font.BOLD, 14));
		btnconditionsDeReussite.setFocusPainted(false);
		btnconditionsDeReussite.setBorderColor(new Color(255, 255, 255));
		btnconditionsDeReussite.setBackground(new Color(40, 40, 40));
		btnconditionsDeReussite.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnconditionsDeReussite);
		
		CustomButton btnelevesSupprimes = new CustomButton("<html><div style='text-align: leading;'>Eleves supprimes</div></html>");
		btnelevesSupprimes.setRadius(15);
		btnelevesSupprimes.setMargin(new Insets(2, 10, 2, 14));
		btnelevesSupprimes.setHorizontalAlignment(SwingConstants.LEADING);
		btnelevesSupprimes.setPreferredSize(new Dimension(320, 40));
		btnelevesSupprimes.setIconTextGap(10);
		btnelevesSupprimes.setForeground(Color.WHITE);
		btnelevesSupprimes.setFont(new Font("Roboto", Font.BOLD, 14));
		btnelevesSupprimes.setFocusPainted(false);
		btnelevesSupprimes.setBorderColor(new Color(255, 255, 255));
		btnelevesSupprimes.setBackground(new Color(40, 40, 40));
		btnelevesSupprimes.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnelevesSupprimes);
		
		CustomButton btncoursSupprimes = new CustomButton("<html><div style='text-align: leading;'>Cours supprimes</div></html>");
		btncoursSupprimes.setRadius(15);
		btncoursSupprimes.setMargin(new Insets(2, 10, 2, 14));
		btncoursSupprimes.setHorizontalAlignment(SwingConstants.LEADING);
		btncoursSupprimes.setPreferredSize(new Dimension(320, 40));
		btncoursSupprimes.setIconTextGap(10);
		btncoursSupprimes.setForeground(Color.WHITE);
		btncoursSupprimes.setFont(new Font("Roboto", Font.BOLD, 14));
		btncoursSupprimes.setFocusPainted(false);
		btncoursSupprimes.setBorderColor(new Color(255, 255, 255));
		btncoursSupprimes.setBackground(new Color(40, 40, 40));
		btncoursSupprimes.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btncoursSupprimes);
		

		for(int i = 0; i< getComponentCount(); i++) {
			int k = i;
			if(getComponent(i) instanceof CustomButton) {
				((AbstractButton) getComponent(i)).setMultiClickThreshhold(500L);
				getComponent(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				getComponent(k).setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				getComponent(k).setBackground(getComponent(k).getParent().getBackground());
			}
		});
	}}
	}
	
	public static void loadStudentInfo(String student_id, String classroom_id, String ay_id, String start, String end) {
		name.setText(Home.getStudentName(student_id));
		number.setText("No "+StudentStats.loadStudentNumber(student_id, classroom_id, ay_id));
		
		List<String> l = new ArrayList();
		l.add("0");
		l.add("0/0");
		List<String> l1 = new ArrayList();
		l1.add("0");
		l1.add("0/0");
		if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
			l  = StudentStats.getStudentTestsStats(student_id, classroom_id
				, "All", "Toute l'annee", start, end);}

		if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			l1 = StudentStats.getStudentExamStats(student_id, classroom_id
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
		
	}
}
