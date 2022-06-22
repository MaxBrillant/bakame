package Class;

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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import Application.Class;
import Application.Group;
import Application.Home;
import Application.ResizeImages;
import app.App;
import app.General;
import app.LPane;
import Class.NewCourse;
import Class.OptionsMenu.CourseMenu;
import Class.OptionsMenu.ExamMenu;
import Class.OptionsMenu.HomeMenu1;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.TestMenu;
import app.Test;
import app.WrapLayout;
import elements.CustomButton;
import Publishing.Mail;
import Publishing.SMSSender;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

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
import sideInformation.ClassInfo;

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
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Application {


	private static int selectedTab;
	public static JFrame frame;
	public static JPanel panel;
	public static JLabel no;
	public static JLabel classe;
	private JScrollPane scrollPane;
	public static JPanel panelStudents;
	public static JPanel panelCourses;
	public static JPanel panelTests;
	public static JPanel panelExams;
	//public static JPanel panel2;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application(String classroom_id) {
		initialize(classroom_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String classroom_in_ay_id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(80, 80, 80));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(480, 0));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Home.getClassColors(classroom_in_ay_id).get(0));
		panel_1.setPreferredSize(new Dimension(10, frame.getHeight()*20/100*30/100));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		classe = new JLabel(Home.getClassName(classroom_in_ay_id));
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		panel_1.add(classe, BorderLayout.CENTER);
		
		no = new JLabel("0");
		no.setVisible(false);
		no.setHorizontalAlignment(SwingConstants.CENTER);
		no.setForeground(new Color(255, 255, 255));
		no.setFont(new Font("Futura Hv BT", Font.PLAIN, 25));
		no.setPreferredSize(new Dimension(160, 14));
		panel_1.add(no, BorderLayout.EAST);
		
		JButton label = new JButton(ScholarYears.getAcademicYearName(Login.selectedAcademicYearID));
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home(Login.selectedSchoolID, Login.selectedUserID, Login.selectedAcademicYearID);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		label.setBorderPainted(false);
		label.setFocusPainted(false);
		label.setBackground(panel_1.getBackground());
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(panel_1.getBackground().darker());
			}@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(panel_1.getBackground());
			}
		});
		label.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		label.setPreferredSize(new Dimension(240, 14));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		panel_1.add(label, BorderLayout.WEST);
		
		
		JPanel p = new JPanel();
		//panel_3.setBorder(null);
		//panel_3.setBackground();
		p.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(p, BorderLayout.CENTER);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(40, 40, 40));
		p.add(panel_5, BorderLayout.NORTH);
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
		
		
		JButton btnStudents = new JButton("El\u00E8ves");
		btnStudents.setMultiClickThreshhold(1000L);
		btnStudents.setFocusPainted(false);
		btnStudents.setPreferredSize(new Dimension(150, 50));
		btnStudents.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
		btnStudents.setIconTextGap(10);
		btnStudents.setVerticalTextPosition(SwingConstants.CENTER);
		btnStudents.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnStudents.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
		btnStudents.setFont(new Font("Roboto", Font.BOLD, 14));
		btnStudents.setBackground(new Color(60, 60, 60));
		btnStudents.setForeground(new Color(255, 255, 255));
		panel_5.add(btnStudents);

		
		JButton btnCours = new JButton("Cours");
		btnCours.setMultiClickThreshhold(1000L);
		btnCours.setPreferredSize(new Dimension(150, 50));
		btnCours.setBorder(null);
		//btnCours.setBorderPainted(true);
		btnCours.setIconTextGap(10);
		btnCours.setVerticalTextPosition(SwingConstants.CENTER);
		btnCours.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCours.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
		btnCours.setForeground(Color.LIGHT_GRAY);
		btnCours.setFont(new Font("Roboto", Font.BOLD, 14));
		btnCours.setFocusPainted(false);
		btnCours.setBackground(new Color(40, 40, 40));
		panel_5.add(btnCours);
		
		
		JButton btnTests = new JButton("Interros");
		btnTests.setMultiClickThreshhold(1000L);
		btnTests.setPreferredSize(new Dimension(150, 50));
		btnTests.setBorder(null);
		btnTests.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnTests.setVerticalTextPosition(SwingConstants.CENTER);
		btnTests.setIconTextGap(10);
		btnTests.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnTests.setForeground(Color.LIGHT_GRAY);
		btnTests.setFont(new Font("Roboto", Font.BOLD, 14));
		btnTests.setFocusPainted(false);
		btnTests.setBackground(new Color(40, 40, 40));
		panel_5.add(btnTests);
		
		
		
		JButton btnExams = new JButton("Examens");
		btnExams.setMultiClickThreshhold(1000L);
		btnExams.setPreferredSize(new Dimension(150, 50));
		btnExams.setBorder(null);
		btnExams.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class1.png"));
		btnExams.setVerticalTextPosition(SwingConstants.CENTER);
		btnExams.setIconTextGap(10);
		btnExams.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnExams.setForeground(Color.LIGHT_GRAY);
		btnExams.setFont(new Font("Roboto", Font.BOLD, 14));
		btnExams.setFocusPainted(false);
		btnExams.setBackground(new Color(40, 40, 40));
		panel_5.add(btnExams);
		
		
		
		
		
		JPanel p1 = new JPanel();
		//panel_3.setBorder(null);
		//panel_3.setBackground();
		p1.setLayout(new BorderLayout(0, 0));
		p.add(p1, BorderLayout.CENTER);
		

		JPanel panel_10 = new JPanel();
		
		panel_10.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				int width = 0;
				for(int i = 0; i< ((Container) ((JScrollPane) panel_10.getComponent(1)).getViewport().getComponent(0)).getComponentCount(); i++) {
					if(((Container) ((JScrollPane) panel_10.getComponent(1)).getViewport().getComponent(0)).getComponent(i).isVisible()) {
					width = width+ ((Container) ((JScrollPane) panel_10.getComponent(1)).getViewport().getComponent(0)).getComponent(i).getWidth();
					}}
				
				if(panel_10.getWidth()< ((Container) panel_10.getComponent(0)).getComponent(0).getPreferredSize().width + width) {
					
					Component c1 = panel_10.getComponent(0);
					Component c2 = panel_10.getComponent(1);
					panel_10.removeAll();
					panel_10.add(c1, BorderLayout.CENTER);
					panel_10.add(c2, BorderLayout.SOUTH);
				}else {
					Component c1 = panel_10.getComponent(0);
					Component c2 = panel_10.getComponent(1);
					panel_10.removeAll();
					panel_10.add(c1, BorderLayout.CENTER);
					panel_10.add(c2, BorderLayout.EAST);
				
				}
				panel_10.revalidate();
				panel_10.repaint();
			}
		});
		panel_10.setBackground(new Color(40, 40, 40));
		p1.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		StudentMenu p2 = new StudentMenu(classroom_in_ay_id);
		panel_10.add(p2, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		//scrollPane_1.setPreferredSize(new Dimension(2, 40));
		panel_10.add(scrollPane_1, BorderLayout.EAST);
		scrollPane_1.setBackground(scrollPane_1.getParent().getBackground());
		
		
		JPanel panel_11 = new JPanel();
		scrollPane_1.setViewportView(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 2));
		panel_11.setBackground(new Color(40, 40, 40).darker());
		
		
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(10, 25));
		textField_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		textField_1.setColumns(10);
		panel_11.add(textField_1);
		
		
		
		
		JPanel panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(170, 30));
		panel_31.setBackground(new Color(60, 60, 60));
		panel_31.setBounds(39, 40, 155, 30);
		panel_11.add(panel_31);
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
				
				for(int i = 0; i< Application.panelStudents.getComponentCount(); i++) {
					if(Application.panelStudents.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panelStudents.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panelStudents.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}}
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
				
				for(int i = 0; i< Application.panelStudents.getComponentCount(); i++) {
					if(Application.panelStudents.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panelStudents.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panelStudents.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
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
		panel_11.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JLabel lblerTrimestre = new JLabel("2eme Trimestre");
		lblerTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblerTrimestre.setForeground(Color.WHITE);
		lblerTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_41.add(lblerTrimestre, BorderLayout.CENTER);
		lblerTrimestre.setText(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
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
				
				for(int i = 0; i< Application.panelStudents.getComponentCount(); i++) {
					if(Application.panelStudents.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panelStudents.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panelStudents.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
				}
		});
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(panel_41.getBackground());
		button_2.setBorder(null);
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		panel_41.add(button_2, BorderLayout.WEST);
		
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
				for(int i = 0; i< Application.panelStudents.getComponentCount(); i++) {
					if(Application.panelStudents.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panelStudents.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panelStudents.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}}
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
				Application.ranking();
			}
		});
		comboBox.setFont(new Font("Roboto", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A-z", "merite", "Progres", "Echecs"}));
		comboBox.setBounds(244, 77, 96, 30);
		panel_11.add(comboBox);
		
		
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for(int i = 0; i< ((Container) scrollPane.getViewport().getComponent(0)).getComponentCount(); i++) {
					((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-20, ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).getPreferredSize().height));
					
					if(scrollPane.getWidth()<700) {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 85));
						((Container) ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i)).getComponent(1).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 55));
					}else {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 67));
						((Container) ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i)).getComponent(1).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 37));
						}
			}
				((Container) scrollPane.getViewport().getComponent(0)).revalidate();
				((Container) scrollPane.getViewport().getComponent(0)).repaint();
			
			}
		});
		p1.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panelStudents = new JPanel();
		panelStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panelStudents.setBackground(new Color(40, 40, 40));
		panelStudents.setForeground(new Color(0, 128, 128));
		scrollPane.setViewportView(panelStudents);
		panelStudents.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 3));
		
		
		
		panelCourses = new JPanel();
		panelCourses.setBorder(null);
		panelCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panelCourses.setBackground(new Color(40, 40, 40));
		//scrollPane_1.setViewportView(panel2);
		panelCourses.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 3));
		

		panelTests = new JPanel();
		panelTests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panelTests.setBackground(new Color(40, 40, 40));
		panelTests.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 3));
		
		
		panelExams = new JPanel();
		panelExams.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panelExams.setBackground(new Color(40, 40, 40));
		panelExams.setLayout(new WrapLayout(1, 5, 3));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBorder(new LineBorder(new Color(211, 211, 211)));
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setPreferredSize(new Dimension(350, 2));
		frame.getContentPane().add(scrollPane_5, BorderLayout.WEST);
		
		

		scrollPane_5.getVerticalScrollBar().setUnitIncrement(10);

		scrollPane_5.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_5.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		ClassInfo panel_12 = new ClassInfo(classroom_in_ay_id);
		scrollPane_5.setViewportView(panel_12);
		
		for(int i = 0; i< panel_1.getComponentCount(); i++) {
			panel_1.getComponent(i).setForeground(Home.getClassColors(classroom_in_ay_id).get(1));
		}


		Application.manageTabs(classroom_in_ay_id);
		Application.deselect();
		
		
		selectedTab = 0;
		panel_11.getComponent(1).setVisible(false);
		panel_11.getComponent(2).setVisible(true);
		panel_11.getComponent(3).setVisible(false);
		
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
		
		
		btnStudents.addActionListener(new ActionListener() {
			boolean areLoaded = true;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 0;
				panel_11.getComponent(1).setVisible(false);
				panel_11.getComponent(2).setVisible(true);
				panel_11.getComponent(3).setVisible(false);
				
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
				
				if(panel_10.getComponentCount()>0) {
				panel_10.remove(0);
				}
				StudentMenu h = new StudentMenu(classroom_in_ay_id);
				panel_10.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_10.revalidate();
				panel_10.repaint();
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	NewStudent.load(classroom_in_ay_id);
						return null;
			            }
			        }.execute();
				}
				Student.deselectAll();
				}
		});
		
		
		btnCours.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 1;
				panel_11.getComponent(1).setVisible(false);
				panel_11.getComponent(2).setVisible(true);
				panel_11.getComponent(3).setVisible(false);
				
				scrollPane.setViewportView(panelCourses);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnCours.setPreferredSize(new Dimension(150, 50));
				btnCours.setForeground(Color.white);
				btnCours.setBackground(new Color(60, 60, 60));
				btnCours.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnCours.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				if(panel_10.getComponentCount()>0) {
				panel_10.remove(0);
				}
				CourseMenu h = new CourseMenu(classroom_in_ay_id);
				panel_10.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_10.revalidate();
				panel_10.repaint();
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	NewCourse.load(classroom_in_ay_id);
			            	return null;
			            }
			        }.execute();
				}
				Course.deselectAll();
				}
		});
		
		
		btnTests.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 2;
				panel_11.getComponent(1).setVisible(false);
				panel_11.getComponent(2).setVisible(true);
				panel_11.getComponent(3).setVisible(false);
				
				scrollPane.setViewportView(panelTests);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnTests.setPreferredSize(new Dimension(150, 50));
				btnTests.setForeground(Color.white);
				btnTests.setBackground(new Color(60, 60, 60));
				btnTests.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnTests.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				if(panel_10.getComponentCount()>0) {
				panel_10.remove(0);
				}
				TestMenu h = new TestMenu(classroom_in_ay_id);
				panel_10.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_10.revalidate();
				panel_10.repaint();
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	TestBox.loadAllTests(classroom_in_ay_id);
			            	 return null;
			            }
			        }.execute();
				}
				TestBox.deselectAll();
				}
		});
		
		
		btnExams.addActionListener(new ActionListener() {
			boolean areLoaded = false;
			public void actionPerformed(ActionEvent e) {
				selectedTab = 3;
				panel_11.getComponent(1).setVisible(false);
				panel_11.getComponent(2).setVisible(true);
				panel_11.getComponent(3).setVisible(false);
				
				scrollPane.setViewportView(panelExams);
				
				for(int i = 1; i< panel_5.getComponentCount(); i++) {
					panel_5.getComponent(i).setPreferredSize(new Dimension(100, 50));
					panel_5.getComponent(i).setBackground(new Color(40, 40, 40));
					panel_5.getComponent(i).setForeground(Color.LIGHT_GRAY);
					((JComponent) panel_5.getComponent(i)).setBorder(null);
					((AbstractButton) panel_5.getComponent(i)).setIcon(null);
				}
				btnExams.setPreferredSize(new Dimension(150, 50));
				btnExams.setForeground(Color.white);
				btnExams.setBackground(new Color(60, 60, 60));
				btnExams.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(20, 148, 198)));
				btnExams.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\class.png"));
				
				if(panel_10.getComponentCount()>0) {
				panel_10.remove(0);
				}
				ExamMenu h = new ExamMenu(classroom_in_ay_id);
				panel_10.add(h, 0);
				//panel_2.add(panel_2.getComponent(0));
				panel_10.revalidate();
				panel_10.repaint();
				
				if(!areLoaded) {
					areLoaded = true;
				 new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
			            	ExamBox.loadAllExams(classroom_in_ay_id);
			            	 return null;
			            }
			        }.execute();
				}
				ExamBox.deselectAll();
				}
		});
		
		
    	new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{

        		NewStudent.load(classroom_in_ay_id);
        		//Application.merite();
            	 return null;
            }
        }.execute();
        
        
        
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
        
        
		frame.revalidate();
		frame.repaint();
}
	
	
	public static void deselect() {
		if(selectedTab==0) {
			Student.deselectAll();
		}if(selectedTab==1) {
			Course.deselectAll();
		}if(selectedTab==2) {
			TestBox.deselectAll();
		}if(selectedTab==3) {
			ExamBox.deselectAll();
		}
	}
	

	public static void manageTabs(String classroom_in_ay_id) {
		/*
		 * if(tabbedPane.getSelectedIndex()==0) { StudentMenu sm = new
		 * StudentMenu(classroom_in_ay_id); panel.remove(1); panel.add(sm,
		 * BorderLayout.CENTER);
		 * Application.no.setText(String.valueOf(panel1.getComponentCount()));
		 * }if(tabbedPane.getSelectedIndex()==1) { CourseMenu cm = new
		 * CourseMenu(classroom_in_ay_id); panel.remove(1); panel.add(cm,
		 * BorderLayout.CENTER);
		 * Application.no.setText(String.valueOf(panel2.getComponentCount()));
		 * }if(tabbedPane.getSelectedIndex()==2) { TestMenu tm = new
		 * TestMenu(classroom_in_ay_id); panel.remove(1); panel.add(tm,
		 * BorderLayout.CENTER);
		 * Application.no.setText(String.valueOf(panelTests.getComponentCount()));
		 * 
		 * }if(tabbedPane.getSelectedIndex()==3) { ExamMenu tm = new
		 * ExamMenu(classroom_in_ay_id); panel.remove(1); panel.add(tm,
		 * BorderLayout.CENTER);
		 * Application.no.setText(String.valueOf(panelExams.getComponentCount()));
		 * 
		 * }
		 */}
	
	
	public static void ranking() {
		if(StudentMenu.comboBox.getSelectedIndex()==0) {
			rankAlphabetically();
		}if(StudentMenu.comboBox.getSelectedIndex()==1) {
			merite();
		}
		if(StudentMenu.comboBox.getSelectedIndex()==2) {
			rankProgress();
		}
		if(StudentMenu.comboBox.getSelectedIndex()==3) {
			rankEchecs();
		}
		panel1.revalidate();
		panel1.repaint();
	}
	
	public static void merite() {
		/*
		 * Application.rankAlphabetically(); if(panel1.getComponentCount()>1) {
		 * List<Double> percent = new ArrayList<Double>(); List<Double> percent1 = new
		 * ArrayList<Double>(); for(int i = 0; i<panel1.getComponentCount();i++) {
		 * percent.add((Double.parseDouble(((JLabel) ((((Container)
		 * panel1.getComponent(i)).getComponent(3)))).getText().replace(",",
		 * ".").replace("%", ""))));
		 * percent1.add(Double.parseDouble(percent.get(i).toString())+i*1/100); }
		 * 
		 * Collections.sort(percent, Collections.reverseOrder());
		 * Collections.sort(percent1, Collections.reverseOrder());
		 * 
		 * 
		 * for(int i = 0; i<percent.toArray().length;i++) { int t = (int)
		 * Math.round(((percent1.get(i)-percent.get(i))*100)-1);
		 * 
		 * Student st = new Student(); Application.panel1.add(st);
		 * Application.panel1.revalidate(); Application.panel1.repaint(); deselect();
		 * 
		 * 
		 * for(int j = 0;j<((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponentCount()-1;j++) { ((JLabel) ((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponent(j)).setText(((JLabel) ((Container)
		 * panel1.getComponent(t)).getComponent(j)).getText()); }
		 * 
		 * System.out.println(Math.round((percent1.get(i)-percent.get(i))*100));
		 * System.out.println((percent)); System.out.println((percent1)); } for(int j =
		 * 0; j<percent1.toArray().length;j++) { panel1.remove(0); deselect(); }
		 * 
		 * for(int i = 0; i<panel1.getComponentCount(); i++) { ((JLabel) ((Container)
		 * panel1.getComponent(i)).getComponent(1)).setText(String.valueOf(i+1)); } }
		 */}
	
public static void rankEchecs() {
	/*
	 * Application.rankAlphabetically(); List<Double> percent = new
	 * ArrayList<Double>(); List<Double> percent1 = new ArrayList<Double>(); for(int
	 * i = 0; i<panel1.getComponentCount();i++) {
	 * percent.add((Double.parseDouble(((JLabel) ((((Container)
	 * panel1.getComponent(i)).getComponent(5)))).getText().replace(",",
	 * ".").replace("%", ""))));
	 * percent1.add(Double.parseDouble(percent.get(i).toString())+i*1/100);
	 * 
	 * }
	 * 
	 * Collections.sort(percent, Collections.reverseOrder());
	 * Collections.sort(percent1, Collections.reverseOrder());
	 * 
	 * 
	 * for(int i = 0; i<percent.toArray().length;i++) { int t = (int)
	 * Math.round(((percent1.get(i)-percent.get(i))*100)-1);
	 * 
	 * Student st = new Student(); Application.panel1.add(st);
	 * Application.panel1.revalidate(); Application.panel1.repaint(); deselect();
	 * 
	 * 
	 * for(int j = 0;j<((Container)
	 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
	 * ).getComponentCount()-1;j++) { ((JLabel) ((Container)
	 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
	 * ).getComponent(j)).setText(((JLabel) ((Container)
	 * panel1.getComponent(t)).getComponent(j)).getText()); }
	 * 
	 * System.out.println(Math.round((percent1.get(i)-percent.get(i))*100));
	 * System.out.println((percent)); System.out.println((percent1)); } for(int j =
	 * 0; j<percent1.toArray().length;j++) { panel1.remove(0); deselect(); }
	 * 
	 */}
	
	public static void rankProgress() {
		/*
		 * Application.rankAlphabetically(); List<Double> percent = new
		 * ArrayList<Double>(); List<Double> percent1 = new ArrayList<Double>(); for(int
		 * i = 0; i<panel1.getComponentCount();i++) {
		 * percent.add((Double.parseDouble(((JLabel) ((((Container)
		 * panel1.getComponent(i)).getComponent(7)))).getText().replace(",",
		 * ".").replace("%", ""))));
		 * percent1.add(Double.parseDouble(percent.get(i).toString())+i*1/100); }
		 * 
		 * Collections.sort(percent, Collections.reverseOrder());
		 * Collections.sort(percent1, Collections.reverseOrder());
		 * 
		 * 
		 * for(int i = 0; i<percent.toArray().length;i++) { int t = (int)
		 * Math.round(((percent1.get(i)-percent.get(i))*100)-1);
		 * 
		 * Student st = new Student(); Application.panel1.add(st);
		 * Application.panel1.revalidate(); Application.panel1.repaint(); deselect();
		 * 
		 * 
		 * for(int j = 0;j<((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponentCount()-1;j++) { ((JLabel) ((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponent(j)).setText(((JLabel) ((Container)
		 * panel1.getComponent(t)).getComponent(j)).getText()); }
		 * 
		 * System.out.println(Math.round((percent1.get(i)-percent.get(i))*100));
		 * System.out.println((percent)); System.out.println((percent1)); } for(int j =
		 * 0; j<percent1.toArray().length;j++) { panel1.remove(0); deselect(); }
		 * 
		 */}
	
	public static void rankAlphabetically() {
		/*
		 * 
		 * List note = null;
		 * 
		 * Collection<String> sort = new TreeSet<String>(Collator.getInstance());
		 * for(int i = 0; i<panel1.getComponentCount();i++) { sort.add(((JLabel)
		 * ((((Container)
		 * panel1.getComponent(i)).getComponent(2)))).getText()+"//"+((((Container)
		 * panel1.getComponent(i)))).getName()); }
		 * 
		 * 
		 * for (int i = 0; i<sort.toArray().length;i++) { note =
		 * Arrays.asList(sort.toArray()[i].toString().trim().split("//")); int t =
		 * Integer.parseInt(note.get(1).toString())-1;
		 * 
		 * Student st = new Student(); panel1.add(st); panel1.revalidate();
		 * panel1.repaint(); deselect(); for(int j = 0;j<((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponentCount()-1;j++) { ((JLabel) ((Container)
		 * Application.panel1.getComponent(Integer.parseInt(Application.no.getText())-1)
		 * ).getComponent(j)).setText(((JLabel) ((Container)
		 * panel1.getComponent(t)).getComponent(j)).getText()); }
		 * 
		 * } System.out.println((sort));
		 * 
		 * for(int j = 0; j<sort.toArray().length;j++) { panel1.remove(0); deselect(); }
		 * 
		 */}
}
