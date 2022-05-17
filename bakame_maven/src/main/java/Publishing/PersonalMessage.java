package Publishing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Application.Home;
import Class.NewExam;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

import java.awt.TextArea;
import java.awt.TextComponent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PersonalMessage extends JFrame {

	private JPanel contentPane;
	public static JPanel panel;
	public static JLabel destination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalMessage frame = new PersonalMessage();
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
	public PersonalMessage() {
		setResizable(false);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(0, 202, 434, 253);
		contentPane.add(scrollPane);
		
		JTextArea txtrWriteSomethingHere = new JTextArea();
		txtrWriteSomethingHere.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtrWriteSomethingHere.getText().equals("Ecrivez quelque chose ici")) {
					txtrWriteSomethingHere.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtrWriteSomethingHere.getText().equals("")) {

					txtrWriteSomethingHere.setText("Ecrivez quelque chose ici");
				}
			}
		});
		txtrWriteSomethingHere.setForeground(new Color(255, 255, 255));
		txtrWriteSomethingHere.setCaretColor(new Color(0, 153, 204));
		txtrWriteSomethingHere.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(txtrWriteSomethingHere);
		txtrWriteSomethingHere.setText("Ecrivez quelque chose ici");
		txtrWriteSomethingHere.setLineWrap(true);
		txtrWriteSomethingHere.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Publication personnalisee");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(72, 11, 290, 24);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(10, 72, 414, 119);
		contentPane.add(scrollPane_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		
		destination = new JLabel("Destinataires: 0 eleves");
		destination.setForeground(new Color(255, 255, 255));
		destination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		destination.setBounds(10, 51, 214, 20);
		contentPane.add(destination);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 35, 434, 1);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSelection ss = new StudentSelection();
				ss.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(250, 46, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Envoyer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(10, 466, 194, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnAnnuler.setBorderPainted(false);
		btnAnnuler.setBounds(230, 466, 194, 34);
		contentPane.add(btnAnnuler);
		
		System.out.println(getClassColor(""+Home.className+""));

		
	}
	
	
	public static void loadStudents(List<String> list) {
		List<String> l = new ArrayList();
		for(int i = 0; i<list.toArray().length; i++) {
			List l1 = Arrays.asList(list.get(i).toString().split("//"));
			l.add(l1.get(0).toString());
		}
		for(int k = 0; k< PersonalMessage.panel.getComponentCount(); k++) {
				PersonalMessage.panel.remove(k);
				PersonalMessage.panel.revalidate();
				PersonalMessage.panel.repaint();
			}
		

		for(int j = 0; j< PersonalMessage.panel.getComponentCount(); j++) {
		for(int k = 1; k< ((Container) PersonalMessage.panel.getComponent(j)).getComponentCount(); k++) {
				((Container) PersonalMessage.panel.getComponent(j)).remove(k);
		}}
		
		for(int i = 0 ; i< l.toArray().length; i++) {
			
			boolean alreadyExists = false;
			for(int j = 0; j< PersonalMessage.panel.getComponentCount(); j++) {
				if(PersonalMessage.getStudentSource(l.get(i)).equals(((JLabel) ((Container) PersonalMessage.panel.getComponent(j))
						.getComponent(0)).getText())) {
					alreadyExists = true;
				}
				}
			if(!alreadyExists) {
				JPanel panel_1 = new JPanel();
				panel_1.setPreferredSize(new Dimension(410, 50));
				panel_1.setBackground(new Color(80, 80, 80));
				PersonalMessage.panel.add(panel_1);
				panel_1.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
				JLabel lblNewLabel_2 = new JLabel(PersonalMessage.getStudentSource(l.get(i)));
				lblNewLabel_2.setForeground(Color.white);
				lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 15));
				panel_1.add(lblNewLabel_2);
				PersonalMessage.panel.revalidate();
				PersonalMessage.panel.repaint();
			}}
		
		List<String> students = new ArrayList();
		for(int i = 0 ; i< l.toArray().length; i++) {
		students.add(l.get(i)+"//"+PersonalMessage.getStudentSource(l.get(i)));
		}
		
		for(int i = 0 ; i< students.toArray().length; i++) {
			int index = 0;
			boolean exists = false;
			List<String> parts = Arrays.asList(students.get(i).split("//"));
			for(int j = 0; j< PersonalMessage.panel.getComponentCount(); j++) {
		if(((JLabel) ((Container) PersonalMessage.panel.getComponent(j)).getComponent(0)).getText().equals(parts.get(1))) {
			index = j;
		}
		}
			for(int k = 1; k< ((Container) PersonalMessage.panel.getComponent(index)).getComponentCount(); k++) {
			if(((JLabel) ((Container) ((Container) PersonalMessage.panel.getComponent(index)).getComponent(k)).getComponent(0)).getText()
						.equals(StudentStats.loadStudentNumber(parts.get(0), parts.get(1)))) {
				exists = true;
			}}
		
		if(!exists) {
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tekton Pro Ext", Font.BOLD, 11));
		panel_2.setPreferredSize(new Dimension(30, 30));
		((JPanel) PersonalMessage.panel.getComponent(index)).add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		List<String> s1 = Arrays.asList(PersonalMessage.getClassColor(parts.get(1)).split("//"));
		List<String> s = Arrays.asList(s1.get(0).split(","));
		panel_2.setBackground(new Color(Integer.parseInt(s.get(0)),Integer.parseInt(s.get(1)), Integer.parseInt(s.get(2))));
		
		JLabel lblNewLabel_3 = new JLabel(StudentStats.loadStudentNumber(parts.get(0), parts.get(1)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 15));
		panel_2.add(lblNewLabel_3);
		
		System.out.println(parts.get(1)+"/"+StudentStats.loadStudentNumber(parts.get(0), parts.get(1)));
		
		List<String> colors = Arrays.asList(PersonalMessage.getClassColor(parts.get(1)).split(","));


		List<String> s2 = Arrays.asList(s1.get(1).split(","));
		lblNewLabel_3.setForeground(new Color(Integer.parseInt(s2.get(0)),Integer.parseInt(s2.get(1)), Integer.parseInt(s2.get(2))));
				}}

		destination.setText("Desinataires: "+StudentSelection.selectedStudents.toArray().length+" eleves");

		for(int k = 0; k< PersonalMessage.panel.getComponentCount(); k++) {
			int totalWidth = 0;
			int componentWidth = panel.getComponent(k).getPreferredSize().width;
			for(int j = 0; j<((Container) PersonalMessage.panel.getComponent(k)).getComponentCount(); j++) {
				totalWidth = totalWidth+((Container) PersonalMessage.panel.getComponent(k)).getComponent(j).getPreferredSize().width;
			}
			System.out.println((int) Math.ceil(totalWidth/componentWidth));
			Double number = Math.ceil(totalWidth/(componentWidth-(3*((Container) PersonalMessage.panel.getComponent(k)).getComponentCount())));
			if(number>0) {
				panel.getComponent(k).setPreferredSize(new Dimension(componentWidth, (int) ((number+1)*(30+6))));
			}else {
				panel.getComponent(k).setPreferredSize(new Dimension(componentWidth, 36));
			}
			}
		//System.out.println(l.toArray().length);
		
			
			panel.revalidate();
			panel.repaint();
	}
	
	public static String getStudentSource(String s) {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		String className = null;
		
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = Home.loadActiveClasses(file1.getPath());
		
		for(int i = 0; i< lines1.length; i++) {
			List parts1 = Arrays.asList(lines1[i].toString().split("//"));
			
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+parts1.get(0)+"/Students.txt");
			
			FileReader fr;
			try {
				fr = new FileReader(file);
			
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = Home.loadActiveStudents(file.getPath());
			
			for(int j = 0; j< lines.length; j++) {
				List parts = Arrays.asList(lines[j].toString().split("//"));
				if(s.equals(parts.get(0))) {
					className = parts1.get(0).toString();
				}
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return className;
		
	}
	
public static String getClassColor(String s) {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		String color = null;
		
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = Home.loadActiveClasses(file1.getPath());
		
		for(int i = 0; i< lines1.length; i++) {
			List parts1 = Arrays.asList(lines1[i].toString().split("//"));
			
			if(s.equals(parts1.get(0))) {
				color = parts1.get(1).toString()+"//"+parts1.get(2).toString();
			}
		
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return color;
		
	}
}
