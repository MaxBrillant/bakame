package sideInformation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import org.jfree.text.TextBox;

import Application.Class;
import Application.ClassesAndCourses;
import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.TestBox;
import Class.OptionsMenu.HomeMenu3;
import CloudOperations.aws;
import CloudOperations.mysql;
import Schedule.TeacherSchedule;
import Stats.CourseStats;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherInfo extends JPanel {
	public static JLabel numberOfClasses;
	public static JLabel className;
	public static JLabel coursesNumber;
	public static JLabel classNumber;
	public static List<String> classes = new ArrayList();
	public static int selectedClass = 0;
	public static JLabel percent;
	public static JLabel rate;

	/**
	 * Create the panel.
	 */
	public TeacherInfo(String teacher_id, String ay_id) {
		setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(400, 614));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Teacher.getTeacherName(teacher_id));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 21, 380, 28);
		add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBounds(10, 119, 380, 147);
		add(panel_2);
		panel_2.setBackground(panel_2.getParent().getBackground());
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 36, 378, 110);
		panel_2.add(panel_4);
		panel_4.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 5));
		panel_4.setBackground(panel_4.getParent().getBackground());
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setPreferredSize(new Dimension(180, 70));
		panel.setBackground(new Color(80, 80, 80));
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMoyenne = new JLabel("Moyenne %");
		lblMoyenne.setPreferredSize(new Dimension(61, 25));
		lblMoyenne.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyenne.setForeground(Color.WHITE);
		lblMoyenne.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(lblMoyenne, BorderLayout.NORTH);
		
		percent = new JLabel("-");
		percent.setHorizontalAlignment(SwingConstants.CENTER);
		percent.setForeground(Color.WHITE);
		percent.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(percent, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setPreferredSize(new Dimension(180, 70));
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPoints = new JLabel("% de reussite moyen");
		lblPoints.setPreferredSize(new Dimension(61, 25));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Roboto", Font.BOLD, 18));
		panel_1.add(lblPoints, BorderLayout.NORTH);
		
		rate = new JLabel("-");
		rate.setHorizontalAlignment(SwingConstants.CENTER);
		rate.setForeground(Color.WHITE);
		rate.setFont(new Font("Roboto", Font.BOLD, 30));
		panel_1.add(rate, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(100, 20));
		panel_6.setBackground(new Color(80, 80, 80));
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		coursesNumber = new JLabel("0 cours");
		coursesNumber.setHorizontalAlignment(SwingConstants.CENTER);
		coursesNumber.setForeground(Color.WHITE);
		coursesNumber.setFont(new Font("Roboto", Font.PLAIN, 17));
		coursesNumber.setBackground(Color.WHITE);
		panel_6.add(coursesNumber, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1, 1, 378, 35);
		panel_3.setPreferredSize(new Dimension(25, 35));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(panel_3.getParent().getBackground());
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button.setPreferredSize(new Dimension(40, 30));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(60, 60, 60));
		panel_3.add(button, BorderLayout.EAST);
		
		JButton button_1 = new JButton("");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(true);
				button_1.setEnabled(true);
				if(selectedClass < classes.toArray().length-2) {
					button.setEnabled(true);
				}else {
					button.setEnabled(false);
				}
				selectedClass++;
				if(classes.toArray().length>0) {
				loadTeacherInfo(teacher_id, ay_id, classes.get(selectedClass));
			}}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				button.setEnabled(true);
				button_1.setEnabled(true);
				if(selectedClass == 1) {
					button_1.setEnabled(false);
				}else {
					button_1.setEnabled(true);
				}
				selectedClass--;
				if(classes.toArray().length>0) {
				loadTeacherInfo(teacher_id, ay_id, classes.get(selectedClass));
				}
			}
		});
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_1.setPreferredSize(new Dimension(40, 30));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(60, 60, 60));
		panel_3.add(button_1, BorderLayout.WEST);
		
		className = new JLabel("-");
		className.setHorizontalAlignment(SwingConstants.CENTER);
		className.setForeground(Color.WHITE);
		className.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		panel_3.add(className, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Informations rapides");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(78, 93, 227, 19);
		add(lblNewLabel_1);
		
		numberOfClasses = new JLabel("0 Classes");
		numberOfClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfClasses.setForeground(new Color(192, 192, 192));
		numberOfClasses.setFont(new Font("Futura Hv BT", Font.PLAIN, 18));
		numberOfClasses.setBounds(53, 50, 294, 28);
		add(numberOfClasses);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setPreferredSize(new Dimension(0, 1));
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 85, 400, 10);
		add(separator);
		
		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommandes.setForeground(Color.LIGHT_GRAY);
		lblCommandes.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCommandes.setBounds(78, 316, 227, 19);
		add(lblCommandes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setPreferredSize(new Dimension(0, 1));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 308, 400, 10);
		add(separator_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(50, 20));
		panel_5.setBackground(new Color(80, 80, 80));
		panel_5.setBounds(175, 277, 50, 20);
		add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		classNumber = new JLabel("-");
		classNumber.setForeground(new Color(255, 255, 255));
		classNumber.setBackground(new Color(255, 255, 255));
		classNumber.setFont(new Font("Roboto", Font.PLAIN, 17));
		classNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(classNumber, BorderLayout.CENTER);
		
		JButton btnclassesEtCours = new JButton("<html><div style='text-align: center;'>Classes et cours</div></html>");
		btnclassesEtCours.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\book.png"));
		btnclassesEtCours.setIconTextGap(0);
		btnclassesEtCours.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnclassesEtCours.setHorizontalTextPosition(SwingConstants.CENTER);
		btnclassesEtCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClassesAndCourses t = new ClassesAndCourses(teacher_id, ay_id);
				t.setVisible(true);
			}
		});
		btnclassesEtCours.setForeground(Color.WHITE);
		btnclassesEtCours.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnclassesEtCours.setFocusPainted(false);
		btnclassesEtCours.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnclassesEtCours.setBackground(new Color(40, 40, 40));
		btnclassesEtCours.setBounds(210, 346, 165, 100);
		add(btnclassesEtCours);
		
		btnclassesEtCours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnclassesEtCours.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnclassesEtCours.setBackground(btnclassesEtCours.getParent().getBackground());
			}
		});
		
		JButton btnhorairePersonnel = new JButton("<html><div style='text-align: left;'>Horaire personnel</div></html>");
		btnhorairePersonnel.setIconTextGap(0);
		btnhorairePersonnel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnhorairePersonnel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnhorairePersonnel.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\calendar.png"));
		btnhorairePersonnel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherSchedule t = new TeacherSchedule(teacher_id, ay_id);
				t.setVisible(true);
			}
		});
		btnhorairePersonnel.setForeground(Color.WHITE);
		btnhorairePersonnel.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnhorairePersonnel.setFocusPainted(false);
		btnhorairePersonnel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnhorairePersonnel.setBackground(new Color(40, 40, 40));
		btnhorairePersonnel.setBounds(25, 346, 165, 100);
		add(btnhorairePersonnel);
		
		btnhorairePersonnel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnhorairePersonnel.setBackground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				btnhorairePersonnel.setBackground(btnhorairePersonnel.getParent().getBackground());
			}
		});

		
		loadTeacherClasses(teacher_id, ay_id);

		if(classes.toArray().length>0) {
		loadTeacherInfo(teacher_id, ay_id, classes.get(selectedClass));
		}
		if(classes.toArray().length==1) {
			button.setEnabled(false);
			button_1.setEnabled(false);
		}else {
			button_1.setEnabled(false);
		}
		
	}
	
	
	public static void loadTeacherClasses(String teacher_id, String ay_id) {
		classes.clear();
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN classrooms as c "
					+ "JOIN classrooms_in_ay as cia "
					+ "JOIN courses as co "
					+ "JOIN courses_in_classroom as cic "
					+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ "AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
			while(rs.next())
			{
						classes.add(rs.getString("cic.cia_id"));
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				Home.frame.revalidate();
				Home.frame.repaint();
	
	}
	
	public static void loadTeacherInfo(String teacher_id, String ay_id, String classroom_in_ay_id) {
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN classrooms as c "
					+ "JOIN classrooms_in_ay as cia "
					+ "JOIN courses as co "
					+ "JOIN courses_in_classroom as cic "
					+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ "AND cic.cia_id = '"+classroom_in_ay_id+"' AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
			while(rs.next())
			{
				List<String> listOfclasses = new ArrayList();
				List<String> listOfcourses = new ArrayList();
				while(rs.next())
				{
					if(!listOfclasses.contains(rs.getString("cic.cia_id"))) {
						listOfclasses.add(rs.getString("cic.cia_id"));
					}
				}
				while(rs.next())
				{
					if(!listOfcourses.contains(rs.getString("cic.courses_in_classroom_id"))) {
						listOfcourses.add(rs.getString("cic.courses_in_classroom_id"));
					}
				}
						classNumber.setText(selectedClass+1+"/"+listOfclasses.toArray().length);
						coursesNumber.setText(listOfcourses.toArray().length+" cours");
						className.setText(Class.getClassName(classroom_in_ay_id));
						numberOfClasses.setText(classes.toArray().length+" classes");
						loadTeacherStats(teacher_id, ay_id, classroom_in_ay_id);
						}
			} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				Home.frame.revalidate();
				Home.frame.repaint();
	
	}
	public static void loadTeacherStats(String teacher_id, String ay_id, String classroom_in_ay_id) {
		
		
		int classesThatHaveTests = 0;
								
								Double pointsTotal = (double) 0;
								Double maximaTotal = (double) 0;
								int totalRate = 0;
								
								
								try {
									Statement stmt= mysql.con.createStatement();

									ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
											+ "JOIN classrooms as c "
											+ "JOIN classrooms_in_ay as cia "
											+ "JOIN courses as co "
											+ "JOIN courses_in_classroom as cic "
											+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
													+ "AND cic.cia_id = '"+classroom_in_ay_id+"' AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
									while(rs.next())
									{
									
									
									List<String> l1 = new ArrayList();
									l1.add("0");
									l1.add("0/0");
									List<String> l11 = new ArrayList();
									l11.add("0");
									l11.add("0/0");
									if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
										l1 = CourseStats.getStudentTestsStats("All", classroom_in_ay_id
												,rs.getString("cic.courses_in_classroom_id"), Home.termsText.get(Home.selectedTermIndex)
												,"All", "All");
										}

									if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
										l11 = CourseStats.getStudentExamStats("All", classroom_in_ay_id
												,rs.getString("cic.courses_in_classroom_id"), Home.termsText.get(Home.selectedTermIndex), "All", "All");
										}
							
							List<String> note = Arrays.asList(l1.get(1).toString().split("/"));
							List<String> note1 = Arrays.asList(l11.get(1).toString().split("/"));
							
							Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
							Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
							
							if(points1!=0 && maxima!=0 ) {
							classesThatHaveTests++;
							}
							pointsTotal = pointsTotal+points1;
							maximaTotal = maximaTotal+maxima;
								
								int rate = Teacher.successRate(ay_id, classroom_in_ay_id, rs.getString("cic.courses_in_classroom_id"));
								totalRate = totalRate+rate;
								}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
							Double percentage;
							if(pointsTotal==0 && maximaTotal==0 ) {
								percentage = 0.00;
								rate.setText("-");
							}else {
								percentage = (double) (pointsTotal*100/maximaTotal);
								rate.setText((totalRate)/((classesThatHaveTests))+"%");
							}
							percent.setText(new DecimalFormat("##.##").format(percentage)+"%");	
							
				Home.frame.revalidate();
				Home.frame.repaint();
	
}
}

