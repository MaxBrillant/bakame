package accounts;

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
	public static JPanel panel_2;
	public static String selectedSchool;
	public static String selectedRole;
	public static JPanel panel;

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
	public Users(String schoolID) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 500, 500);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(60, 60, 60));
	panel_1.setPreferredSize(new Dimension(10, 80));
	contentPane.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(null);
	
	JLabel lblNewLabel = new JLabel(UserPanel.getSchoolFullName(schoolID));
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(10, 0, 454, 33);
	panel_1.add(lblNewLabel);
	
	JLabel notice = new JLabel("<html><div style='text-align: center;'>Controllez et administrez ceux qui ont acc\u00E8s \u00E0 l'\u00E9tablissement, ainsi que leurs responsabilit\u00E9s (roles).</div></html>");
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(Color.WHITE);
	notice.setFont(new Font("Roboto", Font.PLAIN, 15));
	notice.setBounds(10, 32, 454, 44);
	panel_1.add(notice);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBorder(null);
	//contentPane.add(scrollPane, BorderLayout.CENTER);
	
	panel_2 = new JPanel();
	panel_2.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
	
	
	JPanel panel_3 = new JPanel();
	panel_3.setBackground(new Color(60, 60, 60).brighter());
	panel_3.setPreferredSize(new Dimension(450, 30));
	panel_2.add(panel_3);
	panel_3.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Ndashimye Max Brillant");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(5, 0, 181, 30);
	panel_3.add(lblNewLabel_1);
	
	JLabel lblAdministrateur = new JLabel("Administrateur General");
	lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
	lblAdministrateur.setForeground(Color.WHITE);
	lblAdministrateur.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblAdministrateur.setBounds(190, 0, 154, 30);
	panel_3.add(lblAdministrateur);
	
	JLabel lblClasses = new JLabel("12 Classes");
	lblClasses.setHorizontalAlignment(SwingConstants.RIGHT);
	lblClasses.setForeground(Color.WHITE);
	lblClasses.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblClasses.setBounds(366, 0, 74, 30);
	panel_3.add(lblClasses);
	
	JButton btnRoles = new JButton("Modifier");
	btnRoles.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnRoles.setIconTextGap(0);
	btnRoles.setHorizontalTextPosition(SwingConstants.CENTER);
	btnRoles.setForeground(Color.WHITE);
	btnRoles.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnRoles.setFocusPainted(false);
	btnRoles.setBorder(new LineBorder(new Color(255, 255, 255)));
	btnRoles.setBackground(new Color(60, 60, 60));
	btnRoles.setBounds(350, 2, 44, 25);
	panel_3.add(btnRoles);
	
	JButton button = new JButton("Modifier");
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setIconTextGap(0);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button.setFocusPainted(false);
	button.setBorder(new LineBorder(new Color(255, 255, 255)));
	button.setBackground(new Color(60, 60, 60));
	button.setBounds(400, 2, 44, 25);
	panel_3.add(button);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			if(tabbedPane.getSelectedIndex() == 0) {
			notice.setText("<html><div style='text-align: center;'>Controllez et administrez ceux qui ont acc\u00E8s \u00E0 l'\u00E9tablissement, ainsi que leurs responsabilit\u00E9s (roles).</div></html>");
			}
			if(tabbedPane.getSelectedIndex() == 1) {
			notice.setText("<html><div style='text-align: center;'>Donnez l'acc\u00E8s \u00E0 l'\u00E9tablissement aux autres utilisateurs qui vous ont fait une demande.</div></html>");
				
			}
		}
	});
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 15));
	contentPane.add(tabbedPane, BorderLayout.CENTER);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	tabbedPane.addTab("Utilisateurs", null, scrollPane, null);
	
	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setBorder(null);
	if(UserPanel.selectedRole.equals("Administrateur General") || UserPanel.selectedRole.equals("Administrateur")) {
	tabbedPane.addTab("Demandes", null, scrollPane_2, null);
	}
	panel = new JPanel();
	panel.setBackground(new Color(40, 40, 40));
	scrollPane_2.setViewportView(panel);
	panel.setLayout(new WrapLayout(1, 3, 3));
	
	JPanel panel_4 = new JPanel();
	panel_4.setLayout(null);
	panel_4.setPreferredSize(new Dimension(450, 40));
	panel_4.setBackground(new Color(85, 85, 85));
	panel.add(panel_4);
	
	JLabel label = new JLabel("Ndashimye Max Brillant");
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 15));
	label.setBounds(5, 0, 181, 25);
	panel_4.add(label);
	
	JLabel label_3 = new JLabel("Le 22/9/2021");
	label_3.setHorizontalAlignment(SwingConstants.LEFT);
	label_3.setForeground(Color.LIGHT_GRAY);
	label_3.setFont(new Font("Roboto", Font.PLAIN, 15));
	label_3.setBackground(Color.LIGHT_GRAY);
	label_3.setBounds(5, 22, 181, 18);
	panel_4.add(label_3);
	
	JButton btnAccepter = new JButton("Accepter");
	btnAccepter.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnAccepter.setIconTextGap(0);
	btnAccepter.setHorizontalTextPosition(SwingConstants.CENTER);
	btnAccepter.setForeground(Color.WHITE);
	btnAccepter.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAccepter.setFocusPainted(false);
	btnAccepter.setBorder(new LineBorder(new Color(255, 255, 255)));
	btnAccepter.setBackground(new Color(60, 60, 60));
	btnAccepter.setBounds(211, 5, 110, 30);
	panel_4.add(btnAccepter);
	
	JButton btnRefuser = new JButton("Refuser");
	btnRefuser.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnRefuser.setIconTextGap(0);
	btnRefuser.setHorizontalTextPosition(SwingConstants.CENTER);
	btnRefuser.setForeground(Color.WHITE);
	btnRefuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnRefuser.setFocusPainted(false);
	btnRefuser.setBorder(new LineBorder(new Color(255, 255, 255)));
	btnRefuser.setBackground(new Color(60, 60, 60));
	btnRefuser.setBounds(330, 5, 110, 30);
	panel_4.add(btnRefuser);
	setLocationRelativeTo(null);
	
	loadUsers(schoolID, Login.selectedUserID);
	loadRequests(schoolID);
	}
	
	
	public static void loadUsers(String schoolID, String userID) {

		panel_2.removeAll();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users_in_schools AS uis "
					+ "JOIN users AS u "
					+ "WHERE uis.school_id = '"+schoolID+"' AND uis.user_id <> '"+userID+"' AND uis.user_id = u.user_id AND u.is_active = 1 AND uis.is_active = 1");
			while(rs.next())
			{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(60, 60, 60).brighter());
						panel_3.setPreferredSize(new Dimension(450, 30));
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						
						JLabel lblNewLabel_1 = new JLabel(Login.getUserName(rs.getString("uis.user_id")));
						lblNewLabel_1.setForeground(Color.WHITE);
						lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
						lblNewLabel_1.setBounds(5, 0, 181, 30);
						panel_3.add(lblNewLabel_1);
						
						String s = null;
						if(Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("administrator")) {
							s = "Administrateur";
						}else if(Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("general_administrator")) {
							s = "Administrateur General";
						}else if(Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("editor")) {
							s = "Editeur";
						}
						JLabel lblAdministrateur = new JLabel(s);
						lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
						lblAdministrateur.setForeground(Color.WHITE);
						lblAdministrateur.setFont(new Font("Roboto", Font.PLAIN, 15));
						lblAdministrateur.setBounds(190, 0, 154, 30);
						panel_3.add(lblAdministrateur);
						
						ClassName.load(schoolID, rs.getString("uis.user_id"));
						List<String> l1 = new ArrayList();
						for(int j = 0; j< ClassName.selectedCourses.toArray().length; j++) {
							List m = Arrays.asList(ClassName.selectedCourses.get(j).split("//"));
							if(!l1.contains(m.get(1).toString())) {
								l1.add(m.get(1).toString());
							}
						}
						
						JLabel lblClasses = new JLabel(l1.toArray().length+" Classes");
						lblClasses.setHorizontalAlignment(SwingConstants.RIGHT);
						lblClasses.setForeground(Color.WHITE);
						lblClasses.setFont(new Font("Roboto", Font.PLAIN, 15));
						lblClasses.setBounds(366, 0, 74, 30);
						if(Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("Editor")) {
						panel_3.add(lblClasses);
						}
						panel_3.setVisible(true);
						JButton btnRoles = new JButton("+");
						btnRoles.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnRoles.setIconTextGap(0);
						btnRoles.setHorizontalTextPosition(SwingConstants.CENTER);
						btnRoles.setForeground(Color.WHITE);
						btnRoles.setFont(new Font("ROBOTO", Font.BOLD, 30));
						btnRoles.setFocusPainted(false);
						btnRoles.setBorder(new LineBorder(new Color(255, 255, 255)));
						btnRoles.setBackground(new Color(60, 60, 60));
						btnRoles.setBounds(340, 2, 44, 25);
						btnRoles.setVisible(false);
						if(!Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("general_administrator")) {

							if(UserPanel.selectedRole.equals("Administrateur General") || UserPanel.selectedRole.equals("Administrateur")) {
						panel_3.add(btnRoles);
						}}
						
						JButton button = new JButton();
						button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
						button.setVerticalTextPosition(SwingConstants.BOTTOM);
						button.setIconTextGap(0);
						button.setHorizontalTextPosition(SwingConstants.CENTER);
						button.setForeground(Color.WHITE);
						button.setFont(new Font("Tahoma", Font.PLAIN, 15));
						button.setFocusPainted(false);
						button.setBorder(new LineBorder(new Color(255, 255, 255)));
						button.setBackground(new Color(60, 60, 60));
						button.setBounds(400, 2, 44, 25);
						button.setVisible(false);
						if(!Login.getUserRole(schoolID, rs.getString("uis.user_id")).equals("general_administrator")) {
							if(UserPanel.selectedRole.equals("Administrateur General") || UserPanel.selectedRole.equals("Administrateur")) {
						panel_3.add(button);
						}}
						
						
						panel_3.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								panel_3.setBorder(new LineBorder(new Color(20, 148, 198), 2));
								button.setVisible(true);
								btnRoles.setVisible(true);
								if(UserPanel.selectedRole.equals("Administrateur General") || UserPanel.selectedRole.equals("Administrateur")){
								lblClasses.setVisible(false);
							}
							}
							@Override
							public void mouseExited(MouseEvent e) {
								panel_3.setBorder(null);
								button.setVisible(false);
								btnRoles.setVisible(false);
								lblClasses.setVisible(true);
							}
						});
						
						
						btnRoles.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								panel_3.setBorder(new LineBorder(new Color(20, 148, 198), 2));
								button.setVisible(true);
								btnRoles.setVisible(true);
								lblClasses.setVisible(false);
								btnRoles.setBackground(new Color(20, 148, 198));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								button.setVisible(false);
								btnRoles.setVisible(false);
								lblClasses.setVisible(true);
								btnRoles.setBackground(new Color(60, 60, 60));
							}
						});
						
						btnRoles.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ClassName c;
								try {
									c = new ClassName(schoolID, rs.getString("uis.user_id"));
									c.setVisible(true);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									removeUser(schoolID, rs.getString("uis.user_id"));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								loadUsers(schoolID, userID);
							}
						});
						panel_3.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if(e.getClickCount()==2) {
									if(UserPanel.selectedRole.equals("Administrateur General") || UserPanel.selectedRole.equals("Administrateur")){
								ClassName c;
								try {
									c = new ClassName(schoolID, rs.getString("uis.user_id"));
									c.setVisible(true);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
									}
							}}
						});
						
						
						button.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								panel_3.setBorder(new LineBorder(new Color(20, 148, 198), 2));
								button.setVisible(true);
								btnRoles.setVisible(true);
								lblClasses.setVisible(false);
								button.setBackground(new Color(255, 102, 102));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								button.setVisible(false);
								btnRoles.setVisible(false);
								lblClasses.setVisible(true);
								button.setBackground(new Color(60, 60, 60));
							}
						});
						
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				if(panel_2.getComponentCount()==0) {
					JLabel lblNewLabel_2 = new JLabel("Cet etablissement n'a actuellement aucun utilisateur");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel_2.add(lblNewLabel_2);
				}
				panel_2.revalidate();
				panel_2.repaint();
	
		
	}
	public static void loadRequests(String schoolID) {
		panel.removeAll();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from requests AS r "
					+ "JOIN users AS u "
					+ "WHERE r.school_id = '"+schoolID+"' AND r.user_id = u.user_id AND u.is_active = 1");
			while(rs.next())
			{
							JPanel panel_4 = new JPanel();
							panel_4.setLayout(null);
							panel_4.setPreferredSize(new Dimension(450, 40));
							panel_4.setBackground(new Color(85, 85, 85));
							panel.add(panel_4);
							
							JLabel label = new JLabel(Login.getUserName(rs.getString("r.user_id")));
							label.setForeground(Color.WHITE);
							label.setFont(new Font("Roboto", Font.PLAIN, 15));
							label.setBounds(5, 0, 181, 25);
							panel_4.add(label);
							
							//List time = Arrays.asList(l.get(1).toString().split("::"));
							//List hours = Arrays.asList(time.get(1).toString().split(":"));
							
							//JLabel label_3 = new JLabel("Le "+time.get(0).toString()+" à "+hours.get(0).toString()+"h"+hours.get(1).toString());
							JLabel label_3 = new JLabel(rs.getString("r.date_and_time"));
							label_3.setHorizontalAlignment(SwingConstants.LEFT);
							label_3.setForeground(Color.LIGHT_GRAY);
							label_3.setFont(new Font("Roboto", Font.PLAIN, 15));
							label_3.setBackground(Color.LIGHT_GRAY);
							label_3.setBounds(5, 22, 181, 18);
							panel_4.add(label_3);
							
							JButton btnAccepter = new JButton("Accepter");
							btnAccepter.setVerticalTextPosition(SwingConstants.BOTTOM);
							btnAccepter.setIconTextGap(0);
							btnAccepter.setHorizontalTextPosition(SwingConstants.CENTER);
							btnAccepter.setForeground(Color.WHITE);
							btnAccepter.setFont(new Font("Tahoma", Font.PLAIN, 15));
							btnAccepter.setFocusPainted(false);
							btnAccepter.setBorder(new LineBorder(new Color(255, 255, 255)));
							btnAccepter.setBackground(new Color(60, 60, 60));
							btnAccepter.setBounds(211, 5, 110, 30);
							panel_4.add(btnAccepter);
							
							

							btnAccepter.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										grantAccess(schoolID, rs.getString("r.user_id"));
										denyAccess(schoolID, rs.getString("r.user_id"));
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									loadRequests(schoolID);
									loadUsers(schoolID, Login.selectedUserID);
								}
							});

							btnAccepter.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									btnAccepter.setBackground(new Color(0, 171, 89).brighter());
									btnAccepter.setForeground(Color.black);
								}
								@Override
								public void mouseExited(MouseEvent e) {
									btnAccepter.setBackground(new Color(60, 60, 60));
									btnAccepter.setForeground(Color.white);
								}
							});
							
							JButton btnRefuser = new JButton("Refuser");
							btnRefuser.setVerticalTextPosition(SwingConstants.BOTTOM);
							btnRefuser.setIconTextGap(0);
							btnRefuser.setHorizontalTextPosition(SwingConstants.CENTER);
							btnRefuser.setForeground(Color.WHITE);
							btnRefuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
							btnRefuser.setFocusPainted(false);
							btnRefuser.setBorder(new LineBorder(new Color(255, 255, 255)));
							btnRefuser.setBackground(new Color(60, 60, 60));
							btnRefuser.setBounds(330, 5, 110, 30);
							panel_4.add(btnRefuser);
							

							btnRefuser.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										denyAccess(schoolID, rs.getString("r.user_id"));
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									loadRequests(schoolID);
								}
							});
							btnRefuser.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									btnRefuser.setBackground(new Color(255, 102, 102).brighter());
									btnRefuser.setForeground(Color.black);
								}
								@Override
								public void mouseExited(MouseEvent e) {
									btnRefuser.setBackground(new Color(60, 60, 60));
									btnRefuser.setForeground(Color.white);
								}
							});
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				if(panel.getComponentCount()==0) {
					JLabel lblNewLabel_2 = new JLabel("Cet établissement n'a actuellement aucune demande d'accès");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel.add(lblNewLabel_2);
				}
				panel.revalidate();
				panel.repaint();
	}
	
	public static void grantAccess(String schoolID, String userID) {
		File file1 = new File("Data/Establishments/"+schoolID+"/Users.txt");
		List<String> comp = new ArrayList(); 
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
		comp.add(userID+"//Editor");
		
		File file11 = new File("Data/Establishments/"+schoolID+"/Users.txt");
				
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
	
	public static void denyAccess(String schoolID, String userID) {
		File file1 = new File("Data/Establishments/"+schoolID+"/Requests.txt");
		List<String> comp = new ArrayList(); 
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
			if(l.get(0).toString().equals(userID)) {
				comp.remove(i);
		}}
		File file11 = new File("Data/Establishments/"+schoolID+"/Requests.txt");
				
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
	public static void removeUser(String schoolID, String userID) {
		File file1 = new File("Data/Establishments/"+schoolID+"/Users.txt");
		List<String> comp = new ArrayList(); 
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
			if(l.get(0).toString().equals(userID)) {
				comp.remove(i);
		}}
		File file11 = new File("Data/Establishments/"+schoolID+"/Users.txt");
				
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