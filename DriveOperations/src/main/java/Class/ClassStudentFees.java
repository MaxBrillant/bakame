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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
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

import org.joda.time.DateTime;

import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import CloudOperations.mysql;
import Publishing.getInternetDateAndTime;
import accounts.Login;
import app.WrapLayout;
import elements.CalendarBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ClassStudentFees extends JFrame {

	private JPanel contentPane;
	private static  JPanel panel;
	private static JLabel lblMinervalFbu;
	private List<String> terms = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassStudentFees frame = new ClassStudentFees();
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
	public ClassStudentFees(String classroom_in_ay_id) {
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
	Login.setAsPopup(this);
	
	JLabel lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Paiement du minerval: "+Home.getClassName(classroom_in_ay_id)+"</html>");
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
	scrollPane.setBounds(10, 128, 414, 422);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Poursuivez de pres l'etat de paiement des frais de scholarite/minerval pour chaque eleve, selon le trimestre</div></html>");
	lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblajouterModifierouSupprimer.setBounds(10, 34, 414, 51);
	contentPane.add(lblajouterModifierouSupprimer);
	
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
			
			JLabel lblNewLabel = new JLabel("UMUHOZA Chris Koen Michael");
			panel_2.add(lblNewLabel);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.white);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));

		panel_3.setBackground(panel_3.getParent().getBackground());
		
		JLabel lblNewLabel_1 = new JLabel("Paye a 100%");
		lblNewLabel_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);
		
		JLabel label = new JLabel("-");
		label.setPreferredSize(new Dimension(5, 25));
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_3.add(label);
		
		JLabel lblFbu = new JLabel("250.000 FBU");
		lblFbu.setForeground(new Color(211, 211, 211));
		lblFbu.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_3.add(lblFbu);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModifier.setPreferredSize(new Dimension(70, 25));
		btnModifier.setIconTextGap(0);
		btnModifier.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnModifier.setFocusPainted(false);
		btnModifier.setBorder(null);
		btnModifier.setBackground(new Color(20, 148, 198));
		panel_3.add(btnModifier);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!terms.isEmpty()) {
				loadStudents(classroom_in_ay_id, terms.get(comboBox.getSelectedIndex()));
			}}
		});
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1er Trimestre", "2eme Trimestre", "3eme Trimestre"}));
		comboBox.setBounds(264, 96, 160, 22);
		contentPane.add(comboBox);
		loadTerms(comboBox);
		
		lblMinervalFbu = new JLabel("Minerval: 300.000 FBU");
		lblMinervalFbu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinervalFbu.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblMinervalFbu.setMaximumSize(new Dimension(300, 14));
		lblMinervalFbu.setForeground(Color.WHITE);
		lblMinervalFbu.setFont(new Font("Roboto", Font.BOLD, 14));
		lblMinervalFbu.setBounds(10, 96, 188, 26);
		contentPane.add(lblMinervalFbu);
		
		loadStudents(classroom_in_ay_id, Home.termsText.get(Home.selectedTermIndex));
		
	}
	
	private void loadTerms(JComboBox c) {
		c.removeAllItems();
		

		Object[] lines = Home.loadActiveTerms(Login.selectedAcademicYearID);
		for(int i = 0; i<lines.length;i++) {
		c.addItem(Home.getTermName(lines[i].toString()));
		terms.add(lines[i].toString());
		}
		c.setSelectedItem(Home.getTermName(Home.termsText.get(Home.selectedTermIndex)));
		
	}

	public static void loadStudents(String classroom_in_ay_id, String term_id) {
		panel.removeAll();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
		
		double termFees = Terms.getTermFees(term_id);
		lblMinervalFbu.setText("Minerval: "+termFees);
		
		for(int i = 0; i<lines.length;i++) {
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setBackground(new Color(60, 60, 60));;
			
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
					panel_2.setBackground(panel_2.getParent().getBackground());
					
					JLabel lblNewLabel = new JLabel(Home.getStudentName(lines[i].toString()));
					panel_2.add(lblNewLabel);
					lblNewLabel.setMaximumSize(new Dimension(300, 14));
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.white);
				
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, BorderLayout.EAST);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));

				panel_3.setBackground(panel_3.getParent().getBackground());
				
				JLabel lblNewLabel_1 = new JLabel("N'a pas encore paye");
				lblNewLabel_1.setForeground(new Color(211, 211, 211));
				lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel_3.add(lblNewLabel_1);
				
				JLabel label = new JLabel("-");
				label.setPreferredSize(new Dimension(5, 25));
				label.setForeground(new Color(211, 211, 211));
				label.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel_3.add(label);
				
				JLabel lblFbu = new JLabel("0");
				lblFbu.setForeground(new Color(211, 211, 211));
				lblFbu.setFont(new Font("Roboto", Font.PLAIN, 14));
				panel_3.add(lblFbu);
				
				JButton btnModifier = new JButton("Modifier");
				btnModifier.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnModifier.setPreferredSize(new Dimension(70, 25));
				btnModifier.setIconTextGap(0);
				btnModifier.setHorizontalTextPosition(SwingConstants.CENTER);
				btnModifier.setForeground(Color.WHITE);
				btnModifier.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnModifier.setFocusPainted(false);
				btnModifier.setBorder(null);
				btnModifier.setBackground(panel_3.getBackground());
				btnModifier.setBorder(new LineBorder(new Color(255, 255, 255)));
				panel_3.add(btnModifier);
			
		

				panel_3.getComponent(1).setVisible(true);
				panel_3.getComponent(2).setVisible(true);
				panel_3.getComponent(3).setVisible(false);
				
				btnModifier.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnModifier.setBackground(new Color(20, 142, 192));
						panel_1.setBorder(new LineBorder(Color.white));
						panel_3.getComponent(1).setVisible(false);
						panel_3.getComponent(2).setVisible(false);
						panel_3.getComponent(3).setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent e) {

						btnModifier.setBackground(panel_3.getBackground());
						panel_1.setBorder(null);
						panel_3.getComponent(1).setVisible(true);
						panel_3.getComponent(2).setVisible(true);
						panel_3.getComponent(3).setVisible(false);
					}
				});
					
					panel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white));
							panel_3.getComponent(1).setVisible(false);
							panel_3.getComponent(2).setVisible(false);
							panel_3.getComponent(3).setVisible(true);
						}
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
							panel_3.getComponent(1).setVisible(true);
							panel_3.getComponent(2).setVisible(true);
							panel_3.getComponent(3).setVisible(false);
						}
					});
					panel_3.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white));
							panel_3.getComponent(1).setVisible(false);
							panel_3.getComponent(2).setVisible(false);
							panel_3.getComponent(3).setVisible(true);
						}
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
							panel_3.getComponent(1).setVisible(true);
							panel_3.getComponent(2).setVisible(true);
							panel_3.getComponent(3).setVisible(false);
						}
					});

		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from fees_payment "
					+ "WHERE sic_id = '"+lines[i].toString()+"' AND term_id = '"+term_id+"'");
			while(rs.next())
			{
				double payedFees = rs.getDouble("payed_amount");

				if(payedFees == 0) {
				lblNewLabel_1.setText("N'a pas encore paye");
				}else {
					lblNewLabel_1.setText("Paye a "+Integer.valueOf((int) (payedFees*100/termFees))+"%");
				}
				
				lblFbu.setText(String.valueOf(payedFees));
				
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}	
		}
	}
}
