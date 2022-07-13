package Class;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractButton;
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
import Class.OptionsMenu.ExamMenu;
import Class.OptionsMenu.ExamMenu;
import Class.OptionsMenu.ExamMenu;
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
import java.awt.PopupMenu;
import java.awt.Toolkit;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ExamBox extends JPanel {
	public static JPanel Box1;
	public static JLabel lblNdashimyeMaxBrillant;
	public static JLabel label_5;
	public static boolean isSelected;
	public static JPanel series;
	private JLabel icon;
	public static List<Component> selectedExams = new ArrayList();


	/**
	 * Create the panel.
	 */
	public ExamBox() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for(int i = 0; i< ((Container) getComponent(0)).getComponentCount(); i++) {
					((Container) getComponent(0)).getComponent(i).setPreferredSize(new Dimension(getWidth(), ((Container) getComponent(0)).getComponent(i).getPreferredSize().height));
						
			}
				((Container) getComponent(0)).revalidate();
				((Container) getComponent(0)).repaint();
			
			}
		});
		setBackground(new Color(40, 40, 40));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExamMenu.deselect();
				if((MouseEvent.CTRL_MASK & e.getModifiers())!=0) {
					if(!selectedExams.contains(getComponent(0).getParent())) {
						selectedExams.add(getComponent(0).getParent());
					}else {
						selectedExams.remove(getComponent(0).getParent());
					}
				}else {
				deselectAll();
				selectedExams.add(getComponent(0).getParent());
				}
				
				for(int i = 0; i<selectedExams.toArray().length; i++) {
					for(int j = 0; j< Application.panelExams.getComponentCount(); j++) {
						if(Application.panelExams.getComponent(j).equals(selectedExams.get(i))) {
							((Container) ((Container) Application.panelExams.getComponent(j))).getComponent(1).setBackground(new Color(20, 148, 198, 0));
							((Container) ((Container) Application.panelExams.getComponent(j)).getComponent(1)).getComponent(0).setBackground(new Color(20, 148, 198, 50));
							((Container) ((Container) Application.panelExams.getComponent(j)).getComponent(1)).getComponent(1).setBackground(new Color(20, 148, 198, 50));
							((JComponent) Application.panelExams.getComponent(j)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
							((Container) ((Container) ((Container) Application.panelExams.getComponent(j)).getComponent(1)).getComponent(0)).getComponent(0).setVisible(true);
							
							for(int k = 0;k<((Container) Application.panelExams.getComponent(j)).getComponentCount();k++) {
								((Container) Application.panelExams.getComponent(j)).getComponent(k).setForeground(Color.white);
							}
				}}}
				
			//
					
				
				if(((Container) getComponent(0)).getComponentCount()>0) {
					if(getPreferredSize().height == 67) {
					setPreferredSize(new Dimension(getWidth(), (((Container) getComponent(0)).getComponentCount()+1)*67));
				}else {
					setPreferredSize(new Dimension(getWidth(), 67));
				}
					}
				//
					ExamMenu.edit.setVisible(true);
					ExamMenu.delete.setVisible(true);
					ExamMenu.publish.setVisible(true);
					ExamMenu.stats.setVisible(true);
				if(selectedExams.toArray().length==0) {
					deselectAll();
				}
				}
			public void mouseEntered(MouseEvent e) {
				if(!selectedExams.contains(getComponent(0).getParent())) {
					((Container) getComponent(1)).getComponent(0).setBackground(new Color(60, 60, 60));
					((Container) getComponent(1)).getComponent(1).setBackground(new Color(60, 60, 60));
					//setBorder(new LineBorder(new Color(20, 148, 198)));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedExams.contains(getComponent(0).getParent())) {
					((Container) getComponent(1)).getComponent(0).setBackground(new Color(40, 40, 40));
					((Container) getComponent(1)).getComponent(1).setBackground(new Color(40, 40, 40));
					setBorder(null);
				}
				
			}
		});
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 67));
		setLayout(new BorderLayout(0, 0));
		
		series = new JPanel();
		series.setBackground(getBackground());
		series.setBorder(null);
		add(series, BorderLayout.CENTER);
		series.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 40));
		add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(1325, 67));
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(35, 30));
		panel2.setBackground(new Color(40, 40, 40));
		panel.add(panel2, BorderLayout.NORTH);
		panel2.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(35, 40));
		panel1.setBackground(new Color(20, 148, 198));
		panel2.add(panel1, BorderLayout.WEST);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\check.png"));
		panel1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblUmuhozaChrisKoen = new JLabel();
		lblUmuhozaChrisKoen.setAlignmentX(1.0f);
		lblUmuhozaChrisKoen.setText("Mathematiques Statistiques (2 series)");
		lblUmuhozaChrisKoen.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.BOLD, 16));
		panel2.add(lblUmuhozaChrisKoen, BorderLayout.CENTER);
		
		JButton stats = new JButton();
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		stats.setBackground(new Color(40, 40, 40));
		panel2.add(stats, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setPreferredSize(new Dimension(10, 37));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		panel_1.setBackground(new Color(40, 40, 40));
		
		JLabel lblProgres = new JLabel("10/04/2022");
		lblProgres.setHorizontalAlignment(SwingConstants.CENTER);
		//lblProgres.setPreferredSize(new Dimension(80, 18));
		lblProgres.setOpaque(true);
		lblProgres.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProgres.setForeground(Color.BLACK);
		lblProgres.setFont(new Font("Roboto", Font.BOLD, 14));
		lblProgres.setBackground(new Color(233, 150, 122));
		panel_1.add(lblProgres);
		
		JLabel lblNewLabel = new JLabel("Moyenne: 58.5/105");
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("-");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalTextPosition(SwingConstants.LEADING);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Roboto", Font.BOLD, 14));
		label_1.setBackground(new Color(250, 128, 114));
		panel_1.add(label_1);
		
		JLabel lblEchecs = new JLabel("12 echecs");
		lblEchecs.setVerticalAlignment(SwingConstants.TOP);
		lblEchecs.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEchecs.setForeground(new Color(211, 211, 211));
		lblEchecs.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEchecs.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEchecs);
		
		JLabel label_4 = new JLabel("-");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalTextPosition(SwingConstants.LEADING);
		label_4.setForeground(new Color(211, 211, 211));
		label_4.setFont(new Font("Roboto", Font.BOLD, 14));
		label_4.setBackground(new Color(250, 128, 114));
		panel_1.add(label_4);
		
		JLabel lblElevesManquants = new JLabel("25 sur 30 eleves ont ete corriges");
		lblElevesManquants.setVerticalAlignment(SwingConstants.TOP);
		lblElevesManquants.setHorizontalTextPosition(SwingConstants.LEADING);
		lblElevesManquants.setForeground(new Color(211, 211, 211));
		lblElevesManquants.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblElevesManquants.setBackground(new Color(250, 128, 114));
		panel_1.add(lblElevesManquants);
		
		JLabel label_3 = new JLabel("-");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalTextPosition(SwingConstants.LEADING);
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Roboto", Font.BOLD, 14));
		label_3.setBackground(new Color(250, 128, 114));
		panel_1.add(label_3);
		
		JLabel lblEducation = new JLabel("Reussite: 83%");
		lblEducation.setVerticalAlignment(SwingConstants.TOP);
		lblEducation.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEducation.setForeground(new Color(211, 211, 211));
		lblEducation.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEducation.setBackground(new Color(250, 128, 114));
		panel_1.add(lblEducation);
	
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
		//((Container) ((Container) Application.frame.getContentPane().getComponent(1)).getComponent(3)).getComponent(0).setVisible(true);
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

			if(i >0) {
				JSeparator separator = new JSeparator();
				separator.setPreferredSize(new Dimension(1000, 1));
				separator.setForeground(new Color(211, 211, 211, 50));
				Application.panelExams.add(separator);
			}
			i++;
						ExamBox eb = new ExamBox();
						Application.panelExams.add(eb);
						
						eb.setName(rs.getString("exam_id"));
						List<String> listOfSeries = Exam.getExamSeries(rs.getString("exam_id"));
						String name = TestBox.getFullName(Exam.getExamCourse(rs.getString("exam_id")));
		
						if(listOfSeries.toArray().length>1) {
			((((JLabel) ((Container) (((Container) eb.getComponent(1)).getComponent(0))).getComponent(1)))).setText("  "+name+" ("+listOfSeries.toArray().length+" series)");
		}else {
			((((JLabel) ((Container) (((Container) eb.getComponent(1)).getComponent(0))).getComponent(1)))).setText("  "+name);
			}
						((((JLabel) ((Container) ((((Container) (((Container) eb).getComponent(1))).getComponent(1)))).getComponent(0)))).setText(" "+Exam.getExamDate(rs.getString("exam_id"))+" ");
							for(int j = 0; j<listOfSeries.toArray().length; j++) {
								ExamBox eb1 = new ExamBox();
								eb1.setName(listOfSeries.get(j).toString());
								((JPanel)eb.getComponent(0)).add(eb1);
								
								((((JLabel) ((Container) (((Container) eb1.getComponent(1)).getComponent(0))).getComponent(1)))).setText("  "+Exam.getSerieName(listOfSeries.get(j)));
								((((JLabel) ((Container) ((((Container) (((Container) eb1).getComponent(1))).getComponent(1)))).getComponent(0)))).setVisible(false);;
								((Container) ((Container) (eb1).getComponent(1)).getComponent(0)).getComponent(0).setVisible(false);
								
								((((AbstractButton) ((Container) (((Container) eb1.getComponent(1)).getComponent(0))).getComponent(2)))).setIcon(null);
								((JPanel)eb.getComponent(0)).revalidate();
								((JPanel)eb.getComponent(0)).repaint();
								}
							if(((Container) eb.getComponent(0)).getComponentCount()>0) {
						((((AbstractButton) ((Container) (((Container) eb.getComponent(1)).getComponent(0))).getComponent(2)))).setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
					}else{
						((((AbstractButton) ((Container) (((Container) eb.getComponent(1)).getComponent(0))).getComponent(2)))).setIcon(null);
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
						
						List note2 = Arrays.asList(LPane.loadStudentSerieNote(listOfSeries.get(k), lines1[j].toString()).split("/"));
						
						Double d = Double.parseDouble(note2.get(0).toString());
						Double e = Double.parseDouble(note2.get(1).toString());
						
						
						if(e == 0 && d == 0) {
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
					
				}

					if(((Container) ((Container) (c)).getComponent(0)).getComponentCount()>0) {
					double max = Double.parseDouble(Exam.getSerieMaxima(listOfSeries.get(k)));
					((((JLabel) ((Container) ((((((Container) (((((Container) ((((Container) (((Container) c).getComponent(0))).getComponent(k)))).getComponent(1))))).getComponent(1)))))).getComponent(1)))).setText("Moyenne: "+(new DecimalFormat("##.##").format(sum2/sum3*max))+"/"+max);
					((((JLabel) ((Container) ((((((Container) (((((Container) ((((Container) (((Container) c).getComponent(0))).getComponent(k)))).getComponent(1))))).getComponent(1)))))).getComponent(3)))).setText(String.valueOf(echecs1)+" echecs");
					((((JLabel) ((Container) ((((((Container) (((((Container) ((((Container) (((Container) c).getComponent(0))).getComponent(k)))).getComponent(1))))).getComponent(1)))))).getComponent(5)))).setText(participants1+" sur "+lines1.length+" eleves ont ete corriges");
					
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs1))/Double.parseDouble(String.valueOf(participants1))*100));
					((((JLabel) ((Container) ((((((Container) (((((Container) ((((Container) (((Container) c).getComponent(0))).getComponent(k)))).getComponent(1))))).getComponent(1)))))).getComponent(7)))).setText("Reussite a: "+reussite+"%");


					}
					if(participants1> participants) {
						participants = participants1;
					}
					}
					if(((sum1/2)<=sum)) {
						echecs = echecs+0;
					}
					else{
						echecs++;
					}
					Double max  = Double.parseDouble(Exam.getExamMaxima(exam_id));
					((((JLabel) ((Container) ((((Container) (((Container) c).getComponent(1))).getComponent(1)))).getComponent(1)))).setText("Moyenne: "+(new DecimalFormat("##.##").format(sum/sum1*max))+"/"+max);
					((((JLabel) ((Container) ((((Container) (((Container) c).getComponent(1))).getComponent(1)))).getComponent(3)))).setText(String.valueOf(echecs)+" echecs");
					((((JLabel) ((Container) ((((Container) (((Container) c).getComponent(1))).getComponent(1)))).getComponent(5)))).setText(participants+" sur "+lines1.length+" eleves ont ete corriges");
					
					String reussite = new DecimalFormat("##.##").format(100-(Double.parseDouble(String.valueOf(echecs))/Double.parseDouble(String.valueOf(participants))*100));
					((((JLabel) ((Container) ((((Container) (((Container) c).getComponent(1))).getComponent(1)))).getComponent(7)))).setText("Reussite a: "+reussite+"%");
					
					c.revalidate();
					c.repaint();
				
}

public static void deselectAll() {
	for(int i = 0; i< ((Container) Application.panelExams).getComponentCount(); i++) {
		if(((Container) Application.panelExams).getComponent(i) instanceof ExamBox) {
		if(selectedExams.contains(((Container) Application.panelExams).getComponent(i))) {
			((JComponent) ((Container) Application.panelExams).getComponent(i)).setBackground(new Color(40, 40, 40));
			((Container) ((JComponent) ((Container) Application.panelExams).getComponent(i)).getComponent(1)).getComponent(0).setBackground(new Color(40, 40, 40));
			((Container) ((JComponent) ((Container) Application.panelExams).getComponent(i)).getComponent(1)).getComponent(1).setBackground(new Color(40, 40, 40));
			((JComponent) ((Container) Application.panelExams).getComponent(i)).setBorder(null);
			//((Container) Application.panelExams.getComponent(i)).setPreferredSize(new Dimension(((Container) Application.panelExams.getComponent(i)).getWidth(), 67));
			}
		((Container) ((Container) ((Container) Application.panelExams.getComponent(i)).getComponent(1)).getComponent(0)).getComponent(0).setVisible(false);
			Application.panelExams.revalidate();

			Application.panelExams.repaint();
		}
	}

	selectedExams.clear();
	
	ExamMenu.deselect();
}
}