package accounts;

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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import Application.Home;
import Application.ResizeImages;
import Class.NewCourse;
import Publishing.getInternetDateAndTime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class GenerateKey extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static JTextField students;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();
	public static JLabel key;
	private JComboBox category;
	private JComboBox days;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateKey frame = new GenerateKey("44878bff-9645-4b70-b6a3-996905cb9402");
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
	public GenerateKey(String schoolID) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 530);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Generate");
	create.setEnabled(false);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkForKey(category.getSelectedItem().toString(), students.getText(), days.getSelectedItem().toString());
		}
	});
	create.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			create.setBackground(new Color(0, 171, 89).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {

			create.setBackground(new Color(0, 171, 89));
		}
	});
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(59, 345, 305, 31);
	contentPane.add(create);
	
	JLabel lblNomDutilisateur = new JLabel("Number of students:");
	lblNomDutilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDutilisateur.setForeground(Color.WHITE);
	lblNomDutilisateur.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDutilisateur.setBounds(29, 188, 182, 31);
	contentPane.add(lblNomDutilisateur);
	
	students = new JTextField();
	students.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!students.getText().replace(" ", "").isBlank()) {
				create.setEnabled(true);
			}else {
				create.setEnabled(false);
			}
		}
	});
	students.setHorizontalAlignment(SwingConstants.CENTER);
	students.setForeground(Color.WHITE);
	students.setFont(new Font("Arial", Font.PLAIN, 20));
	students.setColumns(10);
	students.setCaretColor(new Color(0, 204, 255));
	students.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	students.setBackground(new Color(40, 40, 40));
	students.setBounds(217, 188, 136, 28);
	contentPane.add(students);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "Icons\\Bakame.png"));
	label.setBounds(157, 20, 110, 90);
	contentPane.add(label);
	
	JLabel lblVotreLicenceDutilisation = new JLabel("Key Generator");
	lblVotreLicenceDutilisation.setHorizontalAlignment(SwingConstants.CENTER);
	lblVotreLicenceDutilisation.setForeground(Color.WHITE);
	lblVotreLicenceDutilisation.setFont(new Font("Roboto", Font.BOLD, 25));
	lblVotreLicenceDutilisation.setBounds(12, 116, 400, 40);
	contentPane.add(lblVotreLicenceDutilisation);
	
	JLabel lblEtablissementEcoleInternationale = new JLabel(NewEstablishment.getSchoolName(schoolID));
	lblEtablissementEcoleInternationale.setHorizontalAlignment(SwingConstants.CENTER);
	lblEtablissementEcoleInternationale.setForeground(Color.WHITE);
	lblEtablissementEcoleInternationale.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblEtablissementEcoleInternationale.setBounds(12, 152, 400, 25);
	contentPane.add(lblEtablissementEcoleInternationale);
	
	JLabel lblCategory = new JLabel("Category:");
	lblCategory.setHorizontalAlignment(SwingConstants.TRAILING);
	lblCategory.setForeground(Color.WHITE);
	lblCategory.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblCategory.setBounds(29, 230, 182, 31);
	contentPane.add(lblCategory);
	
	JLabel lblNumberOfDays = new JLabel("Number of days:");
	lblNumberOfDays.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNumberOfDays.setForeground(Color.WHITE);
	lblNumberOfDays.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNumberOfDays.setBounds(29, 272, 182, 31);
	contentPane.add(lblNumberOfDays);
	
	key = new JLabel("028osp567uts363");
	key.setVisible(false);
	key.setBackground(new Color(0, 102, 255));
	key.setOpaque(true);
	key.setHorizontalAlignment(SwingConstants.CENTER);
	key.setForeground(Color.WHITE);
	key.setFont(new Font("Roboto", Font.BOLD, 30));
	key.setBounds(12, 395, 400, 68);
	contentPane.add(key);
	
	category = new JComboBox();
	category.setModel(new DefaultComboBoxModel(new String[] {"Basic", "Standard", "Premium"}));
	category.setFont(new Font("Roboto", Font.PLAIN, 20));
	category.setBounds(217, 234, 136, 25);
	contentPane.add(category);
	
	days = new JComboBox();
	days.setModel(new DefaultComboBoxModel(new String[] {"7", "30", "90", "360"}));
	days.setFont(new Font("Roboto", Font.PLAIN, 20));
	days.setBounds(217, 272, 69, 25);
	contentPane.add(days);

	setLocationRelativeTo(null);
	}
	
	public static void checkForKey(String category, String students, String days) {

		List<String> content = new ArrayList();

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIATCPCBRZ572L66UD7", "rInnepuleetF0etEnZseelyDdsrSAx20hSsptmKw");
		AmazonS3 s3Client;
		s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-2").withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.build();
		System.out.println("Downloading...");
	S3Object fullObject;
	fullObject = s3Client.getObject(new GetObjectRequest("bakamedata", "Keys/"+category+".txt"));
	System.out.println("--File "+"Keys/"+category+".txt"+" downloaded successfully");
	// Print file content line by line
	InputStream is = fullObject.getObjectContent();
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	String line;
	try {
		while ((line = reader.readLine()) != null) {
			content.add(line+"//"+"Keys/"+category+".txt");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i = 0; i< content.toArray().length; i++) {
		List l = Arrays.asList(content.get(i).split("//"));
		if(l.get(1).toString().equals(days)) {
			String s = l.get(0).toString()+"//"+l.get(1).toString()+"//"+students+"//Keys/"+category+".txt";
			content.add(i, s);
			content.remove(i+1);
			key.setVisible(true);
			key.setText(l.get(0).toString());
			break;
		}
	}
		List<String> refreshed = new ArrayList();
		for(int i = 0; i< content.toArray().length; i++) {
			List l1 = Arrays.asList(content.get(i).split("//"));
			if(l1.get(3).toString().equals("Keys/"+category+".txt")) {
			refreshed.add(l1.get(0).toString()+"//"+l1.get(1).toString()+"//"+l1.get(2).toString());
		}}
		String listString = String.join("\n", refreshed);
		s3Client.putObject("bakamedata", "Keys/"+category+".txt", listString);
}
}