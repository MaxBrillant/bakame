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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import Publishing.getInternetDateAndTime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class UserPanel extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();
	public static JPanel panel_2;
	public static String selectedRole;
	public static String selectedCategory;
	public static String numberOfAllowedStudents;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel("Max Brillant");
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
	public UserPanel(String userID) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 500, 500);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(60, 60, 60));
	panel.setPreferredSize(new Dimension(10, 200));
	contentPane.add(panel, BorderLayout.SOUTH);
	panel.setLayout(null);
	
	JButton btnNewButton = new JButton("<html><div style='text-align: left;'>Creer un nouvel etablissement</div></html>");
	btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
	btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnNewButton.setIconTextGap(-10);
	btnNewButton.setIcon(ResizeImages.resize(100, 100, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\New_School.png"));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			NewEstablishment ne = new NewEstablishment(userID);
			ne.setVisible(true);
			setVisible(false);
		}
	});
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNewButton.setBackground(new Color(20, 148, 198));
		}@Override
		public void mouseExited(MouseEvent e) {
			btnNewButton.setBackground(new Color(60, 60, 60));
		}
	});
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setFocusPainted(false);
	btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
	btnNewButton.setBackground(new Color(60, 60, 60));
	btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 18));
	btnNewButton.setBounds(49, 34, 165, 155);
	panel.add(btnNewButton);
	
	JButton button = new JButton("<html><div style='text-align: left;'>Se connecter a un etablissement existant</div></html>");
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setIconTextGap(-10);
	button.setIcon(ResizeImages.resize(100, 100, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Enter_School.png"));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SendAccessRequest l = new SendAccessRequest(userID);
			l.setVisible(true);
			setVisible(false);
		
		}
	});
	button.setForeground(new Color(255, 255, 255));
	button.setFocusPainted(false);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
	button.setBackground(new Color(60, 60, 60));
	button.setFont(new Font("Roboto", Font.PLAIN, 18));
	button.setBounds(259, 34, 165, 155);
	panel.add(button);
	
	button.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			button.setBackground(new Color(20, 148, 198));
		}@Override
		public void mouseExited(MouseEvent e) {
			button.setBackground(new Color(60, 60, 60));
		}
	});
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(60, 60, 60));
	panel_1.setPreferredSize(new Dimension(10, 100));
	contentPane.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(null);
	
	JButton btnNewButton_1 = new JButton("Retour");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Login l = new Login();
			l.setVisible(true);
			setVisible(false);
		
		}
	});
	btnNewButton_1.setFocusPainted(false);
	btnNewButton_1.setBorderPainted(false);
	btnNewButton_1.setBackground(new Color(60, 60, 60));
	btnNewButton_1.setForeground(new Color(255, 255, 255));
	btnNewButton_1.setIconTextGap(0);
	btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
	btnNewButton_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	btnNewButton_1.setBounds(0, 0, 74, 40);
	panel_1.add(btnNewButton_1);

	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNewButton_1.setBackground(new Color(60, 60, 60).brighter());
		}@Override
		public void mouseExited(MouseEvent e) {
			btnNewButton_1.setBackground(new Color(60, 60, 60));
			btnNewButton_1.setForeground(Color.white);
		}
	});
	
	JLabel lblNewLabel = new JLabel("Etablissements");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(104, 70, 265, 24);
	panel_1.add(lblNewLabel);
	
	JLabel lblMaxBrillant = new JLabel("<html><div style='text-align: left;'>"+Login.getUserName(userID)+"</div></html>");
	lblMaxBrillant.setVerticalAlignment(SwingConstants.TOP);
	lblMaxBrillant.setHorizontalAlignment(SwingConstants.LEFT);
	lblMaxBrillant.setForeground(Color.WHITE);
	lblMaxBrillant.setFont(new Font("Futura Hv BT", Font.PLAIN, 30));
	lblMaxBrillant.setBounds(79, 0, 278, 66);
	panel_1.add(lblMaxBrillant);
	
	JButton btnModifier = new JButton("Modifier");
	btnModifier.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			Signup ne = new Signup();
			ne.setVisible(true);
			ne.actualiser.setVisible(true);
			ne.create.setVisible(false);
			//ne.name1.setText(Login.selectedUserName);
			//ne.pass1.setText(getUserPassword(Login.getUserId(Login.selectedUserName)));
			//ne.pass2.setText(getUserPassword(Login.getUserId(Login.selectedUserName)));
		
		}
	});
	btnModifier.setBorder(new LineBorder(new Color(255, 255, 255)));
	btnModifier.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnModifier.setIconTextGap(0);
	btnModifier.setHorizontalTextPosition(SwingConstants.CENTER);
	btnModifier.setForeground(Color.WHITE);
	btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnModifier.setFocusPainted(false);
	btnModifier.setBackground(new Color(60, 60, 60));
	btnModifier.setBounds(358, 11, 106, 24);
	panel_1.add(btnModifier);
	
	btnModifier.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnModifier.setBackground(Color.white);
			btnModifier.setForeground(Color.black);
		}@Override
		public void mouseExited(MouseEvent e) {
			btnModifier.setBackground(new Color(60, 60, 60));
			btnModifier.setForeground(Color.white);
		}
	});
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBorder(null);
	contentPane.add(scrollPane, BorderLayout.CENTER);
	
	panel_2 = new JPanel();
	panel_2.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
	
	
	JPanel panel_3 = new JPanel();
	panel_3.setBackground(new Color(60, 60, 60).brighter());
	panel_3.setPreferredSize(new Dimension(450, 40));
	panel_2.add(panel_3);
	panel_3.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Ecole Internationale de Bujumbura");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(10, 0, 244, 40);
	panel_3.add(lblNewLabel_1);
	
	JLabel lblAdministrateur = new JLabel("Administrateur");
	lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
	lblAdministrateur.setForeground(Color.WHITE);
	lblAdministrateur.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblAdministrateur.setBounds(271, 0, 169, 40);
	panel_3.add(lblAdministrateur);
	setLocationRelativeTo(null);

	
	loadEstablishment(userID);
	}
	
	
	public static void loadEstablishment(String userId) {
		panel_2.removeAll();


		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users_in_schools AS UIS "
					+ "JOIN schools AS s "
					+ "WHERE UIS.user_id = '"+userId+"' AND UIS.school_id = s.school_id AND s.is_active = 1");
			while(rs.next())
			{
									JPanel panel_3 = new JPanel();
									panel_3.setBackground(new Color(60, 60, 60).brighter());
									panel_3.setPreferredSize(new Dimension(450, 40));
									panel_2.add(panel_3);
									panel_3.setLayout(null);
									panel_3.setName(rs.getString("school_id"));
									
									JLabel lblNewLabel_1 = new JLabel(getSchoolFullName(rs.getString("school_id")));
									lblNewLabel_1.setForeground(Color.WHITE);
									lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
									lblNewLabel_1.setBounds(10, 0, 244, 40);
									panel_3.add(lblNewLabel_1);
									
									String s = null;
									if(rs.getString("responsibility").equals("administrator")) {
										s = "Administrateur";
									}else if(rs.getString("responsibility").equals("editor")) {
										s = "Editeur";
									}else if(rs.getString("responsibility").equals("general_administrator")) {
										s = "Administrateur General";
									}
									JLabel lblAdministrateur = new JLabel(s);
									lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
									lblAdministrateur.setForeground(Color.WHITE);
									lblAdministrateur.setFont(new Font("Roboto", Font.PLAIN, 15));
									lblAdministrateur.setBounds(271, 0, 169, 40);
									panel_3.add(lblAdministrateur);
									

									panel_3.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseEntered(MouseEvent e) {
											panel_3.setBorder(new LineBorder(new Color(20, 148, 198),3));
										}@Override
										public void mouseExited(MouseEvent e) {
											panel_3.setBorder(null);
										}public void mouseClicked(MouseEvent e) {
											if(e.getClickCount()==2) {

												Loading l = new Loading();
												l.setVisible(true);
												
												 new Thread(new Runnable(){
													    @Override
													    public void run(){

													    	Login.selectedSchoolID = panel_3.getName();
															selectedRole = ((JLabel) panel_3.getComponent(1)).getText();
															try {
																ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
																window.frame.setVisible(true);
																SwingUtilities.getRoot(contentPane).setVisible(false);
			
															} catch (Exception e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
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
										}
									});
			}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
				if(panel_2.getComponentCount()==0) {
					JLabel lblNewLabel_2 = new JLabel("Vous n'avez acces a aucun etablissement pour le moment");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel_2.add(lblNewLabel_2);
				}
	}
	
	
	public static String getSchoolFullName(String schoolID) {
		String name = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from schools "
					+ "WHERE school_id = '"+schoolID+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("full_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return name;
	}
	
	public static String getSchoolShortName(String schoolID) {
		String name = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from schools "
					+ "WHERE school_id = '"+schoolID+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("short_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return name;
	}
	
}