package accounts;

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
import Class.OptionsMenu.SchoolMenu;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.TestMenu;
import CloudOperations.mysql;
import app.Test;
import app.WrapLayout;
import Publishing.Connection;
import Publishing.Mail;
import Stats.StatsPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
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
import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import sideInformation.SchoolInfo;
import sideInformation.UserInfo;

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

import Application.Home;
import Application.ResizeImages;

public class ScholarYears extends JFrame {


	public static JPanel panel;
	public static JButton button_3;
	public static JLabel classe;
	private static JPanel panelYear;
	private static JPanel panelStudents;
	private static JPanel panelClasses;
	private static JPanel panelProfs;
	private static JPanel panelParents;
	public static String className = "3eme Economique";
	public static  int  selectedTab = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					ScholarYears window = new ScholarYears("1", "1", "Administrateur General");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScholarYears(String userId, String schoolId, String role) {
		
		

		
		


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
		classe.setText(UserPanel.getSchoolFullName(schoolId)+" ("+role+")");
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Roboto", Font.BOLD, 16));
		panel_1.add(classe, BorderLayout.CENTER);
		
		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPanel l = new UserPanel(userId);
				l.setVisible(true);
				setVisible(false);
			
			}
		});
		btnBack.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		//button_2.setPreferredSize(new Dimension(150, 14));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Roboto", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(20, 148, 198));
		panel_1.add(btnBack, BorderLayout.WEST);
		
		
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
		
		
		SchoolMenu s = new SchoolMenu();
		p2.add(s, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for(int i = 0; i< ((Container) scrollPane.getViewport().getComponent(0)).getComponentCount(); i++) {
					if(((Container) scrollPane.getViewport().getComponent(0)).getComponent(i) instanceof JLabel || selectedTab > 0) {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-50, ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).getPreferredSize().height));
						}
					}
				scrollPane.getViewport().getComponent(0).revalidate();
				scrollPane.getViewport().getComponent(0).repaint();
			
			}
		});
		scrollPane.setBorder(null);
		p2.add(scrollPane, BorderLayout.CENTER);
		
		panelYear = new JPanel();
		panelYear.setForeground(new Color(0, 128, 128));
		panelYear.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panelYear);
		panelYear.setLayout(new WrapLayout(0, 20, 20));
		
		panelStudents = new JPanel();
		panelStudents.setBorder(null);
		panelStudents.setBackground(new Color(40, 40, 40));
		//scrollPane_1.setViewportView(panel2);
		panelStudents.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 0));
		
		for(int i = 0; i< 100; i++) {
			SchoolMembers sm = new SchoolMembers();
			panelStudents.add(sm);
		}
		
		panelClasses = new JPanel();
		panelClasses.setBorder(null);
		panelClasses.setBackground(new Color(40, 40, 40));
		//scrollPane_1.setViewportView(panel2);
		panelClasses.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 0));
		
		panelProfs = new JPanel();
		panelProfs.setBorder(null);
		panelProfs.setBackground(new Color(40, 40, 40));
		//scrollPane_1.setViewportView(panel2);
		panelProfs.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 0));
		
		panelParents = new JPanel();
		panelParents.setBorder(null);
		panelParents.setBackground(new Color(40, 40, 40));
		//scrollPane_1.setViewportView(panel2);
		panelParents.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 0));
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane1.setBorder(null);
		p.add(scrollPane1, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(40, 40, 40));
		scrollPane1.setViewportView(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		
		JButton logo = new JButton("");
		logo.setMultiClickThreshhold(1000L);
		logo.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		logo.setPreferredSize(new Dimension(70, 50));
		logo.setFont(new Font("Arial", Font.PLAIN, 27));
		logo.setFocusPainted(false);
		logo.setBorder(null);
		logo.setBackground(new Color(40, 40, 40));
		panel_5.add(logo);
		
		
		JButton btnAs = new JButton("An. scholaires");
		btnAs.setMultiClickThreshhold(1000L);
		btnAs.setFocusPainted(false);
		btnAs.setPreferredSize(new Dimension(150, 50));
		btnAs.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
		btnAs.setIconTextGap(10);
		btnAs.setVerticalTextPosition(SwingConstants.CENTER);
		btnAs.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAs.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
		btnAs.setFont(new Font("Roboto", Font.BOLD, 14));
		btnAs.setBackground(new Color(60, 60, 60));
		btnAs.setForeground(new Color(255, 255, 255));
		panel_5.add(btnAs);

		
		JButton btnStudents = new JButton("El\u00E8ves");
		btnStudents.setMultiClickThreshhold(1000L);
		btnStudents.setPreferredSize(new Dimension(150, 50));
		btnStudents.setBorder(null);
		//btnCours.setBorderPainted(true);
		btnStudents.setIconTextGap(10);
		btnStudents.setVerticalTextPosition(SwingConstants.CENTER);
		btnStudents.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnStudents.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
		btnStudents.setForeground(Color.LIGHT_GRAY);
		btnStudents.setFont(new Font("Roboto", Font.BOLD, 14));
		btnStudents.setFocusPainted(false);
		btnStudents.setBackground(new Color(40, 40, 40));
		panel_5.add(btnStudents);
		
		
		JButton btnClasses = new JButton("Classes");
		btnClasses.setMultiClickThreshhold(1000L);
		btnClasses.setPreferredSize(new Dimension(150, 50));
		btnClasses.setBorder(null);
		btnClasses.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnClasses.setVerticalTextPosition(SwingConstants.CENTER);
		btnClasses.setIconTextGap(10);
		btnClasses.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClasses.setForeground(Color.LIGHT_GRAY);
		btnClasses.setFont(new Font("Roboto", Font.BOLD, 14));
		btnClasses.setFocusPainted(false);
		btnClasses.setBackground(new Color(40, 40, 40));
		panel_5.add(btnClasses);
		
		JButton btnProfs = new JButton("Professeurs");
		btnProfs.setMultiClickThreshhold(1000L);
		btnProfs.setPreferredSize(new Dimension(150, 50));
		btnProfs.setBorder(null);
		btnProfs.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnProfs.setVerticalTextPosition(SwingConstants.CENTER);
		btnProfs.setIconTextGap(10);
		btnProfs.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnProfs.setForeground(Color.LIGHT_GRAY);
		btnProfs.setFont(new Font("Roboto", Font.BOLD, 14));
		btnProfs.setFocusPainted(false);
		btnProfs.setBackground(new Color(40, 40, 40));
		panel_5.add(btnProfs);
		
		JButton btnParents = new JButton("Parents");
		btnParents.setMultiClickThreshhold(1000L);
		btnParents.setPreferredSize(new Dimension(150, 50));
		btnParents.setBorder(null);
		btnParents.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnParents.setVerticalTextPosition(SwingConstants.CENTER);
		btnParents.setIconTextGap(10);
		btnParents.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnParents.setForeground(Color.LIGHT_GRAY);
		btnParents.setFont(new Font("Roboto", Font.BOLD, 14));
		btnParents.setFocusPainted(false);
		btnParents.setBackground(new Color(40, 40, 40));
		panel_5.add(btnParents);
		
		
		
		
		btnAs.addActionListener(new ActionListener() {
			boolean areLoaded = true;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 0;
				
				scrollPane.setViewportView(panelYear);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnAs.setPreferredSize(new Dimension(150, 50));
				btnAs.setForeground(Color.white);
				btnAs.setBackground(new Color(60, 60, 60));
				btnAs.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnAs.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	//NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				//Student.deselectAll();
			}
		});
		
		btnStudents.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 1;
				
				scrollPane.setViewportView(panelStudents);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnStudents.setPreferredSize(new Dimension(150, 50));
				btnStudents.setForeground(Color.white);
				btnStudents.setBackground(new Color(60, 60, 60));
				btnStudents.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnStudents.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	//NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				//Student.deselectAll();
			}
		});
		
		btnClasses.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 2;
				
				scrollPane.setViewportView(panelClasses);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnClasses.setPreferredSize(new Dimension(150, 50));
				btnClasses.setForeground(Color.white);
				btnClasses.setBackground(new Color(60, 60, 60));
				btnClasses.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnClasses.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	//NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				//Student.deselectAll();
			}
		});
		
		btnProfs.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 3;
				
				scrollPane.setViewportView(panelProfs);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnProfs.setPreferredSize(new Dimension(150, 50));
				btnProfs.setForeground(Color.white);
				btnProfs.setBackground(new Color(60, 60, 60));
				btnProfs.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnProfs.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	//NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				//Student.deselectAll();
			}
		});
		
		btnParents.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 4;
				
				scrollPane.setViewportView(panelParents);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnParents.setPreferredSize(new Dimension(150, 50));
				btnParents.setForeground(Color.white);
				btnParents.setBackground(new Color(60, 60, 60));
				btnParents.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnParents.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	//NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				//Student.deselectAll();
			}
		});
		
		
		
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setPreferredSize(new Dimension(250, 250));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelYear.getComponentCount() > 1) {
					List l = Arrays.asList(((JLabel) ((Container) ((Container) panelYear.getComponent(panelYear.getComponentCount()-2)).getComponent(1)).getComponent(1)).getText().split("-"));

					NewScholarYear nsy = new NewScholarYear(((Container) panelYear.getComponent(panelYear.getComponentCount()-2)).getName(), schoolId);
					nsy.setVisible(true);
					
			}else {
				NewScholarYear nsy = new NewScholarYear("Annee 1", schoolId);
				nsy.setVisible(true);

				}
				}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setForeground(new Color(20,148,198));
				btnNewButton_1.setBackground(new Color(60, 60, 60).brighter());
			}@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setForeground(Color.white);
				btnNewButton_1.setBackground(new Color(60, 60, 60));
			}
		});
		btnNewButton_1.setFont(new Font("Roboto", Font.BOLD, 99));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);

		panelYear.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(60, 60, 60));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(350, 2));
		getContentPane().add(scrollPane_2, BorderLayout.WEST);
		
		
		
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
		 
		 
		SchoolInfo ui = new SchoolInfo(schoolId);
		scrollPane_2.setViewportView(ui);
	
		
		loadAcademicYears(schoolId, userId);
		
		/*
		 * SwingUtilities.invokeLater(() -> { JScrollBar bar =
		 * scrollPane.getHorizontalScrollBar(); bar.setValue(bar.getMaximum()); } );
		 */
	}
	
	public static void loadAcademicYears(String schoolId, String userId) {
		
		for(int i = 0; i< panelYear.getComponentCount()-1;i++) {
			panelYear.remove(i);
			panelYear.revalidate();
			panelYear.repaint();
			
		}
		int i = 0;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs;
			if(UserPanel.selectedRole.equals("Administrateur") || UserPanel.selectedRole.equals("Administrateur General")) {
			rs=stmt.executeQuery("select * from academic_year "
					+ "WHERE school_id = '"+schoolId+"' AND is_active = 1");
			}else {
				rs=stmt.executeQuery("SELECT * " + 
						"FROM user_responsability AS UR "
						+ "JOIN courses_in_classroom AS cic " + 
						"JOIN academic_year as AY " + 
						"WHERE AY.school_id = '"+schoolId+"' AND cic.courses_in_classroom_id = UR.courses_in_classroom_id AND AY.is_active = 1 AND cic.is_active = 1");
			}
			while(rs.next())
			{
				
				i++;
				
				String id;
				if(UserPanel.selectedRole.equals("Administrateur") || UserPanel.selectedRole.equals("Administrateur General")) {
					id = rs.getString("ay_id");
				}else {
					id = rs.getString("cic.ay_id");
				}
							
							JPanel panel_4 = new JPanel();
						
						panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
						panel_4.setBackground(new Color(60, 60, 60));
						panel_4.setPreferredSize(new Dimension(250, 250));
						panelYear.add(panel_4, panelYear.getComponentCount()-1);
						panel_4.setLayout(new BorderLayout(0, 0));
						panel_4.setName(id);
						
						JButton btnNewButton = new JButton("Supprimer");
						btnNewButton.setFocusPainted(false);
						btnNewButton.setForeground(new Color(255, 255, 255));
						btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 15));
						btnNewButton.setPreferredSize(new Dimension(89, 30));
						if(UserPanel.selectedRole.equals("Administrateur") || UserPanel.selectedRole.equals("Administrateur General")) {
						panel_4.add(btnNewButton, BorderLayout.NORTH);
						}
						btnNewButton.setBackground(panel_4.getBackground());
						btnNewButton.setVisible(false);
						
						
						JPanel panel_6 = new JPanel();
						panel_6.setBackground(new Color(60, 60, 60));
						panel_4.add(panel_6, BorderLayout.CENTER);
						panel_6.setLayout(new BorderLayout(0, 0));
						
						JLabel lblNewLabel = new JLabel("Ann\u00E9e Scholaire");
						lblNewLabel.setForeground(new Color(255, 255, 255));
						lblNewLabel.setPreferredSize(new Dimension(77, 30));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						panel_6.add(lblNewLabel, BorderLayout.NORTH);
						lblNewLabel.setBackground(lblNewLabel.getParent().getBackground());
						lblNewLabel.setOpaque(true);

						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								panel_4.setBorder(new LineBorder(new Color(20, 148, 198), 4));
								btnNewButton.setVisible(true);
								lblNewLabel.setBackground(lblNewLabel.getParent().getBackground().darker());
								
							}@Override
							public void mouseExited(MouseEvent e) {
								panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
								btnNewButton.setVisible(false);
								lblNewLabel.setBackground(lblNewLabel.getParent().getBackground());
							}
							@Override
							public void mouseClicked(MouseEvent e) {
								if(e.getClickCount()==2) {
									if(UserPanel.selectedRole.equals("Administrateur") || UserPanel.selectedRole.equals("Administrateur General")) {
									List l = Arrays.asList(((JLabel) ((Container) lblNewLabel.getParent()).getComponent(1)).getText().split("-"));

									NewScholarYear nsy = new NewScholarYear(panel_4.getName(), schoolId);
									nsy.setVisible(true);
									nsy.actualiser.setVisible(true);
									nsy.create.setVisible(false);
									nsy.title.setText("Changer l'ann\u00E9e scholaire");
									}
								}
								
							}
						});
						
						JLabel lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>"+getAcademicYearName(id)+"</div></html>");
						lblNewLabel_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_1.setBackground(new Color(34, 212, 118));
						lblNewLabel_1.setOpaque(true);
						lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 30));
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						panel_6.add(lblNewLabel_1, BorderLayout.CENTER);
						
						JButton btnOuvrir = new JButton("Ouvrir");
						btnOuvrir.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								btnOuvrir.setBackground(new Color(20, 148, 198));
								
							}@Override
							public void mouseExited(MouseEvent e) {
								btnOuvrir.setBackground(btnOuvrir.getParent().getBackground());
							}
						});
						btnOuvrir.setFocusPainted(false);
						btnOuvrir.setForeground(new Color(255, 255, 255));
						btnOuvrir.setPreferredSize(new Dimension(89, 40));
						btnOuvrir.setFont(new Font("Roboto", Font.PLAIN, 18));
						panel_6.add(btnOuvrir, BorderLayout.SOUTH);
						btnOuvrir.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(255, 255, 255)));
						btnOuvrir.setBackground(btnOuvrir.getParent().getBackground());
						
						btnOuvrir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								

								Loading l = new Loading();
								l.setVisible(true);
								
							    new Thread(new Runnable(){
							    @Override
							    public void run(){
							    	
								Login.selectedAcademicYearID = btnOuvrir.getParent().getParent().getName();
								Home h = new Home(Login.selectedSchoolID, Login.selectedUserID, Login.selectedAcademicYearID);
								h.frame.setVisible(true);
								SwingUtilities.getRoot(panelYear).setVisible(false);
								
								 SwingUtilities.invokeLater(new Runnable(){
						             @Override public void run(){
						            	 l.setVisible(false);
						           }
						          });
						       }

						    }).start();
								}
						});

						lblNewLabel_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								if(e.getClickCount()==2) {
								Loading l = new Loading();
								l.setVisible(true);
								
							    new Thread(new Runnable(){
							    @Override
							    public void run(){
							    	
							    	Login.selectedAcademicYearID = lblNewLabel_1.getParent().getParent().getName();
								Home h = new Home(Login.selectedSchoolID, Login.selectedUserID, Login.selectedAcademicYearID);
								h.frame.setVisible(true);
								SwingUtilities.getRoot(panelYear).setVisible(false);
								
								 SwingUtilities.invokeLater(new Runnable(){
						             @Override public void run(){
						            	 l.setVisible(false);
						           }
						          });
						       }

						    }).start();
								}}
							@Override
							public void mouseEntered(MouseEvent e) {
								panel_4.setBorder(new LineBorder(new Color(20, 148, 198), 4));
								btnNewButton.setVisible(true);
								
							}@Override
							public void mouseExited(MouseEvent e) {
								panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
								btnNewButton.setVisible(false);
							}
						});
					
						for(int j = 0; j< panel_4.getComponentCount(); j++) {
							panel_4.getComponent(j).addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								btnNewButton.setVisible(true);
								panel_4.setBorder(new LineBorder(new Color(20, 148, 198), 4));
							}@Override
							public void mouseExited(MouseEvent e) {
								btnNewButton.setVisible(false);
								panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
							}
						});
						}
						

						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								List l = Arrays.asList(((JLabel) ((Container) btnNewButton.getParent().getComponent(1)).getComponent(1)).getText().split("-"));
								deleteAcademicYear(btnNewButton.getParent().getName());

								SwingUtilities.getRoot(ScholarYears.panelYear).setVisible(false);
											ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
											SwingUtilities.getRoot(panelYear).setVisible(true);
								
							}
						});

						btnNewButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								btnNewButton.setBackground(new Color(255, 102, 102));
								
							}@Override
							public void mouseExited(MouseEvent e) {
								btnNewButton.setBackground(btnOuvrir.getParent().getBackground());
							}
						});
						}


			if(i>0) {
				JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Ceci est la liste des annees scholaires auquelles vous pouvez acceder. Cliquez sur \"ouvrir\" pour continuer.</div></html>");
				lblNewLabel.setPreferredSize(new Dimension(500, 50));
				lblNewLabel.setBackground(new Color(60, 60, 60));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
				panelYear.add(lblNewLabel, 0);
			}
			
			if(panelYear.getComponentCount() == 1) {
				JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'y a actuellement aucune annee scholaire enregistree dans cet etablissemment. Cliquez sur + pour en ajouter.</div></html>");
				lblNewLabel.setPreferredSize(new Dimension(500, 50));
				lblNewLabel.setBackground(new Color(60, 60, 60));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
				panelYear.add(lblNewLabel, 0);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			}
				
		//panelYear.setPreferredSize(new Dimension((panelYear.getComponentCount()+1)*(250+20), getHeight()*13/100+300));
	
	}
	
	
	
	public static String getAcademicYearName(String ayID) {
		String name = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from academic_year "
					+ "WHERE ay_id = '"+ayID+"' LIMIT 1");
			while(rs.next())
			{
				name = rs.getString("year_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return name;
	}
	
	
	public static String getSchoolOfAcademicYear(String ay_id) {
		String id = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from academic_year "
					+ "WHERE ay_id = '"+ay_id+"' LIMIT 1");
			while(rs.next())
			{
				id = rs.getString("school_id");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return id;
	}
	

	public static void deleteAcademicYear(String ayId) {

		Statement stmt;
		try {
			stmt = mysql.con.createStatement();
		stmt.executeUpdate("UPDATE academic_year " + 
				"SET is_active = 0 "
						+ "WHERE ay_id = "+ayId);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	public static void updateEstablishment(String schoolId, String name1, String name2) {

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
				comp.add(i, l.get(0).toString()+"//"+name1+"//"+name2+"//active");
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
	
	public static void deleteEstablishment(String schoolId) {

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
				comp.add(i, l.get(0).toString()+"//"+l.get(1).toString()+"//"+l.get(2).toString()+"//deleted");
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
