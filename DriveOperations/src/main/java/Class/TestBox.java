package Class;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Class.OptionsMenu.CourseMenu;
import Class.OptionsMenu.TestMenu;
import Class.OptionsMenu.TestMenu;
import Class.OptionsMenu.TestMenu;
import Class.OptionsMenu.TestMenu;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.LPane;
import app.Test;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;

public class TestBox extends JPanel {
	public static JPanel Box1;
	public static JLabel lblNdashimyeMaxBrillant;
	public static JLabel label_5;
	public static List<Component> selectedTests = new ArrayList();

	/**
	 * Create the panel.
	 */
	public TestBox() {
		setBackground(new Color(40, 40, 40));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TestMenu.deselect();
				boolean alreadyExists = false;
				if((MouseEvent.CTRL_MASK & e.getModifiers())!=0) {
					if(!selectedTests.contains(getComponent(0).getParent())) {
						selectedTests.add(getComponent(0).getParent());
					}else {
						selectedTests.remove(getComponent(0).getParent());
					}
				}else {

					if(selectedTests.contains(getComponent(0).getParent())) {
					alreadyExists = true;
					}
				deselectAll();
				TestMenu.deselect();
				selectedTests.add(getComponent(0).getParent());
				}


				if(selectedTests.toArray().length==1) {
					Component comp = null;

				for(int i = 0; i< Application.panelTests.getComponentCount(); i++) {
						if(Application.panelTests.getComponent(i).equals(selectedTests.get(0))) {
							comp = Application.panelTests.getComponent(i);
						}
					}
				
						if(!comp.equals(null)) {
				}}
				
				for(int i = 0; i<selectedTests.toArray().length; i++) {
					for(int j = 0; j< Application.panelTests.getComponentCount(); j++) {
						if(Application.panelTests.getComponent(j).equals(selectedTests.get(i))) {
							((Container) Application.panelTests.getComponent(j)).getComponent(0).setBackground(new Color(20, 148, 198, 50));
							((Container) Application.panelTests.getComponent(j)).getComponent(1).setBackground(new Color(20, 148, 198, 50));
							((JComponent) Application.panelTests.getComponent(j)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
							((Container) ((Container) Application.panelTests.getComponent(j)).getComponent(0)).getComponent(0).setVisible(true);
							
							for(int k = 0;k<((Container) Application.panelTests.getComponent(j)).getComponentCount();k++) {
								((Container) Application.panelTests.getComponent(j)).getComponent(k).setForeground(Color.white);
							}
				}}}
				
			//
					
				//
					TestMenu.edit.setVisible(true);
					TestMenu.delete.setVisible(true);
					TestMenu.publish.setVisible(true);
					TestMenu.stats.setVisible(true);
				if(selectedTests.toArray().length==0) {
					deselectAll();
				}
				}
			public void mouseEntered(MouseEvent e) {
				if(!selectedTests.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(new Color(60, 60, 60));
					getComponent(1).setBackground(new Color(60, 60, 60));
					//setBorder(new LineBorder(new Color(20, 148, 198)));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedTests.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(getBackground());
					getComponent(1).setBackground(getBackground());
					setBorder(null);
				}
				
			}
		});
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 67));
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(35, 30));
		panel.setBackground(new Color(40, 40, 40));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(35, 40));
		panel1.setBackground(new Color(20, 148, 198));
		panel.add(panel1, BorderLayout.WEST);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(ResizeImages.resize(20, 20, "Icons\\check.png"));
		panel1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblUmuhozaChrisKoen = new JLabel();
		lblUmuhozaChrisKoen.setAlignmentX(1.0f);
		lblUmuhozaChrisKoen.setText("Interrogation No 2 (Maths Stats)");
		lblUmuhozaChrisKoen.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.BOLD, 16));
		panel.add(lblUmuhozaChrisKoen, BorderLayout.CENTER);
		
		JButton stats = new JButton();
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setIcon(ResizeImages.resize(25, 25, "Icons\\stats.png"));
		stats.setBackground(new Color(40, 40, 40));
		panel.add(stats, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setPreferredSize(new Dimension(10, 37));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		panel_1.setBackground(new Color(40, 40, 40));
		
		JLabel lblProgres = new JLabel("10/04/2022");
		lblProgres.setHorizontalAlignment(SwingConstants.CENTER);
		//lblProgres.setPreferredSize(new Dimension(80, 18));
		lblProgres.setOpaque(true);
		lblProgres.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProgres.setForeground(Color.BLACK);
		lblProgres.setFont(new Font("Roboto", Font.BOLD, 14));
		lblProgres.setBackground(new Color(233, 150, 122));
		panel_1.add(lblProgres);
		
		JLabel lblNewLabel = new JLabel("Moyenne: 58.5/105");
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("-");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Roboto", Font.BOLD, 14));
		label_1.setBackground(new Color(250, 128, 114));
		panel_1.add(label_1);
		
		JLabel lblEchecs = new JLabel("12 echecs");
		lblEchecs.setVerticalAlignment(SwingConstants.TOP);
		lblEchecs.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEchecs.setForeground(new Color(211, 211, 211));
		lblEchecs.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEchecs.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEchecs);
		
		JLabel label_4 = new JLabel("-");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setForeground(new Color(211, 211, 211));
		label_4.setFont(new Font("Roboto", Font.BOLD, 14));
		label_4.setBackground(new Color(250, 128, 114));
		panel_1.add(label_4);
		
		JLabel lblElevesManquants = new JLabel("25 sur 30 eleves ont ete corriges");
		lblElevesManquants.setVerticalAlignment(SwingConstants.TOP);
		lblElevesManquants.setHorizontalTextPosition(SwingConstants.LEADING);
		lblElevesManquants.setForeground(new Color(211, 211, 211));
		lblElevesManquants.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblElevesManquants.setBackground(new Color(250, 128, 114));
		panel_1.add(lblElevesManquants);
		
		JLabel label_3 = new JLabel("-");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Roboto", Font.BOLD, 14));
		label_3.setBackground(new Color(250, 128, 114));
		panel_1.add(label_3);
		
		JLabel lblEducation = new JLabel("Reussite: 83%");
		lblEducation.setVerticalAlignment(SwingConstants.TOP);
		lblEducation.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEducation.setForeground(new Color(211, 211, 211));
		lblEducation.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEducation.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEducation);
	
		
	}
	

	public static String getFullName(String course_in_classroom_id) {
		
		String fullName = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from courses AS c "
					+ "JOIN courses_in_classroom AS cic "
					+ "WHERE cic.courses_in_classroom_id = '"+course_in_classroom_id+"' AND cic.course_id = c.course_id LIMIT 1");
			while(rs.next())
			{
				fullName = rs.getString("c.full_name");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return fullName;
		
	}
	
public static String getShortName(String course_in_classroom_id) {
	
	String shortName = null;
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses AS c "
				+ "JOIN courses_in_classroom AS cic "
				+ "WHERE cic.courses_in_classroom_id = '"+course_in_classroom_id+"' AND cic.course_id = c.course_id LIMIT 1");
		while(rs.next())
		{
			shortName = rs.getString("c.short_name");
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return shortName;
	
}
	
	

	public static void deleteTest() {
		//loadTests();
		
		String s = ((JLabel) ((Container) selectedTests.get(0)).getComponent(1)).getText();
		String courseName = getShortName(s, Home.className);
		int testNumber = Integer.parseInt(((JLabel) ((Container) TestBox.selectedTests.get(0)).getComponent(0)).getText().replaceAll("[^0.00-9.00]+", " ").replaceAll(" ", ""));
		
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		aws.downloadContent(file1.getPath());
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = br1.lines().toArray();
		
		
		for(int i =0; i<lines1.length; i++) {
			List note = Arrays.asList(lines1[i].toString().split("//"));
			List<String> studentInfo = new ArrayList();
			
			
			
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+note.get(0).toString().replaceAll("::", " ")+"/3eme Trimestre/"+courseName+".txt");
			aws.downloadContent(file.getPath());
			FileReader fr;
			try {
				fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int j = 0; j<lines.length; j++) {
				studentInfo.add(lines[j].toString());
			}
			
			studentInfo.remove(0+testNumber);
			
			PrintWriter write = new PrintWriter(file);
			for(int k = 0; k < studentInfo.toArray().length;k++) {
			write.println(studentInfo.get(k).toString());
			}
			write.close();

			aws.upload(file.getPath());

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0;i<testList.toArray().length;i++) {
			List l = Arrays.asList(testList.get(i).split("//"));
			if(l.get(0).equals(courseName) && l.get(2).toString().equals(String.valueOf(testNumber))) {
				testList.remove(i);
		}}
		saveTests();
		String s1 = ((JLabel) ((Container) selectedTests.get(0)).getComponent(1)).getText();
		String courseName1 = getShortName(s1, Home.className);
		refreshTestNumbers(courseName1);
		
		
		 new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
	        		TestBox.loadAllTests();
	            	 return null;
	            }
	        }.execute();
		//NewCourse.load();
		//NewStudent.load();
	}
	
	
	public static void refreshTestNumbers(String courseName) { // in order to refresh the test numbers when a test is deleted
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
		aws.downloadContent(file.getPath());
		testList.clear();
		//int testNumber = Integer.parseInt(((JLabel) ((Container) TestBox.selectedTests.get(0)).getComponent(0)).getText().replaceAll("[^0.00-9.00]+", " ").replaceAll(" ", ""));
		
		
				try {

					
					FileReader fr = new FileReader(file);
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines = br.lines().toArray();
					
					for(int i = 0;i<lines.length;i++) {
						testList.add(lines[i].toString());
					}
					
					int count = 0;
					for(int i = 0 ;i<testList.toArray().length; i++) {
						List note = Arrays.asList(testList.get(i).split("//"));
						
						if(note.get(1).equals(courseName)) {
							count++;
							String t = testList.get(i).toString();
							List note1 = Arrays.asList(t.split("//"));
							testList.remove(i);
							testList.add(i, note1.get(0).toString()+"//"+note1.get(1).toString()+"//"+note1.get(2).toString()+"//"+count+"//"+note1.get(4).toString());
						}
					}
					saveTests();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			}
		
	}
	
	public static void loadAllTests(String classroom_in_ay_id) {
		Application.panelTests.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadTests(classroom_in_ay_id, Home.terms.get(i));
		}
		Application.panelTests.revalidate();
		Application.panelTests.repaint();
	}
	
	public static void loadTests(String classroom_in_ay_id, String term_id) {
		
		//((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(2)).getComponent(0).setVisible(true);
				int i = 0;
					
					JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
					lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
					lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
					lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 20));
					Application.panelTests.add(lblNdashimyeMaxBrillant);
					lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(lblNdashimyeMaxBrillant.getParent().getParent().getWidth(), 50));
					
					try {
						Statement stmt= mysql.con.createStatement();

						ResultSet rs=stmt.executeQuery("SELECT * from test_information "
								+ "WHERE is_active = 1 AND cia_id = '"+classroom_in_ay_id+"' AND term_id = '"+term_id+"'");
					
					while(rs.next())
					{
						if(i >0) {
							JSeparator separator = new JSeparator();
							separator.setPreferredSize(new Dimension(1000, 2));
							separator.setForeground(new Color(250, 250, 250, 100));
							Application.panelTests.add(separator);
						}
						i++;
						TestBox tb = new TestBox();
						tb.setName(rs.getString("test_id"));
						((JLabel) ((Container) ((Container) tb).getComponent(0)).getComponent(1)).setText("  "+Test.getTestName(rs.getString("test_id"))+" ("+TestBox.getShortName(Test.getTestCourse(rs.getString("test_id")))+")");
						loadTestdata(tb, rs.getString("test_id"), classroom_in_ay_id);
						Application.panelTests.add(tb);
					}
					Application.panelTests.revalidate();
					Application.panelTests.repaint();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			}
					if(i == 0) {
						((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(2)).getComponent(0).setVisible(false);
						
						JPanel panel_10 = new JPanel();
						panel_10.setBorder(new MatteBorder(1, 3, 5, 3, (Color) new Color(0, 0, 0, 120)));
						panel_10.setBackground(new Color(0, 0, 0, 20));
						panel_10.setPreferredSize(new Dimension(300, 400));
						Application.panelTests.add(panel_10);
						panel_10.setLayout(null);
						
						JPanel panel_11 = new JPanel();
						panel_11.setBorder(new MatteBorder(0, 3, 5, 3, (Color) new Color(0, 0, 0, 190)));
						panel_11.setBackground(new Color(80,80,80));
						panel_11.setBounds(0, 233, 300, 167);
						panel_10.add(panel_11);
						panel_11.setLayout(null);
						
						JLabel lblNewLabel = new JLabel("<html>Aucune interrogation n'a ete effectuee dans ce trimestre.</html>");
						lblNewLabel.setForeground(new Color(255, 255, 255));
						lblNewLabel.setBounds(10, 0, 280, 106);
						panel_11.add(lblNewLabel);
						lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
						
						JButton btnNewButton_1 = new JButton("Ajouter une interrogation");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TestInfo nt = new TestInfo();
								nt.setVisible(true);
							}
						});
						btnNewButton_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								btnNewButton_1.setBackground(Color.white);
								btnNewButton_1.setForeground(Color.black);
							}public void mouseExited(MouseEvent e) {
								btnNewButton_1.setBackground(panel_11.getBackground());
								btnNewButton_1.setForeground(Color.WHITE);
								
							}
						});
						btnNewButton_1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
						btnNewButton_1.setFocusPainted(false);
						btnNewButton_1.setBackground(panel_11.getBackground());
						btnNewButton_1.setForeground(Color.WHITE);
						btnNewButton_1.setBounds(10, 116, 280, 40);
						if(Home.selectedTermIndex!=Home.termsText.toArray().length) {
						panel_11.add(btnNewButton_1);
						}
						btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
						
						JLabel lblNewLabel_2 = new JLabel("");
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_2.setIcon(ResizeImages.resize(80, 80, "Icons\\cg_welcome.png"));
						lblNewLabel_2.setBackground(new Color(0, 0, 0));
						lblNewLabel_2.setBounds(0, 0, 300, 235);
						panel_10.add(lblNewLabel_2);
						
					}
				Application.panelTests.revalidate();
				Application.panelTests.repaint();
				TestBox.deselectAll();
	}
	
	

	public static void loadTestdata(Container c, String test_id, String classroom_in_ay_id) {
		
		int echec = 0;
		Double points = (double) 0;
		Double maxima = (double) 0;
		int participants = 0;
		
		
		Object[] lines1 = Home.loadActiveStudents(classroom_in_ay_id);
		
		
		for(int i = 0; i<lines1.length;i++) {
		
		List<String> note = Arrays.asList(LPane.loadStudentNote(test_id, lines1[i].toString()).split("/"));
		Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."));
		Double maxima1 = Double.parseDouble(note.get(1).replaceAll(",", "."));
		
		points = points+ points1;
		maxima = maxima+ maxima1;
		
		if(Double.parseDouble(new DecimalFormat("##.##").format(points1).replaceAll(",", "."))<(Double.parseDouble(new DecimalFormat("##.##").format(maxima1).replaceAll(",", "."))/2)) {
		echec++;
		}
		if(points1 == 0 && maxima1 == 0) {
			participants = participants+0;
		}else {
			participants++;
		}
		}
		((JLabel) ((((Container) c.getComponent(1)).getComponent(0)))).setText(" "+Test.getTestDate(test_id)+" ");
		
		((JLabel) ((((Container) c.getComponent(1)).getComponent(1)))).setText("Moyenne: "+(new DecimalFormat("##.##").format(points*Double.parseDouble(Test.getTestMaxima(test_id))/maxima))+"/"+Test.getTestMaxima(test_id));
		((JLabel) ((((Container) c.getComponent(1)).getComponent(3)))).setText(String.valueOf(echec)+" echecs");
		((JLabel) ((((Container) c.getComponent(1)).getComponent(5)))).setText(participants+" sur "+lines1.length+" eleves ont ete corriges");
		String reussite = new DecimalFormat("##").format(100-(Double.parseDouble(String.valueOf(echec))/Double.parseDouble(String.valueOf(participants))*100));
		((JLabel) ((((Container) c.getComponent(1)).getComponent(7)))).setText("Reussite a: "+reussite+"%");
		
					
		
	}
	
	
	
	
	public static void addTest(String s) {
		loadAllTests();
		testList.add(s);
		rankTests();
		saveTests();
}


	private static void rankTests() {

		List<String> comp = new ArrayList();
		
					for(int i = 0;i<testList.toArray().length;i++) {
					comp.add(testList.get(i).toString());
					}
					
				List<Calendar> dates = new ArrayList();
				for(int i = 0; i< comp.toArray().length; i++) {
					List l = Arrays.asList(comp.get(i).split("//"));
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					try {
						d1 = df.parse(l.get(4).toString());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					Calendar c1 = Calendar.getInstance();
					c1.setTime(d1);
					dates.add(c1);
				}
				Collections.sort(dates);
				

				for(int j = 0; j< dates.toArray().length; j++) {
				for(int i = 0; i< comp.toArray().length; i++) {
					List l = Arrays.asList(comp.get(i).split("//"));
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					try {
						d1 = df.parse(l.get(4).toString());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					Calendar c1 = Calendar.getInstance();
					c1.setTime(d1);
					
					if(dates.get(j).equals(c1)) {
						String s = comp.get(i);
						comp.remove(i);
						comp.add(j, s);
					}
						}
					}
		
				testList.clear();
				for(int i = 0; i< comp.toArray().length; i++) {
					testList.add(comp.get(i));
				}
				saveTests();
				for(int i = 0; i< testList.toArray().length; i++) {
					List l = Arrays.asList(testList.get(i).split("//"));
					refreshTestNumbers(l.get(1).toString());
		}
	}

	public static void saveTests() {
		
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
		
		if(file.exists()) {
					file.delete();
				}
		
			try {
				

				file.createNewFile();

				PrintWriter pw = new PrintWriter(file);
				for(int i = 0; i<testList.toArray().length;i++) {
					pw.println(testList.get(i));
				}
				
				pw.close();
				aws.upload(file.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	
	public static void deselectAll() {
		for(int i = 0; i< ((Container) Application.panelTests).getComponentCount(); i++) {
			if(((Container) Application.panelTests).getComponent(i) instanceof TestBox) {
			if(selectedTests.contains(((Container) Application.panelTests).getComponent(i))) {
				((JComponent) ((Container) Application.panelTests).getComponent(i)).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) Application.panelTests).getComponent(i)).getComponent(0).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) Application.panelTests).getComponent(i)).getComponent(1).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) Application.panelTests).getComponent(i)).setBorder(null);
			}
			((Container) ((Container) Application.panelTests.getComponent(i)).getComponent(0)).getComponent(0).setVisible(false);
			
				Application.panelTests.revalidate();

				Application.panelTests.repaint();
			}
		}

		selectedTests.clear();
		
		TestMenu.deselect();
}
	
}