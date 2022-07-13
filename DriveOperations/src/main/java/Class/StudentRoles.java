package Class;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Application.EducationFrame;
import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import CloudOperations.mysql;
import app.WrapLayout;

public class StudentRoles extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRoles frame = new StudentRoles();
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
	public StudentRoles(String role_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 300));
	setTitle("");
	setBounds(100, 100, 450, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblajoutezLesClasses = new JLabel("Eleves choisis: "+ RolesAndPrizes.getRoleName(role_id));
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 414, 33);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 117, 414, 433);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panel.getComponentCount(); i++) {
				if(!(panel.getComponent(i) instanceof JLabel)) {
				panel.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panel.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panel.getComponent(i)).getComponent(0).setBackground(panel.getComponent(i).getBackground());
				((Container) panel.getComponent(i)).getComponent(1).setBackground(panel.getComponent(i).getBackground());
			}}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ceci est la liste des eleves qui ont ete choisis pour exercer ce role. Vous pouvez ajouter d'autres eleves ou les retirer de la liste.</div></html>");
	lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblajouterModifierouSupprimer.setBounds(10, 34, 404, 51);
	contentPane.add(lblajouterModifierouSupprimer);
	
	JButton btnAjouter = new JButton("Ajouter");
	btnAjouter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			NewPunishment np = new NewPunishment("", "");
			np.setVisible(true);
			np.create.setVisible(true);
			np.actualiser.setVisible(false);
		}
	});
	btnAjouter.setForeground(Color.WHITE);
	btnAjouter.setFont(new Font("Roboto", Font.BOLD, 14));
	btnAjouter.setFocusPainted(false);
	btnAjouter.setBorderPainted(false);
	btnAjouter.setBackground(new Color(0, 171, 89));
	btnAjouter.setBounds(323, 84, 101, 31);
	contentPane.add(btnAjouter);
	
	setLocationRelativeTo(null);;
		
		
	loadStudents(role_id);
	}
	
	
	
public static void loadStudents (String role_id) {
		
		panel.removeAll();
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from student_roles AS sr "
					+ "JOIN students AS s "
					+ "JOIN students_in_classrooms AS sic "
					+ "WHERE sr.role_id = '"+role_id+"' AND sr.sic_id = sic.sic_id AND s.student_id = sic.student_id AND s.is_active = 1 AND sic.is_active = 1");
			while(rs.next())
			{
				
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(rs.getString("sr.id"));
				panel_1.setPreferredSize(new Dimension(390, 25));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
						panel_2.setBackground(panel_2.getParent().getBackground());
						
						JLabel lblNewLabel = new JLabel(Home.getStudentName(rs.getString("sic.sic_id")));
						panel_2.add(lblNewLabel);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(Color.white);
					
					JPanel panel_3 = new JPanel();
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					panel_3.setVisible(false);

					panel_3.setBackground(panel_3.getParent().getBackground());
					
					
					
					JButton btnRetirer = new JButton("Retirer");
					btnRetirer.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnRetirer.setHorizontalTextPosition(SwingConstants.CENTER);
					btnRetirer.setForeground(Color.WHITE);
					btnRetirer.setFont(new Font("Roboto", Font.PLAIN, 14));
					btnRetirer.setFocusPainted(false);
					btnRetirer.setBorder(new LineBorder(new Color(255, 255, 255)));
					btnRetirer.setPreferredSize(new Dimension(80, 25));
					panel_3.add(btnRetirer);
					btnRetirer.setBackground(btnRetirer.getParent().getBackground());
					

					btnRetirer.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnRetirer.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							btnRetirer.setBackground(btnRetirer.getParent().getBackground());
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
		panel.revalidate();
		panel.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun eleve n'a ete choisi pour exercer ce role. Cliquez sur \"Ajouter\" pour en ajouter.</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel, 0);
		}
	}

}
