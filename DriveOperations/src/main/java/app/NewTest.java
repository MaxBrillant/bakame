package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import Application.Home;
import Class.TestInfo;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewTest extends JFrame {

	private JPanel contentPane;
	public static JButton create;
	private JLabel label;
	public static JTextField PO;
	public static JLabel interro;
	public static JLabel error;
	private JSeparator separator_1;
	public static JButton update;
	private JPanel panel;
	public static JButton upExam;
	public static JLabel TP;
	private JLabel label_1;
	public static JLabel cours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTest frame = new NewTest();
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
	public NewTest(String testId) {
	setResizable(false);
	setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 290);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 70, 70));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	create = new JButton("Ajouter");
	create.setFocusPainted(false);
	create.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			create.setBackground(new Color(64, 201, 135));
		}public void mouseExited(MouseEvent e) {
			create.setBackground(new Color(0, 171, 89));
		}
	});
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(new Color(255, 255, 255));
	create.setFont(new Font("Roboto", Font.PLAIN, 20));
	create.setBounds(152, 205, 124, 31);
	//contentPane.add(create);
	
	update = new JButton("Modifier");
	update.setForeground(Color.WHITE);
	update.setFont(new Font("Roboto", Font.BOLD, 20));
	update.setFocusPainted(false);
	update.setBackground(new Color(171, 145, 0));
	contentPane.add(update);
	

	update.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {

			update.setBackground(new Color(201, 180, 64));
		}public void mouseExited(MouseEvent e) {
			update.setBackground(new Color(171, 145, 0));
		}
	});
	
	JLabel lblPointsObtenus = new JLabel("Points obtenus:");
	lblPointsObtenus.setForeground(new Color(255, 255, 255));
	lblPointsObtenus.setHorizontalAlignment(SwingConstants.TRAILING);
	lblPointsObtenus.setFont(new Font("Roboto", Font.BOLD, 20));
	lblPointsObtenus.setBounds(28, 150, 175, 31);
	contentPane.add(lblPointsObtenus);
	
	PO = new JTextField();
	PO.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(PO.getText().isBlank()) {
			update.setEnabled(false);
			}else {
				update.setEnabled(true);
			}
		}
	});
	PO.setHorizontalAlignment(SwingConstants.CENTER);
	PO.setCaretColor(new Color(0, 204, 255));
	PO.setForeground(new Color(255, 255, 255));
	PO.setBorder(new LineBorder(new Color(128, 128, 128)));
	PO.setBackground(new Color(40, 40, 40));
	PO.setFont(new Font("Roboto", Font.PLAIN, 22));
	PO.setColumns(10);
	PO.setBounds(226, 150, 72, 28);
	contentPane.add(PO);
	
	panel = new JPanel();
	panel.setBackground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 53);
	contentPane.add(panel);
	panel.setLayout(null);
	
	label = new JLabel("<html>Ajoutez une nouvelle interrogation en inserant les points obtenus ainsi que le maximum des points.</html>");
	label.setForeground(new Color(255, 255, 255));
	label.setBounds(5, 2, 414, 48);
	panel.add(label);
	label.setFont(new Font("Roboto", Font.BOLD, 16));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	
	interro = new JLabel("Interrogation No ");
	interro.setHorizontalAlignment(SwingConstants.CENTER);
	interro.setForeground(new Color(255, 255, 255));
	interro.setFont(new Font("Futura Hv BT", Font.PLAIN, 23));
	interro.setBounds(0, 51, 424, 31);
	contentPane.add(interro);
	
	separator_1 = new JSeparator();
	separator_1.setForeground(Color.BLACK);
	separator_1.setBounds(0, 84, 424, 14);
	contentPane.add(separator_1);
	
	error = new JLabel("");
	error.setForeground(Color.RED);
	error.setFont(new Font("Tahoma", Font.PLAIN, 15));
	error.setHorizontalAlignment(SwingConstants.CENTER);
	error.setBounds(0, 84, 424, 21);
	contentPane.add(error);
	
	upExam = new JButton("Changer");
	upExam.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Exam.saveExistingExam();
			Exam.loadExams();
			setVisible(false);
		}
	});
	upExam.setForeground(Color.WHITE);
	upExam.setFont(new Font("Roboto", Font.PLAIN, 20));
	upExam.setFocusPainted(false);
	upExam.setBackground(new Color(171, 145, 0));
	upExam.setBounds(152, 205, 124, 31);
	contentPane.add(upExam);

	

	update.setBounds(upExam.getBounds());
	
	label_1 = new JLabel("/");
	label_1.setForeground(Color.WHITE);
	label_1.setFont(new Font("Roboto", Font.BOLD, 25));
	label_1.setBounds(308, 148, 16, 31);
	contentPane.add(label_1);
	
	TP = new JLabel("20");
	TP.setForeground(Color.WHITE);
	TP.setFont(new Font("Roboto", Font.BOLD, 25));
	TP.setBounds(315, 150, 75, 31);
	contentPane.add(TP);
	
	cours = new JLabel(LPane.Name.getText());
	cours.setHorizontalAlignment(SwingConstants.CENTER);
	cours.setForeground(Color.WHITE);
	cours.setFont(new Font("Futura Hv BT", Font.PLAIN, 23));
	cours.setBounds(0, 90, 424, 31);
	contentPane.add(cours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.BLACK);
	separator.setBounds(0, 124, 424, 14);
	contentPane.add(separator);
	
	
	setLocationRelativeTo(null);
	
	
	
	
	

	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String s = TP.getText();
			String g = PO.getText().toString();
			if(s.contains(",")) {
				s = TP.getText().replace(",", ".");
			}if(g.contains(",")) {
				g = PO.getText().toString().replace(",", ".");
			}

			if(!PO.getText().equals("") && Double.parseDouble(s)>=Double.parseDouble(g)) {
				
			TestInfo.saveTestNote(testId, s+"/"+g, App.getStudentName(App.n), LPane.getTestCourseName(testId));
			App.saveTests = true;

			setVisible(false);
			}else {
				error.setText("Please fill the empty field");
				}


		}
	});
	
	
	update.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

				String g = PO.getText().toString().replace(",", ".");

			if(!PO.getText().isBlank()) {
			TestInfo.saveTestNote(testId, g+"/"+Test.getTestMaxima(testId), App.getStudentName(App.n), LPane.getTestCourseName(testId));
			App.saveTests = true;
			App.loadCourses();
			Cours.loaddata(((Container)Cours.selectedCourses.get(0)), ((JLabel) ((Container) ((Container) Cours.selectedCourses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			Test.deselect(((JLabel) ((Container) ((Container) Cours.selectedCourses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));

			setVisible(false);
			}else {
				error.setText("Please fill the empty field");
			}	}
	});
	
	}
}
