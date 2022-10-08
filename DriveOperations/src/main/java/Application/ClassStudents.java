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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.Application;
import Class.Course;
import Class.ExamBox;
import Class.ExamInfo;
import Class.NewExam;
import Class.Student;
import Class.TestBox;
import Class.OptionsMenu.HomeMenu2;
import CloudOperations.aws;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.App;
import app.WrapLayout;
import sideInformation.MainInfo;
import sideInformation.StudentInfo;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ClassStudents extends JPanel {
	
	private static String selectedStudent = "";
	private List<String>courses = new ArrayList();
	public static int selectedCourse;
	

	/**
	 * Create the panel.
	 */
	
	public ClassStudents(String start, String end) {
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(new Color(40, 40, 40));
	//setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
	setPreferredSize(new Dimension(700, 135));
	setLayout(new BorderLayout(0, 0));
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(50, 65));
	add(panel_1, BorderLayout.NORTH);
	panel_1.setBackground(panel_1.getParent().getBackground());
	panel_1.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_7 = new JPanel();
	panel_1.add(panel_7);
	panel_7.setLayout(new BorderLayout(0, 0));
	panel_7.setBackground(panel_7.getParent().getBackground());
	
	JLabel name = new JLabel("  3eme PF Economique");
	panel_7.add(name);
	name.setForeground(Color.WHITE);
	name.setFont(new Font("Roboto", Font.BOLD, 16));
	name.setBorder(null);
	name.setBackground(Color.GREEN);
	
	JPanel panel_6 = new JPanel();
	panel_6.setPreferredSize(new Dimension(10, 25));
	panel_7.add(panel_6, BorderLayout.SOUTH);
	panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 2));
	panel_6.setBackground(panel_6.getParent().getBackground());
	
	JComboBox combo1 = new JComboBox();
	panel_6.add(combo1);
	combo1.setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs", "Interrogations", "Progression"}));
	combo1.setFont(new Font("Roboto", Font.PLAIN, 15));
	combo1.putClientProperty("JComboBox.roundRect", true);
	UIManager.put("JComboBox.arc", 100);
	
	JComboBox combo2 = new JComboBox();
	combo2.setPreferredSize(new Dimension(150, 25));
	panel_6.add(combo2);
	combo2.setModel(new DefaultComboBoxModel(new String[] {"COGE", "MAFINA", "COANA", "Maths", "Economie", "Entrepreneuriat", "Droit", "FPH", "Francais", "Anglais", "Kirundi", "Kiswahili"}));
	combo2.setFont(new Font("Roboto", Font.PLAIN, 15));
	
	JComboBox combo3 = new JComboBox();
	panel_6.add(combo3);
	combo3.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "7", "10"}));
	combo3.setFont(new Font("Roboto", Font.PLAIN, 15));
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(ResizeImages.resize(30, 30, "Icons\\drop2.png"));
	label_1.setPreferredSize(new Dimension(45, 0));
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(label_1, BorderLayout.EAST);
	
	JPanel panel = new JPanel();
	panel.setBorder(null);
	panel.setPreferredSize(new Dimension(10, 95));
	add(panel, BorderLayout.CENTER);
	panel.setBackground(panel.getParent().getBackground());
	panel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
	
	JPanel panel_5 = new JPanel();
	panel_5.setBackground(new Color(40, 40, 40).darker());
	panel_5.setPreferredSize(new Dimension(690, 25));
	//panel.add(panel_5);
	panel_5.setLayout(null);
	
	JLabel lbler = new JLabel("1");
	lbler.setHorizontalAlignment(SwingConstants.CENTER);
	lbler.setForeground(Color.WHITE);
	lbler.setFont(new Font("Roboto", Font.PLAIN, 16));
	lbler.setBorder(null);
	lbler.setBackground(Color.GREEN);
	lbler.setBounds(10, 0, 69, 25);
	panel_5.add(lbler);
	
	JLabel lblUmuhozaChrisKoen = new JLabel("IMPUNDU Gaella");
	lblUmuhozaChrisKoen.setForeground(Color.WHITE);
	lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.PLAIN, 16));
	lblUmuhozaChrisKoen.setBorder(null);
	lblUmuhozaChrisKoen.setBackground(Color.GREEN);
	lblUmuhozaChrisKoen.setBounds(116, 0, 344, 25);
	panel_5.add(lblUmuhozaChrisKoen);
	
	JLabel label = new JLabel("86,43%");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 16));
	label.setBorder(null);
	label.setBackground(Color.GREEN);
	label.setBounds(499, 0, 143, 25);
	panel_5.add(label);
	
	JPanel panel_4 = new JPanel();
	panel_4.setPreferredSize(new Dimension(50, 25));
	add(panel_4, BorderLayout.SOUTH);
	panel_4.setLayout(new BorderLayout(0, 0));
	panel_4.setBackground(panel_4.getParent().getBackground());
	
	JLabel lblVoirLaClasse = new JLabel("Voir la classe");
	lblVoirLaClasse.setHorizontalAlignment(SwingConstants.CENTER);
	lblVoirLaClasse.setForeground(Color.WHITE);
	lblVoirLaClasse.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblVoirLaClasse.setBorder(null);
	lblVoirLaClasse.setBackground(Color.GREEN);
	panel_4.add(lblVoirLaClasse);
	
	JButton reverse = new JButton("Croissant");
	reverse.setHorizontalTextPosition(SwingConstants.LEADING);
	reverse.setForeground(Color.LIGHT_GRAY);
	reverse.setFont(new Font("Roboto", Font.PLAIN, 14));
	reverse.setFocusPainted(false);
	reverse.setBorderPainted(false);
	reverse.setIcon(ResizeImages.resize(20, 20, "Icons\\up.png"));
	panel_4.add(reverse, BorderLayout.EAST);
	reverse.setBackground(reverse.getParent().getBackground().brighter());

	
	
	
	JPanel panel_51 = new JPanel();
	panel_51.setBackground(new Color(40, 40, 40).darker());
	panel_51.setPreferredSize(new Dimension(690, 25));
	(panel).add(panel_51);
	panel_51.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
	
	JLabel lbler1 = new JLabel(String.valueOf(1));
	lbler1.setHorizontalAlignment(SwingConstants.CENTER);
	lbler1.setForeground(Color.WHITE);
	lbler1.setFont(new Font("Roboto", Font.BOLD, 16));
	lbler1.setBorder(null);
	lbler1.setBackground(Color.GREEN);
	panel_51.add(lbler1);
	
	JLabel label_4 = new JLabel("\u2022");
	label_4.setHorizontalAlignment(SwingConstants.CENTER);
	label_4.setForeground(Color.WHITE);
	label_4.setFont(new Font("Roboto", Font.BOLD, 14));
	label_4.setBorder(null);
	label_4.setBackground(Color.GREEN);
	panel_51.add(label_4);
	
	JLabel lblUmuhozaChrisKoen1 = new JLabel("UMUHOZA Chris Koen Michael");
	//lblUmuhozaChrisKoen1.setName(lines[i].toString());
	lblUmuhozaChrisKoen1.setForeground(Color.WHITE);
	lblUmuhozaChrisKoen1.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblUmuhozaChrisKoen1.setBorder(null);
	lblUmuhozaChrisKoen1.setBackground(Color.GREEN);
	panel_51.add(lblUmuhozaChrisKoen1);
	
	JLabel label_5 = new JLabel("\u2022");
	label_5.setHorizontalAlignment(SwingConstants.CENTER);
	label_5.setForeground(Color.WHITE);
	label_5.setFont(new Font("Roboto", Font.BOLD, 14));
	label_5.setBorder(null);
	label_5.setBackground(Color.GREEN);
	panel_51.add(label_5);
	

	JLabel label1 = new JLabel("78%");
	label1.setHorizontalAlignment(SwingConstants.CENTER);
	label1.setForeground(Color.WHITE);
	label1.setFont(new Font("Roboto", Font.PLAIN, 14));
	label1.setBorder(null);
	label1.setBackground(Color.GREEN);
	panel_51.add(label1);
	
	JLabel label_6 = new JLabel("\u2022");
	label_6.setHorizontalAlignment(SwingConstants.CENTER);
	label_6.setForeground(Color.WHITE);
	label_6.setFont(new Font("Roboto", Font.BOLD, 14));
	label_6.setBorder(null);
	label_6.setBackground(Color.GREEN);
	panel_51.add(label_6);
	
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
	btnNewButton.setIcon(ResizeImages.resize(20, 20, "Icons\\stats.png"));
	panel_51.add(btnNewButton);
	btnNewButton.setFocusPainted(false);
	btnNewButton.setBorder(null);
	btnNewButton.setBackground(btnNewButton.getParent().getBackground());
	Home.addToolTip(btnNewButton, "Stats");

	
	
	}
	
	
	public List<String> getCourses() {
		return this.courses;
	}


	public void setCourses(List<String> courses) {
		this.courses = courses;
	}


	public static void loadStudents(String start, String end, String ay_id) {
		
		Home.panelStudents.removeAll();

			Object[] lines1 =Home.loadActiveClasses(ay_id);
			
			for(int k = 0; k< lines1.length;k++) {
				
				if(k >0) {
					JSeparator separator = new JSeparator();
					separator.setPreferredSize(new Dimension(1000, 2));
					separator.setForeground(new Color(250, 250, 250, 100));
					Home.panelStudents.add(separator);
				}
				
					ClassStudents te = new ClassStudents(start, end);
					Home.panelStudents.add(te);
					
		Container comboPane = (Container) ((Container) (((Container) ((te).getComponent(0))).getComponent(0))).getComponent(1);
		JLabel name = (JLabel) ((Container) (((Container) ((te).getComponent(0))).getComponent(0))).getComponent(0);
					
				name.setText(Class.getClassName(lines1[k].toString()));
				te.setName(lines1[k].toString());
				populateBox(lines1[k].toString(), (JComboBox) comboPane.getComponent(1), te);
				Home.panelStudents.revalidate();
				Home.panelStudents.repaint();
				name.setName(lines1[k].toString());
				((Container) (te).getComponent(1)).removeAll();

				//collapse(k);

				int l = k;
				((JComboBox) comboPane.getComponent(0)).addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			//	loadData(te, t.get(0).toString());

				deselectAll(ay_id);

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {

					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
	        		loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst(te);
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
					loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast(te);
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			
			}
		});
				((JComboBox) comboPane.getComponent(1)).addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			//	loadData(te, t.get(0).toString());
				deselectAll(ay_id);
				selectedCourse = ((JComboBox) comboPane.getComponent(1)).getSelectedIndex();

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
						
				loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst(te);
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
					loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast(te);
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			
			}
		});
		((JComboBox) comboPane.getComponent(2)).addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
				
        		
				loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				deselectAll(ay_id);

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					String start1 = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end1 = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
	        				
				loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start1, end1);
				rankFromLastToFirst(te);
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start1 = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end1 = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
	        		
					loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start1, end1);
					rankFromFirstToLast(te);
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			}
		});
		((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					deselectAll(ay_id);
					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
				loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst(te);
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					deselectAll(ay_id);
					String start = (HomeMenu2.dateChooser.getSelectedYear()+"-"+(HomeMenu2.dateChooser.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser.getSelectedDay());
	        		String end = (HomeMenu2.dateChooser_1.getSelectedYear())+"-"+(HomeMenu2.dateChooser_1.getSelectedMonth()+1)+"-"+HomeMenu2.dateChooser_1.getSelectedDay();
					
					loadData(te, te.getCourses().get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast(te);
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			}
		});
		
		((JLabel) ((Container) te.getComponent(2)).getComponent(0)).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application a = new Application(te.getName());
				a.frame.setVisible(true);
				
				Home.frame.setVisible(false);
				
				
			}
			public void mouseEntered(MouseEvent e) {
				((JLabel) ((Container) te.getComponent(2)).getComponent(0)).setForeground(new Color(20, 148, 198));
			}public void mouseExited(MouseEvent e) {
				((JLabel) ((Container) te.getComponent(2)).getComponent(0)).setForeground(Color.white);
			}
		});

		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();

			collapse(te);
			((Container) (te).getComponent(0)).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((te).getComponent(1).getPreferredSize().height>0) {
					collapse(te);
					//((Container) (te).getComponent(0)).getComponent(2).setVisible(false);
					//((Container) (te).getComponent(0)).getComponent(3).setVisible(false);
					//((Container) (te).getComponent(0)).getComponent(4).setVisible(false);
				}else {
					expand(te);
					if((((JPanel)((JPanel) (te)).getComponent(1))).getComponentCount()==0) {
					loadData((te), te.getCourses().get(selectedCourse), te.getName(), ay_id, start, end);

					rankFromFirstToLast(te);
					}
					//((Container) (te).getComponent(0)).getComponent(2).setVisible(true);
					//((Container) (te).getComponent(0)).getComponent(3).setVisible(true);
					//((Container) (te).getComponent(0)).getComponent(4).setVisible(true);
					}
				}
			});
			
		}
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();
}
	
	
	
	
	public static void loadData(Component te, String course_in_classroom_id, String classroom_in_ay_id, String ay_id, String start, String end) {
		(((JPanel)((JPanel) te).getComponent(1))).removeAll();
		
			Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);

			for(int i = 0; i< lines.length; i++) {

				
				
				JPanel panel_5 = new JPanel();
				panel_5.setName(lines[i].toString());
				panel_5.setBackground(new Color(40, 40, 40).darker());
				panel_5.setPreferredSize(new Dimension(690, 25));
				(((JPanel)((JPanel) te).getComponent(1))).add(panel_5);
				panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
				
				JLabel lbler1 = new JLabel(String.valueOf(i+1));
				lbler1.setHorizontalAlignment(SwingConstants.CENTER);
				lbler1.setForeground(Color.WHITE);
				lbler1.setFont(new Font("Roboto", Font.BOLD, 14));
				lbler1.setBorder(null);
				lbler1.setBackground(Color.GREEN);
				panel_5.add(lbler1);
				
				JLabel label_4 = new JLabel("\u2022");
				label_4.setHorizontalAlignment(SwingConstants.CENTER);
				label_4.setForeground(Color.WHITE);
				label_4.setFont(new Font("Roboto", Font.BOLD, 14));
				label_4.setBorder(null);
				label_4.setBackground(Color.GREEN);
				panel_5.add(label_4);
				
				JLabel lblUmuhozaChrisKoen1 = new JLabel(Home.getStudentName(lines[i].toString()));
				//lblUmuhozaChrisKoen1.setName(lines[i].toString());
				lblUmuhozaChrisKoen1.setForeground(Color.WHITE);
				lblUmuhozaChrisKoen1.setFont(new Font("Roboto", Font.PLAIN, 14));
				lblUmuhozaChrisKoen1.setBorder(null);
				lblUmuhozaChrisKoen1.setBackground(Color.GREEN);
				panel_5.add(lblUmuhozaChrisKoen1);
				
				JLabel label_5 = new JLabel("\u2022");
				label_5.setHorizontalAlignment(SwingConstants.CENTER);
				label_5.setForeground(Color.WHITE);
				label_5.setFont(new Font("Roboto", Font.BOLD, 14));
				label_5.setBorder(null);
				label_5.setBackground(Color.GREEN);
				panel_5.add(label_5);
				
				
				
				String value = null;
	
		Container comboPane = (Container) ((Container) (((Container) (((Container) (te)).getComponent(0))).getComponent(0))).getComponent(1);
	if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()>=0) {
					
					

					List list = new ArrayList();
					list.add("0");
					list.add("0/0");
					List list1 = new ArrayList();
					list1.add("0");
					list1.add("0/0");
					if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
						
						if(((JComboBox) (comboPane).getComponent(1)).getSelectedIndex()>0) {
						list  = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_in_ay_id
								, course_in_classroom_id, "Toute l'annee", start, end);
						}else{
							list  = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_in_ay_id
									, "All", "Toute l'annee", start, end);
						}}
					if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
						if(((JComboBox) (comboPane).getComponent(1)).getSelectedIndex()>0) {
							list1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_in_ay_id
								, course_in_classroom_id, "Toute l'annee", start, end);
						}else{
							list1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_in_ay_id
								, "All", "Toute l'annee", start, end);
							}
						}
					
					List<String> note = Arrays.asList(list.get(1).toString().split("/"));
					List<String> note1 = Arrays.asList(list1.get(1).toString().split("/"));
					
					Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."))+Double.parseDouble(note1.get(0).replaceAll(",", "."));
					Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."))+Double.parseDouble(note1.get(1).replaceAll(",", "."));
					
					Double percentage;
					if(points1 == 0 && maxima== 0) {
						percentage = (double) 0;
					}else {
					percentage = points1*100/maxima;
					}
					if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==0){
					value = new DecimalFormat("##.##").format(percentage)+"%";
					}if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==1) {
					value = new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima);
					}if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==3) {
						value = String.valueOf(((List)list.get(6)).toArray().length);
					}if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==4) {
						value = list.get(5).toString()+"%";
					}
					
					if(((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==2) {
						if(((JComboBox) (comboPane).getComponent(1)).getSelectedIndex()==0) {
							value = String.valueOf(StudentStats.getNumberOfechecs(lines[i].toString(), course_in_classroom_id, classroom_in_ay_id, "Toute l'annee", start, end));
						}
						
					}
				}
				
				if(((JComboBox) (comboPane).getComponent(1)).getSelectedIndex()>0 && ((JComboBox) (comboPane).getComponent(0)).getSelectedIndex()==2) {
					value = StudentStats.getEchecsInPoints(lines[i].toString(), course_in_classroom_id, classroom_in_ay_id, "Toute l'annee", start, end)+" pts";
				}
				


				JLabel label1 = new JLabel(value);
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				label1.setForeground(Color.WHITE);
				label1.setFont(new Font("Roboto", Font.PLAIN, 14));
				label1.setBorder(null);
				label1.setBackground(Color.GREEN);
				panel_5.add(label1);
				
				JLabel label_6 = new JLabel("\u2022");
				label_6.setHorizontalAlignment(SwingConstants.CENTER);
				label_6.setForeground(Color.WHITE);
				label_6.setFont(new Font("Roboto", Font.BOLD, 14));
				label_6.setBorder(null);
				label_6.setBackground(Color.GREEN);
				panel_5.add(label_6);
				
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
				btnNewButton.setIcon(ResizeImages.resize(20, 20, "Icons\\stats.png"));
				panel_5.add(btnNewButton);
				btnNewButton.setFocusPainted(false);
				btnNewButton.setBorder(null);
				btnNewButton.setBackground(btnNewButton.getParent().getBackground());
				Home.addToolTip(btnNewButton, "Stats");
				

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						StatsPane frame = new StatsPane(panel_5.getName(), "All", classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
						frame.setVisible(true);
						}
				});
				

			panel_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					deselectAll(ay_id);
					(panel_5).setBackground(new Color(20, 148, 198));
					selectedStudent = (panel_5).getName();
					Home.frame.revalidate();
					Home.frame.repaint();
				}
				public void mouseEntered(MouseEvent e) {
					if(!selectedStudent.equals((panel_5).getName())) {
						panel_5.setBackground(panel_5.getBackground().brighter());
				}}
				public void mouseExited(MouseEvent e) {
					if(!selectedStudent.equals((panel_5).getName())) {
						panel_5.setBackground(new Color(40, 40, 40).darker());
					}}
			});
		}
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();

	}

	public static void populateBox(String classroom_in_ay_id, JComboBox c, ClassStudents co) {
c.removeAllItems();
	List<String> l = new ArrayList();
	l.add("Tous");
c.addItem("Tous");

		Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
		
		
		for(int i = 0; i< lines.length; i++) {
			c.addItem(TestBox.getShortName(lines[i].toString()));
			l.add(lines[i].toString());
		}
		co.setCourses(l);
		}
	
	public static void collapse(Container c) {
		((Container) (c).getComponent(2)).setVisible(false);
		((Container) ((Container) (c).getComponent(0)).getComponent(0)).getComponent(1).setVisible(false);
		((Container) (c).getComponent(0)).setPreferredSize(new Dimension(((Container) (c).getComponent(0)).getPreferredSize().width, 40));
		
		(c).setPreferredSize(new Dimension((c).getPreferredSize().width, 40));
		(c).getComponent(1).setPreferredSize(new Dimension((c).getComponent(1).getPreferredSize().width, 0));
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();
	}
	public static void expand(Container c) {
		

		((Container) (c).getComponent(2)).setVisible(true);
		((Container) ((Container) (c).getComponent(0)).getComponent(0)).getComponent(1).setVisible(true);
		((Container) (c).getComponent(0)).setPreferredSize(new Dimension(((Container) (c).getComponent(0)).getPreferredSize().width, 65));
		
			((Container) (c).getComponent(1)).setPreferredSize(new Dimension(((Container) (c).getComponent(1)).getPreferredSize().width,
					((Container) ((Container) (c).getComponent(1))).getComponentCount()*25+10));
			
		(c).setPreferredSize(new Dimension((c).getPreferredSize().width, 
				(c).getComponent(0).getPreferredSize().height +((c).getComponent(1).getPreferredSize().height)+(c).getComponent(2).getPreferredSize().height));
		(c).revalidate();
		(c).repaint();
	}
	
	
	public static void rankFromFirstToLast(Component c){
		
		List<Double> criteria = new ArrayList();
		Container panel = (Container) ((Container) (((Container) (((Container) (c)).getComponent(0))).getComponent(0))).getComponent(1);
	
		for(int i = 0; i< ((Container) ((Container) c).getComponent(1)).getComponentCount(); i++) {
		Container panel1 = (Container) ((Container) ((Container) c).getComponent(1)).getComponent(i);
		
			if(((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 0 ||((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 4) {
				criteria.add(Double.parseDouble(((JLabel) (panel1).getComponent(4)).getText().replaceAll("%", "").replaceAll(",", ".")));
			}else if(((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 1) {
				List l = Arrays.asList(((JLabel) (panel1).getComponent(4)).getText().split("/"));
				Double d = Double.parseDouble(l.get(0).toString().replaceAll(",", "."))/Double.parseDouble(l.get(1).toString().replaceAll(",", "."));
				criteria.add(d);
			}else {
			criteria.add(Double.parseDouble(((JLabel) (panel1).getComponent(4)).getText().replaceAll("[^0.00-9.00]", "")));
			}
		}
		List<String> l = new ArrayList<String>();;
		for(int i = 0; i< ((Container) ((Container) c).getComponent(1)).getComponentCount(); i++) {
			l.add((criteria.get(i)*10000)+"//"+((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(4)).getText()+"//"+
		(((Container) ((Container) c).getComponent(1)).getComponentCount()-i)+"//"+((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(2)).getText());
		}
		Collections.sort(l, Collections.reverseOrder());
		
		for(int i = 0; i< l.toArray().length; i++) {
			List l1 = Arrays.asList(l.get(i).split("//"));
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(4)).setText(l1.get(1).toString());
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(0)).setText((i+1)+"");
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(2)).setText(l1.get(3).toString());
		}
		

		c.revalidate();
		c.repaint();
		


		limit(((Container) ((Container) c).getComponent(1)), Integer.parseInt((String) ((JComboBox) (panel).getComponent(2)).getSelectedItem()));
		for(int i = 0; i< ((Container)(c).getParent()).getComponentCount(); i++) {
			if(((Component)(c).getParent().getComponent(i)).equals(((JPanel)(c)))) {
				expand((Container) c);
			}
		}

	}
	public static void rankFromLastToFirst(Component c){
		
		List<Double> criteria = new ArrayList();
		Container panel = (Container) ((Container) (((Container) (((Container) (c)).getComponent(0))).getComponent(0))).getComponent(1);
		
		for(int i = 0; i< ((Container) ((Container) c).getComponent(1)).getComponentCount(); i++) {
			
			Container panel1 = (Container) ((Container) ((Container) c).getComponent(1)).getComponent(i);
			
			if(((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 0 ||((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 4) {
				criteria.add(Double.parseDouble(((JLabel) (panel1).getComponent(4)).getText().replaceAll("%", "").replaceAll(",", ".")));
			}else if(((JComboBox) (panel).getComponent(0)).getSelectedIndex() == 1) {
				List l = Arrays.asList(((JLabel) (panel1).getComponent(4)).getText().split("/"));
				Double d = Double.parseDouble(l.get(0).toString().replaceAll(",", "."))/Double.parseDouble(l.get(1).toString().replaceAll(",", "."));
				criteria.add(d);
			}else {
			criteria.add(Double.parseDouble(((JLabel) (panel1).getComponent(4)).getText().replaceAll("[^0.00-9.00]", "")));
			}
		}
		List<String> l = new ArrayList<String>();
		for(int i = 0; i< ((Container) ((Container) c).getComponent(1)).getComponentCount(); i++) {
			l.add((criteria.get(i)*10000)+"//"+((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(4)).getText()
					+"//"+(((Container) ((Container) c).getComponent(1)).getComponentCount()-i)+"//"+((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(2)).getText());
		}
		Collections.sort(l);
		
		for(int i = 0; i< l.toArray().length; i++) {
			List l1 = Arrays.asList(l.get(i).split("//"));
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(4)).setText(l1.get(1).toString());
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(0)).setText((i+1)+"");
			((JLabel) ((Container) ((Container) ((Container) c).getComponent(1)).getComponent(i)).getComponent(2)).setText(l1.get(3).toString());
		}
		

		c.revalidate();
		c.repaint();
		


		limit(((Container) ((Container) c).getComponent(1)), Integer.parseInt((String) ((JComboBox) (panel).getComponent(2)).getSelectedItem()));
		for(int i = 0; i< ((Container)(c).getParent()).getComponentCount(); i++) {
			if(((Component)(c).getParent().getComponent(i)).equals((c))) {
				expand((Container) c);
			}
		}

	}
	
	public static void deselectAll(String ay_id) {

		for(int j = 0; j< Home.panelStudents.getComponentCount(); j++) {
			if(Home.panelStudents.getComponent(j) instanceof JPanel) {
				for(int i = 0; i< (((Container) ((JPanel) Home.panelStudents.getComponent(j)).getComponent(1))).getComponentCount(); i++) {
			(((Container) ((JPanel) Home.panelStudents.getComponent(j)).getComponent(1))).getComponent(i).setBackground(new Color(40, 40, 40).darker());
		}}
		}selectedStudent = "";
		Home.frame.revalidate();
		Home.frame.repaint();
	}
	
	public static void limit(Component c, int i){
		if(((Container) c).getComponentCount()>i) {
			for(int i1 = ((Container) c).getComponentCount()-1; i1>= i; i1--) {
				((Container) c).remove(i1);
			}
			

			c.revalidate();
			c.repaint();
		}
	}
}
