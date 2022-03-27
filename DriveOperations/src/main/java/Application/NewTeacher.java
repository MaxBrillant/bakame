package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.LPane;
import app.NewTest;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

public class NewTeacher extends JFrame {

	public static JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JTextField name1;
	public static JTextField name2;
	public static JTextField phone;
	public static JTextField mail;
	public static JComboBox gender;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTeacher frame = new NewTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewTeacher() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 474);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Continuer");
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			addNewTeacher();
			createNewTeacher(name1.getText().toUpperCase()+" "+name2.getText());
			ClassesAndCourses cc = new ClassesAndCourses(name1.getText().toUpperCase()+" "+name2.getText());
			cc.setVisible(true);
			Teacher.loadTeachers();
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(50, 393, 120, 31);
	contentPane.add(create);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez un nouvel enseignant dans l'etablissement en inserant les informations requises</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updateTeacher(Teacher.selectedTeacher);
			setVisible(false);
			Teacher.loadTeachers();
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
	contentPane.add(actualiser);
	
	button = new JButton("Annuler");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(236, 393, 129, 31);
	contentPane.add(button);
	
	JLabel lblNouveauCours = new JLabel("Nouveau professeur");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	lblNouveauCours.setBounds(0, 70, 424, 28);
	contentPane.add(lblNouveauCours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 97, 424, 12);
	contentPane.add(separator);
	
	JLabel label = new JLabel("*Nom:");
	label.setHorizontalAlignment(SwingConstants.TRAILING);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	label.setBounds(10, 120, 144, 31);
	contentPane.add(label);
	
	name1 = new JTextField();
	name1.setHorizontalAlignment(SwingConstants.CENTER);
	name1.setForeground(Color.WHITE);
	name1.setFont(new Font("Arial", Font.PLAIN, 20));
	name1.setColumns(10);
	name1.setCaretColor(new Color(0, 204, 255));
	name1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	name1.setBackground(new Color(40, 40, 40));
	name1.setBounds(178, 120, 161, 28);
	contentPane.add(name1);
	
	name2 = new JTextField();
	name2.setHorizontalAlignment(SwingConstants.CENTER);
	name2.setForeground(Color.WHITE);
	name2.setFont(new Font("Arial", Font.PLAIN, 20));
	name2.setColumns(10);
	name2.setCaretColor(new Color(0, 204, 255));
	name2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	name2.setBackground(new Color(40, 40, 40));
	name2.setBounds(178, 162, 161, 28);
	contentPane.add(name2);
	
	JLabel label_1 = new JLabel("*Prenom:");
	label_1.setHorizontalAlignment(SwingConstants.TRAILING);
	label_1.setForeground(Color.WHITE);
	label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	label_1.setBounds(10, 162, 144, 31);
	contentPane.add(label_1);
	
	JLabel lblSexe = new JLabel("*Sexe:");
	lblSexe.setHorizontalAlignment(SwingConstants.TRAILING);
	lblSexe.setForeground(Color.WHITE);
	lblSexe.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblSexe.setBounds(20, 204, 144, 31);
	contentPane.add(lblSexe);
	
	JLabel label_3 = new JLabel("Telephone:");
	label_3.setHorizontalAlignment(SwingConstants.TRAILING);
	label_3.setForeground(Color.WHITE);
	label_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	label_3.setBounds(20, 246, 144, 31);
	contentPane.add(label_3);
	
	phone = new JTextField();
	phone.setHorizontalAlignment(SwingConstants.CENTER);
	phone.setForeground(Color.WHITE);
	phone.setFont(new Font("Arial", Font.PLAIN, 20));
	phone.setColumns(10);
	phone.setCaretColor(new Color(0, 204, 255));
	phone.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	phone.setBackground(new Color(40, 40, 40));
	phone.setBounds(188, 246, 161, 28);
	contentPane.add(phone);
	
	JLabel label_4 = new JLabel("E- Mail");
	label_4.setHorizontalAlignment(SwingConstants.TRAILING);
	label_4.setForeground(Color.WHITE);
	label_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	label_4.setBounds(20, 288, 144, 31);
	contentPane.add(label_4);
	
	mail = new JTextField();
	mail.setHorizontalAlignment(SwingConstants.CENTER);
	mail.setForeground(Color.WHITE);
	mail.setFont(new Font("Arial", Font.PLAIN, 20));
	mail.setColumns(10);
	mail.setCaretColor(new Color(0, 204, 255));
	mail.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	mail.setBackground(new Color(40, 40, 40));
	mail.setBounds(188, 288, 161, 28);
	contentPane.add(mail);
	
	JLabel label_5 = new JLabel("* : important (obligatoire)");
	label_5.setHorizontalAlignment(SwingConstants.CENTER);
	label_5.setForeground(Color.WHITE);
	label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_5.setBounds(86, 339, 231, 20);
	contentPane.add(label_5);
	
	gender = new JComboBox();
	gender.setFont(new Font("Roboto", Font.PLAIN, 18));
	gender.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
	gender.setBounds(209, 208, 108, 22);
	contentPane.add(gender);

	setLocationRelativeTo(null);
	}
	
	
	public static void addNewTeacher() {
		
		teacherList.clear();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file.getPath());
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				teacherList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		

		String phoneString;
		String mailString;
		
		if(phone.getText().isBlank()) {
			phoneString = "noPhone";
		}else {
			phoneString = phone.getText();
		}
		
		if(mail.getText().isBlank()) {
			mailString = "noMail";
		}else {
			mailString = mail.getText();
		}
		
		teacherList.add(name1.getText().toUpperCase()+"::"+name2.getText()+"//"+gender.getSelectedIndex()
		+"//"+phoneString+"//"+mailString+"//active");
		
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<teacherList.toArray().length;j++) {
			pw.println((String)teacherList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
	}
	
	
public static void updateTeacher(String teacherName) {
		
		teacherList.clear();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file.getPath());
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				teacherList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		

		String phoneString;
		String mailString;
		
		if(phone.getText().isBlank()) {
			phoneString = "noPhone";
		}else {
			phoneString = phone.getText();
		}
		
		if(mail.getText().isBlank()) {
			mailString = "noMail";
		}else {
			mailString = mail.getText();
		}
		
		for(int i = 0; i<teacherList.toArray().length; i++) {
			List l = Arrays.asList(teacherList.get(i).split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(teacherName)) {
		teacherList.add(i, name1.getText().toUpperCase()+"::"+name2.getText()+"//"+gender.getSelectedIndex()
		+"//"+phoneString+"//"+mailString+"//active");
		teacherList.remove(i+1);
		}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<teacherList.toArray().length;j++) {
			pw.println((String)teacherList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
		

		File file4 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+teacherName);
		
		File file5 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+name1.getText().toUpperCase()+" "+name2.getText());
		
		file4.renameTo(file5);
	}


	
	public static void createNewTeacher(String s) {
		
		

		File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+s);
	
		file11.mkdir();
		aws.upload(file11.getPath());
			
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+s+"/ClassesAndCourses.txt");
			
			if(file.exists()) {
						file.delete();
					}
			
			
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}aws.upload(file.getPath());
			
				File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+s+"/Preferred Schedule.txt");
			
			if(file1.exists()) {
						file1.delete();
					}
			
				try {
					file1.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}aws.upload(file1.getPath());
				
				
				File file111 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+s+"/Schedule.txt");
				
				if(file111.exists()) {
							file111.delete();
						}
				
					try {
						file111.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}aws.upload(file111.getPath());
				
	}
}