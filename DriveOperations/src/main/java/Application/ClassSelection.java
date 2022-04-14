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
import accounts.Login;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ClassSelection extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	public static JPanel panel;
	public static int selectedClass;
	public static boolean isSelectable =false;
	private JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassSelection frame = new ClassSelection(Login.selectedAcademicYearID);
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
	public ClassSelection(String ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	
	create = new JButton("Continuer");
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			addClass(((JLabel) ((Container) panel.getComponent(selectedClass)).getComponent(0)).getName(), ay_id);
			setVisible(false);
			isSelectable = false;
			
		}
	});
	create.setForeground(Color.WHITE);
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setFocusPainted(false);
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setBounds(57, 519, 120, 31);
	contentPane.add(create);
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
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
	button.setBounds(236, 519, 129, 31);
	contentPane.add(button);
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Selectionnez une classe</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 25));
	lblajoutezLesClasses.setBounds(10, 0, 404, 31);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 424, 12);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 42, 404, 466);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			isSelectable =false;
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(80, 80, 80));
			}
			create.setEnabled(false);
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));

	setLocationRelativeTo(null);
	
	loadClasses(ay_id);
	
	
	for(int i = 0; i<panel.getComponentCount(); i++) {
		int k = i;
	panel.getComponent(i).addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) { 
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(80, 80, 80));
			}
			isSelectable =true;
			create.setEnabled(true);
			selectedClass = k;
			panel.getComponent(k).setBackground(new Color(20, 148, 198));
		}@Override
		public void mouseEntered(MouseEvent e) {
			panel.getComponent(k).setBackground(new Color(40, 40, 40));
			if(isSelectable) {
			panel.getComponent(selectedClass).setBackground(new Color(20, 148, 198));
			}
		}@Override
		public void mouseExited(MouseEvent e) {
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(80, 80, 80));
			}
			panel.getComponent(k).setBackground(new Color(80, 80, 80));
			if(isSelectable) {
				panel.getComponent(selectedClass).setBackground(new Color(20, 148, 198));
				}
		}
	});
	
	}
	}
	
	public static void addClass(String classroom_id, String ay_id) {
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setPreferredSize(new Dimension(390, 55));
		ClassesAndCourses.panel.add(panel_1, ClassesAndCourses.panel.getComponentCount()-1);
		panel_1.setLayout(new BorderLayout(0, 0));
		

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 30));
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_4.setBackground(panel_4.getParent().getBackground());
		
		JLabel label = new JLabel(Home.getClassName(classroom_id));
		label.setBackground(Color.DARK_GRAY);
		label.setPreferredSize(new Dimension(46, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 20));
		panel_4.add(label, BorderLayout.CENTER);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
		button_1.setPreferredSize(new Dimension(30, 9));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(40, 40, 40));
		panel_4.add(button_1, BorderLayout.EAST);
		button_1.setBackground(button_1.getParent().getBackground());
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
		panel_2.setBackground(panel_2.getParent().getBackground());
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 25));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setPreferredSize(new Dimension(390, 25));
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(btnNewButton.getParent().getParent().getBackground());
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			//	SwingUtilities.getRoot(courseSelection.contentPane).setVisible(false);
				courseSelection cs = new courseSelection(((JLabel) ((Container) btnNewButton.getParent().getParent().getComponent(0)).getComponent(0)).getName(), ay_id);
				cs.setVisible(true);
				
				for(int m = 0; m<  ClassesAndCourses.panel.getComponentCount()-1; m++) {
					for(int i = 0; i< ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponentCount()-1; i++) {
						((JComponent) ((Container) ((Container) ClassesAndCourses.panel.getComponent(m)).getComponent(1)).getComponent(i)).setBorder(null);
					}}
			}
		});

		ClassesAndCourses.panel.revalidate();
		ClassesAndCourses.panel.repaint();
		

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(btnNewButton.getBackground().brighter());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(btnNewButton.getParent().getParent().getBackground());
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("done4");
				button_1.getParent().getParent().getParent().remove(button_1.getParent().getParent());
				ClassesAndCourses.panel.revalidate();
				ClassesAndCourses.panel.repaint();
				ClassesAndCourses.checkContinuation();
			}
		});
		ClassesAndCourses.checkContinuation();
		}
	
	
	public static void loadClasses(String ay_id) {
		Object[] lines = Home.loadActiveClasses(ay_id);
		
		
		for(int i = 0; i< lines.length; i++) {
			
			Object[] lines1 = Home.loadActiveCourses(ay_id, lines[i].toString());

			if(lines1.length>0) {
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(400, 20));
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(80, 80, 80));;
			
			JLabel lblNewLabel = new JLabel(Class.getClassName(lines[i].toString()));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblNewLabel.setBounds(10, 0, 265, 20);
			lblNewLabel.setForeground(Color.white);
			lblNewLabel.setName(lines[i].toString());
			
			JLabel lblCours = new JLabel(lines1.length+" cours");
			lblCours.setHorizontalAlignment(SwingConstants.CENTER);
			lblCours.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblCours.setForeground(Color.white);
			lblCours.setBounds(269, 0, 121, 20);
			
					panel.add(panel_1);
					panel_1.add(lblNewLabel);
					panel_1.add(lblCours);
					
			}
		}
		for(int i11 = 0; i11< ClassesAndCourses.panel.getComponentCount()-1;i11++) {
		for(int i1 = 0; i1< panel.getComponentCount(); i1++) {
			if(((JLabel) ((Container) ((Container) ClassesAndCourses.panel.getComponent(i11)).getComponent(0)).getComponent(0)).getText().equals(((JLabel) ((Container) panel.getComponent(i1)).getComponent(0)).getText())) {
				panel.remove(i1);
			}
			}}
	}
}