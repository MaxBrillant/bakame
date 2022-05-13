package app;

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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.TestBox;
import CloudOperations.aws;
import CloudOperations.mysql;
import Class.CustomVerticalScrollBarUI;
import app.NewTest;
import Class.Student;
import Publishing.Mail;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class App {

	public static JFrame frame;
	public static int count = 0;
	public static JPanel panel;
	public static JPanel panel_5;
	public static JLabel number;
	public static JButton delete;
	public static JPanel panel_1;
	public static boolean saveTests = false;
	public static JButton btnAjouter;
	public static JButton edit;
	public static JPanel panelName;
	
	public static int n;
	public static List<String> students = new ArrayList();
	public static JLabel name;
	public static JButton previous;
	public static JButton next;
	public static JLabel num;
	private JPanel panel_6;
	public static JPanel numbers;
	private JLabel button_1;
	private JPanel back;
	public static JScrollPane scrollPane;
	private JPanel panel_7;
	public static Component course;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					App window = new App("1");
					window.frame.setVisible(true);
					System.gc();
					Thread.currentThread().setPriority((int) (Thread.MAX_PRIORITY*0.8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		/*
		 * 
		 * File file = new File("C:/Users/User/Desktop/db_script.sql");
		 * aws.downloadContent(file.getPath()); FileReader fr; fr = new
		 * FileReader(file);
		 * 
		 * 
		 * BufferedReader br = new BufferedReader(fr); Object[] lines =
		 * br.lines().toArray();
		 * 
		 * List<String> l = new ArrayList(); int j = 0; for(int i = 0; i< lines.length;
		 * i++) { if(lines[i].toString().contains("CONSTRAINT")) { j++; String s =
		 * lines[i].toString().substring(0, lines[i].toString().lastIndexOf("`"))+j+"`";
		 * l.add(s); }else{ l.add(lines[i].toString()); }}
		 * 
		 * 
		 * if(file.exists()) { file.delete(); }
		 * 
		 * file.createNewFile(); for(int i = 0; i< l.toArray().length; i++) {
		 * 
		 * PrintWriter pw = new PrintWriter(file); for(int k = 0;
		 * k<l.toArray().length;k++) { pw.println(l.get(k)); }
		 * 
		 * pw.close();}
		 */}

	/**
	 * Create the application.
	 */
	public App(String classroom_in_ay_id) {
		initialize(classroom_in_ay_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String classroom_in_ay_id) {

		loadStudents(classroom_in_ay_id);
		
		
		frame = new JFrame();/*
								 * frame.addComponentListener(new ComponentAdapter() {
								 * 
								 * @Override public void componentResized(ComponentEvent e) { Dimension
								 * screensize = Toolkit.getDefaultToolkit().getScreenSize();
								 * 
								 * for(int i = 0; i<panel_5.getComponentCount();i++) {
								 * if(frame.getWidth()<=1191) { panel_5.setLayout(new
								 * WrapLayout(WrapLayout.CENTER, 15*frame.getWidth()/2/screensize.width,
								 * 15*frame.getWidth()/2/screensize.width)); }else { panel_5.setLayout(new
								 * WrapLayout(WrapLayout.CENTER, 10, 10)); } }} });
								 */
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//frame.setMinimumSize(new Dimension(screensize.width*80/100, screensize.height*80/100));
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect(classroom_in_ay_id);
			}
		});
		panel.setBackground(new Color(40, 40, 40));
		panel.setPreferredSize(new Dimension(10, frame.getHeight()*15/100));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		btnAjouter = new JButton("");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAjouter.setBackground(new Color(0, 180, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouter.setBackground(new Color(0, 150, 150));
			}
		});
		btnAjouter.setBorder(null);
		btnAjouter.setFocusPainted(false);
		btnAjouter.setBackground(new Color(0, 150, 150));
		btnAjouter.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		btnAjouter.setFont(new Font("Arial", Font.PLAIN, 27));
		btnAjouter.setBounds(235, 11, 118, 116);
		//panel.add(btnAjouter);
		
		number = new JLabel("0");
		number.setBounds(1222, 108, 118, 19);
		panel.add(number);
		
		delete = new JButton("");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 180, 180));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				delete.setBackground(new Color(0, 150, 150));
			}}
		});
		delete.setBorder(null);
		delete.setFocusPainted(false);
		delete.setBackground(new Color(0, 150, 150));
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setBounds(385, 11, 118, 116);
	//	panel.add(delete);
		
		edit = new JButton("");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 180, 180));
			}}
			@Override
			public void mouseExited(MouseEvent e) {
				if(delete.isEnabled() && edit.isEnabled()) {
				edit.setBackground(new Color(0, 150, 150));
			}}
		});
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				createBox();

				 App.saveTests = true;
				NewCourse.create.setVisible(false);
				NewCourse.actualiser.setVisible(true);
				int j = Integer.parseInt(App.number.getText());
				String s = ((JLabel) ((Container) ((Container) App.panel_5.getComponent(j-1)).getComponent(0)).getComponent(0)).getText();
				NewCourse.name.setText(s.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			}
		});
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(0, 150, 150));
		edit.setBounds(535, 11, 118, 116);
		
		panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(300, 100));
		panel_7.setBounds(0, 0, 416, 115);
		panel.add(panel_7);
		panel_7.setLayout(null);
		//panel.add(edit);
		
		back = new JPanel();
		back.setBounds(10, 17, 124, 80);
		panel_7.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Application app = new Application(classroom_in_ay_id);
				app.frame.setVisible(true);
				App.frame.setVisible(false);
			}
		});
		
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				back.setBackground(new Color(60, 60, 60));
			}
		});
		back.setBackground(new Color(60, 60, 60));
		back.setLayout(null);
		
		button_1 = new JLabel("");
		button_1.setBounds(30, 0, 90, 80);
		back.add(button_1);
		button_1.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button_1.setBorder(null);
		button_1.setBackground(new Color(0, 128, 128));
		
		JLabel btnNewButton = new JLabel("");
		btnNewButton.setBounds(0, 10, 50, 59);
		back.add(btnNewButton);
		btnNewButton.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(panel.getBackground());
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(60, 60, 60));
		panel_9.setBounds(1030, 67, 195, 30);
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		

		JLabel lblemeTrimestre = new JLabel("3eme Trimestre");
		lblemeTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblemeTrimestre.setForeground(Color.WHITE);
		lblemeTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_9.add(lblemeTrimestre, BorderLayout.CENTER);
		lblemeTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
		
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component selectedCourse = null;
				if(Cours.selectedCourses.toArray().length>0) {
				selectedCourse = Cours.selectedCourses.get(0);
				selectedCourse.setName(Cours.selectedCourses.get(0).getName());
				}if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}

				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblemeTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				loadCourses(classroom_in_ay_id, students.get(n));
				
				if(selectedCourse!= null) {
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}
			}else{
				General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
			}}
		});
		button.setPreferredSize(new Dimension(30, 30));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(60, 60, 60));
		button.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panel_9.add(button, BorderLayout.WEST);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
				}
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}

				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblemeTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				loadCourses(classroom_in_ay_id, students.get(n));
				

				
				if(selectedCourse != null) {
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}}else{
						General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
				
			}
		});
		button_2.setPreferredSize(new Dimension(30, 30));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(60, 60, 60));
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		panel_9.add(button_2, BorderLayout.EAST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 25));
		panel_1.setPreferredSize(new Dimension(350, 10));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		

		panelName = new JPanel();
		panelName.setBackground(new Color(60, 60, 60));
		panel_1.add(panelName, BorderLayout.NORTH);
		panelName.setPreferredSize(new Dimension(10, 50));
		panelName.setLayout(new BorderLayout(0, 0));
		
		name = new JLabel("UMUHOZA Chris Koen Michael");
		name.setForeground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Roboto", Font.BOLD, 16));
		panelName.add(name, BorderLayout.NORTH);
		
		previous = new JButton("");
		previous.setFocusPainted(false);
		previous.setBorderPainted(false);
		previous.setBackground(new Color(25, 25, 25));
		previous.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panelName.add(previous, BorderLayout.WEST);
		
		panel_6 = new JPanel();
		panel_6.setBorder(null);
		panelName.add(panel_6, BorderLayout.CENTER);
		panel_6.setBackground(new Color(60, 60, 60));
		

		
		num = new JLabel("15");
		num.setForeground(Color.WHITE);
		num.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelName.getHeight() == 50) {
						panelName.setPreferredSize(new Dimension(10, 100));
						panelName.getComponent(panelName.getComponentCount()-2).setPreferredSize(new Dimension(10, 50));
					panelName.revalidate();
					panelName.repaint();
					loadnumbers(classroom_in_ay_id);
					
					}
					else{
						panelName.setPreferredSize(new Dimension(10, 50));
						panelName.getComponent(panelName.getComponentCount()-2).setPreferredSize(new Dimension(10, 0));
						panelName.revalidate();
						panelName.repaint();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(120, 120, 120));
			}

			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(60, 60, 60));
			
			}
		});
		panel_6.setLayout(new BorderLayout(0, 0));
		num.setBackground(new Color(245, 245, 245));
		panel_6.add(num);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 0));
		scrollPane_1.setBorder(null);
		panelName.add(scrollPane_1, BorderLayout.SOUTH);
		
		

		scrollPane_1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(5);
		
		numbers = new JPanel();
		numbers.setBackground(new Color(25, 25, 25));
		scrollPane_1.setViewportView(numbers);

		numbers.setLayout(new WrapLayout(WrapLayout.CENTER,3,3));
		
		next = new JButton("");
		panelName.add(next, BorderLayout.EAST);
		next.setFocusPainted(false);
		next.setBorderPainted(false);
		next.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		next.setBackground(new Color(25, 25, 25));
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;

				int opened = 0;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					
				if(LPane.tabbedPane.getSelectedIndex()==1) {
					opened = 1;
				}
				LPane.tabbedPane.setSelectedIndex(0);

				Test.deselect(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
				}
				
				if(n<students.toArray().length-1) {
					n++;
				}else{
					n = 0;
				}
				General.loadName(students.get(n));
				
				loadCourses(classroom_in_ay_id, students.get(n));

				loadnumbers(classroom_in_ay_id);
				
				if(selectedCourse != null) {
					
					LPane.tabbedPane.setSelectedIndex(opened);
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					
				for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
					if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
						Cours.selectedCourses.add(App.panel_5.getComponent(i));
				}}
				
				for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
					if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
						Cours.setSelected(App.panel_5.getComponent(j));
					}}}else{
						General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
				App.panel_5.revalidate();
				App.panel_5.repaint();
			}
		});
		
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component selectedCourse = null;

				int opened = 0;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					
				if(LPane.tabbedPane.getSelectedIndex()==1) {
					opened = 1;
				}
				LPane.tabbedPane.setSelectedIndex(0);

				Test.deselect(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
				}
				
				//loadStudents(classroom_id, ay_id);
				
				if(n>0) {
					n--;
				}else{
				n = students.toArray().length-1;
				}
				General.loadName(students.get(n));

				loadCourses(classroom_in_ay_id, students.get(n));

				loadnumbers(classroom_in_ay_id);
				if(selectedCourse != null) {
					LPane.tabbedPane.setSelectedIndex(opened);
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					
					for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
						if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
							Cours.selectedCourses.add(App.panel_5.getComponent(i));
					}}
					
					for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
						if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
							Cours.setSelected(App.panel_5.getComponent(j));
						}}}else{
							General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
						}
				
				
				App.panel_5.revalidate();
				App.panel_5.repaint();

			}
		});
		
		
		
		
		
		General g = new General(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
		JPanel lp = new JPanel();
		panel_1.add(lp, BorderLayout.CENTER);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setPreferredSize(new Dimension(350, 490));
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setMinimumSize(new Dimension(100, 100));
		
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_3.add(panel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(40, 40, 40));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deselect(classroom_in_ay_id);
			}
		});
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(null);
		
		panel_5.setLayout(new WrapLayout(WrapLayout.LEFT, 12, 12));
		

		/*
		 * frame.addComponentListener(new ComponentAdapter() {
		 * 
		 * @Override public void componentResized(ComponentEvent e) { Dimension
		 * screensize = Toolkit.getDefaultToolkit().getScreenSize();
		 * 
		 * for(int i = 0; i<panel_5.getComponentCount();i++) {
		 * if(frame.getWidth()<=1191) { panel_5.setLayout(new
		 * WrapLayout(WrapLayout.CENTER, 15*frame.getWidth()/2/screensize.width,
		 * 15*frame.getWidth()/2/screensize.width)); }else { panel_5.setLayout(new
		 * WrapLayout(WrapLayout.CENTER, 10, 10)); } }} });
		 */
		
		deselect(classroom_in_ay_id);

		
		loadCourses(classroom_in_ay_id, students.get(n));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deselect(classroom_in_ay_id);
				createBox();
				NewCourse.create.setVisible(true);
				NewCourse.actualiser.setVisible(false);
				
		        SwingUtilities.invokeLater(() -> {
		            JScrollBar bar = scrollPane.getVerticalScrollBar();
		            bar.setValue(bar.getMaximum());
		    });
		        
			}
		});
	
		
		

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count--;
				String i = number.getText().replaceAll("[^0-9]", "");
				//App.delete();
				panel_5.revalidate();
				 panel_5.repaint();
				panel_5.remove(Integer.valueOf(i)-1);
				number.setText(String.valueOf(count));
				  panel_5.revalidate();
				     panel_5.repaint();
						deselect(classroom_in_ay_id);

			}
		});
	

		//Exam.loadExams();
	}
	
	public static void loadStudents(String classroom_in_ay_id) { //number selected
		students.clear();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
		
		for(int i = 0;i<lines.length;i++) {
		students.add(lines[i].toString());
		}
	}
	

	public static void loadnumbers(String classroom_in_ay_id) { //number selected
		numbers.removeAll();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
					
		for(int i = 0;i<lines.length;i++) {
		
		JPanel button = new JPanel();
		button.setPreferredSize(new Dimension(30, 25));
		button.setBackground(new Color(80, 80, 80));
		button.setName(String.valueOf(i));
		JLabel num = new JLabel();
		num.setText(getStudentNumber(lines[i].toString()));
		num.setBounds(button.getBounds());
		button.add(num);
		
		num.setVerticalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		num.setForeground(Color.white);
		numbers.add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				

				Component selectedCourse = null;

				int opened = 0;
				if(Cours.selectedCourses.toArray().length>0) {
					selectedCourse = Cours.selectedCourses.get(0);
					selectedCourse.setName(Cours.selectedCourses.get(0).getName());
					
				if(LPane.tabbedPane.getSelectedIndex()==1) {
					opened = 1;
				}
				LPane.tabbedPane.setSelectedIndex(0);

				Test.deselect(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
				}
				

				n= Integer.parseInt(button.getName());
				General.loadName(students.get(n));

				loadCourses(classroom_in_ay_id, students.get(n));
				loadnumbers(classroom_in_ay_id);
				if(selectedCourse != null) {
					LPane.tabbedPane.setSelectedIndex(opened);
					LPane.panel_3.removeAll();
					LPane.loadAllTests(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					LPane.loadAllExams(selectedCourse.getName(), students.get(n), classroom_in_ay_id);
					
					for(int i = 0 ; i< App.panel_5.getComponentCount(); i++) {
						if(App.panel_5.getComponent(i).getName().equals(selectedCourse.getName())) {
							Cours.selectedCourses.add(App.panel_5.getComponent(i));
					}}
					
					for(int j = 0; j< App.panel_5.getComponentCount(); j++) {
						if(App.panel_5.getComponent(j).getName().equals(Cours.selectedCourses.get(0).getName())) {
							Cours.setSelected(App.panel_5.getComponent(j));
						}}}else{
							General.totalScore(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
						}

				num.setForeground(Color.white);
			}
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(120, 120, 120));
				num.setForeground(Color.white);
			}public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(80, 80, 80));
				num.setForeground(Color.white);
				numbers.getComponent(n).setBackground(new Color(20, 148, 198));
				((Container) numbers.getComponent(n)).getComponent(0).setForeground(Color.white);
			}
		});
		}

		numbers.getComponent(n).setBackground(new Color(20, 148, 198));
		((Container) numbers.getComponent(n)).getComponent(0).setForeground(Color.white);
		
		
	}
	
	public static void createBox() {
		
		NewCourse nc = new NewCourse();
		nc.setVisible(true);
        
	}
	public static void deselect(String classroom_in_ay_id) {
		
		Cours.isSelected = false;
		
		App.delete.setEnabled(false);
		App.edit.setEnabled(false);
		App.delete.setBackground(App.panel.getBackground());
		App.edit.setBackground(App.panel.getBackground());
		
		General g = new General(students.get(n), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
		panel_1.remove(1);
		panel_1.add(g);
		Cours.selectedCourses.clear();
		for(int i = 0; i<panel_5.getComponentCount(); i++) {
			((Container) panel_5.getComponent(i)).getComponent(1).setBackground(new Color(60, 60, 60));
			((JComponent) panel_5.getComponent(i)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
			((Container) ((Container) panel_5.getComponent(i)).getComponent(0)).getComponent(0).setForeground(Color.black);
			
			if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(161, 0, 0))) {
				App.panel_5.getComponent(i).setBackground(new Color(255,221,221));
			((Container) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(255,221,221));
			}
			else if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(31, 154, 97))) {
			App.panel_5.getComponent(i).setBackground(new Color(201,255,226));
			((Container) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(201,255,226));
}else if(((JComponent) App.panel_5.getComponent(i)).getComponent(0).getBackground().equals(new Color(120, 120, 120))) {
	App.panel_5.getComponent(i).setBackground(new Color(200, 200, 200));
	((JComponent) App.panel_5.getComponent(i)).getComponent(0).setBackground(new Color(200, 200, 200));
}
		}
		
		panel_1.revalidate();
		panel_1.repaint();
		panel_5.revalidate();
		panel_5.repaint();
		
		

}
	
	public static String getStudentNumber(String student_in_classroom_id) {
		 String number = null;
		 
		 try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * FROM students_in_classrooms "
						+ "WHERE sic_id = '"+student_in_classroom_id+"'");
				while(rs.next())
				{
					number = rs.getString("number");
		
		}} catch (SQLException e) {
			e.printStackTrace();
			
			}
		
	return number;
	}
	
	public static void loadCourses(String classroom_in_ay_id, String student_id) {

		App.panel_5.removeAll();

				Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
				
				for(int i = 0; i<lines.length;i++) {
				Cours c = new Cours(lines[i].toString(), classroom_in_ay_id, student_id);
				c.setName(lines[i].toString());
				App.panel_5.add(c);
				//number.setText(String.valueOf(panel_5.getComponentCount()));
				Cours.loaddata(c, lines[i].toString(), classroom_in_ay_id, student_id);
				
				App.panel_5.revalidate();
				App.panel_5.repaint();
				}
		}
}
