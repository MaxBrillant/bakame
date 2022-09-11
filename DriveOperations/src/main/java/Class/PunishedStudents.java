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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import CloudOperations.mysql;
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
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	public static JPanel panel;
	public static int selectedClass;
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
	public PunishedStudents(String pi_id, String classroom_in_ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 450, 600);
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
	
	lblajoutezLesClasses = new JLabel(Punish.getPunishmentName(Punish.getPunishmentOriginalId(pi_id)));
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 414, 33);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 17));
	tabbedPane.setBounds(10, 118, 414, 432);
	contentPane.add(tabbedPane);
	
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab("Eleves punis", null, scrollPane, null);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			for(int i = 0; i<panel.getComponentCount(); i++) {
				if(!(panel.getComponent(i) instanceof JLabel)) {
				panel.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panel.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panel.getComponent(i)).getComponent(0).setBackground(panel.getComponent(i).getBackground());
				((Container) panel.getComponent(i)).getComponent(1).setBackground(panel.getComponent(i).getBackground());
			}}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JLabel lblLe = new JLabel("Le "+Punish.getPunishmentDate(pi_id));
	lblLe.setHorizontalAlignment(SwingConstants.CENTER);
	lblLe.setForeground(Color.WHITE);
	lblLe.setFont(new Font("Roboto", Font.BOLD, 16));
	lblLe.setBounds(137, 42, 160, 31);
	contentPane.add(lblLe);
	
	List<String> students = getPunishedStudents(pi_id, classroom_in_ay_id);
	JLabel lblEleves = new JLabel(students.toArray().length+" eleves");
	if(students.toArray().length==1) {
		lblEleves.setText(students.toArray().length+" eleve");
	}
	lblEleves.setHorizontalAlignment(SwingConstants.CENTER);
	lblEleves.setForeground(Color.WHITE);
	lblEleves.setFont(new Font("Roboto", Font.PLAIN, 16));
	lblEleves.setBounds(331, 42, 93, 31);
	contentPane.add(lblEleves);
	
	JButton btnToutPardonner = new JButton("Tout pardonner");
	btnToutPardonner.setForeground(Color.WHITE);
	btnToutPardonner.setFont(new Font("Roboto", Font.BOLD, 14));
	btnToutPardonner.setFocusPainted(false);
	btnToutPardonner.setBorderPainted(false);
	btnToutPardonner.setBackground(new Color(0, 171, 89));
	btnToutPardonner.setBounds(279, 84, 145, 31);
	contentPane.add(btnToutPardonner);
	setLocationRelativeTo(null);
	loadPunishedStudents(pi_id, classroom_in_ay_id, students);
	}
	
	
	
	
	public static void loadPunishedStudents(String pi_id, String classroom_in_ay_id, List students) {
		panel.removeAll();
		
		String points = Punish.getPunishmentPoints(Punish.getPunishmentOriginalId(pi_id));
		for(int i = 0; i< students.toArray().length; i++) {
			
			JPanel panel_3 = new JPanel();
			panel_3.setName(Punish.getStudentPunishment(pi_id, students.get(i).toString()));
			panel_3.setPreferredSize(new Dimension(390, 25));
			panel_3.setBackground(new Color(60, 60, 60));;
			
					panel.add(panel_3);
					panel_3.setLayout(new BorderLayout(0, 0));
			
			JPanel panel2 = new JPanel();
			panel_3.add(panel2);
			panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
			panel2.setBackground(panel2.getParent().getBackground());
			
			JLabel label = new JLabel(Home.getStudentName(students.get(i).toString()));
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Roboto", Font.PLAIN, 14));
			label.setBounds(10, 2, 207, 20);
			panel2.add(label);
			
			
			JLabel label1 = new JLabel("-");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setForeground(Color.WHITE);
			label1.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel2.add(label1);
			
			
			JLabel label_2 = new JLabel(points+" points");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Roboto", Font.PLAIN, 14));
			label_2.setBounds(219, 2, 162, 20);
			panel2.add(label_2);
			

			
			JPanel panel_4 = new JPanel();
			panel_3.add(panel_4, BorderLayout.EAST);
			panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			panel_4.setVisible(false);

			panel_4.setBackground(panel_4.getParent().getBackground());
			
			
			JButton btnRetirer = new JButton("Pardonner");
			btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRetirer.setForeground(Color.WHITE);
			btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
			btnRetirer.setFocusPainted(false);
			btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
			btnRetirer.setPreferredSize(new Dimension(80, 25));
			panel_4.add(btnRetirer);
			btnRetirer.setBackground(btnRetirer.getParent().getBackground());
			
			
			btnRetirer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRetirer.setBackground(new Color(20, 142, 192));
				}
				@Override
				public void mouseExited(MouseEvent e) {

					btnRetirer.setBackground(new Color(80, 80, 80));
				}
			});
			

			btnRetirer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//forgive(student_in_classroom_id, btnRetirer.getParent().getName());
					//loadIndividualPunishments(student_in_classroom_id, term_id);
					
				}
			});
			
			

			panel2.addMouseListener(new MouseAdapter() {@Override
				public void mouseClicked(MouseEvent e) {
				for(int i = 0; i< panel_3.getParent().getComponentCount(); i++) {
					panel_3.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
					((Container) panel_3.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
					((Container) panel_3.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
				}
				
				panel_3.setBackground(new Color(20, 142, 192));
				panel_3.getComponent(0).setBackground(panel_3.getBackground());
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					
					panel_3.getComponent(1).setVisible(true);
					
					for(int i = 0; i< (panel_3.getParent()).getComponentCount(); i++) {
						if(!(panel_3.getParent()).getComponent(i).equals(panel_3.getComponent(0).getParent())) {
					((Container) ((Container) panel_3.getParent().getComponent(i))).getComponent(1).setVisible(false);
						
					panel_3.getParent().revalidate();

					panel_3.getParent().repaint();
						}
					}
					
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

			
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Cette classe n'a pas ete encore punie.</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel, 0);
		}
	}
	
	
public static List<String> getPunishedStudents(String punishment_id, String classroom_in_ay_id) {
		
		List<String> students = new ArrayList();
		try {
			Statement stmt= mysql.con.createStatement();
			Object[] s = Home.loadActiveStudents(classroom_in_ay_id);

			ResultSet rs=stmt.executeQuery("select * from student_punishments "
					+ "WHERE pi_id = '"+punishment_id+"'");
			while(rs.next())
			{
				for(int i = 0; i< s.length; i++) {
					if(rs.getString("sic_id").equals(s[i].toString())) {
						students.add(rs.getString("sic_id"));
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return students;
	}
}