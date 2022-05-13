package Schedule;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.LPane;
import app.NewTest;
import app.WrapLayout;
import Application.Class;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ScrollPaneUI;

import Application.ChooseColor;
import Application.ClassesAndCourses;
import Application.Home;
import Application.NewSession;
import Application.ResizeImages;
import Application.Schedule;
import Application.Teacher;
import Application.courseSelection;
import Schedule.CustomVerticalScrollBarUI;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import Class.NewCourse;
import Class.TestBox;
import CloudOperations.mysql;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.ScrollPaneConstants;

public class TeacherSchedule extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static Color backColor = new Color(240, 240, 240);
	public static Color foreColor = new Color(0, 0, 0);
	public static boolean isBackground;
	public static boolean backgroundisSelected = false;
	public static boolean foregroundisSelected = false;
	//public static int selectedSession;
	public static JPanel panel1;
	public static JPanel panel2;
	public static JPanel sessions;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel;
	private JLabel lblLundi;
	private JLabel lblMardi;
	private JLabel lblMercredi;
	private JLabel lblJeudi;
	private JLabel lblVendredi;
	private JLabel lblSamedi;
	public static Component selectedSession;
	
	public static Component selectedComponent;
	public static boolean isSelected = false;
	public static boolean SessionisSelected = false;
	public static List<Component> classBoxes = new ArrayList<Component>();
	private JLabel lblNewLabel_3;
	public static JLabel title;
	public static List<Component> redZones = new ArrayList<Component>();
	public static JButton ext;
	private JPanel panel_8;
	private JPanel panel_10;
	private JPanel panel_9;
	private JLabel lblNewLabel_4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSchedule frame = new TeacherSchedule("1", "2");
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
	public TeacherSchedule(String teacher_id, String ay_id) {
		setBackground(new Color(0, 0, 0));
		setPreferredSize(new Dimension(700,	700));
	setTitle("");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(100,100,screensize.width,screensize.height);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setMinimumSize(new Dimension(screensize.width*80/100,screensize.height*80/100));
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	setContentPane(contentPane);
	setLocationRelativeTo(null);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(60, 60, 60));
	panel.setPreferredSize(new Dimension(10, screensize.height*15/100));
	contentPane.add(panel, BorderLayout.NORTH);
	

	panel.setLayout(new BorderLayout(0, 0));
	panel_10 = new JPanel();
	panel_10.setBackground(panel.getBackground());
	panel_10.setPreferredSize(new Dimension(200, 10));
	panel.add(panel_10, BorderLayout.EAST);
	
	JButton btnSauvegarder = new JButton("Sauvegarder");
	btnSauvegarder.setBounds(40, 14, 120, 46);
	btnSauvegarder.setBorder(new LineBorder(Color.WHITE, 2));
	btnSauvegarder.setForeground(Color.WHITE);
	btnSauvegarder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			save(name);
		}
	});
	panel_10.setLayout(null);
	btnSauvegarder.setFont(new Font("Roboto", Font.PLAIN, 17));
	btnSauvegarder.setFocusPainted(false);
	panel_10.add(btnSauvegarder);
	btnSauvegarder.setBackground(panel.getBackground());
	

	btnSauvegarder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(btnSauvegarder.isEnabled()) {
				btnSauvegarder.setBackground(new Color(0, 255, 153));
				btnSauvegarder.setForeground(Color.black);
			}
		}@Override
		public void mouseExited(MouseEvent e) {
			btnSauvegarder.setBackground(panel.getBackground());
			btnSauvegarder.setForeground(Color.white);
		}
	});
	
	title = new JLabel("Horaire du professeur "+Teacher.getTeacherName(teacher_id));
	title.setPreferredSize(new Dimension(163, 50));
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Roboto", Font.BOLD, 30));
	panel.add(title, BorderLayout.NORTH);
	
	
	
	


	panel_9 = new JPanel();
	panel_9.setBackground(panel.getBackground());
	panel_9.setMinimumSize(new Dimension(200, 100));
	panel_9.setPreferredSize(new Dimension(200, 100));
	panel.add(panel_9, BorderLayout.WEST);
	
	ext = new JButton("Extraire");
	ext.setBounds(35, 16, 130, 42);
	ext.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\down.png"));
	ext.setForeground(Color.WHITE);
	ext.setFocusPainted(false);
	ext.setBorder(new LineBorder(new Color(255, 255, 255), 2));
	ext.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			extract();
		}
	});
	panel_9.setLayout(null);
	ext.setFont(new Font("Roboto", Font.PLAIN, 20));
	panel_9.add(ext);
	ext.setBackground(panel.getBackground());
	ext.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(ext.isEnabled()) {
			ext.setBackground(new Color(255, 102, 102).darker());
			}
		}@Override
		public void mouseExited(MouseEvent e) {
			ext.setBackground(panel.getBackground());
		}
	});
	
	
	panel_8 = new JPanel();
	panel_8.setBackground(panel.getBackground());
	panel.add(panel_8, BorderLayout.CENTER);
	panel_8.setLayout(new BorderLayout(0, 0));
	
	lblNewLabel_4 = new JLabel("<html><div style='text-align: center;'>Choisissez l' horaire du professeur cite ci-dessus. Vous pouvez selectionner les cours se trouvant a gauche de l'ecran et les placer sur l' horaire. Pour modifier l'emplacement d' un cours, selectionnez le et placez le a l'endroit voulu.</div></html>");
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setFont(new Font("Roboto", Font.PLAIN, 15));
	panel_8.add(lblNewLabel_4);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setPreferredSize(new Dimension(screensize.width*17/100, 2));
	contentPane.add(scrollPane, BorderLayout.WEST);
	scrollPane.getVerticalScrollBar().setUnitIncrement(7);
	scrollPane.setBackground(scrollPane.getParent().getBackground());
	
	scrollPane.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
	scrollPane.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
	
	panel2 = new JPanel();
	panel2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			deselect();
		}
	});
	panel2.setBackground(new Color(60, 60, 60));
	scrollPane.setViewportView(panel2);
	panel2.setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
	panel2.setPreferredSize(scrollPane.getPreferredSize());
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBackground(new Color(40, 40, 40));
	contentPane.add(scrollPane_1, BorderLayout.CENTER);
	scrollPane_1.setPreferredSize(new Dimension(screensize.width*84/100, screensize.height*85/100));
	scrollPane_1.getVerticalScrollBar().setUnitIncrement(3);
	scrollPane_1.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
	scrollPane_1.getHorizontalScrollBar().setUI(new CustomVerticalScrollBarUI());
	
	panel1 = new JPanel();
	panel1.setBackground(new Color(40, 40, 40));
	scrollPane_1.setViewportView(panel1);
	panel1.setPreferredSize(scrollPane_1.getPreferredSize());
	panel1.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));

	panel1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			deselect();
		}
	});
	sessions = new JPanel();
	sessions.setBorder(null);
	sessions.setBackground(new Color(40, 40, 40));
	panel1.add(sessions);
	sessions.setPreferredSize(new Dimension(174, 652));
	sessions.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblNewLabel = new JLabel("Heures des seances");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
	sessions.add(lblNewLabel);
	
	
	panel_2 = new JPanel();
	panel_2.setBorder(null);
	panel_2.setPreferredSize(new Dimension(160, 652));
	panel_2.setBackground(new Color(40, 40, 40));
	panel1.add(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblLundi = new JLabel("Lundi");
	lblLundi.setForeground(new Color(255, 255, 255));
	lblLundi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_2.add(lblLundi);
	
	panel_3 = new JPanel();
	panel_3.setBorder(null);
	panel_3.setPreferredSize(new Dimension(160, 652));
	panel_3.setBackground(new Color(40, 40, 40));
	panel1.add(panel_3);
	panel_3.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblMardi = new JLabel("Mardi");
	lblMardi.setForeground(new Color(255, 255, 255));
	lblMardi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_3.add(lblMardi);
	
	panel_4 = new JPanel();
	panel_4.setBorder(null);
	panel_4.setPreferredSize(new Dimension(160, 652));
	panel_4.setBackground(new Color(40, 40, 40));
	panel1.add(panel_4);
	panel_4.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblMercredi = new JLabel("Mercredi");
	lblMercredi.setForeground(new Color(255, 255, 255));
	lblMercredi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_4.add(lblMercredi);
	
	panel_5 = new JPanel();
	panel_5.setBorder(null);
	panel_5.setPreferredSize(new Dimension(160, 652));
	panel_5.setBackground(new Color(40, 40, 40));
	panel1.add(panel_5);
	panel_5.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblJeudi = new JLabel("Jeudi");
	lblJeudi.setForeground(new Color(255, 255, 255));
	lblJeudi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_5.add(lblJeudi);
	
	panel_6 = new JPanel();
	panel_6.setBorder(null);
	panel_6.setPreferredSize(new Dimension(160, 652));
	panel_6.setBackground(new Color(40, 40, 40));
	panel1.add(panel_6);
	panel_6.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblVendredi = new JLabel("Vendredi");
	lblVendredi.setForeground(new Color(255, 255, 255));
	lblVendredi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_6.add(lblVendredi);
	
	panel_7 = new JPanel();
	panel_7.setBorder(null);
	panel_7.setPreferredSize(new Dimension(160, 652));
	panel_7.setBackground(new Color(40, 40, 40));
	panel1.add(panel_7);
	panel_7.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 0));
	
	lblSamedi = new JLabel("Samedi");
	lblSamedi.setForeground(new Color(255, 255, 255));
	lblSamedi.setFont(new Font("Roboto", Font.PLAIN, 18));
	panel_7.add(lblSamedi);

	setLocationRelativeTo(null);
	
	load(teacher_id, ay_id);
	

	actions1(teacher_id, ay_id);
	
actions2(teacher_id, ay_id);
loadSchedule(teacher_id, ay_id);
deselect();
	}
	
	
	private JPanel cloneSwingComponent(JPanel c) {
	    try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        oos.writeObject(c);
	        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	        ObjectInputStream ois = new ObjectInputStream(bais);
	        return (JPanel) ois.readObject();
	    } catch (IOException|ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}
	
	public static void load(String teacher_id, String ay_id) {
		
		
							
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_in_classrooms as tic "
					+ "JOIN schedule_class AS sc "
					+ "JOIN classrooms as c "
					+ "JOIN classrooms_in_ay as cia "
					+ "JOIN courses_in_classroom as cic "
					+ "JOIN courses AS co "
					+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
							+ "AND sc.cia_id = cic.cia_id AND co.course_id = cic.course_id AND cic.is_active = 1 AND co.is_active = 1");
			while(rs.next())
			{
							JLabel lblNewLabel_2 = new JLabel((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")).replaceAll(":", "h"));
							lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
							lblNewLabel_2.setForeground(new Color(255, 255, 255));
							lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 18));
							lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_2.setPreferredSize(new Dimension(174, 60));
							
							
							boolean exists = false;
							for(int j = 1; j<sessions.getComponentCount(); j++) {
								if(((JLabel) sessions.getComponent(j)).getText().equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")).replaceAll(":", "h"))) {
									exists = true;
								}
							}
							if(!exists) {
							sessions.add(lblNewLabel_2);
							
							sessions.revalidate();
							sessions.repaint();

							lblNewLabel_2.setBackground(lblNewLabel_2.getParent().getBackground());
							}
							}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
loadBlocks(teacher_id, ay_id);
pause();
loadSessions(teacher_id, ay_id);

int height = 0;
for(int i = 0; i<sessions.getComponentCount(); i++) {
	height = height+sessions.getComponent(i).getPreferredSize().height;
}
for(int i = 0; i< panel1.getComponentCount(); i++) {
	panel1.getComponent(i).setPreferredSize(new Dimension(panel1.getComponent(i).getPreferredSize().width, height+50)); 
}
panel1.setPreferredSize(new Dimension(panel1.getPreferredSize().width, height+50));

}
	
public static void pause() {
		
		if(sessions.getComponentCount()>2) {
			for(int i = 1; i<sessions.getComponentCount(); i++) {
			if(((JLabel) sessions.getComponent(i)).getText().equals("Pause")) {
				sessions.remove(i);
				
				for(int j = 1; j< panel1.getComponentCount(); j++) {
					if(((JPanel)panel1.getComponent(j)).getComponentCount()>=i) {
					((JPanel)panel1.getComponent(j)).remove(i);
				}}
				
				panel1.revalidate();
				panel1.repaint();
			};
			
			}
			List<String> list = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();
			for(int i = 1; i<sessions.getComponentCount(); i++) {
				List s = Arrays.asList(((JLabel) sessions.getComponent(i)).getText().split("-"));
				list.add(s.get(0).toString().replaceAll("h", ""));
				list3.add(((JLabel) sessions.getComponent(i)).getText());
			}
			Collections.sort(list);
			
			for(int i = 0; i<list.toArray().length; i++) {
				for(int j = 0; j<list3.toArray().length; j++) {
					List s = Arrays.asList(list3.get(j).split("-"));
					if(s.get(0).toString().replaceAll("h", "").equals(list.get(i))) {
						list3.add(i, list3.get(j));
						list3.remove(j+1);
					}
			}}
			for(int i = 0; i<list3.toArray().length; i++) {
			((JLabel) sessions.getComponent(i+1)).setText(list3.get(i).toString());
			}
			for(int i = 1; i<sessions.getComponentCount(); i++) {
				
				if(i+1<sessions.getComponentCount()) {
				if(((Container) sessions.getComponent(i+1)) instanceof JLabel && !((JLabel) sessions.getComponent(i)).getText().equals("Pause") 
						&& !((JLabel) sessions.getComponent(i+1)).getText().equals("Pause") ) {
				List list1 = Arrays.asList(((JLabel) sessions.getComponent(i)).getText().replaceAll("h", ":").split("-"));
				List list2 = Arrays.asList(((JLabel) sessions.getComponent(i+1)).getText().replaceAll("h", ":").split("-"));
				
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
							//System.out.println(min+ "minutes");
							
								if(sessions.getComponentCount()>=i) {
								JLabel lblNewLabel_2 = new JLabel("Pause");
								lblNewLabel_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.white));
								lblNewLabel_2.setForeground(new Color(255, 255, 255));
								lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 25));
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setPreferredSize(new Dimension(174, 30));

								sessions.add(lblNewLabel_2, i+1);
								sessions.revalidate();
								sessions.repaint();
								}

								for(int j = 1; j< panel1.getComponentCount(); j++) {
									if(((Container) panel1.getComponent(j)).getComponentCount()>i) {

										JLabel lblNewLabel_2 = new JLabel();
										lblNewLabel_2.setBorder(null);
										lblNewLabel_2.setForeground(new Color(255, 255, 255));
										lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 25));
										lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_2.setPreferredSize(new Dimension(174, 30));
										((Container) panel1.getComponent(j)).add(lblNewLabel_2, i+1);
									}
								}
	}}}}}
	}

public static void loadBlocks(String teacher_id, String ay_id) {
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_in_classrooms as tic "
				+ "JOIN schedule_class AS sc "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses_in_classroom as cic "
				+ "JOIN courses AS co "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ "AND sc.cia_id = cic.cia_id AND co.course_id = cic.course_id AND cic.is_active = 1 AND co.is_active = 1");
		while(rs.next())
		{
								for(int m = 1; m<((Container) panel1.getComponent(0)).getComponentCount(); m++) {
								if(((JLabel) ((Container) panel1.getComponent(0)).getComponent(m)).getText().replaceAll("h", ":").equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")))) {
									for(int k = 0; k<m; k++) {
										if(((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponentCount()-1<m) {
									JPanel jp = new JPanel();
									jp.setPreferredSize(new Dimension(160, 60));
									jp.setBorder(new LineBorder(Color.lightGray));
									((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).add(jp);
									jp.setBackground(jp.getParent().getBackground());
									jp.setLayout(new BorderLayout(0, 0));
								}}}
							}
					}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

} 

public static void blocksPerClass(String classroom_id) {
	classBoxes.clear();
	List<Component> trueComponents = new ArrayList<Component>();
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from schedule_class AS sc "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				//+ "JOIN courses_in_classroom as cic "
				//+ "JOIN courses AS co "
				+ "WHERE c.is_active = 1 AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id "
						+ "AND sc.cia_id = cia.cia_id AND sc.cia_id = '"+classroom_id+"' "); //if not replace classroom_id with ay_id
		while(rs.next())
		{
	
		for(int m = 1; m<((Container) panel1.getComponent(0)).getComponentCount(); m++) {
				
				for(int i = 0; i<((Container) ((Container) panel1.getComponent(0)).getComponent(m)).getComponentCount(); i++) {
				if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(m)).getText().equals("Pause")) {
			if(((JLabel) ((Container) panel1.getComponent(0)).getComponent(m)).getText().replaceAll("h", ":").equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")))) {

					if(((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponentCount()>m) {
						trueComponents.add(((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(m));
						((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(m).setEnabled(true);
						((JComponent) ((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(m)).setBorder(new LineBorder(Color.white, 2));
						classBoxes.add(((JComponent) ((JPanel)panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(m)));
			}
			}
		}}}
	}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

for(int i = 1; i< panel1.getComponentCount(); i++) {
	for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
		if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause")) {
			if(!trueComponents.contains(((JPanel)panel1.getComponent(i)).getComponent(j))) {
	((JPanel)panel1.getComponent(i)).getComponent(j).setEnabled(false);
	((JComponent) ((JPanel)panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.gray));
}}}}
}

public static void loadSessions(String teacher_id, String ay_id) {

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from teachers_in_classrooms as tic "
				+ "JOIN courses_in_classroom AS cic "
				+ "JOIN classrooms as c "
				+ "JOIN courses as co "
				+ "JOIN classrooms_in_ay as cia "
				+ "WHERE cic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id  AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND c.classroom_id = cia.classroom_id AND cia.is_active = 1 AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ " AND tic.courses_in_classroom_id = cic.courses_in_classroom_id AND cic.course_id = co.course_id AND co.is_active = 1");
		while(rs.next())
		{
				JPanel jp = new JPanel();
				jp.setPreferredSize(new Dimension(210, 300));
				jp.setLayout(new WrapLayout(WrapLayout.CENTER, 5, 5));
				jp.setBackground(new Color(40, 40, 40));
				jp.setBorder(new LineBorder(Color.LIGHT_GRAY));
				panel2.add(jp);
				
				JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>"+rs.getString("cic.cia_id")+"</div></html>");
				lblNewLabel.setName(rs.getString("cic.cia_id"));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setPreferredSize(new Dimension(220, 30));
				lblNewLabel.setFont(new Font("ROBOTO", Font.PLAIN, 15));
				lblNewLabel.setForeground(Color.WHITE);
				jp.add(lblNewLabel);
				panel2.revalidate();
				panel2.repaint();
				
			
				try {
					Statement stmt1= mysql.con.createStatement();

					ResultSet rs1=stmt1.executeQuery("select * from teachers_in_classrooms as tic "
							+ "JOIN courses_in_classroom AS cic "
							+ "JOIN classrooms as c "
							+ "JOIN courses as co "
							+ "JOIN classrooms_in_ay as cia "
							+ "WHERE cic.is_active = 1 AND cic.courses_in_classroom_id = tic.courses_in_classroom_id  AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND c.classroom_id = cia.classroom_id AND cia.is_active = 1 AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
									+ "AND cic.cia_id = '"+rs.getString("cic.cia_id")+"' AND tic.courses_in_classroom_id = cic.courses_in_classroom_id AND cic.course_id = co.course_id AND co.is_active = 1");
					while(rs1.next())
					{
							
						JPanel panel = new JPanel();
						panel.setPreferredSize(new Dimension(200, 70));
						panel.setBackground(new Color(60, 60, 60));
						panel.setBorder(new LineBorder(Color.white));
						jp.add(panel);
						panel.setLayout(new BorderLayout(0, 0));
						
						JLabel lblNewLabel_1 = new JLabel(rs.getString("cic.cia_id"));
						lblNewLabel_1.setPreferredSize(new Dimension(40, 14));
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						panel.add(lblNewLabel_1, BorderLayout.WEST);
						lblNewLabel_1.setForeground(Color.white);
						
						JPanel panel_1 = new JPanel();
						panel.add(panel_1, BorderLayout.CENTER);
						panel_1.setLayout(new BorderLayout(0, 0));
						panel_1.setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));
						
						JPanel panel_11 = new JPanel();
						panel_1.add(panel_11, BorderLayout.CENTER);
						panel_11.setLayout(new BorderLayout(0, 0));
						JLabel lblNewLabel1 = new JLabel("<html><div style='text-align: center;'>"+TestBox.getShortName(rs.getString("cic.courses_in_classroom_id"))+"</div></html>");
						lblNewLabel1.setName(rs.getString("cic.courses_in_classroom_id"));
						lblNewLabel1.setFont(new Font("Roboto", Font.BOLD, 18));
						lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
						panel_11.add(lblNewLabel1, BorderLayout.CENTER);
						lblNewLabel1.setForeground(Home.getClassColors(rs.getString("cic.cia_id")).get(1));
						panel_11.setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));
						
						JPanel panel1 = new JPanel();
						panel1.setForeground(new Color(255, 255, 255));
						panel1.setBackground(new Color(0, 0, 255));
						panel_1.add(panel1, BorderLayout.SOUTH);
						panel1.setPreferredSize(new Dimension(10, 20));
						panel1.setLayout(new BorderLayout(0, 0));
						panel1.setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(1));
						panel1.setVisible(false);
						
						JLabel lblNewLabel_11 = new JLabel(rs.getString("cic.cia_id"));
						lblNewLabel_11.setPreferredSize(new Dimension(113, 10));
						lblNewLabel_11.setForeground(new Color(255, 255, 255));
						lblNewLabel_11.setFont(new Font("Roboto", Font.PLAIN, 11));
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel1.add(lblNewLabel_11);
						lblNewLabel_11.setForeground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));

						
						//ClassesAndCourses.checkContinuation();
						panel2.revalidate();
						panel2.repaint();
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				resize(jp);
			}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}


/*
 * public static void replaceExternalCourse(Component selected, Component
 * destination) {
 * 
 * 
 * int i1 = 0; int j1 = 0; int i2 = 0; int j2 = 0;
 * 
 * 
 * save(title.getText().replaceAll("Horaire du professeur ", "")); for(int i =
 * 1; i< panel1.getComponentCount(); i++) { for(int j = 1; j< ((Container)
 * panel1.getComponent(i)).getComponentCount(); j++) { if(((Container)
 * panel1.getComponent(i)).getComponent(j).equals(selected)) { i1 = i; j1 = j; }
 * if(((Container) panel1.getComponent(i)).getComponent(j).equals(destination))
 * { i2 = i; j2 = j; } } }
 * 
 * File file = new
 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/Teachers.txt"
 * );
 * 
 * try {
 * 
 * FileReader fr = new FileReader(file);
 * 
 * BufferedReader br = new BufferedReader(fr); Object[] lines =
 * Home.loadActiveProfs(file.getPath());
 * 
 * for(int i = 0; i<lines.length; i++) { List l =
 * Arrays.asList(lines[i].toString().split("//"));
 * 
 * List <String>comp = new ArrayList<String>(); List <String>comp2 = new
 * ArrayList<String>();
 * 
 * File file1 = new
 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).
 * toString()+"/Schedule.txt");
 * 
 * try {
 * 
 * FileReader fr1 = new FileReader(file1);
 * 
 * BufferedReader br1 = new BufferedReader(fr1); Object[] lines1 =
 * br1.lines().toArray();
 * 
 * 
 * for(int j = 0; j< lines1.length; j++) { comp.add(lines1[j].toString()); }
 * 
 * for(int j = 0; j< lines1.length; j++) { comp2.add(lines1[j].toString()); }
 * 
 * for(int j = 0; j< comp.toArray().length; j++) { List l1 =
 * Arrays.asList(comp.get(j).toString().split("//")); if(destination instanceof
 * JButton) { if(((AbstractButton)
 * destination).getText().replaceAll("<html><div style='text-align: center;'>",
 * "").replaceAll("</div></html>",
 * "").replaceAll("Occup\u00E9e par le professeur de ",
 * "").equals(l1.get(3).toString())) { if(i2 ==
 * Integer.parseInt(l1.get(0).toString())) {
 * if(l1.get(1).toString().equals(((JLabel) ((Container)
 * panel1.getComponent(0)).getComponent(j2)).getText().replaceAll("h", ":"))) {
 * String s = i1+"//"+((JLabel) ((Container)
 * panel1.getComponent(0)).getComponent(j1)).getText().replaceAll("h",
 * ":")+"//"+l1.get(2).toString()+"//"+l1.get(3).toString(); comp.remove(j);
 * comp.add(s); //System.out.println("done");
 * 
 * Collections.sort(comp);
 * 
 * 
 * 
 * 
 * 
 * File file11 = new
 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).
 * toString()+"/Schedule.txt"); if(file11.exists()) { file11.delete(); }
 * 
 * try { file11.createNewFile(); PrintWriter pw = new PrintWriter(file11);
 * 
 * for(int j11 = 0;j11<comp.toArray().length;j11++) {
 * pw.println((String)comp.get(j11)); };
 * 
 * pw.close();
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace();
 * 
 * }
 * 
 * } }} }}
 * 
 * for(int j = 0; j< comp2.toArray().length; j++) { List l1 =
 * Arrays.asList(comp2.get(j).toString().split("//")); if((((JLabel)
 * ((Container) ((Container) ((Container)
 * selected).getComponent(0)).getComponent(0)).getComponent(0))).getText().
 * replaceAll("<html><div style='text-align: center;'>",
 * "").replaceAll("</div></html>", "").equals(l1.get(3).toString())) { if(i1 ==
 * Integer.parseInt(l1.get(0).toString())) {
 * if(l1.get(1).toString().equals(((JLabel) ((Container)
 * panel1.getComponent(0)).getComponent(j1)).getText().replaceAll("h", ":"))) {
 * String s = i2+"//"+((JLabel) ((Container)
 * panel1.getComponent(0)).getComponent(j2)).getText().replaceAll("h",
 * ":")+"//"+l1.get(2).toString()+"//"+l1.get(3).toString(); comp2.remove(j);
 * comp2.add(s); // System.out.println("done");
 * 
 * Collections.sort(comp2);
 * 
 * 
 * 
 * File file111 = new
 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+l.get(0).
 * toString()+"/Schedule.txt"); if(file111.exists()) { file111.delete(); }
 * 
 * try { file111.createNewFile(); PrintWriter pw = new PrintWriter(file111);
 * 
 * for(int j11 = 0;j11<comp2.toArray().length;j11++) {
 * pw.println((String)comp2.get(j11)); };
 * 
 * pw.close();
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace();
 * 
 * } } }} }
 * 
 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * }
 * 
 * 
 * 
 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * 
 * }
 * 
 */

public static void resize(Component jp) {

	int height = 0;
	int count = 0;
	for(int j = 0; j< ((Container) jp).getComponentCount(); j++) {
		if(((Container) jp).getComponent(j).isVisible()) {
		height = height+((Container) jp).getComponent(j).getPreferredSize().height;
		count++;
	}}
	jp.setPreferredSize(new Dimension(jp.getPreferredSize().width,
			height+((count+1)*5)+5));
	
	int height1 = 0;
	for(int i = 0; i<panel2.getComponentCount(); i++) {
		height1 = height1+panel2.getComponent(i).getPreferredSize().height;
	}
		panel2.setPreferredSize(new Dimension(panel2.getPreferredSize().width, height1+(((panel2).getComponentCount()+1)*5)+5));
	panel2.revalidate();
	panel2.repaint();
}
public static void deselect() {
	
	isSelected = false;
	SessionisSelected = false;
	selectedComponent = null;
	selectedSession = null;

	ext.setEnabled(false);


	if(redZones.toArray().length>0) {
for(int i = 1; i< panel1.getComponentCount(); i++) {
	for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
		if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause")) {
	if(((Container) panel1.getComponent(i)).getComponent(j) instanceof JButton) {
		((Container) panel1.getComponent(i)).remove(j);
		((Container) panel1.getComponent(i)).add(redZones.get(0), j);
		redZones.remove(0);
		panel1.revalidate();
		panel1.repaint();
	}	}
	}
	}}
for(int i = 0; i<panel2.getComponentCount(); i++) {
	for(int j = 1; j<((Container) panel2.getComponent(i)).getComponentCount(); j++) {
		((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).setBorder(new LineBorder(Color.white));
		((JComponent) panel2.getComponent(i)).setBorder(new LineBorder(Color.lightGray));
	}
	}

		

for(int i = 1; i< panel1.getComponentCount(); i++) {
	for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
		if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause")) {
		((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.lightGray));
		if(((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).getComponentCount()>0) {
		((Container) ((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).getComponent(0)).getComponent(2).setVisible(false);
		}
		}
	}}


panel1.revalidate();
panel1.repaint();
panel2.revalidate();
panel2.repaint();
	}


	/*
	 * public static void save(String name) {
	 * 
	 * List <String>comp = new ArrayList<String>();
	 * 
	 * for(int i = 1; i< panel1.getComponentCount(); i++) { for(int j = 1; j<
	 * ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
	 * if(!((JLabel) ((Container)
	 * panel1.getComponent(0)).getComponent(j)).getText().equals("Pause")) {
	 * if(((JComponent) ((Container)
	 * panel1.getComponent(i)).getComponent(j)).getComponentCount()>0) {
	 * comp.add(i+"//"+((JLabel) ((Container)
	 * panel1.getComponent(0)).getComponent(j)).getText().replaceAll("h", ":")+"//"+
	 * ((JLabel) ((Container) (((Container) (((Container) ((Container)
	 * panel1.getComponent(i)).getComponent(j)).getComponent(0))).getComponent(1))).
	 * getComponent(0)).getText() +"//"+ ((JLabel) ((Container) (((Container)
	 * (((Container) ((Container)
	 * panel1.getComponent(i)).getComponent(j)).getComponent(0))).getComponent(0))).
	 * getComponent(0)).getText().
	 * replaceAll("<html><div style='text-align: center;'>",
	 * "").replaceAll("</div></html>", "")); }}
	 * 
	 * }
	 * 
	 * File file1 = new
	 * File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.
	 * selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Teachers/"+name+
	 * "/Schedule.txt");
	 * 
	 * if(file1.exists()) { file1.delete(); }
	 * 
	 * try { file1.createNewFile(); PrintWriter pw = new PrintWriter(file1);
	 * 
	 * for(int j = 0;j<comp.toArray().length;j++) { pw.println((String)comp.get(j));
	 * };
	 * 
	 * pw.close();
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * 
	 * } } }
	 */
public static void loadSchedule(String teacher_id, String ay_id) {

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_in_classrooms as tic "
				+ "JOIN schedule_class AS sc "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses_in_classroom as cic "
				+ "JOIN courses AS co "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ "AND sc.cia_id = cic.cia_id AND co.course_id = cic.course_id AND cic.is_active = 1 AND co.is_active = 1");
		while(rs.next())
		{
			for(int j = 1; j< ((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponentCount(); j++) {
				if(((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().replaceAll("h", ":").equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")))) {
			Session session = new Session();
			((Container) session.getComponent(1)).getComponent(1).setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));
			((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0).setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));
			((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setBackground(Home.getClassColors(rs.getString("cic.cia_id")).get(1));
			((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setVisible(false);
			((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0).setForeground(Home.getClassColors(rs.getString("cic.cia_id")).get(1));
			((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0).setForeground(Home.getClassColors(rs.getString("cic.cia_id")).get(0));
			((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0)).setText(TestBox.getShortName(rs.getString("cic.courses_in_classroom_id")));
			((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0)).setText(Class.getClassName(rs.getString("cic.cia_id")));
			((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0)).setName(rs.getString("cic.cia_id"));
			((JComponent) ((Container) session.getComponent(1)).getComponent(1)).setBorder(new LineBorder(((JPanel)((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(j)).getBackground() ,4));
			((Container)((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(j)).add(((Container) session.getComponent(1)).getComponent(1));
			session.inverse.setVisible(false);
		
				for(int m = 0; m< panel2.getComponentCount(); m++) {
					if(((JLabel) ((Container) panel2.getComponent(m)).getComponent(0)).getName().equals(rs.getString("cic.cia_id"))) {
						for(int k = 1; k< ((Container) panel2.getComponent(m)).getComponentCount(); k++) {
							if(((JLabel) ((Container) ((Container) ((Container) ((Container) panel2.getComponent(m)).getComponent(k)).getComponent(1)).getComponent(0)).getComponent(0)).getName().equals(rs.getString("cic.courses_in_classroom_id"))) {
								((JLabel) ((Container) ((Container) panel2.getComponent(m)).getComponent(k)).getComponent(0)).setText(Integer.parseInt(((JLabel) ((Container) ((Container) panel2.getComponent(m)).getComponent(k)).getComponent(0)).getText())-1+"");
							if(((JLabel) ((Container) ((Container) panel2.getComponent(m)).getComponent(k)).getComponent(0)).getText().equals("0")) {
								((Container) ((Container) panel2.getComponent(m)).getComponent(k)).setVisible(false);
								resize((Container) ((Container) panel2.getComponent(m)));
							}
							
							}}
						}
					}
				}
				}}
			actions(teacher_id, ay_id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
}
}


public static void drawZones(String teacher_id, String classroom_in_ay_id, String ay_id) {
	loadBlocks(teacher_id, ay_id);
	blocksPerClass(classroom_in_ay_id);
	redZones.clear();
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_in_classrooms as tic "
				+ "JOIN schedule_class AS sc "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses_in_classroom as cic "
				+ "JOIN courses AS co "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ "AND sc.cia_id = cic.cia_id AND cic.cia_id = '"+classroom_in_ay_id+"'AND co.course_id = cic.course_id AND cic.is_active = 1 AND co.is_active = 1");
		while(rs.next())
		{
						
							for(int k = 1; k< ((Container) panel1.getComponent(0)).getComponentCount(); k++) {
								if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
						if(((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().replaceAll("h", ":").equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")))) {
							if(((Container) ((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(k)).getComponentCount()==0) {
							JButton lblNewLabel_3 = new JButton("<html><div style='text-align: center;'>Occup\u00E9e par le professeur de "+TestBox.getShortName(rs.getString("cic.courses_in_classroom_id"))+"</div></html>");
							lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 14));
							lblNewLabel_3.setBackground(new Color(255, 208, 223));
							lblNewLabel_3.setOpaque(true);
							lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_3.setPreferredSize(new Dimension(160, 60));
							lblNewLabel_3.setFocusPainted(false);
							lblNewLabel_3.setBorder(new LineBorder(Color.white));
							redZones.add(((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(k));
					((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).add(lblNewLabel_3, k);
					((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).remove(k+1);
					panel1.revalidate();
					panel1.repaint();
					actions(teacher_id, ay_id);
					
					break;
					
							}}
						}}
						
					}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
}
	//pause();
}


public static List<Component> getRedAreas(String teacher_id, String classroom_in_ay_id, String ay_id) {
	
	List<Component> areas = new ArrayList();
	//loadBlocks(name);
	//blocksPerClass(className);
	
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_in_classrooms as tic "
				+ "JOIN schedule_class AS sc "
				+ "JOIN classrooms as c "
				+ "JOIN classrooms_in_ay as cia "
				+ "JOIN courses_in_classroom as cic "
				+ "JOIN courses AS co "
				+ "WHERE cic.courses_in_classroom_id = tic.courses_in_classroom_id AND c.is_active = 1 AND cia.cia_id = cic.cia_id AND cia.is_active = 1 AND c.classroom_id = cia.classroom_id AND cia.ay_id = '"+ay_id+"' AND tic.teacher_id = '"+teacher_id+"' "
						+ "AND sc.cia_id = cic.cia_id AND cic.cia_id = '"+classroom_in_ay_id+"'AND co.course_id = cic.course_id AND cic.is_active = 1 AND co.is_active = 1");
		while(rs.next())
		{
						
							for(int k = 1; k< ((Container) panel1.getComponent(0)).getComponentCount(); k++) {
								if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
						if(((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().replaceAll("h", ":").equals((rs.getString("sc.start_time")+":"+rs.getString("sc.end_time")))) {
							areas.add(((Container) panel1.getComponent(Integer.parseInt(rs.getString("sc.day_of_the_week")))).getComponent(k));
					
				//	break;
					
							}}
						}
						
					}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
}
	//pause();
	return areas; 
}

public static void extract() {
		for(int i = 0; i< panel2.getComponentCount(); i++) {
			if(SessionisSelected) {
			if(((JLabel) ((Container) panel2.getComponent(i)).getComponent(0)).getName().equals(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName())) {
				for(int j = 1; j< ((Container) panel2.getComponent(i)).getComponentCount(); j++) {
					if(SessionisSelected) {
						//here is the problem
					if(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(0))).getComponent(0)).getName().equals(
							((JLabel) ((Container) ((Container) ((Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(1)).getComponent(0)).getComponent(0)).getName())) {
					
					if(!((Container) ((Container) panel2.getComponent(i)).getComponent(j)).isVisible()) {
						((Container) ((Container) panel2.getComponent(i)).getComponent(j)).setVisible(true);

						resize(((Container) panel2.getComponent(i)));
						if(((JLabel) ((Container) (Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(0)).getText().equals("0")) {
							((JLabel) (Container) ((Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(0)).setText("1");
						}
					}else {
						((JLabel) (Container) ((Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(0)).setText(Integer.parseInt(((JLabel) (Container) ((Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(0)).getText())+1+"");
					}
					((JPanel)selectedSession).remove(0);
					deselect();
					}
					}
			}}}}
}


public static void actions2(String teacher_id, String ay_id) {
	
	
for(int i = 0; i<panel2.getComponentCount(); i++) {
	for(int j = 1; j<((Container) panel2.getComponent(i)).getComponentCount(); j++) {
int s = i;
int t = j;
		((Container) ((Container) panel2.getComponent(i)).getComponent(j)).getComponent(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

for(int i = 0; i<panel2.getComponentCount(); i++) {
	for(int j = 1; j<((Container) panel2.getComponent(i)).getComponentCount(); j++) {
		if(!((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).equals(selectedComponent)) {
		((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).setBorder(new LineBorder(Color.white));
		((JComponent) panel2.getComponent(i)).setBorder(new LineBorder(Color.lightGray));
	}}
	}
((JComponent) ((Container) ((Container) panel2.getComponent(s)).getComponent(t))).setBorder(new LineBorder(new Color(20, 148, 198).brighter(), 4));
panel2.revalidate();
panel2.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {

for(int i = 0; i<panel2.getComponentCount(); i++) {
	for(int j = 1; j<((Container) panel2.getComponent(i)).getComponentCount(); j++) {
		if(!((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).equals(selectedComponent)) {
		((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).setBorder(new LineBorder(Color.white));
		((JComponent) panel2.getComponent(i)).setBorder(new LineBorder(Color.lightGray));
	}}
	}
panel2.revalidate();
panel2.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				deselect();
				
				
				for(int i = 0; i<panel2.getComponentCount(); i++) {
					for(int j = 1; j<((Container) panel2.getComponent(i)).getComponentCount(); j++) {
						((JComponent) ((Container) ((Container) panel2.getComponent(i)).getComponent(j))).setBorder(new LineBorder(Color.white));
					}}
				((JComponent) ((Container) ((Container) panel2.getComponent(s)).getComponent(t))).setBorder(new LineBorder(new Color(0, 255, 153),4));
				
				for(int i = 1; i< panel1.getComponentCount(); i++) {
					for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {

						((Container) panel1.getComponent(i)).getComponent(j).addMouseListener(new MouseAdapter() {

							
					});
			}}

				selectedComponent = ((Container) ((Container) panel2.getComponent(s)).getComponent(t));
				blocksPerClass(((JLabel) ((Container) (((Container) (((Container) selectedComponent).getComponent(1))).getComponent(1))).getComponent(0)).getName());
				drawZones(teacher_id, ((JLabel) ((Container) (((Container) (((Container) selectedComponent).getComponent(1))).getComponent(1))).getComponent(0)).getName(), ay_id);
				isSelected = true;
				
			actions(teacher_id, ay_id);}
		});
	
		panel1.revalidate();
		panel1.repaint();
		panel2.revalidate();
		panel2.repaint();
	
}}
}

public static void actions1(String teacher_id, String ay_id) {
	
	for(int i = 1; i< panel1.getComponentCount(); i++) {
		for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
			int m = i;
			int k = j;

			((Container) panel1.getComponent(i)).getComponent(j).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					if(!isSelected && !SessionisSelected) {
					for(int i = 1; i< panel1.getComponentCount(); i++) {
						for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
						if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause") && !((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).equals(selectedSession)) {
						((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.lightGray));
					}
						}}

					if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel){
					if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0){
						if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause") && !((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).equals(selectedSession)) {
						((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(0, 255, 153),2));
						 (((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k))).getComponent(0))).getComponent(1)).setVisible(true);
					}
					}}
					}
					
				}
				@Override
				public void mouseExited(MouseEvent e) {

					if(!isSelected && !SessionisSelected) {
					for(int i = 1; i< panel1.getComponentCount(); i++) {
						for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
							if(((Container) ((Container) panel1.getComponent(i)).getComponent(j)) instanceof JPanel){
							if(((Container) ((Container) panel1.getComponent(i)).getComponent(j)).getComponentCount()>0){
						if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause") && !((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).equals(selectedSession)) {
						((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.lightGray));
						(((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(i)).getComponent(j))).getComponent(0))).getComponent(1)).setVisible(false);
					}
						}}}
					}
				}}
				
				@Override
				public void mouseClicked(MouseEvent e) {

					if(!isSelected && !SessionisSelected) {
						//deselect();
					if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0){
						if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
						selectedSession = ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k));
						SessionisSelected = true;
						
						blocksPerClass(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName());
						drawZones(teacher_id, ((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName(), ay_id);

						((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(0, 255, 153),4));
					}
					}
				}
					if((boolean) ((Container) panel1.getComponent(m)).getComponent(k).isEnabled()) {
							if(SessionisSelected) {

							((Container) ((Container) selectedSession).getComponent(0)).getComponent(1).setVisible(false);
							((Container) ((Container) selectedSession).getComponent(0)).revalidate();
							((Container) ((Container) selectedSession).getComponent(0)).repaint();

						if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0){
			((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).setVisible(false);
				
				deselect();
				ext.setEnabled(true);
							if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
							selectedSession = ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k));
							SessionisSelected = true;
							
							blocksPerClass(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName());
							drawZones(teacher_id, ((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName(),  ay_id);

							((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(0, 255, 153),4));
						}
							}else {
						}
						}}
						

					//isSelected = true;
				}
				
			});
			
			
		}}}


public static void actions(String teacher_id, String ay_id) {
	for(int i = 1; i< panel1.getComponentCount(); i++) {

		for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
			int m = i;
			int k = j;
			((Container) panel1.getComponent(i)).getComponent(j).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					if(isSelected  || SessionisSelected) {
					for(int i = 1; i< panel1.getComponentCount(); i++) {
						for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
							if(((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).isEnabled()) {
							if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause") && !((Container) ((Container) panel1.getComponent(i)).getComponent(j)).equals(selectedSession)) {
									if(((Container)((Container) panel1.getComponent(i)).getComponent(j)).getComponentCount()==0) {
							((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.white,2));
							}}
						}}}
					if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")&& !((Container) ((Container) panel1.getComponent(m)).getComponent(k)).equals(selectedSession)) {

						if(((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).isEnabled()) {
							if(((Container)((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()==0) {
								if(((Container)((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel) {
								if(((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).isEnabled()) {
					((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(0, 255, 153), 5));
								}}
					}else {
						if(SessionisSelected) {
						selectedSession.setEnabled(true);
						if(SessionisSelected && !((JLabel) ((Container) (((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k))).getComponent(0))).getComponent(1))).getComponent(0)).getName().equals
								(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName())) {
							blocksPerClass(((JLabel) ((Container) (((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k))).getComponent(0))).getComponent(1))).getComponent(0)).getName());
							}
						((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(255, 102, 102), 3));
						((JComponent) selectedSession).setBorder(new LineBorder(new Color(0, 255, 153), 5));
						}
						if(isSelected) {
								((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(255, 102, 102), 3));
							
						}
						if(SessionisSelected) {
							if(selectedSession.isEnabled()) {
								if(!getRedAreas(teacher_id, ((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName(),  ay_id).contains(((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)))
									&& 	!getRedAreas(teacher_id, ((JLabel) ((Container) (((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k))).getComponent(0))).getComponent(1))).getComponent(0)).getName(),  ay_id).contains(selectedSession)
						) {
							((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).setVisible(true);
							}}
							((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(255, 102, 102), 3));
							
							((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel){
									if(((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0) {
										if(selectedSession.isEnabled()) {
									((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).setVisible(true);
									((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).setBackground(new Color(60, 60, 60));
									
									}	((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).setBorder(new LineBorder(new Color(20, 148, 198), 3));
									
									}}
								}@Override
								public void mouseExited(MouseEvent e) {
									if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel){
										if(((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0) {
									((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(2).setBackground(new Color(40, 40, 40));
									}}
								}
								@Override
								public void mouseClicked(MouseEvent e) {
									if(SessionisSelected) {
										if(((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0) {
									Session session = new Session();
									((Container) session.getComponent(1)).getComponent(1).setBackground(((Container) selectedSession).getComponent(0).getBackground());
									((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0).setBackground(((Container) ((Container) selectedSession).getComponent(0)).getComponent(0).getBackground());
									((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setBackground(((Container) ((Container) selectedSession).getComponent(0)).getComponent(1).getBackground());
									((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setVisible(false);
									((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0).setForeground(((Container) ((Container) (((Container) selectedSession).getComponent(0))).getComponent(0)).getComponent(0).getForeground());
									((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0).setForeground(((Container) ((Container) (((Container) selectedSession).getComponent(0))).getComponent(1)).getComponent(0).getForeground());
									((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(0))).getComponent(0)).getText());
									((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getText());
									((JComponent) ((Container) session.getComponent(1)).getComponent(1)).setBorder(new LineBorder(((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).getBackground() ,4));
									session.inverse.setVisible(false);
									
									Session session1 = new Session();
									((Container) session1.getComponent(1)).getComponent(1).setBackground(((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0).getBackground());
									((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(0).setBackground(((Container) ((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(0).getBackground());
									((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(1).setBackground(((Container) ((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0)).getComponent(1).getBackground());
									((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(1).setVisible(false);
									((Container) ((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0).setForeground(((Container) ((Container) (((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0))).getComponent(0)).getComponent(0).getForeground());
									((Container) ((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0).setForeground(((Container) ((Container) (((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0))).getComponent(1)).getComponent(0).getForeground());
									((JLabel) ((Container) ((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0))).getComponent(0))).getComponent(0)).getText());
									((JLabel) ((Container) ((Container) ((Container) session1.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponent(0))).getComponent(1))).getComponent(0)).getText());
									((JComponent) ((Container) session1.getComponent(1)).getComponent(1)).setBorder(new LineBorder(((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).getBackground() ,4));

									

									((JPanel) ((Container) panel1.getComponent(m)).getComponent(k)).remove(0);
									((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).add(((Container) session.getComponent(1)).getComponent(1));
									
									((JPanel)selectedSession).remove(0);
									((JPanel)selectedSession).add(((Container) session1.getComponent(1)).getComponent(1));
									session1.inverse.setVisible(false);
									
									panel1.revalidate();
									panel1.repaint();

									deselect();
									}}}
							});
						}
						
					}}}
						}}
				@Override
				public void mouseExited(MouseEvent e) {
					for(int i = 1; i< panel1.getComponentCount(); i++) {

						if(isSelected  || SessionisSelected) {
						for(int j = 1; j< ((Container) panel1.getComponent(i)).getComponentCount(); j++) {
							if(((Container) ((Container) panel1.getComponent(i)).getComponent(j)) instanceof JPanel){
							if(((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).isEnabled()) {
							if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(j)).getText().equals("Pause")&& !((Container) ((Container) panel1.getComponent(i)).getComponent(j)).equals(selectedSession)) {
							((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).setBorder(new LineBorder(Color.white,2));
							if(((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).getComponentCount()>0 && SessionisSelected) {
							((Container) ((JComponent) ((Container) panel1.getComponent(i)).getComponent(j)).getComponent(0)).getComponent(2).setVisible(false);
							}}
						}}
						}}
					}

					if(SessionisSelected && ((Container) ((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()>0  && !((JLabel) ((Container) (((Container) (((Container) ((JComponent) ((Container) panel1.getComponent(m)).getComponent(k))).getComponent(0))).getComponent(1))).getComponent(0)).getName().equals
							(((JLabel) ((Container) (((Container) (((Container) selectedSession).getComponent(0))).getComponent(1))).getComponent(0)).getName())
							) {
						if(((Container) ((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel){
						blocksPerClass(((JLabel) ((Container) ((((Container) ((((Container) (selectedSession)).getComponent(0)))).getComponent(1)))).getComponent(0)).getName());

						((JComponent) selectedSession).setBorder(new LineBorder(new Color(0, 255, 153), 5));
						}}
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(((JComponent) ((Container) panel1.getComponent(m)).getComponent(k)).isEnabled()) {
					if(isSelected) {
					if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
						if(((Container)((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()==0) {
							if(((Container)((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel) {
					Session session = new Session();
					((Container) session.getComponent(1)).getComponent(1).setBackground(((Container) selectedComponent).getComponent(1).getBackground());
					((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0).setBackground(((Container) ((Container) selectedComponent).getComponent(1)).getComponent(0).getBackground());
					((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setBackground(((Container) ((Container) selectedComponent).getComponent(1)).getComponent(1).getBackground());
					((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1).setVisible(false);
					((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0).setForeground(((Container) ((Container) (((Container) selectedComponent).getComponent(1))).getComponent(0)).getComponent(0).getForeground());
					((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0).setForeground(((Container) ((Container) (((Container) selectedComponent).getComponent(1))).getComponent(1)).getComponent(0).getForeground());
					((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(0)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) selectedComponent).getComponent(1))).getComponent(0))).getComponent(0)).getText());
					((JLabel) ((Container) ((Container) ((Container) session.getComponent(1)).getComponent(1)).getComponent(1)).getComponent(0)).setText(((JLabel) ((Container) (((Container) (((Container) selectedComponent).getComponent(1))).getComponent(1))).getComponent(0)).getText());
					((JComponent) ((Container) session.getComponent(1)).getComponent(1)).setBorder(new LineBorder(((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).getBackground() ,4));
					((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).add(((Container) session.getComponent(1)).getComponent(1));
					session.inverse.setVisible(false);
					
					
					if(((JLabel) ((Container) selectedComponent).getComponent(0)).getText().equals("1")) {
						selectedComponent.setVisible(false);;
						panel2.revalidate();
						panel2.repaint();
					//	System.out.println(((Container) panel2.getComponent(s)).getComponentCount());
						resize(selectedComponent.getParent());
						selectedComponent = null;
					}else {
						((JLabel) ((Container) selectedComponent).getComponent(0)).setText(String.valueOf(Integer.parseInt(((JLabel) ((Container) selectedComponent).getComponent(0)).getText())-1));
					}
					panel1.revalidate();
					panel1.repaint();
					panel2.revalidate();
					panel2.repaint();
					deselect();
							}}}}else if(SessionisSelected) {
					if(!((JLabel) ((Container) panel1.getComponent(0)).getComponent(k)).getText().equals("Pause")) {
						
						if(((Container)((Container) panel1.getComponent(m)).getComponent(k)).getComponentCount()==0) {

							if(((Container)((Container) panel1.getComponent(m)).getComponent(k)) instanceof JPanel) {
				((JPanel)((Container) panel1.getComponent(m)).getComponent(k)).add(((Container) selectedSession).getComponent(0));
					panel1.revalidate();
					panel1.repaint();
					deselect();
				}else if(((Container)((Container) panel1.getComponent(m)).getComponent(k)) instanceof JButton) {
					

						((Container)((Container) panel1.getComponent(m)).getComponent(k)).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(SessionisSelected) {
					replaceExternalCourse(selectedSession, ((Container)((Container) panel1.getComponent(m)).getComponent(k)));

					panel1.revalidate();
					panel1.repaint();
					
					SwingUtilities.getRoot(panel1).setVisible(false);
								TeacherSchedule tc = new TeacherSchedule(teacher_id, ay_id);
								tc.setVisible(true);
							
							}}});
							
						
						}}
					
				}}
				}}
				
			});
		}

		
	}
	
}
}