package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.General;
import app.LPane;
import app.Test;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewTest extends JFrame {

	public static JPanel contentPane;
	public static JTextField points;
	public static JLabel name;
	public static JButton add;
	public static JButton annuler;
	public static JLabel interro;
	public static JLabel cours;
	public static JLabel maxima;
	public static JButton skip;
	public static JButton right;
	public static JButton left;
	public static int n;
	public static JLabel num;
	private JPanel panel;
	private JPanel panel_1;
	public static String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTest frame = new NewTest();
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
	public NewTest(String testId) {
		id = testId;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		setTitle("New Test");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 400, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		right = new JButton("");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
				aws.downloadContent(file.getPath());
			FileReader fr;
			try {
				fr = new FileReader(file);
			
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = Home.loadActiveStudents(file.getPath());
			
			if(n<lines.length-1) {
				n++;
			}else{
				n = 0;
			}
			Animations.scrollTestRight();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		right.setFocusPainted(false);
		right.setIcon(ResizeImages.resize(50, 50, "Icons\\r_arrow.png"));
		right.setBorderPainted(false);
		right.setBackground(Color.GRAY);
		right.setBounds(313, 21, 61, 55);
		contentPane.add(right);
		
		left = new JButton("");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
				aws.downloadContent(file.getPath());
				FileReader fr;
				try {
					fr = new FileReader(file);
				
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = Home.loadActiveStudents(file.getPath());
				
				if(n>0) {
					n--;
				}else{
					n = lines.length-1;
				}
				Animations.scrollTestLeft();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		left.setFocusPainted(false);
		left.setIcon(ResizeImages.resize(50, 50, "Icons\\l_arrow.png"));
		left.setBorderPainted(false);
		left.setBackground(Color.GRAY);
		left.setBounds(10, 21, 61, 55);
		contentPane.add(left);
		
		panel = new JPanel();
		panel.setBackground(contentPane.getBackground());
		panel.setBounds(0, 11, 384, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		num = new JLabel("154");
		num.setBounds(165, 49, 54, 23);
		panel.add(num);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(new Color(127, 255, 212));
		num.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		
		name = new JLabel("NDABIHAWENIMANA Christin Helec");
		name.setBounds(0, 0, 384, 95);
		panel.add(name);
		name.setIconTextGap(10);
		name.setForeground(new Color(255, 255, 255));
		name.setVerticalTextPosition(SwingConstants.BOTTOM);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		name.setIcon(ResizeImages.resize(65, 65, "Icons\\student.png"));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Roboto", Font.BOLD, 20));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setBounds(10, 186, 364, 64);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Points obtenus:");
		lblNewLabel.setBounds(12, 16, 144, 31);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		points = new JTextField();
		points.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(points.getText().isBlank() || Double.parseDouble(points.getText().replace(",", "."))>Double.parseDouble(maxima.getText().replace("/", "").replace(",", "."))) {
					add.setEnabled(false);
				}else {
					add.setEnabled(true);
				}
			}
		});
		points.setBounds(175, 18, 61, 28);
		panel_1.add(points);
		points.setBorder(new LineBorder(new Color(128, 128, 128)));
		points.setForeground(new Color(255, 255, 255));
		points.setBackground(new Color(40, 40, 40));
		points.setCaretColor(new Color(0, 204, 255));
		points.setHorizontalAlignment(SwingConstants.CENTER);
		points.setFont(new Font("Arial", Font.PLAIN, 25));
		points.setColumns(10);
		
		maxima = new JLabel("/20");
		maxima.setBounds(246, 16, 118, 31);
		panel_1.add(maxima);
		maxima.setForeground(Color.WHITE);
		maxima.setFont(new Font("Roboto", Font.BOLD, 23));

		points.requestFocus();
		
		add = new JButton("Suivant");
		add.setEnabled(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTestNote(testId, (points.getText().replace(",", ".")+"/"+maxima.getText().replaceAll("[^0.00-9.00]+", "")), name.getText(),TestInfo.cours.getSelectedItem().toString());
				
				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
				aws.downloadContent(file.getPath());
				FileReader fr;
				try {
					fr = new FileReader(file);
				
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = Home.loadActiveStudents(file.getPath());
				
				if(n<lines.length-1) {
					n++;
				}else{
					n = 0;
					setVisible(false);
				}

				Animations.scrollTestRight();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			
		});
		add.setFocusPainted(false);
		add.setBorderPainted(false);
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(0, 171, 89));
		add.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		add.setBounds(10, 261, 111, 31);
		contentPane.add(add);
		
		annuler = new JButton("Arreter");
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
		annuler.setBounds(263, 261, 111, 31);
		contentPane.add(annuler);
		
		interro = new JLabel("Interrogation No"+Test.getTestNumber(testId));
		interro.setForeground(new Color(255, 255, 255));
		interro.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		interro.setHorizontalAlignment(SwingConstants.CENTER);
		interro.setBounds(0, 141, 384, 27);
		contentPane.add(interro);
		
		cours = new JLabel("Comptabilite Generale");
		cours.setHorizontalAlignment(SwingConstants.CENTER);
		cours.setForeground(Color.WHITE);
		cours.setFont(new Font("Futura Hv BT", Font.PLAIN, 23));
		cours.setBounds(0, 115, 384, 27);
		contentPane.add(cours);
		
		skip = new JButton("Pas fait");
		skip.setForeground(Color.WHITE);
		skip.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		skip.setFocusPainted(false);
		skip.setBorderPainted(false);
		skip.setBackground(new Color(171, 141, 0));
		skip.setBounds(136, 261, 111, 31);
		contentPane.add(skip);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 110, 384, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(0, 172, 384, 12);
		contentPane.add(separator_1);
		
	}
	
	public static void loadTestInfo(String testId) {
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Courses.txt");
		aws.downloadContent(file.getPath());
		aws.downloadContent(file2.getPath());
		FileReader fr;
		try {
			fr = new FileReader(file);
			FileReader fr2 = new FileReader(file2);
		
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = Home.loadActiveStudents(file.getPath());
		
		BufferedReader br2 = new BufferedReader(fr2);
		Object[] lines2 = Home.loadActiveCourses(file2.getPath());
		
		List note1;
		
		if(n<lines.length) {
		note1 = Arrays.asList(lines[n].toString().trim().split("//"));
		}else{
		note1 = Arrays.asList(lines[0].toString().trim().split("//"));
		}
		NewTest.name.setText((String) note1.get(0));
		NewTest.num.setText((String) note1.get(1));
		NewTest.cours.setText(TestBox.getFullName(Test.getTestCourseName(testId), Home.className));
		NewTest.interro.setText("Interrogation No "+Test.getTestNumber(testId));
		
		
		String note = LPane.loadStudentNote(testId, (String) note1.get(0));
		List note2 = Arrays.asList(LPane.loadStudentNote(testId, (String) note1.get(0)).split("/"));
		if(note.equals("0/0")) {
			points.setText("");
		}else {
		points.setText(note2.get(0).toString());
		}

		maxima.setText("/"+Test.getTestMaxima(testId));
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		points.requestFocus();
	}
	
	public static void saveTestNote(String testId, String note, String name, String courseName) {
		
		List<String>list = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name+"/3eme Trimestre/"+courseName+".txt");
		aws.downloadContent(file.getPath());
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i =0; i<lines.length; i++) {
				list.add(lines[i].toString());
			}

			for(int i = 0; i< list.toArray().length; i++) {
				List l = Arrays.asList(list.get(i).split("//"));
				if(l.get(0).toString().equals(testId)) {
					list.add(i, testId+"//"+note);
					list.remove(i+1);
				}
			}
			
			PrintWriter write = new PrintWriter(file);
			for(int i = 0; i < list.toArray().length;i++) {
			write.println(list.get(i).toString());
			}
			write.close();
			aws.upload(file.getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
