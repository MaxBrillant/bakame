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
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Teacher extends JPanel {
	public static JPanel Box1;
	public static boolean isSelected;

	public static List <String> classList = new ArrayList();
	private JPanel panel_1;
	public static JLabel classes;
	public static JPanel panel;
	private JPanel panel_2;
	private JLabel label_1;
	private JLabel lblemeEconomique;
	private JPanel panel_3;
	private JLabel lblFormationPatriotiqueEt;
	private JLabel lblMoyenne;
	private JLabel lblTauxDeReussite;
	private JLabel label_2;
	private JLabel label_3;
	public static JLabel name;
	public static String selectedTeacher = "";
	

	/**
	 * Create the panel.
	 */
	public Teacher() {
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(new Color(60, 60, 60));
	setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
	setPreferredSize(new Dimension(700, 135));
	setLayout(new BorderLayout(0, 0));
	
	

	panel_1 = new JPanel();
	add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(null);
	panel_1.setBackground(panel_1.getParent().getBackground());
	
	name = new JLabel("Manirambona Ezequias");
	name.setForeground(Color.WHITE);
	name.setFont(new Font("Roboto", Font.BOLD, 20));
	name.setBorder(null);
	name.setBackground(Color.GREEN);
	name.setBounds(10, 0, 379, 35);
	panel_1.add(name);
	
	classes = new JLabel("7 classes");
	classes.setHorizontalAlignment(SwingConstants.CENTER);
	classes.setForeground(Color.WHITE);
	classes.setFont(new Font("Roboto", Font.BOLD, 20));
	classes.setBorder(null);
	classes.setBackground(Color.GREEN);
	classes.setBounds(399, 0, 118, 35);
	panel_1.add(classes);
	
	label_1 = new JLabel("");
	label_1.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
	label_1.setPreferredSize(new Dimension(45, 0));
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setBounds(641, 0, 45, 35);
	panel_1.add(label_1);
	
	panel = new JPanel();
	panel.setPreferredSize(new Dimension(10, 95));
	add(panel, BorderLayout.SOUTH);
	panel.setBackground(panel.getParent().getBackground());
	panel.setLayout(new WrapLayout(1, 3, 3));
	}
	
	
	public static void loadTeachers(String ay_id) {
		
		Home.panelProf.removeAll();
		
			Object[] lines1 = Home.loadActiveProfs(ay_id);
		
			
			for(int k = 0; k< lines1.length;k++) {
				
				Teacher te = new Teacher();
				te.name.setText(lines1[k].toString());
				te.setName(lines1[k].toString());
				Home.panelProf.add(te);
				collapse(k);
			}

		for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
			
			int k = i;
			String classes;
			int numberOfClasses = loadNumberOfTeacherClasses(ay_id, lines1[k].toString());
			if(numberOfClasses>1) {
				classes = "classes";
			}else {
				classes = "classe";
			}
			((JLabel) ((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).getComponent(1)).setText(numberOfClasses+" "+classes);
			((JLabel) ((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).getComponent(2)).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(((Container) Home.panelProf.getComponent(k)).getComponent(1).getPreferredSize().height>0) {
					collapse(k);
				}else {
					if(((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(1)).getComponentCount()==0) {
					loadClassesAndCourses(lines1[k].toString(), ay_id, ((Container) Home.panelProf.getComponent(k)).getComponent(1));
					loadData(((Container) Home.panelProf.getComponent(k)).getComponent(1), ay_id, Home.termsText.get(Home.selectedTermIndex));
					}
					expand(k);
					}
				}
			});
			
			((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					deselectAll(ay_id);
					selectedTeacher = ((JLabel) ((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).getComponent(0)).getText();
					((JComponent) Home.panelProf.getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198), 4));
					
					Home.side.removeAll();
					TeacherInfo.selectedClass = 0;
					TeacherInfo t = new TeacherInfo(lines1[k].toString(), ay_id);
					Home.side.add(t);

					HomeMenu3.panel.getComponent(1).setVisible(true);
					HomeMenu3.panel.getComponent(2).setVisible(true);
					HomeMenu3.panel.getComponent(4).setVisible(true);
					HomeMenu3.panel.getComponent(5).setVisible(true);

					
					if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)).getComponent(0)).getComponent(0)).getText().equals(selectedTeacher)) {

						HomeMenu3.panel.getComponent(5).setVisible(false);}
					if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(0)).getComponent(0)).getComponent(0)).getText().equals(selectedTeacher)) {
						HomeMenu3.panel.getComponent(4).setVisible(false);
						}
					Home.frame.revalidate();
					Home.frame.repaint();
					}
				public void mouseEntered(MouseEvent e) {
					if(!selectedTeacher.equals(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).getComponent(0)).getText())) {
					((JComponent) Home.panelProf.getComponent(k)).setBorder(new LineBorder(Color.white, 2));
					Home.panelProf.revalidate();
					Home.panelProf.repaint();
					}
				}public void mouseExited(MouseEvent e) {
					if(!selectedTeacher.equals(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(k)).getComponent(0)).getComponent(0)).getText())) {
					((JComponent) Home.panelProf.getComponent(k)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
					Home.panelProf.revalidate();
					Home.panelProf.repaint();
				}}
				
			});
			
		}
		Home.panelProf.revalidate();
		Home.panelProf.repaint();
		deselectAll(ay_id);
		
		if(Home.panelProf.getComponentCount() == 0) {
			JLabel lblNewLabel = new JLabel("Il n'y a actuellement aucun professeur dans cet etablissement.");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
			Home.panelProf.add(lblNewLabel);
			

			Home.panelProf.revalidate();
			Home.panelProf.repaint();
		}
}
	
	public static void collapse(int i) {
		((Container) Home.panelProf.getComponent(i)).setPreferredSize(new Dimension(((Container) Home.panelProf.getComponent(i)).getPreferredSize().width, 40));
		((Container) Home.panelProf.getComponent(i)).getComponent(1).setPreferredSize(new Dimension(((Container) Home.panelProf.getComponent(i)).getComponent(1).getPreferredSize().width, 0));

		Home.panelProf.revalidate();
		Home.panelProf.repaint();
	}
	public static void expand(int i) {
		int panelWidth = 0;
		for(int j = 0; j< ((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponentCount(); j++) {
			((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponent(j).setPreferredSize(new Dimension(((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponent(j).getPreferredSize().width,
					((Container) ((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponent(j)).getComponentCount()*25+5));
			
		panelWidth = panelWidth+((Container) ((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponent(j)).getComponentCount()*25+5;
		}
		((Container) Home.panelProf.getComponent(i)).getComponent(1).setPreferredSize(new Dimension(((Container) Home.panelProf.getComponent(i)).getComponent(1).getPreferredSize().width, 
				panelWidth+(((Container) ((Container) Home.panelProf.getComponent(i)).getComponent(1)).getComponentCount()+1)*3));

		((Container) Home.panelProf.getComponent(i)).setPreferredSize(new Dimension(((Container) Home.panelProf.getComponent(i)).getPreferredSize().width, 40+((Container) Home.panelProf.getComponent(i)).getComponent(1).getPreferredSize().height));
	
		((Container) Home.panelProf.getComponent(i)).revalidate();
		((Container) Home.panelProf.getComponent(i)).repaint();
		
	}
	
	public static void deselectAll(String ay_id) {
		for(int i = 0; i< Home.panelProf.getComponentCount(); i++) {
			if(((Container) Home.panelProf.getComponent(i)).getComponentCount()>0) {
				if(((Container) Home.panelProf.getComponent(i)) instanceof Teacher) {	
			((JComponent) Home.panelProf.getComponent(i)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));

			for(int j = 0; j< ((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(1)).getComponentCount(); j++) {

				((Container) ((Container) ((Container) ((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(1))).getComponent(j))).setBackground(new Color(40, 40, 40));
				((JComponent) ((Container) ((Container) ((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(1))).getComponent(j))).setBorder(new LineBorder(Color.LIGHT_GRAY));
				((Container) (((Container) ((Container) ((Container) ((JComponent) Home.panelProf.getComponent(i)).getComponent(1))).getComponent(j)).getComponent(0))).setForeground(Color.white);
				Home.panelProf.revalidate();
				Home.panelProf.repaint();
			}
		selectedTeacher = "";
		}}}
		MainInfo m = new MainInfo(ay_id);
		m.guide.setText("<html>- Cliquez sur un professeur pour le selectionner.<br/><br/>\r\n- Cliquez sur la fleche correspondante au professeur <br/>pour rapidement voir ses differentes performances <br/>dans differentes classes et cours.<br/><br/>\r\n- Selectionnez le professeur pour voir les options <br/>disponibles.<br/><br/>\r\n- Double-cliquez sur une des classes disponibles<br/> pour le professeur pour l'ouvrir.</html>");
		Home.side.removeAll();
		Home.side.add(m);
		Home.frame.revalidate();
		Home.frame.repaint();
		HomeMenu3.deselect();
	}
	
	public static int successRate(String ay_id, String classroom_id, String course_id) {
		int echecs = 0;
		int rate = 0;
			
			Object lines [] = Home.loadActiveStudents(classroom_id, ay_id);
		
			for(int i = 0; i< lines.length; i++) {

				List l = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_id
						, course_id, "Toute l'annee", "All", "All");
				List l1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_id
						, course_id, "Toute l'annee", "All", "All");
				
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
					+ "WHERE cic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id  AND c.is_active = 1 AND c.classroom_id = cic.classroom_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cic.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ " AND cic.course_id = co.course_id AND co.is_active = 1");
			while(rs.next())
			{
				s.add(rs.getString("cic.classroom_id"));
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}

					Object[] lines = s.toArray();
					
					for(int i = 0; i< lines.length; i++) {
						
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(new Color(40, 40, 40));
						panel_2.setPreferredSize(new Dimension(685, 75));
						((JPanel)c).add(panel_2);
						panel_2.setLayout(new WrapLayout(1, 0, 0));
						panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
						
						JLabel lblemeEconomique = new JLabel(Class.getClassName(lines[i].toString()));
						lblemeEconomique.setName(lines[i].toString());
						lblemeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
						lblemeEconomique.setForeground(Color.WHITE);
						lblemeEconomique.setFont(new Font("Roboto", Font.BOLD, 20));
						lblemeEconomique.setBorder(null);
						lblemeEconomique.setBackground(Color.GREEN);
						panel_2.add(lblemeEconomique);
						lblemeEconomique.setPreferredSize(new Dimension(lblemeEconomique.getParent().getPreferredSize().width, 25));
						
						
						List<String> s1 = new ArrayList();

						try {
							Statement stmt= mysql.con.createStatement();

							ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
									+ "JOIN classrooms as c "
									+ "JOIN classrooms_in_ay as cia "
									+ "JOIN courses as co "
									+ "JOIN courses_in_classroom as cic "
									+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND c.classroom_id = cic.classroom_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cic.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
											+ "AND cic.classroom_id = '"+lines[i].toString()+"' AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
							while(rs.next())
							{
								s1.add(rs.getString("cic.course_id"));
							}

						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						}

									Object[] lines1 = s1.toArray();
									
						
						for(int j = 0; j< lines1.length; j++) {
									
								JPanel panel_3 = new JPanel();
								panel_2.add(panel_3);
								panel_3.setBackground(new Color(40, 40, 40).darker());
								panel_3.setPreferredSize(new Dimension(panel_3.getParent().getPreferredSize().width*99/100, 25));
								panel_3.setLayout(null);
								
								JLabel lblFormationPatriotiqueEt = new JLabel();
								lblFormationPatriotiqueEt.setName(lines1[j].toString());
								lblFormationPatriotiqueEt.setForeground(Color.WHITE);
								lblFormationPatriotiqueEt.setFont(new Font("Roboto", Font.BOLD, 18));
								lblFormationPatriotiqueEt.setBorder(null);
								lblFormationPatriotiqueEt.setBackground(Color.GREEN);
								lblFormationPatriotiqueEt.setBounds(10, 0, 287, 25);
								panel_3.add(lblFormationPatriotiqueEt);
								
								
								JLabel lblMoyenne = new JLabel();
								lblMoyenne.setHorizontalAlignment(SwingConstants.CENTER);
								lblMoyenne.setForeground(Color.WHITE);
								lblMoyenne.setFont(new Font("Roboto", Font.BOLD, 16));
								lblMoyenne.setBorder(null);
								lblMoyenne.setBackground(Color.GREEN);
								lblMoyenne.setBounds(300, 0, 169, 25);
								panel_3.add(lblMoyenne);
								
								JLabel lblTauxDeReussite = new JLabel();
								lblTauxDeReussite.setHorizontalAlignment(SwingConstants.CENTER);
								lblTauxDeReussite.setForeground(Color.WHITE);
								lblTauxDeReussite.setFont(new Font("Roboto", Font.BOLD, 16));
								lblTauxDeReussite.setBorder(null);
								lblTauxDeReussite.setBackground(Color.GREEN);
								lblTauxDeReussite.setBounds(479, 0, 189, 25);
								panel_3.add(lblTauxDeReussite);
								
								JLabel label_2 = new JLabel("•");
								label_2.setHorizontalAlignment(SwingConstants.CENTER);
								label_2.setForeground(Color.WHITE);
								label_2.setFont(new Font("Roboto", Font.BOLD, 18));
								label_2.setBorder(null);
								label_2.setBackground(Color.GREEN);
								label_2.setBounds(460, 0, 22, 25);
								panel_3.add(label_2);
								
								JLabel label_3 = new JLabel("•");
								label_3.setHorizontalAlignment(SwingConstants.CENTER);
								label_3.setForeground(Color.WHITE);
								label_3.setFont(new Font("Roboto", Font.BOLD, 18));
								label_3.setBorder(null);
								label_3.setBackground(Color.GREEN);
								label_3.setBounds(290, 0, 22, 25);
								panel_3.add(label_3);
									
						}}
				Home.panelProf.revalidate();
				Home.panelProf.repaint();
				
				for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
					int k = i;
					((Container) ((Container) ((Container) c).getComponent(i))).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							deselectAll(ay_id);
							selectedTeacher = ((JLabel) ((Container) ((Container) c.getParent()).getComponent(0)).getComponent(0)).getName();
							((JComponent) c.getParent()).setBorder(new LineBorder(new Color(20, 148, 198), 4));
							
							Home.side.removeAll();
							TeacherInfo.selectedClass = 0;
							TeacherInfo t = new TeacherInfo(teacher_id, ay_id);
							Home.side.add(t);

							HomeMenu3.panel.getComponent(1).setVisible(true);
							HomeMenu3.panel.getComponent(2).setVisible(true);
							HomeMenu3.panel.getComponent(4).setVisible(true);
							HomeMenu3.panel.getComponent(5).setVisible(true);



							TeacherInfo.selectedClass = k;
							TeacherInfo.loadTeacherInfo(teacher_id, ay_id, TeacherInfo.classes.get(TeacherInfo.selectedClass));
							
							if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)).getComponent(0)).getComponent(0)).getName().equals(selectedTeacher)) {

								HomeMenu3.panel.getComponent(5).setVisible(false);}
							if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(0)).getComponent(0)).getComponent(0)).getName().equals(selectedTeacher)) {
								HomeMenu3.panel.getComponent(4).setVisible(false);
								}
							
							((JComponent) ((Container) ((Container) c).getComponent(k))).setBackground(new Color(255, 255, 255, 20));
							((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(new Color(0, 255, 153), 2));
							
							Home.frame.revalidate();
							Home.frame.repaint();
							
							
							
							
							if(e.getClickCount() == 2) {
								Home.className = ((JLabel) ((Container) ((Container) ((Container) c).getComponent(k))).getComponent(0)).getText()
										.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "");
								Application a = new Application(((Container) ((Container) ((Container) c).getComponent(k))).getComponent(0).getName(), ay_id);
								a.frame.setVisible(true);
								
								Home.frame.setVisible(false);
							}
						}
						public void mouseEntered(MouseEvent e) {
							if(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().equals(new Color(40, 40, 40))) {
							((Container) ((Container) ((Container) c).getComponent(k))).setBackground(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().brighter());
							((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(Color.white,2));
							Home.panelProf.revalidate();
							Home.panelProf.repaint();
							}
						}public void mouseExited(MouseEvent e) {
							if(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().equals(new Color(40, 40, 40).brighter())) {
							((Container) ((Container) ((Container) c).getComponent(k))).setBackground(new Color(40, 40, 40));
							((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(Color.LIGHT_GRAY));
							Home.panelProf.revalidate();
							Home.panelProf.repaint();
						}}
						
					});
					

					
					
					
					for(int j = 1; j< ((Container) ((Container) c).getComponent(i)).getComponentCount(); j++) {
						int m = j;
						(((Container) ((Container) c).getComponent(i)).getComponent(j)).addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

									deselectAll(ay_id);
									selectedTeacher = ((JLabel) ((Container) ((Container) c.getParent()).getComponent(0)).getComponent(0)).getName();
									((JComponent) c.getParent()).setBorder(new LineBorder(new Color(20, 148, 198), 4));
									
									Home.side.removeAll();
									TeacherInfo.selectedClass = 0;
									TeacherInfo t = new TeacherInfo(teacher_id, ay_id);
									Home.side.add(t);

									HomeMenu3.panel.getComponent(1).setVisible(true);
									HomeMenu3.panel.getComponent(2).setVisible(true);
									HomeMenu3.panel.getComponent(4).setVisible(true);
									HomeMenu3.panel.getComponent(5).setVisible(true);

									TeacherInfo.selectedClass = k;
									TeacherInfo.loadTeacherInfo(teacher_id, ay_id, TeacherInfo.classes.get(TeacherInfo.selectedClass));
									
									if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(Home.panelProf.getComponentCount()-1)).getComponent(0)).getComponent(0)).getText().equals(selectedTeacher)) {

										HomeMenu3.panel.getComponent(5).setVisible(false);}
									if(((JLabel) ((Container) ((Container) Home.panelProf.getComponent(0)).getComponent(0)).getComponent(0)).getText().equals(selectedTeacher)) {
										HomeMenu3.panel.getComponent(4).setVisible(false);
										}
									
									((JComponent) ((Container) ((Container) c).getComponent(k))).setBackground(new Color(255, 255, 255, 20));
									((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(new Color(0, 255, 153), 2));
									
									Home.frame.revalidate();
									Home.frame.repaint();
									
									
									
									
									if(e.getClickCount() == 2) {
										StatsPane frame = new StatsPane("All", ((((JLabel) ((Container) ((Container) ((Container) c).getComponent(k)).getComponent(0))).getName())), ((JLabel) ((Container) ((Container) ((Container) c).getComponent(k)).getComponent(m)).getComponent(0)).getName(),
												Login.selectedAcademicYearID, ay_id);
										frame.setVisible(true);
									}
								}
								public void mouseEntered(MouseEvent e) {
									if(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().equals(new Color(40, 40, 40))) {
									((Container) ((Container) ((Container) c).getComponent(k))).setBackground(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().brighter());
									((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(Color.white,2));
									Home.panelProf.revalidate();
									Home.panelProf.repaint();
									}
									((JComponent) ((JComponent) ((Container) ((Container) c).getComponent(k))).getComponent(m)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
								}public void mouseExited(MouseEvent e) {
									if(((Container) ((Container) ((Container) c).getComponent(k))).getBackground().equals(new Color(40, 40, 40).brighter())) {
									((Container) ((Container) ((Container) c).getComponent(k))).setBackground(new Color(40, 40, 40));
									((JComponent) ((Container) ((Container) c).getComponent(k))).setBorder(new LineBorder(Color.LIGHT_GRAY));
									Home.panelProf.revalidate();
									Home.panelProf.repaint();
								}
									((JComponent) ((JComponent) ((Container) ((Container) c).getComponent(k))).getComponent(m)).setBorder(null);}
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
	public static void loadData(Component c, String ay_id, String term_id) {
		
			for(int j = 0; j< ((Container) c).getComponentCount(); j++) {
				for(int m = 1; m<((Container) ((Container) c).getComponent(j)).getComponentCount(); m++) {
					List<String> l = new ArrayList();
					l.add("0");
					l.add("0/0");
					List<String> l1 = new ArrayList();
					l1.add("0");
					l1.add("0/0");
					if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
						l = CourseStats.getStudentTestsStats("All", ((JLabel) ((Container) (((Container) c).getComponent(j))).getComponent(0)).getName()
								, ((JLabel) (((Container) (((Container) (((Container) c).getComponent(j))).getComponent(m))).getComponent(0))).getName(), term_id,"All", "All");
						}

					if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
						l1 = CourseStats.getStudentExamStats("All", ((JLabel) ((Container) (((Container) c).getComponent(j))).getComponent(0)).getName()
								, ((JLabel) (((Container) (((Container) (((Container) c).getComponent(j))).getComponent(m))).getComponent(0))).getName(), term_id,"All", "All");
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
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(j)).getComponent(m)).getComponent(1)).setText("Moyenne: "+new DecimalFormat("##.##").format(percentage)+"%");
				
				
				int rate = successRate(ay_id, ((JLabel) ((Container) (((Container) c).getComponent(j))).getComponent(0)).getName()
						, ((JLabel) (((Container) (((Container) (((Container) c).getComponent(j))).getComponent(m))).getComponent(0))).getName());
		
				((JLabel) ((Container) ((Container) ((Container) c).getComponent(j)).getComponent(m)).getComponent(2)).setText("Taux de reussite: "+rate+"%");
				
				}
			}
		
		Home.panelProf.revalidate();
		Home.panelProf.repaint();
	}
	
	
	public static int loadNumberOfTeacherClasses(String ay_id, String teacher_id) {
		

		int numberOfclass = 0;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from teachers_in_classrooms as tic "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cic.is_active = 1 AND c.classroom_id = cic.classroom_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cic.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"'");
		while(rs.next())
		{
			numberOfclass++;
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
				return numberOfclass;
	}
	}
