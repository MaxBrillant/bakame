package Class;

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
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import CloudOperations.aws;
import Stats.CourseStats;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

public class NewCourse extends JFrame {

	public static JPanel contentPane;
	public static JComboBox TP;
	public static JTextField name;
	private JLabel lblNewLabel_1;
	public static JTextField courseName;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse();
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
	public NewCourse(String classroom_in_ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 360);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 70, 70));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNewLabel = new JLabel("Abbreviation:");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNewLabel.setBounds(48, 164, 147, 31);
	contentPane.add(lblNewLabel);
	
	JLabel lblTg = new JLabel("Total points:");
	lblTg.setForeground(new Color(255, 255, 255));
	lblTg.setHorizontalAlignment(SwingConstants.TRAILING);
	lblTg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTg.setBounds(48, 206, 147, 31);
	contentPane.add(lblTg);
	
	name = new JTextField();
	name.setBorder(new LineBorder(new Color(128, 128, 128)));
	name.setHorizontalAlignment(SwingConstants.CENTER);
	name.setForeground(new Color(255, 255, 255));
	name.setCaretColor(new Color(0, 204, 255));
	name.setBackground(new Color(40, 40, 40));
	name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	name.setBounds(218, 164, 143, 28);
	contentPane.add(name);
	name.setColumns(10);
	
	TP = new JComboBox();
	TP.setModel(new DefaultComboBoxModel(new String[] {"20", "30", "40", "50", "60", "80", "100"}));
	TP.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
	TP.setEditable(true);
	TP.setBounds(218, 206, 72, 29);
	contentPane.add(TP);
	
	create = new JButton("Ajouter");
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Application.tabbedPane.setSelectedIndex(1);
			Application.deselect();
			load(classroom_in_ay_id);
			setVisible(false);
			
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(58, 275, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Nom du cours:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(48, 122, 147, 31);
	contentPane.add(lblNomDuCours);
	
	courseName = new JTextField();
	courseName.setBorder(new LineBorder(new Color(128, 128, 128)));
	courseName.setHorizontalAlignment(SwingConstants.CENTER);
	courseName.setForeground(new Color(255, 255, 255));
	courseName.setCaretColor(new Color(0, 204, 255));
	courseName.setBackground(new Color(40, 40, 40));
	courseName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	courseName.setColumns(10);
	courseName.setBounds(218, 122, 143, 28);
	contentPane.add(courseName);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez un nouveau cours en inserrant son nom, son abbreviation, et le total des points du cours</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updatecourse(TestBox.getShortName(((JLabel) ((Container) Course.selectedCourses.get(0)).getComponent(0)).getText(), Home.className));
			setVisible(false);

			
			new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
	    			NewCourse.load(classroom_in_ay_id);
	            	 return null;
	            }
	        }.execute();
		
		
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
			NewPane np = new NewPane();
			np.setVisible(true);
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(244, 275, 129, 31);
	contentPane.add(button);
	
	JLabel lblNouveauCours = new JLabel("Nouveau Cours");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	lblNouveauCours.setBounds(0, 70, 424, 28);
	contentPane.add(lblNouveauCours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 97, 424, 12);
	contentPane.add(separator);

	setLocationRelativeTo(null);
	}
	
	
	public static void load(String classroom_in_ay_id) {
		Application.panel2.removeAll();
		isEmpty = false;
		((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(1)).getComponent(0).setVisible(true);
		
				Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
				
				for(int i = 0; i<lines.length;i++) {
				Course c = new Course();
				((JLabel) ((Container) c).getComponent(0)).setText(TestBox.getFullName(lines[i].toString()));
				loadCoursedata(c, lines[i].toString(), classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
				c.setName(lines[i].toString());
				Application.panel2.add(c);
				}
				Application.panel2.revalidate();
				Application.panel2.repaint();
				
			if(Application.panel2.getComponentCount()==0) {
				isEmpty = true;
				((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(1)).getComponent(0).setVisible(false);
				
				JPanel panel_10 = new JPanel();
				panel_10.setBorder(new MatteBorder(1, 3, 5, 3, (Color) new Color(0, 0, 0, 120)));
				panel_10.setBackground(new Color(0, 0, 0, 20));
				panel_10.setPreferredSize(new Dimension(300, 400));
				Application.panel2.add(panel_10);
				panel_10.setLayout(null);
				
				JPanel panel_11 = new JPanel();
				panel_11.setBorder(new MatteBorder(0, 3, 5, 3, (Color) new Color(0, 0, 0, 190)));
				panel_11.setBackground(new Color(80,80,80));
				panel_11.setBounds(0, 233, 300, 167);
				panel_10.add(panel_11);
				panel_11.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("<html>Il n'ya actuellement aucun cours dans la bibliotheque, commencez par en ajouter.</html>");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBounds(10, 0, 280, 106);
				panel_11.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
				
				JButton btnNewButton_1 = new JButton("Ajouter un nouveau cours");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewCourse nt = new NewCourse(classroom_in_ay_id);
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
				panel_11.add(btnNewButton_1);
				btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setIcon(ResizeImages.resize(250, 250, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\empty_shelf.png"));
				lblNewLabel_2.setBackground(new Color(0, 0, 0));
				lblNewLabel_2.setBounds(0, 0, 300, 235);
				panel_10.add(lblNewLabel_2);
				
				
			}


			Course.deselectAll();
		}
	

	public static void loadCoursedata(Container c, String course_in_classroom_id, String classroom_in_ay_id, String term_id) {

		
		List<String> l = new ArrayList();
		l.add("0");
		l.add("0/0");
		List<String> l1 = new ArrayList();
		l1.add("0");
		l1.add("0/0");
		if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
			l = CourseStats.getStudentTestsStats("All", classroom_in_ay_id
					,course_in_classroom_id, term_id,"All", "All");
			}

		if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
			l1 = CourseStats.getStudentExamStats("All", classroom_in_ay_id
					,course_in_classroom_id, term_id,"All", "All");
			}
List<String> note = Arrays.asList(l.get(1).toString().split("/"));
List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));

Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));

Double percentage;
if(points1==0 && maxima==0 ) {
	percentage = 0.00;
}else {
	percentage = points1*100/maxima;
}
						
						((JLabel) ((((Container) c).getComponent(1)))).setText(new DecimalFormat("##.##").format(percentage)+"%");
							((JLabel) ((((Container) c).getComponent(2)))).setText(new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima));
						
							int echecs = CourseStats.listOfEchecs(course_in_classroom_id, classroom_in_ay_id, term_id).toArray().length;
						
							if(l.toArray().length>2) {
						((JLabel) ((((Container)c).getComponent(4)))).setText(l.get(2));
						((JLabel) ((((Container) c).getComponent(5)))).setText(String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(l.get(5))))+"%");
							}

						Object[] lines1 = Home.loadActiveStudents(classroom_in_ay_id);
						((JLabel) ((((Container) c).getComponent(6)))).setText(new DecimalFormat("##.##").format(100-(echecs*100/lines1.length))+"%");
	}
	
	
	

public static void updatecourse(String cName) {

		for(int k = 0;k<Application.trim.getItemCount()-1;k++) {
		List<String> TestList1 = new ArrayList();
		File file41 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/"+Application.trim.getItemAt(k)+"/TestList.txt");
		aws.downloadContent(file41.getPath());
		try {
			
			FileReader fr = new FileReader(file41);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				TestList1.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<TestList1.toArray().length; i++) {
			List l = Arrays.asList(TestList1.get(i).split("//"));
			if(l.get(1).toString().equals(cName)) {
				TestList1.add(i, TestList1.get(i).replaceAll("//"+l.get(1).toString()+"//", "//"+name.getText()+"//"));
				TestList1.remove(i+1);
		}}
	
	if(file41.exists()) {
		file41.delete();
			}
	
		try {
			file41.createNewFile();
			PrintWriter pw = new PrintWriter(file41);

			for(int j = 0;j<TestList1.toArray().length;j++) {
			pw.println((String)TestList1.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file41.getPath());
}
		






		for(int k = 0;k<Application.trim.getItemCount()-1;k++) {
			List<String> TestList1 = new ArrayList();
			File file41 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/"+Application.trim.getItemAt(k)+"/ExamList.txt");
			aws.downloadContent(file41.getPath());
			try {
				
				FileReader fr = new FileReader(file41);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = br.lines().toArray();
				
				for(int i = 0; i< lines.length; i++) {
					TestList1.add(lines[i].toString());
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			for(int i = 0; i<TestList1.toArray().length; i++) {
				List l = Arrays.asList(TestList1.get(i).split("//"));
				if(l.get(0).toString().equals(cName)) {
					TestList1.add(i, name.getText()+TestList1.get(i).replaceAll(l.get(0).toString(), ""));
					TestList1.remove(i+1);
			}}
		
		if(file41.exists()) {
			file41.delete();
				}
		
			try {
				file41.createNewFile();
				PrintWriter pw = new PrintWriter(file41);

				for(int j = 0;j<TestList1.toArray().length;j++) {
				pw.println((String)TestList1.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			aws.upload(file41.getPath());
	}

		
		
		
		
		
		
		
		
		
		
		
		File file21 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
		aws.downloadContent(file21.getPath());
				try {
					
					FileReader fr = new FileReader(file21);
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines1 = br.lines().toArray();
		
		for(int i = 0; i< lines1.length; i++) {
			List<String> comp1 = new ArrayList();
			List<String> comp2 = new ArrayList();
		List l = Arrays.asList(lines1[i].toString().split("//"));
		
		
		File file111 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).toString().replaceAll("::", " ")+"/ClassesAndCourses.txt");
		aws.downloadContent(file111.getPath());
				try {
					
					FileReader fr1 = new FileReader(file111);
					
					BufferedReader br1 = new BufferedReader(fr1);
					Object[] lines = br1.lines().toArray();
	
					for(int j = 0; j< lines.length; j++) {
							comp1.add(lines[j].toString());
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}

				for(int j = 0; j< comp1.toArray().length; j++) {
					String s = comp1.get(j).replaceAll(Home.className+"//"+TestBox.getFullName(cName, Home.className)+":", Home.className+"//"+courseName.getText()+":");
					comp1.add(j, s);
					comp1.remove(j+1);
				}
				if(file111.exists()) {
							file111.delete();
						}
				
					try {
						file111.createNewFile();
						PrintWriter pw = new PrintWriter(file111);

						for(int j = 0;j<comp1.toArray().length;j++) {
						pw.println(comp1.get(j));
						};
						
						pw.close();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					aws.upload(file111.getPath());
					
					

					File file1111 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).toString().replaceAll("::", " ")+"/Schedule.txt");
					aws.downloadContent(file1111.getPath());
							try {
								
								FileReader fr1 = new FileReader(file1111);
								
								BufferedReader br1 = new BufferedReader(fr1);
								Object[] lines = br1.lines().toArray();
				
								for(int j = 0; j< lines.length; j++) {
										comp2.add(lines[j].toString());
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}

							for(int j = 0; j< comp2.toArray().length; j++) {
								List l1 = Arrays.asList(comp2.get(j).split("//"));
								if(l1.get(2).toString().equals(Home.className) && l1.get(3).toString().equals(cName)) {
								String s = comp2.get(j).replaceAll("//"+cName, "//"+name.getText());
								comp2.add(j, s);
								comp2.remove(j+1);
							}}
							if(file1111.exists()) {
										file1111.delete();
									}
							
								try {
									file1111.createNewFile();
									PrintWriter pw = new PrintWriter(file1111);

									for(int j = 0;j<comp2.toArray().length;j++) {
									pw.println(comp2.get(j));
									};
									
									pw.close();
								
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
							}
								aws.upload(file1111.getPath());
		}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				
				
				
				
				File file3 = new File("Data/Establishments/Establishments.txt");
				aws.downloadContent(file3.getPath());
						try {
							
							FileReader fr = new FileReader(file3);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines1 = br.lines().toArray();
				
							List<String> comp1 = new ArrayList();
							
				for(int i = 0; i< lines1.length; i++) {
				List l = Arrays.asList(lines1[i].toString().split("//"));
				File file111 = new File("Data/Establishments/"+l.get(0).toString()+"/Roles.txt");
				aws.downloadContent(file111.getPath());
						try {
							
							FileReader fr1 = new FileReader(file111);
							
							BufferedReader br1 = new BufferedReader(fr1);
							Object[] lines = br1.lines().toArray();
			
							for(int j = 0; j< lines.length; j++) {
									comp1.add(lines[j].toString());
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}

						for(int j = 0; j< comp1.toArray().length; j++) {
							List<String> l2 = new ArrayList();
							List l1 = Arrays.asList(comp1.get(j).split("//"));
							for(int k = 0 ;k< l1.toArray().length; k++) {
								l2.add(l1.get(k).toString());
							}
							String s = "";
							for(int k = 0 ;k< l2.toArray().length; k++) {
								if(l2.get(k).toString().equals(TestBox.getFullName(cName, Home.className)+"::"+Home.className)) {
								s = l2.get(k).toString().replaceAll(TestBox.getFullName(cName, Home.className)+"::"+Home.className, courseName.getText()+"::"+Home.className);
							}else{
								s = l2.get(k).toString();
							}
								l2.add(k, s);
								l2.remove(k+1);
							}
							String m = "";
							for(int k = 0 ;k< l2.toArray().length; k++) {
								if(k==0) {
							m = m+l2.get(k);
							}else {

								m = m+"//"+l2.get(k);
							}
							}
							comp1.add(j, m);
							comp1.remove(j+1);
						}
						
						if(file111.exists()) {
									file111.delete();
								}
						
							try {
								file111.createNewFile();
								PrintWriter pw = new PrintWriter(file111);

								for(int j = 0;j<comp1.toArray().length;j++) {
								pw.println(comp1.get(j));
								};
								
								pw.close();
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
						}
							aws.upload(file111.getPath());
				}

						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
						
				
						
						
						
						
						List<String> courseList = new ArrayList();
						File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Courses.txt");
						aws.downloadContent(file.getPath());
						try {
							
							FileReader fr = new FileReader(file);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines = br.lines().toArray();
							
							for(int i = 0; i< lines.length; i++) {
								courseList.add(lines[i].toString());
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
						
						for(int i = 0; i<courseList.toArray().length; i++) {
							List l = Arrays.asList(courseList.get(i).split("//"));
							if(l.get(0).toString().equals(cName)) {
								courseList.add(i, name.getText()+"//"+courseName.getText()+"//"+TP.getSelectedItem()
						+"//active");
								courseList.remove(i+1);
						}}
					File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Courses.txt");
					
					if(file1.exists()) {
								file1.delete();
							}
					
						try {
							file1.createNewFile();
							PrintWriter pw = new PrintWriter(file1);

							for(int j = 0;j<courseList.toArray().length;j++) {
							pw.println((String)courseList.get(j));
							};
							
							pw.close();
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
						aws.upload(file1.getPath());
						
						
						
						
						

						
						File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
						aws.downloadContent(file2.getPath());
						try {
							FileReader fr = new FileReader(file2);
							
							BufferedReader br = new BufferedReader(fr);
							Object[] lines = br.lines().toArray();
							
							for(int i = 0; i<lines.length;i++) {
								String [] words = lines[i].toString().split("//");
								
								for(int k = 0;k<Application.trim.getItemCount()-1;k++) {
								File file31 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+words[0].replaceAll("::", " ")+"/"+Application.trim.getItemAt(k)+"/"+cName+".txt");
								File file311 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+words[0].replaceAll("::", " ")+"/"+Application.trim.getItemAt(k)+"/"+name.getText()+".txt");
								file311.renameTo(file311);
							}}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
					} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
}
	
}
