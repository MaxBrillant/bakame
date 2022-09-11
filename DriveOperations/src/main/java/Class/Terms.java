package Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import CloudOperations.mysql;
import accounts.Loading;
import accounts.Login;
import accounts.NewScholarYear;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;
import sideInformation.UserInfo;

public class Terms extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terms frame = new Terms();
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
	public Terms(String ay_id) {
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
	
	JLabel lblajoutezLesClasses = new JLabel("Trimestres: "+ScholarYears.getAcademicYearName(ay_id));
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
	scrollPane.setBounds(10, 96, 414, 454);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.CENTER, 20, 20));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ajoutez, modifiez ou supprimez les trimestres qui constituent l'annee scholaire.</div></html>");
	lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblajouterModifierouSupprimer.setBounds(10, 34, 404, 51);
	contentPane.add(lblajouterModifierouSupprimer);
	
	setLocationRelativeTo(null);;
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(211, 211, 211)));
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setPreferredSize(new Dimension(180, 150));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setBackground(panel_6.getParent().getBackground());
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("<html><div style='text-align: center;'>3eme Trimestre</div></html>");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setPreferredSize(new Dimension(165, 40));
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(211, 211, 211)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_6.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.CENTER);
		panel_7.setBackground(panel_7.getParent().getBackground());
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
		
		JLabel lblNewLabel_5 = new JLabel(" 12/04/2022 - 04/07/2022 ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(panel.getBackground());
		//lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Trimestre additionnel");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_7.add(lblNewLabel_2);
		
		JLabel lblFbu = new JLabel("Minerval: 250000 FBU");
		lblFbu.setForeground(Color.WHITE);
		lblFbu.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_7.add(lblFbu);
		
		
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.SOUTH);
		panel_8.setBackground(panel_8.getParent().getBackground());
		panel_8.setPreferredSize(new Dimension(89, 25));
		panel_8.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		btnNewButton.setPreferredSize(new Dimension(40, 25));
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton.setBorder(null);
		panel_8.add(btnNewButton);
		btnNewButton.setBackground(btnNewButton.getParent().getBackground());
		Home.addToolTip(btnNewButton, "Modifier");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(20, 148, 198));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(btnNewButton.getParent().getBackground());
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.setPreferredSize(new Dimension(40, 25));
		button_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
		button_1.setFont(new Font("Roboto", Font.BOLD, 14));
		button_1.setFocusPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(60, 60, 60));
		panel_8.add(button_1);
		Home.addToolTip(button_1, "Supprimer");
		
		JButton btnNewButton_1 = new JButton("Ajouter un trimestre");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(60, 60, 60).brighter());
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(60, 60, 60));
			}
		});
		btnNewButton_1.setIconTextGap(10);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Addicon.png"));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(60, 60, 60));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_1.setPreferredSize(new Dimension(180, 150));
		panel.add(btnNewButton_1);
		
		loadTerms(ay_id);
		
	}
	
	
	
	public static void loadTerms(String ay_id) {

		
		for(int i = 0; i< panel.getComponentCount()-1;i++) {
			panel.remove(i);
			panel.revalidate();
			panel.repaint();
			
		}

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs =stmt.executeQuery("select * from terms "
					+ "WHERE ay_id = '"+ay_id+"' AND is_active = 1");
			while(rs.next())
			{
							
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new LineBorder(new Color(211, 211, 211)));
				panel_4.setBackground(new Color(60, 60, 60));
				panel_4.setPreferredSize(new Dimension(180, 150));
				panel.add(panel_4, panel.getComponentCount()-1);
				panel_4.setLayout(new BorderLayout(0, 0));
				
				JPanel panel_6 = new JPanel();
				panel_6.setBorder(null);
				panel_4.add(panel_6, BorderLayout.CENTER);
				panel_6.setBackground(panel_6.getParent().getBackground());
				panel_6.setLayout(new BorderLayout(0, 0));
				
				JLabel lblNewLabel_4 = new JLabel("<html><div style='text-align: center;'>"+rs.getString("term_name")+"</div></html>");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setPreferredSize(new Dimension(165, 40));
				lblNewLabel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(211, 211, 211)));
				lblNewLabel_4.setForeground(new Color(255, 255, 255));
				lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
				panel_6.add(lblNewLabel_4, BorderLayout.NORTH);
				
				JPanel panel_7 = new JPanel();
				panel_6.add(panel_7, BorderLayout.CENTER);
				panel_7.setBackground(panel_7.getParent().getBackground());
				panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
				
				JLabel lblNewLabel_5 = new JLabel(" "+rs.getString("start_of_term")+" - "+rs.getString("end_of_term")+" ");
				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				lblNewLabel_5.setBackground(panel.getBackground());
				//lblNewLabel_5.setOpaque(true);
				lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
				panel_7.add(lblNewLabel_5);
				
				JLabel lblNewLabel_2 = new JLabel("Trimestre normal");
				if(!rs.getString("type").equals("regular")) {
					lblNewLabel_2.setText("Trimestre additionnel");
				}
				lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
				lblNewLabel_2.setForeground(Color.WHITE);
				panel_7.add(lblNewLabel_2);
				
				JLabel lblFbu = new JLabel("Minerval: "+rs.getString("fees_amount")+" FBU");
				lblFbu.setForeground(Color.WHITE);
				lblFbu.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel_7.add(lblFbu);
				
				
				
				JPanel panel_8 = new JPanel();
				panel_6.add(panel_8, BorderLayout.SOUTH);
				panel_8.setBackground(panel_8.getParent().getBackground());
				panel_8.setPreferredSize(new Dimension(89, 25));
				panel_8.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setFocusPainted(false);
				btnNewButton.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
				btnNewButton.setPreferredSize(new Dimension(40, 25));
				btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
				btnNewButton.setBorder(null);
				panel_8.add(btnNewButton);
				btnNewButton.setBackground(btnNewButton.getParent().getBackground());
				Home.addToolTip(btnNewButton, "Modifier");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton.setBackground(new Color(20, 148, 198));
					}
					public void mouseExited(MouseEvent e) {
						btnNewButton.setBackground(btnNewButton.getParent().getBackground());
					}
				});
				
				JButton button_1 = new JButton("");
				button_1.setPreferredSize(new Dimension(40, 25));
				button_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
				button_1.setFont(new Font("Roboto", Font.BOLD, 14));
				button_1.setFocusPainted(false);
				button_1.setBorder(null);
				button_1.setBackground(new Color(60, 60, 60));
				panel_8.add(button_1);
				Home.addToolTip(button_1, "Supprimer");
				
				button_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button_1.setBackground(new Color(255, 102, 102));
					}
					public void mouseExited(MouseEvent e) {
						button_1.setBackground(button_1.getParent().getBackground());
					}
				});
						}
			
			if(panel.getComponentCount() == 1) {
				JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Il n'y a actuellement aucun trimestre dans cet annee scholaire. Cliquez sur + pour en ajouter.</div></html>");
				lblNewLabel.setPreferredSize(new Dimension(370, 50));
				lblNewLabel.setBackground(new Color(60, 60, 60));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel.add(lblNewLabel, 0);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			}
				
		//panelYear.setPreferredSize(new Dimension((panelYear.getComponentCount()+1)*(250+20), getHeight()*13/100+300));
	
	
	}
	
	
	public static double getTermFees(String term_id) {
		double fees = 0;
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs =stmt.executeQuery("select * from terms "
					+ "WHERE term_id = '"+term_id+"'");
			while(rs.next())
			{
				fees = rs.getDouble("fees_amount");
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			}
		return fees;
	}

}
