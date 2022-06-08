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

import Application.Group;
import Application.Home;
import Application.ResizeImages;
import app.App;
import app.General;
import app.LPane;
import Class.NewCourse;
import Class.OptionsMenu.CourseMenu;
import Class.OptionsMenu.ExamMenu;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.TestMenu;
import app.Test;
import app.WrapLayout;
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
import sideInformation.StudentInfo;

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


	public static JFrame frame;
	public static JPanel panel;
	public static JButton add;
	public static JLabel no;
	public static JButton delete;
	public static JButton edit;
	public static JButton button_3;
	public static JLabel classe;
	public static JTextField textField;
	private JPanel panel_6;
	private JScrollPane scrollPane;
	public static JPanel panel1;
	public static JTabbedPane tabbedPane;
	public static JPanel panel2;
	public static JComboBox ordre;
	public static JComboBox trim;
	public static JPanel panelTests;
	public static JPanel panelExams;
	public static JButton deleteTest;
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
		panel_1.setBackground(Home.getClassColors(classroom_in_ay_id).get(0));
		panel_1.setPreferredSize(new Dimension(10, frame.getHeight()*20/100*30/100));
		panel.add(panel_1, BorderLayout.NORTH);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
	
		
		add = new JButton("");
		add.setForeground(Color.WHITE);
		add.setIconTextGap(0);
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		add.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setFont(new Font("Arial", Font.PLAIN, 19));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(new Color(0, 150, 150));
		add.setBounds(158, 4, 104, 99);
		panel_2.add(add);

		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				add.setBackground(new Color(0, 180, 180));
				add.setText("Ajouter");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				add.setBackground(new Color(0, 150, 150));
				add.setText(null);
			}
		});
		
		delete = new JButton("");
		delete.setForeground(Color.WHITE);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setFont(new Font("Arial", Font.PLAIN, 19));
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(new Color(0, 150, 150));
		delete.setBounds(267, 4, 104, 99);
		panel_2.add(delete);
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 180, 180));
				delete.setText("Supprimer");
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 150, 150));
				delete.setText(null);
			}}
		});
		
		edit = new JButton("");
		edit.setForeground(Color.WHITE);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setFont(new Font("Arial", Font.PLAIN, 19));
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(0, 150, 150));
		edit.setBounds(376, 4, 104, 100);
		panel_2.add(edit);
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 180, 180));
				edit.setText("Modifier");
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 150, 150));
				edit.setText(null);
			}}
		});
		
		button_3 = new JButton("");
		button_3.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button_3.setFont(new Font("Arial", Font.PLAIN, 27));
		button_3.setFocusPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(0, 128, 128));
		button_3.setBounds(10, 7, 104, 94);
		panel_2.add(button_3);
		
		textField = new JTextField();
		textField.setBounds(1015, 0, 325, 35);
		panel_2.add(textField);
		textField.setColumns(10);
		
		ordre = new JComboBox();
		ordre.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ranking();
			}
		});
		ordre.setModel(new DefaultComboBoxModel(new String[] {"A-Z", "Merite", "Progres", "Echecs"}));
		ordre.setFont(new Font("Roboto", Font.PLAIN, 19));
		ordre.setBounds(1077, 75, 96, 30);
		panel_2.add(ordre);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		tabbedPane.setFocusTraversalPolicyProvider(true);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(240, 248, 255));
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Roboto", Font.BOLD, 16));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 128, 128));
		tabbedPane.addTab("Eleves", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(40, 40, 40));
		panel_4.setPreferredSize(new Dimension(10, 40));
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_4.add(scrollPane_4, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(40, 40, 40));
		scrollPane_4.setViewportView(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(600, 10));
		panel_10.add(panel_11, BorderLayout.EAST);
		panel_11.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 2));
		panel_11.setBackground(panel_11.getParent().getBackground());
		
		
		
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
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
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
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
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
				
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
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
				for(int i = 0; i< Application.panel1.getComponentCount(); i++) {
					if(Application.panel1.getComponent(i) instanceof Student) {
						String student_id = ((Container) Application.panel1.getComponent(i)).getName();
					NewStudent.loadStudentdata((Container) Application.panel1.getComponent(i), student_id, classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
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
						((Container) ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i)).getComponent(2).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 55));
					}else {
						((Container) scrollPane.getViewport().getComponent(0)).getComponent(i).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 67));
						((Container) ((Container) scrollPane.getViewport().getComponent(0)).getComponent(i)).getComponent(2).setPreferredSize(new Dimension(scrollPane.getWidth()-20, 37));
						}
			}
				((Container) scrollPane.getViewport().getComponent(0)).revalidate();
				((Container) scrollPane.getViewport().getComponent(0)).repaint();
			
			}
		});
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panel1 = new JPanel();
		panel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panel1.setBackground(new Color(40, 40, 40));
		panel1.setForeground(new Color(0, 128, 128));
		scrollPane.setViewportView(panel1);
		panel1.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 3));
		
		
		
		panel_6 = new JPanel();
		panel_6.setBorder(null);
		tabbedPane.addTab("Cours", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setPreferredSize(new Dimension(10, 35));
		panel_7.setBackground(new Color(40, 40, 40));
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNomComplet = new JLabel("Nom complet");
		lblNomComplet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomComplet.setForeground(Color.WHITE);
		lblNomComplet.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNomComplet.setBorder(null);
		lblNomComplet.setBounds(0, 0, 399, 35);
		panel_7.add(lblNomComplet);
		
		JLabel lblMoyenne = new JLabel("Moyenne %");
		lblMoyenne.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyenne.setForeground(Color.WHITE);
		lblMoyenne.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblMoyenne.setBorder(null);
		lblMoyenne.setBounds(383, 0, 152, 35);
		panel_7.add(lblMoyenne);
		
		JLabel lblMoyennePoints = new JLabel("Moyenne Points");
		lblMoyennePoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyennePoints.setForeground(Color.WHITE);
		lblMoyennePoints.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblMoyennePoints.setBorder(null);
		lblMoyennePoints.setBounds(559, 0, 146, 35);
		panel_7.add(lblMoyennePoints);
		
		JLabel label_4 = new JLabel("Echecs");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_4.setBorder(null);
		label_4.setBounds(726, 0, 121, 35);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("Interrogations");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_5.setBorder(null);
		label_5.setBounds(857, 0, 157, 35);
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("Progression");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_6.setBorder(null);
		label_6.setBounds(1024, 0, 146, 35);
		panel_7.add(label_6);
		
		JLabel lblTauxDeReussite = new JLabel("Taux de reussite");
		lblTauxDeReussite.setHorizontalAlignment(SwingConstants.CENTER);
		lblTauxDeReussite.setForeground(Color.WHITE);
		lblTauxDeReussite.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblTauxDeReussite.setBorder(null);
		lblTauxDeReussite.setBounds(1176, 0, 179, 35);
		panel_7.add(lblTauxDeReussite);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(15);

		scrollPane_1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panel2 = new JPanel();
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panel2.setBackground(new Color(40, 40, 40));
		scrollPane_1.setViewportView(panel2);
		panel2.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 3));
		

		scrollPane_1.setBackground(panel2.getBackground());
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Interrogations", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setPreferredSize(new Dimension(10, 35));
		panel_8.setBackground(new Color(40, 40, 40));
		panel_5.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblInterroNo = new JLabel("Interrogation");
		lblInterroNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterroNo.setForeground(Color.WHITE);
		lblInterroNo.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblInterroNo.setBorder(null);
		lblInterroNo.setBounds(0, 0, 132, 35);
		panel_8.add(lblInterroNo);
		
		JLabel lblNomDuCours = new JLabel("Nom du cours");
		lblNomDuCours.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDuCours.setForeground(Color.WHITE);
		lblNomDuCours.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNomDuCours.setBorder(null);
		lblNomDuCours.setBounds(97, 0, 423, 35);
		panel_8.add(lblNomDuCours);
		
		JLabel lblMoyennePoints_1 = new JLabel("Moyenne Points");
		lblMoyennePoints_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyennePoints_1.setForeground(Color.WHITE);
		lblMoyennePoints_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblMoyennePoints_1.setBorder(null);
		lblMoyennePoints_1.setBounds(718, 0, 152, 35);
		panel_8.add(lblMoyennePoints_1);
		
		JLabel lblMoyenne_1 = new JLabel("Moyenne %");
		lblMoyenne_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyenne_1.setForeground(Color.WHITE);
		lblMoyenne_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblMoyenne_1.setBorder(null);
		lblMoyenne_1.setBounds(894, 0, 146, 35);
		panel_8.add(lblMoyenne_1);
		
		JLabel label_13 = new JLabel("Echecs");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_13.setBorder(null);
		label_13.setBounds(1050, 0, 121, 35);
		panel_8.add(label_13);
		
		JLabel lblDateDEvaluation = new JLabel("Date d' evaluation");
		lblDateDEvaluation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDEvaluation.setForeground(Color.WHITE);
		lblDateDEvaluation.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblDateDEvaluation.setBorder(null);
		lblDateDEvaluation.setBounds(519, 0, 163, 35);
		panel_8.add(lblDateDEvaluation);
		
		JLabel label_16 = new JLabel("Taux de reussite");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_16.setBorder(null);
		label_16.setBounds(1176, 0, 179, 35);
		panel_8.add(label_16);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_5.add(scrollPane_2, BorderLayout.CENTER);
		

		scrollPane_2.getVerticalScrollBar().setUnitIncrement(15);
		

		scrollPane_2.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_2.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Examens", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setPreferredSize(new Dimension(10, 35));
		panel_9.setBackground(new Color(40, 40, 40));
		panel_6.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblSeries = new JLabel("Series");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblSeries.setBorder(null);
		lblSeries.setBounds(0, 0, 132, 35);
		panel_9.add(lblSeries);
		
		JLabel label_2 = new JLabel("Nom du cours");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_2.setBorder(null);
		label_2.setBounds(97, 0, 423, 35);
		panel_9.add(label_2);
		
		JLabel label_3 = new JLabel("Moyenne Points");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_3.setBorder(null);
		label_3.setBounds(718, 0, 152, 35);
		panel_9.add(label_3);
		
		JLabel label_7 = new JLabel("Moyenne %");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_7.setBorder(null);
		label_7.setBounds(894, 0, 146, 35);
		panel_9.add(label_7);
		
		JLabel label_8 = new JLabel("Echecs");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_8.setBorder(null);
		label_8.setBounds(1050, 0, 121, 35);
		panel_9.add(label_8);
		
		JLabel lblDateDePassation = new JLabel("Date de passation");
		lblDateDePassation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDePassation.setForeground(Color.WHITE);
		lblDateDePassation.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblDateDePassation.setBorder(null);
		lblDateDePassation.setBounds(519, 0, 163, 35);
		panel_9.add(lblDateDePassation);
		
		JLabel label_10 = new JLabel("Taux de reussite");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_10.setBorder(null);
		label_10.setBounds(1176, 0, 179, 35);
		panel_9.add(label_10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_6.add(scrollPane_3, BorderLayout.CENTER);
		
		panelExams = new JPanel();
		panelExams.setBackground(new Color(40, 40, 40));
		scrollPane_3.setViewportView(panelExams);
		panelExams.setLayout(new WrapLayout(1, 5, 3));
		
		panelTests = new JPanel();
		panelTests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect();
			}
		});
		panelTests.setBackground(new Color(40, 40, 40));
		scrollPane_2.setViewportView(panelTests);
		panelTests.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 3));
		
		trim = new JComboBox();
		trim.setModel(new DefaultComboBoxModel(new String[] {"1er Trimestre", "2eme Trimestre", "3eme Trimestre", "Toute l'annee"}));
		trim.setFont(new Font("Roboto", Font.PLAIN, 19));
		trim.setBounds(1183, 75, 157, 30);
		panel_2.add(trim);
		
		JButton btnNewButton1 = new JButton("Publier");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publish();
			}
		});
		btnNewButton1.setFocusPainted(false);
		btnNewButton1.setBorderPainted(false);
		btnNewButton1.setBackground(Color.WHITE);
		btnNewButton1.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnNewButton1.setBounds(812, 69, 109, 30);
		panel_2.add(btnNewButton1);
		
		deleteTest = new JButton("Delete test");
		deleteTest.setEnabled(false);
		deleteTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestBox.deleteTest();
			}
		});
		deleteTest.setVerticalTextPosition(SwingConstants.BOTTOM);
		deleteTest.setIconTextGap(0);
		deleteTest.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteTest.setForeground(Color.WHITE);
		deleteTest.setFont(new Font("Arial", Font.PLAIN, 19));
		deleteTest.setFocusPainted(false);
		deleteTest.setBorder(null);
		deleteTest.setBackground(new Color(0, 150, 150));
		deleteTest.setBounds(526, 4, 104, 100);
		panel_2.add(deleteTest);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"TG", "Examen", "TG+Ex."}));
		comboBox1.setFont(new Font("Roboto", Font.PLAIN, 19));
		comboBox1.setBounds(1183, 40, 96, 30);
		panel_2.add(comboBox1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setPreferredSize(new Dimension(400, 2));
		frame.getContentPane().add(scrollPane_5, BorderLayout.EAST);

		scrollPane_5.getVerticalScrollBar().setUnitIncrement(10);

		scrollPane_5.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_5.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		StudentInfo panel_12 = new StudentInfo(classroom_in_ay_id);
		scrollPane_5.setViewportView(panel_12);
		
		for(int i = 0; i< panel_1.getComponentCount(); i++) {
			panel_1.getComponent(i).setForeground(Home.getClassColors(classroom_in_ay_id).get(1));
		}


		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				manageTabs(classroom_in_ay_id);
			}
		});


		Application.manageTabs(classroom_in_ay_id);
		Application.deselect();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{

        		NewStudent.load(classroom_in_ay_id);
        		Application.merite();
            	 return null;
            }
        }.execute();
        
        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		TestBox.loadAllTests(classroom_in_ay_id);
            	 return null;
            }
        }.execute();
        
        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
    			NewCourse.load(classroom_in_ay_id);
            	 return null;
            }
        }.execute();
        
        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
        		ExamBox.loadAllExams(classroom_in_ay_id);
            	 return null;
            }
        }.execute();
		frame.revalidate();
		frame.repaint();
}
	
	
	public static void deselect() {
		if(tabbedPane.getSelectedIndex()==0) {
			Student.deselectAll();
		}if(tabbedPane.getSelectedIndex()==1) {
			Course.deselectAll();
		}if(tabbedPane.getSelectedIndex()==2) {
			TestBox.deselectAll();
		}
	}
	

	public static void manageTabs(String classroom_in_ay_id) {
	if(tabbedPane.getSelectedIndex()==0) {
		StudentMenu sm = new StudentMenu(classroom_in_ay_id);
		panel.remove(1);
		panel.add(sm, BorderLayout.CENTER);
		Application.no.setText(String.valueOf(panel1.getComponentCount()));
	}if(tabbedPane.getSelectedIndex()==1) {
		CourseMenu cm = new CourseMenu(classroom_in_ay_id);
		panel.remove(1);
		panel.add(cm, BorderLayout.CENTER);
		Application.no.setText(String.valueOf(panel2.getComponentCount()));
	}if(tabbedPane.getSelectedIndex()==2) {
		TestMenu tm = new TestMenu(classroom_in_ay_id);
		panel.remove(1);
	panel.add(tm, BorderLayout.CENTER);
		Application.no.setText(String.valueOf(panelTests.getComponentCount()));
		
	}if(tabbedPane.getSelectedIndex()==3) {
		ExamMenu tm = new ExamMenu(classroom_in_ay_id);
		panel.remove(1);
	panel.add(tm, BorderLayout.CENTER);
		Application.no.setText(String.valueOf(panelExams.getComponentCount()));
		
	}
	}
	
	public static void publish(){
			
			String textSent = "Derniere Mise a jour sur les performances de "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(2)))).getText()+" en classe de "+classe.getText()+" pour le 3eme Trimestre  :\n\n"+
			"Pourcentage: "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(3)))).getText()+" ;\n"+
			"Total des points: "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(4)))).getText()+" ;\n"+
			"Echecs: "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(5)))).getText()+" ;\n"+
			"Progression: "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(7)))).getText()+" ;\n"+
			"Interrogations effectuees: "+((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(6)))).getText()+".\n\n\nMerci beaucoup pour votre attention. \nJe vous souhaite une bonne preparation pour les examens.\nMade and developed by CiGicom.";
			
		
			try {
				SMSSender.sendMessage(((JLabel) ((((Container) panel1.getComponent(Integer.parseInt(Application.no.getText()))).getComponent(8)))).getText(), textSent);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
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
