package Application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import static javax.swing.ScrollPaneConstants.*;

import javax.mail.MessagingException;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.text.JTextComponent;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import app.App;
import app.General;
import app.LPane;
import Class.Application;
import Class.CustomVerticalScrollBarUI;
import Class.NewCourse;
import Class.NewPane;
import Class.Student;
import Class.TestBox;
import Class.Threads;
import Class.OptionsMenu.CourseMenu;
import Class.OptionsMenu.HomeMenu1;
import Class.OptionsMenu.HomeMenu2;
import Class.OptionsMenu.HomeMenu3;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.TestMenu;
import CloudOperations.aws;
import CloudOperations.mysql;
import app.Test;
import app.WrapLayout;
import Publishing.Connection;
import Publishing.Mail;
import Stats.StatsPane;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import accounts.Users;


import java.sql.*; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.text.Collator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import sideInformation.MainInfo;

import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLayeredPane;
import java.awt.ComponentOrientation;
import com.toedter.calendar.JDateChooser;

public class Home {

	public static JFrame frame;
	public static JPanel panel;
	public static JLabel classe;
	public static JScrollPane scrollPane;
	public static JPanel panelClasses;
	public static JPanel panelStudents;
	public static JPanel panelProf;
	private JScrollPane scrollPane_2;
	private JPanel panel_4;
	private JScrollPane scrollPane_3;
	public static JPanel side;
	private JButton button;
	public static String className = "3eme PF Economique";
	public static BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIATCPCBRZ572L66UD7", "rInnepuleetF0etEnZseelyDdsrSAx20hSsptmKw");
	public static AmazonS3 s3Client;
	public static  int  selectedTab = 0;
	public static  int  selectedTermIndex;
	public static  List<String> terms = new ArrayList();
	public static  List<String> termsText = new ArrayList();
	public static  int  selectedPeriod;
	public static  List<String> periodText = new ArrayList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home(Login.selectedSchoolID, Login.selectedUserID);
					window.frame.setVisible(true);
					System.gc();
					Thread.currentThread().setPriority((int) (Thread.MAX_PRIORITY*0.8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(String SchoolID, String UserID) {
		initialize(SchoolID, UserID);
	}
	//Metal
	//Nimbus
	//CDE/Motif
	//Windows
	//Windows Classic
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String SchoolID, String UserID) {

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
		loadTerms(Login.selectedAcademicYearID);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(40, 40, 40));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(screensize.width*80/100,screensize.height*80/100));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		if(Connection.isConnectedToInternet()) {  try {
			// SECTION 1 OPTION 1: Create a S3 client with in-program credential
			//
			// us-west-2 is AWS Oregon
			s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-2").withCredentials(new AWSStaticCredentialsProvider(awsCreds))
					.build();

			
//			AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

			// SECTION 2: Put file in S3 bucket
			//
		} catch (AmazonS3Exception e) {

			e.printStackTrace();
		}}
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.setBackground(new Color(0, 128, 128));
		panel.setPreferredSize(new Dimension(10, frame.getHeight()*20/100));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(20, 148, 198));
		panel_1.setPreferredSize(new Dimension(10, frame.getHeight()*20/100*30/100));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		classe = new JLabel(UserPanel.getSchoolFullName(SchoolID));
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		panel_1.add(classe, BorderLayout.CENTER);
		
		JButton button_2 = new JButton(ScholarYears.getAcademicYearName(Login.selectedAcademicYearID));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ScholarYears s = new ScholarYears(UserID, SchoolID, UserPanel.selectedRole);
				s.frame.setVisible(true);
			}
		});
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_2.setPreferredSize(new Dimension(240, 14));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(new Color(20, 148, 198));
		panel_1.add(button_2, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 40, 40));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		HomeMenu1 h = new HomeMenu1();
		//panel_2.remove(0);
		panel_2.add(h, BorderLayout.CENTER);

		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panelClasses = new JPanel();
		panelClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Class.deselectAll();
				HomeMenu1.deselect();
				if(Class.selectedClasses.toArray().length == 0) {
					MainInfo m = new MainInfo();
					m.guide.setText("<html>- Cliquez sur une classe pour la selectionner.<br/><br/>\r\n- Double-cliquez sur une classe pour l'ouvrir.<br/><br/>\r\n- Cliquez sur la fleche correspondante a une classe <br/>pour rapidement voir les details de cette classe.<br/><br/>\r\n- Pour creer un groupe de classe, selectionnez deux<br/> ou plusieurs classe, et puis choisissez l'option <br/>\"regrouper\".<br/><br/>\r\n- Pour ajouter une classe dans un groupe, cliquez <br/>sur le bouton \"ajouter\" qui se situe sur le groupe <br/>voulu, puis choisissez parmi les classes donnees.</html>");
					Home.side.removeAll();
					Home.side.add(m);
					Home.frame.revalidate();
					Home.frame.repaint();
				}
			}
		});
		panelClasses.setForeground(new Color(0, 128, 128));
		panelClasses.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panelClasses);
		panelClasses.setLayout(new WrapLayout(0, 20, 20));

		
		panelStudents = new JPanel();
		panelStudents.setForeground(new Color(0, 128, 128));
		panelStudents.setBackground(new Color(40, 40, 40));
		//scrollPane.setViewportView(panelClasses);
		panelStudents.setLayout(new WrapLayout(0, 5, 5));

		panelStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClassStudents.deselectAll();
			}
		});
		
		panelProf = new JPanel();
		panelProf.setForeground(new Color(0, 128, 128));
		panelProf.setBackground(new Color(40, 40, 40));
		//scrollPane.setViewportView(panelClasses);
		panelProf.setLayout(new WrapLayout(0, 5, 5));
		
		panelProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Teacher.deselectAll();

				HomeMenu3.deselect();
			}
		});

		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panelClasses.setBackground(new Color(40, 40, 40));
		panelClasses.setForeground(new Color(0, 128, 128));
		scrollPane.setViewportView(panelClasses);
		panelClasses.setLayout(new WrapLayout(WrapLayout.LEFT, 20, 20));
		
		JLabel lblNewLabel = new JLabel("Il n'y a actuellement aucune classe dans cet etablissement.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		panelClasses.add(lblNewLabel);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(screensize.width*33/100, 21));
		panel_3.add(scrollPane_2, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setPreferredSize(new Dimension(151, 200));
		frame.getContentPane().add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(null);
		panel_7.setBackground(panel_7.getParent().getBackground());
		
		JButton btnNewButton = new JButton("Classes");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		btnNewButton.setIconTextGap(0);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 0, 150, 130);
		panel_7.add(btnNewButton);

		btnNewButton.setBackground(new Color(20, 148, 198));
		button = new JButton("El\u00E8ves");
		button.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		//button.setBorderPainted(true);
		button.setIconTextGap(0);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto", Font.PLAIN, 25));
		button.setFocusPainted(false);
		button.setBackground(new Color(60, 60, 60));
		button.setBounds(0, 130, 150, 130);
		panel_7.add(button);
		
		
		JButton btnProfesseurs = new JButton("Professeurs");
		btnProfesseurs.setBorderPainted(false);
		btnProfesseurs.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		btnProfesseurs.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnProfesseurs.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProfesseurs.setIconTextGap(0);
		btnProfesseurs.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProfesseurs.setForeground(Color.WHITE);
		btnProfesseurs.setFont(new Font("Roboto", Font.PLAIN, 21));
		btnProfesseurs.setFocusPainted(false);
		btnProfesseurs.setBackground(new Color(60, 60, 60));
		btnProfesseurs.setBounds(0, 260, 150, 130);
		panel_7.add(btnProfesseurs);
		
		JButton users = new JButton("Utilisateurs");
		users.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users u = new Users(SchoolID);
				u.setVisible(true);
			}
		});
		users.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel_4.add(users, BorderLayout.SOUTH);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(null);
		scrollPane_3.setPreferredSize(new Dimension(400, 300));
		frame.getContentPane().add(scrollPane_3, BorderLayout.EAST);

		scrollPane_3.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getVerticalScrollBar().setUnitIncrement(15);
		
		side = new JPanel();
		side.setForeground(new Color(0, 128, 128));
		side.setBackground(new Color(40, 40, 40));
		scrollPane_3.setViewportView(side);
		side.setLayout(new BorderLayout(0, 0));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(panelClasses);
				btnNewButton.setBackground(new Color(20, 148, 198));
				button.setBackground(panel_4.getBackground());
				btnProfesseurs.setBackground(panel_4.getBackground());
				selectedTab = 0;

				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}HomeMenu1 h = new HomeMenu1();
				panel_2.add(h, BorderLayout.CENTER);
				panel_2.revalidate();
				panel_2.repaint();
				Class.deselectAll();
				ClassStudents.deselectAll();
				Teacher.deselectAll();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(panelStudents);
				button.setBackground(new Color(20, 148, 198));
				btnNewButton.setBackground(panel_4.getBackground());
				btnProfesseurs.setBackground(panel_4.getBackground());
				selectedTab = 1;

				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}
				HomeMenu2 h = new HomeMenu2();
				panel_2.add(h, BorderLayout.CENTER);
				panel_2.revalidate();
				panel_2.repaint();
				Class.deselectAll();
				ClassStudents.deselectAll();
				Teacher.deselectAll();
			}
		});
		btnProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(panelProf);
				btnProfesseurs.setBackground(new Color(20, 148, 198));
				button.setBackground(panel_4.getBackground());
				btnNewButton.setBackground(panel_4.getBackground());
				selectedTab = 2;

				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}
				HomeMenu3 h = new HomeMenu3();
				panel_2.add(h, BorderLayout.CENTER);
				panel_2.revalidate();
				panel_2.repaint();
				//Teacher.loadData();
				Class.deselectAll();
				ClassStudents.deselectAll();
				Teacher.deselectAll();
			}
		});
		
		for(int i = 0; i< ((Container) panel_4.getComponent(0)).getComponentCount();i++) {
			int k = i;
			Color c = ((Container) panel_4.getComponent(0)).getComponent(k).getBackground();
			((Container) panel_4.getComponent(0)).getComponent(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!((Container) panel_4.getComponent(0)).getComponent(k).getBackground().equals(new Color(20, 148, 198))) {
					((Container) panel_4.getComponent(0)).getComponent(k).setBackground(((Container) panel_4.getComponent(0)).getComponent(k).getBackground().darker());
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!((Container) panel_4.getComponent(0)).getComponent(k).getBackground().equals(new Color(20, 148, 198))) {
					((Container) panel_4.getComponent(0)).getComponent(k).setBackground(((Container) panel_4.getComponent(0)).getComponent(k).getBackground().brighter());
			}}
			});
		}
		
		


        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		Class.loadClasses(Login.selectedAcademicYearID);

				MainInfo m = new MainInfo();
				m.guide.setText("<html>- Cliquez sur une classe pour la selectionner.<br/><br/>\r\n- Double-cliquez sur une classe pour l'ouvrir.<br/><br/>\r\n- Cliquez sur la fleche correspondante a une classe <br/>pour rapidement voir les details de cette classe.<br/><br/>\r\n- Pour creer un groupe de classe, selectionnez deux<br/> ou plusieurs classe, et puis choisissez l'option <br/>\"regrouper\".<br/><br/>\r\n- Pour ajouter une classe dans un groupe, cliquez <br/>sur le bouton \"ajouter\" qui se situe sur le groupe <br/>voulu, puis choisissez parmi les classes donnees.</html>");
				Home.side.removeAll();
				Home.side.add(m);
				Home.frame.revalidate();
				Home.frame.repaint(); return null;
            }
        }.execute();

        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		Teacher.loadTeachers(Login.selectedAcademicYearID);
        		 return null;
    }
}.execute();
        
        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		String start = HomeMenu2.dateChooser.getDate().getDate()+"/"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"/"+(HomeMenu2.dateChooser.getDate().getYear()+1900);
        		String end = HomeMenu2.dateChooser_1.getDate().getDate()+"/"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"/"+(HomeMenu2.dateChooser_1.getDate().getYear()+1900);
        		ClassStudents.loadStudents(start, end, Login.selectedAcademicYearID);
            	 return null;
            }
        }.execute();
}

	public static void collapseAll() {
		for(int k = 0; k< Home.panelClasses.getComponentCount(); k++) {
			if(Home.panelClasses.getComponent(k) instanceof Class) {
			((JButton) ((Container) Home.panelClasses.getComponent(k)).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) Home.panelClasses.getComponent(k)).getComponent(1).setVisible(false);
			Home.panelClasses.getComponent(k).setPreferredSize(new Dimension(370-370*53/100, 140));
			Home.panelClasses.getComponent(k).revalidate();
			Home.panelClasses.getComponent(k).repaint();
		}else{
			for(int i = 0; i< ((Container) ((Container) Home.panelClasses.getComponent(k)).getComponent(0)).getComponentCount(); i++) {
			((JButton) ((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).getComponent(1).setVisible(false);
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).setPreferredSize(new Dimension(370-370*53/100, 140));
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).revalidate();
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).repaint();
			}
		}}
	}
	public static void collapse(Component c) {
		((AbstractButton) ((Container) c).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) c).getComponent(1).setVisible(false);
			((Container) c).setPreferredSize(new Dimension(370-370*53/100, 140));
			((Container) c).revalidate();
			((Container) c).repaint();
		}
	
	
public static List<Color> getClassColors(String classroom_id, String ay_id) {
	Color back;
		Color fore;
		List <Color> allColors = new ArrayList();
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from classrooms_in_ay "
					+ "WHERE classroom_id = '"+classroom_id+"' AND ay_id = '"+ay_id+"' LIMIT 1");
			while(rs.next())
			{
				List<String> colors = Arrays.asList(rs.getString("color1").split(","));
				List<String> colors2 = Arrays.asList(rs.getString("color2").split(","));
				
				back = new Color(Integer.parseInt(colors.get(0)), Integer.parseInt(colors.get(1)), Integer.parseInt(colors.get(2)));
				
				fore = new Color(Integer.parseInt(colors2.get(0)), Integer.parseInt(colors2.get(1)), Integer.parseInt(colors2.get(2)));
				allColors.add(back);
				allColors.add(fore);
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}	
		
		return allColors;
		}
	
	public static void deselect() {
	}
	
	
	
	
	
	public static void loadTerms(String ay_id) {
		
		termsText.clear();
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from terms "
					+ "WHERE ay_id = '"+ay_id+"'");
			while(rs.next())
			{
				termsText.add(ScholarYears.getAcademicYearName(rs.getString("term_id")));
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		termsText.add("Toute l'annee");

		periodText.clear();
		periodText.add("Travaux");
		periodText.add("Examens");
		periodText.add("TJ + Examens");

		Home.terms.clear();
		if(Home.selectedTermIndex == termsText.toArray().length-1) {
			for(int i = 0; i< termsText.toArray().length-2; i++) {
			Home.terms.add(termsText.get(i));
			}
		}else {
			Home.terms.clear();
			Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
			}
	}
	
	

public static Object[] loadActiveStudents(String classroom_id, String ay_id) {
	
	List<String> s = new ArrayList();
	BufferedReader

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * from students_in_classrooms AS sic "
				+ "JOIN students AS s"
				+ "WHERE sic.classroom_id = '"+classroom_id+"' AND sic.ay_id = '"+ay_id+"' AND sic.student_id = s.student_id AND s.is_active = 1 AND sic.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("sic.student_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	Object[] students = s.toArray();
	
	return students;
	
}
public static Object[] loadActiveTerms(String ay_id) {
	
	List<String> s = new ArrayList();

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * from terms AS t "
				+ "JOIN academic_year AS ay "
				+ "WHERE t.ay_id = '"+ay_id+"' AND t.ay_id = ay.ay_id AND t.is_active = 1 AND ay.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("t.term_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	Object[] terms = s.toArray();
	
	return terms;
	
}
public static Object[] loadActiveClasses(String ay_id) {
	
	List<String> s = new ArrayList();

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from classrooms_in_ay AS cia "
				+ "JOIN classrooms AS c "
				+ "WHERE cia.ay_id = '"+ay_id+"' AND cia.classroom_id = c.classroom_id AND c.is_active = 1 AND cia.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("cia.classroom_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	
	Object[] classes = s.toArray();
	return classes;
	
}

public static Object[] loadActiveProfs(String ay_id) {
	
	List<String> s = new ArrayList();

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms AS tic "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN teachers AS t "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND cic.ay_id = '"+ay_id+"' AND t.teacher_id = tic.teacher_id AND tic.is_active = 1 AND t.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("tic.teacher_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	
	Object[] teachers = s.toArray();
	return teachers;
}

public static boolean classExists(String classroomId, String ay_id) {
	boolean exists = false;
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from classrooms_in_ay AS cia "
				+ "JOIN classrooms AS c "
				+ "WHERE c.classroom_id = '"+classroomId+"' AND c.is_active = 1 AND cia.ay_id = '"+ay_id+"' AND cia.classroom_id = '"+classroomId+"' AND cia.is_active = 1");
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

public static boolean courseExists(String courseId, String ay_id) {
	boolean exists = false;
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses_in_classroom AS cic"
				+ "JOIN courses AS c"
				+ "WHERE c.course_id = '"+courseId+"' AND c.is_active = 1 AND cic.ay_id = '"+ay_id+"' AND cic.course_id = '"+courseId+"' AND cic.is_active = 1");

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

public static Object[] loadActiveCourses(String ay_id, String classroom_id) {
	
	List<String> s = new ArrayList();

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses_in_classroom AS cic "
				+ "JOIN courses AS c"
				+ "WHERE cic.ay_id = '"+ay_id+"' AND cic.classroom_id = '"+classroom_id+"' AND cic.course_id = c.course_id AND c.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("cic.course_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	Object[] courses = s.toArray();
	return courses;
	
}
}
