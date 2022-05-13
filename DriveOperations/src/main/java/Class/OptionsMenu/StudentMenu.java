package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.Application;
import Class.Course;
import Class.NewPane;
import Class.NewStudent;
import Class.Punish;
import Class.Student;
import CloudOperations.aws;
import Publishing.NewPublication;
import Stats.StatsPane;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StudentMenu extends JPanel {
	public static JTextField textField;
	public static JButton open;
	public static JButton add;
	public static JButton stats;
	public static JButton publish;
	public static JButton retirer;
	public static JButton edit;
	public static JButton delete;
	public static JButton settings2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblerTrimestre;
	private JButton btnNewButton;
	public static JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public StudentMenu(String classroom_in_ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int) screensize.getWidth(), (int) screensize.getHeight()*20/100*70/100));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension((int) screensize.getWidth()*0/100, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		
		open = new JButton("");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Student.selectedStudents.toArray().length==1) {
					Student.openStudent(Student.selectedStudents.get(0).getName(), classroom_in_ay_id);
			}
			}
		});
		open.setVerticalTextPosition(SwingConstants.BOTTOM);
		open.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\open.png"));
		open.setPreferredSize(new Dimension(100, 100));
		open.setIconTextGap(0);
		open.setHorizontalTextPosition(SwingConstants.CENTER);
		open.setForeground(new Color(255, 255, 255));
		open.setFont(new Font("Roboto", Font.PLAIN, 18));
		open.setFocusPainted(false);
		open.setBorder(null);
		open.setBackground(new Color(60, 60, 60));
		panel.add(open);
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(100, 100));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(new Color(60, 60, 60));
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		
		stats = new JButton("");
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Student.selectedStudents.toArray().length>0) {
				StatsPane frame = new StatsPane(Student.selectedStudents.get(0).getName(), "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
				}else{
					StatsPane frame = new StatsPane("All", "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					frame.setVisible(true);
				
				}}
		});
		stats.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		stats.setPreferredSize(new Dimension(100, 100));
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setIconTextGap(0);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 18));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(new Color(60, 60, 60));
		panel.add(stats);
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewStudent nt = new NewStudent(classroom_in_ay_id);
				nt.setVisible(true);
				nt.actualiser.setVisible(true);
				nt.add.setVisible(false);
			}
		});
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(100, 100));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(60, 60, 60));
		panel.add(edit);
		
		delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
				deleteStudent(((JLabel) ((Container) Student.selectedStudents.get(i)).getComponent(2)).getText(), Home.className);
				}
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{

		        		NewStudent.load(classroom_in_ay_id);
		        		Application.merite();
		            	 return null;
		            }
		        }.execute();
			}
		});
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(100, 100));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(new Color(60, 60, 60));
		panel.add(delete);
		
		retirer = new JButton("");
		retirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> students = new ArrayList();
				for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
					students.add(Student.selectedStudents.get(i).getName());
				}
				Punish p = new Punish(classroom_in_ay_id, Login.selectedAcademicYearID, students);
				p.setVisible(true);
			}
		});
		retirer.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\discipline.png"));
		retirer.setVerticalTextPosition(SwingConstants.BOTTOM);
		retirer.setPreferredSize(new Dimension(100, 100));
		retirer.setIconTextGap(0);
		retirer.setHorizontalTextPosition(SwingConstants.CENTER);
		retirer.setForeground(Color.WHITE);
		retirer.setFont(new Font("Roboto", Font.PLAIN, 18));
		retirer.setFocusPainted(false);
		retirer.setBorder(null);
		retirer.setBackground(new Color(60, 60, 60));
		panel.add(retirer);
		
		publish = new JButton("");
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			}
		});
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(100, 100));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(new Color(60, 60, 60));
		panel.add(publish);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(panel.getBackground());
		panel_1.setPreferredSize(new Dimension(350, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(59, 0, 291, 29);
		panel_1.add(textField);
		
		JButton btnElevesSupprimes = new JButton("eleves supprimes");
		btnElevesSupprimes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(60, 60, 60));
			}
			
		});
		btnElevesSupprimes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnElevesSupprimes.setPreferredSize(new Dimension(100, 100));
		btnElevesSupprimes.setIconTextGap(0);
		btnElevesSupprimes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnElevesSupprimes.setForeground(Color.WHITE);
		btnElevesSupprimes.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnElevesSupprimes.setFocusPainted(false);
		btnElevesSupprimes.setBorder(null);
		btnElevesSupprimes.setBackground(new Color(60, 60, 60));
		btnElevesSupprimes.setBounds(206, 40, 134, 24);
		panel_1.add(btnElevesSupprimes);
		
		settings2 = new JButton("");
		settings2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settings2.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settings2.setBackground(new Color(60, 60, 60));
			}
			
		});
		settings2.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\settingsicon.png"));
		settings2.setVerticalTextPosition(SwingConstants.BOTTOM);
		settings2.setPreferredSize(new Dimension(100, 100));
		settings2.setIconTextGap(-4);
		settings2.setHorizontalTextPosition(SwingConstants.CENTER);
		settings2.setForeground(Color.WHITE);
		settings2.setFont(new Font("Arial", Font.PLAIN, 19));
		settings2.setFocusPainted(false);
		settings2.setBorder(null);
		settings2.setBackground(new Color(60, 60, 60));
		settings2.setBounds(10, 0, 66, 66);
	//	panel_1.add(settings2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 60, 60));
		panel_3.setBounds(39, 40, 155, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Travaux");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod>0) {
					Home.selectedPeriod--;
				}else {
					Home.selectedPeriod = Home.periodText.toArray().length-1;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(panel_3.getBackground());
		btnNewButton.setBorder(null);
		btnNewButton.setPreferredSize(new Dimension(30, 30));
		btnNewButton.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panel_3.add(btnNewButton, BorderLayout.WEST);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod<Home.periodText.toArray().length-1) {
					Home.selectedPeriod++;
				}else {
					Home.selectedPeriod = 0;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(panel_3.getBackground());
		button_1.setBorder(null);
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		panel_3.add(button_1, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setBounds(39, 77, 195, 30);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblerTrimestre = new JLabel("2eme Trimestre");
		lblerTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblerTrimestre.setForeground(Color.WHITE);
		lblerTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_4.add(lblerTrimestre, BorderLayout.CENTER);
		lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
				}
		});
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(panel_4.getBackground());
		button_2.setBorder(null);
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		panel_4.add(button_2, BorderLayout.WEST);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
			}
		});
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(panel_4.getBackground());
		button_3.setBorder(null);
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		panel_4.add(button_3, BorderLayout.EAST);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Application.ranking();
			}
		});
		comboBox.setFont(new Font("Roboto", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A-z", "merite", "Progres", "Echecs"}));
		comboBox.setBounds(244, 77, 96, 30);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(panel.getBackground());
		panel_2.setPreferredSize(new Dimension(130, 200));
		add(panel_2, BorderLayout.WEST);
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\School Project\\Icons\\Bakame.png"));
		button.setPreferredSize(new Dimension(100, 100));
		button.setFont(new Font("Arial", Font.PLAIN, 27));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(panel_2.getBackground());
		panel_2.add(button);
		

		Application.deselect();
		Home.deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			String[] s = {"Ouvrir","Ajouter","Statistiques","Modifier","Supprimer","Education","Publier"};
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(120, 120, 120));
					((AbstractButton) panel.getComponent(j)).setText(s[j]);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
					((AbstractButton) panel.getComponent(j)).setText(null);
				}
				
			});
		}
	}
	
	
	public static void deselect() {
		//Student.isSelected = false;
		stats.setVisible(true);
		open.setVisible(false);
		edit.setVisible(false);
		delete.setVisible(false);
		settings2.setVisible(false);
		
		if(!NewStudent.isEmpty) {
		for(int k = 0;k<Application.panel1.getComponentCount(); k++) {
		for(int i = 0;i<((Container) Application.panel1.getComponent(k)).getComponentCount();i++) {
			for(int j = 0;j<Application.panel1.getComponentCount();j++) {
				//((Container) Application.panel1.getComponent(j)).getComponent(i).setForeground(Color.white);
			Application.panel1.getComponent(j).setBackground(new Color(60, 60, 60));
			((Container) Application.panel1.getComponent(j)).getComponent(0).setForeground(Color.black);
		}
		}
}
		Application.no.setText(String.valueOf(Application.panel1.getComponentCount()));
		}else {
			Application.no.setText("0");
}
		}
	
	
	public static void deleteStudent(String studentName, String className) {
	

		List<String> StudentList = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				StudentList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<StudentList.toArray().length; i++) {
			List l = Arrays.asList(StudentList.get(i).split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(studentName)) {
				StudentList.add(i, StudentList.get(i).replaceAll("//active", "//deleted"));
				StudentList.remove(i+1);
			}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<StudentList.toArray().length;j++) {
			pw.println((String)StudentList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
	}
}
