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
	public static JButton settings;
	public static JButton settings2;
	private JPanel panel_4;
	private JLabel lblerTrimestre;
	public static JDateChooser dateChooser;
	public static JDateChooser dateChooser_1;

	/**
	 * Create the panel.
	 */
	public HomeMenu2(String ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 70));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		JPanel panel = new JPanel();
		//panel.setPreferredSize(new Dimension(50, 10));
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDureeDapplicationMontrer = new JLabel("Montrer les resultats corrrespondants a une periode determinee.");
		lblDureeDapplicationMontrer.setPreferredSize(new Dimension(400, 30));
		lblDureeDapplicationMontrer.setForeground(Color.WHITE);
		lblDureeDapplicationMontrer.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblDureeDapplicationMontrer, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(panel.getBackground());
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		
		JLabel label_1 = new JLabel("A partir du:");
		panel_5.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		dateChooser = new JDateChooser();
		panel_5.add(dateChooser);
		//dateChooser.setBounds(340, 31, 115, 28);
		dateChooser.setPreferredSize(new Dimension(110, 20));
		dateChooser.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("Jusqu'au:");
		panel_5.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		dateChooser_1 = new JDateChooser();
		panel_5.add(dateChooser_1);
		//dateChooser_1.setBounds(340, 70, 115, 28);
		dateChooser_1.setPreferredSize(new Dimension(110, 20));
		dateChooser_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		
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
			
			
			dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					
					((JComboBox) Home.panel_6.getComponent(3)).setSelectedIndex(2);
	        		String start = (dateChooser.getDate().getYear()+1900)+"-"+(dateChooser.getDate().getMonth()+1)+"-"+dateChooser.getDate().getDate();
	        		String end = (dateChooser_1.getDate().getYear()+1900)+"-"+(dateChooser_1.getDate().getMonth()+1)+"-"+dateChooser_1.getDate().getDate();
					
	        		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
	        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
	        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ClassStudents.courses.get(ClassStudents.selectedCourse), Home.panelStudents.getComponent(i).getName(), ay_id, start, end);
	        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
	        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
	        				}else{
	            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
	            				}}}
	        			}
			});

			dateChooser_1.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {

					((JComboBox) Home.panel_6.getComponent(3)).setSelectedIndex(2);

					String start = (dateChooser.getDate().getYear()+1900)+"-"+(dateChooser.getDate().getMonth()+1)+"-"+dateChooser.getDate().getDate();
	        		String end = (dateChooser_1.getDate().getYear()+1900)+"-"+(dateChooser_1.getDate().getMonth()+1)+"-"+dateChooser_1.getDate().getDate();
					for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
	        			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {
	        			ClassStudents.loadData(Home.panelStudents.getComponent(i), ClassStudents.courses.get(ClassStudents.selectedCourse), Home.panelStudents.getComponent(i).getName(), ay_id, start, end);
	        			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
	        				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
	        				}else{
	            				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
	            				}
	        			}}
				}
			});
			Home.deselect();
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(609, 0, 281, 35);
		
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
		Home.deselect();
		
	}
	
	
	public static void refreshStudents(String ay_id) {

		((JComboBox) Home.panel_6.getComponent(3)).setSelectedIndex(2);

		String start = (HomeMenu2.dateChooser.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser.getDate().getDate();
		String end = (HomeMenu2.dateChooser_1.getDate().getYear()+1900)+"-"+(HomeMenu2.dateChooser_1.getDate().getMonth()+1)+"-"+HomeMenu2.dateChooser_1.getDate().getDate();
		for(int i = 0; i< Home.panelStudents.getComponentCount(); i++) {
			if(Home.panelStudents.getComponent(i).getPreferredSize().height > 50) {

				if(Home.selectedPeriod ==1 && ((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).getSelectedIndex() > 2) 
				{
					((JComboBox) ((Container) ((Container) Home.panelStudents.getComponent(i)).getComponent(0)).getComponent(2)).setSelectedIndex(0);
				}
			ClassStudents.loadData(Home.panelStudents.getComponent(i), ClassStudents.courses.get(ClassStudents.selectedCourse), Home.panelStudents.getComponent(i).getName(), ay_id, start, end);
			if(((AbstractButton) ((Container) (((Container) Home.panelStudents.getComponent(i)).getComponent(2))).getComponent(1)).getText().equals("Decroissant")){
				ClassStudents.rankFromLastToFirst((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
				}else{
    				ClassStudents.rankFromFirstToLast((((JPanel)((JPanel) ((Container) Home.panelStudents.getComponent(i))).getComponent(1))));
    				}}
		
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
		ClassStudents.deselectAll(ay_id);
	
	}
}
