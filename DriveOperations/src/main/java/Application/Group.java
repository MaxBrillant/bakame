package Application;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import app.WrapLayout;
import sideInformation.ClassInfo;
import sideInformation.MainInfo;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.OptionsMenu.HomeMenu1;
import CloudOperations.aws;
import CloudOperations.mysql;
import Publishing.PersonalMessage;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Group extends JPanel {
	public static JLabel groupName;
	public static JLabel classNumber;
	public static JButton addButton;
	public static JButton btnExtraire;

	/**
	 * Create the panel.
	 */
	public Group(String term_id, String ay_id) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				setBorder(new LineBorder(Color.white, 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
			}
		});
		
		setPreferredSize(new Dimension(760, 345));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).brighter());
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));

		setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setPreferredSize(new Dimension(10, 45));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		

		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		panel_2.setBackground(panel_2.getParent().getBackground());
		

		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(getPreferredSize().height<=47) {
				panel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

				}
				setBorder(new LineBorder(Color.white, 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				panel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
			}
		});
		
		groupName = new JLabel("Section Economique");
		groupName.setBounds(10, 10, 299, 23);
		panel_2.add(groupName);
		groupName.setForeground(new Color(255, 255, 255));
		groupName.setIcon(ResizeImages.resize(30, 30, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\drop1.png"));
		groupName.setFont(new Font("Roboto", Font.BOLD, 20));
		
		classNumber = new JLabel("20 classes");
		classNumber.setBounds(309, 10, 93, 23);
		panel_2.add(classNumber);
		classNumber.setForeground(new Color(255, 255, 255));
		classNumber.setHorizontalAlignment(SwingConstants.CENTER);
		classNumber.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblEleves = new JLabel("640 eleves");
		lblEleves.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleves.setForeground(Color.WHITE);
		lblEleves.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEleves.setBounds(437, 10, 116, 23);
		panel_2.add(lblEleves);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(140, 45));
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setBackground(panel_3.getParent().getBackground());
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		
		btnExtraire = new JButton("Extraire");
		btnExtraire.setVisible(false);
		btnExtraire.setPreferredSize(new Dimension(120, 45));
		btnExtraire.setForeground(Color.WHITE);
		btnExtraire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnExtraire.setFocusPainted(false);
		btnExtraire.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnExtraire.setBackground(new Color(80, 80, 80));
		panel_3.add(btnExtraire);
		
		((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(0).setBackground(new Color(255, 102, 102).darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(0).setBackground(panel_1.getBackground());
			}
		});
		
		
		addButton = new JButton(" Ajouter");
		addButton.setPreferredSize(new Dimension(120, 45));
		panel_3.add(addButton);
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addButton.setBackground(panel_1.getBackground());
		addButton.setFocusPainted(false);
		addButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		

		((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(1).setBackground(panel_1.getBackground().brighter());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				((Container) ((Container) getComponent(1)).getComponent(1)).getComponent(1).setBackground(panel_1.getBackground());
			}
		});

	}
	
	
	public static void deselectGroup(Component c, String ay_id) {
		
		int number = 0;
		for(int i = 0; i< ((Container) c).getComponentCount(); i++) {
			if(Class.selectedClasses.contains(((Container) c).getComponent(i))) {
				Class.selectedClasses.remove(((Container) c).getComponent(i));
				

				((JComponent) ((Container) c).getComponent(i)).setBorder(new MatteBorder(1, 2, 4, 2, (Color) new Color(0, 0, 0)));
				((JComponent) ((JComponent) ((Container) c).getComponent(i)).getComponent(0)).setBorder(null);
				((Container) ((JComponent) ((Container) c).getComponent(i)).getComponent(1)).setLayout(new FlowLayout(FlowLayout.LEFT, 7, 9));

				((Container) ((JComponent) ((Container) c).getComponent(i)).getComponent(3)).setVisible(false);
				
			}

			((Container) ((Container) ((JComponent) ((Container) c).getParent()).getComponent(1)).getComponent(1)).setPreferredSize(new Dimension(
				140, 45));
				((Container) ((Container) ((JComponent) ((Container) c).getParent()).getComponent(1)).getComponent(1)).getComponent(0).setVisible(false);
				((Container) ((Container) ((JComponent) ((Container) c).getParent()).getComponent(1)).getComponent(0)).getComponent(2).setVisible(true);
				

				number = number+StudentStats.getNumberOfStudents(((JLabel) ((Container) ((Container) ((Container) c).getComponent(i)).getComponent(0)).getComponent(0)).getName(), ay_id);
					
				Home.panelClasses.revalidate();

				Home.panelClasses.repaint();
		}


		((JLabel) ((Container) ((Container) c.getParent().getComponent(1)).getComponent(0)).getComponent(1))
		.setText(String.valueOf(((Container) c).getComponentCount())+" classes");
		((JLabel) ((Container) ((Container) c.getParent().getComponent(1)).getComponent(0)).getComponent(2)).setText(number+" eleves");

		if(Class.selectedClasses.toArray().length == 0) {

			MainInfo m = new MainInfo(ay_id);
			m.guide.setText("<html>- Cliquez sur une classe pour la selectionner.<br/><br/>\r\n- Double-cliquez sur une classe pour l'ouvrir.<br/><br/>\r\n- Cliquez sur la fleche correspondante a une classe <br/>pour rapidement voir les details de cette classe.<br/><br/>\r\n- Pour creer un groupe de classe, selectionnez deux<br/> ou plusieurs classe, et puis choisissez l'option <br/>\"regrouper\".<br/><br/>\r\n- Pour ajouter une classe dans un groupe, cliquez <br/>sur le bouton \"ajouter\" qui se situe sur le groupe <br/>voulu, puis choisissez parmi les classes donnees.</html>");
			Home.side.removeAll();
			Home.side.add(m);
			Home.frame.revalidate();
			Home.frame.repaint();
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
		
		if(Class.selectedClasses.toArray().length==1) {
			new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
			ClassInfo c1 = new ClassInfo(((JLabel) ((Container) (((Container) Class.selectedClasses.get(0)).getComponent(0))).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			Home.side.removeAll();
			Home.side.add(c1);
			Home.frame.revalidate();
			Home.frame.repaint();
			 return null;
	            }
	         }.execute();
		}
		if(Class.selectedClasses.toArray().length==0) {
			//Class.deselectAll();
			HomeMenu1.deselect();
		}
		
		Home.panelClasses.revalidate();
		Home.panelClasses.repaint();
	}
	public static void loadGroupComponents(String parent_id, String term_id, String ay_id) {
		
		for(int j = 0; j< Home.panelClasses.getComponentCount(); j++) {
			if(Home.panelClasses.getComponent(j) instanceof Group) {
				//((Container) ((Container) Home.panelClasses.getComponent(j)).getComponent(0)).removeAll();
			//System.out.println(((JLabel) ((Container) ((Container) ((Container) Home.panelClasses.getComponent(j)).getComponent(1)).getComponent(0)).getComponent(0)).getText());
			if((((Container) Home.panelClasses.getComponent(j)).getName().equals(parent_id))) {
				((Container) ((Container) Home.panelClasses.getComponent(j)).getComponent(0)).removeAll();
				
				try {
					Statement stmt= mysql.con.createStatement();

					ResultSet rs=stmt.executeQuery("select * from classroom_parents AS cp "
							+ "JOIN parents_of_classrooms AS poc"
							+ "JOIN classrooms as c "
							+ "JOIN classrooms_in_ay as cia "
							+ "WHERE poc.ay_id = '"+ay_id+"' AND poc.parent_id = cp.parent_id AND poc.parent_id = '"+parent_id+"' AND cp.classroom_id = c.classroom_id "
									+ "AND c.classroom_id = cia.classroom_id AND c.is_active = 1 AND cia.is_active = 1");
					while(rs.next())
					{
				
							
				Class c = new Class(term_id, ay_id);
				((JPanel)((Container) Home.panelClasses.getComponent(j)).getComponent(0)).add(c);
				c.className.setText("<html><div style='text-align: center;'>"+Class.getClassName(rs.getString("cp.classroom_id"))+"</div></html>");
				c.setName(rs.getString("cp.classroom_id"));
				Class.Actions(((Container) Home.panelClasses.getComponent(j)).getComponent(0), term_id, ay_id);
				
				List<Color> words = Home.getClassColors(rs.getString("cp.classroom_id"), ay_id);
				List<String> colors = Arrays.asList(words.get(0).toString().split(","));
				List<String> colors2 = Arrays.asList(words.get(1).toString().split(","));
				c.courseBox.setBackground(new Color(Integer.parseInt(colors.get(0)), Integer.parseInt(colors.get(1)), Integer.parseInt(colors.get(2))));
				
				c.className.setForeground(new Color(Integer.parseInt(colors2.get(0)), Integer.parseInt(colors2.get(1)), Integer.parseInt(colors2.get(2))));
				

				c.expand.setBackground(c.courseBox.getBackground().darker());
				

	    		Group.resizeGroup(Home.panelClasses.getComponent(j));
				}
						
					Home.panelClasses.revalidate();
					Home.panelClasses.repaint();
					
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			
			}
				
				((JLabel) ((Container) (((Container) ((Container) Home.panelClasses.getComponent(j)).getComponent(1)).getComponent(0))).getComponent(1))
				.setText(String.valueOf(((Container) Home.panelClasses.getComponent(j)).getComponentCount()+1)+" classes");
			
				//deselectGroup(((Container) Home.panelClasses.getComponent(j)).getComponent(0));
			}
		}
	}
	
	public static void resizeGroup(Component c) {
			if(c instanceof Group) {
				int totalWidth = 0;
				int componentWidth = c.getPreferredSize().width;
				for(int k = 0; k< ((Container) ((Container) (c)).getComponent(0)).getComponentCount(); k++) {
			totalWidth = totalWidth+((Container) ((Container) (c)).getComponent(0)).getComponent(k).getPreferredSize().width;
				}
				
			Double number = Math.ceil(totalWidth/(componentWidth-(5*((Container) ((Container) (c)).getComponent(0)).getComponentCount())));
		
				c.setPreferredSize(new Dimension(c.getPreferredSize().width, 
					((Container) c).getComponent(1).getPreferredSize().height+ ((Container) c).getComponent(0).getPreferredSize().height+5));
			}
			c.revalidate();
			c.repaint();
	
		}
	
	public static void collapse(Component c) {
		c.setPreferredSize(new Dimension(c.getPreferredSize().width, 47));

		c.revalidate();
		c.repaint();
	}
	

	public static void expand(Component c) {
		resizeGroup(c);

		c.revalidate();
		c.repaint();
	}
}
