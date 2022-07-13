package Application;

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
import Class.Punish;
import Class.TestBox;
import CloudOperations.mysql;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class ClassAndCourseSelection extends JFrame {

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
	public ClassAndCourseSelection(String user_id, String ay_id) {
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
				if(classes.toArray().length> 0) {
				populateCourseList(classes.get(comboBox.getSelectedIndex()));
				}}
		});
		comboBox.setMaximumRowCount(1000);
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBox.setBounds(57, 110, 254, 22);
		contentPane.add(comboBox);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>0) {
				save(user_id, userID);
				changeRoles(user_id, userID, "Editor");
				//PersonalMessage.loadStudents(selectedStudents);
				setVisible(false);
				Users.loadUsers(user_id, Login.selectedUserID);
				}else {
				selectedCourses.clear();
				save(user_id, userID);
				changeRoles(user_id, userID, "administrator");
				setVisible(false);
				Users.loadUsers(user_id, Login.selectedUserID);
				}
				}
		});
		btnOk.setFont(new Font("Roboto", Font.BOLD, 14));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(147, 519, 101, 30);
		contentPane.add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Roboto", Font.BOLD, 14));
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setBorderPainted(false);
		btnAnnuler.setBounds(258, 519, 101, 30);
		contentPane.add(btnAnnuler);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 14));
		tabbedPane.setBounds(10, 149, 349, 358);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Cours", null, scrollPane, null);
		scrollPane.setBorder(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		tabbedPane.addTab("Selections", null, scrollPane_1, null);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for(int i = 0; i<panel_1.getComponentCount(); i++) {
					panel_1.getComponent(i).setBackground(new Color(60, 60, 60));
					((Container) panel_1.getComponent(i)).getComponent(1).setVisible(false);
					((Container) panel_1.getComponent(i)).getComponent(0).setBackground(panel_1.getComponent(i).getBackground());
					((Container) panel_1.getComponent(i)).getComponent(1).setBackground(panel_1.getComponent(i).getBackground());
				}
			
			}
		});
		panel_1.setBackground(new Color(40, 40, 40));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new WrapLayout(1, 1, 1));
		
		JLabel lblNdashimyeMaxBrillant = new JLabel("Selection des classes et cours");
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNdashimyeMaxBrillant.setBounds(10, 0, 349, 33);
		contentPane.add(lblNdashimyeMaxBrillant);
		
		JLabel notice = new JLabel("<html><div style='text-align: center;'>Selectionnez les classes et specifiez les cours que l' utilisateur pourra voir et editer (modifier).</div></html>");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setForeground(new Color(211, 211, 211));
		notice.setFont(new Font("Roboto", Font.PLAIN, 14));
		notice.setBounds(10, 34, 349, 44);
		contentPane.add(notice);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(0, 33, 369, 1);
		contentPane.add(separator);
		
		JLabel lblSelectionnezLaClasse = new JLabel("Selectionnez la classe:");
		lblSelectionnezLaClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnezLaClasse.setForeground(Color.WHITE);
		lblSelectionnezLaClasse.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblSelectionnezLaClasse.setBounds(40, 85, 289, 22);
		contentPane.add(lblSelectionnezLaClasse);
		
		

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex()==1) {
					tabbedPane.setBounds(10, 89, 349, 418);
					notice.setText("<html><div style='text-align: center;'>Ceci est la liste des classes et cours selectionnes. Cliquez sur \"retirer\" pour enlever un cours de la liste.</div></html>");
					comboBox.setVisible(false);
					lblSelectionnezLaClasse.setVisible(false);
					populateSelectedList();
				}if(tabbedPane.getSelectedIndex()==0) {
					tabbedPane.setBounds(10, 149, 349, 358);
					notice.setText("<html><div style='text-align: center;'>Selectionnez les classes et specifiez les cours que l' utilisateur pourra voir et editer (modifier).</div></html>");
					comboBox.setVisible(true);
					lblSelectionnezLaClasse.setVisible(true);
					if(classes.toArray().length> 0 && comboBox.getSelectedIndex()>=0) {
					populateCourseList(classes.get(comboBox.getSelectedIndex()));
				}}
			}
		});
		
		
		
		load(user_id, ay_id);
		populateClassList(ay_id);
		populateCourseList(classes.get(comboBox.getSelectedIndex()));
		populateSelectedList();
	}
	
public static void populateClassList(String ay_id) {
	comboBox.removeAllItems();
	Object[] lines1 = Home.loadActiveClasses(ay_id);
	
	for(int i = 0; i< lines1.length; i++) {
		comboBox.addItem(Home.getClassName(lines1[i].toString()));
		classes.add(lines1[i].toString());
	}
	comboBox.setSelectedIndex(0);
}


public static void populateCourseList(String classroom_in_ay_id) {
	panel.removeAll();
		
	Object[] lines1 = Home.loadActiveCourses(classroom_in_ay_id);
	
	for(int i = 0; i< lines1.length; i++) {
		
		JCheckBox checkBox1 = new JCheckBox(TestBox.getFullName(lines1[i].toString()));
		checkBox1.setName(lines1[i].toString());
		checkBox1.setIconTextGap(10);
		checkBox1.setPreferredSize(new Dimension(340, 25));
		checkBox1.setMargin(new Insets(10, 10, 2, 2));
		checkBox1.setFont(new Font("Roboto", Font.PLAIN, 14));
		checkBox1.setBackground(new Color(60, 60, 60));
		checkBox1.setForeground(Color.white);
		checkBox1.setFocusPainted(false);
		checkBox1.setBorder(null);
		panel.add(checkBox1);
		
		if(selectedCourses.contains(lines1[i].toString())) {
			checkBox1.setSelected(true);
		}
		
		
	checkBox1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if((checkBox1).isSelected()) {
				selectedCourses.add((checkBox1).getName());
			}else {
					if(selectedCourses.contains((checkBox1).getName())) {
						selectedCourses.remove((checkBox1).getName());
					}
			}
			//populateSelectedList();
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
		}
	});
	
	
	
		}
	panel.revalidate();
	panel.repaint();

	}

public static void populateSelectedList() {
	panel_1.removeAll();
	for(int i = 0; i< selectedCourses.toArray().length; i++) {
		
		JPanel panel_3 = new JPanel();
		panel_3.setName(selectedCourses.get(i));
		panel_3.setPreferredSize(new Dimension(340, 25));
		panel_3.setBackground(new Color(60, 60, 60));;
		
		panel_1.add(panel_3);
				panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();
		panel_3.add(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
		panel2.setBackground(panel2.getParent().getBackground());
		
		JLabel label = new JLabel(Home.getClassName(Home.getClassroomOfCourse(selectedCourses.get(i))));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		label.setBounds(10, 2, 207, 20);
		panel2.add(label);
		
		
		JLabel label1 = new JLabel("-");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel2.add(label1);
		
		
		JLabel label_2 = new JLabel(TestBox.getShortName(selectedCourses.get(i)));
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
		
		
		JButton btnRetirer = new JButton("Retirer");
		btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRetirer.setForeground(Color.WHITE);
		btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnRetirer.setFocusPainted(false);
		btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnRetirer.setPreferredSize(new Dimension(60, 25));
		panel_4.add(btnRetirer);
		btnRetirer.setBackground(btnRetirer.getParent().getBackground());
		
		
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
				selectedCourses.remove((panel_3).getName());
				populateSelectedList();
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
	panel_1.revalidate();
	panel_1.repaint();
	if(panel_1.getComponentCount() == 0) {
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucune classe et aucun cours n'ont ete selectionnes.</div></html>");
		lblNewLabel.setPreferredSize(new Dimension(330, 50));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblNewLabel, 0);
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



public static void load(String user_id, String ay_id) {
	selectedCourses.clear();
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from user_course_control AS ucc "
				+ "JOIN classrooms_in_ay AS cia "
				+ "JOIN courses_in_classroom AS cic "
				+ "WHERE ucc.user_id = '"+user_id+"' AND ucc.courses_in_classroom_id = cic.courses_in_classroom_id AND cia.cia_id = cic.cia_id AND cia.ay_id = '"+ay_id+"' AND cia.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
				selectedCourses.add(rs.getString("ucc.courses_in_classroom_id"));
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
