package Application;

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
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ScheduleStructure extends JFrame {

	public static JPanel contentPane;
	private JButton button;
	public static boolean isEmpty = false;
	public static Color backColor = new Color(240, 240, 240);
	public static Color foreColor = new Color(0, 0, 0);
	public static boolean isBackground;
	public static boolean backgroundisSelected = false;
	public static boolean foregroundisSelected = false;
	public static JButton create;
	public static JPanel hours;
	public static JScrollPane scrollPane;
	public static JPanel panel;
	public static JPanel panel1;
	public static int selectedSession = 0;
	public static JButton delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					ScheduleStructure frame = new ScheduleStructure("1", "8");
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
	public ScheduleStructure(String classroom_in_ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 690, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	Login.setAsPopup(this);
	
	create = new JButton("Creer");
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String s = "";
			for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
				int sessions = 0;
				for(int k = 0; k< ((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1; k++) {
					if(!((JPanel) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(k)).getBackground().equals(((JPanel) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(k)).getParent().getParent().getBackground())) {
						sessions++;
					}
				}
				if(s.equals("")) {
					s = j+":"+sessions;
				}else {
				s = s+"//"+j+":"+sessions;	
				}}
			System.out.println(s);
			
			String s1 = "";

			for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
				if(!((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
					if(s1.equals("")) {
						s1 = ((JLabel) ScheduleStructure.hours.getComponent(j)).getText();
					}else {
					s1 = s1+"//"+((JLabel) ScheduleStructure.hours.getComponent(j)).getText();	
					}}
			}
			System.out.println(s1);
			
			/*
			 * File file = new
			 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
			 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+
			 * ClassName+"/ScheduleStructure/ScheduleStructure structure.txt");
			 * 
			 * if(file.exists()) { file.delete(); }
			 * 
			 * try { file.createNewFile(); PrintWriter pw = new PrintWriter(file);
			 * pw.println(s1); pw.println(s);
			 * 
			 * pw.close();
			 * 
			 * } catch (IOException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace();
			 * 
			 * }
			 */
			setVisible(true);
		}
	});
	
	JLabel title = new JLabel("Structure de l'horaire: "+Home.getClassName(classroom_in_ay_id));
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Roboto", Font.BOLD, 16));
	title.setBounds(10, 0, 654, 33);
	contentPane.add(title);
	
	JLabel lbleeEconomique = new JLabel("<html><div style='text-align: center;'>La structure de l'horaire de la classe est utilisee par le logiciel afin de pouvoir aider les professeurs lors de la creation des horaires des enseignants.</div></html>");
	lbleeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
	lbleeEconomique.setForeground(new Color(211, 211, 211));
	lbleeEconomique.setFont(new Font("Roboto", Font.PLAIN, 14));
	lbleeEconomique.setBounds(10, 34, 654, 50);
	contentPane.add(lbleeEconomique);
	create.setFont(new Font("Roboto", Font.BOLD, 14));
	create.setBounds(405, 519, 120, 31);
	contentPane.add(create);
	
	button = new JButton("Annuler");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Roboto", Font.BOLD, 14));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(535, 519, 129, 31);
	contentPane.add(button);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 674, 12);
	contentPane.add(separator);
	
	scrollPane = new JScrollPane();
	scrollPane.setPreferredSize(new Dimension(0, 0));
	scrollPane.setBounds(12, 161, 652, 345);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			delete.setEnabled(false);


			if(hours.getComponentCount()==1) {
				selectedSession = 0;
			}else {
			selectedSession = hours.getComponentCount()-2;
			}
			for(int j = 0; j<hours.getComponentCount()-1; j++) {
				if(!((JLabel) hours.getComponent(j)).getText().equals("Pause")) {
			((JLabel) hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
				}else {
					((JLabel) hours.getComponent(j)).setBorder(null);
				}
			}
		}
	});
	panel.addContainerListener(new ContainerAdapter() {
		@Override
		public void componentAdded(ContainerEvent e) {
			pause();
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	panel.setPreferredSize(new Dimension(0, 0));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	hours = new JPanel();
	hours.setBorder(null);
	hours.setBackground(panel.getBackground());
	hours.setPreferredSize(new Dimension(150, 345));
	panel.add(hours);
	hours.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton plus = new JButton("+");
	plus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(ScheduleStructure.hours.getComponentCount()==1) {
			NewSession ns = new NewSession("7", "0", "50");
			ns.setVisible(true);
			}else{
				if(!((JLabel) ScheduleStructure.hours.getComponent(selectedSession)).getText().equals("Pause")) {
				String t = ((JLabel) ScheduleStructure.hours.getComponent(selectedSession)).getText();
				List l = Arrays.asList(t.split(" - "));
				
				 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				 Date d = null;
				 Date d1 = null;
				try {
					d = df.parse(l.get(0).toString());
					d1 = df.parse(l.get(1).toString());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
						long diffMs = d1.getTime() - d.getTime();
						long diffSec = diffMs / 1000;
						long min = diffSec / 60;
						
						List l1 = Arrays.asList(l.get(1).toString().split(":"));
				
				NewSession ns = new NewSession(l1.get(0).toString(), l1.get(1).toString(), String.valueOf(min));
				ns.setVisible(true);
			}}
		}
	});
	plus.setFocusPainted(false);
	plus.setForeground(new Color(255, 255, 255));
	plus.setBackground(panel.getBackground());
	plus.setBorderPainted(false);
	plus.setFont(new Font("Roboto", Font.PLAIN, 35));
	plus.setPreferredSize(new Dimension(150, 30));
	hours.add(plus);
	
	JPanel lundi = new JPanel();
	lundi.setBorder(null);
	lundi.setBackground(panel.getBackground());
	lundi.setPreferredSize(new Dimension(83, 345));
	panel.add(lundi);
	lundi.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton button_1 = new JButton("+");
	button_1.setEnabled(false);
	button_1.setPreferredSize(new Dimension(83, 30));
	button_1.setForeground(Color.WHITE);
	button_1.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_1.setFocusPainted(false);
	button_1.setBorderPainted(false);
	button_1.setBackground(new Color(40, 40, 40));
	lundi.add(button_1);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBorder(null);
	panel_3.setBackground(panel.getBackground());
	panel_3.setPreferredSize(new Dimension(83, 345));
	panel.add(panel_3);
	panel_3.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton button_2 = new JButton("+");
	button_2.setEnabled(false);
	button_2.setPreferredSize(new Dimension(83, 30));
	button_2.setForeground(Color.WHITE);
	button_2.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_2.setFocusPainted(false);
	button_2.setBorderPainted(false);
	button_2.setBackground(new Color(40, 40, 40));
	panel_3.add(button_2);
	
	JPanel panel_4 = new JPanel();
	panel_4.setBorder(null);
	panel_4.setBackground(panel.getBackground());
	panel_4.setPreferredSize(new Dimension(83, 345));
	panel.add(panel_4);
	panel_4.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton button_3 = new JButton("+");
	button_3.setEnabled(false);
	button_3.setPreferredSize(new Dimension(83, 30));
	button_3.setForeground(Color.WHITE);
	button_3.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_3.setFocusPainted(false);
	button_3.setBorderPainted(false);
	button_3.setBackground(new Color(40, 40, 40));
	panel_4.add(button_3);
	
	JPanel panel_5 = new JPanel();
	panel_5.setBorder(null);
	panel_5.setBackground(panel.getBackground());
	panel_5.setPreferredSize(new Dimension(83, 345));
	panel.add(panel_5);
	panel_5.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton button_4 = new JButton("+");
	button_4.setEnabled(false);
	button_4.setPreferredSize(new Dimension(83, 30));
	button_4.setForeground(Color.WHITE);
	button_4.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_4.setFocusPainted(false);
	button_4.setBorderPainted(false);
	button_4.setBackground(new Color(40, 40, 40));
	panel_5.add(button_4);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBorder(null);
	panel_6.setBackground(panel.getBackground());
	panel_6.setPreferredSize(new Dimension(83, 345));
	panel.add(panel_6);
	panel_6.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	JButton button_5 = new JButton("+");
	button_5.setEnabled(false);
	button_5.setPreferredSize(new Dimension(83, 30));
	button_5.setForeground(Color.WHITE);
	button_5.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_5.setFocusPainted(false);
	button_5.setBorderPainted(false);
	button_5.setBackground(new Color(40, 40, 40));
	panel_6.add(button_5);
	
	JPanel panel_2 = new JPanel();
	panel_2.setPreferredSize(new Dimension(83, 345));
	panel_2.setBorder(null);
	panel_2.setBackground(new Color(40, 40, 40));
	panel.add(panel_2);
	panel_2.setLayout(new WrapLayout(0, 0, 0));
	
	JButton button_11 = new JButton("+");
	button_11.setPreferredSize(new Dimension(83, 30));
	button_11.setForeground(Color.WHITE);
	button_11.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_11.setFocusPainted(false);
	button_11.setEnabled(false);
	button_11.setBorderPainted(false);
	button_11.setBackground(new Color(40, 40, 40));
	panel_2.add(button_11);
	
	JLabel lblNewLabel_1 = new JLabel("Lundi");
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(160, 136, 84, 14);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblMardi = new JLabel("Mardi");
	lblMardi.setHorizontalAlignment(SwingConstants.CENTER);
	lblMardi.setForeground(Color.WHITE);
	lblMardi.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblMardi.setBounds(246, 136, 84, 14);
	contentPane.add(lblMardi);
	
	JLabel lblMercredi = new JLabel("Mercredi");
	lblMercredi.setHorizontalAlignment(SwingConstants.CENTER);
	lblMercredi.setForeground(Color.WHITE);
	lblMercredi.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblMercredi.setBounds(327, 136, 84, 14);
	contentPane.add(lblMercredi);
	
	JLabel lblJeudi = new JLabel("Jeudi");
	lblJeudi.setHorizontalAlignment(SwingConstants.CENTER);
	lblJeudi.setForeground(Color.WHITE);
	lblJeudi.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblJeudi.setBounds(411, 136, 84, 14);
	contentPane.add(lblJeudi);
	
	JLabel lblVendredi = new JLabel("Vendredi");
	lblVendredi.setHorizontalAlignment(SwingConstants.CENTER);
	lblVendredi.setForeground(Color.WHITE);
	lblVendredi.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblVendredi.setBounds(493, 136, 84, 14);
	contentPane.add(lblVendredi);
	
	panel1 = new JPanel();
	panel1.setBackground(new Color(40, 40, 40));
	panel1.setBounds(160, 95, 502, 30);
	contentPane.add(panel1);
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	
	JButton button_6 = new JButton("-");
	button_6.setPreferredSize(new Dimension(83, 30));
	button_6.setForeground(Color.WHITE);
	button_6.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_6.setFocusPainted(false);
	button_6.setEnabled(false);
	button_6.setBorderPainted(false);
	button_6.setBackground(new Color(40, 40, 40));
	panel1.add(button_6);
	
	JButton button_7 = new JButton("-");
	button_7.setPreferredSize(new Dimension(83, 30));
	button_7.setForeground(Color.WHITE);
	button_7.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_7.setFocusPainted(false);
	button_7.setEnabled(false);
	button_7.setBorderPainted(false);
	button_7.setBackground(new Color(40, 40, 40));
	panel1.add(button_7);
	
	JButton button_8 = new JButton("-");
	button_8.setPreferredSize(new Dimension(83, 30));
	button_8.setForeground(Color.WHITE);
	button_8.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_8.setFocusPainted(false);
	button_8.setEnabled(false);
	button_8.setBorderPainted(false);
	button_8.setBackground(new Color(40, 40, 40));
	panel1.add(button_8);
	
	JButton button_9 = new JButton("-");
	button_9.setPreferredSize(new Dimension(83, 30));
	button_9.setForeground(Color.WHITE);
	button_9.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_9.setFocusPainted(false);
	button_9.setEnabled(false);
	button_9.setBorderPainted(false);
	button_9.setBackground(new Color(40, 40, 40));
	panel1.add(button_9);
	
	JButton button_10 = new JButton("-");
	button_10.setPreferredSize(new Dimension(83, 30));
	button_10.setForeground(Color.WHITE);
	button_10.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_10.setFocusPainted(false);
	button_10.setEnabled(false);
	button_10.setBorderPainted(false);
	button_10.setBackground(new Color(40, 40, 40));
	panel1.add(button_10);
	
	JButton button_12 = new JButton("-");
	button_12.setPreferredSize(new Dimension(83, 30));
	button_12.setForeground(Color.WHITE);
	button_12.setFont(new Font("Roboto", Font.PLAIN, 35));
	button_12.setFocusPainted(false);
	button_12.setEnabled(false);
	button_12.setBorderPainted(false);
	button_12.setBackground(new Color(40, 40, 40));
	panel1.add(button_12);
	
	delete = new JButton("Supprimer");
	delete.setEnabled(false);
	delete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				for(int j = 0; j<ScheduleStructure.panel.getComponentCount(); j++) {
					if(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1>selectedSession) {
					((Container) ScheduleStructure.panel.getComponent(j)).remove(selectedSession);
					((Container) ScheduleStructure.panel.getComponent(j)).revalidate();
						((Container) ScheduleStructure.panel.getComponent(j)).repaint();
				}}
				pause();
				NewSession.refresh();
				if(ScheduleStructure.hours.getComponentCount()>1) {
					ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;
					}else{
						ScheduleStructure.selectedSession = 0;
						}
				}
	});
	delete.setBorder(new LineBorder(Color.WHITE));
	delete.setForeground(Color.WHITE);
	delete.setBackground(Color.DARK_GRAY);
	delete.setFont(new Font("Roboto", Font.BOLD, 14));
	delete.setFocusPainted(false);
	delete.setBounds(10, 127, 129, 23);
	contentPane.add(delete);
	
	JButton btnImporter = new JButton("Importer");
	btnImporter.setForeground(Color.WHITE);
	btnImporter.setFont(new Font("Roboto", Font.BOLD, 14));
	btnImporter.setFocusPainted(false);
	btnImporter.setBorderPainted(false);
	btnImporter.setBackground(Color.GRAY);
	btnImporter.setBounds(10, 525, 108, 23);
	contentPane.add(btnImporter);
	
	JLabel lblSamedi = new JLabel("Samedi");
	lblSamedi.setHorizontalAlignment(SwingConstants.CENTER);
	lblSamedi.setForeground(Color.WHITE);
	lblSamedi.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblSamedi.setBounds(580, 136, 84, 14);
	contentPane.add(lblSamedi);

	setLocationRelativeTo(null);
	
	load(classroom_in_ay_id);
	
	for(int i = 1; i<ScheduleStructure.panel.getComponentCount(); i++) {
		int k = i;
			((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(i)).getComponent(((Container) ScheduleStructure.panel.getComponent(i)).getComponentCount()-1))
			.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(80, 80, 80));
				panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
				panel_1.setPreferredSize(new Dimension(83, 30));
				((Container) ScheduleStructure.panel.getComponent(k)).add(panel_1, 0);
				for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
					if(((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
					if(((Container) ScheduleStructure.panel.getComponent(k)).getComponentCount()-1==j) {
						JPanel panel_11 = new JPanel();
						panel_11.setBackground(new Color(80, 80, 80));
						panel_11.setBorder(new LineBorder(new Color(255, 255, 255), 2));
						panel_11.setPreferredSize(new Dimension(83, 30));
						((Container) ScheduleStructure.panel.getComponent(k)).add(panel_11, 0);
					}
					}
					}
				
				if(hours.getComponentCount()<=((Container) ScheduleStructure.panel.getComponent(k)).getComponentCount()) {
					((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(k)).getComponent(((Container) ScheduleStructure.panel.getComponent(k)).getComponentCount()-1))
					.setEnabled(false);
				}


				pause();
				delete.setEnabled(false);


				if(ScheduleStructure.hours.getComponentCount()==1) {
					ScheduleStructure.selectedSession = 0;
				}else {
				ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;
				}
				for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
					if(!((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
				((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
					}else {
						((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(null);
					}
				}
				
				panel1.getComponent(k-1).setEnabled(true);
				panel1.getComponent(k-1).revalidate();
				panel1.getComponent(k-1).repaint();
				((Container) ScheduleStructure.panel.getComponent(k)).revalidate();
				((Container) ScheduleStructure.panel.getComponent(k)).repaint();
			

			}
		});
	}
	
	
	
	for(int i = 0; i<ScheduleStructure.panel1.getComponentCount(); i++) {
		int k = i;
			((AbstractButton) ScheduleStructure.panel1.getComponent(i)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				((Container) ScheduleStructure.panel.getComponent(k+1)).remove(0);
				
				if(((Container) ScheduleStructure.panel.getComponent(k+1)).getComponentCount()==1) {
				panel1.getComponent(k).setEnabled(false);
				}
				if(((Container) ((Container) ScheduleStructure.panel.getComponent(k+1)).getComponent(((Container) ScheduleStructure.panel.getComponent(k+1)).getComponentCount()-1)) instanceof JButton) {
					((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(k+1)).getComponent(((Container) ScheduleStructure.panel.getComponent(k+1)).getComponentCount()-1))
					.setEnabled(true);
				}


				pause();
					delete.setEnabled(false);


					if(ScheduleStructure.hours.getComponentCount()==1) {
						ScheduleStructure.selectedSession = 0;
					}else {
					ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;
					}
					for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
						if(!((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
					((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
						}else {
							((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(null);
						}
					}
				
					
				panel1.getComponent(k).revalidate();
				panel1.getComponent(k).repaint();
				
				((Container) ScheduleStructure.panel.getComponent(k+1)).revalidate();
				((Container) ScheduleStructure.panel.getComponent(k+1)).repaint();
				

			}
		});
	}
	}
	
	public static void pause() {
		
		if(ScheduleStructure.hours.getComponentCount()>2) {
			for(int i = 0; i<ScheduleStructure.hours.getComponentCount()-1; i++) {
			if(((JLabel) ScheduleStructure.hours.getComponent(i)).getText().equals("Pause")) {
				ScheduleStructure.hours.remove(i);
				
				for(int j = 1; j< panel.getComponentCount(); j++) {
					if(((JPanel)panel.getComponent(j)).getComponentCount()>=i+1) {
					((JPanel)panel.getComponent(j)).remove(i-1);
				}}
				
				ScheduleStructure.hours.revalidate();
				ScheduleStructure.hours.repaint();
			};
			
			}
			
			for(int i = 0; i<ScheduleStructure.hours.getComponentCount()-1; i++) {
				
				if(((Container) ScheduleStructure.hours.getComponent(i+1)) instanceof JLabel && !((JLabel) ScheduleStructure.hours.getComponent(i)).getText().equals("Pause") 
						&& !((JLabel) ScheduleStructure.hours.getComponent(i+1)).getText().equals("Pause") ) {
				List list1 = Arrays.asList(((JLabel) ScheduleStructure.hours.getComponent(i)).getText().split(" - "));
				List list2 = Arrays.asList(((JLabel) ScheduleStructure.hours.getComponent(i+1)).getText().split(" - "));
				
				 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				 Date d = null;
				 Date d1 = null;
				try {
					d = df.parse(list1.get(1).toString());
					d1 = df.parse(list2.get(0).toString());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
						long diffMs = d1.getTime() - d.getTime();
						long diffSec = diffMs / 1000;
						long min = diffSec / 60;

						if(min>0) {
							
								if(((Container) ScheduleStructure.panel.getComponent(0)).getComponentCount()>=i) {
								JLabel lblNewLabel_2 = new JLabel("Pause");
								lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
								lblNewLabel_2.setForeground(new Color(255, 255, 255));
								//lblNewLabel_2.setOpaque(true);
								lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setPreferredSize(new Dimension(150, 30));

								((Container) ScheduleStructure.panel.getComponent(0)).add(lblNewLabel_2, i+1);
								((Container) ScheduleStructure.panel.getComponent(0)).revalidate();
								((Container) ScheduleStructure.panel.getComponent(0)).repaint();
								}
	}}}}
		
		for(int i = 0; i<ScheduleStructure.hours.getComponentCount()-1; i++) {
			for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
					
				if(ScheduleStructure.hours.getComponent(i) instanceof JLabel) {
					if(((JLabel) ScheduleStructure.hours.getComponent(i)).getText().equals("Pause")) {
					if(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1>=i) {
						JPanel panel_1 = new JPanel();
					panel_1.setBorder(null);
					panel_1.setPreferredSize(new Dimension(83, 30));
					((Container) ScheduleStructure.panel.getComponent(j)).add(panel_1, i);
					panel_1.setBackground(panel_1.getParent().getParent().getBackground());
				}
			}}}
			ScheduleStructure.panel.revalidate();
			ScheduleStructure.panel.repaint();
		}

		
		for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
			for(int k = 0; k<((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1; k++) {
				if(hours.getComponentCount()< ((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()) {
				((Container) ScheduleStructure.panel.getComponent(j)).remove(0);
				}
			}}

		
		for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
			for(int k = 0; k<((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1; k++) {

					if(((JComponent) ScheduleStructure.hours.getComponent(k)) instanceof JLabel) {
					if(!((JLabel) ScheduleStructure.hours.getComponent(k)).getText().equals("Pause")) {
					((JPanel) ScheduleStructure.panel.getComponent(j)).getComponent(k).setBackground(new Color(80, 80, 80));
					((JComponent) ((JComponent) ScheduleStructure.panel.getComponent(j)).getComponent(k)).setBorder(new LineBorder(new Color(255, 255, 255),2));
					}}
			}
			}
		for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
			if(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()>0) {
			if(hours.getComponentCount()<=((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()) {
				if(((Container) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1)) instanceof JButton) {
				((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1))
				.setEnabled(false);
				}
			}else {
				if(((Container) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1)) instanceof JButton) {
				((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(j)).getComponent(((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()-1))
				.setEnabled(true);
			}}}}
		saveIsOn();
		refresh();
		panel.revalidate();
		panel.repaint();
		
		
		
	}
	
	public static void load(String classroom_id) {
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from schedule_class "
					+ "WHERE cia_id = '"+classroom_id+"' ORDER BY start_time ASC");
			while(rs.next())
			{
			JLabel lblNewLabel_2 = new JLabel((rs.getString("start_time").substring(0, 5)+" - "+rs.getString("end_time").substring(0, 5)));
			lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setPreferredSize(new Dimension(150, 30));
			
			ScheduleStructure.hours.add(lblNewLabel_2, ScheduleStructure.hours.getComponentCount()-1);
				
			
			ScheduleStructure.hours.revalidate();
			ScheduleStructure.hours.repaint();

			lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
			
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(80, 80, 80));
				panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
				panel_1.setPreferredSize(new Dimension(83, 30));
				((JPanel)ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week"))))
			.add(panel_1, ((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponentCount()-1);
				
				((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponent(((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponentCount()-1))
				.setEnabled(true);
				if(hours.getComponentCount()<=((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponentCount()) {
					((AbstractButton) ((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponent(((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).getComponentCount()-1))
					.setEnabled(false);
				}


				delete.setEnabled(false);

				if(ScheduleStructure.hours.getComponentCount()==1) {
					ScheduleStructure.selectedSession = 0;
				}else {
				ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;
				}
				for(int j1 = 0; j1<ScheduleStructure.hours.getComponentCount()-1; j1++) {
					if((ScheduleStructure.hours.getComponent(j1)) instanceof JLabel) {
					if(!((JLabel) ScheduleStructure.hours.getComponent(j1)).getText().equals("Pause")) {
				((JLabel) ScheduleStructure.hours.getComponent(j1)).setBorder(new LineBorder(new Color(255, 255, 255)));
					}else {
						((JLabel) ScheduleStructure.hours.getComponent(j1)).setBorder(null);
					}
				}}
				
				panel1.getComponent(Integer.parseInt(rs.getString("day_of_the_week"))-1).setEnabled(true);
				panel1.getComponent(Integer.parseInt(rs.getString("day_of_the_week"))-1).revalidate();
				panel1.getComponent(Integer.parseInt(rs.getString("day_of_the_week"))-1).repaint();
				((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).revalidate();
				((Container) ScheduleStructure.panel.getComponent(Integer.parseInt(rs.getString("day_of_the_week")))).repaint();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;

			ScheduleStructure.delete.setEnabled(false);
			
			for(int i = 0; i<ScheduleStructure.hours.getComponentCount()-1; i++) {
				int k = i;
					(ScheduleStructure.hours.getComponent(i)).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							ScheduleStructure.hours.revalidate();;
							ScheduleStructure.hours.repaint();
							
							ScheduleStructure.selectedSession = k;
							for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
								if(!((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
							((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
								}else {
									((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(null);
								}
							}
							if(!((JLabel) ScheduleStructure.hours.getComponent(k)).getText().equals("Pause")) {
								ScheduleStructure.delete.setEnabled(true);
								
							}else {

								ScheduleStructure.delete.setEnabled(false);
							}

							((JLabel) ScheduleStructure.hours.getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198),4));
							
						if(e.getClickCount()==2) {
							if(!((JLabel) ScheduleStructure.hours.getComponent(k)).getText().equals("Pause")) {
							String t = ((JLabel) ScheduleStructure.hours.getComponent(k)).getText();
							List l = Arrays.asList(t.split(" - "));
							
							 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
							 Date d = null;
							 Date d1 = null;
							try {
								d = df.parse(l.get(0).toString());
								d1 = df.parse(l.get(1).toString());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
									long diffMs = d1.getTime() - d.getTime();
									long diffSec = diffMs / 1000;
									long min = diffSec / 60;
									
									List l1 = Arrays.asList(l.get(0).toString().split(":"));
							
							NewSession ns = new NewSession(l1.get(0).toString(), l1.get(1).toString(), String.valueOf(min));
							ns.setVisible(true);
							
							ns.create.setVisible(false);
						}}
					}
				});
			}
			pause();
	}
	
	public static void refresh() {

		List<String> components = new ArrayList<String>();
		for(int i = 0; i< ScheduleStructure.hours.getComponentCount(); i++) {
			if(ScheduleStructure.hours.getComponent(i) instanceof JLabel) {
			components.add(((JLabel) ScheduleStructure.hours.getComponent(i)).getText());
		}}
		
		System.out.println(components.toArray().length);
		for(int i = 0; i< components.toArray().length; i++) {
			ScheduleStructure.hours.remove(i);
		JLabel lblNewLabel_2 = new JLabel(components.get(i));
		lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		if(components.get(i).equals("Pause")) {

			lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
			lblNewLabel_2.setBorder(null);
		}
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setPreferredSize(new Dimension(150, 30));
		
		ScheduleStructure.hours.add(lblNewLabel_2, i);
			
		
		ScheduleStructure.hours.revalidate();
		ScheduleStructure.hours.repaint();

		lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
		
		}
		ScheduleStructure.selectedSession = ScheduleStructure.hours.getComponentCount()-2;

		
		for(int i = 0; i<ScheduleStructure.hours.getComponentCount()-1; i++) {
			int k = i;
				((JLabel) ScheduleStructure.hours.getComponent(i)).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ScheduleStructure.hours.revalidate();;
						ScheduleStructure.hours.repaint();
						
						ScheduleStructure.selectedSession = k;
						for(int j = 0; j<ScheduleStructure.hours.getComponentCount()-1; j++) {
							if(!((JLabel) ScheduleStructure.hours.getComponent(j)).getText().equals("Pause")) {
						((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
							}else {
								((JLabel) ScheduleStructure.hours.getComponent(j)).setBorder(null);
							}
						}
						if(!((JLabel) ScheduleStructure.hours.getComponent(k)).getText().equals("Pause")) {
							ScheduleStructure.delete.setEnabled(true);
							
						}else {

							ScheduleStructure.delete.setEnabled(false);
						}

						((JLabel) ScheduleStructure.hours.getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198),4));
						
					if(e.getClickCount()==2) {
						if(!((JLabel) ScheduleStructure.hours.getComponent(k)).getText().equals("Pause")) {
						String t = ((JLabel) ScheduleStructure.hours.getComponent(k)).getText();
						List l = Arrays.asList(t.split(" - "));
						
						 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
						 Date d = null;
						 Date d1 = null;
						try {
							d = df.parse(l.get(0).toString());
							d1 = df.parse(l.get(1).toString());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
								long diffMs = d1.getTime() - d.getTime();
								long diffSec = diffMs / 1000;
								long min = diffSec / 60;
								
								List l1 = Arrays.asList(l.get(0).toString().split(":"));
						
						NewSession ns = new NewSession(l1.get(0).toString(), l1.get(1).toString(), String.valueOf(min));
						ns.setVisible(true);

						ns.create.setVisible(false);
					}}
				}
			});
		}
	
	}
	
	
	public static void saveIsOn() {
		boolean saveOn = false;
			for(int j = 1; j<ScheduleStructure.panel.getComponentCount(); j++) {
					if(ScheduleStructure.hours.getComponentCount()==((Container) ScheduleStructure.panel.getComponent(j)).getComponentCount()&& ScheduleStructure.hours.getComponentCount()>1) {
						saveOn = true;
				}}
			
			if(saveOn) {
				create.setEnabled(true);
			}else {

				create.setEnabled(false);
			}
				}
}