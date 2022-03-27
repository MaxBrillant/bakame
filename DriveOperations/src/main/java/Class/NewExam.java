package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.General;
import app.LPane;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import Application.Home;
import Application.ResizeImages;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewExam extends JFrame {

	public static JPanel contentPane;
	public static JLabel name;
	public static JButton add;
	public static JButton annuler;
	public static JLabel interro;
	public static JLabel cours;
	public static JButton skip;
	public static JButton right;
	public static JButton left;
	public static int n;
	public static int displayedSerie = 0;
	public static JLabel num;
	public static JPanel panel;
	public static JScrollPane scrollPane;
	public static JLabel Total;
	private JPanel panel_2;
	private JButton up;
	private JSeparator separator_2;
	public static JLabel series;
	private JButton down;
	private JPanel panel_3;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewExam frame = new NewExam();
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
	public NewExam() {
		setBackground(new Color(40, 40, 40));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		setTitle("New Test");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 400, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		right = new JButton("");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
				aws.downloadContent(file.getPath());
			FileReader fr;
			try {
				fr = new FileReader(file);
			
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = Home.loadActiveStudents(file.getPath());

			if(n<lines.length-1) {
				n++;
			}else{
				n = 0;
			}
			Animations.scrollRight();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		right.setFocusPainted(false);
		right.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		right.setBorderPainted(false);
		right.setBackground(Color.GRAY);
		right.setBounds(313, 21, 61, 55);
		contentPane.add(right);
		
		left = new JButton("");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
				aws.downloadContent(file.getPath());
				FileReader fr;
				try {
					fr = new FileReader(file);
				
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = Home.loadActiveStudents(file.getPath());
				
				if(n>0) {
					n--;
				}else{
					n = lines.length-1;
				}
				Animations.scrollLeft();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					 }
				 ((Component) ((Container) panel.getComponent(displayedSerie)).getComponent(2)).requestFocus();
			}
		});
		left.setFocusPainted(false);
		left.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		left.setBorderPainted(false);
		left.setBackground(Color.GRAY);
		left.setBounds(10, 21, 61, 55);
		contentPane.add(left);
		
		panel_4 = new JPanel();
		panel_4.setBackground(contentPane.getBackground());
		panel_4.setBounds(0, 11, 384, 95);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		num = new JLabel("154");
		num.setBounds(165, 49, 54, 23);
		panel_4.add(num);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(new Color(127, 255, 212));
		num.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		
		name = new JLabel("Dushime Sylvio");
		name.setBounds(0, 0, 384, 95);
		panel_4.add(name);
		name.setIconTextGap(10);
		name.setForeground(new Color(255, 255, 255));
		name.setVerticalTextPosition(SwingConstants.BOTTOM);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		name.setIcon(ResizeImages.resize(65, 65, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\student.png"));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		
		add = new JButton("Suivant");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayedSerie ++;
				saveExams();
				 
				 if(displayedSerie == panel.getComponentCount()){

					 displayedSerie = 0;
					 down.setEnabled(false);
						File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
						aws.downloadContent(file.getPath());
					FileReader fr;
					try {
						fr = new FileReader(file);
					
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines = Home.loadActiveStudents(file.getPath());
					
					if(n<lines.length-1) {
						n++;
					}else{
						n = 0;
					}
					Animations.scrollRight();
					
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(panel.getComponentCount()>1){
						 down.setEnabled(true);
						 up.setEnabled(false);
					 }else {
						 down.setEnabled(false);
						 up.setEnabled(false);
					 }
				 }else if(displayedSerie!=0 && displayedSerie+1 < panel.getComponentCount()){
					 down.setEnabled(true);
					 up.setEnabled(true);
					 Animations.scrollDown();
				 }else{
					 down.setEnabled(false);
					 up.setEnabled(true);
					 Animations.scrollDown();
				 }
				 series.setText(displayedSerie+1+"/"+panel.getComponentCount());
				 }

		});
		add.setFocusPainted(false);
		add.setBorderPainted(false);
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(0, 171, 89));
		add.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		add.setBounds(10, 327, 111, 31);
		contentPane.add(add);
		
		annuler = new JButton("Arreter");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
				setVisible(false);
			}
		});
		
		skip = new JButton("Pas fait");
		skip.setForeground(Color.WHITE);
		skip.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		skip.setFocusPainted(false);
		skip.setBorderPainted(false);
		skip.setBackground(new Color(171, 141, 0));
		skip.setBounds(136, 327, 111, 31);
		contentPane.add(skip);
		annuler.setForeground(Color.WHITE);
		annuler.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		annuler.setFocusPainted(false);
		annuler.setBorderPainted(false);
		annuler.setBackground(new Color(171, 0, 0));
		annuler.setBounds(263, 327, 111, 31);
		contentPane.add(annuler);
		
		interro = new JLabel("Examen");
		interro.setForeground(new Color(255, 255, 255));
		interro.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		interro.setHorizontalAlignment(SwingConstants.CENTER);
		interro.setBounds(0, 141, 384, 27);
		contentPane.add(interro);
		
		cours = new JLabel("Cours");
		cours.setHorizontalAlignment(SwingConstants.CENTER);
		cours.setForeground(Color.WHITE);
		cours.setFont(new Font("Futura Hv BT", Font.PLAIN, 23));
		cours.setBounds(0, 115, 384, 27);
		contentPane.add(cours);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 110, 384, 12);
		contentPane.add(separator);
		
		panel_2 = new JPanel();
		panel_2.setBackground(contentPane.getBackground());
		panel_2.setBounds(0, 182, 384, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Total = new JLabel("Total: 103.5/135");
		panel_2.add(Total);
		Total.setHorizontalAlignment(SwingConstants.CENTER);
		Total.setForeground(Color.WHITE);
		Total.setFont(new Font("Futura Hv BT", Font.PLAIN, 27));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(contentPane.getBackground());
		panel_1.setPreferredSize(new Dimension(100, 10));
		panel_2.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		down = new JButton("");
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				displayedSerie ++;
				//saveExams();
				
				 if(displayedSerie+1 == panel.getComponentCount()){
					 up.setEnabled(true);
					 down.setEnabled(false);
				 }else {
					 down.setEnabled(true);
				 }

				 Animations.scrollDown();
				 series.setText(displayedSerie+1+"/"+panel.getComponentCount());
				 
			}
		});
		down.setBorder(new LineBorder(new Color(255, 255, 255)));
		down.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\down.png"));
		down.setFocusPainted(false);
		down.setBackground(contentPane.getBackground());
		down.setPreferredSize(new Dimension(30, 9));
		panel_1.add(down, BorderLayout.EAST);
		
		series = new JLabel("");
		series.setPreferredSize(new Dimension(40, 14));
		series.setForeground(new Color(255, 255, 255));
		series.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		panel_1.add(series, BorderLayout.WEST);
		
		up = new JButton("");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayedSerie --;
				//saveExams();
				Animations.scrollUp();
				 if(displayedSerie == 0){
					 up.setEnabled(false);
					 down.setEnabled(true);
				 }else {
					 up.setEnabled(true);
				 }
				 if(displayedSerie+1 == panel.getComponentCount()){
					 up.setEnabled(true);
					 down.setEnabled(false);
				 }else {
					 down.setEnabled(true);
				 }
				 
				 series.setText(displayedSerie+1+"/"+panel.getComponentCount());
				 
			}
		});
		up.setBorder(new LineBorder(new Color(255, 255, 255)));
		up.setFocusPainted(false);
		up.setBackground(contentPane.getBackground());
		up.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\up.png"));
		up.setPreferredSize(new Dimension(30, 9));
		panel_1.add(up, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 221, 364, 95);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 364, 95);
		panel_3.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setBackground(contentPane.getBackground());
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(275, 170, 2, 52);
		//contentPane.add(separator_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(0, 170, 384, 12);
		contentPane.add(separator_1);
		

		n = 0;
		loadStudent(n);
		loadExamSeries(cours.getText());
		total();
		//Animations.scrollRight();
		
		 if(displayedSerie == 0){
			 up.setEnabled(false);
		 }else {
			 up.setEnabled(true);
		 }
		 if(displayedSerie+1 == panel.getComponentCount()){
			 down.setEnabled(false);
		 }if(panel.getComponentCount() <= 1){
			 down.setEnabled(false);
		 }if(displayedSerie+1 < panel.getComponentCount()){
			 down.setEnabled(true);
		 }
		
		 SwingUtilities.invokeLater(() -> {
	            JScrollBar bar = scrollPane.getVerticalScrollBar();
	            bar.setValue((panel.getHeight())*0);
	    });
		 
	}
	
	
	public static void total() {
		Double sum = (double) 0;
		Double max = (double) 0;
		int seriesDone = 0;

		for(int i = 0;i<panel.getComponentCount();i++) {
		String PO = ((JTextComponent) ((Container) panel.getComponent(i)).getComponent(2)).getText().replace(",", ".");
		
		if(PO.equals("")) {
			seriesDone = seriesDone;
			sum = sum;
		}else {
			seriesDone = seriesDone+1;
			String PO1 = ((JTextComponent) ((Container) panel.getComponent(i)).getComponent(2)).getText().replace(",", ".");
			sum = sum+Double.parseDouble(PO1);
			
		}
		String maxima1 = ((JLabel) ((Container) panel.getComponent(i)).getComponent(3)).getText().replace("/", "");
		max = max+Double.parseDouble(maxima1);
		}
		
		if(seriesDone==0) {
			Total.setText("N'as pas encore fait");
		}else {

			Total.setText("Total: "+(new DecimalFormat("##.##").format(sum))+"/"+(new DecimalFormat("##.##").format(max)));
		}
		
	}
	
	public static void loadExamSeries(String s) {
		
		panel.removeAll();
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
		aws.downloadContent(file.getPath());
				try {

					
					FileReader fr = new FileReader(file);
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines = br.lines().toArray();
					
					String Name = TestBox.getShortName(s, Home.className);
					int index = 0;
					for(int i =0;i< lines.length; i++) {
					List parts = Arrays.asList(lines[i].toString().split("//"));
					if(parts.get(0).equals(Name)) {
						index = i;
					
		List parts1 = Arrays.asList(lines[index].toString().split("//"));
		
		int series = Integer.parseInt( parts1.get(2).toString());
		
		for(int i1 = 0; i1<series;i1++) {
			
			List serie = Arrays.asList(parts1.get(4+i1).toString().split("::"));
			
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setPreferredSize(new Dimension(scrollPane.getWidth(), scrollPane.getHeight()));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSituationDintegration = new JLabel(i1+1+". "+serie.get(0));
		lblSituationDintegration.setBorder(new LineBorder(Color.WHITE));
		lblSituationDintegration.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituationDintegration.setForeground(Color.WHITE);
		lblSituationDintegration.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		lblSituationDintegration.setBounds(10, 0, 344, 27);
		panel_1.add(lblSituationDintegration);
		
		JLabel label = new JLabel("Points obtenus:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		label.setBounds(20, 43, 144, 31);
		panel_1.add(label);
		
		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Arial", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setCaretColor(new Color(0, 204, 255));
		textField.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField.setBackground(new Color(40, 40, 40));
		textField.setBounds(183, 44, 61, 28);
		panel_1.add(textField);
	
		
		String maxima = parts.get(1).toString();
		
		
		JLabel label_1 = new JLabel("/"+Integer.parseInt(serie.get(1).toString())*Integer.parseInt(maxima)/100);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
		label_1.setBounds(254, 43, 118, 31);
		panel_1.add(label_1);
		

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				total();
				
				if(textField.getText().isBlank() || Double.parseDouble(textField.getText().replace(",", "."))>Double.parseDouble(label_1.getText().replace("/", "").replace(",", "."))) {
					add.setEnabled(false);
				}else {

					add.setEnabled(true);
				}
			}
		});
		
		
		}
		}
					}
		
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			}

				series.setText(displayedSerie+1+"/"+panel.getComponentCount());
	}
	
	public static void loadData(String s) {
		

		String Name = TestBox.getShortName(s, Home.className);
		
		for(int i1 = 0; i1<panel.getComponentCount();i1++) {
File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name.getText()+"/3eme Trimestre/"+Name+".txt");
aws.downloadContent(file1.getPath());
		try {

			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			
			String points = "";
			if(lines1[0].toString().contains("//")) {
				List parts2 = Arrays.asList(lines1[0].toString().split("//"));
				List note = Arrays.asList(parts2.get(i1).toString().split("/"));
				if(note.get(0).toString().equals("0") && note.get(1).toString().equals("0")) {
					points = "";
				}else {
				points = (String) note.get(0);
				}
			}else {
				List parts2 = Arrays.asList(lines1[0].toString().split("/"));
				if(parts2.get(0).toString().equals("0") && parts2.get(1).toString().equals("0")) {
					points = "";
				}else {
				points = (String) parts2.get(0);
				}
			}
			
			((JTextField) ((Container) panel.getComponent(i1)).getComponent(2)).setText(points);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	}}
	}
	
	public static void loadStudent(int i) {
		
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		aws.downloadContent(file.getPath());
		FileReader fr;
		try {
			fr = new FileReader(file);
		
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = Home.loadActiveStudents(file.getPath());
		
		List note1;
		
		if(n<lines.length) {
		note1 = Arrays.asList(lines[i].toString().trim().split("//"));
		}else{
		note1 = Arrays.asList(lines[0].toString().trim().split("//"));
		}
		name.setText((String) note1.get(0));
		num.setText((String) note1.get(1));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	}
	}
	
	
	public static void saveExams() {
		
		String Name = TestBox.getShortName(cours.getText(), Home.className);
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name.getText()+"/3eme Trimestre/"+Name+".txt");
		aws.downloadContent(file1.getPath());
		List <String> components = new ArrayList();
		String points = null;

		List<String> parts2 = new ArrayList();
		try {

			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines = br1.lines().toArray();
			
			for(int i = 0; i<lines.length; i++) {
				components.add(lines[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
	}	
		
		for(int i = 0; i<panel.getComponentCount(); i++) {
			
			parts2.clear();

			String PO = null;
			String maxima = null;

			
			if(components.get(0).toString().contains("//")) {
				
				List parts1 = Arrays.asList(components.get(0).toString().split("//"));
				
				for(int j = 0; j<parts1.toArray().length; j++) {
				parts2.add((String) parts1.get(j));
				}}
				else {
					parts2.add(components.get(0).toString());
				}
				if(((JTextField) ((Container) panel.getComponent(i)).getComponent(2)).getText().equals("")) {
					PO = "0";
					maxima = "0";
					System.out.println(i+".contains 0");
				}else {
					PO = ((JTextField) ((Container) panel.getComponent(i)).getComponent(2)).getText().replace(",", ".");
					maxima = ((JLabel) ((Container) panel.getComponent(i)).getComponent(3)).getText().replaceAll("[^0-9]", "").replace(",", ".");
					System.out.println(i+".contains something");
				}
				parts2.add(i, PO+"/"+maxima);
				parts2.remove(i+1);

				
				for(int k = 0;k<parts2.toArray().length;k++) {
					if(k == 0) {
						points = parts2.get(0);
					}else {
						points = points+"//"+parts2.get(k);
					}
				}
				components.add(0, points);
				components.remove(1);
			
		}
		
		if(file1.exists()) {
			file1.delete();
		}

	try {
		

		file1.createNewFile();

		PrintWriter pw = new PrintWriter(file1);
		for(int i1 = 0; i1<components.toArray().length;i1++) {
			pw.println(components.get(i1));
		}
		
		pw.close();
		
		aws.upload(file1.getPath());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
	}
}
