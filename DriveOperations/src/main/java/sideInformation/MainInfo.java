package sideInformation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Application.EducationFrame;
import Application.Home;
import Application.ResizeImages;
import Class.CustomVerticalScrollBarUI;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class MainInfo extends JPanel {
	public static JLabel numberOfTeachers;
	public static JLabel numberOfStudents;
	public static JLabel numberOfClasses;
	public static JLabel guide;

	/**
	 * Create the panel.
	 */
	public MainInfo(String ay_id) {
		setBorder(new LineBorder(Color.WHITE));
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(400, 550));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Informations generales");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 23, 380, 19);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(500, 40));
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setBounds(35, 62, 330, 40);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPoints = new JLabel("<html><div style='text-align: center;'>Nombre de classes</div></html>");
		lblPoints.setPreferredSize(new Dimension(220, 25));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_1.add(lblPoints, BorderLayout.WEST);
		
		numberOfClasses = new JLabel("40");
		numberOfClasses.setBorder(new LineBorder(Color.WHITE));
		numberOfClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfClasses.setForeground(Color.WHITE);
		numberOfClasses.setFont(new Font("Roboto", Font.BOLD, 27));
		panel_1.add(numberOfClasses, BorderLayout.CENTER);
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVisible(false);
		scrollPane.setBounds(10, 268, 380, 280);
		add(scrollPane);
		

		scrollPane.getVerticalScrollBar().setUnitIncrement(7);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		JLabel lblCommandes = new JLabel("Guide");
		lblCommandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblCommandes.setForeground(Color.white);
			}public void mouseExited(MouseEvent e) {

				lblCommandes.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!scrollPane.isVisible()) {
				scrollPane.setVisible(true);
			}else{
				scrollPane.setVisible(false);
			}}
		});
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommandes.setForeground(Color.LIGHT_GRAY);
		lblCommandes.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCommandes.setBounds(78, 238, 227, 19);
		add(lblCommandes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setPreferredSize(new Dimension(0, 1));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 230, 400, 10);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 40));
		panel.setBackground(new Color(80, 80, 80));
		panel.setBounds(35, 113, 330, 40);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblnombreDeleves = new JLabel("<html><div style='text-align: center;'>Nombre d'eleves</div></html>");
		lblnombreDeleves.setPreferredSize(new Dimension(220, 25));
		lblnombreDeleves.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombreDeleves.setForeground(Color.WHITE);
		lblnombreDeleves.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(lblnombreDeleves, BorderLayout.WEST);
		
		numberOfStudents = new JLabel("3000");
		numberOfStudents.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfStudents.setForeground(Color.WHITE);
		numberOfStudents.setFont(new Font("Roboto", Font.BOLD, 27));
		numberOfStudents.setBorder(new LineBorder(Color.WHITE));
		panel.add(numberOfStudents, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(500, 40));
		panel_2.setBackground(new Color(80, 80, 80));
		panel_2.setBounds(35, 164, 330, 40);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblnombreDeProfesseurs = new JLabel("<html><div style='text-align: center;'>Nombre de professeurs</div></html>");
		lblnombreDeProfesseurs.setPreferredSize(new Dimension(220, 25));
		lblnombreDeProfesseurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombreDeProfesseurs.setForeground(Color.WHITE);
		lblnombreDeProfesseurs.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_2.add(lblnombreDeProfesseurs, BorderLayout.WEST);
		
		numberOfTeachers = new JLabel("54");
		numberOfTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfTeachers.setForeground(Color.WHITE);
		numberOfTeachers.setFont(new Font("Roboto", Font.BOLD, 27));
		numberOfTeachers.setBorder(new LineBorder(Color.WHITE));
		panel_2.add(numberOfTeachers, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
		panel_3.setBackground(new Color(40, 40, 40));
		
		guide = new JLabel("<html>- Cliquez sur une classe pour voir les eleves<br/> appartenants a cette classe selon la methode de <br/>triage selectionnee.<br/><br/>\r\n- Cliquez sur un eleve pour le selectonner.<br/><br/>\r\n- Selectionnez un pour voir les options <br/>disponibles ainsi que quelques statistiques rapides.<br/><br/>\r\n- Cliquez sur le bas de la classe la ou c'est ecrit <br/>\"voir la classe\" pour ouvrir cette classe.<br/><br/>\r\n- Cliquez sur l'ordre de classement (croissant <br/>ou decroissant) pour changer l'ordre.</html>");
		panel_3.add(guide);
		guide.setVerticalAlignment(SwingConstants.TOP);
		guide.setForeground(Color.LIGHT_GRAY);
		guide.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		JButton button = new JButton("<html><div style='text-align: center;'>Education</div></html>");
		button.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\discipline.png"));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setIconTextGap(0);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto", Font.PLAIN, 18));
		button.setFocusPainted(false);
		button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		button.setBackground(new Color(40, 40, 40));
		button.setBounds(30, 290, 165, 100);
		add(button);
		

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EducationFrame ef = new EducationFrame(Login.selectedAcademicYearID);
				ef.setVisible(true);
			}
		});
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				button.setBackground(button.getParent().getBackground());
			}
		});

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
		numberOfStudents.setText(students+"");
		numberOfClasses.setText(classes.length+"");
}	
	public static void deselect(String ay_id) {

		MainInfo m = new MainInfo(ay_id);
		m.guide.setText("<html>- Cliquez sur une classe pour la selectionner.<br/><br/>\r\n- Double-cliquez sur une classe pour l'ouvrir.<br/><br/>\r\n- Cliquez sur la fleche correspondante a une classe <br/>pour rapidement voir les details de cette classe.<br/><br/>\r\n- Pour creer un groupe de classe, selectionnez deux<br/> ou plusieurs classe, et puis choisissez l'option <br/>\"regrouper\".<br/><br/>\r\n- Pour ajouter une classe dans un groupe, cliquez <br/>sur le bouton \"ajouter\" qui se situe sur le groupe <br/>voulu, puis choisissez parmi les classes donnees.</html>");
		Home.side.removeAll();
		Home.side.add(m);
		Home.frame.revalidate();
		Home.frame.repaint();
	}
}
