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
import Class.Student;
import Class.TestBox;
import Class.Threads;
import Class.OptionsMenu.CourseMenu;
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

public class ScholarYears {


	public static JFrame frame;
	public static JPanel panel;
	public static JButton button_3;
	public static JLabel classe;
	private JScrollPane scrollPane;
	public static JPanel panelYear;
	public static JPanel panelStudents;
	public static JPanel panelProf;
	private JScrollPane scrollPane_2;
	public static String className = "3eme Economique";
	public static  int  selectedTab = 0;
	private JLabel lblAdministrateur;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnOuvrir;
	private JPanel panel_5;
	private JButton btnNewButton_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScholarYears window = new ScholarYears("1", "1", UserPanel.selectedRole);
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
	public ScholarYears(String userId, String schoolId, String role) {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(40, 40, 40));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screensize.width,screensize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(screensize.width*80/100,screensize.height*80/100));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setPreferredSize(new Dimension(10, frame.getHeight()*20/100));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(20, 148, 198));
		panel_1.setPreferredSize(new Dimension(10, frame.getHeight()*20/100*30/100));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		classe = new JLabel(UserPanel.getSchoolFullName(schoolId));
		classe.setHorizontalAlignment(SwingConstants.CENTER);
		classe.setForeground(new Color(255, 255, 255));
		classe.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		panel_1.add(classe, BorderLayout.CENTER);
		
		JButton label = new JButton("Retour");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(20, 148, 198).brighter());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(20, 148, 198));
			}
		});
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPanel up = new UserPanel(Login.selectedUserID);
				up.setVisible(true);
				frame.setVisible(false);
			}
		});
		label.setFocusPainted(false);
		label.setBorderPainted(false);
		label.setBackground(new Color(20, 148, 198));
		label.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		label.setPreferredSize(new Dimension(200, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Futura Hv BT", Font.BOLD, 30));
		panel_1.add(label, BorderLayout.WEST);
		
		lblAdministrateur = new JLabel(role);
		lblAdministrateur.setPreferredSize(new Dimension(350, 14));
		lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrateur.setForeground(Color.WHITE);
		lblAdministrateur.setFont(new Font("Futura Hv BT", Font.BOLD, 25));
		panel_1.add(lblAdministrateur, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 40, 40));
		panel.add(panel_2, BorderLayout.CENTER);

		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		button_3 = new JButton("");
		button_3.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button_3.setFont(new Font("Arial", Font.PLAIN, 27));
		button_3.setFocusPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(40, 40, 40));
		panel_2.add(button_3, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(350, 10));
		panel_2.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(null);
		panel_7.setBackground(panel_7.getParent().getBackground());
		
		JButton btnmodifierLEtablissement = new JButton("<html><div style='text-align: center;'>Modifier l' etablissement</div></html>");
		btnmodifierLEtablissement.setBounds(24, 3, 140, 97);
		if(role.equals("Administrateur") || role.equals("Administrateur General")) {
		panel_7.add(btnmodifierLEtablissement);
		}
		btnmodifierLEtablissement.setForeground(Color.WHITE);
		btnmodifierLEtablissement.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnmodifierLEtablissement.setFocusPainted(false);
		btnmodifierLEtablissement.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnmodifierLEtablissement.setBackground(panel_7.getBackground());

		btnmodifierLEtablissement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnmodifierLEtablissement.setBackground(new Color(60, 60, 60));
			}@Override
			public void mouseExited(MouseEvent e) {
				btnmodifierLEtablissement.setBackground(panel_7.getBackground());
			}
		});
		
		JButton btnsupprimerLEtablissement = new JButton("<html><div style='text-align: center;'>Supprimer l' etablissement</div></html>");
		btnsupprimerLEtablissement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsupprimerLEtablissement.setBackground(new Color(255, 102, 102));
			}@Override
			public void mouseExited(MouseEvent e) {
				btnsupprimerLEtablissement.setBackground(panel_7.getBackground());
			}
		});
		btnsupprimerLEtablissement.setBounds(189, 3, 140, 97);
		if(role.equals("Administrateur") || role.equals("Administrateur General")) {
		panel_7.add(btnsupprimerLEtablissement);
		}
		btnsupprimerLEtablissement.setHorizontalTextPosition(SwingConstants.CENTER);
		btnsupprimerLEtablissement.setForeground(Color.WHITE);
		btnsupprimerLEtablissement.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnsupprimerLEtablissement.setFocusPainted(false);
		btnsupprimerLEtablissement.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnsupprimerLEtablissement.setBackground(panel_7.getBackground());
		

		btnsupprimerLEtablissement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEstablishment(schoolId);
				UserPanel u = new UserPanel(Login.selectedUserID);
				u.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnmodifierLEtablissement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewEstablishment ne = new NewEstablishment(Login.selectedUserID);
				ne.setVisible(true);
				ne.actualiser.setVisible(true);
				ne.create.setVisible(false);
				ne.name1.setText(UserPanel.getSchoolFullName(Login.selectedSchoolID));
				ne.name2.setText(UserPanel.getSchoolShortName(Login.selectedSchoolID));
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panelYear = new JPanel();
		panelYear.setForeground(new Color(0, 128, 128));
		panelYear.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panelYear);
		panelYear.setLayout(new WrapLayout(1, 20, frame.getHeight()*13/100));
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		

		scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
		
		panelYear.setBackground(new Color(40, 40, 40));
		panelYear.setForeground(new Color(0, 128, 128));
		scrollPane.setViewportView(panelYear);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setPreferredSize(new Dimension(250, 300));
		//panelYear.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Supprimer");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setPreferredSize(new Dimension(89, 30));
		panel_4.add(btnNewButton, BorderLayout.NORTH);
		btnNewButton.setBackground(btnNewButton.getParent().getBackground());
		

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 102, 102));
				
			}@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(btnOuvrir.getParent().getBackground());
			}
		});
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(60, 60, 60));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Ann\u00E9e Scholaire");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setPreferredSize(new Dimension(77, 30));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setBackground(lblNewLabel.getParent().getBackground());
		
		lblNewLabel_1 = new JLabel("2020-2021");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(34, 212, 118));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Futura Hv BT", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_1, BorderLayout.CENTER);
		
		btnOuvrir = new JButton("Ouvrir");
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
		
		panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(250, 300));
		panel_5.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
		panel_5.setBackground(new Color(60, 60, 60));

		if(role.equals("Administrateur") || role.equals("Administrateur General")) {
		panelYear.add(panel_5);
		}
		panel_5.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_1 = new JButton("+");
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
				btnNewButton_1.setBackground(panel_5.getBackground().brighter());
			}@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setForeground(Color.white);
				btnNewButton_1.setBackground(panel_5.getBackground());
			}
		});
		btnNewButton_1.setFont(new Font("Futura Hv BT", Font.BOLD, 99));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);

		panel_5.add(btnNewButton_1, BorderLayout.CENTER);
		btnNewButton_1.setBackground(panel_5.getBackground());
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(screensize.width*33/100, 21));
		panel_3.add(scrollPane_2, BorderLayout.EAST);
		
		loadAcademicYears(schoolId, userId);
		
		 SwingUtilities.invokeLater(() -> {
			 JScrollBar bar = scrollPane.getHorizontalScrollBar();
	          bar.setValue(bar.getMaximum());
				}
		);
	}
	
	public static void loadAcademicYears(String schoolId, String userId) {
		
		for(int i = 0; i< panelYear.getComponentCount()-1;i++) {
			panelYear.remove(i);
			panelYear.revalidate();
			panelYear.repaint();
			
		}

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
						"WHERE AY.school_id = '"+schoolId+"' AND cic.courses_in_classroom_id = UR.courses_in_classroom_id AND AY.ay_id = cic.ay_id AND AY.is_active = 1 AND cic.is_active = 1");
			}
			while(rs.next())
			{
				String id;
				if(UserPanel.selectedRole.equals("Administrateur") || UserPanel.selectedRole.equals("Administrateur General")) {
					id = rs.getString("ay_id");
				}else {
					id = rs.getString("cic.ay_id");
				}
							
							JPanel panel_4 = new JPanel();
						
						panel_4.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
						panel_4.setBackground(new Color(60, 60, 60));
						panel_4.setPreferredSize(new Dimension(250, 300));
						panelYear.add(panel_4, panelYear.getComponentCount()-1);
						panel_4.setLayout(new BorderLayout(0, 0));
						panel_4.setName(id);
						
						JButton btnNewButton = new JButton("Supprimer");
						btnNewButton.setFocusPainted(false);
						btnNewButton.setForeground(new Color(255, 255, 255));
						btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
						
						JLabel lblNewLabel_1 = new JLabel(getAcademicYearName(id));
						lblNewLabel_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_1.setBackground(new Color(34, 212, 118));
						lblNewLabel_1.setOpaque(true);
						lblNewLabel_1.setFont(new Font("Futura Hv BT", Font.PLAIN, 40));
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
								ScholarYears.frame.setVisible(false);
								
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
								ScholarYears.frame.setVisible(false);
								
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
											window.frame.setVisible(true);
								
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

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			}
				
		panelYear.setPreferredSize(new Dimension((panelYear.getComponentCount()+1)*(250+20), frame.getHeight()*13/100+300));
	
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
