package Class;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Application.ResizeImages;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class NewPane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPane frame = new NewPane();
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
	public NewPane() {
		setTitle("Ajouter");
		setResizable(false);
		setPreferredSize(new Dimension(600, 600));
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 80, 80));
		panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>Creez une nouvelle activite en ajoutant une interrogation ou un examen, ou ajoutez un nouvel eleve ou un nouveau cours a la classe.</html>");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 60, 60));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton newTest = new JButton("<html><div style='text-align: center;'>Ajouter une interrogation</html>");
		newTest.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\test.png"));
		newTest.setVerticalTextPosition(SwingConstants.BOTTOM);
		newTest.setIconTextGap(0);
		newTest.setHorizontalTextPosition(SwingConstants.CENTER);
		newTest.setForeground(Color.WHITE);
		newTest.setFont(new Font("Arial", Font.PLAIN, 20));
		newTest.setFocusPainted(false);
		newTest.setBorderPainted(false);
		newTest.setBackground(new Color(80, 80, 80));
		newTest.setBounds(55, 31, 170, 170);
		panel_1.add(newTest);
		
		JButton newStudent = new JButton("<html><div style='text-align: center;'>Ajouter un eleve</html>");
		newStudent.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-student.png"));
		newStudent.setVerticalTextPosition(SwingConstants.BOTTOM);
		newStudent.setIconTextGap(0);
		newStudent.setHorizontalTextPosition(SwingConstants.CENTER);
		newStudent.setForeground(Color.WHITE);
		newStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		newStudent.setFocusPainted(false);
		newStudent.setBorderPainted(false);
		newStudent.setBackground(new Color(80, 80, 80));
		newStudent.setBounds(245, 32, 170, 170);
		panel_1.add(newStudent);
		
		JButton newCourse = new JButton("<html><div style='text-align: center;'>Ajouter un cours</html>");
		newCourse.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\book.png"));
		newCourse.setVerticalTextPosition(SwingConstants.BOTTOM);
		newCourse.setIconTextGap(0);
		newCourse.setHorizontalTextPosition(SwingConstants.CENTER);
		newCourse.setForeground(Color.WHITE);
		newCourse.setFont(new Font("Arial", Font.PLAIN, 20));
		newCourse.setFocusPainted(false);
		newCourse.setBorderPainted(false);
		newCourse.setBackground(new Color(80, 80, 80));
		newCourse.setBounds(55, 221, 170, 170);
		panel_1.add(newCourse);
		
		JButton newExam = new JButton("<html><div style='text-align: center;'>Ajouter un examen</html>");
		newExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ExamInfo ei = new ExamInfo();
				ei.setVisible(true);
				setVisible(false);
			}
		});
		newExam.setIcon(ResizeImages.resize(90, 90, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\new-Exam.png"));
		newExam.setVerticalTextPosition(SwingConstants.BOTTOM);
		newExam.setIconTextGap(0);
		newExam.setHorizontalTextPosition(SwingConstants.CENTER);
		newExam.setForeground(Color.WHITE);
		newExam.setFont(new Font("Arial", Font.PLAIN, 20));
		newExam.setFocusPainted(false);
		newExam.setBorderPainted(false);
		newExam.setBackground(new Color(80, 80, 80));
		newExam.setBounds(245, 221, 170, 170);
		panel_1.add(newExam);
		
		JButton button_4 = new JButton("Fermer");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setBackground(new Color(171, 0, 0));
		button_4.setBounds(345, 420, 129, 31);
		panel_1.add(button_4);
		setLocationRelativeTo(null);

		

		newTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestInfo nt = new TestInfo();
				nt.setVisible(true);
				setVisible(false);

				nt.actualiser.setVisible(false);
				nt.Add.setVisible(true);
			}
		});
		
		

		newCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Application.tabbedPane.setSelectedIndex(1);
				NewCourse nc = new NewCourse();
				nc.setVisible(true);
				setVisible(false);
				nc.actualiser.setVisible(false);
				nc.create.setVisible(true);
			}
		});
		
		

		newStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Application.tabbedPane.setSelectedIndex(0);
				
				NewStudent ns = new NewStudent();
				ns.setVisible(true);
				setVisible(false);
				ns.actualiser.setVisible(false);
				ns.add.setVisible(true);
			}
		});
	
	

		
		newStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newStudent.setBackground(new Color(120, 120, 120));
				newStudent.setFont(new Font("Arial", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newStudent.setBackground(new Color(80, 80, 80));
				newStudent.setFont(new Font("Arial", Font.PLAIN, 20));
			}
		});
		
		
		newTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newTest.setBackground(new Color(120, 120, 120));
				newTest.setFont(new Font("Arial", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newTest.setBackground(new Color(80, 80, 80));
				newTest.setFont(new Font("Arial", Font.PLAIN, 20));
			}
		});
		
		
		newCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newCourse.setBackground(new Color(120, 120, 120));
				newCourse.setFont(new Font("Arial", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newCourse.setBackground(new Color(80, 80, 80));
				newCourse.setFont(new Font("Arial", Font.PLAIN, 20));
			}
		});
		
		newExam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newExam.setBackground(new Color(120, 120, 120));
				newExam.setFont(new Font("Arial", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newExam.setBackground(new Color(80, 80, 80));
				newExam.setFont(new Font("Arial", Font.PLAIN, 20));
			}
		});
	
	
	
	}
}
