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

public class BackToMenu extends JFrame {

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
					BackToMenu frame = new BackToMenu();
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
	public BackToMenu() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 379);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNouveauCours = new JLabel("<html>Vous n' avez pas acc\u00E8s a l'\u00E9tablissement car la licence d'utilisation du logiciel CiGi Bakame pour la gestion de l'\u00E9tablissement est expir\u00E9e. Vous regagnerez l'acc\u00E8s lorsque la licence sera renouvell\u00E9e par les administrateurs de cet \u00E9tablissement.</html>");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNouveauCours.setBounds(10, 148, 400, 132);
	contentPane.add(lblNouveauCours);
	
	JButton btnSinscrire = new JButton("Retour");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserPanel u = new UserPanel(Login.getUserId(Login.selectedUserName));
			u.setVisible(true);
			setVisible(false);
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
	btnSinscrire.setBounds(75, 298, 271, 31);
	contentPane.add(btnSinscrire);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\cg_colored.png"));
	label.setBounds(157, 24, 110, 90);
	contentPane.add(label);
	
	JLabel lblNewLabel = new JLabel("La licence d'utilisation est expir\u00E9e");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 23));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(33, 123, 357, 23);
	contentPane.add(lblNewLabel);

	setLocationRelativeTo(null);
	}
}