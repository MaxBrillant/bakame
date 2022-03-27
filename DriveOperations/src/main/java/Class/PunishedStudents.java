package Class;

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
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
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

import Application.EducationFrame;
import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import Class.NewCourse;
import CloudOperations.aws;
import Publishing.getInternetDateAndTime;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PunishedStudents extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton btnFermer;
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	public static JPanel panel;
	public static int selectedClass;
	//public static boolean isSelectable =false;
	private JLabel text;
	private JLabel lblNewLabel_2;
	public static JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PunishedStudents frame = new PunishedStudents();
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
	public PunishedStudents(String punishmentId, String date) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 550, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	contentPane.add(actualiser);
	
	btnFermer = new JButton("Fermer");
	btnFermer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnFermer.setForeground(Color.WHITE);
	btnFermer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnFermer.setFocusPainted(false);
	btnFermer.setBorderPainted(false);
	btnFermer.setBackground(new Color(171, 0, 0));
	btnFermer.setBounds(395, 520, 129, 31);
	contentPane.add(btnFermer);
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Refus d'ordre</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 25));
	lblajoutezLesClasses.setBounds(10, 0, 514, 31);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 534, 12);
	contentPane.add(separator);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 17));
	tabbedPane.setBounds(10, 97, 514, 411);
	contentPane.add(tabbedPane);
	
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab("Eleves punis", null, scrollPane, null);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(80, 80, 80));
				((Container) panel.getComponent(i)).getComponent(2).setVisible(false);
			}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
	
	text = new JLabel("<html><div style='text-align: center;'>Cliquez sur les eleves que vous voulez pardonner.</div></html>");
	text.setForeground(Color.WHITE);
	text.setFont(new Font("Roboto", Font.PLAIN, 15));
	text.setBounds(10, 62, 514, 31);
	contentPane.add(text);
	
	JLabel lblLe = new JLabel("Le "+date);
	lblLe.setHorizontalAlignment(SwingConstants.CENTER);
	lblLe.setForeground(Color.WHITE);
	lblLe.setFont(new Font("Roboto", Font.BOLD, 20));
	lblLe.setBounds(10, 32, 514, 31);
	contentPane.add(lblLe);
	setLocationRelativeTo(null);
	loadPunishedStudents(punishmentId);
	}
	
	
	
	
	public static void loadPunishedStudents(String punishmentId) {
		panel.removeAll();
		
		List<String> punished = new ArrayList();
		Object[] lines = Home.loadActiveStudents("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		
		for(int j = 0 ; j< lines.length; j++) {
			List l1 = Arrays.asList(lines[j].toString().split("//"));
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+l1.get(0).toString()+"/3eme Trimestre/Education.txt");
		aws.downloadContent(file1.getPath());
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = br1.lines().toArray();
		
		
		for(int i = 0; i< lines1.length; i++) {
				List l = Arrays.asList(lines1[i].toString().split("//"));
				if(l.get(1).toString().equals(punishmentId)) {
					punished.add(l1.get(0).toString()+"//"+l.get(0).toString()+"//"+l.get(1).toString());
					break;
				}
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		
		for(int i = 0; i< punished.toArray().length; i++) {
			List l = Arrays.asList(punished.get(i).split("//"));
			

			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setPreferredSize(new Dimension(500, 25));
			panel_3.setBackground(new Color(80, 80, 80));
			panel.add(panel_3);
			panel_3.setName(l.get(0).toString());
			
			JLabel label = new JLabel(l.get(0).toString());
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Roboto", Font.PLAIN, 15));
			label.setBounds(10, 2, 207, 20);
			panel_3.add(label);
			
			JLabel label_2 = new JLabel(Punish.getPunishmentPoints(l.get(1).toString())+" points");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Roboto", Font.PLAIN, 15));
			label_2.setBounds(219, 2, 162, 20);
			panel_3.add(label_2);
			

			JButton btnToutPardonner = new JButton("Pardonner");
			btnToutPardonner.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnToutPardonner.setIconTextGap(0);
			btnToutPardonner.setHorizontalTextPosition(SwingConstants.CENTER);
			btnToutPardonner.setForeground(Color.WHITE);
			btnToutPardonner.setFont(new Font("Roboto", Font.PLAIN, 17));
			btnToutPardonner.setFocusPainted(false);
			btnToutPardonner.setBorder(new LineBorder(new Color(255, 255, 255)));
			btnToutPardonner.setBackground(new Color(80, 80, 80));
			btnToutPardonner.setBounds(391, 0, 109, 25);
			panel_3.add(btnToutPardonner);
			btnToutPardonner.setVisible(false);
			
			
			btnToutPardonner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnToutPardonner.setBackground(new Color(20, 142, 192));
				}
				@Override
				public void mouseExited(MouseEvent e) {

					btnToutPardonner.setBackground(new Color(80, 80, 80));
				}
			});
			

			btnToutPardonner.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Punish.forgive(btnToutPardonner.getParent().getName(), punishmentId);
					loadPunishedStudents(punishmentId);
					Punish.loadClassPunishments(Home.className);
				}
			});
			
			
			panel_3.addMouseListener(new MouseAdapter() {@Override
				public void mouseClicked(MouseEvent e) {
				for(int i = 0; i< panel_3.getParent().getComponentCount(); i++) {
					panel_3.getParent().getComponent(i).setBackground(new Color(80, 80, 80));
					((Container) panel_3.getParent().getComponent(i)).getComponent(2).setVisible(false);
				}
				panel_3.setBackground(new Color(20, 142, 192));
				panel_3.getComponent(2).setVisible(true);
				
				if(e.getClickCount()==2) {
					
				}
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_3.setBorder(new LineBorder(Color.white, 1));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel_3.setBorder(null);
				}
			});
		}
		panel.revalidate();
		panel.repaint();
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel_2 = new JLabel("Cette classe n'a pas ete encore punie.");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_2);
		}
	}
}