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
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class courseSelection extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static int selectedClass;
	public static boolean isSelectable =false;
	public static JButton create;
	private JLabel lblNombreDheuresPar;
	public static JComboBox comboBox;
	public static JTextField textField;
	private JLabel notice;
	private JLabel lblemePfEconomique;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseSelection frame = new courseSelection("1");
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
	public courseSelection(String classroom_in_ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 292);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	actualiser = new JButton("Actualiser");
	actualiser.setVisible(false);
	create = new JButton("Continuer");
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			

			for(int i = 0; i< ClassesAndCourses.panel.getComponentCount()-1;i++) {
				
				if(((JLabel) ((Container) ((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(0)).getComponent(0)).getText().equals(Home.getClassName(classroom_in_ay_id))) {
					
					
					JPanel panel_3 = new JPanel();
					panel_3.setBackground(new Color(40, 40, 40));
					panel_3.setPreferredSize(new Dimension(380, 25));
					panel_3.setLayout(null);
					
					JLabel lblNewLabel_1 = new JLabel(comboBox.getSelectedItem().toString());
					lblNewLabel_1.setForeground(Color.WHITE);
					lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(10, 0, 256, 25);
					panel_3.add(lblNewLabel_1);
					
					JLabel lblheures = new JLabel(textField.getText()+" s.");
					lblheures.setForeground(Color.WHITE);
					lblheures.setHorizontalAlignment(SwingConstants.CENTER);
					lblheures.setFont(new Font("Roboto", Font.PLAIN, 17));
					lblheures.setBounds(276, 0, 50, 25);
					panel_3.add(lblheures);
					
					JButton btnNewButton_1 = new JButton("");
					btnNewButton_1.setFocusPainted(false);
					btnNewButton_1.setBorderPainted(false);
					btnNewButton_1.setPreferredSize(new Dimension(30, 9));
					btnNewButton_1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
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

								courseSelection cs = new courseSelection(classroom_in_ay_id);
								SwingUtilities.getRoot(cs.contentPane).setVisible(false);
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

					int j = i;
					btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("done3");
								btnNewButton_1.getParent().getParent().remove(btnNewButton_1.getParent());

								ClassesAndCourses.panel.revalidate();
								ClassesAndCourses.panel.repaint();
								ClassesAndCourses.checkContinuation();
								refresh();
							}
						});
					
					
					((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).add(panel_3, ((Container) ((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).getComponentCount()-1);
					

					ClassesAndCourses.checkContinuation();
					refresh();
					((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).revalidate();
					((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).repaint();
					setVisible(false);
					
				
				}
			}
	
		}
	});
	create.setForeground(Color.WHITE);
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setFocusPainted(false);
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setBounds(58, 213, 120, 31);
	contentPane.add(create);
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.getBounds());
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
	button.setBounds(237, 213, 129, 31);
	contentPane.add(button);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 424, 12);
	contentPane.add(separator);
	
	JLabel lblselectionnezUnDes = new JLabel("<html><div style='text-align: center;'>Selectionnez un des cours que dispensera le professeur ainsi que le nombre d'heures dedies a ce cours par semaine</html>");
	lblselectionnezUnDes.setHorizontalAlignment(SwingConstants.CENTER);
	lblselectionnezUnDes.setForeground(Color.WHITE);
	lblselectionnezUnDes.setFont(new Font("Roboto", Font.BOLD, 14));
	lblselectionnezUnDes.setBounds(10, 35, 404, 46);
	contentPane.add(lblselectionnezUnDes);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBounds(0, 80, 424, 12);
	contentPane.add(separator_1);
	
	comboBox = new JComboBox();
	comboBox.setBackground(new Color(255, 255, 255));
	comboBox.setFont(new Font("Roboto", Font.PLAIN, 20));
	comboBox.setBounds(40, 103, 344, 25);
	contentPane.add(comboBox);
	
	lblNombreDheuresPar = new JLabel("Nombre de seances par semaine:");
	lblNombreDheuresPar.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreDheuresPar.setForeground(Color.WHITE);
	lblNombreDheuresPar.setFont(new Font("Roboto", Font.BOLD, 18));
	lblNombreDheuresPar.setBounds(10, 153, 273, 31);
	contentPane.add(lblNombreDheuresPar);
	
	textField = new JTextField();
	textField.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {

			if(((String) textField.getText()).isEmpty()) {
				notice.setVisible(true);
				create.setEnabled(false);
				notice.setText("Veuillez remplir la case pour le nombre d'heures");
			}
			else if(Integer.parseInt((String) textField.getText()) <=0) {
				notice.setVisible(true);
				create.setEnabled(false);
				notice.setText("Le nombre d'heures doit etre superieur a zero");
			}else if(Integer.parseInt((String) textField.getText()) >15) {
				notice.setVisible(true);
				create.setEnabled(false);
				notice.setText("Le nombre d'heures doit etre inferieur a 15");
			}else {
				create.setEnabled(true);
				notice.setVisible(false);
			}
		
		}
	});
	comboBox.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			textField.requestFocus();
		}
	});
	textField.setFont(new Font("Roboto", Font.PLAIN, 20));
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setBounds(293, 155, 50, 25);
	contentPane.add(textField);
	textField.setColumns(10);
	
	notice = new JLabel("Veuillez remplir la case pour le nombre d'heures");
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 153, 204));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(10, 191, 404, 18);
	contentPane.add(notice);
	
	lblemePfEconomique = new JLabel(Home.getClassName(classroom_in_ay_id));
	lblemePfEconomique.setHorizontalAlignment(SwingConstants.CENTER);
	lblemePfEconomique.setForeground(Color.WHITE);
	lblemePfEconomique.setFont(new Font("Roboto", Font.BOLD, 22));
	lblemePfEconomique.setBounds(10, 0, 404, 31);
	contentPane.add(lblemePfEconomique);
	setLocationRelativeTo(null);
	
	populateBox(classroom_in_ay_id);
	}
	
	
	public static void refresh() {

		for(int i = 0; i< ClassesAndCourses.panel.getComponentCount()-1; i++) {
		ClassesAndCourses.panel.getComponent(i).setPreferredSize(new Dimension((ClassesAndCourses.panel.getComponent(i).getWidth()),
				30+(((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).getComponentCount()-1)*25+25));
		
		
		((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).revalidate();
		((JPanel)((Container) ClassesAndCourses.panel.getComponent(i)).getComponent(1)).repaint();
	}}
	
	public static void populateBox(String classroom_in_ay_id) {
		Object[] lines = Home.loadActiveCourses(classroom_in_ay_id);
		
		
		for(int i = 0; i< lines.length; i++) {
			comboBox.addItem(TestBox.getFullName(lines[i].toString()));
			boolean exists = true;
			for(int j = 0; j< ClassesAndCourses.panel.getComponentCount()-1; j++) {
				if(((JLabel) ((Container) ((Container) ClassesAndCourses.panel.getComponent(j)).getComponent(0)).getComponent(0)).getText().equals(Home.getClassName(classroom_in_ay_id))) {
					for(int k = 0; k< ((Container) (((Container) ClassesAndCourses.panel.getComponent(j)).getComponent(1))).getComponentCount()-1; k++) {
					if(((JLabel) ((Container) ((Container) ((Container) ClassesAndCourses.panel.getComponent(j)).getComponent(1)).getComponent(k)).getComponent(0)).getText()
								.equals(TestBox.getFullName(lines[i].toString()))) {
							comboBox.removeItem(TestBox.getFullName(lines[i].toString()));
						}
					}
				}
			}
			if(exists) {
			}
		}
		}
}