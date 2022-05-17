package Class;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Class.OptionsMenu.StudentMenu;
import Class.OptionsMenu.TestMenu;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.Exam;
import app.LPane;
import app.WrapLayout;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExamBox extends JPanel {
	public static JPanel Box1;
	public static JLabel lblNdashimyeMaxBrillant;
	public static JLabel label_5;
	public static boolean isSelected;
	public static JPanel series;
	public static boolean isCollapsed;
	private JLabel icon;
	

	/**
	 * Create the panel.
	 */
	public ExamBox() {
		setBackground(new Color(60, 60, 60));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(int i =0;i<getComponentCount();i++) {
					for(int j = 0;j<getParent().getComponentCount();j++) {
						if((Container) getParent().getComponent(j) instanceof ExamBox) {
						((Container) getParent().getComponent(j)).getComponent(i).setForeground(Color.white);
						getParent().getComponent(j).setBackground(new Color(60, 60, 60));
						((JComponent) getParent().getComponent(j)).setBorder(null);
						
				}}}
				
				for(int i = 0; i< getParent().getComponentCount(); i++) {
					if(getParent().getComponent(i) instanceof ExamBox) {
					getParent().getComponent(i).setPreferredSize(new Dimension(getWidth(), 40));
					
					for(int i1 =4; i1<getComponentCount();i1++) {
						if(i1!=8) {
						((Container) getParent().getComponent(i)).getComponent(i1).setVisible(true);
					}}
					if(((Container) ((Container) getParent().getComponent(i)).getComponent(0)).getComponentCount()>0) {
					((JLabel) ((Container) getParent().getComponent(i)).getComponent(8)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
					}
					Application.panelExams.revalidate();
					Application.panelExams.repaint();
				}
				}
				isSelected = true;
				//TestMenu.edit.setVisible(true);
				//TestMenu.delete.setVisible(true);

				//TestMenu.corrige.setVisible(true);
				
				if(((Container) getComponent(0)).getComponentCount()==0) {
				setBackground(new Color(20, 148, 198));
				for(int j = 0;j<getComponentCount();j++) {
					getComponent(j).setForeground(Color.white);
			}
				if(getParent().equals(Application.panelExams)) {
					Application.no.setText(getName());
					isCollapsed = true;
				}else {
					Application.no.setText(getParent().getParent().getName()+"-"+getName());
				}
				//Application.panelExams.getComponent(Integer.parseInt(Application.no.getText())-1).setBackground(new Color(20, 148, 198));
				
				}else {
					
					Application.no.setText(getName());
					setBackground(new Color(100, 100, 100));
					setPreferredSize(new Dimension(getWidth(), (((Container) getComponent(0)).getComponentCount()+1)*40+6));
					//Application.panelExams.setLayout(new WrapLayout(1, 5, 5));
					
					for(int i =4; i<getComponentCount();i++) {
						if(i!=8) {
						getComponent(i).setVisible(false);
					}}
					setBorder(new LineBorder(new Color(240, 240, 240), 2));
					if(((Container) getComponent(0)).getComponentCount()>0) {
					((JLabel) getComponent(8)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
					}Application.panelExams.revalidate();
					Application.panelExams.repaint();
					Application.no.setText(Application.no.getText());
					
					if(getHeight()>getComponent(0).getHeight()) {
						isCollapsed = true;
						icon.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
						setPreferredSize(new Dimension(getWidth(), 40));
						

						for(int i =4; i<((Container) getComponent(1)).getComponentCount();i++) {
							((Container) getComponent(1)).getComponent(i).setVisible(true);
						}
						
						Application.panelExams.revalidate();
						Application.panelExams.repaint();
						

						for(int j = 0;j<((Container) getComponent(0)).getComponentCount();j++) {
							for(int i =4; i<((Container) getComponent(1)).getComponentCount();i++) {
							((Container) ((Container) ((Container) getComponent(0)).getComponent(j)).getComponent(1)).getComponent(i).setForeground(Color.white);
							((Container) getComponent(0)).getComponent(j).setBackground(new Color(60, 60, 60));
						}
					}
						Application.panelExams.setLayout(new WrapLayout(1, 5, 3));
					}else {
						isCollapsed = false;
						icon.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
					}
				}
				
				getComponent(0).setBackground(getBackground());
			}
			public void mouseEntered(MouseEvent e) {
				int exam;
				int serie = 0;
				
				if(Application.no.getText().contains("-")) {
					List note = Arrays.asList(Application.no.getText().split("-"));
					exam = Integer.parseInt(note.get(0).toString());
					serie = Integer.parseInt(note.get(1).toString());
				}else {
					exam = Integer.parseInt(Application.no.getText());
					serie = 0;
				}
				
				for(int i = 0; i <getParent().getComponentCount();i++) {
					getParent().getComponent(i).setBackground(new Color(60, 60, 60));
				}
				setBorder(new LineBorder(new Color(20, 148, 198), 1));
				if(getParent().equals(Application.panelExams)){
				setBackground(new Color(120, 120, 120));
				}else {
					setBorder(new LineBorder(new Color(20, 148, 198), 3));
				}
				for(int i = 0; i<getComponentCount(); i++) {

					if(isSelected) {
					getComponent(i).setForeground(Color.white);
					//if(Integer.parseInt(getName()) <= getParent().getComponentCount()) {
					//((Container) getParent().getComponent(Integer.parseInt(getName())-1)).getComponent(i).setForeground(Color.white);
					//}
					if(!isCollapsed && serie!=0 && ((Container) getComponent(0)).getComponentCount()==0){
						getParent().getComponent(serie-1).setBackground(new Color(20, 148, 198));
					}
					if(isCollapsed) {
					Application.panelExams.getComponent(exam-1).setBackground(new Color(20, 148, 198));
					}else {
						Application.panelExams.getComponent(exam-1).setBackground(new Color(100, 100, 100));
						((JComponent) Application.panelExams.getComponent(exam-1)).setBorder(new LineBorder(new Color(240, 240, 240), 2));
					}
					}}
			}public void mouseExited(MouseEvent e) {
				setBorder(null);
				setBackground(getBackground());
		}
		});
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 40));
		setLayout(new BorderLayout(0, 0));
		
		series = new JPanel();
		series.setBackground(getBackground());
		series.setBorder(null);
		add(series, BorderLayout.SOUTH);
		series.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(panel.getParent().getBackground());
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 55, 0));
		
		JLabel lblNo = new JLabel("2");
		panel.add(lblNo);
		lblNo.setIconTextGap(15);
		lblNo.setIcon(null);
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setForeground(new Color(211, 211, 211));
		lblNo.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		lblNdashimyeMaxBrillant = new JLabel("Comptabilite Generale");
		panel.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JLabel label_3 = new JLabel("31/12/2003");
		panel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel label = new JLabel("0/0");
		panel.add(label);
		label.setForeground(new Color(211, 211, 211));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("0%");
		panel.add(label_1);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("0");
		panel.add(label_2);
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		label_5 = new JLabel("0%");
		panel.add(label_5);
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		icon = new JLabel("");
		panel.add(icon);
		icon.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
		icon.setIconTextGap(15);
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setForeground(Color.WHITE);
		icon.setFont(new Font("Roboto", Font.PLAIN, 23));
	
	
	}
	
	public static void loadAllExams(String classroom_in_ay_id) {
		Application.panelExams.removeAll();
		for(int i = 0; i< Home.terms.toArray().length; i++) {
			loadExams(classroom_in_ay_id, Home.terms.get(i));
		}

		Application.panelExams.revalidate();
		Application.panelExams.repaint();
	}
	
public static void loadExams(String classroom_in_ay_id, String term_id) {
		int  i = 0;
		((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(3)).getComponent(0).setVisible(true);
		JLabel lblNdashimyeMaxBrillant = new JLabel(Home.getTermName(term_id));
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 20));
		Application.panelExams.add(lblNdashimyeMaxBrillant);
		lblNdashimyeMaxBrillant.setPreferredSize(new Dimension(lblNdashimyeMaxBrillant.getParent().getParent().getWidth(), 50));
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from exam_information "
					+ "WHERE is_active = 1 AND cia_id = '"+classroom_in_ay_id+"' AND term_id = '"+term_id+"'");
		
		while(rs.next())
		{
			i++;
						ExamBox eb = new ExamBox();
						Application.panelExams.add(eb);
						
						eb.setName(rs.getString("exam_id"));
						List<String> listOfSeries = Exam.getExamSeries(rs.getString("exam_id"));
						((JLabel) ((Container) (eb).getComponent(1)).getComponent(1)).setText(String.valueOf(listOfSeries.toArray().length));
						String name = TestBox.getFullName(Exam.getExamCourse(rs.getString("exam_id")));
						((JLabel) ((Container) (eb).getComponent(1)).getComponent(2)).setText(name);
						((JLabel) ((Container) (eb).getComponent(1)).getComponent(3)).setText(Exam.getExamDate(rs.getString("exam_id")));
						JPanel jp = (JPanel) (eb).getComponent(0);
							int k = 0;
							for(int j = 0; j<listOfSeries.toArray().length;j++) {
								k++;
								ExamBox eb1 = new ExamBox();
								eb1.setName(listOfSeries.get(j).toString());
								jp.add(eb1);
								
								((JLabel) ((Container) (eb1).getComponent(1)).getComponent(1)).setText(String.valueOf(k));
								((JLabel) ((Container) (eb1).getComponent(1)).getComponent(2)).setText(Exam.getSerieName(listOfSeries.get(j)));
								((JLabel) ((Container) (eb1).getComponent(1)).getComponent(3)).setText("");
								
								eb1.setPreferredSize(new Dimension(1325*99/100,40*99/100));
								((JLabel) ((Container) (eb1).getComponent(1)).getComponent(8)).setIcon(null);
							}
							if(((Container) eb.getComponent(0)).getComponentCount()>0) {
						((JLabel) (eb).getComponent(8)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
					}else{
						((JLabel) (eb).getComponent(8)).setIcon(null);
					}

						loadExamData(eb, listOfSeries, eb.getName(), classroom_in_ay_id);
						}
					
					Application.panelExams.revalidate();
					Application.panelExams.repaint();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			}
				if(i==0) {
					((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(3)).getComponent(0).setVisible(false);
					
					JPanel panel_10 = new JPanel();
					panel_10.setBorder(new MatteBorder(1, 3, 5, 3, (Color) new Color(0, 0, 0, 120)));
					panel_10.setBackground(new Color(0, 0, 0, 20));
					panel_10.setPreferredSize(new Dimension(300, 400));
					Application.panelExams.add(panel_10);
					panel_10.setLayout(null);
					
					JPanel panel_11 = new JPanel();
					panel_11.setBorder(new MatteBorder(0, 3, 5, 3, (Color) new Color(0, 0, 0, 190)));
					panel_11.setBackground(new Color(80,80,80));
					panel_11.setBounds(0, 233, 300, 167);
					panel_10.add(panel_11);
					panel_11.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("<html>Aucun examen n'a ete effectue dans ce trimestre.</html>");
					lblNewLabel.setForeground(new Color(255, 255, 255));
					lblNewLabel.setBounds(10, 0, 280, 106);
					panel_11.add(lblNewLabel);
					lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
					
					JButton btnNewButton_1 = new JButton("Ajouter un nouvel examen");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ExamInfo nt = new ExamInfo(classroom_in_ay_id);
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
					lblNewLabel_2.setIcon(ResizeImages.resize(80, 80, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\cg_welcome.png"));
					lblNewLabel_2.setBackground(new Color(0, 0, 0));
					lblNewLabel_2.setBounds(0, 0, 300, 235);
					panel_10.add(lblNewLabel_2);
					
				}else {
				}
}



public static void loadExamData(Component c, List<String> listOfSeries, String exam_id, String classroom_in_ay_id) {
	if(Application.panelExams.getComponentCount()>0) {
					
					Double sum = (double) 0;
					Double sum1 = (double) 0;
					int participants = 0;
					boolean echec = false;
					int echecs = 0;

					Object[] lines1 = null;
						lines1 = Home.loadActiveStudents(classroom_in_ay_id);
						
					String cours = TestBox.getShortName(Exam.getExamCourse(exam_id));
					int series = Exam.getExamSeries(exam_id).toArray().length;
					
					

					for(int k = 0; k<series; k++) {
						int participants1 = 0;
						int echecs1 = 0;
						Double sum2 = (double) 0;
						Double sum3 = (double) 0;
					for(int j = 0; j<lines1.length; j++) {
						Double sum21 = (double) 0;
						Double sum31 = (double) 0;
						
						List note2 = Arrays.asList(LPane.loadStudentSerieNote(listOfSeries.get(k), lines1[j].toString()).split("/"));
						
						Double d = Double.parseDouble(note2.get(0).toString());
						Double e = Double.parseDouble(note2.get(1).toString());
						
						
						if(e==0 && d==0) {
							participants1 = participants1+0;
						}else{
							participants1 = participants1+1;
						}
						
						
				
						sum = sum+d;
						sum1 = sum1+e;
						
						sum2 = sum2+d;
						sum3 = sum3+e;
						

						if(((e/2)<=d)) {
							echecs1 = echecs1+0;
						}
						else{
							echecs1++;
						}
						
						for(int l = 0; l<series;l++) {

							List note21 = Arrays.asList(LPane.loadStudentSerieNote(listOfSeries.get(l), lines1[j].toString()).split("/"));
							
							Double d1 = Double.parseDouble(note21.get(0).toString());
							Double e1 = Double.parseDouble(note21.get(1).toString());
							sum21 = sum21+d1;
							sum31 = sum31+e1;

							
							if((sum31/2)<=sum21 || k < series-1) {
								echec = false;
							}else{
								echec = true;
							}
							
						}

						if(sum31!=0 && sum21!=0 &&k == series-1) {
							participants = participants+1;
						}else{
							participants = participants+0;
						}
						if(echec) {
							echecs++;
						}else {
							echecs = echecs+0;
						}
					
				}

					if(((Container) ((Container) (c)).getComponent(0)).getComponentCount()>0) {
					double max = Double.parseDouble(Exam.getSerieMaxima(listOfSeries.get(k)));
					((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(k)).getComponent(4)).setText((new DecimalFormat("##.##").format(sum2/participants1))+"/"+max);
					System.out.println(participants1);
					((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(k)).getComponent(5)).setText((new DecimalFormat("##.##").format(100*(sum2/participants1)/max)+"%"));
					((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(k)).getComponent(6)).setText(String.valueOf(echecs1));
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs1))/Double.parseDouble(String.valueOf(participants1))*100));
					((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(k)).getComponent(7)).setText(reussite+"%");


					((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(k)).getComponent(3)).setText(participants1+" eleves");
					}
					}
					((JLabel) ((Container) (Container) ((Container) c).getComponent(1)).getComponent(4)).setText((new DecimalFormat("##.##").format(sum/participants))+"/"+Exam.getExamMaxima(exam_id));
					System.out.println(participants);
					((JLabel) ((Container) (Container) ((Container) c).getComponent(1)).getComponent(5)).setText((new DecimalFormat("##.##").format(100*(sum/participants)/Integer.parseInt(Exam.getExamMaxima(exam_id)))+"%"));
					((JLabel) ((Container) (Container) ((Container) c).getComponent(1)).getComponent(6)).setText(String.valueOf(echecs));
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs))/Double.parseDouble(String.valueOf(participants))*100));
					((JLabel) ((Container) (Container) ((Container) c).getComponent(1)).getComponent(7)).setText(reussite+"%");
					
					c.revalidate();
					c.repaint();
					c.getParent().revalidate();
					c.repaint();
				
	}
	
}
}