package Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.joda.time.DateTime;

import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import CloudOperations.mysql;
import Publishing.getInternetDateAndTime;
import accounts.Login;
import app.WrapLayout;
import elements.CalendarBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Attendance extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance(String classroom_in_ay_id) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 300));
	setTitle("");
	setBounds(100, 100, 450, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	Login.setAsPopup(this);
	
	JButton btnFermer = new JButton("Fermer");
	btnFermer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnFermer.setForeground(Color.WHITE);
	btnFermer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnFermer.setFocusPainted(false);
	btnFermer.setBorderPainted(false);
	btnFermer.setBackground(new Color(171, 0, 0));
	btnFermer.setBounds(295, 519, 129, 31);
	contentPane.add(btnFermer);
	
	JLabel lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Liste des presences</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 414, 33);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 33, 434, 1);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 128, 414, 380);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ceci est la liste des presences de la classe. Les eleves sont soit presents, absents, en retard ou excuses.</div></html>");
	lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblajouterModifierouSupprimer.setBounds(10, 34, 414, 51);
	contentPane.add(lblajouterModifierouSupprimer);
	
	setLocationRelativeTo(null);
	
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(390, 25));
	panel_1.setBackground(new Color(60, 60, 60));;
	
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
			panel_2.setBackground(panel_2.getParent().getBackground());
			
			JLabel lblNewLabel = new JLabel("UMUHOZA Chris Koen Michael");
			panel_2.add(lblNewLabel);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.white);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		panel_3.setBackground(panel_3.getParent().getBackground());
		
		
		
		JButton btnP = new JButton("P");
		panel_3.add(btnP);
		btnP.setPreferredSize(new Dimension(35, 25));
		btnP.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnP.setIconTextGap(0);
		btnP.setHorizontalTextPosition(SwingConstants.CENTER);
		btnP.setForeground(new Color(0, 0, 0));
		btnP.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnP.setFocusPainted(false);
		btnP.setBorder(null);
		btnP.setBackground(new Color(51, 255, 204));
		Home.addToolTip(btnP, "Present(e)");
		
		JButton button = new JButton("A");
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(new Dimension(35, 25));
		button.setIconTextGap(0);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Roboto", Font.PLAIN, 14));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(250, 128, 114));
		panel_3.add(button);
		Home.addToolTip(button, "Absent(e)");
		
		JButton btnL = new JButton("R");
		btnL.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnL.setPreferredSize(new Dimension(35, 25));
		btnL.setIconTextGap(0);
		btnL.setHorizontalTextPosition(SwingConstants.CENTER);
		btnL.setForeground(Color.BLACK);
		btnL.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnL.setFocusPainted(false);
		btnL.setBorder(null);
		btnL.setBackground(new Color(255, 153, 51));
		panel_3.add(btnL);
		Home.addToolTip(btnL, "En retard");
		
		
		JButton button1 = new JButton("E");
		panel_3.add(button1);
		button1.setPreferredSize(new Dimension(35, 25));
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button1.setIconTextGap(0);
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Roboto", Font.PLAIN, 14));
		button1.setFocusPainted(false);
		button1.setBorder(null);
		button1.setBackground(new Color(255, 255, 102));
		Home.addToolTip(button1, "Excuse(e)");
		
		JButton btnTousPresents = new JButton("Tous presents");
		btnTousPresents.setEnabled(false);
		btnTousPresents.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTousPresents.setPreferredSize(new Dimension(35, 25));
		btnTousPresents.setIconTextGap(0);
		btnTousPresents.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTousPresents.setForeground(new Color(255, 255, 255));
		btnTousPresents.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnTousPresents.setFocusPainted(false);
		btnTousPresents.setBorder(null);
		btnTousPresents.setBackground(new Color(20, 148, 198));
		btnTousPresents.setBounds(308, 92, 116, 25);
		contentPane.add(btnTousPresents);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d1 = null;
			try {
				d1 = df.parse(getInternetDateAndTime.getDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		CalendarBox calendar = new CalendarBox(d1.getYear()+1900, d1.getMonth(), d1.getDate());
		
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				 Date d1 = null;
					try {
						d1 = df.parse(calendar.getSelectedDay()+"/"+(calendar.getSelectedMonth()+1)+"/"+calendar.getSelectedYear());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		loadStudents(classroom_in_ay_id, d1);
			}
		});
		calendar.setBounds(10, 100, calendar.getPreferredSize().width, calendar.getPreferredSize().height);
		contentPane.add(calendar);
		
		loadStudents(classroom_in_ay_id, d1);
		
	}
	
	public static void loadStudents(String classroom_in_ay_id, Date date) {
		panel.removeAll();
		Object[] lines = Home.loadActiveStudents(classroom_in_ay_id);
		
		for(int i = 0; i<lines.length;i++) {
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setName(lines[i].toString());
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setBackground(new Color(60, 60, 60));;
			
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
					panel_2.setBackground(panel_2.getParent().getBackground());
					
					panel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white));
						}
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});
					
					JLabel lblNewLabel = new JLabel(Home.getStudentName(lines[i].toString()));
					panel_2.add(lblNewLabel);
					lblNewLabel.setMaximumSize(new Dimension(300, 14));
					lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.white);
				
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, BorderLayout.EAST);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

				panel_3.setBackground(panel_3.getParent().getBackground());
				
				
				
				JButton btnP = new JButton("P");
				panel_3.add(btnP);
				btnP.setPreferredSize(new Dimension(35, 25));
				btnP.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnP.setIconTextGap(0);
				btnP.setHorizontalTextPosition(SwingConstants.CENTER);
				btnP.setForeground(new Color(0, 0, 0));
				btnP.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnP.setFocusPainted(false);
				btnP.setBorder(null);
				btnP.setBackground(new Color(51, 255, 204));
				Home.addToolTip(btnP, "Present(e)");
				
				JButton button = new JButton("A");
				button.setVerticalTextPosition(SwingConstants.BOTTOM);
				button.setPreferredSize(new Dimension(35, 25));
				button.setIconTextGap(0);
				button.setHorizontalTextPosition(SwingConstants.CENTER);
				button.setForeground(new Color(0, 0, 0));
				button.setFont(new Font("Roboto", Font.PLAIN, 14));
				button.setFocusPainted(false);
				button.setBorder(null);
				button.setBackground(new Color(250, 128, 114));
				panel_3.add(button);
				Home.addToolTip(button, "Absent(e)");
				
				JButton btnL = new JButton("R");
				btnL.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnL.setPreferredSize(new Dimension(35, 25));
				btnL.setIconTextGap(0);
				btnL.setHorizontalTextPosition(SwingConstants.CENTER);
				btnL.setForeground(Color.BLACK);
				btnL.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnL.setFocusPainted(false);
				btnL.setBorder(null);
				btnL.setBackground(new Color(255, 153, 51));
				panel_3.add(btnL);
				Home.addToolTip(btnL, "En retard");
				
				
				JButton button1 = new JButton("E");
				panel_3.add(button1);
				button1.setPreferredSize(new Dimension(35, 25));
				button1.setVerticalTextPosition(SwingConstants.BOTTOM);
				button1.setIconTextGap(0);
				button1.setHorizontalTextPosition(SwingConstants.CENTER);
				button1.setForeground(new Color(0, 0, 0));
				button1.setFont(new Font("Roboto", Font.PLAIN, 14));
				button1.setFocusPainted(false);
				button1.setBorder(null);
				button1.setBackground(new Color(255, 255, 102));
				Home.addToolTip(button1, "Excuse(e)");
			
				
				
				for(int j = 0; j< panel_3.getComponentCount(); j++) {
					panel_3.getComponent(j).setBackground(panel_3.getBackground());
					panel_3.getComponent(j).setForeground(Color.white);
				}

				loadAttendance(panel_1, date);
				for(int j = 0; j< panel_3.getComponentCount(); j++) {
					
					int k = j;
					
					((AbstractButton) panel_3.getComponent(j)).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white));
						}
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});
					((AbstractButton) panel_3.getComponent(j)).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for(int j = 0; j< panel_3.getComponentCount(); j++) {
								panel_3.getComponent(j).setBackground(panel_3.getBackground());
								panel_3.getComponent(j).setForeground(Color.white);
							}
							panel_3.getComponent(k).setForeground(Color.black);
							if(k == 0) {
								panel_3.getComponent(k).setBackground(new Color(51, 255, 204));
							}if(k == 1) {
								panel_3.getComponent(k).setBackground(new Color(250, 128, 114));
							}if(k == 2) {
								panel_3.getComponent(k).setBackground(new Color(255, 153, 51));
							}if(k == 3) {
								panel_3.getComponent(k).setBackground(new Color(255, 255, 102));
							}
						}
					});
				}
				
		}
	}

	private static void loadAttendance(Container c, Date date) {
		String student_in_classroom_id = c.getName();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from attendance "
					+ "WHERE sic_id = '"+student_in_classroom_id+"'");
			while(rs.next())
			{
				Date date1 = rs.getDate("date");
				

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						date1 = df.parse(date1.getDate()+"/"+(date1.getMonth()+1)+"/"+(date1.getYear()+1900));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(date.compareTo(date1) == 0) {
				if(rs.getInt("attendance_status") == 0) {
					((Container) c.getComponent(1)).getComponent(0).setBackground(new Color(51, 255, 204));
					((Container) c.getComponent(1)).getComponent(0).setForeground(Color.black);
				}if(rs.getInt("attendance_status") == 1) {
					((Container) c.getComponent(1)).getComponent(1).setBackground(new Color(250, 128, 114));
					((Container) c.getComponent(1)).getComponent(1).setForeground(Color.black);
				}if(rs.getInt("attendance_status") == 2) {
					((Container) c.getComponent(1)).getComponent(2).setBackground(new Color(255, 153, 51));
					((Container) c.getComponent(1)).getComponent(2).setForeground(Color.black);
				}if(rs.getInt("attendance_status") == 3) {
					((Container) c.getComponent(1)).getComponent(3).setBackground(new Color(255, 255, 102));
					((Container) c.getComponent(1)).getComponent(3).setForeground(Color.black);
				}
				}
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		
	}
}
