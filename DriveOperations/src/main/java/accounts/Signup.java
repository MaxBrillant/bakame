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
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Class.NewCourse;
import CloudOperations.mysql;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class Signup extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static JTextField name1;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();
	public static JPasswordField pass1;
	public static JPasswordField pass2;
	public static JLabel notice;
	public static JButton actualiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 424);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Creer le compte");
	create.setEnabled(false);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!userNamealreadyExists(name1.getText())&& !passwordalreadyExists(pass1.getText())) {
			AccountCreated ac = new AccountCreated();
			ac.setVisible(true);
			setVisible(false);
			createAccount(name1.getText(), pass1.getText());
		}else {
			notice.setVisible(true);
			notice.setText("Le mot de passe ou le nom d'utilisateur est deja utilise");
		}
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
	create.setBounds(29, 338, 182, 31);
	contentPane.add(create);
	
	JLabel lblNouveauCours = new JLabel("<html>Creez un compte afin de pouvoir vous connecter aux serveurs de CiGiCom. Apres avoir complete l'inscription, vous pourrez vous connecter a votre nouveau compte et ainsi utiliser Bakame.</html>");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNouveauCours.setBounds(12, 97, 400, 72);
	contentPane.add(lblNouveauCours);
	
	JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur:");
	lblNomDutilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDutilisateur.setForeground(Color.WHITE);
	lblNomDutilisateur.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDutilisateur.setBounds(24, 190, 149, 31);
	contentPane.add(lblNomDutilisateur);
	
	name1 = new JTextField();
	name1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!name1.getText().replace(" ", "").isBlank()&& pass1.getText().equals(pass2.getText()) && !pass1.getText().replace(" ", "").isBlank()&& !pass2.getText().replace(" ", "").isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
			}
		}
	});
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
	lblMotDePasse.setBounds(29, 232, 144, 31);
	contentPane.add(lblMotDePasse);
	
	JButton btnSinscrire = new JButton("Retour");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(create.isVisible()) {
			Login l = new Login();
			l.setVisible(true);
			setVisible(false);
		}else{
			setVisible(false);
		}}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255, 102, 102).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255, 102, 102));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(255, 102, 102));
	btnSinscrire.setBounds(255, 338, 136, 31);
	contentPane.add(btnSinscrire);
	
	JSeparator separator = new JSeparator();
	separator.setBackground(Color.WHITE);
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 173, 424, 5);
	contentPane.add(separator);
	
	pass1 = new JPasswordField();
	pass1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(pass2.getText().equals(pass1.getText())&& !pass2.getText().replaceAll(" ", "").isBlank()&& !pass1.getText().replaceAll(" ", "").isBlank()&& !name1.getText().replaceAll(" ", "").isBlank()) {
			create.setEnabled(true);
			actualiser.setEnabled(true);
		}else {
			create.setEnabled(false);
			actualiser.setEnabled(false);
		}
			if(!pass2.getText().equals(pass1.getText())) {
				
			}
			if(!pass2.getText().equals(pass1.getText())) {
						notice.setVisible(true);	
						notice.setText("Veuillez repeter le meme mot de passe pour le confirmer");
						}else {
							notice.setVisible(false);	
							if(pass1.getText().length()+1<=8) {
								notice.setVisible(true);	
								notice.setText("Le mot de passe doit contenir au moins 8 caracteres");
								create.setEnabled(false);
								actualiser.setEnabled(false);
							}else {
								notice.setVisible(false);
							}
						}
			}
	});
	pass1.setForeground(new Color(255, 255, 255));
	pass1.setCaretColor(new Color(0, 204, 255));
	pass1.setHorizontalAlignment(SwingConstants.CENTER);
	pass1.setBorder(new LineBorder(Color.GRAY));
	pass1.setFont(new Font("Arial", Font.PLAIN, 20));
	pass1.setBackground(new Color(40, 40, 40));
	pass1.setBounds(197, 230, 161, 28);
	contentPane.add(pass1);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "Icons\\cg_colored.png"));
	label.setBounds(157, 5, 110, 90);
	contentPane.add(label);
	
	pass2 = new JPasswordField();
	pass2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			
			if(pass2.getText().equals(pass1.getText())&& !pass2.getText().replaceAll(" ", "").isBlank()&& !pass1.getText().replaceAll(" ", "").isBlank()&& !name1.getText().replaceAll(" ", "").isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
				notice.setText("Veuillez repeter le meme mot de passe pour le confirmer");
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
			}
if(!pass2.getText().equals(pass1.getText())) {
			notice.setVisible(true);	
			notice.setText("Veuillez repeter le meme mot de passe pour le confirmer");
			}else {
				notice.setVisible(false);	

				if(pass1.getText().length()+1<=8) {
					notice.setVisible(true);	
					notice.setText("Le mot de passe doit contenir au moins 8 caracteres");
					create.setEnabled(false);
					actualiser.setEnabled(false);
				}else {
					notice.setVisible(false);
				}
			}
		}
	});
	pass2.setHorizontalAlignment(SwingConstants.CENTER);
	pass2.setForeground(Color.WHITE);
	pass2.setFont(new Font("Arial", Font.PLAIN, 20));
	pass2.setCaretColor(new Color(0, 204, 255));
	pass2.setBorder(new LineBorder(Color.GRAY));
	pass2.setBackground(new Color(40, 40, 40));
	pass2.setBounds(197, 274, 161, 28);
	contentPane.add(pass2);
	
	JLabel lblConfirmerMDe = new JLabel("Confirmer:");
	lblConfirmerMDe.setHorizontalAlignment(SwingConstants.TRAILING);
	lblConfirmerMDe.setForeground(Color.WHITE);
	lblConfirmerMDe.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblConfirmerMDe.setBounds(29, 276, 144, 31);
	contentPane.add(lblConfirmerMDe);
	
	notice = new JLabel("Veuillez repeter le meme mot de passe pour le confirmer");
	notice.setVisible(false);
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(12, 313, 400, 19);
	contentPane.add(notice);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!userNamealreadyExists(name1.getText())|| !passwordalreadyExists(pass1.getText())) {
			AccountCreated ac = new AccountCreated();
			ac.setVisible(true);
			setVisible(false);
			updateUser(Login.selectedUserID, name1.getText(), pass1.getText());

			SwingUtilities.getRoot(UserPanel.contentPane).setVisible(false);
		}else if(userNamealreadyExists(name1.getText())&& passwordalreadyExists(pass1.getText())) {
			notice.setVisible(true);
			notice.setText("Le mot de passe ou le nom d'utilisateur est deja utilise");
		}
			
		}
	});
	actualiser.setVisible(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setFocusPainted(false);
	actualiser.setBounds(new Rectangle(32, 199, 120, 31));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(29, 338, 182, 31);
	contentPane.add(actualiser);

	setLocationRelativeTo(null);
	}
	
	

	public static void updateUser(String userID, String userName, String password) {

		Statement stmt;
		try {
			stmt = mysql.con.createStatement();
		stmt.executeUpdate("UPDATE users " + 
				"SET username = '"+userName+"', password = '"+password
						+ "' WHERE user_id = "+userID);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static boolean userNamealreadyExists(String userName) {
		boolean exists = false;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users "
					+ "WHERE username = '"+userName+"'");

			int i = 0;
			while(rs.next())
			{
				i++;
			}
			if(i == 1) {
				exists = true;
			}else {
				exists = false;
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return exists;
	}
	public static boolean passwordalreadyExists(String passWord) {
		boolean exists = false;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users "
					+ "WHERE password = '"+passWord+"'");
			
			int i = 0;
			while(rs.next())
			{
				i++;
			}
			if(i == 1) {
				exists = true;
			}else {
				exists = false;
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return exists;
	}
	


	public static void createAccount(String name, String pass) {

		Statement stmt;
		try {
			stmt = mysql.con.createStatement();
		stmt.executeUpdate("INSERT INTO users(username, password) " + 
				"VALUES('"+name+"', '"+pass+"')");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}