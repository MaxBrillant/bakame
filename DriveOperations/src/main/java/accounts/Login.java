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
import javax.swing.SwingUtilities;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import Application.ResizeImages;
import Class.NewCourse;
import CloudOperations.mysql;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	public static boolean isEmpty = false;
	public static JTextField name1;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();
	private JPasswordField passwordField;
	private JLabel notice;
	public static String selectedUserID = "1";
	public static String selectedSchoolID = "1";
	public static String selectedAcademicYearID = "1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		

		mysql.connectToDB();
		
		
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
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Loading l = new Loading();
			l.setVisible(true);
			
		    new Thread(new Runnable(){
		    @Override
		    public void run(){

				if(verifyAccount(name1.getText(), passwordField.getText())) {
					UserPanel up = new UserPanel(getUserId(name1.getText(), passwordField.getText()));
					up.setVisible(true);
					setVisible(false);
					selectedUserID = getUserId(name1.getText(), passwordField.getText());
				}else {
					notice.setVisible(true);
				}
		       //time consuming algorithm.
		         SwingUtilities.invokeLater(new Runnable(){
		             @Override public void run(){
		            	 l.setVisible(false);
		           }
		          });
		       }

		    }).start();
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
	create.setBounds(131, 289, 161, 31);
	contentPane.add(create);
	
	actualiser = new JButton("Actualiser");
	actualiser.setVisible(false);
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(new Rectangle(132, 289, 161, 31));
	contentPane.add(actualiser);
	
	JLabel lblNouveauCours = new JLabel("Connectez vous a votre compte");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 23));
	lblNouveauCours.setBounds(0, 141, 424, 28);
	contentPane.add(lblNouveauCours);
	
	JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur:");
	lblNomDutilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDutilisateur.setForeground(Color.WHITE);
	lblNomDutilisateur.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDutilisateur.setBounds(30, 190, 149, 31);
	contentPane.add(lblNomDutilisateur);
	
	name1 = new JTextField();
	name1.setHorizontalAlignment(SwingConstants.CENTER);
	name1.setForeground(Color.WHITE);
	name1.setFont(new Font("Arial", Font.PLAIN, 20));
	name1.setColumns(10);
	name1.setCaretColor(new Color(0, 204, 255));
	name1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	name1.setBackground(new Color(40, 40, 40));
	name1.setBounds(197, 190, 161, 28);
	contentPane.add(name1);
	
	JLabel lblMotDePasse = new JLabel("Mot de passe:");
	lblMotDePasse.setHorizontalAlignment(SwingConstants.TRAILING);
	lblMotDePasse.setForeground(Color.WHITE);
	lblMotDePasse.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblMotDePasse.setBounds(30, 232, 149, 31);
	contentPane.add(lblMotDePasse);
	
	JLabel lblVousNetesPas = new JLabel("Vous ne vous etes pas encore inscrit?");
	lblVousNetesPas.setHorizontalAlignment(SwingConstants.CENTER);
	lblVousNetesPas.setForeground(Color.WHITE);
	lblVousNetesPas.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblVousNetesPas.setBounds(25, 331, 373, 20);
	contentPane.add(lblVousNetesPas);
	
	JButton btnSinscrire = new JButton("Creer un compte");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Signup l = new Signup();
			l.setVisible(true);
			setVisible(false);
		}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(20, 148, 198).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(20, 148, 198));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(20, 148, 198));
	btnSinscrire.setBounds(121, 363, 181, 31);
	contentPane.add(btnSinscrire);
	
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
	lblNewLabel.setBounds(153, 11, 117, 90);
	contentPane.add(lblNewLabel);
	
	JSeparator separator = new JSeparator();
	separator.setBackground(Color.WHITE);
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 173, 424, 5);
	contentPane.add(separator);
	
	JLabel lblBienvenu = new JLabel("Bienvenue!");
	lblBienvenu.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblBienvenu.setIconTextGap(0);
	lblBienvenu.setHorizontalTextPosition(SwingConstants.CENTER);
	lblBienvenu.setHorizontalAlignment(SwingConstants.CENTER);
	lblBienvenu.setForeground(Color.WHITE);
	lblBienvenu.setFont(new Font("Futura Hv BT", Font.BOLD, 27));
	lblBienvenu.setBounds(0, 102, 424, 28);
	contentPane.add(lblBienvenu);
	
	passwordField = new JPasswordField();
	passwordField.setForeground(new Color(255, 255, 255));
	passwordField.setCaretColor(new Color(0, 204, 255));
	passwordField.setHorizontalAlignment(SwingConstants.CENTER);
	passwordField.setBorder(new LineBorder(Color.GRAY));
	passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
	passwordField.setBackground(new Color(40, 40, 40));
	passwordField.setBounds(197, 230, 161, 28);
	contentPane.add(passwordField);
	
	notice = new JLabel("Le nom d'utilisateur ou le mot de passe est incorrect");
	notice.setVisible(false);
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(10, 264, 404, 20);
	contentPane.add(notice);

	setLocationRelativeTo(null);
	}
	
	public static boolean verifyAccount(String username, String passWord) {
		boolean granted = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from users "
				+ "WHERE username = '"+username+"' AND password = '"+passWord+"'");
		
		int i = 0;
		while(rs.next())
		{
			i++;
		}
		if(i == 1) {
			granted = true;
		}else {
			granted = false;
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

		return granted;
	}
	public static String getUserId(String name, String password) {
		String id = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users "
					+ "WHERE username = '"+name+"' AND password = '"+password+"' LIMIT 1");
			while(rs.next())
			{
				id = rs.getString("user_id");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return id;
	}
	
	public static String getUserName(String userID) {
		String name = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users "
					+ "WHERE user_id = '"+userID+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("username");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return name;
	}
	public static String getUserRole(String schoolID, String userID) {
		String role = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users_in_schools "
					+ "WHERE school_id = '"+schoolID+"' AND user_id = '"+userID+"' LIMIT 1");
			while(rs.next())
			{
				role = rs.getString("responsibility");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return role;
	}
}