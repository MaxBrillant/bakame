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
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ClassStudents extends JPanel {
	public static JPanel Box1;
	public static boolean isSelected;

	public static List <String> classList = new ArrayList();
	private JPanel panel_1;
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
	private JPanel panel_4;
	private JLabel lblVoirLaClasse;
	public static JComboBox combo1;
	public static JComboBox combo2;
	public static JComboBox combo3;
	private JPanel panel_5;
	public static JButton reverse;
	public static String selectedStudent = "";
	public static List<String>courses = new ArrayList();
	public static int selectedCourse;
	

	/**
	 * Create the panel.
	 */
	public ClassStudents(String start, String end) {
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(new Color(60, 60, 60));
	setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
	setPreferredSize(new Dimension(700, 135));
	setLayout(new BorderLayout(0, 0));
	
	

	panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(50, 40));
	add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(null);
	panel_1.setBackground(panel_1.getParent().getBackground());
	
	name = new JLabel("3eme PF Economique");
	name.setForeground(Color.WHITE);
	name.setFont(new Font("Roboto", Font.BOLD, 20));
	name.setBorder(null);
	name.setBackground(Color.GREEN);
	name.setBounds(10, 0, 293, 35);
	panel_1.add(name);
	
	label_1 = new JLabel("");
	label_1.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
	label_1.setPreferredSize(new Dimension(45, 0));
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setBounds(641, 0, 45, 35);
	panel_1.add(label_1);
	
	combo1 = new JComboBox();
	combo1.setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs", "Interrogations", "Progression"}));
	combo1.setFont(new Font("Roboto", Font.PLAIN, 15));
	combo1.setBounds(276, 9, 114, 22);
	panel_1.add(combo1);
	
	combo2 = new JComboBox();
	combo2.setModel(new DefaultComboBoxModel(new String[] {"COGE", "MAFINA", "COANA", "Maths", "Economie", "Entrepreneuriat", "Droit", "FPH", "Francais", "Anglais", "Kirundi", "Kiswahili"}));
	combo2.setFont(new Font("Roboto", Font.PLAIN, 15));
	combo2.setBounds(411, 9, 153, 22);
	panel_1.add(combo2);
	
	combo3 = new JComboBox();
	combo3.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "7", "10"}));
	combo3.setFont(new Font("Roboto", Font.PLAIN, 15));
	combo3.setBounds(586, 8, 45, 22);
	panel_1.add(combo3);
	
	panel = new JPanel();
	panel.setBorder(null);
	panel.setPreferredSize(new Dimension(10, 95));
	add(panel, BorderLayout.CENTER);
	panel.setBackground(panel.getParent().getBackground());
	panel.setLayout(new WrapLayout(0, 3, 0));
	
	panel_5 = new JPanel();
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
	
	panel_4 = new JPanel();
	panel_4.setPreferredSize(new Dimension(50, 25));
	panel_4.setBackground(new Color(60, 60, 60));
	add(panel_4, BorderLayout.SOUTH);
	panel_4.setLayout(new BorderLayout(0, 0));
	
	lblVoirLaClasse = new JLabel("Voir la classe");
	lblVoirLaClasse.setHorizontalAlignment(SwingConstants.CENTER);
	lblVoirLaClasse.setForeground(Color.WHITE);
	lblVoirLaClasse.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblVoirLaClasse.setBorder(null);
	lblVoirLaClasse.setBackground(Color.GREEN);
	panel_4.add(lblVoirLaClasse);
	
	reverse = new JButton("Croissant");
	reverse.setHorizontalTextPosition(SwingConstants.LEADING);
	reverse.setForeground(Color.LIGHT_GRAY);
	reverse.setFont(new Font("Roboto", Font.PLAIN, 15));
	reverse.setFocusPainted(false);
	reverse.setBorderPainted(false);
	reverse.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\up.png"));
	panel_4.add(reverse, BorderLayout.EAST);
	reverse.setBackground(reverse.getParent().getBackground().brighter());

	}
	
	
	public static void loadStudents(String start, String end, String ay_id) {
		
		Home.panelStudents.removeAll();

			Object[] lines1 =Home.loadActiveClasses(ay_id);
			
			for(int k = 0; k< lines1.length;k++) {
					ClassStudents te = new ClassStudents(start, end);
					Home.panelStudents.add(te);
				te.name.setText(Class.getClassName(lines1[k].toString()));
				te.setName(lines1[k].toString());
				populateBox(lines1[k].toString(), ay_id, te.combo2);
				Home.panelStudents.revalidate();
				Home.panelStudents.repaint();
				te.name.setName(lines1[k].toString());

				//collapse(k);

				int l = k;
		te.combo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			//	loadData(te, t.get(0).toString());

				deselectAll(ay_id);

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {

					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        		loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst((((JPanel)((JPanel) te).getComponent(1))));
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        		
					loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast((((JPanel)((JPanel) te).getComponent(1))));
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			
			}
		});
		te.combo2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			//	loadData(te, t.get(0).toString());
				deselectAll(ay_id);
				selectedCourse = te.combo2.getSelectedIndex();

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        			
				loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst((((JPanel)((JPanel) te).getComponent(1))));
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        		
					loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast((((JPanel)((JPanel) te).getComponent(1))));
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			
			}
		});
		te.combo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
        		
				loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				deselectAll(ay_id);

				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					String start1 = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end1 = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        				
				loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start1, end1);
				rankFromLastToFirst((((JPanel)((JPanel) te).getComponent(1))));
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					String start1 = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end1 = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        		
					loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start1, end1);
					rankFromFirstToLast((((JPanel)((JPanel) te).getComponent(1))));
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			
			}
		});
		((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Croissant")) {
					deselectAll(ay_id);
					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        			
				loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
				rankFromLastToFirst((((JPanel)((JPanel) te).getComponent(1))));
				((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Decroissant");

				}else if(((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).getText().equals("Decroissant")){
					deselectAll(ay_id);
					String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
	        		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
	        		
					loadData(te, courses.get(selectedCourse), lines1[l].toString(), ay_id, start, end);
					rankFromFirstToLast((((JPanel)((JPanel) te).getComponent(1))));
					((AbstractButton) ((Container) te.getComponent(2)).getComponent(1)).setText("Croissant");
				}
			}
		});
		
		((JLabel) ((Container) te.getComponent(2)).getComponent(0)).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.className = ((JLabel) ((Container) te.getComponent(0)).getComponent(0)).getText()
						.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "");
				Application a = new Application(te.getName(), ay_id);
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
			}

		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
			
			int k = i;
			collapse(i);
			((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(((Container) Home.panelStudents.getComponent(k)).getComponent(1).getPreferredSize().height>0) {
					collapse(k);
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(2).setVisible(false);
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(3).setVisible(false);
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(4).setVisible(false);
				}else {
					expand(k);
					if((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(k))).getComponent(1))).getComponentCount()==0) {
					loadData(((Container) Home.panelStudents.getComponent(k)), courses.get(selectedCourse), Home.panelStudents.getComponent(k).getName(), ay_id, start, end);

					rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(k))).getComponent(1))));
					}
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(2).setVisible(true);
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(3).setVisible(true);
					((Container) ((Container) Home.panelStudents.getComponent(k)).getComponent(0)).getComponent(4).setVisible(true);
					}
				}
			});
			
		}
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();
}
	
	
	
	
	public static void loadData(Component te, String course_id, String classroom_id, String ay_id, String start, String end) {
		(((JPanel)((JPanel) te).getComponent(1))).removeAll();
		
			Object[] lines = Home.loadActiveStudents(classroom_id, ay_id);

			for(int i = 0; i< lines.length; i++) {

				JPanel panel_5 = new JPanel();
				panel_5.setBackground(new Color(40, 40, 40).darker());
				panel_5.setPreferredSize(new Dimension(690, 25));
				(((JPanel)((JPanel) te).getComponent(1))).add(panel_5);
				panel_5.setLayout(null);
				
				JLabel lbler = new JLabel(String.valueOf(i+1));
				lbler.setHorizontalAlignment(SwingConstants.CENTER);
				lbler.setForeground(Color.WHITE);
				lbler.setFont(new Font("Roboto", Font.PLAIN, 16));
				lbler.setBorder(null);
				lbler.setBackground(Color.GREEN);
				lbler.setBounds(10, 0, 69, 25);
				panel_5.add(lbler);
				
				JLabel lblUmuhozaChrisKoen = new JLabel(Home.getStudentName(lines[i].toString()));
				lblUmuhozaChrisKoen.setName(lines[i].toString());
				lblUmuhozaChrisKoen.setForeground(Color.WHITE);
				lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.PLAIN, 16));
				lblUmuhozaChrisKoen.setBorder(null);
				lblUmuhozaChrisKoen.setBackground(Color.GREEN);
				lblUmuhozaChrisKoen.setBounds(116, 0, 344, 25);
				panel_5.add(lblUmuhozaChrisKoen);
				
				String value = null;
				
				if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()>=0) {
					
					

					List<String> list = new ArrayList();
					list.add("0");
					list.add("0/0");
					List<String> list1 = new ArrayList();
					list1.add("0");
					list1.add("0/0");
					if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
						
						if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(3)).getSelectedIndex()>0) {
						list  = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_id
								, course_id, "Toute l'annee", start, end);
						}else{
							list  = StudentStats.getStudentTestsStats(lines[i].toString(), classroom_id
									, "All", "Toute l'annee", start, end);
						}}
					if(Home.selectedPeriod == 1 || Home.selectedPeriod == 2) {
						if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(3)).getSelectedIndex()>0) {
							list1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_id
								, course_id, "Toute l'annee", start, end);
						}else{
							list1 = StudentStats.getStudentExamStats(lines[i].toString(), classroom_id
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
					if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==0){
					value = new DecimalFormat("##.##").format(percentage)+"%";
					}if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==1) {
					value = new DecimalFormat("##.##").format(points1)+"/"+new DecimalFormat("##.##").format(maxima);
					}if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==3) {
						value = list.get(2).toString();
					}if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==4) {
						value = list.get(5).toString()+"%";
					}
					
					if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==2) {
						if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(3)).getSelectedIndex()==0) {
							value = String.valueOf(StudentStats.getNumberOfechecs(lines[i].toString(), course_id, classroom_id, ay_id, "Toute l'annee", start, end));
						}
						
					}
				}
				
				if(((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(3)).getSelectedIndex()>0 && ((JComboBox) ((Container) ((Container) te).getComponent(0)).getComponent(2)).getSelectedIndex()==2) {
					value = StudentStats.getEchecsInPoints(lines[i].toString(), course_id, classroom_id, ay_id, "Toute l'annee", start, end)+" pts";
				}
				
				JLabel label = new JLabel(value);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Roboto", Font.PLAIN, 16));
				label.setBorder(null);
				label.setBackground(Color.GREEN);
				label.setBounds(499, 0, 143, 25);
				panel_5.add(label);

			}
		
		for(int i = 0; i< (((JPanel)((JPanel) te).getComponent(1))).getComponentCount(); i++) {
			int k = i;
			(((JPanel)((JPanel) te).getComponent(1))).getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					deselectAll(ay_id);
					((Container) (((JPanel)((JPanel) te).getComponent(1))).getComponent(k)).setBackground(new Color(20, 148, 198));
					selectedStudent = ((JLabel) ((Container) (((JPanel)((JPanel) te).getComponent(1))).getComponent(k)).getComponent(1)).getName();
					StudentInfo s = new StudentInfo(((JLabel) ((Container) (((JPanel)((JPanel) te).getComponent(1))).getComponent(k)).getComponent(1)).getName(),
							(((JLabel) ((JPanel) ((JPanel) te).getComponent(0)).getComponent(0)).getName()), ay_id, start, end);
					Home.side.removeAll();
					Home.side.add(s);
					Home.frame.revalidate();
					Home.frame.repaint();
				}
				public void mouseEntered(MouseEvent e) {
					if(!selectedStudent.equals(((JLabel) ((Container) (((JPanel)((JPanel) te).getComponent(1))).getComponent(k)).getComponent(1)).getText())) {
					(((JPanel)((JPanel) te).getComponent(1))).getComponent(k).setBackground((((JPanel)((JPanel) te).getComponent(1))).getComponent(k).getBackground().brighter());
				}}
				public void mouseExited(MouseEvent e) {
					if(!selectedStudent.equals(((JLabel) ((Container) (((JPanel)((JPanel) te).getComponent(1))).getComponent(k)).getComponent(1)).getText())) {
					(((JPanel)((JPanel) te).getComponent(1))).getComponent(k).setBackground(new Color(40, 40, 40).darker());
					}}
			});
		}
		
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();

	}

	public static void populateBox(String classroom_id, String ay_id, JComboBox c) {
c.removeAllItems();
courses.clear();
courses.add("Tous");
c.addItem("Tous");

		Object[] lines = Home.loadActiveCourses(ay_id, classroom_id);
		
		
		for(int i = 0; i< lines.length; i++) {
			c.addItem(TestBox.getFullName(lines[i].toString()));
			courses.add(lines[i].toString());
		}
		}
	
	public static void collapse(int i) {
		((Container) Home.panelStudents.getComponent(i)).setPreferredSize(new Dimension(((Container) Home.panelStudents.getComponent(i)).getPreferredSize().width, 45));
		((Container) Home.panelStudents.getComponent(i)).getComponent(1).setPreferredSize(new Dimension(((Container) Home.panelStudents.getComponent(i)).getComponent(1).getPreferredSize().width, 0));


		((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2).setVisible(false);
		((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(3).setVisible(false);
		((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(4).setVisible(false);

		((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(2)).setVisible(false);
		Home.panelStudents.revalidate();
		Home.panelStudents.repaint();
	}
	public static void expand(int i) {
		int panelWidth = 0;
			((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(1)).setPreferredSize(new Dimension(((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(1)).getPreferredSize().width,
					((Container) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(1))).getComponentCount()*25));
			
		panelWidth = panelWidth+((Container) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(1))).getComponentCount()*25;
		
		((Container) Home.panelStudents.getComponent(i)).setPreferredSize(new Dimension(((Container) Home.panelStudents.getComponent(i)).getPreferredSize().width, 40+(((Container) Home.panelStudents.getComponent(i)).getComponent(1).getPreferredSize().height)+((Container) Home.panelStudents.getComponent(i)).getComponent(2).getPreferredSize().height));

		((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(2)).setVisible(true);
		((Container) Home.panelStudents.getComponent(i)).revalidate();
		((Container) Home.panelStudents.getComponent(i)).repaint();
	}
	
	
	public static void rankFromFirstToLast(Component c){
		
		List<Double> criteria = new ArrayList();
		
		for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
			if(((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 0 ||((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 4) {
				criteria.add(Double.parseDouble(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().replaceAll("%", "").replaceAll(",", ".")));
			}else if(((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 1) {
				List l = Arrays.asList(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().split("/"));
				Double d = Double.parseDouble(l.get(0).toString().replaceAll(",", "."))/Double.parseDouble(l.get(1).toString().replaceAll(",", "."));
				criteria.add(d);
			}else {
			criteria.add(Double.parseDouble(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().replaceAll("[^0.00-9.00]", "")));
			}
		}
		List<String> l = new ArrayList<String>();;
		for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
			l.add((criteria.get(i)*10000)+"//"+((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText()+"//"+(((Container) c).getComponentCount()-i)+"//"+((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(1)).getText());
		}
		Collections.sort(l, Collections.reverseOrder());
		
		for(int i = 0; i< l.toArray().length; i++) {
			List l1 = Arrays.asList(l.get(i).split("//"));
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).setText(l1.get(1).toString());
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(0)).setText((i+1)+"");
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(1)).setText(l1.get(3).toString());
		}
		

		c.revalidate();
		c.repaint();
		


		limit((c), Integer.parseInt((String) ((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(4)).getSelectedItem()));
		for(int i = 0; i< ((Container)(c.getParent()).getParent()).getComponentCount(); i++) {
			if(((JPanel)(c.getParent()).getParent().getComponent(i)).equals(((JPanel)(c.getParent())))) {
				expand(i);
			}
		}

	}
	public static void rankFromLastToFirst(Component c){
		
		List<Double> criteria = new ArrayList();
		
		for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
			if(((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 0 ||((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 4) {
				criteria.add(Double.parseDouble(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().replaceAll("%", "").replaceAll(",", ".")));
			}else if(((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(2)).getSelectedIndex() == 1) {
				List l = Arrays.asList(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().split("/"));
				Double d = Double.parseDouble(l.get(0).toString().replaceAll(",", "."))/Double.parseDouble(l.get(1).toString().replaceAll(",", "."));
				criteria.add(d);
			}else {
			criteria.add(Double.parseDouble(((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText().replaceAll("[^0.00-9.00]", "")));
			}
		}
		List<String> l = new ArrayList<String>();;
		for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
			l.add((criteria.get(i)*10000)+"//"+((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).getText()+"//"+(((Container) c).getComponentCount()-i)+"//"+((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(1)).getText());
		}
		Collections.sort(l);
		
		for(int i = 0; i< l.toArray().length; i++) {
			List l1 = Arrays.asList(l.get(i).split("//"));
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(2)).setText(l1.get(1).toString());
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(0)).setText((i+1)+"");
			((JLabel) ((Container) ((Container) c).getComponent(i)).getComponent(1)).setText(l1.get(3).toString());
		}
		

		c.revalidate();
		c.repaint();
		


		limit((c), Integer.parseInt((String) ((JComboBox) ((Container) c.getParent().getComponent(0)).getComponent(4)).getSelectedItem()));
		for(int i = 0; i< ((Container)(c.getParent()).getParent()).getComponentCount(); i++) {
			if(((JPanel)(c.getParent()).getParent().getComponent(i)).equals(((JPanel)(c.getParent())))) {
				expand(i);
			}
		}

	}
	
	public static void deselectAll(String ay_id) {

		for(int j = 0; j< Home.panelStudents.getComponentCount(); j++) {
		for(int i = 0; i< (((Container) ((JPanel) Home.panelStudents.getComponent(j)).getComponent(1))).getComponentCount(); i++) {
			(((Container) ((JPanel) Home.panelStudents.getComponent(j)).getComponent(1))).getComponent(i).setBackground(new Color(40, 40, 40).darker());
		}
		}selectedStudent = "";

		MainInfo m = new MainInfo(ay_id);
		m.guide.setText("<html>- Cliquez sur une classe pour voir les eleves<br/> appartenants a cette classe selon la methode de <br/>triage selectionnee.<br/><br/>\r\n- Cliquez sur un eleve pour le selectonner.<br/><br/>\r\n- Selectionnez un pour voir les options <br/>disponibles ainsi que quelques statistiques rapides.<br/><br/>\r\n- Cliquez sur le bas de la classe la ou c'est ecrit <br/>\"voir la classe\" pour ouvrir cette classe.<br/><br/>\r\n- Cliquez sur l'ordre de classement (croissant <br/>ou decroissant) pour changer l'ordre.</html>");
		Home.side.removeAll();
		Home.side.add(m);
		Home.frame.revalidate();
		Home.frame.repaint();
	}
	
	public static void limit(Component c, int i){
		System.out.println("linit = "+i+"/"+((Container) c).getComponentCount());
		if(((Container) c).getComponentCount()>i) {
			for(int i1 = ((Container) c).getComponentCount()-1; i1>= i; i1--) {
				((Container) c).remove(i1);
			}
			

			c.revalidate();
			c.repaint();
		}
	}
}
