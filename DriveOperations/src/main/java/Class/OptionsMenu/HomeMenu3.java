package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.NewTeacher;
import Application.ResizeImages;
import Application.Teacher;
import Class.Application;
import Class.NewPane;
import Class.NewStudent;
import Class.Student;
import CloudOperations.aws;
import Publishing.NewPublication;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HomeMenu3 extends JPanel {
	
	public static JPanel panel;

	/**
	 * Create the panel.
	 */
	public HomeMenu3(String ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 70));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setBackground(new Color(40, 40, 40));
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JButton add = new JButton("");
		add.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
		panel.add(add);
		Home.addToolTip(add, "Ajouter");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTeacher nt = new NewTeacher();
				nt.setVisible(true);
				nt.actualiser.setVisible(false);
				nt.create.setVisible(true);
	
			}
		});
		
		JButton edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTeacher nt = new NewTeacher();
				nt.setVisible(true);
				nt.actualiser.setVisible(true);
				nt.create.setVisible(false);
				String s = TeacherData(Teacher.selectedTeacher);
				List l = Arrays.asList(s.split("//"));
				List n = Arrays.asList(l.get(0).toString().split("::"));
				nt.name1.setText(n.get(0).toString());
				nt.name2.setText(n.get(1).toString());
				nt.gender.setSelectedIndex(Integer.parseInt(l.get(1).toString()));
				
				if(l.get(2).toString().equals("noPhone")) {
					nt.phone.setText("");
				}else {
					nt.phone.setText(l.get(2).toString());
				}
				
				if(l.get(3).toString().equals("noMail")) {
					nt.mail.setText("");
				}else {
					nt.mail.setText(l.get(3).toString());
				}
			}
		});
		edit.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
		panel.add(edit);
		Home.addToolTip(edit, "Modifier");
		
		JButton delete = new JButton("");
		delete.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		Home.addToolTip(delete, "Supprimer");
		
		JButton publish = new JButton("");
		publish.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
				//Application.publish();
			}
		});
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(50, 50));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(panel.getBackground());
		panel.add(publish);
		Home.addToolTip(publish, "Publier");
		
		JButton button_5 = new JButton("");
		button_5.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_up.png"));
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goUp (Teacher.selectedTeacher);
				Teacher.loadTeachers(ay_id);
			}
		});
		button_5.setPreferredSize(new Dimension(50, 50));
		button_5.setIconTextGap(0);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Roboto", Font.PLAIN, 18));
		button_5.setFocusPainted(false);
		button_5.setBorderPainted(false);
		button_5.setBackground(panel.getBackground());
		panel.add(button_5);
		Home.addToolTip(button_5, "Monter");
		
		JButton button_4 = new JButton("");
		button_4.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_down.png"));
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goDown (Teacher.selectedTeacher);
				Teacher.loadTeachers(ay_id);
			}
		});
		button_4.setPreferredSize(new Dimension(50, 50));
		button_4.setIconTextGap(0);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Roboto", Font.PLAIN, 18));
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setBackground(panel.getBackground());
		panel.add(button_4);
		Home.addToolTip(button_4, "Descendre");
		
		deselect();
		
		
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(panel.getBackground());
				}
				
			});
		}
		
	}

	public static String TeacherData(String teacherName) {
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				List l = Arrays.asList(lines[i].toString().split("//"));
				if(l.get(0).toString().replaceAll("::", " ").equals(teacherName)) {
					s = lines[i].toString();
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return s;
	}
	
	
	public static void goUp (String teacherName) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		for(int i = 0; i< comp.toArray().length; i++) {

			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(teacherName)) {
				comp.add(i-1, comp.get(i));
				comp.remove(i+1);
			}
		
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
	aws.upload(file.getPath());
	}
	public static void goDown (String teacherName) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		for(int i = 0; i< comp.toArray().length; i++) {
			if(i+1 < comp.toArray().length) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(teacherName)) {
				comp.add(i+2, comp.get(i));
				comp.remove(i);
				break;
			}
			}
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
	aws.upload(file.getPath());
	}
	
	public static void deselect() {
		HomeMenu3.panel.getComponent(1).setVisible(false);
		HomeMenu3.panel.getComponent(2).setVisible(false);
		HomeMenu3.panel.getComponent(4).setVisible(false);
		HomeMenu3.panel.getComponent(5).setVisible(false);
	}
}
