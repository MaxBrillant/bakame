package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Class.TestBox;
import CloudOperations.mysql;
import app.WrapLayout;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DeletedEntities extends JFrame {

	private JPanel contentPane;
	private static JPanel panelClasses;
	private static JPanel panelStudents;
	private static JPanel panelCourses;
	private static JPanel panelProfs;
	private static List<String> classes = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletedEntities frame = new DeletedEntities();
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
	public DeletedEntities(String ay_id, int index) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 450, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);

	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 14));
	tabbedPane.setBounds(10, 109, 414, 441);
	contentPane.add(tabbedPane);
	
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab("Classes", null, scrollPane, null);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panelClasses = new JPanel();
	panelClasses.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panelClasses.getComponentCount(); i++) {
				if(!(panelClasses.getComponent(i) instanceof JLabel)) {
				panelClasses.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panelClasses.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panelClasses.getComponent(i)).getComponent(0).setBackground(panelClasses.getComponent(i).getBackground());
				((Container) panelClasses.getComponent(i)).getComponent(1).setBackground(panelClasses.getComponent(i).getBackground());
			}}
		}
	});
	panelClasses.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panelClasses);
	panelClasses.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JScrollPane scrollPane1 = new JScrollPane();
	scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	tabbedPane.addTab("Eleves", null, scrollPane1, null);
	
	panelStudents = new JPanel();
	panelStudents.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panelStudents.getComponentCount(); i++) {
				if(!(panelStudents.getComponent(i) instanceof JLabel)) {
				panelStudents.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panelStudents.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panelStudents.getComponent(i)).getComponent(0).setBackground(panelStudents.getComponent(i).getBackground());
				((Container) panelStudents.getComponent(i)).getComponent(1).setBackground(panelStudents.getComponent(i).getBackground());
			}}
		}
	});
	panelStudents.setBackground(new Color(40, 40, 40));
	scrollPane1.setViewportView(panelStudents);
	panelStudents.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	
	JScrollPane scrollPane2 = new JScrollPane();
	tabbedPane.addTab("Cours", null, scrollPane2, null);
	scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panelCourses = new JPanel();
	panelCourses.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panelCourses.getComponentCount(); i++) {
				if(!(panelCourses.getComponent(i) instanceof JLabel)) {
				panelCourses.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panelCourses.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panelCourses.getComponent(i)).getComponent(0).setBackground(panelCourses.getComponent(i).getBackground());
				((Container) panelCourses.getComponent(i)).getComponent(1).setBackground(panelCourses.getComponent(i).getBackground());
			}}
		}
	});
	panelCourses.setBackground(new Color(40, 40, 40));
	scrollPane2.setViewportView(panelCourses);
	panelCourses.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	
	
	JScrollPane scrollPane3 = new JScrollPane();
	tabbedPane.addTab("Professeurs", null, scrollPane3, null);
	scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panelProfs = new JPanel();
	panelProfs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panelProfs.getComponentCount(); i++) {
				if(!(panelProfs.getComponent(i) instanceof JLabel)) {
				panelProfs.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panelProfs.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panelProfs.getComponent(i)).getComponent(0).setBackground(panelProfs.getComponent(i).getBackground());
				((Container) panelProfs.getComponent(i)).getComponent(1).setBackground(panelProfs.getComponent(i).getBackground());
			}}
		}
	});
	panelProfs.setBackground(new Color(40, 40, 40));
	scrollPane3.setViewportView(panelProfs);
	panelProfs.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JLabel text = new JLabel("<html><div style='text-align: center;'>Ceci est la liste des eleves qui ont ete supprime. Vous pouvez les restorer dans leurs classes ou les supprimer definitivement.</div></html>");
	text.setHorizontalAlignment(SwingConstants.CENTER);
	text.setForeground(new Color(211, 211, 211));
	text.setFont(new Font("Roboto", Font.PLAIN, 14));
	text.setBounds(10, 34, 414, 50);
	contentPane.add(text);
		
	
	JButton btnAjouter = new JButton("Ajouter");
	btnAjouter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		NewPunishment np = new NewPunishment("", "");
		np.setVisible(true);
		np.create.setVisible(true);
		np.actualiser.setVisible(false);
		
		}
	});
	
	JLabel title = new JLabel("<html><div style='text-align: center;'>Eleves supprimes</html>");
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Roboto", Font.BOLD, 16));
	title.setBounds(10, 0, 414, 33);
	contentPane.add(title);
	
	JComboBox comboBox = new JComboBox();
	comboBox.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(index == 1) {
				if(comboBox.getSelectedIndex() == 0) {
					loadAllStudents(ay_id);
				}else {
					panelStudents.removeAll();
					loadStudents(classes.get(comboBox.getSelectedIndex()-1));
					
					if(panelStudents.getComponentCount() == 0) {

						JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun eleve de cette classe n'a encore ete supprime</div></html>");
						lblNewLabel.setPreferredSize(new Dimension(370, 50));
						lblNewLabel.setForeground(Color.WHITE);
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						panelStudents.add(lblNewLabel, 0);
					}
				}
			}

			if(index == 2) {
				if(comboBox.getSelectedIndex() == 0) {
					loadAllCourses(ay_id);
				}else {
					panelCourses.removeAll();
					loadCourses(classes.get(comboBox.getSelectedIndex()-1));
					
					if(panelCourses.getComponentCount() == 0) {

						JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun cours de cette classe n'a encore ete supprime</div></html>");
						lblNewLabel.setPreferredSize(new Dimension(370, 50));
						lblNewLabel.setForeground(Color.WHITE);
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						panelCourses.add(lblNewLabel, 0);
					}
				}
			}
		}
	});
	comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
	comboBox.setBounds(224, 80, 200, 22);
	contentPane.add(comboBox);
	setLocationRelativeTo(null);
	//loadPunishments(ay_id, students);
	
	
	
	
	
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(390, 25));
	panel_1.setBackground(new Color(60, 60, 60));;
	
			panelClasses.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
			panel_2.setBackground(panel_2.getParent().getBackground());
			
			JLabel lblNewLabel = new JLabel("UMUHOZA Chris Koen Michael - 3eme PF Economique");
			panel_2.add(lblNewLabel);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.white);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		panel_3.setBackground(panel_3.getParent().getBackground());
		
		
		
		JButton btnRestaurer = new JButton();
		panel_3.add(btnRestaurer);
		btnRestaurer.setPreferredSize(new Dimension(40, 25));
		btnRestaurer.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		btnRestaurer.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRestaurer.setIconTextGap(0);
		btnRestaurer.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRestaurer.setForeground(Color.WHITE);
		btnRestaurer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestaurer.setFocusPainted(false);
		btnRestaurer.setBorder(null);
		btnRestaurer.setBackground(btnRestaurer.getParent().getBackground());
		Home.addToolTip(btnRestaurer, "Restaurer");
		
		
		JButton button1 = new JButton("");
		panel_3.add(button1);
		button1.setPreferredSize(new Dimension(40, 25));
		button1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button1.setIconTextGap(0);
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button1.setFocusPainted(false);
		button1.setBorder(null);
		button1.setBackground(button1.getParent().getBackground());
		Home.addToolTip(button1, "Supprimer");
		
		
		
		
		if(index == 0) {
			title.setText("<html><div style='text-align: center;'>Classes supprimees</html>");
			text.setText("<html><div style='text-align: center;'>Ceci est la liste des classes qui ont ete supprimees. Vous pouvez les restaurer a nouveau ou les supprimer definitivement.</div></html>");
				tabbedPane.removeAll();
			tabbedPane.addTab("Classes", null, scrollPane, null);
			
			loadClasses(ay_id);
			comboBox.setVisible(false);
		}
		if(index == 1) {
			title.setText("<html><div style='text-align: center;'>Eleves supprimes</html>");
			text.setText("<html><div style='text-align: center;'>Ceci est la liste des eleves qui ont ete supprimes. Vous pouvez les restaurer dans leurs classes ou les supprimer definitivement.</div></html>");
			tabbedPane.removeAll();
			tabbedPane.addTab("Eleves", null, scrollPane1, null);
			comboBox.setVisible(true);
			loadComboBox(ay_id, comboBox);
			loadAllStudents(ay_id);
		}
		if(index == 2) {
			title.setText("<html><div style='text-align: center;'>Cours supprimes</html>");
			text.setText("<html><div style='text-align: center;'>Ceci est la liste des cours qui ont ete supprimes. Vous pouvez les restaurer dans leurs classes ou les supprimer definitivement.</div></html>");
			tabbedPane.removeAll();
			tabbedPane.addTab("Cours", null, scrollPane2, null);
			comboBox.setVisible(true);
			loadComboBox(ay_id, comboBox);
			loadAllCourses(ay_id);
		}
		if(index == 3) {
			title.setText("<html><div style='text-align: center;'>Professeurs supprimes</html>");
			text.setText("<html><div style='text-align: center;'>Ceci est la liste des professeurs qui ont ete supprimes. Vous pouvez les restaurer a nouveau ou les supprimer definitivement.</div></html>");
			tabbedPane.removeAll();
			tabbedPane.addTab("Professeurs", null, scrollPane3, null);
			comboBox.setVisible(false);
			loadProfs(ay_id);
		}
	}

	
	
	public static void loadComboBox(String ay_id, JComboBox c) {
		Object[] lines1 = Home.loadActiveClasses(ay_id);
		c.removeAllItems();
		
		c.addItem("All");
		for(int k = 0; k< lines1.length;k++) {
		classes.add(lines1[k].toString());
		c.addItem(Home.getClassName(lines1[k].toString()));
		}
		
	}
	
	public static void loadAllStudents(String ay_id) {
		Object[] lines1 = Home.loadActiveClasses(ay_id);
		panelStudents.removeAll();
		
		for(int k = 0; k< lines1.length;k++) {
		loadStudents(lines1[k].toString());
		}
		
		if(panelStudents.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun eleve n'a encore ete supprime de l'annee scholaire</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panelStudents.add(lblNewLabel, 0);
		}
	}
	
	
	public static void loadAllCourses(String ay_id) {
		Object[] lines1 = Home.loadActiveClasses(ay_id);
		panelCourses.removeAll();
		
		for(int k = 0; k< lines1.length;k++) {
		loadCourses(lines1[k].toString());
		}
		
		if(panelCourses.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun cours n'a encore ete supprime de l'annee scholaire</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panelCourses.add(lblNewLabel, 0);
		}
	}
	
	
public static void loadClasses(String ay_id) {
		
		panelClasses.removeAll();
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from classrooms_in_ay AS cia "
					+ "WHERE cia.is_active = 0 AND cia.ay_id = '"+ay_id+"'");
			while(rs.next())
			{
				
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(rs.getString("cia.cia_id"));
				panel_1.setPreferredSize(new Dimension(390, 25));
				panel_1.setBackground(new Color(60, 60, 60));;
				
				panelClasses.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
						panel_2.setBackground(panel_2.getParent().getBackground());
						
						JLabel lblNewLabel = new JLabel(Home.getClassName(rs.getString("cia.cia_id")));
						panel_2.add(lblNewLabel);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(Color.white);
						
					JPanel panel_3 = new JPanel();
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					panel_3.setVisible(false);

					panel_3.setBackground(panel_3.getParent().getBackground());
					
					
					
					JButton button = new JButton("");
					panel_3.add(button);
					button.setPreferredSize(new Dimension(40, 25));
					button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
					button.setVerticalTextPosition(SwingConstants.BOTTOM);
					button.setIconTextGap(0);
					button.setHorizontalTextPosition(SwingConstants.CENTER);
					button.setForeground(Color.WHITE);
					button.setFont(new Font("Tahoma", Font.PLAIN, 15));
					button.setFocusPainted(false);
					button.setBorder(null);
					button.setBackground(button.getParent().getBackground());
					Home.addToolTip(button, "Restaurer");
					
					
					JButton button1 = new JButton("");
					panel_3.add(button1);
					button1.setPreferredSize(new Dimension(40, 25));
					button1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
					button1.setVerticalTextPosition(SwingConstants.BOTTOM);
					button1.setIconTextGap(0);
					button1.setHorizontalTextPosition(SwingConstants.CENTER);
					button1.setForeground(Color.WHITE);
					button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					button1.setFocusPainted(false);
					button1.setBorder(null);
					button1.setBackground(button1.getParent().getBackground());
					Home.addToolTip(button1, "Supprimer definitivement");
					

					button1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							button1.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							button1.setBackground(button1.getParent().getBackground());
						}
					});
					
					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							button.setBackground(new Color(20, 148, 198));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							button.setBackground(button.getParent().getBackground());
						}
					});
					

					
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
							nc.setVisible(true);
							nc.create.setVisible(false);
							nc.actualiser.setVisible(true);
						}
					});
					
					
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//NewPunishment.deletePunishment(((JLabel) button1.getParent().getComponent(0)).getText());
							EducationFrame.loadPunishments(ay_id);
						}
					});
					
					
					panel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
							panel_1.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
							((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
							((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
						}
						
						panel_1.setBackground(new Color(20, 142, 192));
						panel_1.getComponent(0).setBackground(panel_1.getBackground());
						
					}
						@Override
						public void mouseEntered(MouseEvent e) {
							
							panel_1.getComponent(1).setVisible(true);
							
							for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
								if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
							((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(1).setVisible(false);
								
							panel_1.getParent().revalidate();

							panel_1.getParent().repaint();
								}
							}
							
							panel_1.setBorder(new LineBorder(Color.white, 1));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});

		}
		panelClasses.revalidate();
		panelClasses.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panelClasses.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucune classe n'a encore ete supprimee de l'annee scholaire</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panelClasses.add(lblNewLabel, 0);
		}
	}




public static void loadStudents(String classroom_in_ay_id) {
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM students_in_classrooms AS sic "
				+ "WHERE sic.cia_id = '"+classroom_in_ay_id+"' AND sic.is_active = 0");
		while(rs.next())
		{
			
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setName(rs.getString("sic.sic_id"));
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setBackground(new Color(60, 60, 60));;
			
					panelStudents.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
					panel_2.setBackground(panel_2.getParent().getBackground());
					
					JLabel lblNewLabel = new JLabel(Home.getStudentName(rs.getString("sic.sic_id"))+" - "+Home.getClassName(classroom_in_ay_id));
					panel_2.add(lblNewLabel);
					lblNewLabel.setMaximumSize(new Dimension(300, 14));
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.white);
					
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, BorderLayout.EAST);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				panel_3.setVisible(false);

				panel_3.setBackground(panel_3.getParent().getBackground());
				
				
				
				JButton button = new JButton("");
				panel_3.add(button);
				button.setPreferredSize(new Dimension(40, 25));
				button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
				button.setVerticalTextPosition(SwingConstants.BOTTOM);
				button.setIconTextGap(0);
				button.setHorizontalTextPosition(SwingConstants.CENTER);
				button.setForeground(Color.WHITE);
				button.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button.setFocusPainted(false);
				button.setBorder(null);
				button.setBackground(button.getParent().getBackground());
				Home.addToolTip(button, "Restaurer");
				
				
				JButton button1 = new JButton("");
				panel_3.add(button1);
				button1.setPreferredSize(new Dimension(40, 25));
				button1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
				button1.setVerticalTextPosition(SwingConstants.BOTTOM);
				button1.setIconTextGap(0);
				button1.setHorizontalTextPosition(SwingConstants.CENTER);
				button1.setForeground(Color.WHITE);
				button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button1.setFocusPainted(false);
				button1.setBorder(null);
				button1.setBackground(button1.getParent().getBackground());
				Home.addToolTip(button1, "Supprimer definitivement");
				

				button1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button1.setBackground(new Color(255, 102, 102));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button1.setBackground(button1.getParent().getBackground());
					}
				});
				
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBackground(new Color(20, 148, 198));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button.setBackground(button.getParent().getBackground());
					}
				});
				

				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
						nc.setVisible(true);
						nc.create.setVisible(false);
						nc.actualiser.setVisible(true);
					}
				});
				
				
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//NewPunishment.deletePunishment(((JLabel) button1.getParent().getComponent(0)).getText());
						EducationFrame.loadPunishments(ay_id);
					}
				});
				
				
				panel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
						panel_1.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
					}
					
					panel_1.setBackground(new Color(20, 142, 192));
					panel_1.getComponent(0).setBackground(panel_1.getBackground());
					
				}
					@Override
					public void mouseEntered(MouseEvent e) {
						
						panel_1.getComponent(1).setVisible(true);
						
						for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
							if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
						((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(1).setVisible(false);
							
						panel_1.getParent().revalidate();

						panel_1.getParent().repaint();
							}
						}
						
						panel_1.setBorder(new LineBorder(Color.white, 1));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel_1.setBorder(null);
					}
				});

	}
		panelStudents.revalidate();
		panelStudents.repaint();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}





public static void loadCourses(String classroom_in_ay_id) {
	
	//panelCourses.removeAll();
	
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from courses_in_classroom AS cic "
				+ "WHERE cic.cia_id = '"+classroom_in_ay_id+"' AND cic.is_active = 0");
		while(rs.next())
		{
			
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setName(rs.getString("cic.courses_in_classroom_id"));
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setBackground(new Color(60, 60, 60));;
			
			panelCourses.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
					panel_2.setBackground(panel_2.getParent().getBackground());
					
					JLabel lblNewLabel = new JLabel(TestBox.getShortName(rs.getString("cic.courses_in_classroom_id"))+" - "+ Home.getClassName(classroom_in_ay_id));
					panel_2.add(lblNewLabel);
					lblNewLabel.setMaximumSize(new Dimension(300, 14));
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.white);
					
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, BorderLayout.EAST);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				panel_3.setVisible(false);

				panel_3.setBackground(panel_3.getParent().getBackground());
				
				
				
				JButton button = new JButton("");
				panel_3.add(button);
				button.setPreferredSize(new Dimension(40, 25));
				button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
				button.setVerticalTextPosition(SwingConstants.BOTTOM);
				button.setIconTextGap(0);
				button.setHorizontalTextPosition(SwingConstants.CENTER);
				button.setForeground(Color.WHITE);
				button.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button.setFocusPainted(false);
				button.setBorder(null);
				button.setBackground(button.getParent().getBackground());
				Home.addToolTip(button, "Restaurer");
				
				
				JButton button1 = new JButton("");
				panel_3.add(button1);
				button1.setPreferredSize(new Dimension(40, 25));
				button1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
				button1.setVerticalTextPosition(SwingConstants.BOTTOM);
				button1.setIconTextGap(0);
				button1.setHorizontalTextPosition(SwingConstants.CENTER);
				button1.setForeground(Color.WHITE);
				button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button1.setFocusPainted(false);
				button1.setBorder(null);
				button1.setBackground(button1.getParent().getBackground());
				Home.addToolTip(button1, "Supprimer definitivement");
				

				button1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button1.setBackground(new Color(255, 102, 102));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button1.setBackground(button1.getParent().getBackground());
					}
				});
				
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBackground(new Color(20, 148, 198));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button.setBackground(button.getParent().getBackground());
					}
				});
				

				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
						nc.setVisible(true);
						nc.create.setVisible(false);
						nc.actualiser.setVisible(true);
					}
				});
				
				
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//NewPunishment.deletePunishment(((JLabel) button1.getParent().getComponent(0)).getText());
						EducationFrame.loadPunishments(ay_id);
					}
				});
				
				
				panel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
						panel_1.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
					}
					
					panel_1.setBackground(new Color(20, 142, 192));
					panel_1.getComponent(0).setBackground(panel_1.getBackground());
					
				}
					@Override
					public void mouseEntered(MouseEvent e) {
						
						panel_1.getComponent(1).setVisible(true);
						
						for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
							if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
						((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(1).setVisible(false);
							
						panel_1.getParent().revalidate();

						panel_1.getParent().repaint();
							}
						}
						
						panel_1.setBorder(new LineBorder(Color.white, 1));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel_1.setBorder(null);
					}
				});

	}
		panelCourses.revalidate();
		panelCourses.repaint();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}




public static void loadProfs(String ay_id) {
	
	panelProfs.removeAll();
	
	List<String> l = new ArrayList();
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms AS tic "
				+ "JOIN classrooms_in_ay AS cia "
				+ "JOIN courses_in_classroom AS cic "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND cic.cia_id = cia.cia_id AND cia.ay_id = '"+ay_id+"' AND tic.is_active = 0 AND cia.is_active = 1 AND cic.is_active = 1");
		while(rs.next())
		{
			if(!l.contains(rs.getString("tic.teacher_id"))) {
			l.add(rs.getString("tic.teacher_id"));
			
			JPanel panel_1 = new JPanel();
			panel_1.setName(rs.getString("tic.teacher_id"));
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setBackground(new Color(60, 60, 60));;
			
			panelProfs.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
					panel_2.setBackground(panel_2.getParent().getBackground());
					
					JLabel lblNewLabel = new JLabel(Teacher.getTeacherName(rs.getString("tic.teacher_id")));
					panel_2.add(lblNewLabel);
					lblNewLabel.setMaximumSize(new Dimension(300, 14));
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.white);
					
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, BorderLayout.EAST);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				panel_3.setVisible(false);

				panel_3.setBackground(panel_3.getParent().getBackground());
				
				
				
				JButton button = new JButton("");
				panel_3.add(button);
				button.setPreferredSize(new Dimension(40, 25));
				button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
				button.setVerticalTextPosition(SwingConstants.BOTTOM);
				button.setIconTextGap(0);
				button.setHorizontalTextPosition(SwingConstants.CENTER);
				button.setForeground(Color.WHITE);
				button.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button.setFocusPainted(false);
				button.setBorder(null);
				button.setBackground(button.getParent().getBackground());
				Home.addToolTip(button, "Modifier");
				
				
				JButton button1 = new JButton("");
				panel_3.add(button1);
				button1.setPreferredSize(new Dimension(40, 25));
				button1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
				button1.setVerticalTextPosition(SwingConstants.BOTTOM);
				button1.setIconTextGap(0);
				button1.setHorizontalTextPosition(SwingConstants.CENTER);
				button1.setForeground(Color.WHITE);
				button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button1.setFocusPainted(false);
				button1.setBorder(null);
				button1.setBackground(button1.getParent().getBackground());
				Home.addToolTip(button1, "Supprimer definitivement");
				

				button1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button1.setBackground(new Color(255, 102, 102));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button1.setBackground(button1.getParent().getBackground());
					}
				});
				
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBackground(new Color(20, 148, 198));
					}
					@Override
					public void mouseExited(MouseEvent e) {

						button.setBackground(button.getParent().getBackground());
					}
				});
				

				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
						nc.setVisible(true);
						nc.create.setVisible(false);
						nc.actualiser.setVisible(true);
					}
				});
				
				
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//NewPunishment.deletePunishment(((JLabel) button1.getParent().getComponent(0)).getText());
						EducationFrame.loadPunishments(ay_id);
					}
				});
				
				
				panel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
						panel_1.getParent().getComponent(i).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
						((Container) panel_1.getParent().getComponent(i)).getComponent(0).setBackground(new Color(60, 60, 60));
					}
					
					panel_1.setBackground(new Color(20, 142, 192));
					panel_1.getComponent(0).setBackground(panel_1.getBackground());
					
				}
					@Override
					public void mouseEntered(MouseEvent e) {
						
						panel_1.getComponent(1).setVisible(true);
						
						for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
							if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
						((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(1).setVisible(false);
							
						panel_1.getParent().revalidate();

						panel_1.getParent().repaint();
							}
						}
						
						panel_1.setBorder(new LineBorder(Color.white, 1));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel_1.setBorder(null);
					}
				});
			}
	}
		panelProfs.revalidate();
		panelProfs.repaint();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if(panelProfs.getComponentCount() == 0) {

		JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun professeur n'a encore ete supprime de l'annee scholaire</div></html>");
		lblNewLabel.setPreferredSize(new Dimension(370, 50));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelProfs.add(lblNewLabel, 0);
	}
}
}
