package Schedule;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Application.ResizeImages;
import app.WrapLayout;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Session extends JPanel {
	public static JLabel className;
	public static JPanel panel1;
	public static JLabel course;
	public static JPanel panel_2;
	public static JPanel panel_1;
	public static JLabel inverse;

	/**
	 * Create the panel.
	 */
	public Session() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		setBorder(null);
		setPreferredSize(new Dimension(220, 100));
		setLayout(new WrapLayout(WrapLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("3eme PF Sciences BCST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(220, 30));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(140, 70));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("6");
		lblNewLabel_1.setPreferredSize(new Dimension(40, 14));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		course = new JLabel("<html><div style='text-align: center;'>Entrepreneuriat</div></html>");
		course.setFont(new Font("Roboto", Font.PLAIN, 14));
		course.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(course, BorderLayout.CENTER);
		
		panel1 = new JPanel();
		panel1.setForeground(new Color(255, 255, 255));
		panel1.setBackground(new Color(0, 0, 255));
		panel_1.add(panel1, BorderLayout.SOUTH);
		panel1.setPreferredSize(new Dimension(10, 15));
		panel1.setLayout(new BorderLayout(0, 0));
		
		className = new JLabel("3eme PF Sciences BCST");
		className.setMinimumSize(new Dimension(113, 0));
		className.setPreferredSize(new Dimension(113, 5));
		className.setForeground(new Color(255, 255, 255));
		className.setFont(new Font("Roboto", Font.PLAIN, 11));
		className.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(className);
		
		inverse = new JLabel("");
		inverse.setOpaque(true);
		inverse.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
		inverse.setPreferredSize(new Dimension(20, 35));
		panel_1.add(inverse, BorderLayout.EAST);
		inverse.setBackground(new Color(40, 40, 40));

	}
}
