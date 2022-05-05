package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.General;
import app.LPane;
import app.NewCourse;
import app.Test;
import Class.NewTest;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
import java.awt.Rectangle;

public class TestInfo extends JFrame {

	private JPanel contentPane;
	public static JComboBox cours;
	public static List<String> coursesList = new ArrayList();
	public static JComboBox maxima;
	public static JButton Add;
	public static JButton cancel;
	public static JButton actualiser;
	public static JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					TestInfo frame = new TestInfo("3", "1", "8");
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
	public TestInfo(String test_id, String classroom_id, String ay_id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\ILLUSTRATOR\\Bakame.png"));
		setTitle("New Test");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 370, 400);
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
		lblNewLabel.setBounds(50, 136, 88, 28);
		contentPane.add(lblNewLabel);
		
		cours = new JComboBox();
		cours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		cours.setBounds(162, 136, 132, 28);
		contentPane.add(cours);
		
		JLabel lblMaxima = new JLabel("Maxima:");
		lblMaxima.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaxima.setForeground(Color.WHITE);
		lblMaxima.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblMaxima.setBounds(50, 185, 88, 28);
		contentPane.add(lblMaxima);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblDate.setBounds(50, 235, 88, 28);
		contentPane.add(lblDate);
		
		maxima = new JComboBox();
		maxima.setEditable(true);
		maxima.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "35", "40", "50"}));
		maxima.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		maxima.setBounds(162, 185, 60, 28);
		contentPane.add(maxima);
		
		JLabel lblNewLabel_1 = new JLabel("Nouvelle interrogation");
		lblNewLabel_1.setIconTextGap(0);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-5, 86, 364, 28);
		contentPane.add(lblNewLabel_1);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setPreferredSize(new Dimension(30, 17));
		dateChooser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		dateChooser.setBackground(Color.blue);
		dateChooser.setBounds(162, 235, 142, 28);
		contentPane.add(dateChooser);
		

		Date date = new Date();
		dateChooser.setDate(date);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(20, 148, 198));
		panel.setBounds(0, 0, 354, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("<html><div style='text-align: center;'>Ajoutez une nouvelle interrogation, en selectionnant le cours, le maximum des points, ainsi que la date de l'evaluation</html>");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(4, 0, 345, 71);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		Add = new JButton("Ajouter");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Application.tabbedPane.setSelectedIndex(2);
				setVisible(false);

				
				String date = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)
						+"/"+(dateChooser.getDate().getYear()+1900);

				String id = UUID.randomUUID().toString();
				NewTest nt = new NewTest(id);
				String s = id+"//"+cours.getSelectedItem()+"//"+maxima.getSelectedItem()+"//"+NewTest.interro.getText().replaceAll("[^0-9]","")+"//"+date;
				

				TestBox.addTest(s);
				addNewTest(id);

				NewTest.loadTestInfo(id);
				new SwingWorker<Void, Void>() {
		            public Void doInBackground() throws Exception{
		            	Thread.sleep(1000);
		        		TestBox.loadAllTests(classroom_id, ay_id);
						Animations.scrollTestRight();
						NewTest.points.requestFocus();
		            	 return null;
		            }
		        }.execute();
				
				nt.setVisible(true);
				
			}
		});
		Add.setForeground(Color.WHITE);
		Add.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		Add.setFocusPainted(false);
		Add.setBorderPainted(false);
		Add.setBackground(new Color(0, 171, 89));
		Add.setBounds(29, 307, 120, 31);
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
		cancel.setBounds(197, 307, 129, 31);
		contentPane.add(cancel);
		
		actualiser = new JButton("Actualiser");
		actualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatecourse(cours.getSelectedItem().toString(), ((JLabel) ((Container) TestBox.selectedTests.get(0)).getComponent(0)).getText().replaceAll("[^0.00-9.00]+", " ").replaceAll(" ", ""));
			setVisible(false);
			
			new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
	        		TestBox.loadAllTests(classroom_id, ay_id);
	            	 return null;
	            }
	        }.execute();
			}
		});
		actualiser.setForeground(Color.WHITE);
		actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		actualiser.setFocusPainted(false);
		actualiser.setBounds(new Rectangle(58, 275, 120, 31));
		actualiser.setBackground(new Color(171, 145, 0));
		actualiser.setBounds(29, 307, 120, 31);
		contentPane.add(actualiser);
		
		populateBox(classroom_id, ay_id);
		
		if(test_id.equals("null")) {
			actualiser.setVisible(false);
			Add.setVisible(true);
			//cours.setSelectedItem(Test.getTestCourse(test_id));
			//cours.setEnabled(true);
			//maxima.setSelectedItem(Test.getTestMaxima(test_id));
			//maxima.setEnabled(true);
		}else {
			actualiser.setVisible(true);
			Add.setVisible(false);
			cours.setSelectedItem(TestBox.getFullName(Test.getTestCourse(test_id)));
			cours.setEnabled(false);
			maxima.setSelectedItem(Test.getTestMaxima(test_id));
			maxima.setEnabled(false);
			
			SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(test_id+"//"+Test.getTestDate(test_id));
			 Date d3 = null;
			try {
				d3 = df1.parse(Test.getTestDate(test_id));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			dateChooser.setDate(d3);
		
		}
		
	}
	public static void populateBox(String classroom_id, String ay_id) {
		//coursesList.clear();
			Object lines [] = Home.loadActiveCourses(ay_id, classroom_id);
			
			for(int i = 0;i<lines.length; i++) {
				coursesList.add(lines[i].toString());
				cours.addItem(TestBox.getFullName(lines[i].toString()));
			}
			
		
	}
	
	
	public static void addNewTest(String testId) {
			
		File testList = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
		//aws.downloadContent(testList.getPath());
		FileReader fr4;
		try {
			fr4 = new FileReader(testList);
		
		
		BufferedReader br3 = new BufferedReader(fr4);
		Object[] lines = br3.lines().toArray();
		
		for(int i = 0; i<lines.length; i++) {
			List parts = Arrays.asList(lines[i].toString().split("//"));
		
			
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+parts.get(0).toString().replaceAll("::", " ")+"/3eme Trimestre/"+cours.getSelectedItem()+".txt");
			
				try {
					PrintWriter write = new PrintWriter(new FileWriter(file, true));
					write.println(testId+"//0/0");
					
					write.close();
					aws.upload(file.getPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}

		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public static void updatecourse(String shortName, String testNumber) {
	

		List<String> TestList = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				TestList.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<TestList.toArray().length; i++) {
			List l = Arrays.asList(TestList.get(i).split("//"));
			if(l.get(1).toString().equals(shortName) && l.get(3).equals(testNumber)) {
				TestList.add(i, l.get(0).toString()+"//"+shortName+"//"+maxima.getSelectedItem()+"//"+testNumber+"//"+dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900));
				TestList.remove(i+1);
		}}
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
	
	if(file1.exists()) {
				file1.delete();
			}
	
		try {
			file1.createNewFile();
			PrintWriter pw = new PrintWriter(file1);

			for(int j = 0;j<TestList.toArray().length;j++) {
			pw.println((String)TestList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file1.getPath());
	}
	
	
	
	
public static void saveTestNote(String testId, String note, String name, String course) {
	NewTest.saveTestNote(testId, note, name, course);
}
}