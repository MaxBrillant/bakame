package sideInformation;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
import Class.CustomVerticalScrollBarUI;
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
import app.App;
import app.Cours;
import app.General;
import app.LPane;
import app.Test;
import app.WrapLayout;
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

public class StudentInfo extends JPanel {
	public static JLabel name;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public StudentInfo(String classroom_in_ay_id) {
		setBorder(null);
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(320, 700));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		RoundLabel btnNewButton = new RoundLabel(100, 100, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\cartoonproject.jpg");
		//btnNewButton.setPreferredSize(new Dimension(100, 100));
		btnNewButton.setBackground(new Color(40, 40, 40));
		add(btnNewButton);
		
		
		
		
		
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(60, 60, 60));
		add(panelName, BorderLayout.NORTH);
		panelName.setPreferredSize(new Dimension(300, 50));
		panelName.setLayout(new BorderLayout(0, 0));
		
		name = new JLabel("UMUHOZA Chris Koen Michael");
		name.setForeground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Roboto", Font.BOLD, 16));
		panelName.add(name, BorderLayout.NORTH);
		
		JButton previous = new JButton("");
		previous.setFocusPainted(false);
		previous.setBorderPainted(false);
		previous.setBackground(new Color(25, 25, 25));
		previous.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panelName.add(previous, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panelName.add(panel_6, BorderLayout.CENTER);
		panel_6.setBackground(new Color(60, 60, 60));
		

		
		JLabel num = new JLabel("15");
		num.setForeground(Color.WHITE);
		panel_6.setLayout(new BorderLayout(0, 0));
		num.setBackground(new Color(245, 245, 245));
		panel_6.add(num);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 0));
		scrollPane_1.setBorder(null);
		panelName.add(scrollPane_1, BorderLayout.SOUTH);
		
		

		scrollPane_1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(5);
		
		JPanel numbers = new JPanel();
		numbers.setBackground(new Color(25, 25, 25));
		scrollPane_1.setViewportView(numbers);

		numbers.setLayout(new WrapLayout(WrapLayout.CENTER,3,3));
		
		JButton next = new JButton("");
		panelName.add(next, BorderLayout.EAST);
		next.setFocusPainted(false);
		next.setBorderPainted(false);
		next.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		next.setBackground(new Color(25, 25, 25));
		
		

		num.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelName.getHeight() == 50) {
						panelName.setPreferredSize(new Dimension(panelName.getPreferredSize().width, 100));
						panelName.getComponent(panelName.getComponentCount()-2).setPreferredSize(new Dimension(panelName.getPreferredSize().width, 50));
					panelName.revalidate();
					panelName.repaint();
					loadnumbers(classroom_in_ay_id, numbers);
					
					}
					else{
						panelName.setPreferredSize(new Dimension(panelName.getPreferredSize().width, 50));
						panelName.getComponent(panelName.getComponentCount()-2).setPreferredSize(new Dimension(panelName.getPreferredSize().width, 0));
						panelName.revalidate();
						panelName.repaint();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(120, 120, 120));
			}

			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(60, 60, 60));
			
			}
		});
		
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;

				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					

					if(LPane.selectedTab==0) {
						LPane.setToTestView(selectedCourse.getName(), classroom_in_ay_id);
					}else {
						LPane.setToExamView(selectedCourse.getName(), classroom_in_ay_id);
						}
				}
				if(App.n<App.students.toArray().length-1) {
					App.n++;
				}else{
					App.n = 0;
				}
				App.loadName(classroom_in_ay_id, App.students.get(App.n), numbers);
				
				App.loadCourses(classroom_in_ay_id, App.students.get(App.n));

				loadnumbers(classroom_in_ay_id, numbers);
				

				//Test.deselect(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
				
				
				if(selectedCourse != null) {
					
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}}else{
						//General.totalScore(App.students.get(App.n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
				panelName.revalidate();
				panelName.repaint();
			
			}
		});
		
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;

				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					
					if(LPane.selectedTab==0) {
						LPane.setToTestView(selectedCourse.getName(), classroom_in_ay_id);
					}else {
						LPane.setToExamView(selectedCourse.getName(), classroom_in_ay_id);
						}
				//Test.deselect(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
				}
				
				//loadStudents(classroom_id, ay_id);
				
				if(App.n>0) {
					App.n--;
				}else{
					App.n = App.students.toArray().length-1;
				}
				App.loadName(classroom_in_ay_id, App.students.get(App.n), numbers);

				App.loadCourses(classroom_in_ay_id, App.students.get(App.n));

				loadnumbers(classroom_in_ay_id, numbers);
				if(selectedCourse != null) {
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					
					for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
						if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
							Cours.selectedCourses.add(App.panel_5.getComponent(i));
					}}
					
					for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
						if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
							Cours.setSelected(App.panel_5.getComponent(j));
						}}}else{
							//General.totalScore(App.students.get(App.n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
						}
				
				
				panelName.revalidate();
				panelName.repaint();
			
			}
		});
		
		
		
		App.loadName(classroom_in_ay_id, App.students.get(App.n), numbers);
		
		
		

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
		separator.setForeground(new Color(211, 211, 211));
		separator.setPreferredSize(new Dimension(300, 1));
		add(separator);
		

		CustomButton btnstatistiquesAvances = new CustomButton("<html><div style='text-align: leading;'>Statistiques avanc\u00E9es</div></html>");
		btnstatistiquesAvances.setRadius(15);
		btnstatistiquesAvances.setMargin(new Insets(0, 10, 0, 0));
		btnstatistiquesAvances.setHorizontalAlignment(SwingConstants.LEADING);
		btnstatistiquesAvances.setPreferredSize(new Dimension(300, 40));
		btnstatistiquesAvances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsPane frame = new StatsPane("All", "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
				}
		});
		
		JLabel lblRolestitres = new JLabel("Roles/titres");
		lblRolestitres.setPreferredSize(new Dimension(300, 25));
		lblRolestitres.setHorizontalAlignment(SwingConstants.CENTER);
		lblRolestitres.setForeground(Color.WHITE);
		lblRolestitres.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(lblRolestitres);
		
		CustomButton btnNewButton_1 = new CustomButton();
		btnNewButton_1.setRadius(15);
		btnNewButton_1.setText("Delege de classe");
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setBorderColor(Color.black);
		add(btnNewButton_1);
		
		CustomButton btnNewButton_11 = new CustomButton();
		btnNewButton_11.setRadius(15);
		btnNewButton_11.setText("Doyen");
		btnNewButton_11.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_11.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setBorderColor(Color.black);
		add(btnNewButton_11);
		
		CustomButton btnNewButton_111 = new CustomButton();
		btnNewButton_111.setRadius(15);
		btnNewButton_111.setText("Prix innovation 2022");
		btnNewButton_111.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_111.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setBorderColor(Color.black);
		add(btnNewButton_111);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(300, 1));
		separator_1.setForeground(new Color(211, 211, 211));
		add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Parents/Tuteurs");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setPreferredSize(new Dimension(300, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(lblNewLabel_2);
		
		CustomButton btnNewButton_2 = new CustomButton();
		btnNewButton_2.setRadius(15);
		btnNewButton_2.setText("Kazezwa Ancilla");
		btnNewButton_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(20, 148, 198));
		btnNewButton_2.setBorderColor(Color.black);
		add(btnNewButton_2);
		
		CustomButton btnNewButton_21 = new CustomButton();
		btnNewButton_21.setRadius(15);
		btnNewButton_21.setText("Nzosaba Avit Viateur");
		btnNewButton_21.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_21.setBackground(new Color(20, 148, 198));
		btnNewButton_21.setBorderColor(Color.black);
		add(btnNewButton_21);
		
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(211, 211, 211));
		separator2.setPreferredSize(new Dimension(300, 1));
		add(separator2);
		
		
		btnstatistiquesAvances.setIconTextGap(10);
		btnstatistiquesAvances.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		btnstatistiquesAvances.setForeground(Color.WHITE);
		btnstatistiquesAvances.setFont(new Font("Roboto", Font.BOLD, 14));
		btnstatistiquesAvances.setFocusPainted(false);
		btnstatistiquesAvances.setBorderColor(new Color(255, 255, 255));
		btnstatistiquesAvances.setBackground(new Color(40, 40, 40));
		add(btnstatistiquesAvances);
		
		CustomButton btnhoraireDeClasse = new CustomButton("<html><div style='text-align: leading;'>Horaire de classe</div></html>");
		btnhoraireDeClasse.setRadius(15);
		btnhoraireDeClasse.setMargin(new Insets(2, 10, 2, 14));
		btnhoraireDeClasse.setHorizontalAlignment(SwingConstants.LEADING);
		btnhoraireDeClasse.setPreferredSize(new Dimension(300, 40));
		btnhoraireDeClasse.setIconTextGap(10);
		btnhoraireDeClasse.setForeground(Color.WHITE);
		btnhoraireDeClasse.setFont(new Font("Roboto", Font.BOLD, 14));
		btnhoraireDeClasse.setFocusPainted(false);
		btnhoraireDeClasse.setBorderColor(new Color(255, 255, 255));
		btnhoraireDeClasse.setBackground(new Color(40, 40, 40));
		btnhoraireDeClasse.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnhoraireDeClasse);
		
		CustomButton btnstructuresDeLhoraire = new CustomButton("<html><div style='text-align: leading;'>Modifier les infos personnelles</div></html>");
		btnstructuresDeLhoraire.setRadius(15);
		btnstructuresDeLhoraire.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnstructuresDeLhoraire.setMargin(new Insets(2, 10, 2, 14));
		btnstructuresDeLhoraire.setHorizontalAlignment(SwingConstants.LEADING);
		btnstructuresDeLhoraire.setPreferredSize(new Dimension(300, 40));
		btnstructuresDeLhoraire.setIconTextGap(10);
		btnstructuresDeLhoraire.setForeground(Color.WHITE);
		btnstructuresDeLhoraire.setFont(new Font("Roboto", Font.BOLD, 14));
		btnstructuresDeLhoraire.setFocusPainted(false);
		btnstructuresDeLhoraire.setBorderColor(new Color(255, 255, 255));
		btnstructuresDeLhoraire.setBackground(new Color(40, 40, 40));
		btnstructuresDeLhoraire.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnstructuresDeLhoraire);
		
		CustomButton btnbulletinScolaire = new CustomButton("<html><div style='text-align: leading;'>Bulletin scolaire</div></html>");
		btnbulletinScolaire.setRadius(15);
		btnbulletinScolaire.setMargin(new Insets(2, 10, 2, 14));
		btnbulletinScolaire.setHorizontalAlignment(SwingConstants.LEADING);
		btnbulletinScolaire.setPreferredSize(new Dimension(300, 40));
		btnbulletinScolaire.setIconTextGap(10);
		btnbulletinScolaire.setForeground(Color.WHITE);
		btnbulletinScolaire.setFont(new Font("Roboto", Font.BOLD, 14));
		btnbulletinScolaire.setFocusPainted(false);
		btnbulletinScolaire.setBorderColor(new Color(255, 255, 255));
		btnbulletinScolaire.setBackground(new Color(40, 40, 40));
		btnbulletinScolaire.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnbulletinScolaire);
		
		CustomButton btnpaiementDuMinerval = new CustomButton("<html><div style='text-align: leading;'>Responsabilites et titres</div></html>");
		btnpaiementDuMinerval.setRadius(15);
		btnpaiementDuMinerval.setMargin(new Insets(2, 10, 2, 14));
		btnpaiementDuMinerval.setHorizontalAlignment(SwingConstants.LEADING);
		btnpaiementDuMinerval.setPreferredSize(new Dimension(300, 40));
		btnpaiementDuMinerval.setIconTextGap(10);
		btnpaiementDuMinerval.setForeground(Color.WHITE);
		btnpaiementDuMinerval.setFont(new Font("Roboto", Font.BOLD, 14));
		btnpaiementDuMinerval.setFocusPainted(false);
		btnpaiementDuMinerval.setBorderColor(new Color(255, 255, 255));
		btnpaiementDuMinerval.setBackground(new Color(40, 40, 40));
		btnpaiementDuMinerval.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(btnpaiementDuMinerval);
		

		for(int i = 0; i< getComponentCount(); i++) {
			int k = i;
			if(getComponent(i) instanceof CustomButton && getComponent(i).getBackground().equals(getBackground())) {
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
	
	
	public static void loadnumbers(String classroom_in_ay_id, Container c) { //number selected
		c.removeAll();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
					
		for(int i = 0;i<lines.length;i++) {
		
		JPanel button = new JPanel();
		button.setPreferredSize(new Dimension(30, 25));
		button.setBackground(new Color(80, 80, 80));
		button.setName(String.valueOf(i));
		JLabel num = new JLabel();
		num.setText(App.getStudentNumber(lines[i].toString()));
		num.setBounds(button.getBounds());
		button.add(num);
		
		num.setVerticalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		num.setForeground(Color.white);
		c.add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				

				Component selectedCourse = null;

				int opened = 0;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					
				

				Test.deselect(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
				
				if(LPane.selectedTab==0) {
					LPane.setToTestView(selectedCourse.getName(), classroom_in_ay_id);
				}else {
					LPane.setToExamView(selectedCourse.getName(), classroom_in_ay_id);
					}
				}
				
				App.n= Integer.parseInt(button.getName());
				App.loadName(classroom_in_ay_id, App.students.get(App.n), c);

				App.loadCourses(classroom_in_ay_id, App.students.get(App.n));
				loadnumbers(classroom_in_ay_id, c);
				if(selectedCourse != null) {
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), App.students.get(App.n), classroom_in_ay_id);
					
					for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
						if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
							Cours.selectedCourses.add(App.panel_5.getComponent(i));
					}}
					
					for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
						if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
							Cours.setSelected(App.panel_5.getComponent(j));
						}}}

				num.setForeground(Color.white);
				c.revalidate();
				c.repaint();
			
			}
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(120, 120, 120));
				num.setForeground(Color.white);
			}public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(80, 80, 80));
				num.setForeground(Color.white);
				c.getComponent(App.n).setBackground(new Color(20, 148, 198));
				((Container) c.getComponent(App.n)).getComponent(0).setForeground(Color.white);
			}
		});
		}

		c.getComponent(App.n).setBackground(new Color(20, 148, 198));
		((Container) c.getComponent(App.n)).getComponent(0).setForeground(Color.white);
		
	}
	
	
	
	public static void loadStudentInfo(String student_id, String classroom_id, String ay_id, String start, String end) {
		name.setText(Home.getStudentName(student_id));
		
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
