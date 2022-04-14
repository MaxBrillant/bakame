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

import org.joda.time.DateTime;

import Application.ClassStudents;
import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import Class.Application;
import Class.NewPane;
import Class.NewStudent;
import Class.Student;
import Publishing.NewPublication;
import Publishing.getInternetDateAndTime;
import sideInformation.ClassInfo;
import sideInformation.MainInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class HomeMenu2 extends JPanel {
	public static JTextField textField;
	public static JButton publish;
	public static JButton settings;
	public static JButton settings2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblerTrimestre;
	private JButton btnNewButton;
	public static JDateChooser dateChooser;
	public static JDateChooser dateChooser_1;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public HomeMenu2() {

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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		
		publish = new JButton("Publier");
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(70, 70, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			}
		});
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(100, 100));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(new Color(60, 60, 60));
		panel.add(publish);
		
		
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
		panel_1.setPreferredSize(new Dimension(730, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(609, 0, 281, 35);
		//panel_1.add(textField);
		
		JButton btnElevesSupprimes = new JButton("Eleves supprimees");
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
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					 Date d2 = null;
						try {
							List time = Arrays.asList(getInternetDateAndTime.onlineTime.split("::"));
							d2 = df.parse(time.get(0).toString());
							d1 = new DateTime(d2).minusDays(7).toDate();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dateChooser.setDate(d1);

						dateChooser_1.setDate(d2);
				}
				if(comboBox.getSelectedIndex()==1) {
					 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 Date d1 = null;
					 Date d2 = null;
						try {
							List time = Arrays.asList(getInternetDateAndTime.onlineTime.split("::"));
							d2 = df.parse(time.get(0).toString());
							d1 = new DateTime(d2).minusDays(30).toDate();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dateChooser.setDate(d1);

						dateChooser_1.setDate(d2);
				}

        		String start = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900);
        		String end = dateChooser_1.getDate().getDate()+"/"+(dateChooser_1.getDate().getMonth()+1)+"/"+(dateChooser_1.getDate().getYear()+1900);
        		ClassStudents.loadStudents(start, end);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Les 7 derniers jours", "Les 30 derniers jours", "Autre periode"}));
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 17));
		comboBox.setBounds(10, 61, 184, 30);
		panel_1.add(comboBox);
		btnElevesSupprimes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnElevesSupprimes.setPreferredSize(new Dimension(100, 100));
		btnElevesSupprimes.setIconTextGap(0);
		btnElevesSupprimes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnElevesSupprimes.setForeground(Color.WHITE);
		btnElevesSupprimes.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnElevesSupprimes.setFocusPainted(false);
		btnElevesSupprimes.setBorder(null);
		btnElevesSupprimes.setBackground(new Color(60, 60, 60));
		btnElevesSupprimes.setBounds(577, 0, 136, 24);
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
		panel_3.setBounds(518, 72, 195, 30);
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


				comboBox.setSelectedIndex(2);

				String start = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900);
        		String end = dateChooser_1.getDate().getDate()+"/"+(dateChooser_1.getDate().getMonth()+1)+"/"+(dateChooser_1.getDate().getYear()+1900);
        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
        				
        				if(Home.selectedPeriod ==1 && ((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).getSelectedIndex() > 2) 
        				{
        					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setSelectedIndex(0);
        				}
        				
        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ((JLabel) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(0)).getText(), start, end);
        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
        				}else{
            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
            				}
        			}
        			

        			int index = ((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).getSelectedIndex();
        			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs", "Interrogations", "Progression"}));
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).revalidate();
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).repaint();
					}if(Home.selectedPeriod ==1) {
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs"}));
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).revalidate();
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).repaint();
						}
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setSelectedIndex(index);
					}
    			ClassStudents.deselectAll();
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


				comboBox.setSelectedIndex(2);

				String start = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900);
        		String end = dateChooser_1.getDate().getDate()+"/"+(dateChooser_1.getDate().getMonth()+1)+"/"+(dateChooser_1.getDate().getYear()+1900);
        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {

        				if(Home.selectedPeriod ==1 && ((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).getSelectedIndex() > 2) 
        				{
        					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setSelectedIndex(0);
        				}
        				
        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ((JLabel) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(0)).getText(), start, end);
        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
        				}else{
            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
            				}
        			}

        			int index = ((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).getSelectedIndex();
        			if(Home.selectedPeriod == 0 || Home.selectedPeriod == 2) {
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs", "Interrogations", "Progression"}));
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).revalidate();
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).repaint();
					}if(Home.selectedPeriod ==1) {
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setModel(new DefaultComboBoxModel(new String[] {"Pourcentage", "Points", "Echecs"}));
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).revalidate();
						((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).repaint();
						}
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setSelectedIndex(index);
					}
    			ClassStudents.deselectAll();
			
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
		panel_4.setBounds(518, 72, 195, 30);
		//panel_1.add(panel_4);
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
		}
		});
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBackground(panel_4.getBackground());
		button_3.setBorder(null);
		button_3.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		panel_4.add(button_3, BorderLayout.EAST);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(340, 31, 152, 28);
		panel_1.add(dateChooser);
		dateChooser.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(340, 70, 152, 28);
		panel_1.add(dateChooser_1);
		dateChooser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		

		
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d1 = null;
		 Date d2 = null;
			try {
				List time = Arrays.asList(getInternetDateAndTime.onlineTime.split("::"));
				d2 = df.parse(time.get(0).toString());
				d1 = new DateTime(d2).minusDays(7).toDate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dateChooser.setDate(d1);

			dateChooser_1.setDate(d2);
		
		JLabel lblNewLabel = new JLabel("A partir du:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(204, 33, 104, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lblJusquau = new JLabel("Jusqu'au:");
		lblJusquau.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJusquau.setForeground(Color.WHITE);
		lblJusquau.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblJusquau.setBounds(204, 71, 104, 22);
		panel_1.add(lblJusquau);
		
		JLabel lblDureeDapplication = new JLabel("Duree d'application");
		lblDureeDapplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblDureeDapplication.setForeground(Color.WHITE);
		lblDureeDapplication.setFont(new Font("Roboto", Font.BOLD, 23));
		lblDureeDapplication.setBounds(149, 2, 266, 22);
		panel_1.add(lblDureeDapplication);
		
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
		

		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				comboBox.setSelectedIndex(2);
        		String start = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900);
        		String end = dateChooser_1.getDate().getDate()+"/"+(dateChooser_1.getDate().getMonth()+1)+"/"+(dateChooser_1.getDate().getYear()+1900);
				
        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ((JLabel) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(0)).getName(), start, end);
        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
        				}else{
            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
            				}}}
        			}
		});

		dateChooser_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

				comboBox.setSelectedIndex(2);

				String start = dateChooser.getDate().getDate()+"/"+(dateChooser.getDate().getMonth()+1)+"/"+(dateChooser.getDate().getYear()+1900);
        		String end = dateChooser_1.getDate().getDate()+"/"+(dateChooser_1.getDate().getMonth()+1)+"/"+(dateChooser_1.getDate().getYear()+1900);
        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ((JLabel) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(0)).getText(), start, end);
        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
        				}else{
            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
            				}
        			}}
			}
		});
		Home.deselect();

		comboBox.setSelectedIndex(0);
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			String[] s = {"Publier"};
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
	
	
	public static void deselect() {}
}
