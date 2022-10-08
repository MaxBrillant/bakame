package Publishing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Application.ResizeImages;
import app.WrapLayout;

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
import javax.swing.JTabbedPane;
import java.awt.Point;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.FlowLayout;

public class PublicationsList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicationsList frame = new PublicationsList();
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
	public PublicationsList() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 600));
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(80, 80, 80));
		panel_1.setPreferredSize(new Dimension(10, 120));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(55, 11, 273, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(60, 60, 60));
		panel_6.setBounds(40, 50, 304, 30);
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton("");
		button.setIcon(ResizeImages.resize(25, 25, "Icons\\l_arrow.png"));
		button.setPreferredSize(new Dimension(30, 30));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(60, 60, 60));
		panel_6.add(button, BorderLayout.WEST);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(ResizeImages.resize(25, 25, "Icons\\l_arrow.png"));
		button_2.setPreferredSize(new Dimension(30, 30));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(60, 60, 60));
		panel_6.add(button_2, BorderLayout.EAST);
		
		JLabel lblemepfEco = new JLabel("3eme PF Economique");
		lblemepfEco.setHorizontalAlignment(SwingConstants.CENTER);
		lblemepfEco.setForeground(Color.WHITE);
		lblemepfEco.setFont(new Font("Arial", Font.BOLD, 17));
		panel_6.add(lblemepfEco, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(60, 60, 60));
		panel_7.setBounds(40, 82, 304, 30);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton button_1 = new JButton("");
		button_1.setIcon(ResizeImages.resize(25, 25, "Icons\\l_arrow.png"));
		button_1.setPreferredSize(new Dimension(30, 30));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(60, 60, 60));
		panel_7.add(button_1, BorderLayout.WEST);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(ResizeImages.resize(25, 25, "Icons\\r_arrow.png"));
		button_3.setPreferredSize(new Dimension(30, 30));
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(60, 60, 60));
		panel_7.add(button_3, BorderLayout.EAST);
		
		JLabel lblNdashimyeMaxBrillant = new JLabel("NDASHIMYE Max Brillant");
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setFont(new Font("Arial", Font.BOLD, 17));
		panel_7.add(lblNdashimyeMaxBrillant, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(20, 0));
		tabbedPane.setMinimumSize(new Dimension(200, 200));
		tabbedPane.setPreferredSize(new Dimension(10, 10));
		tabbedPane.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("SMS", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		scrollPane_1.setViewportView(panel_4);
		panel_4.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("E-Mail", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setPreferredSize(new Dimension(370, 50));
		panel_5.add(panel_8);
		setLocationRelativeTo(null);
	
	
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
