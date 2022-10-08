package Application;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.Animations;
import Class.Application;
import Class.Course;
import Class.NewExam;
import Class.OptionsMenu.HomeMenu1;
import CloudOperations.aws;
import CloudOperations.mysql;
import Stats.CourseStats;
import Stats.StatsPane;
import Stats.StudentStats;
import accounts.Loading;
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.App;
import sideInformation.ClassInfo;
import sideInformation.MainInfo;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class Class extends JPanel {
	public static JLabel className;
	public static JPanel courseBox;
	public static JPanel Box1;
	public static boolean isSelected;

	public static List <String> classList = new ArrayList();

	public static List <Component> selectedClasses = new ArrayList();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblCours;
	private JLabel lblInterros;
	

	/**
	 * Create the panel.
	 */
	public Class(String ay_id) {
		
		
		
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBackground(new Color(60, 60, 60));
	setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
	setPreferredSize(new Dimension(150, 120));
	setLayout(new BorderLayout(0, 0));
	
	
	
	courseBox = new JPanel();
	courseBox.setBorder(null);
	courseBox.setBackground(new Color(0, 121, 50));
	courseBox.setPreferredSize(new Dimension(135, 10));
	add(courseBox, BorderLayout.CENTER);
	courseBox.setLayout(new BorderLayout(0, 0));
	
	className = new JLabel("<html><div style='text-align: center;'>3eme PF Bio-ChimieassAn");
	className.setBorder(null);
	className.setForeground(Color.WHITE);
	className.setBackground(Color.GREEN);
	className.setFont(new Font("Roboto", Font.BOLD, 14));
	className.setHorizontalAlignment(SwingConstants.CENTER);
	courseBox.add(className);
	
	panel_1 = new JPanel();
	panel_1.setBackground(Color.DARK_GRAY);
	panel_1.setPreferredSize(new Dimension(10, 40));
	panel_1.setMinimumSize(new Dimension(10, 40));
	courseBox.add(panel_1, BorderLayout.SOUTH);
	panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));
	
	lblNewLabel_1 = new JLabel("143 eleves");
	lblNewLabel_1.setForeground(new Color(211, 211, 211));
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_1.add(lblNewLabel_1);
	
	lblCours = new JLabel("93 cours");
	lblCours.setForeground(new Color(211, 211, 211));
	lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_1.add(lblCours);
	
	lblInterros = new JLabel("193 interros");
	lblInterros.setForeground(new Color(211, 211, 211));
	lblInterros.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_1.add(lblInterros);
	
	panel = new JPanel();
	panel.setVisible(false);
	panel.setBackground(new Color(20, 148, 198));
	panel.setPreferredSize(new Dimension(10, 25));
	panel.setMinimumSize(new Dimension(10, 20));
	add(panel, BorderLayout.SOUTH);
	panel.setLayout(new BorderLayout(0, 0));
	
	lblNewLabel = new JLabel("");
	lblNewLabel.setIconTextGap(0);
	lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNewLabel.setIcon(ResizeImages.resize(20, 20, "Icons\\check.png"));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	panel.add(lblNewLabel, BorderLayout.CENTER);
	
	//Home.collapse(getComponent(0).getParent());
    addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeMenu1.deselect();
				boolean alreadyExists = false;
				if((MouseEvent.CTRL_MASK & e.getModifiers())!=0) {
					if(!selectedClasses.contains(getComponent(0).getParent())) {
					selectedClasses.add(getComponent(0).getParent());
					}else {
						selectedClasses.remove(getComponent(0).getParent());
						setBorder(new LineBorder(Color.cyan,4));
						((JComponent) getComponent(0)).setBorder(new LineBorder(Color.black,2));
						((JComponent) getComponent(0)).setBackground(((JComponent) getComponent(0)).getBackground().darker());
						((JComponent) getComponent(1)).setVisible(false);
						(((JComponent) getComponent(0)).getComponent(1)).setVisible(true);
					}
				}else {

					if(selectedClasses.contains(getComponent(0).getParent())) {
					alreadyExists = true;
					}
				deselectAll(ay_id);
				HomeMenu1.deselect();
				selectedClasses.add(getComponent(0).getParent());
				}

				HomeMenu1.panel.getComponent(2).setVisible(true);

				if(Class.selectedClasses.toArray().length==1) {
					Component comp = null;
				HomeMenu1.panel.getComponent(1).setVisible(true);
				HomeMenu1.panel.getComponent(5).setVisible(true);
				HomeMenu1.panel.getComponent(6).setVisible(true);

				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					if(Home.panelClasses.getComponent(i) instanceof Class) {
						if(Home.panelClasses.getComponent(i).equals(Class.selectedClasses.get(0))) {
							comp = Home.panelClasses.getComponent(i);
						}
					}else {
						for(int j = 0; j< ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponentCount(); j++) {
						if(((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j).equals(Class.selectedClasses.get(0))) {
							comp = ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j);
						}
					}}}
				
						if(!comp.equals(null)) {
				if(comp.getParent().getComponent(comp.getParent().getComponentCount()-1).equals(comp)) {
					HomeMenu1.panel.getComponent(6).setVisible(false);
				}
				if(comp.getParent().getComponent(0).equals(comp)) {
					HomeMenu1.panel.getComponent(5).setVisible(false);
				}
				}}
				
				if(Class.selectedClasses.toArray().length>1) {
					boolean hasGroup = false;
					int classes = Class.selectedClasses.toArray().length;
					for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
						if(Home.panelClasses.getComponent(i) instanceof Class) {
							for(int j = 0; j< Class.selectedClasses.toArray().length; j++) {
								if(Home.panelClasses.getComponent(i).equals(Class.selectedClasses.get(j))) {
									classes--;
								}
							}
						}
						}
					System.out.println(classes);
					if(classes == 0) {
							HomeMenu1.panel.getComponent(4).setVisible(true);
						}else{
							HomeMenu1.panel.getComponent(4).setVisible(false);
						}
				}
				
				
				
				for(int i = 0; i<selectedClasses.toArray().length; i++) {
					((JComponent) selectedClasses.get(i)).setBorder(new LineBorder(new Color(20, 148, 198),4));
					((JComponent) ((JComponent) selectedClasses.get(i)).getComponent(0)).setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
					((JComponent) ((JComponent) selectedClasses.get(i)).getComponent(1)).setVisible(true);
					(((JComponent) ((JComponent) selectedClasses.get(i)).getComponent(0)).getComponent(1)).setVisible(false);
					
					if(selectedClasses.get(i).equals(getComponent(0).getParent())) {
						if(!alreadyExists) {
					((JComponent) ((JComponent) selectedClasses.get(i)).getComponent(0)).setBackground(((JComponent) ((JComponent) selectedClasses.get(i)).getComponent(0)).getBackground().brighter());
				}}
				}
				
				
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					if(Home.panelClasses.getComponent(i) instanceof Group) {

						((Container) ((Container) (((Container) Home.panelClasses.getComponent(i)).getComponent(1))).getComponent(1)).getComponent(0).setVisible(false);

						((Container) ((Container) (((Container) Home.panelClasses.getComponent(i)).getComponent(1))).getComponent(0)).getComponent(2).setVisible(true);
						((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(1)).getComponent(1).setPreferredSize(new Dimension(
								80, 45));
						Home.panelClasses.revalidate();

						Home.panelClasses.repaint();
						
						
							boolean groupIsSelected = true;
							List <Component> components = new ArrayList();
							for(int j = 0; j< ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponentCount(); j++) {
								components.add(((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(0)).getComponent(j));
							}
							
							for(int j = 0; j< selectedClasses.toArray().length; j++) {
								if(!components.contains(selectedClasses.get(j))) {
									groupIsSelected = false;
								}
							}
							if(groupIsSelected) {

								((Container) ((Container) (((Container) Home.panelClasses.getComponent(i)).getComponent(1))).getComponent(1)).getComponent(0).setVisible(true);

								((Container) ((Container) (((Container) Home.panelClasses.getComponent(i)).getComponent(1))).getComponent(0)).getComponent(2).setVisible(false);
								((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(1)).getComponent(1).setPreferredSize(new Dimension(
										160, 45));
								Home.panelClasses.revalidate();

								Home.panelClasses.repaint();}}
    }}
			public void mouseEntered(MouseEvent e) {
				if(!selectedClasses.contains(getComponent(0).getParent())) {
				setBorder(new LineBorder(Color.white,2));
				((JComponent) getComponent(0)).setBorder(new LineBorder(Color.black,2));
				((JComponent) getComponent(0)).setBackground(((JComponent) getComponent(0)).getBackground().darker());
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedClasses.contains(getComponent(0).getParent())) {
				setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
				((JComponent) getComponent(0)).setBorder(null);
				((JComponent) getComponent(0)).setBackground(((JComponent) getComponent(0)).getBackground().brighter());
				}
		}
		});
		
    
    
	}
	
	

	public static void loadClasses(String term_id, String ay_id) {
		
		Class.selectedClasses.clear();
		classList.clear();
		Home.panelClasses.removeAll();
		
			Object[] lines = Home.loadActiveClasses(ay_id);
			System.out.println(lines.length);
			
			for(int i = 0; i<lines.length; i++) {
				String parentId = getParentId(lines[i].toString());
				String parentName = getParentName(parentId);
			if(!hasParent(lines[i].toString())) {
			Class c = new Class(ay_id);
			Home.panelClasses.add(c);
			c.className.setText("<html><div style='text-align: center;'>"+getClassName(lines[i].toString())+"</div></html>");
			c.setName(lines[i].toString());

			Class.Actions(c, term_id, ay_id);
			
			c.courseBox.setBackground(Home.getClassColors(lines[i].toString()).get(0));
			
			c.className.setForeground(Home.getClassColors(lines[i].toString()).get(1));
			

			((Container) c.getComponent(0)).getComponent(1).setBackground(c.courseBox.getBackground().darker());
			

			Class.loadData(c, lines[i].toString(), term_id, ay_id);
			}else {
				if(!groupExists(parentId)) {
				Group g = new Group(term_id, ay_id);
				Home.panelClasses.add(g);
				g.groupName.setText(parentName);
				g.setName(parentId);


				((Container) g.getComponent(0)).addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
				Group.deselectGroup(((Container) g.getComponent(0)), ay_id);
				
					}
					@Override
					public void mouseEntered(MouseEvent e) {

						g.setBorder(new LineBorder(Color.white, 2));
						}
					@Override
					public void mouseExited(MouseEvent e) {
						((JComponent) g.getComponent(1)).setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
					g.setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
					}
				});
				((Container) g.getComponent(1)).getComponent(0).addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(g.getPreferredSize().height>47) {
							Group.collapse((Component)g);
							((Container) g.getComponent(1)).getComponent(1).setVisible(false);
						}else {
							Group.expand((Component)g);
							((Container) g.getComponent(1)).getComponent(1).setVisible(true);
						}
					}
				});
				
				
				((Container) ((Container) g.getComponent(1)).getComponent(0)).getComponent(0).addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {

						if(g.getPreferredSize().height>47) {
							Group.collapse((Component)g);
							((Container) g.getComponent(1)).getComponent(1).setVisible(false);
						}else {
							Group.expand((Component)g);
							((Container) g.getComponent(1)).getComponent(1).setVisible(true);
						}
					
						if(e.getClickCount()==2) {

							NewGroup ng = new NewGroup();
							ng.className.setText(((JLabel) ((Container) ((Container) g.getComponent(1)).getComponent(0)).getComponent(0)).getText());
							ng.setVisible(true);
							ng.actualiser.setVisible(true);
							ng.create.setVisible(false);
							

							ng.actualiser.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									AddToGroup.replaceGroup(((JLabel) ((Container) ((Container) g.getComponent(1)).getComponent(0)).getComponent(0)).getText(), 
											ng.className.getText());
									ng.setVisible(false);
									Class.loadClasses(term_id, ay_id);
								}
							});
						
					}}
				});
					


				g.btnExtraire.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						int j = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
						
						for(int i = 0; i< selectedClasses.toArray().length; i++) {
								AddToGroup.changeGroup(((JLabel) ((Container) (((Container) selectedClasses.get(i)).getComponent(0))).getComponent(0)).getText()
										.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""), "none");
						}
						Class.loadClasses(term_id, ay_id);
							((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(j); 
						}
					
				});
				g.addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Class.deselectAll(ay_id);
					AddToGroup a = new AddToGroup(parentId);
					a.setVisible(true);
				}
				});

				Group.loadGroupComponents(parentId, term_id, ay_id);
			}
			}
			
			classList.add(lines[i].toString());
			}
			Home.panelClasses.revalidate();
			Home.panelClasses.repaint();
		

		Class.deselectAll(ay_id);
		HomeMenu1.deselect();

		if(Home.panelClasses.getComponentCount() == 0) {
			JLabel lblNewLabel = new JLabel("Il n'y a actuellement aucune classe dans cet annee scholaire..");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
			Home.panelClasses.add(lblNewLabel);
			

			Home.panelClasses.revalidate();
			Home.panelClasses.repaint();
		}
		
	}
	
	public static boolean hasParent(String classroom_in_ay_id) {
		boolean granted = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from classroom_parents AS cp "
				+ "JOIN parents_of_classrooms AS poc "
				+ "WHERE cp.cia_id = '"+classroom_in_ay_id+"' AND poc.parent_id = cp.parent_id  LIMIT 1");
		
		int i = 0;
		while(rs.next())
		{
			i++;
		}
		if(i == 1) {
			granted = true;
		}else {
			granted = false;
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

		return granted;
	}



	public static String getClassName(String classroom_id) {
		String name = null;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from classrooms "
				+ "WHERE classroom_id = '"+classroom_id+"' LIMIT 1");
		while(rs.next())
		{
			name = rs.getString("classroom_name");
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return name;
	}



	public static String getParentName(String parentId) {
		String name = null;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from parents_of_classrooms "
				+ "WHERE parent_id = '"+parentId+"' LIMIT 1");
		while(rs.next())
		{
			name = rs.getString("parent_name");
		}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return name;
	}



	public static String getParentId(String classroom_in_ay_id) {
		String id = null;

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from classroom_parents AS cp "
					+ "JOIN parents_of_classrooms AS poc "
					+ "WHERE cp.cia_id = '"+classroom_in_ay_id+"' AND poc.parent_id = cp.parent_id  LIMIT 1");
			while(rs.next())
			{
				id = rs.getString("cp.parent_id");
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return id;
	}



	public static boolean groupExists(String s) {
		
		boolean exists = false;
		for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
			if(Home.panelClasses.getComponent(i) instanceof Group) {
				if(((JLabel) ((Container) ((Container) ((Container) Home.panelClasses.getComponent(i)).getComponent(1)).getComponent(0)).getComponent(0)).getText().equals(s)) {
					exists = true;
				}
			}
		}
		return exists;
		
	}
	
	public static void Actions(Component c, String term_id, String ay_id) {
		
			if(c instanceof Class) {
			c.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {


					Loading l = new Loading();
					l.setVisible(true);
					
				    new Thread(new Runnable(){
				    @Override
				    public void run(){
				if(e.getClickCount()==2) {
					Home.className = ((JLabel) ((JPanel) ((((Container) (c)).getComponent(0)))).getComponent(0)).getText()
							.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "");
					Application app = new Application(c.getName());
					app.frame.setVisible(true);
					
					Home.frame.setVisible(false);
					
				}
				
				 SwingUtilities.invokeLater(new Runnable(){
		             @Override public void run(){
		            	 l.setVisible(false);
		           }
		          });
		       }

		    }).start();
			}
		});
		}
	}
	
public static void loadData(Component c, String classroom_in_ay_id, String term_id, String ay_id) {
		if(c instanceof Class) {
	
	int number = StudentStats.getNumberOfStudents(classroom_in_ay_id);
	((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(1)).getComponent(0)).setText(number+" eleves");
	
	int courses = CourseStats.getNumberOfCourses(classroom_in_ay_id);
	
	((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(1)).getComponent(1)).setText(courses+" cours");
	
	List l20 = CourseStats.getStudentTestsStats("All", classroom_in_ay_id, "All", term_id, "All", "All");
	
	((JLabel) ((Container) ((Container) ((Container) c).getComponent(0)).getComponent(1)).getComponent(2)).setText(((List) l20.get(6)).toArray().length+" interros");

	((Container) c).revalidate();
	((Container) c).repaint();
	
	}else {
		for(int j = 0; j<((Container) ((Container) c).getComponent(0)).getComponentCount(); j++) {
		
		int number = StudentStats.getNumberOfStudents(classroom_in_ay_id);
		((JLabel) ((Container) ((Container) (((Container) (((Container) ((Container) c).getComponent(0)).getComponent(j))).getComponent(0))).getComponent(1)).getComponent(0)).setText(number+" eleves");

		int courses = CourseStats.getNumberOfCourses(classroom_in_ay_id);
		
		((JLabel) ((Container) ((Container) (((Container) (((Container) ((Container) c).getComponent(0)).getComponent(j))).getComponent(0))).getComponent(1)).getComponent(1)).setText(courses+" cours");
		
		List l20 = CourseStats.getStudentTestsStats("All", classroom_in_ay_id, "All", term_id, "All", "All");
		
		((JLabel) ((Container) ((Container) (((Container) (((Container) ((Container) c).getComponent(0)).getComponent(j))).getComponent(0))).getComponent(1)).getComponent(2)).setText(l20.get(2)+" interros");

		((Container) c).revalidate();
		((Container) c).repaint();
		
		}
		
	}
		Home.panelClasses.revalidate();
		Home.panelClasses.repaint();
	}


public static void deselectAll(String ay_id) {
	for(int i = 0; i< ((Container) Home.panelClasses).getComponentCount(); i++) {
		if(((Container) Home.panelClasses).getComponent(i) instanceof Class) {
		if(Class.selectedClasses.contains(((Container) Home.panelClasses).getComponent(i))) {
			

			((JComponent) ((Container) Home.panelClasses).getComponent(i)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
			((JComponent) ((JComponent) ((Container) Home.panelClasses).getComponent(i)).getComponent(0)).setBorder(null);
			
			((JComponent) ((JComponent) ((Container) Home.panelClasses).getComponent(i)).getComponent(1)).setVisible(false);
			(((JComponent) ((JComponent) ((Container) Home.panelClasses).getComponent(i)).getComponent(0)).getComponent(1)).setVisible(true);
		}
			Home.panelClasses.revalidate();

			Home.panelClasses.repaint();
	
		}else if(!(((Container) Home.panelClasses).getComponent(i) instanceof JLabel)) {
			Group.deselectGroup(((Container) ((Container) Home.panelClasses).getComponent(i)).getComponent(0), ay_id);
		}
	}

	Class.selectedClasses.clear();
	Home.frame.revalidate();
	Home.frame.repaint();
	
	HomeMenu1.deselect();
}
}
