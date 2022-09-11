package sideInformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Application.ResizeImages;
import accounts.Login;
import accounts.ScholarYears;
import accounts.UserPanel;
import elements.CustomButton;
import elements.RoundLabel;

public class SchoolInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public SchoolInfo(String school_id) {
		setBorder(null);
		setBackground(new Color(40, 40, 40));
		setPreferredSize(new Dimension(320, 600));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		RoundLabel btnNewButton = new RoundLabel(100, 100, "C:\\Users\\User\\Pictures\\photoshop max\\CG Projects\\cartoonproject.jpg");
		btnNewButton.setPreferredSize(new Dimension(100, 100));
		btnNewButton.setBackground(new Color(40, 40, 40));
		add(btnNewButton);
		
		
		JLabel label = new JLabel(UserPanel.getSchoolFullName(school_id));
		label.setPreferredSize(new Dimension(300, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 16));
		add(label);
		
		JLabel label_1 = new JLabel(UserPanel.getSchoolShortName(school_id));
		label_1.setPreferredSize(new Dimension(300, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(label_1);
		

		CustomButton changePhoto = new CustomButton("<html><div style='text-align: leading;'>Changer la photo</div></html>");
		changePhoto.setRadius(15);
		changePhoto.setAlignmentX(Component.CENTER_ALIGNMENT);
		changePhoto.setMultiClickThreshhold(2000L);
		changePhoto.setMargin(new Insets(2, 10, 2, 14));
		changePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		changePhoto.setPreferredSize(new Dimension(170, 25));
		changePhoto.setIconTextGap(10);
		changePhoto.setForeground(Color.WHITE);
		changePhoto.setFont(new Font("Roboto", Font.BOLD, 14));
		changePhoto.setFocusPainted(false);
		changePhoto.setBorderColor(new Color(255, 255, 255));
		changePhoto.setBackground(new Color(40, 40, 40));
		changePhoto.setIcon(ResizeImages.resize(15, 15, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		add(changePhoto);
		
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(300, 1));
		separator.setForeground(Color.WHITE);
		add(separator);
		
		

		CustomButton communication = new CustomButton("<html><div style='text-align: leading;'>Modifier les infos de l'ecole</div></html>");
		communication.setRadius(15);
		communication.setAlignmentX(Component.CENTER_ALIGNMENT);
		communication.setMultiClickThreshhold(2000L);
		communication.setMargin(new Insets(2, 10, 2, 14));
		communication.setHorizontalAlignment(SwingConstants.LEADING);
		communication.setPreferredSize(new Dimension(300, 40));
		communication.setIconTextGap(10);
		communication.setForeground(Color.WHITE);
		communication.setFont(new Font("Roboto", Font.BOLD, 14));
		communication.setFocusPainted(false);
		communication.setBorderColor(new Color(255, 255, 255));
		communication.setBackground(new Color(40, 40, 40));
		communication.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(communication);
		
		
		
		CustomButton trimestres = new CustomButton("<html><div style='text-align: leading;'>Comptabilite</div></html>");
		trimestres.setRadius(15);
		trimestres.setAlignmentX(Component.CENTER_ALIGNMENT);
		trimestres.setMultiClickThreshhold(2000L);
		trimestres.setMargin(new Insets(2, 10, 2, 14));
		trimestres.setHorizontalAlignment(SwingConstants.LEADING);
		trimestres.setPreferredSize(new Dimension(300, 40));
		trimestres.setIconTextGap(10);
		trimestres.setForeground(Color.WHITE);
		trimestres.setFont(new Font("Roboto", Font.BOLD, 14));
		trimestres.setFocusPainted(false);
		trimestres.setBorderColor(new Color(255, 255, 255));
		trimestres.setBackground(new Color(40, 40, 40));
		trimestres.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(trimestres);
		
		
		
		CustomButton punitions111 = new CustomButton("<html><div style='text-align: leading;'>Personnel</div></html>");
		punitions111.setRadius(15);
		punitions111.setAlignmentX(Component.CENTER_ALIGNMENT);
		punitions111.setMultiClickThreshhold(2000L);
		punitions111.setMargin(new Insets(2, 10, 2, 14));
		punitions111.setHorizontalAlignment(SwingConstants.LEADING);
		punitions111.setPreferredSize(new Dimension(300, 40));
		punitions111.setIconTextGap(10);
		punitions111.setForeground(Color.WHITE);
		punitions111.setFont(new Font("Roboto", Font.BOLD, 14));
		punitions111.setFocusPainted(false);
		punitions111.setBorderColor(new Color(255, 255, 255));
		punitions111.setBackground(new Color(40, 40, 40));
		punitions111.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(punitions111);
		

		CustomButton punitions1111 = new CustomButton("<html><div style='text-align: leading;'>Biblioteque</div></html>");
		punitions1111.setRadius(15);
		punitions1111.setAlignmentX(Component.CENTER_ALIGNMENT);
		punitions1111.setMultiClickThreshhold(2000L);
		punitions1111.setMargin(new Insets(2, 10, 2, 14));
		punitions1111.setHorizontalAlignment(SwingConstants.LEADING);
		punitions1111.setPreferredSize(new Dimension(300, 40));
		punitions1111.setIconTextGap(10);
		punitions1111.setForeground(Color.WHITE);
		punitions1111.setFont(new Font("Roboto", Font.BOLD, 14));
		punitions1111.setFocusPainted(false);
		punitions1111.setBorderColor(new Color(255, 255, 255));
		punitions1111.setBackground(new Color(40, 40, 40));
		punitions1111.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(punitions1111);
		
		
		
		CustomButton punitions11 = new CustomButton("<html><div style='text-align: leading;'>Administrateurs</div></html>");
		punitions11.setRadius(15);
		punitions11.setAlignmentX(Component.CENTER_ALIGNMENT);
		punitions11.setMultiClickThreshhold(2000L);
		punitions11.setMargin(new Insets(2, 10, 2, 14));
		punitions11.setHorizontalAlignment(SwingConstants.LEADING);
		punitions11.setPreferredSize(new Dimension(300, 40));
		punitions11.setIconTextGap(10);
		punitions11.setForeground(Color.WHITE);
		punitions11.setFont(new Font("Roboto", Font.BOLD, 14));
		punitions11.setFocusPainted(false);
		punitions11.setBorderColor(new Color(255, 255, 255));
		punitions11.setBackground(new Color(40, 40, 40));
		punitions11.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(punitions11);
		
		
		
		CustomButton punitions1 = new CustomButton("<html><div style='text-align: leading;'>Parametres des preferences</div></html>");
		punitions1.setRadius(15);
		punitions1.setAlignmentX(Component.CENTER_ALIGNMENT);
		punitions1.setMultiClickThreshhold(2000L);
		punitions1.setMargin(new Insets(2, 10, 2, 14));
		punitions1.setHorizontalAlignment(SwingConstants.LEADING);
		punitions1.setPreferredSize(new Dimension(300, 40));
		punitions1.setIconTextGap(10);
		punitions1.setForeground(Color.WHITE);
		punitions1.setFont(new Font("Roboto", Font.BOLD, 14));
		punitions1.setFocusPainted(false);
		punitions1.setBorderColor(new Color(255, 255, 255));
		punitions1.setBackground(new Color(40, 40, 40));
		punitions1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(punitions1);
		
		
		
		CustomButton utilisateurs = new CustomButton("<html><div style='text-align: leading;'>Supprimer l'etablissement</div></html>");
		utilisateurs.setRadius(15);
		utilisateurs.setAlignmentX(Component.CENTER_ALIGNMENT);
		utilisateurs.setMultiClickThreshhold(2000L);
		utilisateurs.setMargin(new Insets(2, 10, 2, 14));
		utilisateurs.setHorizontalAlignment(SwingConstants.LEADING);
		utilisateurs.setPreferredSize(new Dimension(300, 40));
		utilisateurs.setIconTextGap(10);
		utilisateurs.setForeground(Color.WHITE);
		utilisateurs.setFont(new Font("Roboto", Font.BOLD, 14));
		utilisateurs.setFocusPainted(false);
		utilisateurs.setBorderColor(new Color(255, 255, 255));
		utilisateurs.setBackground(new Color(40, 40, 40));
		utilisateurs.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\stats.png"));
		add(utilisateurs);
		
		
		

		for(int i = 0; i< getComponentCount(); i++) {
			int k = i;
			if(getComponent(i) instanceof CustomButton) {
				((AbstractButton) getComponent(i)).setMultiClickThreshhold(500L);
				getComponent(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(k< getComponentCount()-1) {
				getComponent(k).setBackground(new Color(20, 148, 198));
				}else {
					getComponent(k).setBackground(new Color(255, 102, 102));
				}
			}public void mouseExited(MouseEvent e) {
				getComponent(k).setBackground(getComponent(k).getParent().getBackground());
			}
		});
	}}
	}

}
