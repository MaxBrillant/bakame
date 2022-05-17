package accounts;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.LPane;
import app.NewTest;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.ResizeImages;
import Class.NewCourse;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class AccessGranted extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessGranted frame = new AccessGranted("Max Brillant", "30", "20/20/2021");
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
	public AccessGranted(String schoolID, String days, String lastDay) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 358);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNouveauCours = new JLabel(//"<html>La licence d'utilisation du logiciel CiGi Bakame pour la gestion de l'\u00E9tablissement  \""+NewEstablishment.sch.getSchoolName(schoolID)+"\" a \u00E9t\u00E9 renouvell\u00E9e avec succ\u00E8s. Votre licence est valide pour "+days+" jours, soit jusqu'au "+lastDay+".<dynamic></html>"
			);
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNouveauCours.setBounds(10, 148, 400, 105);
	contentPane.add(lblNouveauCours);
	
	JButton btnSinscrire = new JButton("Continuer");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//ScholarYears sy = new ScholarYears(Login.getUserId(Login.selectedUserID), NewEstablishment.getSchoolID(Us), UserPanel.selectedRole);
			//sy.frame.setVisible(true);
			//setVisible(false);
		}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(0, 171, 89).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(0, 171, 89));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(0, 171, 89));
	btnSinscrire.setBounds(75, 275, 271, 31);
	contentPane.add(btnSinscrire);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\cg_colored.png"));
	label.setBounds(157, 24, 110, 90);
	contentPane.add(label);

	setLocationRelativeTo(null);
	}
}