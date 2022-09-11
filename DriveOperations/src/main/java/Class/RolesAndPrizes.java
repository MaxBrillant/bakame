package Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import CloudOperations.mysql;
import app.WrapLayout;

public class RolesAndPrizes extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RolesAndPrizes frame = new RolesAndPrizes("");
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
	public RolesAndPrizes(String ay_id) {
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
	
	JButton btnFermer = new JButton("Fermer");
	btnFermer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnFermer.setForeground(Color.WHITE);
	btnFermer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnFermer.setFocusPainted(false);
	btnFermer.setBorderPainted(false);
	btnFermer.setBackground(new Color(171, 0, 0));
	btnFermer.setBounds(285, 519, 129, 31);
	contentPane.add(btnFermer);
	
	JLabel lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Responsabilites et titres des eleves</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 404, 33);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 119, 414, 389);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panel.getComponentCount(); i++) {
				if(!(panel.getComponent(i) instanceof JLabel)) {
				panel.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panel.getComponent(i)).getComponent(2).setVisible(false);
				((Container) panel.getComponent(i)).getComponent(0).setBackground(panel.getComponent(i).getBackground());
				((Container) panel.getComponent(i)).getComponent(2).setBackground(panel.getComponent(i).getBackground());
			}}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 5));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ajoutez, modifiez ou supprimez les differents roles, titres et prix que vous voulez assigner a certains eleves dans l'etablissement.</div></html>");
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
	btnAjouter.setBounds(323, 86, 101, 31);
	contentPane.add(btnAjouter);
	
	setLocationRelativeTo(null);
	
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(390, 50));
	panel_1.setBackground(new Color(60, 60, 60));;
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setPreferredSize(new Dimension(390, 50));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
			lblNewLabel_1.setForeground(Color.WHITE);
			panel.add(lblNewLabel_1);
	
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblMaxBrillant = new JLabel("  Delegue de classe");
			lblMaxBrillant.setMaximumSize(new Dimension(300, 14));
			lblMaxBrillant.setPreferredSize(new Dimension(100, 30));
			lblMaxBrillant.setForeground(Color.WHITE);
			lblMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
			panel_1.add(lblMaxBrillant, BorderLayout.CENTER);
			
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: leading;'>"+"ksjlksklsj lkj sjl sksj jlksjkls lskssj k jskl jskljs"+"</div></html>");
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setPreferredSize(new Dimension(317, 20));
			lblNewLabel.setMinimumSize(new Dimension(317, 20));
			panel_1.add(lblNewLabel, BorderLayout.SOUTH);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel.setForeground(new Color(211, 211, 211));
			
			
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		panel_3.setBackground(panel_3.getParent().getBackground());

		panel_3.setVisible(false);
		
		
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					lblNewLabel.setText("<html><u>"+lblNewLabel.getText().replaceAll("<html><div style='text-align: leading;'>", "").replaceAll("</div></html>", "")+"</u></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
					lblNewLabel.setText("<html><div style='text-align: leading;'>"+lblNewLabel.getText().replaceAll("<u>", "").replaceAll("</u>", "")+"</div></html>");
			}
		});


		
		JButton button11 = new JButton(" 23 eleves ");
		panel_3.add(button11);
		//button11.setPreferredSize(new Dimension(40, 30));
		button11.setVerticalTextPosition(SwingConstants.BOTTOM);
		button11.setIconTextGap(0);
		button11.setHorizontalTextPosition(SwingConstants.RIGHT);
		button11.setForeground(Color.WHITE);
		button11.setFont(new Font("Roboto", Font.PLAIN, 14));
		button11.setFocusPainted(false);
		button11.setBorder(null);
		button11.setBackground(button11.getParent().getBackground());
		Home.addToolTip(button11, "Eleves choisis");
		
		
		JButton button = new JButton("");
		panel_3.add(button);
		button.setPreferredSize(new Dimension(40, 30));
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
		button1.setPreferredSize(new Dimension(40, 30));
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
		
		JLabel label = new JLabel("New label");
		label.setBounds(-16, 137, 46, 14);
		contentPane.add(label);
		
	
	
	
		load(ay_id);
	}
	
	public static void load(String ay_id) {

		panel.removeAll();
		loadRoles(ay_id);
		loadPrizes(ay_id);
	}
	
	
	public static void loadRoles(String ay_id) {
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Roles/Responsabilites");
		lblNewLabel_1.setPreferredSize(new Dimension(390, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		
		
		int i = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from roles "
					+ "WHERE ay_id = '"+ay_id+"'");
			while(rs.next())
			{
				i++;
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(rs.getString("role_id"));
				panel_1.setPreferredSize(new Dimension(390, 50));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JLabel lblMaxBrillant = new JLabel("  "+rs.getString("role_name"));
						lblMaxBrillant.setMaximumSize(new Dimension(300, 14));
						lblMaxBrillant.setPreferredSize(new Dimension(100, 30));
						lblMaxBrillant.setForeground(Color.WHITE);
						lblMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
						panel_1.add(lblMaxBrillant, BorderLayout.CENTER);
						
						JLabel lblNewLabel = new JLabel(" "+rs.getString("description"));
						lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
						lblNewLabel.setPreferredSize(new Dimension(317, 20));
						lblNewLabel.setMinimumSize(new Dimension(317, 20));
						panel_1.add(lblNewLabel, BorderLayout.SOUTH);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(new Color(211, 211, 211));
						
						
					
					JPanel panel_3 = new JPanel();
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

					panel_3.setBackground(panel_3.getParent().getBackground());

					panel_3.setVisible(false);
					
					
					
					lblNewLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
								lblNewLabel.setText("<html><u>"+lblNewLabel.getText()+"</u></html>");
						}
						@Override
						public void mouseExited(MouseEvent e) {
								lblNewLabel.setText(lblNewLabel.getText().replaceAll("<html><u>", "").replaceAll("</u></html>", ""));
						}
					});


					int count = StudentRoles.loadNumberOfStudents(rs.getString("role_id"));
					String s = "eleves";
					if(count == 1) {
						s = "eleve";
					}
					JButton button11 = new JButton(" "+count+" "+s+" ");
					panel_3.add(button11);
					//button11.setPreferredSize(new Dimension(40, 30));
					button11.setVerticalTextPosition(SwingConstants.BOTTOM);
					button11.setIconTextGap(0);
					button11.setHorizontalTextPosition(SwingConstants.RIGHT);
					button11.setForeground(Color.WHITE);
					button11.setFont(new Font("Roboto", Font.PLAIN, 14));
					button11.setFocusPainted(false);
					button11.setBorder(null);
					button11.setBackground(button11.getParent().getBackground());
					Home.addToolTip(button11, "Eleves choisis");
					
					
					JButton button = new JButton("");
					panel_3.add(button);
					button.setPreferredSize(new Dimension(40, 30));
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
					button1.setPreferredSize(new Dimension(40, 30));
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
					
					button11.addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent e) {
					button11.setText("<html><u>"+button11.getText()+"</u></html>");
					}
					@Override
					public void mouseExited(MouseEvent e) {
					button11.setText(button11.getText().replaceAll("<html><u>", "").replaceAll("</u></html>", ""));
					}
					});
					

					
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					button11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StudentRoles s = new StudentRoles(panel_1.getName());
							s.setVisible(true);
						}
					});
					
					
					panel_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							
							panel_1.getComponent(2).setVisible(true);
							
							for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
								if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent()) && !((panel_1.getParent()).getComponent(i) instanceof JLabel)) {
							((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(2).setVisible(false);
								
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
		if(i == 0) {
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'ya actuellement aucun role ou responsabilite dans cet etablissement</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel, 0);
		}
	}
	
	
	
	public static void loadPrizes(String ay_id) {
		
		JLabel lblNewLabel_1 = new JLabel("Prix/Titres");
		lblNewLabel_1.setPreferredSize(new Dimension(390, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		int i = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from prizes "
					+ "WHERE ay_id = '"+ay_id+"'");
			while(rs.next())
			{
				i++;
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(rs.getString("prize_id"));
				panel_1.setPreferredSize(new Dimension(390, 50));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JLabel lblMaxBrillant = new JLabel("  "+rs.getString("prize_name"));
						lblMaxBrillant.setMaximumSize(new Dimension(300, 14));
						lblMaxBrillant.setPreferredSize(new Dimension(100, 30));
						lblMaxBrillant.setForeground(Color.WHITE);
						lblMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
						panel_1.add(lblMaxBrillant, BorderLayout.CENTER);
						
						JLabel lblNewLabel = new JLabel(" "+rs.getString("description"));
						lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
						lblNewLabel.setPreferredSize(new Dimension(317, 20));
						lblNewLabel.setMinimumSize(new Dimension(317, 20));
						panel_1.add(lblNewLabel, BorderLayout.SOUTH);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(new Color(211, 211, 211));
						
						
					
					JPanel panel_3 = new JPanel();
					panel_1.add(panel_3, BorderLayout.EAST);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

					panel_3.setBackground(panel_3.getParent().getBackground());

					panel_3.setVisible(false);
					
					
					
					lblNewLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
								lblNewLabel.setText("<html><u>"+lblNewLabel.getText()+"</u></html>");
						}
						@Override
						public void mouseExited(MouseEvent e) {
								lblNewLabel.setText(lblNewLabel.getText().replaceAll("<u>", "").replaceAll("</u>", ""));
						}
					});


					
					int count = StudentPrizes.loadNumberOfStudents(rs.getString("prize_id"));
					String s = "eleves";
					if(count == 1) {
						s = "eleve";
					}
					JButton button11 = new JButton(" "+count+" "+s+" ");
					panel_3.add(button11);
					//button11.setPreferredSize(new Dimension(40, 30));
					button11.setVerticalTextPosition(SwingConstants.BOTTOM);
					button11.setIconTextGap(0);
					button11.setHorizontalTextPosition(SwingConstants.RIGHT);
					button11.setForeground(Color.WHITE);
					button11.setFont(new Font("Roboto", Font.PLAIN, 14));
					button11.setFocusPainted(false);
					button11.setBorder(null);
					button11.setBackground(button11.getParent().getBackground());
					Home.addToolTip(button11, "Eleves choisis");
					
					
					JButton button = new JButton("");
					panel_3.add(button);
					button.setPreferredSize(new Dimension(40, 30));
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
					button1.setPreferredSize(new Dimension(40, 30));
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
					
					button11.addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent e) {
					button11.setText("<html><u>"+button11.getText()+"</u></html>");
					}
					@Override
					public void mouseExited(MouseEvent e) {
					button11.setText(button11.getText().replaceAll("<html><u>", "").replaceAll("</u></html>", ""));
					}
					});
					

					
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					button11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StudentPrizes s = new StudentPrizes(panel_1.getName());
							s.setVisible(true);
						}
					});
					
					
					panel_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							
							panel_1.getComponent(2).setVisible(true);
							
							for(int i = 0; i< (panel_1.getParent()).getComponentCount(); i++) {
								if(!((panel_1.getParent()).getComponent(i) instanceof JLabel)) {
								if(!(panel_1.getParent()).getComponent(i).equals(panel_1.getComponent(0).getParent())) {
							((Container) ((Container) panel_1.getParent().getComponent(i))).getComponent(2).setVisible(false);
								
							panel_1.getParent().revalidate();

							panel_1.getParent().repaint();
								}
							}}
							
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
		if(i == 0) {
			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'ya actuellement aucun prix ou titre dans cet etablissement</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel);
		}
	}

	public static String getRoleName(String role_id) {
		String name = null;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from roles "
					+ "WHERE role_id = '"+role_id+"'");
			while(rs.next())
			{
				name = rs.getString("role_name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}
	
	
	public static String getPrizeName(String prize_id) {
		String name = null;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from prizes "
					+ "WHERE prize_id = '"+prize_id+"'");
			while(rs.next())
			{
				name = rs.getString("prize_name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}
}
