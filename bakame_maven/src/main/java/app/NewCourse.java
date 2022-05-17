package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;

public class NewCourse extends JFrame {

	public static JPanel contentPane;
	public static JComboBox TP;
	public static JButton create;
	public static JTextField name;
	private JLabel lblNewLabel_1;
	public static JTextField courseName;
	private JPanel panel;
	public static JButton actualiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse();
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
	public NewCourse() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("New course");
	setBounds(100, 100, 440, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 70, 70));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Abbreviation:");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNewLabel.setBounds(35, 120, 175, 31);
	contentPane.add(lblNewLabel);
	
	JLabel lblTg = new JLabel("Total points:");
	lblTg.setForeground(new Color(255, 255, 255));
	lblTg.setHorizontalAlignment(SwingConstants.TRAILING);
	lblTg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTg.setBounds(35, 162, 175, 31);
	contentPane.add(lblTg);
	
	name = new JTextField();
	name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	name.setBounds(233, 120, 143, 28);
	contentPane.add(name);
	name.setColumns(10);
	
	TP = new JComboBox();
	TP.setModel(new DefaultComboBoxModel(new String[] {"20", "30", "40", "50", "60", "80", "100"}));
	TP.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	TP.setEditable(true);
	TP.setBounds(233, 162, 72, 29);
	contentPane.add(TP);
	
	create = new JButton("Ajouter");
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			App.count++;
			
			Cours c = new Cours();
			App.number.setText(String.valueOf(App.count));
			setVisible(false);

			 App.panel_5.add(c);
			 App.saveTests = false;

			 
				App.save();

				 App.ranking();
				 App.load();


		     App.panel_5.revalidate();
		     App.panel_5.repaint();

		     
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(152, 215, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Nom du cours:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(35, 78, 175, 31);
	contentPane.add(lblNomDuCours);
	
	courseName = new JTextField();
	courseName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	courseName.setColumns(10);
	courseName.setBounds(233, 78, 143, 28);
	contentPane.add(courseName);
	
	panel = new JPanel();
	panel.setBackground(new Color(0, 139, 139));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html>Ajoutez un nouveau cours en inserrant son nom, son abbreviation, et le total des points du cours</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 17));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Cours c = new Cours();
			int j = Integer.parseInt(App.number.getText());
			
			 App.panel_5.add(c, j);

			 App.delete();
			 App.panel_5.remove(j-1);

			 App.saveTests = true;
				App.save();

					setVisible(false);
					Test.deselect();


		     App.panel_5.revalidate();
		     App.panel_5.repaint();

		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
	contentPane.add(actualiser);

	setLocationRelativeTo(null);
	}
}
