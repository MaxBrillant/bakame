package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.WrapLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class UserHistory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHistory frame = new UserHistory();
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
	public UserHistory() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 300));
	setTitle("");
	setBounds(100, 100, 700, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Historique d'utilisation</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
	lblajoutezLesClasses.setBounds(10, 0, 664, 33);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 684, 1);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 125, 664, 425);
	contentPane.add(scrollPane);
	
	JPanel panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(60, 60, 60));
				((Container) panel.getComponent(i)).getComponent(1).setVisible(false);
				((Container) panel.getComponent(i)).getComponent(0).setBackground(panel.getComponent(i).getBackground());
				((Container) panel.getComponent(i)).getComponent(1).setBackground(panel.getComponent(i).getBackground());
			}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.LEADING, 3, 3));
	
	JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>L'historique d'utilisation permet a l'administrateur de l'annee scholaire de tracer et suivre toutes les activites importantes effectuees par les utilisateurs externes pendant les 3 derniers mois.</div></html>");
	lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
	lblajouterModifierouSupprimer.setBounds(10, 34, 664, 44);
	contentPane.add(lblajouterModifierouSupprimer);
	
	setLocationRelativeTo(null);

	
			JLabel lblNewLabel_1 = new JLabel("   10/07/2022");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setPreferredSize(new Dimension(100, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(640, 40));
	panel_1.setBackground(new Color(60, 60, 60));;
	
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblMaxBrillant = new JLabel("  Max Brillant");
			lblMaxBrillant.setHorizontalTextPosition(SwingConstants.LEADING);
			lblMaxBrillant.setIcon(ResizeImages.resize(10, 10, "C:\\Users\\User\\git\\bakame\\DriveOperations\\Icons\\drop1.png"));
			lblMaxBrillant.setMaximumSize(new Dimension(300, 14));
			lblMaxBrillant.setPreferredSize(new Dimension(100, 20));
			lblMaxBrillant.setForeground(Color.WHITE);
			lblMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 14));
			panel_1.add(lblMaxBrillant, BorderLayout.CENTER);
			
			JLabel lblNewLabel = new JLabel("  Ajout du cours de FPH dans la classe de 3eme PF Sciences BCST.");
			lblNewLabel.setPreferredSize(new Dimension(317, 20));
			lblNewLabel.setMinimumSize(new Dimension(317, 20));
			panel_1.add(lblNewLabel, BorderLayout.SOUTH);
			lblNewLabel.setMaximumSize(new Dimension(300, 14));
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
			lblNewLabel.setForeground(Color.white);
			
			JLabel label = new JLabel(" 14:08 ");
			label.setMaximumSize(new Dimension(300, 14));
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Roboto", Font.PLAIN, 14));
			panel_1.add(label, BorderLayout.EAST);
			
			JButton btnNewButton = new JButton("Voir plus");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton.setBackground(new Color(20, 148, 198));
				}public void mouseExited(MouseEvent e) {
					btnNewButton.setBackground(new Color(60, 60, 60));
				}
			});
			btnNewButton.setHorizontalTextPosition(SwingConstants.LEADING);
			btnNewButton.setFocusPainted(false);
			btnNewButton.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\git\\bakame\\DriveOperations\\Icons\\drop2.png"));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255)));
			btnNewButton.setBackground(new Color(60, 60, 60));
			btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 14));
			btnNewButton.setPreferredSize(new Dimension(640, 30));
			panel.add(btnNewButton);
	
	
	
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
			comboBox.setBounds(497, 92, 177, 22);
			contentPane.add(comboBox);
		
		
	}
}
