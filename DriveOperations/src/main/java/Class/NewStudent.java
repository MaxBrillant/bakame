package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.LPane;
import Class.NewCourse;
import CloudOperations.aws;
import Stats.CourseStats;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Teacher;

import javax.swing.JSeparator;
import java.awt.Rectangle;

public class NewStudent extends JFrame {

	public static JPanel contentPane;
	public static JTextField nom;
	public static JTextField prenom;
	public static JTextField num;
	public static JTextField phone;
	public static JButton add;
	public static JButton annuler;
	public static boolean isEmpty = false;
	public static JTextField email;
	public static JButton actualiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent frame = new NewStudent();
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
	public NewStudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\School Project\\Icons\\cg_colored.png"));
		setTitle("New Student");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 70, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("*Nom:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(0, 119, 144, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("*Prenom:");
		lblPrenom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblPrenom.setBounds(0, 161, 144, 31);
		contentPane.add(lblPrenom);
		
		JLabel lblNumero = new JLabel("*Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNumero.setBounds(10, 203, 144, 31);
		contentPane.add(lblNumero);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelephone.setForeground(Color.WHITE);
		lblTelephone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblTelephone.setBounds(10, 245, 144, 31);
		contentPane.add(lblTelephone);
		
		nom = new JTextField();
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setCaretColor(new Color(0, 204, 255));
		nom.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		nom.setForeground(new Color(255, 255, 255));
		nom.setBackground(new Color(40, 40, 40));
		nom.setFont(new Font("Arial", Font.PLAIN, 20));
		nom.setBounds(168, 119, 161, 28);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setCaretColor(new Color(0, 204, 255));
		prenom.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		prenom.setForeground(new Color(255, 255, 255));
		prenom.setBackground(new Color(40, 40, 40));
		prenom.setFont(new Font("Arial", Font.PLAIN, 20));
		prenom.setColumns(10);
		prenom.setBounds(168, 161, 161, 28);
		contentPane.add(prenom);
		
		num = new JTextField();
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setCaretColor(new Color(0, 204, 255));
		num.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		num.setForeground(new Color(255, 255, 255));
		num.setBackground(new Color(40, 40, 40));
		num.setFont(new Font("Arial", Font.PLAIN, 20));
		num.setColumns(10);
		num.setBounds(225, 203, 59, 28);
		contentPane.add(num);
		
		phone = new JTextField();
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setCaretColor(new Color(0, 204, 255));
		phone.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		phone.setForeground(new Color(255, 255, 255));
		phone.setBackground(new Color(40, 40, 40));
		phone.setFont(new Font("Arial", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(178, 245, 161, 28);
		contentPane.add(phone);
		
		add = new JButton("Ajouter");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
				String ph;
				String em;
				
				if(phone.getText().isBlank()) {
					ph = "noPhone";
				}else{
					ph = phone.getText();
				}if(email.getText().isBlank()) {
					em = "noMail";
				}else {
					em = email.getText();
				}
				String s = nom.getText().toUpperCase()+"::"+prenom.getText()+"//"+ num.getText()
						+"//"+ ph+"//"+em+"//active";
				//Application.deselect();
				save();
				addNewStudent(s);
				saveCourses();
				saveMissedTests();
				saveMissedExams();
				load();
				setVisible(false);

				Application.rankAlphabetically();
				Application.merite();
				Application.ranking();
			}
		});
		add.setFocusPainted(false);
		add.setBorderPainted(false);
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(0, 171, 89));
		add.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		add.setBounds(43, 369, 129, 31);
		contentPane.add(add);
		
		annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
				setVisible(false);
			}
		});
		annuler.setForeground(Color.WHITE);
		annuler.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		annuler.setFocusPainted(false);
		annuler.setBorderPainted(false);
		annuler.setBackground(new Color(171, 0, 0));
		annuler.setBounds(216, 369, 129, 31);
		contentPane.add(annuler);
		
		JLabel lblEMail = new JLabel("E- Mail");
		lblEMail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEMail.setForeground(Color.WHITE);
		lblEMail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblEMail.setBounds(10, 287, 144, 31);
		contentPane.add(lblEMail);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Arial", Font.PLAIN, 20));
		email.setColumns(10);
		email.setCaretColor(new Color(0, 204, 255));
		email.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		email.setBackground(new Color(40, 40, 40));
		email.setBounds(178, 287, 161, 28);
		contentPane.add(email);
		
		JLabel lblNouvelEleve = new JLabel("Nouvel Eleve");
		lblNouvelEleve.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNouvelEleve.setIconTextGap(0);
		lblNouvelEleve.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNouvelEleve.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelEleve.setForeground(Color.WHITE);
		lblNouvelEleve.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
		lblNouvelEleve.setBounds(-20, 73, 424, 28);
		contentPane.add(lblNouvelEleve);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(-20, 100, 424, 12);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 139, 139));
		panel.setBackground(new Color(20, 148, 198));
		panel.setBounds(-20, 0, 424, 59);
		contentPane.add(panel);
		
		JLabel lblajoutezUnNouvel = new JLabel("<html><div style='text-align: center;'>Ajoutez un nouvel eleve en inserrant son nom, ainsi que toutes les informations requises</html>");
		lblajoutezUnNouvel.setHorizontalAlignment(SwingConstants.CENTER);
		lblajoutezUnNouvel.setForeground(Color.WHITE);
		lblajoutezUnNouvel.setFont(new Font("Roboto", Font.BOLD, 16));
		lblajoutezUnNouvel.setBounds(21, 5, 382, 48);
		panel.add(lblajoutezUnNouvel);
		
		JLabel lblNewLabel_1 = new JLabel("* : important (obligatoire)");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(76, 338, 231, 20);
		contentPane.add(lblNewLabel_1);
		
		actualiser = new JButton("Actualiser");
		actualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateStudent(((JLabel) ((Container) Student.selectedStudents.get(0)).getComponent(2)).getText());
				setVisible(false);

				
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{

		        		NewStudent.load();
		        		Application.merite();
		            	 return null;
		            }
		        }.execute();
			
			}
		});
		actualiser.setForeground(Color.WHITE);
		actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		actualiser.setFocusPainted(false);
		actualiser.setBounds(new Rectangle(50, 393, 120, 31));
		actualiser.setBackground(new Color(171, 145, 0));
		actualiser.setBounds(43, 369, 129, 31);
		contentPane.add(actualiser);
	}


	public static void addNewStudent(String s) {
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		
		List <String> stList = new ArrayList();
		aws.downloadContent(file.getPath());
			try {

				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = br.lines().toArray();
				
				for(int i = 0; i<lines.length;i++) {
					stList.add(lines[i].toString());
					}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
			stList.add(s);
			
		if(file.exists()) {
					file.delete();
				}
		
		Collections.sort(stList);
			try {
				file.createNewFile();
				PrintWriter pw = new PrintWriter(file);
				
				for(int j = 0;j<stList.toArray().length;j++) {
				pw.println((String)stList.get(j));
				}
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aws.upload(file.getPath());
		}

public static void save() {
	String name = nom.getText().toUpperCase()+" "+prenom.getText();
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name);
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/1er Trimestre");
		File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/2eme Trimestre");
		File file3 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/3eme Trimestre");
		
		if(file.exists()) {
					file.delete();
				}
		
				file.mkdir();
				file1.mkdir();
				file2.mkdir();
				file3.mkdir();
}


public static void saveMissedTests() {
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
	aws.downloadContent(file.getPath());
	try {

		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = br.lines().toArray();
		for(int i = 0;i<lines.length;i++) {
			List note = Arrays.asList(lines[i].toString().trim().split("//"));
			File file1  = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+nom.getText()+" "+prenom.getText()+"/3eme Trimestre/"+note.get(1).toString()+".txt");
			
			try {
				PrintWriter write = new PrintWriter(new FileWriter(file1, true));
				write.println(note.get(0).toString()+"//0/0");
				
				write.close();

				aws.upload(file1.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
}
}


public static void saveMissedExams() {
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
	aws.downloadContent(file.getPath());
	try {

		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = br.lines().toArray();
		if(lines.length>0) {
		for(int i = 0;i<lines.length;i++) {
			List note = Arrays.asList(lines[i].toString().trim().split("//"));
			File file1  = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+nom.getText()+" "+prenom.getText()+"/3eme Trimestre/"+note.get(0).toString()+".txt");
			aws.downloadContent(file1.getPath());

			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1= new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			
			List<String> l = new ArrayList();
			
			for(int k = 0; k< lines1.length; k++) {
				l.add(lines1[k].toString());
			}
			
			String exams = null;
			for(int j = 0; j< (Integer.parseInt(note.get(2).toString()));j++) {
				if(j==0) {
				exams = "0/0";
			}else{
				exams = exams+"//0/0";
			}
				}
			l.add(0, exams);
			l.remove(1);
			
			
			try {
				PrintWriter write = new PrintWriter(file1);
				for(int m = 0; m<l.toArray().length; m++) {
				write.println(l.get(m));
				}
				write.close();

				aws.upload(file1.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
}
}

public static void saveCourses() {
	
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Courses.txt");
	aws.downloadContent(file.getPath());
	int j = Integer.parseInt(Application.no.getText().replace(" ", ""));
		String name = nom.getText().toUpperCase()+" "+prenom.getText();;
		
		
	
	try {

		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = Home.loadActiveCourses(file.getPath());
		
		for(int i = 0; i<lines.length;i++) {
			String [] words = lines[i].toString().split("//");
			
			for(int k = 0;k<Application.trim.getItemCount()-1;k++) {
			File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/"+Application.trim.getItemAt(k)+"/"+words[0]+".txt");
			
			file2.createNewFile();
			PrintWriter pw = new PrintWriter(file2);
			pw.println("0");
			
			pw.close();
			

			aws.upload(file2.getPath());
		}}
		

		String[] terms = {"1er Trimestre","2eme Trimestre","3eme Trimestre"};
		
		for(int i = 0;i< terms.length; i++) {
		File file3 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/"+terms[i]+"/"+"Education.txt");
		
		file3.createNewFile();
		aws.upload(file3.getPath());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}



public static void updateStudent(String studentName) {
		
		List<String> StudentList = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		aws.downloadContent(file.getPath());
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
		

		String phoneString;
		String mailString;
		
		if(phone.getText().isBlank()) {
			phoneString = "noPhone";
		}else {
			phoneString = phone.getText();
		}
		
		if(email.getText().isBlank()) {
			mailString = "noMail";
		}else {
			mailString = email.getText();
		}
		
		for(int i = 0; i<StudentList.toArray().length; i++) {
			List l = Arrays.asList(StudentList.get(i).split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(studentName)) {
				StudentList.add(i, nom.getText().toUpperCase()+"::"+prenom.getText()+"//"+num.getText()
		+"//"+phoneString+"//"+mailString+"//active");
				StudentList.remove(i+1);
		}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
	
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
		
		
		String name = nom.getText()+" "+prenom.getText();
		File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+studentName);
		File file3 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+studentName+"/1er Trimestre");
		File file4 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+studentName+"/2eme Trimestre");
		File file5 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+studentName+"/3eme Trimestre");
		
		
		File file21 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name);
		File file31 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/1er Trimestre");
		File file41 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/2eme Trimestre");
		File file51 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/3eme Trimestre");
		
		
		file2.renameTo(file21);
		file3.renameTo(file31);
		file4.renameTo(file41);
		file5.renameTo(file51);
	}

public static void load() {
	
Student.deselectAll();
Application.panel1.removeAll();
isEmpty = false;
((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(0)).getComponent(0).setVisible(true);
	

	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
	aws.downloadContent(file.getPath());
		try {

			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = Home.loadActiveStudents(file.getPath());
			
			for(int i = 0; i<lines.length;i++) {
			String [] words = lines[i].toString().split("//");
			Student c = new Student();
			c.setName(words[0]);
			((JLabel) ((Container) c).getComponent(0)).setText(words[1]);
			((JLabel) ((Container) c).getComponent(2)).setText(words[0]);
			((JLabel) ((Container) c).getComponent(8)).setText(words[2]);
			
				loadStudentdata(words[0], c);

				Application.panel1.add(c);
			
				Application.panel1.revalidate();
				Application.panel1.repaint();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	}
		if(Application.panel1.getComponentCount()==0) {
			
			isEmpty = true;
			((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(0)).getComponent(0).setVisible(false);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBorder(new MatteBorder(1, 3, 5, 3, (Color) new Color(0, 0, 0, 120)));
			panel_10.setBackground(new Color(0, 0, 0, 20));
			panel_10.setPreferredSize(new Dimension(300, 400));
			Application.panel1.add(panel_10);
			panel_10.setLayout(null);
			
			JPanel panel_11 = new JPanel();
			panel_11.setBorder(new MatteBorder(0, 3, 5, 3, (Color) new Color(0, 0, 0, 190)));
			panel_11.setBackground(new Color(80,80,80));
			panel_11.setBounds(0, 233, 300, 167);
			panel_10.add(panel_11);
			panel_11.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("<html>Il n'ya actuellement aucun eleve dans cette classe, commencez par en ajouter.</html>");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 0, 280, 106);
			panel_11.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			
			JButton btnNewButton_1 = new JButton("Ajouter un nouvel eleve");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewStudent nt = new NewStudent();
					nt.setVisible(true);
				}
			});
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton_1.setBackground(Color.white);
					btnNewButton_1.setForeground(Color.black);
				}public void mouseExited(MouseEvent e) {
					btnNewButton_1.setBackground(panel_11.getBackground());
					btnNewButton_1.setForeground(Color.WHITE);
					
				}
			});
			btnNewButton_1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setBackground(panel_11.getBackground());
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBounds(10, 116, 280, 40);
			panel_11.add(btnNewButton_1);
			btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(ResizeImages.resize(80, 80, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\cg_welcome.png"));
			lblNewLabel_2.setBackground(new Color(0, 0, 0));
			lblNewLabel_2.setBounds(0, 0, 300, 235);
			panel_10.add(lblNewLabel_2);
			
			
		}
		Application.panel1.revalidate();
		Application.panel1.repaint();

	}
public static void loadStudentdata(String student, Container c) { 
	//to calculate the different stats about the student
		Application.manageTabs();
		
		List<String> l = new ArrayList();
		l.add("0");
		l.add("0/0");
		List<String> l1 = new ArrayList();
		l1.add("0");
		l1.add("0/0");
		if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
			l = StudentStats.getStudentTestsStats(student, Home.className
					,"All", Home.termsText.get(Home.selectedTermIndex),"All", "All");
			}

		if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			l1 = StudentStats.getStudentExamStats(student, Home.className
					,"All", Home.termsText.get(Home.selectedTermIndex),"All", "All");
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
	
	((JLabel) ((((Container) c).getComponent(4)))).setText(new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
	
	
	
	((JLabel) ((((Container) c).getComponent(3)))).setText(new DecimalFormat("##.##").format(percentage)+"%");
	
	((JLabel) ((((Container) c).getComponent(5)))).setText(String.valueOf(StudentStats.getNumberOfechecs(student, Home.className, Home.termsText.get(Home.selectedTermIndex),"All", "All")));
	
	if(l.toArray().length>2) {
	((JLabel) ((((Container) c).getComponent(6)))).setText(String.valueOf(l.get(2)));
	((JLabel) ((((Container) c).getComponent(7)))).setText(String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(l.get(5))))+"%");
	}
}
}

