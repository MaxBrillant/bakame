package Application;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

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
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.Application;
import Class.Course;
import Class.ExamBox;
import Class.ExamInfo;
import Class.NewExam;
import Class.TestBox;
import Class.OptionsMenu.HomeMenu1;
import Class.OptionsMenu.HomeMenu3;
import CloudOperations.aws;
import CloudOperations.mysql;
import Schedule.TeacherSchedule;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.App;
import app.WrapLayout;
import sideInformation.MainInfo;
import sideInformation.TeacherInfo;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Teacher extends JPanel {
	public static JPanel Box1;
	public static boolean isSelected;

	public static List <String> classList = new ArrayList();
	public static Component selectedTeacher;
	

	/**
	 * Create the panel.
	 */
	public Teacher() {
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(new Color(40, 40, 40));
	//setBorder(new LineBorder(new Color(211, 211, 211)));
	setPreferredSize(new Dimension(700, 135));
	setLayout(new BorderLayout(0, 0));
	
	

	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(10, 40));
	add(panel_1, BorderLayout.NORTH);
	panel_1.setBackground(panel_1.getParent().getBackground());
	panel_1.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_4 = new JPanel();
	panel_1.add(panel_4, BorderLayout.CENTER);
	panel_4.setBackground(panel_4.getParent().getBackground());
	panel_4.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 7));
	
	JLabel name = new JLabel("Manirambona Ezequias");
	panel_4.add(name);
	name.setForeground(Color.WHITE);
	name.setFont(new Font("Roboto", Font.BOLD, 16));
	name.setBorder(null);
	name.setBackground(Color.GREEN);
	
	JLabel label = new JLabel("-");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 14));
	label.setBorder(null);
	label.setBackground(Color.GREEN);
	panel_4.add(label);
	
	JLabel classes = new JLabel("7 classes");
	panel_4.add(classes);
	classes.setHorizontalAlignment(SwingConstants.CENTER);
	classes.setForeground(Color.WHITE);
	classes.setFont(new Font("Roboto", Font.PLAIN, 14));
	classes.setBorder(null);
	classes.setBackground(Color.GREEN);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
	label_1.setPreferredSize(new Dimension(45, 0));
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(label_1, BorderLayout.EAST);
	
	JPanel panel1 = new JPanel();
	panel1.setPreferredSize(new Dimension(35, 40));
	panel1.setBackground(new Color(40, 40, 40));
	panel_1.add(panel1, BorderLayout.WEST);
	panel1.setLayout(new BorderLayout(0, 0));
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\check.png"));
	panel1.add(lblNewLabel_1, BorderLayout.CENTER);
	
	JPanel panel = new JPanel();
	panel.setBorder(null);
	panel.setPreferredSize(new Dimension(10, 95));
	add(panel, BorderLayout.CENTER);
	panel.setBackground(panel.getParent().getBackground());
	panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	
	
	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(40, 40, 40));
	(panel).add(panel_2);
	panel_2.setBorder(null);
	panel_2.setPreferredSize(new Dimension(panel_2.getParent().getParent().getPreferredSize().width*98/100, 75));
	panel_2.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_5 = new JPanel();
	panel_5.setPreferredSize(new Dimension(20, 25));
	panel_2.add(panel_5, BorderLayout.NORTH);
	panel_5.setBackground(panel_5.getParent().getBackground());
	panel_5.setLayout(new BorderLayout(0, 0));
	
	JLabel lblemeEconomique = new JLabel("3eme PF Economique");
	panel_5.add(lblemeEconomique);
	lblemeEconomique.setName("3eme PF Economique");
	lblemeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
	lblemeEconomique.setForeground(Color.WHITE);
	lblemeEconomique.setFont(new Font("Roboto", Font.BOLD, 14));
	lblemeEconomique.setBorder(null);
	lblemeEconomique.setBackground(Color.GREEN);
	lblemeEconomique.setPreferredSize(new Dimension(lblemeEconomique.getParent().getPreferredSize().width, 25));
	
	
	JButton btnRetirer = new JButton("  Voir la classe  ");
	btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
	btnRetirer.setForeground(Color.WHITE);
	btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
	btnRetirer.setFocusPainted(false);
	btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
	panel_5.add(btnRetirer, BorderLayout.EAST);
	btnRetirer.setBackground(btnRetirer.getParent().getBackground());
			
			JPanel panel_6 = new JPanel();
			panel_2.add(panel_6);
			panel_6.setBackground(panel_6.getParent().getBackground());
			panel_6.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
	
				
			JPanel panel_3 = new JPanel();
			panel_6.add(panel_3);
			panel_3.setBackground(new Color(40, 40, 40).darker());
			panel_3.setPreferredSize(new Dimension(panel_2.getPreferredSize().width, 25));
			panel_3.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
			
			JLabel lblFormationPatriotiqueEt = new JLabel("Entrepreneuriat");
			lblFormationPatriotiqueEt.setName("Entrepreneuriat");
			lblFormationPatriotiqueEt.setForeground(Color.WHITE);
			lblFormationPatriotiqueEt.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblFormationPatriotiqueEt.setBorder(null);
			lblFormationPatriotiqueEt.setBackground(Color.GREEN);
			panel_3.add(lblFormationPatriotiqueEt);
			
			JLabel label_2 = new JLabel("•");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Roboto", Font.BOLD, 14));
			label_2.setBorder(null);
			label_2.setBackground(Color.GREEN);
			panel_3.add(label_2);
			
			JLabel lblMoyenne_1 = new JLabel("Moyenne: 45%");
			lblMoyenne_1.setName("Entrepreneuriat");
			lblMoyenne_1.setForeground(Color.WHITE);
			lblMoyenne_1.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblMoyenne_1.setBorder(null);
			lblMoyenne_1.setBackground(Color.GREEN);
			panel_3.add(lblMoyenne_1);
			
			JLabel label_3 = new JLabel("•");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Roboto", Font.BOLD, 14));
			label_3.setBorder(null);
			label_3.setBackground(Color.GREEN);
			panel_3.add(label_3);
			
			JLabel lblReussiteA = new JLabel("Reussite a 56%");
			lblReussiteA.setName("Entrepreneuriat");
			lblReussiteA.setForeground(Color.WHITE);
			lblReussiteA.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblReussiteA.setBorder(null);
			lblReussiteA.setBackground(Color.GREEN);
			panel_3.add(lblReussiteA);
			
			JLabel label_4 = new JLabel("\u2022");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Roboto", Font.BOLD, 14));
			label_4.setBorder(null);
			label_4.setBackground(Color.GREEN);
			panel_3.add(label_4);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton.setBackground(new Color(20, 148, 198));
				}
				public void mouseExited(MouseEvent e) {
					btnNewButton.setBackground(btnNewButton.getParent().getBackground());
				}
			});
			btnNewButton.setPreferredSize(new Dimension(40, 25));
			btnNewButton.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
			panel_3.add(btnNewButton);
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(btnNewButton.getParent().getBackground());
			Home.addToolTip(btnNewButton, "Modifier");
			

	}
	
	
	public static void loadTeachers(String ay_id) {
		
		Home.panelProf.removeAll();
		
			Object[] lines1 = Home.loadActiveProfs(ay_id);
		
			
			for(int k = 0; k< lines1.length;k++) {
				

				if(k >0) {
					JSeparator separator = new JSeparator();
					separator.setPreferredSize(new Dimension(1000, 2));
					separator.setForeground(new Color(250, 250, 250, 100));
					Home.panelProf.add(separator);
				}
				
				Teacher te = new Teacher();
				((JLabel) ((Container) ((Container) te.getComponent(0)).getComponent(0)).getComponent(0)).setText(Teacher.getTeacherName(lines1[k].toString()));
				te.setName(lines1[k].toString());
				Home.panelProf.add(te);
				collapse(te);
				((Container) (te).getComponent(1)).removeAll();

			String classes;
			int numberOfClasses = loadNumberOfTeacherCourses(ay_id, lines1[k].toString());
			if(numberOfClasses>1) {
				classes = "cours";
			}else {
				classes = "cours";
			}
			((JLabel) ((Container) ((Container) te.getComponent(0)).getComponent(0)).getComponent(2)).setText(numberOfClasses+" "+classes);
			
			int j = k;
			((JLabel) ((Container) ((Container) te.getComponent(0)).getComponent(1))).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((te).getPreferredSize().height> 40) {
					collapse(te);
				}else {
					if(((Container) (te).getComponent(1)).getComponentCount() == 0) {
					loadClassesAndCourses(lines1[j].toString(), ay_id, (te).getComponent(1));
					//loadData(((Container) Home.panelProf.getComponent(k)).getComponent(1), ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
					expand(te);
					}
				}
			});
			
			((Container) (te).getComponent(0)).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2) {
						TeacherSchedule tc = new TeacherSchedule(lines1[j].toString(), ay_id);
						tc.setVisible(true);
					}
					if(selectedTeacher.equals(te)) {
						collapse(te);
					deselectAll(ay_id);
					}else {
						deselectAll(ay_id);
						selectedTeacher = te;
					(te).setBackground(new Color(20, 148, 198, 50));
					((Container) te).getComponent(0).setBackground(new Color(20, 148, 198, 0));
					(te).getComponent(1).setBackground(new Color(20, 148, 198, 0));
					((Container) (te).getComponent(0)).getComponent(0).setBackground(new Color(20, 148, 198, 0));
					((Container) (te).getComponent(0)).getComponent(1).setBackground(new Color(20, 148, 198, 0));
					((Container) (te).getComponent(0)).getComponent(2).setBackground(new Color(20, 148, 198, 0));
					(te).setBorder(new LineBorder(new Color(20, 148, 198), 2));
					
					((Container) te.getComponent(0)).getComponent(2).setVisible(true);
					
						if(((Container) (te).getComponent(1)).getComponentCount() == 0) {
						loadClassesAndCourses(lines1[j].toString(), ay_id, (te).getComponent(1));
						//loadData(((Container) Home.panelProf.getComponent(k)).getComponent(1), ay_id, Home.termsText.get(Home.selectedTermIndex));
						}
						expand(te);
						}
					
					
					
					TeacherInfo.selectedClass = 0;

					HomeMenu3.panel.getComponent(1).setVisible(true);
					HomeMenu3.panel.getComponent(2).setVisible(true);
					HomeMenu3.panel.getComponent(4).setVisible(true);
					HomeMenu3.panel.getComponent(5).setVisible(true);

					
					if((((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)))).equals(te)) {

						HomeMenu3.panel.getComponent(5).setVisible(false);}
					if((((Container) ((Container) Home.panelProf.getComponent(0)))).equals(te)) {
						HomeMenu3.panel.getComponent(4).setVisible(false);
						}
					Home.frame.revalidate();
					Home.frame.repaint();
					}
				public void mouseEntered(MouseEvent e) {
					if(!selectedTeacher.equals(te)) {

						(te).setBackground(new Color(60, 60, 60));
						((Container) te).getComponent(0).setBackground(new Color(60, 60, 60));
						(te).getComponent(1).setBackground(new Color(60, 60, 60));
						((Container) (te).getComponent(0)).getComponent(0).setBackground(new Color(60, 60, 60));
						((Container) (te).getComponent(0)).getComponent(1).setBackground(new Color(60, 60, 60));
						((Container) (te).getComponent(0)).getComponent(2).setBackground(new Color(60, 60, 60));
						(te).setBorder(new LineBorder(new Color(20, 148, 198)));
					//(te).setBorder(new LineBorder(Color.white, 2));
					Home.panelProf.revalidate();
					Home.panelProf.repaint();
					}
				}public void mouseExited(MouseEvent e) {
					if(!selectedTeacher.equals(te)) {
						(te).setBackground(new Color(40, 40, 40));
					((Container) te).getComponent(0).setBackground(new Color(40, 40, 40));
					(te).getComponent(1).setBackground(new Color(40, 40, 40));
					((Container) (te).getComponent(0)).getComponent(0).setBackground(new Color(40, 40, 40));
					((Container) (te).getComponent(0)).getComponent(1).setBackground(new Color(40, 40, 40));
					((Container) (te).getComponent(0)).getComponent(2).setBackground(new Color(40, 40, 40));
					(te).setBorder(null);
					//(te).setBorder(new LineBorder(new Color(211, 211, 211)));
					Home.panelProf.revalidate();
					Home.panelProf.repaint();
				}}
				
			});
			
		}
		Home.panelProf.revalidate();
		Home.panelProf.repaint();
		deselectAll(ay_id);
		
		if(Home.panelProf.getComponentCount() == 0) {
			JLabel lblNewLabel = new JLabel("Il n'y a actuellement aucun professeur enregistre dans cette annee scholaire.");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			Home.panelProf.add(lblNewLabel);
			

			Home.panelProf.revalidate();
			Home.panelProf.repaint();
		}
}
	
	public static void collapse(Container c) {
		(c).setPreferredSize(new Dimension((c).getPreferredSize().width, 40));
		//(c).getComponent(1).setVisible(false);
		//(c).getComponent(1).setPreferredSize(new Dimension((c).getComponent(1).getPreferredSize().width, 0));
		Home.panelProf.revalidate();
		Home.panelProf.repaint();
	}
	public static void expand(Container c) {
		(c).getComponent(1).setVisible(true);
		int panelWidth = 0;
		for(int j = 0; j< ((Container) (c).getComponent(1)).getComponentCount(); j++) {
			((Container) (c).getComponent(1)).getComponent(j).setPreferredSize(new Dimension(((Container) (c).getComponent(1)).getComponent(j).getPreferredSize().width,
					((Container) ((Container) ((Container) (c).getComponent(1)).getComponent(j)).getComponent(0)).getPreferredSize().height+
					((Container) ((Container) ((Container) (c).getComponent(1)).getComponent(j)).getComponent(1)).getComponentCount()*25+5));
			
		panelWidth = panelWidth+((Container) ((Container) (c).getComponent(1)).getComponent(j)).getPreferredSize().height;
		}
		(c).getComponent(1).setPreferredSize(new Dimension((c).getComponent(1).getPreferredSize().width, 
				panelWidth+(((Container) (c).getComponent(1)).getComponentCount()+2)*3));

		(c).setPreferredSize(new Dimension((c).getPreferredSize().width, (c).getComponent(0).getPreferredSize().height+(c).getComponent(1).getPreferredSize().height));
	
		(c).revalidate();
		(c).repaint();
		
	}
	
	public static void deselectAll(String ay_id) {
		for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
			if(((Container) Home.panelProf.getComponent(i)).getComponentCount()>0) {
				if(((Container) Home.panelProf.getComponent(i)) instanceof Teacher) {

					//collapse((Container) (JComponent) Home.panelProf.getComponent(i));
					((Container) (JComponent) Home.panelProf.getComponent(i)).getComponent(0).setBackground(new Color(40, 40, 40));
					((JComponent) Home.panelProf.getComponent(i)).setBackground(new Color(40, 40, 40));
					((JComponent) Home.panelProf.getComponent(i)).getComponent(1).setBackground(new Color(40, 40, 40));
					((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(0)).getComponent(0).setBackground(new Color(40, 40, 40));
					((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(0)).getComponent(1).setBackground(new Color(40, 40, 40));
					((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(0)).getComponent(2).setBackground(new Color(40, 40, 40));
					
			((JComponent) Home.panelProf.getComponent(i)).setBorder(null);
			((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(0)).getComponent(2).setVisible(false);
			if(((Container) Home.panelProf.getComponent(i)).getPreferredSize().height > 40) {
				
			}
				}}}
		selectedTeacher = new JLabel();
		Home.frame.revalidate();
		Home.frame.repaint();
		HomeMenu3.deselect();
	}
	
	public static int successRate(String ay_id, String classroom_id, String course_id) {
		int echecs = 0;
		int rate = 0;
			
			Object lines [] = Home.loadActiveStudents(classroom_id);
		
			for(int i = 0; i< lines.length; i++) {

				List l = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_id
						, course_id, Home.termsText.get(Home.selectedTermIndex), "All", "All");
				List l1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_id
						, course_id, Home.termsText.get(Home.selectedTermIndex), "All", "All");
				
				List<String> note = Arrays.asList(l.get(1).toString().split("/"));
				List<String> note1 = Arrays.asList(l1.get(1).toString().split("/"));
				
				Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
				Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
				
				if(points1!= 0 && maxima != 0) {
				if((maxima/2)>points1) {
					echecs = echecs+1;
				}
			if(lines.length>0) {
			rate = 100-echecs*100/lines.length;
			}else {
				rate = 100;
			}}else {
				rate = 0;
			}}
			return rate;
	}
	
	
	public static void loadClassesAndCourses(String teacher_id, String ay_id, Component c) {
		((JPanel)c).removeAll();
		
		
		List<String> s = new ArrayList();

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN courses_in_classroom AS cic "
					+ "JOIN classrooms as c "
					+ "JOIN courses as co "
					+ "JOIN classrooms_in_ay as cia "
					+ "WHERE cic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id  AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND c.classroom_id = cia.classroom_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ " AND cic.course_id = co.course_id AND co.is_active = 1");
			while(rs.next())
			{
				s.add(rs.getString("cic.cia_id"));
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}

					Object[] lines = s.toArray();
					List<String> classes = new ArrayList();
					
					for(int i = 0; i< lines.length; i++) {
						
						if(!classes.contains(lines[i].toString())) {
						classes.add(lines[i].toString());
						
						
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(new Color(40, 40, 40));
						((JPanel)c).add(panel_2);
						//panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
						panel_2.setPreferredSize(new Dimension(panel_2.getParent().getParent().getPreferredSize().width*98/100, 75));
						panel_2.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_5 = new JPanel();
						panel_5.setPreferredSize(new Dimension(20, 25));
						panel_2.add(panel_5, BorderLayout.NORTH);
						panel_5.setBackground(panel_5.getParent().getBackground());
						panel_5.setLayout(new BorderLayout(0, 0));
						
						JLabel lblemeEconomique = new JLabel(Class.getClassName(lines[i].toString()));
						panel_5.add(lblemeEconomique);
						lblemeEconomique.setName(lines[i].toString());
						lblemeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
						lblemeEconomique.setForeground(Color.WHITE);
						lblemeEconomique.setFont(new Font("Roboto", Font.BOLD, 14));
						lblemeEconomique.setBorder(null);
						lblemeEconomique.setBackground(Color.GREEN);
						lblemeEconomique.setPreferredSize(new Dimension(lblemeEconomique.getParent().getPreferredSize().width, 25));
						
						
						JButton btnRetirer = new JButton("  Voir la classe  ");
						btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
						btnRetirer.setForeground(Color.WHITE);
						btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
						btnRetirer.setFocusPainted(false);
						btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
						panel_5.add(btnRetirer, BorderLayout.EAST);
						btnRetirer.setBackground(btnRetirer.getParent().getBackground());
						
						
						btnRetirer.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								btnRetirer.setBackground(new Color(20, 148, 198));
								}
							public void mouseExited(MouseEvent e) {
								btnRetirer.setBackground(btnRetirer.getParent().getBackground());
								}
						});
						int k = i;
						btnRetirer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Application app = new Application(lines[k].toString());
								app.frame.setVisible(true);
								
								Home.frame.setVisible(false);
							}
							
						});
						
						
						
						JPanel panel_6 = new JPanel();
						panel_2.add(panel_6);
						panel_6.setBackground(panel_6.getParent().getBackground());
						panel_6.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
						
						List<String> s1 = new ArrayList();

						try {
							Statement stmt= mysql.con.createStatement();

							ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
									+ "JOIN classrooms as c "
									+ "JOIN classrooms_in_ay as cia "
									+ "JOIN courses as co "
									+ "JOIN courses_in_classroom as cic "
									+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
											+ "AND cic.cia_id = '"+lines[i].toString()+"' AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
							while(rs.next())
							{
								s1.add(rs.getString("cic.courses_in_classroom_id"));
							}

						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						}

									Object[] lines1 = s1.toArray();
									
						
						for(int j = 0; j< lines1.length; j++) {
									
							
							JPanel panel_3 = new JPanel();
							panel_6.add(panel_3);
							panel_3.setBackground(new Color(40, 40, 40).darker());
							panel_3.setPreferredSize(new Dimension(panel_2.getPreferredSize().width, 25));
							panel_3.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
							
							JLabel lblFormationPatriotiqueEt = new JLabel(TestBox.getShortName(lines1[j].toString()));
							lblFormationPatriotiqueEt.setName(lines1[j].toString());
							lblFormationPatriotiqueEt.setForeground(Color.WHITE);
							lblFormationPatriotiqueEt.setFont(new Font("Roboto", Font.PLAIN, 14));
							lblFormationPatriotiqueEt.setBorder(null);
							lblFormationPatriotiqueEt.setBackground(Color.GREEN);
							panel_3.add(lblFormationPatriotiqueEt);
							
							JLabel label_2 = new JLabel("•");
							label_2.setHorizontalAlignment(SwingConstants.CENTER);
							label_2.setForeground(Color.WHITE);
							label_2.setFont(new Font("Roboto", Font.BOLD, 14));
							label_2.setBorder(null);
							label_2.setBackground(Color.GREEN);
							panel_3.add(label_2);
							
							JLabel lblMoyenne_1 = new JLabel("Moyenne: 45%");
							lblMoyenne_1.setName("Entrepreneuriat");
							lblMoyenne_1.setForeground(Color.WHITE);
							lblMoyenne_1.setFont(new Font("Roboto", Font.PLAIN, 14));
							lblMoyenne_1.setBorder(null);
							lblMoyenne_1.setBackground(Color.GREEN);
							panel_3.add(lblMoyenne_1);
							
							JLabel label_3 = new JLabel("•");
							label_3.setHorizontalAlignment(SwingConstants.CENTER);
							label_3.setForeground(Color.WHITE);
							label_3.setFont(new Font("Roboto", Font.BOLD, 14));
							label_3.setBorder(null);
							label_3.setBackground(Color.GREEN);
							panel_3.add(label_3);
							
							JLabel lblReussiteA = new JLabel("Reussite a 56%");
							lblReussiteA.setName("Entrepreneuriat");
							lblReussiteA.setForeground(Color.WHITE);
							lblReussiteA.setFont(new Font("Roboto", Font.PLAIN, 14));
							lblReussiteA.setBorder(null);
							lblReussiteA.setBackground(Color.GREEN);
							panel_3.add(lblReussiteA);
						
							JLabel label_4 = new JLabel("\u2022");
							label_4.setHorizontalAlignment(SwingConstants.CENTER);
							label_4.setForeground(Color.WHITE);
							label_4.setFont(new Font("Roboto", Font.BOLD, 14));
							label_4.setBorder(null);
							label_4.setBackground(Color.GREEN);
							panel_3.add(label_4);
							
							JButton btnNewButton = new JButton("");
							btnNewButton.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									btnNewButton.setBackground(new Color(20, 148, 198));
								}
								public void mouseExited(MouseEvent e) {
									btnNewButton.setBackground(btnNewButton.getParent().getBackground());
								}
							});
							btnNewButton.setPreferredSize(new Dimension(40, 25));
							btnNewButton.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
							panel_3.add(btnNewButton);
							btnNewButton.setFocusPainted(false);
							btnNewButton.setBorder(null);
							btnNewButton.setBackground(btnNewButton.getParent().getBackground());
							Home.addToolTip(btnNewButton, "Stats");
							
							
							int m = j;
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									StatsPane frame = new StatsPane("All", lines1[m].toString(), lines[k].toString(), Home.termsText.get(Home.selectedTermIndex));
									frame.setVisible(true);
								
								}
							});
							

							List<String> l = new ArrayList();
							l.add("0");
							l.add("0/0");
							List<String> l1 = new ArrayList();
							l1.add("0");
							l1.add("0/0");
							if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
								l = CourseStats.getStudentTestsStats("All", lines[i].toString()
										, lines1[j].toString(), Home.termsText.get(Home.selectedTermIndex),"All", "All");
								}

							if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
								l1 = CourseStats.getStudentExamStats("All",  lines[i].toString()
										, lines1[j].toString(), Home.termsText.get(Home.selectedTermIndex),"All", "All");
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
					lblMoyenne_1.setText("Moyenne: "+new DecimalFormat("##.##").format(percentage)+"%");
						
						
						int rate = successRate(ay_id,  lines[i].toString()
								, lines1[j].toString());
				
						lblReussiteA.setText("Reussite a: "+rate+"%");
						
						
						
						(panel_3).addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

									deselectAll(ay_id);
									selectedTeacher = c.getParent();
									((JComponent) c.getParent()).setBorder(new LineBorder(new Color(20, 148, 198), 4));
									
									HomeMenu3.panel.getComponent(1).setVisible(true);
									HomeMenu3.panel.getComponent(2).setVisible(true);
									HomeMenu3.panel.getComponent(4).setVisible(true);
									HomeMenu3.panel.getComponent(5).setVisible(true);

									
									if((((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)))).equals(c.getParent())) {

										HomeMenu3.panel.getComponent(5).setVisible(false);
										}
									if((((Container) ((Container) Home.panelProf.getComponent(0)))).equals(c.getParent())) {
										HomeMenu3.panel.getComponent(4).setVisible(false);
										}
									
									((JComponent) (panel_2)).setBackground(new Color(255, 255, 255, 20));
									//((JComponent) (panel_2)).setBorder(new LineBorder(new Color(0, 255, 153), 2));
									
									Home.frame.revalidate();
									Home.frame.repaint();
									
									
									
									
									if(e.getClickCount() == 2) {
										StatsPane frame = new StatsPane("All", ((((JLabel) ((Container) ((Container) ((Container) c).getComponent(k)).getComponent(0))).getName())), ((JLabel) ((Container) ((Container) ((Container) c).getComponent(k)).getComponent(m)).getComponent(0)).getName(),
												Login.selectedAcademicYearID);
										frame.setVisible(true);
									}
								}
								public void mouseEntered(MouseEvent e) {
									if(((Container) (panel_2)).getBackground().equals(new Color(40, 40, 40))) {
									((Container) (panel_2)).setBackground(((Container) (panel_2)).getBackground().brighter());
									//((JComponent) (panel_2)).setBorder(new LineBorder(Color.white,2));
									Home.panelProf.revalidate();
									Home.panelProf.repaint();
									}
									//((JComponent) ((JComponent) ((Container) ((Container) c).getComponent(k))).getComponent(m)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
								}public void mouseExited(MouseEvent e) {
									if(((Container) (panel_2)).getBackground().equals(new Color(40, 40, 40).brighter())) {
									((Container) (panel_2)).setBackground(new Color(40, 40, 40));
									//((JComponent) (panel_2)).setBorder(new LineBorder(Color.LIGHT_GRAY));
									Home.panelProf.revalidate();
									Home.panelProf.repaint();
								}
									//((JComponent) ((JComponent) ((Container) ((Container) c).getComponent(k))).getComponent(m)).setBorder(null);
									}
						});
				
						
						
						
						
						
						}
				Home.panelProf.revalidate();
				Home.panelProf.repaint();
				
				
				
				
				
				panel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							deselectAll(ay_id);
							selectedTeacher = c.getParent();
							((JComponent) c.getParent()).setBorder(new LineBorder(new Color(20, 148, 198), 4));
							
							//Home.side.removeAll();
							TeacherInfo.selectedClass = 0;
							//TeacherInfo t = new TeacherInfo(teacher_id, ay_id);
							//Home.side.add(t);

							HomeMenu3.panel.getComponent(1).setVisible(true);
							HomeMenu3.panel.getComponent(2).setVisible(true);
							HomeMenu3.panel.getComponent(4).setVisible(true);
							HomeMenu3.panel.getComponent(5).setVisible(true);

							
							if((((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)))).equals(selectedTeacher)) {

								HomeMenu3.panel.getComponent(5).setVisible(false);}
							if((((Container) ((Container) Home.panelProf.getComponent(0)))).equals(selectedTeacher)) {
								HomeMenu3.panel.getComponent(4).setVisible(false);
								}
							
							(panel_2).setBackground(new Color(255, 255, 255, 20));
							//(panel_2).setBorder(new LineBorder(new Color(0, 255, 153), 2));
							
							Home.frame.revalidate();
							Home.frame.repaint();
							
							
							
							
							if(e.getClickCount() == 2) {
								Home.className = ((JLabel) ((Container) ((Container) ((Container) c).getComponent(k))).getComponent(0)).getText()
										.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "");
								Application a = new Application(((Container) ((Container) ((Container) c).getComponent(k))).getComponent(0).getName());
								a.frame.setVisible(true);
								
								Home.frame.setVisible(false);
							}
						}
						public void mouseEntered(MouseEvent e) {
							if(((Container) (panel_2)).getBackground().equals(new Color(40, 40, 40))) {
							((Container) (panel_2)).setBackground(((Container) (panel_2)).getBackground().brighter());
							//((JComponent) (panel_2)).setBorder(new LineBorder(Color.white,2));
							Home.panelProf.revalidate();
							Home.panelProf.repaint();
							}
						}public void mouseExited(MouseEvent e) {
							if(((Container) (panel_2)).getBackground().equals(new Color(40, 40, 40).brighter())) {
							((Container) (panel_2)).setBackground(new Color(40, 40, 40));
							//((JComponent) (panel_2)).setBorder(new LineBorder(Color.LIGHT_GRAY));
							Home.panelProf.revalidate();
							Home.panelProf.repaint();
						}}
						
					});
					}
					}
	
	}
	
	
	public static String getTeacherName(String teacher_id) {
		String name = null;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from teachers "
				+ "WHERE teacher_id = '"+teacher_id+"' LIMIT 1");
		while(rs.next())
		{
			name = rs.getString("last_name")+" "+rs.getString("first_name");
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return name;
	}
	
	
	public static int loadNumberOfTeacherCourses(String ay_id, String teacher_id) {
		

		int numberOfclass = 0;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select COUNT(*) from teachers_in_classrooms as tic "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cic.is_active = 1 AND cic.cia_id = cia.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"'");
		
		rs.next();
			numberOfclass = rs.getInt(1);
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
				return numberOfclass;
	}
	}
