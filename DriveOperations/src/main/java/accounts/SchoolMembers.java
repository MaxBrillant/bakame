package accounts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Application.Home;
import Application.ResizeImages;
import Class.Application;
import Class.TestBox;
import Class.OptionsMenu.SchoolMenu;
import Class.OptionsMenu.TestMenu;

public class SchoolMembers extends JPanel {


	public static List<Component> selectedMembers = new ArrayList();
	/**
	 * Create the panel.
	 */
	public SchoolMembers() {
		setBackground(new Color(40, 40, 40));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TestMenu.deselect();
				//TestMenu.deselect();
				deselectAll(getParent());
				if(!selectedMembers.contains(getComponent(0).getParent())) {
					selectedMembers.add(getComponent(0).getParent());
				}else {
					selectedMembers.remove(getComponent(0).getParent());
				}

				
					for(int j = 0; j< getParent().getComponentCount(); j++) {
						if(selectedMembers.contains(getParent().getComponent(j))) {
							((Container) getParent().getComponent(j)).getComponent(0).setBackground(new Color(20, 148, 198, 50));
							((Container) getParent().getComponent(j)).setBackground(new Color(20, 148, 198, 50));
							((Container) getParent().getComponent(j)).getComponent(2).setBackground(new Color(20, 148, 198, 50));
							((JComponent) getParent().getComponent(j)).setBorder(new LineBorder(new Color(20, 148, 198), 2));
							for(int k = 0;k<((Container) getParent().getComponent(j)).getComponentCount();k++) {
								((Container) getParent().getComponent(j)).getComponent(k).setForeground(Color.white);
							}
				}
						}
				
			//
					
				//
					//TestMenu.edit.setVisible(true);
					//TestMenu.delete.setVisible(true);
					//TestMenu.publish.setVisible(true);
					//TestMenu.stats.setVisible(true);
				if(selectedMembers.toArray().length==0) {
					deselectAll(getParent());
				}
				}
			public void mouseEntered(MouseEvent e) {

				getComponent(2).setVisible(true);
				
				for(int i = 0; i< (getParent()).getComponentCount(); i++) {
					if(!(getParent()).getComponent(i).equals(getComponent(0).getParent())) {
				((Container) ((Container) getParent().getComponent(i))).getComponent(2).setVisible(false);
					
				getParent().revalidate();

				getParent().repaint();
					}
				}
				
				if(!selectedMembers.contains(getComponent(0).getParent())) {
				getComponent(0).setBackground(new Color(60, 60, 60));
				setBackground(new Color(60, 60, 60));
				getComponent(2).setBackground(new Color(60, 60, 60));
				
					//getComponent(1).setBackground(new Color(60, 60, 60));
					setBorder(new LineBorder(new Color(20, 148, 198)));
				}
			}public void mouseExited(MouseEvent e) {
				if(!selectedMembers.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(new Color(40, 40, 40));
					setBackground(new Color(40, 40, 40));
					getComponent(2).setBackground(new Color(40, 40, 40));
					//getComponent(1).setBackground(getBackground());
					setBorder(null);
				}
				
			}
		});
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1325, 40));
		setBackground(new Color(40, 40, 40));
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(35, 40));
		panel1.setBackground(new Color(40, 40, 40));
		add(panel1, BorderLayout.WEST);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\check.png"));
		panel1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblUmuhozaChrisKoen = new JLabel();
		lblUmuhozaChrisKoen.setText("UMUHOZA Chris Koen Michael  - 42342");
		lblUmuhozaChrisKoen.setForeground(Color.WHITE);
		lblUmuhozaChrisKoen.setFont(new Font("Roboto", Font.BOLD, 14));
		add(lblUmuhozaChrisKoen, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setBackground(new Color(40, 40, 40));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));
		panel_1.setVisible(false);
		
		JButton users = new JButton();
		users.setPreferredSize(new Dimension(40, 40));
		users.setFocusPainted(false);
		users.setBorder(null);
		users.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		users.setBackground(new Color(40, 40, 40));
		panel_1.add(users);
		Home.addToolTip(users, "Utilisateurs");
		
		
		JButton Students = new JButton();
		Students.setPreferredSize(new Dimension(40, 40));
		Students.setFocusPainted(false);
		Students.setBorder(null);
		Students.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		Students.setBackground(new Color(40, 40, 40));
		panel_1.add(Students);
		Home.addToolTip(Students, "Eleves sous tutelle");
		
		
		JButton parents = new JButton();
		parents.setPreferredSize(new Dimension(40, 40));
		parents.setFocusPainted(false);
		parents.setBorder(null);
		parents.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		parents.setBackground(new Color(40, 40, 40));
		panel_1.add(parents);
		Home.addToolTip(parents, "Parents/tuteurs");
		
		
		JButton Open = new JButton();
		Open.setPreferredSize(new Dimension(40, 40));
		Open.setFocusPainted(false);
		Open.setBorder(null);
		Open.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		Open.setBackground(new Color(40, 40, 40));
		panel_1.add(Open);
		Home.addToolTip(Open, "Ouvrir");
		
		JButton Edit = new JButton();
		Edit.setPreferredSize(new Dimension(40, 40));
		Edit.setFocusPainted(false);
		Edit.setBorder(null);
		Edit.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		Edit.setBackground(new Color(40, 40, 40));
		panel_1.add(Edit);
		Home.addToolTip(Edit, "Modifier");
		
		
		JButton info = new JButton();
		info.setPreferredSize(new Dimension(40, 40));
		info.setFocusPainted(false);
		info.setBorder(null);
		info.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		info.setBackground(new Color(40, 40, 40));
		panel_1.add(info);
		Home.addToolTip(info, "Infos");
		
	
		
		for(int i = 0;i<panel_1.getComponentCount(); i++) {
			int j = i;
			panel_1.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.getComponent(j).setBackground(new Color(20, 148, 198));

					if(!selectedMembers.contains(getComponent(0).getParent())) {
					getComponent(0).setBackground(new Color(60, 60, 60));
					setBackground(new Color(60, 60, 60));
					getComponent(2).setBackground(new Color(60, 60, 60));
					getComponent(2).setVisible(true);
					
						//getComponent(1).setBackground(new Color(60, 60, 60));
						setBorder(new LineBorder(new Color(20, 148, 198)));
					}
				
					}
				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.getComponent(j).setBackground(new Color(40, 40, 40));

					if(!selectedMembers.contains(getComponent(0).getParent())) {
						getComponent(0).setBackground(new Color(40, 40, 40));
						setBackground(new Color(40, 40, 40));
						getComponent(2).setBackground(new Color(40, 40, 40));
						//getComponent(1).setBackground(getBackground());
						setBorder(null);
						//getComponent(2).setVisible(false);
					}
					
				
					}
				
			});
		}
		
	}
	
	

	public static void deselectAll(Container c) {
		for(int i = 0; i< (c).getComponentCount(); i++) {
			if((c).getComponent(i) instanceof SchoolMembers) {
			if(selectedMembers.contains((c).getComponent(i))) {
				((JComponent) (c).getComponent(i)).setBackground(new Color(40, 40, 40));
				((JComponent) (c).getComponent(i)).getComponent(0).setBackground(new Color(40, 40, 40));
				((JComponent) (c).getComponent(i)).setBackground(new Color(40, 40, 40));
				((JComponent) (c).getComponent(i)).getComponent(2).setBackground(new Color(40, 40, 40));
				((JComponent) (c).getComponent(i)).setBorder(null);
			}
			//((Container) ((Container) c.getComponent(i)).getComponent(0)).getComponent(0).setVisible(false);
			
				c.revalidate();

				c.repaint();
			}
		}

		//selectedMembers.clear();
		
		SchoolMenu.deselect();
}

}
