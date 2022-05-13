package app;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.metal.MetalProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.ExamBox;
import Class.ExamInfo;
import Class.NewExam;
import Class.TestBox;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.StudentStats;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Exam extends JPanel {
	public static JLabel number;
	public static JProgressBar progress;
	public static JLabel percent;
	public static boolean isSelected;

	public static int selected;

	/**
	 * Create the panel.
	 */
	public Exam(String course_in_classroom_id, String student_in_classroom_id, String classroom_in_ay_id, String term_id) {
		setBackground(new Color(80, 80, 80));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(new Dimension((int) screensize.getWidth()*31/100,(int) (screensize.getHeight()*82/100*7/100))));
		setLayout(null);
		
		progress = new JProgressBar();
		progress.setBounds(42, 4, 300, 35);
		progress.setBackground(new Color(25, 25, 25));
		UIManager.put("progress.selectionBackground", Color.black);
		progress.setStringPainted(true);
		progress.setForeground(new Color(46, 139, 87));
		progress.setValue(58);
		progress.setFont(new Font("Roboto", Font.PLAIN, 23));
		progress.setString("58/100");
		
		
		Color color ;
		//NewTest nt = new NewTest();
		//if(nt.isVisible()) {
		//if(100*Double.parseDouble(NewTest.PO.getText().replace(",", "."))/Double.parseDouble(NewTest.TP.getSelectedItem().toString().replace(",", "."))>=50) {
			//color = new Color(0, 168, 96);
		//}else {
			//color = new Color(204, 0, 0);
		//}
		
		//progress.setUI(new BasicProgressBarUI() {
			//protected Color getSelectionBackground() { return color;}
			//protected Color getSelectionForeground() { return Color.white;}
		//});
		//}
		
		add(progress);
		
		
		
		
		number = new JLabel();
		number.setForeground(new Color(255, 255, 255));
		number.setText("22");
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setFont(new Font("Roboto", Font.PLAIN, 23));
		number.setBounds(0, 7, 37, 30);
		add(number);
		
		percent = new JLabel("100%");
		percent.setForeground(new Color(255, 255, 255));
		percent.setFont(new Font("Roboto", Font.PLAIN, 23));
		percent.setBounds(352, 6, 61, 30);
		//add(percent);
		
		JLabel pasfait = new JLabel("N'as pas encore fait l'examen");
		pasfait.setVisible(false);
		pasfait.setIconTextGap(15);
		pasfait.setIcon(ResizeImages.resize(46, 26, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\missing.png"));
		pasfait.setHorizontalTextPosition(SwingConstants.RIGHT);
		pasfait.setForeground(new Color(255, 255, 255));
		pasfait.setHorizontalAlignment(SwingConstants.CENTER);
		pasfait.setFont(new Font("Roboto", Font.BOLD, 23));
		pasfait.setBounds(10, 0, 412, 44);
		add(pasfait);
		
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				


				//setBorder(new LineBorder(Color.white, 2));
				Test.deselect(course_in_classroom_id, student_in_classroom_id, classroom_in_ay_id);

				isSelected = true;
				String str = ((JProgressBar)getComponent(0)).getString().replaceAll("[^0.00-9.00]+", "/");
				List note = Arrays.asList(str.trim().split("/"));
				LPane.points.setText(note.get(0)+"/"+note.get(1));
				
				
				LPane.points.setForeground(new Color(255, 33, 94));
				LPane.mention.setForeground(new Color(255, 33, 94));
				LPane.mention();
				
				LPane.average.setVisible(false);
				LPane.comboBox.setVisible(false);
				
				setBackground(new Color(20, 148, 198));
				getComponent(1).setForeground(Color.WHITE);
				getComponent(2).setForeground(Color.WHITE);
				LPane.no.setText("Serie No "+((JLabel) getComponent(1)).getText());//this will give the number of tests
				LPane.supprimer.setVisible(true);
				LPane.modifier.setVisible(true);
				
				selected = Integer.parseInt(((JLabel) getComponent(1)).getText())-1;

				if(App.panel_5.getComponentCount()>0) {
				int num = Integer.parseInt(LPane.no.getText().replaceAll("[^0.00-9.00]", ""));
				LPane.panel_2.getComponent(num-1).setPreferredSize(new Dimension((int) ((screensize.getWidth()*31/100)*103)/100,(int) (((screensize.getHeight()*82/100*7/100)*105)/100)));
				}
				
				LPane.panel_2.revalidate();
				LPane.panel_2.repaint();
				
				if(e.getClickCount()==2){
					NewTest nt = new NewTest(getName());
				nt.setVisible(true);
					NewTest.update.setVisible(false);
					NewTest.upExam.setVisible(true);
					
					

					List note1 = Arrays.asList(LPane.loadStudentSerieNote(getName(), student_in_classroom_id).trim().split("/"));
					
					
					NewTest.PO.setText((String) note1.get(0));
					NewTest.TP.setText(getSerieMaxima(getName()));
					NewTest.interro.setText(getSerieName(getName()));
				}
				
				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
		}
			public void mouseEntered(MouseEvent e) {
				
				
				setBorder(null);
				setBackground(new Color(120, 120, 120));
				setForeground(Color.white);
				if(!getComponent(0).isVisible()) {
					
				}

				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
			}public void mouseExited(MouseEvent e) {
				if(!getComponent(0).isVisible()) {
					setBackground(LPane.panel_3.getBackground());
					setForeground(Color.white);
					setBorder(new LineBorder(Color.white, 2));
					getComponent(1).setForeground(Color.white);
				}else {
			setBackground(new Color(80, 80, 80));
			setBorder(null);
				}
				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
			}
		});

	}
	
	
	public static void color() {

		for (int k = 0; k< LPane.panel_2.getComponentCount();k++) {
			String str = ((JProgressBar) ((Container) LPane.panel_2.getComponent(k)).getComponent(0)).getString();
			List note = Arrays.asList(str.trim().split("/"));
			
			Color color;
			if(Double.parseDouble((String)note.get(0))/Double.parseDouble((String)note.get(1))*100 >=50) {
				color = new Color(0, 168, 96);
			}else {
				color = new Color(255, 33, 94);
			}
			
			Exam.progress.setUI(new BasicProgressBarUI() {
				protected Color getSelectionBackground() { return color;}
				protected Color getSelectionForeground() { return Color.white;
				}
			});
			
			
		}
		
	}
	
	public static void deselect(String course_id, String student_id, String classroom_id) {
		
		for(int i = 0; i < LPane.panel_2.getComponents().length;i++) {
			
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			
			LPane.panel_2.getComponent(i).setPreferredSize(new Dimension((int) screensize.getWidth()*31/100,(int) (screensize.getHeight()*82/100*7/100)));
			
			if(!((JComponent) LPane.panel_2.getComponent(i)).getComponent(0).isVisible()) {
				((JComponent) LPane.panel_2.getComponent(i)).setBackground(LPane.panel_2.getBackground());
				((Container) LPane.panel_2.getComponent(i)).getComponent(1).setForeground(Color.white);
				((JComponent) LPane.panel_2.getComponent(i)).setBorder(new LineBorder(Color.white, 2));
			}else {
		((JComponent) LPane.panel_2.getComponent(i)).setBackground(new Color(60, 60, 60));
		((Container) LPane.panel_2.getComponent(i)).getComponent(1).setForeground(Color.white);
		((Container) LPane.panel_2.getComponent(i)).getComponent(2).setForeground(Color.white);
			}
	}
		
List l = StudentStats.getStudentExamStats(student_id, classroom_id, course_id, Home.termsText.get(Home.selectedTermIndex), "All", "All");
		
		List<String> note = Arrays.asList(l.get(1).toString().split("/"));
		
		Double points1 = Double.parseDouble(note.get(0).replaceAll(",", "."));
		Double maxima = Double.parseDouble(note.get(1).replaceAll(",", "."));
		
		Double percentage;
		if(points1 == Double.parseDouble("0") && maxima == Double.parseDouble("0")) {
			percentage = (double) 0;
		}else {
			percentage = points1*100/maxima;
		}
		
		LPane.average.setVisible(true);
		LPane.comboBox.setVisible(true);
		

		LPane.supprimer.setVisible(false);
		LPane.modifier.setVisible(false);
		LPane.no.setText(l.get(2).toString()+" Series effectuees");
		

		

		LPane.prog.setText("Progression: "+ l.get(5).toString()+"%");
		LPane.pourcent.setText("Pourcentage: "+new DecimalFormat("##.##").format(percentage)+"%");
		LPane.points.setText(l.get(1).toString());
		if(percentage>=50) {
		LPane.echec.setText("Augmentation: "+new DecimalFormat("##.##").format((Double.parseDouble(note.get(0).toString())-(Double.parseDouble(note.get(1).toString())/2)))+" points");
		}else {
			LPane.echec.setText("Echec: "+new DecimalFormat("##.##").format((Double.parseDouble(note.get(1).toString())/2)-Double.parseDouble(note.get(0).toString()))+" points");
		}
		
		LPane.points.setForeground(new Color(255, 33, 94));
		LPane.mention.setForeground(new Color(255, 33, 94));
		LPane.mention();
		
		LPane.average.setVisible(true);
		LPane.comboBox.setVisible(true);
		//selectedTests.clear();
		LPane.comboBox.setSelectedItem(ExamInfo.loadCourseMaxima(course_id, classroom_id, Login.selectedAcademicYearID));
		
			LPane.mention();
			LPane.average();
		}
	
	
	public static void saveExistingExam() {

		int i = Integer.parseInt(App.number.getText().replace(" ", ""));
			String name = ((JLabel) (((Container) ((Container) App.panel_5.getComponent(i-1)).getComponent(0)).getComponent(0))).getText();
		
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+App.name.getText()+"/3eme Trimestre/"+name.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")+".txt");
			aws.downloadContent(file.getPath());
	
			try {

				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = br.lines().toArray();
				
				List<String> info = new ArrayList();
				for(i = 0; i<lines.length; i++) {
					info.add(lines[i].toString());
				}
				
				int index = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""))-1;
				for(int j = 0; j<LPane.panel_2.getComponentCount();j++) {
					

					
					if(index == j) {
						
						if(j==0) {
							((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).setString(NewTest.PO.getText()+"/"+NewTest.TP.getText());
							info.remove(0);
							info.add(0, ((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
						}else {
							String s = info.get(0);
							info.remove(0);
							((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).setString(NewTest.PO.getText()+"/"+NewTest.TP.getText());
							info.add(0, s+"//"+((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
						}
					}else {
					
					if(j==0) {
						info.remove(0);
						info.add(0, ((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
					}else {
						String s = info.get(0);
						info.remove(0);
						info.add(0, s+"//"+((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
					}}
				}
				
				
				if(file.exists()) {
					file.delete();
				}
				

				try {
					file.createNewFile();
					
					PrintWriter pw = new PrintWriter(file);
					for(int k = 0; k<info.toArray().length;k++) {
						pw.println(info.get(k));
					}
					
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
			aws.upload(file.getPath());
	
	}
	
	
	

	public static String getSerieMaxima(String serie_id) {
		 
			String maxima = null;
			
			try {
				Statement stmt= mysql.con.createStatement();

				ResultSet rs=stmt.executeQuery("SELECT * from series "
						+ "WHERE serie_id = '"+serie_id+"' LIMIT 1");
			
			while(rs.next())
			{
				maxima = rs.getString("maxima");
			}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return maxima;
		}
	
	public static String getExamMaxima(String exam_id) {
		int maxima = 0;
		List<String> l = getExamSeries(exam_id);
		for(int i = 0; i< l.toArray().length; i++) {
			maxima = maxima+ Integer.parseInt(getSerieMaxima(l.get(i)));
		}
		return String.valueOf(maxima);
	}
	
	
public static String getExamDate(String exam_id) {
	 
		String date = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT DAY(date), MONTH(date), YEAR(date) from exam_information "
					+ "WHERE is_active = 1 AND exam_id = '"+exam_id+"' LIMIT 1");
		
		while(rs.next())
		{
			date = rs.getString("DAY(date)")+"/"+rs.getString("MONTH(date)")+"/"+rs.getString("YEAR(date)");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return date;
	}
	
public static String getSerieName(String serie_id) {
	 
		String name = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from series "
					+ "WHERE serie_id = '"+serie_id+"' LIMIT 1");
		
		while(rs.next())
		{
			name = rs.getString("serie_name");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}

public static String getExamCourse(String exam_id) {
	 
		String course = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information AS ei "
					+ "JOIN course_examss AS ce "
					+ "WHERE ei.exam_id = ce.exam_id AND ei.is_active = 1 AND ei.exam_id = '"+exam_id+"' LIMIT 1");
		
		while(rs.next())
		{
			course = rs.getString("ce.course_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return course;
	}

public static String getExamClassroom(String exam_id) {
	 
		String classroom = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information "
					+ "WHERE is_active = 1 AND exam_id = '"+exam_id+"' LIMIT 1");
		
		while(rs.next())
		{
			classroom = rs.getString("classroom_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return classroom;
	}

public static String getExamTerm(String exam_id) {
	 
		String term = null;
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information "
					+ "WHERE is_active = 1 AND exam_id = '"+exam_id+"' LIMIT 1");
		
		while(rs.next())
		{
			term = rs.getString("term_id");
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return term;
	}


public static List<String> getExamSeries(String exam_id) {
	 
		List<String> series = new ArrayList();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from series "
					+ "WHERE exam_id = '"+exam_id+"'");
		
		while(rs.next())
		{
			series.add(rs.getString("serie_id"));
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return series;
	}
}
