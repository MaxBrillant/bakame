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
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
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
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import CloudOperations.mysql;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;

import Application.ResizeImages;

import javax.swing.event.ChangeEvent;

public class Users extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();
	public static JPanel panel;
	public static String selectedSchool;
	public static String selectedRole;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users frame = new Users("44878bff-9645-4b70-b6a3-996905cb9402");
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
	public Users(String ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 300));
	setTitle("");
	setBounds(100, 100, 450, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNewLabel = new JLabel("Utilisateurs et responsabilites: "+ScholarYears.getAcademicYearName(ay_id));
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(10, 0, 404, 33);
	contentPane.add(lblNewLabel);
	
	JLabel notice = new JLabel("<html><div style='text-align: center;'>Controllez et administrez les utilisateurs externes qui ont acc\u00E8s aux classes et cours qui constituent l'annee scholaire.</div></html>");
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(211, 211, 211));
	notice.setFont(new Font("Roboto", Font.PLAIN, 14));
	notice.setBounds(10, 34, 404, 44);
	contentPane.add(notice);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	JButton button_1 = new JButton("Ajouter");
	button_1.setForeground(Color.WHITE);
	button_1.setFont(new Font("Roboto", Font.BOLD, 14));
	button_1.setFocusPainted(false);
	button_1.setBorderPainted(false);
	button_1.setBackground(new Color(0, 171, 89));
	button_1.setBounds(323, 85, 101, 31);
	contentPane.add(button_1);
	
	
	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 118, 414, 438);
	scrollPane.setBorder(null);
	contentPane.add(scrollPane);
	//contentPane.add(scrollPane, BorderLayout.CENTER);
	
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
	
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(390, 25));
	panel_1.setBackground(new Color(60, 60, 60));;
	
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
			panel_2.setBackground(panel_2.getParent().getBackground());
			
			JLabel lblNewLabel1 = new JLabel("UMUHOZA Chris Koen Michael");
			panel_2.add(lblNewLabel1);
			lblNewLabel1.setMaximumSize(new Dimension(300, 14));
			lblNewLabel1.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel1.setForeground(Color.white);
			
			JLabel label = new JLabel("-");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel_2.add(label);
			
			JLabel lblCours = new JLabel("2 classes");
			panel_2.add(lblCours);
			lblCours.setHorizontalAlignment(SwingConstants.CENTER);
			lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblCours.setForeground(Color.white);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		panel_3.setBackground(panel_3.getParent().getBackground());
		
		
		
		JButton button = new JButton("");
		panel_3.add(button);
		button.setPreferredSize(new Dimension(40, 25));
		button.setIcon(ResizeImages.resize(20, 20, "Icons\\iconedit.png"));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setIconTextGap(0);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(button.getParent().getBackground());
		button.setVisible(false);
		Home.addToolTip(button, "Modifier");
		
		
		JButton button1 = new JButton("");
		panel_3.add(button1);
		button1.setPreferredSize(new Dimension(40, 25));
		button1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button1.setIconTextGap(0);
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button1.setFocusPainted(false);
		button1.setBorder(null);
		button1.setBackground(button1.getParent().getBackground());
		button1.setVisible(false);
		Home.addToolTip(button1, "Supprimer");
		
		
	
	loadUsers(ay_id);
	}
	
	
	public static void loadUsers(String ay_id) {

		panel.removeAll();
		List l = new ArrayList();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from user_course_control AS ucc "
					+ "JOIN users AS u "
					+ "JOIN classrooms_in_ay AS cia "
					+ "JOIN courses_in_classroom AS cic "
					+ "WHERE ucc.courses_in_classroom_id = cic.courses_in_classroom_id AND cia.cia_id = cic.cia_id AND ucc.user_id = u.user_id AND cia.ay_id = '"+ay_id+"' AND cia.is_active = 1 AND cic.is_active = 1 AND u.is_active = 1");
			while(rs.next())
			{
				if(!l.contains(rs.getString("ucc.user_id"))) {
					l.add(rs.getString("ucc.user_id"));
				}
			}
				
				
				for(int i = 0; i< l.toArray().length; i++) {
					
				JPanel panel_1 = new JPanel();
				panel_1.setName(l.get(i).toString());
				panel_1.setPreferredSize(new Dimension(390, 25));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
						panel_2.setBackground(panel_2.getParent().getBackground());
						
						JLabel lblNewLabel1 = new JLabel(Login.getUserName(l.get(i).toString()));
						panel_2.add(lblNewLabel1);
						lblNewLabel1.setMaximumSize(new Dimension(300, 14));
						lblNewLabel1.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel1.setForeground(Color.white);
						
						JLabel label = new JLabel("-");
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setForeground(Color.WHITE);
						label.setFont(new Font("Roboto", Font.PLAIN, 14));
						panel_2.add(label);
					
						
						List<String> l1 = userCourses(l.get(i).toString(), ay_id);
						
						JLabel lblCours = new JLabel(l1.toArray().length+" cours");
						panel_2.add(lblCours);
						lblCours.setHorizontalAlignment(SwingConstants.CENTER);
						lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblCours.setForeground(Color.white);
					
					JPanel panel_3 = new JPanel();
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					panel_3.setVisible(false);
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setBackground(panel_3.getParent().getBackground());
					
					
					JButton button = new JButton("");
					panel_3.add(button);
					button.setPreferredSize(new Dimension(40, 25));
					button.setIcon(ResizeImages.resize(20, 20, "Icons\\iconedit.png"));
					button.setVerticalTextPosition(SwingConstants.BOTTOM);
					button.setIconTextGap(0);
					button.setHorizontalTextPosition(SwingConstants.CENTER);
					button.setForeground(Color.WHITE);
					button.setFont(new Font("Tahoma", Font.PLAIN, 15));
					button.setFocusPainted(false);
					button.setBorder(null);
					button.setBackground(button.getParent().getBackground());
					Home.addToolTip(button, "Modifier");
					
					
					JButton button1 = new JButton("");
					panel_3.add(button1);
					button1.setPreferredSize(new Dimension(40, 25));
					button1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
					button1.setVerticalTextPosition(SwingConstants.BOTTOM);
					button1.setIconTextGap(0);
					button1.setHorizontalTextPosition(SwingConstants.CENTER);
					button1.setForeground(Color.WHITE);
					button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					button1.setFocusPainted(false);
					button1.setBorder(null);
					button1.setBackground(button1.getParent().getBackground());
					Home.addToolTip(button1, "Supprimer");
					
					
					
					
					button1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							button1.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							button1.setBackground(button1.getParent().getBackground());
						}
					});
					
					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							button.setBackground(new Color(20, 148, 198));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							button.setBackground(button.getParent().getBackground());
						}
					});
					

					int k = i;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ClassAndCourseSelection c = new ClassAndCourseSelection(l.get(k).toString(), ay_id);
							c.setVisible(true);
						}
					});
					
					
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//NewPunishment.deletePunishment(((JLabel) button1.getParent().getComponent(0)).getText());
							EducationFrame.loadPunishments(ay_id);
						}
					});
					
					
					panel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
							panel_1.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
							((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
							((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
						}
						
						panel_1.setBackground(new Color(20, 142, 192));
						panel_1.getComponent(0).setBackground(panel_1.getBackground());
						
					}
						@Override
						public void mouseEntered(MouseEvent e) {
							
							panel_1.getComponent(1).setVisible(true);
							
							for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
								if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
							((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(1).setVisible(false);
								
							panel_1.getParent().revalidate();

							panel_1.getParent().repaint();
								}
							}
							
							panel_1.setBorder(new LineBorder(Color.white, 1));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});
						
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				if(panel.getComponentCount()==0) {

					
					JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Cet etablissement n'a actuellement aucun utilisateur externe qui controle les cours.</div></html>");
					lblNewLabel.setPreferredSize(new Dimension(370, 50));
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					panel.add(lblNewLabel, 0);
				}
				panel.revalidate();
				panel.repaint();
	
		
	}
	
	public static List<String> userCourses(String user_id, String ay_id) {
		List<String> courses = new ArrayList();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from user_course_control AS ucc "
					+ "JOIN classrooms_in_ay AS cia "
					+ "JOIN courses_in_classroom AS cic "
					+ "WHERE ucc.user_id = '"+user_id+"' AND ucc.courses_in_classroom_id = cic.courses_in_classroom_id AND cia.cia_id = cic.cia_id AND cia.ay_id = '"+ay_id+"' AND cia.is_active = 1 AND cic.is_active = 1");
			while(rs.next())
			{
				courses.add(rs.getString("ucc.courses_in_classroom_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return courses;
	}

	public static void loadRequests(String schoolID) {
		/*
		 * panel.removeAll(); try { Statement stmt= mysql.con.createStatement();
		 * 
		 * ResultSet rs=stmt.executeQuery("select * from requests AS r " +
		 * "JOIN users AS u " + "WHERE r.school_id = '"
		 * +schoolID+"' AND r.user_id = u.user_id AND u.is_active = 1");
		 * while(rs.next()) { JPanel panel_4 = new JPanel(); panel_4.setLayout(null);
		 * panel_4.setPreferredSize(new Dimension(450, 40)); panel_4.setBackground(new
		 * Color(85, 85, 85)); panel.add(panel_4);
		 * 
		 * JLabel label = new JLabel(Login.getUserName(rs.getString("r.user_id")));
		 * label.setForeground(Color.WHITE); label.setFont(new Font("Roboto",
		 * Font.PLAIN, 15)); label.setBounds(5, 0, 181, 25); panel_4.add(label);
		 * 
		 * //List time = Arrays.asList(l.get(1).toString().split("::")); //List hours =
		 * Arrays.asList(time.get(1).toString().split(":"));
		 * 
		 * //JLabel label_3 = new
		 * JLabel("Le "+time.get(0).toString()+" � "+hours.get(0).toString()+"h"+hours.
		 * get(1).toString()); JLabel label_3 = new
		 * JLabel(rs.getString("r.date_and_time"));
		 * label_3.setHorizontalAlignment(SwingConstants.LEFT);
		 * label_3.setForeground(Color.LIGHT_GRAY); label_3.setFont(new Font("Roboto",
		 * Font.PLAIN, 15)); label_3.setBackground(Color.LIGHT_GRAY);
		 * label_3.setBounds(5, 22, 181, 18); panel_4.add(label_3);
		 * 
		 * JButton btnAccepter = new JButton("Accepter");
		 * btnAccepter.setVerticalTextPosition(SwingConstants.BOTTOM);
		 * btnAccepter.setIconTextGap(0);
		 * btnAccepter.setHorizontalTextPosition(SwingConstants.CENTER);
		 * btnAccepter.setForeground(Color.WHITE); btnAccepter.setFont(new
		 * Font("Tahoma", Font.PLAIN, 15)); btnAccepter.setFocusPainted(false);
		 * btnAccepter.setBorder(new LineBorder(new Color(255, 255, 255)));
		 * btnAccepter.setBackground(new Color(60, 60, 60)); btnAccepter.setBounds(211,
		 * 5, 110, 30); panel_4.add(btnAccepter);
		 * 
		 * 
		 * 
		 * btnAccepter.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { try { grantAccess(schoolID,
		 * rs.getString("r.user_id")); denyAccess(schoolID, rs.getString("r.user_id"));
		 * } catch (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } loadRequests(schoolID); loadUsers(schoolID,
		 * Login.selectedUserID); } });
		 * 
		 * btnAccepter.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseEntered(MouseEvent e) {
		 * btnAccepter.setBackground(new Color(0, 171, 89).brighter());
		 * btnAccepter.setForeground(Color.black); }
		 * 
		 * @Override public void mouseExited(MouseEvent e) {
		 * btnAccepter.setBackground(new Color(60, 60, 60));
		 * btnAccepter.setForeground(Color.white); } });
		 * 
		 * JButton btnRefuser = new JButton("Refuser");
		 * btnRefuser.setVerticalTextPosition(SwingConstants.BOTTOM);
		 * btnRefuser.setIconTextGap(0);
		 * btnRefuser.setHorizontalTextPosition(SwingConstants.CENTER);
		 * btnRefuser.setForeground(Color.WHITE); btnRefuser.setFont(new Font("Tahoma",
		 * Font.PLAIN, 15)); btnRefuser.setFocusPainted(false); btnRefuser.setBorder(new
		 * LineBorder(new Color(255, 255, 255))); btnRefuser.setBackground(new Color(60,
		 * 60, 60)); btnRefuser.setBounds(330, 5, 110, 30); panel_4.add(btnRefuser);
		 * 
		 * 
		 * btnRefuser.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { try { denyAccess(schoolID,
		 * rs.getString("r.user_id")); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } loadRequests(schoolID); }
		 * }); btnRefuser.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseEntered(MouseEvent e) {
		 * btnRefuser.setBackground(new Color(255, 102, 102).brighter());
		 * btnRefuser.setForeground(Color.black); }
		 * 
		 * @Override public void mouseExited(MouseEvent e) {
		 * btnRefuser.setBackground(new Color(60, 60, 60));
		 * btnRefuser.setForeground(Color.white); } }); } } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * if(panel.getComponentCount()==0) { JLabel lblNewLabel_2 = new
		 * JLabel("Cet �tablissement n'a actuellement aucune demande d'acc�s");
		 * lblNewLabel_2.setForeground(Color.WHITE); lblNewLabel_2.setFont(new
		 * Font("Tahoma", Font.PLAIN, 15)); panel.add(lblNewLabel_2); }
		 * panel.revalidate(); panel.repaint();
		 */}
}