package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import app.App;
import app.Cours;
import app.General;
import app.LPane;
import app.NewCourse;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import Application.Home;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ExamInfo extends JFrame {

	private JPanel contentPane;
	public static JComboBox cours;
	public static List<String> coursesList = new ArrayList();
	public static JComboBox maxima;
	public static JButton Add;
	public static JButton cancel;
	private JDateChooser dateChooser;
	public static JTable table;
	private JLabel notice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					ExamInfo frame = new ExamInfo("1");
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
	public ExamInfo(String classroom_in_ay_id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		setTitle("New Test");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 370, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 113, 384, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Cours:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 146, 88, 28);
		contentPane.add(lblNewLabel);
		
		cours = new JComboBox();

		cours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String max = loadCourseMaxima(coursesList.get(cours.getSelectedIndex()));
				maxima.setSelectedItem(max);
				}
		});
		cours.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String max = loadCourseMaxima(coursesList.get(cours.getSelectedIndex()));
				maxima.setSelectedItem(max);
			}
		});
		cours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		cours.setBounds(162, 146, 132, 28);
		contentPane.add(cours);
		
		JLabel lblMaxima = new JLabel("Maxima:");
		lblMaxima.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaxima.setForeground(Color.WHITE);
		lblMaxima.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblMaxima.setBounds(50, 245, 88, 28);
		contentPane.add(lblMaxima);
		
		maxima = new JComboBox();
		maxima.setEditable(true);
		maxima.setModel(new DefaultComboBoxModel(new String[] {"15", "20", "35", "40", "60", "80"}));
		maxima.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		maxima.setBounds(162, 245, 60, 28);
		contentPane.add(maxima);
		
		JLabel lblNewLabel_1 = new JLabel("Nouvel Examen");
		lblNewLabel_1.setIconTextGap(0);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-5, 86, 364, 28);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(20, 148, 198));
		panel.setBounds(0, 0, 354, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("<html><div style='text-align: center;'>Ajoutez un examen pour un cours, en selectionnant le maximum des points, la date de l'evaluation, et le nombre de series</html>");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(4, 0, 345, 71);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		Add = new JButton("Ajouter");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				boolean exists = CheckExistance(cours.getSelectedItem().toString());
				if(!exists) {

					setVisible(false);
					NewExam nt = new NewExam();
					nt.setVisible(true);
					nt.cours.setText(cours.getSelectedItem().toString());
					nt.loadData(nt.cours.getText());
				String date = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)
						+"/"+(dateChooser.getDate().getYear()+1900);
				
				
				String s = cours.getSelectedItem()+"//"+maxima.getSelectedItem()+"//"+table.getModel().getRowCount()+"//"+date;
				for(int i = 0;i<table.getModel().getRowCount();i++) {
					s = s+"//"+table.getModel().getValueAt(i, 0)+"::"+table.getModel().getValueAt(i, 1);
				}
				
				addExams(s);
				NewExam.cours.setText(TestBox.getFullName(coursesList.get(cours.getSelectedIndex())));
				NewExam.loadExamSeries(NewExam.cours.getText());
				
				}else {
					notice.setVisible(true);
				}
				
			}
		});
		Add.setForeground(Color.WHITE);
		Add.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		Add.setFocusPainted(false);
		Add.setBorderPainted(false);
		Add.setBackground(new Color(0, 171, 89));
		Add.setBounds(29, 379, 120, 31);
		contentPane.add(Add);
		
		cancel = new JButton("Annuler");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
				setVisible(false);
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		cancel.setBackground(new Color(171, 0, 0));
		cancel.setBounds(197, 379, 129, 31);
		contentPane.add(cancel);
		
		JLabel label = new JLabel("Date:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		label.setBounds(50, 195, 88, 28);
		contentPane.add(label);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setPreferredSize(new Dimension(30, 17));
		dateChooser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		dateChooser.setBounds(162, 195, 132, 28);
		contentPane.add(dateChooser);
		
		Date date = new Date();
		dateChooser.setDate(date);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		scrollPane.setBackground(new Color(25, 25, 25));
		scrollPane.setBounds(29, 284, 297, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(new Color(20, 148, 198));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(80, 80, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Series", "%", "Maxima"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth((int) table.getPreferredSize().getWidth()*70/100);
		table.getColumnModel().getColumn(1).setPreferredWidth((int) table.getPreferredSize().getWidth()*7/100);
		table.getColumnModel().getColumn(2).setPreferredWidth((int) table.getPreferredSize().getWidth()*23/100);
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		table.setGridColor(new Color(255, 255, 255));
		scrollPane.setViewportView(table);

		scrollPane.getViewport().setBackground(new Color(60, 60, 60));
		

		table.getTableHeader().setBackground(new Color(60, 60, 60));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.setRowHeight(25);
		
		JLabel lblSeries = new JLabel("Series:");
		lblSeries.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblSeries.setBounds(232, 245, 71, 28);
		contentPane.add(lblSeries);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if(model.getRowCount()>0) {
				for(int i = 0;i<model.getRowCount()+1;i++) {
					model.removeRow(i);
				}
				if(Integer.parseInt(spinner.getModel().getValue().toString()) == 2){

					model.addRow(new Object[] {"Situation d'integration","60"});
					model.addRow(new Object[] {"Examen","40"});
				}else {

					model.addRow(new Object[] {"Examen","100"});
				}

				String max = loadCourseMaxima(coursesList.get(cours.getSelectedIndex()));
				maxima.setSelectedItem(max);
			}}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spinner.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		spinner.setBounds(309, 247, 35, 25);
		contentPane.add(spinner);

		spinner.getModel().setValue(2);
		
		notice = new JLabel("L' examen de ce cours a deja ete effectue");
		notice.setVisible(false);
		notice.setForeground(new Color(255, 192, 203));
		notice.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setBounds(0, 120, 354, 22);
		contentPane.add(notice);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	         table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
	         table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		model.addRow(new Object[] {"Situation d'integration","60"});
		model.addRow(new Object[] {"Examen","40"});
		populateBox(classroom_in_ay_id);
		
	}
	public static void populateBox(String classroom_id) {
		//coursesList.clear();
			Object lines [] = Home.loadActiveCourses(classroom_id);
			
			for(int i = 0;i<lines.length; i++) {
				coursesList.add(lines[i].toString());
				cours.addItem(TestBox.getFullName(lines[i].toString()));
			}
			
		
	}
	
	
	public static String loadCourseMaxima(String course_in_classroom_id) {

		String maxima = null;
		

		  try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * FROM courses_in_classroom "
						+ "WHERE courses_in_classroom_id = '"+course_in_classroom_id+"' LIMIT 1");
				while(rs.next())
				{
			 maxima = rs.getString("maxima");
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
			return maxima;
			
	}
	public static void addExams(String s) {
		refreshExams();
		examList.add(0, s);
		saveExams();
		
}
	
	public static boolean CheckExistance(String s) {
		boolean alreadyExists = false;
		for(int i = 0; i<examList.toArray().length; i++) {
			List parts = Arrays.asList(examList.get(i).split("//"));
			if(parts.get(0).equals(cours.getSelectedItem())) {
				alreadyExists = true;
			}
		}
		return alreadyExists;
	}
	
	public static void saveExams() {
		
		
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
		
		if(file.exists()) {
					file.delete();
				}
		
			try {
				

				file.createNewFile();

				PrintWriter pw = new PrintWriter(file);
				for(int i = 0; i<examList.toArray().length;i++) {
					pw.println(examList.get(i));
				}
				
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}aws.upload(file.getPath());
	}
	
	
	
public static void refreshExams() {
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
	aws.downloadContent(file.getPath());	
			try {
	
				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = Home.loadActiveStudents(file.getPath());

				List <String>list = new ArrayList();
				
				File file1;
				for(int i = 0;i<lines.length;i++) {
					list.clear();
					List parts = Arrays.asList(lines[i].toString().split("//"));
	file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+parts.get(0)+"/3eme Trimestre/"+cours.getSelectedItem()+".txt");
			
			try {
	
				
				FileReader fr1 = new FileReader(file1);
				
				BufferedReader br1 = new BufferedReader(fr1);
				Object[] lines1 = br1.lines().toArray();
				
				for(int i1 = 0;i1<lines1.length;i1++) {
					list.add(lines1[i1].toString());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			
			String s = "";
			for(int i1 = 0;i1<table.getModel().getRowCount();i1++) {
				if(i1 == 0) {
					s = s+"0/0";
				}else {
				s = s+"//0/0";
			}}
			list.add(0, s);
			list.remove(1);
			
		if(file1.exists()) {
					file1.delete();
				}
		
			try {
				

				file1.createNewFile();

				PrintWriter pw = new PrintWriter(file1);
				for(int i1 = 0; i1<list.toArray().length;i1++) {
					pw.println(list.get(i1));
				}
				
				pw.close();
				
				aws.upload(file1.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	}
	}


	}

