package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.Course;
import Class.NewCourse;
import Class.NewPane;
import Class.Student;
import Class.TestBox;
import Class.TestInfo;
import CloudOperations.aws;
import Publishing.NewPublication;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

public class TestMenu extends JPanel {
	public static JTextField textField;
	public static JButton add;
	public static JButton newTest;
	public static JButton publish;
	public static JButton stats;
	public static JButton edit;
	public static JButton delete;
	public static JPanel corrige;

	/**
	 * Create the panel.
	 */
	public TestMenu(String classroom_in_ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int) screensize.getWidth(), (int) screensize.getHeight()*20/100*70/100));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension((int) screensize.getWidth()*0/100, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(12, 10));
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(100, 100));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(new Color(60, 60, 60));
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		
		newTest = new JButton("");
		newTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestInfo nt = new TestInfo("null", classroom_in_ay_id);
				nt.setVisible(true);
			}
		});
		newTest.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-Exam.png"));
		newTest.setPreferredSize(new Dimension(100, 100));
		newTest.setVerticalTextPosition(SwingConstants.BOTTOM);
		newTest.setIconTextGap(0);
		newTest.setHorizontalTextPosition(SwingConstants.CENTER);
		newTest.setForeground(Color.WHITE);
		newTest.setFont(new Font("Roboto", Font.PLAIN, 18));
		newTest.setFocusPainted(false);
		newTest.setBorder(null);
		newTest.setBackground(new Color(60, 60, 60));
		panel.add(newTest);
		
		stats = new JButton("Statistiques");
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setPreferredSize(new Dimension(100, 100));
		stats.setIconTextGap(-4);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 18));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(new Color(60, 60, 60));
		//panel.add(stats);
		
		publish = new JButton("");
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			
			}
		});
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.setIconTextGap(-4);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(100, 100));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(new Color(60, 60, 60));
		panel.add(publish);
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TestInfo nt = new TestInfo(TestBox.selectedTests.get(0).getName(), classroom_in_ay_id);
				nt.setVisible(true);
			
			}
		});
		edit.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(100, 100));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(new Color(60, 60, 60));
		panel.add(edit);
		
		delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TestBox.deleteTest();
			}
		});
		delete.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(100, 100));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(new Color(60, 60, 60));
		panel.add(delete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(panel.getBackground());
		panel_1.setPreferredSize(new Dimension(450, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(188, 0, 262, 30);
		panel_1.add(textField);
		
		JButton btnInterrosNonFaites = new JButton("interros non faites");
		btnInterrosNonFaites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInterrosNonFaites.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInterrosNonFaites.setBackground(new Color(60, 60, 60));
			}
			
		});
		btnInterrosNonFaites.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInterrosNonFaites.setPreferredSize(new Dimension(100, 100));
		btnInterrosNonFaites.setIconTextGap(0);
		btnInterrosNonFaites.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInterrosNonFaites.setForeground(Color.WHITE);
		btnInterrosNonFaites.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnInterrosNonFaites.setFocusPainted(false);
		btnInterrosNonFaites.setBorder(null);
		btnInterrosNonFaites.setBackground(new Color(60, 60, 60));
		btnInterrosNonFaites.setBounds(306, 42, 134, 24);
		panel_1.add(btnInterrosNonFaites);
		
		corrige = new JPanel();
		corrige.setBackground(panel.getBackground());
		corrige.setBounds(0, 0, 178, 107);
		panel_1.add(corrige);
		corrige.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("corige a : 92%");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(19, 11, 139, 24);
		corrige.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 19));
		
		JLabel label = new JLabel("20/24");
		label.setBounds(34, 35, 109, 35);
		corrige.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 30));
		
		JButton btnContinuerCorrection = new JButton("Continuer correction");
		btnContinuerCorrection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnContinuerCorrection.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnContinuerCorrection.setBackground(new Color(60, 60, 60));
			}
			
		});
		btnContinuerCorrection.setBounds(8, 70, 161, 24);
		corrige.add(btnContinuerCorrection);
		btnContinuerCorrection.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnContinuerCorrection.setPreferredSize(new Dimension(100, 100));
		btnContinuerCorrection.setIconTextGap(0);
		btnContinuerCorrection.setHorizontalTextPosition(SwingConstants.CENTER);
		btnContinuerCorrection.setForeground(Color.WHITE);
		btnContinuerCorrection.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnContinuerCorrection.setFocusPainted(false);
		btnContinuerCorrection.setBorder(null);
		btnContinuerCorrection.setBackground(new Color(60, 60, 60));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 60, 60));
		panel_3.setBounds(190, 77, 195, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		
		JLabel label_1 = new JLabel("2eme Trimestre");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_3.add(label_1, BorderLayout.CENTER);
		label_1.setText(Home.termsText.get(Home.selectedTermIndex));
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}
				Home.terms.clear();
				if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
					for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
					Home.terms.add(Home.termsText.get(i));
					}
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				label_1.setText(Home.termsText.get(Home.selectedTermIndex));
				TestBox.loadAllTests(classroom_in_ay_id);
				}
		});
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(60, 60, 60));
		panel_3.add(button_1, BorderLayout.WEST);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
						Home.selectedTermIndex++;
					}else {
						Home.selectedTermIndex = 0;
					}
					Home.terms.clear();
					if(Home.selectedTermIndex == Home.termsText.toArray().length-1) {
						for(int i = 0; i< Home.termsText.toArray().length-1; i++) {
						Home.terms.add(Home.termsText.get(i));
						}
					}else {
						Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
						}
					label_1.setText(Home.termsText.get(Home.selectedTermIndex));
					TestBox.loadAllTests(classroom_in_ay_id);
			}
		});
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(60, 60, 60));
		panel_3.add(button_2, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(panel.getBackground());
		panel_2.setPreferredSize(new Dimension(130, 200));
		add(panel_2, BorderLayout.WEST);
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button.setPreferredSize(new Dimension(100, 100));
		button.setFont(new Font("Roboto", Font.PLAIN, 27));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(panel_2.getBackground());
		panel_2.add(button);
		
		
		Application.deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			String[] s = {"Ajouter","+Interro","Publier","Modifier","Supprimer"};
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(120, 120, 120));
					((AbstractButton) panel.getComponent(j)).setText(s[j]);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
					((AbstractButton) panel.getComponent(j)).setText(null);
				}
				
			});
		}
	}
	
	
	public static void deselect() {
		TestBox.isSelected = false;
		
		if(edit != null) {
		edit.setVisible(false);
		delete.setVisible(false);
		corrige.setVisible(false);
		}
		for(int k = 0;k<Application.panelTests.getComponentCount(); k++) {
			if(Application.panelTests.getComponent(k) instanceof TestBox) {
		for(int i =0;i<((Container) Application.panelTests.getComponent(k)).getComponentCount();i++) {
			for(int j = 0;j<Application.panelTests.getComponentCount();j++) {
				if(Application.panelTests.getComponent(j) instanceof TestBox) {
				//((Container) Application.panelTests.getComponent(j)).getComponent(i).setForeground(Color.white);
			Application.panelTests.getComponent(j).setBackground(new Color(60, 60, 60));
		}}}
		}
}
		Application.no.setText(String.valueOf(Application.panelTests.getComponentCount()));
		}
}
