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
import Class.NewCourse;
import CloudOperations.mysql;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class NewEstablishment extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static JTextField name1;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();
	private JLabel notice;
	public static JTextField name2;
	public static JButton actualiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEstablishment frame = new NewEstablishment("Max Brillant");
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
	public NewEstablishment(String userId) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 431);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Creer");
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!schoolNameAlreadyExists(name1.getText())) {
				createEstablishment(name1.getText(),name2.getText(), userId);
				EstablishmentCreated ec = new EstablishmentCreated(userId, name1.getText());
				ec.setVisible(true);
				setVisible(false);
			}else {
				/*
				 * if(schoolHasBeenDeleted(NewEstablishment.getSchoolID(name1.getText()))) {
				 * if(SendAccessRequest.hasRoles(userId,
				 * NewEstablishment.getSchoolID(name1.getText()))) { if(getRole(userId,
				 * NewEstablishment.getSchoolID(name1.getText())).equals("administrator")
				 * ||getRole(userId,
				 * NewEstablishment.getSchoolID(name1.getText())).equals("general_administrator"
				 * )) { restoreEstablishment(NewEstablishment.getSchoolID(name1.getText()));
				 * setVisible(false); UserPanel u = new UserPanel(userId); u.setVisible(true);
				 * setVisible(false); ScholarYears.frame.setVisible(false); } else {
				 * notice.setVisible(true); notice.setText("L'etablissement existe deja."); }
				 * }else { notice.setVisible(true);
				 * notice.setText("L'etablissement existe deja."); } }else {
				 */
				notice.setVisible(true);
				notice.setText("L'etablissement existe deja.");
			}
		}
	});
	create.setEnabled(false);
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
	create.setBounds(29, 349, 182, 31);
	contentPane.add(create);
	
	JLabel lblNouveauCours = new JLabel("<html>Creez un nouvel etablissement scolaire dans Bakame, et ajoutez d'autres utilisateurs qui seront eux aussi responsables de la gestion de cet etablissement.</html>");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 16));
	lblNouveauCours.setBounds(12, 112, 400, 72);
	contentPane.add(lblNouveauCours);
	
	JLabel lblNomDutilisateur = new JLabel("<html>*Nom de l' etablissement:</html>");
	lblNomDutilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDutilisateur.setForeground(Color.WHITE);
	lblNomDutilisateur.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblNomDutilisateur.setBounds(29, 199, 170, 42);
	contentPane.add(lblNomDutilisateur);
	
	name1 = new JTextField();
	name1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!name1.getText().replaceAll(" ", "").isBlank()) {
				create.setEnabled(true);
			}else {
				create.setEnabled(false);
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
	name1.setBounds(163, 213, 214, 28);
	contentPane.add(name1);
	
	JButton btnSinscrire = new JButton("Retour");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(create.isVisible()) {
			UserPanel l = new UserPanel(userId);
			l.setVisible(true);
			setVisible(false);
		}else{
			setVisible(false);
		}}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255, 51, 102).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255, 51, 102));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(255, 51, 102));
	btnSinscrire.setBounds(255, 349, 136, 31);
	contentPane.add(btnSinscrire);
	
	JSeparator separator = new JSeparator();
	separator.setBackground(Color.WHITE);
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 183, 424, 5);
	contentPane.add(separator);
	
	notice = new JLabel("Veuillez repeter le meme mot de passe pour le confirmer");
	notice.setVisible(false);
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(12, 324, 400, 19);
	contentPane.add(notice);
	
	JLabel lblAbbreviation = new JLabel("Abbreviation:");
	lblAbbreviation.setHorizontalAlignment(SwingConstants.TRAILING);
	lblAbbreviation.setForeground(Color.WHITE);
	lblAbbreviation.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblAbbreviation.setBounds(10, 265, 142, 31);
	contentPane.add(lblAbbreviation);
	
	name2 = new JTextField();
	name2.setHorizontalAlignment(SwingConstants.CENTER);
	name2.setForeground(Color.WHITE);
	name2.setFont(new Font("Arial", Font.PLAIN, 20));
	name2.setColumns(10);
	name2.setCaretColor(new Color(0, 204, 255));
	name2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	name2.setBackground(new Color(40, 40, 40));
	name2.setBounds(165, 266, 182, 28);
	contentPane.add(name2);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if(!schoolNameAlreadyExists(name1.getText())) {
			ScholarYears.updateEstablishment(Login.selectedSchoolID, name1.getText(), name2.getText());
			UserPanel u = new UserPanel(userId);
			u.setVisible(true);
			ScholarYears.frame.setVisible(false);
			setVisible(false);
			}else {
				notice.setVisible(true);
				notice.setText("L'etablissement existe deja.");
			}
		}
	});
	actualiser.setVisible(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setFocusPainted(false);
	actualiser.setBounds(new Rectangle(32, 199, 120, 31));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(29, 349, 182, 31);
	contentPane.add(actualiser);

	setLocationRelativeTo(null);
	}
	public static boolean schoolNameAlreadyExists(String name) {
		boolean exists = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from schools "
				+ "WHERE full_name = '"+name+"' LIMIT 1");
		
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

	public static void createEstablishment(String name, String name2, String userId) {
		List<String> comp = new ArrayList();
File file1 = new File("Data/Establishments/Establishments.txt");
		
		try {
			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i<lines1.length; i++) {
				comp.add(lines1[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}	
		String id = UUID.randomUUID().toString();
		if(!name2.replaceAll(" ", "").isBlank()) {
		comp.add(id+"//"+name+"//"+name2+"//active");
		}else {
			comp.add(id+"//"+name+"//"+name+"//active");
		}
		
File file11 = new File("Data/Establishments/Establishments.txt");
		
		if(file11.exists()) {
					file11.delete();
				}
		
			try {
				file11.createNewFile();
				PrintWriter pw = new PrintWriter(file11);

				for(int j = 0;j<comp.toArray().length;j++) {
				pw.println((String)comp.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			File file3 = new File("Data/Establishments/"+id);
			
			if(file3.exists()) {
						file3.delete();
					}
					file3.mkdir();
					
					

					File file111 = new File("Data/Establishments/"+id+"/Preferences.txt");
					
					if(file111.exists()) {
								file111.delete();
							}
					
						try {
							file111.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
						File file1111 = new File("Data/Establishments/"+id+"/Licence.txt");
						
						if(file1111.exists()) {
									file1111.delete();
								}
						
							try {
								file1111.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
						}File file11111 = new File("Data/Establishments/"+id+"/Scholar years.txt");
						
						if(file11111.exists()) {
									file11111.delete();
								}
						
							try {
								file11111.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
						}
							File file111111 = new File("Data/Establishments/"+id+"/Users.txt");
							
							if(file111111.exists()) {
										file111111.delete();
									}
							
								try {
									file111111.createNewFile();
									PrintWriter pw = new PrintWriter(file111111);

									pw.println(userId+"//General Administrator");
									
									pw.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
							}
								File file1111111 = new File("Data/Establishments/"+id+"/Requests.txt");
								
								if(file1111111.exists()) {
											file1111111.delete();
										}
								
									try {
										file1111111.createNewFile();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									
								}
									
									File file11111111 = new File("Data/Establishments/"+id+"/Roles.txt");
									
									if(file11111111.exists()) {
										file11111111.delete();
											}
									
										try {
											file11111111.createNewFile();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										
									}
									
									
			}
	
	
	public static boolean schoolHasBeenDeleted(String school_id) {
		boolean exists = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from schools "
				+ "WHERE school_id = '"+school_id+"' AND is_active = 0 LIMIT 1");
		
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
	
	
	public static void restoreEstablishment(String schoolId) {

		List<String> comp = new ArrayList();
File file1 = new File("Data/Establishments/Establishments.txt");
		
		try {
			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i<lines1.length; i++) {
				comp.add(lines1[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}	
		for(int i = 0; i< comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).split("//"));
			if(l.get(0).equals(schoolId)) {
				comp.add(i, l.get(0).toString()+"//"+l.get(1).toString()+"//"+l.get(2).toString()+"//active");
				comp.remove(i+1);
			}
		}
		
File file11 = new File("Data/Establishments/Establishments.txt");
		
		if(file11.exists()) {
					file11.delete();
				}
		
			try {
				file11.createNewFile();
				PrintWriter pw = new PrintWriter(file11);

				for(int j = 0;j<comp.toArray().length;j++) {
				pw.println((String)comp.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
}