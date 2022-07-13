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
import sideInformation.MainInfo;
import sideInformation.UserInfo;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import java.awt.Component;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.joda.time.DateTime;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import Application.Class;
import Application.ClassStudents;
import Application.Group;
import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.CustomVerticalScrollBarUI;
import Class.NewCourse;
import Class.OptionsMenu.HomeMenu1;
import Class.OptionsMenu.HomeMenu2;
import Class.OptionsMenu.HomeMenu3;
import CloudOperations.mysql;
import Publishing.Connection;
import Publishing.getInternetDateAndTime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Point;

public class UserPanel extends JFrame {

	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();
	public static String selectedRole = "Administrateur General";
	public static String selectedCategory;
	public static String numberOfAllowedStudents;
	private static JPanel panelSchools;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel("1");
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
		
		


//
//		
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//		} catch (ClassNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (InstantiationException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (IllegalAccessException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		getContentPane().setBackground(new Color(40, 40, 40));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screensize.width,screensize.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(720, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(20, 148, 198));
		panel_1.setPreferredSize(new Dimension(10, 45));
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel classe = new JLabel();
		classe.setText("Bienvenue, "+Login.getUserName(userID));
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Roboto", Font.BOLD, 16));
		panel_1.add(classe, BorderLayout.CENTER);
		
		JButton btnAs = new JButton("Se deconnecter");
		btnAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			
			}
		});
		btnAs.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		//button_2.setPreferredSize(new Dimension(150, 14));
		btnAs.setForeground(Color.WHITE);
		btnAs.setFont(new Font("Roboto", Font.BOLD, 16));
		btnAs.setFocusPainted(false);
		btnAs.setBorderPainted(false);
		btnAs.setBackground(new Color(20, 148, 198));
		panel_1.add(btnAs, BorderLayout.WEST);
		
		
		JPanel p = new JPanel();
		p.setForeground(new Color(0, 128, 128));
		p.setBackground(new Color(40, 40, 40));
		p.setLayout(new BorderLayout(0, 0));
		getContentPane().add(p, BorderLayout.CENTER);
		
		
		JPanel p2 = new JPanel();
		p2.setBorder(null);
		p2.setForeground(new Color(0, 128, 128));
		p2.setBackground(new Color(40, 40, 40));
		p2.setLayout(new BorderLayout(0, 0));
		p.add(p2, BorderLayout.CENTER);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for(int i = 0; i< ((Container) scrollPane.getViewport().getComponent(0)).getComponentCount(); i++) {
					if(((Container) scrollPane.getViewport().getComponent(0)).getComponent(i) instanceof JLabel) {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-50, ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).getPreferredSize().height));

						}}

				scrollPane.getViewport().getComponent(0).revalidate();
				scrollPane.getViewport().getComponent(0).repaint();
			
			}
		});
		scrollPane.setBorder(null);
		p2.add(scrollPane, BorderLayout.CENTER);
		
		panelSchools = new JPanel();
		panelSchools.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panelSchools);
		panelSchools.setLayout(new WrapLayout(0, 20, 20));

		

		JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Ceci est la liste des etablissements auquels vous avez acces, ainsi que les roles qui vous sont assignes. Cliquez sur \"ouvrir\" pour continuer.</div></html>");
		lblNewLabel.setPreferredSize(new Dimension(500, 100));
		lblNewLabel.setBackground(new Color(60, 60, 60));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		panelSchools.add(lblNewLabel);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(211, 211, 211)));
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setPreferredSize(new Dimension(200, 200));
		panelSchools.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(ResizeImages.resize(100, 100, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\book.png"));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setPreferredSize(new Dimension(46, 100));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setBackground(panel_6.getParent().getBackground());
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("<html><div style='text-align: center;'>Ecole Internationale</div></html>");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setPreferredSize(new Dimension(165, 40));
		lblNewLabel_4.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(211, 211, 211)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_6.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.CENTER);
		panel_7.setBackground(panel_7.getParent().getBackground());
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
		
		JLabel lblNewLabel_5 = new JLabel(" Administrateur ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(20, 148, 198));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_7.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Ouvrir");
		btnNewButton.setFocusPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(20, 148, 198));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(btnNewButton.getParent().getBackground());
			}
		});
		btnNewButton.setPreferredSize(new Dimension(89, 35));
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6.add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.setBackground(btnNewButton.getParent().getBackground());
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane1.setBorder(null);
		p.add(scrollPane1, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		//panel_5.setPreferredSize(new Dimension(10, 70));
		panel_5.setBackground(new Color(40, 40, 40));
		scrollPane1.setViewportView(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 3));
		
		
		JButton logo = new JButton("");
		logo.setMultiClickThreshhold(1000L);
		logo.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		logo.setPreferredSize(new Dimension(70, 70));
		logo.setFont(new Font("Arial", Font.PLAIN, 27));
		logo.setFocusPainted(false);
		logo.setBorder(null);
		logo.setBackground(panel_5.getBackground());
		panel_5.add(logo);
		
		
		JButton btnNewButton1 = new JButton("Creer une ecole");
		btnNewButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton1.setBackground(new Color(20, 148, 198));
				
			}public void mouseExited(MouseEvent e) {
				btnNewButton1.setBackground(new Color(40, 40, 40));
				
			}
		});
		btnNewButton1.setMultiClickThreshhold(1000L);
		btnNewButton1.setFocusPainted(false);
		btnNewButton1.setPreferredSize(new Dimension(200, 60));
		btnNewButton1.setBorder(new LineBorder(new Color(20, 148, 198), 2));
		btnNewButton1.setIconTextGap(10);
		btnNewButton1.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewButton1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton1.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\New_School.png"));
		btnNewButton1.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton1.setBackground(new Color(40, 40, 40));
		btnNewButton1.setForeground(Color.white);
		panel_5.add(btnNewButton1);

		
		JButton btnJoindreUneEcole = new JButton("Joindre une ecole");
		btnJoindreUneEcole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnJoindreUneEcole.setBackground(new Color(20, 148, 198));
				
			}public void mouseExited(MouseEvent e) {
				btnJoindreUneEcole.setBackground(new Color(40, 40, 40));
				
			}
		});
		btnJoindreUneEcole.setMultiClickThreshhold(1000L);
		btnJoindreUneEcole.setPreferredSize(new Dimension(200, 60));
		btnJoindreUneEcole.setBorder(new LineBorder(new Color(20, 148, 198), 2));
		//button.setBorderPainted(true);
		btnJoindreUneEcole.setIconTextGap(10);
		btnJoindreUneEcole.setVerticalTextPosition(SwingConstants.CENTER);
		btnJoindreUneEcole.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnJoindreUneEcole.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Enter_School.png"));
		btnJoindreUneEcole.setForeground(Color.white);
		btnJoindreUneEcole.setFont(new Font("Roboto", Font.BOLD, 14));
		btnJoindreUneEcole.setFocusPainted(false);
		btnJoindreUneEcole.setBackground(new Color(40, 40, 40));
		panel_5.add(btnJoindreUneEcole);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(350, 2));
		getContentPane().add(scrollPane_2, BorderLayout.WEST);
		
		
		UserInfo ui = new UserInfo(userID);
		scrollPane_2.setViewportView(ui);
		
loadEstablishment(userID);
		
	}
		
	
	
	public static void loadEstablishment(String userId) {
		panelSchools.removeAll();

		int i = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users_in_schools AS UIS "
					+ "JOIN schools AS s "
					+ "WHERE UIS.user_id = '"+userId+"' AND UIS.school_id = s.school_id AND s.is_active = 1");
			while(rs.next())
			{
				if(i == 0) {
					JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Ceci est la liste des etablissements auquels vous avez acces, ainsi que les roles qui vous sont assignes. Cliquez sur \"ouvrir\" pour continuer.</div></html>");
					lblNewLabel.setPreferredSize(new Dimension(500, 50));
					lblNewLabel.setBackground(new Color(60, 60, 60));
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					panelSchools.add(lblNewLabel);
				}
				i++;
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new LineBorder(new Color(211, 211, 211)));
				panel_4.setBackground(new Color(60, 60, 60));
				panel_4.setPreferredSize(new Dimension(200, 200));
				panelSchools.add(panel_4);
				panel_4.setLayout(new BorderLayout(0, 0));
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setIcon(ResizeImages.resize(100, 100, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\book.png"));
				lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
				lblNewLabel_3.setPreferredSize(new Dimension(46, 100));
				panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
				
				JPanel panel_6 = new JPanel();
				panel_4.add(panel_6, BorderLayout.CENTER);
				panel_6.setBackground(panel_6.getParent().getBackground());
				panel_6.setLayout(new BorderLayout(0, 0));
				
				JLabel lblNewLabel_4 = new JLabel("<html><div style='text-align: center;'>"+getSchoolFullName(rs.getString("school_id"))+"</div></html>");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setPreferredSize(new Dimension(165, 40));
				lblNewLabel_4.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(211, 211, 211)));
				lblNewLabel_4.setForeground(new Color(255, 255, 255));
				lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
				panel_6.add(lblNewLabel_4, BorderLayout.NORTH);
				
				JPanel panel_7 = new JPanel();
				panel_6.add(panel_7, BorderLayout.CENTER);
				panel_7.setBackground(panel_7.getParent().getBackground());
				panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
				
				
				
				String s = null;
				if(rs.getString("responsibility").equals("administrator")) {
					s = "Administrateur";
				}else if(rs.getString("responsibility").equals("editor")) {
					s = "Editeur";
				}else if(rs.getString("responsibility").equals("general_administrator")) {
					s = "Administrateur General";
				}
				
				
				JLabel lblNewLabel_5 = new JLabel(" "+s+" ");
				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				lblNewLabel_5.setBackground(new Color(20, 148, 198));
				lblNewLabel_5.setOpaque(true);
				lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
				panel_7.add(lblNewLabel_5);
				
				JButton btnNewButton = new JButton("Ouvrir");
				btnNewButton.setFocusPainted(false);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton.setBackground(new Color(20, 148, 198));
					}
					public void mouseExited(MouseEvent e) {
						btnNewButton.setBackground(btnNewButton.getParent().getBackground());
					}
				});

				String school_id = rs.getString("school_id");
				String role = s;
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

							Loading l = new Loading();
							l.setVisible(true);
							
							 new Thread(new Runnable(){
								    @Override
								    public void run(){
								    	
									    	Login.selectedSchoolID = school_id;
											selectedRole = role;
										try {
											ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
											window.setVisible(true);
											SwingUtilities.getRoot(panelSchools).setVisible(false);

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
				});
				
				
				btnNewButton.setPreferredSize(new Dimension(89, 35));
				btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
				btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255)));
				btnNewButton.setForeground(Color.white);
				panel_6.add(btnNewButton, BorderLayout.SOUTH);
				btnNewButton.setBackground(btnNewButton.getParent().getBackground());
				
			}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
				if(panelSchools.getComponentCount()==0) {
					JLabel lblNewLabel_2 = new JLabel("Vous n'avez acces a aucun etablissement pour le moment.");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panelSchools.add(lblNewLabel_2);
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