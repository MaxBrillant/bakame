package Class;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.NewSession;
import Application.Schedule;
import Application.ScheduleStructure;
import Application.Teacher;
import CloudOperations.mysql;
import accounts.Loading;
import accounts.Login;
import app.WrapLayout;
import elements.CustomButton;

import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;

public class ClassSchedule extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static Color backColor = new Color(240, 240, 240);
	public static Color foreColor = new Color(0, 0, 0);
	public static boolean isBackground;
	public static boolean backgroundisSelected = false;
	public static boolean foregroundisSelected = false;
	public static JPanel hours;
	public static JScrollPane scrollPane;
	public static JPanel panel;
	public static int selectedSession = 0;
	private static JPanel panelTeacher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysql.connectToDB();
					Schedule frame = new Schedule("1", "8");
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
		    
	public ClassSchedule(String classroom_in_ay_id) {
		setBackground(new Color(0, 0, 0));
		setPreferredSize(new Dimension(700,	700));
	setTitle("");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(100,100,screensize.width,screensize.height);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	setContentPane(contentPane);
	setLocationRelativeTo(null);
	contentPane.setLayout(new BorderLayout(0, 0));
	Login.setAsPopup(this);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(contentPane.getBackground());
	panel_1.setPreferredSize(new Dimension(100, 90));
	contentPane.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(new BorderLayout(0, 0));
	
	JLabel title = new JLabel("Horaire de la classe de "+Home.getClassName(classroom_in_ay_id));
	title.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
	title.setPreferredSize(new Dimension(163, 33));
	panel_1.add(title, BorderLayout.NORTH);
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Roboto", Font.BOLD, 16));
	
	JLabel lbleeEconomique = new JLabel("<html><div style='text-align: center;'>Ceci est l'horaire de la classe. Cliquez sur un professeur pour voir les cours qu'il/elle dispense.</div></html>");
	lbleeEconomique.setPreferredSize(new Dimension(703, 33));
	panel_1.add(lbleeEconomique);
	lbleeEconomique.setHorizontalAlignment(SwingConstants.CENTER);
	lbleeEconomique.setForeground(new Color(211, 211, 211));
	lbleeEconomique.setFont(new Font("Roboto", Font.PLAIN, 14));
	
	scrollPane = new JScrollPane();
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
	panel.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
	
	hours = new JPanel();
	hours.setBorder(null);
	hours.setBackground(panel.getBackground());
	hours.setPreferredSize(new Dimension(140, 345));
	panel.add(hours);
	hours.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel lblHeuresseances = new JLabel("Heures des seances");
	lblHeuresseances.setHorizontalAlignment(SwingConstants.CENTER);
	lblHeuresseances.setForeground(Color.WHITE);
	lblHeuresseances.setFont(new Font("Roboto", Font.PLAIN, 14));
	hours.add(lblHeuresseances);
	
	JPanel lundi = new JPanel();
	lundi.setBorder(null);
	lundi.setBackground(panel.getBackground());
	lundi.setPreferredSize(new Dimension(140, 345));
	panel.add(lundi);
	lundi.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label = new JLabel("Lundi");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Roboto", Font.PLAIN, 14));
	lundi.add(label);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBorder(null);
	panel_3.setBackground(panel.getBackground());
	panel_3.setPreferredSize(new Dimension(140, 345));
	panel.add(panel_3);
	panel_3.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label_1 = new JLabel("Mardi");
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setForeground(Color.WHITE);
	label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_3.add(label_1);
	
	JPanel panel_4 = new JPanel();
	panel_4.setBorder(null);
	panel_4.setBackground(panel.getBackground());
	panel_4.setPreferredSize(new Dimension(140, 345));
	panel.add(panel_4);
	panel_4.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label_2 = new JLabel("Mercredi");
	label_2.setHorizontalAlignment(SwingConstants.CENTER);
	label_2.setForeground(Color.WHITE);
	label_2.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_4.add(label_2);
	
	JPanel panel_5 = new JPanel();
	panel_5.setBorder(null);
	panel_5.setBackground(panel.getBackground());
	panel_5.setPreferredSize(new Dimension(140, 345));
	panel.add(panel_5);
	panel_5.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label_3 = new JLabel("Jeudi");
	label_3.setHorizontalAlignment(SwingConstants.CENTER);
	label_3.setForeground(Color.WHITE);
	label_3.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_5.add(label_3);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBorder(null);
	panel_6.setBackground(panel.getBackground());
	panel_6.setPreferredSize(new Dimension(140, 345));
	panel.add(panel_6);
	panel_6.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label_4 = new JLabel("Vendredi");
	label_4.setHorizontalAlignment(SwingConstants.CENTER);
	label_4.setForeground(Color.WHITE);
	label_4.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_6.add(label_4);
	
	JPanel panel_2 = new JPanel();
	panel_2.setPreferredSize(new Dimension(140, 345));
	panel_2.setBorder(null);
	panel_2.setBackground(new Color(40, 40, 40));
	panel.add(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	JLabel label_5 = new JLabel("Samedi");
	label_5.setHorizontalAlignment(SwingConstants.CENTER);
	label_5.setForeground(Color.WHITE);
	label_5.setFont(new Font("Roboto", Font.PLAIN, 14));
	panel_2.add(label_5);
	
	JPanel panel1 = new JPanel();
	panel1.setFont(new Font("Roboto", Font.BOLD, 14));
	panel1.setForeground(Color.WHITE);
	contentPane.add(panel1, BorderLayout.SOUTH);
	panel1.setLayout(new BorderLayout(0, 0));
	panel1.setBackground(contentPane.getBackground());
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBackground(contentPane.getBackground());
	scrollPane_1.setPreferredSize(new Dimension(100, 120));
	scrollPane_1.setBorder(null);
	panel1.add(scrollPane_1, BorderLayout.CENTER);
	
	panelTeacher = new JPanel();
	panelTeacher.setBackground(contentPane.getBackground());
	scrollPane_1.setViewportView(panelTeacher);
	panelTeacher.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
	
	CustomButton btnNewButton_21 = new CustomButton();
	btnNewButton_21.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_21.setRadius(15);
	btnNewButton_21.setText("Nzosaba Avit Viateur");
	btnNewButton_21.setFont(new Font("Roboto", Font.PLAIN, 16));
	btnNewButton_21.setBackground(panelTeacher.getBackground());
	btnNewButton_21.setForeground(new Color(211, 211, 211));
	btnNewButton_21.setBorderColor(new Color(211, 211, 211));
	panelTeacher.add(btnNewButton_21);
	
	JLabel lblNewLabel = new JLabel("   Professeurs");
	lblNewLabel.setPreferredSize(new Dimension(66, 40));
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
	panel1.add(lblNewLabel, BorderLayout.NORTH);

	setLocationRelativeTo(null);
	
	load(classroom_in_ay_id);
	
	
	}
	
	private static void load(String classroom_in_ay_id) {
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * from schedule_class "
					+ "WHERE cia_id = '"+classroom_in_ay_id+"' ORDER BY start_time ASC");
			while(rs.next())
			{
			JLabel lblNewLabel_2 = new JLabel((rs.getString("start_time").substring(0, 5)+" - "+rs.getString("end_time").substring(0, 5)));
			lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 16));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setPreferredSize(new Dimension(140, 60));
			
			((JPanel)panel.getComponent(0)).add(lblNewLabel_2);
				
			
			panel.getComponent(0).revalidate();
			panel.getComponent(0).repaint();

			lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
			}
			for(int i  = 1; i< panel.getComponentCount(); i++) {
				for(int j = 1; j< ((JPanel)panel.getComponent(0)).getComponentCount(); j++) {
				JPanel lblNewLabel_2 = new JPanel();
				lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 16));
				lblNewLabel_2.setPreferredSize(new Dimension(140, 60));

				((JPanel)panel.getComponent(i)).add(lblNewLabel_2);
				lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
				panel.getComponent(i).revalidate();
				panel.getComponent(i).repaint();
				}
			}
			loadTeachers(classroom_in_ay_id);

			pause();
			resize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadTeachers(String classroom_in_ay_id) {
		panelTeacher.removeAll();
		List<String> t = new ArrayList();
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs= stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN teachers as t "
					+ "JOIN schedule_class as sc "
					+ "JOIN schedule_course as sco "
					+ "JOIN classrooms as c "
					+ "JOIN classrooms_in_ay as cia "
					+ "WHERE tic.is_active = 1 AND t.is_active = 1 AND c.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.is_active = 1 AND sc.cia_id = '"+classroom_in_ay_id+"'  "
							+ " AND sc.schedule_id = sco.schedule_id AND tic.tic_id = sco.tic_id AND sc.cia_id = cia.cia_id AND t.teacher_id = tic.teacher_id");
			while(rs.next())
			{
			if(!t.contains(rs.getString("tic.teacher_id"))) {
			
			CustomButton btnNewButton_21 = new CustomButton();
			btnNewButton_21.setName(rs.getString("tic.teacher_id"));
			btnNewButton_21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i< panelTeacher.getComponentCount(); i++) {
						panelTeacher.getComponent(i).setBackground(panelTeacher.getBackground());
						panelTeacher.getComponent(i).setForeground(new Color(211, 211, 211));
						((CustomButton) panelTeacher.getComponent(i)).setBorderColor(new Color(211, 211, 211));
					}
					btnNewButton_21.setBackground(Color.white);
					btnNewButton_21.setForeground(Color.black);
					btnNewButton_21.setBorderColor(Color.white);
					selectTeacherCourses(Login.selectedAcademicYearID, classroom_in_ay_id, btnNewButton_21.getName());
				}
			});

			btnNewButton_21.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton_21.setBackground(btnNewButton_21.getBackground().darker());
				}
				public void mouseExited(MouseEvent e) {
					btnNewButton_21.setBackground(btnNewButton_21.getBackground().brighter());
				}
			});
			btnNewButton_21.setRadius(15);
			btnNewButton_21.setFocusPainted(false);
			btnNewButton_21.setText(Teacher.getTeacherName(rs.getString("tic.teacher_id")));
			btnNewButton_21.setFont(new Font("Roboto", Font.PLAIN, 16));
			btnNewButton_21.setBackground(panelTeacher.getBackground());
			btnNewButton_21.setForeground(new Color(211, 211, 211));
			btnNewButton_21.setBorderColor(new Color(211, 211, 211));
			panelTeacher.add(btnNewButton_21);
			t.add(rs.getString("tic.teacher_id"));
			}

			loadCourses(rs.getString("tic.tic_id"), classroom_in_ay_id);
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
		
	}

	private static void selectTeacherCourses(String ay_id, String classroom_in_ay_id, String teacher_id) {

		for (int i = 1; i< panel.getComponentCount(); i++) {
			for(int j = 1; j< ((Container) panel.getComponent(i)).getComponentCount(); j++) {
				if(((Container) panel.getComponent(i)).getComponent(j) instanceof JLabel) {
					if(!((JComponent) ((Container) panel.getComponent(i)).getComponent(j)).getBorder().equals(null)) {
						((JComponent) ((Container) panel.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.white));
					}}
			}
		}
		
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from teachers_in_classrooms as tic "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses as co "
				+ "JOIN courses_in_classroom as cic "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ "AND cic.cia_id = '"+classroom_in_ay_id+"' AND cic.course_id = co.course_id AND co.is_active = 1 AND cic.is_active = 1");
		
		while(rs.next())
		{
			for (int i = 1; i< panel.getComponentCount(); i++) {
				for(int j = 1; j< ((Container) panel.getComponent(i)).getComponentCount(); j++) {
					if(((Container) panel.getComponent(i)).getComponent(j) instanceof JLabel) {
						if(((Container) panel.getComponent(i)).getComponent(j).getName().equals(rs.getString("tic.courses_in_classroom_id"))) {
							((JComponent) ((Container) panel.getComponent(i)).getComponent(j)).setBorder(new LineBorder(new Color(0, 255, 153),4));
							break;
						}
					}
				}
			}
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
		
	}

	private static void loadCourses(String teacher_id, String classroom_in_ay_id) {
		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs= stmt.executeQuery("select * from teachers_in_classrooms as tic "
					+ "JOIN schedule_class as sc "
					+ "JOIN schedule_course as sco "
					+ "JOIN courses_in_classroom AS cic "
					+ "JOIN classrooms as c "
					+ "JOIN courses as co "
					+ "JOIN classrooms_in_ay as cia "
					+ "WHERE tic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id AND sc.schedule_id = sco.schedule_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND sc.cia_id = '"+classroom_in_ay_id+"' AND tic.tic_id = '"+teacher_id+"' "
							+ " AND cic.course_id = co.course_id AND tic.tic_id = sco.tic_id AND sc.cia_id = cia.cia_id AND co.is_active = 1 AND cic.is_active = 1");
			while(rs.next())
			{
				for(int i = 0; i< ((Container) panel.getComponent(0)).getComponentCount(); i++) {
					if(((JLabel) ((Container) panel.getComponent(0)).getComponent(i)).getText()
							.equals((rs.getString("sc.start_time").substring(0, 5)+" - "+rs.getString("sc.end_time").substring(0, 5)))) {
				//System.out.println(TestBox.getShortName(rs.getString("cic.courses_in_classroom_id")));

						JLabel lblNewLabel_2 = new JLabel(TestBox.getShortName(rs.getString("cic.courses_in_classroom_id")));
						lblNewLabel_2.setName(rs.getString("cic.courses_in_classroom_id"));
						lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
						lblNewLabel_2.setForeground(new Color(255, 255, 255));
						lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_2.setPreferredSize(new Dimension(140, 60));
						lblNewLabel_2.setOpaque(true);

						((JPanel)panel.getComponent(rs.getInt("sc.day_of_the_week"))).add(lblNewLabel_2, i);
						((JPanel)panel.getComponent(rs.getInt("sc.day_of_the_week"))).remove(i+1);
						lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
						break;
			}}}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
	}
	
	public static void pause() {
		

		for(int i = 1; i<((Container) panel.getComponent(0)).getComponentCount()-1; i++) {
			if(!((JLabel) ((Container) panel.getComponent(0)).getComponent(i)).getText().equals("Pause") 
					&& !((JLabel) ((Container) panel.getComponent(0)).getComponent(i+1)).getText().equals("Pause") ) {
			List list1 = Arrays.asList(((JLabel) ((Container) panel.getComponent(0)).getComponent(i)).getText().split(" - "));
			List list2 = Arrays.asList(((JLabel) ((Container) panel.getComponent(0)).getComponent(i+1)).getText().split(" - "));
			
			 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			 Date d = null;
			 Date d1 = null;
			try {
				d = df.parse(list1.get(1).toString());
				d1 = df.parse(list2.get(0).toString());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					long diffMs = d1.getTime() - d.getTime();
					long diffSec = diffMs / 1000;
					long min = diffSec / 60;

					if(min>0) {
						
							JLabel lblNewLabel_2 = new JLabel("Pause");
							//lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
							lblNewLabel_2.setForeground(new Color(255, 255, 255));
							//lblNewLabel_2.setOpaque(true);
							lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
							lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_2.setPreferredSize(new Dimension(140, 30));

							((Container) panel.getComponent(0)).add(lblNewLabel_2, i+1);
							((Container) panel.getComponent(0)).revalidate();
							((Container) panel.getComponent(0)).repaint();
							
							for(int j = 1; j< panel.getComponentCount(); j++) {
							JPanel panel_1 = new JPanel();
						panel_1.setBorder(null);
						panel_1.setPreferredSize(new Dimension(140, 30));
						((Container) panel.getComponent(j)).add(panel_1, i+1);
						panel_1.setBackground(panel_1.getParent().getParent().getBackground());
							}
					}
}}
		}
	
	public static void resize() {
		int height = 0;
		int width = 0;
		
		for(int i = 0; i< ((Container) panel.getComponent(0)).getComponentCount(); i++) {
			height = height+ ((Container) panel.getComponent(0)).getComponent(i).getPreferredSize().height;
		}
		for(int i = 0; i< panel.getComponentCount(); i++) {
			width = width+ panel.getComponent(i).getPreferredSize().width;
		}
		
		for(int i = 0; i< panel.getComponentCount(); i++) {
			panel.getComponent(i).setPreferredSize(new Dimension(panel.getComponent(i).getPreferredSize().width, height));
		}
		panel.setPreferredSize(new Dimension(width, height));
		
	}
}
