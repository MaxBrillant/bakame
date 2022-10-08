package Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Application.Home;
import Application.ResizeImages;
import Application.Teacher;
import CloudOperations.mysql;
import Publishing.getInternetDateAndTime;
import accounts.Login;
import app.WrapLayout;
import elements.CalendarBox;
import elements.CustomButton;
import javax.swing.border.LineBorder;

public class ClassDiary extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassDiary frame = new ClassDiary();
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
	public ClassDiary(String classroom_in_ay_id) {
		setBackground(new Color(0, 0, 0));
		setPreferredSize(new Dimension(700,	700));
	setTitle("");
	//Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(100, 100, 700, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	setContentPane(contentPane);
	setLocationRelativeTo(null);
	contentPane.setLayout(new BorderLayout(0, 0));
	Login.setAsPopup(this);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(contentPane.getBackground());
	panel_1.setPreferredSize(new Dimension(100, 120));
	contentPane.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(null);
	
	JLabel title = new JLabel("Journal de la classe de "+Home.getClassName(classroom_in_ay_id));
	title.setBounds(0, 0, 684, 33);
	title.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
	title.setPreferredSize(new Dimension(163, 33));
	panel_1.add(title);
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Roboto", Font.BOLD, 16));
	
	JLabel lbleeEconomique = new JLabel("<html><div style='text-align: center;'>La structure de l'horaire de la classe est utilisee par le logiciel afin de pouvoir aider les professeurs lors de la creation des horaires des enseignants.</div></html>");
	lbleeEconomique.setBounds(0, 34, 684, 45);
	lbleeEconomique.setPreferredSize(new Dimension(703, 33));
	panel_1.add(lbleeEconomique);
	lbleeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
	lbleeEconomique.setForeground(new Color(211, 211, 211));
	lbleeEconomique.setFont(new Font("Roboto", Font.PLAIN, 14));
	
	
	
	JButton button_1 = new JButton("Ajouter");
	button_1.setForeground(Color.WHITE);
	button_1.setFont(new Font("Roboto", Font.BOLD, 14));
	button_1.setFocusPainted(false);
	button_1.setBorderPainted(false);
	button_1.setBackground(new Color(0, 171, 89));
	button_1.setBounds(562, 87, 101, 31);
	panel_1.add(button_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setPreferredSize(new Dimension(0, 0));
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addContainerListener(new ContainerAdapter() {
		@Override
		public void componentAdded(ContainerEvent e) {
		//	pause();
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	panel.setPreferredSize(new Dimension(0, 0));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));
	
	
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
	load(classroom_in_ay_id, d1);
		}
	});
	calendar.setBounds(10, 90, calendar.getPreferredSize().width, calendar.getPreferredSize().height);
	panel_1.add(calendar);
	
	
	JPanel panel_4 = new JPanel();
	panel_4.setBackground(Color.DARK_GRAY);
	panel_4.setPreferredSize(new Dimension(660, 40));
	panel.add(panel_4);
	panel_4.setLayout(new BorderLayout(0, 0));
	
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(Color.DARK_GRAY);
	panel_4.add(panel_6, BorderLayout.WEST);
	panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
	
	JLabel label = new JLabel("07:30 - 09:45");
	label.setPreferredSize(new Dimension(85, 40));
	//label.setPreferredSize(new Dimension(140, 40));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 14));
	label.setBorder(null);
	panel_6.add(label);
	
	JLabel lblUmuhozaChrisKoen_1 = new JLabel("UMUHOZA Chris Koen Michael (Entrepreneuriat)");
	lblUmuhozaChrisKoen_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblUmuhozaChrisKoen_1.setForeground(Color.WHITE);
	lblUmuhozaChrisKoen_1.setFont(new Font("Roboto", Font.BOLD, 14));
	lblUmuhozaChrisKoen_1.setBorder(null);
	panel_6.add(lblUmuhozaChrisKoen_1);
	
	JLabel lblDLkjklsdjkfjakjsKkfjaksj = new JLabel("D lkjklsdjkfjakjs kkfjaksj jfaksdjklfasd flajsdf jaklsdjklf jaksldjkl fjasj fl");
	lblDLkjklsdjkfjakjsKkfjaksj.setHorizontalAlignment(SwingConstants.CENTER);
	lblDLkjklsdjkfjakjsKkfjaksj.setForeground(new Color(211, 211, 211));
	lblDLkjklsdjkfjakjsKkfjaksj.setFont(new Font("Roboto", Font.PLAIN, 12));
	lblDLkjklsdjkfjakjsKkfjaksj.setBorder(null);
	panel_4.add(lblDLkjklsdjkfjakjsKkfjaksj, BorderLayout.CENTER);
	
	
	JPanel panel_5 = new JPanel();
	panel_5.setPreferredSize(new Dimension(80, 10));
	panel_4.add(panel_5, BorderLayout.EAST);
	panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	panel_5.setBackground(panel_5.getParent().getBackground());
	
	JButton button = new JButton("");
	panel_5.add(button);
	button.setPreferredSize(new Dimension(40, 40));
	button.setIcon(ResizeImages.resize(20, 20, "Icons\\iconedit.png"));
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setIconTextGap(0);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button.setFocusPainted(false);
	button.setBorder(null);
	button.setBackground(button.getParent().getBackground());
	Home.addToolTip(button, "Modifier");
	
	
	JButton button1 = new JButton("");
	panel_5.add(button1);
	button1.setPreferredSize(new Dimension(40, 40));
	button1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
	button1.setVerticalTextPosition(SwingConstants.BOTTOM);
	button1.setIconTextGap(0);
	button1.setHorizontalTextPosition(SwingConstants.CENTER);
	button1.setForeground(Color.WHITE);
	button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button1.setFocusPainted(false);
	button1.setBorder(null);
	button1.setBackground(button1.getParent().getBackground());
	Home.addToolTip(button1, "Supprimer");
	
	

	setLocationRelativeTo(null);
	
	//load(classroom_in_ay_id);

	load(classroom_in_ay_id, d1);
	}
	
	
	public static void load(String classroom_in_ay_id, Date date) {
		panel.removeAll();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * FROM class_diary AS cd "
					+ "JOIN teachers_in_classrooms AS tic "
					+ "JOIN teachers AS t "
					+ "JOIN classrooms_in_ay AS cia "
					+ "JOIN courses_in_classroom AS cic "
					+ "JOIN courses AS c "
					+ "WHERE tic.is_active = 1 AND t.is_active = 1 AND cia.is_active = 1 AND cic.is_active = 1 AND c.is_active = 1 AND cd.tic_id = tic.tic_id AND tic.teacher_id = t.teacher_id "
					+ " AND tic.courses_in_classroom_id = cic.courses_in_classroom_id AND cic.course_id = c.course_id AND cic.cia_id = cia.cia_id AND cia.cia_id = '"+classroom_in_ay_id+"' ORDER BY cd.start_time ASC");
			while(rs.next())
			{
		
Date date1 = rs.getDate("cd.date");
				

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						date1 = df.parse(date1.getDate()+"/"+(date1.getMonth()+1)+"/"+(date1.getYear()+1900));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(date.compareTo(date1) == 0) {
					
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setPreferredSize(new Dimension(660, 40));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_4.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		JLabel label = new JLabel((rs.getString("cd.start_time").substring(0, 5)+" - "+rs.getString("cd.end_time").substring(0, 5)));
		label.setPreferredSize(new Dimension(85, 40));
		//label.setPreferredSize(new Dimension(140, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.PLAIN, 14));
		label.setBorder(null);
		panel_6.add(label);
		
		JLabel lblUmuhozaChrisKoen_1 = new JLabel(Teacher.getTeacherName(rs.getString("tic.teacher_id"))+" ("+TestBox.getShortName(rs.getString("cic.courses_in_classroom_id"))+")");
		lblUmuhozaChrisKoen_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUmuhozaChrisKoen_1.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblUmuhozaChrisKoen_1.setBorder(null);
		panel_6.add(lblUmuhozaChrisKoen_1);
		
		JLabel lblDLkjklsdjkfjakjsKkfjaksj = new JLabel(rs.getString("activities"));
		lblDLkjklsdjkfjakjsKkfjaksj.setHorizontalAlignment(SwingConstants.CENTER);
		lblDLkjklsdjkfjakjsKkfjaksj.setForeground(new Color(211, 211, 211));
		lblDLkjklsdjkfjakjsKkfjaksj.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblDLkjklsdjkfjakjsKkfjaksj.setBorder(null);
		panel_4.add(lblDLkjklsdjkfjakjsKkfjaksj, BorderLayout.CENTER);
		
		if(rs.getInt("cd.attendance_status") == 0) {
			lblDLkjklsdjkfjakjsKkfjaksj.setText("Aucune activite effectuee.");
			lblDLkjklsdjkfjakjsKkfjaksj.setForeground(new Color(255, 102, 102));
		}
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(80, 10));
		panel_4.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_5.setBackground(panel_5.getParent().getBackground());
		
		JButton button = new JButton("");
		panel_5.add(button);
		button.setPreferredSize(new Dimension(40, 40));
		button.setIcon(ResizeImages.resize(20, 20, "Icons\\iconedit.png"));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setIconTextGap(0);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(button.getParent().getBackground());
		Home.addToolTip(button, "Modifier");
		
		
		JButton button1 = new JButton("");
		panel_5.add(button1);
		button1.setPreferredSize(new Dimension(40, 40));
		button1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button1.setIconTextGap(0);
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button1.setFocusPainted(false);
		button1.setBorder(null);
		button1.setBackground(button1.getParent().getBackground());
		Home.addToolTip(button1, "Supprimer");
		
		
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setBackground(new Color(255, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				button1.setBackground(button1.getParent().getBackground());
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(20, 148, 198));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				button.setBackground(button.getParent().getBackground());
			}
		});
		
		
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_4.getComponent(2).setVisible(true);
				
				for(int i = 0; i< (panel_4.getParent()).getComponentCount(); i++) {
					if(!(panel_4.getParent()).getComponent(i).equals(panel_4.getComponent(0).getParent())) {
				((Container) ((Container) panel_4.getParent().getComponent(i))).getComponent(2).setVisible(false);
					
				panel_4.getParent().revalidate();

				panel_4.getParent().repaint();
					}
				}
				
				panel_4.setBorder(new LineBorder(Color.white, 1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBorder(null);
			}
		});

		
			}}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
if(panel.getComponentCount() == 0) {
			
	try {
		int day = date.getDay();
				if(day == 0) {
					day = 7;
				}

		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM schedule_class AS sc "
				+ "JOIN schedule_course AS sco "
				+ "JOIN teachers_in_classrooms AS tic "
				+ "JOIN teachers AS t "
				+ "JOIN classrooms_in_ay AS cia "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN courses AS c "
				+ "WHERE tic.is_active = 1 AND t.is_active = 1 AND cia.is_active = 1 AND cic.is_active = 1 AND c.is_active = 1 AND sco.tic_id = tic.tic_id AND tic.teacher_id = t.teacher_id AND sc.schedule_id = sco.schedule_id AND sc.cia_id = cia.cia_id "
				+ " AND tic.courses_in_classroom_id = cic.courses_in_classroom_id AND cic.course_id = c.course_id AND cic.cia_id = cia.cia_id AND cia.cia_id = '"+classroom_in_ay_id+"' AND sc.day_of_the_week = '"+day+"' ORDER BY sc.start_time ASC");
		while(rs.next())
		{
				
	JPanel panel_4 = new JPanel();
	panel_4.setBackground(Color.DARK_GRAY);
	panel_4.setPreferredSize(new Dimension(660, 40));
	panel.add(panel_4);
	panel_4.setLayout(new BorderLayout(0, 0));
	
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(Color.DARK_GRAY);
	panel_4.add(panel_6, BorderLayout.WEST);
	panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
	
	JLabel label = new JLabel((rs.getString("sc.start_time").substring(0, 5)+" - "+rs.getString("sc.end_time").substring(0, 5)));
	label.setPreferredSize(new Dimension(85, 40));
	//label.setPreferredSize(new Dimension(140, 40));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 14));
	label.setBorder(null);
	panel_6.add(label);
	
	JLabel lblUmuhozaChrisKoen_1 = new JLabel(Teacher.getTeacherName(rs.getString("tic.teacher_id"))+" ("+TestBox.getShortName(rs.getString("cic.courses_in_classroom_id"))+")");
	lblUmuhozaChrisKoen_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblUmuhozaChrisKoen_1.setForeground(Color.WHITE);
	lblUmuhozaChrisKoen_1.setFont(new Font("Roboto", Font.BOLD, 14));
	lblUmuhozaChrisKoen_1.setBorder(null);
	panel_6.add(lblUmuhozaChrisKoen_1);
	
	JLabel lblDLkjklsdjkfjakjsKkfjaksj = new JLabel("Aucune activite effectuee");
	lblDLkjklsdjkfjakjsKkfjaksj.setHorizontalAlignment(SwingConstants.CENTER);
	lblDLkjklsdjkfjakjsKkfjaksj.setForeground(new Color(211, 211, 211));
	lblDLkjklsdjkfjakjsKkfjaksj.setFont(new Font("Roboto", Font.PLAIN, 12));
	lblDLkjklsdjkfjakjsKkfjaksj.setBorder(null);
	panel_4.add(lblDLkjklsdjkfjakjsKkfjaksj, BorderLayout.CENTER);
	lblDLkjklsdjkfjakjsKkfjaksj.setForeground(new Color(255, 102, 102));
	
	
	JPanel panel_5 = new JPanel();
	panel_5.setPreferredSize(new Dimension(80, 10));
	panel_4.add(panel_5, BorderLayout.EAST);
	panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	panel_5.setBackground(panel_5.getParent().getBackground());
	panel_5.setVisible(false);
	
	JButton button = new JButton("");
	panel_5.add(button);
	button.setPreferredSize(new Dimension(40, 40));
	button.setIcon(ResizeImages.resize(20, 20, "Icons\\iconedit.png"));
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setIconTextGap(0);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button.setFocusPainted(false);
	button.setBorder(null);
	button.setBackground(button.getParent().getBackground());
	Home.addToolTip(button, "Modifier");
	
	
	JButton button1 = new JButton("");
	panel_5.add(button1);
	button1.setPreferredSize(new Dimension(40, 40));
	button1.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
	button1.setVerticalTextPosition(SwingConstants.BOTTOM);
	button1.setIconTextGap(0);
	button1.setHorizontalTextPosition(SwingConstants.CENTER);
	button1.setForeground(Color.WHITE);
	button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button1.setFocusPainted(false);
	button1.setBorder(null);
	button1.setBackground(button1.getParent().getBackground());
	Home.addToolTip(button1, "Supprimer");
	
	
	button1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			button1.setBackground(new Color(255, 102, 102));
		}
		@Override
		public void mouseExited(MouseEvent e) {

			button1.setBackground(button1.getParent().getBackground());
		}
	});
	
	button.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			button.setBackground(new Color(20, 148, 198));
		}
		@Override
		public void mouseExited(MouseEvent e) {

			button.setBackground(button.getParent().getBackground());
		}
	});
	
	panel_4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			
			panel_4.getComponent(2).setVisible(true);
			
			for(int i = 0; i< (panel_4.getParent()).getComponentCount(); i++) {
				if(!(panel_4.getParent()).getComponent(i).equals(panel_4.getComponent(0).getParent())) {
			((Container) ((Container) panel_4.getParent().getComponent(i))).getComponent(2).setVisible(false);
				
			panel_4.getParent().revalidate();

			panel_4.getParent().repaint();
				}
			}
			
			panel_4.setBorder(new LineBorder(Color.white, 1));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel_4.setBorder(null);
		}
	});
	
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}


if(panel.getComponentCount() == 0) {

	JLabel lblNewLabel = new JLabel("<html><div style='text-align: left;'>Aucun cours n'est assigne a un professeur dans cette classe</div></html>");
	lblNewLabel.setPreferredSize(new Dimension(670, 50));
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel.add(lblNewLabel, 0);

}
panel.revalidate();
panel.repaint();
	}
}
