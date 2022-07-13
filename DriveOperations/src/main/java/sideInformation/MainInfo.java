package sideInformation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Application.EducationFrame;
import Application.Home;
import Application.ResizeImages;
import Application.UserHistory;
import Application.Users;
import Class.CustomVerticalScrollBarUI;
import Class.RolesAndPrizes;
import Class.StudentRoles;
import Class.Terms;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;
import elements.CustomButton;
import elements.RoundLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class MainInfo extends JPanel {
	public static JLabel numberOfTeachers;
	public static JLabel numberOfStudents;
	public static JLabel numberOfClasses;

	/**
	 * Create the panel.
	 */
	public MainInfo(String ay_id) {
		setBorder(null);
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(320, 750));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		RoundLabel btnNewButton = new RoundLabel(100, 100, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\cartoonproject.jpg");
		btnNewButton.setPreferredSize(new Dimension(100, 100));
		btnNewButton.setBackground(new Color(40, 40, 40));
		add(btnNewButton);
		
		
		JLabel label = new JLabel(ScholarYears.getAcademicYearName(ay_id));
		label.setPreferredSize(new Dimension(300, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 16));
		add(label);
		

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
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(40, 40, 40));
		panel_3.setPreferredSize(new Dimension(320, 100));
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(20, 148, 198), 2));
		panel_3.add(panel_1);
		panel_1.setPreferredSize(new Dimension(90, 70));
		panel_1.setBackground(new Color(40, 40, 40));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPoints = new JLabel("Classes");
		lblPoints.setBackground(new Color(20, 148, 198));
		lblPoints.setOpaque(true);
		lblPoints.setPreferredSize(new Dimension(10, 27));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(new Color(40, 40, 40));
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_1.add(lblPoints, BorderLayout.SOUTH);
		
		numberOfClasses = new JLabel("40");
		numberOfClasses.setHorizontalTextPosition(SwingConstants.CENTER);
		numberOfClasses.setIcon(null);
		numberOfClasses.setBorder(null);
		numberOfClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfClasses.setForeground(new Color(20, 148, 198));
		numberOfClasses.setFont(new Font("Roboto", Font.BOLD, 35));
		panel_1.add(numberOfClasses, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(20, 148, 198), 2));
		panel_3.add(panel);
		panel.setPreferredSize(new Dimension(90, 70));
		panel.setBackground(new Color(40, 40, 40));
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblnombreDeleves = new JLabel("Eleves");
		lblnombreDeleves.setBackground(new Color(20, 148, 198));
		lblnombreDeleves.setOpaque(true);
		lblnombreDeleves.setPreferredSize(new Dimension(10, 27));
		lblnombreDeleves.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombreDeleves.setForeground(new Color(40, 40, 40));
		lblnombreDeleves.setFont(new Font("Roboto", Font.BOLD, 14));
		panel.add(lblnombreDeleves, BorderLayout.SOUTH);
		
		numberOfStudents = new JLabel("3000");
		numberOfStudents.setIcon(null);
		numberOfStudents.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfStudents.setForeground(new Color(20, 148, 198));
		numberOfStudents.setFont(new Font("Roboto", Font.BOLD, 35));
		numberOfStudents.setBorder(null);
		panel.add(numberOfStudents, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(20, 148, 198), 2));
		panel_3.add(panel_2);
		panel_2.setPreferredSize(new Dimension(90, 70));
		panel_2.setBackground(new Color(40, 40, 40));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblnombreDeProfesseurs = new JLabel("Professeurs");
		lblnombreDeProfesseurs.setBackground(new Color(20, 148, 198));
		lblnombreDeProfesseurs.setOpaque(true);
		lblnombreDeProfesseurs.setPreferredSize(new Dimension(10, 27));
		lblnombreDeProfesseurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombreDeProfesseurs.setForeground(new Color(40, 40, 40));
		lblnombreDeProfesseurs.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_2.add(lblnombreDeProfesseurs, BorderLayout.SOUTH);
		
		numberOfTeachers = new JLabel("54");
		numberOfTeachers.setIcon(null);
		numberOfTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfTeachers.setForeground(new Color(20, 148, 198));
		numberOfTeachers.setFont(new Font("Roboto", Font.BOLD, 35));
		numberOfTeachers.setBorder(null);
		panel_2.add(numberOfTeachers, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(300, 1));
		separator.setForeground(Color.WHITE);
		add(separator);
		
		
		
		CustomButton trimestres = new CustomButton("<html><div style='text-align: leading;'>Trimestres</div></html>");
		trimestres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms t = new Terms(ay_id);
				t.setVisible(true);
			}
		});
		trimestres.setRadius(15);
		trimestres.setAlignmentX(Component.CENTER_ALIGNMENT);
		trimestres.setMultiClickThreshhold(2000L);
		trimestres.setMargin(new Insets(2, 10, 2, 14));
		trimestres.setHorizontalAlignment(SwingConstants.LEADING);
		trimestres.setPreferredSize(new Dimension(300, 40));
		trimestres.setIconTextGap(10);
		trimestres.setForeground(Color.WHITE);
		trimestres.setFont(new Font("Roboto", Font.BOLD, 14));
		trimestres.setFocusPainted(false);
		trimestres.setBorderColor(new Color(255, 255, 255));
		trimestres.setBackground(new Color(40, 40, 40));
		trimestres.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(trimestres);
		
		
		CustomButton punitions = new CustomButton("<html><div style='text-align: leading;'>Liste des punitions</div></html>");
		punitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EducationFrame ef = new EducationFrame(ay_id);
				ef.setVisible(true);
			}
		});
		punitions.setRadius(15);
		punitions.setAlignmentX(Component.CENTER_ALIGNMENT);
		punitions.setMultiClickThreshhold(2000L);
		punitions.setMargin(new Insets(2, 10, 2, 14));
		punitions.setHorizontalAlignment(SwingConstants.LEADING);
		punitions.setPreferredSize(new Dimension(300, 40));
		punitions.setIconTextGap(10);
		punitions.setForeground(Color.WHITE);
		punitions.setFont(new Font("Roboto", Font.BOLD, 14));
		punitions.setFocusPainted(false);
		punitions.setBorderColor(new Color(255, 255, 255));
		punitions.setBackground(new Color(40, 40, 40));
		punitions.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(punitions);
		
		
		
		CustomButton utilisateurs = new CustomButton("<html><div style='text-align: leading;'>Utilisateurs et responsabilites</div></html>");
		utilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users u = new Users(ay_id);
				u.setVisible(true);
			}
		});
		utilisateurs.setRadius(15);
		utilisateurs.setAlignmentX(Component.CENTER_ALIGNMENT);
		utilisateurs.setMultiClickThreshhold(2000L);
		utilisateurs.setMargin(new Insets(2, 10, 2, 14));
		utilisateurs.setHorizontalAlignment(SwingConstants.LEADING);
		utilisateurs.setPreferredSize(new Dimension(300, 40));
		utilisateurs.setIconTextGap(10);
		utilisateurs.setForeground(Color.WHITE);
		utilisateurs.setFont(new Font("Roboto", Font.BOLD, 14));
		utilisateurs.setFocusPainted(false);
		utilisateurs.setBorderColor(new Color(255, 255, 255));
		utilisateurs.setBackground(new Color(40, 40, 40));
		utilisateurs.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(utilisateurs);
		
		

		CustomButton historique = new CustomButton("<html><div style='text-align: leading;'>Historique des utilisateurs</div></html>");
		historique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHistory u = new UserHistory();
				u.setVisible(true);
			}
		});
		historique.setRadius(15);
		historique.setAlignmentX(Component.CENTER_ALIGNMENT);
		historique.setMultiClickThreshhold(2000L);
		historique.setMargin(new Insets(2, 10, 2, 14));
		historique.setHorizontalAlignment(SwingConstants.LEADING);
		historique.setPreferredSize(new Dimension(300, 40));
		historique.setIconTextGap(10);
		historique.setForeground(Color.WHITE);
		historique.setFont(new Font("Roboto", Font.BOLD, 14));
		historique.setFocusPainted(false);
		historique.setBorderColor(new Color(255, 255, 255));
		historique.setBackground(new Color(40, 40, 40));
		historique.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(historique);
		
		
		
		CustomButton studentRoles = new CustomButton("<html><div style='text-align: leading;'>Roles et titres des eleves</div></html>");
		studentRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RolesAndPrizes s = new RolesAndPrizes(ay_id);
				s.setVisible(true);
			}
		});
		studentRoles.setRadius(15);
		studentRoles.setAlignmentX(Component.CENTER_ALIGNMENT);
		studentRoles.setMultiClickThreshhold(2000L);
		studentRoles.setMargin(new Insets(2, 10, 2, 14));
		studentRoles.setHorizontalAlignment(SwingConstants.LEADING);
		studentRoles.setPreferredSize(new Dimension(300, 40));
		studentRoles.setIconTextGap(10);
		studentRoles.setForeground(Color.WHITE);
		studentRoles.setFont(new Font("Roboto", Font.BOLD, 14));
		studentRoles.setFocusPainted(false);
		studentRoles.setBorderColor(new Color(255, 255, 255));
		studentRoles.setBackground(new Color(40, 40, 40));
		studentRoles.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(studentRoles);
		
		CustomButton Accounting = new CustomButton("<html><div style='text-align: leading;'>Comptabilite</div></html>");
		Accounting.setRadius(15);
		Accounting.setAlignmentX(Component.CENTER_ALIGNMENT);
		Accounting.setMargin(new Insets(2, 10, 2, 14));
		Accounting.setHorizontalAlignment(SwingConstants.LEADING);
		Accounting.setPreferredSize(new Dimension(300, 40));
		Accounting.setIconTextGap(10);
		Accounting.setForeground(Color.WHITE);
		Accounting.setFont(new Font("Roboto", Font.BOLD, 14));
		Accounting.setFocusPainted(false);
		Accounting.setBorderColor(new Color(255, 255, 255));
		Accounting.setBackground(new Color(40, 40, 40));
		Accounting.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(Accounting);
		
		

		CustomButton communication = new CustomButton("<html><div style='text-align: leading;'>Historique de communication</div></html>");
		communication.setRadius(15);
		communication.setAlignmentX(Component.CENTER_ALIGNMENT);
		communication.setMultiClickThreshhold(2000L);
		communication.setMargin(new Insets(2, 10, 2, 14));
		communication.setHorizontalAlignment(SwingConstants.LEADING);
		communication.setPreferredSize(new Dimension(300, 40));
		communication.setIconTextGap(10);
		communication.setForeground(Color.WHITE);
		communication.setFont(new Font("Roboto", Font.BOLD, 14));
		communication.setFocusPainted(false);
		communication.setBorderColor(new Color(255, 255, 255));
		communication.setBackground(new Color(40, 40, 40));
		communication.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(communication);
		
		
		CustomButton deletedClasses = new CustomButton("<html><div style='text-align: leading;'>Classes supprimees</div></html>");
		deletedClasses.setRadius(15);
		deletedClasses.setAlignmentX(Component.CENTER_ALIGNMENT);
		deletedClasses.setMargin(new Insets(2, 10, 2, 14));
		deletedClasses.setHorizontalAlignment(SwingConstants.LEADING);
		deletedClasses.setPreferredSize(new Dimension(300, 40));
		deletedClasses.setIconTextGap(10);
		deletedClasses.setForeground(Color.WHITE);
		deletedClasses.setFont(new Font("Roboto", Font.BOLD, 14));
		deletedClasses.setFocusPainted(false);
		deletedClasses.setBorderColor(new Color(255, 255, 255));
		deletedClasses.setBackground(new Color(40, 40, 40));
		deletedClasses.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(deletedClasses);

		
		CustomButton deletedStudents = new CustomButton("<html><div style='text-align: leading;'>Eleves supprimees</div></html>");
		deletedStudents.setRadius(15);
		deletedStudents.setAlignmentX(Component.CENTER_ALIGNMENT);
		deletedStudents.setMargin(new Insets(2, 10, 2, 14));
		deletedStudents.setHorizontalAlignment(SwingConstants.LEADING);
		deletedStudents.setPreferredSize(new Dimension(300, 40));
		deletedStudents.setIconTextGap(10);
		deletedStudents.setForeground(Color.WHITE);
		deletedStudents.setFont(new Font("Roboto", Font.BOLD, 14));
		deletedStudents.setFocusPainted(false);
		deletedStudents.setBorderColor(new Color(255, 255, 255));
		deletedStudents.setBackground(new Color(40, 40, 40));
		deletedStudents.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(deletedStudents);
		
		
		CustomButton deletedTeachers = new CustomButton("<html><div style='text-align: leading;'>Professeurs supprimees</div></html>");
		deletedTeachers.setRadius(15);
		deletedTeachers.setAlignmentX(Component.CENTER_ALIGNMENT);
		deletedTeachers.setMargin(new Insets(2, 10, 2, 14));
		deletedTeachers.setHorizontalAlignment(SwingConstants.LEADING);
		deletedTeachers.setPreferredSize(new Dimension(300, 40));
		deletedTeachers.setIconTextGap(10);
		deletedTeachers.setForeground(Color.WHITE);
		deletedTeachers.setFont(new Font("Roboto", Font.BOLD, 14));
		deletedTeachers.setFocusPainted(false);
		deletedTeachers.setBorderColor(new Color(255, 255, 255));
		deletedTeachers.setBackground(new Color(40, 40, 40));
		deletedTeachers.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(deletedTeachers);
		
		

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

		loadStudentInfo(ay_id);
	}
	
	public static void loadStudentInfo(String ay_id) {
		Object[] classes = Home.loadActiveClasses(ay_id);
		Object[] profs = Home.loadActiveProfs(ay_id);
		int students = 0;
		int tests;
		for(int i = 0; i< classes.length; i++) {
			int st = StudentStats.getNumberOfStudents(classes[i].toString());
			students = students+st;
		}

		numberOfTeachers.setText(profs.length+"");
		numberOfStudents.setText("0");
		numberOfClasses.setText(classes.length+"");
}
}
