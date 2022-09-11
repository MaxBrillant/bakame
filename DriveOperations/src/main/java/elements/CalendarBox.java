package elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import Application.ResizeImages;
import javax.swing.border.LineBorder;

public class CalendarBox extends JButton {

	private int selectedDay, selectedMonth, selectedYear;
	private String[] days = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	
	public int getSelectedDay() {
		return selectedDay;
	}
	
	public void setSelectedDay(int selectedDay) {
		this.selectedDay = selectedDay;
		Calendar calendar = Calendar.getInstance();
        calendar.set(this.getSelectedYear(), this.getSelectedMonth(), this.getSelectedDay());
		((JButton) this).setText(days[calendar.getTime().getDay()].substring(0, 3)+". "+ this.getSelectedDay()+"/"+(this.getSelectedMonth()+1)+"/"+this.getSelectedYear());
	
	}
	public int getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(int selectedMonth) {
		this.selectedMonth = selectedMonth;
		Calendar calendar = Calendar.getInstance();
        calendar.set(this.getSelectedYear(), this.getSelectedMonth(), this.getSelectedDay());
		((JButton) this).setText(days[calendar.getTime().getDay()].substring(0, 3)+". "+ this.getSelectedDay()+"/"+(this.getSelectedMonth()+1)+"/"+this.getSelectedYear());
	}
	public int getSelectedYear() {
		return selectedYear;
	}
	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
		Calendar calendar = Calendar.getInstance();
        calendar.set(this.getSelectedYear(), this.getSelectedMonth(), this.getSelectedDay());
		((JButton) this).setText(days[calendar.getTime().getDay()].substring(0, 3)+". "+ this.getSelectedDay()+"/"+(this.getSelectedMonth()+1)+"/"+this.getSelectedYear());
	}
	
	
	
	public CalendarBox(int year, int month, int day) {
		setFocusPainted(false);
		setBorder(new LineBorder(new Color(211, 211, 211)));
		setBackground(new Color(40, 40, 40));
		setForeground(Color.WHITE);
		setPreferredSize(new Dimension(170, 25));
		setText("Sam. 26/07/2022");
		setIconTextGap(7);
		setHorizontalTextPosition(SwingConstants.LEADING);
		setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		setFont(new Font("Roboto", Font.PLAIN, 14));
		
		this.setSelectedDay(day);
		this.setSelectedMonth(month);
		this.setSelectedYear(year);
		
		CalendarBox cb = this;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPopupMenu popup = new JPopupMenu();
				popup.setBorderPainted(false);
				popup.setBackground(Color.black);
				popup.setLayout(new BorderLayout(0, 0));
				
				CustomCalendar cc = new CustomCalendar((cb));
				popup.add(cc);
				popup.setPreferredSize(new Dimension(cc.getPreferredSize().width+5, cc.getPreferredSize().height+10));
					showMenu(e, popup);
			}
			private void showMenu(ActionEvent e, JPopupMenu j) {
				j.show(cb, 0-((j.getPreferredSize().width-cb.getWidth())/2), cb.getPreferredSize().height);
				}
		});
		}
}
