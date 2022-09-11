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
import javax.swing.JPopupMenu;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.text.JTextComponent;

import org.joda.time.DateTime;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.formdev.flatlaf.FlatLightLaf;

import app.App;
import app.General;
import app.LPane;
import Class.Application;
import Class.CustomVerticalScrollBarUI;
import Class.NewCourse;
import Class.NewPane;
import Class.NewStudent;
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
import Publishing.getInternetDateAndTime;
import Stats.StatsPane;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;


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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
import javax.swing.ScrollPaneConstants;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;

public class Home {

	public static JFrame frame;
	public static JPanel panel;
	public static JLabel classe;
	public static JScrollPane scrollPane;
	public static JPanel panelClasses;
	public static JPanel panelStudents;
	public static JPanel panelProf;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	public static JPanel side;
	public static String className = "3eme PF Economique";
	public static BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIATCPCBRZ572L66UD7", "rInnepuleetF0etEnZseelyDdsrSAx20hSsptmKw");
	public static AmazonS3 s3Client;
	public static  int  selectedTermIndex;
	public static  List<String> terms = new ArrayList();
	public static  List<String> termsText = new ArrayList();
	public static  int  selectedPeriod;
	public static int selectedTab = 0;
	public static  List<String> periodText = new ArrayList();
	public static JPanel panel_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
				    UIManager.setLookAndFeel( new FlatLightLaf() );
				} catch( Exception ex ) {
				    System.err.println( "Failed to initialize LaF" );
				}
					mysql.connectToDB();
					Home window = new Home("1", "1", "2");
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
	public Home(String SchoolID, String UserID, String ay_id) {
		initialize(SchoolID, UserID, ay_id);
	}
	//Metal
	//Nimbus
	//CDE/Motif
	//Windows
	//Windows Classic
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String SchoolID, String UserID, String ay_id) {

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
		loadTerms(ay_id);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(40, 40, 40));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Open-ed_color.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(720, 0));
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
		
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 128));
		panel.setBackground(new Color(40, 40, 40));
		panel.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		JPanel p = new JPanel();
		p.setForeground(new Color(0, 128, 128));
		p.setBackground(new Color(40, 40, 40));
		p.setLayout(new BorderLayout(0, 0));
		panel.add(p, BorderLayout.CENTER);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(40, 40, 40));
		panel_1.setPreferredSize(new Dimension(10, 45));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		classe = new JLabel(UserPanel.getSchoolFullName(SchoolID)+" - "+ScholarYears.getAcademicYearName(Login.selectedAcademicYearID));
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Roboto", Font.BOLD, 16));
		panel_1.add(classe, BorderLayout.CENTER);
		
		JButton btnAs = new JButton("A/S");
		btnAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ScholarYears s = new ScholarYears(UserID, SchoolID, UserPanel.selectedRole);
				s.setVisible(true);
			}
		});
		btnAs.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		//button_2.setPreferredSize(new Dimension(150, 14));
		btnAs.setForeground(Color.WHITE);
		btnAs.setFont(new Font("Roboto", Font.BOLD, 16));
		btnAs.setFocusPainted(false);
		btnAs.setBorderPainted(false);
		btnAs.setBackground(new Color(40, 40, 40));
		panel_1.add(btnAs, BorderLayout.WEST);
		
		
		
		
		
		JPanel p2 = new JPanel();
		p2.setBorder(null);
		p2.setForeground(new Color(0, 128, 128));
		p2.setBackground(new Color(40, 40, 40));
		p2.setLayout(new BorderLayout(0, 0));
		p.add(p2, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				int width = 0;
				for(int i = 0; i< ((Container) ((JScrollPane) panel_2.getComponent(1)).getViewport().getComponent(0)).getComponentCount(); i++) {
					if(((Container) ((JScrollPane) panel_2.getComponent(1)).getViewport().getComponent(0)).getComponent(i).isVisible()) {
					width = width+ ((Container) ((JScrollPane) panel_2.getComponent(1)).getViewport().getComponent(0)).getComponent(i).getWidth();
					}}
				
				if(panel_2.getWidth()< ((Container) panel_2.getComponent(0)).getComponent(0).getPreferredSize().width + width) {
					
					Component c1 = panel_2.getComponent(0);
					Component c2 = panel_2.getComponent(1);
					panel_2.removeAll();
					panel_2.add(c1, BorderLayout.CENTER);
					panel_2.add(c2, BorderLayout.NORTH);
				}else {
					Component c1 = panel_2.getComponent(0);
					Component c2 = panel_2.getComponent(1);
					panel_2.removeAll();
					panel_2.add(c1, BorderLayout.CENTER);
					panel_2.add(c2, BorderLayout.EAST);
				
				}
				panel_2.revalidate();
				panel_2.repaint();
			}
		});
		panel_2.setBackground(new Color(40, 40, 40));
		p2.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		HomeMenu1 h = new HomeMenu1(ay_id);
		//panel_2.remove(0);
		panel_2.add(h, BorderLayout.CENTER);

		panel_2.setBorder(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for(int i = 0; i< ((Container) scrollPane.getViewport().getComponent(0)).getComponentCount(); i++) {
					if(((Container) scrollPane.getViewport().getComponent(0)).getComponent(i) instanceof Group) {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-50, ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).getPreferredSize().height));

						scrollPane.revalidate();
						scrollPane.repaint();
						}
				}
			
			}
		});
		scrollPane.setBorder(null);
		p2.add(scrollPane, BorderLayout.CENTER);
		
		panelClasses = new JPanel();
		panelClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Class.deselectAll(ay_id);
				HomeMenu1.deselect();
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
		panelStudents.setLayout(new WrapLayout(WrapLayout.LEADING, 10, 0));

		panelStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClassStudents.deselectAll(ay_id);
			}
		});
		
		panelProf = new JPanel();
		panelProf.setForeground(new Color(0, 128, 128));
		panelProf.setBackground(new Color(40, 40, 40));
		//scrollPane.setViewportView(panelClasses);
		panelProf.setLayout(new WrapLayout(WrapLayout.LEADING, 10, 0));
		
		panelProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Teacher.deselectAll(ay_id);

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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		//scrollPane_1.setPreferredSize(new Dimension(2, 40));
		panel_2.add(scrollPane_1, BorderLayout.EAST);
		
		
		panel_6 = new JPanel();
		//panel_6.setPreferredSize(new Dimension(600, 10));
		panel_6.setBackground(new Color(40, 40, 40).darker());
		scrollPane_1.setViewportView(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 10));
		
		
		JTextField textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(10, 25));
		textField_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		textField_1.setColumns(10);
		panel_6.add(textField_1);
		
		
		
		
		JPanel panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(170, 30));
		panel_31.setBackground(new Color(60, 60, 60));
		panel_31.setBounds(39, 40, 155, 30);
		panel_6.add(panel_31);
		panel_31.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Travaux");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_31.add(lblNewLabel_1, BorderLayout.CENTER);
		lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod>0) {
					Home.selectedPeriod--;
				}else {
					Home.selectedPeriod = Home.periodText.toArray().length-1;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				

				if(selectedTab == 2) {
					for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
					if(Home.panelProf.getComponent(i).getPreferredSize().height> 50) {
				Teacher.loadTeachers(ay_id);
				}}
				Teacher.deselectAll(ay_id);
			}else if(selectedTab == 1) {
				//HomeMenu2.refreshStudents(ay_id);
			}
				}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(panel_31.getBackground());
		btnNewButton.setBorder(null);
		btnNewButton.setPreferredSize(new Dimension(30, 30));
		btnNewButton.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panel_31.add(btnNewButton, BorderLayout.WEST);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod<Home.periodText.toArray().length-1) {
					Home.selectedPeriod++;
				}else {
					Home.selectedPeriod = 0;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				

				if(selectedTab == 2) {
					for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
					if(Home.panelProf.getComponent(i).getPreferredSize().height> 50) {
						Teacher.loadTeachers(ay_id);}}
				Teacher.deselectAll(ay_id);
			}else if(selectedTab == 1) {
				//HomeMenu2.refreshStudents(ay_id);
			}
				
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(panel_31.getBackground());
		button_1.setBorder(null);
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		panel_31.add(button_1, BorderLayout.EAST);
		
		JPanel panel_41 = new JPanel();
		panel_41.setPreferredSize(new Dimension(190, 30));
		panel_41.setBackground(new Color(60, 60, 60));
		panel_41.setBounds(39, 77, 195, 30);
		panel_6.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JLabel lblerTrimestre = new JLabel("2eme Trimestre");
		lblerTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblerTrimestre.setForeground(Color.WHITE);
		lblerTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_41.add(lblerTrimestre, BorderLayout.CENTER);
		if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
			lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
			}else {
				lblerTrimestre.setText("Toute l'annee");
				}
		
		JButton button_21 = new JButton("");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
					lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
					}else {
						lblerTrimestre.setText("Toute l'annee");
						}
				
				if(selectedTab == 0) {
					Class.deselectAll(ay_id);
					for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
						if(Home.panelClasses.getComponent(i) instanceof Class) {
							Class.loadData(Home.panelClasses.getComponent(i), Home.panelClasses.getComponent(i).getName(), Home.termsText.get(Home.selectedTermIndex), ay_id);
							}else {
								for(int j = 0; j< ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponentCount(); j++) {
									Class.loadData(((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j), ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j).getName(), Home.termsText.get(Home.selectedTermIndex), ay_id);
									}
							}
							}
					}else if(selectedTab == 2) {
						for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
						if(Home.panelProf.getComponent(i).getPreferredSize().height> 50) {
							Teacher.loadTeachers(ay_id);}}
					Teacher.deselectAll(ay_id);
				}
				}
		});
		button_21.setFocusPainted(false);
		button_21.setBorderPainted(false);
		button_21.setBackground(panel_41.getBackground());
		button_21.setBorder(null);
		button_21.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_21.setPreferredSize(new Dimension(30, 30));
		panel_41.add(button_21, BorderLayout.WEST);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-2; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				if(Home.selectedTermIndex< Home.termsText.toArray().length-1) {
				lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
				}else {
					lblerTrimestre.setText("Toute l'annee");
					}
				
				if(selectedTab == 0) {
				Class.deselectAll(ay_id);
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					if(Home.panelClasses.getComponent(i) instanceof Class) {
					Class.loadData(Home.panelClasses.getComponent(i), Home.panelClasses.getComponent(i).getName(), Home.termsText.get(Home.selectedTermIndex), ay_id);
					}else {
						for(int j = 0; j< ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponentCount(); j++) {
							Class.loadData(((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j), ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j).getName(), Home.termsText.get(Home.selectedTermIndex), ay_id);
							}
					}
					}
				}else if(selectedTab == 2) {
					for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
					if(Home.panelProf.getComponent(i).getPreferredSize().height> 50) {
						Teacher.loadTeachers(ay_id);}}
				Teacher.deselectAll(ay_id);
			}
				}
		});
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(panel_41.getBackground());
		button_3.setBorder(null);
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		panel_41.add(button_3, BorderLayout.EAST);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					 Date d2 = null;
						try {
							d2 = df.parse(getInternetDateAndTime.getDate());
							d1 = new DateTime(d2).minusDays(7).toDate();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						HomeMenu2.dateChooser.setSelectedDay(d1.getDate());
						HomeMenu2.dateChooser.setSelectedMonth(d1.getMonth());
						HomeMenu2.dateChooser.setSelectedMonth(d1.getYear()+1900);


						HomeMenu2.dateChooser_1.setSelectedDay(d2.getDate());
						HomeMenu2.dateChooser_1.setSelectedMonth(d2.getMonth());
						HomeMenu2.dateChooser_1.setSelectedMonth(d2.getYear()+1900);
				}
				if(comboBox.getSelectedIndex()==1) {
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					 Date d2 = null;
						try {
							d2 = df.parse(getInternetDateAndTime.getDate());
							d1 = new DateTime(d2).minusDays(30).toDate();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						HomeMenu2.dateChooser.setSelectedDay(d1.getDate());
						HomeMenu2.dateChooser.setSelectedMonth(d1.getMonth());
						HomeMenu2.dateChooser.setSelectedMonth(d1.getYear()+1900);


						HomeMenu2.dateChooser_1.setSelectedDay(d2.getDate());
						HomeMenu2.dateChooser_1.setSelectedMonth(d2.getMonth());
						HomeMenu2.dateChooser_1.setSelectedMonth(d2.getYear()+1900);
				}

				String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
				
        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
        			if(Home.panelStudents.getComponent(i) instanceof JPanel) {
        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ((ClassStudents) Home.panelStudents.getComponent(i)).getCourses().get(ClassStudents.selectedCourse), Home.panelStudents.getComponent(i).getName(), ay_id, start, end);
        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
        				ClassStudents.rankFromLastToFirst((JPanel) ((Container) Home.panelStudents.getComponent(i)));
        				}else{
            				ClassStudents.rankFromFirstToLast((JPanel) ((Container) Home.panelStudents.getComponent(i)));
            				}}}}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Les 7 derniers jours", "Les 30 derniers jours", "Autre periode"}));
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 17));
		comboBox.setBounds(10, 61, 184, 30);
		panel_6.add(comboBox);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(40, 40, 40));
		p.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		
		JButton menu = new JButton("");
		menu.setMultiClickThreshhold(1000L);
		menu.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		menu.setPreferredSize(new Dimension(70, 50));
		menu.setFont(new Font("Arial", Font.PLAIN, 27));
		menu.setFocusPainted(false);
		menu.setBorder(null);
		menu.setBackground(panel_2.getBackground());
		panel_5.add(menu);
		
		
		JButton btnNewButton1 = new JButton("Classes");
		btnNewButton1.setMultiClickThreshhold(1000L);
		btnNewButton1.setFocusPainted(false);
		btnNewButton1.setPreferredSize(new Dimension(150, 50));
		btnNewButton1.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
		btnNewButton1.setIconTextGap(10);
		btnNewButton1.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewButton1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton1.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
		btnNewButton1.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton1.setBackground(new Color(60, 60, 60));
		btnNewButton1.setForeground(new Color(255, 255, 255));
		panel_5.add(btnNewButton1);

		
		JButton button = new JButton("El\u00E8ves");
		button.setMultiClickThreshhold(1000L);
		button.setPreferredSize(new Dimension(150, 50));
		button.setBorder(null);
		//button.setBorderPainted(true);
		button.setIconTextGap(10);
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Roboto", Font.BOLD, 14));
		button.setFocusPainted(false);
		button.setBackground(new Color(40, 40, 40));
		panel_5.add(button);
		
		
		JButton btnProfesseurs = new JButton("Professeurs");
		btnProfesseurs.setMultiClickThreshhold(1000L);
		btnProfesseurs.setPreferredSize(new Dimension(150, 50));
		btnProfesseurs.setBorder(null);
		btnProfesseurs.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnProfesseurs.setVerticalTextPosition(SwingConstants.CENTER);
		btnProfesseurs.setIconTextGap(10);
		btnProfesseurs.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnProfesseurs.setForeground(Color.LIGHT_GRAY);
		btnProfesseurs.setFont(new Font("Roboto", Font.BOLD, 14));
		btnProfesseurs.setFocusPainted(false);
		btnProfesseurs.setBackground(new Color(40, 40, 40));
		panel_5.add(btnProfesseurs);
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(screensize.width*33/100, 21));
		panel_3.add(scrollPane_2, BorderLayout.EAST);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(350, 80));
		frame.getContentPane().add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel logo_panel = new JPanel();
		logo_panel.setPreferredSize(new Dimension(350, 80));
		logo_panel.setBackground(new Color(40, 40, 40));
		panel_4.add(logo_panel, BorderLayout.NORTH);
		logo_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
		
		JButton logo = new JButton("");
		logo.setFocusPainted(false);
		logo.setBackground(new Color(40, 40, 40));
		logo.setBorder(null);
		logo_panel.add(logo);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setHorizontalTextPosition(SwingConstants.CENTER);
		logo.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\Open-ed.png"));
		logo.setPreferredSize(new Dimension(220, 70));
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBorder(null);
		scrollPane_3.setPreferredSize(new Dimension(350, 300));
		panel_4.add(scrollPane_3, BorderLayout.CENTER);

		scrollPane_3.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_3.getVerticalScrollBar().setUnitIncrement(15);
		
		MainInfo side = new MainInfo(ay_id);
		scrollPane_3.setViewportView(side);
		
		
		
		for(int i = 1; i< panel_5.getComponentCount(); i++) {
			panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
			panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
			panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
			((JComponent) panel_5.getComponent(i)).setBorder(null);
			((AbstractButton) panel_5.getComponent(i)).setIcon(null);
		}
		btnNewButton1.setPreferredSize(new Dimension(150, 50));
		btnNewButton1.setForeground(Color.white);
		btnNewButton1.setBackground(new Color(60, 60, 60));
		btnNewButton1.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
		btnNewButton1.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
		panel_6.getComponent(1).setVisible(false);
		panel_6.getComponent(2).setVisible(true);
		panel_6.getComponent(3).setVisible(false);
		
		
		
		btnNewButton1.addActionListener(new ActionListener() {
			boolean classesAreLoaded = true;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 0;
				panel_6.getComponent(1).setVisible(false);
				panel_6.getComponent(2).setVisible(true);
				panel_6.getComponent(3).setVisible(false);
				
				scrollPane.setViewportView(panelClasses);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnNewButton1.setPreferredSize(new Dimension(150, 50));
				btnNewButton1.setForeground(Color.white);
				btnNewButton1.setBackground(new Color(60, 60, 60));
				btnNewButton1.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnNewButton1.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}HomeMenu1 h = new HomeMenu1(ay_id);
				panel_2.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_2.revalidate();
				panel_2.repaint();
				
				if(!classesAreLoaded) {
					classesAreLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			        		Class.loadClasses(Home.termsText.get(Home.selectedTermIndex), ay_id);

						return null;
			            }
			        }.execute();
				}
				Class.deselectAll(ay_id);
			}
		});
		button.addActionListener(new ActionListener() {
			boolean studentsAreLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 1;
				panel_6.getComponent(2).setVisible(false);
				panel_6.getComponent(3).setVisible(true);
				panel_6.getComponent(1).setVisible(false);
				
				scrollPane.setViewportView(panelStudents);

				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				button.setPreferredSize(new Dimension(150, 50));
				button.setForeground(Color.white);
				button.setBackground(new Color(60, 60, 60));
				button.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				button.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
				

				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}
				HomeMenu2 h = new HomeMenu2(ay_id);
				panel_2.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_2.revalidate();
				panel_2.repaint();

				if(!studentsAreLoaded) {
					studentsAreLoaded = true;
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		        		String start = HomeMenu2.dateChooser.getSelectedDay()+"/"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"/"+(HomeMenu2.dateChooser.getSelectedYear());
		        		String end = HomeMenu2.dateChooser_1.getSelectedDay()+"/"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"/"+(HomeMenu2.dateChooser_1.getSelectedYear());
		        		ClassStudents.loadStudents(start, end, ay_id);
		            	 return null;
		            }
		        }.execute();
				}
				ClassStudents.deselectAll(ay_id);
			}
		});
		btnProfesseurs.addActionListener(new ActionListener() {
			boolean teachersAreLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 2;
				panel_6.getComponent(1).setVisible(true);
				panel_6.getComponent(2).setVisible(true);
				panel_6.getComponent(3).setVisible(false);
				
				scrollPane.setViewportView(panelProf);

				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnProfesseurs.setPreferredSize(new Dimension(150, 50));
				btnProfesseurs.setForeground(Color.white);
				btnProfesseurs.setBackground(new Color(60, 60, 60));
				btnProfesseurs.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnProfesseurs.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
				

				if(panel_2.getComponentCount()>0) {
				panel_2.remove(0);
				}
				HomeMenu3 h = new HomeMenu3(ay_id);
				panel_2.add(h, 0);
				panel_2.revalidate();
				panel_2.repaint();
				//Teacher.loadData();

				if(!teachersAreLoaded) {
					teachersAreLoaded = true;
		        new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		        		Teacher.loadTeachers(ay_id);
		        		 return null;
		    }
		}.execute();
				}
				Teacher.deselectAll(ay_id);
			}
		});
		
		for(int i = 0; i< (panel_5).getComponentCount();i++) {
			int k = i;
			Color c = (panel_5).getComponent(k).getBackground();
			(panel_5).getComponent(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(k-1 != selectedTab) {
					(panel_5).getComponent(k).setBackground(new Color(60, 60, 60));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(k-1 != selectedTab) {
					(panel_5).getComponent(k).setBackground((panel_5).getComponent(k).getParent().getBackground());
			}}
			});
		}
		
		


        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		Class.loadClasses(Home.termsText.get(Home.selectedTermIndex), ay_id);

			return null;
            }
        }.execute();
        
	}

	public static void collapseAll() {
		for(int k = 0; k< Home.panelClasses.getComponentCount(); k++) {
			if(Home.panelClasses.getComponent(k) instanceof Class) {
			((JButton) ((Container) Home.panelClasses.getComponent(k)).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) Home.panelClasses.getComponent(k)).getComponent(1).setVisible(false);
			Home.panelClasses.getComponent(k).setPreferredSize(new Dimension(310-310*49/100, 120));
			Home.panelClasses.getComponent(k).revalidate();
			Home.panelClasses.getComponent(k).repaint();
		}else{
			for(int i = 0; i< ((Container) ((Container) Home.panelClasses.getComponent(k)).getComponent(0)).getComponentCount(); i++) {
			((JButton) ((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).getComponent(1).setVisible(true);
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).setPreferredSize(new Dimension(310-310*49/100, 120));
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).revalidate();
			((Container) (((Container) (((Container) Home.panelClasses.getComponent(k)).getComponent(0))).getComponent(i))).repaint();
			}
		}}
	}
	public static void collapse(Component c) {
		((AbstractButton) ((Container) c).getComponent(2)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
			((Container) c).getComponent(1).setVisible(false);
			((Container) c).setPreferredSize(new Dimension(310-310*49/100, 120));
			((Container) c).revalidate();
			((Container) c).repaint();
		}
	
	
public static List<Color> getClassColors(String classroom_in_ay_id) {
	Color back;
		Color fore;
		List <Color> allColors = new ArrayList();
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from classrooms_in_ay "
					+ "WHERE cia_id = '"+classroom_in_ay_id+"' LIMIT 1");
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

public static String getClassName(String classroom_in_ay_id) {
		
	String name = null;
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from classrooms AS c "
					+ "JOIN classrooms_in_ay AS cia "
					+ "WHERE cia.cia_id = '"+classroom_in_ay_id+"' AND cia.classroom_id = c.classroom_id  LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("c.classroom_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		return name;
		}

public static String getStudentName(String student_in_classroom_id) {
	
	String name = null;
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from students AS s "
					+ "JOIN students_in_classrooms AS sic "
					+ "WHERE sic.sic_id = '"+student_in_classroom_id+"' AND sic.student_id = s.student_id LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("s.last_name").toUpperCase()+" "+rs.getString("s.first_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		return name;
		}

public static String getTermName(String term_id) {
	
	String name = null;
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from terms "
					+ "WHERE term_id = '"+term_id+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("term_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		return name;
		}

public static String getTermYear(String term_id) {
	
	String name = null;
	
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from terms "
					+ "WHERE term_id = '"+term_id+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("ay_id");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		return name;
		}
	
	public static void deselect() {
	}
	
	
	
	
	
	public static void loadTerms(String ay_id) {
		
		termsText.clear();
		
		
		Object [] terms = Home.loadActiveTerms(ay_id);
		for(int i = 0 ; i< terms.length; i++) {
				termsText.add(terms[i].toString());
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
	

public static Object[] loadActiveStudents(String classroom_in_ay_id) {
	
	List<String> s = new ArrayList();
	//BufferedReader

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM students_in_classrooms AS sic "
				+ "JOIN students AS s "
				+ "WHERE sic.cia_id = '"+classroom_in_ay_id+"' AND sic.student_id = s.student_id AND s.is_active = 1 AND sic.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("sic.sic_id"));
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
				+ "WHERE t.ay_id = '"+ay_id+"' AND t.ay_id = ay.ay_id AND t.is_active = 1 AND t.type = 'regular'");
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
				+ "WHERE c.is_active = 1 AND cia.is_active = 1 AND cia.ay_id = '"+ay_id+"' AND cia.classroom_id = c.classroom_id");
		while(rs.next())
		{
			s.add(rs.getString("cia.cia_id"));
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

		ResultSet rs=stmt.executeQuery("select * from teachers AS t "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN classrooms_in_ay AS cia "
				+ "JOIN teachers_in_classrooms AS tic "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND cic.cia_id = cia.cia_id AND cia.ay_id = '"+ay_id+"' AND t.teacher_id = tic.teacher_id AND cia.is_active = 1 AND tic.is_active = 1 AND t.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
			if(!s.contains(rs.getString("tic.teacher_id"))) {
			s.add(rs.getString("tic.teacher_id"));
		}}

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
				+ "JOIN courses AS c "
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

public static boolean courseIsCalculated(String course_in_classroom_id) {
	boolean exists = false;
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses_in_classroom "
				+ "WHERE courses_in_classroom_id = '"+course_in_classroom_id+"' AND is_calculated = 1");

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

public static Object[] loadActiveCourses(String classroom_in_ay_id) {
	
	List<String> s = new ArrayList();

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses_in_classroom AS cic "
				+ "JOIN courses AS c "
				+ "WHERE cic.cia_id = '"+classroom_in_ay_id+"' AND cic.course_id = c.course_id AND c.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
			s.add(rs.getString("cic.courses_in_classroom_id"));
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}
	Object[] courses = s.toArray();
	return courses;
	
}


public static String getClassroomOfCourse(String course_in_classroom_id) {
	
	String id = null;
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * FROM courses_in_classroom "
				+ "WHERE courses_in_classroom_id = '"+course_in_classroom_id+"' LIMIT 1");
		while(rs.next())
		{
			id = rs.getString("cia_id");
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return id;
	
}


public static void addToolTip(Component c, String toolTip) {
	
	JLabel j = new JLabel(toolTip);
	j.setForeground(new Color(255, 255, 255));
	j.setFont(new Font("Roboto", Font.BOLD, 12));
	j.setHorizontalAlignment(0);
	
	JPopupMenu popupMenu = new JPopupMenu();
	popupMenu.setBorderPainted(false);
	popupMenu.setBackground(new Color(0, 0, 0));
	popupMenu.setPreferredSize(new Dimension(6*toolTip.length()+13, 25));
	popupMenu.setLayout(new BorderLayout(0, 0));
	popupMenu.add(j);
	
	

	c.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			if (e.getComponent() == c) {
				showMenu(e);
			}
		}
		public void mouseExited(MouseEvent e) {
			if (e.getComponent() == c) {
				popupMenu.setVisible(false);
			}
		}
		private void showMenu(MouseEvent e) {
			popupMenu.show(c, 0-((popupMenu.getPreferredSize().width-c.getWidth())/2), c.getPreferredSize().height);
		}
	});
}
}
