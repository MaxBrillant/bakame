package Publishing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

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
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;

import Application.Home;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentSelection extends JFrame {

	private JPanel contentPane;
	public static List<String> classes = new ArrayList();
	public static List<String> selectedStudents = new ArrayList();
	public static JComboBox comboBox;
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSelection frame = new StudentSelection();
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
	public StudentSelection() {
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
				populateStudentList(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setMaximumRowCount(1000);
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 18));
		comboBox.setBounds(33, 44, 302, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Selectionnez la classe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel.setBounds(53, 11, 263, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectionnezLeleve = new JLabel("Selectionnez les eleves");
		lblSelectionnezLeleve.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnezLeleve.setForeground(Color.WHITE);
		lblSelectionnezLeleve.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblSelectionnezLeleve.setBounds(40, 77, 289, 22);
		contentPane.add(lblSelectionnezLeleve);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< selectedStudents.toArray().length;i++) {
				System.out.println(selectedStudents.get(i));
			}
				PersonalMessage.loadStudents(selectedStudents);
				setVisible(false);
				}
		});
		btnOk.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(33, 518, 135, 32);
		contentPane.add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setBorderPainted(false);
		btnAnnuler.setBounds(200, 518, 135, 32);
		contentPane.add(btnAnnuler);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(5, 103, 359, 404);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 1, 1));
		
		populateClassList();
		populateStudentList(comboBox.getSelectedItem().toString());
	}
	
public static void populateClassList() {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		classes.clear();
		
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = Home.loadActiveClasses(file1.getPath());
		
		classes.add("All");
		for(int i = 0; i< lines1.length; i++) {
			List name = Arrays.asList(lines1[i].toString().split("//"));

			if(StatsPane.hasStudents(name.get(0).toString())) {
			classes.add(name.get(0).toString());
			}
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i< classes.toArray().length; i++) {
			comboBox.addItem(classes.get(i));
		}
	}

public static void populateStudentList(String s) {
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
		
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+s+"/Students.txt");
	
	FileReader fr1;
	try {
		fr1 = new FileReader(file1);
	
	
	BufferedReader br1 = new BufferedReader(fr1);
	Object[] lines1 = Home.loadActiveStudents(file1.getPath());
	
	for(int i = 0; i< lines1.length; i++) {
		List parts = Arrays.asList(lines1[i].toString().split("//"));
		if(parts.get(4).equals("active")) {

		JCheckBox checkBox1 = new JCheckBox(parts.get(0).toString());
		checkBox1.setPreferredSize(new Dimension(350, 23));
		checkBox1.setMargin(new Insets(10, 10, 2, 2));
		checkBox1.setFont(new Font("Roboto", Font.PLAIN, 18));
		checkBox1.setBackground(new Color(60, 60, 60));
		checkBox1.setForeground(Color.white);
		checkBox1.setFocusPainted(false);
		checkBox1.setBorder(null);
		panel.add(checkBox1);
	}}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		if(selectedStudents.contains(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem())) {
			((JCheckBox) panel.getComponent(i)).setSelected(true);
		}
	}
	
	
	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		int k = i;
	((JCheckBox) panel.getComponent(i)).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if( k > 0) {
			if(((JCheckBox) panel.getComponent(k)).isSelected()) {
				selectedStudents.add(((JCheckBox) panel.getComponent(k)).getText()+"//"+comboBox.getSelectedItem());
			}else {
				for(int j = 0; j< selectedStudents.toArray().length; j++) {
					if(selectedStudents.get(j).equals(((JCheckBox) panel.getComponent(k)).getText()+"//"+comboBox.getSelectedItem())) {
						selectedStudents.remove(j);
					}
				}
			}
			}
			else {
				if(((JCheckBox) panel.getComponent(0)).isSelected()) {

					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedStudents.contains(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem())) {
						selectedStudents.remove(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem());
				}}
				for(int i = 1; i< panel.getComponentCount(); i++) {
					selectedStudents.add(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem());
				}
				}else {
					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedStudents.contains(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem())) {
						selectedStudents.remove(((JCheckBox) panel.getComponent(i)).getText()+"//"+comboBox.getSelectedItem());
				}}
				}
			}
			PersonalMessage.loadStudents(selectedStudents);
			PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			
			for(int j = 0; j< selectedStudents.toArray().length; j++) {
				System.out.println(selectedStudents.get(j));
				}
		}
	});
	}
	panel.revalidate();
	panel.repaint();

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
}
