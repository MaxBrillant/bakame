package transcripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Application.Class;
import Application.Home;
import Application.ResizeImages;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;

public class TranscriptSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranscriptSelection frame = new TranscriptSelection();
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
	public TranscriptSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(40, 40, 40));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		panel.setPreferredSize(new Dimension(10, 120));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Conception du bulletin de la classe de 3eme Economique");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("<html><div style='text-align: left;'>Selectionnez un des modeles de bulletins disponibles et effectuez des modifications sur l'apparence du bulletin en ajoutant des couleurs, en modifiant l'ordre des cours.</div></html>");
		lblNewLabel_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 60, 60));
		panel_2.setPreferredSize(new Dimension(300, 10));
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(260, 30));
		panel_3.setBackground(new Color(60, 60, 60));
		panel_3.setBounds(245, 35, 195, 30);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("Type 1");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_3.add(lblNewLabel_11, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(panel_3.getBackground());
		btnNewButton.setBorder(null);
		btnNewButton.setPreferredSize(new Dimension(30, 30));
		btnNewButton.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		panel_3.add(btnNewButton, BorderLayout.WEST);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(panel_3.getBackground());
		button_1.setBorder(null);
		button_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\r_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		panel_3.add(button_1, BorderLayout.EAST);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Couleurs");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setPreferredSize(new Dimension(300, 20));
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(25, 25));
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(Color.RED);
		panel_31.setPreferredSize(new Dimension(25, 25));
		panel_2.add(panel_31);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(25, 25));
		panel_4.setBackground(Color.YELLOW);
		panel_2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(25, 25));
		panel_5.setBackground(Color.CYAN);
		panel_2.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(25, 25));
		panel_6.setBackground(Color.GREEN);
		panel_2.add(panel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 60));
		panel_1.setBackground(new Color(40, 40, 40));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screensize.width,screensize.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setMinimumSize(new Dimension(screensize.width*80/100,screensize.height*80/100));
	}

}
