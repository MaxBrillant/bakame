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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.Application;
import Class.Course;
import Class.NewPane;
import Class.NewStudent;
import Class.Punish;
import Class.Student;
import CloudOperations.aws;
import Publishing.NewPublication;
import Stats.StatsPane;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

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

public class StudentMenu extends JPanel {
	public static JButton add;
	public static JButton stats;
	public static JButton publish;
	public static JButton retirer;
	public static JButton edit;
	public static JButton delete;
	public static JButton settings2;

	/**
	 * Create the panel.
	 */
	public StudentMenu(String classroom_in_ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(360, 2));
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		//scrollPane.setPreferredSize(new Dimension((int) screensize.getWidth()*0/100, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(37, 37, "Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 14));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		
		stats = new JButton("");
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Student.selectedStudents.toArray().length>0) {
				StatsPane frame = new StatsPane(Student.selectedStudents.get(0).getName(), "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				frame.setVisible(true);
				}else{
					StatsPane frame = new StatsPane("All", "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
					frame.setVisible(true);
				
				}}
		});
		stats.setIcon(ResizeImages.resize(37, 37, "Icons\\stats.png"));
		stats.setPreferredSize(new Dimension(50, 50));
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setIconTextGap(0);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 14));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(panel.getBackground());
		panel.add(stats);
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewStudent nt = new NewStudent(classroom_in_ay_id);
				nt.setVisible(true);
				nt.actualiser.setVisible(true);
				nt.add.setVisible(false);
			}
		});
		edit.setIcon(ResizeImages.resize(37, 37, "Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 14));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
		panel.add(edit);
		
		delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
				deleteStudent(((JLabel) ((Container) Student.selectedStudents.get(i)).getComponent(2)).getText(), Home.className);
				}
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{

		        		NewStudent.load(classroom_in_ay_id);
		        		Application.merite();
		            	 return null;
		            }
		        }.execute();
			}
		});
		delete.setIcon(ResizeImages.resize(37, 37, "Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 14));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		
		retirer = new JButton("");
		retirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> students = new ArrayList();
				for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
					students.add(Student.selectedStudents.get(i).getName());
				}
				Punish p = new Punish(classroom_in_ay_id, Login.selectedAcademicYearID, students);
				p.setVisible(true);
			}
		});
		retirer.setIcon(ResizeImages.resize(37, 37, "Icons\\discipline.png"));
		retirer.setVerticalTextPosition(SwingConstants.BOTTOM);
		retirer.setPreferredSize(new Dimension(50, 50));
		retirer.setIconTextGap(0);
		retirer.setHorizontalTextPosition(SwingConstants.CENTER);
		retirer.setForeground(Color.WHITE);
		retirer.setFont(new Font("Roboto", Font.PLAIN, 14));
		retirer.setFocusPainted(false);
		retirer.setBorder(null);
		retirer.setBackground(panel.getBackground());
		panel.add(retirer);
		
		publish = new JButton("");
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(37, 37, "Icons\\Send.png"));
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			}
		});
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(50, 50));
		publish.setFont(new Font("Roboto", Font.PLAIN, 14));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(panel.getBackground());
		panel.add(publish);
		
		settings2 = new JButton("");
		settings2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settings2.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settings2.setBackground(new Color(60, 60, 60));
			}
			
		});
		settings2.setIcon(ResizeImages.resize(50, 50, "Icons\\settingsicon.png"));
		settings2.setVerticalTextPosition(SwingConstants.BOTTOM);
		settings2.setPreferredSize(new Dimension(100, 100));
		settings2.setIconTextGap(-4);
		settings2.setHorizontalTextPosition(SwingConstants.CENTER);
		settings2.setForeground(Color.WHITE);
		settings2.setFont(new Font("Arial", Font.PLAIN, 19));
		settings2.setFocusPainted(false);
		settings2.setBorder(null);
		settings2.setBackground(panel.getBackground());
		settings2.setBounds(10, 0, 66, 66);
		

		//Application.deselect();
		Home.deselect();
		
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
	
	
	public static void deselect() {
		//Student.isSelected = false;
		stats.setVisible(true);
		edit.setVisible(false);
		delete.setVisible(false);
		settings2.setVisible(false);
		
		}
	
	
	public static void deleteStudent(String studentName, String className) {
	

		List<String> StudentList = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				StudentList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<StudentList.toArray().length; i++) {
			List l = Arrays.asList(StudentList.get(i).split("//"));
			if(l.get(0).toString().replaceAll("::", " ").equals(studentName)) {
				StudentList.add(i, StudentList.get(i).replaceAll("//active", "//deleted"));
				StudentList.remove(i+1);
			}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className+"/Students.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<StudentList.toArray().length;j++) {
			pw.println((String)StudentList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
	}
}
