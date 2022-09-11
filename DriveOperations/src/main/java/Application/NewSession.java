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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Class.NewCourse;
import accounts.Login;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NewSession extends JFrame {

	public static JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	private JComboBox comboMinutes;
	private JComboBox hour;
	private JComboBox minutes;
	public static JLabel sessionWord;
	public static JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSession frame = new NewSession("7","30","50");
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
	public NewSession(String hours, String mins, String timeAdded) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 510, 353);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);

	Login.setAsPopup(this);
	
	create = new JButton("Continuer");
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String end = endOfSession(hour.getSelectedItem()+":"+minutes.getSelectedItem(), Integer.parseInt(comboMinutes.getSelectedItem().toString()));
			String[]l = end.split(":");
			
			 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			 Date d = null;
			try {
				d = df.parse(hour.getSelectedItem()+":"+minutes.getSelectedItem());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			for(int i = 0; i< Schedule.hours.getComponentCount()-1; i++) {
				if(!((JLabel) Schedule.hours.getComponent(i)).getText().equals("Pause")) {
					((JLabel) Schedule.hours.getComponent(i)).setBorder(new LineBorder(new Color(255, 255, 255)));
				}
			}

			 Calendar cal = Calendar.getInstance();
			 cal.setTime(d);
			 cal.add(Calendar.MINUTE, 0);
			 String newTime = df.format(cal.getTime());
			
			
			JLabel lblNewLabel_2 = new JLabel(newTime+" - "+l[0]+":"+l[1]);
			lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 18));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setPreferredSize(new Dimension(150, 30));
			
			if(Schedule.hours.getComponentCount()>1) {
			Schedule.hours.add(lblNewLabel_2, Schedule.selectedSession+1);
			}
			else {
				Schedule.hours.add(lblNewLabel_2, 0);
			}
			Schedule.hours.revalidate();
			Schedule.hours.repaint();

			lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
			
			setVisible(false);

			for(int i = 0; i<Schedule.panel.getComponentCount(); i++) {
				((Container) Schedule.panel.getComponent(i)).getComponent(((Container) Schedule.panel.getComponent(i)).getComponentCount()-1).setEnabled(true);
				((Container) Schedule.panel.getComponent(i)).getComponent(0).revalidate();
				((Container) Schedule.panel.getComponent(i)).getComponent(0).repaint();
			}

			Schedule.pause();
			NewSession.refresh();
			if(Schedule.hours.getComponentCount()>1) {
				Schedule.selectedSession = Schedule.hours.getComponentCount()-2;
				}else{
					Schedule.selectedSession = 0;
					}

			Schedule.delete.setEnabled(false);
			
			for(int i = 0; i<Schedule.hours.getComponentCount()-1; i++) {
				int k = i;
					((JLabel) Schedule.hours.getComponent(i)).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							Schedule.hours.revalidate();;
							Schedule.hours.repaint();
							
							Schedule.selectedSession = k;
							for(int j = 0; j<Schedule.hours.getComponentCount()-1; j++) {
								if(!((JLabel) Schedule.hours.getComponent(j)).getText().equals("Pause")) {
							((JLabel) Schedule.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
								}else {
									((JLabel) Schedule.hours.getComponent(j)).setBorder(null);
								}
							}
							if(!((JLabel) Schedule.hours.getComponent(k)).getText().equals("Pause")) {
								Schedule.delete.setEnabled(true);
								
							}else {

								Schedule.delete.setEnabled(false);
							}

							((JLabel) Schedule.hours.getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198),4));
							
						if(e.getClickCount()==2) {
							if(!((JLabel) Schedule.hours.getComponent(k)).getText().equals("Pause")) {
							String t = ((JLabel) Schedule.hours.getComponent(k)).getText();
							List l = Arrays.asList(t.split(" - "));
							
							 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
							 Date d = null;
							 Date d1 = null;
							try {
								d = df.parse(l.get(0).toString());
								d1 = df.parse(l.get(1).toString());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
									long diffMs = d1.getTime() - d.getTime();
									long diffSec = diffMs / 1000;
									long min = diffSec / 60;
									
									List l1 = Arrays.asList(l.get(0).toString().split(":"));
							
							NewSession ns = new NewSession(l1.get(0).toString(), l1.get(1).toString(), String.valueOf(min));
							ns.setVisible(true);

							ns.create.setVisible(false);
						}}
					}
				});
			}}
		
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(88, 271, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Debut de la seance a:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(10, 97, 228, 31);
	contentPane.add(lblNomDuCours);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 494, 45);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez une nouvelle seance dans l' horaire de la  semaine</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 477, 30);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			for(int i = 0; i< Schedule.hours.getComponentCount()-1; i++) {
				if(!((JLabel) Schedule.hours.getComponent(i)).getText().equals("Pause")) {
					((JLabel) Schedule.hours.getComponent(i)).setBorder(new LineBorder(new Color(255, 255, 255)));
				}
			}
			
			String end = endOfSession(hour.getSelectedItem()+":"+minutes.getSelectedItem(), Integer.parseInt(comboMinutes.getSelectedItem().toString()));
			String[]l = end.split(":");
			
			 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			 Date d = null;
			try {
				d = df.parse(hour.getSelectedItem()+":"+minutes.getSelectedItem());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 

			 Calendar cal = Calendar.getInstance();
			 cal.setTime(d);
			 cal.add(Calendar.MINUTE, 0);
			 String newTime = df.format(cal.getTime());
			

			((JLabel) Schedule.hours.getComponent(Schedule.selectedSession)).setText(newTime+" - "+l[0]+":"+l[1]);
			Schedule.hours.revalidate();
			Schedule.hours.repaint();


			Schedule.delete.setEnabled(false);
			setVisible(false);
			refresh();
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
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
	button.setBounds(274, 271, 129, 31);
	contentPane.add(button);
	
	JLabel lblNouveauCours = new JLabel("Nouvelle Seance");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	lblNouveauCours.setBounds(0, 46, 494, 28);
	contentPane.add(lblNouveauCours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 74, 494, 12);
	contentPane.add(separator);
	
	hour = new JComboBox();
	hour.setFont(new Font("Roboto", Font.PLAIN, 20));
	hour.setEditable(true);
	hour.setBounds(248, 104, 64, 22);
	contentPane.add(hour);
	hour.setSelectedItem(hours);
	
	JLabel lblH = new JLabel("H");
	lblH.setHorizontalAlignment(SwingConstants.LEFT);
	lblH.setForeground(Color.WHITE);
	lblH.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblH.setBounds(316, 104, 44, 24);
	contentPane.add(lblH);
	
	minutes = new JComboBox();
	minutes.setFont(new Font("Roboto", Font.PLAIN, 20));
	minutes.setEditable(true);
	minutes.setBounds(339, 104, 64, 22);
	contentPane.add(minutes);

	minutes.setSelectedItem(mins);
	
	JLabel lblMin = new JLabel("Min");
	lblMin.setHorizontalAlignment(SwingConstants.LEFT);
	lblMin.setForeground(Color.WHITE);
	lblMin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblMin.setBounds(406, 104, 44, 24);
	contentPane.add(lblMin);
	
	JLabel lblDureeDeLa = new JLabel("Duree de la seance:");
	lblDureeDeLa.setHorizontalAlignment(SwingConstants.TRAILING);
	lblDureeDeLa.setForeground(Color.WHITE);
	lblDureeDeLa.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblDureeDeLa.setBounds(10, 149, 228, 31);
	contentPane.add(lblDureeDeLa);
	
	comboMinutes = new JComboBox();
	comboMinutes.setFont(new Font("Roboto", Font.PLAIN, 20));
	comboMinutes.setEditable(true);
	comboMinutes.setBounds(248, 156, 64, 22);
	contentPane.add(comboMinutes);

	comboMinutes.setSelectedItem(timeAdded);
	
	JLabel lblMinutes = new JLabel("minutes");
	lblMinutes.setHorizontalAlignment(SwingConstants.LEFT);
	lblMinutes.setForeground(Color.WHITE);
	lblMinutes.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblMinutes.setBounds(320, 156, 96, 24);
	contentPane.add(lblMinutes);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBounds(0, 196, 494, 12);
	contentPane.add(separator_1);
	
	sessionWord = new JLabel("La seance debutera a 9h45 et se terminera a 10h35");
	sessionWord.setHorizontalAlignment(SwingConstants.CENTER);
	sessionWord.setForeground(Color.WHITE);
	sessionWord.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	sessionWord.setBounds(10, 213, 474, 31);
	contentPane.add(sessionWord);

	setLocationRelativeTo(null);
	
	
	for(int i = 6; i< 15; i++) {
		hour.addItem(i);
	}
	for(int i = 0; i< 60; i++) {
		if(String.valueOf(i).endsWith("0") || String.valueOf(i).endsWith("5")) {
		minutes.addItem(i);
		}
	}
	comboMinutes.addItem("30");
	comboMinutes.addItem("40");
	comboMinutes.addItem("45");
	comboMinutes.addItem("50");
	comboMinutes.addItem("55");
	comboMinutes.addItem("60");
	

	lastSentence(hour.getSelectedItem().toString(), minutes.getSelectedItem().toString(), comboMinutes.getSelectedItem().toString());


	hour.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			lastSentence(hour.getSelectedItem().toString(), minutes.getSelectedItem().toString(), comboMinutes.getSelectedItem().toString());
		}
	});
	minutes.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			lastSentence(hour.getSelectedItem().toString(), minutes.getSelectedItem().toString(), comboMinutes.getSelectedItem().toString());
		}
	});
	comboMinutes.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			lastSentence(hour.getSelectedItem().toString(), minutes.getSelectedItem().toString(), comboMinutes.getSelectedItem().toString());
		}
	});
	

	}
	
	public static void refresh() {
		List<String> components = new ArrayList<String>();
		for(int i = 0; i< Schedule.hours.getComponentCount(); i++) {
			if(Schedule.hours.getComponent(i) instanceof JLabel) {
			components.add(((JLabel) Schedule.hours.getComponent(i)).getText());
		}}
		
		System.out.println(components.toArray().length);
		for(int i = 0; i< components.toArray().length; i++) {
			Schedule.hours.remove(i);
		JLabel lblNewLabel_2 = new JLabel(components.get(i));
		lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setPreferredSize(new Dimension(150, 30));
		
		Schedule.hours.add(lblNewLabel_2, i);
			
		
		Schedule.hours.revalidate();
		Schedule.hours.repaint();

		lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
		
		}
		Schedule.pause();
		Schedule.selectedSession = Schedule.hours.getComponentCount()-2;

		Schedule.delete.setEnabled(false);
		
		for(int i = 0; i<Schedule.hours.getComponentCount()-1; i++) {
			int k = i;
				((JLabel) Schedule.hours.getComponent(i)).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Schedule.hours.revalidate();;
						Schedule.hours.repaint();
						
						Schedule.selectedSession = k;
						for(int j = 0; j<Schedule.hours.getComponentCount()-1; j++) {
							if(!((JLabel) Schedule.hours.getComponent(j)).getText().equals("Pause")) {
						((JLabel) Schedule.hours.getComponent(j)).setBorder(new LineBorder(new Color(255, 255, 255)));
							}else {
								((JLabel) Schedule.hours.getComponent(j)).setBorder(null);
							}
						}
						if(!((JLabel) Schedule.hours.getComponent(k)).getText().equals("Pause")) {
							Schedule.delete.setEnabled(true);
							
						}else {

							Schedule.delete.setEnabled(false);
						}

						((JLabel) Schedule.hours.getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198),4));
						
					if(e.getClickCount()==2) {
						if(!((JLabel) Schedule.hours.getComponent(k)).getText().equals("Pause")) {
						String t = ((JLabel) Schedule.hours.getComponent(k)).getText();
						List l = Arrays.asList(t.split(" - "));
						
						 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
						 Date d = null;
						 Date d1 = null;
						try {
							d = df.parse(l.get(0).toString());
							d1 = df.parse(l.get(1).toString());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
								long diffMs = d1.getTime() - d.getTime();
								long diffSec = diffMs / 1000;
								long min = diffSec / 60;
								
								List l1 = Arrays.asList(l.get(0).toString().split(":"));
						
						NewSession ns = new NewSession(l1.get(0).toString(), l1.get(1).toString(), String.valueOf(min));
						ns.setVisible(true);

						ns.create.setVisible(false);
					}}
				}
			});
		}
	}
	
	
	public static String endOfSession(String time, int minutes) {
		
		 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		 Date d = null;
		try {
			d = df.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.MINUTE, minutes);
		 String newTime = df.format(cal.getTime());
		
		return newTime;
	}
	
	public static void lastSentence(String hours, String mins, String timeAdded) {
		String end = endOfSession(hours+":"+mins, Integer.parseInt(timeAdded));
		String[]l = end.split(":");
		
		sessionWord.setText("La seance debutera a "+hours+"h"+mins+" et se terminera a "+l[0]+"h"+l[1]);
	}
}