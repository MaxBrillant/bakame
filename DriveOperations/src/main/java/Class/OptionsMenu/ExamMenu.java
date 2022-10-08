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

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.Course;
import Class.ExamBox;
import Class.NewCourse;
import Class.NewPane;
import Class.Student;
import Class.TestBox;
import Class.TestInfo;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

public class ExamMenu extends JPanel {
	public static JButton add;
	public static JButton newTest;
	public static JButton publish;
	public static JButton stats;
	public static JButton edit;
	public static JButton delete;

	/**
	 * Create the panel.
	 */
	public ExamMenu(String classroom_in_ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(300, 2));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(12, 10));
		scrollPane.getHorizontalScrollBar().setBackground(new Color(60, 60, 60));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		add = new JButton("");
		add.setIcon(ResizeImages.resize(37, 37, "Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Roboto", Font.PLAIN, 18));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
		panel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPane np = new NewPane();
				np.setVisible(true);
	
			}
		});
		
		newTest = new JButton("");
		newTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestInfo nt = new TestInfo();
				nt.setVisible(true);
			}
		});
		newTest.setIcon(ResizeImages.resize(37, 37, "Icons\\new-Exam.png"));
		newTest.setPreferredSize(new Dimension(50, 50));
		newTest.setVerticalTextPosition(SwingConstants.BOTTOM);
		newTest.setIconTextGap(0);
		newTest.setHorizontalTextPosition(SwingConstants.CENTER);
		newTest.setForeground(Color.WHITE);
		newTest.setFont(new Font("Roboto", Font.PLAIN, 18));
		newTest.setFocusPainted(false);
		newTest.setBorder(null);
		newTest.setBackground(panel.getBackground());
		panel.add(newTest);
		
		stats = new JButton("Statistiques");
		stats.setVerticalTextPosition(SwingConstants.BOTTOM);
		stats.setPreferredSize(new Dimension(100, 100));
		stats.setIconTextGap(-4);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setFont(new Font("Roboto", Font.PLAIN, 18));
		stats.setFocusPainted(false);
		stats.setBorder(null);
		stats.setBackground(panel.getBackground());
		//panel.add(stats);
		
		publish = new JButton("");
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setIcon(ResizeImages.resize(37, 37, "Icons\\Send.png"));
		publish.setIconTextGap(-4);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(50, 50));
		publish.setFont(new Font("Roboto", Font.PLAIN, 18));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(panel.getBackground());
		panel.add(publish);
		
		edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		edit.setIcon(ResizeImages.resize(37, 37, "Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 18));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
		panel.add(edit);
		
		delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TestBox.deleteTest();
			}
		});
		delete.setIcon(ResizeImages.resize(37, 37, "Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 18));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		
		
		Application.deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(panel.getBackground());
				}
				
			});
		}
	}
	
	
	public static void deselect() {
		edit.setVisible(false);
		delete.setVisible(false);
		//corrige.setVisible(false);
		}
	
	
	public static String TestData(String testId) {
		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Test List/3eme Trimestre/TestList.txt");
		aws.downloadContent(file.getPath());
		String s = null;
		try {
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i< lines.length; i++) {
				List l = Arrays.asList(lines[i].toString().split("//"));
				if(l.get(0).toString().equals(testId)) {
					s = lines[i].toString();
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return s;
	}
}
