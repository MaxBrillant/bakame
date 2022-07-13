package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Application.Class;
import Application.Home;
import Application.NewClass;
import Application.NewGroup;
import Application.ResizeImages;
import Publishing.NewPublication;

public class SchoolMenu extends JPanel {

	private static Container panel;

	/**
	 * Create the panel.
	 */
	public SchoolMenu() {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 70));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		

		scrollPane.getHorizontalScrollBar().setBackground(panel.getBackground());
		
		JButton add = new JButton("");
		add.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 12));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
		panel.add(add);
		Home.addToolTip(add, "Ajouter");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		
		JButton edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		edit.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 12));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
		panel.add(edit);
		Home.addToolTip(edit, "Modifier");
		
		JButton delete = new JButton("");
		delete.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 12));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		Home.addToolTip(delete, "Supprimer");
		
		deselect();
		
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
		//panel.getComponent(1).setVisible(false);
		//panel.getComponent(2).setVisible(false);
		//panel.getComponent(4).setVisible(false);
		//panel.getComponent(5).setVisible(false);
		//panel.getComponent(6).setVisible(false);
		
	}

}
