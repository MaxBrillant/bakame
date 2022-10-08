package elements;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.joda.time.DateTime;

import Application.ResizeImages;
import Publishing.getInternetDateAndTime;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomCalendar extends JPanel {
	private static JPanel panelDate;
	private JPanel panel_11;
	private int selectedDay, selectedMonth, selectedYear;
	private static JLabel date;
	private int year;
	private int month;

	public int getSelectedDay() {
		return selectedDay;
	}
	public void setSelectedDay(int selectedDay) {
		this.selectedDay = selectedDay;
	}
	public int getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(int selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	public int getSelectedYear() {
		return selectedYear;
	}
	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}
	/**
	 * Create the panel.
	 */
	public static void main(String [] args) {
		JFrame j = new JFrame();
		j.setBounds(100, 100, 300, 300);
		j.setVisible(true);
		CustomCalendar c = new CustomCalendar();
		j.getContentPane().setLayout(new BorderLayout(0, 0));
		j.getContentPane().add(c);
	}
	
	public CustomCalendar(CalendarBox calendarBox) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		panel.setPreferredSize(new Dimension(10, 35));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
			
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 60, 60));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(ResizeImages.resize(15, 15, "Icons\\l_arrow.png"));
		btnNewButton.setBackground(panel.getBackground());
		btnNewButton.setFocusPainted(false);
		btnNewButton.setPreferredSize(new Dimension(40, 23));
		panel_2.add(btnNewButton, BorderLayout.WEST);
		
		JButton button = new JButton("");
		button.setBorder(null);
		button.setIcon(ResizeImages.resize(15, 15, "Icons\\r_arrow.png"));
		button.setBackground(panel.getBackground());
		button.setPreferredSize(new Dimension(40, 23));
		button.setFocusPainted(false);
		panel_2.add(button, BorderLayout.EAST);
		
		date = new JLabel();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFocusTraversalKeysEnabled(false);
		date.setBorder(null);
		date.setForeground(new Color(255, 255, 255));
		date.setBackground(panel.getBackground());
		date.setPreferredSize(new Dimension(120, 22));
		date.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_2.add(date, BorderLayout.CENTER);
		
		
		
		panel_11 = new JPanel();
		add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 60, 60));
		panel_1.setPreferredSize(new Dimension(10, 25));
		panel_11.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JLabel label_1 = new JLabel("L");
		label_1.setForeground(new Color(255, 150, 102));
		label_1.setPreferredSize(new Dimension(40, 25));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(label_1);
		
		JLabel lblM = new JLabel("M");
		lblM.setPreferredSize(new Dimension(40, 25));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setForeground(new Color(255, 150, 102));
		lblM.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblM);
		
		JLabel lblM_1 = new JLabel("M");
		lblM_1.setPreferredSize(new Dimension(40, 25));
		lblM_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblM_1.setForeground(new Color(255, 150, 102));
		lblM_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblM_1);
		
		JLabel lblJ = new JLabel("J");
		lblJ.setPreferredSize(new Dimension(40, 25));
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ.setForeground(new Color(255, 150, 102));
		lblJ.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblJ);
		
		JLabel lblV = new JLabel("V");
		lblV.setPreferredSize(new Dimension(40, 25));
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		lblV.setForeground(new Color(255, 150, 102));
		lblV.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblV);
		
		JLabel lblS = new JLabel("S");
		lblS.setPreferredSize(new Dimension(40, 25));
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setForeground(new Color(255, 150, 102));
		lblS.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblS);
		
		JLabel lblD = new JLabel("D");
		lblD.setPreferredSize(new Dimension(40, 25));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setForeground(new Color(255, 150, 102));
		lblD.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_1.add(lblD);
		
		
		
		panelDate = new JPanel();
		panelDate.setBackground(new Color(40, 40, 40));
		panel_11.add(panelDate, BorderLayout.CENTER);
		panelDate.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(panelDate.getBackground());
		panel_3.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JButton label = new JButton("L");
		label.setBorder(null);
		label.setFocusPainted(false);
		label.setOpaque(true);
		label.setPreferredSize(new Dimension(40, 23));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(panelDate.getBackground());
		panel_4.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(panelDate.getBackground());
		panel_5.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(panelDate.getBackground());
		panel_7.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(panelDate.getBackground());
		panel_8.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(panelDate.getBackground());
		panel_9.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(panelDate.getBackground());
		panel_10.setPreferredSize(new Dimension(40, 140));
		panelDate.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(panelDate.getBackground());
		panelDate.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month = month+1;
				if(month >11) {
					month = 0;
					year = year+1;
				}
				getDays(year, month, 
						(CustomCalendar) getComponent(0).getParent(), calendarBox);
				}
		});
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month = month-1;
				if(month <0) {
					month = 11;
					year = year-1;
				}
				getDays(year, month, 
						(CustomCalendar) getComponent(0).getParent(), calendarBox);
				}
		});
		
		
		((CustomCalendar)this).setSelectedDay(calendarBox.getSelectedDay());
		((CustomCalendar)this).setSelectedMonth(calendarBox.getSelectedMonth());
		((CustomCalendar)this).setSelectedYear(calendarBox.getSelectedYear());
		
		year = this.selectedYear;
		month = this.getSelectedMonth();
		getDays(this.getSelectedYear(), this.getSelectedMonth(), this, calendarBox);
		}

	
	public static void getDays(int year, int month, CustomCalendar c, CalendarBox calendarBox) {

		String [] months = new String[] {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin"
				, "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
		date.setText(months[month]+" "+year);
		for(int i = 0; i< panelDate.getComponentCount(); i++) {
				((Container) panelDate.getComponent(i)).removeAll();
		}
		Calendar calendar = Calendar.getInstance();
      //  int year = 2021;
      //  int month = Calendar.FEBRUARY;
        int date = 1;
        // We have a new date of 2021-02-01
        calendar.set(year, month, date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        

    	int k = calendar.getTime().getDay();
    	if(k == 0) {
    		k = 7;
    	}
        for(int i = 0; i< k-1; i++) {
    		JLabel label_12 = new JLabel();
    		label_12.setName(0+"");
    		label_12.setFocusable(false);
    		label_12.setFocusTraversalKeysEnabled(false);
    		label_12.setOpaque(true);
    		label_12.setPreferredSize(new Dimension(40, 23));
    		label_12.setHorizontalAlignment(SwingConstants.CENTER);
    		label_12.setFont(new Font("Roboto", Font.PLAIN, 14));
        	((Container) panelDate.getComponent(i)).add(label_12);
			}
        for(int i = 1; i<= maxDay; i++) {

            calendar.set(year, month, i);
        	int j = calendar.getTime().getDay();
        	
        	if(j == 0) {
        		j = 7;
        	}
        		JButton label_12 = new JButton(i+"");
        		label_12.setName(i+"");
        		label_12.setBorder(null);
        		label_12.setFocusPainted(false);
        		label_12.setOpaque(true);
        		label_12.setPreferredSize(new Dimension(40, 23));
        		label_12.setHorizontalAlignment(SwingConstants.CENTER);
        		label_12.setFont(new Font("Roboto", Font.PLAIN, 14));
        		label_12.setForeground(Color.white);
        		label_12.setBackground(panelDate.getBackground());
        		((Container) panelDate.getComponent(j-1)).add(label_12);
        		

        		label_12.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				label_12.setBackground(label_12.getBackground().darker());
        	        	//setDate(year, month, c);
        			}
        			public void mouseExited(MouseEvent e) {
        				//label_12.setBackground(panelDate.getBackground());
        	        	setDate(year, month, c, calendarBox);
        			}
        		});
        		label_12.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//label_12.setBackground(new Color(20, 148, 198));
        				c.setSelectedDay(Integer.parseInt(label_12.getName()));
        				c.setSelectedMonth(month);
        				c.setSelectedYear(year);
        				setDate(year, month, c, calendarBox);

        				c.getParent().setVisible(false);
        			}
        		});
        	setDate(year, month, c, calendarBox);
        	panelDate.revalidate();
        	panelDate.repaint();
        	}
	}
	
	public static void setDate(int year, int month, CustomCalendar c, CalendarBox calendarBox) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d2 = null;
			try {
				d2 = df.parse(getInternetDateAndTime.getDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		for(int i = 0; i< panelDate.getComponentCount(); i++) {
			for(int j = 0; j< ((Container) panelDate.getComponent(i)).getComponentCount(); j++) {
				if(c.getSelectedYear() == year && c.getSelectedMonth() == month && c.getSelectedDay() 
						== Integer.parseInt(((Container) panelDate.getComponent(i)).getComponent(j).getName())) {	
					((Container) panelDate.getComponent(i)).getComponent(j).setBackground(new Color(20, 148, 198));
					calendarBox.setSelectedDay(Integer.parseInt(((Container) panelDate.getComponent(i)).getComponent(j).getName()));
					calendarBox.setSelectedMonth(month);
					calendarBox.setSelectedYear(year);
				}else {
					((Container) panelDate.getComponent(i)).getComponent(j).setBackground(panelDate.getBackground());
				}
				if(d2.getYear()+1900 == year && d2.getMonth() == month && d2.getDate()
						== Integer.parseInt(((Container) panelDate.getComponent(i)).getComponent(j).getName())) {	
					((JComponent) ((Container) panelDate.getComponent(i)).getComponent(j)).setBorder(new LineBorder(new Color(255, 150, 102), 2));
				}else {
					((JComponent) ((Container) panelDate.getComponent(i)).getComponent(j)).setBorder(null);
				}
			}
	}
	}
}
