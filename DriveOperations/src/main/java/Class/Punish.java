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
	setBounds(100, 100, 450, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
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
	btnFermer.setBounds(295, 519, 129, 31);
	contentPane.add(btnFermer);
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Education: Umuhoza Chris Koen Michael</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 414, 33);
	contentPane.add(lblajoutezLesClasses);
	
	if(students.toArray().length == 1) {
		lblajoutezLesClasses.setText("Education: "+ Home.getStudentName(students.get(0)));
	}else if(students.toArray().length == 0) {
		lblajoutezLesClasses.setText("Education: "+ Home.getClassName(classroom_in_ay_id));
	}else {
		lblajoutezLesClasses.setText("Education: "+ students.toArray().length+" eleves");
	}
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 17));
	tabbedPane.setBounds(10, 109, 414, 399);
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
				if(!(panel_2.getComponent(i) instanceof JLabel)) {
				panel_2.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panel_2.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panel_2.getComponent(i)).getComponent(0).setBackground(panel_2.getComponent(i).getBackground());
				((Container) panel_2.getComponent(i)).getComponent(1).setBackground(panel_2.getComponent(i).getBackground());
			}}
		}
	});
	panel_2.setBackground(new Color(40, 40, 40));
	scrollPane_1.setViewportView(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	text = new JLabel("<html><div style='text-align: center;'>Veuillez retrancher les points selon les punitions disponibles ci-dessous.</div></html>");
	text.setHorizontalAlignment(SwingConstants.CENTER);
	text.setForeground(new Color(211, 211, 211));
	text.setFont(new Font("Roboto", Font.PLAIN, 14));
	text.setBounds(10, 34, 403, 54);
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
	JLabel lblPoints = new JLabel("Points: 36/60");
	lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
	lblPoints.setForeground(new Color(255, 255, 255));
	lblPoints.setFont(new Font("Roboto", Font.BOLD, 20));
	lblPoints.setBounds(270, 78, 154, 31);
	contentPane.add(lblPoints);
	if(students.toArray().length==1) {
		lblPoints.setVisible(true);
	}else {
		lblPoints.setVisible(false);
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
				panel_1.setName(rs.getString("p.punishment_id"));
				panel_1.setPreferredSize(new Dimension(390, 25));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
						panel_2.setBackground(panel_2.getParent().getBackground());
						
						JLabel lblNewLabel = new JLabel(rs.getString("p.punishment_name"));
						panel_2.add(lblNewLabel);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(Color.white);
						
						JLabel label = new JLabel("-");
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setForeground(Color.WHITE);
						label.setFont(new Font("Roboto", Font.PLAIN, 14));
						panel_2.add(label);
						
						JLabel lblCours = new JLabel(rs.getString("pia.points")+" points");
						panel_2.add(lblCours);
						lblCours.setHorizontalAlignment(SwingConstants.CENTER);
						lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblCours.setForeground(Color.white);
					
					JPanel panel_3 = new JPanel();
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					panel_3.setVisible(false);

					panel_3.setBackground(panel_3.getParent().getBackground());
					
					
					JButton btnRetirer = new JButton("Retirer");
					btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
					btnRetirer.setForeground(Color.WHITE);
					btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
					btnRetirer.setFocusPainted(false);
					btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
					btnRetirer.setPreferredSize(new Dimension(70, 25));
					panel_3.add(btnRetirer);
					btnRetirer.setBackground(btnRetirer.getParent().getBackground());
					

					btnRetirer.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnRetirer.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							btnRetirer.setBackground(btnRetirer.getParent().getBackground());
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
					panel_2.addMouseListener(new MouseAdapter() {@Override
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
		panel.revalidate();
		panel.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'ya actuellement aucune punition dans cet etablissement</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel, 0);
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
				
				
				
				
				JPanel panel_3 = new JPanel();
				panel_3.setName(rs.getString("sp.id"));
				panel_3.setPreferredSize(new Dimension(390, 25));
				panel_3.setBackground(new Color(60, 60, 60));;
				
						panel_2.add(panel_3);
						panel_3.setLayout(new BorderLayout(0, 0));
				
				JPanel panel2 = new JPanel();
				panel_3.add(panel2);
				panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
				panel2.setBackground(panel2.getParent().getBackground());
				
				JLabel label = new JLabel(rs.getString("p.punishment_name"));
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Roboto", Font.PLAIN, 14));
				label.setBounds(10, 2, 207, 20);
				panel2.add(label);
				
				JLabel label1 = new JLabel("-");
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				label1.setForeground(Color.WHITE);
				label1.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel2.add(label1);
				
				JLabel label_2 = new JLabel(rs.getString("pi.date")+" \u2022 "+rs.getString("pia.points")+" pts");
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
							
							forgive(student_in_classroom_id, btnRetirer.getParent().getName());
							loadIndividualPunishments(student_in_classroom_id, term_id);
							
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
		panel_2.revalidate();
		panel_2.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel_2.getComponentCount() == 0) {
			
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>L'eleve n'a pas encore ete puni.</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel_2.add(lblNewLabel, 0);
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
				panel_3.setName(rs.getString("pi.pi_id"));
				panel_3.setPreferredSize(new Dimension(390, 25));
				panel_3.setBackground(new Color(60, 60, 60));;
				
						panel_2.add(panel_3);
						panel_3.setLayout(new BorderLayout(0, 0));
				
				JPanel panel2 = new JPanel();
				panel_3.add(panel2);
				panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
				panel2.setBackground(panel2.getParent().getBackground());
				
				JLabel label = new JLabel(rs.getString("p.punishment_name"));
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Roboto", Font.PLAIN, 14));
				label.setBounds(10, 2, 207, 20);
				panel2.add(label);
				
				JLabel label1 = new JLabel("-");
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				label1.setForeground(Color.WHITE);
				label1.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel2.add(label1);
				
				String eleves = "eleves";
				if(students.toArray().length==1) {
					eleves = "eleve";
				}
				JLabel label_2 = new JLabel(rs.getString("pi.date")+" \u2022 "+students.toArray().length+" "+eleves);
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
				
				
				JButton btnRetirer = new JButton("Tout pardonner");
				btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
				btnRetirer.setForeground(Color.WHITE);
				btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnRetirer.setFocusPainted(false);
				btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
				btnRetirer.setPreferredSize(new Dimension(110, 25));
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
						
						forgiveAll(className, btnRetirer.getParent().getName());
						loadClassPunishments(classroom_in_ay_id, term_id);
						
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
					
				
					
					if(e.getClickCount()==2) {
						PunishedStudents ps = new PunishedStudents(panel_3.getName(), classroom_in_ay_id, students);
						ps.setVisible(true);
					}
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
			
			}} catch (SQLException e1) {
			}
		panel_2.revalidate();
		panel_2.repaint();
		if(panel_2.getComponentCount() == 0) {


			
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Cette classe n'a pas ete encore punie.</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel_2.add(lblNewLabel, 0);
		}
	}
	
public static String getStudentPunishment(String pi_id, String student_in_classroom_id) {
		
	String id = null;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from student_punishments "
					+ "WHERE pi_id = '"+pi_id+"' AND sic_id = '"+student_in_classroom_id+"'");
			while(rs.next())
			{
				id = rs.getString("id");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id;
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