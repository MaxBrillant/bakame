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
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
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

public class EducationFrame extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton btnFermer;
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	public static JPanel panel;
	public static int selectedClass;
	private JLabel lblajouterModifierouSupprimer;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EducationFrame frame = new EducationFrame("8");
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
	public EducationFrame(String ay_id) {
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
	
	btnFermer = new JButton("Fermer");
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
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Education et punitions</html>");
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
	scrollPane.setBounds(10, 128, 414, 380);
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
	
	JLabel lblNewLabel_1 = new JLabel("Toutes les Punitions");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(10, 102, 293, 23);
	contentPane.add(lblNewLabel_1);
	
	lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ajoutez, modifiez ou supprimez les punitions appliquees par cet etablissement.</div></html>");
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
	btnAjouter.setBounds(323, 98, 101, 31);
	contentPane.add(btnAjouter);
	
	setLocationRelativeTo(null);
	
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(390, 25));
	panel_1.setBackground(new Color(60, 60, 60));;
	
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
			panel_2.setBackground(panel_2.getParent().getBackground());
			
			JLabel lblNewLabel = new JLabel("Derangement exagere en classe");
			panel_2.add(lblNewLabel);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.white);
			
			JLabel label = new JLabel("-");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel_2.add(label);
			
			JLabel lblCours = new JLabel("12 points");
			panel_2.add(lblCours);
			lblCours.setHorizontalAlignment(SwingConstants.CENTER);
			lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblCours.setForeground(Color.white);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

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
		Home.addToolTip(button1, "Supprimer");
		
		
		

		loadPunishments(ay_id);
		
		
	}
	
	
	

	public static void loadPunishments(String ay_id) {
		
		panel.removeAll();
		
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from punishments_in_ay AS pia "
					+ "JOIN punishments AS p "
					+ "WHERE p.is_active = 1 AND pia.is_active = 1 AND pia.ay_id = '"+ay_id+"' AND pia.punishment_id = p.punishment_id");
			while(rs.next())
			{
				
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setName(rs.getString("p.punishment_id"));
				panel_1.setPreferredSize(new Dimension(390, 25));
				panel_1.setBackground(new Color(60, 60, 60));;
				
						panel.add(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
						panel_2.setBackground(panel_2.getParent().getBackground());
						
						JLabel lblNewLabel = new JLabel(rs.getString("p.punishment_name"));
						panel_2.add(lblNewLabel);
						lblNewLabel.setMaximumSize(new Dimension(300, 14));
						lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel.setForeground(Color.white);
						
						JLabel label = new JLabel("-");
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setForeground(Color.WHITE);
						label.setFont(new Font("Roboto", Font.PLAIN, 14));
						panel_2.add(label);
						
						JLabel lblCours = new JLabel(rs.getString("pia.points")+" points");
						panel_2.add(lblCours);
						lblCours.setHorizontalAlignment(SwingConstants.CENTER);
						lblCours.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblCours.setForeground(Color.white);
					
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
		panel.revalidate();
		panel.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'ya actuellement aucune punition dans cet etablissement</div></html>");
			lblNewLabel.setPreferredSize(new Dimension(370, 50));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel.add(lblNewLabel, 0);
		}
	}
}