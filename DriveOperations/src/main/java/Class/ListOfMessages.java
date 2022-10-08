package Class;

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

import Application.Home;
import Application.NewPunishment;
import Application.ResizeImages;
import app.WrapLayout;
import javax.swing.JTextField;

public class ListOfMessages extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOfMessages frame = new ListOfMessages();
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
	public ListOfMessages() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 300));
		setTitle("");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Listes des messages</html>");
		lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblajoutezLesClasses.setForeground(Color.WHITE);
		lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 16));
		lblajoutezLesClasses.setBounds(10, 0, 564, 33);
		contentPane.add(lblajoutezLesClasses);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(0, 33, 584, 1);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 119, 564, 431);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i<panel.getComponentCount(); i++) {
					if(!(panel.getComponent(i) instanceof JLabel)) {
					panel.getComponent(i).setBackground(new Color(60, 60, 60));
					((Container) panel.getComponent(i)).getComponent(2).setVisible(false);
					((Container) panel.getComponent(i)).getComponent(0).setBackground(panel.getComponent(i).getBackground());
					((Container) panel.getComponent(i)).getComponent(2).setBackground(panel.getComponent(i).getBackground());
				}}
			}
		});
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 5));
		
		JLabel lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ceci est la liste des messages et communiques envoyes aux eleves ou parents/tuteurs pendant cet annee scolaire.</div></html>");
		lblajouterModifierouSupprimer.setForeground(new Color(211, 211, 211));
		lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblajouterModifierouSupprimer.setBounds(10, 34, 564, 51);
		contentPane.add(lblajouterModifierouSupprimer);
		
		setLocationRelativeTo(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(540, 50));
		panel_1.setBackground(new Color(60, 60, 60));;
		
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				JLabel lblMaxBrillant = new JLabel("Delegue de classe");
				lblMaxBrillant.setMaximumSize(new Dimension(300, 14));
				lblMaxBrillant.setPreferredSize(new Dimension(100, 30));
				lblMaxBrillant.setForeground(Color.WHITE);
				lblMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 16));
				panel_1.add(lblMaxBrillant, BorderLayout.CENTER);
				
				
				JPanel panel_4 = new JPanel();
				panel_1.add(panel_4, BorderLayout.SOUTH);
				panel_4.setLayout(new BorderLayout(0, 0));
				panel_4.setPreferredSize(new Dimension(317, 20));

				panel_4.setBackground(panel_4.getParent().getBackground());
				
				
				JLabel lblNewLabel = new JLabel("<html><div style='text-align: leading;'>"+"ksjlksklsj lkj sjl sksj jlksjkls lskssj k jskl jskljs"+"</div></html>");
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel.setPreferredSize(new Dimension(317, 20));
				lblNewLabel.setMinimumSize(new Dimension(317, 20));
				panel_4.add(lblNewLabel, BorderLayout.CENTER);
				lblNewLabel.setMaximumSize(new Dimension(300, 14));
				lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
				lblNewLabel.setForeground(new Color(211, 211, 211));
				
				JButton button = new JButton("12/04/2022  ");
				button.setVerticalTextPosition(SwingConstants.BOTTOM);
				button.setIconTextGap(0);
				button.setHorizontalTextPosition(SwingConstants.RIGHT);
				button.setForeground(new Color(211, 211, 211));
				button.setFont(new Font("Roboto", Font.PLAIN, 14));
				button.setFocusPainted(false);
				button.setBorder(null);
				button.setBackground(new Color(60, 60, 60));
				panel_4.add(button, BorderLayout.EAST);
				
				
				
			
			JPanel panel_3 = new JPanel();
			panel_1.add(panel_3, BorderLayout.EAST);
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

			panel_3.setBackground(panel_3.getParent().getBackground());

			
			
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
						lblNewLabel.setText("<html><u>"+lblNewLabel.getText().replaceAll("<html><div style='text-align: leading;'>", "").replaceAll("</div></html>", "")+"</u></html>");
				}
				@Override
				public void mouseExited(MouseEvent e) {
						lblNewLabel.setText("<html><div style='text-align: leading;'>"+lblNewLabel.getText().replaceAll("<u>", "").replaceAll("</u>", "")+"</div></html>");
				}
			});


			
			JButton button11 = new JButton("envoye a 79% de 2000 eleves");
			panel_3.add(button11);
			//button11.setPreferredSize(new Dimension(40, 30));
			button11.setVerticalTextPosition(SwingConstants.BOTTOM);
			button11.setIconTextGap(0);
			button11.setHorizontalTextPosition(SwingConstants.RIGHT);
			button11.setForeground(Color.WHITE);
			button11.setFont(new Font("Roboto", Font.PLAIN, 14));
			button11.setFocusPainted(false);
			button11.setBorder(null);
			button11.setBackground(button11.getParent().getBackground());
			Home.addToolTip(button11, "Eleves choisis");
			
			
			
			JButton button1 = new JButton("");
			panel_3.add(button1);
			button1.setPreferredSize(new Dimension(40, 30));
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
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setPreferredSize(new Dimension(30, 30));
			lblNewLabel_2.setIcon(ResizeImages.resize(20, 20, "Icons\\delete.png"));
			panel_1.add(lblNewLabel_2, BorderLayout.WEST);
			
			JLabel label = new JLabel("New label");
			label.setBounds(-16, 137, 46, 14);
			contentPane.add(label);
			
			textField = new JTextField();
			textField.setBackground(new Color(40, 40, 40));
			textField.setFont(new Font("Roboto", Font.PLAIN, 14));
			textField.setBounds(402, 93, 172, 25);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnNouveauMessage = new JButton("Nouveau message");
			btnNouveauMessage.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnNouveauMessage.setPreferredSize(new Dimension(40, 30));
			btnNouveauMessage.setIconTextGap(0);
			btnNouveauMessage.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNouveauMessage.setForeground(Color.WHITE);
			btnNouveauMessage.setFont(new Font("Roboto", Font.BOLD, 14));
			btnNouveauMessage.setFocusPainted(false);
			btnNouveauMessage.setBorder(null);
			btnNouveauMessage.setBackground(new Color(20, 148, 198));
			btnNouveauMessage.setBounds(10, 86, 160, 25);
			contentPane.add(btnNouveauMessage);
			
		}
}
