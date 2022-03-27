package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.LPane;
import app.NewTest;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import CloudOperations.aws;
import Publishing.PersonalMessage;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NewClass extends JFrame {

	public static JPanel contentPane;
	private JLabel lblNewLabel_1;
	public static JTextField className;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JButton create;
	public static JTextField textField;
	public static JPanel panel_1;
	public static JCheckBox checkBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewClass frame = new NewClass();
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
	public NewClass() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 351);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Continuer");
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			ChooseColor cc = new ChooseColor();
			cc.setVisible(true);
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(48, 270, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Nom de la classe:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(40, 122, 155, 31);
	contentPane.add(lblNomDuCours);
	
	className = new JTextField();
	className.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!className.getText().equals("") && !checkBox.isSelected() || !className.getText().equals("") && checkBox.isSelected() && !textField.getText().isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
				}
		}
	});
	className.setBorder(new LineBorder(new Color(128, 128, 128)));
	className.setHorizontalAlignment(SwingConstants.CENTER);
	className.setForeground(new Color(255, 255, 255));
	className.setCaretColor(new Color(0, 204, 255));
	className.setBackground(new Color(40, 40, 40));
	className.setFont(new Font("Roboto", Font.BOLD, 18));
	className.setColumns(10);
	className.setBounds(205, 122, 188, 28);
	contentPane.add(className);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez une nouvelle classe dans l'etablissement scolaire en tapant son nom</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.setVisible(false);
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Class.selectedClasses.toArray().length==1) {
				
				String s = null;
				if(checkBox.isSelected()) {
					s = textField.getText();
				}else {
					s = "none";
				}
			updateClass(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
					.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""), className.getText(), 
					NewClass.loadClassEducation(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
							.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")), s);
			setVisible(false);
			
			 String colors =
					 PersonalMessage.getClassColor(className.getText());
					List l = Arrays.asList(colors.split("//")); 
					List l1 = Arrays.asList(l.get(0).toString().split(",")); 
					ChooseColor.backColor = (new Color(Integer.parseInt(l1.get(0).toString()),Integer.parseInt(l1.get(1).toString()), Integer.parseInt(l1.get(2).toString())));
					  
					 List l2 = Arrays.asList(l.get(1).toString().split(",")); 
					 ChooseColor.foreColor = (new Color(Integer.parseInt(l2.get(0).toString()),Integer.parseInt(l2.get(1).toString()),Integer.parseInt(l2.get(2).toString())));
					  
			ChooseColor cc = new ChooseColor();

				cc.create.setVisible(false);
				 cc.setVisible(true);
			 cc.setVisible(true);

     		Class.loadClasses();
		}}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
	contentPane.add(actualiser);
	
	button = new JButton("Annuler");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(234, 270, 129, 31);
	contentPane.add(button);
	
	JLabel lblNouveauCours = new JLabel("Nouvelle Classe ");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	lblNouveauCours.setBounds(0, 70, 424, 28);
	contentPane.add(lblNouveauCours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 97, 424, 12);
	contentPane.add(separator);
	
	checkBox = new JCheckBox("Retrait des points en education");
	checkBox.setSelected(true);
	checkBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if(!className.getText().equals("") && !checkBox.isSelected() || !className.getText().equals("") && checkBox.isSelected() && !textField.getText().isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
				}
			
			if(checkBox.isSelected()) {
				textField.setEnabled(true);
				textField.requestFocus();
			}else {
				textField.setText("");
				textField.setEnabled(false);
			}
		}
	});
	checkBox.setBackground(new Color(40, 40, 40));
	checkBox.setFocusPainted(false);
	checkBox.setForeground(Color.WHITE);
	checkBox.setHorizontalAlignment(SwingConstants.CENTER);
	checkBox.setFont(new Font("Roboto", Font.PLAIN, 18));
	checkBox.setBounds(40, 170, 353, 31);
	contentPane.add(checkBox);
	
	panel_1 = new JPanel();
	panel_1.setBackground(new Color(40, 40, 40));
	panel_1.setBounds(40, 202, 353, 48);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	JLabel lblMaximumDePoints = new JLabel("<html>Maximum de points a retrancher par trimestre:</html>");
	lblMaximumDePoints.setBounds(10, 0, 183, 48);
	panel_1.add(lblMaximumDePoints);
	lblMaximumDePoints.setHorizontalAlignment(SwingConstants.RIGHT);
	lblMaximumDePoints.setForeground(Color.WHITE);
	lblMaximumDePoints.setFont(new Font("Roboto", Font.PLAIN, 15));
	
	textField = new JTextField();
	textField.setText("60");
	textField.setBounds(186, 10, 76, 28);
	panel_1.add(textField);
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setForeground(Color.WHITE);
	textField.setFont(new Font("Roboto", Font.BOLD, 18));
	textField.setColumns(10);
	textField.setCaretColor(new Color(0, 204, 255));
	textField.setBorder(new LineBorder(new Color(128, 128, 128)));
	textField.setBackground(new Color(40, 40, 40));


	textField.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!className.getText().equals("") && !checkBox.isSelected() || !className.getText().equals("") && checkBox.isSelected() && !textField.getText().isBlank()) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
				}
		}
	});
	
	setLocationRelativeTo(null);
	
	}
	
	
	public static String loadClassEducation(String className) {
		
		String s = null;
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		//aws.downloadContent(testList.getPath());
		FileReader fr4;
		try {
			fr4 = new FileReader(file);
		
		
		BufferedReader br3 = new BufferedReader(fr4);
		Object[] lines = br3.lines().toArray();
		
		for(int i = 0; i<lines.length; i++) {
			List parts = Arrays.asList(lines[i].toString().split("//"));
			if(parts.get(0).equals(className)) {
				s = parts.get(3).toString();
			}
		}

		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
		
	}
	
	public static void updateClass(String className, String newName, String lastEd, String newEd) {
		List<String> comp = new ArrayList();
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		aws.downloadContent(file.getPath());
				try {
					
					FileReader fr = new FileReader(file);
					
					BufferedReader br = new BufferedReader(fr);
					Object[] lines = br.lines().toArray();
	
					for(int i = 0; i< lines.length; i++) {
							comp.add(lines[i].toString());
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}

				for(int i = 0; i< comp.toArray().length; i++) {
					List l = Arrays.asList(comp.get(i).toString().split("//"));
				if(l.get(0).toString().equals(className)) {
					String s = comp.get(i).replaceAll(className+"//", newName+"//").replace("//"+lastEd+"//", "//"+newEd+"//");
					comp.add(i, s);
					comp.remove(i+1);
				}}
				if(file.exists()) {
							file.delete();
						}
				
					try {
						file.createNewFile();
						PrintWriter pw = new PrintWriter(file);

						for(int j = 0;j<comp.toArray().length;j++) {
						pw.println(comp.get(j));
						};
						
						pw.close();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
					aws.upload(file.getPath());
					

					File file4 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+className);
					
					File file5 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+newName);
					
					file4.renameTo(file5);
					

					File file2 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt");
					aws.downloadContent(file2.getPath());
							try {
								
								FileReader fr = new FileReader(file2);
								
								BufferedReader br = new BufferedReader(fr);
								Object[] lines1 = br.lines().toArray();
					
					for(int i = 0; i< lines1.length; i++) {
						List<String> comp1 = new ArrayList();
						List<String> comp2 = new ArrayList();
					List l = Arrays.asList(lines1[i].toString().split("//"));
					
					
					File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).toString().replaceAll("::", " ")+"/ClassesAndCourses.txt");
					aws.downloadContent(file1.getPath());
							try {
								
								FileReader fr1 = new FileReader(file1);
								
								BufferedReader br1 = new BufferedReader(fr1);
								Object[] lines = br1.lines().toArray();
				
								for(int j = 0; j< lines.length; j++) {
										comp1.add(lines[j].toString());
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}

							for(int j = 0; j< comp1.toArray().length; j++) {
								String s = comp1.get(j).replaceAll(className+"//", newName+"//");
								comp1.add(j, s);
								comp1.remove(j+1);
							}
							if(file1.exists()) {
										file1.delete();
									}
							
								try {
									file1.createNewFile();
									PrintWriter pw = new PrintWriter(file1);

									for(int j = 0;j<comp1.toArray().length;j++) {
									pw.println(comp1.get(j));
									};
									
									pw.close();
								
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
							}
								aws.upload(file1.getPath());
								
								

								File file11 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).toString().replaceAll("::", " ")+"/Schedule.txt");
								aws.downloadContent(file11.getPath());
										try {
											
											FileReader fr1 = new FileReader(file11);
											
											BufferedReader br1 = new BufferedReader(fr1);
											Object[] lines = br1.lines().toArray();
							
											for(int j = 0; j< lines.length; j++) {
													comp2.add(lines[j].toString());
											}
										} catch (FileNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
									}

										for(int j = 0; j< comp2.toArray().length; j++) {
											String s = comp2.get(j).replaceAll("//"+className+"//", "//"+newName+"//");
											comp2.add(j, s);
											comp2.remove(j+1);
										}
										if(file11.exists()) {
													file11.delete();
												}
										
											try {
												file11.createNewFile();
												PrintWriter pw = new PrintWriter(file11);

												for(int j = 0;j<comp2.toArray().length;j++) {
												pw.println(comp2.get(j));
												};
												
												pw.close();
											
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											
										}
											aws.upload(file11.getPath());
					}

							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
							
							
							
							
							File file3 = new File("Data/Establishments/Establishments.txt");
							aws.downloadContent(file3.getPath());
									try {
										
										FileReader fr = new FileReader(file3);
										
										BufferedReader br = new BufferedReader(fr);
										Object[] lines1 = br.lines().toArray();
							
										List<String> comp1 = new ArrayList();
										
							for(int i = 0; i< lines1.length; i++) {
							List l = Arrays.asList(lines1[i].toString().split("//"));
							File file1 = new File("Data/Establishments/"+l.get(0).toString()+"/Roles.txt");
							aws.downloadContent(file1.getPath());
									try {
										
										FileReader fr1 = new FileReader(file1);
										
										BufferedReader br1 = new BufferedReader(fr1);
										Object[] lines = br1.lines().toArray();
						
										for(int j = 0; j< lines.length; j++) {
												comp1.add(lines[j].toString());
										}
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
								}

									for(int j = 0; j< comp1.toArray().length; j++) {
										List<String> l2 = new ArrayList();
										List l1 = Arrays.asList(comp1.get(j).split("//"));
										for(int k = 0 ;k< l1.toArray().length; k++) {
											l2.add(l1.get(k).toString());
										}
										String s = "";
										for(int k = 0 ;k< l2.toArray().length; k++) {
											if(l2.get(k).toString().endsWith("::"+className)) {
											s = l2.get(k).toString().replaceAll("::"+className, "::"+newName);
										}else{
											s = l2.get(k).toString();
										}
											l2.add(k, s);
											l2.remove(k+1);
										}
										String m = "";
										for(int k = 0 ;k< l2.toArray().length; k++) {
											if(k==0) {
										m = m+l2.get(k);
										}else {

											m = m+"//"+l2.get(k);
										}
										}
										comp1.add(j, m);
										comp1.remove(j+1);
									}
									
									if(file1.exists()) {
												file1.delete();
											}
									
										try {
											file1.createNewFile();
											PrintWriter pw = new PrintWriter(file1);

											for(int j = 0;j<comp1.toArray().length;j++) {
											pw.println(comp1.get(j));
											};
											
											pw.close();
										
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										
									}
										aws.upload(file1.getPath());
							}

									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
								}
	}
}