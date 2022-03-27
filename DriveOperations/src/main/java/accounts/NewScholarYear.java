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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import CloudOperations.mysql;
import Schedule.TeacherSchedule;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Rectangle;

public class NewScholarYear extends JFrame {

	public static JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JComboBox<String> year1;
	public static JComboBox<String> year2;
	public static JButton create;
	private JLabel notice;
	public static JLabel title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewScholarYear frame = new NewScholarYear("Ecole Internationale de Bujumbura","2021-2022");
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
	public NewScholarYear(String academicYearID, String school_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 400, 279);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	create = new JButton("Ajouter");
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(32, 199, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Ann\u00E9e scholaire:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(78, 97, 228, 31);
	contentPane.add(lblNomDuCours);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 494, 45);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez une nouvelle ann\u00E9e scholaire pour cet \u00E9tablissement</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 370, 40);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			
			if(!yearAlreadyExists(academicYearID)) {
		updateScholarYear(school, sc1, sc2, year1.getSelectedItem().toString(), year2.getSelectedItem().toString());
		setVisible(false);

		SwingUtilities.getRoot(ScholarYears.panelYear).setVisible(false);
					ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
					window.frame.setVisible(true);
			}else{

				if(!yearHasBeenDeleted(academicYearID)) {
				notice.setVisible(true);
				}else {
					restoreScholarYear(academicYearID);
					setVisible(false);
					ScholarYears.loadAcademicYears(Login.selectedSchoolID, Login.selectedUserID);

					SwingUtilities.getRoot(ScholarYears.panelYear).setVisible(false);
								ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
								window.frame.setVisible(true);
							
				}
			}
			
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
	contentPane.add(actualiser);
	
	button = new JButton("Annuler");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(218, 199, 129, 31);
	contentPane.add(button);
	
	title = new JLabel("Nouvelle ann\u00E9e scholaire");
	title.setVerticalTextPosition(SwingConstants.BOTTOM);
	title.setIconTextGap(0);
	title.setHorizontalTextPosition(SwingConstants.CENTER);
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	title.setBounds(0, 46, 384, 28);
	contentPane.add(title);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 74, 494, 12);
	contentPane.add(separator);
	
	year1 = new JComboBox();
	year1.setFont(new Font("Roboto", Font.PLAIN, 20));
	year1.setBounds(102, 139, 80, 22);
	contentPane.add(year1);
	
	year2 = new JComboBox();
	year2.setFont(new Font("Roboto", Font.PLAIN, 20));
	year2.setBounds(209, 139, 80, 22);
	contentPane.add(year2);
	
	JLabel lblNewLabel = new JLabel("-");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 25));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(179, 139, 31, 22);
	contentPane.add(lblNewLabel);
	
	notice = new JLabel("Cette ann\u00E9e scholaire existe d\u00E9j\u00E0");
	notice.setVisible(false);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setBounds(10, 174, 374, 22);
	contentPane.add(notice);

	setLocationRelativeTo(null);
	
	populateBoxes();
	

	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!yearAlreadyExists(academicYearID)) {
		newScholarYear(academicYearID, school_id);
		setVisible(false);

		SwingUtilities.getRoot(ScholarYears.panelYear).setVisible(false);
					ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
					window.frame.setVisible(true);
				
				
			}else{

				if(!yearHasBeenDeleted(academicYearID)) {
				notice.setVisible(true);
				}else {
					restoreScholarYear(academicYearID);
					setVisible(false);
					ScholarYears.loadAcademicYears(Login.selectedSchoolID, Login.selectedUserID);
					

					SwingUtilities.getRoot(ScholarYears.panelYear).setVisible(false);
								ScholarYears window = new ScholarYears(Login.selectedUserID, Login.selectedSchoolID, UserPanel.selectedRole);
								window.frame.setVisible(true);
							
				}
			}}});
	

	year1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(year1.hasFocus()) {
			int i = Integer.parseInt(year1.getSelectedItem().toString())+1;
			year2.setSelectedItem(""+i+"");
		}}
	});
	
	year2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(year2.hasFocus()) {
			int i = Integer.parseInt(year2.getSelectedItem().toString())-1;
			year1.setSelectedItem(""+i+"");
		}}
	});
	}
	
	
	public static void populateBoxes() {
		NewScholarYear.year1.removeAllItems();
		NewScholarYear.year2.removeAllItems();
		
		for(int i = 2021; i< 2050; i++) {
			NewScholarYear.year1.addItem(String.valueOf(i));
			NewScholarYear.year2.addItem(String.valueOf(i));
		}
		year2.addItem("2050");
		year2.removeItemAt(0);
	}
	
	
	public static boolean yearHasBeenDeleted(String academicYearID) {
		boolean exists = false;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from academic_year "
					+ "WHERE ay_id = '"+academicYearID+"' AND is_active = 0");

			int i = 0;
			while(rs.next())
			{
				i++;
			}
			if(i == 1) {
				exists = true;
			}else {
				exists = false;
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return exists;
	}
	
	public static boolean yearAlreadyExists(String academicYearID) {
		boolean exists = false;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from academic_year "
					+ "WHERE ay_id = '"+academicYearID+"'");

			int i = 0;
			while(rs.next())
			{
				i++;
			}
			if(i == 1) {
				exists = true;
			}else {
				exists = false;
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return exists;
	}
	
	
	public static void newScholarYear(String name, String school_id) {

		List<String> comp = new ArrayList();
File file1 = new File("Data/Establishments/"+school+"/Scholar years.txt");
		
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
		comp.add(year1+"////"+year2+"////active");
		
File file11 = new File("Data/Establishments/"+school+"/Scholar years.txt");
		
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
			
File file3 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2);
			
			if(file3.exists()) {
						file3.delete();
					}
					file3.mkdir();
					
					
					File file111 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Classes.txt");
					
					if(file111.exists()) {
								file111.delete();
							}
					
						try {
							file111.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
						File file112 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Punishments.txt");
						
						if(file112.exists()) {
									file112.delete();
								}
						
							try {
								file112.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
						}
						File file1111 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Teachers");
						
						if(file1111.exists()) {
							file1111.delete();
								}
						file1111.mkdir();
						
						File file11111 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Teachers/Teachers.txt");
						
						if(file11111.exists()) {
									file11111.delete();
								}
						
							try {
								file11111.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
						}
							
							File file4 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Backup");
							
							if(file4.exists()) {
								file4.delete();
									}
							file4.mkdir();
							
							File file5 = new File("Data/Establishments/"+school+"/"+year1+"-"+year2+"/Backup/Backup storage.txt");
							
							if(file5.exists()) {
										file5.delete();
									}
							
								try {
									file5.createNewFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
							}
								
	}
	
	public static void updateScholarYear(String school, String oldyear1, String oldyear2, String newyear1, String newyear2) {

		List<String> comp = new ArrayList();
File file1 = new File("Data/Establishments/"+school+"/Scholar years.txt");
		
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
		List l = Arrays.asList(comp.get(i).split("////"));
		if(l.get(0).equals(oldyear1)&& l.get(1).equals(oldyear2)) {
			comp.add(i, newyear1+"////"+newyear2+"////active");
			comp.remove(i+1);
		}
	}
		
File file11 = new File("Data/Establishments/"+school+"/Scholar years.txt");
		
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
			
			File file2 = new File("Data/Establishments/"+school+"/"+oldyear1+"-"+oldyear2);
			
			File file3 = new File("Data/Establishments/"+school+"/"+newyear1+"-"+newyear2);
			
			file2.renameTo(file3);
	}
	
	
	public static void restoreScholarYear(String academicYearID) {

		Statement stmt;
		try {
			stmt = mysql.con.createStatement();
		stmt.executeUpdate("UPDATE academic_year " + 
				"SET is_active = 1"
						+ "' WHERE ay_id = "+academicYearID);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}