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
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
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
	public static List<String> examList = new ArrayList();
	public static boolean isSelected;
	public static JPanel series;
	public static boolean isCollapsed;
	private JLabel icon;
	public static boolean isEmpty = false;
	

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
						((Container) getParent().getComponent(j)).getComponent(i).setForeground(Color.white);
						getParent().getComponent(j).setBackground(new Color(60, 60, 60));
						((JComponent) getParent().getComponent(j)).setBorder(null);
						
				}}
				
				for(int i = 0; i< getParent().getComponentCount(); i++) {

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
						

						for(int i =4; i<getComponentCount();i++) {
							getComponent(i).setVisible(true);
						}
						
						Application.panelExams.revalidate();
						Application.panelExams.repaint();
						

						for(int j = 0;j<((Container) getComponent(0)).getComponentCount();j++) {
							for(int i =4; i<getComponentCount();i++) {
							((Container) ((Container) getComponent(0)).getComponent(j)).getComponent(i).setForeground(Color.white);
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
					if(Integer.parseInt(getName()) <= getParent().getComponentCount()) {
					((Container) getParent().getComponent(Integer.parseInt(getName())-1)).getComponent(i).setForeground(Color.white);
					}
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
		setLayout(null);
		
		series = new JPanel();
		series.setBackground(getBackground());
		series.setBorder(null);
		series.setBounds(3, 40, 1320, 80);
		add(series);
		series.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
		
		JLabel lblNo = new JLabel("2");
		lblNo.setIconTextGap(15);
		lblNo.setIcon(null);
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setForeground(new Color(255, 255, 255));
		lblNo.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblNo.setBounds(35, 0, 45, 40);
		add(lblNo);
		
		lblNdashimyeMaxBrillant = new JLabel("Comptabilite Generale");
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(new Color(255, 255, 255));
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblNdashimyeMaxBrillant.setBounds(104, 0, 407, 40);
		add(lblNdashimyeMaxBrillant);
		
		JLabel label_3 = new JLabel("31/12/2003");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_3.setBounds(514, 0, 134, 40);
		add(label_3);
		
		JLabel label = new JLabel("0/0");
		label.setForeground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.PLAIN, 23));
		label.setBounds(720, 0, 119, 40);
		add(label);
		
		JLabel label_1 = new JLabel("0%");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_1.setBounds(878, 0, 134, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_2.setBounds(1050, 0, 94, 40);
		add(label_2);
		
		label_5 = new JLabel("0%");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Roboto", Font.PLAIN, 23));
		label_5.setBounds(1178, 0, 147, 40);
		add(label_5);
		
		icon = new JLabel("");
		icon.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop2.png"));
		icon.setIconTextGap(15);
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setForeground(Color.WHITE);
		icon.setFont(new Font("Roboto", Font.PLAIN, 23));
		icon.setBounds(0, 0, 45, 40);
		add(icon);
	
	
	}
	
public static void loadExams() {
		
		Application.panelExams.removeAll();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
		aws.downloadContent(file.getPath());
		examList.clear();
		isEmpty = false;
		((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(3)).getComponent(0).setVisible(true);
				
				try {

					
					FileReader fr = new FileReader(file);
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines = br.lines().toArray();
					
					for(int i = 0;i<lines.length;i++) {
						examList.add(lines[i].toString());
					}
					
					for(int i = 0;i<examList.toArray().length; i++) {
						List note = Arrays.asList(examList.get(i).split("//"));
						if(Home.courseExists((String) note.get(0), Home.className)) {
						ExamBox eb = new ExamBox();
						Application.panelExams.add(eb);
						((Container) Application.panelExams.getComponent(i)).setName(String.valueOf(i+1));
						((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(1)).setText((String) note.get(2));
						String s = (String) note.get(0);
						String name = TestBox.getFullName(s, Home.className);
						((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(2)).setText(name);
						((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(3)).setText((String) note.get(3));
						JPanel jp = (JPanel) ((Container) Application.panelExams.getComponent(i)).getComponent(0);
						if(Integer.parseInt(note.get(2).toString())>1) {
							int k = 0;
							for(int j = 4; j<note.toArray().length;j++) {
								k++;
								List note1 = Arrays.asList(((String) note.get(j)).split("::"));
								ExamBox eb1 = new ExamBox();
								jp.add(eb1);
								
								jp.getComponent(k-1).setName(String.valueOf(k));
								((JLabel) ((Container) jp.getComponent(k-1)).getComponent(1)).setText(String.valueOf(k));
								((JLabel) ((Container) jp.getComponent(k-1)).getComponent(2)).setText((String) note1.get(0));
								((JLabel) ((Container) jp.getComponent(k-1)).getComponent(3)).setText("");
								
								eb1.setPreferredSize(new Dimension(1325*99/100,40*99/100));
								((JLabel) eb1.getComponent(8)).setIcon(null);
							}
						}if(((Container) eb.getComponent(0)).getComponentCount()>0) {
						((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(8)).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
					}else{
						((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(8)).setIcon(null);
					}}}
					Application.panelExams.revalidate();
					Application.panelExams.repaint();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			}
				if(Application.panelExams.getComponentCount()==0) {
					isEmpty = true;
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
					
					JLabel lblNewLabel = new JLabel("<html>Cette classe n'a pas encore effectue d'examens.</html>");
					lblNewLabel.setForeground(new Color(255, 255, 255));
					lblNewLabel.setBounds(10, 0, 280, 106);
					panel_11.add(lblNewLabel);
					lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
					
					JButton btnNewButton_1 = new JButton("Ajouter un nouvel examen");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ExamInfo nt = new ExamInfo();
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
				loadExamData();
				}
}



public static void loadExamData() { 
	if(Application.panelExams.getComponentCount()>0) {

		Object[] lines = null;
		
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
			aws.downloadContent(file.getPath());
				FileReader fr;
				try {
					fr = new FileReader(file);
				
				
				BufferedReader br = new BufferedReader(fr);
				lines = br.lines().toArray();
				

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = lines.length-1; i>-1; i--) {
					
					List l1 = Arrays.asList(lines[i].toString().split("//"));
					if(Home.courseExists(l1.get(0).toString(), Home.className)) {
					Double sum = (double) 0;
					Double sum1 = (double) 0;
					int participants = 0;
					boolean echec = false;
					int echecs = 0;

					Object[] lines1 = null;
					
					File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Students.txt");
					aws.downloadContent(file1.getPath());
						FileReader fr1;
						try {
							fr1 = new FileReader(file1);
						
						
						BufferedReader br1 = new BufferedReader(fr1);
						lines1 = Home.loadActiveStudents(file1.getPath());
						

						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					List note1 = Arrays.asList(lines[i].toString().split("//"));
					String s = (String) note1.get(0);
					String cours = TestBox.getShortName(s,Home.className);
					int series = Integer.parseInt(note1.get(2).toString());
					
					

					for(int k = 0; k<series; k++) {
						int participants1 = 0;
						int echecs1 = 0;
						Double sum2 = (double) 0;
						Double sum3 = (double) 0;
					for(int j = 0; j<lines1.length; j++) {
						Double sum21 = (double) 0;
						Double sum31 = (double) 0;
						List name = Arrays.asList(lines1[j].toString().split("//"));
						File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+name.get(0)+"/3eme Trimestre/"+cours+".txt");
						aws.downloadContent(file2.getPath());
						FileReader fr2;
						try {
							fr2 = new FileReader(file2);
						
						BufferedReader br2 = new BufferedReader(fr2);
						Object[] lines2 = br2.lines().toArray();
						
						List note = Arrays.asList(lines2[0].toString().split("//"));
						
						List note2 = Arrays.asList(note.get(k).toString().split("/"));
						
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
							List note11 = Arrays.asList(lines2[0].toString().split("//"));
							
							List note21 = Arrays.asList(note11.get(l).toString().split("/"));
							
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
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						if(echec) {
							echecs++;
						}else {
							echecs = echecs+0;
						}
					
				}


					if(((Container) ((Container) ((Container) Application.panelExams.getComponent(i))).getComponent(0)).getComponentCount()>0) {
					List points = Arrays.asList(note1.get(k+4).toString().split("::"));
					int max = Integer.parseInt(note1.get(1).toString())*Integer.parseInt(points.get(1).toString())/100;
					((JLabel) ((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(0)).getComponent(k)).getComponent(4)).setText((new DecimalFormat("##.##").format(sum2/participants1))+"/"+max);
					System.out.println(participants1);
					((JLabel) ((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(0)).getComponent(k)).getComponent(5)).setText((new DecimalFormat("##.##").format(100*(sum2/participants1)/max)+"%"));
					((JLabel) ((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(0)).getComponent(k)).getComponent(6)).setText(String.valueOf(echecs1));
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs1))/Double.parseDouble(String.valueOf(participants1))*100));
					((JLabel) ((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(0)).getComponent(k)).getComponent(7)).setText(reussite+"%");


					((JLabel) ((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(0)).getComponent(k)).getComponent(3)).setText(participants1+" eleves");
					}
					}
					((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(4)).setText((new DecimalFormat("##.##").format(sum/participants))+"/"+note1.get(1).toString());
					System.out.println(participants);
					((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(5)).setText((new DecimalFormat("##.##").format(100*(sum/participants)/Integer.parseInt(note1.get(1).toString()))+"%"));
					((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(6)).setText(String.valueOf(echecs));
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs))/Double.parseDouble(String.valueOf(participants))*100));
					((JLabel) ((Container) Application.panelExams.getComponent(i)).getComponent(7)).setText(reussite+"%");
					
				}}
				
	}
	
}
}