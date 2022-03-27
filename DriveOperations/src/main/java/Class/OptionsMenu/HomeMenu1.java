package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
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

import Application.Class;
import Application.Home;
import Application.NewClass;
import Application.NewGroup;
import Application.ResizeImages;
import Class.Application;
import Class.NewPane;
import Class.NewStudent;
import Class.Student;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HomeMenu1 extends JPanel {
	public static JTextField textField;
	public static JButton add;
	public static JButton publish;
	public static JButton edit;
	public static JButton delete;
	public static JButton settings;
	public static JButton settings2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblerTrimestre;
	private JButton btnNewButton;
	public static JComboBox comboBox;
	public static JPanel panel;

	/**
	 * Create the panel.
	 */
	public HomeMenu1() {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int) screensize.getWidth(), (int) screensize.getHeight()*20/100*70/100));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension((int) screensize.getWidth()*0/100, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(100, 100));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(new Color(60, 60, 60));
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClass nc = new NewClass();
				nc.setVisible(true);
				nc.create.setVisible(true);
				nc.actualiser.setVisible(false);
			}
		});
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Class.selectedClasses.toArray().length==1) {
				NewClass nc = new NewClass();
				nc.className.setText(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
						.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				nc.setVisible(true);
				String s = NewClass.loadClassEducation(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
						.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				if(s.equals("none")) {
					nc.checkBox.setSelected(false);
					nc.textField.setText("");
					nc.textField.setEnabled(false);
				}else {
					nc.checkBox.setSelected(true);
					nc.textField.setText(s);
					nc.textField.setEnabled(true);
				}
				nc.create.setVisible(false);
				nc.actualiser.setVisible(true);
				}}
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
		
		publish = new JButton("");
		publish.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\regroup.png"));
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGroup ng = new NewGroup();
				ng.setVisible(true);
				ng.actualiser.setVisible(false);

				ng.create.setVisible(true);
			}
		});
		
		JButton button_6 = new JButton("");
		button_6.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		button_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			}
		});
		button_6.setPreferredSize(new Dimension(100, 100));
		button_6.setIconTextGap(0);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Roboto", Font.PLAIN, 18));
		button_6.setFocusPainted(false);
		button_6.setBorderPainted(false);
		button_6.setBackground(new Color(60, 60, 60));
		panel.add(button_6);
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(100, 100));
		publish.setFont(new Font("Roboto", Font.PLAIN, 13));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(new Color(60, 60, 60));
		panel.add(publish);
		
		JButton btnMonter = new JButton("");
		btnMonter.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_up.png"));
		btnMonter.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMonter.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMonter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
				goUp (((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				Class.loadClasses();
				System.out.println(i);
				((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(i);}
		});
		btnMonter.setPreferredSize(new Dimension(100, 100));
		btnMonter.setIconTextGap(0);
		btnMonter.setForeground(Color.WHITE);
		btnMonter.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnMonter.setFocusPainted(false);
		btnMonter.setBorderPainted(false);
		btnMonter.setBackground(new Color(60, 60, 60));
		panel.add(btnMonter);
		
		JButton btnMonter_1 = new JButton("");
		btnMonter_1.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_down.png"));
		btnMonter_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMonter_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMonter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
				goDown (((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				Class.loadClasses();
				((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(i);
			
			}
		});
		btnMonter_1.setPreferredSize(new Dimension(100, 100));
		btnMonter_1.setIconTextGap(0);
		btnMonter_1.setForeground(Color.WHITE);
		btnMonter_1.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnMonter_1.setFocusPainted(false);
		btnMonter_1.setBorderPainted(false);
		btnMonter_1.setBackground(new Color(60, 60, 60));
		panel.add(btnMonter_1);
		
		settings = new JButton("");
		settings.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\settingsicon.png"));
		settings.setVerticalTextPosition(SwingConstants.BOTTOM);
		settings.setPreferredSize(new Dimension(100, 100));
		settings.setIconTextGap(0);
		settings.setHorizontalTextPosition(SwingConstants.CENTER);
		settings.setForeground(Color.WHITE);
		settings.setFont(new Font("Roboto", Font.PLAIN, 19));
		settings.setFocusPainted(false);
		settings.setBorder(null);
		settings.setBackground(new Color(60, 60, 60));
		//panel.add(settings);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(panel.getBackground());
		panel_1.setPreferredSize(new Dimension(450, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(159, 0, 281, 35);
		//panel_1.add(textField);
		
		JButton btnElevesSupprimes = new JButton("Classes supprimees");
		btnElevesSupprimes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElevesSupprimes.setBackground(new Color(60, 60, 60));
			}
			
		});
		btnElevesSupprimes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnElevesSupprimes.setPreferredSize(new Dimension(100, 100));
		btnElevesSupprimes.setIconTextGap(0);
		btnElevesSupprimes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnElevesSupprimes.setForeground(Color.WHITE);
		btnElevesSupprimes.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnElevesSupprimes.setFocusPainted(false);
		btnElevesSupprimes.setBorder(null);
		btnElevesSupprimes.setBackground(new Color(60, 60, 60));
		btnElevesSupprimes.setBounds(304, 0, 136, 24);
		panel_1.add(btnElevesSupprimes);
		
		settings2 = new JButton("");
		settings2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settings2.setBackground(new Color(120, 120, 120));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settings2.setBackground(new Color(60, 60, 60));
			}
			
		});
		settings2.setIcon(ResizeImages.resize(50, 50, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\settingsicon.png"));
		settings2.setVerticalTextPosition(SwingConstants.BOTTOM);
		settings2.setPreferredSize(new Dimension(100, 100));
		settings2.setIconTextGap(-4);
		settings2.setHorizontalTextPosition(SwingConstants.CENTER);
		settings2.setForeground(Color.WHITE);
		settings2.setFont(new Font("Arial", Font.PLAIN, 19));
		settings2.setFocusPainted(false);
		settings2.setBorder(null);
		settings2.setBackground(new Color(60, 60, 60));
		settings2.setBounds(10, 0, 66, 66);
	//	panel_1.add(settings2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 60, 60));
		panel_3.setBounds(245, 35, 195, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Travaux");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod>0) {
					Home.selectedPeriod--;
				}else {
					Home.selectedPeriod = Home.periodText.toArray().length-1;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				Class.deselectAll();
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
				Class.loadData(Home.panelClasses.getComponent(i));
				}
				}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(panel_3.getBackground());
		btnNewButton.setBorder(null);
		btnNewButton.setPreferredSize(new Dimension(30, 30));
		btnNewButton.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panel_3.add(btnNewButton, BorderLayout.WEST);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedPeriod<Home.periodText.toArray().length-1) {
					Home.selectedPeriod++;
				}else {
					Home.selectedPeriod = 0;
				}
				lblNewLabel_1.setText(Home.periodText.get(Home.selectedPeriod));
				Class.deselectAll();
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					Class.loadData(Home.panelClasses.getComponent(i));
					}
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(panel_3.getBackground());
		button_1.setBorder(null);
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		panel_3.add(button_1, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 60, 60));
		panel_4.setBounds(245, 72, 195, 30);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblerTrimestre = new JLabel("2eme Trimestre");
		lblerTrimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblerTrimestre.setForeground(Color.WHITE);
		lblerTrimestre.setFont(new Font("Roboto", Font.BOLD, 17));
		panel_4.add(lblerTrimestre, BorderLayout.CENTER);
		lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex>0) {
					Home.selectedTermIndex--;
				}else {
					Home.selectedTermIndex = Home.termsText.toArray().length-1;
				}
				if(Home.selectedTermIndex == 3) {
					Home.terms.clear();
					Home.terms.add("1er Trimestre");
					Home.terms.add("2eme Trimestre");
					Home.terms.add("3eme Trimestre");
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				Class.deselectAll();
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					Class.loadData(Home.panelClasses.getComponent(i));
					}
				}
		});
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(panel_4.getBackground());
		button_2.setBorder(null);
		button_2.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		panel_4.add(button_2, BorderLayout.WEST);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.selectedTermIndex<Home.termsText.toArray().length-1) {
					Home.selectedTermIndex++;
				}else {
					Home.selectedTermIndex = 0;
				}
				if(Home.selectedTermIndex == 3) {
					Home.terms.clear();
					Home.terms.add("1er Trimestre");
					Home.terms.add("2eme Trimestre");
					Home.terms.add("3eme Trimestre");
				}else {
					Home.terms.clear();
					Home.terms.add(Home.termsText.get(Home.selectedTermIndex));
					}
				lblerTrimestre.setText(Home.termsText.get(Home.selectedTermIndex));
				Class.deselectAll();
				for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
					Class.loadData(Home.panelClasses.getComponent(i));
					}
		}
		});
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(panel_4.getBackground());
		button_3.setBorder(null);
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		panel_4.add(button_3, BorderLayout.EAST);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		comboBox.setFont(new Font("Roboto", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A-z", "merite", "Progres", "Echecs"}));
		comboBox.setBounds(344, 77, 96, 30);
		//panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(panel.getBackground());
		panel_2.setPreferredSize(new Dimension(130, 200));
		add(panel_2, BorderLayout.WEST);
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
		button.setPreferredSize(new Dimension(100, 100));
		button.setFont(new Font("Arial", Font.PLAIN, 27));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(panel_2.getBackground());
		panel_2.add(button);
		

		deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			String[] s = {"+Classe","Modifier","Supprimer","Publier","Regrouper", "Monter", "Descendre"};
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
	
	

	public static void goUp (String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		boolean done = false;
		for(int i = 0; i< comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(className)) {
				String group = l.get(4).toString();
				List l2 = Arrays.asList(comp.get(i-1).toString().split("//"));
				if(l2.get(4).equals(group)) {
					comp.add(i-1, comp.get(i));
					comp.remove(i+1);
					break;
				}else {
					if(!group.equals("none")) {
				for(int j = i-1; j>= 0; j--) {
					List l1 = Arrays.asList(comp.get(j).toString().split("//"));
					if(l1.get(4).toString().equals(group)) {
						comp.add(j, comp.get(i));
						comp.remove(i+1);
						break;
					}
				}}else {
					String group1 = l2.get(4).toString();
					for(int j = i-2; j>= 0; j--) {
						List l1 = Arrays.asList(comp.get(j).toString().split("//"));
						if(!l1.get(4).toString().equals(group1)) {
							if(!l1.get(4).toString().equals(group)){
							comp.add(j+1, comp.get(i));
							comp.remove(i+1);
							done = true;
							break;
						}else{
							comp.add(j+1, comp.get(i));
							comp.remove(i+1);
							done = true;
							break;
						}}
					}
					if(!done) {
						comp.add(0, comp.get(i));
						comp.remove(i+1);
						break;
					}
				}
				}
			}
		}
		
		if(file.exists()) {
			file.delete();
		}

	try {
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	aws.upload(file.getPath());
	}
	
	
	
	
	public static void goDown (String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		boolean done = false;
		
		for(int i = 0; i< comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(className)) {
				String group = l.get(4).toString();
				List l2 = Arrays.asList(comp.get(i+1).toString().split("//"));
				if(l2.get(4).equals(group)) {
					comp.add(i+2, comp.get(i));
					comp.remove(i);
					break;
				}else {
					if(!group.equals("none")) {
				for(int j = i+2; j< comp.toArray().length; j++) {
					List l1 = Arrays.asList(comp.get(j).toString().split("//"));
					if(l1.get(4).toString().equals(group)) {
						comp.add(j, comp.get(i));
						comp.remove(i);
						break;
					}
				}}else {

					if(!done) {
					String group1 = l2.get(4).toString();
					for(int j = i+2 ; j< comp.toArray().length; j++) {
						List l1 = Arrays.asList(comp.get(j).toString().split("//"));
						if(!l1.get(4).toString().equals(group1)) {
							String s = comp.get(i);
							comp.add(j, s);

							System.out.println("+++++++++++++++++++++++++++++");
							for(int k = 0; k< comp.toArray().length; k++) {
								System.out.println(comp.get(k));
							}
							comp.remove(i);
							

							System.out.println("+++++++++++++++++++++++++++++");
							for(int k = 0; k< comp.toArray().length; k++) {
								System.out.println(comp.get(k));
							}
							done = true;
							
							if(file.exists()) {
								file.delete();
							}

						try {
							file.createNewFile();
							PrintWriter pw = new PrintWriter(file);

							for(int j1 = 0;j1<comp.toArray().length;j1++) {
							pw.println((String)comp.get(j1));
							};
							
							pw.close();
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
						aws.upload(file.getPath());
						
						break;
						}}
					
					
				}
					if(!done) {
						String s = comp.get(i);
						comp.add(s);

						System.out.println("+++++++++++++++++++++++++++++");
						for(int k = 0; k< comp.toArray().length; k++) {
							System.out.println(comp.get(k));
						}
						comp.remove(i);
						

						System.out.println("+++++++++++++++++++++++++++++");
						for(int k = 0; k< comp.toArray().length; k++) {
							System.out.println(comp.get(k));
						}
						done = true;
						
						if(file.exists()) {
							file.delete();
						}

					try {
						file.createNewFile();
						PrintWriter pw = new PrintWriter(file);

						for(int j1 = 0;j1<comp.toArray().length;j1++) {
						pw.println((String)comp.get(j1));
						};
						
						pw.close();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
					aws.upload(file.getPath());
					
					break;
					
					}
				}}
			}
		}
		
		if(!done) {
			if(file.exists()) {
				file.delete();
			}

		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);

			for(int j1 = 0;j1<comp.toArray().length;j1++) {
			pw.println((String)comp.get(j1));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file.getPath());
		
		}
}
	
	public static void deselect() {
		HomeMenu1.panel.getComponent(1).setVisible(false);
		HomeMenu1.panel.getComponent(2).setVisible(false);
		HomeMenu1.panel.getComponent(4).setVisible(false);
		HomeMenu1.panel.getComponent(5).setVisible(false);
		HomeMenu1.panel.getComponent(6).setVisible(false);
		
	}
}
