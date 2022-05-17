package accounts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Stats.StatsPane;
import Stats.StudentStats;
import app.WrapLayout;
import Application.Class;

import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;

import Application.Home;
import Class.TestBox;
import CloudOperations.mysql;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class ClassName extends JFrame {

	private JPanel contentPane;
	public static List<String> classes = new ArrayList();
	public static List<String> selectedCourses = new ArrayList();
	public static JComboBox comboBox;
	public static JPanel panel;
	public static JPanel panel_1;

	/**s
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassName frame = new ClassName("44878bff-9645-4b70-b6a3-996905cb9402", "82d42940-abbb-4247-afd0-6b6eae662db6");
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
	public ClassName(String schoolID, String userID) {
		setResizable(false);
		setBounds(100, 100, 385, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				populateCourseList(classes.get(comboBox.getSelectedIndex()+1));
			}
		});
		comboBox.setMaximumRowCount(1000);
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 18));
		comboBox.setBounds(33, 106, 302, 22);
		contentPane.add(comboBox);
		
		JLabel select = new JLabel("Selectionnez les cours");
		select.setHorizontalAlignment(SwingConstants.CENTER);
		select.setForeground(Color.WHITE);
		select.setFont(new Font("Roboto", Font.PLAIN, 18));
		select.setBounds(40, 130, 289, 22);
		contentPane.add(select);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>0) {
				save(schoolID, userID);
				changeRoles(schoolID, userID, "Editor");
				//PersonalMessage.loadStudents(selectedStudents);
				setVisible(false);
				Users.loadUsers(schoolID, Login.selectedUserID);
				}else {
				selectedCourses.clear();
				save(schoolID, userID);
				changeRoles(schoolID, userID, "administrator");
				setVisible(false);
				Users.loadUsers(schoolID, Login.selectedUserID);
				}
				}
		});
		btnOk.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(33, 518, 135, 32);
		contentPane.add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setBorderPainted(false);
		btnAnnuler.setBounds(200, 518, 135, 32);
		contentPane.add(btnAnnuler);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex()==1) {
					comboBox.setVisible(false);
					select.setVisible(false);
				}if(tabbedPane.getSelectedIndex()==0) {
					comboBox.setVisible(true);
					select.setVisible(true);
					
				}
			}
		});
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 15));
		tabbedPane.setBounds(5, 152, 359, 355);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Cours", null, scrollPane, null);
		scrollPane.setBorder(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 1, 1));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		tabbedPane.addTab("Selections", null, scrollPane_1, null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(40, 40, 40));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new WrapLayout(1, 1, 1));
		
		JLabel lblNdashimyeMaxBrillant = new JLabel(Login.getUserName(userID));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNdashimyeMaxBrillant.setBounds(5, 11, 359, 22);
		contentPane.add(lblNdashimyeMaxBrillant);
		
		JLabel lblsele = new JLabel("<html><div style='text-align: center;'>Selectionnez les classes et specifiez les cours que l' utilisateur pourra voir et editer (modifier).</div></html>");
		lblsele.setHorizontalAlignment(SwingConstants.CENTER);
		lblsele.setForeground(Color.WHITE);
		lblsele.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblsele.setBounds(10, 33, 349, 65);
		contentPane.add(lblsele);

		load(schoolID, userID);
		populateClassList(Login.selectedAcademicYearID);
		populateCourseList(classes.get(comboBox.getSelectedIndex()+1));
		populateSelectedList();
	}
	
public static void populateClassList(String ay_id) {
	
	classes.clear();
	
	Object[] lines1 = Home.loadActiveClasses(ay_id);
	
	classes.add("Administrateur");
	for(int i = 0; i< lines1.length; i++) {
		if(StatsPane.hasStudents(lines1[i].toString())) {
		classes.add(lines1[i].toString());
		}
	}
	for(int i = 0; i< classes.toArray().length; i++) {
		comboBox.addItem(Class.getClassName(classes.get(i)));
	}
	
	


	List<String> comp = new ArrayList();
	for(int i = 0; i< classes.toArray().length; i++) {
		comp.add(classes.get(i));
	}
	if(selectedCourses.toArray().length>0) {
		if(comp.contains(getClassroomId(selectedCourses.get(0)))) {
			comboBox.setSelectedItem(Class.getClassName(getClassroomId(selectedCourses.get(0))));
		}
	}
}


public static void populateCourseList(String classroom_in_ay_id) {
	panel.removeAll();
	
	if(comboBox.getSelectedIndex()!=0) {

		JCheckBox checkBox = new JCheckBox("All");
		checkBox.setPreferredSize(new Dimension(350, 23));
		checkBox.setMargin(new Insets(10, 10, 2, 2));
		checkBox.setFont(new Font("Roboto", Font.PLAIN, 18));
		checkBox.setBackground(new Color(60, 60, 60));
		checkBox.setForeground(Color.white);
		checkBox.setFocusPainted(false);
		checkBox.setBorder(null);
		panel.add(checkBox);
		
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					selectAll();
				}	else {
					deselectAll();
				}
				
			}
		});
		
	Object[] lines1 = Home.loadActiveCourses(classroom_in_ay_id);
	
	for(int i = 0; i< lines1.length; i++) {

		JCheckBox checkBox1 = new JCheckBox(TestBox.getFullName(lines1[i].toString()));
		checkBox1.setPreferredSize(new Dimension(350, 23));
		checkBox1.setMargin(new Insets(10, 10, 2, 2));
		checkBox1.setFont(new Font("Roboto", Font.PLAIN, 18));
		checkBox1.setBackground(new Color(60, 60, 60));
		checkBox1.setForeground(Color.white);
		checkBox1.setFocusPainted(false);
		checkBox1.setBorder(null);
		panel.add(checkBox1);
		checkBox1.setName(lines1[i].toString());
	}
}
	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		if(selectedCourses.contains(((JCheckBox) panel.getComponent(i)).getName())) {
			((JCheckBox) panel.getComponent(i)).setSelected(true);
		}
	}
	
	
	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		int k = i;
	((JCheckBox) panel.getComponent(i)).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if( k > 0) {
			if(((JCheckBox) panel.getComponent(k)).isSelected()) {
				selectedCourses.add(((JCheckBox) panel.getComponent(k)).getName());
			}else {
				for(int j = 0; j< selectedCourses.toArray().length; j++) {
					if(selectedCourses.get(j).equals(((JCheckBox) panel.getComponent(k)).getName())) {
						selectedCourses.remove(j);
					}
				}
			}
			}
			else {
				if(((JCheckBox) panel.getComponent(0)).isSelected()) {

					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedCourses.contains(((JCheckBox) panel.getComponent(i)).getName())) {
							selectedCourses.remove(((JCheckBox) panel.getComponent(i)).getName());
				}}
				for(int i = 1; i< panel.getComponentCount(); i++) {
					selectedCourses.add(((JCheckBox) panel.getComponent(i)).getName());
				}
				}else {
					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedCourses.contains(((JCheckBox) panel.getComponent(i)).getName())) {
							selectedCourses.remove(((JCheckBox) panel.getComponent(i)).getName());
				}}
				}
			}
			populateSelectedList();
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			
			for(int j = 0; j< selectedCourses.toArray().length; j++) {
				System.out.println(selectedCourses.get(j));
				}
		}
	});
	}
	panel.revalidate();
	panel.repaint();

	}


private static String getCourseId(String courses_in_classroom_id) {
	String id = null;
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * FROM courses_in_classroom "
				+ "WHERE is_active = 1 AND courses_in_classroom_id = '"+courses_in_classroom_id+"' LIMIT 1");
		while(rs.next())
		{
				id = rs.getString("course_id");
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}

	return id;
}


private static String getClassroomId(String courses_in_classroom_id) {
	String id = null;
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * FROM courses_in_classroom "
				+ "WHERE is_active = 1 AND courses_in_classroom_id = '"+courses_in_classroom_id+"' LIMIT 1");
		while(rs.next())
		{
				id = rs.getString("classroom_id");
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}

	return id;
}

public static void populateSelectedList() {
	panel_1.removeAll();
	for(int i = 0; i< selectedCourses.toArray().length; i++) {
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(350, 30));
		panel_2.setBackground(new Color(85, 85, 85));
		panel_1.add(panel_2);
		
		JLabel lblemePfEconomique = new JLabel(Class.getClassName(getClassroomId(selectedCourses.get(i))));
		lblemePfEconomique.setForeground(Color.WHITE);
		lblemePfEconomique.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblemePfEconomique.setBounds(5, 0, 181, 30);
		panel_2.add(lblemePfEconomique);
		
		JLabel lblFormationPatriotiqueEt = new JLabel(TestBox.getShortName(getCourseId(selectedCourses.get(i))));
		lblFormationPatriotiqueEt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormationPatriotiqueEt.setForeground(Color.WHITE);
		lblFormationPatriotiqueEt.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblFormationPatriotiqueEt.setBounds(185, 0, 165, 30);
		panel_2.add(lblFormationPatriotiqueEt);
		
	
	}
}

public static void selectAll() {
	for(int i =1; i< panel.getComponentCount(); i++) {
		((JCheckBox) panel.getComponent(i)).setSelected(true);
	}
}public static void deselectAll() {
	for(int i =1; i< panel.getComponentCount(); i++) {
		((JCheckBox) panel.getComponent(i)).setSelected(false);
	}
}



public static void load(String school_id, String user_id) {
	selectedCourses.clear();
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * FROM users_in_schools as uis "
				+ "JOIN user_responsability AS ur "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses_in_classroom as cic "
				+ "JOIN courses AS co "
				+ "JOIN academic_years AS ay "
				+ "WHERE uis.school_id = '"+school_id+"' AND uis.user_id = '"+user_id+"' AND uis.us_id = ur.us_id AND "
						+ "cic.courses_in_classroom_id = ur.courses_in_classroom_id AND c.is_active = 1 AND c.classroom_id = cic.classroom_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cic.ay_id = ay.ay_id AND ay.is_active = 1 "
						+ "AND cic.is_active = 1 AND co.is_active = 1 AND co.course_id = cic.course_id");
		while(rs.next())
		{
				selectedCourses.add(rs.getString("cic.courses_in_classroom_id"));
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
}



public static void save(String schoolID, String userID) {
	File file = new File("Data/Establishments/"+schoolID+"/Roles.txt");
	List<String> comp = new ArrayList();

	try {
		
		FileReader fr11 = new FileReader(file);
		
		BufferedReader br11 = new BufferedReader(fr11);
		Object[] lines11 = br11.lines().toArray();
		
		for(int i = 0; i< lines11.length; i++) {
			comp.add(lines11[i].toString());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	boolean exists = false;
	for(int i = 0; i< comp.toArray().length; i++) {
		List l = Arrays.asList(comp.get(i).split("//"));
		if(l.get(0).toString().equals(userID)) {
			if(selectedCourses.toArray().length>0) {
			exists = true;
			String s = userID;
			for(int j = 0; j<selectedCourses.toArray().length; j++) {
				s = s+"//"+selectedCourses.get(j).replaceAll("//", "::");
		}
			comp.add(i, s);
			comp.remove(i+1);
			}else {
				comp.remove(i);
			}
		}
	}
	if(!exists) {
		String s = userID;
		for(int j = 0; j<selectedCourses.toArray().length; j++) {
			s = s+"//"+selectedCourses.get(j).replaceAll("//", "::");
	}
		comp.add(s);
	}
	if(file.exists()) {
				file.delete();
			}
	
		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);

			for(int j = 0;j<comp.toArray().length;j++) {
			pw.println((String)comp.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
}
public static void changeRoles(String schoolID, String userID, String role) {

File file1 = new File("Data/Establishments/"+schoolID+"/Users.txt");
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
}for(int i = 0; i<comp.toArray().length; i++) {
	List l = Arrays.asList(comp.get(i).toString().split("//")); 
	if(l.get(0).toString().equals(userID)) {
		String s = l.get(0).toString()+"//"+role;
		comp.add(i, s);
		comp.remove(i+1);
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
}
