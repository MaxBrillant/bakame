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

public class Punish extends JFrame {

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
	private JScrollPane scrollPane_1;
	public static JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Punish frame = new Punish();
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
	public Punish(String classroom_in_ay_id, String ay_id, List<String> students) {
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
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Education: Umuhoza Chris Koen Michael</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 25));
	lblajoutezLesClasses.setBounds(10, 0, 514, 31);
	contentPane.add(lblajoutezLesClasses);
	
	if(students.toArray().length == 1) {
		lblajoutezLesClasses.setText("Education: "+ students.get(0));
	}else if(students.toArray().length == 0) {
		lblajoutezLesClasses.setText("Education: "+ Home.className);
	}else {
		lblajoutezLesClasses.setText("Education: "+ students.toArray().length+" eleves");
	}
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 534, 12);
	contentPane.add(separator);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 17));
	tabbedPane.setBounds(10, 115, 514, 393);
	contentPane.add(tabbedPane);
	
	JScrollPane scrollPane = new JScrollPane();
	if(students.toArray().length>0) {
	tabbedPane.addTab("Punitions", null, scrollPane, null);
	}
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
	
	scrollPane_1 = new JScrollPane();
	scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	if(students.toArray().length==0 || students.toArray().length==1) {
	tabbedPane.addTab("Historique: Eleves", null, scrollPane_1, null);
	}
	if(students.toArray().length==1) {
		tabbedPane.setTitleAt(1, "Historique: Eleves");
	}else if(students.toArray().length==0) {
		tabbedPane.setTitleAt(0, "Historique: Classe");
	}
	
	panel_2 = new JPanel();
	panel_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panel_2.getComponentCount(); i++) {
				panel_2.getComponent(i).setBackground(new Color(80, 80, 80));
				((Container) panel_2.getComponent(i)).getComponent(2).setVisible(false);
			}
		
		}
	});
	panel_2.setBackground(new Color(40, 40, 40));
	scrollPane_1.setViewportView(panel_2);
	panel_2.setLayout(new WrapLayout(1, 3, 3));
	
	text = new JLabel("<html><div style='text-align: center;'>Veuillez retrancher les points selon les punitions disponibles ci-dessous.</div></html>");
	text.setForeground(Color.WHITE);
	text.setFont(new Font("Roboto", Font.PLAIN, 15));
	text.setBounds(10, 34, 514, 70);
	contentPane.add(text);
	
	

	tabbedPane.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			if(students.toArray().length>0) {
			if(tabbedPane.getComponentCount()>1) {
			if(tabbedPane.getSelectedIndex() == 0) {
				text.setText("<html><div style='text-align: center;'>Veuillez retrancher les points selon les punitions disponibles ci-dessous.</div></html>");
			}else if(tabbedPane.getSelectedIndex() == 1) {
				text.setText("<html><div style='text-align: center;'>Cliquez sur les punitions que vous voulez supprimer ou pardonner.</div></html>");
			}
		}}else {
			text.setText("<html><div style='text-align: center;'>Cliquez sur les punitions que vous voulez supprimer ou pardonner pour toute la classe. "
					+ "Si vous voulez pardonner des eleves individuellement, veuillez double-cliquer.</div></html>");
			
		}
			}
	});
	
	if(students.toArray().length == 0) {

		text.setText("<html><div style='text-align: center;'>Cliquez sur les punitions que vous voulez supprimer ou pardonner pour toute la classe. "
				+ "Si vous voulez pardonner des eleves individuellement, veuillez double-cliquer.</div></html>");
		
	
	}
	
	JButton btnAjouter = new JButton("Ajouter");
	btnAjouter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		NewPunishment np = new NewPunishment("", "");
		np.setVisible(true);
		np.create.setVisible(true);
		np.actualiser.setVisible(false);
		
		}
	});
	btnAjouter.setForeground(Color.WHITE);
	btnAjouter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnAjouter.setFocusPainted(false);
	btnAjouter.setBorderPainted(false);
	btnAjouter.setBackground(new Color(0, 171, 89));
	btnAjouter.setBounds(10, 520, 120, 31);
	if(students.toArray().length>0) {
	contentPane.add(btnAjouter);
	}
	JLabel lblPoints = new JLabel("Points: 36/60");
	lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
	lblPoints.setForeground(Color.LIGHT_GRAY);
	lblPoints.setFont(new Font("Roboto", Font.BOLD, 30));
	lblPoints.setBounds(298, 79, 209, 51);
	if(students.toArray().length==1) {
	contentPane.add(lblPoints);
	}
	setLocationRelativeTo(null);
	loadPunishments(ay_id, students);
	
	if(students.toArray().length==1) {
    	panel_2.removeAll();
    	for(int j = 0; j< Home.terms.toArray().length; j++) {
    		loadIndividualPunishments(students.get(0).toString(), Home.terms.get(j));
		}
    	}else if(students.toArray().length==0) {

        	panel_2.removeAll();
        	for(int j = 0; j< Home.terms.toArray().length; j++) {
        		loadClassPunishments(classroom_in_ay_id, Home.terms.get(j));
    		}
	}
	}
	
	
	

	public static void loadPunishments(String ay_id, List students) {
		panel.removeAll();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments_in_ay AS pia "
					+ "JOIN punishments AS p "
					+ "WHERE p.is_active = 1 AND pia.is_active = 1 AND pia.ay_id = '"+ay_id+"' AND pia.punishment_id = p.punishment_id");
			while(rs.next())
			{
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(500, 25));
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(80, 80, 80));;
			
			JLabel lblNewLabel = new JLabel(rs.getString("p.punishment_name"));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 2, 325, 20);
			lblNewLabel.setForeground(Color.white);
			
			JLabel lblCours = new JLabel(rs.getString("pia.points")+" points");
			lblCours.setHorizontalAlignment(SwingConstants.CENTER);
			lblCours.setFont(new Font("Roboto", Font.PLAIN, 15));
			lblCours.setForeground(Color.white);
			lblCours.setBounds(329, 2, 88, 20);
			
					panel.add(panel_1);
					panel_1.add(lblNewLabel);
					panel_1.add(lblCours);
					
					JButton btnRetirer = new JButton("Retirer");
					btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnRetirer.setIconTextGap(0);
					btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
					btnRetirer.setForeground(Color.WHITE);
					btnRetirer.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnRetirer.setFocusPainted(false);
					btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
					btnRetirer.setBounds(427, 0, 73, 25);
					panel_1.add(btnRetirer);
					btnRetirer.setBackground(btnRetirer.getParent().getBackground());
					btnRetirer.setVisible(false);
					

					btnRetirer.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnRetirer.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							btnRetirer.setBackground(new Color(80, 80, 80));
						}
					});
					

					btnRetirer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String id = UUID.randomUUID().toString();
				    		getInternetDateAndTime.generateTime();
							
							for(int i = 0; i< students.toArray().length; i++) {
					        	int k =i;
								addPunishment(students.get(k).toString(), ((JLabel) btnRetirer.getParent().getComponent(0)).getText(), id, getInternetDateAndTime.onlineTime);
								

						        if(students.toArray().length == 1) {
						        	panel_2.removeAll();
						        	for(int j = 0; j< Home.terms.toArray().length; j++) {
						        		loadIndividualPunishments(students.get(0).toString(), Home.terms.get(j));
						    		}
						        }
							}
						}
					});
					panel_1.addMouseListener(new MouseAdapter() {@Override
						public void mouseClicked(MouseEvent e) {
						for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
							panel_1.getParent().getComponent(i).setBackground(new Color(80, 80, 80));
							((Container) panel_1.getParent().getComponent(i)).getComponent(2).setVisible(false);
						}
						panel_1.setBackground(new Color(20, 142, 192));
						panel_1.getComponent(2).setVisible(true);
						
						if(e.getClickCount()==2) {
							
							NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
							nc.setVisible(true);
							nc.create.setVisible(false);
							nc.actualiser.setVisible(true);
						}
					}
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white, 1));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});

		}
		panel.revalidate();
		panel.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel_2 = new JLabel("Il n'ya actuellement aucune punition dans cet etablissement");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_2);
		}
	}
	
	
	
	public static void loadIndividualPunishments(String student_in_classroom_id, String term_id) {
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments_in_ay AS pia "
					+ "JOIN punishments AS p "
					+ "JOIN punishment_information as pi "
					+ "JOIN student_punishments as sp "
					+ "WHERE p.is_active = 1 AND pia.is_active = 1 AND pia.punishment_id = p.punishment_id AND pia.pia_id = pi.pia_id "
					+ "AND pi.pi_id = sp.pi_id AND pi.term_id = '"+term_id+"' AND sp.sic_id = '"+student_in_classroom_id+"'");
			while(rs.next())
			{
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(500, 25));
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(80, 80, 80));
			panel_1.setName(rs.getString("pi.pi_id"));
			
			JLabel lblNewLabel = new JLabel(rs.getString("p.punishment_name"));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 2, 254, 20);
			lblNewLabel.setForeground(Color.white);
			
					panel_2.add(panel_1);
					panel_1.add(lblNewLabel);
					
					JLabel lblLe = new JLabel(rs.getString("pi.date")+" \u2022 "+rs.getString("pia.points")+" pts");
					lblLe.setHorizontalAlignment(SwingConstants.CENTER);
					lblLe.setForeground(Color.WHITE);
					lblLe.setFont(new Font("Roboto", Font.PLAIN, 15));
					lblLe.setBounds(261, 2, 146, 20);
					panel_1.add(lblLe);
					
					
					JButton btnRetirer = new JButton("Pardonner");
					btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnRetirer.setIconTextGap(0);
					btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
					btnRetirer.setForeground(Color.WHITE);
					btnRetirer.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnRetirer.setFocusPainted(false);
					btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
					btnRetirer.setBounds(417, 0, 83, 25);
					panel_1.add(btnRetirer);
					btnRetirer.setBackground(btnRetirer.getParent().getBackground());
					btnRetirer.setVisible(false);
					

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
							
							forgive(student_in_classroom_id, btnRetirer.getParent().getName());
							loadIndividualPunishments(student_in_classroom_id, term_id);
							
						}
					});
					
					
					panel_1.addMouseListener(new MouseAdapter() {@Override
						public void mouseClicked(MouseEvent e) {
						for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
							panel_1.getParent().getComponent(i).setBackground(new Color(80, 80, 80));
							((Container) panel_1.getParent().getComponent(i)).getComponent(2).setVisible(false);
						}
						panel_1.setBackground(new Color(20, 142, 192));
						panel_1.getComponent(2).setVisible(true);
						
						if(e.getClickCount()==2) {
							
						}
					}
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white, 1));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});

		}
		panel_2.revalidate();
		panel_2.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel_2.getComponentCount() == 0) {

			JLabel lblNewLabel_2 = new JLabel("L'eleve n'a pas encore ete puni.");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_2.add(lblNewLabel_2);
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
	
	
	public static void loadClassPunishments(String classroom_in_ay_id, String term_id) {
		panel_2.removeAll();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments_in_ay AS pia "
					+ "JOIN punishments AS p "
					+ "JOIN punishment_information as pi "
					+ "WHERE p.is_active = 1 AND pia.is_active = 1 AND pia.punishment_id = p.punishment_id AND pia.pia_id = pi.pia_id "
					+ "AND pi.term_id = '"+term_id+"'");
			while(rs.next())
			{

				List students = getPunishedStudents(rs.getString("pi.pi_id"), classroom_in_ay_id);
				

				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setPreferredSize(new Dimension(500, 25));
				panel_3.setBackground(new Color(80, 80, 80));
				panel_2.add(panel_3);
				panel_3.setName(rs.getString("pi.pi_id"));
				
				JLabel label = new JLabel(rs.getString("p.punishment_name"));
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Roboto", Font.PLAIN, 15));
				label.setBounds(10, 2, 207, 20);
				panel_3.add(label);
				
				String eleves = "eleves";
				if(students.toArray().length==1) {
					eleves = "eleve";
				}
				JLabel label_2 = new JLabel(rs.getString("pi.date")+" \u2022 "+students.toArray().length+" "+eleves);
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Roboto", Font.PLAIN, 15));
				label_2.setBounds(219, 2, 162, 20);
				panel_3.add(label_2);
				

				JButton btnToutPardonner = new JButton("Tout Pardonner");
				btnToutPardonner.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnToutPardonner.setIconTextGap(0);
				btnToutPardonner.setHorizontalTextPosition(SwingConstants.CENTER);
				btnToutPardonner.setForeground(Color.WHITE);
				btnToutPardonner.setFont(new Font("Roboto", Font.PLAIN, 13));
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
						
						forgiveAll(className, btnToutPardonner.getParent().getName());
						loadClassPunishments(classroom_in_ay_id, term_id);
						
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
						PunishedStudents ps = new PunishedStudents(panel_3.getName(), classroom_in_ay_id, students);
						ps.setVisible(true);
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
			
			}} catch (SQLException e1) {
			}
		panel_2.revalidate();
		panel_2.repaint();
		if(panel_2.getComponentCount() == 0) {

			JLabel lblNewLabel_2 = new JLabel("Cette classe n'a pas ete encore punie.");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_2.add(lblNewLabel_2);
		}
	}

	public static void addPunishment(String student, String punishment, String ID, String date) {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+student+"/3eme Trimestre/Education.txt");
		
		List <String> comp = new ArrayList();
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
		//getInternetDateAndTime.generateTime();
		
		comp.add(getPunishmentID(punishment)+"//"+ID+"//"+date);
		
		if(file1.exists()) {
			file1.delete();
		}

	try {
		file1.createNewFile();
		PrintWriter pw = new PrintWriter(file1);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	}
	
	
	

	
	public static void forgive(String student, String punishmentID) {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+student+"/3eme Trimestre/Education.txt");
		
		List <String> comp = new ArrayList();
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
			if(l.get(1).toString().equals(punishmentID)) {
				comp.remove(i);
				break;
			}
		}
		
		if(file1.exists()) {
			file1.delete();
		}

	try {
		file1.createNewFile();
		PrintWriter pw = new PrintWriter(file1);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	}
	
	
public static void forgiveAll(String className, String punishmentID) {

	Object[] lines = Home.loadActiveStudents("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
	
	for(int j = 0 ; j< lines.length; j++) {
		List l1 = Arrays.asList(lines[j].toString().split("//"));
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+l1.get(0).toString()+"/3eme Trimestre/Education.txt");
	
		List <String> comp = new ArrayList();
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
			if(l.get(1).toString().equals(punishmentID)) {
				comp.remove(i);
				break;
			}
		}
		
		if(file1.exists()) {
			file1.delete();
		}

	try {
		file1.createNewFile();
		PrintWriter pw = new PrintWriter(file1);

		for(int j1 = 0;j1<comp.toArray().length;j1++) {
		pw.println((String)comp.get(j1));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}
	

	public static String getPunishmentName(String punishment_id) {
		String name = null;
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments "
					+ "WHERE punishment_id =  '"+punishment_id+"'");
			while(rs.next())
			{
				name = rs.getString("punishment_name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}
	
	
	
	

	public static String getPunishmentPoints(String punishment_in_ay_id) {
		String points = null;
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments_in_ay "
					+ "WHERE pia_id =  '"+punishment_in_ay_id+"' LIMIT 1");
			while(rs.next())
			{
				points = rs.getString("points");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return points;
	}

	public static String getPunishmentOriginalId(String punishment_in_ay_id) {
		String id = null;
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishment_information "
					+ "WHERE pia_id =  '"+punishment_in_ay_id+"'");
			while(rs.next())
			{
				id = rs.getString("pia_id");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id;
	}

	public static String getPunishmentDate(String pi_id) {
		String date = null;
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishment_information "
					+ "WHERE pi_id =  '"+pi_id+"'");
			while(rs.next())
			{
				date = rs.getString("date");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return date;
	}

}