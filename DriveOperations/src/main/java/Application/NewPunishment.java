package Application;

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

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Class.Punish;
import Class.Student;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewPunishment extends JFrame {

	public static JPanel contentPane;
	public static JTextField name;
	private JLabel lblNewLabel_1;
	public static JTextField courseName;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static List <String> list = new ArrayList();
	public static boolean isEmpty = false;
	public static JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPunishment frame = new NewPunishment("", "");
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
	public NewPunishment(String punishment, String points) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 318);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 70, 70));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNewLabel = new JLabel("Points a retrancher:");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNewLabel.setBounds(45, 164, 169, 31);
	contentPane.add(lblNewLabel);
	
	name = new JTextField();
	name.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!courseName.getText().isBlank() && !name.getText().isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
			}
		
		}
	});
	name.setBorder(new LineBorder(new Color(128, 128, 128)));
	name.setHorizontalAlignment(SwingConstants.CENTER);
	name.setForeground(new Color(255, 255, 255));
	name.setCaretColor(new Color(0, 204, 255));
	name.setBackground(new Color(40, 40, 40));
	name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	name.setBounds(238, 164, 82, 28);
	contentPane.add(name);
	name.setColumns(10);
	name.setText(points);
	
	JLabel notice = new JLabel("Cette punition existe deja, veuillez la modifier pour continuer");
	notice.setVisible(false);
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(12, 206, 400, 19);
	contentPane.add(notice);
	notice.setVisible(false);
	
	create = new JButton("Ajouter");
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!PunishmentExists(courseName.getText())) {
			addPunishment(courseName.getText(), name.getText());
			setVisible(false);
			if(EducationFrame.contentPane != null) {
				EducationFrame.loadPunishments();
				}
				if(Punish.contentPane != null) {
					List<String> l = new ArrayList();
					for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
						l.add(((JLabel) ((Container) Student.selectedStudents.get(i)).getComponent(2)).getText());
					}
				Punish.loadPunishments(l);
				}
		}else{
			notice.setVisible(true);
		}}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(59, 233, 120, 31);
	contentPane.add(create);
	create.setEnabled(false);
	
	JLabel lblNomDuCours = new JLabel("<html><div style='text-align: center;'>Denomination de la punition:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(10, 95, 204, 41);
	contentPane.add(lblNomDuCours);
	
	courseName = new JTextField();
	courseName.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!courseName.getText().isBlank() && !name.getText().isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
			}
		
		}
	});
	courseName.setBorder(new LineBorder(new Color(128, 128, 128)));
	courseName.setHorizontalAlignment(SwingConstants.CENTER);
	courseName.setForeground(new Color(255, 255, 255));
	courseName.setCaretColor(new Color(0, 204, 255));
	courseName.setBackground(new Color(40, 40, 40));
	courseName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	courseName.setColumns(10);
	courseName.setBounds(216, 108, 198, 28);
	contentPane.add(courseName);
	courseName.setText(punishment);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez une punition en inserant sa denomination, ainsi que le nombre de points a penaliser ou retrancher.</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updateInfo(punishment);
			setVisible(false);
			if(EducationFrame.contentPane != null) {
				EducationFrame.loadPunishments();
				}
				if(Punish.contentPane != null) {

					List<String> l = new ArrayList();
					for(int i = 0; i< Student.selectedStudents.toArray().length; i++) {
						l.add(((JLabel) ((Container) Student.selectedStudents.get(i)).getComponent(2)).getText());
					}
				Punish.loadPunishments(l);
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
		public void actionPerformed(ActionEvent e) {}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(245, 233, 129, 31);
	contentPane.add(button);

	setLocationRelativeTo(null);
	
	}


	public static void addPunishment(String name, String points) {
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Punishments.txt");
		
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

		String id = UUID.randomUUID().toString();
		comp.add(id+"//"+name+"//"+points);
		
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
	

	public static void 	updateInfo(String punishment) {

		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Punishments.txt");
		
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
			if(l.get(1).toString().equals(punishment)) {
				comp.add(i, l.get(0).toString()+"//"+courseName.getText()+"//"+name.getText());
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
	
	
public static void 	deletePunishment(String punishment) {

		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Punishments.txt");
		
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
			if(l.get(1).toString().equals(punishment)) {
				comp.remove(i);
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

public static boolean PunishmentExists(String punishment) {

	boolean p = false;
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Punishments.txt");
	
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
		if(l.get(1).toString().equals(punishment)) {
			p = true;
			break;
		}
	}
	return p;
}
	}