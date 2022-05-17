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
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
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
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import Class.TestBox;
import CloudOperations.aws;
import CloudOperations.mysql;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class ClassesAndCourses extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	private JLabel lblManirakizaDiomede;
	public static JPanel panel;
	public static JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					ClassesAndCourses frame = new ClassesAndCourses("1", "2");
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
	public ClassesAndCourses(String teacher_id, String ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Terminer");
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			save(teacherName);
			setVisible(false);
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(50, 519, 120, 31);
	contentPane.add(create);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
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
	button.setBounds(236, 519, 129, 31);
	contentPane.add(button);
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Ajoutez les classes qu'occupera ce professeur ainsi que les cours qu'il dispensera</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 404, 48);
	contentPane.add(lblajoutezLesClasses);
	
	lblManirakizaDiomede = new JLabel(Teacher.getTeacherName(teacher_id));
	lblManirakizaDiomede.setHorizontalAlignment(SwingConstants.CENTER);
	lblManirakizaDiomede.setForeground(Color.WHITE);
	lblManirakizaDiomede.setFont(new Font("Roboto", Font.BOLD, 22));
	lblManirakizaDiomede.setBounds(0, 50, 424, 31);
	contentPane.add(lblManirakizaDiomede);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 46, 424, 12);
	contentPane.add(separator);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBounds(0, 82, 424, 12);
	contentPane.add(separator_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 92, 404, 416);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addContainerListener(new ContainerAdapter() {
		@Override
		public void componentAdded(ContainerEvent e) {
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 5));
	
	
	JButton plus = new JButton("+");
	plus.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			plus.setBackground(plus.getBackground().brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			plus.setBackground(plus.getParent().getBackground());
		}
	});
	plus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ClassSelection cs = new ClassSelection(ay_id);
			cs.setVisible(true);
			for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
				for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
					((JComponent) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).setBorder(null);
				}}
		}
	});
	plus.setForeground(Color.WHITE);
	plus.setBorderPainted(false);
	plus.setFocusPainted(false);
	plus.setPreferredSize(new Dimension(400, 37));
	plus.setFont(new Font("Roboto", Font.PLAIN, 40));
	panel.add(plus);
	plus.setBackground(panel.getBackground());

	setLocationRelativeTo(null);
	load(teacher_id, ay_id);

	}
	
	public static void checkContinuation() {
		boolean isEmpty = false;
		if(ClassesAndCourses.panel.getComponentCount()>1) {
		for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
			if(((Container) ClassesAndCourses.panel.getComponent(m)).getComponentCount()>1) {
			if(((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1<1) {
				isEmpty = true;
			}	}
	}}else {
		isEmpty = true;
	}
		if(isEmpty) {
			create.setEnabled(false);
		}else {
			create.setEnabled(true);
		}
	}
	
	public static void save(String name) {
		List<String> comp = new ArrayList();
		for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
			String s = ((JLabel) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(0)).getComponent(0)).getText();
			for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
				s = s+"//"+ ((JLabel) ((Container) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).getComponent(0)).getText()+":"+
						((JLabel) ((Container) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).getComponent(1)).getText().replaceAll("[^0-9]+", "");
			}
			comp.add(s);
			}
		
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+name+"/ClassesAndCourses.txt");
		
		if(file1.exists()) {
					file1.delete();
				}
		
			try {
				file1.createNewFile();
				PrintWriter pw = new PrintWriter(file1);

				for(int j = 0;j<comp.toArray().length;j++) {
				pw.println((String)comp.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			aws.upload(file1.getPath());
	}
	
	public static void load(String teacher_id, String ay_id) {
		
		List<String> s = new ArrayList();
		List<String> s1 = new ArrayList();

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN courses_in_classroom AS cic "
					+ "JOIN classrooms as c "
					+ "JOIN courses as co "
					+ "JOIN classrooms_in_ay as cia "
					+ "WHERE cic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id  AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND c.classroom_id = cia.classroom_id AND cia.is_active = 1 AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ " AND tic.courses_in_classroom_id = cic.courses_in_classroom_id AND cic.course_id = co.course_id AND co.is_active = 1");
			while(rs.next())
			{
				s.add(rs.getString("cia.cia_id")+"//"+rs.getString("cic.courses_in_classroom_id")+":"+rs.getString("tic.sessions_per_week"));
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}

					Object[] lines = s.toArray();
					
					List<String> classes = new ArrayList();
					for(int i = 0; i< lines.length; i++) {
						List l = Arrays.asList(lines[i].toString().split("//"));
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(l.get(0).toString());
				panel_1.setBackground(new Color(80, 80, 80));
				panel_1.setPreferredSize(new Dimension(390, 55));
				panel_1.setLayout(new BorderLayout(0, 0));

				if(!classes.contains(l.get(0).toString())) {
					classes.add((String) l.get(0));
				ClassesAndCourses.panel.add(panel_1, classes.toArray().length-1);
				
				JPanel panel_4 = new JPanel();
				panel_4.setPreferredSize(new Dimension(10, 30));
				panel_1.add(panel_4, BorderLayout.NORTH);
				panel_4.setLayout(new BorderLayout(0, 0));

				panel_4.setBackground(panel_4.getParent().getBackground());
				
				JLabel label = new JLabel(Home.getClassName(l.get(0).toString()));
				label.setBackground(Color.DARK_GRAY);
				label.setPreferredSize(new Dimension(46, 30));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Roboto", Font.BOLD, 20));
				panel_4.add(label, BorderLayout.CENTER);
				label.setName(l.get(0).toString());
				
				JButton button_1 = new JButton("");
				button_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
				button_1.setPreferredSize(new Dimension(30, 9));
				button_1.setFocusPainted(false);
				button_1.setBorderPainted(false);
				button_1.setBackground(new Color(40, 40, 40));
				panel_4.add(button_1, BorderLayout.EAST);
				button_1.setBackground(button_1.getParent().getBackground());
				
				
				JPanel panel_2 = new JPanel();
				panel_1.add(panel_2, BorderLayout.CENTER);
				panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
				panel_2.setBackground(panel_2.getParent().getBackground());
				
				JButton btnNewButton = new JButton("+");
				btnNewButton.setFocusPainted(false);
				btnNewButton.setBorderPainted(false);
				btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 25));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setPreferredSize(new Dimension(390, 25));
				panel_2.add(btnNewButton);
				btnNewButton.setBackground(btnNewButton.getParent().getParent().getBackground());

				ClassesAndCourses.panel.revalidate();
				ClassesAndCourses.panel.repaint();
				

				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton.setBackground(btnNewButton.getBackground().brighter());
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton.setBackground(btnNewButton.getParent().getParent().getBackground());
					}
				});
				
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("done1");
						button_1.getParent().getParent().getParent().remove(button_1.getParent().getParent());
						ClassesAndCourses.panel.revalidate();
						ClassesAndCourses.panel.repaint();
						ClassesAndCourses.checkContinuation();

					}
				});
				ClassesAndCourses.checkContinuation();

					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							courseSelection cs = new courseSelection(((JLabel) ((Container) btnNewButton.getParent().getParent().getComponent(0)).getComponent(0)).getName());
							cs.setVisible(true);
							
							for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
								for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
									((JComponent) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).setBorder(null);
								}}
						}
					});
				}
				
				for(int j = 1; j< l.toArray().length; j++) {
					
						List l1 = Arrays.asList(l.get(j).toString().split(":"));
							
							
							JPanel panel_3 = new JPanel();
							panel_3.setBackground(new Color(40, 40, 40));
							panel_3.setPreferredSize(new Dimension(380, 25));
							panel_3.setLayout(null);
							
							JLabel lblNewLabel_1 = new JLabel(TestBox.getFullName(l1.get(0).toString()));
							lblNewLabel_1.setForeground(Color.WHITE);
							lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
							lblNewLabel_1.setBounds(10, 0, 256, 25);
							panel_3.add(lblNewLabel_1);
							
							JLabel lblheures = new JLabel(l1.get(1).toString().replaceAll("null", "0")+" s.");
							lblheures.setForeground(Color.WHITE);
							lblheures.setHorizontalAlignment(SwingConstants.CENTER);
							lblheures.setFont(new Font("Roboto", Font.PLAIN, 17));
							lblheures.setBounds(276, 0, 50, 25);
							panel_3.add(lblheures);
							
							JButton btnNewButton_1 = new JButton("");
							btnNewButton_1.setFocusPainted(false);
							btnNewButton_1.setBorderPainted(false);
							btnNewButton_1.setPreferredSize(new Dimension(30, 9));
							btnNewButton_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
							btnNewButton_1.setBounds(345, 0, 35, 25);
							panel_3.add(btnNewButton_1);
							btnNewButton_1.setBackground(btnNewButton_1.getParent().getBackground());
							
							panel_3.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									
									for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
									for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
										((JComponent) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).setBorder(null);
									}}

									panel_3.setBorder(new LineBorder(Color.white, 1));
									if(e.getClickCount()==2) {
										courseSelection cs = new courseSelection(((JLabel) ((Container) panel_3.getParent().getParent().getComponent(0)).getComponent(0)).getName());
										cs.setVisible(true);
										cs.create.setVisible(false);
										cs.actualiser.setVisible(true);
										cs.comboBox.addItem(((JLabel) panel_3.getComponent(0)).getText());
										cs.comboBox.setSelectedItem(((JLabel) panel_3.getComponent(0)).getText());
										cs.comboBox.setEnabled(false);
										cs.textField.setText(((JLabel) panel_3.getComponent(1)).getText().replaceAll("[^0-9]+", ""));
										cs.textField.requestFocus();
										

										cs.actualiser.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												for(int m = 0; m<  panel_3.getComponentCount()-1; m++) {
													((JLabel) panel_3.getComponent(1)).setText(cs.textField.getText()+" s.");
											}
												cs.setVisible(false);
											}
										});
									}
								}
							});
							
							ClassesAndCourses.panel.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									
									for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
									for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
										((JComponent) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).setBorder(null);
									}}
								}
							});

							int j1 = i;
							btnNewButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										btnNewButton_1.getParent().getParent().remove(btnNewButton_1.getParent());

										ClassesAndCourses.panel.revalidate();
										ClassesAndCourses.panel.repaint();
										ClassesAndCourses.checkContinuation();
										courseSelection.refresh();
									}
								});
							
							for(int k = 0; k< ClassesAndCourses.panel.getComponentCount()-1; k++) {
								if(ClassesAndCourses.panel.getComponent(k).getName().equals(l.get(0).toString())) {
							((JPanel)((Container) ClassesAndCourses.panel.getComponent(k)).getComponent(1)).add(panel_3, ((JPanel)((Container) ClassesAndCourses.panel.getComponent(k)).getComponent(1)).getComponentCount()-1);
							ClassesAndCourses.checkContinuation();
							((JPanel)((Container) ClassesAndCourses.panel.getComponent(k)).getComponent(1)).revalidate();
							((JPanel)((Container) ClassesAndCourses.panel.getComponent(k)).getComponent(1)).repaint();
							
							((Container) ClassesAndCourses.panel.getComponent(k)).setPreferredSize(new Dimension(390,
									30+(((Container)((Container) ClassesAndCourses.panel.getComponent(k)).getComponent(1)).getComponentCount()-1)*25+25));
								}}
						}
				//System.out.println(ClassesAndCourses.panel.getParent().getWidth()+"//"+30+(((Container)panel_1.getComponent(1)).getComponentCount()-1)*25+25);
				ClassesAndCourses.panel.revalidate();
				ClassesAndCourses.panel.repaint();
	}
		
		
	}
}